# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isConnected:Lkotlinx/coroutines/flow/StateFlow;
.field final synthetic $retryDelayMs:J
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I


.method constructor <init>(long  kotlinx.coroutines.flow.StateFlow  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-wide v1, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->$retryDelayMs J
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->$isConnected Lkotlinx/coroutines/flow/StateFlow;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;
    iget-wide v1, v4, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->$retryDelayMs J
    iget-object v3, v4, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->$isConnected Lkotlinx/coroutines/flow/StateFlow;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;-><init>(J Lkotlinx/coroutines/flow/StateFlow; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->label I
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +01bh
    if-ne v1, v2, +011h
    iget-object v0, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->L$1 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/Deferred;
    iget-object v1, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/Deferred;
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +6bh
    move-exception v12
    goto/16 +07ah
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->L$0 Ljava/lang/Object;
    check-cast v12, Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v1, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$timerDeferred$1;
    iget-wide v7, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->$retryDelayMs J
    invoke-direct v1, v7, v8, v3, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$timerDeferred$1;-><init>(J Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    move-object v4, v12
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v1
    new-instance v4, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$networkDeferred$1;
    iget-object v7, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->$isConnected Lkotlinx/coroutines/flow/StateFlow;
    invoke-direct v4, v7, v3, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$networkDeferred$1;-><init>(Lkotlinx/coroutines/flow/StateFlow; Lkotlin/coroutines/Continuation;)V
    move-object v7, v4
    check-cast v7, Lkotlin/jvm/functions/Function2;
    move-object v4, v12
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v12
    new-instance v4, Lkotlinx/coroutines/selects/SelectImplementation;
    invoke-interface v11, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v5
    invoke-direct v4, v5, Lkotlinx/coroutines/selects/SelectImplementation;-><init>(Lkotlin/coroutines/CoroutineContext;)V
    move-object v5, v4
    check-cast v5, Lkotlinx/coroutines/selects/SelectBuilder;
    invoke-interface v1, Lkotlinx/coroutines/Deferred;->getOnAwait()Lkotlinx/coroutines/selects/SelectClause1;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$1$1;
    invoke-direct v7, v12, v3, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$1$1;-><init>(Lkotlinx/coroutines/Deferred; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-interface v5, v6, v7, Lkotlinx/coroutines/selects/SelectBuilder;->invoke(Lkotlinx/coroutines/selects/SelectClause1; Lkotlin/jvm/functions/Function2;)V
    invoke-interface v12, Lkotlinx/coroutines/Deferred;->getOnAwait()Lkotlinx/coroutines/selects/SelectClause1;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$1$2;
    invoke-direct v7, v1, v3, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$1$2;-><init>(Lkotlinx/coroutines/Deferred; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-interface v5, v6, v7, Lkotlinx/coroutines/selects/SelectBuilder;->invoke(Lkotlinx/coroutines/selects/SelectClause1; Lkotlin/jvm/functions/Function2;)V
    iput-object v1, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->L$0 Ljava/lang/Object;
    iput-object v12, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->L$1 Ljava/lang/Object;
    iput v2, v11, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;->label I
    invoke-virtual v4, v11, Lkotlinx/coroutines/selects/SelectImplementation;->doSelect(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    move-object v0, v12
    check-cast v1, Lkotlinx/coroutines/Job;
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    check-cast v0, Lkotlinx/coroutines/Job;
    invoke-static v0, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    move-exception v0
    move-object v10, v0
    move-object v0, v12
    move-object v12, v10
    check-cast v1, Lkotlinx/coroutines/Job;
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    check-cast v0, Lkotlinx/coroutines/Job;
    invoke-static v0, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    throw v12
    :try_start_0x14
    :try_start_0x4c
.end method
