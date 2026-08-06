package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class TransactionTooLargeOpt {
    private static final String ACTIVITY_HASHCODE_KEY = "TransactionTooLargeOptActivityHashCode";
    private static final String ACTIVITY_RECORD_KEY = "TransactionTooLargeOptActivityRecordKey";
    private static final String TAG = "TransactionTooLargeOpt";
    private static int sSaveRootBundleSize = 460800;
    private static boolean sStarted;
    private static List<String> sDisableActivities = Collections.EMPTY_LIST;
    private static boolean sForceClear = false;
    private static boolean sRestartOnRestore = false;
    private static final Map<String, Bundle> sKey2ContentMap = new HashMap();
    private static ILog sLog = new ILog() { // from class: com.bytedance.sysoptimizer.TransactionTooLargeOpt.1
        @Override // com.bytedance.sysoptimizer.TransactionTooLargeOpt.ILog
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.bytedance.sysoptimizer.TransactionTooLargeOpt.ILog
        public void e(String str, String str2) {
            Log.e(str, str2);
        }
    };
    private static final Application.ActivityLifecycleCallbacks ACTIVITY_LIFECYCLE_CALLBACKS = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sysoptimizer.TransactionTooLargeOpt.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            if (bundle == null) {
                return;
            }
            if (TransactionTooLargeOpt.isDisable(activity)) {
                TransactionTooLargeOpt.sLog.e(TransactionTooLargeOpt.TAG, "onActivityPreCreated disable for " + activity);
            } else {
                TransactionTooLargeOpt.restoreRootBundle(activity, bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            TransactionTooLargeOpt.sLog.d(TransactionTooLargeOpt.TAG, "onActivityStarted() called with: activity = [" + activity + "], remove bundle=[" + (((Bundle) TransactionTooLargeOpt.sKey2ContentMap.remove(TransactionTooLargeOpt.getActivityKey(activity))) != null) + "]");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TransactionTooLargeOpt.sLog.d(TransactionTooLargeOpt.TAG, "onActivityResumed() called with: activity = [" + activity + "], size = [" + TransactionTooLargeOpt.sKey2ContentMap.size() + "]");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TransactionTooLargeOpt.sLog.d(TransactionTooLargeOpt.TAG, "onActivityPaused() called with: activity = [" + activity + "]");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            TransactionTooLargeOpt.sLog.d(TransactionTooLargeOpt.TAG, "onActivityStopped() called with: activity = [" + activity + "]");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            TransactionTooLargeOpt.sLog.d(TransactionTooLargeOpt.TAG, "onActivitySaveInstanceState() called with: activity = [" + activity + "], outState = [" + bundle + "]");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
            if (TransactionTooLargeOpt.isDisable(activity)) {
                TransactionTooLargeOpt.sLog.e(TransactionTooLargeOpt.TAG, "onActivityPostSaveInstanceState disable for " + activity);
            } else {
                TransactionTooLargeOpt.saveRootBundle(activity, bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            boolean isFinishing = activity.isFinishing();
            TransactionTooLargeOpt.sLog.d(TransactionTooLargeOpt.TAG, "onActivityDestroyed() called with: activity = [" + activity + "], finishing = [" + isFinishing + "]");
            if (isFinishing) {
                TransactionTooLargeOpt.sLog.d(TransactionTooLargeOpt.TAG, "onActivityDestroyed() called with: activity = [" + activity + "], remove bundle=[" + (((Bundle) TransactionTooLargeOpt.sKey2ContentMap.remove(TransactionTooLargeOpt.getActivityKey(activity))) != null) + "]");
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface ILog {
        void d(String str, String str2);

        void e(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDisable(Activity activity) {
        String name = activity.getClass().getName();
        Iterator<String> it = sDisableActivities.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveRootBundle(Activity activity, Bundle bundle) {
        int bundleSize = bundleSize(bundle);
        if (bundleSize > sSaveRootBundleSize) {
            String activityKey = getActivityKey(activity);
            try {
                Bundle bundle2 = new Bundle();
                bundle2.putAll(bundle);
                sKey2ContentMap.put(activityKey, bundle2);
                bundle.clear();
                bundle.putString(ACTIVITY_RECORD_KEY, activityKey);
            } finally {
                try {
                    bundle.putString(ACTIVITY_HASHCODE_KEY, activityKey);
                    sLog.d(TAG, "saveRootBundle() called with: uuid = [" + activityKey + "], size=[" + bundleSize + "]");
                    return;
                } catch (Throwable th) {
                }
            }
            bundle.putString(ACTIVITY_HASHCODE_KEY, activityKey);
            sLog.d(TAG, "saveRootBundle() called with: uuid = [" + activityKey + "], size=[" + bundleSize + "]");
            return;
        }
        sLog.d(TAG, "saveRootBundle() called size = [" + bundleSize + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getActivityKey(Activity activity) {
        return activity.getClass().getName() + "@" + Integer.toHexString(activity.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void restoreRootBundle(Activity activity, Bundle bundle) {
        Bundle remove;
        Object obj = bundle.get(ACTIVITY_RECORD_KEY);
        if (obj instanceof String) {
            try {
                bundle.remove(ACTIVITY_RECORD_KEY);
                remove = sKey2ContentMap.remove(obj);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (remove == null) {
                sLog.d(TAG, "restoreRootBundle() called with: uuid = [" + obj + "], bundle == null");
                if (sRestartOnRestore) {
                    restart(activity);
                    return;
                }
                return;
            }
            bundle.putAll(remove);
            sLog.d(TAG, "restoreRootBundle() called with: uuid = [" + obj + "], activityHashCode=[" + bundle.getString(ACTIVITY_HASHCODE_KEY) + "]");
            return;
        }
        sLog.e(TAG, "restoreRootBundle() uuid = [" + obj + "]");
    }

    private static void restart(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            sLog.e(TAG, "application == null");
            return;
        }
        Intent launchIntentForPackage = application.getPackageManager().getLaunchIntentForPackage(application.getPackageName());
        if (launchIntentForPackage == null) {
            sLog.e(TAG, "intent == null");
            return;
        }
        activity.startActivity(Intent.makeRestartActivityTask(launchIntentForPackage.getComponent()));
        sLog.e(TAG, "RestartActivity");
        Runtime.getRuntime().exit(0);
    }

    private static byte[] bundle2Bytes(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeBundle(bundle);
            return obtain.marshall();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                obtain.recycle();
                return null;
            } finally {
                obtain.recycle();
            }
        }
    }

    private static int bundleSize(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.setDataPosition(0);
            obtain.writeBundle(bundle);
            return obtain.dataSize();
        } catch (Throwable th) {
            try {
                sLog.e(TAG, Log.getStackTraceString(th));
                return 0;
            } finally {
                obtain.recycle();
            }
        }
    }

    private static Bundle bytes2Bundle(byte[] bArr, ClassLoader classLoader) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return obtain.readBundle(classLoader);
        } finally {
            obtain.recycle();
        }
    }

    public static boolean start(ILog iLog, Application application, int i, boolean z, boolean z2, List<String> list) {
        if (Build.VERSION.SDK_INT < 29) {
            System.out.println("Ignore for sdk " + Build.VERSION.SDK_INT);
            return false;
        }
        if (sStarted) {
            System.out.println("Ignore for already started");
            return false;
        }
        sStarted = true;
        sSaveRootBundleSize = i;
        sForceClear = z;
        sRestartOnRestore = z2;
        sDisableActivities = list;
        sLog = iLog;
        application.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE_CALLBACKS);
        return true;
    }
}
