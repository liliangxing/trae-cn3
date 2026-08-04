# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
.super Ljava/lang/Object;
.source "DetailBlockStore.kt"

.field private static final BLOCK_TAG:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
.field private static final MAX_ENTRIES:I
.field private static final cache:Ljava/util/LinkedHashMap;
.field private static final lock:Ljava/lang/Object;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;-><init>()V
    check-cast v0, Ljava/util/LinkedHashMap;
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->cache Ljava/util/LinkedHashMap;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->lock Ljava/lang/Object;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic getCache$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public final clear()void
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->lock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->cache Ljava/util/LinkedHashMap;
    invoke-virtual v1, Ljava/util/LinkedHashMap;->size()I
    move-result v2
    invoke-virtual v1, Ljava/util/LinkedHashMap;->clear()V
    monitor-exit v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "AgentBlock"
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[BlockStore] clear: removed "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " entries"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final get(java.lang.String)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 4
    # ins_size=2
    const-string v0, "key"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->lock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->cache Ljava/util/LinkedHashMap;
    invoke-virtual v1, v3, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    monitor-exit v0
    return-object v3
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x8
.end method

.method public final synthetic getAs(java.lang.String)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 4
    # ins_size=2
    const-string v0, "key"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v3
    const/4 v0, 2
    const-string v1, "T"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(I Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    return-object v3
.end method

.method public final getCache()java.util.LinkedHashMap
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->cache Ljava/util/LinkedHashMap;
    return-object v0
.end method

.method public final put(com.bytedance.trae.conversation.chat.block.AgentContentBlock)java.lang.String
    .registers 8
    # ins_size=2
    const-string v0, "block"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toString(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->lock Ljava/lang/Object;
    monitor-enter v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->cache Ljava/util/LinkedHashMap;
    move-object v3, v2
    check-cast v3, Ljava/util/Map;
    invoke-interface v3, v0, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v1
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "AgentBlock"
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "[BlockStore] put: key="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", type="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v7
    invoke-interface v7, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v4, ", cacheSize="
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v2, Ljava/util/LinkedHashMap;->size()I
    move-result v2
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    move-exception v7
    monitor-exit v1
    throw v7
    :try_start_0x16
.end method

.method public final putOrUpdate(java.lang.String  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 7
    # ins_size=3
    const-string v0, "key"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->lock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->cache Ljava/util/LinkedHashMap;
    check-cast v1, Ljava/util/Map;
    invoke-interface v1, v5, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "AgentBlock"
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[BlockStore] putOrUpdate: key="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", type="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v6
    invoke-interface v6, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v5
    monitor-exit v0
    throw v5
    :try_start_0xd
.end method

.method public final remove(java.lang.String)void
    .registers 6
    # ins_size=2
    const-string v0, "key"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->lock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->cache Ljava/util/LinkedHashMap;
    invoke-virtual v1, v5, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    monitor-exit v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "AgentBlock"
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[BlockStore] remove: key="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v5
    monitor-exit v0
    throw v5
    :try_start_0x8
.end method
