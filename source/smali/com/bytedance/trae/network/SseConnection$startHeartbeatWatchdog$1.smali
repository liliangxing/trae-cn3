# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SseConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/SseConnection;


.method constructor <init>(com.bytedance.trae.network.SseConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->this$0 Lcom/bytedance/trae/network/SseConnection;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;
    iget-object v1, v2, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->this$0 Lcom/bytedance/trae/network/SseConnection;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;-><init>(Lcom/bytedance/trae/network/SseConnection; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->label I
    const/4 v2, 1
    if-eqz v1, +015h
    if-ne v1, v2, +00bh
    iget-object v1, v7, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v7
    goto +28h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/CoroutineScope;
    move-object v1, v8
    move-object v8, v7
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v3
    if-eqz v3, +04ch
    move-object v3, v8
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v1, v8, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->L$0 Ljava/lang/Object;
    iput v2, v8, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->label I
    const-wide/16 v4, 5000
    invoke-static v4, v5, v3, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v0, +003h
    return-object v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    iget-object v5, v8, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->this$0 Lcom/bytedance/trae/network/SseConnection;
    invoke-static v5, Lcom/bytedance/trae/network/SseConnection;->access$getLastDataReceivedTime$p(Lcom/bytedance/trae/network/SseConnection;)J
    move-result-wide v5
    sub-long/2addr v3, v5
    iget-object v5, v8, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->this$0 Lcom/bytedance/trae/network/SseConnection;
    invoke-static v5, Lcom/bytedance/trae/network/SseConnection;->access$getConfig$p(Lcom/bytedance/trae/network/SseConnection;)Lcom/bytedance/trae/network/SseConfig;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/SseConfig;->getHeartbeatTimeoutMs()J
    move-result-wide v5
    cmp-long v5, v3, v5
    if-ltz v5, -02dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "heartbeat timeout: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "ms, cancelling call"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "SseConnection"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v8, v8, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;->this$0 Lcom/bytedance/trae/network/SseConnection;
    invoke-static v8, Lcom/bytedance/trae/network/SseConnection;->access$cancelActiveCall(Lcom/bytedance/trae/network/SseConnection;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
