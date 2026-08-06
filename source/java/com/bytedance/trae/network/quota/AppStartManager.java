package com.bytedance.trae.network.quota;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppStartManager.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012J\u001a\u0010\u0019\u001a\u00020\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u001a\u001a\u00020\u000fJ\u001a\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/trae/network/quota/AppStartManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Lcom/ss/android/ugc/quota/launch/IBDNetworkLaunchMonitor;", "<init>", "()V", "TAG", "", "initialized", "", "startedActivityCount", "", "hasEverForeground", "isActivityCreated", "finishAll", "lastStartState", "Lcom/bytedance/trae/network/quota/AppStartState;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function1;", "", EventConstants.PARAM_SOURCE_INIT, "app", "Landroid/app/Application;", "addListener", "listener", "removeListener", "getLastStartState", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "updateStartState", "state", "onActivityStopped", "onActivityResumed", "onActivityPaused", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "notifyListeners", "currentLaunchType", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AppStartManager implements Application.ActivityLifecycleCallbacks, IBDNetworkLaunchMonitor {
    private static final String TAG = "AppStartManager";
    private static volatile boolean finishAll;
    private static volatile boolean hasEverForeground;
    private static volatile boolean initialized;
    private static volatile boolean isActivityCreated;
    private static volatile int startedActivityCount;
    public static final AppStartManager INSTANCE = new AppStartManager();
    private static volatile AppStartState lastStartState = AppStartState.NormalStart;
    private static final CopyOnWriteArraySet<Function1<AppStartState, Unit>> listeners = new CopyOnWriteArraySet<>();

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

    private AppStartManager() {
    }

    public final void init(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            AppStartManager appStartManager = INSTANCE;
            initialized = true;
            app.registerActivityLifecycleCallbacks(appStartManager);
            AppInfoProvider.INSTANCE.init();
            TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.ColdStart);
            appStartManager.updateStartState(AppStartState.ColdStart);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addListener(Function1<? super AppStartState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    public final void removeListener(Function1<? super AppStartState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final AppStartState getLastStartState() {
        return lastStartState;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        isActivityCreated = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        AppStartState appStartState;
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean z = startedActivityCount > 0;
        startedActivityCount++;
        if (z) {
            return;
        }
        if (!hasEverForeground) {
            appStartState = null;
        } else if (isActivityCreated && finishAll) {
            finishAll = false;
            TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.WarmStart);
            appStartState = AppStartState.WarmStart;
        } else {
            TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.HotStart);
            appStartState = AppStartState.HotStart;
        }
        hasEverForeground = true;
        if (appStartState != null) {
            INSTANCE.updateStartState(appStartState);
        }
    }

    private final void updateStartState(AppStartState state) {
        lastStartState = state;
        notifyListeners(state);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        startedActivityCount--;
        if (startedActivityCount <= 0) {
            startedActivityCount = 0;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (startedActivityCount <= 0) {
            isActivityCreated = false;
            finishAll = true;
        }
    }

    private final void notifyListeners(AppStartState state) {
        Object obj;
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) it.next();
            try {
                Result.Companion companion = Result.Companion;
                function1.invoke(state);
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Result.exceptionOrNull-impl(obj);
        }
    }

    public int currentLaunchType() {
        return lastStartState.getValue();
    }
}
