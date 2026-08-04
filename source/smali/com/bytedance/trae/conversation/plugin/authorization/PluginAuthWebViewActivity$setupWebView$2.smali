# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;
.super Landroid/webkit/WebViewClient;
.source "PluginAuthWebViewActivity.kt"

.field final synthetic $url:Ljava/lang/String;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;->$url Ljava/lang/String;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    return-void 
.end method

.method public onPageFinished(android.webkit.WebView  java.lang.String)void
    .registers 4
    # ins_size=3
    invoke-super v1, v2, v3, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;->$url Ljava/lang/String;
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +009h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;->$url Ljava/lang/String;
    invoke-static v3, v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$injectBytecloudLocalStorage(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity; Landroid/webkit/WebView; Ljava/lang/String;)V
    return-void 
.end method

.method public shouldOverrideUrlLoading(android.webkit.WebView  android.webkit.WebResourceRequest)boolean
    .registers 3
    # ins_size=3
    if-eqz v2, +010h
    invoke-interface v2, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;
    move-result-object v1
    if-nez v1, +003h
    goto +8h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$handleUri(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity; Landroid/net/Uri;)Z
    move-result v1
    return v1
    const/4 v1, 0
    return v1
.end method
