package com.bytedance.ug.sdk.share.impl.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ActivityStack {
    private static LinkedList<Activity> sActivityStack = new LinkedList<>();

    public static void register(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.ug.sdk.share.impl.utils.ActivityStack.1
            ConcurrentHashMap<String, ViewTreeObserver.OnWindowFocusChangeListener> listeners = new ConcurrentHashMap<>();

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
                try {
                    ActivityStack.sActivityStack.remove(activity);
                    ActivityStack.sActivityStack.add(activity);
                } catch (Throwable unused) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ShareSdkManager.getInstance().enterForeground(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ShareSdkManager.getInstance().enterBackground(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                try {
                    ActivityStack.sActivityStack.remove(activity);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Activity getTopActivity() {
        if (sActivityStack.isEmpty()) {
            return null;
        }
        return sActivityStack.getLast();
    }
}
