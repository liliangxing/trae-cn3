package com.bytedance.trae.conversation.extract;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.widget.Toast;
import com.bytedance.trae.TraeApplication;
import com.bytedance.trae.common.activity.SimpleWebViewActivity;
import com.bytedance.trae.im.database.ChatMessageDao;
import com.bytedance.trae.im.database.ChatMessageEntity;
import com.bytedance.trae.im.database.ConversationDetailDao;
import com.bytedance.trae.im.database.ConversationDetailEntity;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.im.database.DatabaseOpenHelper;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.service.SdkCommonHttpImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ExtractHelper {

    public static final ExtractHelper INSTANCE = new ExtractHelper();

    private ExtractHelper() {
    }

    private static void toast(final Activity activity, final String msg) {
        try {
            if (activity == null) return;
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    try {
                        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
                    } catch (Throwable t) {
                    }
                }
            });
        } catch (Throwable t) {
        }
    }

    public final void start(final Activity activity, final String conversationId, final String title) {
        FileLogger.log("ExtractHelper", "=== START === convId=" + conversationId + " title=" + title);
        toast(activity, "开始提取对话...");

        // 必须在后台线程执行！performExtract 包含数据库查询 + HTTP API 调用，
        // 在主线程执行会阻塞 UI，Android 15 / MIUI 会直接杀进程（不弹 ANR）
        new Thread(new Runnable() {
            @Override
            public void run() {
                performExtract(activity, conversationId, title);
            }
        }, "TraeExtract").start();
    }

    private void performExtract(Activity activity, String conversationId, String title) {
        String TAG = "ExtractHelper";
        try {
            FileLogger.log(TAG, "Step1: started");
            toast(activity, "Step1: 开始提取");

            Context context = TraeApplication.Companion.getInst();
            if (context == null) {
                FileLogger.log(TAG, "EARLY RETURN: context null");
                toast(activity, "错误: 无法获取 Context");
                return;
            }
            FileLogger.log(TAG, "Step2: got context");
            toast(activity, "Step2: 获取上下文");

            ServiceManager serviceManager = ServiceManager.get();
            if (serviceManager == null) {
                FileLogger.log(TAG, "EARLY RETURN: ServiceManager null");
                toast(activity, "错误: ServiceManager 为空");
                return;
            }
            FileLogger.log(TAG, "Step3: ServiceManager got");

            ILoginService loginService = (ILoginService) serviceManager.getService(ILoginService.class);
            FileLogger.log(TAG, "Step3a: LoginService=" + (loginService != null ? "ok" : "null"));

            if (loginService == null) {
                FileLogger.log(TAG, "EARLY RETURN: LoginService null");
                toast(activity, "错误: 登录服务为空");
                return;
            }

            AccountInfo accountInfo = loginService.getAccountInfo();
            FileLogger.log(TAG, "Step4: AccountInfo=" + (accountInfo != null ? "ok" : "null"));

            if (accountInfo == null) {
                FileLogger.log(TAG, "EARLY RETURN: AccountInfo null");
                toast(activity, "错误: 账号信息为空");
                return;
            }

            String userId = accountInfo.getUserId();
            FileLogger.log(TAG, "Step5: userId=" + userId);

            if (userId == null) {
                FileLogger.log(TAG, "EARLY RETURN: userId null");
                toast(activity, "错误: 用户ID为空");
                return;
            }

            toast(activity, "Step5: 用户ID=" + userId);
            DatabaseOpenHelper dbHelper = DatabaseManager.INSTANCE.getDatabase(context, userId);
            if (dbHelper == null) {
                FileLogger.log(TAG, "EARLY RETURN: dbHelper null");
                toast(activity, "错误: 数据库为空");
                return;
            }
            FileLogger.log(TAG, "Step6: DB opened");

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT latest_task_id FROM conversation WHERE id = ?", new String[]{conversationId});

            String taskId = null;
            if (cursor.moveToFirst()) {
                taskId = cursor.getString(0);
            }
            cursor.close();

            FileLogger.log(TAG, "Step7: convId=" + conversationId + " taskId=" + (taskId != null ? taskId : "NULL"));
            toast(activity, "Step7: taskId=" + (taskId != null ? taskId : "NULL"));

            if (taskId != null && taskId.length() > 0) {
                FileLogger.log(TAG, "Step7a: using latest_task_id");
            } else {
                FileLogger.log(TAG, "Step7a: using conversationId (fallback)");
                taskId = conversationId;
            }

            ChatMessageDao chatMessageDao = new ChatMessageDao(dbHelper);
            List messages = chatMessageDao.queryByTaskId(taskId);

            if (messages != null) {
                FileLogger.log(TAG, "Step8: msgCount=" + messages.size());
                toast(activity, "Step8: 消息数=" + messages.size());
            } else {
                FileLogger.log(TAG, "Step8: messages list is null");
                toast(activity, "Step8: 消息列表为空");
            }

            if (messages == null || messages.isEmpty()) {
                FileLogger.log(TAG, "Step8a: chat_message empty, trying conversation_detail");
                ConversationDetailDao detailDao = new ConversationDetailDao(dbHelper);
                messages = detailDao.queryLatest(conversationId, 1000);

                if (messages != null && !messages.isEmpty()) {
                    FileLogger.log(TAG, "Step8b: using conversation_detail, count=" + messages.size());
                }
            }

            // 如果数据库消息太少（< 50），也尝试 API 获取完整历史
            boolean tryApiFetch = false;
            if (messages == null || messages.isEmpty()) {
                tryApiFetch = true;
                FileLogger.log(TAG, "Step8c: DB empty, will try API fetch");
            } else if (messages.size() < 50) {
                // 数据库可能只有本地缓存的少量消息，API 才能拿到完整历史
                // 先记录 DB 消息数量，后续会尝试 API 获取更多
                FileLogger.log(TAG, "Step8c: DB only has " + messages.size() + " msgs, will also try API fetch");
                tryApiFetch = true;
            }

            String markdown = null;
            String firstQuestion = null;
            int userMessageCount = 0;

            if (messages == null) {
                FileLogger.log(TAG, "EARLY RETURN: messages null");
                toast(activity, "错误: 消息为 null");
                return;
            }

            if (tryApiFetch) {
                FileLogger.log(TAG, "Step9: trying API fetch for full history");
                toast(activity, "Step9: 尝试 API 拉取完整历史");

                String apiToken = SdkCommonHttpImpl.INSTANCE.getToken();
                String apiUrl = TraeHttpConnection.INSTANCE.baseUrl();

                int tokenLen = apiToken != null ? apiToken.length() : 0;
                FileLogger.log(TAG, "Step9a: token=" + tokenLen + " url=" + apiUrl);
                toast(activity, "Step9a: token长度=" + tokenLen);

                markdown = ApiMessageFetcher.fetch(conversationId, title, apiToken, apiUrl);

                if (markdown == null) {
                    if (messages != null && !messages.isEmpty()) {
                        // API 失败但有 DB 数据，回退到 DB 路径
                        FileLogger.log(TAG, "Step9b: API failed, falling back to DB (" + messages.size() + " msgs)");
                        toast(activity, "Step9b: API 失败，使用本地数据");
                        // 重置 tryApiFetch 让下面走 DB 路径
                        tryApiFetch = false;
                    } else {
                        FileLogger.log(TAG, "EARLY RETURN: API fetch failed, no DB fallback");
                        toast(activity, "错误: API 拉取失败");
                        return;
                    }
                } else {
                    FileLogger.log(TAG, "Step9b: API success, MD len=" + markdown.length());
                    toast(activity, "Step9b: API 成功，MD 长度=" + markdown.length());

                    firstQuestion = ApiMessageFetcher.getLastFirstUserMessage();
                    if (firstQuestion == null) {
                        firstQuestion = title;
                    }
                    userMessageCount = ApiMessageFetcher.getLastUserMessageCount();
                }
            }

            if (!tryApiFetch) {
                FileLogger.log(TAG, "Step9: building user message list");

                List userMessages = new ArrayList();
                Iterator iterator = messages.iterator();
                while (iterator.hasNext()) {
                    Object entity = iterator.next();

                    String role = null;
                    String content = null;

                    if (entity instanceof ConversationDetailEntity) {
                        ConversationDetailEntity cde = (ConversationDetailEntity) entity;
                        role = cde.getRole();
                        content = cde.getContent();
                    } else {
                        ChatMessageEntity cme = (ChatMessageEntity) entity;
                        role = cme.getMessageType();
                        content = cme.getContent();
                    }

                    if ("user".equals(role) && content != null && content.length() > 0) {
                        userMessages.add(extractPlainText(content));
                    }
                }

                userMessageCount = userMessages.size();
                FileLogger.log(TAG, "Step9a: userMessageCount=" + userMessageCount);
                toast(activity, "Step9a: 用户消息数=" + userMessageCount);

                if (userMessageCount > 0) {
                    firstQuestion = (String) userMessages.get(0);
                } else {
                    firstQuestion = title;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String exportTime = sdf.format(new Date());

                StringBuilder md = new StringBuilder();
                md.append("# TRAE用户消息导出");
                md.append("\n\n");
                md.append("> 导出时间: ").append(exportTime);
                md.append("\n");
                md.append("> 用户ID: ").append(userId);
                md.append("\n");
                md.append("> 任务ID: ").append(taskId);
                md.append("\n");
                md.append("> 用户消息数: ").append(userMessageCount);
                md.append("\n---\n");

                // 每条用户消息加序号并用 --- 分隔，格式如：
                // ---
                // ## 消息 1
                // <内容>
                for (int i = 0; i < userMessages.size(); i++) {
                    md.append("\n\n## 消息 ").append(i + 1).append("\n\n");
                    md.append(userMessages.get(i));
                }

                markdown = md.toString();
                FileLogger.log(TAG, "Step9b: markdown built, len=" + markdown.length());
            }

            String mdFileName = buildFileName(firstQuestion);
            FileLogger.log(TAG, "Step10: writing " + mdFileName);
            toast(activity, "Step10: 写入 " + mdFileName);

            File cacheFile = writeMarkdownFile(context, mdFileName, markdown, activity);
            if (cacheFile == null) {
                FileLogger.log(TAG, "EARLY RETURN: writeMarkdownFile failed");
                toast(activity, "错误: 文件写入失败");
                return;
            }

            FileLogger.log(TAG, "Step10a: MD saved to cache");
            toast(activity, "Step10a: 文件已保存");

            String html = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"><style>body{font-family:sans-serif;padding:16px;line-height:1.6;color:#333;max-width:800px;margin:0 auto}.md h1,.md h2,.md h3{border-bottom:1px solid #eee;padding-bottom:8px;margin-top:24px}.md blockquote{border-left:4px solid #ddd;margin:8px 0;padding:8px 16px;color:#666;background:#f9f9f9}.md pre{background:#f6f8fa;padding:12px;border-radius:6px;overflow-x:auto;font-size:13px}.md code{background:#f0f0f0;padding:2px 4px;border-radius:3px;font-size:13px}.md pre code{background:none;padding:0}.md hr{border:none;border-top:1px solid #eee;margin:16px 0}.md li{margin:4px 0}.md a{color:#0066cc}</style></head><body><div class=\"md\">" + markdownToHtml(markdown) + "</div></body></html>";

            // 预览用 FileProvider content:// URI（WebView 默认允许 content:// 访问）
            // HTML 写到 cache/update/TRAE/（对应 FileProvider cache-path path="/update"）
            File cacheHtmlDir = new File(context.getCacheDir(), "update/TRAE");
            if (!cacheHtmlDir.exists()) {
                cacheHtmlDir.mkdirs();
            }
            File cacheHtmlFile = new File(cacheHtmlDir, mdFileName + ".html");

            try {
                FileWriter htmlWriter = new FileWriter(cacheHtmlFile);
                htmlWriter.write(html);
                htmlWriter.close();
                FileLogger.log(TAG, "Step11: HTML saved to cache/update/TRAE");
            } catch (Throwable te) {
                FileLogger.log(TAG, "Step11: HTML cache write failed", te);
            }

            // 方式2: 也写一份到外部目录（方便用户通过文件管理器找到）
            File extHtmlDir = context.getExternalFilesDir("TRAE");
            if (extHtmlDir != null) {
                if (!extHtmlDir.exists()) {
                    extHtmlDir.mkdirs();
                }
                File extHtmlFile = new File(extHtmlDir, mdFileName + ".html");
                try {
                    FileWriter extWriter = new FileWriter(extHtmlFile);
                    extWriter.write(html);
                    extWriter.close();
                    FileLogger.log(TAG, "Step11a: HTML also saved to external");
                } catch (Throwable te) {
                    FileLogger.log(TAG, "Step11a: HTML external write failed", te);
                }
            }

            // 用 FileProvider 生成 content:// URI，SimpleWebViewActivity 可直接渲染
            final Intent intent = new Intent(activity, SimpleWebViewActivity.class);
            try {
                Uri previewUri = androidx.core.content.FileProvider.getUriForFile(context, "com.bytedance.trae.cn3.uri.key", cacheHtmlFile);
                intent.putExtra("extra_url", previewUri.toString());
                FileLogger.log(TAG, "Step11b: preview content:// " + previewUri);
            } catch (Throwable fe) {
                FileLogger.log("ExtractHelper", "Step11b: FileProvider failed", fe);
                intent.putExtra("extra_url", Uri.fromFile(cacheHtmlFile).toString());
            }
            try {
                // startActivity 必须在主线程调用
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            activity.startActivity(intent);
                        } catch (Throwable se) {
                            FileLogger.log("ExtractHelper", "Step12: preview start failed", se);
                            toast(activity, "预览打开失败: " + se.getMessage());
                        }
                    }
                });
                FileLogger.log(TAG, "Step12: preview started");
            } catch (Throwable se) {
                FileLogger.log(TAG, "Step12: preview start failed", se);
                toast(activity, "预览打开失败: " + se.getMessage());
            }

            FileLogger.log(TAG, "Step12: pushing to GitHub");
            toast(activity, "Step12: 推送到 GitHub");
            GitHubPusher.push(mdFileName, cacheFile);
            FileLogger.log(TAG, "Step12a: push done");

        } catch (Throwable t) {
            FileLogger.log(TAG, ">>> FAILED <<<", t);
            toast(activity, "提取失败: " + t.getMessage());
            return;
        }

        FileLogger.log(TAG, ">>> COMPLETED SUCCESSFULLY <<<");
        toast(activity, "提取完成！");
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

    private String buildFileName(String question) {
        if (question == null) {
            question = "conversation";
        }
        String name = question.replace('\n', ' ').replace('\r', ' ').trim();
        // 脱敏 GitHub 认证 token（classic PAT / fine-grained PAT / OAuth 等）
        name = name.replaceAll("gh[pousr]_[A-Za-z0-9]{36}|github_pat_[A-Za-z0-9_]{30,}", "xxx");
        if (name.length() > 50) {
            name = name.substring(0, 50);
        }
        name = name.replaceAll("[\\\\/:*?\"<>|]", "_");
        if (name.trim().length() == 0) {
            name = "conversation";
        }
        return "【TRAE】" + name + ".md";
    }

    private static String markdownToHtml(String md) {
        if (md == null) {
            return "";
        }
        StringBuilder html = new StringBuilder();
        String[] lines = md.split("\n", -1);
        boolean inCode = false;
        StringBuilder codeBuf = new StringBuilder();
        boolean listOpen = false;
        char listType = 0;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line.startsWith("```")) {
                if (inCode) {
                    html.append("<pre>").append(htmlEscape(codeBuf.toString())).append("</pre>");
                    codeBuf.setLength(0);
                    inCode = false;
                } else {
                    closeList(html, listOpen, listType);
                    listOpen = false;
                    inCode = true;
                }
                continue;
            }
            if (inCode) {
                codeBuf.append(line).append("\n");
                continue;
            }
            if (line.trim().length() == 0) {
                closeList(html, listOpen, listType);
                listOpen = false;
                continue;
            }
            if (line.startsWith("#")) {
                closeList(html, listOpen, listType);
                listOpen = false;
                int level = 0;
                while (level < line.length() && line.charAt(level) == '#' && level < 4) {
                    level++;
                }
                html.append("<h").append(level).append(">").append(inlineMarkdown(line.substring(level).trim())).append("</h").append(level).append(">");
                continue;
            }
            if (line.startsWith(">")) {
                closeList(html, listOpen, listType);
                listOpen = false;
                html.append("<blockquote>").append(inlineMarkdown(line.substring(1).trim())).append("</blockquote>");
                continue;
            }
            if (line.matches("^\\s*-{3,}\\s*$")) {
                closeList(html, listOpen, listType);
                listOpen = false;
                html.append("<hr>");
                continue;
            }
            if (line.matches("^\\s*[-*+]\\s+.*")) {
                if (!listOpen || listType != 'u') {
                    closeList(html, listOpen, listType);
                    html.append("<ul>");
                    listOpen = true;
                    listType = 'u';
                }
                html.append("<li>").append(inlineMarkdown(line.replaceFirst("^\\s*[-*+]\\s+", ""))).append("</li>");
                continue;
            }
            if (line.matches("^\\s*\\d+\\.\\s+.*")) {
                if (!listOpen || listType != 'o') {
                    closeList(html, listOpen, listType);
                    html.append("<ol>");
                    listOpen = true;
                    listType = 'o';
                }
                html.append("<li>").append(inlineMarkdown(line.replaceFirst("^\\s*\\d+\\.\\s+", ""))).append("</li>");
                continue;
            }
            closeList(html, listOpen, listType);
            listOpen = false;
            html.append("<p>").append(inlineMarkdown(line)).append("</p>");
        }
        closeList(html, listOpen, listType);
        if (inCode) {
            html.append("<pre>").append(htmlEscape(codeBuf.toString())).append("</pre>");
        }
        return html.toString();
    }

    private static void closeList(StringBuilder html, boolean listOpen, char listType) {
        if (!listOpen) {
            return;
        }
        if (listType == 'o') {
            html.append("</ol>");
        } else {
            html.append("</ul>");
        }
    }

    private static String inlineMarkdown(String text) {
        String s = htmlEscape(text);
        s = s.replaceAll("`([^`]+)`", "<code>$1</code>");
        s = s.replaceAll("\\*\\*([^*]+)\\*\\*", "<b>$1</b>");
        s = s.replaceAll("\\*([^*]+)\\*", "<i>$1</i>");
        s = s.replaceAll("~~([^~]+)~~", "<s>$1</s>");
        s = s.replaceAll("\\[([^\\]]+)\\]\\((https?://[^)\\s]+)\\)", "<a href=\"$2\">$1</a>");
        return s;
    }

    private static String htmlEscape(String text) {
        if (text == null) {
            return "";
        }
        String s = text.replace("&", "&amp;");
        s = s.replace("<", "&lt;");
        s = s.replace(">", "&gt;");
        return s;
    }

    private File writeMarkdownFile(Context context, String fileName, String content, Activity activity) {
        boolean publicWritten = false;

        // 方式1: MediaStore (Android 10+)
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Downloads.DISPLAY_NAME, fileName);
                values.put(MediaStore.Downloads.MIME_TYPE, "text/markdown");
                values.put(MediaStore.Downloads.RELATIVE_PATH, "Download/TRAE");

                Uri uri = context.getContentResolver().insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values);
                if (uri != null) {
                    OutputStream os = context.getContentResolver().openOutputStream(uri);
                    if (os != null) {
                        os.write(content.getBytes("UTF-8"));
                        os.flush();
                        os.close();
                        publicWritten = true;
                        FileLogger.log("ExtractHelper", "MediaStore write OK: Download/TRAE/" + fileName);
                        if (activity != null) toast(activity, "MD 已写入: Download/TRAE/" + fileName);
                    } else {
                        FileLogger.log("ExtractHelper", "MediaStore openOutputStream null");
                    }
                } else {
                    FileLogger.log("ExtractHelper", "MediaStore insert returned null uri");
                }
            } catch (Throwable t) {
                FileLogger.log("ExtractHelper", "MediaStore write failed", t);
            }

            if (!publicWritten) {
                FileLogger.log("ExtractHelper", "MediaStore failed, trying app-specific dir");
            }
        }

        // 方式2: app 专属外部目录（不需要权限，任何 Android 版本都能写）
        // 路径: /storage/emulated/0/Android/data/com.bytedance.trae.cn3/files/TRAE/xxx.md
        if (!publicWritten) {
            try {
                File appDir = context.getExternalFilesDir("TRAE");
                if (appDir != null) {
                    if (!appDir.exists()) {
                        appDir.mkdirs();
                    }
                    File file = new File(appDir, fileName);
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                    publicWritten = true;
                    FileLogger.log("ExtractHelper", "App-specific write OK: " + file.getAbsolutePath());
                    if (activity != null) toast(activity, "MD 已写入: Android/data/.../files/TRAE/" + fileName);
                }
            } catch (Throwable t) {
                FileLogger.log("ExtractHelper", "App-specific write failed", t);
            }
        }

        // 方式3: legacy 公共目录 (Android 9 及以下)
        if (!publicWritten) {
            try {
                File downloadDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File traeDir = new File(downloadDir, "TRAE");
                if (!traeDir.exists()) {
                    traeDir.mkdirs();
                }
                File file = new File(traeDir, fileName);
                FileWriter writer = new FileWriter(file);
                writer.write(content);
                writer.close();
                publicWritten = true;
                FileLogger.log("ExtractHelper", "Legacy write OK: Download/TRAE/" + fileName);
            } catch (Throwable t) {
                FileLogger.log("ExtractHelper", "Legacy write failed", t);
            }
        }

        // 总是写一份到 cache（给 GitHubPusher 用）
        File cacheDir = context.getCacheDir();
        File extractDir = new File(cacheDir, "extracted");
        if (!extractDir.exists()) {
            extractDir.mkdirs();
        }
        File cacheFile = new File(extractDir, fileName);
        try {
            FileWriter writer = new FileWriter(cacheFile);
            writer.write(content);
            writer.close();
            FileLogger.log("ExtractHelper", "Cache write OK: " + cacheFile.getAbsolutePath());
            return cacheFile;
        } catch (Throwable t) {
            FileLogger.log("ExtractHelper", "Cache write failed", t);
            return null;
        }
    }
}
