package com.bytedance.apm.launch.evil;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.monitor.collector.BinderMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchBinderDetector {
    private static final String REPORT_TAG = "is_launch_binder";

    public static long fetchLaunchBinderData() {
        long j = 0;
        if (LaunchAnalysisContext.getInstance().getMonitorConfig().isDetectBinder() && FunctionSwitcher.getSwitch(2)) {
            List<BinderMonitor.BinderInfo> dumpBinderInfo = PerfMonitorManager.getInstance().dumpBinderInfo();
            if (dumpBinderInfo != null && !dumpBinderInfo.isEmpty()) {
                for (BinderMonitor.BinderInfo binderInfo : dumpBinderInfo) {
                    long end = binderInfo.getEnd() - binderInfo.getBegin();
                    j += end;
                    reportLongBinderData(end, removeUselessStackTrace(binderInfo.getElements()));
                }
            }
            LaunchAnalysisContext.getInstance().logD("binder cost when launch: " + j);
        }
        return j;
    }

    private static void reportLongBinderData(final long j, final StackTraceElement[] stackTraceElementArr) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.launch.evil.LaunchBinderDetector.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String stackTraces = StackUtils.getStackTraces(stackTraceElementArr);
                    if (j != 0 && !stackTraces.isEmpty()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("crash_time", System.currentTimeMillis());
                        jSONObject.put("is_main_process", ApmContext.isMainProcess());
                        jSONObject.put("process_name", ApmContext.getCurrentProcessName());
                        jSONObject.put(CommonKey.KEY_BLOCK_DURATION, j);
                        jSONObject.put("stack", stackTraces);
                        jSONObject.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_LAG);
                        JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
                        perfFiltersJson.put(CommonKey.KEY_BLOCK_STACK_TYPE, "stack");
                        perfFiltersJson.put(LaunchBinderDetector.REPORT_TAG, "true");
                        jSONObject.put("filters", perfFiltersJson);
                        LaunchAnalysisContext.getInstance().logD("binder report json: " + jSONObject);
                        CommonDataPipeline.getInstance().handle(new ExceptionLogData("block_monitor", jSONObject));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static StackTraceElement[] removeUselessStackTrace(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return stackTraceElementArr;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= stackTraceElementArr.length) {
                break;
            }
            if ("saveBinderInfo".equals(stackTraceElementArr[i2].getMethodName())) {
                i = i2;
                break;
            }
            i2++;
        }
        int i3 = i + 1;
        return i3 <= stackTraceElementArr.length ? (StackTraceElement[]) Arrays.copyOfRange(stackTraceElementArr, i3, stackTraceElementArr.length) : stackTraceElementArr;
    }
}
