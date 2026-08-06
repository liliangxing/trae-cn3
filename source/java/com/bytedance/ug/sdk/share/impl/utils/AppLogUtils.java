package com.bytedance.ug.sdk.share.impl.utils;

import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppLogUtils {
    public static void onEventV3(String str, JSONObject jSONObject) {
        ShareConfigManager.getInstance().onAppLogEvent(str, jSONObject);
    }
}
