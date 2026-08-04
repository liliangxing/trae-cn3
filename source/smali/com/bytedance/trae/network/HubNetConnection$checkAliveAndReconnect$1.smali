# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method constructor <init>(com.bytedance.trae.network.HubNetConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;
    iget-object v0, v1, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    const-string v0, "checkAlive: mode="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->label I
    const-wide/16 v3, 5000
    const-string v5, "checkAlive_reconnect"
    const/4 v6, 3
    const/4 v7, 2
    const-string v8, "HubNetConnection"
    const/4 v9, 0
    const/4 v10, 1
    if-eqz v2, +01fh
    if-eq v2, v10, +018h
    if-eq v2, v7, +011h
    if-ne v2, v6, +007h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +10dh
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0e9h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0b0h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getModeLock$p(Lcom/bytedance/trae/network/HubNetConnection;)Ljava/util/concurrent/locks/ReentrantLock;
    move-result-object v14
    check-cast v14, Ljava/util/concurrent/locks/Lock;
    iget-object v2, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->lock()V
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    if-eq v11, v12, +140h
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/network/TransportMode;->IDLE Lcom/bytedance/trae/network/TransportMode;
    if-ne v11, v12, +004h
    goto/16 +136h
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v0
    sget-object v11, Lcom/bytedance/trae/network/TransportMode;->CONNECTING Lcom/bytedance/trae/network/TransportMode;
    if-ne v0, v11, +00fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "checkAlive: initial connection guarded by timeout job, skip"
    invoke-virtual v0, v8, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-object v0
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v0
    sget-object v11, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    if-ne v0, v11, +00fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "checkAlive: already HTTP_FALLBACK, skip"
    invoke-virtual v0, v8, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-object v0
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$isToB$p(Lcom/bytedance/trae/network/HubNetConnection;)Z
    move-result v0
    if-eqz v0, +00fh
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$getSseConnection$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/SseConnection;
    move-result-object v0
    if-eqz v0, +017h
    invoke-virtual v0, Lcom/bytedance/trae/network/SseConnection;->isReallyAlive()Z
    move-result v0
    if-ne v0, v10, +011h
    goto +dh
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$getFrontier$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/FrontierConnection;
    move-result-object v0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/network/FrontierConnection;->isReallyAlive()Z
    move-result v0
    if-ne v0, v10, +004h
    move v0, v10
    goto +2h
    move v0, v9
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->unlock()V
    if-eqz v0, +00ch
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "checkAlive: transport alive, skip"
    invoke-virtual v14, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "checkAlive: transport NOT alive, attempting reconnect"
    invoke-virtual v14, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$isToB$p(Lcom/bytedance/trae/network/HubNetConnection;)Z
    move-result v14
    if-eqz v14, +03fh
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getSseConnection$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/SseConnection;
    move-result-object v14
    if-eqz v14, +005h
    invoke-virtual v14, Lcom/bytedance/trae/network/SseConnection;->disconnect()V
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getSseConnection$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/SseConnection;
    move-result-object v14
    if-eqz v14, +005h
    invoke-virtual v14, Lcom/bytedance/trae/network/SseConnection;->connect()V
    move-object v14, v13
    check-cast v14, Lkotlin/coroutines/Continuation;
    iput v10, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->label I
    invoke-static v3, v4, v14, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getSseConnection$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/SseConnection;
    move-result-object v14
    if-eqz v14, +009h
    invoke-virtual v14, Lcom/bytedance/trae/network/SseConnection;->isReallyAlive()Z
    move-result v14
    if-ne v14, v10, +003h
    move v9, v10
    if-eqz v9, +057h
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "checkAlive: SSE reconnected successfully"
    invoke-virtual v14, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getFrontier$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/FrontierConnection;
    move-result-object v14
    if-eqz v14, +005h
    invoke-virtual v14, v5, Lcom/bytedance/trae/network/FrontierConnection;->disconnect(Ljava/lang/String;)V
    move-object v14, v13
    check-cast v14, Lkotlin/coroutines/Continuation;
    iput v7, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->label I
    const-wide/16 v11, 1000
    invoke-static v11, v12, v14, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getFrontier$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/FrontierConnection;
    move-result-object v14
    if-eqz v14, +005h
    invoke-virtual v14, v5, Lcom/bytedance/trae/network/FrontierConnection;->connect(Ljava/lang/String;)V
    move-object v14, v13
    check-cast v14, Lkotlin/coroutines/Continuation;
    iput v6, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->label I
    invoke-static v3, v4, v14, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getFrontier$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/FrontierConnection;
    move-result-object v14
    if-eqz v14, +009h
    invoke-virtual v14, Lcom/bytedance/trae/network/FrontierConnection;->isReallyAlive()Z
    move-result v14
    if-ne v14, v10, +003h
    move v9, v10
    if-eqz v9, +00ch
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "checkAlive: Frontier reconnected successfully"
    invoke-virtual v14, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "checkAlive: reconnect failed, falling back to HTTP poll"
    invoke-virtual v14, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lcom/bytedance/trae/network/HubNetConnection;->access$getModeLock$p(Lcom/bytedance/trae/network/HubNetConnection;)Ljava/util/concurrent/locks/ReentrantLock;
    move-result-object v14
    check-cast v14, Ljava/util/concurrent/locks/Lock;
    iget-object v0, v13, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->lock()V
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    if-eq v1, v2, +01bh
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    if-eq v1, v2, +013h
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->access$setTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/TransportMode;)V
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->access$startHttpFallback(Lcom/bytedance/trae/network/HubNetConnection;)V
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->access$isToB$p(Lcom/bytedance/trae/network/HubNetConnection;)Z
    move-result v1
    if-eqz v1, +005h
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->access$startSseBackgroundRetry(Lcom/bytedance/trae/network/HubNetConnection;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->unlock()V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    move-exception v0
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v2, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", skip"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-object v0
    move-exception v0
    invoke-interface v14, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    :try_start_0x41
    :try_start_0x68
    :try_start_0x7d
    :try_start_0x159
    :try_start_0x187
.end method
