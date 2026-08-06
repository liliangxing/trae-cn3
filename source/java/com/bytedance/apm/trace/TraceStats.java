package com.bytedance.apm.trace;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.entity.TraceTimeEntity;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.launch.LaunchDataReport;
import com.bytedance.apm.launch.LaunchPerfDataFetcher;
import com.bytedance.apm.launch.evil.LaunchBinderDetector;
import com.bytedance.apm.launch.evil.LaunchLockDetector;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.LogUtils;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.perf.monitor.EvilMethodTracer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TraceStats {
    public static final int FLAG_EXTRA_INFO_IO = 16;
    public static final int FLAG_EXTRA_INFO_NET = 1;
    public static final int FLAG_EXTRA_INFO_NONE = 0;
    public static final int FLAG_EXTRA_INFO_THREAD = 256;
    private static final String TAG = "AppStartStats";
    private static volatile boolean isFirst = true;
    private final ConcurrentHashMap<String, TraceTimeEntity> timeSpanMap = new ConcurrentHashMap<>(4);
    private long traceBeginTimestamp;
    private long traceEndTimestamp;
    private final String traceName;
    private final String traceServiceName;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface LockFetchListener {
        void lockTime(long j);
    }

    public TraceStats(String str, String str2) {
        if (!"start_trace".equals(str) && !"page_load_trace".equals(str)) {
            throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
        }
        this.traceServiceName = str;
        this.traceName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLaunchService() {
        return "start_trace".equals(this.traceServiceName);
    }

    public long getTraceBeginTimestamp() {
        return this.traceBeginTimestamp;
    }

    public void startTrace() {
        this.traceBeginTimestamp = System.currentTimeMillis();
    }

    public void startSpan(String str, String str2) {
        startSpan(str, str2, false);
    }

    public void startSpan(String str, String str2, boolean z) {
        if (this.timeSpanMap.get(str + "#" + str2) == null || z) {
            this.timeSpanMap.put(str + "#" + str2, new TraceTimeEntity(System.currentTimeMillis()));
        }
    }

    public void endSpan(String str, String str2) {
        TraceTimeEntity traceTimeEntity = this.timeSpanMap.get(str + "#" + str2);
        if (traceTimeEntity == null) {
            return;
        }
        traceTimeEntity.appendEndTimeAndThread(System.currentTimeMillis(), Thread.currentThread().getName());
        this.timeSpanMap.put(str + "#" + str2, traceTimeEntity);
    }

    public void recordSpan(String str, String str2, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        TraceTimeEntity traceTimeEntity = new TraceTimeEntity(currentTimeMillis - j);
        traceTimeEntity.appendEndTimeAndThread(currentTimeMillis, Thread.currentThread().getName());
        this.timeSpanMap.put(str + "#" + str2, traceTimeEntity);
    }

    public void endTrace(int i, String str, long j) {
        endTrace(i, str, j, 0L);
    }

    public void endTrace(int i, String str, long j, long j2) {
        endTrace(i, "", str, j, j2);
    }

    public void endTrace(String str, String str2, long j) {
        endTrace(str, str2, j, 0L);
    }

    public void endTrace(String str, String str2, long j, long j2) {
        endTrace(-1, str, str2, j, j2);
    }

    private void endTrace(final int i, final String str, final String str2, long j, long j2) {
        if (i == -1 && str.isEmpty() && ApmContext.isDebugMode()) {
            throw new IllegalArgumentException("Launch mode is both none");
        }
        this.traceEndTimestamp = System.currentTimeMillis();
        if (j2 > 0) {
            this.traceEndTimestamp = this.traceBeginTimestamp + j2;
        }
        long j3 = this.traceEndTimestamp - this.traceBeginTimestamp;
        if (j <= 0 || j3 <= j) {
            final LaunchPerfDataFetcher.LaunchTraceData createPerfData = isLaunchService() ? LaunchDataReport.createPerfData(j3) : null;
            if (isLaunchService() && EvilMethodTracer.isEvilMethodTraceEnable && isFirst) {
                isFirst = false;
                reportPerfInfo(i, str, this.traceBeginTimestamp, this.traceEndTimestamp);
            }
            if (isLaunchService() && LaunchAnalysisContext.getInstance().getMonitorConfig().isDetectLock() && FunctionSwitcher.getSwitch(8)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(LaunchLockDetector.LAUNCH_LOCK_WITH_OWNER_KEY, true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LockMonitorManager.endLockDetect(jSONObject);
            }
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.TraceStats.1
                @Override // java.lang.Runnable
                public void run() {
                    LaunchPerfDataFetcher.LaunchTraceData launchTraceData;
                    if (TraceStats.this.isLaunchService()) {
                        long fetchLaunchBinderData = LaunchBinderDetector.fetchLaunchBinderData();
                        if (fetchLaunchBinderData != 0 && (launchTraceData = createPerfData) != null) {
                            launchTraceData.setBinderTime(fetchLaunchBinderData);
                        }
                    }
                    TraceStats traceStats = TraceStats.this;
                    traceStats.reportAsync(i, str, str2, traceStats.traceEndTimestamp, createPerfData);
                }
            });
            if (isLaunchService()) {
                LaunchSleepDetector.stopDetect();
            }
        }
    }

    public void cancelTrace() {
        this.timeSpanMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAsync(int i, String str, String str2, long j, LaunchPerfDataFetcher.LaunchTraceData launchTraceData) {
        JSONObject packagePerfData;
        JSONArray jSONArray = new JSONArray();
        int i2 = 2;
        char c = 1;
        try {
            if (TextUtils.equals(str2, AutoLaunchTraceHelper.sLauncherActivityName)) {
                jSONArray = AutoLaunchTraceHelper.assemblySpan();
            }
            ConcurrentHashMap<String, TraceTimeEntity> concurrentHashMap = this.timeSpanMap;
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                for (Map.Entry<String, TraceTimeEntity> entry : this.timeSpanMap.entrySet()) {
                    String key = entry.getKey();
                    TraceTimeEntity value = entry.getValue();
                    if (value.endTimestamp != 0) {
                        JSONObject jSONObject = new JSONObject();
                        String[] split = key.split("#");
                        if (split.length == i2) {
                            if ("page_load_trace".equals(this.traceServiceName)) {
                                jSONObject.put("name", split[c]);
                            } else {
                                jSONObject.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, split[0]);
                                jSONObject.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, split[1]);
                            }
                        } else if (split.length == 1) {
                            jSONObject.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, split[0]);
                        }
                        jSONObject.put("start", value.startTimestamp);
                        jSONObject.put(TraceStatsConsts.STATS_KEY_END, value.endTimestamp);
                        jSONObject.put("thread", value.threadName);
                        jSONArray.put(jSONObject);
                        i2 = 2;
                        c = 1;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ConcurrentHashMap<String, TraceTimeEntity> concurrentHashMap2 = this.timeSpanMap;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("name", this.traceName);
            jSONObject2.put("page_type", this.traceName);
            jSONObject2.put("start", this.traceBeginTimestamp);
            jSONObject2.put(TraceStatsConsts.STATS_KEY_END, j);
            jSONObject2.put(TraceStatsConsts.STATS_KEY_SPANS, jSONArray);
            jSONObject2.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 2);
            jSONObject2.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, str2);
            if (i != -1) {
                jSONObject2.put("launch_mode", i);
            }
            if (!str.isEmpty()) {
                jSONObject2.put(TraceStatsConsts.STATS_KEY_CUSTOM_LAUNCH_MODE, str);
            }
            if (ApmAlogHelper.isFeedbackALogEnabled()) {
                ApmAlogHelper.feedbackI(TAG, jSONObject2.toString());
            }
        } catch (JSONException unused) {
        }
        if (isLaunchService() && LaunchAnalysisContext.getInstance().getConfig().isNeedCollectDeviceInfo()) {
            JSONObject jSONObject3 = new JSONObject();
            DeviceInfoUtil.getInstance().addRealTimeDeviceInfo(jSONObject3, true);
            DeviceInfoUtil.getInstance().addConstantDeviceInfo(jSONObject3, true);
            try {
                jSONObject2.put(LaunchCommon.LAUNCH_DATA_DEVICE_DATA, jSONObject3);
            } catch (Throwable unused2) {
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put(TraceStatsConsts.STATS_KEY_TRACE, jSONObject2);
            if (launchTraceData != null && (packagePerfData = LaunchDataReport.packagePerfData(launchTraceData)) != null) {
                jSONObject4.put(LaunchCommon.LAUNCH_DATA_PERF_DATA, packagePerfData);
            }
        } catch (JSONException unused3) {
        }
        PerfData perfData = new PerfData(this.traceServiceName, "", null, null, jSONObject4);
        CommonDataAssembly.wrapFilters(perfData, false);
        if (ApmContext.isDebugMode()) {
            LogUtils.m103d(TAG, "reportAsync: " + jSONObject4);
        }
        CommonDataPipeline.getInstance().handle(perfData);
    }

    private void reportPerfInfo(final int i, final String str, final long j, final long j2) {
        final long[] copyAllData = MethodCollector.getInstance().copyAllData();
        final long uptimeMillis = SystemClock.uptimeMillis();
        if (copyAllData != null) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.TraceStats.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String evilMethodString = MethodCollector.getInstance().evilMethodString(copyAllData, uptimeMillis);
                        if (TextUtils.isEmpty(evilMethodString)) {
                            return;
                        }
                        long j3 = j2 - j;
                        JSONObject dumpInfos = PerfMonitorManager.getInstance().dumpInfos();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("is_main_process", ApmContext.isMainProcess());
                        jSONObject.put(CommonKey.KEY_BLOCK_DURATION, j3);
                        jSONObject.put("stack", evilMethodString);
                        jSONObject.put("stack_key", "1048574\n");
                        jSONObject.put("scene", "launchTrace");
                        jSONObject.put("cost_time", j3);
                        jSONObject.put("method_time", j3);
                        jSONObject.put("message", "launchTrace");
                        jSONObject.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_EVIL_METHOD);
                        JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson(true);
                        perfFiltersJson.put(CommonKey.KEY_CRASH_SECTION, ApmContext.getTimeRange(System.currentTimeMillis()));
                        perfFiltersJson.put("trace_type", "launchTrace");
                        perfFiltersJson.put("launchMode", String.valueOf(i));
                        perfFiltersJson.put("customLaunchMode", str);
                        jSONObject.put("custom", dumpInfos);
                        jSONObject.put("filters", perfFiltersJson);
                        CommonDataPipeline.getInstance().handle(new ExceptionLogData("drop_frame_stack", jSONObject));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
