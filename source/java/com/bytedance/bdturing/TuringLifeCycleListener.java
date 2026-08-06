package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.bdturing.senseless.PageTracer;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class TuringLifeCycleListener {
    public static long sInitTime;
    private static volatile TuringLifeCycleListener sInstance;
    private boolean isInit;
    private Object mLock = new Object();
    private WeakReference<Activity> mTopActivityRef;

    private TuringLifeCycleListener() {
    }

    public static TuringLifeCycleListener getInstance() {
        if (sInstance == null) {
            synchronized (TuringLifeCycleListener.class) {
                if (sInstance == null) {
                    sInstance = new TuringLifeCycleListener();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        Application applicationByContext;
        if (context == null || this.isInit || (applicationByContext = getApplicationByContext(context)) == null) {
            return;
        }
        applicationByContext.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.bdturing.TuringLifeCycleListener.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                PageTracer.getInstance().onActivityStart(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                TuringLifeCycleListener.this.setTopActivity(new WeakReference(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (TuringLifeCycleListener.this.mTopActivityRef == null || TuringLifeCycleListener.this.mTopActivityRef.get() != activity) {
                    return;
                }
                TuringLifeCycleListener.this.setTopActivity(null);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                PageTracer.getInstance().onActivityStopped(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (TuringLifeCycleListener.this.mTopActivityRef == null || TuringLifeCycleListener.this.mTopActivityRef.get() != activity) {
                    return;
                }
                TuringLifeCycleListener.this.setTopActivity(null);
            }
        });
        sInitTime = System.currentTimeMillis();
        this.isInit = true;
    }

    private Application getApplicationByContext(Context context) {
        if (context != null) {
            if (context instanceof Application) {
                return (Application) context;
            }
            if (context instanceof Activity) {
                return ((Activity) context).getApplication();
            }
            if (context instanceof ContextWrapper) {
                return getApplicationByContext(((ContextWrapper) context).getBaseContext());
            }
        }
        return null;
    }

    public Activity getTopActivity() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            WeakReference<Activity> weakReference = this.mTopActivityRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        synchronized (this.mLock) {
            while (this.mTopActivityRef == null) {
                this.mLock.wait(200L);
                if (this.mTopActivityRef == null) {
                    break;
                }
            }
        }
        WeakReference<Activity> weakReference2 = this.mTopActivityRef;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopActivity(WeakReference<Activity> weakReference) {
        synchronized (this.mLock) {
            this.mTopActivityRef = weakReference;
            this.mLock.notifyAll();
        }
    }

    public boolean isInit() {
        return this.isInit;
    }
}
