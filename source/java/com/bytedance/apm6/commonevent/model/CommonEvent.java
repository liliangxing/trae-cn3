package com.bytedance.apm6.commonevent.model;

import android.text.TextUtils;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class CommonEvent implements Monitorable {
    public static final String LOG_TYPE = "service_monitor";
    private JSONObject category;
    private JSONObject extraJson;
    private JSONObject metric;
    private String serviceName;
    private int status;
    private JSONObject value;

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "service_monitor";
    }

    public CommonEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.serviceName = str;
        this.status = i;
        this.value = jSONObject;
        this.category = jSONObject2;
        this.metric = jSONObject3;
        this.extraJson = jSONObject4;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getStatus() {
        return this.status;
    }

    public JSONObject getValue() {
        return this.value;
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getMetric() {
        return this.metric;
    }

    public JSONObject getExtraJson() {
        return this.extraJson;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.serviceName);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        try {
            JSONObject extraJson = getExtraJson();
            if (extraJson == null) {
                extraJson = new JSONObject();
            }
            extraJson.put("log_type", "service_monitor");
            extraJson.put("service", getServiceName());
            extraJson.put("status", getStatus());
            if (getValue() != null) {
                extraJson.put("value", getValue());
            }
            if (getCategory() != null) {
                extraJson.put("category", getCategory());
            }
            if (getMetric() != null) {
                extraJson.put("metric", getMetric());
            }
            return extraJson;
        } catch (Exception e) {
            if (!ApmContext.isDebugMode()) {
                return null;
            }
            Logger.w(Constants.TAG, "toJsonObject Error.", e);
            return null;
        }
    }

    public void deepCopyJson() {
        this.value = JsonUtils.safeCopyJson(this.value);
        this.category = JsonUtils.safeCopyJson(this.category);
        this.metric = JsonUtils.safeCopyJson(this.metric);
        this.extraJson = JsonUtils.safeCopyJson(this.extraJson);
    }

    public String toString() {
        return "CommonEvent{serviceName='" + this.serviceName + "'}";
    }
}
