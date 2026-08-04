# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  I$0:I
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method constructor <init>(com.bytedance.trae.network.HubNetConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;
    iget-object v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->label I
    const/4 v2, 0
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v1, +033h
    if-eq v1, v5, +026h
    if-eq v1, v4, +016h
    if-ne v1, v3, +00ch
    iget v1, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->I$0 I
    iget-object v6, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2bh
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    iget v1, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->I$0 I
    iget-object v6, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    move v6, v1
    move-object v1, v0
    move-object v0, v13
    goto +50h
    iget v1, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->I$0 I
    iget-object v6, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v14, v13
    goto +2dh
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    check-cast v14, Lkotlinx/coroutines/CoroutineScope;
    move-object v6, v14
    move v1, v2
    move-object v14, v13
    invoke-static v6, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v7
    if-eqz v7, +09bh
    iget-object v7, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v7, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v7
    sget-object v8, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    if-ne v7, v8, +091h
    move-object v7, v14
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput-object v6, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    iput v1, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->I$0 I
    iput v5, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->label I
    const-wide/16 v8, 1000
    invoke-static v8, v9, v7, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    iget-object v7, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    move-object v8, v14
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v6, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    iput v1, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->I$0 I
    iput v4, v14, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->label I
    invoke-static v7, v8, Lcom/bytedance/trae/network/HubNetConnection;->access$flushPendingViaHttp(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    move-object v12, v0
    move-object v0, v14
    move-object v14, v7
    move-object v7, v6
    move v6, v1
    move-object v1, v12
    check-cast v14, Ljava/lang/Boolean;
    invoke-virtual v14, Ljava/lang/Boolean;->booleanValue()Z
    move-result v14
    if-eqz v14, +007h
    move-object v14, v0
    move-object v0, v1
    move v1, v2
    move-object v6, v7
    goto -46h
    add-int/lit8 v14, v6, 1
    add-int/lit8 v6, v14, -1
    const/16 v8, 30
    invoke-static v6, v8, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v6
    const-wide/16 v8, 1
    shl-long/2addr v8, v6
    const-wide/16 v10, 3
    mul-long/2addr v8, v10
    const-wide/16 v10, 180
    invoke-static v8, v9, v10, v11, Lkotlin/ranges/RangesKt;->coerceAtMost(J J)J
    move-result-wide v8
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "HTTP flush backoff: "
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string/jumbo v11, s after 
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, " consecutive failures"
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v11, "HubNetConnection"
    invoke-virtual v6, v11, v10, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/16 v6, 1000
    int-to-long v10, v6
    mul-long/2addr v8, v10
    move-object v6, v0
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v7, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->L$0 Ljava/lang/Object;
    iput v14, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->I$0 I
    iput v3, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;->label I
    invoke-static v8, v9, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    move-object v6, v7
    move-object v12, v1
    move v1, v14
    move-object v14, v0
    move-object v0, v12
    goto/16 -09dh
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
