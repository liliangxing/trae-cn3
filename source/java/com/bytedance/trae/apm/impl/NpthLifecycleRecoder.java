package com.bytedance.trae.apm.impl;

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
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.utils.StringKt;
import com.bytedance.trae.utils.logger.FLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NpthLifecycleRecoder.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0014\u001a\u00020\fJ\u001a\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010,\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J \u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0011H\u0016J\"\u00104\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J*\u00105\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u00108\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u00109\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010;\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010<\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010=\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010>\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J \u0010?\u001a\u00020\u001f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010,\u001a\u00020&H\u0016J\u000e\u0010@\u001a\u00020\u0006*\u0004\u0018\u00010$H\u0002J\u000e\u0010@\u001a\u00020\u0006*\u0004\u0018\u000102H\u0002J\n\u0010C\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010D\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010H\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010I\u001a\u00020\u0006*\u0004\u0018\u00010FH\u0002J\b\u0010J\u001a\u00020\u001fH\u0002J\b\u0010K\u001a\u00020\u001fH\u0002J\u0010\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u0006H\u0002J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060OR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "TAG", "", "DELAY_MILLIS", "", "firstCreated", "", "createdCount", "", "startedCount", "background", "destroyed", "appContext", "Landroid/content/Context;", "lifecycleData", "Ljava/util/concurrent/CopyOnWriteArrayList;", "maxLifeCycleCount", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "delayStopRunnable", "Ljava/lang/Runnable;", "delayDestroyRunnable", "onAppCreate", "", "app", "Landroid/app/Application;", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "onFragmentAttached", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "context", "onFragmentCreated", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFragmentStarted", "onFragmentResumed", "onFragmentStopped", "onFragmentViewDestroyed", "onFragmentDestroyed", "onFragmentDetached", "onFragmentPaused", "onFragmentSaveInstanceState", "getClassPrefix", "timeFormatter", "Ljava/text/SimpleDateFormat;", "getCurTime", "recordLifecycle", "target", "", "msg", MessagePart.TYPE_LOG, "simpleName", "onAppForeground", "onAppBackground", "addLifecycleData", "string", "getLifecycleData", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NpthLifecycleRecoder extends FragmentManager.FragmentLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static final long DELAY_MILLIS = 300;
    private static final String TAG = "LifecycleRecorder";
    private static Context appContext;
    private static int createdCount;
    private static int startedCount;
    public static final NpthLifecycleRecoder INSTANCE = new NpthLifecycleRecoder();
    private static boolean firstCreated = true;
    private static boolean background = true;
    private static boolean destroyed = true;
    private static final CopyOnWriteArrayList<String> lifecycleData = new CopyOnWriteArrayList<>();
    private static int maxLifeCycleCount = 100;

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private static final Lazy handler = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.apm.impl.NpthLifecycleRecoder$$ExternalSyntheticLambda0
        public final Object invoke() {
            Handler handler_delegate$lambda$0;
            handler_delegate$lambda$0 = NpthLifecycleRecoder.handler_delegate$lambda$0();
            return handler_delegate$lambda$0;
        }
    });
    private static final Runnable delayStopRunnable = new Runnable() { // from class: com.bytedance.trae.apm.impl.NpthLifecycleRecoder$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            NpthLifecycleRecoder.delayStopRunnable$lambda$1();
        }
    };
    private static final Runnable delayDestroyRunnable = new Runnable() { // from class: com.bytedance.trae.apm.impl.NpthLifecycleRecoder$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            NpthLifecycleRecoder.delayDestroyRunnable$lambda$2();
        }
    };
    private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    private NpthLifecycleRecoder() {
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
            NpthLifecycleRecoder npthLifecycleRecoder = INSTANCE;
            background = true;
            npthLifecycleRecoder.onAppBackground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayDestroyRunnable$lambda$2() {
        if (createdCount == 0) {
            destroyed = true;
        }
    }

    public static /* synthetic */ void onAppCreate$default(NpthLifecycleRecoder npthLifecycleRecoder, Application application, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1000;
        }
        npthLifecycleRecoder.onAppCreate(application, i);
    }

    public final void onAppCreate(Application app, int maxLifeCycleCount2) {
        Intrinsics.checkNotNullParameter(app, "app");
        appContext = app;
        maxLifeCycleCount = maxLifeCycleCount2;
        log(app, "onAppCreate, process:" + ApmContext.getCurrentProcessName() + ", " + AppHost.INSTANCE.getAppId() + ' ' + AppHost.INSTANCE.getBuildChannel() + ' ' + AppHost.INSTANCE.getVersionName() + ' ' + AppHost.INSTANCE.getVersionCode() + ' ' + AppHost.INSTANCE.isDebug());
        recordLifecycle(app, "onAppCreate");
        app.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = createdCount + 1;
        createdCount = i;
        if (i == 1) {
            if (destroyed) {
                destroyed = false;
            } else {
                getHandler().removeCallbacks(delayDestroyRunnable);
            }
        }
        boolean z = savedInstanceState != null;
        String str = "normal create";
        if (firstCreated) {
            firstCreated = false;
            if (z) {
                str = "maybe app recreate";
            }
        } else if (z) {
            str = "maybe activity recreate";
        }
        log(activity, "onActivityCreated, desc: ".concat(str));
        recordLifecycle(activity, "onActivityCreated");
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.registerFragmentLifecycleCallbacks(this, true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        recordLifecycle(activity, "onActivityStarted");
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
        recordLifecycle(activity, "onActivityResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        recordLifecycle(activity, "onActivityPaused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        recordLifecycle(activity, "onActivityStopped");
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
        recordLifecycle(activity, "onActivitySaveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        recordLifecycle(activity, "onActivityDestroyed");
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
        recordLifecycle(f, "onFragmentAttached");
    }

    public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentCreated");
    }

    public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(v, "v");
        recordLifecycle(f, "onFragmentViewCreated");
    }

    public void onFragmentStarted(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentStarted");
    }

    public void onFragmentResumed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentResumed");
    }

    public void onFragmentStopped(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentStopped");
    }

    public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentViewDestroyed");
    }

    public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentDestroyed");
    }

    public void onFragmentDetached(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentDetached");
    }

    public void onFragmentPaused(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        recordLifecycle(f, "onFragmentPaused");
    }

    public void onFragmentSaveInstanceState(FragmentManager fm, Fragment f, Bundle outState) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        recordLifecycle(f, "onFragmentSaveInstanceState");
    }

    private final String getClassPrefix(Activity activity) {
        return activity == null ? "null" : simpleName(activity);
    }

    private final String getClassPrefix(Fragment fragment) {
        if (fragment == null) {
            return "null";
        }
        FragmentActivity activity = fragment.getActivity();
        return (activity != null ? simpleName(activity) : "") + ' ' + simpleName(fragment);
    }

    private final String getCurTime() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return timeFormatter.format(new Date(currentTimeMillis));
        } catch (Throwable unused) {
            return String.valueOf(currentTimeMillis);
        }
    }

    private final void recordLifecycle(Object target, String msg) {
        String str;
        if (target instanceof Activity) {
            str = "[" + getClassPrefix((Activity) target) + "] " + msg;
        } else if (target instanceof Fragment) {
            str = "[" + getClassPrefix((Fragment) target) + "] " + msg;
        } else {
            str = "[" + simpleName(target) + "] " + msg;
        }
        if (StringKt.isNotNullOrEmpty(str)) {
            addLifecycleData("\n" + getCurTime() + ' ' + str);
        }
    }

    private final void log(Object target, String msg) {
        FLogger.INSTANCE.i(TAG, "[" + simpleName(target) + "] " + msg);
    }

    private final String simpleName(Object obj) {
        return obj == null ? "null" : obj.getClass().getSimpleName() + '@' + Integer.toHexString(obj.hashCode());
    }

    private final void onAppForeground() {
        recordLifecycle(appContext, "onAppForeground");
    }

    private final void onAppBackground() {
        recordLifecycle(appContext, "onAppBackground");
    }

    private final void addLifecycleData(String string) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = lifecycleData;
        copyOnWriteArrayList.add(string);
        if (copyOnWriteArrayList.size() > maxLifeCycleCount) {
            copyOnWriteArrayList.remove(0);
        }
    }

    public final List<String> getLifecycleData() {
        return lifecycleData;
    }
}
