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
            latch.await(120, TimeUnit.SECONDS);
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
            // 分页拉取所有消息
            String firstQuestion = null;
            int totalUserCount = 0;
            int page = 0;
            int pageSize = 10;
            // 每页的"正序"用户消息列表，结束后按翻页顺序逆序合并为全局正序列表
            // 翻页方向从新到旧，越晚拉到的页越旧，必须放在最终内容前面
            java.util.ArrayList<java.util.ArrayList<String>> pageLists = new java.util.ArrayList<>();
            // 游标：当前页最早消息的 created_at_ms（毫秒时间戳），用于翻页
            // 对齐原 APK anchor API：翻页参数是 anchor_created_at_ms，而非 before_id
            String anchorCreatedAtMs = null;
            // 第一页请求失败时置 true，此时不构建文档（返回 null）
            boolean apiFailed = false;

            while (true) {
                // 构建 URL
                StringBuilder urlBuilder = new StringBuilder();
                urlBuilder.append(baseUrl);
                urlBuilder.append("api/solo_hub/v1/conversations/messages/anchor?conversation_id=");
                urlBuilder.append(conversationId);
                urlBuilder.append("&before_limit=").append(pageSize);
                urlBuilder.append("&after_limit=0&include_anchor=false");
                if (anchorCreatedAtMs != null) {
                    urlBuilder.append("&anchor_created_at_ms=").append(anchorCreatedAtMs);
                }
                String urlStr = urlBuilder.toString();
                FileLogger.log(TAG, "API-P" + page + ": URL=" + urlStr);

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

                FileLogger.log(TAG, "API-P" + page + ": headers set, getting response");

                int responseCode = conn.getResponseCode();
                FileLogger.log(TAG, "API-P" + page + ": responseCode=" + responseCode);

                if (responseCode != 200) {
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
                    if (page == 0) {
                        // 第一页就失败，标记失败（避免 break 后仍构建出空文档）
                        apiFailed = true;
                    }
                    break;
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                reader.close();
                String responseBody = sb.toString();

                FileLogger.log(TAG, "API-P" + page + ": rawLen=" + responseBody.length());

                JSONObject root = new JSONObject(responseBody);
                JSONObject data = root.optJSONObject("data");

                if (data == null) {
                    FileLogger.log(TAG, "API-P" + page + ": data object is null");
                    if (page == 0) {
                        // 第一页就失败，标记失败
                        apiFailed = true;
                    }
                    break;
                }

                JSONArray items = data.optJSONArray("items");
                if (items == null) {
                    items = data.optJSONArray("messages");
                }

                if (items == null || items.length() == 0) {
                    FileLogger.log(TAG, "API-P" + page + ": items empty, done");
                    break;
                }

                int arrayLen = items.length();
                FileLogger.log(TAG, "API-P" + page + ": itemsLen=" + arrayLen);

                // 记录最早消息的 created_at_ms 用于下一页翻页
                // items 返回的是从最新到最旧的顺序，最后一条是最早的
                JSONObject oldestMsg = items.optJSONObject(arrayLen - 1);
                if (oldestMsg != null) {
                    String nextAnchor = oldestMsg.optString("created_at_ms");
                    if (nextAnchor == null || nextAnchor.length() == 0) {
                        nextAnchor = oldestMsg.optString("created_at");
                    }
                    if (nextAnchor != null && nextAnchor.length() > 0) {
                        anchorCreatedAtMs = nextAnchor;
                    } else {
                        // 没有时间戳字段，无法继续翻页
                        FileLogger.log(TAG, "API-P" + page + ": no created_at_ms/created_at, pagination stopped");
                    }
                }

                // 判断是否有更多页：返回条数达到一页（>= before_limit）则继续翻页（对齐原 APK 数量判断）
                boolean hasMore = arrayLen >= pageSize;
                // 兼容服务端显式返回 has_more 字段的情况
                if (data.has("has_more")) {
                    hasMore = data.optBoolean("has_more", hasMore);
                }

                // 处理当前页的消息：先收集当前页的用户消息（items 是倒序，最新在前）
                java.util.ArrayList<String> pageUserMessages = new java.util.ArrayList<>();
                for (int i = 0; i < arrayLen; i++) {
                    JSONObject msg = items.optJSONObject(i);
                    if (msg != null) {
                        String role = msg.optString("role");
                        if ("user".equals(role)) {
                            String rawContent = msg.optString("content");
                            String content = extractPlainText(rawContent);
                            if (content != null && content.length() > 0) {
                                // 无条件覆盖：翻页从新到旧，循环结束时 firstQuestion 即全局最早一条用户消息
                                firstQuestion = content;
                                totalUserCount++;
                                pageUserMessages.add(content);
                            }
                        }
                    }
                }

                // 当前页的消息是倒序的（最新在前），收集本页正序用户消息列表，翻页结束后统一按时间正序编号
                pageLists.add(pageUserMessages);

                FileLogger.log(TAG, "API-P" + page + ": pageUserCount=" + pageUserMessages.size() + " hasMore=" + hasMore);

                if (!hasMore || anchorCreatedAtMs == null) {
                    FileLogger.log(TAG, "API-P" + page + ": no more pages, totalUserCount=" + totalUserCount);
                    break;
                }

                page++;
            }

            // 翻页方向从新到旧：越晚拉到的页越旧，逆序合并使最终内容按时间正序
            // 同时每页内消息也是最新在前，需逐页逆序后合并
            java.util.ArrayList<String> allUserList = new java.util.ArrayList<>();
            for (int i = pageLists.size() - 1; i >= 0; i--) {
                java.util.ArrayList<String> pageMsgs = pageLists.get(i);
                for (int j = pageMsgs.size() - 1; j >= 0; j--) {
                    allUserList.add(pageMsgs.get(j));
                }
            }

            lastFirstUserMessage = firstQuestion;
            lastUserMessageCount = totalUserCount;

            if (apiFailed) {
                // 第一页请求失败：不构建文档
                FileLogger.log(TAG, "API-7: first page failed, markdown=null");
                markdown = null;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String exportTime = sdf.format(new Date());

                StringBuilder md = new StringBuilder();
                md.append("# TRAE用户消息导出");
                md.append("\n\n");
                md.append("> 导出时间: ").append(exportTime);
                md.append("\n");
                md.append("> 任务ID: ").append(conversationId);
                md.append("\n");
                md.append("> 用户消息数: ").append(totalUserCount);
                md.append("\n---\n");

                // 每条用户消息加序号并用 --- 分隔，格式如：
                // ---
                // ## TRAE 1
                // <内容>
                for (int i = 0; i < allUserList.size(); i++) {
                    md.append("\n\n## TRAE ").append(i + 1).append("\n\n");
                    md.append(allUserList.get(i));
                }

                markdown = md.toString();
                FileLogger.log(TAG, "API-6: markdown built, totalUserCount=" + totalUserCount);
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
        String trimmed = raw.trim();

        // 处理 JSON 数组: [{"type": "text", "text_content": "实际文本"}]
        if (trimmed.startsWith("[")) {
            try {
                JSONArray arr = new JSONArray(trimmed);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.optJSONObject(i);
                    if (obj != null) {
                        // 尝试 text_content 字段
                        String text = obj.optString("text_content");
                        if (text == null || text.length() == 0) {
                            // 回退到 content 字段
                            text = obj.optString("content");
                        }
                        if (text != null && text.length() > 0) {
                            if (sb.length() > 0) {
                                sb.append("\n");
                            }
                            // 递归处理：content 可能还是 JSON
                            sb.append(extractPlainText(text));
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

        // 处理 JSON 对象: {"content": "实际文本", "agent_id": "solo_work_remote", ...}
        // 实际消息存储为完整 JSON 对象，用户文本在 content 字段内
        if (trimmed.startsWith("{")) {
            try {
                JSONObject obj = new JSONObject(trimmed);
                String text = obj.optString("content");
                if (text != null && text.length() > 0) {
                    // 递归处理：content 可能还是 JSON
                    return extractPlainText(text);
                }
                // 尝试 text 字段
                text = obj.optString("text");
                if (text != null && text.length() > 0) {
                    return extractPlainText(text);
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
