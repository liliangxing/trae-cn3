package com.bytedance.push.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.Singleton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SysDialogActivityLifecycleObserver extends Observable implements Application.ActivityLifecycleCallbacks {
    private WeakReference<Activity> mActivityRef;
    private int mForegroundActivityNum;
    private final List<Application.ActivityLifecycleCallbacks> mListener = new ArrayList();
    private static final Singleton<SysDialogActivityLifecycleObserver> INST = new Singleton<SysDialogActivityLifecycleObserver>() { // from class: com.bytedance.push.helper.SysDialogActivityLifecycleObserver.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.push.utils.Singleton
        public SysDialogActivityLifecycleObserver create(Object... objArr) {
            return new SysDialogActivityLifecycleObserver();
        }
    };
    private static volatile boolean sIsBackGround = true;
    private static volatile boolean sHasForeGround = false;

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

    public SysDialogActivityLifecycleObserver() {
        sIsBackGround = ActivityLifecycleObserver.getIns().isBackGround();
        Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
        if (topActivity != null) {
            this.mActivityRef = new WeakReference<>(topActivity);
        }
        ActivityLifecycleObserver.getIns().addActivityLifeCycleListener(this);
    }

    public static SysDialogActivityLifecycleObserver getIns() {
        return INST.get(new Object[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (Logger.debug()) {
            Logger.m268d("SysDialogActivityLifecycleObserver", "onActivityResumed:" + activity.getClass().getName());
        }
        if (activity.getClass().getName().contains("tSysActivity") || activity.getClass().getName().contains("BSysActivity")) {
            return;
        }
        if (this.mForegroundActivityNum < 0) {
            this.mForegroundActivityNum = 0;
        }
        this.mActivityRef = new WeakReference<>(activity);
        if (this.mForegroundActivityNum == 0) {
            onEnterForeground();
        }
        this.mForegroundActivityNum++;
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Logger.m268d("SysDialogActivityLifecycleObserver", "onActivityPaused:" + activity.getClass().getName());
        if (activity.getClass().getName().contains("tSysActivity") || activity.getClass().getName().contains("BSysActivity")) {
            return;
        }
        int i = this.mForegroundActivityNum - 1;
        this.mForegroundActivityNum = i;
        if (i <= 0) {
            onEnterBackground();
        }
        if (this.mForegroundActivityNum < 0) {
            this.mForegroundActivityNum = 0;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityPaused(activity);
            }
        }
    }

    private void onEnterBackground() {
        Logger.m268d("SysDialogActivityLifecycleObserver", "onEnterBackground,topActivity:" + getTopActivity());
        sIsBackGround = true;
        setChanged();
        notifyObservers(Boolean.valueOf(sIsBackGround));
    }

    private void onEnterForeground() {
        Logger.m268d("SysDialogActivityLifecycleObserver", "onEnterForeground,topActivity:" + getTopActivity());
        sIsBackGround = false;
        sHasForeGround = true;
        setChanged();
        notifyObservers(Boolean.valueOf(sIsBackGround));
    }

    public boolean isBackGround() {
        return sIsBackGround;
    }

    public boolean hasForeGround() {
        return sHasForeGround;
    }

    public void addActivityLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks == null) {
            return;
        }
        synchronized (this.mListener) {
            if (this.mListener.contains(activityLifecycleCallbacks)) {
                return;
            }
            this.mListener.add(activityLifecycleCallbacks);
        }
    }

    public void removeActivityLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks == null) {
            return;
        }
        synchronized (this.mListener) {
            this.mListener.remove(activityLifecycleCallbacks);
        }
    }

    private Object[] collectActivityLifecycleCallbacks() {
        Object[] array;
        synchronized (this.mListener) {
            array = this.mListener.size() > 0 ? this.mListener.toArray() : null;
        }
        return array;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
