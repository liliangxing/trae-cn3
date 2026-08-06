package com.bytedance.trae.conversation.extract;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
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
            } else {
                FileLogger.log(TAG, "Step9: building markdown");

                StringBuilder md = new StringBuilder();
                md.append("# ").append(title);
                md.append("\n\n---\n\n");

                Iterator iterator = messages.iterator();
                while (iterator.hasNext()) {
                    Object entity = iterator.next();

                    if (entity instanceof ConversationDetailEntity) {
                        ConversationDetailEntity cde = (ConversationDetailEntity) entity;
                        String role = cde.getRole();
                        if ("user".equals(role)) {
                            md.append("**[User]**: ");
                        } else {
                            md.append("**[Assistant]**: ");
                        }
                        md.append(cde.getContent());
                        md.append("\n\n");
                    } else {
                        ChatMessageEntity cme = (ChatMessageEntity) entity;
                        String messageType = cme.getMessageType();
                        if ("user".equals(messageType)) {
                            md.append("**[User]**: ");
                        } else {
                            md.append("**[Assistant]**: ");
                        }
                        md.append(cme.getContent());
                        md.append("\n\n");
                    }
                }

                markdown = md.toString();
                FileLogger.log(TAG, "Step9a: markdown built");
                FileLogger.log(TAG, "Step9b: MD len=" + markdown.length());
            }

            // Step10: Write MD file
            File cacheDir = activity.getApplicationContext().getCacheDir();
            File extractDir = new File(cacheDir, "extracted");
            if (!extractDir.exists()) {
                extractDir.mkdirs();
            }

            String mdFileName = title + ".md";
            File mdFile = new File(extractDir, mdFileName);

            FileWriter mdWriter = new FileWriter(mdFile);
            mdWriter.write(markdown);
            mdWriter.close();

            FileLogger.log(TAG, "Step10: MD saved");

            // Step11: Build HTML and preview
            String html = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"><style>body{font-family:sans-serif;padding:16px;line-height:1.6;color:#333;max-width:800px;margin:0 auto}h1{border-bottom:1px solid #eee;padding-bottom:8px}blockquote{border-left:4px solid #ddd;margin:0;padding:8px 16px;color:#666;background:#f9f9f9}hr{border:none;border-top:1px solid #eee;margin:16px 0}b{color:#0066cc}</style><script src=\"https://cdn.jsdelivr.net/npm/marked/marked.min.js\"></script></head><body><textarea id=\"md\" style=\"display:none\">" + markdown + "</textarea><div id=\"content\"></div><script>var md=document.getElementById('md').value;document.getElementById('content').innerHTML=marked.parse(md);</script></body></html>";

            String htmlFileName = title + ".html";
            File htmlFile = new File(extractDir, htmlFileName);

            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write(html);
            htmlWriter.close();

            FileLogger.log(TAG, "Step11: HTML saved");

            Intent intent = new Intent(activity, SimpleWebViewActivity.class);
            intent.putExtra("extra_url", Uri.fromFile(htmlFile).toString());
            activity.startActivity(intent);

            FileLogger.log(TAG, "Step12: pushing to GitHub");
            GitHubPusher.push(title, mdFile);
            FileLogger.log(TAG, "Step12a: push done");

        } catch (Throwable t) {
            FileLogger.log(TAG, ">>> FAILED <<<", t);
            return;
        }

        FileLogger.log(TAG, ">>> COMPLETED SUCCESSFULLY <<<");
    }
}
