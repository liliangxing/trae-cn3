# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
.super Ljava/lang/Object;
.source "TenantUserConfigRepository.kt"

.field private static final CACHE_TTL_MS:J
.field private static final EMPTY_REQUEST:Ljava/util/Map;
.field public static final INSTANCE:Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
.field private static final TAG:Ljava/lang/String;
.field private static bridge accountConfigGeneration:J
.field private static bridge asyncRefreshJob:Lkotlinx/coroutines/Job;
.field private static final cacheStateLock:Ljava/lang/Object;
.field private static bridge cachedConfig:Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
.field private static bridge hasSuccessfulConfig:Z
.field private static bridge lastRefreshElapsedMs:J
.field private static bridge pollingJob:Lkotlinx/coroutines/Job;
.field private static final refreshMutex:Lkotlinx/coroutines/sync/Mutex;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->EMPTY_REQUEST Ljava/util/Map;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v2
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v2, v3, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    sget-object v3, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v4, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v4, Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v2, v4, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    invoke-static v2, v1, v0, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refreshMutex Lkotlinx/coroutines/sync/Mutex;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cacheStateLock Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$currentGeneration(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository)long
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->currentGeneration()J
    move-result-wide v0
    return-wide v0
.end method

.method public static final synthetic access$fetchTenantUserConfig(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->fetchTenantUserConfig(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$refresh(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  boolean  java.lang.String  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refresh(Z Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final clearCacheAndBumpGeneration()long
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cacheStateLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->asyncRefreshJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v1, +006h
    const/4 v3, 1
    invoke-static v1, v2, v3, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->asyncRefreshJob Lkotlinx/coroutines/Job;
    sget-object v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    const/4 v1, 0
    sput-boolean v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->hasSuccessfulConfig Z
    const-wide/16 v1, 0
    sput-wide v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->lastRefreshElapsedMs J
    sget-wide v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->accountConfigGeneration J
    const-wide/16 v3, 1
    add-long/2addr v1, v3
    sput-wide v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->accountConfigGeneration J
    sget-wide v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->accountConfigGeneration J
    monitor-exit v0
    return-wide v1
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method private final currentGeneration()long
    .registers 3
    # ins_size=1
    sget-wide v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->accountConfigGeneration J
    return-wide v0
.end method

.method public static synthetic ensureEnterpriseBlacklistCommandsFresh$default(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +004h
    const-string v1, "command_blacklist"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->ensureEnterpriseBlacklistCommandsFresh(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic ensureMcpWhitelistFresh$default(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +004h
    const-string v1, "mcp_whitelist"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->ensureMcpWhitelistFresh(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final fetchTenantUserConfig(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=3
    instance-of v0, v15, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;
    if-eqz v0, +012h
    move-object v0, v15
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;
    iget v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v15, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->label I
    sub-int/2addr v15, v2
    iput v15, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;
    invoke-direct v0, v13, v15, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->label I
    const/4 v3, 1
    if-eqz v2, +018h
    if-ne v2, v3, +00eh
    iget-object v14, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->L$1 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v15, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v15, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v5, "base"
    const-class v6, Lcom/bytedance/trae/im/service/tenant/ITenantUserConfigApi;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 60
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/im/service/tenant/ITenantUserConfigApi;
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->EMPTY_REQUEST Ljava/util/Map;
    iput-object v13, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->L$0 Ljava/lang/Object;
    iput-object v14, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$fetchTenantUserConfig$1;->label I
    invoke-interface v15, v2, v0, Lcom/bytedance/trae/im/service/tenant/ITenantUserConfigApi;->getTenantUserConfig(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v1, +003h
    return-object v1
    move-object v0, v13
    check-cast v15, Lcom/bytedance/retrofit2/SsResponse;
    invoke-direct v0, v15, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->parseTenantUserConfigResponse(Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v15
    goto +30h
    move-exception v15
    move-object v3, v15
    new-instance v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1004
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    move-object v2, v0
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v15
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +16h
    move-exception v15
    new-instance v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1001
    const-string v2, ""
    move-object v3, v15
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v15, v7
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string/jumbo v1, safeCall done source=
    const-string v2, "TenantUserConfig"
    if-eqz v0, +02ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v1, ", bizCode="
    invoke-virtual v14, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    move-object v1, v15
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-virtual v14, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v2, v14, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +28h
    instance-of v0, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +026h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v1, ", errorCode="
    invoke-virtual v14, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    move-object v1, v15
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v1
    invoke-virtual v14, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v2, v14, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v15
    new-instance v14, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v14, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v14
    :try_start_0x2e
    :try_start_0x3d
.end method

.method public static synthetic isAllowedByStdioConfig$default(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  java.lang.String  java.lang.String  java.util.List  java.lang.String  int  java.lang.Object)boolean
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    const-string v4, ""
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isAllowedByStdioConfig(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method private final isCacheValid()boolean
    .registers 5
    # ins_size=1
    sget-wide v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->lastRefreshElapsedMs J
    sget-boolean v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->hasSuccessfulConfig Z
    if-eqz v2, +016h
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +010h
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    sub-long/2addr v2, v0
    const-wide/32 v0, 600000
    cmp-long v0, v2, v0
    if-gez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final isEnterpriseLogin()boolean
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    const-string v1, "enterprise"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public static synthetic isWorkspaceAIEnabled$default(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  java.lang.String  java.util.List  int  java.lang.Object)boolean
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isWorkspaceAIEnabled(Ljava/lang/String; Ljava/util/List;)Z
    move-result v0
    return v0
.end method

.method private final markRefreshAttempt(java.lang.String  java.lang.String  long)com.bytedance.trae.im.service.tenant.TenantUserConfigResponse
    .registers 8
    # ins_size=5
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cacheStateLock Ljava/lang/Object;
    monitor-enter v0
    sget-wide v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->accountConfigGeneration J
    cmp-long v6, v6, v1
    if-nez v6, +014h
    sget-object v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v6
    if-nez v6, +003h
    goto +ah
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v6
    sput-wide v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->lastRefreshElapsedMs J
    sget-object v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    goto +2h
    const/4 v6, 0
    monitor-exit v0
    if-nez v6, +009h
    sget-object v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v4
    return-object v4
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "TenantUserConfig"
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "refresh failed source="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, ", "
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v0, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v6
    move-exception v4
    monitor-exit v0
    throw v4
    :try_start_0x3
.end method

.method private final parseTenantUserConfigResponse(com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.HttpDataResult
    .registers 14
    # ins_size=2
    if-nez v13, +01fh
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1005
    const-string/jumbo v2, response is null
    new-instance v0, Ljava/lang/NullPointerException;
    const-string/jumbo v3, response is null
    invoke-direct v0, v3, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    move-object v3, v0
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v13
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v13
    invoke-virtual v13, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +05ch
    invoke-virtual v13, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +036h
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    if-eqz v0, +030h
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v3, Ljava/io/InputStreamReader;
    invoke-direct v3, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v3, Ljava/io/Reader;
    instance-of v0, v3, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v3, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v3, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v3, v0
    check-cast v3, Ljava/io/Closeable;
    move-object v0, v3
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v0
    invoke-static v3, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +9h
    move-exception v13
    throw v13
    move-exception v0
    invoke-static v3, v13, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v0
    move-object v0, v1
    if-nez v0, +01fh
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v3, -1005
    const-string/jumbo v4, response body is null
    new-instance v0, Ljava/lang/NullPointerException;
    const-string/jumbo v1, response body is null
    invoke-direct v0, v1, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    move-object v5, v0
    check-cast v5, Ljava/lang/Throwable;
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v13
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v13
    const-class v2, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v2, Ljava/lang/reflect/Type;
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/reflect/Type;
    const/4 v4, 0
    const-class v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    aput-object v5, v3, v4
    invoke-static v2, v3, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v3
    invoke-virtual v3, v0, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v2, +01fh
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v4, -1004
    const-string/jumbo v5, response envelope is null
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string/jumbo v1, response envelope is null
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    move-object v6, v0
    check-cast v6, Ljava/lang/Throwable;
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v13
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v13
    invoke-virtual v2, v13, Lcom/bytedance/trae/network/response/BizResponse;->setupSSResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    if-nez v3, +01ah
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v3
    if-eqz v3, +012h
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v3
    const-class v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    goto +3h
    move-object v10, v1
    goto +2h
    move-object v10, v3
    new-instance v0, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getPayload()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v11
    move-object v4, v0
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v13, Lcom/bytedance/trae/network/response/BizResponse;->setupSSResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-direct v13, v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v13
    :try_start_0x4e
    :try_start_0x5c
.end method

.method private final refresh(boolean  java.lang.String  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=6
    move-wide/from16 v0, v20
    move-object/from16 v2, v22
    const-string v3, "refresh success source="
    const-string v4, "empty data or bizCode="
    const-string v5, "network error code="
    instance-of v6, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;
    if-eqz v6, +014h
    move-object v6, v2
    check-cast v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;
    iget v7, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    const/high16 v8, -2147483648
    and-int/2addr v7, v8
    if-eqz v7, +00ah
    iget v2, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    sub-int/2addr v2, v8
    iput v2, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    move-object/from16 v7, v17
    goto +8h
    new-instance v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;
    move-object/from16 v7, v17
    invoke-direct v6, v7, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v8
    iget v9, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    const/4 v10, 2
    const/4 v11, 1
    const/4 v12, 0
    if-eqz v9, +035h
    if-eq v9, v11, +01eh
    if-ne v9, v10, +014h
    iget-wide v0, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->J$0 J
    iget-object v8, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$1 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/sync/Mutex;
    iget-object v6, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07ch
    move-exception v0
    goto/16 +192h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-wide v0, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->J$0 J
    iget-boolean v9, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->Z$0 Z
    iget-object v11, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lkotlinx/coroutines/sync/Mutex;
    iget-object v13, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$0 Ljava/lang/Object;
    check-cast v13, Ljava/lang/String;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v16, v13
    move v13, v9
    move-object/from16 v9, v16
    goto +2ch
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct/range v17, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v2
    if-eqz v2, +170h
    invoke-direct/range v17, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->currentGeneration()J
    move-result-wide v13
    cmp-long v2, v0, v13
    if-eqz v2, +004h
    goto/16 +166h
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refreshMutex Lkotlinx/coroutines/sync/Mutex;
    move-object/from16 v9, v19
    iput-object v9, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$0 Ljava/lang/Object;
    iput-object v2, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$1 Ljava/lang/Object;
    move/from16 v13, v18
    iput-boolean v13, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->Z$0 Z
    iput-wide v0, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->J$0 J
    iput v11, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    invoke-interface v2, v12, v6, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v8, +003h
    return-object v8
    move-object v11, v2
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v14
    if-eqz v14, +136h
    invoke-direct v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->currentGeneration()J
    move-result-wide v14
    cmp-long v14, v0, v14
    if-eqz v14, +004h
    goto/16 +12ch
    if-nez v13, +00ch
    invoke-direct v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isCacheValid()Z
    move-result v13
    if-eqz v13, +006h
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    goto/16 +126h
    iput-object v9, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$0 Ljava/lang/Object;
    iput-object v11, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->L$1 Ljava/lang/Object;
    iput-wide v0, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->J$0 J
    iput v10, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    invoke-direct v2, v9, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->fetchTenantUserConfig(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v8, +003h
    return-object v8
    move-object v6, v9
    move-object v8, v11
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v9, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v9, +0d4h
    sget-object v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v9
    if-eqz v9, +0c4h
    invoke-direct v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->currentGeneration()J
    move-result-wide v9
    cmp-long v9, v0, v9
    if-eqz v9, +004h
    goto/16 +0bah
    move-object v9, v2
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v9
    if-eqz v9, +010h
    move-object v9, v2
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    goto +2h
    move-object v9, v12
    if-eqz v9, +080h
    invoke-direct v5, v9, v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->saveConfigIfCurrent(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse; J)Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    goto/16 +094h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "TenantUserConfig"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", repos="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getConfigInfo()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->getBlacklistRepos()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", commands="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getConfigInfo()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->getBlacklistCommands()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", rules="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getSecurityRules()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", mcpWhitelist="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getMcpWhitelistConfig()Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    move-result-object v3
    if-eqz v3, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;->getWhitelists()Ljava/util/List;
    move-result-object v3
    if-eqz v3, +007h
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v9
    goto +23h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v3, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v5, v6, v2, v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->markRefreshAttempt(Ljava/lang/String; Ljava/lang/String; J)Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    goto +7h
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    move-object v11, v8
    goto +3ch
    instance-of v3, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +02dh
    sget-object v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", msg="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v3, v6, v2, v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->markRefreshAttempt(Ljava/lang/String; Ljava/lang/String; J)Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    goto -30h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    invoke-interface v11, v12, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    move-exception v0
    move-object v8, v11
    invoke-interface v8, v12, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    return-object v0
    :try_start_0x42
    :try_start_0x92
    :try_start_0xc1
    :try_start_0x1ce
.end method

.method static synthetic refresh$default(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  boolean  java.lang.String  long  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 4
    if-eqz v12, +006h
    invoke-direct v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->currentGeneration()J
    move-result-wide v9
    move-wide v3, v9
    move-object v0, v6
    move v1, v7
    move-object v2, v8
    move-object v5, v11
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refresh(Z Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    return-object v6
.end method

.method public static synthetic refreshMcpWhitelist$default(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +004h
    const-string v1, "mcp_whitelist"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refreshMcpWhitelist(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final resolvedType(com.bytedance.trae.im.service.tenant.McpWhitelistItem)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getType()Ljava/lang/String;
    move-result-object v0
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    return-object v0
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +015h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getCommand()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +2h
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +005h
    const-string v4, "http"
    goto +4h
    const-string/jumbo v4, stdio
    return-object v4
.end method

.method private final saveConfigIfCurrent(com.bytedance.trae.im.service.tenant.TenantUserConfigResponse  long)com.bytedance.trae.im.service.tenant.TenantUserConfigResponse
    .registers 7
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cacheStateLock Ljava/lang/Object;
    monitor-enter v0
    sget-wide v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->accountConfigGeneration J
    cmp-long v5, v5, v1
    if-nez v5, +017h
    sget-object v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v5
    if-nez v5, +003h
    goto +dh
    sput-object v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    const/4 v5, 1
    sput-boolean v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->hasSuccessfulConfig Z
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v5
    sput-wide v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->lastRefreshElapsedMs J
    goto +2h
    const/4 v4, 0
    monitor-exit v0
    return-object v4
    move-exception v4
    monitor-exit v0
    throw v4
    :try_start_0x3
.end method

.method public final clearCache()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->clearCacheAndBumpGeneration()J
    return-void 
.end method

.method public final ensureEnterpriseBlacklistCommandsFresh(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    instance-of v0, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;
    iget v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;
    invoke-direct v0, v4, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +15h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v3, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureEnterpriseBlacklistCommandsFresh$1;->label I
    invoke-virtual v4, v5, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->ensureFresh(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    check-cast v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getConfigInfo()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->getBlacklistCommands()Ljava/util/List;
    move-result-object v5
    return-object v5
.end method

.method public final ensureFresh(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    invoke-direct v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v0
    if-nez v0, +009h
    sget-object v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v9
    return-object v9
    invoke-direct v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isCacheValid()Z
    move-result v0
    if-eqz v0, +005h
    sget-object v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    return-object v9
    const/4 v1, 0
    const-wide/16 v3, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v0, v8
    move-object v2, v9
    move-object v5, v10
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refresh$default(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Z Ljava/lang/String; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method

.method public final ensureMcpWhitelistFresh(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=3
    instance-of v0, v11, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;
    iget v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;
    invoke-direct v0, v9, v11, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    iget-object v11, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1dh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v11, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v11, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/4 v11, 1
    const-wide/16 v4, 0
    const/4 v7, 4
    const/4 v8, 0
    iput v2, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$ensureMcpWhitelistFresh$1;->label I
    move-object v1, v9
    move v2, v11
    move-object v3, v10
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refresh$default(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Z Ljava/lang/String; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v11, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getMcpWhitelistConfig()Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    move-result-object v10
    return-object v10
.end method

.method public final getBlacklistRepoUrlsCached()java.util.List
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getConfigInfo()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->getBlacklistRepos()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->getRepoUrls()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto -15h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public final getCachedConfig()com.bytedance.trae.im.service.tenant.TenantUserConfigResponse
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    return-object v0
.end method

.method public final getEnterpriseBlacklistCommandsCached()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getConfigInfo()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->getBlacklistCommands()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final getMcpWhitelists()java.util.List
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getMcpWhitelistConfig()Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;->getWhitelists()Ljava/util/List;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getEnable()Z
    move-result v3
    if-eqz v3, -011h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public final getSecurityRulesCached()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getSecurityRules()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final isAllowedByHttpConfig(java.lang.String)boolean
    .registers 8
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isMcpWhitelistEnabled()Z
    move-result v0
    const/4 v1, 1
    if-nez v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getMcpWhitelistConfig()Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;->getWhitelists()Ljava/util/List;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +003h
    return v3
    check-cast v0, Ljava/lang/Iterable;
    instance-of v2, v0, Ljava/util/Collection;
    if-eqz v2, +00dh
    move-object v2, v0
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v1, v3
    goto +38h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getEnable()Z
    move-result v4
    if-eqz v4, +020h
    sget-object v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v4, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->resolvedType(Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;)Ljava/lang/String;
    move-result-object v4
    const-string v5, "http"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +012h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    move v2, v1
    goto +2h
    move v2, v3
    if-eqz v2, -031h
    return v1
.end method

.method public final isAllowedByStdioConfig(java.lang.String  java.lang.String  java.util.List  java.lang.String)boolean
    .registers 11
    # ins_size=5
    const-string/jumbo v0, type
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "command"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "args"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isMcpWhitelistEnabled()Z
    move-result v0
    const/4 v1, 1
    if-nez v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getMcpWhitelistConfig()Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;->getWhitelists()Ljava/util/List;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +003h
    return v3
    check-cast v0, Ljava/lang/Iterable;
    instance-of v2, v0, Ljava/util/Collection;
    if-eqz v2, +00dh
    move-object v2, v0
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v1, v3
    goto +4fh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getEnable()Z
    move-result v4
    if-eqz v4, +037h
    sget-object v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v4, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->resolvedType(Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +02bh
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getCommand()Ljava/lang/String;
    move-result-object v4
    const-string v5, ""
    if-nez v4, +003h
    move-object v4, v5
    invoke-static v4, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +01ch
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getArg()Ljava/util/List;
    move-result-object v4
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +012h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->getUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v5, v2
    invoke-static v5, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    move v2, v1
    goto +2h
    move v2, v3
    if-eqz v2, -048h
    return v1
.end method

.method public final isMcpWhitelistEnabled()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->getMcpWhitelistConfig()Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;->getGlobalEnable()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method public final isWorkspaceAIEnabled(java.lang.String  java.util.List)boolean
    .registers 13
    # ins_size=3
    const-string v0, "gitUrls"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->getBlacklistRepoUrlsCached()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +003h
    return v2
    check-cast v12, Ljava/lang/Iterable;
    instance-of v1, v12, Ljava/util/Collection;
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 0
    if-eqz v1, +00dh
    move-object v1, v12
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v12, v5
    goto +4eh
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    move-object v6, v0
    check-cast v6, Ljava/lang/Iterable;
    instance-of v7, v6, Ljava/util/Collection;
    if-eqz v7, +00dh
    move-object v7, v6
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v1, v5
    goto +29h
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, -00ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    move-object v8, v1
    check-cast v8, Ljava/lang/CharSequence;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v8, v7, v5, v4, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +00bh
    invoke-static v7, v8, v5, v4, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move v7, v5
    goto +2h
    move v7, v2
    if-eqz v7, -021h
    move v1, v2
    if-eqz v1, -046h
    move v12, v2
    if-eqz v12, +003h
    return v5
    if-nez v11, +004h
    const-string v11, ""
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    if-nez v12, +030h
    check-cast v0, Ljava/lang/Iterable;
    instance-of v12, v0, Ljava/util/Collection;
    if-eqz v12, +00dh
    move-object v12, v0
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v12
    if-eqz v12, +004h
    move v11, v2
    goto +1ah
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, -00ah
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v11, v0, v5, v4, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, -012h
    move v11, v5
    if-eqz v11, +003h
    goto +2h
    move v2, v5
    return v2
.end method

.method public final onAccountChanged()void
    .registers 10
    # ins_size=1
    invoke-direct v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->clearCacheAndBumpGeneration()J
    move-result-wide v0
    invoke-direct v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v2
    if-eqz v2, +018h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->startPolling()V
    sget-object v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$onAccountChanged$1;
    const/4 v6, 0
    invoke-direct v2, v0, v1, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$onAccountChanged$1;-><init>(J Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +4h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->stopPolling()V
    return-void 
.end method

.method public final refreshMcpWhitelist(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    const/4 v1, 1
    const-wide/16 v3, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v0, v8
    move-object v2, v9
    move-object v5, v10
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->refresh$default(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Z Ljava/lang/String; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method

.method public final startPolling()void
    .registers 9
    # ins_size=1
    invoke-direct v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v0
    if-nez v0, +006h
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->stopPolling()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final stopPolling()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final triggerRefreshIfNeeded(java.lang.String)com.bytedance.trae.im.service.tenant.TenantUserConfigResponse
    .registers 10
    # ins_size=2
    const-string/jumbo v0, source
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isEnterpriseLogin()Z
    move-result v0
    if-nez v0, +009h
    sget-object v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v9
    return-object v9
    invoke-direct v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->isCacheValid()Z
    move-result v0
    if-eqz v0, +005h
    sget-object v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    return-object v9
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->asyncRefreshJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-nez v1, +01ah
    invoke-direct v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->currentGeneration()J
    move-result-wide v0
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;
    const/4 v6, 0
    invoke-direct v5, v9, v0, v1, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;-><init>(Ljava/lang/String; J Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v9
    sput-object v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->asyncRefreshJob Lkotlinx/coroutines/Job;
    sget-object v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->cachedConfig Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    return-object v9
.end method
