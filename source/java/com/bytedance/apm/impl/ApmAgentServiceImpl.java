package com.bytedance.apm.impl;

import android.content.Context;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.services.apm.api.EventConfig;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmAgentServiceImpl implements IApmAgent {
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        ApmAgent.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }

    public void monitorLog(String str, JSONObject jSONObject) {
        ApmAgent.monitorCommonLog(str, jSONObject);
    }

    public void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        ApmAgent.monitorStatusRate(str, i, jSONObject);
    }

    public void monitorEvent(EventConfig eventConfig) {
        ApmAgent.monitorEvent(com.bytedance.apm.config.EventConfig.builder().setServiceName(eventConfig.getServiceName()).setStatus(eventConfig.getStatus()).setCategory(eventConfig.getCategory()).setMetric(eventConfig.getMetric()).setExtraLog(eventConfig.getExtraLog()).isUploadImmediate(eventConfig.isUploadImmediate()).build());
    }

    public void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        ApmAgent.monitorDuration(str, jSONObject, jSONObject2);
    }

    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        ApmAgent.monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
    }

    public void monitorCommonLog(String str, JSONObject jSONObject) {
        ApmAgent.monitorCommonLog(str, jSONObject);
    }

    public void monitorExceptionLog(String str, JSONObject jSONObject) {
        ApmAgent.monitorExceptionLog(str, jSONObject);
    }

    public void reportLegacyMonitorLog(Context context, long j, long j2, boolean z) {
        ApmAgent.reportLegacyMonitorLog(ApmContext.getContext(), j, j2, z);
    }
}
