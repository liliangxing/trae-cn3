package com.bytedance.apm6.commonevent.model;

import android.text.TextUtils;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class GeneralLegacyEvent implements Monitorable {
    private JSONObject logJson;
    private String logType;

    public GeneralLegacyEvent(String str, JSONObject jSONObject) {
        this.logType = str;
        this.logJson = jSONObject;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return this.logType;
    }

    public JSONObject getLogJson() {
        return this.logJson;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.logType);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        try {
            JSONObject logJson = getLogJson();
            if (logJson == null) {
                logJson = new JSONObject();
            }
            logJson.put("log_type", getLogType());
            return logJson;
        } catch (Exception e) {
            if (!ApmContext.isDebugMode()) {
                return null;
            }
            Logger.w(Constants.TAG, "toJsonObject Error.", e);
            return null;
        }
    }

    public String toString() {
        return "Apm5LegacyEvent{logType='" + this.logType + "'}";
    }
}
