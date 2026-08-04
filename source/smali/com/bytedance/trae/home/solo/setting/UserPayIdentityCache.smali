# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
.super Ljava/lang/Object;
.source "UserPayIdentityCache.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
.field private static final TAG:Ljava/lang/String;
.field private static bridge cachedPayStatus:Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
.field private static bridge cachedUsageQuota:Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
.field private static final exceptionHandler:Lkotlinx/coroutines/CoroutineExceptionHandler;
.field private static bridge ownedCNPayStatus:Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
.field private static bridge ownedCreditsBalance:Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$CeHP22gpoqmdyjv2zoTAXv8X9NQ(java.lang.String)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchBillingUpgradePreparation$lambda$9(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    sput-object v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->exceptionHandler Lkotlinx/coroutines/CoroutineExceptionHandler;
    const/4 v0, 0
    const/4 v2, 1
    invoke-static v0, v2, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v2, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->scope Lkotlinx/coroutines/CoroutineScope;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$currentTocUserId(com.bytedance.trae.home.solo.setting.UserPayIdentityCache)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setCachedUsageQuota$p(com.bytedance.trae.home.solo.setting.UsageQuotaData)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-void 
.end method

.method public static final synthetic access$setOwnedCNPayStatus$p(com.bytedance.trae.home.solo.setting.UserPayIdentityCache$OwnedCNPayStatus)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCNPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    return-void 
.end method

.method public static final synthetic access$switchBillingVersionWithObservation(com.bytedance.trae.home.solo.setting.UserPayIdentityCache  com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->switchBillingVersionWithObservation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final cachedCNPayStatusForRequest(java.lang.String)com.bytedance.trae.home.solo.setting.CNUserPayStatusData
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCNPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;->getUserId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;->getStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v2
    invoke-static v5, v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCacheKt;->selectCachedCNPayStatusForRequest(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;)Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v5
    return-object v5
.end method

.method private final currentCNPayStatus()com.bytedance.trae.home.solo.setting.CNUserPayStatusData
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCNPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;->getUserId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v2, v1
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;->getStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v1
    return-object v1
.end method

.method private final currentLoggedInUserId()java.lang.String
    .registers 4
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +024h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +01eh
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +014h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00eh
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    move-object v1, v0
    return-object v1
.end method

.method private final currentTocUserId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-nez v0, +004h
    const/4 v0, 0
    return-object v0
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final fetchBillingUpgradePreparation$lambda$9(java.lang.String)boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method private final switchBillingVersionWithObservation(com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=3
    instance-of v0, v14, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;
    invoke-direct v0, v12, v14, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->label I
    const/4 v3, 1
    if-eqz v2, +01ah
    if-ne v2, v3, +010h
    iget-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->J$0 J
    iget-object v13, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +24h
    move-exception v14
    move-object v8, v13
    goto/16 +083h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v14, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v14, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v4
    sget-object v14, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi;->Companion Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;
    iput-object v13, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->L$0 Ljava/lang/Object;
    iput-wide v4, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->J$0 J
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$switchBillingVersionWithObservation$1;->label I
    invoke-virtual v14, v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;->switchCnBillingVersionRawCall(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    move-wide v1, v4
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v4, 0
    if-eqz v0, +011h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-eqz v0, +004h
    move v0, v3
    goto +2h
    move v0, v4
    if-eqz v0, +005h
    const/4 v14, 0
    move-object v11, v14
    goto +27h
    instance-of v5, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v5, +011h
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v14
    goto -14h
    instance-of v5, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v5, +00dh
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v14
    invoke-static v14, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v14
    goto -23h
    const-string/jumbo v14, unknown
    goto -27h
    sget-object v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    if-eqz v0, +004h
    move v7, v3
    goto +2h
    move v7, v4
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v3
    sub-long v9, v3, v1
    move-object v8, v13
    invoke-virtual/range v6 ... v11, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->trackBillingSwitchResult(Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; J Ljava/lang/String;)V
    if-eqz v0, +007h
    sget-object v14, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;
    check-cast v14, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;
    goto +5h
    sget-object v14, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;
    check-cast v14, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;
    return-object v14
    move-exception v14
    move-object v8, v13
    move-wide v1, v4
    sget-object v6, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    const/4 v7, 0
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v3
    sub-long v9, v3, v1
    const-string v11, "exception"
    invoke-virtual/range v6 ... v11, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->trackBillingSwitchResult(Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; J Ljava/lang/String;)V
    throw v14
    move-exception v13
    throw v13
    :try_start_0x2c
    :try_start_0x43
    :try_start_0x53
.end method

.method public final clear()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCNPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    return-void 
.end method

.method public final currentUsageQuota()com.bytedance.trae.home.solo.setting.UsageQuotaData
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 0
    return-object v0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v0
.end method

.method public final fetchAndCache(kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;
    invoke-direct v0, v6, v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +025h
    if-eq v2, v4, +018h
    if-ne v2, v3, +00eh
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5eh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ch
    move-exception v7
    goto/16 +08ch
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v7
    if-eqz v7, +009h
    sput-object v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    sput-object v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCNPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    sput-object v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v5
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v7
    if-eqz v7, +019h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi$Companion;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->label I
    invoke-virtual v7, v0, Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi$Companion;->fetchPayStatus(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v0, v6
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    sput-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    goto/16 +084h
    invoke-direct v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +003h
    return-object v5
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->L$0 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCache$1;->label I
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;->fetchPayStatusRawCall(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v7
    move-object v7, v0
    move-object v0, v6
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return-object v5
    instance-of v2, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +02ah
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-eqz v2, +01dh
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    if-eqz v7, +00ah
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    invoke-direct v2, v1, v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;)V
    sput-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCNPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    goto +36h
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentCNPayStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v7
    goto +31h
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentCNPayStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v7
    goto +2ch
    move-exception v7
    move-object v0, v6
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "fetchAndCache failed: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v2, "UserPayIdentityCache"
    invoke-virtual v1, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v7
    if-eqz v7, +005h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    goto +5h
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentCNPayStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v7
    return-object v7
    :try_start_0x32
    :try_start_0x42
    :try_start_0x5b
    :try_start_0x71
    :try_start_0x7a
    :try_start_0x93
.end method

.method public final fetchAndCacheCreditsBalance(kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;
    invoke-direct v0, v6, v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +01bh
    if-ne v2, v3, +011h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    move-exception v7
    goto/16 +099h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +008h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    sput-object v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    return-object v4
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->L$0 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalance$1;->label I
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->fetchEntUsageRawCall(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v7
    move-object v7, v0
    move-object v0, v6
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return-object v4
    instance-of v2, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +044h
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-eqz v2, +037h
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    if-eqz v7, +012h
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCacheKt;->toCreditsBalance(Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;)Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v7
    if-eqz v7, +00ch
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    invoke-direct v2, v1, v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/CreditsBalance;)V
    sput-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    move-object v4, v7
    goto/16 +073h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    if-eqz v7, +06fh
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getUserId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v7, v4
    if-eqz v7, +061h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getBalance()Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v4
    goto +5bh
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    if-eqz v7, +058h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getUserId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v7, v4
    if-eqz v7, +04ah
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getBalance()Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v4
    goto +44h
    move-exception v0
    move-object v1, v7
    move-object v7, v0
    move-object v0, v6
    instance-of v2, v7, Ljava/util/concurrent/CancellationException;
    if-nez v2, +03eh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "fetchAndCacheCreditsBalance failed: "
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v3, "UserPayIdentityCache"
    invoke-virtual v2, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +003h
    return-object v4
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    if-eqz v7, +014h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getUserId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v7, v4
    if-eqz v7, +006h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getBalance()Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v4
    return-object v4
    throw v7
    :try_start_0x2f
    :try_start_0x4d
    :try_start_0x5f
.end method

.method public final fetchAndCacheCreditsBalanceSnapshot(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +18h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;->label I
    invoke-virtual v4, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCacheCreditsBalance(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    move-object v0, v4
    check-cast v5, Lcom/bytedance/trae/conversation/CreditsBalance;
    if-nez v5, +004h
    const/4 v5, 0
    return-object v5
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->getCreditsBalanceSnapshot()Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;
    move-result-object v5
    return-object v5
.end method

.method public final fetchAndCacheUserEntStatus(kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ch
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v6
    if-eqz v6, +005h
    sput-object v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v4
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v6
    if-nez v6, +040h
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchAndCacheUserEntStatus$1;->label I
    invoke-virtual v6, v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->fetchEntUsageRawCall(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +02ah
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-nez v0, +003h
    goto +1bh
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    if-nez v6, +005h
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v6
    invoke-static v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCacheKt;->toFastRequestUsageQuota(Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;)Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    move-result-object v6
    sput-object v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v6
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v6
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v6
    move-exception v6
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "fetchAndCache failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v1, "UserPayIdentityCache"
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedUsageQuota Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    return-object v4
    :try_start_0x2b
    :try_start_0x45
.end method

.method public final fetchBillingUpgradePreparation(com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    instance-of v0, v10, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;
    if-eqz v0, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v10, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;->label I
    sub-int/2addr v10, v2
    iput v10, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;
    invoke-direct v0, v8, v10, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache; Lkotlin/coroutines/Continuation;)V
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +42h
    move-exception v9
    goto +43h
    move-exception v9
    goto +61h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct v8, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;
    return-object v9
    new-instance v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;
    const/4 v5, 0
    invoke-direct v4, v10, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function1;
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;
    invoke-direct v6, v10, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function1;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3;
    invoke-direct v7, v9, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function1;
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$$ExternalSyntheticLambda0;
    invoke-direct v5, v10, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String;)V
    invoke-direct v2, v4, v6, v7, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$1;->label I
    invoke-virtual v2, v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->run(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    goto +20h
    sget-object v10, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "fetchBillingUpgradePreparation failed: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v0, "UserPayIdentityCache"
    invoke-virtual v10, v0, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    return-object v10
    throw v9
    :try_start_0x26
    :try_start_0x62
.end method

.method public final fetchCreditsBalance()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchCreditsBalance$1;
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchCreditsBalance$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final fetchFreshCNPayStatus(kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +01ah
    if-ne v2, v3, +010h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +27h
    move-exception v6
    goto +63h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    return-object v4
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchFreshCNPayStatus$1;->label I
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;->fetchPayStatusRawCall(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v6
    move-object v6, v0
    move-object v0, v5
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return-object v4
    instance-of v2, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +026h
    move-object v2, v6
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-eqz v2, +019h
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    if-eqz v6, +036h
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    invoke-direct v2, v1, v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;)V
    sput-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCNPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    move-object v4, v6
    goto +2ch
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedCNPayStatusForRequest(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v4
    goto +27h
    move-exception v0
    move-object v1, v6
    move-object v6, v0
    move-object v0, v5
    instance-of v2, v6, Ljava/util/concurrent/CancellationException;
    if-nez v2, +021h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "fetchFreshCNPayStatus failed: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v3, "UserPayIdentityCache"
    invoke-virtual v2, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedCNPayStatusForRequest(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v4
    return-object v4
    throw v6
    :try_start_0x2f
    :try_start_0x47
    :try_start_0x59
.end method

.method public final fetchPayStatus()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchPayStatus$1;
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchPayStatus$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final fetchUserEntStatus()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchUserEntStatus$1;
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchUserEntStatus$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getCacheUserPayIdentity()java.lang.Integer
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    if-eqz v0, +008h
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +015h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    if-eqz v0, +025h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->getIdentity()Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    move-result-object v0
    if-eqz v0, +01fh
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->getValue()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    goto +15h
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentCNPayStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v0
    if-eqz v0, +010h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;->getIdentity()Lcom/bytedance/trae/home/solo/setting/CNUserPayIdentity;
    move-result-object v0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CNUserPayIdentity;->getValue()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    return-object v1
.end method

.method public final getCreditsBalanceSnapshot()com.bytedance.trae.home.solo.setting.CreditsBalanceSnapshot
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentTocUserId()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;
    if-nez v2, +003h
    return-object v1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getUserId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-object v1
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getUserId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;->getBalance()Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/CreditsBalance;)V
    return-object v0
.end method

.method public final getKnownCacheUserPayIdentity()java.lang.Integer
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->getUserPayIdentity()Ljava/lang/Integer;
    move-result-object v1
    goto +bh
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentCNPayStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;->getUserPayIdentity()Ljava/lang/Integer;
    move-result-object v1
    return-object v1
.end method

.method public final getUserCNPayStatus()com.bytedance.trae.home.solo.setting.CNUserPayStatusData
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentCNPayStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v0
    return-object v0
.end method

.method public final getUserPayStatus()com.bytedance.trae.home.solo.setting.UserPayStatusData
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    return-object v0
.end method

.method public final isPaidUser()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    goto +22h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const/4 v2, 1
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->cachedPayStatus Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    if-eqz v0, +016h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->isPaidUser()Z
    move-result v0
    if-ne v0, v2, +010h
    goto +dh
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentCNPayStatus()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;->isPaidUser()Z
    move-result v0
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method
