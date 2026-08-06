package com.bytedance.ies.bullet.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifeCycleManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/core/LifeCycleManager;", "", "()V", "mActivityStack", "Ljava/util/LinkedList;", "Landroid/app/Activity;", "mIsRegister", "", "getActivityStack", "", "()[Landroid/app/Activity;", "isBlackActivity", "activity", "register", "", "application", "Landroid/app/Application;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LifeCycleManager {
    public static final LifeCycleManager INSTANCE = new LifeCycleManager();
    private static final LinkedList<Activity> mActivityStack = new LinkedList<>();
    private static volatile boolean mIsRegister;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBlackActivity(Activity activity) {
        return false;
    }

    private LifeCycleManager() {
    }

    public final Activity[] getActivityStack() {
        LinkedList<Activity> linkedList = mActivityStack;
        return (Activity[]) linkedList.toArray(new Activity[linkedList.size()]);
    }

    public final synchronized void register(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (mIsRegister) {
            return;
        }
        mIsRegister = true;
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.ies.bullet.core.LifeCycleManager$register$1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                boolean isBlackActivity;
                LinkedList linkedList;
                LinkedList linkedList2;
                LinkedList linkedList3;
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    isBlackActivity = LifeCycleManager.INSTANCE.isBlackActivity(activity);
                } catch (Throwable unused) {
                }
                if (isBlackActivity) {
                    return;
                }
                linkedList = LifeCycleManager.mActivityStack;
                if (linkedList.contains(activity)) {
                    linkedList3 = LifeCycleManager.mActivityStack;
                    linkedList3.remove(activity);
                }
                linkedList2 = LifeCycleManager.mActivityStack;
                linkedList2.add(activity);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, activity.getClass().getSimpleName() + " onActivityCreated", null, null, 6, null);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                boolean isBlackActivity;
                LinkedList linkedList;
                LinkedList linkedList2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    isBlackActivity = LifeCycleManager.INSTANCE.isBlackActivity(activity);
                    if (isBlackActivity) {
                        return;
                    }
                    linkedList = LifeCycleManager.mActivityStack;
                    if (!linkedList.contains(activity)) {
                        linkedList2 = LifeCycleManager.mActivityStack;
                        linkedList2.add(activity);
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, activity.getClass().getSimpleName() + " onActivityStarted", null, null, 6, null);
                } catch (Throwable unused) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                boolean isBlackActivity;
                LinkedList linkedList;
                LinkedList linkedList2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    isBlackActivity = LifeCycleManager.INSTANCE.isBlackActivity(activity);
                    if (isBlackActivity) {
                        return;
                    }
                    linkedList = LifeCycleManager.mActivityStack;
                    if (!linkedList.contains(activity)) {
                        linkedList2 = LifeCycleManager.mActivityStack;
                        linkedList2.add(activity);
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, activity.getClass().getSimpleName() + " onActivityResumed", null, null, 6, null);
                } catch (Throwable unused) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                boolean isBlackActivity;
                LinkedList linkedList;
                LinkedList linkedList2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    isBlackActivity = LifeCycleManager.INSTANCE.isBlackActivity(activity);
                    if (isBlackActivity) {
                        return;
                    }
                    linkedList = LifeCycleManager.mActivityStack;
                    if (!linkedList.contains(activity)) {
                        linkedList2 = LifeCycleManager.mActivityStack;
                        linkedList2.add(activity);
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, activity.getClass().getSimpleName() + " onActivityPaused", null, null, 6, null);
                } catch (Throwable unused) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                boolean isBlackActivity;
                LinkedList linkedList;
                LinkedList linkedList2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    isBlackActivity = LifeCycleManager.INSTANCE.isBlackActivity(activity);
                    if (isBlackActivity) {
                        return;
                    }
                    linkedList = LifeCycleManager.mActivityStack;
                    if (!linkedList.contains(activity)) {
                        linkedList2 = LifeCycleManager.mActivityStack;
                        linkedList2.add(activity);
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, activity.getClass().getSimpleName() + " onActivityStopped", null, null, 6, null);
                } catch (Throwable unused) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                boolean isBlackActivity;
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
                try {
                    isBlackActivity = LifeCycleManager.INSTANCE.isBlackActivity(activity);
                    if (isBlackActivity) {
                        return;
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, activity.getClass().getSimpleName() + " onActivitySaveInstanceState", null, null, 6, null);
                } catch (Throwable unused) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                boolean isBlackActivity;
                LinkedList linkedList;
                LinkedList linkedList2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    isBlackActivity = LifeCycleManager.INSTANCE.isBlackActivity(activity);
                    if (isBlackActivity) {
                        return;
                    }
                    linkedList = LifeCycleManager.mActivityStack;
                    if (linkedList.contains(activity)) {
                        linkedList2 = LifeCycleManager.mActivityStack;
                        linkedList2.remove(activity);
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, activity.getClass().getSimpleName() + " onActivityDestroyed", null, null, 6, null);
                } catch (Throwable unused) {
                }
            }
        });
    }
}
