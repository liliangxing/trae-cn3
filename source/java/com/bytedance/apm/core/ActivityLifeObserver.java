package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks, IActivityLifeManager {
    private static final long CHECK_DELAY = 600;
    private static final String TAG = "ActivityLifeObserver";
    private static final ActivityLifeObserver mInstance = new ActivityLifeObserver();
    private boolean mChangingConfigActivity;
    private String mCurActivityHash;
    private int mFrontActivityCount;
    private volatile boolean mIsFrontV2;
    private WeakReference<Activity> mTopActivityRef;
    private ArrayList<IActivityLifeObserver> mObservers = new ArrayList<>(8);
    private ArrayList<ILifecycle> mLifecycleObservers = new ArrayList<>(8);
    private String mTopActivityClassName = null;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public boolean isForeground() {
        return this.mIsFrontV2;
    }

    public boolean isV2Foreground() {
        return this.mIsFrontV2;
    }

    private ActivityLifeObserver() {
    }

    private void initWithApp(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
            application.registerActivityLifecycleCallbacks(this);
        }
    }

    public static void init(Application application) {
        mInstance.initWithApp(application);
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    public void register(IActivityLifeObserver iActivityLifeObserver) {
        ArrayList<IActivityLifeObserver> arrayList = this.mObservers;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mObservers.add(iActivityLifeObserver);
            }
        }
    }

    public void unregister(IActivityLifeObserver iActivityLifeObserver) {
        ArrayList<IActivityLifeObserver> arrayList = this.mObservers;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mObservers.remove(iActivityLifeObserver);
            }
        }
    }

    public void register(ILifecycle iLifecycle) {
        ArrayList<ILifecycle> arrayList = this.mLifecycleObservers;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mLifecycleObservers.add(iLifecycle);
            }
        }
    }

    public void unregister(ILifecycle iLifecycle) {
        ArrayList<ILifecycle> arrayList = this.mLifecycleObservers;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mLifecycleObservers.remove(iLifecycle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.mTopActivityRef = new WeakReference<>(activity);
        this.mTopActivityClassName = null;
        Object[] collectObservers = collectObservers();
        for (Object obj : collectObservers) {
            ((IActivityLifeObserver) obj).onActivityResume(activity);
        }
        Iterator<ILifecycle> it = this.mLifecycleObservers.iterator();
        while (it.hasNext()) {
            it.next().onActivityResumed(activity);
        }
        String activityHash = getActivityHash(activity);
        if (activityHash.equals(this.mCurActivityHash)) {
            return;
        }
        for (Object obj2 : collectObservers) {
            ((IActivityLifeObserver) obj2).onChange(activity, (Fragment) null);
        }
        this.mCurActivityHash = activityHash;
    }

    private void notifyFront(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifeObserver) obj).onFront(activity);
        }
        Iterator<ILifecycle> it = this.mLifecycleObservers.iterator();
        while (it.hasNext()) {
            it.next().onFront(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifeObserver) obj).onActivityPause(activity);
        }
    }

    private void notifyBackground(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifeObserver) obj).onBackground(activity);
        }
        Iterator<ILifecycle> it = this.mLifecycleObservers.iterator();
        while (it.hasNext()) {
            it.next().onBackground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (Object obj : collectObservers()) {
            ((IActivityLifeObserver) obj).onActivityCreated(activity, bundle);
        }
        Iterator<ILifecycle> it = this.mLifecycleObservers.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        for (Object obj : collectObservers()) {
            ((IActivityLifeObserver) obj).onActivityStarted(activity);
        }
        if (this.mChangingConfigActivity) {
            this.mChangingConfigActivity = false;
            return;
        }
        int i = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = i;
        if (i == 1) {
            this.mIsFrontV2 = true;
            notifyFront(activity);
        }
    }

    private Object[] collectObservers() {
        Object[] array;
        synchronized (this.mObservers) {
            array = this.mObservers.size() > 0 ? this.mObservers.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.mChangingConfigActivity = true;
            return;
        }
        int i = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = i;
        if (i == 0) {
            this.mIsFrontV2 = false;
            notifyBackground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (getActivityHash(activity).equals(this.mCurActivityHash)) {
            this.mCurActivityHash = null;
        }
        Iterator<ILifecycle> it = this.mLifecycleObservers.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroyed(activity);
        }
    }

    private String getActivityHash(Activity activity) {
        return activity.getClass().getName() + activity.hashCode();
    }

    public WeakReference<Activity> getTopActivityRef() {
        return this.mTopActivityRef;
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> weakReference = this.mTopActivityRef;
        String str = "";
        if (weakReference == null) {
            return "";
        }
        Activity activity = weakReference.get();
        return (activity == null || (str = this.mTopActivityClassName) != null) ? str : activity.getClass().getName();
    }
}
