# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserPayIdentityCache.kt"

.implements Lkotlin/jvm/functions/Function1;

.field final synthetic $requestUserId:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->$requestUserId Ljava/lang/String;
    const/4 v1, 1
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->$requestUserId Ljava/lang/String;
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->invoke(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->create(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
    move-object v1, v5
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->label I
    invoke-virtual v6, v1, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->fetchEntUsageRawCall(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +04eh
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-nez v0, +003h
    goto +40h
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    if-nez v6, +007h
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;
    goto +33h
    invoke-static v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCacheKt;->toFastRequestUsageQuota(Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;)Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    move-result-object v6
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->access$currentTocUserId(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2;->$requestUserId Ljava/lang/String;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v6, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->access$setCachedUsageQuota$p(Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;)V
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getInfinite()Z
    move-result v2
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getRemaining()J
    move-result-wide v3
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->classifyUserState(Z J)Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v6
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)V
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;
    goto +5h
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;
    return-object v6
.end method
