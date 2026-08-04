# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
.super Ljava/lang/Object;
.source "KmpArtifactIo.kt"

.implements Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;

.field public static final $stable:I
.field private final entries:Ljava/util/LinkedHashMap;
.field private final mutex:Lkotlinx/coroutines/sync/Mutex;
.field private nextTemporaryId:J


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v2, v0, v1, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    return-void 
.end method

.method public atomicReplace(com.bytedance.trae.kmp.artifact.KmpFileReference  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=4
    const-string v0, "Missing source file "
    instance-of v1, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;
    if-eqz v1, +012h
    move-object v1, v9
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;
    iget v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->label I
    sub-int/2addr v9, v3
    iput v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;
    invoke-direct v1, v6, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->label I
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +022h
    if-ne v3, v5, +018h
    iget-object v7, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$3 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/sync/Mutex;
    iget-object v8, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$2 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v1, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v7
    move-object v7, v2
    goto +20h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v6, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v6, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$1 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$2 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->L$3 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$atomicReplace$1;->label I
    invoke-interface v9, v4, v1, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v1, v6
    iget-object v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-eqz v2, +017h
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    iget-object v7, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    check-cast v7, Ljava/util/Map;
    invoke-virtual v8, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v8
    invoke-interface v7, v8, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v9, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    new-instance v8, Ljava/lang/IllegalStateException;
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v8, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    move-exception v7
    invoke-interface v9, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v7
    :try_start_0x5e
    :try_start_0x7f
.end method

.method public createTemporaryFile(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=3
    const-string v0, "/cache/"
    instance-of v1, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;
    if-eqz v1, +012h
    move-object v1, v9
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;
    iget v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->label I
    sub-int/2addr v9, v3
    iput v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;
    invoke-direct v1, v7, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->label I
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +01eh
    if-ne v3, v5, +014h
    iget-object v8, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->L$2 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v1, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    move-object v8, v2
    goto +1eh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v9, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v9, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v7, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->L$0 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->L$1 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->L$2 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$createTemporaryFile$1;->label I
    invoke-interface v9, v4, v1, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v1, v7
    iget-wide v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->nextTemporaryId J
    const-wide/16 v5, 1
    add-long/2addr v2, v5
    iput-wide v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->nextTemporaryId J
    new-instance v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const/16 v0, 45
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    iget-wide v5, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->nextTemporaryId J
    invoke-virtual v8, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v0, ".tmp"
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v2, v8, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;-><init>(Ljava/lang/String;)V
    iget-object v8, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    check-cast v8, Ljava/util/Map;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    const/4 v3, 0
    new-array v3, v3, [B
    const-wide/16 v5, 0
    invoke-direct v1, v3, v5, v6, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;-><init>([B J)V
    invoke-interface v8, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v9, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v2
    move-exception v8
    invoke-interface v9, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    :try_start_0x58
.end method

.method public delete(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +01eh
    if-ne v2, v4, +014h
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    move-object v6, v1
    goto +1eh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v5, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->L$1 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$delete$1;->label I
    invoke-interface v7, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    if-eqz v6, +003h
    goto +2h
    const/4 v4, 0
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v6
    move-exception v6
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x56
.end method

.method public exists(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +01eh
    if-ne v2, v4, +014h
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    move-object v6, v1
    goto +1eh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v5, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->L$1 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$exists$1;->label I
    invoke-interface v7, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v6
    invoke-interface v0, v6, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v6
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v6
    move-exception v6
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x56
.end method

.method public file(java.lang.String)com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 7
    # ins_size=2
    const-string/jumbo v0, relativePath
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "/"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/4 v2, 1
    new-array v2, v2, [C
    const/4 v3, 0
    const/16 v4, 47
    aput-char v4, v2, v3
    invoke-static v6, v2, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v0, v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;-><init>(Ljava/lang/String;)V
    return-object v0
.end method

.method public list(kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +018h
    if-ne v2, v4, +00eh
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/sync/Mutex;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$list$1;->label I
    invoke-interface v6, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    move-object v1, v6
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v6, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;
    move-result-object v6
    const-string v0, "<get-keys>(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v6, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v0, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +011h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    new-instance v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    invoke-direct v4, v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;-><init>(Ljava/lang/String;)V
    invoke-interface v0, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -14h
    check-cast v0, Ljava/util/List;
    invoke-interface v1, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    move-exception v6
    invoke-interface v1, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x4f
.end method

.method public localUri(com.bytedance.trae.kmp.artifact.KmpFileReference)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "file"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "file://"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public metadata(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=3
    instance-of v0, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;
    invoke-direct v0, v7, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +01eh
    if-ne v2, v3, +014h
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->L$2 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    move-object v8, v1
    goto +1eh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v9, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v9, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->L$0 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->L$1 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$metadata$1;->label I
    invoke-interface v9, v4, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v7
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v8, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v8, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    if-eqz v8, +012h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    invoke-virtual v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->getBytes()[B
    move-result-object v1
    array-length v1, v1
    int-to-long v1, v1
    invoke-virtual v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->getModifiedAtMillis()J
    move-result-wide v5
    invoke-direct v0, v1, v2, v5, v6, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;-><init>(J J)V
    goto +2h
    move-object v0, v4
    invoke-interface v9, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    move-exception v8
    invoke-interface v9, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    :try_start_0x56
.end method

.method public read(com.bytedance.trae.kmp.artifact.KmpFileReference  long  int  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=6
    instance-of v0, v10, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;
    if-eqz v0, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v10, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->label I
    sub-int/2addr v10, v2
    iput v10, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;
    invoke-direct v0, v5, v10, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v10, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +022h
    if-ne v2, v4, +018h
    iget v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->I$0 I
    iget-wide v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->J$0 J
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v10, v6
    move-object v6, v1
    goto +22h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v5, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->L$1 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->L$2 Ljava/lang/Object;
    iput-wide v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->J$0 J
    iput v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->I$0 I
    iput v4, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$read$1;->label I
    invoke-interface v10, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    const/4 v0, 0
    if-eqz v6, +025h
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->getBytes()[B
    move-result-object v6
    if-nez v6, +003h
    goto +1dh
    const-wide/16 v1, 0
    invoke-static v7, v8, v1, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v7
    array-length v1, v6
    int-to-long v1, v1
    invoke-static v7, v8, v1, v2, Lkotlin/ranges/RangesKt;->coerceAtMost(J J)J
    move-result-wide v7
    long-to-int v7, v7
    invoke-static v9, v0, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v8
    add-int/2addr v8, v7
    array-length v9, v6
    invoke-static v8, v9, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v8
    invoke-static v6, v7, v8, Lkotlin/collections/ArraysKt;->copyOfRange([B I I)[B
    move-result-object v6
    goto +3h
    new-array v6, v0, [B
    invoke-interface v10, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v6
    move-exception v6
    invoke-interface v10, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x5e
.end method

.method public touch(com.bytedance.trae.kmp.artifact.KmpFileReference  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=5
    instance-of v0, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;
    invoke-direct v0, v5, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +020h
    if-ne v2, v4, +016h
    iget-wide v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->J$0 J
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v6
    move-object v6, v1
    goto +20h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v5, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->L$1 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->L$2 Ljava/lang/Object;
    iput-wide v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->J$0 J
    iput v4, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->label I
    invoke-interface v9, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    if-eqz v6, +005h
    invoke-virtual v6, v7, v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->setModifiedAtMillis(J)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v9, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    move-exception v6
    invoke-interface v9, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x5a
.end method

.method public write(com.bytedance.trae.kmp.artifact.KmpFileReference  byte[]  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=5
    instance-of v0, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;
    invoke-direct v0, v5, v9, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;-><init>(Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +024h
    if-ne v2, v4, +01ah
    iget-boolean v8, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->Z$0 Z
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$3 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$2 Ljava/lang/Object;
    check-cast v7, [B
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v6
    move-object v6, v1
    goto +22h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v5, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$1 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$2 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->L$3 Ljava/lang/Object;
    iput-boolean v8, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->Z$0 Z
    iput v4, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->label I
    invoke-interface v9, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v5
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    if-eqz v8, +00dh
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->getBytes()[B
    move-result-object v8
    invoke-static v8, v7, Lkotlin/collections/ArraysKt;->plus([B [B)[B
    move-result-object v7
    goto +bh
    array-length v8, v7
    invoke-static v7, v8, Ljava/util/Arrays;->copyOf([B I)[B
    move-result-object v7
    const-string v8, "copyOf(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->entries Ljava/util/LinkedHashMap;
    check-cast v8, Ljava/util/Map;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->getModifiedAtMillis()J
    move-result-wide v1
    goto +3h
    const-wide/16 v1, 0
    invoke-direct v0, v7, v1, v2, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;-><init>([B J)V
    invoke-interface v8, v6, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v9, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    move-exception v6
    invoke-interface v9, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v6
    :try_start_0x60
.end method
