package com.bytedance.push.interfaze;

import com.ss.android.ug.bus.IUgBusService;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface ISDKMonitor extends IUgBusService {
    void ensureNotReachHere(Throwable th);

    void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2);

    void onUserActive();
}
