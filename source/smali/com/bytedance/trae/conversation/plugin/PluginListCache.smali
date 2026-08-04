# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginListCache;
.super Ljava/lang/Object;
.source "PluginListCache.kt"

.field private static final INSTALLED_TTL_MS:J
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/plugin/PluginListCache;
.field private static final MARKETPLACE_TTL_MS:J
.field private static final PAGE_SIZE:I
.field private static final installedCache:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final installedPromises:Ljava/util/concurrent/ConcurrentHashMap;
.field private static bridge marketplaceByName:Ljava/util/Map;
.field private static bridge marketplaceLoadedAt:J
.field private static marketplacePromise:Lkotlinx/coroutines/Deferred;
.field private static final mutex:Lkotlinx/coroutines/sync/Mutex;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    const/4 v0, 0
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v0, v1, v2, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    invoke-static v2, v1, v2, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->scope Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedCache Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedPromises Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$ensureInstalledLoading(com.bytedance.trae.conversation.plugin.PluginListCache  com.bytedance.trae.conversation.plugin.PluginListCache$InstalledCacheKey  boolean  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->ensureInstalledLoading(Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey; Z Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$ensureMarketplaceLoading(com.bytedance.trae.conversation.plugin.PluginListCache  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->ensureMarketplaceLoading(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchAllInstalledPages(com.bytedance.trae.conversation.plugin.PluginListCache  boolean  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->fetchAllInstalledPages(Z Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getInstalledCache$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedCache Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getInstalledPromises$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedPromises Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getMarketplacePromise$p()kotlinx.coroutines.Deferred
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplacePromise Lkotlinx/coroutines/Deferred;
    return-object v0
.end method

.method public static final synthetic access$getMutex$p()kotlinx.coroutines.sync.Mutex
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    return-object v0
.end method

.method public static final synthetic access$setMarketplaceByName$p(java.util.Map)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    return-void 
.end method

.method public static final synthetic access$setMarketplaceLoadedAt$p(long)void
    .registers 2
    # ins_size=2
    sput-wide v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceLoadedAt J
    return-void 
.end method

.method public static final synthetic access$setMarketplacePromise$p(kotlinx.coroutines.Deferred)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplacePromise Lkotlinx/coroutines/Deferred;
    return-void 
.end method

.method private final ensureInstalledLoading(com.bytedance.trae.conversation.plugin.PluginListCache$InstalledCacheKey  boolean  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=6
    move-object/from16 v0, v22
    instance-of v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->label I
    move-object/from16 v2, v17
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;
    move-object/from16 v2, v17
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginListCache; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->label I
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v4, +025h
    if-ne v4, v6, +01bh
    iget-boolean v3, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->Z$0 Z
    iget-object v4, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$3 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/sync/Mutex;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$2 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v1, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v0, v1
    move-object v10, v7
    move-object v9, v8
    goto +2ch
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    move-object/from16 v0, v18
    iput-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$0 Ljava/lang/Object;
    move-object/from16 v7, v20
    iput-object v7, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$1 Ljava/lang/Object;
    move-object/from16 v8, v21
    iput-object v8, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$2 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->L$3 Ljava/lang/Object;
    move/from16 v9, v19
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->Z$0 Z
    iput v6, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$1;->label I
    invoke-interface v4, v5, v1, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v10, v8
    move v3, v9
    move-object v9, v7
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v0, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    if-eqz v1, +01ch
    sget-object v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->getLoadedAt()J
    move-result-wide v11
    const-wide/16 v13, 30000
    invoke-direct v7, v11, v12, v13, v14, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->isFresh(J J)Z
    move-result v7
    if-eqz v7, +00eh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->getPlugins()Ljava/util/List;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v0
    invoke-interface v4, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedPromises Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v0, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lkotlinx/coroutines/Deferred;
    if-eqz v7, +00ch
    invoke-interface v7, Lkotlinx/coroutines/Deferred;->isActive()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v4, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v7
    sget-object v13, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v14, 0
    const/4 v15, 0
    new-instance v16, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;
    if-eqz v3, +003h
    goto +2h
    const/4 v6, 0
    move v8, v6
    const/4 v12, 0
    move-object/from16 v7, v16
    move-object v11, v0
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureInstalledLoading$2$deferred$1;-><init>(Z Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v3, v16
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/16 v16, 0
    move-object v11, v13
    move-object v12, v14
    move-object v13, v15
    move-object v14, v3
    move v15, v6
    invoke-static/range v11 ... v16, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v3
    check-cast v1, Ljava/util/Map;
    invoke-interface v1, v0, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v4, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v3
    move-exception v0
    invoke-interface v4, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    :try_start_0x71
    :try_start_0x95
    :try_start_0xa9
.end method

.method private final ensureMarketplaceLoading(kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=2
    instance-of v0, v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;
    invoke-direct v0, v10, v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginListCache; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +014h
    if-ne v2, v4, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$1;->label I
    invoke-interface v11, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v11
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    sget-wide v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceLoadedAt J
    const-wide/32 v5, 300000
    invoke-direct v11, v1, v2, v5, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->isFresh(J J)Z
    move-result v11
    if-eqz v11, +015h
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    invoke-interface v11, Ljava/util/Map;->isEmpty()Z
    move-result v11
    xor-int/2addr v11, v4
    if-eqz v11, +00ch
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    invoke-static v11, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v11
    invoke-interface v0, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v11
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplacePromise Lkotlinx/coroutines/Deferred;
    if-eqz v11, +00ch
    invoke-interface v11, Lkotlinx/coroutines/Deferred;->isActive()Z
    move-result v1
    if-eqz v1, +006h
    invoke-interface v0, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v11
    sget-object v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;
    invoke-direct v11, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$ensureMarketplaceLoading$2$deferred$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v7, v11
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v11
    sput-object v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplacePromise Lkotlinx/coroutines/Deferred;
    invoke-interface v0, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v11
    move-exception v11
    invoke-interface v0, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v11
    :try_start_0x48
    :try_start_0x68
    :try_start_0x76
.end method

.method private final fetchAllInstalledPages(boolean  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=5
    instance-of v0, v14, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;
    invoke-direct v0, v10, v14, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginListCache; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +044h
    if-eq v2, v4, +027h
    if-ne v2, v3, +01dh
    iget-boolean v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->Z$0 Z
    iget-object v12, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$4 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$3 Ljava/lang/Object;
    check-cast v13, Ljava/util/Set;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$2 Ljava/lang/Object;
    check-cast v2, Ljava/util/List;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c4h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v12, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v12, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    iget-boolean v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->Z$0 Z
    iget-object v12, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$4 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$3 Ljava/lang/Object;
    check-cast v13, Ljava/util/Set;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$2 Ljava/lang/Object;
    check-cast v2, Ljava/util/List;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07dh
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v14, Ljava/util/ArrayList;
    invoke-direct v14, Ljava/util/ArrayList;-><init>()V
    check-cast v14, Ljava/util/List;
    new-instance v2, Ljava/util/LinkedHashSet;
    invoke-direct v2, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v2, Ljava/util/Set;
    new-instance v5, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v5, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    move-object v9, v13
    move-object v13, v12
    move-object v12, v5
    move-object v5, v14
    move-object v14, v9
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v6
    const-string v7, "page_size"
    const-string v8, "50"
    invoke-interface v6, v7, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v7, sort_by
    const-string v8, "created_at"
    invoke-interface v6, v7, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v7, sort_order
    const-string v8, "desc"
    invoke-interface v6, v7, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v7, v12, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +00ah
    const-string v8, "page_token"
    invoke-interface v6, v8, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    if-eqz v11, +014h
    if-eqz v13, +00ah
    const-string v7, "cli_id"
    invoke-interface v6, v7, v13, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    if-eqz v14, +008h
    const-string/jumbo v7, workspace_folder
    invoke-interface v6, v7, v14, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v6, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v6
    if-eqz v11, +026h
    sget-object v7, Lcom/bytedance/trae/conversation/network/IPluginApi;->Companion Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$0 Ljava/lang/Object;
    iput-object v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$1 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$2 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$3 Ljava/lang/Object;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$4 Ljava/lang/Object;
    iput-boolean v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->Z$0 Z
    iput v4, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->label I
    invoke-virtual v7, v6, v0, Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;->listLocalPlugins(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    move-object v9, v6
    move-object v6, v13
    move-object v13, v2
    move-object v2, v5
    move-object v5, v14
    move-object v14, v9
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    move-object v9, v2
    move-object v2, v13
    move-object v13, v6
    move-object v6, v9
    goto +21h
    sget-object v7, Lcom/bytedance/trae/conversation/network/IPluginApi;->Companion Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$0 Ljava/lang/Object;
    iput-object v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$1 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$2 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$3 Ljava/lang/Object;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->L$4 Ljava/lang/Object;
    iput-boolean v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->Z$0 Z
    iput v3, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$fetchAllInstalledPages$1;->label I
    invoke-virtual v7, v6, v0, Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;->listRemotePlugins(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    move-object v9, v6
    move-object v6, v13
    move-object v13, v2
    move-object v2, v5
    move-object v5, v14
    move-object v14, v9
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto -24h
    instance-of v7, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v7, +04ch
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v7
    if-eqz v7, +04dh
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/conversation/network/ListPluginsData;
    if-nez v14, +003h
    goto +43h
    move-object v7, v6
    check-cast v7, Ljava/util/Collection;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ListPluginsData;->getAllItems()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    invoke-static v7, v8, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ListPluginsData;->getNextPageToken()Ljava/lang/String;
    move-result-object v14
    const/4 v7, 0
    if-eqz v14, +018h
    move-object v8, v14
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v4
    if-eqz v8, +00ah
    invoke-interface v2, v14, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +004h
    move v8, v4
    goto +2h
    const/4 v8, 0
    if-eqz v8, +003h
    goto +2h
    move-object v14, v7
    iput-object v14, v12, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v14, v12, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v14, +003h
    goto +12h
    move-object v14, v5
    move-object v5, v6
    goto/16 -0d3h
    instance-of v11, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v11, +00ch
    sget-object v11, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v12, "plugin_list"
    const-string v13, "fetch_installed_error"
    invoke-virtual v11, v12, v13, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    return-object v6
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
.end method

.method private final findMarketplaceItem(java.util.Map  java.lang.String)com.bytedance.trae.conversation.network.MarketplacePluginItem
    .registers 10
    # ins_size=3
    invoke-interface v8, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    if-eqz v0, +003h
    return-object v0
    move-object v1, v9
    check-cast v1, Ljava/lang/CharSequence;
    const/16 v2, 58
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-lez v0, +016h
    const/4 v1, 0
    invoke-virtual v9, v1, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v0, substring(...)
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v8, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    if-eqz v8, +003h
    return-object v8
    const/4 v8, 0
    return-object v8
.end method

.method private final isFresh(long  long)boolean
    .registers 7
    # ins_size=5
    const-wide/16 v0, 0
    cmp-long v0, v3, v0
    if-lez v0, +00dh
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sub-long/2addr v0, v3
    cmp-long v3, v0, v5
    if-gez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    return v3
.end method

.method private final mergePlugins(java.util.List  java.util.Map)java.util.List
    .registers 25
    # ins_size=3
    move-object/from16 v0, v23
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/network/PluginItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/PluginItem;->getEnabled()Z
    move-result v3
    if-eqz v3, -011h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    invoke-interface/range v24, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v0, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +04bh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/network/PluginItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/PluginItem;->getName()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v5, v24
    invoke-interface v5, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    if-nez v2, +003h
    goto +30h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->getPluginId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->getName()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    const-string v6, ""
    move-object/from16 v21, v6
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 1
    const/4 v9, 0
    invoke-static v2, v9, v8, v9, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->localizedDisplayName$default(Lcom/bytedance/trae/conversation/network/MarketplacePluginItem; Ljava/util/Locale; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->getIconUrl()Ljava/lang/String;
    move-result-object v10
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 32684
    const/16 v20, 0
    move-object/from16 v5, v21
    invoke-static/range v3 ... v20, Lcom/bytedance/trae/conversation/network/PluginItem;->copy$default(Lcom/bytedance/trae/conversation/network/PluginItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List; Ljava/lang/Long; Ljava/lang/Long; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/network/PluginItem;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -4eh
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public final clearAll()void
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$clearAll$1;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$clearAll$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v2, 1
    invoke-static v1, v0, v2, v1, Lkotlinx/coroutines/BuildersKt;->runBlocking$default(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final getCachedLocalizedDisplayName(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "pluginName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->findMarketplaceItem(Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    move-result-object v3
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    const/4 v1, 1
    invoke-static v3, v0, v1, v0, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->localizedDisplayName$default(Lcom/bytedance/trae/conversation/network/MarketplacePluginItem; Ljava/util/Locale; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final getCachedPlugins(java.lang.String  java.lang.String)java.util.List
    .registers 6
    # ins_size=3
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    xor-int/2addr v0, v1
    new-instance v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    invoke-direct v2, v0, v4, v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;-><init>(Z Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v4, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    const/4 v5, 0
    if-nez v4, +003h
    return-object v5
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-object v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->getPlugins()Ljava/util/List;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mergePlugins(Ljava/util/List; Ljava/util/Map;)Ljava/util/List;
    move-result-object v4
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v1
    if-eqz v0, +003h
    move-object v5, v4
    return-object v5
.end method

.method public final getPlugins(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=4
    move-object/from16 v1, v16
    move-object/from16 v0, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v19
    instance-of v4, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;
    if-eqz v4, +012h
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;
    iget v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    sub-int/2addr v3, v6
    iput v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;
    invoke-direct v4, v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginListCache; Lkotlin/coroutines/Continuation;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v11
    iget v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    const/4 v6, 1
    const/4 v7, 0
    packed-switch v5, +00001a1h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    check-cast v0, Ljava/util/Map;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +16eh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/Deferred;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +14eh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/Deferred;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +12eh
    iget v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->I$0 I
    iget-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$2 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v8, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v15, v6
    move-object v6, v2
    move-object v2, v9
    move-object v9, v5
    move-object v5, v3
    move v3, v15
    goto/16 +0f3h
    iget v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->I$0 I
    iget-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$5 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$4 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    iget-object v8, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$3 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    iget-object v9, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$2 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v13, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07eh
    iget v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->I$0 I
    iget-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$4 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$3 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    iget-object v8, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$2 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v3, v0
    move-object v0, v9
    move-object v13, v10
    move-object v15, v8
    move-object v8, v2
    move-object v2, v15
    goto +31h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    move v3, v6
    xor-int/2addr v3, v6
    new-instance v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    invoke-direct v5, v3, v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;-><init>(Z Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    iput-object v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$2 Ljava/lang/Object;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$3 Ljava/lang/Object;
    iput-object v8, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$4 Ljava/lang/Object;
    iput v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->I$0 I
    iput v6, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    invoke-interface v8, v7, v4, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v11, +003h
    return-object v11
    move-object v13, v1
    sget-object v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v9, v5, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    invoke-interface v8, v7, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    iput-object v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$2 Ljava/lang/Object;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$3 Ljava/lang/Object;
    iput-object v9, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$4 Ljava/lang/Object;
    iput-object v8, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$5 Ljava/lang/Object;
    iput v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->I$0 I
    const/4 v10, 2
    iput v10, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    invoke-interface v8, v7, v4, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v11, +003h
    return-object v11
    move-object v10, v0
    move v0, v3
    move-object v15, v9
    move-object v9, v2
    move-object v2, v8
    move-object v8, v5
    move-object v5, v15
    sget-object v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceByName Ljava/util/Map;
    sget-object v14, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    move-object/from16 v17, v13
    sget-wide v12, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->marketplaceLoadedAt J
    const-wide/32 v6, 300000
    invoke-direct v14, v12, v13, v6, v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->isFresh(J J)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    const/4 v3, 0
    const/4 v6, 0
    invoke-interface v2, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    if-eqz v5, +021h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->getLoadedAt()J
    move-result-wide v6
    const-wide/16 v12, 30000
    move-object/from16 v2, v17
    invoke-direct v2, v6, v7, v12, v13, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->isFresh(J J)Z
    move-result v6
    if-eqz v6, +015h
    if-eqz v3, +013h
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->getPlugins()Ljava/util/List;
    move-result-object v4
    invoke-direct v2, v4, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mergePlugins(Ljava/util/List; Ljava/util/Map;)Ljava/util/List;
    move-result-object v2
    const/4 v3, 1
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;-><init>(Ljava/util/List; Z)V
    return-object v0
    move-object/from16 v2, v17
    const/4 v3, 1
    iput-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    iput-object v10, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    iput-object v9, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$2 Ljava/lang/Object;
    iput-object v8, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$3 Ljava/lang/Object;
    const/4 v5, 0
    iput-object v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$4 Ljava/lang/Object;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$5 Ljava/lang/Object;
    iput v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->I$0 I
    const/4 v5, 3
    iput v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->ensureMarketplaceLoading(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v11, +003h
    return-object v11
    move-object v6, v8
    move-object v8, v10
    move-object v12, v5
    check-cast v12, Lkotlinx/coroutines/Deferred;
    if-eqz v0, +004h
    move v7, v3
    goto +2h
    const/4 v7, 0
    iput-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    iput-object v12, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    const/4 v3, 0
    iput-object v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$2 Ljava/lang/Object;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$3 Ljava/lang/Object;
    const/4 v0, 4
    iput v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    move-object v5, v2
    move-object v10, v4
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->ensureInstalledLoading(Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey; Z Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v11, +003h
    return-object v11
    move-object v0, v12
    check-cast v3, Lkotlinx/coroutines/Deferred;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    const/4 v5, 5
    iput v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    invoke-interface v0, v4, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v11, +003h
    return-object v11
    move-object v15, v3
    move-object v3, v0
    move-object v0, v15
    check-cast v3, Ljava/util/Map;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$0 Ljava/lang/Object;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->L$1 Ljava/lang/Object;
    const/4 v5, 6
    iput v5, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$getPlugins$1;->label I
    invoke-interface v0, v4, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v11, +003h
    return-object v11
    move-object v15, v3
    move-object v3, v0
    move-object v0, v15
    check-cast v3, Ljava/util/List;
    new-instance v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->mergePlugins(Ljava/util/List; Ljava/util/Map;)Ljava/util/List;
    move-result-object v0
    const/4 v2, 0
    invoke-direct v4, v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;-><init>(Ljava/util/List; Z)V
    return-object v4
    move-exception v0
    const/4 v3, 0
    goto +3h
    move-exception v0
    move-object v3, v7
    invoke-interface v2, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    move-exception v0
    move-object v3, v7
    invoke-interface v8, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    nop 
    packed-switch-payload 0 1 2 3 4 5 6
    :try_start_0xe9
    :try_start_0x115
    :try_start_0x120
.end method

.method public final invalidateInstalled(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    xor-int/2addr v0, v1
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    invoke-direct v1, v0, v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;-><init>(Z Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->installedCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v1, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final preload(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=4
    instance-of v0, v15, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;
    if-eqz v0, +012h
    move-object v0, v15
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v15, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    sub-int/2addr v15, v2
    iput v15, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;
    invoke-direct v0, v12, v15, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginListCache; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v7
    iget v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    const/4 v2, 0
    const/4 v8, 4
    const/4 v9, 3
    const/4 v3, 2
    const/4 v10, 0
    const/4 v4, 1
    if-eqz v1, +042h
    if-eq v1, v4, +027h
    if-eq v1, v3, +01ch
    if-eq v1, v9, +011h
    if-ne v1, v8, +007h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a0h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v14, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v14, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    iget-object v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lkotlinx/coroutines/Deferred;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +084h
    iget-object v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lkotlinx/coroutines/Deferred;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06ch
    iget v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->I$0 I
    iget-object v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$3 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$2 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v6
    move-object v6, v1
    move-object v1, v11
    goto +33h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v15, v13
    check-cast v15, Ljava/lang/CharSequence;
    if-eqz v15, +00bh
    invoke-interface v15, Ljava/lang/CharSequence;->length()I
    move-result v15
    if-nez v15, +003h
    goto +3h
    move v15, v2
    goto +2h
    move v15, v4
    xor-int/2addr v15, v4
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;
    invoke-direct v1, v15, v13, v14, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey;-><init>(Z Ljava/lang/String; Ljava/lang/String;)V
    iput-object v12, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$0 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$1 Ljava/lang/Object;
    iput-object v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$2 Ljava/lang/Object;
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$3 Ljava/lang/Object;
    iput v15, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->I$0 I
    iput v4, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    invoke-direct v12, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->ensureMarketplaceLoading(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v7, +003h
    return-object v7
    move-object v6, v14
    move-object v14, v1
    move-object v1, v12
    move-object v11, v5
    move-object v5, v13
    move v13, v15
    move-object v15, v11
    check-cast v15, Lkotlinx/coroutines/Deferred;
    if-eqz v13, +003h
    goto +2h
    move v4, v2
    iput-object v15, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$0 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$1 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$2 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$3 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    move-object v2, v14
    move v3, v4
    move-object v4, v5
    move-object v5, v6
    move-object v6, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->ensureInstalledLoading(Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheKey; Z Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v7, +003h
    return-object v7
    move-object v11, v15
    move-object v15, v13
    move-object v13, v11
    move-object v14, v15
    check-cast v14, Lkotlinx/coroutines/Deferred;
    iput-object v14, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$0 Ljava/lang/Object;
    iput v9, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    invoke-interface v13, v0, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v7, +003h
    return-object v7
    move-object v13, v14
    iput-object v10, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->L$0 Ljava/lang/Object;
    iput v8, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$preload$1;->label I
    invoke-interface v13, v0, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v7, +003h
    return-object v7
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
.end method

.method public final resolveLocalizedDisplayName(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginListCache; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +026h
    if-eq v2, v4, +018h
    if-ne v2, v3, +00eh
    iget-object v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$1 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$1 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->getCachedLocalizedDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +003h
    return-object v7
    iput-object v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->label I
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->ensureMarketplaceLoading(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v2, v5
    check-cast v7, Lkotlinx/coroutines/Deferred;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$resolveLocalizedDisplayName$1;->label I
    invoke-interface v7, v0, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v0, v2
    check-cast v7, Ljava/util/Map;
    invoke-direct v0, v7, v6, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->findMarketplaceItem(Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    move-result-object v6
    const/4 v7, 0
    if-nez v6, +003h
    return-object v7
    invoke-static v6, v7, v4, v7, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->localizedDisplayName$default(Lcom/bytedance/trae/conversation/network/MarketplacePluginItem; Ljava/util/Locale; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v4
    if-eqz v0, +003h
    move-object v7, v6
    return-object v7
.end method
