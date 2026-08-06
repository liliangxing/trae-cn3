package com.bytedance.tracing.internal;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class LogData {
    private final Map<String, String> fields;
    private final String message;
    private final long timestamp;

    public LogData(long j, String str, Map<String, String> map) {
        this.timestamp = j;
        this.message = str;
        this.fields = map;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", this.timestamp);
            jSONObject.put("message", this.message);
            Map<String, String> map = this.fields;
            if (map != null && map.size() > 0) {
                jSONObject.put(TracingConstants.KEY_FIELDS, new JSONObject(this.fields));
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
