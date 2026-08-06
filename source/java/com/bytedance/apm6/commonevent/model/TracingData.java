package com.bytedance.apm6.commonevent.model;

import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TracingData implements Monitorable {
    private JSONArray array;

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "tracing";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public TracingData(JSONArray jSONArray) {
        this.array = jSONArray;
    }

    public TracingData(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        this.array = jSONArray;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public final JSONObject toJsonObject() {
        return BatchLogWrapUtils.wrapData(getLogType(), this.array);
    }
}
