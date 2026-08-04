# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SpringNetwokStrategyManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $strategy:Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
.field final synthetic $timeoutDelay:J
.field  label:I


.method constructor <init>(long  com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-wide v1, v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->$timeoutDelay J
    iput-object v3, v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->$strategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;
    iget-wide v0, v3, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->$timeoutDelay J
    iget-object v2, v3, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->$strategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;-><init>(J Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->label I
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +016h
    if-eq v1, v4, +010h
    if-ne v1, v3, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +37h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-wide v5, v7, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->$timeoutDelay J
    move-object v8, v7
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v4, v7, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->label I
    invoke-static v5, v6, v8, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v8
    check-cast v8, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v4, v7
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v7, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->label I
    invoke-static v8, v1, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->INSTANCE Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;
    iget-object v0, v7, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;->$strategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    monitor-enter v8
    invoke-static Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->access$getCurrentStrategy$p()Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    move-result-object v1
    if-ne v1, v0, +007h
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->INSTANCE Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;
    invoke-static v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->access$setCurrentStrategy$p(Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v8
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    move-exception v0
    monitor-exit v8
    throw v0
    :try_start_0x4e
.end method
