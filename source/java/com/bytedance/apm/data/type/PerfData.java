package com.bytedance.apm.data.type;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PerfData implements ITypeData {
    public JSONObject extraStatus;
    public JSONObject extraValues;
    public JSONObject filters;
    public boolean forceReport;
    public boolean isSaveImmediately;
    public JSONObject logExtr;
    public String metricName;
    public String serviceName;

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "performance_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public PerfData() {
    }

    public PerfData serviceName(String str) {
        this.serviceName = str;
        return this;
    }

    public PerfData metricName(String str) {
        this.metricName = str;
        return this;
    }

    public PerfData forceReport(boolean z) {
        this.forceReport = z;
        return this;
    }

    public PerfData extraValues(JSONObject jSONObject) {
        this.extraValues = jSONObject;
        return this;
    }

    public PerfData extraStatus(JSONObject jSONObject) {
        this.extraStatus = jSONObject;
        return this;
    }

    public PerfData appendFilters(JSONObject jSONObject) {
        this.filters = jSONObject;
        return this;
    }

    public PerfData extraLog(JSONObject jSONObject) {
        this.logExtr = jSONObject;
        return this;
    }

    public PerfData(String str, String str2, boolean z, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.serviceName = str;
        this.metricName = str2;
        this.forceReport = z;
        this.extraValues = jSONObject;
        this.extraStatus = jSONObject2;
        this.logExtr = jSONObject3;
    }

    public PerfData(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this(str, str2, false, jSONObject, jSONObject2, jSONObject3);
    }

    public PerfData(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this(str, "", false, jSONObject, jSONObject2, jSONObject3);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        try {
            if (this.logExtr == null) {
                this.logExtr = new JSONObject();
            }
            this.logExtr.put("log_type", "performance_monitor");
            this.logExtr.put("service", this.serviceName);
            if (!JsonUtils.isEmpty(this.extraValues)) {
                this.logExtr.put(CommonKey.KEY_EXTRA_VALUES, this.extraValues);
            }
            if (TextUtils.equals("start", this.serviceName) && TextUtils.equals("from", this.logExtr.optString("monitor-plugin"))) {
                if (this.extraStatus == null) {
                    this.extraStatus = new JSONObject();
                }
                this.extraStatus.put("start_mode", ApmContext.getLaunchMode());
            }
            if (!JsonUtils.isEmpty(this.extraStatus)) {
                this.logExtr.put(CommonKey.KEY_EXTRA_STATUS, this.extraStatus);
            }
            if (!JsonUtils.isEmpty(this.filters)) {
                this.logExtr.put("filters", this.filters);
            }
            return this.logExtr;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        boolean perfFpsAllowSwitch;
        JSONObject optJSONObject;
        if ("fps".equals(this.serviceName) || "fps_drop".equals(this.serviceName)) {
            perfFpsAllowSwitch = SamplerHelper.getPerfFpsAllowSwitch(this.serviceName, this.metricName);
        } else if (CommonServiceName.MONITOR_TYPE_TEMPERATURE.equals(this.serviceName)) {
            perfFpsAllowSwitch = SamplerHelper.getPerfSecondStageSwitch(this.serviceName);
        } else {
            if (!"battery".equals(this.serviceName)) {
                if ("start".equals(this.serviceName)) {
                    if (!SamplerHelper.getPerfAllowSwitch(this.serviceName) && !SamplerHelper.getMetricSwitch(this.metricName)) {
                        perfFpsAllowSwitch = false;
                    }
                } else if ("start_trace".equals(this.serviceName)) {
                    if (jSONObject != null) {
                        if (!SamplerHelper.getPerfSecondStageSwitch(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT)) {
                            jSONObject.remove(LaunchCommon.LAUNCH_DATA_PERF_DATA);
                        }
                        if (!SamplerHelper.getPerfAllowSwitch(this.serviceName) && (optJSONObject = jSONObject.optJSONObject(TraceStatsConsts.STATS_KEY_TRACE)) != null) {
                            optJSONObject.remove(TraceStatsConsts.STATS_KEY_SPANS);
                        }
                    }
                    perfFpsAllowSwitch = SamplerHelper.getPerfAllowSwitch(this.serviceName);
                } else {
                    perfFpsAllowSwitch = SamplerHelper.getPerfAllowSwitch(this.serviceName);
                }
            }
            perfFpsAllowSwitch = true;
        }
        return this.forceReport || perfFpsAllowSwitch;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.serviceName;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return this.isSaveImmediately;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getMetricName() {
        return this.metricName;
    }

    public boolean isAddDeviceInfo() {
        return TextUtils.equals(this.serviceName, "memory");
    }
}
