package com.bytedance.trae.conversation.extract;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMessageFetcher implements Runnable {

    private String conversationId;
    private String title;
    private String token;
    private String baseUrl;
    private String markdown;
    private CountDownLatch latch;

    private static String lastFirstUserMessage;
    private static int lastUserMessageCount;

    public ApiMessageFetcher(String conversationId, String title, String token, String baseUrl, CountDownLatch latch) {
        this.conversationId = conversationId;
        this.title = title;
        this.token = token;
        this.baseUrl = baseUrl;
        this.latch = latch;
    }

    public static String getLastFirstUserMessage() {
        return lastFirstUserMessage;
    }

    public static int getLastUserMessageCount() {
        return lastUserMessageCount;
    }

    public static String fetch(String conversationId, String title, String token, String baseUrl) {
        CountDownLatch latch = new CountDownLatch(1);
        ApiMessageFetcher fetcher = new ApiMessageFetcher(conversationId, title, token, baseUrl, latch);
        new Thread(fetcher).start();

        try {
            latch.await(35, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return null;
        }

        return fetcher.getMarkdown();
    }

    public String getMarkdown() {
        return markdown;
    }

    @Override
    public void run() {
        String TAG = "ApiFetcher";
        try {
            String urlStr = baseUrl + "api/solo_hub/v1/conversations/messages/anchor?conversation_id=" + conversationId + "&before_limit=200&after_limit=0&include_anchor=true";
            FileLogger.log(TAG, "API-1: URL=" + urlStr);

            URL url = new URL(urlStr);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(createTrustAllSocketFactory());
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-App-Id", "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8");
            conn.setRequestProperty("X-App-Version-Code", "20260310");
            conn.setRequestProperty("x-ide-token", token);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);

            FileLogger.log(TAG, "API-2: headers set, getting response");

            int responseCode = conn.getResponseCode();
            FileLogger.log(TAG, "API-3: responseCode=" + responseCode);

            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                reader.close();
                String responseBody = sb.toString();

                FileLogger.log(TAG, "API-4: rawLen=" + responseBody.length());

                JSONObject root = new JSONObject(responseBody);
                JSONObject data = root.optJSONObject("data");

                if (data == null) {
                    FileLogger.log(TAG, "API-ERR: data object is null");
                    markdown = null;
                } else {
                    JSONArray items = data.optJSONArray("items");
                    if (items == null) {
                        items = data.optJSONArray("messages");
                    }

                    if (items == null) {
                        FileLogger.log(TAG, "API-ERR: items/messages array is null");
                        markdown = null;
                    } else {
                        int arrayLen = items.length();
                        FileLogger.log(TAG, "API-5: arrayLen=" + arrayLen);

                        if (arrayLen == 0) {
                            FileLogger.log(TAG, "API-ERR: array is empty");
                            markdown = null;
                        } else {
                            StringBuilder userContent = new StringBuilder();
                            int userCount = 0;
                            String firstQuestion = null;

                            for (int i = 0; i < arrayLen; i++) {
                                JSONObject msg = items.optJSONObject(i);
                                if (msg != null) {
                                    String role = msg.optString("role");
                                    if ("user".equals(role)) {
                                        String rawContent = msg.optString("content");
                                        String content = extractPlainText(rawContent);
                                        if (content != null && content.length() > 0) {
                                            if (firstQuestion == null) {
                                                firstQuestion = content;
                                            }
                                            userCount++;
                                            if (userContent.length() > 0) {
                                                userContent.append("\n\n");
                                            }
                                            userContent.append(content);
                                        }
                                    }
                                }
                            }

                            lastFirstUserMessage = firstQuestion;
                            lastUserMessageCount = userCount;

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String exportTime = sdf.format(new Date());

                            StringBuilder md = new StringBuilder();
                            md.append("# 会话用户消息导出");
                            md.append("\n\n");
                            md.append("> 导出时间: ").append(exportTime);
                            md.append("\n");
                            md.append("> 任务ID: ").append(conversationId);
                            md.append("\n");
                            md.append("> 用户消息数: ").append(userCount);
                            md.append("\n---\n");
                            md.append(userContent.toString());

                            markdown = md.toString();
                            FileLogger.log(TAG, "API-6: markdown built, userCount=" + userCount);
                        }
                    }
                }
            } else {
                InputStream errorStream = conn.getErrorStream();
                if (errorStream != null) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    reader.close();
                    FileLogger.log(TAG, "API-ERR: code=" + responseCode + " body=" + sb.toString());
                } else {
                    FileLogger.log(TAG, "API-ERR: code=" + responseCode + " no error stream");
                }
                markdown = null;
            }
        } catch (Throwable t) {
            try {
                String msg = "API-EXCEPTION: " + t.getClass().getName() + ": " + t.getMessage();
                FileLogger.log(TAG, msg);
                FileLogger.log(TAG, msg, t);
            } catch (Throwable ignored) {
            }
            markdown = null;
        }

        latch.countDown();
    }

    private static String extractPlainText(String raw) {
        if (raw == null || raw.length() == 0) {
            return raw;
        }
        // 消息内容可能是 JSON 数组格式:
        // [{"type": "text", "text_content": "实际文本"}, {"type": "code", "text_content": "code"}]
        String trimmed = raw.trim();
        if (trimmed.startsWith("[")) {
            try {
                JSONArray arr = new JSONArray(trimmed);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.optJSONObject(i);
                    if (obj != null) {
                        String text = obj.optString("text_content");
                        if (text != null && text.length() > 0) {
                            if (sb.length() > 0) {
                                sb.append("\n");
                            }
                            sb.append(text);
                        }
                    }
                }
                if (sb.length() > 0) {
                    return sb.toString();
                }
            } catch (Throwable t) {
                // 解析失败，返回原始内容
            }
        }
        return raw;
    }

    private static SSLSocketFactory createTrustAllSocketFactory() {
        try {
            TrustManager[] trustManagers = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Throwable t) {
            return HttpsURLConnection.getDefaultSSLSocketFactory();
        }
    }
}
