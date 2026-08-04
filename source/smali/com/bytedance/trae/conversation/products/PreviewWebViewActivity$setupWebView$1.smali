# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;
.super Landroid/webkit/WebChromeClient;
.source "PreviewWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.PreviewWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebChromeClient;-><init>()V
    return-void 
.end method

.method public onProgressChanged(android.webkit.WebView  int)void
    .registers 6
    # ins_size=3
    const/4 v4, 0
    const/4 v0, 1
    if-gt v0, v5, +007h
    const/16 v1, 100
    if-ge v5, v1, +003h
    goto +2h
    move v0, v4
    const/4 v1, 0
    const-string v2, "progressBar"
    if-eqz v0, +031h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v4, Landroid/widget/ProgressBar;->setIndeterminate(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v4, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    invoke-virtual v1, v5, Landroid/widget/ProgressBar;->setProgress(I)V
    goto +13h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    const/16 v4, 8
    invoke-virtual v1, v4, Landroid/widget/ProgressBar;->setVisibility(I)V
    return-void 
.end method
