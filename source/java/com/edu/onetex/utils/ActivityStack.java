package com.edu.onetex.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityStack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/edu/onetex/utils/ActivityStack;", "", "()V", "isBackground", "", "sActivityStack", "Ljava/util/LinkedList;", "Landroid/app/Activity;", "sAppStatusChangedListeners", "Lcom/edu/onetex/utils/ActivityStack$OnAppStatusChangedListener;", "init", "", "application", "Landroid/app/Application;", "isAppBackground", "registerAppStatusListener", "statusListener", "unregisterAppStatusListener", "ActivityStackLifecycleCallbacks", "OnAppStatusChangedListener", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ActivityStack {
    public static final ActivityStack INSTANCE = new ActivityStack();
    private static final LinkedList<Activity> sActivityStack = new LinkedList<>();
    private static final LinkedList<OnAppStatusChangedListener> sAppStatusChangedListeners = new LinkedList<>();
    private static boolean isBackground = true;

    /* compiled from: ActivityStack.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/edu/onetex/utils/ActivityStack$OnAppStatusChangedListener;", "", "onBackground", "", "onForeground", "activity", "Landroid/app/Activity;", "isAppLaunch", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface OnAppStatusChangedListener {
        void onBackground();

        void onForeground(Activity activity, boolean isAppLaunch);
    }

    private ActivityStack() {
    }

    public static final /* synthetic */ LinkedList access$getSActivityStack$p(ActivityStack activityStack) {
        return sActivityStack;
    }

    public static final /* synthetic */ LinkedList access$getSAppStatusChangedListeners$p(ActivityStack activityStack) {
        return sAppStatusChangedListeners;
    }

    public static final /* synthetic */ boolean access$isBackground$p(ActivityStack activityStack) {
        return isBackground;
    }

    public final boolean isAppBackground() {
        return isBackground;
    }

    public final void registerAppStatusListener(OnAppStatusChangedListener statusListener) {
        Intrinsics.checkNotNullParameter(statusListener, "statusListener");
        LinkedList<OnAppStatusChangedListener> linkedList = sAppStatusChangedListeners;
        if (linkedList.contains(statusListener)) {
            return;
        }
        linkedList.add(statusListener);
    }

    public final void unregisterAppStatusListener(OnAppStatusChangedListener statusListener) {
        Intrinsics.checkNotNullParameter(statusListener, "statusListener");
        sAppStatusChangedListeners.remove(statusListener);
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(new ActivityStackLifecycleCallbacks());
    }

    /* compiled from: ActivityStack.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/edu/onetex/utils/ActivityStack$ActivityStackLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "activityStartCount", "", "isAppLaunch", "", "activityStoppedEvent", "", "activity", "Landroid/app/Activity;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPreStopped", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class ActivityStackLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private int activityStartCount;
        private boolean isAppLaunch = true;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ActivityStack.access$getSActivityStack$p(ActivityStack.INSTANCE).remove(activity);
            ActivityStack.access$getSActivityStack$p(ActivityStack.INSTANCE).add(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            int i = this.activityStartCount + 1;
            this.activityStartCount = i;
            if (i == 1 && ActivityStack.access$isBackground$p(ActivityStack.INSTANCE)) {
                ActivityStack activityStack = ActivityStack.INSTANCE;
                ActivityStack.isBackground = false;
                Iterator it = ActivityStack.access$getSAppStatusChangedListeners$p(ActivityStack.INSTANCE).iterator();
                while (it.hasNext()) {
                    ((OnAppStatusChangedListener) it.next()).onForeground(activity, this.isAppLaunch);
                }
                this.isAppLaunch = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                activityStoppedEvent(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                activityStoppedEvent(activity);
            }
        }

        private final void activityStoppedEvent(Activity activity) {
            try {
                int i = this.activityStartCount - 1;
                this.activityStartCount = i;
                if (i == 0) {
                    ActivityStack activityStack = ActivityStack.INSTANCE;
                    ActivityStack.isBackground = true;
                    Iterator it = ActivityStack.access$getSAppStatusChangedListeners$p(ActivityStack.INSTANCE).iterator();
                    while (it.hasNext()) {
                        ((OnAppStatusChangedListener) it.next()).onBackground();
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ActivityStack.access$getSActivityStack$p(ActivityStack.INSTANCE).remove(activity);
        }
    }
}
