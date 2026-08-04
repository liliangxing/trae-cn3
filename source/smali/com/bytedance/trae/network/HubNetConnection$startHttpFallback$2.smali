# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;
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
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;
    iget-object v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->label I
    const-wide/16 v3, 1
    const/4 v5, 0
    const/4 v6, 3
    const/4 v7, 2
    const/4 v8, 1
    if-eqz v2, +035h
    if-eq v2, v8, +027h
    if-eq v2, v7, +017h
    if-ne v2, v6, +00dh
    iget v2, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->I$0 I
    iget-object v9, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v10, v2
    goto +2ch
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget v2, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->I$0 I
    iget-object v9, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v11, v18
    move-object v10, v9
    move-object v9, v0
    goto +56h
    iget v2, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->I$0 I
    iget-object v9, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v10, v2
    move-object v2, v0
    goto +2dh
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    move-object v9, v2
    move v10, v5
    move-object v2, v0
    invoke-static v9, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v11
    if-eqz v11, +0a9h
    iget-object v11, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v11, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    if-ne v11, v12, +09fh
    move-object v11, v2
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput-object v9, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    iput v10, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->I$0 I
    iput v8, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->label I
    const-wide/16 v12, 3000
    invoke-static v12, v13, v11, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    iget-object v11, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v11, Lcom/bytedance/trae/network/HubNetConnection;->access$getNextExpectedDownSeq$p(Lcom/bytedance/trae/network/HubNetConnection;)J
    move-result-wide v12
    sub-long/2addr v12, v3
    move-object v14, v2
    check-cast v14, Lkotlin/coroutines/Continuation;
    iput-object v9, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    iput v10, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->I$0 I
    iput v7, v2, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->label I
    invoke-static v11, v12, v13, v14, Lcom/bytedance/trae/network/HubNetConnection;->access$pollViaHttp(Lcom/bytedance/trae/network/HubNetConnection; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object/from16 v16, v9
    move-object v9, v2
    move v2, v10
    move-object/from16 v10, v16
    check-cast v11, Ljava/util/List;
    if-eqz v11, +015h
    move-object v2, v11
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v2, v8
    if-eqz v2, +007h
    iget-object v2, v9, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v2, v11, v8, Lcom/bytedance/trae/network/HubNetConnection;->access$dispatch(Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List; Z)V
    move-object v2, v9
    move-object v9, v10
    move v10, v5
    goto -55h
    add-int/2addr v2, v8
    add-int/lit8 v11, v2, -1
    const/16 v12, 30
    invoke-static v11, v12, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v11
    shl-long v11, v3, v11
    const-wide/16 v13, 3
    mul-long/2addr v11, v13
    const-wide/16 v13, 180
    invoke-static v11, v12, v13, v14, Lkotlin/ranges/RangesKt;->coerceAtMost(J J)J
    move-result-wide v11
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v15, "HTTP poll backoff: "
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v11, v12, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string/jumbo v15, s after 
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, " consecutive failures"
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    const-string v15, "HubNetConnection"
    invoke-virtual v13, v15, v14, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/16 v13, 1000
    int-to-long v13, v13
    mul-long/2addr v11, v13
    move-object v13, v9
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v10, v9, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->L$0 Ljava/lang/Object;
    iput v2, v9, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->I$0 I
    iput v6, v9, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;->label I
    invoke-static v11, v12, v13, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object/from16 v16, v10
    move v10, v2
    move-object v2, v9
    move-object/from16 v9, v16
    goto/16 -0abh
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
