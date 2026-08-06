package com.bytedance.android.monitorV2.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitorLifecycleManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000bJ\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/monitorV2/lifecycle/MonitorLifecycleManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "delegates", "", "Lcom/bytedance/android/monitorV2/lifecycle/MonitorLifecycleDelegate;", "foregroundManager", "Lcom/bytedance/android/monitorV2/lifecycle/ForegroundImpl;", "getForegroundManager", "()Lcom/bytedance/android/monitorV2/lifecycle/ForegroundImpl;", "addDelegate", "", "delegate", "clearDelegate", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "removeDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorLifecycleManager implements Application.ActivityLifecycleCallbacks {
    public static final MonitorLifecycleManager INSTANCE;
    private static final List<MonitorLifecycleDelegate> delegates;
    private static final ForegroundImpl foregroundManager;

    private MonitorLifecycleManager() {
    }

    static {
        MonitorLifecycleManager monitorLifecycleManager = new MonitorLifecycleManager();
        INSTANCE = monitorLifecycleManager;
        foregroundManager = new ForegroundImpl();
        delegates = new ArrayList();
        monitorLifecycleManager.addDelegate(new ForegroundLifecycleDelegate());
    }

    public final ForegroundImpl getForegroundManager() {
        return foregroundManager;
    }

    public final void addDelegate(MonitorLifecycleDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        delegates.add(delegate);
    }

    public final void removeDelegate(MonitorLifecycleDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        delegates.remove(delegate);
    }

    public final void clearDelegate() {
        delegates.clear();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<MonitorLifecycleDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(activity, savedInstanceState);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<MonitorLifecycleDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<MonitorLifecycleDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<MonitorLifecycleDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<MonitorLifecycleDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().onActivityStopped(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        Iterator<MonitorLifecycleDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().onActivitySaveInstanceState(activity, outState);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<MonitorLifecycleDelegate> it = delegates.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroyed(activity);
        }
    }
}
