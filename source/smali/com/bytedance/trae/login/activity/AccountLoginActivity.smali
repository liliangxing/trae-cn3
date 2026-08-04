# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public Lcom/bytedance/trae/login/activity/AccountLoginActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "AccountLoginActivity.java"

.implements Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;

.field private static final EXT_FAILED_STEP:Ljava/lang/String;
.field private static final FAILED_STEP_TRAE_AUTH_AFTER_DOUYIN_AUTH:Ljava/lang/String;
.field static final MAIN_ACTIVITY_CLASS:Ljava/lang/String;
.field private static final TAG_ENTRY:Ljava/lang/String;
.field private static final TAG_ONE_CLICK:Ljava/lang/String;
.field private static final TAG_PHONE_LOGIN:Ljava/lang/String;
.field private static final TAG_VERIFY_CODE:Ljava/lang/String;
.field private static final ioExecutor:Ljava/util/concurrent/ExecutorService;
.field private accountPhoneOneKeyInfo:Lcom/bytedance/trae/login/PhoneOneKeyInfo;
.field private hasClickedLogin:Z
.field private hasEnteredTraeAuth:Z
.field private isBytedanceNetwork:Z
.field private isLoginSuccess:Z
.field private isNavigatingAway:Z
.field private isNavigatingToVerifyCode:Z
.field private bridge isWaitingForDouyinResult:Z
.field private lastClickedLoginType:Ljava/lang/String;
.field private loginLoadingOverlay:Landroid/widget/FrameLayout;
.field private networkCallback:Landroid/net/ConnectivityManager$NetworkCallback;
.field private final phoneLogin:Lcom/bytedance/trae/login/PhoneLogin;
.field private phoneLoginAgreementChecked:Z
.field private resumeCount:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->ioExecutor Ljava/util/concurrent/ExecutorService;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    new-instance v0, Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v0, Lcom/bytedance/trae/login/PhoneLogin;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isBytedanceNetwork Z
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isLoginSuccess Z
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->phoneLoginAgreementChecked Z
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingAway Z
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingToVerifyCode Z
    iput v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->resumeCount I
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    const-string v1, ""
    iput-object v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isWaitingForDouyinResult Z
    return-void 
.end method

.method static synthetic access$002(com.bytedance.trae.login.activity.AccountLoginActivity  boolean)boolean
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isBytedanceNetwork Z
    return v1
.end method

