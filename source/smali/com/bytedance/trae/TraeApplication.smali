# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/TraeApplication;
.super Landroid/app/Application;
.source "TraeApplication.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/TraeApplication$Companion;
.field private static final TAG:Ljava/lang/String;
.field private static inst:Lcom/bytedance/trae/TraeApplication;
.field private launcher:Lcom/bytedance/trae/ILauncher;
.field private final startTime:Lkotlin/Pair;


.method public static synthetic $r8$lambda$-I0hEYQ9CzrcrZXO2NawU3DkEEk()androidx.fragment.app.FragmentActivity
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/TraeApplication;->attachBaseContext$lambda$0()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$8dlURe0EN8eLPUEQMTq7METNRPY()android.app.Activity
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/TraeApplication;->attachBaseContext$lambda$1()Landroid/app/Activity;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$K5iSIQdtcgUuTQKtcxDbBA6NuOw()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/TraeApplication;->onCreate$lambda$2()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/TraeApplication$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/TraeApplication$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/TraeApplication;->Companion Lcom/bytedance/trae/TraeApplication$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/TraeApplication;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Landroid/app/Application;-><init>()V
    new-instance v0, Lkotlin/Pair;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-direct v0, v1, v2, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    iput-object v0, v4, Lcom/bytedance/trae/TraeApplication;->startTime Lkotlin/Pair;
    sput-object v4, Lcom/bytedance/trae/TraeApplication;->inst Lcom/bytedance/trae/TraeApplication;
    const-string v0, "application"
    invoke-static v0, v4, Lcom/bytedance/lego/init/util/InitContext;->setCommonParams(Ljava/lang/Object; Ljava/lang/Object;)V
    return-void 
.end method

.method public static final synthetic access$getInst$cp()com.bytedance.trae.TraeApplication
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/TraeApplication;->inst Lcom/bytedance/trae/TraeApplication;
    return-object v0
.end method

.method private static final attachBaseContext$lambda$0()androidx.fragment.app.FragmentActivity
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getResumActivity()Landroid/app/Activity;
    move-result-object v0
    if-nez v0, +00ch
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    instance-of v1, v0, Landroidx/fragment/app/FragmentActivity;
    if-eqz v1, +005h
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private static final attachBaseContext$lambda$1()android.app.Activity
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getResumActivity()Landroid/app/Activity;
    move-result-object v0
    if-nez v0, +00ch
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    return-object v0
.end method

.method public static com_bytedance_trae_TraeApplication_com_bytedance_push_starter_PushInitLancet_onCreate(com.bytedance.trae.TraeApplication)void
    .registers 3
    # ins_size=1
    const-string v0, "PushStarter"
    const-string v1, "hook of Application.onCreate by Lancet"
    invoke-static v0, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-boolean v0, Lcom/bytedance/push/starter/PushInitLancet;->enableHook Z
    if-nez v0, +006h
    invoke-virtual v2, Lcom/bytedance/trae/TraeApplication;->com_bytedance_trae_TraeApplication__onCreate$___twin___()V
    return-void 
    move-object v0, v2
    check-cast v0, Landroid/app/Application;
    invoke-static v0, Lcom/bytedance/push/starter/PushHook;->onHookApplicationOnCreate(Landroid/app/Application;)Z
    move-result v0
    if-eqz v0, +005h
    invoke-virtual v2, Lcom/bytedance/trae/TraeApplication;->com_bytedance_trae_TraeApplication__onCreate$___twin___()V
    return-void 
.end method

.method private final configureKmpHostActions(android.content.Context)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostActions;
    new-instance v1, Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;-><init>(Landroid/content/Context;)V
    check-cast v1, Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/host/KmpHostActions;->configure(Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;)V
    return-void 
.end method

