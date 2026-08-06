package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.HWReceiverCrashOptimizer;

/* loaded from: classes4.dex */
public class HWReceiverCrashPlugin extends BasePlugin {
    private Application mApplication;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "HWReceiverCrashPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
        this.mApplication = application;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        HWReceiverCrashOptimizer.fix(this.mApplication);
    }
}
