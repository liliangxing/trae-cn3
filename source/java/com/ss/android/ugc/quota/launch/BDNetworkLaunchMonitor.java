package com.ss.android.ugc.quota.launch;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.ss.android.ugc.quota.BDNetworkTagManager;

/* loaded from: classes7.dex */
public class BDNetworkLaunchMonitor implements IBDNetworkLaunchMonitor {
    private static final String TAG = "BDNetworkLaunchMonitor";
    private int fgActivityCount = 0;
    private boolean appInBackground = false;
    private boolean firstLaunch = true;
    private int launchType = -999;

    static /* synthetic */ int access$308(BDNetworkLaunchMonitor bDNetworkLaunchMonitor) {
        int i = bDNetworkLaunchMonitor.fgActivityCount;
        bDNetworkLaunchMonitor.fgActivityCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$310(BDNetworkLaunchMonitor bDNetworkLaunchMonitor) {
        int i = bDNetworkLaunchMonitor.fgActivityCount;
        bDNetworkLaunchMonitor.fgActivityCount = i - 1;
        return i;
    }

    public BDNetworkLaunchMonitor(Application application) {
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.ugc.quota.launch.BDNetworkLaunchMonitor.1
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

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r5v3 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ?? r5 = bundle != null ? 1 : 0;
                Log.d(BDNetworkLaunchMonitor.TAG, "onActivityCreated, Activity:" + activity + ",firstLaunch:" + BDNetworkLaunchMonitor.this.firstLaunch + ",restore:" + ((boolean) r5));
                if (BDNetworkLaunchMonitor.this.firstLaunch) {
                    BDNetworkLaunchMonitor.this.firstLaunch = false;
                    BDNetworkLaunchMonitor.this.onLaunchTypeChanged(r5);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                BDNetworkLaunchMonitor.this.logCurrentStats("onActivityStarted enter", activity);
                BDNetworkLaunchMonitor.access$308(BDNetworkLaunchMonitor.this);
                if (BDNetworkLaunchMonitor.this.fgActivityCount == 1) {
                    if (BDNetworkLaunchMonitor.this.appInBackground) {
                        BDNetworkLaunchMonitor.this.onLaunchTypeChanged(2);
                    }
                    BDNetworkLaunchMonitor.this.appInBackground = false;
                }
                BDNetworkLaunchMonitor.this.logCurrentStats("onActivityStarted exit", activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                BDNetworkLaunchMonitor.this.logCurrentStats("onActivityStopped enter", activity);
                BDNetworkLaunchMonitor.access$310(BDNetworkLaunchMonitor.this);
                if (BDNetworkLaunchMonitor.this.fgActivityCount == 0) {
                    BDNetworkLaunchMonitor.this.appInBackground = true;
                }
                BDNetworkLaunchMonitor.this.logCurrentStats("onActivityStopped exit", activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLaunchTypeChanged(int i) {
        if (this.launchType == i) {
            return;
        }
        Log.d(TAG, "Current launch type is " + i);
        this.launchType = i;
        BDNetworkTagManager.getInstance().updateLaunchType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logCurrentStats(String str, Activity activity) {
        Log.d(TAG, str + ", Activity:" + activity + ",fgActivityCount: " + this.fgActivityCount + ",appInBackground: " + this.appInBackground);
    }

    @Override // com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor
    public int currentLaunchType() {
        return this.launchType;
    }
}
