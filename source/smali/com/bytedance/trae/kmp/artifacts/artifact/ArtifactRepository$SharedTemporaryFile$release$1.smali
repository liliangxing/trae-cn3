# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $leaseId:J
.field  J$0:J
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;


.method constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile  long  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    iput-wide v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->$leaseId J
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->$leaseId J
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile; J Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->label I
    const/4 v2, 2
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v1, +021h
    if-eq v1, v4, +011h
    if-ne v1, v2, +007h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +081h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->J$0 J
    iget-object v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    iget-object v7, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    invoke-static v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$getMutex$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v7
    iget-object v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->$leaseId J
    move-object v9, v8
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v7, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->L$0 Ljava/lang/Object;
    iput-object v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->L$1 Ljava/lang/Object;
    iput-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->J$0 J
    iput v4, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->label I
    invoke-interface v7, v3, v9, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$getReleasedLeaseIds$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;)Ljava/util/Set;
    move-result-object v9
    invoke-static v5, v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v5
    invoke-interface v9, v5, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v9
    const/4 v5, 0
    if-nez v9, +004h
    move v4, v5
    goto +19h
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$getActiveLeases$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;)I
    move-result v9
    sub-int/2addr v9, v4
    invoke-static v9, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v9
    invoke-static v1, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$setActiveLeases$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile; I)V
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$getDistributionFinished$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;)Z
    move-result v9
    if-eqz v9, -012h
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$getActiveLeases$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;)I
    move-result v9
    if-nez v9, -018h
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    if-eqz v4, +01eh
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    invoke-static v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$getFileSystem$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;)Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    move-result-object v9
    iget-object v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->access$getFile$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v1
    move-object v4, v8
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v3, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->L$0 Ljava/lang/Object;
    iput-object v3, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->L$1 Ljava/lang/Object;
    iput v2, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile$release$1;->label I
    invoke-interface v9, v1, v4, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->delete(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    move-exception v9
    invoke-interface v7, v3, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v9
    :try_start_0x49
.end method
