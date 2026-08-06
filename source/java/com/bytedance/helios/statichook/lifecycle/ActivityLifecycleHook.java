package com.bytedance.helios.statichook.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ActivityLifecycleHook {
    private static final List<ActivityLifecycleInvoker> invokers = new ArrayList();

    private static void initInvokers() {
    }

    static {
        initInvokers();
    }

    public static void onCreate(Activity activity, Bundle bundle) {
        Iterator<ActivityLifecycleInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onCreate(activity, bundle);
            } catch (Exception e) {
                Log.e("ActivityLifecycleHook", null, e);
            }
        }
    }

    public static void onStart(Activity activity) {
        Iterator<ActivityLifecycleInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStart(activity);
            } catch (Exception e) {
                Log.e("ActivityLifecycleHook", null, e);
            }
        }
    }

    public static void onResume(Activity activity) {
        Iterator<ActivityLifecycleInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onResume(activity);
            } catch (Exception e) {
                Log.e("ActivityLifecycleHook", null, e);
            }
        }
    }

    public static void onPause(Activity activity) {
        Iterator<ActivityLifecycleInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onPause(activity);
            } catch (Exception e) {
                Log.e("ActivityLifecycleHook", null, e);
            }
        }
    }

    public static void onStop(Activity activity) {
        Iterator<ActivityLifecycleInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStop(activity);
            } catch (Exception e) {
                Log.e("ActivityLifecycleHook", null, e);
            }
        }
    }

    public static void onDestroy(Activity activity) {
        Iterator<ActivityLifecycleInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDestroy(activity);
            } catch (Exception e) {
                Log.e("ActivityLifecycleHook", null, e);
            }
        }
    }
}
