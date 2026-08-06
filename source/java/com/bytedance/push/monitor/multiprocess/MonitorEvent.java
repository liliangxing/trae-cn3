package com.bytedance.push.monitor.multiprocess;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class MonitorEvent extends BaseJson {
    public String category;
    public String extra;
    public long id;
    public String metric;
    public String serviceName;

    public MonitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.serviceName = str;
        if (jSONObject != null) {
            this.category = jSONObject.toString();
        }
        if (jSONObject2 != null) {
            this.metric = jSONObject2.toString();
        }
        if (jSONObject3 != null) {
            this.extra = jSONObject3.toString();
        }
    }

    public MonitorEvent(Cursor cursor) {
        this.id = cursor.getLong(0);
        this.serviceName = cursor.getString(1);
        this.category = cursor.getString(2);
        this.metric = cursor.getString(3);
        this.extra = cursor.getString(4);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "service_name", this.serviceName);
        add(jSONObject, "category", this.category);
        add(jSONObject, "metric", this.metric);
        add(jSONObject, "extra", this.extra);
        return jSONObject;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("service_name", this.serviceName);
        contentValues.put("category", this.category);
        contentValues.put("metric", this.metric);
        contentValues.put("extra", this.extra);
        return contentValues;
    }

    public String toString() {
        return "{id=" + this.id + ", serviceName='" + this.serviceName + "', category='" + this.category + "', metric='" + this.metric + "', extra='" + this.extra + "'}";
    }

    public JSONObject getCategory() {
        try {
            return new JSONObject(this.category);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject getMetric() {
        try {
            return new JSONObject(this.metric);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject getExtra() {
        try {
            return new JSONObject(this.extra);
        } catch (Throwable unused) {
            return null;
        }
    }
}
