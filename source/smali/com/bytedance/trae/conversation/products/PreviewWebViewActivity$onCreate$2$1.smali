# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PreviewWebViewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $rawUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$rawUrl Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$chatSessionId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$cliType Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$rawUrl Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$chatSessionId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$cliType Ljava/lang/String;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v10
    check-cast v10, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1$result$1;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$rawUrl Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$chatSessionId Ljava/lang/String;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->$cliType Ljava/lang/String;
    const/4 v8, 0
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1$result$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v9
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->label I
    invoke-static v10, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setIndeterminate(Z)V
    instance-of v0, v10, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;
    if-eqz v0, +01ch
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)Landroid/webkit/WebView;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    check-cast v10, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;->getUrl()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v10, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    goto +25h
    instance-of v0, v10, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$ServiceNotRunning;
    if-eqz v0, +010h
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_service_not_running I
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_service_stopped I
    const/4 v4, 0
    const/4 v5, 1
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->showError$default(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; I I Z Z I Ljava/lang/Object;)V
    goto +13h
    instance-of v10, v10, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
    if-eqz v10, +013h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_disconnected I
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_network_error_check_connection I
    const/4 v3, 1
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->showError$default(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; I I Z Z I Ljava/lang/Object;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
.end method
