# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2;
.super Ljava/lang/Object;
.source "InitAccountTask.kt"

.implements Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public fetchBillingUpgradePreparation(com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchBillingUpgradePreparation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public fetchCreditsBalanceData(kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=2
    instance-of v0, v12, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;
    if-eqz v0, +012h
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;
    iget v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v12, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;->label I
    sub-int/2addr v12, v2
    iput v12, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;
    invoke-direct v0, v11, v12, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;-><init>(Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2; Lkotlin/coroutines/Continuation;)V
    iget-object v12, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v12, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    iput v3, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchCreditsBalanceData$1;->label I
    invoke-virtual v12, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCacheCreditsBalanceSnapshot(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v1, +003h
    return-object v1
    check-cast v12, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;
    if-nez v12, +004h
    const/4 v12, 0
    return-object v12
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;->getBalance()Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v0
    new-instance v10, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;->getUserId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CreditsBalance;->getTotal()J
    move-result-wide v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CreditsBalance;->getUsed()J
    move-result-wide v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CreditsBalance;->getRemaining()J
    move-result-wide v7
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CreditsBalance;->getInfinite()Z
    move-result v9
    move-object v1, v10
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;-><init>(Ljava/lang/String; J J J Z)V
    return-object v10
.end method

.method public fetchKnownUserPayIdentity(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;
    iget v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;-><init>(Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    iput v3, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;->label I
    invoke-virtual v5, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->getKnownCacheUserPayIdentity()Ljava/lang/Integer;
    move-result-object v5
    return-object v5
.end method

.method public fetchUserPayIdentity(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;
    iget v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;-><init>(Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    iput v3, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserPayIdentity$1;->label I
    invoke-virtual v5, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->getCacheUserPayIdentity()Ljava/lang/Integer;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v5
    goto +2h
    const/4 v5, 0
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v5
    return-object v5
.end method

.method public fetchUserUsageQuotaData(kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=2
    instance-of v0, v14, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;
    iget v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;
    invoke-direct v0, v13, v14, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;-><init>(Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v14, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    iput v3, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1;->label I
    invoke-virtual v14, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCacheUserEntStatus(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    check-cast v14, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    if-eqz v14, +015h
    new-instance v6, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getRemaining()J
    move-result-wide v1
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getTotal()J
    move-result-wide v3
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getInfinite()Z
    move-result v5
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;-><init>(J J Z)V
    return-object v6
    new-instance v14, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    const-wide/16 v8, 0
    const-wide/16 v10, 0
    const/4 v12, 0
    move-object v7, v14
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;-><init>(J J Z)V
    return-object v14
.end method

.method public getCreditsBalanceData()com.bytedance.trae.conversation.chat.UserPayIdentityService$CreditsBalanceData
    .registers 13
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->getCreditsBalanceSnapshot()Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;
    move-result-object v0
    if-nez v0, +004h
    const/4 v0, 0
    return-object v0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;->getBalance()Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;->getUserId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CreditsBalance;->getTotal()J
    move-result-wide v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CreditsBalance;->getUsed()J
    move-result-wide v6
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CreditsBalance;->getRemaining()J
    move-result-wide v8
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CreditsBalance;->getInfinite()Z
    move-result v10
    move-object v2, v11
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;-><init>(Ljava/lang/String; J J J Z)V
    return-object v11
.end method

.method public getKnownUserPayIdentity()java.lang.Integer
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->getKnownCacheUserPayIdentity()Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method public getUserPayIdentity()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->getCacheUserPayIdentity()Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public getUserUsageQuotaData()com.bytedance.trae.conversation.chat.UserPayIdentityService$UsageQuotaData
    .registers 15
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->currentUsageQuota()Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    move-result-object v0
    if-eqz v0, +015h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getRemaining()J
    move-result-wide v2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getTotal()J
    move-result-wide v4
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->getInfinite()Z
    move-result v6
    move-object v1, v7
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;-><init>(J J Z)V
    return-object v7
    new-instance v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    move-object v8, v0
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;-><init>(J J Z)V
    return-object v0
.end method
