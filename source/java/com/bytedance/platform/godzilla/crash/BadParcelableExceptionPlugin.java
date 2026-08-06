package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;

/* loaded from: classes4.dex */
public class BadParcelableExceptionPlugin extends BasePlugin {
    private Context mContext;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "BadParcelableExceptionPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
        this.mContext = application;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        BadParcelableCrashOptimizer.fix(this.mContext);
    }
}
