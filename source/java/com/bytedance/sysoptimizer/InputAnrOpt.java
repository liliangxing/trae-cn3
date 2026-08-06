package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.anr.AnrListener;
import com.bytedance.sysoptimizer.anr.AnrManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class InputAnrOpt {
    private static final String TAG = "InputAnrOpt";
    private static volatile boolean isRunning = false;
    private static int sAnrLevel = 2;
    private static boolean sAnrOptInited;
    private static boolean sShadowHookInited;
    private static final Object sMutex = new Object();
    static ScheduledExecutorService sExecutor = Executors.newScheduledThreadPool(1);
    private static LaunchActivityLifecycleCallback LaunchActivityLifecycleCallback = new LaunchActivityLifecycleCallback();
    static ScheduledFuture<?> sFuture = null;
    static AnrListener mAnrListener = new C02931();

    private static native boolean init(int i, int i2, boolean z, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void setStuckFlag(boolean z);

    private static native void setTimeOut(int i);

    private static native boolean startOpt();

    private static native boolean stopOpt();

    public static boolean inputAnrOptStart(Context context, int i, boolean z, int i2) {
        if (i >= 2000) {
            sAnrLevel = i / 1000;
        }
        return inputAnrInit(context, i, z, i2);
    }

    public static void setAnrLevel(int i) {
        if (i >= 2000) {
            sAnrLevel = i / 1000;
            setTimeOut(i);
        }
    }

    /* renamed from: com.bytedance.sysoptimizer.InputAnrOpt$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    static class C02931 implements AnrListener {
        C02931() {
        }

        @Override // com.bytedance.sysoptimizer.anr.AnrListener
        public void onAnrChange(boolean z, int i, AnrManager.AnrReason anrReason) {
            if (!z || anrReason.getNewAnrLevel() < InputAnrOpt.sAnrLevel) {
                return;
            }
            if (InputAnrOpt.sFuture != null) {
                InputAnrOpt.sFuture.cancel(false);
            }
            InputAnrOpt.setStuckFlag(true);
            InputAnrOpt.sFuture = InputAnrOpt.sExecutor.schedule(new Runnable() { // from class: com.bytedance.sysoptimizer.InputAnrOpt$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InputAnrOpt.setStuckFlag(false);
                }
            }, 15L, TimeUnit.SECONDS);
        }
    }

    public static boolean inputAnrInit(Context context, int i, boolean z, int i2) {
        synchronized (sMutex) {
            if (sShadowHookInited) {
                return sAnrOptInited;
            }
            if (!isTargetOSVersion()) {
                Log.d(TAG, "api:" + Build.VERSION.SDK_INT + ", not support");
                return sAnrOptInited;
            }
            try {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                    sShadowHookInited = true;
                }
                sAnrOptInited = init(Build.VERSION.SDK_INT, i, z, i2);
                Log.d(TAG, "isDebug:" + z + ", priority:" + i2 + ", sAnrOptInited:" + sAnrOptInited);
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(LaunchActivityLifecycleCallback);
                AnrManager.getInstance().registerListener(mAnrListener);
                startAnrOpt();
            } catch (Throwable th) {
                th.printStackTrace();
                sAnrOptInited = false;
            }
            return sAnrOptInited;
        }
    }

    private static boolean isTargetOSVersion() {
        return Build.VERSION.SDK_INT <= 35;
    }

    public static void startAnrOpt() {
        sExecutor.submit(new Runnable() { // from class: com.bytedance.sysoptimizer.InputAnrOpt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InputAnrOpt.lambda$startAnrOpt$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$startAnrOpt$0() {
        synchronized (sMutex) {
            if (startOpt()) {
                Log.e(TAG, "startOpt sucess");
            } else {
                Log.e(TAG, "startOpt faile");
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class LaunchActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            InputAnrOpt.startAnrOpt();
        }
    }
}
