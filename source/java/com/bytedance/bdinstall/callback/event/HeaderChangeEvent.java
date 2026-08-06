package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.Utils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HeaderChangeEvent {
    private final JSONObject mHeader;

    public HeaderChangeEvent(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Utils.copy(jSONObject2, jSONObject);
        this.mHeader = jSONObject2;
    }

    public JSONObject getHeaderCopy() {
        return this.mHeader;
    }
}
