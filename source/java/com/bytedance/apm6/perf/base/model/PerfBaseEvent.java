package com.bytedance.apm6.perf.base.model;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class PerfBaseEvent implements Monitorable {
    protected static final String KEY_IS_FRONT = "is_front";
    protected static final String KEY_IS_MAIN_PROCESS = "is_main_process";
    protected static final String KEY_PROCESS_NAME = "process_name";
    private JSONObject logExtr;
    protected final String KEY_LOG_TYPE = "log_type";
    protected final String KEY_EXTRA_STATUS = CommonKey.KEY_EXTRA_STATUS;
    protected final String KEY_EXTRA_VALUES = CommonKey.KEY_EXTRA_VALUES;
    protected final String KEY_FILTERS = "filters";
    protected final String KEY_SERVICE = "service";
    protected final String KEY_SCENE = "scene";

    protected abstract JSONObject getExtraValues();

    protected abstract JSONObject getFilters();

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "performance_monitor";
    }

    protected abstract String getServiceName();

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        try {
            if (this.logExtr == null) {
                this.logExtr = createRootJSONObject();
            }
            this.logExtr.put("log_type", "performance_monitor");
            this.logExtr.put("service", getServiceName());
            JSONObject extraValues = getExtraValues();
            if (!JsonUtils.isEmpty(extraValues)) {
                this.logExtr.put(CommonKey.KEY_EXTRA_VALUES, extraValues);
            }
            JSONObject extraStatus = getExtraStatus();
            if (!JsonUtils.isEmpty(extraStatus)) {
                this.logExtr.put(CommonKey.KEY_EXTRA_STATUS, extraStatus);
            }
            JSONObject filters = getFilters();
            if (!JsonUtils.isEmpty(filters)) {
                this.logExtr.put("filters", filters);
            }
            return this.logExtr;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject createRootJSONObject() {
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject getExtraStatus() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", PerfFilterManager.getInstance().getSceneString());
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
