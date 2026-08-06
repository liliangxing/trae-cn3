package com.bytedance.apm6.commonevent.model;

import android.text.TextUtils;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class CommonLog implements Monitorable {
    private JSONObject logJson;
    private String logType;

    public CommonLog(String str, JSONObject jSONObject) {
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

    public void deepCopyJson() {
        this.logJson = JsonUtils.safeCopyJson(this.logJson);
    }

    public String toString() {
        return "CommonLog{logType='" + this.logType + "'}";
    }
}
