package com.bytedance.realx;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class RXAppStateMonitorAndroid implements Application.ActivityLifecycleCallbacks {
    private Context mContext;
    private Handler mHandler;
    private boolean mIsBackground;
    private HandlerThread mThread;
    private long nativeMonitor;
    private final String TAG = "ASMonitorAndroid";
    private final Set<Integer> mStartedActivitySet = new HashSet();
    private final Set<Integer> mPausedActivitySet = new HashSet();

    private native void nativeOnStateChange(long nativeMonitor, boolean isBackground);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    public RXAppStateMonitorAndroid(long nativeMonitor) {
        this.mIsBackground = false;
        this.nativeMonitor = 0L;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mContext = applicationContext;
        if (applicationContext == null) {
            RXLogging.e("ASMonitorAndroid", "context is null.");
            return;
        }
        Context applicationContext2 = applicationContext.getApplicationContext();
        this.mContext = applicationContext2;
        this.nativeMonitor = nativeMonitor;
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(this);
        } else {
            RXLogging.e("ASMonitorAndroid", "context not a Application obj.");
        }
        this.mIsBackground = checkBackground(this.mContext);
        HandlerThread handlerThread = new HandlerThread("appStatePoster");
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
    }

    private synchronized boolean getState() {
        return this.mIsBackground;
    }

    private synchronized void onStateChange(boolean isBackground) {
        if (isBackground == this.mIsBackground) {
            return;
        }
        this.mIsBackground = isBackground;
        if (this.nativeMonitor == 0) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.bytedance.realx.RXAppStateMonitorAndroid$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RXAppStateMonitorAndroid.this.m7835xb260bdff();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onStateChange$0$com-bytedance-realx-RXAppStateMonitorAndroid, reason: not valid java name */
    public /* synthetic */ void m7835xb260bdff() {
        synchronized (this) {
            long j = this.nativeMonitor;
            if (j == 0) {
                RXLogging.e("ASMonitorAndroid", "state monitor is reset.");
            } else {
                nativeOnStateChange(j, this.mIsBackground);
            }
        }
    }

    private synchronized void reset() {
        Context context = this.mContext;
        if (context != null && (context instanceof Application)) {
            ((Application) context).unregisterActivityLifecycleCallbacks(this);
        }
        this.nativeMonitor = 0L;
        this.mHandler = null;
        if (this.mThread != null) {
            this.mThread.quitSafely();
            this.mThread = null;
        }
    }

    private boolean checkBackground(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                RXLogging.e("ASMonitorAndroid", "activityManager is null.");
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                RXLogging.e("ASMonitorAndroid", "processInfoList is null.");
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && context.getPackageName().equals(runningAppProcessInfo.processName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            RXLogging.e("ASMonitorAndroid", "Get App background state failed. " + e);
            return false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.mStartedActivitySet.add(Integer.valueOf(activity.hashCode()));
        onStateChange(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.mStartedActivitySet.add(Integer.valueOf(activity.hashCode()));
        onStateChange(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.mPausedActivitySet.add(Integer.valueOf(activity.hashCode()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
    
        if (r5.mStartedActivitySet.size() == 0) goto L11;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityStopped(Activity activity) {
        int hashCode = activity.hashCode();
        boolean z = this.mIsBackground;
        if (this.mStartedActivitySet.contains(Integer.valueOf(hashCode))) {
            this.mStartedActivitySet.remove(Integer.valueOf(hashCode));
        } else {
            if (this.mStartedActivitySet.size() == 0) {
                if (!this.mPausedActivitySet.contains(Integer.valueOf(hashCode))) {
                    RXLogging.w("ASMonitorAndroid", "started set not contain activity" + activity);
                }
                z = true;
            }
            z = false;
        }
        onStateChange(z);
        this.mPausedActivitySet.remove(Integer.valueOf(hashCode));
    }
}
