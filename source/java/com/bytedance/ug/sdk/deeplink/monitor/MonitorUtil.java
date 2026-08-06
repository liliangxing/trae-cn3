package com.bytedance.ug.sdk.deeplink.monitor;

import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MonitorUtil {
    public static void monitorEventByHost(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend != null) {
            zlinkDepend.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }
}
