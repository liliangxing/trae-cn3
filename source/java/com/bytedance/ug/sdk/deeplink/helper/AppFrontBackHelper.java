package com.bytedance.ug.sdk.deeplink.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.resolver.ResolverManager;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import com.bytedance.ug.sdk.deeplink.utils.CommonUtils;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppFrontBackHelper {
    private static final String TAG = "AppFrontBackHelper";
    private final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
    private volatile boolean isForeground;
    private final LinkedList<Activity> mActivityStack;
    private final CopyOnWriteArrayList<IAppStatusListener> mAppStatusListeners;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class InstanceHolder {
        static AppFrontBackHelper sInstance = new AppFrontBackHelper();

        InstanceHolder() {
        }
    }

    public static AppFrontBackHelper getInstance() {
        return InstanceHolder.sInstance;
    }

    private AppFrontBackHelper() {
        this.mAppStatusListeners = new CopyOnWriteArrayList<>();
        this.activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.ug.sdk.deeplink.helper.AppFrontBackHelper.1
            private int activityStartCount = 0;

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
                if (activity == null) {
                    return;
                }
                AppFrontBackHelper.this.mActivityStack.remove(activity);
                AppFrontBackHelper.this.mActivityStack.add(activity);
                if (CommonUtils.isInWhiteList(activity)) {
                    ResolverManager.instance().parseIntent(activity, activity.getIntent());
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                String canonicalName = (activity == null || activity.getClass() == null) ? null : activity.getClass().getCanonicalName();
                if (!TextUtils.isEmpty(canonicalName)) {
                    List<String> forbiddenActivityList = HostCommonServices.getForbiddenActivityList();
                    if (!CollectionsUtils.isEmptyList(forbiddenActivityList) && activity != null) {
                        for (String str : forbiddenActivityList) {
                            if (canonicalName.equalsIgnoreCase(str)) {
                                Logger.m446d(AppFrontBackHelper.TAG, "the forbidden activity is " + str + " result the counter invalid where onActivityStarted");
                                return;
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(canonicalName)) {
                    Logger.m446d(AppFrontBackHelper.TAG, "the activity is null which results the counter valid where onActivityStarted");
                } else {
                    Logger.m446d(AppFrontBackHelper.TAG, "the activity is " + canonicalName + " which results the counter valid where onActivityStarted");
                }
                int i = this.activityStartCount + 1;
                this.activityStartCount = i;
                if (i == 1) {
                    handleEnterForeground(activity);
                }
            }

            private void handleEnterForeground(final Activity activity) {
                try {
                    if (Build.VERSION.SDK_INT < 29) {
                        AppFrontBackHelper.this.notifyForeground(activity);
                        return;
                    }
                    Window window = activity != null ? activity.getWindow() : null;
                    View decorView = window != null ? window.getDecorView() : null;
                    if (decorView != null) {
                        decorView.post(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.helper.AppFrontBackHelper.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AppFrontBackHelper.this.notifyForeground(activity);
                            }
                        });
                    } else {
                        postDelayed(activity);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            
                if (r1 > 0) goto L11;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private void postDelayed(final Activity activity) {
                long j;
                Handler handler = ThreadUtils.getHandler();
                if (handler == null) {
                    return;
                }
                if (HostCommonServices.getZlinkDepend() != null) {
                    j = HostCommonServices.getZlinkDepend().delayMillis();
                }
                j = 500;
                handler.postDelayed(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.helper.AppFrontBackHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AppFrontBackHelper.this.notifyForeground(activity);
                    }
                }, j);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                String canonicalName = (activity == null || activity.getClass() == null) ? null : activity.getClass().getCanonicalName();
                if (!TextUtils.isEmpty(canonicalName)) {
                    List<String> forbiddenActivityList = HostCommonServices.getForbiddenActivityList();
                    if (!CollectionsUtils.isEmptyList(forbiddenActivityList) && activity != null) {
                        for (String str : forbiddenActivityList) {
                            if (canonicalName.equalsIgnoreCase(str)) {
                                Logger.m446d(AppFrontBackHelper.TAG, "the forbidden activity is " + str + " result the counter invalid where onActivityStopped");
                                return;
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(canonicalName)) {
                    Logger.m446d(AppFrontBackHelper.TAG, "the activity is null which results the counter valid where onActivityStopped");
                } else {
                    Logger.m446d(AppFrontBackHelper.TAG, "the activity is " + canonicalName + " which results the counter valid where onActivityStopped");
                }
                int i = this.activityStartCount - 1;
                this.activityStartCount = i;
                if (i == 0) {
                    AppFrontBackHelper.this.notifyBackground(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null) {
                    AppFrontBackHelper.this.mActivityStack.remove(activity);
                }
            }
        };
        this.mActivityStack = new LinkedList<>();
    }

    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }

    public void registerAppStatusListener(IAppStatusListener iAppStatusListener) {
        if (iAppStatusListener == null || this.mAppStatusListeners.contains(iAppStatusListener)) {
            return;
        }
        this.mAppStatusListeners.add(iAppStatusListener);
    }

    public void registerAppStatusListener(IAppStatusListener iAppStatusListener, boolean z) {
        if (z && iAppStatusListener != null) {
            if (isForeground()) {
                iAppStatusListener.onFront(getTopActivity());
            } else {
                iAppStatusListener.onBack(getTopActivity());
            }
        }
        if (iAppStatusListener == null || this.mAppStatusListeners.contains(iAppStatusListener)) {
            return;
        }
        this.mAppStatusListeners.add(iAppStatusListener);
    }

    public void unRegisterAppStatusListener(IAppStatusListener iAppStatusListener) {
        Iterator<IAppStatusListener> it = this.mAppStatusListeners.iterator();
        while (it.hasNext()) {
            if (it.next() == iAppStatusListener) {
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyForeground(Activity activity) {
        Iterator<IAppStatusListener> it = this.mAppStatusListeners.iterator();
        while (it.hasNext()) {
            IAppStatusListener next = it.next();
            if (next != null) {
                next.onFront(activity);
            }
        }
        this.isForeground = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBackground(Activity activity) {
        Iterator<IAppStatusListener> it = this.mAppStatusListeners.iterator();
        while (it.hasNext()) {
            IAppStatusListener next = it.next();
            if (next != null) {
                next.onBack(activity);
            }
        }
        this.isForeground = false;
    }

    public boolean isForeground() {
        return this.isForeground;
    }

    public Activity getTopActivity() {
        try {
            if (this.mActivityStack.isEmpty()) {
                return null;
            }
            return this.mActivityStack.getLast();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
