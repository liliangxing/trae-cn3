package com.bytedance.article.common.monitor.backfetch;

import android.content.Context;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.TimeUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FetchUtils {
    public static void activeUploadLegacyLog(Context context, long j, long j2, boolean z) {
    }

    public static void fetchAllData() {
    }

    public static String getVersionName(JSONObject jSONObject) {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("update_version_code"))) {
            return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("app_version"))) ? "" : jSONObject.optString("app_version");
        }
        return jSONObject.optString("update_version_code");
    }

    public static boolean checkFetchInterval(long j, long j2) {
        return j < j2 && ((j2 - j) / 1000) / TimeUtils.SECONDS_PER_HOUR > 1;
    }

    public static void activeUploadRecentLog(Context context, boolean z) {
        activeUploadLegacyLog(context, System.currentTimeMillis() - 21600000, System.currentTimeMillis(), z);
    }
}
