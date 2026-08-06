package com.bytedance.push.interfaze;

import com.bytedance.push.PushBody;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IRevokeEventInterceptor {
    void intercept(JSONObject jSONObject, PushBody pushBody, PushBody pushBody2);
}
