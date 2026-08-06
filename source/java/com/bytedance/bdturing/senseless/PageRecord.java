package com.bytedance.bdturing.senseless;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PageRecord {
    public long createTime = System.currentTimeMillis();
    public TouchEvent downEvent;
    public long enterTime;
    public TouchEvent firstMoveEvent;
    public long leaveTime;
    public String pageId;
    public TouchEvent secondMoveEvent;
    public TouchEvent upEvent;

    public PageRecord(String str) {
        this.pageId = str;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null || !(obj instanceof PageRecord) || (str = this.pageId) == null) {
            return false;
        }
        return str.equals(((PageRecord) obj).pageId);
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.pageId)) {
            return super.hashCode();
        }
        return this.pageId.hashCode();
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject;
        Exception e;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.pageId);
            jSONObject.put("et", this.enterTime);
            jSONObject.put("lt", this.leaveTime);
            TouchEvent touchEvent = this.downEvent;
            if (touchEvent != null) {
                jSONObject.put("down", touchEvent.toJsonObj());
            }
            TouchEvent touchEvent2 = this.upEvent;
            if (touchEvent2 != null) {
                jSONObject.put("up", touchEvent2.toJsonObj());
            }
            TouchEvent touchEvent3 = this.firstMoveEvent;
            if (touchEvent3 != null) {
                jSONObject.put("move_1", touchEvent3.toJsonObj());
            }
            TouchEvent touchEvent4 = this.secondMoveEvent;
            if (touchEvent4 != null) {
                jSONObject.put("move_2", touchEvent4.toJsonObj());
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }
}
