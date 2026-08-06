package com.bytedance.sdk.account.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class ActivityStack {
    private static final String TAG = "AccountActivityStack";
    private static int sForegroundActivityNum;
    private static final LinkedList<Activity> sActivityStack = new LinkedList<>();
    private static final HashSet<SwitchListener> switchListeners = new HashSet<>();
    private static final AtomicBoolean isInit = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static class SwitchListener {
        public void onBackground() {
        }

        public void onForeground() {
        }
    }

    static /* synthetic */ int access$108() {
        int i = sForegroundActivityNum;
        sForegroundActivityNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$110() {
        int i = sForegroundActivityNum;
        sForegroundActivityNum = i - 1;
        return i;
    }

    public static void init(Application application) {
        if (isInit.compareAndSet(false, true)) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.account.utils.ActivityStack.1
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
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    ActivityStack.sActivityStack.add(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    ActivityStack.access$108();
                    if (ActivityStack.sForegroundActivityNum == 1) {
                        ActivityStack.notifyForeground();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    ActivityStack.access$110();
                    if (ActivityStack.sForegroundActivityNum == 0) {
                        ActivityStack.notifyBackground();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    ActivityStack.sActivityStack.remove(activity);
                }
            });
        }
    }

    public static boolean isAppForeground() {
        return sForegroundActivityNum > 0;
    }

    public static void registerSwitchListener(SwitchListener switchListener) {
        if (switchListener != null) {
            switchListeners.add(switchListener);
        }
    }

    public static void unregisterSwitchListener(SwitchListener switchListener) {
        if (switchListener != null) {
            switchListeners.remove(switchListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyForeground() {
        Log.d(TAG, "notifyForeground");
        Iterator<SwitchListener> it = switchListeners.iterator();
        while (it.hasNext()) {
            it.next().onForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyBackground() {
        Log.d(TAG, "notifyForeground");
        Iterator<SwitchListener> it = switchListeners.iterator();
        while (it.hasNext()) {
            it.next().onBackground();
        }
    }

    public static Activity getPreviousActivity(Activity activity) {
        LinkedList<Activity> linkedList = sActivityStack;
        boolean z = false;
        for (int size = linkedList.size() - 1; size >= 0; size--) {
            if (z) {
                Activity activity2 = linkedList.get(size);
                if (activity2 != null && !activity2.isFinishing()) {
                    return activity2;
                }
            } else if (linkedList.get(size) == activity) {
                z = true;
            }
        }
        return null;
    }

    public static Activity getTopActivity() {
        LinkedList<Activity> linkedList = sActivityStack;
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList.getLast();
    }

    public static synchronized Activity[] getActivityStack() {
        Activity[] activityArr;
        synchronized (ActivityStack.class) {
            LinkedList<Activity> linkedList = sActivityStack;
            activityArr = (Activity[]) linkedList.toArray(new Activity[linkedList.size()]);
        }
        return activityArr;
    }

    public static synchronized Activity getValidTopActivity() {
        synchronized (ActivityStack.class) {
            for (int size = sActivityStack.size() - 1; size >= 0; size--) {
                Activity activity = sActivityStack.get(size);
                if (activity != null && !activity.isFinishing()) {
                    return activity;
                }
            }
            return getTopActivity();
        }
    }
}
