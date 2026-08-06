package com.bytedance.apm6.hub.config;

import com.bytedance.apm.FluencyMonitorManager;
import com.bytedance.apm.config.FluencyConfig;
import com.bytedance.apm.config.FluencyConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FluencyConfigManager implements FluencyConfigService {
    private static final long DEFAULT_BLOCK_THRESHOLD = 2500;
    private static final long DEFAULT_DROP_THRESHOLD = 1000;
    private static final long DEFAULT_SERIOUS_BLOCK_THRESHOLD = 4000;
    private static final String PERF_ATRACE_TAG = "atrace_tag";
    private static final String PERF_ENABLE_UPLOAD = "enable_upload";
    private static final String PERF_KEY_SMOOTH = "smooth";
    private static final String PERF_SMOOTH_BLOCK_DUMP_STACK = "block_dump_stack_enable";
    private static final String PERF_SMOOTH_BLOCK_ENABLE_UPLOAD = "block_enable_upload";
    private static final String PERF_SMOOTH_BLOCK_MONITOR_MODE = "block_monitor_mode";
    private static final String PERF_SMOOTH_BLOCK_THRESHOLD = "block_threshold";
    private static final String PERF_SMOOTH_DROP_BLOCK_THRESHOLD_MS = "drop_threshold";
    private static final String PERF_SMOOTH_DROP_ENABLE_UPLOAD = "drop_enable_upload";
    private static final String PERF_SMOOTH_DROP_SLOW_METHOD_SWITCH = "drop_slow_method_switch";
    private static final String PERF_SMOOTH_ENABLE_GFX_MONITOR = "enable_gfx_monitor";
    private static final String PERF_SMOOTH_SCENE_ENABLE_UPLOAD = "scene_enable_upload";
    private static final String PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD = "serious_block_enable_upload";
    private static final String PERF_SMOOTH_SERIOUS_BLOCK_THRESHOLD = "serious_block_threshold";
    private static final String PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD = "slow_method_enable_upload";
    private static final String PERF_SMOOTH_STACK_SAMPLING = "enable_stack_sampling";
    private static final String PERF_TRACE_ENABLE = "enable_trace";
    private FluencyConfig config;

    public FluencyConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.FluencyConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                FluencyConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    @Override // com.bytedance.apm.config.FluencyConfigService
    public FluencyConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject parseData;
        if (jSONObject == null || (parseData = BasePerfConfigParser.parseData(jSONObject, "smooth")) == null) {
            return;
        }
        this.config = new FluencyConfig();
        this.config.setEnableStackSampling(parseData.optInt("enable_stack_sampling", 0) == 1);
        this.config.setEnableTrace(parseData.optInt("enable_trace", 0) == 1);
        this.config.setAtraceTag(parseData.optLong("atrace_tag", 0L));
        this.config.setBlockDumpStackEnable(parseData.optInt("block_dump_stack_enable", 1) == 1);
        this.config.setEnableGfxMonitor(parseData.optInt("enable_gfx_monitor", 0) == 1);
        this.config.setBlockMonitorMode(parseData.optInt("block_monitor_mode", 1001));
        this.config.setSeriousBlockEnableUpload(parseData.optInt("serious_block_enable_upload", 1) == 1);
        this.config.setSeriousBlockThreshold(parseData.optLong("serious_block_threshold", DEFAULT_SERIOUS_BLOCK_THRESHOLD));
        this.config.setSlowMethodEnableUpload(parseData.optInt("slow_method_enable_upload", 1) == 1);
        this.config.setDropEnableUpload(parseData.optInt("drop_enable_upload", 1) == 1);
        this.config.setFpsEnableUpload(parseData.optInt("enable_upload", 0) == 1);
        this.config.setBlockThreshold(parseData.optLong("block_threshold", 2500L));
        this.config.setSlowMethodDropThreshold(parseData.optLong("drop_threshold", 1000L));
        this.config.setBlockEnableUpload(parseData.optInt("block_enable_upload", 0) == 1);
        this.config.setDropSlowMethodSwitch(parseData.optBoolean("drop_slow_method_switch", true));
        this.config.setAllowScene(parseData.optJSONObject("scene_enable_upload"));
        FluencyMonitorManager.getInstance().updateConfig(getConfig());
    }
}
