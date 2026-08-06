package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.os.Build;
import com.bytedance.platform.godzilla.crash.deadsystemexception.IActivityTaskManagerProxy;
import com.bytedance.platform.godzilla.crash.deadsystemexception.IConnectivityManagerProxy;
import com.bytedance.platform.godzilla.crash.deadsystemexception.ViewRootImplHandlerHook;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DeadSystemExceptionPlugin extends BasePlugin {
    private Application mApplication;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "DeadSystemExceptionPlugin";
    }

    public DeadSystemExceptionPlugin(Application application) {
        this.mApplication = application;
        if (application == null) {
            throw new IllegalArgumentException("Argument application can not be null!");
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        new IConnectivityManagerProxy().onInstall();
        if (Build.VERSION.SDK_INT == 29) {
            new ViewRootImplHandlerHook().onHook(this.mApplication);
            new IActivityTaskManagerProxy().onInstall();
        }
    }
}
