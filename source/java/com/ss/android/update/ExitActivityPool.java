package com.ss.android.update;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class ExitActivityPool implements Application.ActivityLifecycleCallbacks {
    private BroadcastReceiver mExitAppReceiver;

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
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    private ExitActivityPool() {
    }

    /* loaded from: classes7.dex */
    private static class InstanceHolder {
        private static final ExitActivityPool INSTANCE = new ExitActivityPool();

        private InstanceHolder() {
        }
    }

    public static ExitActivityPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void init(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        final WeakReference weakReference = new WeakReference(activity);
        this.mExitAppReceiver = new BroadcastReceiver() { // from class: com.ss.android.update.ExitActivityPool.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || activity2.isFinishing()) {
                    return;
                }
                activity2.finish();
            }
        };
        LocalBroadcastManager.getInstance(activity).registerReceiver(this.mExitAppReceiver, new IntentFilter("com.ss.android.common.app.action.exit_app"));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        LocalBroadcastManager.getInstance(activity).unregisterReceiver(this.mExitAppReceiver);
    }
}
