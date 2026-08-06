package com.bytedance.apm6.hub.config;

import com.bytedance.apm.util.ParseUtils;
import com.bytedance.apm6.disk.Constants;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DiskConfigManager implements DiskConfigService {
    private static final int DEFAULT_EXCEPTION_DIR_COUNT = 50;
    private static final int DEFAULT_FILE_SIZE = 100;
    private static final int DEFAULT_OUTDATED_COUNT = 50;
    private static final int DEFAULT_TOP_FILE_COUNT = 20;
    private DiskConfig config;

    public DiskConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.DiskConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                DiskConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    @Override // com.bytedance.apm6.disk.config.DiskConfigService
    public DiskConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("disk")) == null) {
            return;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "parseConfig:" + optJSONObject);
        }
        DiskConfig diskConfig = new DiskConfig();
        diskConfig.setSample(optJSONObject.optInt("enable_upload", 0) == 1);
        if (optJSONObject.optInt("dump_threshold") > 0) {
            diskConfig.setDiskThresholdBytes(optJSONObject.optInt("dump_threshold") * 1024 * 1024);
        }
        if (optJSONObject.optInt("abnormal_folder_size") > 0) {
            diskConfig.setFolderThresholdBytes(optJSONObject.optInt("abnormal_folder_size") * 1024 * 1024);
        }
        diskConfig.setFileThresholdBytes(optJSONObject.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FILE_SIZE, 100) * 1024);
        if (optJSONObject.optInt("dump_top_count") > 0) {
            diskConfig.setReportMaxCount(optJSONObject.optInt("dump_top_count"));
        }
        diskConfig.setReportMaxOutdatedCount(optJSONObject.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_OUTDATED_COUNT, 50));
        diskConfig.setReportMaxTopCount(optJSONObject.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_FILE_COUNT, 20));
        diskConfig.setReportExceptionDirMaxCount(optJSONObject.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_EXCEPTION_DIR_COUNT, 50));
        if (optJSONObject.optInt("outdated_days") > 0) {
            diskConfig.setOutdatedIntervalMs(optJSONObject.optInt("outdated_days") * 86400000);
        }
        diskConfig.setCustomRelativePaths(ParseUtils.parseMapList(optJSONObject, "disk_customed_paths"));
        diskConfig.setIgnoredRelativePaths(ParseUtils.parseList(optJSONObject, "ignored_relative_paths"));
        diskConfig.setComplianceRelativePaths(ParseUtils.parseList(optJSONObject, "compliance_relative_paths"));
        this.config = diskConfig;
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "parseConfig:" + optJSONObject);
        }
        DiskCollector.getInstance().updateConfig(getConfig());
    }
}
