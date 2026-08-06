package com.bytedance.bdturing.senseless;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PageProfile {
    public TouchEvent downEvent;
    public TouchEvent firstMoveEvent;
    public long index;
    public String name;
    public TouchEvent secondMoveEvent;
    public Boolean touchHookSuccess;
    public long touchHookTs;
    public long ts = System.currentTimeMillis();
    public TouchEvent upEvent;

    public PageProfile(String str, long j) {
        this.name = str;
        this.index = j;
    }

    public void updateHookState(boolean z) {
        this.touchHookSuccess = Boolean.valueOf(z);
        this.touchHookTs = System.currentTimeMillis();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("index", this.index);
            jSONObject.put("ts", this.ts);
            jSONObject.put("name", this.name);
            if (this.touchHookSuccess != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", this.touchHookSuccess.booleanValue() ? 1 : 0);
                jSONObject2.put("ts", this.touchHookTs);
                jSONObject.put("touch_hook", jSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
