package com.bytedance.platform.godzilla.anr;

import android.app.Application;
import com.bytedance.platform.godzilla.anr.webview.HookActivityThread;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* loaded from: classes4.dex */
public class CookieManagerPlugin extends BasePlugin {
    private Application mApplication;
    private boolean mHintTargetApi;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CookieManagerPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
        this.mApplication = application;
        this.mHintTargetApi = false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (this.mApplication == null) {
            throw new RuntimeException("mApplication must not null!!!");
        }
        Logger.e(getName(), "start");
        if (this.mHintTargetApi) {
            new HookActivityThread().preSetApplication(this.mApplication);
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }
}
