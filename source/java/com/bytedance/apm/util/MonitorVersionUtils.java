package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.apm.entity.LocalVersionInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MonitorVersionUtils {
    public static JSONObject assembleVersionInfo(JSONObject jSONObject, LocalVersionInfo localVersionInfo) throws JSONException {
        if (localVersionInfo == null) {
            return jSONObject;
        }
        if (!TextUtils.isEmpty(localVersionInfo.versionCode)) {
            jSONObject.put("version_code", localVersionInfo.versionCode);
        }
        if (!TextUtils.isEmpty(localVersionInfo.versionName)) {
            jSONObject.put("version_name", localVersionInfo.versionName);
        }
        if (!TextUtils.isEmpty(localVersionInfo.manifestVersionCode)) {
            jSONObject.put("manifest_version_code", localVersionInfo.manifestVersionCode);
        }
        if (!TextUtils.isEmpty(localVersionInfo.updateVersionCode)) {
            jSONObject.put("update_version_code", localVersionInfo.updateVersionCode);
        }
        if (!TextUtils.isEmpty(localVersionInfo.appVersion)) {
            jSONObject.put("app_version", localVersionInfo.appVersion);
        }
        return jSONObject;
    }
}
