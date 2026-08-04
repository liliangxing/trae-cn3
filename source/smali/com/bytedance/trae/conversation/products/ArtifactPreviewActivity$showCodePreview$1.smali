# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $fileUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->$fileUrl Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->$fileUrl Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->label I
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v13
    check-cast v13, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1$content$1;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    iget-object v5, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->$fileUrl Ljava/lang/String;
    invoke-direct v1, v4, v5, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1$content$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v4, v12
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v2, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->label I
    invoke-static v13, v1, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Ljava/lang/String;
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    if-eqz v13, +0c1h
    invoke-virtual v13, Ljava/lang/String;->length()I
    move-result v0
    const/high16 v1, 1048576
    const/4 v4, 0
    const-string v5, "path"
    if-le v0, v1, +029h
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getScrollTxt$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/widget/ScrollView;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, scrollTxt
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, v4, Landroid/widget/ScrollView;->setVisibility(I)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getTvTxt$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, tvTxt
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v0, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +6dh
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const-string v1, ""
    const/16 v6, 46
    invoke-static v0, v6, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, v13, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$buildCodeHighlightHtml(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/webkit/WebView;
    move-result-object v13
    const-string/jumbo v0, webView
    if-nez v13, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v3
    invoke-virtual v13, v4, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/webkit/WebView;
    move-result-object v13
    if-nez v13, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v3
    invoke-virtual v13, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v13
    invoke-virtual v13, v2, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v13, v2, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    const-string v1, "UTF-8"
    invoke-virtual v13, v1, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/webkit/WebView;
    move-result-object v13
    if-nez v13, +007h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    goto +2h
    move-object v6, v13
    const-string v7, "https://localhost"
    const-string/jumbo v9, text/html
    const-string v10, "UTF-8"
    const/4 v11, 0
    invoke-virtual/range v6 ... v11, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    iget-object v1, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getMessageId$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +008h
    const-string v1, "messageId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v13, v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactOpen(Ljava/lang/String; Ljava/lang/String;)V
    goto +ch
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    goto +6h
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    :try_start_0x4f
    :try_start_0x5a
    :try_start_0xb2
.end method
