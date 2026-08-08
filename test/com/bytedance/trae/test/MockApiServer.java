package com.bytedance.trae.test;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class MockApiServer {

    private final HttpsServer server;
    private final int totalMessages;
    private final boolean failFirstPage;
    private final List<String> anchorRequests = new ArrayList<>();
    private final List<Integer> pageSizes = new ArrayList<>();

    public MockApiServer(int port, int totalMessages, boolean failFirstPage) throws Exception {
        this.totalMessages = totalMessages;
        this.failFirstPage = failFirstPage;

        SSLContext sslContext = buildSslContext();

        server = HttpsServer.create(new InetSocketAddress("127.0.0.1", port), 0);
        server.setHttpsConfigurator(new HttpsConfigurator(sslContext));
        server.createContext("/", exchange -> {
            try {
                if (failFirstPage && anchorRequests.isEmpty()) {
                    byte[] body = "{\"code\":500}".getBytes("UTF-8");
                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(500, body.length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(body);
                    }
                    return;
                }

                String query = exchange.getRequestURI().getQuery();
                String anchor = parseParam(query, "anchor_created_at_ms");
                String beforeLimitStr = parseParam(query, "before_limit");
                int beforeLimit = beforeLimitStr == null ? 10 : Integer.parseInt(beforeLimitStr);

                anchorRequests.add(anchor == null ? "" : anchor);
                pageSizes.add(beforeLimit);

                long anchorMs = 0;
                if (anchor != null && !anchor.isEmpty()) {
                    anchorMs = Long.parseLong(anchor);
                }

                List<Message> messages = new ArrayList<>();
                for (int i = totalMessages; i >= 1; i--) {
                    long createdAtMs = i * 1000L;
                    if (anchorMs > 0 && createdAtMs >= anchorMs) {
                        continue;
                    }
                    messages.add(new Message(i, createdAtMs));
                    if (messages.size() >= beforeLimit) {
                        break;
                    }
                }

                StringBuilder sb = new StringBuilder();
                sb.append("{\"data\":{\"items\":[");
                for (int i = 0; i < messages.size(); i++) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    Message m = messages.get(i);
                    sb.append("{\"role\":\"").append(m.role).append("\",\"content\":\"")
                      .append(m.content).append("\",\"message_id\":\"msg-").append(m.index)
                      .append("\",\"created_at_ms\":\"").append(m.createdAtMs).append("\"}");
                }
                sb.append("],\"total\":").append(totalMessages).append("}}");

                byte[] body = sb.toString().getBytes("UTF-8");
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, body.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(body);
                }
            } catch (Throwable t) {
                t.printStackTrace();
                try {
                    exchange.sendResponseHeaders(500, -1);
                } catch (Throwable ignored) {
                }
            } finally {
                exchange.close();
            }
        });
        server.start();
    }

    public String getBaseUrl() {
        return "https://127.0.0.1:" + server.getAddress().getPort() + "/";
    }

    public List<String> getAnchorRequests() {
        return anchorRequests;
    }

    public List<Integer> getPageSizes() {
        return pageSizes;
    }

    public void close() {
        server.stop(0);
    }

    private static SSLContext buildSslContext() throws Exception {
        char[] password = "changeit".toCharArray();
        KeyStore ks = KeyStore.getInstance("JKS");
        try (java.io.FileInputStream fis = new java.io.FileInputStream("/tmp/opencode/trae-cn3/test/test2.jks")) {
            ks.load(fis, password);
        }
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(ks, password);
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(kmf.getKeyManagers(), null, null);
        return ctx;
    }

    private static String parseParam(String query, String name) {
        if (query == null) {
            return null;
        }
        for (String pair : query.split("&")) {
            int idx = pair.indexOf('=');
            if (idx > 0 && pair.substring(0, idx).equals(name)) {
                return pair.substring(idx + 1);
            }
        }
        return null;
    }

    private static final class Message {
        final int index;
        final long createdAtMs;
        final String role;
        final String content;

        Message(int index, long createdAtMs) {
            this.index = index;
            this.createdAtMs = createdAtMs;
            this.role = index % 3 == 0 ? "assistant" : "user";
            this.content = "user-message-" + index;
        }
    }
}
