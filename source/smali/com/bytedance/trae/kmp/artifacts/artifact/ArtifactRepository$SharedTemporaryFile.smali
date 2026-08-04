# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"

.field private activeLeases:I
.field private final cleanupScope:Lkotlinx/coroutines/CoroutineScope;
.field private distributionFinished:Z
.field private final file:Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
.field private final fileSystem:Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
.field private final localUri:Ljava/lang/String;
.field private final mutex:Lkotlinx/coroutines/sync/Mutex;
.field private nextLeaseId:J
.field private final releasedLeaseIds:Ljava/util/Set;


.method public constructor <init>(com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem  com.bytedance.trae.kmp.artifact.KmpFileReference  java.lang.String  kotlinx.coroutines.CoroutineScope)void
    .registers 6
    # ins_size=5
    const-string v0, "fileSystem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "file"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "localUri"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cleanupScope"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->localUri Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->cleanupScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    invoke-static v4, v2, v3, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->mutex Lkotlinx/coroutines/sync/Mutex;
    new-instance v2, Ljava/util/LinkedHashSet;
    invoke-direct v2, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v2, Ljava/util/Set;
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->releasedLeaseIds Ljava/util/Set;
    return-void 
.end method

.method public static final synthetic access$getActiveLeases$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->activeLeases I
    return v0
.end method

.method public static final synthetic access$getDistributionFinished$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->distributionFinished Z
    return v0
.end method

.method public static final synthetic access$getFile$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile)com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    return-object v0
.end method

.method public static final synthetic access$getFileSystem$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile)com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    return-object v0
.end method

.method public static final synthetic access$getMutex$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile)kotlinx.coroutines.sync.Mutex
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->mutex Lkotlinx/coroutines/sync/Mutex;
    return-object v0
.end method

.method public static final synthetic access$getReleasedLeaseIds$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile)java.util.Set
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->releasedLeaseIds Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$setActiveLeases$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->activeLeases I
    return-void 
.end method

.method public final acquire(kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=2
    instance-of v0, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;
    invoke-direct v0, v8, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +018h
    if-ne v2, v4, +00eh
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/sync/Mutex;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1dh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$acquire$1;->label I
    invoke-interface v9, v3, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v0, v8
    move-object v1, v9
    iget-boolean v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->distributionFinished Z
    xor-int/2addr v9, v4
    if-eqz v9, +020h
    iget v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->activeLeases I
    add-int/2addr v9, v4
    iput v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->activeLeases I
    iget-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->nextLeaseId J
    const-wide/16 v6, 1
    add-long/2addr v4, v6
    iput-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->nextLeaseId J
    invoke-interface v1, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->localUri Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$TemporaryFileLease;
    invoke-direct v2, v0, v4, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$TemporaryFileLease;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile; J)V
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    invoke-direct v9, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;-><init>(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;)V
    return-object v9
    const-string v9, "Temporary resource distribution already finished"
    new-instance v0, Ljava/lang/IllegalStateException;
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-direct v0, v9, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    move-exception v9
    invoke-interface v1, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v9
    :try_start_0x4f
    :try_start_0x72
.end method

.method public final finishDistribution(kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=2
    instance-of v0, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;
    invoke-direct v0, v7, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->label I
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v2, +01eh
    if-eq v2, v5, +010h
    if-ne v2, v3, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +46h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +14h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->L$0 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->L$1 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->label I
    invoke-interface v2, v4, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v6, v7
    iput-boolean v5, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->distributionFinished Z
    iget v8, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->activeLeases I
    if-nez v8, +003h
    goto +2h
    const/4 v5, 0
    invoke-interface v2, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    if-eqz v5, +016h
    iget-object v8, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iget-object v2, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->L$0 Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$finishDistribution$1;->label I
    invoke-interface v8, v2, v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->delete(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    move-exception v8
    invoke-interface v2, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    :try_start_0x55
.end method

.method public final release(long)void
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->cleanupScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;
    const/4 v4, 0
    invoke-direct v3, v6, v7, v8, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile; J Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
