# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
.super Ljava/lang/Object;
.source "ResourceRepoManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
.field private static final MAX_SIZE:I
.field private static final imageIdToUrlCache:Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final synchronized clear()void
    .registers 2
    # ins_size=1
    monitor-enter v1
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;->evictAll()V
    monitor-exit v1
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x1
.end method

.method public final synchronized get(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    monitor-enter v1
    const-string v0, "imageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    monitor-exit v1
    return-object v2
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public final synchronized getAll(java.util.List)java.util.Map
    .registers 5
    # ins_size=2
    monitor-enter v3
    const-string v0, "imageIds"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-interface v4, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-eqz v2, -014h
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -19h
    monitor-exit v3
    return-object v0
    move-exception v4
    monitor-exit v3
    throw v4
    :try_start_0x1
.end method

.method public final synchronized getMissing(java.util.List)java.util.List
    .registers 6
    # ins_size=2
    monitor-enter v4
    const-string v0, "imageIds"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -018h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v0, Ljava/util/List;
    monitor-exit v4
    return-object v0
    move-exception v5
    monitor-exit v4
    throw v5
    :try_start_0x1
.end method

.method public final synchronized put(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    monitor-enter v1
    const-string v0, "imageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public final synchronized putAll(java.util.Map)void
    .registers 5
    # ins_size=2
    monitor-enter v3
    const-string v0, "map"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v4, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01ah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1dh
    monitor-exit v3
    return-void 
    move-exception v4
    monitor-exit v3
    throw v4
    :try_start_0x1
.end method

.method public final synchronized remove(java.lang.String)void
    .registers 3
    # ins_size=2
    monitor-enter v1
    const-string v0, "imageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->imageIdToUrlCache Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager$imageIdToUrlCache$1;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method
