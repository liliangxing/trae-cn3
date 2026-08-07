package com.bytedance.trae.conversation.extract;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
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

public final class ExtractHelper {

    public static final ExtractHelper INSTANCE = new ExtractHelper();

    private ExtractHelper() {
    }

    public final void start(Activity activity, String conversationId, String title) {
        performExtract(activity, conversationId, title);
    }

    private void performExtract(Activity activity, String conversationId, String title) {
        String TAG = "ExtractHelper";
        try {
            FileLogger.log(TAG, "Step1: started");

            Context context = (Context) TraeApplication.Companion.getInst();
            FileLogger.log(TAG, "Step2: got context");

            ServiceManager serviceManager = ServiceManager.get();
            ILoginService loginService = (ILoginService) serviceManager.getService(ILoginService.class);
            FileLogger.log(TAG, "Step3: LoginService");

            if (loginService == null) {
                FileLogger.log(TAG, "EARLY RETURN: LoginService null");
                return;
            }

            AccountInfo accountInfo = loginService.getAccountInfo();
            FileLogger.log(TAG, "Step4: AccountInfo");

            if (accountInfo == null) {
                FileLogger.log(TAG, "EARLY RETURN: AccountInfo null");
                return;
            }

            String userId = accountInfo.getUserId();
            FileLogger.log(TAG, "Step5: userId=" + userId);

            if (userId == null) {
                FileLogger.log(TAG, "EARLY RETURN: userId null");
                return;
            }

            DatabaseOpenHelper dbHelper = DatabaseManager.INSTANCE.getDatabase(context, userId);
            FileLogger.log(TAG, "Step6: DB opened");

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT latest_task_id FROM conversation WHERE id = ?", new String[]{conversationId});

            String taskId = null;
            if (cursor.moveToFirst()) {
                taskId = cursor.getString(0);
            }
            cursor.close();

            FileLogger.log(TAG, "Step7: convId=" + conversationId + " taskId=" + (taskId != null ? taskId : "NULL"));

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
            } else {
                FileLogger.log(TAG, "Step8: messages list is null");
            }

            if (messages == null || messages.isEmpty()) {
                FileLogger.log(TAG, "Step8a: chat_message empty, trying conversation_detail");
                ConversationDetailDao detailDao = new ConversationDetailDao(dbHelper);
                messages = detailDao.queryLatest(conversationId, 1000);

                if (messages != null && !messages.isEmpty()) {
                    FileLogger.log(TAG, "Step8b: using conversation_detail");
                }
            }

            String markdown;
            String firstQuestion;
            int userMessageCount;

            if (messages == null) {
                FileLogger.log(TAG, "EARLY RETURN: messages null");
                return;
            }

            if (messages.isEmpty()) {
                FileLogger.log(TAG, "Step9: DB empty, trying API fetch");

                String apiToken = SdkCommonHttpImpl.INSTANCE.getToken();
                String apiUrl = TraeHttpConnection.INSTANCE.baseUrl();

                int tokenLen = apiToken != null ? apiToken.length() : 0;
                FileLogger.log(TAG, "Step9a: token=" + tokenLen + " url=" + apiUrl);

                markdown = ApiMessageFetcher.fetch(conversationId, title, apiToken, apiUrl);

                if (markdown == null) {
                    FileLogger.log(TAG, "EARLY RETURN: API fetch failed");
                    return;
                }

                FileLogger.log(TAG, "Step9b: API success, MD len=" + markdown.length());

                firstQuestion = ApiMessageFetcher.getLastFirstUserMessage();
                if (firstQuestion == null) {
                    firstQuestion = title;
                }
                userMessageCount = ApiMessageFetcher.getLastUserMessageCount();
            } else {
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
                        userMessages.add(content);
                    }
                }

                userMessageCount = userMessages.size();
                FileLogger.log(TAG, "Step9a: userMessageCount=" + userMessageCount);

