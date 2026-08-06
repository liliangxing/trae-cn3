package com.bytedance.trae;

import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.lego.init.util.InitContext;
import com.bytedance.push.BDPush;
import com.bytedance.push.starter.PushHook;
import com.bytedance.push.starter.PushInitLancet;
import com.bytedance.rheatrace.RheaDependencyManager;
import com.bytedance.rheatrace.core.RheaTrace3;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.theme.ThemeManager;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.home.zlink.ZlinkInitializer;
import com.bytedance.trae.kmp.AndroidKmpHostInfo;
import com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler;
import com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler;
import com.bytedance.trae.kmp.host.KmpHostActionHandler;
import com.bytedance.trae.kmp.host.KmpHostActions;
import com.bytedance.trae.kmp.host.KmpHostDialogs;
import com.bytedance.trae.kmp.host.KmpHostEnvironment;
import com.bytedance.trae.kmp.host.KmpMediaLibrary;
import com.bytedance.trae.kmp.network.AndroidKmpHostResolverBridge;
import com.bytedance.trae.kmp.player.AndroidUniPlayerInitializer;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.login.user.UserInfo;
import com.bytedance.trae.network.AiRegion;
import com.bytedance.trae.network.BytecloudNetworkCacheReset;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.LoginContextProvider;
import com.bytedance.trae.utils.AppUtils;
import com.bytedance.trae.utils.LocaleManager;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.trae.utils.logger.ILogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: TraeApplication.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/TraeApplication;", "Landroid/app/Application;", "<init>", "()V", "startTime", "Lkotlin/Pair;", "", "getStartTime", "()Lkotlin/Pair;", "launcher", "Lcom/bytedance/trae/ILauncher;", "attachBaseContext", "", "base", "Landroid/content/Context;", "configureKmpHostActions", "context", "initFlogger", "initKeva", "onCreate", "unbindService", "conn", "Landroid/content/ServiceConnection;", "initAnyWhereDoor", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeApplication extends Application {
    private static final String TAG = "TraeApplication";
    private static TraeApplication inst;
    private ILauncher launcher;
    private final Pair<Long, Long> startTime = new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(System.currentTimeMillis()));

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // android.app.Application
    public void onCreate() {
        m768x63ce07b0(this);
    }

    public TraeApplication() {
        inst = this;
        InitContext.setCommonParams("application", this);
    }

    public final Pair<Long, Long> getStartTime() {
        return this.startTime;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        PrivacyAuthorizedLauncher privacyAuthorizedLauncher;
        Intrinsics.checkNotNullParameter(base, "base");
        ApiHost.initHostResolver();
        AndroidKmpHostResolverBridge.INSTANCE.configureFromNativeHostResolver();
        KmpHostEnvironment.INSTANCE.configure(new AndroidKmpHostInfo());
        AndroidUniPlayerInitializer.INSTANCE.initialize(base);
        configureKmpHostActions(base);
        KmpMediaLibrary kmpMediaLibrary = KmpMediaLibrary.INSTANCE;
        Context applicationContext = base.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = base;
        }
        kmpMediaLibrary.configure(new AndroidKmpMediaLibraryHandler(applicationContext, new Function0() { // from class: com.bytedance.trae.TraeApplication$$ExternalSyntheticLambda0
            public final Object invoke() {
                FragmentActivity attachBaseContext$lambda$0;
                attachBaseContext$lambda$0 = TraeApplication.attachBaseContext$lambda$0();
                return attachBaseContext$lambda$0;
            }
        }));
        KmpHostDialogs.INSTANCE.configure(new AndroidKmpHostDialogHandler(new Function0() { // from class: com.bytedance.trae.TraeApplication$$ExternalSyntheticLambda1
            public final Object invoke() {
                Activity attachBaseContext$lambda$1;
                attachBaseContext$lambda$1 = TraeApplication.attachBaseContext$lambda$1();
                return attachBaseContext$lambda$1;
            }
        }));
        HostResolver.INSTANCE.setLoginContextProvider(new LoginContextProvider() { // from class: com.bytedance.trae.TraeApplication$attachBaseContext$3
            public boolean isBytecloudLogin() {
                return BytecloudAuthManager.INSTANCE.isBytecloudLogin();
            }

            public boolean isEnterpriseLogin() {
                return Intrinsics.areEqual(TraeAuthStorage.INSTANCE.getLoginPlatform(), "enterprise");
            }

            public boolean isEnterpriseBoeEnv() {
                return DebugSettings.INSTANCE.isEnterpriseTestEnv();
            }

            public AiRegion getAiRegion() {
                AiRegion.Companion companion = AiRegion.Companion;
                UserInfo userInfo = TraeAuthStorage.INSTANCE.getUserInfo();
                return companion.from(userInfo != null ? userInfo.getAiRegion() : null);
            }
        });
        TraeApplication traeApplication = this;
        LifecycleMonitor.INSTANCE.onAppAttachBaseContext(traeApplication);
        InitContext.setCommonParams("base", base);
        initKeva(base);
        LocaleManager.INSTANCE.init();
        ThemeManager.INSTANCE.init();
        ServiceUtils.bindService();
        PrivacyManager.INSTANCE.init(base);
        boolean checkAgreed = PrivacyManager.INSTANCE.checkAgreed();
        if (!AppHost.INSTANCE.isOversea() && !checkAgreed && AppHost.INSTANCE.isPreinstallApp()) {
            privacyAuthorizedLauncher = new NoPrivacyAuthorizedLauncher();
        } else {
            privacyAuthorizedLauncher = new PrivacyAuthorizedLauncher();
        }
        this.launcher = privacyAuthorizedLauncher;
        privacyAuthorizedLauncher.beforeAttachBaseContext(base);
        super.attachBaseContext(LocaleManager.INSTANCE.wrapContext(base));
        ILauncher iLauncher = this.launcher;
        if (iLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
            iLauncher = null;
        }
        iLauncher.afterAttachBaseContext(base);
        TraeApplication traeApplication2 = this;
        if (!AppUtils.isMainProcess(traeApplication2)) {
            BDPush.getPushService().onAttachBaseContext(traeApplication);
        }
        if (RheaDependencyManager.enabled()) {
            RheaTrace3.init(traeApplication2, RheaDependencyManager.getAppStartCallback());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FragmentActivity attachBaseContext$lambda$0() {
        Activity resumeActivity = AppHost.INSTANCE.getActivityStackManager().getResumeActivity();
        if (resumeActivity == null) {
            resumeActivity = AppHost.INSTANCE.getActivityStackManager().getCurrentActivity();
        }
        if (resumeActivity instanceof FragmentActivity) {
            return (FragmentActivity) resumeActivity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity attachBaseContext$lambda$1() {
        Activity resumeActivity = AppHost.INSTANCE.getActivityStackManager().getResumeActivity();
        return resumeActivity == null ? AppHost.INSTANCE.getActivityStackManager().getCurrentActivity() : resumeActivity;
    }

    private final void configureKmpHostActions(final Context context) {
        KmpHostActions.INSTANCE.configure(new KmpHostActionHandler() { // from class: com.bytedance.trae.TraeApplication$configureKmpHostActions$1
            public void copyToClipboard(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Object systemService = applicationContext.getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", text));
            }

            public void showToast(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                CustomToast.showShort(applicationContext, message);
            }
        });
    }

    private final void initFlogger() {
        FLogger.INSTANCE.setLogger(new ILogger() { // from class: com.bytedance.trae.TraeApplication$initFlogger$1
            public String getDirPath() {
                return "";
            }

            public boolean isDebug() {
                return true;
            }

            public boolean isInitSuccess() {
                return true;
            }

            public void perfSceneTraceStart(String tag, String sceneName, String uniqId) {
                Intrinsics.checkNotNullParameter(tag, "tag");
            }

            public void perfTSceneTraceEnd(String tag, String sceneName, String uniqId) {
                Intrinsics.checkNotNullParameter(tag, "tag");
            }

            public void perfTraceLog(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
            }

            public void uploadALog(String scene, long startTime, long endTime, Function1<? super Boolean, Unit> unit) {
                Intrinsics.checkNotNullParameter(scene, "scene");
            }

            public void uploadAllLog(String scene, Function1<? super Boolean, Unit> unit) {
                Intrinsics.checkNotNullParameter(scene, "scene");
            }

            public void uploadAllLogV2(String scene, Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
                Intrinsics.checkNotNullParameter(scene, "scene");
            }

            /* renamed from: v */
            public void m773v(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                if (msg == null) {
                    msg = "";
                }
                Log.v(tag, msg);
            }

            /* renamed from: d */
            public void m769d(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                if (msg == null) {
                    msg = "";
                }
                Log.d(tag, msg);
            }

            /* renamed from: i */
            public void m772i(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                if (msg == null) {
                    msg = "";
                }
                Log.i(tag, msg);
            }

            /* renamed from: w */
            public void m774w(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                if (msg == null) {
                    msg = "";
                }
                Log.w(tag, msg);
            }

            /* renamed from: w */
            public void m775w(String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                if (msg == null) {
                    msg = "";
                }
                Log.w(tag, msg, tr);
            }

            /* renamed from: w */
            public void m776w(String tag, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Log.w(tag, tr);
            }

            /* renamed from: e */
            public void m770e(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                if (msg == null) {
                    msg = "";
                }
                Log.e(tag, msg);
            }

            /* renamed from: e */
            public void m771e(String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                if (msg == null) {
                    msg = "";
                }
                Log.e(tag, msg, tr);
            }
        });
    }

    private final void initKeva(Context base) {
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        Intrinsics.checkNotNullExpressionValue(kevaBuilder, "getInstance(...)");
        kevaBuilder.setContext(base);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2() {
        BytecloudAuthManager.INSTANCE.resetNetworkCache();
        return Unit.INSTANCE;
    }

    public void com_bytedance_trae_TraeApplication__onCreate$___twin___() {
        BytecloudNetworkCacheReset.INSTANCE.setResetAction(new Function0() { // from class: com.bytedance.trae.TraeApplication$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit onCreate$lambda$2;
                onCreate$lambda$2 = TraeApplication.onCreate$lambda$2();
                return onCreate$lambda$2;
            }
        });
        ILauncher iLauncher = this.launcher;
        ILauncher iLauncher2 = null;
        if (iLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
            iLauncher = null;
        }
        TraeApplication traeApplication = this;
        iLauncher.beforeOnCreate(traeApplication);
        super.onCreate();
        ILauncher iLauncher3 = this.launcher;
        if (iLauncher3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
        } else {
            iLauncher2 = iLauncher3;
        }
        iLauncher2.afterOnCreate(traeApplication);
        initAnyWhereDoor();
        ZlinkInitializer.INSTANCE.registerLifeCycle(traeApplication);
        if (PrivacyManager.INSTANCE.checkAgreed()) {
            ZlinkInitializer.INSTANCE.initAfterPrivacyAgreed(traeApplication);
        }
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.trae.TraeApplication$onCreate$2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

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
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    activity.setRequestedOrientation(1);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection conn) {
        Intrinsics.checkNotNullParameter(conn, "conn");
        try {
            super.unbindService(conn);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null && StringsKt.contains$default(message, "Service not registered", false, 2, (Object) null)) {
                FLogger.INSTANCE.e(TAG, "Ignored Huawei & Honor WebView unbindService crash", e);
                return;
            }
            throw e;
        }
    }

    private final void initAnyWhereDoor() {
        if (AppHost.INSTANCE.isDebug()) {
            try {
                Class.forName("com.bytedance.trae.anydoor.AnyDoorDebugInitializer").getMethod("init", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException unused) {
                FLogger.INSTANCE.i(TAG, "AnyDoor debug initializer not found");
            } catch (Exception e) {
                FLogger.INSTANCE.e(TAG, "AnyDoor debug initializer failed", e);
            }
        }
    }

    /* compiled from: TraeApplication.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/TraeApplication$Companion;", "", "<init>", "()V", "TAG", "", "value", "Lcom/bytedance/trae/TraeApplication;", "inst", "getInst", "()Lcom/bytedance/trae/TraeApplication;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TraeApplication getInst() {
            TraeApplication traeApplication = TraeApplication.inst;
            if (traeApplication != null) {
                return traeApplication;
            }
            Intrinsics.throwUninitializedPropertyAccessException("inst");
            return null;
        }
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Application")
    @Insert("onCreate")
    /* renamed from: com_bytedance_trae_TraeApplication_com_bytedance_push_starter_PushInitLancet_onCreate */
    public static void m768x63ce07b0(TraeApplication traeApplication) {
        Log.d("PushStarter", "hook of Application.onCreate by Lancet");
        if (!PushInitLancet.enableHook) {
            traeApplication.com_bytedance_trae_TraeApplication__onCreate$___twin___();
        } else if (PushHook.onHookApplicationOnCreate(traeApplication)) {
            traeApplication.com_bytedance_trae_TraeApplication__onCreate$___twin___();
        }
    }
}
