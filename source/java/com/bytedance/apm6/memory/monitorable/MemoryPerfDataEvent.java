package com.bytedance.apm6.memory.monitorable;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.bean.MemoryCollectInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.util.JsonUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MemoryPerfDataEvent extends PerfBaseEvent {
    private static final String KEY_BLOCK_GC_COUNT = "block_gc_count";
    private static final String KEY_BLOCK_GC_TIME = "block_gc_time";
    private static final String KEY_GC_COUNT = "gc_count";
    private static final String KEY_GC_TIME = "gc_time";
    private static final String KEY_REACH_TOP_JAVA = "reach_top_java";
    private static final String PERF_MEM_DALVIK_PSS_BACKGROUND = "dalvik_pss_background";
    private static final String PERF_MEM_DALVIK_PSS_FOREGROUND = "dalvik_pss_foreground";
    private static final String PERF_MEM_GRAPHICS_MEM_BACKGROUND = "graphics_background";
    private static final String PERF_MEM_GRAPHICS_MEM_FOREGROUND = "graphics_foreground";
    private static final String PERF_MEM_NATIVE_PSS_BACKGROUND = "native_pss_background";
    private static final String PERF_MEM_NATIVE_PSS_FOREGROUND = "native_pss_foreground";
    private static final String PERF_MEM_TOTAL_JAVA_BACKGROUND = "java_heap_background";
    private static final String PERF_MEM_TOTAL_JAVA_BACKGROUND_USED_RATE = "java_heap_background_used_rate";
    private static final String PERF_MEM_TOTAL_JAVA_FOREGROUND = "java_heap_foreground";
    private static final String PERF_MEM_TOTAL_JAVA_FOREGROUND_USED_RATE = "java_heap_foreground_used_rate";
    private static final String PERF_MEM_TOTAL_PSS_BACKGROUND = "total_pss_background";
    private static final String PERF_MEM_TOTAL_PSS_FOREGROUND = "total_pss_foreground";
    private static final String PERF_MEM_VM_SIZE_BACKGROUND = "vm_size_background";
    private static final String PERF_MEM_VM_SIZE_FOREGROUND = "vm_size_foreground";
    private static final String SERVICE_NAME = "memory";
    private boolean background;
    private long blockingGcCount;
    private long blockingGcTime;
    private long dalvikUsedSize;
    private long gcCount;
    private long gcTime;
    private long graphics;
    private boolean isMemoryReachTop;
    private boolean isRealTimeMemEnable;
    private long javaUsedMemory;
    private double javaUsedMemoryRate;
    private Map<Object, Object> mmapInfo;
    private long nativePss;
    private long totalPss;
    private long vmSize;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "memory";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public MemoryPerfDataEvent(long j, long j2, long j3, long j4, boolean z, long j5, long j6, long j7, long j8, long j9, long j10, double d, boolean z2, boolean z3) {
        this.gcCount = j;
        this.gcTime = j2;
        this.blockingGcCount = j3;
        this.blockingGcTime = j4;
        this.background = z;
        this.nativePss = j5;
        this.totalPss = j6;
        this.javaUsedMemory = j7;
        this.dalvikUsedSize = j8;
        this.graphics = j9;
        this.vmSize = j10;
        this.javaUsedMemoryRate = d;
        this.isMemoryReachTop = z2;
        this.isRealTimeMemEnable = z3;
    }

    public void setMmapInfo(Map<Object, Object> map) {
        this.mmapInfo = map;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gc_count", this.gcCount);
            jSONObject.put("gc_time", this.gcTime);
            jSONObject.put("block_gc_count", this.blockingGcCount);
            jSONObject.put("block_gc_time", this.blockingGcTime);
            if (this.background) {
                jSONObject.put("dalvik_pss_background", this.dalvikUsedSize);
                jSONObject.put("native_pss_background", this.nativePss);
                jSONObject.put("total_pss_background", this.totalPss);
                jSONObject.put("java_heap_background", this.javaUsedMemory);
                jSONObject.put("java_heap_background_used_rate", this.javaUsedMemoryRate);
                jSONObject.put("vm_size_background", this.vmSize);
                jSONObject.put("graphics_background", this.graphics);
            } else {
                jSONObject.put("dalvik_pss_foreground", this.dalvikUsedSize);
                jSONObject.put("native_pss_foreground", this.nativePss);
                jSONObject.put("total_pss_foreground", this.totalPss);
                jSONObject.put("java_heap_foreground", this.javaUsedMemory);
                jSONObject.put("java_heap_foreground_used_rate", this.javaUsedMemoryRate);
                jSONObject.put("vm_size_foreground", this.vmSize);
                jSONObject.put("graphics_foreground", this.graphics);
            }
            if (this.isMemoryReachTop) {
                jSONObject.put("reach_top_java", 1);
            }
            calMapsInfo(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void calMapsInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Map<Object, Object> map = this.mmapInfo;
            if (map == null) {
                return;
            }
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), Long.parseLong((String) entry.getValue()));
            }
        } catch (Exception unused) {
        }
    }

    public double getJavaUsedMemoryRate() {
        return this.javaUsedMemoryRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", PerfFilterManager.getInstance().getSceneString());
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            jSONObject.put(CommonKey.KEY_IS_FRONT, !this.background);
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean isBackground() {
        return this.background;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
        if (this.isRealTimeMemEnable) {
            try {
                JsonUtils.copyJson2(perfFiltersJson, PerfFilterManager.getInstance().getRealTimeMemInfo());
            } catch (Exception unused) {
            }
        }
        IDeviceInfoService iDeviceInfoService = (IDeviceInfoService) ServiceManager.getService(IDeviceInfoService.class);
        if (iDeviceInfoService != null) {
            try {
                JsonUtils.copyJson2(perfFiltersJson, iDeviceInfoService.getDeviceInfo());
            } catch (Exception unused2) {
            }
        }
        return perfFiltersJson;
    }

    public MemoryCollectInfo getMemoryCollectInfo() {
        MemoryCollectInfo memoryCollectInfo = new MemoryCollectInfo();
        memoryCollectInfo.gcCount = this.gcCount;
        memoryCollectInfo.gcTime = this.gcTime;
        memoryCollectInfo.blockingGcCount = this.blockingGcCount;
        memoryCollectInfo.blockingGcTime = this.blockingGcTime;
        memoryCollectInfo.background = this.background;
        memoryCollectInfo.nativePss = this.nativePss;
        memoryCollectInfo.totalPss = this.totalPss;
        memoryCollectInfo.javaUsedMemory = this.javaUsedMemory;
        memoryCollectInfo.dalvikUsedSize = this.dalvikUsedSize;
        memoryCollectInfo.graphics = this.graphics;
        memoryCollectInfo.vmSize = this.vmSize;
        memoryCollectInfo.isMemoryReachTop = this.isMemoryReachTop;
        return memoryCollectInfo;
    }

    public String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.gcCount + ", gcTime=" + this.gcTime + ", blockingGcCount=" + this.blockingGcCount + ", blockingGcTime=" + this.blockingGcTime + ", background=" + this.background + ", nativePss=" + this.nativePss + ", totalPss=" + this.totalPss + ", javaUsedMemory=" + this.javaUsedMemory + ", dalvikUsedSize=" + this.dalvikUsedSize + ", graphics=" + this.graphics + ", vmSize=" + this.vmSize + ", javaUsedMemoryRate=" + this.javaUsedMemoryRate + ", isMemoryReachTop=" + this.isMemoryReachTop + '}';
    }
}
