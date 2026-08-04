# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $imageUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->$imageUrl Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->$imageUrl Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->label I
    const-string v3, "path"
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +012h
    if-ne v2, v4, +008h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v18
    goto +54h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v6
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    invoke-virtual v2, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v7
    const-string v2, "getApplicationContext(...)"
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->$imageUrl Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    const-string v2, "conversationId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v5
    goto +2h
    move-object v9, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +007h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v5
    goto +2h
    move-object v10, v2
    const/4 v11, 1
    const-wide/16 v12, 0
    move-object v14, v0
    check-cast v14, Lkotlin/coroutines/Continuation;
    const/16 v15, 32
    const/16 v16, 0
    iput v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->label I
    invoke-static/range v6 ... v16, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCache$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Ljava/io/File;
    const-string v1, "ArtifactPreviewActivity"
    if-eqz v2, +098h
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v4
    if-eqz v4, +092h
    invoke-virtual v2, Ljava/io/File;->length()J
    move-result-wide v6
    const-wide/16 v8, 0
    cmp-long v4, v6, v8
    if-lez v4, +088h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v5
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getMessageId$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +008h
    const-string v3, "messageId"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v5
    invoke-virtual v4, v6, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactOpen(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v3
    if-nez v3, +008h
    const-string v3, "progressBar"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v5
    const/16 v4, 8
    invoke-virtual v3, v4, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getImageContainer$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/widget/FrameLayout;
    move-result-object v3
    const-string v4, "imageContainer"
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v5
    const/4 v6, 0
    invoke-virtual v3, v6, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-static v2, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v8, showImagePreview cache uri: 
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", size="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v2, Ljava/io/File;->length()J
    move-result-wide v8
    invoke-virtual v7, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$loadImage(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Landroid/net/Uri;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getImageContainer$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/widget/FrameLayout;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v2
    check-cast v5, Landroid/view/View;
    invoke-static v1, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$setupImageTouchHandling(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Landroid/view/View;)V
    goto +eh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, showImagePreview: cache download failed
    invoke-virtual v2, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
