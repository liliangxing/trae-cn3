package com.bytedance.bdinstall.callback.event;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RequestDrSuccessEvent {
    private final JSONObject response;

    public RequestDrSuccessEvent(JSONObject jSONObject) {
        this.response = jSONObject;
    }

    public JSONObject getResponse() {
        return this.response;
    }
}
