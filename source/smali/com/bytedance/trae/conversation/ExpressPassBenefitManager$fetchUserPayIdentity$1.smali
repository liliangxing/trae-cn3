# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ExpressPassBenefitManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 3
    # ins_size=3
    new-instance v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/coroutines/Continuation;
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +012h
    if-ne v1, v3, +008h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1fh
    move-exception v10
    goto +46h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-static v3, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->access$setFetching$p(Z)V
    move-object v10, v9
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v3, v9, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$fetchUserPayIdentity$1;->label I
    invoke-static v10, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->fetchUserUsageQuotaData(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    invoke-static Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->access$getRemainingChangedListeners$p()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;->getTotal()J
    move-result-wide v4
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;->getRemaining()J
    move-result-wide v6
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;->getInfinite()Z
    move-result v8
    invoke-interface/range v3 ... v8, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;->onRemainingChanged(J J Z)V
    goto -1ch
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->access$setFetching$p(Z)V
    throw v10
    sget-object v10, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->access$setFetching$p(Z)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    :try_start_0xc
    :try_start_0x22
.end method
