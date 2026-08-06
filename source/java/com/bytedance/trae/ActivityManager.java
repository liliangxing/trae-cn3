package com.bytedance.trae;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityManager.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J(\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010(\u001a\u00020\t2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010*H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0,H\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0012\u0010/\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u00100\u001a\u00020\u001b2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t02J\b\u00103\u001a\u00020\u001bH\u0016J\u0014\u00104\u001a\u00020\u001b2\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0016J\u0018\u00105\u001a\u00020\r2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t02H\u0016J\u0016\u00106\u001a\u00020\u001b2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t02J\b\u00107\u001a\u00020\rH\u0016J\b\u00108\u001a\u00020\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020;H\u0016J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020;H\u0016J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020=H\u0016J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020=H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=0:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/trae/ActivityManager;", "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "activityStack", "Ljava/util/Stack;", "Landroid/app/Activity;", "startedActivityStack", "resumeActivity", "isBackground", "", "isPaused", "lastForegroundTime", "", "currentActivity", "getCurrentActivity", "()Landroid/app/Activity;", "resumActivity", "getResumActivity", "activityCount", "", "getActivityCount", "()Ljava/lang/Integer;", "onActivityCreated", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivityPreDestroyed", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "getPreviousActivity", "curActivity", "predicate", "Lkotlin/Function1;", "getActivityList", "", "pushActivity", "popActivity", "endActivity", "backPressActivity", "clazz", "Ljava/lang/Class;", "finishAllActivities", "finishActivitiesExcept", "containActivity", "finishFirstTopActivity", "isAppBackground", "isAppPaused", "appBackgroundListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "activityCallbacks", "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;", "addAppBackGroundListener", "listener", "removeAppBackGroundListener", "addActivityLifecycleCallback", "callback", "removeActivityLifecycleCallback", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ActivityManager implements ActivityStackManager, Application.ActivityLifecycleCallbacks {
    public static final String TAG = "LifecycleHandler";
    private final CopyOnWriteArrayList<ActivityStackManager.ActivityLifecycleCallbacks> activityCallbacks;
    private final Stack<Activity> activityStack;
    private final CopyOnWriteArrayList<ActivityStackManager.OnAppBackGroundListener> appBackgroundListeners;
    private boolean isBackground;
    private boolean isPaused;
    private long lastForegroundTime;
    private Activity resumeActivity;
    private final Stack<Activity> startedActivityStack;
    public static final int $stable = 8;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    public ActivityManager(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(this);
        this.activityStack = new Stack<>();
        this.startedActivityStack = new Stack<>();
        this.isBackground = true;
        this.isPaused = true;
        this.appBackgroundListeners = new CopyOnWriteArrayList<>();
        this.activityCallbacks = new CopyOnWriteArrayList<>();
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public Activity getCurrentActivity() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ActivityManager activityManager = this;
            obj = Result.constructor-impl((Activity) CollectionsKt.lastOrNull(this.startedActivityStack));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (Activity) obj;
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    /* renamed from: getResumActivity, reason: from getter */
    public Activity getResumeActivity() {
        return this.resumeActivity;
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public Integer getActivityCount() {
        return Integer.valueOf(this.activityStack.size());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        pushActivity(activity);
        Iterator<ActivityStackManager.ActivityLifecycleCallbacks> it = this.activityCallbacks.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().onCreate(activity, savedInstanceState);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.startedActivityStack.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.isPaused = false;
        if (this.isBackground) {
            this.lastForegroundTime = System.currentTimeMillis();
            this.isBackground = false;
            Iterator<ActivityStackManager.OnAppBackGroundListener> it = this.appBackgroundListeners.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().onAppForeground();
            }
        }
        Iterator<ActivityStackManager.ActivityLifecycleCallbacks> it2 = this.activityCallbacks.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            it2.next().onResumed(activity);
        }
        this.resumeActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.isPaused = true;
        Iterator<ActivityStackManager.ActivityLifecycleCallbacks> it = this.activityCallbacks.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().onPaused(activity);
        }
        this.resumeActivity = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.startedActivityStack.remove(activity);
        if (!this.isBackground && this.startedActivityStack.isEmpty()) {
            this.isBackground = true;
            Iterator<ActivityStackManager.OnAppBackGroundListener> it = this.appBackgroundListeners.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().onAppBackground();
            }
        }
        Iterator<ActivityStackManager.ActivityLifecycleCallbacks> it2 = this.activityCallbacks.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            it2.next().onStopped(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<ActivityStackManager.ActivityLifecycleCallbacks> it = this.activityCallbacks.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().onPreDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        popActivity(activity);
        if (this.activityStack.isEmpty()) {
            Iterator<ActivityStackManager.OnAppBackGroundListener> it = this.appBackgroundListeners.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().onAllActivityDestroyed();
            }
        }
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public Activity getPreviousActivity(Activity curActivity, Function1<? super Activity, Boolean> predicate) {
        boolean z;
        Intrinsics.checkNotNullParameter(curActivity, "curActivity");
        boolean z2 = false;
        for (int size = this.activityStack.size() - 1; size >= 0; size--) {
            if (z2) {
                Activity activity = this.activityStack.get(size);
                if (predicate != null) {
                    Intrinsics.checkNotNull(activity);
                    z = ((Boolean) predicate.invoke(activity)).booleanValue();
                } else {
                    z = true;
                }
                if (z && activity != null && !activity.isFinishing()) {
                    return activity;
                }
            } else if (this.activityStack.get(size) == curActivity) {
                z2 = true;
            }
        }
        return null;
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public List<Activity> getActivityList() {
        return CollectionsKt.toList(this.activityStack);
    }

    private final void pushActivity(Activity activity) {
        this.activityStack.add(activity);
    }

    private final void popActivity(Activity activity) {
        this.activityStack.remove(activity);
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public void endActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            this.activityStack.remove(activity);
        }
    }

    public final void backPressActivity(Class<? extends Activity> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Iterator<Activity> it = this.activityStack.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ComponentActivity componentActivity = (Activity) it.next();
            if (Intrinsics.areEqual(componentActivity.getClass(), clazz)) {
                if (componentActivity instanceof ComponentActivity) {
                    componentActivity.getOnBackPressedDispatcher().onBackPressed();
                } else {
                    componentActivity.finish();
                }
                this.activityStack.remove(componentActivity);
                return;
            }
        }
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public void finishAllActivities() {
        Iterator<Activity> it = this.activityStack.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().finish();
        }
        this.activityStack.clear();
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public void finishActivitiesExcept(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Iterator<Activity> it = this.activityStack.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Activity next = it.next();
            if (!clazz.isInstance(next)) {
                next.finish();
                it.remove();
            }
        }
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public boolean containActivity(Class<? extends Activity> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Iterator<Activity> it = this.activityStack.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getClass(), clazz)) {
                return true;
            }
        }
        return false;
    }

    public final void finishFirstTopActivity(Class<? extends Activity> clazz) {
        Activity activity;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Stack<Activity> stack = this.activityStack;
        ListIterator<Activity> listIterator = stack.listIterator(stack.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                activity = null;
                break;
            } else {
                activity = listIterator.previous();
                if (Intrinsics.areEqual(activity.getClass(), clazz)) {
                    break;
                }
            }
        }
        Activity activity2 = activity;
        if (activity2 != null) {
            activity2.finish();
            this.activityStack.remove(activity2);
        }
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    /* renamed from: isAppBackground, reason: from getter */
    public boolean getIsBackground() {
        return this.isBackground;
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    /* renamed from: isAppPaused, reason: from getter */
    public boolean getIsPaused() {
        return this.isPaused;
    }

    /* renamed from: lastForegroundTime, reason: from getter */
    public final long getLastForegroundTime() {
        return this.lastForegroundTime;
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public synchronized void addAppBackGroundListener(ActivityStackManager.OnAppBackGroundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!(!this.appBackgroundListeners.contains(listener))) {
            listener = null;
        }
        if (listener != null) {
            this.appBackgroundListeners.add(listener);
        }
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public synchronized void removeAppBackGroundListener(ActivityStackManager.OnAppBackGroundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.appBackgroundListeners.contains(listener)) {
            listener = null;
        }
        if (listener != null) {
            this.appBackgroundListeners.remove(listener);
        }
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public synchronized void addActivityLifecycleCallback(ActivityStackManager.ActivityLifecycleCallbacks callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(!this.activityCallbacks.contains(callback))) {
            callback = null;
        }
        if (callback != null) {
            this.activityCallbacks.add(callback);
        }
    }

    @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    public synchronized void removeActivityLifecycleCallback(ActivityStackManager.ActivityLifecycleCallbacks callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.activityCallbacks.contains(callback)) {
            callback = null;
        }
        if (callback != null) {
            this.activityCallbacks.remove(callback);
        }
    }
}
