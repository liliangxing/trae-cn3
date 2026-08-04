# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MargeViewActivity$onCreate$4;
.super Landroid/webkit/WebChromeClient;
.source "MargeViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MargeViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MargeViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$onCreate$4;->this$0 Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    invoke-direct v0, Landroid/webkit/WebChromeClient;-><init>()V
    return-void 
.end method

.method public onProgressChanged(android.webkit.WebView  int)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v2, 100
    if-ne v3, v2, +02ah
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$onCreate$4;->this$0 Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/MargeViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +008h
    const-string v2, "progressBar"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$onCreate$4;->this$0 Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/products/MargeViewActivity;)Landroid/webkit/WebView;
    move-result-object v2
    if-nez v2, +009h
    const-string/jumbo v2, webView
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    const/4 v2, 0
    invoke-virtual v3, v2, Landroid/webkit/WebView;->setVisibility(I)V
    return-void 
.end method
