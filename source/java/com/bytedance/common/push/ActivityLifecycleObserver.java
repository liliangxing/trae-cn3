package com.bytedance.common.push;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.push.notification.BaseBannerActivity;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.Singleton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ActivityLifecycleObserver extends Observable implements Application.ActivityLifecycleCallbacks {
    private static final Singleton<ActivityLifecycleObserver> INST = new Singleton<ActivityLifecycleObserver>() { // from class: com.bytedance.common.push.ActivityLifecycleObserver.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: create, reason: merged with bridge method [inline-methods] */
        public ActivityLifecycleObserver m442create(Object... objArr) {
            return new ActivityLifecycleObserver();
        }
    };
    private static final List<String> activityWhitList = Arrays.asList("GifPermissionBootActivity", "GifPermissionDynamicActivity", "GifPermissionToastActivity");
    private static volatile boolean sIsBackGround = true;
    private long lastForeGroundTime;
    private Rect launchSourceBounds;
    private WeakReference<Activity> mActivityRef;
    private boolean mAppActive;
    private List<Long> mEnterBackgroundTimeStampList;
    private int mForegroundActivityNum;
    private final List<Application.ActivityLifecycleCallbacks> mListener;
    private final Runnable mRunnable;
    private final List<Runnable> runnableNeedExecuteAfterAppLaunch;
    private final WeakHandler sHandler;

    public static ActivityLifecycleObserver getIns() {
        return (ActivityLifecycleObserver) INST.get(new Object[0]);
    }

    private ActivityLifecycleObserver() {
        this.mRunnable = new Runnable() { // from class: com.bytedance.common.push.ActivityLifecycleObserver.2
            @Override // java.lang.Runnable
            public void run() {
                if (ActivityLifecycleObserver.this.mAppActive) {
                    ActivityLifecycleObserver.this.mAppActive = false;
                    Logger.d("ActivityLifecycleObserver", "sAppAlive = false");
                }
            }
        };
        this.mEnterBackgroundTimeStampList = new ArrayList();
        this.sHandler = new WeakHandler(new WeakHandler.IHandler() { // from class: com.bytedance.common.push.ActivityLifecycleObserver.3
            @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
            public void handleMsg(Message message) {
            }
        });
        this.mListener = new ArrayList();
        this.runnableNeedExecuteAfterAppLaunch = new ArrayList();
    }

    public Rect getLaunchSourceBounds() {
        return this.launchSourceBounds;
    }

    public void runAfterUserLaunch(Runnable runnable) {
        Logger.d("ActivityLifecycleObserver", "[runAfterUserLaunch]lastForeGroundTime:" + this.lastForeGroundTime);
        if (this.lastForeGroundTime > 0) {
            runnable.run();
            return;
        }
        synchronized (this.runnableNeedExecuteAfterAppLaunch) {
            this.runnableNeedExecuteAfterAppLaunch.add(runnable);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (Logger.debug()) {
            Logger.d("ActivityLifecycleObserver", "onActivityStarted:" + activity.getClass().getName());
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            Rect sourceBounds = intent.getSourceBounds();
            if (Logger.debug()) {
                Logger.d("ActivityLifecycleObserver", "[onActivityCreated]sourceBounds:" + sourceBounds);
            }
            if (sourceBounds != null) {
                this.launchSourceBounds = sourceBounds;
            }
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityStarted(activity);
            }
        }
        if (activity instanceof BaseBannerActivity) {
            Logger.d("ActivityLifecycleObserver", "on banner ActivityStarted,ignore");
            return;
        }
        Logger.d("ActivityLifecycleObserver", "activityWhitList: " + activity.getClass().getSimpleName());
        if (activityWhitList.contains(activity.getClass().getSimpleName())) {
            return;
        }
        if (this.mForegroundActivityNum < 0) {
            this.mForegroundActivityNum = 0;
        }
        if (this.mForegroundActivityNum == 0) {
            onEnterForeground();
        }
        this.mForegroundActivityNum++;
        if (!this.mAppActive) {
            this.mAppActive = true;
            Logger.d("ActivityLifecycleObserver", "onResume sAppAlive = true");
        }
        this.sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Logger.d("ActivityLifecycleObserver", "onActivityResumed:" + activity.getClass().getName());
        this.mActivityRef = new WeakReference<>(activity);
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (Logger.debug()) {
            Logger.d("ActivityLifecycleObserver", "onActivityPaused:" + activity.getClass().getName());
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityPaused(activity);
            }
        }
    }

    private void onEnterBackground() {
        Logger.d("ActivityLifecycleObserver", "onEnterBackground");
        sIsBackGround = true;
        AppStatusObserverForChildProcess.getIns().onEnterBackground();
        setChanged();
        notifyObservers(Boolean.valueOf(sIsBackGround));
        this.mEnterBackgroundTimeStampList.add(Long.valueOf(System.currentTimeMillis()));
    }

    private void onEnterForeground() {
        Logger.d("ActivityLifecycleObserver", "[onEnterForeground]runnableNeedExecuteAfterAppLaunch size:" + this.runnableNeedExecuteAfterAppLaunch.size());
        sIsBackGround = false;
        this.lastForeGroundTime = System.currentTimeMillis();
        AppStatusObserverForChildProcess.getIns().onEnterForeground();
        setChanged();
        notifyObservers(Boolean.valueOf(sIsBackGround));
        if (this.runnableNeedExecuteAfterAppLaunch.size() > 0) {
            synchronized (this.runnableNeedExecuteAfterAppLaunch) {
                Iterator<Runnable> it = this.runnableNeedExecuteAfterAppLaunch.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.runnableNeedExecuteAfterAppLaunch.clear();
            }
        }
    }

    public List<Long> getEnterBackgroundTimeStampList() {
        return this.mEnterBackgroundTimeStampList;
    }

    public long getLastForeGroundTime() {
        return this.lastForeGroundTime;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Logger.d("ActivityLifecycleObserver", "onActivityStopped:" + activity.getClass().getName());
        if (this.mAppActive) {
            this.sHandler.postDelayed(this.mRunnable, 30000L);
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityStopped(activity);
            }
        }
        Logger.d("ActivityLifecycleObserver", "activityWhitList: " + activity.getClass().getSimpleName());
        if (activityWhitList.contains(activity.getClass().getSimpleName())) {
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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Logger.d("ActivityLifecycleObserver", "onActivityDestroyed:" + activity.getClass().getName());
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((Application.ActivityLifecycleCallbacks) obj).onActivityDestroyed(activity);
            }
        }
    }

    public boolean isBackGround() {
        return sIsBackGround;
    }

    public boolean isApplicationActive() {
        return this.mAppActive;
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
