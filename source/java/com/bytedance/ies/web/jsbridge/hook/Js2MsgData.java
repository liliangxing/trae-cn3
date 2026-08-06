package com.bytedance.ies.web.jsbridge.hook;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class Js2MsgData {
    private String id;
    private JSONObject res;

    public Js2MsgData(String str, JSONObject jSONObject) {
        this.id = str;
        this.res = jSONObject;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public JSONObject getRes() {
        return this.res;
    }

    public void setRes(JSONObject jSONObject) {
        this.res = jSONObject;
    }
}
