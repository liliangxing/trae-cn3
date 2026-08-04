# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
.super Ljava/lang/Object;
.source "ArtifactDiskCache.kt"

.field public static final $stable:I
.field private final entries:Ljava/util/LinkedHashMap;
.field private final fileSystem:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
.field private final leaseCounts:Ljava/util/Map;
.field private final maxBytes:J
.field private final mutex:Lkotlinx/coroutines/sync/Mutex;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactCacheFileSystem  long)void
    .registers 5
    # ins_size=4
    const-string v0, "fileSystem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->fileSystem Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->maxBytes J
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    invoke-static v4, v2, v3, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->leaseCounts Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactCacheFileSystem  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +005h
    const-wide/32 v2, 104857600
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem; J)V
    return-void 
.end method

.method public static final synthetic access$getEntries$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache)java.util.LinkedHashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    return-object v0
.end method

.method public static final synthetic access$getFileSystem$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache)com.bytedance.trae.kmp.artifacts.artifact.ArtifactCacheFileSystem
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->fileSystem Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    return-object v0
.end method

.method public static final synthetic access$getLeaseCounts$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->leaseCounts Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$getMutex$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache)kotlinx.coroutines.sync.Mutex
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    return-object v0
.end method

.method public static final synthetic access$trimLocked(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->trimLocked(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final trimLocked(kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=2
    instance-of v0, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;
    invoke-direct v0, v10, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->label I
    const/4 v3, 1
    if-eqz v2, +01fh
    if-ne v2, v3, +015h
    iget-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->J$0 J
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->L$1 Ljava/lang/Object;
    check-cast v6, Ljava/util/Iterator;
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0bbh
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v11, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;
    move-result-object v11
    const-string v2, "<get-values>(...)"
    invoke-static v11, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/lang/Iterable;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    const-wide/16 v4, 0
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +00eh
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getSize()J
    move-result-wide v6
    add-long/2addr v4, v6
    goto -11h
    iget-wide v6, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->maxBytes J
    cmp-long v11, v4, v6
    if-gtz v11, +005h
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    iget-object v11, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v11, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;
    move-result-object v11
    invoke-static v11, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +027h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    iget-object v8, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->leaseCounts Ljava/util/Map;
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v7
    invoke-interface v8, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Integer;
    const/4 v8, 0
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2h
    move v7, v8
    if-nez v7, +003h
    move v8, v3
    if-eqz v8, -025h
    invoke-interface v2, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ah
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$$inlined$sortedBy$1;
    invoke-direct v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$$inlined$sortedBy$1;-><init>()V
    check-cast v11, Ljava/util/Comparator;
    invoke-static v2, v11, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v11
    invoke-interface v11, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v11
    move-object v7, v10
    move-object v6, v11
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +03dh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v2, v11
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    iget-wide v8, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->maxBytes J
    cmp-long v11, v4, v8
    if-lez v11, +030h
    iget-object v11, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->fileSystem Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v8
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->L$1 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->L$2 Ljava/lang/Object;
    iput-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->J$0 J
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trimLocked$1;->label I
    invoke-interface v11, v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;->delete(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    check-cast v11, Ljava/lang/Boolean;
    invoke-virtual v11, Ljava/lang/Boolean;->booleanValue()Z
    move-result v11
    if-eqz v11, -030h
    iget-object v11, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v11, v8, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getSize()J
    move-result-wide v8
    sub-long/2addr v4, v8
    goto -40h
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method public final access(java.lang.String  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=5
    move-object v1, v15
    move-object/from16 v0, v19
    instance-of v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;
    invoke-direct v2, v15, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->label I
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v4, +021h
    if-ne v4, v6, +017h
    iget-wide v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->J$0 J
    iget-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v2, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide v10, v3
    move-object v3, v6
    move-object v4, v7
    goto +26h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->L$0 Ljava/lang/Object;
    move-object/from16 v4, v16
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->L$1 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->L$2 Ljava/lang/Object;
    move-wide/from16 v7, v17
    iput-wide v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->J$0 J
    iput v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$access$1;->label I
    invoke-interface v0, v5, v2, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v3, +003h
    return-object v3
    move-object v3, v0
    move-object v2, v1
    move-wide v10, v7
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v0, v4, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    if-eqz v6, +016h
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    check-cast v0, Ljava/util/Map;
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v12, 0
    const/16 v13, 11
    const/4 v14, 0
    invoke-static/range v6 ... v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->copy$default(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry; Ljava/lang/String; J J Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    move-result-object v2
    invoke-interface v0, v4, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v3, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    invoke-interface v3, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    :try_start_0x64
.end method

.method public final acquire(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    const-string v0, "Missing cache entry "
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;
    if-eqz v1, +012h
    move-object v1, v8
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;
    iget v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->label I
    sub-int/2addr v8, v3
    iput v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;
    invoke-direct v1, v6, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->label I
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +01eh
    if-ne v3, v5, +014h
    iget-object v7, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->L$2 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v1, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v7
    move-object v7, v2
    goto +1eh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->L$1 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->L$2 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$acquire$1;->label I
    invoke-interface v8, v4, v1, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v1, v6
    iget-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    check-cast v2, Ljava/util/Map;
    invoke-interface v2, v7, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +025h
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->leaseCounts Ljava/util/Map;
    invoke-interface v0, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Integer;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    goto +2h
    const/4 v2, 0
    add-int/2addr v2, v5
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v7, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v8, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;
    invoke-direct v8, v1, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Ljava/lang/String;)V
    return-object v8
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    new-instance v0, Ljava/lang/IllegalStateException;
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v0, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    move-exception v7
    invoke-interface v8, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v7
    :try_start_0x58
    :try_start_0x85
.end method

.method public final commit(com.bytedance.trae.kmp.artifacts.artifact.ArtifactCacheEntry  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=3
    instance-of v0, v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;
    invoke-direct v0, v12, v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v2, +03eh
    if-eq v2, v5, +02ah
    if-eq v2, v4, +015h
    if-ne v2, v3, +00bh
    iget-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +08ch
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v14, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v14, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    iget-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$2 Ljava/lang/Object;
    check-cast v13, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    iget-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4dh
    move-exception v14
    goto/16 +07dh
    iget-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$2 Ljava/lang/Object;
    check-cast v13, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v14, v13
    move-object v13, v2
    goto +16h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v12, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$0 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$1 Ljava/lang/Object;
    iput-object v14, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$2 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->label I
    invoke-interface v14, v6, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v5, v12
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getSize()J
    move-result-wide v7
    iget-wide v9, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->maxBytes J
    cmp-long v2, v7, v9
    if-lez v2, +025h
    iget-object v2, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->fileSystem Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v7
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$0 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$1 Ljava/lang/Object;
    iput-object v14, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->label I
    invoke-interface v2, v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;->delete(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v2, v13
    move-object v13, v14
    move-object v4, v5
    iget-object v14, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v14, v2, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-object v5, v4
    goto +dh
    iget-object v2, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    check-cast v2, Ljava/util/Map;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v4
    invoke-interface v2, v4, v13, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-object v13, v14
    iput-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$1 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$commit$1;->label I
    invoke-direct v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->trimLocked(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v13, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    move-exception v13
    move-object v11, v14
    move-object v14, v13
    move-object v13, v11
    invoke-interface v13, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v14
    :try_start_0x31
    :try_start_0x4a
    :try_start_0x78
    :try_start_0x9a
    :try_start_0xa5
    :try_start_0xb1
.end method

.method public final discard$artifacts_mainlandRelease(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +01eh
    if-ne v2, v4, +014h
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    move-object v6, v1
    goto +1eh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->L$1 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$discard$1;->label I
    invoke-interface v7, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v1, v6, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->leaseCounts Ljava/util/Map;
    invoke-interface v0, v6, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Integer;
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    move-exception v6
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x56
.end method

.method public final restore(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +01eh
    if-ne v2, v4, +014h
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/util/List;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    move-object v6, v1
    goto +1eh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->L$1 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$restore$1;->label I
    invoke-interface v7, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v1, Ljava/util/LinkedHashMap;->clear()V
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    check-cast v2, Ljava/util/Map;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v4
    invoke-interface v2, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -17h
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    move-exception v6
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x56
.end method

.method public final startupCleanup(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=3
    move-object/from16 v1, v18
    move-object/from16 v0, v20
    instance-of v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 3
    const/4 v8, 2
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v4, +056h
    if-eq v4, v9, +03fh
    if-eq v4, v8, +028h
    if-eq v4, v7, +011h
    if-ne v4, v6, +007h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +14dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$3 Ljava/lang/Object;
    check-cast v4, Ljava/util/Map;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$2 Ljava/lang/Object;
    check-cast v9, Ljava/util/Iterator;
    iget-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lkotlinx/coroutines/sync/Mutex;
    iget-object v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c8h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/util/Map;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$1 Ljava/lang/Object;
    move-object v11, v9
    check-cast v11, Lkotlinx/coroutines/sync/Mutex;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0aeh
    move-exception v0
    goto/16 +11eh
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/sync/Mutex;
    iget-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$1 Ljava/lang/Object;
    check-cast v11, Ljava/util/List;
    iget-object v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v17, v11
    move-object v11, v4
    move-object/from16 v4, v17
    goto +19h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$0 Ljava/lang/Object;
    move-object/from16 v4, v19
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$1 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$2 Ljava/lang/Object;
    iput v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    invoke-interface v0, v10, v2, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v3, +003h
    return-object v3
    move-object v11, v0
    move-object v12, v1
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +024h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    move-object v14, v13
    check-cast v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    invoke-virtual v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getSize()J
    move-result-wide v15
    iget-wide v6, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->maxBytes J
    cmp-long v6, v15, v6
    if-gtz v6, +00ah
    invoke-virtual v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getTemporaryOversized()Z
    move-result v6
    if-nez v6, +004h
    move v6, v9
    goto +2h
    move v6, v5
    if-eqz v6, +005h
    invoke-interface v0, v13, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/4 v6, 4
    const/4 v7, 3
    goto -27h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    const/16 v4, 10
    invoke-static v0, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-static v4, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v4
    const/16 v6, 16
    invoke-static v4, v6, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v4
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-direct v6, v4, Ljava/util/LinkedHashMap;-><init>(I)V
    move-object v4, v6
    check-cast v4, Ljava/util/Map;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +011h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getReference()Ljava/lang/String;
    move-result-object v7
    invoke-interface v4, v7, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -14h
    iget-object v0, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->fileSystem Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    iput-object v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$0 Ljava/lang/Object;
    iput-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$1 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$2 Ljava/lang/Object;
    iput v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    invoke-interface v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;->list(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v9, v12
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move-object v12, v9
    move-object v9, v0
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +043h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;->getReference()Ljava/lang/String;
    move-result-object v6
    const-string v7, ".tmp"
    invoke-static v6, v7, v5, v8, v10, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +019h
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;->getSize()J
    move-result-wide v6
    iget-wide v13, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->maxBytes J
    cmp-long v6, v6, v13
    if-gtz v6, +00fh
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;->getReference()Ljava/lang/String;
    move-result-object v6
    invoke-interface v4, v6, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +3h
    const/4 v7, 3
    goto -2eh
    iget-object v6, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->fileSystem Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;->getReference()Ljava/lang/String;
    move-result-object v0
    iput-object v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$0 Ljava/lang/Object;
    iput-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$1 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$3 Ljava/lang/Object;
    const/4 v7, 3
    iput v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    invoke-interface v6, v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;->delete(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, -044h
    return-object v3
    iget-object v0, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v0, Ljava/util/LinkedHashMap;->clear()V
    iget-object v0, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v0, v4, Ljava/util/LinkedHashMap;->putAll(Ljava/util/Map;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v11, v10, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$0 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$1 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$2 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->L$3 Ljava/lang/Object;
    const/4 v0, 4
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$startupCleanup$1;->label I
    invoke-virtual v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->trim(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-interface v11, v10, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    :try_start_0x52
    :try_start_0x64
    :try_start_0x99
.end method

.method public final trim(kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=2
    instance-of v0, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;
    invoke-direct v0, v7, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +025h
    if-eq v2, v4, +016h
    if-ne v2, v3, +00ch
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +39h
    move-exception v8
    goto +43h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v2
    goto +14h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->L$0 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->label I
    invoke-interface v8, v5, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v4, v7
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$trim$1;->label I
    invoke-direct v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->trimLocked(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v8
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    move-exception v0
    move-object v6, v0
    move-object v0, v8
    move-object v8, v6
    invoke-interface v0, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    :try_start_0x2e
    :try_start_0x5c
    :try_start_0x6a
.end method
