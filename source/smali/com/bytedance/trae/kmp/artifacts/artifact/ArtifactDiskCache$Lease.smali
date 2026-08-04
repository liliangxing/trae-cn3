# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;
.super Ljava/lang/Object;
.source "ArtifactDiskCache.kt"

.field private closed:Z
.field private final reference:Ljava/lang/String;
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;


.method public constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, reference
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->reference Ljava/lang/String;
    return-void 
.end method

.method public final close(kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=2
    instance-of v0, v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;
    if-eqz v0, +012h
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->label I
    sub-int/2addr v13, v2
    iput v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;
    invoke-direct v0, v12, v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease; Lkotlin/coroutines/Continuation;)V
    iget-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v2, +043h
    if-eq v2, v6, +030h
    if-eq v2, v4, +018h
    if-ne v2, v3, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0cbh
    move-exception v13
    goto/16 +0d4h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    iget-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$1 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/sync/Mutex;
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v4
    goto/16 +095h
    move-exception v13
    move-object v0, v4
    goto/16 +0b6h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$1 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/sync/Mutex;
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v7
    goto +1ch
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$getMutex$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v13
    iget-object v2, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    iput-object v12, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$0 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$1 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$2 Ljava/lang/Object;
    iput v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->label I
    invoke-interface v13, v5, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v8, v12
    iget-boolean v7, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->closed Z
    if-nez v7, +079h
    iput-boolean v6, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->closed Z
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$getLeaseCounts$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;)Ljava/util/Map;
    move-result-object v7
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->reference Ljava/lang/String;
    invoke-interface v7, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Integer;
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2h
    move v7, v6
    sub-int/2addr v7, v6
    if-gtz v7, +00ch
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$getLeaseCounts$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;)Ljava/util/Map;
    move-result-object v7
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->reference Ljava/lang/String;
    invoke-interface v7, v9, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto +eh
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$getLeaseCounts$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;)Ljava/util/Map;
    move-result-object v9
    iget-object v10, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->reference Ljava/lang/String;
    invoke-interface v9, v10, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$getEntries$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;)Ljava/util/LinkedHashMap;
    move-result-object v7
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->reference Ljava/lang/String;
    invoke-virtual v7, v9, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    const/4 v9, 0
    if-eqz v7, +009h
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->getTemporaryOversized()Z
    move-result v7
    if-ne v7, v6, +003h
    goto +2h
    move v6, v9
    if-eqz v6, +021h
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$getFileSystem$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    move-result-object v6
    iget-object v7, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->reference Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$0 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$1 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->label I
    invoke-interface v6, v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;->delete(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v1, +003h
    return-object v1
    move-object v6, v8
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$getEntries$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;)Ljava/util/LinkedHashMap;
    move-result-object v4
    iget-object v6, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;->reference Ljava/lang/String;
    invoke-virtual v4, v6, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$1 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease$close$1;->label I
    invoke-static v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access$trimLocked(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v13
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    move-exception v0
    move-object v11, v0
    move-object v0, v13
    move-object v13, v11
    invoke-interface v0, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v13
    :try_start_0x31
    :try_start_0x4d
    :try_start_0x83
    :try_start_0xff
.end method
