package com.bytedance.applog.util;

import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SensitiveUtils {
    public static final String CHANNEL_KEY = "UMENG_CHANNEL";
    private static final String KEY_OAID = "oaid";

    public static JSONObject transferHeader(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("oaid");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id", null);
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject.put("oaid", optString);
                }
            }
        } catch (Exception e) {
            LoggerImpl.global().error("transferHeader failed", e, new Object[0]);
        }
        return jSONObject;
    }
}
