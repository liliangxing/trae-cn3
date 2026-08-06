package com.bytedance.push.interfaze;

import com.bytedance.push.PushBody;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IMessageCallbackService {
    public static final String EVENT_TYPE_CLICK = "click";
    public static final String EVENT_TYPE_SHOW = "show";

    void onMessageArrive(PushBody pushBody, JSONObject jSONObject);

    void onMessageClick(boolean z, JSONObject jSONObject);
}
