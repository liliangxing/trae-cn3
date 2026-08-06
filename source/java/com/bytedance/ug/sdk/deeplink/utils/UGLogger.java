package com.bytedance.ug.sdk.deeplink.utils;

import android.text.TextUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UGLogger {
    private static String DEFAULT_LOG_PREFIX = "UGLog_";
    public static String MODULE_CLIPBOARD_INVOKE = "clipboard_invoke";
    public static String MODULE_LINK_INVOKE = "link_invoke";
    private static String TAG = "zlink";
    private static String tagPrefix = "UGLog_";
    private static boolean useTagPrefix = true;

    /* loaded from: classes4.dex */
    public static class LogContext {
        Stage stage = new Stage("session", UUID.randomUUID().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Stage {
        String name;
        String sessionId;

        public Stage(String str, String str2) {
            this.name = str;
            this.sessionId = str2;
        }
    }

    public static LogContext startRecord() {
        return new LogContext();
    }

    public static void d(final String str, final String str2, final String str3, final JSONObject jSONObject, final LogContext logContext) {
        ThreadUtils.executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.utils.UGLogger.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.d(UGLogger.formatTag(str, str3), UGLogger.formatMessage(str2, jSONObject, logContext));
            }
        });
    }

    public static void i(String str, String str2, LogContext logContext) {
        i(TAG, str, str2, null, logContext);
    }

    public static void i(String str, String str2, JSONObject jSONObject, LogContext logContext) {
        i(TAG, str, str2, jSONObject, logContext);
    }

    public static void i(final String str, final String str2, final String str3, final JSONObject jSONObject, final LogContext logContext) {
        ThreadUtils.executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.utils.UGLogger.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.i(UGLogger.formatTag(str, str3), UGLogger.formatMessage(str2, jSONObject, logContext));
            }
        });
    }

    public static void w(final String str, final String str2, final JSONObject jSONObject, final LogContext logContext) {
        ThreadUtils.executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.utils.UGLogger.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.w(UGLogger.formatTag(UGLogger.TAG, str2), UGLogger.formatMessage(str, jSONObject, logContext));
            }
        });
    }

    public static void e(final String str, final String str2, final JSONObject jSONObject, final LogContext logContext) {
        ThreadUtils.executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.utils.UGLogger.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.e(UGLogger.formatTag(UGLogger.TAG, str2), UGLogger.formatMessage(str, jSONObject, logContext));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatTag(String str, String str2) {
        if (!useTagPrefix && str2 == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (useTagPrefix) {
            sb.append(tagPrefix);
        }
        sb.append(str);
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            sb.append("_").append(str2);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatMessage(String str, JSONObject jSONObject, LogContext logContext) {
        if ((jSONObject == null || jSONObject.length() == 0) && logContext == null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        if (jSONObject != null && jSONObject.length() != 0) {
            stringBuffer.append("|xParam:").append(jSONObject);
        }
        if (logContext != null && logContext.stage != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(logContext.stage.name, logContext.stage.sessionId);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("stages", jSONObject2);
                stringBuffer.append("|xContext:").append(jSONObject3);
            } catch (JSONException unused) {
            }
        }
        return stringBuffer.toString();
    }
}
