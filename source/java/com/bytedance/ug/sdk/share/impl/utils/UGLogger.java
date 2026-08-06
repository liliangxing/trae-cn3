package com.bytedance.ug.sdk.share.impl.utils;

import android.text.TextUtils;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UGLogger {
    private static String DEFAULT_LOG_PREFIX = "UGLog_";
    public static String MODULE_REFLOW = "reflow";
    public static String MODULE_SHARE = "share";
    private static String TAG = "share";
    public static LogContext reflowLogContext = null;
    private static String tagPrefix = "UGLog_";
    private static boolean useTagPrefix = true;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class LogContext {
        Stage stage = new Stage("session", UUID.randomUUID().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Stage {
        String name;
        String sessionId;

        public Stage(String str, String str2) {
            this.name = str;
            this.sessionId = str2;
        }
    }

    public static void startRecord() {
        reflowLogContext = new LogContext();
    }

    public static LogContext getRecordingLogContext() {
        return reflowLogContext;
    }

    /* renamed from: d */
    public static void m480d(final String str, final String str2, final String str3, final JSONObject jSONObject, final LogContext logContext) {
        ShareConfigManager.getInstance().executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.UGLogger.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m463d(UGLogger.formatTag(str, str3), UGLogger.formatMessage(str2, jSONObject, logContext));
            }
        });
    }

    /* renamed from: i */
    public static void m482i(String str, String str2, LogContext logContext) {
        m483i(TAG, str, str2, null, logContext);
    }

    /* renamed from: i */
    public static void m484i(String str, String str2, JSONObject jSONObject, LogContext logContext) {
        m483i(TAG, str, str2, jSONObject, logContext);
    }

    /* renamed from: i */
    public static void m483i(final String str, final String str2, final String str3, final JSONObject jSONObject, final LogContext logContext) {
        ShareConfigManager.getInstance().executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.UGLogger.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.m469i(UGLogger.formatTag(str, str3), UGLogger.formatMessage(str2, jSONObject, logContext));
            }
        });
    }

    /* renamed from: w */
    public static void m485w(final String str, final String str2, final JSONObject jSONObject, final LogContext logContext) {
        ShareConfigManager.getInstance().executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.UGLogger.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.m478w(UGLogger.formatTag(UGLogger.TAG, str2), UGLogger.formatMessage(str, jSONObject, logContext));
            }
        });
    }

    /* renamed from: e */
    public static void m481e(final String str, final String str2, final JSONObject jSONObject, final LogContext logContext) {
        ShareConfigManager.getInstance().executeWithSingleThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.UGLogger.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.m466e(UGLogger.formatTag(UGLogger.TAG, str2), UGLogger.formatMessage(str, jSONObject, logContext));
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
            sb.append(RomVersionParamHelper.SEPARATOR).append(str2);
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
