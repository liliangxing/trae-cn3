# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserPayIdentityCache.kt"

.implements Lkotlin/jvm/functions/Function1;

.field final synthetic $requestUserId:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->$requestUserId Ljava/lang/String;
    const/4 v1, 1
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->$requestUserId Ljava/lang/String;
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->invoke(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->create(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi;->Companion Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;
    move-object v1, v3
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->label I
    invoke-virtual v4, v1, Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;->fetchPayStatusRawCall(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +047h
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-nez v0, +003h
    goto +39h
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    if-nez v4, +007h
    sget-object v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;
    check-cast v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;
    goto +2ch
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->access$currentTocUserId(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->$requestUserId Ljava/lang/String;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00eh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1;->$requestUserId Ljava/lang/String;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;)V
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->access$setOwnedCNPayStatus$p(Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;)V
    new-instance v0, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;->isCreditsBilling()Z
    move-result v4
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;-><init>(Z)V
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;
    goto +5h
    sget-object v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;
    check-cast v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;
    return-object v4
.end method
