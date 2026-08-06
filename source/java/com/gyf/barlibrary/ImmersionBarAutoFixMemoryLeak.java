package com.gyf.barlibrary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImmersionBarAutoFixMemoryLeak {
    private static String TAG = "ImmersionBarAutoFixMemoryLeak";

    public static void init(Context context, Boolean bool) {
        if ((context instanceof Application) && bool.booleanValue()) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.gyf.barlibrary.ImmersionBarAutoFixMemoryLeak.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
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
                public void onActivityDestroyed(Activity activity) {
                    if (activity != null) {
                        final String obj = activity.toString();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.gyf.barlibrary.ImmersionBarAutoFixMemoryLeak.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Log.e(ImmersionBarAutoFixMemoryLeak.TAG, "auto destroy count: " + ImmersionBar.destroyAll(obj));
                            }
                        });
                    }
                }
            });
        }
    }
}
