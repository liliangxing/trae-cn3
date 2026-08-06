package com.bytedance.trae;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.apm.ApmContext;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.init.task.base.InitTaskHelperKt;
import com.bytedance.trae.init.task.util.AppDeviceEnv;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleMonitor.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\u0010\u0001\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u001c\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00101\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u00103\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u00104\u001a\u00020-H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J \u00106\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0016H\u0016J\"\u0010<\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J*\u0010=\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010>\u001a\u00020?2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010@\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010A\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010B\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010C\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010D\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010E\u001a\u00020!2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u000e\u0010F\u001a\u00020\u0006*\u0004\u0018\u00010'H\u0002J\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H*\u0004\u0018\u00010+H\u0002J\b\u0010J\u001a\u00020!H\u0002J\b\u0010K\u001a\u00020!H\u0002J\b\u0010L\u001a\u00020!H\u0002J\b\u0010M\u001a\u00020!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/bytedance/trae/LifecycleMonitor;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "TAG", "", "DELAY_MILLIS", "", "EVENT_ENTER_FOREGROUND", "EVENT_ENTER_BACKGROUND", "EVENT_ACTIVITY_STACK_CREATED", "EVENT_ACTIVITY_STACK_DESTROYED", "processStartMillis", "firstCreated", "", "createdCount", "", "startedCount", "background", "destroyed", "appContext", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "delayStopRunnable", "Ljava/lang/Runnable;", "delayDestroyRunnable", "onAppAttachBaseContext", "", "app", "Landroid/app/Application;", "onAppCreate", MessagePart.TYPE_LOG, "target", "", "msg", "onActivityPreCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "onFragmentAttached", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "context", "onFragmentCreated", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFragmentStarted", "onFragmentResumed", "onFragmentStopped", "onFragmentViewDestroyed", "onFragmentDestroyed", "onFragmentDetached", "simpleName", "from", "", "", "onAppForeground", "onAppBackground", "onActivityStackCreated", "onActivityStackDestroyed", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LifecycleMonitor extends FragmentManager.FragmentLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static final long DELAY_MILLIS = 300;
    private static final String EVENT_ACTIVITY_STACK_CREATED = "flow_activity_stack_created";
    private static final String EVENT_ACTIVITY_STACK_DESTROYED = "flow_activity_stack_destroyed";
    private static final String EVENT_ENTER_BACKGROUND = "flow_enter_background";
    private static final String EVENT_ENTER_FOREGROUND = "flow_enter_foreground";
    private static final String TAG = "flow_lifecycle";
    private static Context appContext;
    private static int createdCount;
    private static long processStartMillis;
    private static int startedCount;
    public static final LifecycleMonitor INSTANCE = new LifecycleMonitor();
    private static boolean firstCreated = true;
    private static boolean background = true;
    private static boolean destroyed = true;

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private static final Lazy handler = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.LifecycleMonitor$$ExternalSyntheticLambda0
        public final Object invoke() {
            Handler handler_delegate$lambda$0;
            handler_delegate$lambda$0 = LifecycleMonitor.handler_delegate$lambda$0();
            return handler_delegate$lambda$0;
        }
    });
    private static final Runnable delayStopRunnable = new Runnable() { // from class: com.bytedance.trae.LifecycleMonitor$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            LifecycleMonitor.delayStopRunnable$lambda$1();
        }
    };
    private static final Runnable delayDestroyRunnable = new Runnable() { // from class: com.bytedance.trae.LifecycleMonitor$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            LifecycleMonitor.delayDestroyRunnable$lambda$2();
        }
    };
    public static final int $stable = 8;

    private final void log(Object target, String msg) {
    }

    private LifecycleMonitor() {
    }

    private final Handler getHandler() {
        return (Handler) handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler handler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayStopRunnable$lambda$1() {
        if (startedCount == 0) {
            LifecycleMonitor lifecycleMonitor = INSTANCE;
            background = true;
            lifecycleMonitor.onAppBackground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayDestroyRunnable$lambda$2() {
        if (createdCount == 0) {
            LifecycleMonitor lifecycleMonitor = INSTANCE;
            destroyed = true;
            lifecycleMonitor.onActivityStackDestroyed();
        }
    }

    public final void onAppAttachBaseContext(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        processStartMillis = System.currentTimeMillis();
        appContext = app;
        log(app, "attachBaseContext, process:" + ApmContext.getCurrentProcessName());
    }

    public final void onAppCreate(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.registerActivityLifecycleCallbacks(this);
        AppDeviceEnv.INSTANCE.report();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, "onActivityPreCreated");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        String str;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = createdCount + 1;
        createdCount = i;
        if (i == 1) {
            if (destroyed) {
                destroyed = false;
                onActivityStackCreated();
            } else {
                getHandler().removeCallbacks(delayDestroyRunnable);
            }
        }
        boolean z = savedInstanceState != null;
        String simpleName = activity.getClass().getSimpleName();
        if (firstCreated) {
            firstCreated = false;
            str = z ? "maybe app recreate" : "normal create";
            InitTaskHelperKt.checkSuspiciousTask(processStartMillis);
            InitTaskHelperKt.monitorProcessRecreate(z, simpleName);
        } else {
            str = z ? "maybe activity recreate" : "normal create";
            InitTaskHelperKt.monitorActivityRecreate(z, simpleName);
        }
        log(activity, "onActivityCreated, refer:" + from(activity) + ", " + str);
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.registerFragmentLifecycleCallbacks(this, true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, "onActivityStarted");
        int i = startedCount + 1;
        startedCount = i;
        if (i == 1) {
            if (background) {
                background = false;
                onAppForeground();
            } else {
                getHandler().removeCallbacks(delayStopRunnable);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, "onActivityResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, "onActivityPaused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, "onActivityStopped");
        int i = startedCount - 1;
        startedCount = i;
        if (i != 0 || background) {
            return;
        }
        getHandler().postDelayed(delayStopRunnable, DELAY_MILLIS);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        log(activity, "onActivitySaveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, "onActivityDestroyed");
        int i = createdCount - 1;
        createdCount = i;
        if (i != 0 || destroyed) {
            return;
        }
        getHandler().postDelayed(delayDestroyRunnable, DELAY_MILLIS);
    }

    public void onFragmentAttached(FragmentManager fm, Fragment f, Context context) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(context, "context");
        log(f, "onFragmentAttached, hostActivity:" + simpleName(f.getActivity()) + ", parentFragment:" + simpleName(f.getParentFragment()));
    }

    public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        log(f, "onFragmentCreated, savedInstanceState" + (savedInstanceState == null ? "=" : "!=") + "null");
    }

    public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(v, "v");
        log(f, "onFragmentViewCreated");
    }

    public void onFragmentStarted(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        log(f, "onFragmentStarted");
    }

    public void onFragmentResumed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        log(f, "onFragmentResumed");
    }

    public void onFragmentStopped(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        log(f, "onFragmentStopped");
    }

    public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        log(f, "onFragmentViewDestroyed");
    }

    public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        log(f, "onFragmentDestroyed");
    }

    public void onFragmentDetached(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        log(f, "onFragmentDetached");
    }

    private final String simpleName(Object obj) {
        return obj == null ? "null" : obj.getClass().getSimpleName() + '@' + Integer.toHexString(obj.hashCode());
    }

    private final Comparable<?> from(Activity activity) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(activity != null ? activity.getReferrer() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Comparable<?> comparable = (Comparable) (Result.isFailure-impl(obj) ? null : obj);
        return comparable == null ? "unknown_null" : comparable;
    }

    private final void onAppForeground() {
        log(appContext, "onAppForeground");
        IApplog.INSTANCE.reportEvent(EVENT_ENTER_FOREGROUND);
    }

    private final void onAppBackground() {
        log(appContext, "onAppBackground");
        IApplog.INSTANCE.reportEvent(EVENT_ENTER_BACKGROUND);
    }

    private final void onActivityStackCreated() {
        log(appContext, "onActivityStackCreated");
        IApplog.INSTANCE.reportEvent(EVENT_ACTIVITY_STACK_CREATED);
    }

    private final void onActivityStackDestroyed() {
        log(appContext, "onActivityStackDestroyed");
        IApplog.INSTANCE.reportEvent(EVENT_ACTIVITY_STACK_DESTROYED);
    }
}