.method static synthetic access$100(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->checkBytecloudNetwork()V
    return-void 
.end method

.method static synthetic access$200(com.bytedance.trae.login.activity.AccountLoginActivity  com.bytedance.trae.login.PhoneOneKeyInfo)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isOneKeyInfoValid(Lcom/bytedance/trae/login/PhoneOneKeyInfo;)Z
    move-result v0
    return v0
.end method

.method static synthetic access$302(com.bytedance.trae.login.activity.AccountLoginActivity  com.bytedance.trae.login.PhoneOneKeyInfo)com.bytedance.trae.login.PhoneOneKeyInfo
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->accountPhoneOneKeyInfo Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    return-object v1
.end method

.method static synthetic access$400(com.bytedance.trae.login.activity.AccountLoginActivity  java.util.Map)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->listDevicesAndNotify(Ljava/util/Map;)V
    return-void 
.end method

.method static synthetic access$502(com.bytedance.trae.login.activity.AccountLoginActivity  boolean)boolean
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    return v1
.end method

.method static synthetic access$600(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->navigateToMainActivity()V
    return-void 
.end method

.method static synthetic access$702(com.bytedance.trae.login.activity.AccountLoginActivity  boolean)boolean
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isWaitingForDouyinResult Z
    return v1
.end method

.method static synthetic access$800(com.bytedance.trae.login.activity.AccountLoginActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showLoginLoading(Z)V
    return-void 
.end method

.method static synthetic access$900(com.bytedance.trae.login.activity.AccountLoginActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->navigateToPhoneBindForDouyin(Ljava/lang/String;)V
    return-void 
.end method

.method private checkBytecloudNetwork()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->hasEverSeenIntranet()Z
    move-result v0
    if-eqz v0, +008h
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isBytedanceNetwork Z
    invoke-direct v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->notifyCurrentFragmentSso()V
    new-instance v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda6;
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    invoke-static v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;->checkBytedanceNetwork(Landroidx/lifecycle/LifecycleOwner; Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;)V
    return-void 
.end method

.method public static com_bytedance_trae_login_activity_AccountLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->com_bytedance_trae_login_activity_AccountLoginActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private isOneKeyInfoValid(com.bytedance.trae.login.PhoneOneKeyInfo)boolean
    .registers 3
    # ins_size=2
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->getMaskPhone()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->getCarrier()Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    move-result-object v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method static synthetic lambda$listDevicesAndNotify$3(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->listDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    move-exception v0
    new-instance v1, Ljava/lang/RuntimeException;
    invoke-direct v1, v0, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
    throw v1
    :try_start_0x0
.end method

.method private listDevicesAndNotify(java.util.Map)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    invoke-direct v3, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->normalizeLoginPlatformType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->ioExecutor Ljava/util/concurrent/ExecutorService;
    new-instance v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda0;
    invoke-direct v2, v3, v4, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Ljava/util/Map; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private navigateToMainActivity()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isLoginSuccess Z
    new-instance v1, Landroid/content/Intent;
    invoke-direct v1, Landroid/content/Intent;-><init>()V
    const-string v2, "com.bytedance.trae.home.MainActivity"
    invoke-virtual v1, v3, v2, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v2, 268468224
    invoke-virtual v1, v2, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    const-string v2, "from_login_success"
    invoke-virtual v1, v2, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    invoke-virtual v3, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->finish()V
    return-void 
.end method

.method private navigateToPhoneBindForDouyin(java.lang.String)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->Companion Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$Companion;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
.end method

.method private normalizeLoginPlatformType(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "douyin"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string v0, "bytecloud"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v0, one_click
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v1, phone_oneclick
    invoke-virtual v1, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    return-object v0
    const-string/jumbo v3, phone
    return-object v3
.end method

.method private notifyCurrentFragmentSso()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/login/R$id;->fragment_container I
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentById(I)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/login/fragment/BytecloudSsoHost;
    if-eqz v1, +00ch
    check-cast v0, Lcom/bytedance/trae/login/fragment/BytecloudSsoHost;
    new-instance v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda7;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    invoke-interface v0, v1, Lcom/bytedance/trae/login/fragment/BytecloudSsoHost;->showBytecloudSso(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private recheckBytecloudNetwork()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->resetNetworkCache()Z
    move-result v0
    if-eqz v0, +005h
    invoke-direct v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->checkBytecloudNetwork()V
    return-void 
.end method

.method private registerNetworkCallback()void
    .registers 4
    # ins_size=1
    const-string v0, "connectivity"
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/net/ConnectivityManager;
    if-nez v0, +003h
    return-void 
    new-instance v1, Landroid/net/NetworkRequest$Builder;
    invoke-direct v1, Landroid/net/NetworkRequest$Builder;-><init>()V
    const/16 v2, 12
    invoke-virtual v1, v2, Landroid/net/NetworkRequest$Builder;->addCapability(I)Landroid/net/NetworkRequest$Builder;
    move-result-object v1
    invoke-virtual v1, Landroid/net/NetworkRequest$Builder;->build()Landroid/net/NetworkRequest;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    iput-object v2, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->networkCallback Landroid/net/ConnectivityManager$NetworkCallback;
    invoke-virtual v0, v1, v2, Landroid/net/ConnectivityManager;->registerNetworkCallback(Landroid/net/NetworkRequest; Landroid/net/ConnectivityManager$NetworkCallback;)V
    return-void 
    :try_start_0x0
.end method

.method private reportLoginPageView()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v1, "login_enter_from"
    invoke-virtual v0, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Ljava/lang/String;->isEmpty()Z
    move-result v1
    if-eqz v1, +005h
    const-string/jumbo v0, onboarding
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "enter_from"
    invoke-virtual v1, v2, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "login_page_view"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x1a
.end method

.method private reportLoginStartToSlardar()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v1, start
    const-string/jumbo v2, unselected
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private resolveLoginPlatform(java.lang.String)com.bytedance.trae.login.api.LoginPlatform
    .registers 3
    # ins_size=2
    const-string v0, "douyin"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    return-object v2
    const-string v0, "bytecloud"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->BYTECLOUD Lcom/bytedance/trae/login/api/LoginPlatform;
    return-object v2
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    return-object v2
.end method

.method private showDeviceOverLimitDialog(com.bytedance.trae.login.traeauth.ListDevicesResult  java.util.Map  java.lang.String)void
    .registers 7
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    sget-object v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->LOGIN Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;
    invoke-direct v2, v3, v5, v6, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Ljava/util/Map; Ljava/lang/String;)V
    invoke-virtual v0, v3, v4, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    return-void 
.end method

.method private showLoginEntryFragment()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->Companion Lcom/bytedance/trae/login/fragment/LoginEntryFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$Companion;->newInstance()Lcom/bytedance/trae/login/fragment/LoginEntryFragment;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/login/R$id;->fragment_container I
    const-string/jumbo v3, tag_login_entry
    invoke-virtual v1, v2, v0, v3, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method private showLoginLoading(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->loginLoadingOverlay Landroid/widget/FrameLayout;
    if-eqz v0, +00bh
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    return-void 
.end method

.method private toObjectMap(java.util.Map)java.util.Map
    .registers 5
    # ins_size=2
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    if-nez v4, +003h
    return-object v0
    invoke-interface v4, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    if-eqz v2, -010h
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1bh
    return-object v0
.end method

.method private tryOneClickLogin()void
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    sget-object v1, Lcom/bytedance/trae/login/AccountUtils;->INSTANCE Lcom/bytedance/trae/login/AccountUtils;
    invoke-virtual v1, Lcom/bytedance/trae/login/AccountUtils;->getPreLoadOneKeyInfo()Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isOneKeyInfoValid(Lcom/bytedance/trae/login/PhoneOneKeyInfo;)Z
    move-result v2
    if-eqz v2, +02bh
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->accountPhoneOneKeyInfo Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v4, one_key_preload_result
    const-string/jumbo v5, one_click
    const/4 v6, 0
    const-string v7, "cache_hit"
    const/4 v8, 0
    const/4 v9, 0
    invoke-virtual/range v3 ... v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->getMaskPhone()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->getCarrier()Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showOneClickLoginFragment(Ljava/lang/String; Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "login_page_view_shown"
    const-string/jumbo v5, one_click
    const/4 v7, 0
    invoke-virtual/range v3 ... v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual/range v17, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showPhoneLoginFragment()V
    sget-object v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v11, "login_page_view_shown"
    const-string/jumbo v12, phone
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    invoke-virtual/range v10 ... v16, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;
    invoke-direct v3, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/login/PhoneLogin;->getPhoneInfo(Lcom/bytedance/trae/login/api/LoginPlatform; Lcom/bytedance/trae/login/IPhoneOneKeyCallback;)V
    return-void 
.end method

.method private unregisterNetworkCallback()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->networkCallback Landroid/net/ConnectivityManager$NetworkCallback;
    if-nez v0, +003h
    return-void 
    const-string v0, "connectivity"
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/net/ConnectivityManager;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->networkCallback Landroid/net/ConnectivityManager$NetworkCallback;
    invoke-virtual v0, v1, Landroid/net/ConnectivityManager;->unregisterNetworkCallback(Landroid/net/ConnectivityManager$NetworkCallback;)V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->networkCallback Landroid/net/ConnectivityManager$NetworkCallback;
    return-void 
    :try_start_0x5
.end method

.method public com_bytedance_trae_login_activity_AccountLoginActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public handleLoginSuccess()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    invoke-direct v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->navigateToMainActivity()V
    return-void 
.end method

.method public isBytedanceNetwork()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isBytedanceNetwork Z
    return v0
.end method

.method public isPhoneLoginAgreementChecked()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->phoneLoginAgreementChecked Z
    return v0
.end method

.method synthetic lambda$checkBytecloudNetwork$0$com-bytedance-trae-login-activity-AccountLoginActivity(boolean)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +010h
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +8h
    iput-boolean v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isBytedanceNetwork Z
    if-eqz v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->notifyCurrentFragmentSso()V
    return-void 
.end method

.method synthetic lambda$listDevicesAndNotify$4$com-bytedance-trae-login-activity-AccountLoginActivity(com.bytedance.trae.login.traeauth.ListDevicesResult  java.util.Map  java.lang.String)void
    .registers 6
    # ins_size=4
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +01fh
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +17h
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string/jumbo v1, tag_one_click_login
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    if-eqz v0, +006h
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyDeviceOffline(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Ljava/util/Map;)V
    goto +4h
    invoke-direct v2, v3, v4, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showDeviceOverLimitDialog(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Ljava/util/Map; Ljava/lang/String;)V
    return-void 
.end method

.method synthetic lambda$listDevicesAndNotify$5$com-bytedance-trae-login-activity-AccountLoginActivity(java.lang.String)void
    .registers 5
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +029h
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +21h
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string/jumbo v1, tag_one_click_login
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    const/4 v1, 0
    if-eqz v0, +00bh
    const/4 v2, -1
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyLoginResult(Z Ljava/lang/Integer; Ljava/lang/String;)V
    goto +8h
    invoke-static v3, v4, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method synthetic lambda$listDevicesAndNotify$6$com-bytedance-trae-login-activity-AccountLoginActivity(java.util.Map  java.lang.String)void
    .registers 16
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, v1, Lkotlinx/coroutines/BuildersKt;->runBlocking(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    new-instance v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;
    invoke-direct v1, v13, v0, v14, v15, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Ljava/util/Map; Ljava/lang/String;)V
    invoke-virtual v13, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    goto/16 +0deh
    move-exception v14
    move-object v0, v14
    invoke-virtual v0, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    move-result-object v1
    if-eqz v1, +012h
    invoke-virtual v0, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    move-result-object v1
    if-eq v1, v0, +00ch
    instance-of v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    if-eqz v1, +003h
    goto +6h
    invoke-virtual v0, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    move-result-object v0
    goto -15h
    instance-of v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const-string v2, "login_platform"
    const-string v3, "error_code"
    const-string v4, "icube_login_failure"
    const-string/jumbo v5, reason
    if-eqz v1, +044h
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v14
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "_list_device_error"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v2, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v7, "login_failure"
    const/4 v9, 0
    const-string v10, "list_device_list"
    const-string v11, "-1"
    move-object v8, v15
    move-object v12, v14
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +6eh
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, unknown_error: 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "_login_unknown_error"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const/4 v5, -1
    invoke-virtual v1, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v3, "error_class"
    invoke-virtual v14, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "error_message"
    invoke-virtual v14, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v14, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v14
    goto +3h
    const-string v14, ""
    invoke-virtual v1, v3, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v2, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v14, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v14, v4, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v7, "login_failure"
    const/4 v9, 0
    const-string v10, "list_device_list"
    const-string v11, "-1"
    move-object v8, v15
    move-object v12, v0
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object v14, v0
    new-instance v15, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda3;
    invoke-direct v15, v13, v14, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Ljava/lang/String;)V
    invoke-virtual v13, v15, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
    :try_start_0x0
    :try_start_0x4c
    :try_start_0x9d
.end method

.method synthetic lambda$notifyCurrentFragmentSso$1$com-bytedance-trae-login-activity-AccountLoginActivity()kotlin.Unit
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->openBytecloudLogin()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method synthetic lambda$openBytecloudLogin$2$com-bytedance-trae-login-activity-AccountLoginActivity(boolean)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +033h
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +2bh
    if-nez v2, +011h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_bytecloud_not_in_intranet I
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    const/4 v0, 0
    invoke-static v1, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
    const/4 v2, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingAway Z
    sget-object v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->buildLoginUrl()Ljava/lang/String;
    move-result-object v2
    new-instance v0, Landroidx/browser/customtabs/CustomTabsIntent$Builder;
    invoke-direct v0, Landroidx/browser/customtabs/CustomTabsIntent$Builder;-><init>()V
    invoke-virtual v0, Landroidx/browser/customtabs/CustomTabsIntent$Builder;->build()Landroidx/browser/customtabs/CustomTabsIntent;
    move-result-object v0
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroidx/browser/customtabs/CustomTabsIntent;->launchUrl(Landroid/content/Context; Landroid/net/Uri;)V
    return-void 
.end method

.method synthetic lambda$showDeviceOverLimitDialog$7$com-bytedance-trae-login-activity-AccountLoginActivity(java.util.Map  java.lang.String  boolean)void
    .registers 4
    # ins_size=4
    if-eqz v3, +00eh
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->toObjectMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v1
    invoke-direct v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->normalizeLoginPlatformType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->onDeviceLimitLoginContinue(Ljava/util/Map; Ljava/lang/String;)V
    goto +1ah
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "device_limit_dismissed"
    invoke-direct v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->normalizeLoginPlatformType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit I
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method public notifyLoginClicked(java.lang.String)void
    .registers 3
    # ins_size=2
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    iput-object v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    return-void 
.end method

.method public notifyVerifyCodeNavigation()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingToVerifyCode Z
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 9
    # ins_size=2
    invoke-super v7, v8, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_activity_account_login I
    invoke-virtual v7, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->setContentView(I)V
    sget v0, Lcom/bytedance/trae/login/R$id;->login_loading_overlay I
    invoke-virtual v7, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/FrameLayout;
    iput-object v0, v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->loginLoadingOverlay Landroid/widget/FrameLayout;
    if-nez v8, +02fh
    sget-object v8, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const/4 v0, 0
    move-object v1, v0
    check-cast v1, Lorg/json/JSONObject;
    const-string v1, "icube_login_start"
    invoke-virtual v8, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-direct v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->reportLoginStartToSlardar()V
    invoke-direct v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->reportLoginPageView()V
    invoke-virtual v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getIntent()Landroid/content/Intent;
    move-result-object v8
    const-string v0, "login_page_source"
    invoke-virtual v8, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    const-string v8, "cold_launch"
    move-object v4, v8
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "login_page_source"
    const-string/jumbo v2, unselected
    const/4 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/login/PhoneOneKeyInit;->INSTANCE Lcom/bytedance/trae/login/PhoneOneKeyInit;
    invoke-virtual v8, Lcom/bytedance/trae/login/PhoneOneKeyInit;->init()V
    invoke-direct v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showLoginEntryFragment()V
    invoke-direct v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->checkBytecloudNetwork()V
    invoke-direct v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->registerNetworkCallback()V
    return-void 
.end method

.method protected onDestroy()void
    .registers 9
    # ins_size=1
    iget-boolean v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    if-eqz v0, +010h
    iget-boolean v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    if-nez v0, +00ch
    sget-object v0, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    iget-object v1, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    const-string v2, "cancelled"
    const/4 v3, 0
    invoke-virtual v0, v3, v1, v2, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginResult(Z Ljava/lang/String; Ljava/lang/String;)V
    iget-boolean v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isLoginSuccess Z
    if-nez v0, +014h
    iget-boolean v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingToVerifyCode Z
    if-nez v0, +010h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "login_page_exit"
    const-string/jumbo v3, unselected
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->unregisterNetworkCallback()V
    invoke-super v8, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method public onDeviceLimitLoginContinue(java.util.Map  java.lang.String)void
    .registers 6
    # ins_size=3
    const-string v0, "is_new_user"
    const/4 v1, 0
    if-eqz v4, +013h
    invoke-interface v4, v0, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00dh
    invoke-interface v4, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    move v1, v4
    sget-object v4, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/service/AccountHelper;->setIsNewUser(Z)V
    invoke-direct v3, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->resolveLoginPlatform(Ljava/lang/String;)Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onLoginContinueByDeviceLimit(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/String;)V
    return-void 
    :try_start_0x5
.end method

.method public onDouyinLogin()void
    .registers 6
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    const/4 v1, 0
    iput-boolean v1, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    const-string v2, "douyin"
    iput-object v2, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    iput-boolean v0, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isWaitingForDouyinResult Z
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const/4 v3, 0
    if-eqz v0, +00fh
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/login/api/IDouyinLoginService;
    invoke-virtual v0, v4, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/IDouyinLoginService;
    goto +2h
    move-object v0, v3
    if-nez v0, +015h
    iput-boolean v1, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isWaitingForDouyinResult Z
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "douyin_auth_service_unavailable"
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/login/R$string;->trae_douyin_service_unavailable I
    invoke-static v5, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    new-instance v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;
    invoke-direct v1, v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    invoke-interface v0, v5, v1, v3, Lcom/bytedance/trae/login/api/IDouyinLoginService;->authorize(Landroid/app/Activity; Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method public onLoginSuccess()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    invoke-direct v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->navigateToMainActivity()V
    return-void 
.end method

.method public onOneClickLogin()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    const-string/jumbo v0, phone_oneclick
    iput-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "login_method_selected"
    const-string/jumbo v2, one_click
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    new-instance v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;
    invoke-direct v1, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/PhoneLogin;->doOneKeyLogin(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method protected onPause()void
    .registers 9
    # ins_size=1
    invoke-super v8, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onPause()V
    iget-boolean v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isLoginSuccess Z
    if-eqz v0, +003h
    return-void 
    iget-boolean v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingToVerifyCode Z
    if-eqz v0, +007h
    const-string/jumbo v0, verify_code_navigate
    move-object v5, v0
    goto +16h
    invoke-virtual v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "back_pressed"
    goto -ah
    iget-boolean v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingAway Z
    if-eqz v0, +006h
    const-string/jumbo v0, sso_navigate
    goto -12h
    const-string/jumbo v0, switch_background
    goto -16h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "login_page_pause"
    const-string/jumbo v3, unselected
    const/4 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onPhoneLoginClicked(boolean)void
    .registers 4
    # ins_size=2
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    const-string/jumbo v0, phone
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    iput-boolean v3, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->phoneLoginAgreementChecked Z
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v1, phone_login_clicked
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->tryOneClickLogin()V
    return-void 
.end method

.method public onPrivacyClicked()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method protected onResume()void
    .registers 10
    # ins_size=1
    invoke-super v9, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onResume()V
    iget v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->resumeCount I
    const/4 v1, 1
    add-int/2addr v0, v1
    iput v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->resumeCount I
    const/4 v0, 0
    iput-boolean v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingAway Z
    iput-boolean v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingToVerifyCode Z
    iget-boolean v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isWaitingForDouyinResult Z
    if-eqz v0, +005h
    invoke-direct v9, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showLoginLoading(Z)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "login_page_resume"
    const-string/jumbo v4, unselected
    const/4 v5, 0
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, resume_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->resumeCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    invoke-virtual/range v2 ... v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->recheckBytecloudNetwork()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->com_bytedance_trae_login_activity_AccountLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    return-void 
.end method

.method public onSwitchAccount()void
    .registers 8
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v1, one_click_switch_to_phone
    const-string/jumbo v2, one_click
    const/4 v3, 0
    const-string/jumbo v4, switch_to_phone
    const/4 v5, 0
    const/4 v6, 0
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showPhoneLoginFragment()V
    return-void 
.end method

.method public onTermsClicked()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public openBytecloudLogin()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasEnteredTraeAuth Z
    const-string v0, "bytecloud"
    iput-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "login_method_selected"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda4;
    invoke-direct v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    invoke-static v3, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;->checkIntranetRealTime(Landroidx/lifecycle/LifecycleOwner; Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;)V
    return-void 
.end method

.method public openEnterpriseLogin()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->hasClickedLogin Z
    const-string v1, "enterprise"
    iput-object v1, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lastClickedLoginType Ljava/lang/String;
    iput-boolean v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isNavigatingAway Z
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "login_method_selected"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public showOneClickLoginFragment(java.lang.String  com.bytedance.trae.login.PhoneOneKeyPlatform)void
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->Companion Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;->newInstance(Ljava/lang/String; Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    move-result-object v3
    invoke-virtual v3, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setOneClickLoginCallback(Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/login/R$id;->fragment_container I
    const-string/jumbo v1, tag_one_click_login
    invoke-virtual v4, v0, v3, v1, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    const/4 v4, 0
    invoke-virtual v3, v4, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method public showPhoneLoginFragment()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->Companion Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$Companion;->newInstance()Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/login/R$id;->fragment_container I
    const-string/jumbo v3, tag_phone_login
    invoke-virtual v1, v2, v0, v3, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method
