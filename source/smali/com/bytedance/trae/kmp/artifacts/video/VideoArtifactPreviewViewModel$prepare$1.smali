# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VideoArtifactPreviewViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;


.method constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->label I
    const/4 v2, -1
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +018h
    if-eq v1, v4, +010h
    if-ne v1, v3, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +49h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +15h
    move-exception v6
    goto +55h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-static v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$getPrepareOriginal$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)Lkotlin/jvm/functions/Function1;
    move-result-object v6
    iput v4, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->label I
    invoke-interface v6, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult;
    instance-of v1, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;
    if-eqz v1, +012h
    iget-object v1, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v3, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->label I
    invoke-static v1, v6, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$handleReady(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +015h
    return-object v0
    instance-of v6, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Failed;
    if-eqz v6, +013h
    iget-object v6, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-static v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$get_state$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;-><init>(I)V
    invoke-interface v6, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    iget-object v6, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-static v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$get_state$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;-><init>(I)V
    invoke-interface v6, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    throw v6
    :try_start_0x1b
    :try_start_0x24
.end method
