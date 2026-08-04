# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
.super Ljava/lang/Object;
.source "UserScopedModelListMemoryCache.kt"

.field public static final ANONYMOUS_USER:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Companion;
.field private final entries:Ljava/util/Map;
.field private generation:J
.field private final lock:Ljava/lang/Object;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->Companion Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->lock Ljava/lang/Object;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->entries Ljava/util/Map;
    return-void 
.end method

.method private final normalizeUserId(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    if-eqz v2, +011h
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, "<anonymous>"
    return-object v2
.end method

.method public final captureOwner(java.lang.String)com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache$Owner
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->lock Ljava/lang/Object;
    monitor-enter v0
    new-instance v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->normalizeUserId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->generation J
    invoke-direct v1, v5, v2, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;-><init>(Ljava/lang/String; J)V
    monitor-exit v0
    return-object v1
    move-exception v5
    monitor-exit v0
    throw v5
    :try_start_0x3
.end method

.method public final get(java.lang.String  java.lang.String)java.lang.Object
    .registers 6
    # ins_size=3
    const-string/jumbo v0, route
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->lock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->entries Ljava/util/Map;
    new-instance v2, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$ScopedKey;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->normalizeUserId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$ScopedKey;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    monitor-exit v0
    return-object v4
    move-exception v4
    monitor-exit v0
    throw v4
    :try_start_0x9
.end method

.method public final onAccountChanged()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->lock Ljava/lang/Object;
    monitor-enter v0
    iget-wide v1, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->generation J
    const-wide/16 v3, 1
    add-long/2addr v1, v3
    iput-wide v1, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->generation J
    iget-object v1, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->entries Ljava/util/Map;
    invoke-interface v1, Ljava/util/Map;->clear()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final putIfCurrent(com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache$Owner  java.lang.String  java.lang.String  java.lang.Object)boolean
    .registers 10
    # ins_size=5
    const-string/jumbo v0, requestOwner
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, route
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->lock Ljava/lang/Object;
    monitor-enter v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->getGeneration()J
    move-result-wide v1
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->generation J
    cmp-long v1, v1, v3
    if-nez v1, +021h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->getUserId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->normalizeUserId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +003h
    goto +11h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->entries Ljava/util/Map;
    new-instance v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$ScopedKey;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->getUserId()Ljava/lang/String;
    move-result-object v6
    invoke-direct v1, v6, v8, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$ScopedKey;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v7, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    monitor-exit v0
    return v6
    move-exception v6
    monitor-exit v0
    throw v6
    :try_start_0xf
.end method
