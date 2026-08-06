package com.bytedance.apm.perf;

import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PerfConfigManager implements IConfigListener {
    private static final String TAG = "PerfConfigManager";
    private volatile JSONObject mAllowScene;
    private Map<String, String> mLogTypeToSwitch;
    private final Map<String, Boolean> mPerfAllowSwitch;
    private final Map<String, Boolean> mPerfSecondStageAllowSwitch;
    private List<String> mPerfServiceList;
    private List<String> mPerfSmoothTypeList;
    private List<String> mPerfStartTypeList;

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    private PerfConfigManager() {
        this.mPerfAllowSwitch = new ConcurrentHashMap();
        this.mPerfSecondStageAllowSwitch = new ConcurrentHashMap();
        this.mLogTypeToSwitch = new HashMap();
        LinkedList linkedList = new LinkedList();
        this.mPerfServiceList = linkedList;
        linkedList.addAll(Arrays.asList("battery", SlardarSettingsConsts.PERF_KEY_SMOOTH, "cpu", "disk", "memory", "thread", SlardarSettingsConsts.PERF_KEY_FD, "page_load", "page_load_trace", "start", "start_trace", "traffic", SlardarSettingsConsts.PERF_KEY_UI));
        ArrayList arrayList = new ArrayList();
        this.mPerfSmoothTypeList = arrayList;
        arrayList.add("enable_upload");
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_DROP_ENABLE_UPLOAD);
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD);
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD);
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD);
        LinkedList linkedList2 = new LinkedList();
        this.mPerfStartTypeList = linkedList2;
        linkedList2.add(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT);
        this.mLogTypeToSwitch.put("enable_upload", "fps");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_DROP_ENABLE_UPLOAD, "fps_drop");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, "block_monitor");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD, "drop_frame_stack");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD, "serious_block_monitor");
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
    }

    public static PerfConfigManager getInstance() {
        return Holder.sInstance;
    }

    /* loaded from: classes3.dex */
    private static class Holder {
        private static final PerfConfigManager sInstance = new PerfConfigManager();

        private Holder() {
        }
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        refreshPerformanceModule(jSONObject);
    }

    private void refreshPerformanceModule(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("performance_modules");
        if (optJSONObject == null) {
            return;
        }
        for (String str : this.mPerfServiceList) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
            if (SlardarSettingsConsts.PERF_KEY_SMOOTH.equals(str)) {
                refreshSmoothConfig(optJSONObject2);
            } else {
                if ("memory".equals(str)) {
                    refreshMemoryConfig(optJSONObject2);
                }
                if ("battery".equals(str)) {
                    refreshBatteryConfig(optJSONObject2);
                }
                if ("cpu".equals(str)) {
                    refreshCpuConfig(optJSONObject2);
                }
                if ("start_trace".equals(str)) {
                    refreshStartTraceConfig(optJSONObject2);
                }
                if (optJSONObject2 != null && optJSONObject2.optInt("enable_upload", 0) == 1) {
                    this.mPerfAllowSwitch.put(str, true);
                } else {
                    this.mPerfAllowSwitch.put(str, false);
                }
            }
        }
        this.mAllowScene = JsonUtils.optJSONObject(optJSONObject, SlardarSettingsConsts.PERF_KEY_SMOOTH, SlardarSettingsConsts.PERF_SMOOTH_SCENE_ENABLE_UPLOAD);
    }

    private void refreshStartTraceConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : this.mPerfStartTypeList) {
            try {
                this.mPerfSecondStageAllowSwitch.put(str, Boolean.valueOf(jSONObject.optInt(str, 0) == 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshSmoothConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : this.mPerfSmoothTypeList) {
            try {
                this.mPerfSecondStageAllowSwitch.put(this.mLogTypeToSwitch.get(str), Boolean.valueOf(jSONObject.optInt(str, 0) == 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshMemoryConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mPerfSecondStageAllowSwitch.put("memory_object_monitor", Boolean.valueOf(jSONObject.optInt("memory_object_monitor", 0) == 1));
    }

    private void refreshBatteryConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mPerfSecondStageAllowSwitch.put(CommonServiceName.MONITOR_TYPE_TEMPERATURE, Boolean.valueOf(jSONObject.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD, 0) == 1));
        this.mPerfSecondStageAllowSwitch.put("battery_trace", Boolean.valueOf(jSONObject.optInt(SlardarSettingsConsts.PERF_BATTERY_EXCEPTION, 0) == 1));
    }

    private void refreshCpuConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mPerfSecondStageAllowSwitch.put("cpu_trace", Boolean.valueOf(jSONObject.optInt("exception", 0) == 1));
    }

    public boolean getPerfAllowSwitch(String str) {
        Boolean bool = this.mPerfAllowSwitch.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean getPerfFpsAllowSwitch(String str, String str2) {
        Boolean bool = this.mPerfSecondStageAllowSwitch.get(str);
        return (bool != null && bool.booleanValue()) || (this.mAllowScene != null && this.mAllowScene.optInt(str2) == 1);
    }

    public boolean getPerfSecondStageSwitch(String str) {
        Boolean bool = this.mPerfSecondStageAllowSwitch.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
