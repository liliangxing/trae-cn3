# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VideoArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function1;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;


.method constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    const/4 v1, 1
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->invoke(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->create(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v11, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->getRepository()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    move-result-object v11
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v3, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->access$getRequest$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getSource()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    move-result-object v4
    iget-object v3, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->access$getRequest$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getCliConversationId()Ljava/lang/String;
    move-result-object v5
    iget-object v3, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->access$getRequest$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getConversationId()Ljava/lang/String;
    move-result-object v6
    iget-object v3, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->access$getRequest$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getMessageId()Ljava/lang/String;
    move-result-object v7
    iget-object v3, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->access$getRequest$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getFilePath()Ljava/lang/String;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;->Original Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    move-object v3, v1
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;)V
    move-object v3, v10
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;->label I
    invoke-virtual v11, v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->prepare(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    return-object v11
.end method
