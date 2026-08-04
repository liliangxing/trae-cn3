# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAccountTask;
.super Ljava/lang/Object;
.source "InitAccountTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private static final ACCOUNT_STATUS_STICKY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/init/task/InitAccountTask$Companion;
.field private static final SOURCE_ACCOUNT_DELETED:Ljava/lang/String;
.field private static final SOURCE_BYTECLOUD_RT_EXPIRED:Ljava/lang/String;
.field private static final SOURCE_COLD_LAUNCH:Ljava/lang/String;
.field private static final SOURCE_REFRESH_TOKEN_EXPIRED:Ljava/lang/String;
.field private static final SOURCE_RISK_CONTROL:Ljava/lang/String;
.field private static final SOURCE_SESSION_EXPIRED:Ljava/lang/String;
.field private static final SOURCE_USER_LOGOUT:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private final accountStatusCallback:Lcom/bytedance/trae/login/api/IAccountStatusListener;
.field private final appBackgroundListener:Lcom/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1;
.field private final firstStyle:Ljava/lang/String;
.field private final frontierConnectGeneration:Ljava/util/concurrent/atomic/AtomicInteger;
.field private final frontierConnectStarted:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private final hasBeenLoggedIn:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private final scene:Ljava/lang/String;


.method public static synthetic $r8$lambda$CCb_5fJ6z7xUE0QTz5Awev2edao(java.lang.String)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/InitAccountTask;->navigateToLogin$lambda$6(Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$KR3fLFc5NXk5TksI_YFn_BIuVAw(java.lang.String  java.lang.String  int  com.bytedance.trae.init.task.InitAccountTask  boolean)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/init/task/InitAccountTask;->startFrontierConnect$lambda$5(Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/init/task/InitAccountTask; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Xh-mp18Mt4DxIU4v3h-e8GfI-tw(com.bytedance.trae.init.task.InitAccountTask  com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->accountStatusCallback$lambda$1(Lcom/bytedance/trae/init/task/InitAccountTask; Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mdfRaNDpqHNkKxRVsNEpywAo0K8(com.bytedance.trae.init.task.InitAccountTask  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->preloadModelsOnAppStart$lambda$4(Lcom/bytedance/trae/init/task/InitAccountTask; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$x8De3TROFuCS0ax2YDZHK_y6IbI(com.bytedance.trae.init.task.InitAccountTask  com.bytedance.trae.login.api.AccountInfo)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->accountStatusCallback$lambda$1$lambda$0(Lcom/bytedance/trae/init/task/InitAccountTask; Lcom/bytedance/trae/login/api/AccountInfo;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/init/task/InitAccountTask;->Companion Lcom/bytedance/trae/init/task/InitAccountTask$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/task/InitAccountTask;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    const-string v0, "Basic"
    iput-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->scene Ljava/lang/String;
    const-string v0, "asyncThreadWhenFirst"
    iput-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->firstStyle Ljava/lang/String;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    iput-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectStarted Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V
    iput-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectGeneration Ljava/util/concurrent/atomic/AtomicInteger;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    iput-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->hasBeenLoggedIn Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/init/task/InitAccountTask;)V
    iput-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->accountStatusCallback Lcom/bytedance/trae/login/api/IAccountStatusListener;
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1;
    invoke-direct v0, Lcom/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->appBackgroundListener Lcom/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1;
    return-void 
.end method

.method private static final accountStatusCallback$lambda$1(com.bytedance.trae.init.task.InitAccountTask  com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 15
    # ins_size=3
    const-string v0, "accountStatus"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "businessScene"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/init/task/InitAccountTask$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v13, Lcom/bytedance/trae/login/api/AccountStatus;->ordinal()I
    move-result v13
    aget v13, v0, v13
    const-string v0, "get_account_status_siticky"
    const/4 v1, 2
    const/4 v2, 1
    const/4 v3, 0
    if-eq v13, v2, +079h
    if-eq v13, v1, +00dh
    const/4 v12, 3
    if-ne v13, v12, +004h
    goto/16 +10fh
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
    invoke-direct v12, v3, Lcom/bytedance/trae/init/task/InitAccountTask;->syncAppLogAccountType(Lcom/bytedance/trae/login/api/AccountInfo;)V
    invoke-direct v12, Lcom/bytedance/trae/init/task/InitAccountTask;->isFrontierReconnectDisabled()Z
    move-result v13
    const-string v1, "frontier_disconnect"
    const-string v2, "isFrontierReconnectDisabled"
    const/4 v4, 0
    if-nez v13, +028h
    iget-object v13, v12, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectGeneration Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v13, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I
    sget-object v13, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    move-result-object v13
    invoke-interface v13, Lcom/bytedance/trae/im/network/INetworkDepend;->disconnect()V
    iget-object v13, v12, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectStarted Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v13, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    new-instance v13, Lorg/json/JSONObject;
    invoke-direct v13, Lorg/json/JSONObject;-><init>()V
    const-string v5, "frontierConnectGeneration"
    iget-object v6, v12, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectGeneration Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v13, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v13, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-static v1, v3, v13, v3, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +ch
    new-instance v13, Lorg/json/JSONObject;
    invoke-direct v13, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v13, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-static v1, v3, v13, v3, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    invoke-direct v12, Lcom/bytedance/trae/init/task/InitAccountTask;->clearAllNotifications()V
    sget-object v13, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->clear()V
    sget-object v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->onAccountChanged()V
    sget-object v13, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-virtual v13, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->onAccountChanged()V
    sget-object v13, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->handleLogout()V
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-nez v13, +009h
    invoke-direct v12, v14, Lcom/bytedance/trae/init/task/InitAccountTask;->resolveLoginPageSource(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    invoke-direct v12, v13, Lcom/bytedance/trae/init/task/InitAccountTask;->navigateToLogin(Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/init/task/TrackerCommonParams;->INSTANCE Lcom/bytedance/trae/init/task/TrackerCommonParams;
    invoke-virtual v12, Lcom/bytedance/trae/init/task/TrackerCommonParams;->syncHeaderCustomParams()V
    goto/16 +09fh
    iget-object v13, v12, Lcom/bytedance/trae/init/task/InitAccountTask;->hasBeenLoggedIn Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v13, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    const-class v13, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v13
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v13, v4, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v13, +007h
    invoke-interface v13, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v4
    goto +2h
    move-object v4, v3
    sget-object v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->onAccountChanged()V
    sget-object v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v3
    if-nez v5, +004h
    const-string v5, ""
    move-object v7, v5
    const-wide/16 v8, 0
    const/4 v10, 2
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->recordLoginObserved$default(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore; Ljava/lang/String; J I Ljava/lang/Object;)J
    invoke-direct v12, v4, Lcom/bytedance/trae/init/task/InitAccountTask;->syncAppLogAccountType(Lcom/bytedance/trae/login/api/AccountInfo;)V
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    xor-int/2addr v0, v2
    invoke-direct v12, v0, Lcom/bytedance/trae/init/task/InitAccountTask;->startFrontierConnect(Z)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger;->COLD_LAUNCH Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger;
    invoke-static v0, v2, v3, v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->refreshIDEAccessTokenIfNeeded$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v0
    if-eqz v0, +008h
    sget-object v13, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    invoke-virtual v13, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->validateOnColdLaunch()V
    goto +bh
    if-eqz v13, +00ah
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda0;
    invoke-direct v0, v12, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/init/task/InitAccountTask;)V
    invoke-interface v13, v0, v3, Lcom/bytedance/trae/login/api/ILoginService;->refreshUserInfo(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    sget-object v13, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-virtual v13, Lcom/bytedance/trae/login/region/UserRegionManager;->refreshRegion()V
    sget-object v13, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v13
    if-eqz v13, +008h
    sget-object v13, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->prewarm()V
    goto +bh
    sget-object v13, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchPayStatus()V
    sget-object v13, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchUserEntStatus()V
    invoke-direct v12, Lcom/bytedance/trae/init/task/InitAccountTask;->clearAllNotifications()V
    sget-object v13, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->preload()V
    sget-object v13, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-virtual v13, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->onAccountChanged()V
    invoke-direct v12, v14, Lcom/bytedance/trae/init/task/InitAccountTask;->preloadModelsOnAppStart(Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/init/task/TrackerCommonParams;->INSTANCE Lcom/bytedance/trae/init/task/TrackerCommonParams;
    invoke-virtual v12, Lcom/bytedance/trae/init/task/TrackerCommonParams;->syncHeaderCustomParams()V
    sget-object v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    sget-object v13, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v13
    invoke-virtual v12, v13, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->init(Landroid/app/Application;)V
    return-void 
    :try_start_0x47
.end method

.method private static final accountStatusCallback$lambda$1$lambda$0(com.bytedance.trae.init.task.InitAccountTask  com.bytedance.trae.login.api.AccountInfo)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->syncAppLogAccountTypeIfCurrent(Lcom/bytedance/trae/login/api/AccountInfo;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final buildModelPreloadTrigger(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "get_account_status_siticky"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    const-string v2, "account_logged_in_callback_sticky"
    goto +3h
    const-string v2, "account_logged_in_callback_login_event"
    return-object v2
.end method

.method private final clearAllNotifications()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string v1, "notification"
    invoke-virtual v0, v1, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/app/NotificationManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/app/NotificationManager;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/app/NotificationManager;->cancelAll()V
    return-void 
.end method

.method private final isFrontierReconnectDisabled()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->isDisabled()Z
    move-result v0
    return v0
.end method

.method private final navigateToLogin(java.lang.String)void
    .registers 4
    # ins_size=2
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v1, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda2;
    invoke-direct v1, v3, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method static synthetic navigateToLogin$default(com.bytedance.trae.init.task.InitAccountTask  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +005h
    const-string/jumbo v1, session_expired
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->navigateToLogin(Ljava/lang/String;)V
    return-void 
.end method

.method private static final navigateToLogin$lambda$6(java.lang.String)void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    new-instance v1, Landroid/content/Intent;
    invoke-direct v1, Landroid/content/Intent;-><init>()V
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    const-string v3, "com.bytedance.trae.login.activity.AccountLoginActivity"
    invoke-virtual v1, v2, v3, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v2, 268468224
    invoke-virtual v1, v2, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    const-string v2, "login_enter_from"
    const-string v3, "onboarding"
    invoke-virtual v1, v2, v3, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v2, "login_page_source"
    invoke-virtual v1, v2, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v0, v1, Landroid/app/Application;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final preloadModelsOnAppStart(java.lang.String)void
    .registers 5
    # ins_size=2
    invoke-direct v3, v4, Lcom/bytedance/trae/init/task/InitAccountTask;->buildModelPreloadTrigger(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "preloadModelsOnAppStart start, trigger="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "InitAccountTask"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/Thread;
    new-instance v1, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda3;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/init/task/InitAccountTask; Ljava/lang/String;)V
    invoke-direct v0, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V
    invoke-virtual v0, Ljava/lang/Thread;->start()V
    return-void 
.end method

.method private static final preloadModelsOnAppStart$lambda$4(com.bytedance.trae.init.task.InitAccountTask  java.lang.String)void
    .registers 5
    # ins_size=2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v3, Lcom/bytedance/trae/init/task/InitAccountTask$preloadModelsOnAppStart$1$1$1;
    const/4 v0, 0
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/init/task/InitAccountTask$preloadModelsOnAppStart$1$1$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v1, 1
    invoke-static v0, v3, v1, v0, Lkotlinx/coroutines/BuildersKt;->runBlocking$default(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v3
    if-eqz v3, +018h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "preloadModelsOnAppStart failed, trigger="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "InitAccountTask"
    invoke-virtual v0, v1, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final reportApm(boolean  int)void
    .registers 8
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "hasUserId"
    invoke-virtual v0, v1, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    const-string v6, "did_total_ms"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppStartTime()Lkotlin/Pair;
    move-result-object v3
    invoke-virtual v3, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    sub-long/2addr v1, v3
    invoke-virtual v0, v6, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    const-string v1, "getDidCount"
    invoke-virtual v6, v1, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v7, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v1, "hub_init_event"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v7, v1, v2, v6, v0, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
.end method

.method private final resolveLoginPageSource(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Ljava/lang/String;->hashCode()I
    move-result v0
    const-string/jumbo v1, session_expired
    const-string v2, "cold_launch"
    sparse-switch v0, +0000053h
    goto +44h
    const-string v0, "get_account_status_siticky"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +046h
    goto +3bh
    const-string v0, "logout_by_session_expired"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +03eh
    goto +32h
    const-string v0, "bytecloud_rt_expired"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +029h
    goto +29h
    const-string v0, "account_deleted"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +020h
    goto +20h
    const-string/jumbo v0, risk_control
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +016h
    goto +16h
    const-string v0, "refresh_token_expired"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +00dh
    goto +dh
    const-string/jumbo v0, user_logout
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +3h
    move-object v1, v0
    goto +bh
    iget-object v4, v3, Lcom/bytedance/trae/init/task/InitAccountTask;->hasBeenLoggedIn Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v4, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v1, v2
    return-object v1
    nop 
    sparse-switch-payload -152ea382 -124f3785 -637c813 13aae407 54213f7a 5b074f69 7b0fd1f4
.end method

.method private final startFrontierConnect(boolean)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectStarted Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectGeneration Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I
    move-result v4
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    const-string v2, ""
    if-nez v0, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v0
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v5, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v5, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +006h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v2, v1
    new-instance v0, Ljava/lang/Thread;
    new-instance v7, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;
    move-object v1, v7
    move-object v5, v8
    move v6, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;-><init>(Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/init/task/InitAccountTask; Z)V
    invoke-direct v0, v7, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V
    invoke-virtual v0, Ljava/lang/Thread;->start()V
    return-void 
.end method

.method static synthetic startFrontierConnect$default(com.bytedance.trae.init.task.InitAccountTask  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->startFrontierConnect(Z)V
    return-void 
.end method

.method private static final startFrontierConnect$lambda$5(java.lang.String  java.lang.String  int  com.bytedance.trae.init.task.InitAccountTask  boolean)void
    .registers 12
    # ins_size=5
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->getPpeHeaders()Ljava/util/Map;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 0
    const/4 v3, 1
    if-lez v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    if-eqz v1, +007h
    const-string v1, "X-Tt-token"
    invoke-interface v0, v1, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-object v7, v8
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    if-eqz v1, +008h
    const-string/jumbo v1, user_id
    invoke-interface v0, v1, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v8, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v8, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v8
    if-eqz v8, +005h
    sget-object v8, Lcom/bytedance/trae/ApiHost;->FRONTIER_CONFIG_BYTECLOUD Lcom/bytedance/trae/network/FrontierConfig;
    goto +3h
    sget-object v8, Lcom/bytedance/trae/ApiHost;->FRONTIER_CONFIG Lcom/bytedance/trae/network/FrontierConfig;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    move v7, v3
    goto +2h
    move v7, v2
    move v1, v3
    iget-object v4, v10, Lcom/bytedance/trae/init/task/InitAccountTask;->frontierConnectGeneration Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v4, Ljava/util/concurrent/atomic/AtomicInteger;->get()I
    move-result v4
    if-eq v9, v4, +003h
    return-void 
    sget-object v4, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v4, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v5
    if-nez v5, +05ch
    const-class v9, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v9
    const-class v5, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v9, v5, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v5, 0
    if-eqz v9, +007h
    invoke-interface v9, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v9
    goto +2h
    move-object v9, v5
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v9
    goto +2h
    move-object v9, v5
    sget-object v6, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    if-ne v9, v6, +003h
    move v2, v3
    sget-object v9, Lcom/bytedance/trae/network/HubClientMetadata;->Companion Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    sget-object v3, Landroid/os/Build;->MANUFACTURER Ljava/lang/String;
    sget-object v6, Landroid/os/Build;->MODEL Ljava/lang/String;
    invoke-virtual v9, v3, v6, v4, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->resolve(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/network/HubClientMetadata;
    move-result-object v9
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "InitAccountTask"
    const-string/jumbo v6, resolveHubDeviceName: source=system_manufacturer_model
    invoke-virtual v3, v4, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    move-result-object v3
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v3, v8, v0, v2, v9, Lcom/bytedance/trae/im/network/INetworkDepend;->initConfig(Lcom/bytedance/trae/network/FrontierConfig; Ljava/util/Map; Z Lcom/bytedance/trae/network/HubClientMetadata;)V
    if-eqz v11, +007h
    new-instance v5, Lcom/bytedance/trae/init/task/InitAccountTask$startFrontierConnect$1$listener$1;
    invoke-direct v5, Lcom/bytedance/trae/init/task/InitAccountTask$startFrontierConnect$1$listener$1;-><init>()V
    sget-object v8, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    move-result-object v8
    check-cast v5, Lcom/bytedance/trae/network/HubConnectionListener;
    invoke-interface v8, v5, Lcom/bytedance/trae/im/network/INetworkDepend;->connect(Lcom/bytedance/trae/network/HubConnectionListener;)V
    invoke-direct v10, v7, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->reportApm(Z I)V
    return-void 
    add-int/lit8 v1, v1, 1
    const-wide/16 v4, 100
    invoke-static v4, v5, Ljava/lang/Thread;->sleep(J)V
    goto -79h
    :try_start_0xc6
.end method

.method private final syncAppLogAccountType(com.bytedance.trae.login.api.AccountInfo)void
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    if-eqz v7, +00eh
    invoke-virtual v7, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountType;->getValue()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +008h
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->UNKNOWN Lcom/bytedance/trae/login/api/AccountType;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountType;->getValue()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    const-string v4, ""
    if-nez v3, +003h
    move-object v3, v4
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/login/api/AccountInfo;->getTenantId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v2
    if-nez v5, +003h
    move-object v5, v4
    if-eqz v7, +006h
    invoke-virtual v7, Lcom/bytedance/trae/login/api/AccountInfo;->getTenantName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v4, v2
    invoke-virtual v0, v1, v3, v5, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->onAccountTypeChanged(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final syncAppLogAccountTypeIfCurrent(com.bytedance.trae.login.api.AccountInfo)void
    .registers 5
    # ins_size=2
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v0, +003h
    return-void 
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v1
    if-eqz v1, +031h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v2
    if-ne v1, v2, +027h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +019h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getTenantId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/login/api/AccountInfo;->getTenantId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +9h
    invoke-direct v3, v4, Lcom/bytedance/trae/init/task/InitAccountTask;->syncAppLogAccountType(Lcom/bytedance/trae/login/api/AccountInfo;)V
    sget-object v4, Lcom/bytedance/trae/init/task/TrackerCommonParams;->INSTANCE Lcom/bytedance/trae/init/task/TrackerCommonParams;
    invoke-virtual v4, Lcom/bytedance/trae/init/task/TrackerCommonParams;->syncHeaderCustomParams()V
    return-void 
.end method

.method public checkFirstStartAsyncTaskInit(java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->checkFirstStartAsyncTaskInit(Lcom/bytedance/trae/init/task/base/IInitReportTask; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method public getFirstStyle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->firstStyle Ljava/lang/String;
    return-object v0
.end method

.method public getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->loadFromCache()V
    sget-object v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    new-instance v1, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1;
    invoke-direct v1, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->addOnLogoutListener(Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;)V
    sget-object v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->INSTANCE Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->init()V
    sget-object v0, Lcom/bytedance/trae/account/TTAccount;->INSTANCE Lcom/bytedance/trae/account/TTAccount;
    invoke-virtual v0, Lcom/bytedance/trae/account/TTAccount;->init()V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const/4 v1, 1
    if-nez v0, +021h
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v2, 0
    if-eqz v0, +009h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v0
    if-nez v0, +003h
    move v2, v1
    if-eqz v2, +007h
    sget-object v0, Lcom/bytedance/trae/login/AccountUtils;->INSTANCE Lcom/bytedance/trae/login/AccountUtils;
    invoke-virtual v0, Lcom/bytedance/trae/login/AccountUtils;->preLoadAccountPhoneOneKeyInfo()V
    sget-object v0, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    sget-object v0, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/region/UserRegionManager;->registerLifecycle()V
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2;
    invoke-direct v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2;-><init>()V
    check-cast v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->registerUserPayIdentityProxy(Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00bh
    iget-object v2, v3, Lcom/bytedance/trae/init/task/InitAccountTask;->accountStatusCallback Lcom/bytedance/trae/login/api/IAccountStatusListener;
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v2, v1, Lcom/bytedance/trae/login/api/ILoginService;->registerAccountStatusChangeListener(Lcom/bytedance/trae/login/api/IAccountStatusListener; Ljava/lang/Boolean;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/init/task/InitAccountTask;->appBackgroundListener Lcom/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1;
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    invoke-interface v0, v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->addAppBackGroundListener(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;)V
    return-void 
.end method
