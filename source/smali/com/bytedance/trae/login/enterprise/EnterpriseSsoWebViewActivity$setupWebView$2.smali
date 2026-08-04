# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;
.super Landroid/webkit/WebViewClient;
.source "EnterpriseSsoWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    return-void 
.end method

.method public onPageStarted(android.webkit.WebView  java.lang.String  android.graphics.Bitmap)void
    .registers 4
    # ins_size=4
    if-eqz v2, +01bh
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    if-nez v2, +003h
    goto +13h
    iget-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$isSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity; Landroid/net/Uri;)Z
    move-result v2
    if-eqz v2, +00ch
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/webkit/WebView;->stopLoading()V
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$handleSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    return-void 
.end method

.method public onReceivedError(android.webkit.WebView  android.webkit.WebResourceRequest  android.webkit.WebResourceError)void
    .registers 4
    # ins_size=4
    if-eqz v2, +016h
    invoke-interface v2, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;
    move-result-object v1
    if-nez v1, +003h
    goto +eh
    iget-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$isSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity; Landroid/net/Uri;)Z
    move-result v1
    if-eqz v1, +007h
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$handleSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    return-void 
.end method

.method public shouldOverrideUrlLoading(android.webkit.WebView  android.webkit.WebResourceRequest)boolean
    .registers 6
    # ins_size=3
    const/4 v4, 0
    if-eqz v5, +03bh
    invoke-interface v5, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;
    move-result-object v5
    if-nez v5, +003h
    goto +33h
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$isSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity; Landroid/net/Uri;)Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +008h
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$handleSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    return v1
    invoke-virtual v5, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01fh
    const-string v2, "http"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +017h
    const-string v2, "https"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00fh
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    new-instance v0, Landroid/content/Intent;
    const-string v2, "android.intent.action.VIEW"
    invoke-direct v0, v2, v5, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->startActivity(Landroid/content/Intent;)V
    return v1
    return v4
    :try_start_0x2f
.end method

.method public shouldOverrideUrlLoading(android.webkit.WebView  java.lang.String)boolean
    .registers 6
    # ins_size=3
    const/4 v4, 0
    if-eqz v5, +03bh
    invoke-static v5, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v5
    if-nez v5, +003h
    goto +33h
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$isSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity; Landroid/net/Uri;)Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +008h
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$handleSsoCallback(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    return v1
    invoke-virtual v5, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01fh
    const-string v2, "http"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +017h
    const-string v2, "https"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00fh
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    new-instance v0, Landroid/content/Intent;
    const-string v2, "android.intent.action.VIEW"
    invoke-direct v0, v2, v5, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->startActivity(Landroid/content/Intent;)V
    return v1
    return v4
    :try_start_0x2f
.end method
