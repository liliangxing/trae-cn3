package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.monitor.MonitorManager;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EventUploadQueue {
    public static void enqueue(EventBody eventBody) {
        enqueue(null, eventBody);
    }

    public static void enqueue(Object obj, EventBody eventBody) {
        JSONObject json = eventBody.getJson();
        String optString = json.optString("log_type");
        if (TextUtils.isEmpty(optString)) {
            optString = null;
        }
        String optString2 = json.optString("stack");
        String optString3 = json.optString("event_type");
        String optString4 = json.optString("java_data");
        String optString5 = json.optString("stack");
        if (optString3.equals("exception")) {
            MonitorManager.getAppEnsureManager().reportJavaEnsure(json, optString2, optString);
        } else if (optString3.equals("native_exception")) {
            MonitorManager.getAppEnsureManager().reportNativeEnsure(json, optString5, optString4, optString);
        }
    }
}
