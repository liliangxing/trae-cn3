package com.bytedance.apm6.cpu.exception.normal;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm.perf.TemperatureDataManager;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.log.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuNormalExceptionEvent implements Monitorable {
    private static final String EVENT_CPU_EXCEPTION = "cpu_exception_trace";
    private static final String KEY_BATTERY_RECHARGE_STATE = "battery_recharge_state";
    private static final String KEY_BATTERY_TEMPERATURE = "battery_temperature";
    public static final String KEY_MAX_BACKGROUND = "apm_max_background";
    public static final String KEY_MAX_FOREGROUND = "apm_max_foreground";
    private static final String KEY_PROCESS_SPEED_AVG = "process_speed_avg";
    private static final String KEY_PROCESS_SPEED_MAX = "process_speed_max";
    private static final String KEY_THREAD_CPU_USAGE = "cpu_usage";
    private static final String KEY_THREAD_INFO = "threads_info";
    private static final String KEY_THREAD_NAME = "thread_name";
    private static final String KEY_THREAD_PRIORITY = "nice";
    private static final String KEY_THREAD_STACK = "thread_back_trace";
    private static final String KEY_THREAD_TID = "thread_id";
    private static final String KEY_THREAD_WEIGHT = "weight";
    private double avgLoad;
    private boolean isBackground;
    private List<ThreadExceptionItem> itemList;
    private double maxLoad;
    private String scene;

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "cpu_exception_trace";
    }

    public CpuNormalExceptionEvent(double d, double d2, List<ThreadExceptionItem> list, String str, boolean z) {
        this.avgLoad = d;
        this.maxLoad = d2;
        this.scene = str;
        this.isBackground = z;
        this.itemList = new ArrayList(list);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        List<ThreadExceptionItem> list = this.itemList;
        return list != null && !list.isEmpty() && this.avgLoad > 0.0d && this.maxLoad > 0.0d;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", "cpu_exception_trace");
            jSONObject.put("log_type", "cpu_exception_trace");
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("crash_time", System.currentTimeMillis());
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            if (this.isBackground) {
                jSONObject.put(CpuReportEvent.PERF_DATA_TYPE, CpuReportEvent.VALUE_BACK);
            } else {
                jSONObject.put(CpuReportEvent.PERF_DATA_TYPE, "front");
            }
            jSONObject.put("scene", this.scene);
            jSONObject.put(CommonKey.KEY_REPORT_SCENE, this.scene);
            if (ApmContext.getAppLaunchStartTimestamp() <= ApmContext.getStartId() && ApmContext.getAppLaunchStartTimestamp() != 0) {
                jSONObject.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getAppLaunchStartTimestamp());
            } else {
                jSONObject.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getStartId());
            }
            jSONObject.put(KEY_PROCESS_SPEED_AVG, this.avgLoad);
            jSONObject.put(KEY_PROCESS_SPEED_MAX, this.maxLoad);
            jSONObject.put("battery_temperature", TemperatureDataManager.getInstance().getTemperature());
            jSONObject.put(KEY_BATTERY_RECHARGE_STATE, TemperatureDataManager.getInstance().getStatus());
            JSONArray jSONArray = new JSONArray();
            for (ThreadExceptionItem threadExceptionItem : this.itemList) {
                if (threadExceptionItem != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(KEY_THREAD_PRIORITY, threadExceptionItem.getPriority());
                    jSONObject2.put(KEY_THREAD_WEIGHT, Double.valueOf(threadExceptionItem.getWeight()));
                    jSONObject2.put(KEY_THREAD_CPU_USAGE, threadExceptionItem.getCpuUsage());
                    jSONObject2.put(KEY_THREAD_NAME, threadExceptionItem.getThreadName());
                    jSONObject2.put(KEY_THREAD_STACK, threadExceptionItem.getStack());
                    jSONObject2.put(KEY_THREAD_TID, threadExceptionItem.getThreadId());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(KEY_THREAD_INFO, jSONArray);
        } catch (Throwable th) {
            Logger.m121e(Constants.TAG, "cpu_exception_data_assemble", th);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("exception", th.getLocalizedMessage());
                CommonEventDeliverer.monitorDuration("cpu_exception_no_stack", jSONObject3, null);
            } catch (Throwable unused) {
            }
        }
        Log.i(Constants.TAG, "exception data: " + jSONObject);
        return jSONObject;
    }
}
