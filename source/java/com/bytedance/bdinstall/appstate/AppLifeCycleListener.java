package com.bytedance.bdinstall.appstate;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.bdinstall.appstate.AppStateListener;

/* loaded from: classes3.dex */
public class AppLifeCycleListener implements Application.ActivityLifecycleCallbacks, AppStateListener {
    private int mForegroundActivityNum;
    private boolean mIsForeground;
    private AppStateListener.OnActivityResumeListener mOnResumeListener;
    private boolean mResumed;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.mForegroundActivityNum < 0) {
            this.mForegroundActivityNum = 0;
        }
        if (this.mForegroundActivityNum == 0) {
            onEnterForeground();
        }
        this.mForegroundActivityNum++;
        this.mResumed = true;
        AppStateListener.OnActivityResumeListener onActivityResumeListener = this.mOnResumeListener;
        if (onActivityResumeListener != null) {
            onActivityResumeListener.onResume();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int i = this.mForegroundActivityNum - 1;
        this.mForegroundActivityNum = i;
        if (i <= 0) {
            onEnterBackground();
        }
        if (this.mForegroundActivityNum < 0) {
            this.mForegroundActivityNum = 0;
        }
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public boolean isForeground() {
        return this.mIsForeground;
    }

    private void onEnterBackground() {
        this.mIsForeground = false;
    }

    private void onEnterForeground() {
        this.mIsForeground = true;
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public void setOnResumeListener(AppStateListener.OnActivityResumeListener onActivityResumeListener) {
        this.mOnResumeListener = onActivityResumeListener;
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public boolean isActive() {
        return this.mResumed;
    }
}
