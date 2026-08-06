package com.bytedance.apm.launch;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.LaunchPerfDataFetcher;
import com.bytedance.apm.util.ThreadTimeItem;
import com.bytedance.apm6.util.log.Logger;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchDataReport {
    private static boolean hasFetch;

    public static LaunchPerfDataFetcher.LaunchTraceData createPerfData(long j) {
        if (hasFetch) {
            return null;
        }
        hasFetch = true;
        if (LaunchAnalysisContext.getInstance().getConfig().isNeedCollectPerfData() && FunctionSwitcher.getSwitch(4)) {
            return LaunchPerfDataFetcher.getLaunchTraceData(j);
        }
        return null;
    }

    public static JSONObject packagePerfData(LaunchPerfDataFetcher.LaunchTraceData launchTraceData) {
        if (launchTraceData == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (launchTraceData.getGcCount() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_GC_COUNT, launchTraceData.getGcCount());
            }
            if (launchTraceData.getGcTime() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_GC_TIME, launchTraceData.getGcTime());
            }
            if (launchTraceData.getBlockGcCount() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_COUNT, launchTraceData.getBlockGcCount());
            }
            if (launchTraceData.getBlockGcTime() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_TIME, launchTraceData.getBlockGcTime());
            }
            if (launchTraceData.getIowaitTime() != -1.0d) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_IOWAIT_TIME, launchTraceData.getIowaitTime());
            }
            if (launchTraceData.getRunnableTime() != -1.0d) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_RUNNABLE_TIME, launchTraceData.getRunnableTime());
            }
            if (launchTraceData.getSleepTime() != -1.0d) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_SLEEP_TIME, launchTraceData.getSleepTime());
            }
            if (launchTraceData.getMinorFault() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_MINOR_FAULT, launchTraceData.getMinorFault());
            }
            if (launchTraceData.getMajorFault() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_MAJOR_FAULT, launchTraceData.getMajorFault());
            }
            if (launchTraceData.getCpuTime() != -1.0d) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_CPU_TIME, launchTraceData.getCpuTime());
            }
            if (launchTraceData.getVoluntarySwitches() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_VOLUNTARY_SWITCHES, launchTraceData.getVoluntarySwitches());
            }
            if (launchTraceData.getInVoluntarySwitches() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_INVOLUNTARY_SWITCHES, launchTraceData.getInVoluntarySwitches());
            }
            if (launchTraceData.getAllThreadCount() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_ALL_THREAD_COUNT, launchTraceData.getAllThreadCount());
            }
            if (launchTraceData.getLockTime() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_LOCK_TIME, launchTraceData.getLockTime());
            }
            if (launchTraceData.getBinderTime() != -1) {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_BINDER_TIME, launchTraceData.getBinderTime());
            }
            jSONObject.put(LaunchCommon.LAUNCH_DATA_LIST_DATA, jSONObject2);
            List<String> javaThreadNameList = launchTraceData.getJavaThreadNameList();
            if (javaThreadNameList != null && !javaThreadNameList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = javaThreadNameList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put(LaunchCommon.LAUNCH_DATA_JAVA_THREAD_NAME_LIST, jSONArray);
            }
            if (launchTraceData.getProcessCpuTime() > 0 && launchTraceData.getProcessDuration() > 0 && launchTraceData.getThreadTimeItems() != null && launchTraceData.getThreadTimeItems().size() > 0) {
                jSONObject.put(LaunchCommon.LAUNCH_DATA_PROCESS_CPU_TIME, launchTraceData.getProcessCpuTime());
                jSONObject.put(LaunchCommon.LAUNCH_DATA_PROCESS_DURATION, launchTraceData.getProcessDuration());
                jSONObject.put(LaunchCommon.LAUNCH_DATA_THREAD_CPU_INFO, packThreadItem(launchTraceData.getThreadTimeItems(), launchTraceData.getProcessDuration(), launchTraceData.getProcessCpuTime()));
            }
            LaunchAnalysisContext.getInstance().logD("perf data: " + jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            LaunchAnalysisContext.getInstance().logE(th.getLocalizedMessage());
            return null;
        }
    }

    public static JSONArray packThreadItem(List<ThreadTimeItem> list, long j, long j2) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (ThreadTimeItem threadTimeItem : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", threadTimeItem.threadName);
            jSONObject.put(LaunchCommon.LAUNCH_THREAD_INFO_UTM, threadTimeItem.utm);
            jSONObject.put(LaunchCommon.LAUNCH_THREAD_INFO_STM, threadTimeItem.stm);
            jSONObject.put("duration", threadTimeItem.startDuration);
            jSONObject.put(LaunchCommon.LAUNCH_THREAD_INFO_USAGE_FOR_THREAD_DURATION, String.format("%.5f", Float.valueOf(threadTimeItem.threadUsage)));
            jSONObject.put(LaunchCommon.LAUNCH_THREAD_INFO_USAGE_FOR_PROCESS_DURATION, String.format("%.5f", Float.valueOf((((float) threadTimeItem.threadTime) * 1.0f) / ((float) j))));
            jSONObject.put(LaunchCommon.LAUNCH_THREAD_INFO_USAGE_FOR_PROCESS_CPU, String.format("%.5f", Float.valueOf((((float) threadTimeItem.threadTime) * 1.0f) / ((float) j2))));
            if (ApmContext.isDebugMode()) {
                Logger.m122i("LaunchPerfData", "packThreadItem: " + jSONObject);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
