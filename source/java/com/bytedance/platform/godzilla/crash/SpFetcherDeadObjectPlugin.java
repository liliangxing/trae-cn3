package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.os.Build;
import android.os.storage.StorageManager;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject.IMountServiceProxy;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class SpFetcherDeadObjectPlugin extends BasePlugin {
    private boolean mHitTargetAPI = false;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "SpFetcherDeadObjectPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
        this.mHitTargetAPI = Build.VERSION.SDK_INT == 26;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (this.mHitTargetAPI) {
            new IMountServiceProxy().onInstall();
            try {
                Field declaredField = StorageManager.class.getDeclaredField("sStorageManager");
                declaredField.setAccessible(true);
                declaredField.set(null, null);
                Logger.d("DeadObjectFixer", "Fix success.");
            } catch (Exception e) {
                Logger.d("DeadObjectFixer", "Fix fail " + e);
            }
        }
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
