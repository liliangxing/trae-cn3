# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VideoArtifactPreviewViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $onComplete:Lkotlin/jvm/functions/Function1;
.field final synthetic $ready:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;


.method constructor <init>(kotlin.jvm.functions.Function1  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->$onComplete Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->$ready Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->$onComplete Lkotlin/jvm/functions/Function1;
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->$ready Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->label I
    const/4 v2, 1
    if-eqz v1, +01ah
    if-ne v1, v2, +010h
    iget-object v0, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/functions/Function1;
    iget-object v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +38h
    move-exception v8
    goto +3ch
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->$onComplete Lkotlin/jvm/functions/Function1;
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;
    iget-object v3, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->$ready Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getLocalSource()Ljava/lang/String;
    move-result-object v3
    iget-object v4, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->getRequest()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getTitle()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, video/mp4
    move-object v6, v7
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v8, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->L$0 Ljava/lang/Object;
    iput-object v8, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->L$1 Ljava/lang/Object;
    iput v2, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;->label I
    invoke-virtual v1, v3, v4, v5, v6, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->saveLocalFile(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v8
    move-object v8, v1
    move-object v1, v0
    check-cast v8, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    goto +10h
    move-exception v0
    move-object v1, v8
    move-object v8, v0
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    const/4 v2, 0
    invoke-virtual v8, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v2, v8, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;-><init>(Z Ljava/lang/String;)V
    move-object v8, v0
    move-object v0, v1
    invoke-interface v0, v8, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    move-exception v8
    throw v8
    :try_start_0x13
    :try_start_0x26
    :try_start_0x4e
.end method
