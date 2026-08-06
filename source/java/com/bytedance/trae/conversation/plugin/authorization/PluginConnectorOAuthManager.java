package com.bytedance.trae.conversation.plugin.authorization;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.retrofit2.Converter;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J<\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020\u00052\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dJS\u0010.\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00052!\u0010/\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u001e0\u001d2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e0,J\u0006\u00104\u001a\u00020\u001eJ\"\u00105\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0006\u00106\u001a\u00020\u001eJ*\u00107\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0006\u00108\u001a\u00020\u001eJ*\u00109\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dJ \u0010:\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u0005J\u0006\u0010=\u001a\u00020\u001eJ:\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082@¢\u0006\u0002\u0010BJ2\u0010C\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@2\u0006\u0010$\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082@¢\u0006\u0002\u0010DJ:\u0010E\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082@¢\u0006\u0002\u0010BJ\u000e\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020#J\u0006\u0010J\u001a\u00020\nJ\u0016\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\u0018\u0010L\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0018\u0010M\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u00020@H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;", "", "<init>", "()V", "SCHEME_CN", "", "SCHEME_OVERSEA", "OAUTH_HOST", "OAUTH_PATH", "POLL_INTERVAL_MS", "", "QRCODE_PROVIDERS", "", "DESKTOP_REDIRECT_PROVIDERS", "CUSTOM_AUTH_POLLING_PROVIDERS", "WEBVIEW_PROVIDERS", "DESKTOP_POLL_INTERVAL_MS", "CUSTOM_AUTH_POLL_INTERVAL_MS", "POLL_TIMEOUT_MS", "POLL_CONSECUTIVE_ERROR_THRESHOLD", "", "lock", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mainHandler", "Landroid/os/Handler;", "activeJob", "Lkotlinx/coroutines/Job;", "pendingCompletion", "Lkotlin/Function1;", "", "pendingProvider", "pendingAuthRequestId", "authStartTimeMs", "isQrCodeProvider", "", "provider", "isDesktopRedirectProvider", "isCustomAuthPollingProvider", "isWebViewProvider", "startOAuth", "context", "Landroid/content/Context;", "onBrowserOpened", "Lkotlin/Function0;", "onComplete", "startQrCodeAuth", "onQrCodeReady", "Lkotlin/ParameterName;", "name", "qrcodeUrl", "onError", "cancelQrCodeAuth", "startDesktopRedirectAuth", "cancelDesktopRedirectAuth", "startCustomAuthPollingAuth", "cancelCustomAuthPolling", "startWebViewAuth", "reportWebViewAuthResult", PageDataManager.EXTRA_STATUS, "authRequestId", "cancelWebViewAuth", "pollCustomAuth", TracingConstants.KEY_TRACE_NAME, "Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;", "transactionId", "(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollListConnectorConnections", "(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPolling", "handleCallback", "uri", "Landroid/net/Uri;", "hasPendingOAuth", "authDurationMs", "clearPendingAndGetCompletion", "buildMobileCallbackUrl", "buildMiddlePageUrl", "buildLarkCallbackUrl", "createService", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginConnectorOAuthManager {
    private static final long CUSTOM_AUTH_POLL_INTERVAL_MS = 1000;
    private static final long DESKTOP_POLL_INTERVAL_MS = 2000;
    private static final String OAUTH_HOST = "oauth";
    private static final String OAUTH_PATH = "/plugin-connector/callback";
    private static final int POLL_CONSECUTIVE_ERROR_THRESHOLD = 5;
    private static final long POLL_INTERVAL_MS = 1000;
    private static final long POLL_TIMEOUT_MS = 300000;
    private static final String SCHEME_CN = "traecn";
    private static final String SCHEME_OVERSEA = "traei18n";
    private static Job activeJob;
    private static long authStartTimeMs;
    private static String pendingAuthRequestId;
    private static Function1<? super String, Unit> pendingCompletion;
    private static volatile String pendingProvider;
    public static final PluginConnectorOAuthManager INSTANCE = new PluginConnectorOAuthManager();
    private static final Set<String> QRCODE_PROVIDERS = SetsKt.setOf("wecom");
    private static final Set<String> DESKTOP_REDIRECT_PROVIDERS = SetsKt.setOf(new String[]{"dingtalk", "tencent-docs"});
    private static final Set<String> CUSTOM_AUTH_POLLING_PROVIDERS = SetsKt.setOf("kdocs");
    private static final Set<String> WEBVIEW_PROVIDERS = SetsKt.setOf(new String[]{"lark", "feishu"});
    private static final Object lock = new Object();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private PluginConnectorOAuthManager() {
    }

    public final boolean isQrCodeProvider(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        return QRCODE_PROVIDERS.contains(provider);
    }

    public final boolean isDesktopRedirectProvider(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        return DESKTOP_REDIRECT_PROVIDERS.contains(provider);
    }

    public final boolean isCustomAuthPollingProvider(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        return CUSTOM_AUTH_POLLING_PROVIDERS.contains(provider);
    }

    public final boolean isWebViewProvider(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        return WEBVIEW_PROVIDERS.contains(provider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startOAuth$default(PluginConnectorOAuthManager pluginConnectorOAuthManager, Context context, String str, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        pluginConnectorOAuthManager.startOAuth(context, str, function0, function1);
    }

    public final void startOAuth(Context context, String provider, Function0<Unit> onBrowserOpened, Function1<? super String, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        Object obj = lock;
        synchronized (obj) {
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            pendingCompletion = onComplete;
            pendingProvider = provider;
            pendingAuthRequestId = uuid;
            authStartTimeMs = System.currentTimeMillis();
            Unit unit = Unit.INSTANCE;
        }
        Context applicationContext = context.getApplicationContext();
        String buildMobileCallbackUrl = buildMobileCallbackUrl(uuid, provider);
        Job launch$default = BuildersKt.launch$default(scope, (CoroutineContext) null, CoroutineStart.LAZY, new PluginConnectorOAuthManager$startOAuth$job$1(createService(), provider, buildMobileCallbackUrl, applicationContext, onBrowserOpened, null), 1, (Object) null);
        synchronized (obj) {
            activeJob = launch$default;
            Unit unit2 = Unit.INSTANCE;
        }
        launch$default.start();
    }

    public final void startQrCodeAuth(String provider, Function1<? super String, Unit> onQrCodeReady, Function1<? super String, Unit> onComplete, Function0<Unit> onError) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(onQrCodeReady, "onQrCodeReady");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Object obj = lock;
        synchronized (obj) {
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            pendingProvider = provider;
            authStartTimeMs = System.currentTimeMillis();
            Unit unit = Unit.INSTANCE;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String buildMobileCallbackUrl = buildMobileCallbackUrl(uuid, provider);
        Job launch$default = BuildersKt.launch$default(scope, (CoroutineContext) null, CoroutineStart.LAZY, new PluginConnectorOAuthManager$startQrCodeAuth$job$1(createService(), provider, buildMobileCallbackUrl, onComplete, onError, onQrCodeReady, null), 1, (Object) null);
        synchronized (obj) {
            activeJob = launch$default;
            Unit unit2 = Unit.INSTANCE;
        }
        launch$default.start();
    }

    public final void cancelQrCodeAuth() {
        synchronized (lock) {
            pendingProvider = null;
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void startDesktopRedirectAuth(String provider, Function1<? super String, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Object obj = lock;
        synchronized (obj) {
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            pendingProvider = provider;
            authStartTimeMs = System.currentTimeMillis();
            Unit unit = Unit.INSTANCE;
        }
        Job launch$default = BuildersKt.launch$default(scope, (CoroutineContext) null, CoroutineStart.LAZY, new PluginConnectorOAuthManager$startDesktopRedirectAuth$job$1(createService(), provider, onComplete, null), 1, (Object) null);
        synchronized (obj) {
            activeJob = launch$default;
            Unit unit2 = Unit.INSTANCE;
        }
        launch$default.start();
    }

    public final void cancelDesktopRedirectAuth() {
        synchronized (lock) {
            pendingProvider = null;
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void startCustomAuthPollingAuth(Context context, String provider, Function1<? super String, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Object obj = lock;
        synchronized (obj) {
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            pendingProvider = provider;
            authStartTimeMs = System.currentTimeMillis();
            Unit unit = Unit.INSTANCE;
        }
        Context applicationContext = context.getApplicationContext();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String buildMobileCallbackUrl = buildMobileCallbackUrl(uuid, provider);
        Job launch$default = BuildersKt.launch$default(scope, (CoroutineContext) null, CoroutineStart.LAZY, new PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1(createService(), provider, buildMobileCallbackUrl, onComplete, applicationContext, null), 1, (Object) null);
        synchronized (obj) {
            activeJob = launch$default;
            Unit unit2 = Unit.INSTANCE;
        }
        launch$default.start();
    }

    public final void cancelCustomAuthPolling() {
        synchronized (lock) {
            pendingProvider = null;
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void startWebViewAuth(Context context, String provider, Function1<? super String, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        synchronized (lock) {
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
            pendingProvider = provider;
            pendingCompletion = onComplete;
            pendingAuthRequestId = uuid;
            authStartTimeMs = System.currentTimeMillis();
            Unit unit = Unit.INSTANCE;
        }
        PluginAuthWebViewActivity.INSTANCE.start(context, buildMiddlePageUrl(provider, uuid), provider);
    }

    public final boolean reportWebViewAuthResult(String provider, final String status, String authRequestId) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (lock) {
            if (pendingCompletion == null) {
                FLogger.INSTANCE.w("ConnectorOAuth", "reportWebViewAuthResult: no pending completion");
                PluginTracker.INSTANCE.trackAuthFail(provider, "callback_no_pending");
                return false;
            }
            String str = pendingAuthRequestId;
            if (str != null && !Intrinsics.areEqual(authRequestId, str)) {
                FLogger.INSTANCE.w("ConnectorOAuth", "reportWebViewAuthResult: auth_request_id mismatch");
                PluginTracker.INSTANCE.trackAuthFail(provider, "callback_request_id_mismatch");
                return false;
            }
            if (pendingProvider != null && !Intrinsics.areEqual(provider, pendingProvider)) {
                FLogger.INSTANCE.w("ConnectorOAuth", "reportWebViewAuthResult: provider mismatch, expected=" + pendingProvider + ", got=" + provider);
                PluginTracker.INSTANCE.trackAuthFail(provider, "callback_provider_mismatch");
                return false;
            }
            objectRef.element = pendingCompletion;
            pendingCompletion = null;
            pendingProvider = null;
            pendingAuthRequestId = null;
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
            Unit unit = Unit.INSTANCE;
            mainHandler.post(new Runnable() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PluginConnectorOAuthManager.reportWebViewAuthResult$lambda$13(objectRef, status);
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportWebViewAuthResult$lambda$13(Ref.ObjectRef objectRef, String str) {
        Function1 function1 = (Function1) objectRef.element;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void cancelWebViewAuth() {
        synchronized (lock) {
            pendingProvider = null;
            pendingCompletion = null;
            pendingAuthRequestId = null;
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pollCustomAuth(IConnectorOAuthApi iConnectorOAuthApi, String str, String str2, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
        PluginConnectorOAuthManager$pollCustomAuth$1 pluginConnectorOAuthManager$pollCustomAuth$1;
        Object obj;
        int i;
        String str3;
        Function1<? super String, Unit> function12;
        if (continuation instanceof PluginConnectorOAuthManager$pollCustomAuth$1) {
            pluginConnectorOAuthManager$pollCustomAuth$1 = (PluginConnectorOAuthManager$pollCustomAuth$1) continuation;
            if ((pluginConnectorOAuthManager$pollCustomAuth$1.label & Integer.MIN_VALUE) != 0) {
                pluginConnectorOAuthManager$pollCustomAuth$1.label -= Integer.MIN_VALUE;
                obj = pluginConnectorOAuthManager$pollCustomAuth$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pluginConnectorOAuthManager$pollCustomAuth$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    PluginConnectorOAuthManager$pollCustomAuth$result$1 pluginConnectorOAuthManager$pollCustomAuth$result$1 = new PluginConnectorOAuthManager$pollCustomAuth$result$1(str, iConnectorOAuthApi, str2, function1, null);
                    str3 = str;
                    pluginConnectorOAuthManager$pollCustomAuth$1.L$0 = str3;
                    function12 = function1;
                    pluginConnectorOAuthManager$pollCustomAuth$1.L$1 = function12;
                    pluginConnectorOAuthManager$pollCustomAuth$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(300000L, pluginConnectorOAuthManager$pollCustomAuth$result$1, pluginConnectorOAuthManager$pollCustomAuth$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Function1<? super String, Unit> function13 = (Function1) pluginConnectorOAuthManager$pollCustomAuth$1.L$1;
                    String str4 = (String) pluginConnectorOAuthManager$pollCustomAuth$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    function12 = function13;
                    str3 = str4;
                }
                if (((Unit) obj) != null) {
                    PluginTracker.INSTANCE.trackAuthFail(str3, "custom_poll_timeout");
                    synchronized (lock) {
                        pendingProvider = null;
                        Unit unit = Unit.INSTANCE;
                    }
                    CoroutineContext main = Dispatchers.getMain();
                    PluginConnectorOAuthManager$pollCustomAuth$3 pluginConnectorOAuthManager$pollCustomAuth$3 = new PluginConnectorOAuthManager$pollCustomAuth$3(function12, null);
                    pluginConnectorOAuthManager$pollCustomAuth$1.L$0 = null;
                    pluginConnectorOAuthManager$pollCustomAuth$1.L$1 = null;
                    pluginConnectorOAuthManager$pollCustomAuth$1.label = 2;
                    if (BuildersKt.withContext(main, pluginConnectorOAuthManager$pollCustomAuth$3, pluginConnectorOAuthManager$pollCustomAuth$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        pluginConnectorOAuthManager$pollCustomAuth$1 = new PluginConnectorOAuthManager$pollCustomAuth$1(this, continuation);
        obj = pluginConnectorOAuthManager$pollCustomAuth$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginConnectorOAuthManager$pollCustomAuth$1.label;
        if (i != 0) {
        }
        if (((Unit) obj) != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pollListConnectorConnections(IConnectorOAuthApi iConnectorOAuthApi, String str, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
        PluginConnectorOAuthManager$pollListConnectorConnections$1 pluginConnectorOAuthManager$pollListConnectorConnections$1;
        Object obj;
        int i;
        if (continuation instanceof PluginConnectorOAuthManager$pollListConnectorConnections$1) {
            pluginConnectorOAuthManager$pollListConnectorConnections$1 = (PluginConnectorOAuthManager$pollListConnectorConnections$1) continuation;
            if ((pluginConnectorOAuthManager$pollListConnectorConnections$1.label & Integer.MIN_VALUE) != 0) {
                pluginConnectorOAuthManager$pollListConnectorConnections$1.label -= Integer.MIN_VALUE;
                obj = pluginConnectorOAuthManager$pollListConnectorConnections$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pluginConnectorOAuthManager$pollListConnectorConnections$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    C0742xfa524675 c0742xfa524675 = new C0742xfa524675(str, iConnectorOAuthApi, function1, null);
                    pluginConnectorOAuthManager$pollListConnectorConnections$1.L$0 = str;
                    pluginConnectorOAuthManager$pollListConnectorConnections$1.L$1 = function1;
                    pluginConnectorOAuthManager$pollListConnectorConnections$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(300000L, c0742xfa524675, pluginConnectorOAuthManager$pollListConnectorConnections$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    function1 = (Function1) pluginConnectorOAuthManager$pollListConnectorConnections$1.L$1;
                    str = (String) pluginConnectorOAuthManager$pollListConnectorConnections$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Unit) obj) != null) {
                    PluginTracker.INSTANCE.trackAuthFail(str, "desktop_poll_timeout");
                    synchronized (lock) {
                        pendingProvider = null;
                        Unit unit = Unit.INSTANCE;
                    }
                    CoroutineContext main = Dispatchers.getMain();
                    PluginConnectorOAuthManager$pollListConnectorConnections$3 pluginConnectorOAuthManager$pollListConnectorConnections$3 = new PluginConnectorOAuthManager$pollListConnectorConnections$3(function1, null);
                    pluginConnectorOAuthManager$pollListConnectorConnections$1.L$0 = null;
                    pluginConnectorOAuthManager$pollListConnectorConnections$1.L$1 = null;
                    pluginConnectorOAuthManager$pollListConnectorConnections$1.label = 2;
                    if (BuildersKt.withContext(main, pluginConnectorOAuthManager$pollListConnectorConnections$3, pluginConnectorOAuthManager$pollListConnectorConnections$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        pluginConnectorOAuthManager$pollListConnectorConnections$1 = new PluginConnectorOAuthManager$pollListConnectorConnections$1(this, continuation);
        obj = pluginConnectorOAuthManager$pollListConnectorConnections$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginConnectorOAuthManager$pollListConnectorConnections$1.label;
        if (i != 0) {
        }
        if (((Unit) obj) != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startPolling(IConnectorOAuthApi iConnectorOAuthApi, String str, String str2, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
        PluginConnectorOAuthManager$startPolling$1 pluginConnectorOAuthManager$startPolling$1;
        Object obj;
        int i;
        String str3;
        Function1<? super String, Unit> function12;
        if (continuation instanceof PluginConnectorOAuthManager$startPolling$1) {
            pluginConnectorOAuthManager$startPolling$1 = (PluginConnectorOAuthManager$startPolling$1) continuation;
            if ((pluginConnectorOAuthManager$startPolling$1.label & Integer.MIN_VALUE) != 0) {
                pluginConnectorOAuthManager$startPolling$1.label -= Integer.MIN_VALUE;
                obj = pluginConnectorOAuthManager$startPolling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pluginConnectorOAuthManager$startPolling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    PluginConnectorOAuthManager$startPolling$result$1 pluginConnectorOAuthManager$startPolling$result$1 = new PluginConnectorOAuthManager$startPolling$result$1(str, iConnectorOAuthApi, str2, function1, null);
                    str3 = str;
                    pluginConnectorOAuthManager$startPolling$1.L$0 = str3;
                    function12 = function1;
                    pluginConnectorOAuthManager$startPolling$1.L$1 = function12;
                    pluginConnectorOAuthManager$startPolling$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(300000L, pluginConnectorOAuthManager$startPolling$result$1, pluginConnectorOAuthManager$startPolling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Function1<? super String, Unit> function13 = (Function1) pluginConnectorOAuthManager$startPolling$1.L$1;
                    String str4 = (String) pluginConnectorOAuthManager$startPolling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    function12 = function13;
                    str3 = str4;
                }
                if (((Unit) obj) != null) {
                    PluginTracker.INSTANCE.trackAuthFail(str3, "qrcode_poll_timeout");
                    synchronized (lock) {
                        pendingProvider = null;
                        Unit unit = Unit.INSTANCE;
                    }
                    CoroutineContext main = Dispatchers.getMain();
                    PluginConnectorOAuthManager$startPolling$3 pluginConnectorOAuthManager$startPolling$3 = new PluginConnectorOAuthManager$startPolling$3(function12, null);
                    pluginConnectorOAuthManager$startPolling$1.L$0 = null;
                    pluginConnectorOAuthManager$startPolling$1.L$1 = null;
                    pluginConnectorOAuthManager$startPolling$1.label = 2;
                    if (BuildersKt.withContext(main, pluginConnectorOAuthManager$startPolling$3, pluginConnectorOAuthManager$startPolling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        pluginConnectorOAuthManager$startPolling$1 = new PluginConnectorOAuthManager$startPolling$1(this, continuation);
        obj = pluginConnectorOAuthManager$startPolling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pluginConnectorOAuthManager$startPolling$1.label;
        if (i != 0) {
        }
        if (((Unit) obj) != null) {
        }
    }

    public final void handleCallback(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter("provider");
        String queryParameter2 = uri.getQueryParameter(PageDataManager.EXTRA_STATUS);
        String queryParameter3 = uri.getQueryParameter("auth_request_id");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (lock) {
            if (pendingCompletion == null) {
                FLogger.INSTANCE.w("ConnectorOAuth", "handleCallback: no pending completion");
                PluginTracker pluginTracker = PluginTracker.INSTANCE;
                if (queryParameter == null) {
                    queryParameter = "unknown";
                }
                pluginTracker.trackAuthFail(queryParameter, "callback_no_pending");
                return;
            }
            String str = pendingAuthRequestId;
            if (str != null && !Intrinsics.areEqual(queryParameter3, str)) {
                FLogger.INSTANCE.w("ConnectorOAuth", "handleCallback: auth_request_id mismatch");
                PluginTracker pluginTracker2 = PluginTracker.INSTANCE;
                if (queryParameter == null) {
                    queryParameter = "unknown";
                }
                pluginTracker2.trackAuthFail(queryParameter, "callback_request_id_mismatch");
                return;
            }
            if (queryParameter != null && pendingProvider != null && !Intrinsics.areEqual(queryParameter, pendingProvider)) {
                FLogger.INSTANCE.w("ConnectorOAuth", "handleCallback: provider mismatch, expected=" + pendingProvider + ", got=" + queryParameter);
                PluginTracker.INSTANCE.trackAuthFail(queryParameter, "callback_provider_mismatch");
                return;
            }
            objectRef.element = pendingCompletion;
            pendingCompletion = null;
            pendingProvider = null;
            pendingAuthRequestId = null;
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
            Unit unit = Unit.INSTANCE;
            final String str2 = Intrinsics.areEqual(queryParameter2, "success") ? "success" : "user_cancel";
            mainHandler.post(new Runnable() { // from class: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PluginConnectorOAuthManager.handleCallback$lambda$19(objectRef, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCallback$lambda$19(Ref.ObjectRef objectRef, String str) {
        Function1 function1 = (Function1) objectRef.element;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final boolean hasPendingOAuth() {
        boolean z;
        synchronized (lock) {
            z = pendingCompletion != null;
        }
        return z;
    }

    public final long authDurationMs() {
        long coerceAtLeast;
        synchronized (lock) {
            coerceAtLeast = RangesKt.coerceAtLeast(System.currentTimeMillis() - authStartTimeMs, 0L);
        }
        return coerceAtLeast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<String, Unit> clearPendingAndGetCompletion() {
        Function1 function1;
        synchronized (lock) {
            function1 = pendingCompletion;
            pendingCompletion = null;
            pendingProvider = null;
            pendingAuthRequestId = null;
            Job job = activeJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            activeJob = null;
        }
        return function1;
    }

    private final String buildMobileCallbackUrl(String authRequestId, String provider) {
        String uri = new Uri.Builder().scheme(AppHost.INSTANCE.isOversea() ? SCHEME_OVERSEA : SCHEME_CN).authority(OAUTH_HOST).path(OAUTH_PATH).appendQueryParameter("auth_request_id", authRequestId).appendQueryParameter("provider", provider).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    private final String buildMiddlePageUrl(String provider, String authRequestId) {
        String host = HostResolver.INSTANCE.getHost(HostType.PLUGIN_WEB);
        String uri = new Uri.Builder().scheme("https").authority(host).path(Intrinsics.areEqual(provider, "lark") ? "lark-oauth" : "feishu-oauth").appendQueryParameter("trae_client", "mobile").appendQueryParameter(ITiktokService.ResponseConstants.REDIRECT_URL, buildLarkCallbackUrl(authRequestId)).appendQueryParameter("auth_scope_mode", "all").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    private final String buildLarkCallbackUrl(String authRequestId) {
        String uri = new Uri.Builder().scheme(AppHost.INSTANCE.isOversea() ? SCHEME_OVERSEA : SCHEME_CN).authority(OAUTH_HOST).path("/lark/callback").appendQueryParameter("auth_request_id", authRequestId).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    private final IConnectorOAuthApi createService() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        if (xTToken == null) {
            xTToken = "";
        }
        return (IConnectorOAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "connector_oauth", IConnectorOAuthApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), StringsKt.isBlank(xTToken) ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.to("X-Cloudide-Token", xTToken)), false, 36, (Object) null);
    }
}
