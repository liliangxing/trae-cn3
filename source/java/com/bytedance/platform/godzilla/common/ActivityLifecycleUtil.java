package com.bytedance.platform.godzilla.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ActivityLifecycleUtil {
    public static final int ACTIVITY_STATE_DESTORY = 3;
    public static final int ACTIVITY_STATE_PAUSE = 1;
    public static final int ACTIVITY_STATE_RESUME = 0;
    public static final int ACTIVITY_STATE_STOP = 2;
    private static Map<Integer, WeakReference<Activity>> mActivityMaps = new HashMap();
    private static WeakReference<Activity> mLastResumedActivity = null;
    private static WeakReference<Activity> mLastPauseActivity = null;
    private static WeakReference<Activity> mLastStopActivity = null;
    private static WeakReference<Activity> mLastDestoryActivity = null;

    private ActivityLifecycleUtil() {
    }

    public static void initActivityLifecycle(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.platform.godzilla.common.ActivityLifecycleUtil.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ActivityLifecycleUtil.mActivityMaps.put(0, new WeakReference(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ActivityLifecycleUtil.mActivityMaps.put(1, new WeakReference(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ActivityLifecycleUtil.mActivityMaps.put(2, new WeakReference(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ActivityLifecycleUtil.mActivityMaps.put(3, new WeakReference(activity));
            }
        });
    }

    public static Activity getActivity(int i) {
        if (mActivityMaps.get(Integer.valueOf(i)) != null) {
            return mActivityMaps.get(Integer.valueOf(i)).get();
        }
        return null;
    }
}
