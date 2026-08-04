# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PluginListCache.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 3
    # ins_size=3
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/coroutines/Continuation;
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->label I
    const/4 v2, 2
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v1, +01eh
    if-eq v1, v4, +018h
    if-ne v1, v2, +00eh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/util/Map;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +36h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/conversation/network/IMarketplaceApi;->Companion Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v4, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->label I
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;->fetchMarketplacePlugins(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    move-object v1, v7
    check-cast v1, Ljava/util/Map;
    invoke-static Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$getMutex$p()Lkotlinx/coroutines/sync/Mutex;
    move-result-object v7
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->L$0 Ljava/lang/Object;
    iput-object v7, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->L$1 Ljava/lang/Object;
    iput v2, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;->label I
    invoke-interface v7, v3, v5, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    move-object v0, v7
    invoke-interface v1, Ljava/util/Map;->isEmpty()Z
    move-result v7
    xor-int/2addr v7, v4
    if-eqz v7, +010h
    sget-object v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$setMarketplaceByName$p(Ljava/util/Map;)V
    sget-object v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-static v4, v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$setMarketplaceLoadedAt$p(J)V
    sget-object v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$setMarketplacePromise$p(Lkotlinx/coroutines/Deferred;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v1
    move-exception v7
    invoke-interface v0, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v7
    :try_start_0x50
.end method
