# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$3;
.super Landroid/webkit/WebChromeClient;
.source "EnterpriseSsoWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$3;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebChromeClient;-><init>()V
    return-void 
.end method

.method public onProgressChanged(android.webkit.WebView  int)void
    .registers 5
    # ins_size=3
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$3;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$getPbLoading$p(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v3
    const/4 v0, 0
    const-string/jumbo v1, pbLoading
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, v4, Landroid/widget/ProgressBar;->setProgress(I)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$3;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$getPbLoading$p(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)Landroid/widget/ProgressBar;
    move-result-object v3
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    const/16 v3, 100
    if-ge v4, v3, +004h
    const/4 v3, 0
    goto +3h
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    return-void 
.end method
