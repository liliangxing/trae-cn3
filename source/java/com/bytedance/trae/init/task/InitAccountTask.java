package com.bytedance.trae.init.task;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.ApiHost;
import com.bytedance.trae.FirstInitStyle;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.account.TTAccount;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptStore;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.conversation.network.TaskTemplateRepository;
import com.bytedance.trae.home.solo.setting.UserPayIdentityCache;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository;
import com.bytedance.trae.im.network.INetworkDepend;
import com.bytedance.trae.im.service.tenant.TenantUserConfigRepository;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.bytedance.trae.init.task.bdturing.BDTuringAccount;
import com.bytedance.trae.login.AccountUtils;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ForceLogoutUtils;
import com.bytedance.trae.login.api.IAccountStatusListener;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.region.UserRegionManager;
import com.bytedance.trae.login.traeauth.TokenRefreshTrigger;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.FrontierConfig;
import com.bytedance.trae.network.FrontierSwitchConfig;
import com.bytedance.trae.network.HubClientMetadata;
import com.bytedance.trae.network.HubConnectionListener;
import com.bytedance.trae.network.IChangeLanguageApi;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.platform.service.ApplogService;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* compiled from: InitAccountTask.kt */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005*\u0001'\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0012\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0012\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\u001dH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/trae/init/task/InitAccountTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "frontierConnectStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "frontierConnectGeneration", "Ljava/util/concurrent/atomic/AtomicInteger;", "hasBeenLoggedIn", "runInternal", "", "accountStatusCallback", "Lcom/bytedance/trae/login/api/IAccountStatusListener;", "syncAppLogAccountType", "accountInfo", "Lcom/bytedance/trae/login/api/AccountInfo;", "syncAppLogAccountTypeIfCurrent", "preloadModelsOnAppStart", "businessScene", "buildModelPreloadTrigger", "startFrontierConnect", "isLoginEvent", "", "reportApm", "hasUserId", "didCount", "", "clearAllNotifications", "resolveLoginPageSource", "navigateToLogin", TimonPipeline.KEY_SOURCE, "appBackgroundListener", "com/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1", "Lcom/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1;", "isFrontierReconnectDisabled", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitAccountTask implements IInitTask, IInitReportTask {
    private static final String ACCOUNT_STATUS_STICKY = "get_account_status_siticky";
    private static final String SOURCE_ACCOUNT_DELETED = "account_deleted";
    private static final String SOURCE_BYTECLOUD_RT_EXPIRED = "bytecloud_rt_expired";
    private static final String SOURCE_COLD_LAUNCH = "cold_launch";
    private static final String SOURCE_REFRESH_TOKEN_EXPIRED = "refresh_token_expired";
    private static final String SOURCE_RISK_CONTROL = "risk_control";
    private static final String SOURCE_SESSION_EXPIRED = "session_expired";
    private static final String SOURCE_USER_LOGOUT = "user_logout";
    private static final String TAG = "InitAccountTask";
    public static final int $stable = 8;
    private final String scene = ServiceType.BASIC_SERVICE;
    private final String firstStyle = FirstInitStyle.AsyncThreadWhenFirst;
    private final AtomicBoolean frontierConnectStarted = new AtomicBoolean(false);
    private final AtomicInteger frontierConnectGeneration = new AtomicInteger(0);
    private final AtomicBoolean hasBeenLoggedIn = new AtomicBoolean(false);
    private final IAccountStatusListener accountStatusCallback = new IAccountStatusListener() { // from class: com.bytedance.trae.init.task.InitAccountTask$$ExternalSyntheticLambda1
        public final void onAccountStatusChanged(AccountStatus accountStatus, String str) {
            InitAccountTask.accountStatusCallback$lambda$1(InitAccountTask.this, accountStatus, str);
        }
    };
    private final InitAccountTask$appBackgroundListener$1 appBackgroundListener = new ActivityStackManager.OnAppBackGroundListener() { // from class: com.bytedance.trae.init.task.InitAccountTask$appBackgroundListener$1
        @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager.OnAppBackGroundListener
        public void onAllActivityDestroyed() {
        }

        @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager.OnAppBackGroundListener
        public void onAppBackground() {
        }

        @Override // com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager.OnAppBackGroundListener
        public void onAppForeground() {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            boolean z = false;
            if (iLoginService != null && iLoginService.isTraeLoggedIn()) {
                z = true;
            }
            if (z) {
                TraeAuthManager.refreshIDEAccessTokenIfNeeded$default(TraeAuthManager.INSTANCE, TokenRefreshTrigger.FOREGROUND_HEARTBEAT, (TraeAuthManager.TraeAuthCallback) null, 2, (Object) null);
                BytecloudTokenValidator.INSTANCE.validateOnForegroundIfNeeded();
            }
        }
    };

    /* compiled from: InitAccountTask.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountStatus.values().length];
            try {
                iArr[AccountStatus.LOGGED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AccountStatus.LOGGED_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AccountStatus.LOGGED_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public boolean checkFirstStartAsyncTaskInit(String str) {
        return IInitReportTask.DefaultImpls.checkFirstStartAsyncTaskInit(this, str);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask, java.lang.Runnable
    public void run() {
        IInitReportTask.DefaultImpls.run(this);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getScene() {
        return this.scene;
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getFirstStyle() {
        return this.firstStyle;
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public void runInternal() {
        FrontierSwitchConfig.INSTANCE.loadFromCache();
        ForceLogoutUtils.INSTANCE.addOnLogoutListener(new InitAccountTask$runInternal$1());
        BDTuringAccount.INSTANCE.init();
        TTAccount.INSTANCE.init();
        if (!AppHost.INSTANCE.isOversea()) {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            boolean z = false;
            if (iLoginService != null && !iLoginService.isTraeLoggedIn()) {
                z = true;
            }
            if (z) {
                AccountUtils.INSTANCE.preLoadAccountPhoneOneKeyInfo();
            }
        }
        INetworkDepend.INSTANCE.getInstance();
        UserRegionManager.INSTANCE.registerLifecycle();
        UserPayIdentityService.registerUserPayIdentityProxy(new InitAccountTask$runInternal$2());
        ILoginService iLoginService2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService2 != null) {
            iLoginService2.registerAccountStatusChangeListener(this.accountStatusCallback, true);
        }
        AppHost.INSTANCE.getActivityStackManager().addAppBackGroundListener(this.appBackgroundListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accountStatusCallback$lambda$1(final InitAccountTask initAccountTask, AccountStatus accountStatus, String str) {
        Intrinsics.checkNotNullParameter(accountStatus, "accountStatus");
        Intrinsics.checkNotNullParameter(str, "businessScene");
        int i = WhenMappings.$EnumSwitchMapping$0[accountStatus.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return;
            }
            initAccountTask.syncAppLogAccountType(null);
            try {
                if (!initAccountTask.isFrontierReconnectDisabled()) {
                    initAccountTask.frontierConnectGeneration.incrementAndGet();
                    INetworkDepend.INSTANCE.getInstance().disconnect();
                    initAccountTask.frontierConnectStarted.set(false);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("frontierConnectGeneration", initAccountTask.frontierConnectGeneration);
                    jSONObject.put("isFrontierReconnectDisabled", 0);
                    ApmAgent.monitorEvent("frontier_disconnect", (JSONObject) null, jSONObject, (JSONObject) null);
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("isFrontierReconnectDisabled", 0);
                    ApmAgent.monitorEvent("frontier_disconnect", (JSONObject) null, jSONObject2, (JSONObject) null);
                }
            } catch (Throwable unused) {
            }
            initAccountTask.clearAllNotifications();
            UserPayIdentityCache.INSTANCE.clear();
            IRemoteModelsApi.INSTANCE.onAccountChanged();
            TenantUserConfigRepository.INSTANCE.onAccountChanged();
            SiteMessageRepository.INSTANCE.handleLogout();
            if (!Intrinsics.areEqual(str, ACCOUNT_STATUS_STICKY)) {
                initAccountTask.navigateToLogin(initAccountTask.resolveLoginPageSource(str));
            }
            TrackerCommonParams.INSTANCE.syncHeaderCustomParams();
            return;
        }
        initAccountTask.hasBeenLoggedIn.set(true);
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        IRemoteModelsApi.INSTANCE.onAccountChanged();
        NewFeaturePromptStore newFeaturePromptStore = NewFeaturePromptStore.INSTANCE;
        String userId = accountInfo != null ? accountInfo.getUserId() : null;
        if (userId == null) {
            userId = "";
        }
        NewFeaturePromptStore.recordLoginObserved$default(newFeaturePromptStore, userId, 0L, 2, null);
        initAccountTask.syncAppLogAccountType(accountInfo);
        initAccountTask.startFrontierConnect(!Intrinsics.areEqual(str, ACCOUNT_STATUS_STICKY));
        TraeAuthManager.refreshIDEAccessTokenIfNeeded$default(TraeAuthManager.INSTANCE, TokenRefreshTrigger.COLD_LAUNCH, (TraeAuthManager.TraeAuthCallback) null, 2, (Object) null);
        if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            BytecloudTokenValidator.INSTANCE.validateOnColdLaunch();
        } else if (iLoginService != null) {
            iLoginService.refreshUserInfo(new Function1() { // from class: com.bytedance.trae.init.task.InitAccountTask$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit accountStatusCallback$lambda$1$lambda$0;
                    accountStatusCallback$lambda$1$lambda$0 = InitAccountTask.accountStatusCallback$lambda$1$lambda$0(InitAccountTask.this, (AccountInfo) obj);
                    return accountStatusCallback$lambda$1$lambda$0;
                }
            }, (Function0) null);
        }
        UserRegionManager.INSTANCE.refreshRegion();
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            BillingUpgradePromptCoordinator.INSTANCE.prewarm();
        } else {
            UserPayIdentityCache.INSTANCE.fetchPayStatus();
            UserPayIdentityCache.INSTANCE.fetchUserEntStatus();
        }
        initAccountTask.clearAllNotifications();
        TaskTemplateRepository.INSTANCE.preload();
        TenantUserConfigRepository.INSTANCE.onAccountChanged();
        initAccountTask.preloadModelsOnAppStart(str);
        TrackerCommonParams.INSTANCE.syncHeaderCustomParams();
        SiteMessageRepository.INSTANCE.init(AppHost.INSTANCE.getApplication());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accountStatusCallback$lambda$1$lambda$0(InitAccountTask initAccountTask, AccountInfo accountInfo) {
        Intrinsics.checkNotNullParameter(accountInfo, "it");
        initAccountTask.syncAppLogAccountTypeIfCurrent(accountInfo);
        return Unit.INSTANCE;
    }

    private final void syncAppLogAccountType(AccountInfo accountInfo) {
        String value;
        AccountType accountType;
        IApplog.Companion companion = IApplog.INSTANCE;
        if (accountInfo == null || (accountType = accountInfo.getAccountType()) == null || (value = accountType.getValue()) == null) {
            value = AccountType.UNKNOWN.getValue();
        }
        String userId = accountInfo != null ? accountInfo.getUserId() : null;
        if (userId == null) {
            userId = "";
        }
        String tenantId = accountInfo != null ? accountInfo.getTenantId() : null;
        if (tenantId == null) {
            tenantId = "";
        }
        String tenantName = accountInfo != null ? accountInfo.getTenantName() : null;
        companion.onAccountTypeChanged(value, userId, tenantId, tenantName != null ? tenantName : "");
    }

    private final void syncAppLogAccountTypeIfCurrent(AccountInfo accountInfo) {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            return;
        }
        AccountInfo accountInfo2 = iLoginService.getAccountInfo();
        if (accountInfo2.isLogin() && accountInfo2.getAccountType() == accountInfo.getAccountType() && Intrinsics.areEqual(accountInfo2.getUserId(), accountInfo.getUserId()) && Intrinsics.areEqual(accountInfo2.getTenantId(), accountInfo.getTenantId())) {
            syncAppLogAccountType(accountInfo);
            TrackerCommonParams.INSTANCE.syncHeaderCustomParams();
        }
    }

    private final void preloadModelsOnAppStart(String businessScene) {
        final String buildModelPreloadTrigger = buildModelPreloadTrigger(businessScene);
        TraeLogUtil.INSTANCE.i(TAG, "preloadModelsOnAppStart start, trigger=" + buildModelPreloadTrigger);
        new Thread(new Runnable() { // from class: com.bytedance.trae.init.task.InitAccountTask$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                InitAccountTask.preloadModelsOnAppStart$lambda$4(InitAccountTask.this, buildModelPreloadTrigger);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadModelsOnAppStart$lambda$4(InitAccountTask initAccountTask, String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            BuildersKt.runBlocking$default((CoroutineContext) null, new InitAccountTask$preloadModelsOnAppStart$1$1$1(str, null), 1, (Object) null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "preloadModelsOnAppStart failed, trigger=" + str, th2);
        }
    }

    private final String buildModelPreloadTrigger(String businessScene) {
        return Intrinsics.areEqual(businessScene, ACCOUNT_STATUS_STICKY) ? "account_logged_in_callback_sticky" : "account_logged_in_callback_login_event";
    }

    static /* synthetic */ void startFrontierConnect$default(InitAccountTask initAccountTask, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        initAccountTask.startFrontierConnect(z);
    }

    private final void startFrontierConnect(final boolean isLoginEvent) {
        AccountInfo accountInfo;
        if (this.frontierConnectStarted.compareAndSet(false, true)) {
            final int incrementAndGet = this.frontierConnectGeneration.incrementAndGet();
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
            final String str = userId == null ? "" : userId;
            ILoginService iLoginService2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            String xTToken = iLoginService2 != null ? iLoginService2.getXTToken() : null;
            final String str2 = xTToken != null ? xTToken : "";
            new Thread(new Runnable() { // from class: com.bytedance.trae.init.task.InitAccountTask$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    InitAccountTask.startFrontierConnect$lambda$5(str2, str, incrementAndGet, this, isLoginEvent);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFrontierConnect$lambda$5(String str, String str2, int i, InitAccountTask initAccountTask, boolean z) {
        FrontierConfig frontierConfig;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(DebugSettings.INSTANCE.getPpeHeaders());
        if (str.length() > 0) {
            linkedHashMap.put("X-Tt-token", str);
        }
        String str3 = str2;
        if (str3.length() > 0) {
            linkedHashMap.put("user_id", str2);
        }
        if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            frontierConfig = ApiHost.FRONTIER_CONFIG_BYTECLOUD;
        } else {
            frontierConfig = ApiHost.FRONTIER_CONFIG;
        }
        boolean z2 = str3.length() > 0;
        int i2 = 1;
        while (i == initAccountTask.frontierConnectGeneration.get()) {
            String deviceId = ApplogService.INSTANCE.getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
                boolean z3 = (accountInfo != null ? accountInfo.getAccountType() : null) == AccountType.TOB;
                HubClientMetadata resolve = HubClientMetadata.Companion.resolve(Build.MANUFACTURER, Build.MODEL, deviceId);
                TraeLogUtil.INSTANCE.i(TAG, "resolveHubDeviceName: source=system_manufacturer_model");
                INetworkDepend companion = INetworkDepend.INSTANCE.getInstance();
                Intrinsics.checkNotNull(frontierConfig);
                companion.initConfig(frontierConfig, linkedHashMap, z3, resolve);
                INetworkDepend.INSTANCE.getInstance().connect(z ? new HubConnectionListener() { // from class: com.bytedance.trae.init.task.InitAccountTask$startFrontierConnect$1$listener$1
                    public void onRegisterSuccess() {
                        IChangeLanguageApi.Companion.syncLanguage$default(IChangeLanguageApi.Companion, (String) null, 1, (Object) null);
                    }
                } : null);
                initAccountTask.reportApm(z2, i2);
                return;
            }
            i2++;
            try {
                Thread.sleep(100L);
            } catch (Throwable unused) {
            }
        }
    }

    private final void reportApm(boolean hasUserId, int didCount) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hasUserId", hasUserId);
            jSONObject.put("did_total_ms", System.currentTimeMillis() - ((Number) AppHost.INSTANCE.getAppStartTime().getSecond()).longValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("getDidCount", didCount);
            ApmService.INSTANCE.monitorEventForSlardar("hub_init_event", new JSONObject(), jSONObject2, jSONObject);
        } catch (Throwable unused) {
        }
    }

    private final void clearAllNotifications() {
        Object systemService = AppHost.INSTANCE.getApplication().getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r4.equals(com.bytedance.trae.init.task.InitAccountTask.SOURCE_BYTECLOUD_RT_EXPIRED) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r4.equals(com.bytedance.trae.init.task.InitAccountTask.SOURCE_ACCOUNT_DELETED) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r4.equals(com.bytedance.trae.init.task.InitAccountTask.SOURCE_RISK_CONTROL) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        if (r4.equals(com.bytedance.trae.init.task.InitAccountTask.SOURCE_REFRESH_TOKEN_EXPIRED) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r4.equals("user_logout") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (r4.equals(com.bytedance.trae.init.task.InitAccountTask.ACCOUNT_STATUS_STICKY) == false) goto L27;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String resolveLoginPageSource(String businessScene) {
        String str;
        switch (businessScene.hashCode()) {
            case -355378050:
                str = "user_logout";
                break;
            case -307181445:
                str = SOURCE_REFRESH_TOKEN_EXPIRED;
                break;
            case -104318995:
                str = SOURCE_RISK_CONTROL;
                break;
            case 329966599:
                str = SOURCE_ACCOUNT_DELETED;
                break;
            case 1411465082:
                str = SOURCE_BYTECLOUD_RT_EXPIRED;
                break;
            case 1527205737:
                if (businessScene.equals("logout_by_session_expired")) {
                    return "session_expired";
                }
                if (this.hasBeenLoggedIn.get()) {
                    return "session_expired";
                }
                return SOURCE_COLD_LAUNCH;
            case 2064634356:
                break;
            default:
                if (this.hasBeenLoggedIn.get()) {
                }
                return SOURCE_COLD_LAUNCH;
        }
    }

    static /* synthetic */ void navigateToLogin$default(InitAccountTask initAccountTask, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "session_expired";
        }
        initAccountTask.navigateToLogin(str);
    }

    private final void navigateToLogin(final String source) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.init.task.InitAccountTask$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                InitAccountTask.navigateToLogin$lambda$6(source);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateToLogin$lambda$6(String str) {
        Application application = AppHost.INSTANCE.getApplication();
        Intent intent = new Intent();
        intent.setClassName(application, "com.bytedance.trae.login.activity.AccountLoginActivity");
        intent.setFlags(268468224);
        intent.putExtra("login_enter_from", "onboarding");
        intent.putExtra("login_page_source", str);
        application.startActivity(intent);
    }

    private final boolean isFrontierReconnectDisabled() {
        return FrontierSwitchConfig.INSTANCE.isDisabled();
    }
}
