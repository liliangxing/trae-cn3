package com.ss.android.message;

import android.app.Application;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.utils.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppProvider {
    private static volatile Application app;
    private static final AtomicBoolean sRegisteredActivityLifecycleCallback = new AtomicBoolean(false);

    public static void initApp(Application application) {
        if (application == null) {
            Logger.e("AppProvider", "AppProvider.initApp: application is null！！", new Throwable());
        } else {
            if (sRegisteredActivityLifecycleCallback.getAndSet(true)) {
                return;
            }
            app = application;
            app.registerActivityLifecycleCallbacks(ActivityLifecycleObserver.getIns());
        }
    }

    public static Application getApp() {
        return app;
    }

    @Deprecated
    public static int getTargetSdkVersion() {
        return app.getApplicationInfo().targetSdkVersion;
    }
}
