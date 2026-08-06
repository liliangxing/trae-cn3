package com.ss.alive.monitor.track;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.Logger;
import com.ss.alive.monitor.MonitorLiveSetting;
import com.ss.alive.monitor.PkgTrackListener;
import com.ss.alive.monitor.ProcessStartInfo;
import com.ss.alive.monitor.p002db.MonitorLiveDBHelperDBHelper;
import com.ss.alive.monitor.p002db.ProcessStartDbInfo;
import com.ss.alive.monitor.util.ToolUtils;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ActivityAliveTracker implements IAliveTracker {
    private static final String TAG = "ActivityAliveTracker";
    private final Application mApplication;
    private AliveTrackerActivityLifecycleCallback mCallback;
    private File mFile;
    private final boolean mIsFirstProcess;

    public ActivityAliveTracker(Application application, boolean z) {
        this.mApplication = application;
        this.mIsFirstProcess = z;
        this.mFile = new File(application.getFilesDir(), "process_activity.lock");
    }

    public void monitorFirstActivity() {
        if (this.mIsFirstProcess) {
            doDeleteActivityLockFile();
        }
        AliveTrackerActivityLifecycleCallback aliveTrackerActivityLifecycleCallback = new AliveTrackerActivityLifecycleCallback(this.mApplication);
        this.mCallback = aliveTrackerActivityLifecycleCallback;
        this.mApplication.registerActivityLifecycleCallbacks(aliveTrackerActivityLifecycleCallback);
    }

    @Override // com.ss.alive.monitor.track.IAliveTracker
    public void trackPackageName(Context context, ProcessStartInfo processStartInfo, PkgTrackListener pkgTrackListener) {
        if (processStartInfo == null) {
            return;
        }
        this.mCallback.setPkgTrackListener(pkgTrackListener);
    }

    public void doDeleteActivityLockFile() {
        try {
            this.mFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class AliveTrackerActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        private final Application mApplication;
        private PkgTrackListener mPkgTrackListener;

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

        AliveTrackerActivityLifecycleCallback(Application application) {
            this.mApplication = application;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
        
            if (r4.this$0.mFile.createNewFile() != false) goto L21;
         */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onActivityCreated(Activity activity, Bundle bundle) {
            boolean z;
            String referrer = ActivityAliveTracker.getReferrer(activity);
            if (Logger.debug()) {
                Logger.d(ActivityAliveTracker.TAG, "startActivity = " + activity.getComponentName().getClassName() + ", referrer = " + referrer);
            }
            boolean z2 = true;
            boolean z3 = false;
            if (this.mPkgTrackListener != null) {
                if (ActivityAliveTracker.isValidReferrer(referrer, activity)) {
                    this.mPkgTrackListener.onTrackSuccess(referrer);
                }
                this.mPkgTrackListener = null;
                z = true;
            } else {
                z = false;
            }
            if (ToolUtils.isInBlackList(activity)) {
                return;
            }
            try {
                if (!ActivityAliveTracker.this.mFile.exists()) {
                }
                z2 = false;
                z3 = z2;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                this.mApplication.unregisterActivityLifecycleCallbacks(this);
                return;
            }
            if (z3) {
                ProcessStartInfo processStartInfo = new ProcessStartInfo();
                processStartInfo.startTime = com.ss.android.message.util.ToolUtils.currentTimeMillis();
                processStartInfo.endTime = -1L;
                processStartInfo.mIntent = activity.getIntent();
                processStartInfo.referrer = referrer;
                processStartInfo.process = ToolUtils.getCurProcessName(activity);
                processStartInfo.screenState = ToolUtils.getScreenState(activity);
                processStartInfo.startFlag = 4;
                if (MonitorLiveSetting.getInstance(this.mApplication).getMonitorAliveConfigModel().isMonitorAliveEnable) {
                    final ProcessStartDbInfo processStartDbInfo = new ProcessStartDbInfo();
                    processStartDbInfo.dataJson = processStartInfo.toJson().toString();
                    processStartDbInfo.endTime = -1L;
                    ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.track.ActivityAliveTracker.AliveTrackerActivityLifecycleCallback.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                MonitorLiveDBHelperDBHelper.getInstance(AliveTrackerActivityLifecycleCallback.this.mApplication).insertProcessStartDbInfo(processStartDbInfo);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
            this.mApplication.unregisterActivityLifecycleCallbacks(this);
        }

        void setPkgTrackListener(PkgTrackListener pkgTrackListener) {
            this.mPkgTrackListener = pkgTrackListener;
        }
    }

    static String getReferrer(Activity activity) {
        Uri referrer;
        String str = getmReferrerByReflect(activity);
        if (!isValidReferrer(str, activity) && (referrer = activity.getReferrer()) != null) {
            str = referrer.getHost();
        }
        if (!isValidReferrer(str, activity)) {
            str = activity.getCallingPackage();
        }
        if (isValidReferrer(str, activity)) {
            return str;
        }
        try {
            return activity.getPackageManager().getNameForUid(Binder.getCallingUid());
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidReferrer(String str, Activity activity) {
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, activity.getPackageName())) ? false : true;
    }

    private static String getmReferrerByReflect(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            return (String) declaredField.get(activity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
