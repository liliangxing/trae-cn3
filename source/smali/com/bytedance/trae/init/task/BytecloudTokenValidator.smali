# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
.super Ljava/lang/Object;
.source "BytecloudTokenValidator.kt"

.field public static final $stable:I
.field private static final ERROR_CODE_REAUTH_REQUIRED:Ljava/lang/String;
.field private static final HTTP_UNAUTHORIZED:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
.field private static final KEY_LAST_CHECK_AT:Ljava/lang/String;
.field private static final ONE_DAY_MS:J
.field private static final TAG:Ljava/lang/String;
.field private static final UNAUTHORIZED_THROTTLE_MS:J
.field private static final lastUnauthorizedNotifyAt:Ljava/util/concurrent/atomic/AtomicLong;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;
.field private static final validating:Ljava/util/concurrent/atomic/AtomicBoolean;


.method public static synthetic $r8$lambda$DjITendmt_YMmk_c-QmRv1BKUzc()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->handleUnauthorizedSession$lambda$0()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    invoke-direct v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;
    const-wide/16 v1, 0
    invoke-direct v0, v1, v2, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V
    sput-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->lastUnauthorizedNotifyAt Ljava/util/concurrent/atomic/AtomicLong;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->validating Ljava/util/concurrent/atomic/AtomicBoolean;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$extractHttpStatusCode(com.bytedance.trae.init.task.BytecloudTokenValidator  java.lang.Throwable)int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->extractHttpStatusCode(Ljava/lang/Throwable;)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$getValidating$p()java.util.concurrent.atomic.AtomicBoolean
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->validating Ljava/util/concurrent/atomic/AtomicBoolean;
    return-object v0
.end method

.method public static final synthetic access$handleUnauthorizedSession(com.bytedance.trae.init.task.BytecloudTokenValidator  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->handleUnauthorizedSession(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$saveLastCheckAt(com.bytedance.trae.init.task.BytecloudTokenValidator  long)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->saveLastCheckAt(J)V
    return-void 
.end method

.method private final doValidate()void
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->validating Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-nez v0, +00ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BytecloudTokenValidator"
    const-string v2, "doValidate: already in-flight, skip"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final extractHttpStatusCode(java.lang.Throwable)int
    .registers 3
    # ins_size=2
    if-eqz v2, +01dh
    instance-of v0, v2, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    invoke-virtual v2, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;->getStatusCode()I
    move-result v2
    return v2
    instance-of v0, v2, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    invoke-virtual v2, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;->getStatusCode()I
    move-result v2
    return v2
    invoke-virtual v2, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    move-result-object v2
    goto -1ch
    const/4 v2, -1
    return v2
.end method

.method private final getLastCheckAt()long
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/keva/KevaRepos;->INSTANCE Lcom/bytedance/trae/keva/KevaRepos;
    invoke-virtual v0, Lcom/bytedance/trae/keva/KevaRepos;->getDefaultRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "bytecloud_token_last_check_at"
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v0
    return-wide v0
.end method

.method private final handleUnauthorizedSession(java.lang.String)void
    .registers 11
    # ins_size=2
    invoke-direct v9, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->shouldValidate()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-object v2, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->lastUnauthorizedNotifyAt Ljava/util/concurrent/atomic/AtomicLong;
    invoke-virtual v2, Ljava/util/concurrent/atomic/AtomicLong;->get()J
    move-result-wide v3
    sub-long v5, v0, v3
    const-wide/16 v7, 2000
    cmp-long v5, v5, v7
    if-gez v5, +003h
    return-void 
    invoke-virtual v2, v3, v4, v0, v1, Ljava/util/concurrent/atomic/AtomicLong;->compareAndSet(J J)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleUnauthorizedSession: bytecloud token invalid, forcing logout, msg="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v1, "BytecloudTokenValidator"
    invoke-virtual v0, v1, v10, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v10, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-direct v10, v0, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v10, v0, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final handleUnauthorizedSession$lambda$0()void
    .registers 4
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    const v1, 2131690880
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +009h
    const/4 v1, 0
    const-string v2, "bytecloud_rt_expired"
    const/4 v3, 1
    invoke-interface v0, v3, v1, v2, Lcom/bytedance/trae/login/api/ILoginService;->logout(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method private final saveLastCheckAt(long)void
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/keva/KevaRepos;->INSTANCE Lcom/bytedance/trae/keva/KevaRepos;
    invoke-virtual v0, Lcom/bytedance/trae/keva/KevaRepos;->getDefaultRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "bytecloud_token_last_check_at"
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method private final shouldValidate()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return v1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v2, 1
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v0
    if-ne v0, v2, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-nez v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v0
    if-nez v0, +003h
    return v1
    return v2
.end method

.method public final validateOnColdLaunch()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->shouldValidate()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->doValidate()V
    return-void 
.end method

.method public final validateOnForegroundIfNeeded()void
    .registers 7
    # ins_size=1
    invoke-direct v6, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->shouldValidate()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v6, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->getLastCheckAt()J
    move-result-wide v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v4, v0, v4
    if-lez v4, +02dh
    sub-long/2addr v2, v0
    const-wide/32 v0, 86400000
    cmp-long v0, v2, v0
    if-gez v0, +025h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v4, validateOnForeground: skip, last check 
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/16 v4, 1000
    int-to-long v4, v4
    div-long/2addr v2, v4
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string/jumbo v2, s ago
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "BytecloudTokenValidator"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-direct v6, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->doValidate()V
    return-void 
.end method
