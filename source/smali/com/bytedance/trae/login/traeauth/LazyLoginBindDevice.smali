# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;
.super Ljava/lang/Object;
.source "LazyLoginBindDevice.java"

.field private static final ioExecutor:Ljava/util/concurrent/ExecutorService;
.field private static bridge isBindScheduled:Z
.field private static bridge isNeedBind:Z
.field private static final mainHandler:Landroid/os/Handler;


.method public static synthetic $r8$lambda$8UvXSvr5UH9nHIyn5WOohagpgzo(boolean)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->onResult(Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ci-gkuDY79F0O71tNk5i9J8kDtE()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->realBindDevice()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->ioExecutor Ljava/util/concurrent/ExecutorService;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->mainHandler Landroid/os/Handler;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method static synthetic lambda$onResult$3()void
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v0, +015h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit I
    invoke-virtual v0, v1, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 1
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    sget-object v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->performForceLogout(Landroid/app/Activity;)V
    return-void 
.end method

.method static synthetic lambda$realBindDevice$0(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
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

.method static synthetic lambda$realBindDevice$1()void
    .registers 3
    # ins_size=0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, v1, Lkotlinx/coroutines/BuildersKt;->runBlocking(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    if-eqz v0, +00ch
    sget-object v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->REBIND Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v2, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda1;
    invoke-direct v2, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->showWhenReadyAsync(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    return-void 
    :try_start_0x0
.end method

.method static synthetic lambda$realBindDevice$2(com.bytedance.trae.login.traeauth.BindDeviceResult)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Ljava/lang/Boolean;->TRUE Ljava/lang/Boolean;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;->isDeviceLimit()Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ch
    sget-object v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->ioExecutor Ljava/util/concurrent/ExecutorService;
    new-instance v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda4;-><init>()V
    invoke-interface v1, v0, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public static lazyBindDevice()void
    .registers 4
    # ins_size=0
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->isNeedBind Z
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v2, Lcom/bytedance/trae/network/DebugSettings;->isDeviceManagerMockDid()Z
    move-result v2
    if-eqz v2, +01eh
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +02ch
    invoke-static Ljava/lang/Math;->random()D
    move-result-wide v0
    const-wide v2, 4658815484840378368
    mul-double/2addr v0, v2
    double-to-long v0, v0
    sget-object v2, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->mainHandler Landroid/os/Handler;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda5;
    invoke-direct v3, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda5;-><init>()V
    invoke-virtual v2, v3, v0, v1, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    goto +15h
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +010h
    sput-boolean v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->isBindScheduled Z
    sget-object v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda2;-><init>()V
    const-wide/16 v2, 2000
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method public static onDidGet()void
    .registers 4
    # ins_size=0
    sget-boolean v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->isBindScheduled Z
    if-eqz v0, +003h
    return-void 
    sget-boolean v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->isNeedBind Z
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda2;-><init>()V
    const-wide/16 v2, 2000
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static onResult(boolean)void
    .registers 2
    # ins_size=1
    if-nez v1, +00dh
    sget-object v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->mainHandler Landroid/os/Handler;
    new-instance v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda3;-><init>()V
    invoke-virtual v1, v0, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    goto +7h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const/4 v0, 0
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->bindDeviceAsync(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static realBindDevice()void
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda6;
    invoke-direct v1, Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice$$ExternalSyntheticLambda6;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->bindDeviceAsync(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method
