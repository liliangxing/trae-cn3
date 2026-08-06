package com.bytedance.ies.bullet.service.monitor.deviceperf;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import bolts.Continuation;
import bolts.Task;
import com.bytedance.apm.perf.entity.CpuInfo;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.iesgurd.exception.BytePatchException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: CpuMemoryHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001cH\u0002J\u001b\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0000¢\u0006\u0002\b\u001eJ%\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0004J\u0016\u0010*\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J \u0010*\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0017H\u0002J\u0006\u0010/\u001a\u00020%J\u0016\u00100\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-J\u001a\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/deviceperf/CpuMemoryHelper;", "", "()V", "CPU_RATE", "", "CPU_SPEED", "KB", "", "MEM_DEVICE_AVAIL", "MEM_DEVICE_THRESHOLD", CpuMemoryHelper.MEM_DEVICE_TOTAL, "MEM_JAVA_FREE", "MEM_JAVA_TOTAL", "MEM_JAVA_USED", "TAG", "memorySizeOnWaring", "", "getMemorySizeOnWaring", "()J", "setMemorySizeOnWaring", "(J)V", "recordThreadPoolMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ScheduledExecutorService;", "getCpuRate", "", "", "mutableMap", "", "getCpuRateUseAPi", "getCpuRateUseAPi$anniex_release", "getDeviceTotalMemory", "context", "Landroid/content/Context;", "getDeviceTotalMemory$anniex_release", "getMemory", "initRecordConfig", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "recordActivityInfo", "sessionId", "recordCpuMemory", "stepName", "json", "Lorg/json/JSONObject;", "scheduledExecutorService", "release", "startCycleRecord", "stopCycleRecord", "", "allStop", "userInterActiveKey", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CpuMemoryHelper {
    public static final String CPU_RATE = "cpu_rate";
    public static final String CPU_SPEED = "cpu_speed";
    public static final int KB = 1024;
    public static final String MEM_DEVICE_AVAIL = "mem_device_avail";
    public static final String MEM_DEVICE_THRESHOLD = "mem_device_threshold";
    public static final String MEM_DEVICE_TOTAL = "MEM_DEVICE_TOTAL";
    public static final String MEM_JAVA_FREE = "mem_java_free";
    public static final String MEM_JAVA_TOTAL = "mem_java_total";
    public static final String MEM_JAVA_USED = "mem_java_used";
    private static final String TAG = "CpuMemoryHelper";
    public static final CpuMemoryHelper INSTANCE = new CpuMemoryHelper();
    private static long memorySizeOnWaring = -1;
    private static final ConcurrentHashMap<String, ScheduledExecutorService> recordThreadPoolMap = new ConcurrentHashMap<>();

    private CpuMemoryHelper() {
    }

    public final long getMemorySizeOnWaring() {
        return memorySizeOnWaring;
    }

    public final void setMemorySizeOnWaring(long j) {
        memorySizeOnWaring = j;
    }

    public final void release() {
        memorySizeOnWaring = -1L;
    }

    public final void initRecordConfig(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        if (bulletContext.getUseCardMode()) {
            Log.d(TAG, "useCardMode is true. Ignore initRecordConfig");
            return;
        }
        boolean areEqual = Intrinsics.areEqual(new BooleanParam(bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_ENABLE_PERF_COLLECTION, false).getValue(), true);
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, "initRecordConfig", "initRecordConfig=" + areEqual, TAG, null, 8, null);
        if (areEqual) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("initTime", Long.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("appCpuStat", Long.valueOf(CommonMonitorUtil.getAppCPUTime()));
            linkedHashMap.put("totalCpuStat", Long.valueOf(CommonMonitorUtil.getTotalCPUTimeByTimeInStat()));
            bulletContext.getContainerContext().setCpuMemoryPerfMetric(new CpuMemoryPerfMetric());
            Object cpuMemoryPerfMetric = bulletContext.getContainerContext().getCpuMemoryPerfMetric();
            CpuMemoryPerfMetric cpuMemoryPerfMetric2 = cpuMemoryPerfMetric instanceof CpuMemoryPerfMetric ? (CpuMemoryPerfMetric) cpuMemoryPerfMetric : null;
            if (cpuMemoryPerfMetric2 != null) {
                cpuMemoryPerfMetric2.initRecordConfig(linkedHashMap, areEqual);
            }
        }
    }

    public final Map<String, Double> getCpuRateUseAPi$anniex_release() {
        CpuInfo currentCpuRate = ApmCpuManager.getInstance().getCurrentCpuRate();
        HashMap hashMap = new HashMap();
        hashMap.put(CPU_RATE, Double.valueOf(currentCpuRate.cpuAppRate));
        hashMap.put(CPU_SPEED, Double.valueOf(currentCpuRate.cpuAppSpeed));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Double> getCpuRate(Map<String, Long> mutableMap) {
        double d;
        Long l = mutableMap.get("initTime");
        Long l2 = mutableMap.get("appCpuStat");
        Long l3 = mutableMap.get("totalCpuStat");
        long appCPUTime = CommonMonitorUtil.getAppCPUTime();
        long totalCPUTimeByTimeInStat = CommonMonitorUtil.getTotalCPUTimeByTimeInStat();
        if (l == null || l.longValue() <= 0 || l2 == null || l2.longValue() <= 0 || l3 == null || l3.longValue() <= 0) {
            d = -1.0d;
        } else {
            r6 = totalCPUTimeByTimeInStat - l3.longValue() > 0 ? (appCPUTime - l2.longValue()) / (totalCPUTimeByTimeInStat - l3.longValue()) : -1.0d;
            d = (((appCPUTime - l2.longValue()) * BytePatchException.ErrorCode.paramsError) / (System.currentTimeMillis() - l.longValue())) / CommonMonitorUtil.getScClkTck(100L);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CPU_RATE, Double.valueOf(r6));
        hashMap.put(CPU_SPEED, Double.valueOf(d));
        return hashMap;
    }

    public final Map<String, Long> getMemory() {
        HashMap hashMap = new HashMap();
        long j = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        HashMap hashMap2 = hashMap;
        long j2 = 1024;
        hashMap2.put(MEM_JAVA_TOTAL, Long.valueOf(j / j2));
        hashMap2.put(MEM_JAVA_FREE, Long.valueOf(freeMemory / j2));
        hashMap2.put(MEM_JAVA_USED, Long.valueOf((j - freeMemory) / j2));
        return hashMap2;
    }

    public final Map<String, Long> getDeviceTotalMemory$anniex_release(Context context) {
        Object systemService = context != null ? context.getSystemService("activity") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        HashMap hashMap = new HashMap();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        HashMap hashMap2 = hashMap;
        long j = 1024;
        hashMap2.put(MEM_DEVICE_TOTAL, Long.valueOf(memoryInfo.totalMem / j));
        hashMap2.put(MEM_DEVICE_THRESHOLD, Long.valueOf(memoryInfo.threshold / j));
        hashMap2.put(MEM_DEVICE_AVAIL, Long.valueOf(memoryInfo.availMem / j));
        return hashMap2;
    }

    public final void startCycleRecord(String sessionId, JSONObject json) {
        AtomicBoolean isCanRecord;
        BulletContainerContext containerContext;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(json, "json");
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
        Object cpuMemoryPerfMetric = (context == null || (containerContext = context.getContainerContext()) == null) ? null : containerContext.getCpuMemoryPerfMetric();
        CpuMemoryPerfMetric cpuMemoryPerfMetric2 = cpuMemoryPerfMetric instanceof CpuMemoryPerfMetric ? (CpuMemoryPerfMetric) cpuMemoryPerfMetric : null;
        boolean z = false;
        if (cpuMemoryPerfMetric2 != null && (isCanRecord = cpuMemoryPerfMetric2.getIsCanRecord()) != null && isCanRecord.get()) {
            z = true;
        }
        if (z) {
            String string = json.getString(CpuMemoryPerfMetric.USER_INTERACTIVE_KEY);
            if (json.getBoolean("once")) {
                Intrinsics.checkNotNullExpressionValue(string, "userInteractiveKey");
                recordCpuMemory(sessionId, string);
                return;
            }
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            if (newSingleThreadScheduledExecutor != null) {
                ConcurrentHashMap<String, ScheduledExecutorService> concurrentHashMap = recordThreadPoolMap;
                Intrinsics.checkNotNullExpressionValue(string, "userInteractiveKey");
                concurrentHashMap.put(string, newSingleThreadScheduledExecutor);
                recordCpuMemory(sessionId, json, newSingleThreadScheduledExecutor);
            }
        }
    }

    public static /* synthetic */ boolean stopCycleRecord$default(CpuMemoryHelper cpuMemoryHelper, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        return cpuMemoryHelper.stopCycleRecord(z, str);
    }

    public final boolean stopCycleRecord(boolean allStop, String userInterActiveKey) {
        ScheduledExecutorService scheduledExecutorService;
        Intrinsics.checkNotNullParameter(userInterActiveKey, "userInterActiveKey");
        boolean z = false;
        if (allStop) {
            for (String str : recordThreadPoolMap.keySet()) {
                ConcurrentHashMap<String, ScheduledExecutorService> concurrentHashMap = recordThreadPoolMap;
                ScheduledExecutorService scheduledExecutorService2 = concurrentHashMap.get(userInterActiveKey);
                if (!(scheduledExecutorService2 != null && scheduledExecutorService2.isShutdown()) && (scheduledExecutorService = concurrentHashMap.get(str)) != null) {
                    scheduledExecutorService.shutdownNow();
                }
            }
            recordThreadPoolMap.clear();
            return true;
        }
        ConcurrentHashMap<String, ScheduledExecutorService> concurrentHashMap2 = recordThreadPoolMap;
        if (concurrentHashMap2.get(userInterActiveKey) == null) {
            return false;
        }
        ScheduledExecutorService scheduledExecutorService3 = concurrentHashMap2.get(userInterActiveKey);
        if (scheduledExecutorService3 != null && scheduledExecutorService3.isShutdown()) {
            z = true;
        }
        if (!z) {
            ScheduledExecutorService scheduledExecutorService4 = concurrentHashMap2.get(userInterActiveKey);
            if (scheduledExecutorService4 != null) {
                scheduledExecutorService4.shutdownNow();
            }
            concurrentHashMap2.remove(userInterActiveKey);
        }
        return true;
    }

    public final void recordCpuMemory(final String sessionId, final String stepName) {
        BulletContainerContext containerContext;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        final BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
        if (context != null && context.getUseCardMode()) {
            Log.d(TAG, "useCodeMode is true. Ignore recordCpuMemory");
            return;
        }
        Object cpuMemoryPerfMetric = (context == null || (containerContext = context.getContainerContext()) == null) ? null : containerContext.getCpuMemoryPerfMetric();
        final CpuMemoryPerfMetric cpuMemoryPerfMetric2 = cpuMemoryPerfMetric instanceof CpuMemoryPerfMetric ? (CpuMemoryPerfMetric) cpuMemoryPerfMetric : null;
        if (cpuMemoryPerfMetric2 != null) {
            AtomicBoolean isCanRecord = cpuMemoryPerfMetric2.getIsCanRecord();
            if ((isCanRecord == null || isCanRecord.get()) ? false : true) {
                return;
            }
            long j = memorySizeOnWaring;
            if (j != -1) {
                cpuMemoryPerfMetric2.injectMemory(sessionId, CpuMemoryPerfMetric.MEMORY_WARNING, j);
            }
            if (Intrinsics.areEqual(stepName, CpuMemoryPerfMetric.VIEW_LOAD_CANCEL)) {
                Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryHelper$recordCpuMemory$1
                    @Override // java.util.concurrent.Callable
                    public final Unit call() {
                        Double d;
                        Long l;
                        Map<String, Long> memory = CpuMemoryHelper.INSTANCE.getMemory();
                        if (memory != null && (l = memory.get(CpuMemoryHelper.MEM_JAVA_USED)) != null) {
                            CpuMemoryPerfMetric cpuMemoryPerfMetric3 = CpuMemoryPerfMetric.this;
                            String str = sessionId;
                            String str2 = stepName;
                            long longValue = l.longValue();
                            if (cpuMemoryPerfMetric3 != null) {
                                cpuMemoryPerfMetric3.injectMemory(str, str2, longValue);
                            }
                        }
                        Map<String, Double> cpuRateUseAPi$anniex_release = CpuMemoryHelper.INSTANCE.getCpuRateUseAPi$anniex_release();
                        if (cpuRateUseAPi$anniex_release != null && (d = cpuRateUseAPi$anniex_release.get(CpuMemoryHelper.CPU_RATE)) != null) {
                            CpuMemoryPerfMetric cpuMemoryPerfMetric4 = CpuMemoryPerfMetric.this;
                            String str3 = sessionId;
                            String str4 = stepName;
                            double doubleValue = d.doubleValue();
                            if (cpuMemoryPerfMetric4 != null) {
                                cpuMemoryPerfMetric4.injectCpu(str3, str4, doubleValue);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }).onSuccess(new Continuation() { // from class: com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryHelper$recordCpuMemory$2
                    public /* bridge */ /* synthetic */ Object then(Task task) {
                        m560then((Task<Unit>) task);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: then, reason: collision with other method in class */
                    public final void m560then(Task<Unit> task) {
                        AbsBulletMonitorCallback monitorCallback;
                        BulletContext bulletContext = BulletContext.this;
                        if (bulletContext == null || (monitorCallback = bulletContext.getMonitorCallback()) == null) {
                            return;
                        }
                        monitorCallback.onCpuMemoryReport();
                    }
                });
            } else {
                Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryHelper$recordCpuMemory$3
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        Map cpuRate;
                        Map<String, Long> deviceTotalMemory$anniex_release;
                        Long l;
                        Double d;
                        Long l2;
                        Map<String, Long> memory = CpuMemoryHelper.INSTANCE.getMemory();
                        if (memory != null && (l2 = memory.get(CpuMemoryHelper.MEM_JAVA_USED)) != null) {
                            CpuMemoryPerfMetric cpuMemoryPerfMetric3 = CpuMemoryPerfMetric.this;
                            String str = sessionId;
                            String str2 = stepName;
                            long longValue = l2.longValue();
                            if (cpuMemoryPerfMetric3 != null) {
                                cpuMemoryPerfMetric3.injectMemory(str, str2, longValue);
                            }
                        }
                        CpuMemoryHelper cpuMemoryHelper = CpuMemoryHelper.INSTANCE;
                        CpuMemoryPerfMetric cpuMemoryPerfMetric4 = CpuMemoryPerfMetric.this;
                        Map<String, Long> initCpuinfoMap = cpuMemoryPerfMetric4 != null ? cpuMemoryPerfMetric4.getInitCpuinfoMap() : null;
                        Intrinsics.checkNotNull(initCpuinfoMap);
                        cpuRate = cpuMemoryHelper.getCpuRate(initCpuinfoMap);
                        if (cpuRate != null && (d = (Double) cpuRate.get(CpuMemoryHelper.CPU_RATE)) != null) {
                            CpuMemoryPerfMetric.this.injectCpu(sessionId, stepName, d.doubleValue());
                        }
                        if (!Intrinsics.areEqual(stepName, CpuMemoryPerfMetric.VIEW_PAGESTART) || (deviceTotalMemory$anniex_release = CpuMemoryHelper.INSTANCE.getDeviceTotalMemory$anniex_release(BulletEnv.INSTANCE.getInstance().getApplication())) == null || (l = deviceTotalMemory$anniex_release.get(CpuMemoryHelper.MEM_DEVICE_TOTAL)) == null) {
                            return;
                        }
                        CpuMemoryPerfMetric.this.injectMemory(sessionId, CpuMemoryPerfMetric.DEVICE_TOTALMEM, l.longValue());
                    }
                });
            }
        }
    }

    private final void recordCpuMemory(final String sessionId, JSONObject json, ScheduledExecutorService scheduledExecutorService) {
        Number number;
        BulletSettings provideBulletSettings;
        BulletContainerContext containerContext;
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
        Object cpuMemoryPerfMetric = (context == null || (containerContext = context.getContainerContext()) == null) ? null : containerContext.getCpuMemoryPerfMetric();
        final CpuMemoryPerfMetric cpuMemoryPerfMetric2 = cpuMemoryPerfMetric instanceof CpuMemoryPerfMetric ? (CpuMemoryPerfMetric) cpuMemoryPerfMetric : null;
        if (cpuMemoryPerfMetric2 != null) {
            AtomicBoolean isCanRecord = cpuMemoryPerfMetric2.getIsCanRecord();
            if ((isCanRecord == null || isCanRecord.get()) ? false : true) {
                return;
            }
            long j = memorySizeOnWaring;
            if (j != -1) {
                cpuMemoryPerfMetric2.injectMemory(sessionId, CpuMemoryPerfMetric.MEMORY_WARNING, j);
            }
            if (json.opt(CpuMemoryPerfMetric.FREQUENCY) != null) {
                Object opt = json.opt(CpuMemoryPerfMetric.FREQUENCY);
                Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type kotlin.Number");
                number = (Number) opt;
            } else {
                ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || (number = provideBulletSettings.getCpuMemRecordFrequency()) == null) {
                    number = (Number) 0;
                }
            }
            if (Intrinsics.areEqual(number, 0)) {
                return;
            }
            final String optString = json.optString(CpuMemoryPerfMetric.USER_INTERACTIVE_KEY);
            final Ref.IntRef intRef = new Ref.IntRef();
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryHelper$recordCpuMemory$4
                @Override // java.lang.Runnable
                public final void run() {
                    Double d;
                    Long l;
                    Map<String, Long> memory = CpuMemoryHelper.INSTANCE.getMemory();
                    if (memory != null && (l = memory.get(CpuMemoryHelper.MEM_JAVA_USED)) != null) {
                        CpuMemoryPerfMetric cpuMemoryPerfMetric3 = cpuMemoryPerfMetric2;
                        String str = sessionId;
                        String str2 = optString;
                        Ref.IntRef intRef2 = intRef;
                        long longValue = l.longValue();
                        if (cpuMemoryPerfMetric3 != null) {
                            cpuMemoryPerfMetric3.injectMemory(str, str2 + '_' + intRef2.element, longValue);
                        }
                    }
                    Map<String, Double> cpuRateUseAPi$anniex_release = CpuMemoryHelper.INSTANCE.getCpuRateUseAPi$anniex_release();
                    if (cpuRateUseAPi$anniex_release != null && (d = cpuRateUseAPi$anniex_release.get(CpuMemoryHelper.CPU_RATE)) != null) {
                        CpuMemoryPerfMetric cpuMemoryPerfMetric4 = cpuMemoryPerfMetric2;
                        String str3 = sessionId;
                        String str4 = optString;
                        Ref.IntRef intRef3 = intRef;
                        double doubleValue = d.doubleValue();
                        if (cpuMemoryPerfMetric4 != null) {
                            cpuMemoryPerfMetric4.injectCpu(str3, str4 + '_' + intRef3.element, doubleValue);
                        }
                    }
                    intRef.element++;
                }
            }, number.longValue(), number.longValue(), TimeUnit.SECONDS);
        }
    }

    public final void recordActivityInfo(String sessionId) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        BulletContainerContext containerContext;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
        Object cpuMemoryPerfMetric = (context == null || (containerContext = context.getContainerContext()) == null) ? null : containerContext.getCpuMemoryPerfMetric();
        CpuMemoryPerfMetric cpuMemoryPerfMetric2 = cpuMemoryPerfMetric instanceof CpuMemoryPerfMetric ? (CpuMemoryPerfMetric) cpuMemoryPerfMetric : null;
        if (cpuMemoryPerfMetric2 != null) {
            AtomicBoolean isCanRecord = cpuMemoryPerfMetric2.getIsCanRecord();
            if ((isCanRecord == null || isCanRecord.get()) ? false : true) {
                return;
            }
            Application application = BulletEnv.INSTANCE.getInstance().getApplication();
            Object systemService = application != null ? application.getSystemService("activity") : null;
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            try {
                runningTaskInfo = ((ActivityManager) systemService).getRunningTasks(1).get(0);
            } catch (Exception e) {
                BulletLogger.INSTANCE.printReject(e, "recordActivityInfo exception", TAG);
                runningTaskInfo = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ComponentName componentName = runningTaskInfo != null ? runningTaskInfo.baseActivity : null;
            ComponentName componentName2 = runningTaskInfo != null ? runningTaskInfo.topActivity : null;
            StringBuilder sb = new StringBuilder();
            sb.append("time:" + currentTimeMillis + StringListParam.SPLIT_DELIMITER).append("Running TaskInfo:topActivity=" + (componentName2 != null ? componentName2.toShortString() : null) + ",baseActivity=" + (componentName != null ? componentName.toShortString() : null) + StringListParam.SPLIT_DELIMITER);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            cpuMemoryPerfMetric2.setRunningBulletStackInfo(sb2);
        }
    }
}
