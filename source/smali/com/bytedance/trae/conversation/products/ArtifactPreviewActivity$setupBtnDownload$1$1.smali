# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $needDecode:Lkotlin/jvm/internal/Ref$BooleanRef;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  kotlin.jvm.internal.Ref$BooleanRef  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->$needDecode Lkotlin/jvm/internal/Ref$BooleanRef;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->$needDecode Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    move-object v1, v11
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->label I
    invoke-static v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$fetchFileUrl(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    check-cast v12, Ljava/lang/String;
    move-object v0, v12
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +070h
    if-nez v12, +004h
    goto/16 +06ch
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$setFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v0
    sget-object v12, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v12
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    if-nez v1, +009h
    const-string v1, "fileUrl"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    goto +2h
    move-object v3, v1
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getChatSessionId$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +009h
    const-string v1, "chatSessionId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    goto +2h
    move-object v4, v1
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +009h
    const-string v1, "path"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    goto +2h
    move-object v5, v1
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCreatedTime$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)J
    move-result-wide v8
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getDownloadFinishCallback$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Lkotlin/jvm/functions/Function3;
    move-result-object v6
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->$needDecode Lkotlin/jvm/internal/Ref$BooleanRef;
    iget-boolean v7, v2, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    check-cast v12, Landroid/content/Context;
    move-object v10, v1
    check-cast v10, Lkotlinx/coroutines/CoroutineScope;
    move-object v1, v12
    move-object v2, v3
    move-object v3, v4
    move-object v4, v5
    move-object v5, v10
    invoke-virtual/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
.end method
