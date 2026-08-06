package com.bytedance.sysoptimizer.anr.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ActivityLeakCollect {
    private static final String TAG = "SysAnrOpt";
    private static List<WeakReference<Activity>> activityReferences = new ArrayList();
    private static Map<String, Integer> leakCountMap = new HashMap();

    public static void registerActivity(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sysoptimizer.anr.utils.ActivityLeakCollect.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

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
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ActivityLeakCollect.activityReferences.add(new WeakReference(activity));
            }
        });
    }

    private static void checkForLeaks() {
        try {
            leakCountMap.clear();
            Iterator<WeakReference<Activity>> it = activityReferences.iterator();
            while (it.hasNext()) {
                Activity activity = it.next().get();
                if (activity == null) {
                    it.remove();
                } else {
                    String simpleName = activity.getClass().getSimpleName();
                    Map<String, Integer> map = leakCountMap;
                    map.put(simpleName, Integer.valueOf(map.getOrDefault(simpleName, 0).intValue() + 1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> getLeakCountMap() {
        checkForLeaks();
        return leakCountMap;
    }

    public static Map<String, Integer> getLeaksGreaterThanOne() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Integer> entry : getLeakCountMap().entrySet()) {
            if (entry.getValue().intValue() > 1) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