.method private final initAnyWhereDoor()void
    .registers 6
    # ins_size=1
    const-string v0, "TraeApplication"
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    if-nez v1, +003h
    return-void 
    const-string v1, "com.bytedance.trae.anydoor.AnyDoorDebugInitializer"
    invoke-static v1, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v1
    const-string v2, "init"
    const/4 v3, 0
    new-array v4, v3, [Ljava/lang/Class;
    invoke-virtual v1, v2, v4, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v1
    new-array v2, v3, [Ljava/lang/Object;
    const/4 v3, 0
    invoke-virtual v1, v3, v2, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    goto +13h
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "AnyDoor debug initializer failed"
    check-cast v1, Ljava/lang/Throwable;
    invoke-virtual v2, v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto +8h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "AnyDoor debug initializer not found"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0xb
.end method

.method private final initFlogger()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Lcom/bytedance/trae/TraeApplication$initFlogger$1;
    invoke-direct v1, Lcom/bytedance/trae/TraeApplication$initFlogger$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/utils/logger/ILogger;
    invoke-virtual v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->setLogger(Lcom/bytedance/trae/utils/logger/ILogger;)V
    return-void 
.end method

.method private final initKeva(android.content.Context)void
    .registers 4
    # ins_size=2
    invoke-static Lcom/bytedance/keva/KevaBuilder;->getInstance()Lcom/bytedance/keva/KevaBuilder;
    move-result-object v0
    const-string v1, "getInstance(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v3, Lcom/bytedance/keva/KevaBuilder;->setContext(Landroid/content/Context;)Lcom/bytedance/keva/KevaBuilder;
    return-void 
.end method

.method private static final onCreate$lambda$2()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->resetNetworkCache()Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method protected attachBaseContext(android.content.Context)void
    .registers 7
    # ins_size=2
    const-string v0, "base"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/ApiHost;->initHostResolver()V
    sget-object v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->configureFromNativeHostResolver()V
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    new-instance v2, Lcom/bytedance/trae/kmp/AndroidKmpHostInfo;
    invoke-direct v2, Lcom/bytedance/trae/kmp/AndroidKmpHostInfo;-><init>()V
    check-cast v2, Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->configure(Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    sget-object v1, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->INSTANCE Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;
    invoke-virtual v1, v6, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->initialize(Landroid/content/Context;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/TraeApplication;->configureKmpHostActions(Landroid/content/Context;)V
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;
    new-instance v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
    invoke-virtual v6, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v3
    if-nez v3, +003h
    move-object v3, v6
    new-instance v4, Lcom/bytedance/trae/TraeApplication$$ExternalSyntheticLambda0;
    invoke-direct v4, Lcom/bytedance/trae/TraeApplication$$ExternalSyntheticLambda0;-><init>()V
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;-><init>(Landroid/content/Context; Lkotlin/jvm/functions/Function0;)V
    check-cast v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->configure(Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;)V
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    new-instance v2, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;
    new-instance v3, Lcom/bytedance/trae/TraeApplication$$ExternalSyntheticLambda1;
    invoke-direct v3, Lcom/bytedance/trae/TraeApplication$$ExternalSyntheticLambda1;-><init>()V
    invoke-direct v2, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v2, Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->configure(Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;)V
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    new-instance v2, Lcom/bytedance/trae/TraeApplication$attachBaseContext$3;
    invoke-direct v2, Lcom/bytedance/trae/TraeApplication$attachBaseContext$3;-><init>()V
    check-cast v2, Lcom/bytedance/trae/network/LoginContextProvider;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->setLoginContextProvider(Lcom/bytedance/trae/network/LoginContextProvider;)V
    sget-object v1, Lcom/bytedance/trae/LifecycleMonitor;->INSTANCE Lcom/bytedance/trae/LifecycleMonitor;
    move-object v2, v5
    check-cast v2, Landroid/app/Application;
    invoke-virtual v1, v2, Lcom/bytedance/trae/LifecycleMonitor;->onAppAttachBaseContext(Landroid/app/Application;)V
    invoke-static v0, v6, Lcom/bytedance/lego/init/util/InitContext;->setCommonParams(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/TraeApplication;->initKeva(Landroid/content/Context;)V
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, Lcom/bytedance/trae/utils/LocaleManager;->init()V
    sget-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->INSTANCE Lcom/bytedance/trae/common/theme/ThemeManager;
    invoke-virtual v0, Lcom/bytedance/trae/common/theme/ThemeManager;->init()V
    invoke-static Lcom/bytedance/trae/ServiceUtils;->bindService()V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, v6, Lcom/bytedance/trae/home/privacy/PrivacyManager;->init(Landroid/content/Context;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v1
    if-nez v1, +014h
    if-nez v0, +012h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isPreinstallApp()Z
    move-result v0
    if-eqz v0, +00ah
    new-instance v0, Lcom/bytedance/trae/NoPrivacyAuthorizedLauncher;
    invoke-direct v0, Lcom/bytedance/trae/NoPrivacyAuthorizedLauncher;-><init>()V
    check-cast v0, Lcom/bytedance/trae/ILauncher;
    goto +8h
    new-instance v0, Lcom/bytedance/trae/PrivacyAuthorizedLauncher;
    invoke-direct v0, Lcom/bytedance/trae/PrivacyAuthorizedLauncher;-><init>()V
    check-cast v0, Lcom/bytedance/trae/ILauncher;
    iput-object v0, v5, Lcom/bytedance/trae/TraeApplication;->launcher Lcom/bytedance/trae/ILauncher;
    invoke-interface v0, v6, Lcom/bytedance/trae/ILauncher;->beforeAttachBaseContext(Landroid/content/Context;)V
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, v6, Lcom/bytedance/trae/utils/LocaleManager;->wrapContext(Landroid/content/Context;)Landroid/content/Context;
    move-result-object v0
    invoke-super v5, v0, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V
    iget-object v0, v5, Lcom/bytedance/trae/TraeApplication;->launcher Lcom/bytedance/trae/ILauncher;
    if-nez v0, +008h
    const-string v0, "launcher"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-interface v0, v6, Lcom/bytedance/trae/ILauncher;->afterAttachBaseContext(Landroid/content/Context;)V
    move-object v6, v5
    check-cast v6, Landroid/content/Context;
    invoke-static v6, Lcom/bytedance/trae/utils/AppUtils;->isMainProcess(Landroid/content/Context;)Z
    move-result v0
    if-nez v0, +009h
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v0
    invoke-interface v0, v2, Lcom/bytedance/push/interfaze/IPushService;->onAttachBaseContext(Landroid/app/Application;)V
    invoke-static Lcom/bytedance/rheatrace/RheaDependencyManager;->enabled()Z
    move-result v0
    if-eqz v0, +009h
    invoke-static Lcom/bytedance/rheatrace/RheaDependencyManager;->getAppStartCallback()Lcom/bytedance/rheatrace/core/RheaAppStartCallback;
    move-result-object v0
    invoke-static v6, v0, Lcom/bytedance/rheatrace/core/RheaTrace3;->init(Landroid/content/Context; Lcom/bytedance/rheatrace/core/RheaAppStartCallback;)V
    return-void 
.end method

.method public com_bytedance_trae_TraeApplication__onCreate$___twin___()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->INSTANCE Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
    new-instance v1, Lcom/bytedance/trae/TraeApplication$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/TraeApplication$$ExternalSyntheticLambda2;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->setResetAction(Lkotlin/jvm/functions/Function0;)V
    iget-object v0, v4, Lcom/bytedance/trae/TraeApplication;->launcher Lcom/bytedance/trae/ILauncher;
    const/4 v1, 0
    const-string v2, "launcher"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    move-object v3, v4
    check-cast v3, Landroid/app/Application;
    invoke-interface v0, v3, Lcom/bytedance/trae/ILauncher;->beforeOnCreate(Landroid/app/Application;)V
    invoke-super v4, Landroid/app/Application;->onCreate()V
    iget-object v0, v4, Lcom/bytedance/trae/TraeApplication;->launcher Lcom/bytedance/trae/ILauncher;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-interface v1, v3, Lcom/bytedance/trae/ILauncher;->afterOnCreate(Landroid/app/Application;)V
    invoke-direct v4, Lcom/bytedance/trae/TraeApplication;->initAnyWhereDoor()V
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->registerLifeCycle(Landroid/app/Application;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->initAfterPrivacyAgreed(Landroid/app/Application;)V
    new-instance v0, Lcom/bytedance/trae/TraeApplication$onCreate$2;
    invoke-direct v0, Lcom/bytedance/trae/TraeApplication$onCreate$2;-><init>()V
    check-cast v0, Landroid/app/Application$ActivityLifecycleCallbacks;
    invoke-virtual v4, v0, Lcom/bytedance/trae/TraeApplication;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    return-void 
.end method

.method public final getStartTime()kotlin.Pair
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/TraeApplication;->startTime Lkotlin/Pair;
    return-object v0
.end method

.method public onCreate()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/TraeApplication;->com_bytedance_trae_TraeApplication_com_bytedance_push_starter_PushInitLancet_onCreate(Lcom/bytedance/trae/TraeApplication;)V
    return-void 
.end method

.method public unbindService(android.content.ServiceConnection)void
    .registers 7
    # ins_size=2
    const-string v0, "conn"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v5, v6, Landroid/app/Application;->unbindService(Landroid/content/ServiceConnection;)V
    return-void 
    move-exception v6
    invoke-virtual v6, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01dh
    check-cast v0, Ljava/lang/CharSequence;
    const-string v1, "Service not registered"
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 2
    const/4 v3, 0
    const/4 v4, 0
    invoke-static v0, v1, v4, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00eh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Ignored Huawei & Honor WebView unbindService crash"
    check-cast v6, Ljava/lang/Throwable;
    const-string v2, "TraeApplication"
    invoke-virtual v0, v2, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    throw v6
    :try_start_0x5
.end method
