package com.bytedance.platform.godzilla.anr;

import android.app.Application;
import com.bytedance.platform.godzilla.anr.sp.QueuedWorkProxyWrapper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* loaded from: classes4.dex */
public class SpBlockPlugin extends BasePlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "SpPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        QueuedWorkProxyWrapper.hookQueuedWork();
        Logger.e(getName(), "start");
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
