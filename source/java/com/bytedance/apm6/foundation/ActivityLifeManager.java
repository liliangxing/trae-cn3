package com.bytedance.apm6.foundation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ActivityLifeManager implements Application.ActivityLifecycleCallbacks, ActivityLifecycleService {
    private boolean changingConfigActivity;
    private int frontActivityCount;
    private volatile boolean isFront;
    private final ArrayList<IActivityLifecycleObserver> observers = new ArrayList<>();
    private String topActivityClassName = null;
    private WeakReference<Activity> topActivityRef;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public ActivityLifeManager() {
        Application context = ApmContext.getContext();
        context.unregisterActivityLifecycleCallbacks(this);
        context.registerActivityLifecycleCallbacks(this);
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public boolean isForeground() {
        return this.isFront;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void register(IActivityLifecycleObserver iActivityLifecycleObserver) {
        if (iActivityLifecycleObserver == null) {
            return;
        }
        synchronized (this.observers) {
            this.observers.add(iActivityLifecycleObserver);
        }
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void unregister(IActivityLifecycleObserver iActivityLifecycleObserver) {
        if (iActivityLifecycleObserver == null) {
            return;
        }
        synchronized (this.observers) {
            this.observers.remove(iActivityLifecycleObserver);
        }
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public String getTopActivityClassName() {
        WeakReference<Activity> weakReference = this.topActivityRef;
        String str = "";
        if (weakReference == null) {
            return "";
        }
        Activity activity = weakReference.get();
        return (activity == null || (str = this.topActivityClassName) != null) ? str : activity.getClass().getCanonicalName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.topActivityRef = new WeakReference<>(activity);
        this.topActivityClassName = null;
        for (Object obj : collectObservers()) {
            ((IActivityLifecycleObserver) obj).onActivityResume(activity);
        }
    }

    private void notifyFront(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifecycleObserver) obj).onFront(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifecycleObserver) obj).onActivityPause(activity);
        }
    }

    private void notifyBackground(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifecycleObserver) obj).onBackground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (Object obj : collectObservers()) {
            ((IActivityLifecycleObserver) obj).onActivityCreated(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifecycleObserver) obj).onActivityStarted(activity);
        }
        if (this.changingConfigActivity) {
            this.changingConfigActivity = false;
            return;
        }
        int i = this.frontActivityCount + 1;
        this.frontActivityCount = i;
        if (i == 1) {
            this.isFront = true;
            notifyFront(activity);
        }
    }

    private Object[] collectObservers() {
        Object[] array;
        synchronized (this.observers) {
            array = this.observers.size() > 0 ? this.observers.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.changingConfigActivity = true;
            return;
        }
        int i = this.frontActivityCount - 1;
        this.frontActivityCount = i;
        if (i == 0) {
            this.isFront = false;
            notifyBackground(activity);
        }
    }
}
