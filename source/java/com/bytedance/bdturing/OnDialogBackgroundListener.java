package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OnDialogBackgroundListener implements Application.ActivityLifecycleCallbacks {
    private int count = 1;
    private Activity mActivity;

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
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnDialogBackgroundListener(Activity activity) {
        this.mActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == this.mActivity) {
            this.count++;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity == this.mActivity) {
            int i = this.count - 1;
            this.count = i;
            if (i == 0) {
                EventReport.statisticDialogBackground(null);
            }
        }
    }

    public void registerListener() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public void unregisterListener() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }
}
