package com.bytedance.memory.model;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ClassNumber implements Serializable {
    private static final long serialVersionUID = -3511673943004282406L;
    private String mClassName;
    private int mCount;

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public void setClassName(String str) {
        this.mClassName = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("object_class", this.mClassName);
            jSONObject.put("instance_count", this.mCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
