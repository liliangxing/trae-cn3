package com.bytedance.android.standard.tools.json;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsonBuilder {
    private JSONObject mJsonObject = new JSONObject();

    public JsonBuilder put(String str, boolean z) {
        try {
            this.mJsonObject.put(str, z);
        } catch (JSONException e) {
            e.printStackTrace();
            this.mJsonObject.remove(str);
        }
        return this;
    }

    public JsonBuilder put(String str, int i) {
        try {
            this.mJsonObject.put(str, i);
        } catch (JSONException e) {
            e.printStackTrace();
            this.mJsonObject.remove(str);
        }
        return this;
    }

    public JsonBuilder put(String str, long j) {
        try {
            this.mJsonObject.put(str, j);
        } catch (JSONException e) {
            e.printStackTrace();
            this.mJsonObject.remove(str);
        }
        return this;
    }

    public JsonBuilder put(String str, double d) {
        try {
            this.mJsonObject.put(str, d);
        } catch (JSONException e) {
            e.printStackTrace();
            this.mJsonObject.remove(str);
        }
        return this;
    }

    public JsonBuilder put(String str, Object obj) {
        try {
            this.mJsonObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
            this.mJsonObject.remove(str);
        }
        return this;
    }

    public JSONObject create() {
        return this.mJsonObject;
    }
}
