package com.bytedance.framwork.core.monitor;

import android.util.Log;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class MonitorUtils {
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    public static final String TAG_DEPRECATED = "Deprecated";

    @Deprecated
    public static void setIsBackGround(boolean z) {
    }

    @Deprecated
    public static void setDebugMode() {
        ApmContext.setDebugMode(true);
    }

    public static void monitorPerformance(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        ApmAgent.monitorPerformance(str, jSONObject, jSONObject2, jSONObject3);
    }

    public static void monitorPerformance(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        ApmAgent.monitorPerformance(str, str2, jSONObject, jSONObject2, jSONObject3);
    }

    public static void monitorUIAction(String str, String str2, JSONObject jSONObject) {
        ApmAgent.monitorUIAction(str, str2, jSONObject);
    }

    @Deprecated
    public static void monitorSLA(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        ApmAgent.monitorSLA(j, j2, str, str2, str3, i, jSONObject);
    }

    @Deprecated
    public static void monitorApiError(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        ApmAgent.monitorApiError(j, j2, str, str2, str3, i, jSONObject);
    }

    public static void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        ApmAgent.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }

    @Deprecated
    public static void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        ApmAgent.monitorStatusRate(str, i, jSONObject);
    }

    @Deprecated
    public static void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        ApmAgent.monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
    }

    @Deprecated
    public static void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        ApmAgent.monitorDuration(str, jSONObject, jSONObject2);
    }

    @Deprecated
    public static void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2, long j) {
        ApmAgent.monitorDuration(str, jSONObject, jSONObject2, j);
    }

    @Deprecated
    public static void monitorDirectOnTimer(String str, String str2, float f) {
        ApmAgent.monitorDirectOnTimer(str, str2, f);
    }

    @Deprecated
    public static void monitorOnTimer(String str, String str2, float f) {
        Log.e(TAG_DEPRECATED, MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE);
    }

    @Deprecated
    public static void monitorOnCount(String str, String str2, float f) {
        Log.e(TAG_DEPRECATED, MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE);
    }

    @Deprecated
    public static void monitorOnCount(String str, String str2) {
        Log.e(TAG_DEPRECATED, MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE);
    }

    @Deprecated
    public static void monitorDirectOnCount(String str, String str2, float f) {
        Log.e(TAG_DEPRECATED, MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE);
    }

    public static void monitorCommonLog(String str, JSONObject jSONObject) {
        ApmAgent.monitorCommonLog(str, jSONObject);
    }

    public static void monitorCommonLog(String str, JSONObject jSONObject, boolean z) {
        ApmAgent.monitorCommonLog(str, jSONObject, z);
    }

    public static void monitorStartTime(String str, float f) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, f);
            monitorPerformance("start", str, jSONObject, null, null);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public static void monitorOnStore(String str, String str2, float f) {
        Log.e(TAG_DEPRECATED, MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE);
    }

    @Deprecated
    public static void monitorDebugReal(String str, String str2) {
        Log.e(TAG_DEPRECATED, MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE);
    }

    @Deprecated
    public static void monitorDebugReal(String str) {
        Log.e(TAG_DEPRECATED, MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE);
    }

    public static boolean getLogTypeSwitch(String str) {
        return ApmDelegate.getInstance().getLogTypeSwitch(str);
    }

    public static boolean getServiceNameSwitch(String str) {
        return ApmDelegate.getInstance().getServiceNameSwitch(str);
    }

    public static boolean getMetricsTypeSwitch(String str) {
        return ApmDelegate.getInstance().getMetricsTypeSwitch(str);
    }
}
