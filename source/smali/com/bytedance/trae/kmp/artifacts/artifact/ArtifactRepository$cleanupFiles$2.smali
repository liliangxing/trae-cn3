# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $files:Ljava/util/Collection;
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;


.method constructor <init>(java.util.Collection  com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->$files Ljava/util/Collection;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->$files Ljava/util/Collection;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;-><init>(Ljava/util/Collection; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->label I
    const/4 v2, 1
    if-eqz v1, +018h
    if-ne v1, v2, +00eh
    iget-object v1, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/util/Iterator;
    iget-object v3, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +18h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->$files Ljava/util/Collection;
    check-cast v7, Ljava/lang/Iterable;
    iget-object v1, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    move-object v3, v1
    move-object v1, v7
    move-object v7, v6
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +019h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->access$getFileSystem$p(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;)Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    move-result-object v5
    iput-object v3, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->L$0 Ljava/lang/Object;
    iput-object v1, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->L$1 Ljava/lang/Object;
    iput v2, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;->label I
    invoke-interface v5, v4, v7, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->delete(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, -01ah
    return-object v0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0x13
    :try_start_0x3b
.end method
