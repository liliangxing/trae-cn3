# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $imageUrl:Ljava/lang/String;
.field final synthetic $isLocalWork:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String  boolean  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->$imageUrl Ljava/lang/String;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->$isLocalWork Z
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->$imageUrl Ljava/lang/String;
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->$isLocalWork Z
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Z Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +012h
    if-ne v2, v3, +008h
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v17
    goto +69h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v5
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    invoke-virtual v2, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v6
    const-string v2, "getApplicationContext(...)"
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->$imageUrl Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    const-string v2, "conversationId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v4
    goto +2h
    move-object v8, v2
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->$isLocalWork Z
    if-eqz v2, +00dh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getOidId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +014h
    const-string v2, "oidId"
    goto +bh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileName$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    const-string v2, "fileName"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v4
    goto +2h
    move-object v9, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getNeedDecode$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Z
    move-result v10
    const-wide/16 v11, 0
    move-object v13, v0
    check-cast v13, Lkotlin/coroutines/Continuation;
    const/16 v14, 32
    const/4 v15, 0
    iput v3, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->label I
    invoke-static/range v5 ... v15, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCache$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Ljava/io/File;
    if-eqz v2, +056h
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v1
    if-eqz v1, +050h
    invoke-virtual v2, Ljava/io/File;->length()J
    move-result-wide v5
    const-wide/16 v7, 0
    cmp-long v1, v5, v7
    if-lez v1, +046h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v1
    if-nez v1, +008h
    const-string v1, "progressBar"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v4
    const/16 v3, 8
    invoke-virtual v1, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getImageContainer$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/widget/FrameLayout;
    move-result-object v1
    const-string v3, "imageContainer"
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v4
    const/4 v5, 0
    invoke-virtual v1, v5, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-static v2, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$loadImage(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Landroid/net/Uri;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getImageContainer$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/widget/FrameLayout;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v2
    check-cast v4, Landroid/view/View;
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$setupImageTouchHandling(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Landroid/view/View;)V
    goto +10h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "ArtifactPreviewActivity"
    const-string/jumbo v3, showImagePreview: cache download failed
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
