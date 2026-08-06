package com.bytedance.trae.apm.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BinderTranTooLargeExp extends BasePlugin {
    private static final String ACTIVITY_RECORD_KEY = "BinderTranTooLargeExpActivityRecordKey";
    private static final int BUNDLE_SIZE_THRESHOLD = 460800;
    private static final String MONITOR_KEY = "binder_tran_too_large_exp";
    private static final int MONITOR_STEP_ONRESTORESTATE = 2;
    private static final int MONITOR_STEP_ONSAVESTATE = 1;
    private static final String TAG = "BinderTranTooLargeExp";
    private Application mApp;
    private final List<String> mDisableActivities;
    private final boolean mForceClear;
    private final LinkedHashMap<String, byte[]> mKey2ContentMap = new LinkedHashMap<>();
    private final Application.ActivityLifecycleCallbacks mLifecycleCallback = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.trae.apm.impl.BinderTranTooLargeExp.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            byte[] bArr;
            boolean z;
            boolean isEmpty;
            if (bundle == null) {
                com.bytedance.platform.godzilla.common.Logger.w(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPreCreated savedState is null");
                return;
            }
            if (BinderTranTooLargeExp.this.isDisable(activity)) {
                com.bytedance.platform.godzilla.common.Logger.e(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPreCreated disabled");
                return;
            }
            Object obj = bundle.get(BinderTranTooLargeExp.ACTIVITY_RECORD_KEY);
            if (obj == null) {
                com.bytedance.platform.godzilla.common.Logger.w(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPreCreated uuid is null");
                return;
            }
            if (!(obj instanceof String)) {
                com.bytedance.platform.godzilla.common.Logger.w(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPreCreated uuid is not String[" + obj + "]");
                return;
            }
            try {
                bundle.clear();
                bArr = (byte[]) BinderTranTooLargeExp.this.mKey2ContentMap.remove(obj);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    if (!BinderTranTooLargeExp.this.mRestartOnRestore || !bundle.isEmpty()) {
                        return;
                    }
                } finally {
                    if (BinderTranTooLargeExp.this.mRestartOnRestore && bundle.isEmpty()) {
                        BinderTranTooLargeExp.this.restart(activity);
                    }
                }
            }
            if (bArr == null) {
                com.bytedance.platform.godzilla.common.Logger.e(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPreCreated uuid = [" + obj + "], decoded == null");
                if (z) {
                    if (isEmpty) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            Bundle bytes2Bundle = BinderTranTooLargeExp.this.bytes2Bundle(bArr, activity.getClassLoader());
            if (bytes2Bundle != null) {
                bundle.putAll(bytes2Bundle);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("activity", activity.getComponentName().getClassName());
                jSONObject.put("step", 2);
                ApmAgent.monitorEvent(BinderTranTooLargeExp.MONITOR_KEY, jSONObject, (JSONObject) null, (JSONObject) null);
                com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPreCreated restore success uuid = [" + obj + "]");
            } else {
                com.bytedance.platform.godzilla.common.Logger.w(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPreCreated restore bundle is null uuid = [" + obj + "]");
            }
            if (!BinderTranTooLargeExp.this.mRestartOnRestore || !bundle.isEmpty()) {
                return;
            }
            BinderTranTooLargeExp.this.restart(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityCreated");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityResumed");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityPaused");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityStopped");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivitySaveInstanceState, outState = [" + bundle + "]");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
            if (!BinderTranTooLargeExp.this.isDisable(activity)) {
                byte[] bundle2Bytes = BinderTranTooLargeExp.this.bundle2Bytes(bundle);
                if (bundle2Bytes == null) {
                    if (BinderTranTooLargeExp.this.mForceClear) {
                        com.bytedance.platform.godzilla.common.Logger.e(BinderTranTooLargeExp.TAG, "[" + activity + "] onSaveState force clear");
                        bundle.clear();
                    }
                    com.bytedance.platform.godzilla.common.Logger.w(BinderTranTooLargeExp.TAG, "[" + activity + "] onSaveState bundleBytes is null");
                    return;
                }
                if (bundle2Bytes.length > BinderTranTooLargeExp.BUNDLE_SIZE_THRESHOLD) {
                    String uuid = UUID.randomUUID().toString();
                    try {
                        BinderTranTooLargeExp.this.mKey2ContentMap.put(uuid, bundle2Bytes);
                        bundle.clear();
                        bundle.putString(BinderTranTooLargeExp.ACTIVITY_RECORD_KEY, uuid);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("activity", activity.getComponentName().getClassName());
                        jSONObject.put("step", 1);
                        ApmAgent.monitorEvent(BinderTranTooLargeExp.MONITOR_KEY, jSONObject, (JSONObject) null, (JSONObject) null);
                        com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onSaveState success uuid = [" + uuid + "]");
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                com.bytedance.platform.godzilla.common.Logger.w(BinderTranTooLargeExp.TAG, "[" + activity + "] onSaveState length not reach");
                return;
            }
            com.bytedance.platform.godzilla.common.Logger.e(BinderTranTooLargeExp.TAG, "[" + activity + "] onSaveState disabled");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            com.bytedance.platform.godzilla.common.Logger.i(BinderTranTooLargeExp.TAG, "[" + activity + "] onActivityDestroyed");
        }
    };
    private final boolean mRestartOnRestore;
    private boolean mStarted;

    public String getName() {
        return TAG;
    }

    public BinderTranTooLargeExp(boolean z, boolean z2, List<String> list) {
        this.mForceClear = z;
        this.mRestartOnRestore = z2;
        this.mDisableActivities = list;
    }

    public void init(Application application) {
        super.init(application);
        this.mApp = application;
        com.bytedance.platform.godzilla.common.Logger.i(TAG, "init");
    }

    public void start() {
        super.start();
        if (Build.VERSION.SDK_INT < 29) {
            com.bytedance.platform.godzilla.common.Logger.w(TAG, "start, ignore sdk=" + Build.VERSION.SDK_INT);
        } else {
            if (this.mStarted) {
                com.bytedance.platform.godzilla.common.Logger.w(TAG, "start, already started");
                return;
            }
            this.mStarted = true;
            this.mApp.registerActivityLifecycleCallbacks(this.mLifecycleCallback);
            com.bytedance.platform.godzilla.common.Logger.i(TAG, "start");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisable(Activity activity) {
        String name = activity.getClass().getName();
        Iterator<String> it = this.mDisableActivities.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restart(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            com.bytedance.platform.godzilla.common.Logger.e(TAG, "[" + activity + "] restart, application == null");
            return;
        }
        Intent launchIntentForPackage = application.getPackageManager().getLaunchIntentForPackage(application.getPackageName());
        if (launchIntentForPackage == null) {
            com.bytedance.platform.godzilla.common.Logger.e(TAG, "[" + activity + "] restart, intent == null");
            return;
        }
        activity.startActivity(Intent.makeRestartActivityTask(launchIntentForPackage.getComponent()));
        com.bytedance.platform.godzilla.common.Logger.e(TAG, "[" + activity + "] restart success then exit");
        Runtime.getRuntime().exit(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] bundle2Bytes(Bundle bundle) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle bytes2Bundle(byte[] bArr, ClassLoader classLoader) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return obtain.readBundle(classLoader);
        } finally {
            obtain.recycle();
        }
    }

    public void stop() {
        super.stop();
        com.bytedance.platform.godzilla.common.Logger.i(TAG, "stop");
    }

    public void destroy() {
        super.destroy();
        com.bytedance.platform.godzilla.common.Logger.i(TAG, "destroy");
    }
}
