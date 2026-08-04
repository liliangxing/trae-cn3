# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    move-object v1, v5
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->label I
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$fetchFileUrl(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Ljava/lang/String;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$isDeleted$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Z
    move-result v0
    if-eqz v0, +00ah
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showArtifactDelete(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +0cah
    if-nez v6, +004h
    goto/16 +0c6h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$setFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileType$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    move-result-object v6
    const/4 v0, 0
    if-nez v6, +008h
    const-string v6, "fileType"
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    sget-object v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->ordinal()I
    move-result v6
    aget v6, v1, v6
    const-string v1, "path"
    const-string v2, "chatSessionId"
    const-string v3, "fileUrl"
    packed-switch v6, +00000abh
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getChatSessionId$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    iget-object v2, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v6, v4, v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showDownloadWithUrl(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +06eh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$downloadAndShowTxt(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    goto +5ch
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$downloadAndShowTxt(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    goto +4bh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showCodePreview(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    goto +3ah
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getChatSessionId$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    iget-object v2, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v6, v4, v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$loadMarkdownPreview(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +11h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showImagePreview(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    nop 
    packed-switch-payload 1 2 3 4 5 6
.end method
