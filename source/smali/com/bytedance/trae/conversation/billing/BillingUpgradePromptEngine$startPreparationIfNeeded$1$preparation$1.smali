# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BillingUpgradePromptEngine.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $entry:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
.field final synthetic $mode:Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
.field final synthetic $session:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;


.method constructor <init>(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine  com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  com.bytedance.trae.conversation.billing.BillingUpgradePromptSession  com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$Entry  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->this$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$mode Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$session Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$entry Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->this$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$mode Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$session Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$entry Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1fh
    move-exception v4
    goto +2eh
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->this$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-static v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->access$getFetchPreparation$p(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;)Lkotlin/jvm/functions/Function2;
    move-result-object v4
    iget-object v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$mode Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    iput v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->label I
    invoke-interface v4, v1, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    check-cast v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    goto +5h
    sget-object v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    check-cast v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->this$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$session Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;->$entry Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->access$completePreparation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry; Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;)V
    return-object v4
    throw v4
    :try_start_0xb
    :try_start_0x1c
.end method
