# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $fileUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->$fileUrl Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->$fileUrl Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->label I
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v11
    check-cast v11, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->$fileUrl Ljava/lang/String;
    invoke-direct v1, v4, v5, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v4, v10
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->label I
    invoke-static v11, v1, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Ljava/lang/String;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    if-eqz v11, +072h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileName$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "fileName"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/16 v1, 46
    const-string v4, ""
    invoke-static v0, v1, v4, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, v11, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$buildCodeHighlightHtml(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/webkit/WebView;
    move-result-object v11
    const-string/jumbo v0, webView
    if-nez v11, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v3
    const/4 v1, 0
    invoke-virtual v11, v1, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/webkit/WebView;
    move-result-object v11
    if-nez v11, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v3
    invoke-virtual v11, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v11
    invoke-virtual v11, v2, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v11, v2, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    const-string v1, "UTF-8"
    invoke-virtual v11, v1, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/webkit/WebView;
    move-result-object v11
    if-nez v11, +007h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    goto +2h
    move-object v4, v11
    const-string v5, "https://localhost"
    const-string/jumbo v7, text/html
    const-string v8, "UTF-8"
    const/4 v9, 0
    invoke-virtual/range v4 ... v9, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +6h
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
