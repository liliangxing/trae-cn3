# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;

.field private final fileSystem:Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;


.method public constructor <init>(com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem)void
    .registers 3
    # ins_size=2
    const-string v0, "fileSystem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    return-void 
.end method

.method public delete(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    invoke-interface v0, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->file(Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v2
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->delete(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public list(kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=2
    instance-of v0, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;
    invoke-direct v0, v10, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +02ah
    if-eq v2, v4, +020h
    if-ne v2, v3, +016h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/util/Iterator;
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/util/Collection;
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +52h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->label I
    invoke-interface v11, v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->list(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object v2, v10
    check-cast v11, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    move-object v6, v2
    move-object v5, v4
    move-object v4, v11
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +035h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v2, v11
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v11, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$1 Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$2 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->L$3 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem$list$1;->label I
    invoke-interface v11, v2, v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->metadata(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    check-cast v11, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    if-eqz v11, +010h
    new-instance v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->getSize()J
    move-result-wide v8
    invoke-direct v7, v2, v8, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;-><init>(Ljava/lang/String; J)V
    goto +2h
    const/4 v7, 0
    if-eqz v7, -033h
    invoke-interface v5, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -38h
    check-cast v5, Ljava/util/List;
    return-object v5
.end method
