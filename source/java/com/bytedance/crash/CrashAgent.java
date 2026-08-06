package com.bytedance.crash;

import android.text.TextUtils;
import com.bytedance.crash.anr.AnrInfoParser;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashAgent {
    private static final String SERVICE_NAME = "hmd_app_exit_reason";

    public static void monitorCrash(CrashType crashType, long j, JSONObject jSONObject) {
        IApmAgent iApmAgent;
        boolean z = crashType == CrashType.ANR ? !TextUtils.isEmpty(jSONObject.optString(AnrInfoParser.ANR_INFO)) : false;
        String lastResumedActivityFromBody = ActivityLifecycle.getLastResumedActivityFromBody(jSONObject);
        try {
            ICrashMonitorService crashMonitorService = Global.getCrashMonitorService();
            if (crashMonitorService == null) {
                iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
                if (iApmAgent == null) {
                    return;
                }
            } else {
                iApmAgent = null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_exit_metrics", crashType.getName());
            if (!TextUtils.isEmpty(lastResumedActivityFromBody)) {
                jSONObject2.put("scene", lastResumedActivityFromBody);
            }
            if (crashType == CrashType.ANR) {
                jSONObject2.put("has_anr_info", z);
            }
            jSONObject2.put("crash_time", j);
            if (crashMonitorService != null) {
                crashMonitorService.monitorEvent(SERVICE_NAME, jSONObject2, null, null);
            } else {
                iApmAgent.monitorEvent(SERVICE_NAME, jSONObject2, (JSONObject) null, (JSONObject) null);
            }
        } catch (Exception unused) {
        }
    }

    public static void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        IApmAgent iApmAgent;
        try {
            ICrashMonitorService crashMonitorService = Global.getCrashMonitorService();
            if (crashMonitorService == null) {
                iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
                if (iApmAgent == null) {
                    return;
                }
            } else {
                iApmAgent = null;
            }
            if (crashMonitorService != null) {
                crashMonitorService.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
            } else {
                iApmAgent.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
            }
        } catch (Exception unused) {
        }
    }
}
