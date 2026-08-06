package com.bytedance.common.wschannel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* loaded from: classes3.dex */
class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static WeakHandler sHandler = new WeakHandler(Looper.getMainLooper(), new WeakHandler.IHandler() { // from class: com.bytedance.common.wschannel.LifeCycleMonitor.1
        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message message) {
        }
    });
    private AppStateListener mListener;
    private boolean mAppAlive = false;
    private Runnable mRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.LifeCycleMonitor.2
        @Override // java.lang.Runnable
        public void run() {
            if (Logger.debug()) {
                Logger.d("WsChannelSdk", "sRunnable AppAlive = " + LifeCycleMonitor.this.mAppAlive);
            }
            if (LifeCycleMonitor.this.mAppAlive) {
                LifeCycleMonitor.this.mAppAlive = false;
                if (LifeCycleMonitor.this.mListener != null) {
                    LifeCycleMonitor.this.mListener.onEnterToBackground();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
    }

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
        if (!this.mAppAlive) {
            this.mAppAlive = true;
            AppStateListener appStateListener = this.mListener;
            if (appStateListener != null) {
                appStateListener.onEnterToForeground();
            }
        }
        if (Logger.debug()) {
            Logger.d("WsChannelSdk", "onResume sAppAlive = " + this.mAppAlive);
        }
        sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.mAppAlive) {
            sHandler.postDelayed(this.mRunnable, 3000L);
        }
    }

    public void setAppStateChangedListener(AppStateListener appStateListener) {
        this.mListener = appStateListener;
    }
}