                if (userMessageCount > 0) {
                    firstQuestion = (String) userMessages.get(0);
                } else {
                    firstQuestion = title;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String exportTime = sdf.format(new Date());

                StringBuilder md = new StringBuilder();
                md.append("# 会话用户消息导出");
                md.append("\n\n");
                md.append("> 导出时间: ").append(exportTime);
                md.append("\n");
                md.append("> 用户ID: ").append(userId);
                md.append("\n");
                md.append("> 任务ID: ").append(taskId);
                md.append("\n");
                md.append("> 用户消息数: ").append(userMessageCount);
                md.append("\n---\n");

                for (int i = 0; i < userMessages.size(); i++) {
                    md.append(userMessages.get(i));
                    md.append("\n\n");
                }

                markdown = md.toString();
                FileLogger.log(TAG, "Step9b: markdown built, len=" + markdown.length());
            }

            String mdFileName = buildFileName(firstQuestion);
            FileLogger.log(TAG, "Step10: writing " + mdFileName);

            File cacheFile = writeMarkdownFile(context, mdFileName, markdown);
            if (cacheFile == null) {
                FileLogger.log(TAG, "EARLY RETURN: writeMarkdownFile failed");
                return;
            }

            FileLogger.log(TAG, "Step10a: MD saved to cache");

            String html = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"><style>body{font-family:sans-serif;padding:16px;line-height:1.6;color:#333;max-width:800px;margin:0 auto}h1{border-bottom:1px solid #eee;padding-bottom:8px}blockquote{border-left:4px solid #ddd;margin:0;padding:8px 16px;color:#666;background:#f9f9f9}hr{border:none;border-top:1px solid #eee;margin:16px 0}b{color:#0066cc}</style><script src=\"https://cdn.jsdelivr.net/npm/marked/marked.min.js\"></script></head><body><textarea id=\"md\" style=\"display:none\">" + markdown + "</textarea><div id=\"content\"></div><script>var md=document.getElementById('md').value;document.getElementById('content').innerHTML=marked.parse(md);</script></body></html>";

            File cacheDir = context.getCacheDir();
            File extractDir = new File(cacheDir, "extracted");
            File htmlFile = new File(extractDir, mdFileName + ".html");

            try {
                FileWriter htmlWriter = new FileWriter(htmlFile);
                htmlWriter.write(html);
                htmlWriter.close();
                FileLogger.log(TAG, "Step11: HTML saved");
            } catch (Throwable te) {
                FileLogger.log(TAG, "Step11: HTML write failed", te);
            }

            Intent intent = new Intent(activity, SimpleWebViewActivity.class);
            intent.putExtra("extra_url", Uri.fromFile(htmlFile).toString());
            try {
                activity.startActivity(intent);
            } catch (Throwable se) {
                FileLogger.log(TAG, "Step11a: preview start failed", se);
            }

            FileLogger.log(TAG, "Step12: pushing to GitHub");
            GitHubPusher.push(mdFileName, cacheFile);
            FileLogger.log(TAG, "Step12a: push done");

        } catch (Throwable t) {
            FileLogger.log(TAG, ">>> FAILED <<<", t);
            return;
        }

        FileLogger.log(TAG, ">>> COMPLETED SUCCESSFULLY <<<");
    }

    private String buildFileName(String question) {
        if (question == null) {
            question = "conversation";
        }
        String name = question.replace('\n', ' ').replace('\r', ' ').trim();
        if (name.length() > 50) {
            name = name.substring(0, 50);
        }
        name = name.replaceAll("[\\\\/:*?\"<>|]", "_");
        if (name.trim().length() == 0) {
            name = "conversation";
        }
        return name + ".md";
    }

    private File writeMarkdownFile(Context context, String fileName, String content) {
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
                        FileLogger.log("ExtractHelper", "MediaStore write OK: Download/TRAE/" + fileName);
                    }
                }
            } catch (Throwable t) {
                FileLogger.log("ExtractHelper", "MediaStore write failed", t);
            }
        } else {
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
                FileLogger.log("ExtractHelper", "Legacy write OK: Download/TRAE/" + fileName);
            } catch (Throwable t) {
                FileLogger.log("ExtractHelper", "Legacy write failed", t);
            }
        }

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
            return cacheFile;
        } catch (Throwable t) {
            FileLogger.log("ExtractHelper", "Cache write failed", t);
            return null;
        }
    }
}
