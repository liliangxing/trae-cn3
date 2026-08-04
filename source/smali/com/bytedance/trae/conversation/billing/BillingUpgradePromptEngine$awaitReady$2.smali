# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BillingUpgradePromptEngine.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;


.method constructor <init>(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->this$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->this$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +011h
    if-ne v1, v3, +007h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v1, v5
    goto +29h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v1, v5
    move v6, v2
    if-nez v6, +04bh
    iget-object v6, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->this$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-static v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->access$startPreparationIfNeeded(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;)Lkotlinx/coroutines/Deferred;
    move-result-object v6
    if-nez v6, +007h
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    return-object v6
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;->label I
    invoke-interface v6, v4, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    sget-object v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, -024h
    sget-object v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto -2eh
    instance-of v4, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;
    if-nez v4, +019h
    sget-object v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +011h
    sget-object v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +7h
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    move v6, v3
    goto -4ah
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    return-object v6
.end method
