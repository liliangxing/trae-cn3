package com.bytedance.apm6.cpu.collect;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.Pair;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuCacheItem;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuReportEvent extends PerfBaseEvent {
    private static final String FILTERS_BATTERY_CURRENT = "battery_current";
    private static final String FILTERS_BATTERY_LEVEL = "battery_level";
    private static final String FILTERS_BATTERY_THERMAL = "battery_thermal";
    private static final String FILTERS_CPU_HARDWARE = "cpu_hardware";
    private static final String FILTERS_IS_CHARGING = "is_charging";
    private static final String FILTERS_NETWORK_TYPE = "network_type";
    private static final String FILTERS_POWER_SAVE_MODE = "power_save_mode";
    private static final String FILTERS_THERMAL_STATUS = "thermal_status";
    private static final String FILTER_IS_AUTO_SAMPLE = "is_auto_sample";
    private static final String FILTER_IS_NORMAL_SAMPLE_STATE = "is_normal_sample_state";
    private static final String PERF_APP_MAX_STAT_SPEED = "app_max_stat_speed";
    private static final String PERF_APP_STAT_SPEED = "app_stat_speed";
    private static final String PERF_CPU_APP_MAX_USAGE_RATE = "app_max_usage_rate";
    private static final String PERF_CPU_APP_USAGE_RATE = "app_usage_rate";
    public static final String PERF_DATA_TYPE = "data_type";
    private static final String PERF_THREAD_CPU_USAGE = "thread_cpu_usage";
    private static final String SERVICE_NAME = "cpu";
    private static final String SERVICE_NAME_THREAD = "cpu_thread";
    public static final String VALUE_BACK = "back";
    public static final String VALUE_FRONT = "front";
    public static final String VALUE_MIX = "mix";
    private float batteryCurrent;
    private CpuCacheItem.CpuDataType dataType;
    private IAssistStat.CpuFactorTag factorTag;
    private boolean isAutoSample;
    private boolean isNormalSampleState;
    private double metricCpuSpeed;
    private double metricMaxCpuSpeed;
    private double metricMaxRate;
    private double metricRate;
    private String sceneString;
    private List<Pair<String, Double>> threadUsageList;

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType cpuDataType, String str, double d, double d2, double d3, double d4, IAssistStat.CpuFactorTag cpuFactorTag) {
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.dataType = cpuDataType;
        this.sceneString = str;
        this.metricRate = d;
        this.metricMaxRate = d2;
        this.metricCpuSpeed = d3;
        this.metricMaxCpuSpeed = d4;
        this.factorTag = cpuFactorTag;
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType cpuDataType, String str, List<Pair<String, Double>> list, IAssistStat.CpuFactorTag cpuFactorTag) {
        this.metricRate = -1.0d;
        this.metricMaxRate = -1.0d;
        this.metricCpuSpeed = -1.0d;
        this.metricMaxCpuSpeed = -1.0d;
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.threadUsageList = new ArrayList(list);
        this.dataType = cpuDataType;
        this.sceneString = str;
        this.factorTag = cpuFactorTag;
    }

    public void setIsAutoSample(boolean z) {
        this.isAutoSample = z;
    }

    public void setNormalSampleState(boolean z) {
        this.isNormalSampleState = z;
    }

    public void setBatteryCurrent(float f) {
        this.batteryCurrent = f;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return hasThreadUsageData() ? SERVICE_NAME_THREAD : "cpu";
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (hasThreadUsageData()) {
                for (Pair<String, Double> pair : this.threadUsageList) {
                    if (pair != null && pair.first != null && !pair.first.isEmpty() && pair.second != null && pair.second.doubleValue() != 0.0d) {
                        jSONObject.put(pair.first, pair.second);
                    }
                }
            } else {
                double d = this.metricRate;
                if (d > -1.0d && this.metricMaxRate > -1.0d) {
                    jSONObject.put("app_usage_rate", d);
                    jSONObject.put("app_max_usage_rate", this.metricMaxRate);
                }
                double d2 = this.metricCpuSpeed;
                if (d2 > -1.0d && this.metricMaxCpuSpeed > -1.0d) {
                    jSONObject.put("app_stat_speed", d2);
                    jSONObject.put("app_max_stat_speed", this.metricMaxCpuSpeed);
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            jSONObject.put("scene", this.sceneString);
            int i = C03401.f47x79a0b75b[this.dataType.ordinal()];
            if (i == 1) {
                jSONObject.put(PERF_DATA_TYPE, VALUE_MIX);
            } else if (i == 2) {
                jSONObject.put(PERF_DATA_TYPE, VALUE_BACK);
            } else if (i == 3) {
                jSONObject.put(PERF_DATA_TYPE, "front");
            }
            return jSONObject;
        } catch (Throwable th) {
            Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: com.bytedance.apm6.cpu.collect.CpuReportEvent$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static /* synthetic */ class C03401 {

        /* renamed from: $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType */
        static final /* synthetic */ int[] f47x79a0b75b;

        static {
            int[] iArr = new int[CpuCacheItem.CpuDataType.values().length];
            f47x79a0b75b = iArr;
            try {
                iArr[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47x79a0b75b[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47x79a0b75b[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        try {
            JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
            perfFiltersJson.put(FILTER_IS_AUTO_SAMPLE, this.isAutoSample);
            if (this.factorTag != null) {
                perfFiltersJson.put("network_type", NetworkUtils.getNetworkTypeFast(ApmContext.getContext()));
                perfFiltersJson.put(FILTERS_BATTERY_LEVEL, this.factorTag.batteryLevel);
                perfFiltersJson.put(FILTERS_CPU_HARDWARE, this.factorTag.cpuHardware);
                perfFiltersJson.put("is_charging", this.factorTag.isCharging);
                perfFiltersJson.put(FILTERS_POWER_SAVE_MODE, this.factorTag.powerSaveMode);
                perfFiltersJson.put(FILTERS_THERMAL_STATUS, this.factorTag.thermalStatus);
                perfFiltersJson.put(FILTERS_BATTERY_THERMAL, this.factorTag.batteryThermal);
                perfFiltersJson.put(FILTER_IS_NORMAL_SAMPLE_STATE, this.isNormalSampleState);
            }
            float f = this.batteryCurrent;
            if (f > 0.0f) {
                perfFiltersJson.put(FILTERS_BATTERY_CURRENT, f);
            }
            return perfFiltersJson;
        } catch (Throwable th) {
            Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
            return null;
        }
    }

    public boolean hasThreadUsageData() {
        List<Pair<String, Double>> list = this.threadUsageList;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
