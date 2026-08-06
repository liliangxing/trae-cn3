package com.bytedance.ies.bullet.service.monitor.deviceperf;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CpuMemoryPerfMetric.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005J\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0005J\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0011J$\u0010\u001e\u001a\u00020\u001f2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010 \u001a\u00020!J\u001e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0012J\u001e\u0010%\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0006R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/deviceperf/CpuMemoryPerfMetric;", "", "()V", "initCpuinfoMap", "", "", "", "getInitCpuinfoMap", "()Ljava/util/Map;", "setInitCpuinfoMap", "(Ljava/util/Map;)V", "isCanRecord", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setCanRecord", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "metricCpuMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "metricMemoryMap", "runningBulletStackInfo", "getRunningBulletStackInfo", "()Ljava/lang/String;", "setRunningBulletStackInfo", "(Ljava/lang/String;)V", "getCpu", "stepName", "getCpuMetricMap", "getMemory", "getMemoryMetricMap", "initRecordConfig", "", "canRecoed", "", "injectCpu", "sessionId", "cpuRate", "injectMemory", "memory", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CpuMemoryPerfMetric {
    public static final String BDX_MONITOR_CPU = "bdx_monitor_cpu";
    public static final String BDX_MONITOR_MEMORY = "bdx_monitor_memory";
    public static final String CONTAINER_INIT = "container_init";
    public static final String CONTAINER_LOAD = "container_load";
    public static final String DEVICE_TOTALMEM = "device_totalmem";
    public static final String FREQUENCY = "frequency";
    public static final String LYNXVIEW_FIRSTSCREEN = "lynxview_firstscreen";
    public static final String MEMORY_WARNING = "memory_warning";
    public static final int RECORD_INTERVAL_DEFAULT = 0;
    public static final String STACK_ON_MEMORY_WARNING = "stack_on_memory_warning";
    private static final String TAG = "CpuMemoryPerfMetric";
    public static final String USER_INTERACTIVE_KEY = "user_interactive_key";
    public static final String VIEW_CREATE_BEGIN = "view_create_begin";
    public static final String VIEW_CREATE_END = "view_create_end";
    public static final String VIEW_EXIT = "view_exit";
    public static final String VIEW_LOAD_CANCEL = "view_load_cancel";
    public static final String VIEW_LOAD_END = "view_load_end";
    public static final String VIEW_LOAD_FAIL = "view_load_fail";
    public static final String VIEW_PAGESTART = "view_page_start";
    private final ConcurrentHashMap<String, Double> metricCpuMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> metricMemoryMap = new ConcurrentHashMap<>();
    private AtomicBoolean isCanRecord = new AtomicBoolean(false);
    private Map<String, Long> initCpuinfoMap = new LinkedHashMap();
    private String runningBulletStackInfo = "";

    /* renamed from: isCanRecord, reason: from getter */
    public final AtomicBoolean getIsCanRecord() {
        return this.isCanRecord;
    }

    public final void setCanRecord(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isCanRecord = atomicBoolean;
    }

    public final Map<String, Long> getInitCpuinfoMap() {
        return this.initCpuinfoMap;
    }

    public final void setInitCpuinfoMap(Map<String, Long> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.initCpuinfoMap = map;
    }

    public final String getRunningBulletStackInfo() {
        return this.runningBulletStackInfo;
    }

    public final void setRunningBulletStackInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.runningBulletStackInfo = str;
    }

    public final void initRecordConfig(Map<String, Long> initCpuinfoMap, boolean canRecoed) {
        Intrinsics.checkNotNullParameter(initCpuinfoMap, "initCpuinfoMap");
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, "initRecordConfig", "initRecordConfig=" + canRecoed, TAG, null, 8, null);
        this.initCpuinfoMap = initCpuinfoMap;
        this.isCanRecord.set(canRecoed);
    }

    public final void injectCpu(String sessionId, String stepName, double cpuRate) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, sessionId, stepName + "  recordCpu cpurate: " + cpuRate, TAG, null, 8, null);
        this.metricCpuMap.put(stepName, Double.valueOf(cpuRate));
    }

    public final void injectMemory(String sessionId, String stepName, long memory) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, sessionId, stepName + "  recordMemroy memory: " + memory, TAG, null, 8, null);
        this.metricMemoryMap.put(stepName, Long.valueOf(memory));
    }

    public final ConcurrentHashMap<String, Double> getCpuMetricMap() {
        return this.metricCpuMap;
    }

    public final ConcurrentHashMap<String, Long> getMemoryMetricMap() {
        return this.metricMemoryMap;
    }

    public final double getCpu(String stepName) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        Double d = this.metricCpuMap.get(stepName);
        if (d == null) {
            return -1.0d;
        }
        return d.doubleValue();
    }

    public final long getMemory(String stepName) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        Long l = this.metricMemoryMap.get(stepName);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }
}
