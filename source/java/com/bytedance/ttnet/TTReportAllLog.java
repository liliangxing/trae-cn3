package com.bytedance.ttnet;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTReportAllLog {
    private static final int INVALID_DEFAULT_CODE = Integer.MAX_VALUE;
    private static final String LOG_TYPE = "ttnet_all_log";
    private static final String TAG = "TTReportAllLog";

    public static void reportInternalAllLog(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        reportInternalAllLog(str, jSONObject, Integer.MAX_VALUE, null);
    }

    public static void reportInternalAllLog(String str, JSONObject jSONObject, int i, String str2) {
        try {
            ITTNetDepend tTNetDepend = TTNetInit.getTTNetDepend();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("module_type", str);
            if (i != Integer.MAX_VALUE) {
                jSONObject2.put("code", i);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("message", str2);
            }
            if (jSONObject != null) {
                jSONObject2.put("detail_log", jSONObject);
            }
            if (Logger.debug()) {
                Logger.d(TAG, jSONObject2.toString());
            }
            tTNetDepend.monitorLogSend(LOG_TYPE, jSONObject2);
        } catch (Throwable unused) {
        }
    }
}
