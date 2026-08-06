package com.bytedance.crash.config;

import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.util.NpthDiskMonitor;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InnerAppMonitorConfigService extends AppMonitorConfigService {
    public InnerAppMonitorConfigService(CrashListener crashListener) {
        super(crashListener);
    }

    @Override // com.bytedance.crash.monitor.EventConfigService
    protected ConfigManager createConfigManager() {
        return new InnerConfigManager(this.monitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.crash.monitor.EventConfigService
    public void parseEventConfig(JSONObject jSONObject) {
        super.parseEventConfig(jSONObject);
        if (this.eventConfig != null) {
            NpthDiskMonitor.getInstance().setConfig(this.eventConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.crash.monitor.EventConfigService
    public void parseEnsureConfig(JSONObject jSONObject) {
        if (BytestConfig.isEnsureNoLimit()) {
            this.ensureConfig = new EnsureConfig(true);
        } else {
            super.parseEnsureConfig(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.crash.monitor.AppMonitorConfigService
    public void parseUploadLimits(JSONObject jSONObject) {
        super.parseUploadLimits(jSONObject);
    }
}
