# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method constructor <init>(com.bytedance.trae.network.HubNetConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;
    iget-object v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->label I
    const-string v2, "HubNetConnection"
    const-wide/32 v3, 60000
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v1, +01fh
    if-eq v1, v6, +015h
    if-ne v1, v5, +00bh
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    goto +61h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->L$0 Ljava/lang/Object;
    move-object v1, v9
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    move-object v9, v8
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->L$0 Ljava/lang/Object;
    iput v6, v8, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->label I
    invoke-static v3, v4, v9, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    move-object v9, v8
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v6
    if-eqz v6, +047h
    iget-object v6, v9, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v6, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    if-ne v6, v7, +03dh
    iget-object v6, v9, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v6, Lcom/bytedance/trae/network/HubNetConnection;->access$isToB$p(Lcom/bytedance/trae/network/HubNetConnection;)Z
    move-result v6
    if-eqz v6, +035h
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v7, sseBackgroundRetry: attempting SSE reconnect
    invoke-virtual v6, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v9, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v6, Lcom/bytedance/trae/network/HubNetConnection;->access$getSseConnection$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/SseConnection;
    move-result-object v6
    if-eqz v6, +005h
    invoke-virtual v6, Lcom/bytedance/trae/network/SseConnection;->connect()V
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v1, v9, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->L$0 Ljava/lang/Object;
    iput v5, v9, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->label I
    invoke-static v3, v4, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    iget-object v6, v9, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v6, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    if-ne v6, v7, -041h
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, sseBackgroundRetry: SSE restored, stopping
    invoke-virtual v9, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
