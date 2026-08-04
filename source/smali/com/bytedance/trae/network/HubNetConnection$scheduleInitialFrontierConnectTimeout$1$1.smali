# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method constructor <init>(com.bytedance.trae.network.HubNetConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;
    iget-object v0, v1, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v5, v4
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->label I
    const-wide/16 v1, 15000
    invoke-static v1, v2, v5, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    iget-object v5, v4, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v5, Lcom/bytedance/trae/network/HubNetConnection;->access$getModeLock$p(Lcom/bytedance/trae/network/HubNetConnection;)Ljava/util/concurrent/locks/ReentrantLock;
    move-result-object v5
    check-cast v5, Ljava/util/concurrent/locks/Lock;
    iget-object v0, v4, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-interface v5, Ljava/util/concurrent/locks/Lock;->lock()V
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->CONNECTING Lcom/bytedance/trae/network/TransportMode;
    if-ne v1, v2, +013h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "HubNetConnection"
    const-string v3, "Frontier initial connect timed out, switching to HTTP_FALLBACK"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->access$setTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/TransportMode;)V
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->access$startHttpFallback(Lcom/bytedance/trae/network/HubNetConnection;)V
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->access$setFrontierConnectTimeoutJob$p(Lcom/bytedance/trae/network/HubNetConnection; Lkotlinx/coroutines/Job;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v5, Ljava/util/concurrent/locks/Lock;->unlock()V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    move-exception v0
    invoke-interface v5, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    :try_start_0x35
.end method
