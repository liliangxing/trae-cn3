package com.bytedance.praisedialoglib.manager;

import android.app.Application;
import com.bytedance.praisedialoglib.depend.IPraiseDialogConfig;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PraiseSdkManager {
    private Application mApplication;

    private PraiseSdkManager() {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class SingleHolder {
        private static PraiseSdkManager sInstance = new PraiseSdkManager();

        private SingleHolder() {
        }
    }

    public static PraiseSdkManager getInstance() {
        return SingleHolder.sInstance;
    }

    public void init(IPraiseDialogConfig iPraiseDialogConfig, Application application) {
        this.mApplication = application;
        PraiseDialogCfgManager.getInstance().init(iPraiseDialogConfig);
    }

    public Application getApplication() {
        return this.mApplication;
    }
}
