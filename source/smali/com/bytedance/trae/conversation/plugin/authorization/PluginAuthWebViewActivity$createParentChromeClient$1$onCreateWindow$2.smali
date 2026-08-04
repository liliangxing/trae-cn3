# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$2;
.super Landroid/webkit/WebViewClient;
.source "PluginAuthWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$2;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
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
    iget-object v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$2;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$handleUri(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity; Landroid/net/Uri;)Z
    move-result v1
    return v1
    const/4 v1, 0
    return v1
.end method
