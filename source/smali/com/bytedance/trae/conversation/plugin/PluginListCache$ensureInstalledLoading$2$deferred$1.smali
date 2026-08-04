# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PluginListCache.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliId:Ljava/lang/String;
.field final synthetic $isLocal:Z
.field final synthetic $key:Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
.field final synthetic $workspaceFolder:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  label:I


.method constructor <init>(boolean  java.lang.String  java.lang.String  com.bytedance.trae.conversation.plugin.PluginListCache$InstalledCacheKey  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$isLocal Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$cliId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$workspaceFolder Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$key Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;
    iget-boolean v1, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$isLocal Z
    iget-object v2, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$cliId Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$workspaceFolder Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$key Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;-><init>(Z Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->label I
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +022h
    if-eq v1, v4, +01ch
    if-ne v1, v3, +012h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->L$2 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/sync/Mutex;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->L$0 Ljava/lang/Object;
    check-cast v3, Ljava/util/List;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +40h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +18h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    iget-boolean v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$isLocal Z
    iget-object v5, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$cliId Ljava/lang/String;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$workspaceFolder Ljava/lang/String;
    move-object v7, v8
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v4, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->label I
    invoke-static v9, v1, v5, v6, v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$fetchAllInstalledPages(Lcom/bytedance/trae/conversation/plugin/PluginListCache; Z Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    check-cast v9, Ljava/util/List;
    invoke-static Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$getMutex$p()Lkotlinx/coroutines/sync/Mutex;
    move-result-object v1
    iget-object v4, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->$key Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    move-object v5, v8
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v9, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->L$0 Ljava/lang/Object;
    iput-object v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->L$1 Ljava/lang/Object;
    iput-object v4, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->L$2 Ljava/lang/Object;
    iput v3, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;->label I
    invoke-interface v1, v2, v5, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v0, +003h
    return-object v0
    move-object v3, v9
    move-object v0, v4
    invoke-static Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$getInstalledCache$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v9
    check-cast v9, Ljava/util/Map;
    new-instance v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    invoke-direct v4, v3, v5, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;-><init>(Ljava/util/List; J)V
    invoke-interface v9, v0, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/trae/conversation/plugin/PluginListCache;->access$getInstalledPromises$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v9
    invoke-virtual v9, v0, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lkotlinx/coroutines/Deferred;
    invoke-interface v1, v2, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v3
    move-exception v9
    invoke-interface v1, v2, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v9
    :try_start_0x5e
.end method
