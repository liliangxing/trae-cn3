# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method constructor <init>(com.bytedance.trae.network.HubNetConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;
    iget-object v0, v1, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5bh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->label I
    const-wide/16 v4, 1000
    invoke-static v4, v5, v7, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    iget-object v7, v6, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v7, Lcom/bytedance/trae/network/HubNetConnection;->access$getModeLock$p(Lcom/bytedance/trae/network/HubNetConnection;)Ljava/util/concurrent/locks/ReentrantLock;
    move-result-object v7
    check-cast v7, Ljava/util/concurrent/locks/Lock;
    iget-object v1, v6, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->lock()V
    const/4 v4, 0
    invoke-static v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->access$setPendingQueuePumpJob$p(Lcom/bytedance/trae/network/HubNetConnection; Lkotlinx/coroutines/Job;)V
    invoke-static v1, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v4
    aget v4, v5, v4
    const/4 v5, 0
    packed-switch v4, +000002bh
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    goto +1dh
    move v3, v5
    goto +5h
    invoke-static v1, Lcom/bytedance/trae/network/HubNetConnection;->access$drainPendingQueueViaFrontier(Lcom/bytedance/trae/network/HubNetConnection;)V
    goto -5h
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    if-eqz v3, +010h
    iget-object v7, v6, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;->label I
    invoke-static v7, v1, Lcom/bytedance/trae/network/HubNetConnection;->access$flushPendingViaHttp(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    packed-switch-payload 1 2 3 4 5 6
    :try_start_0x3d
    :try_start_0x6f
.end method
