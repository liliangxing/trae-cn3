# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$3;
.super Landroid/webkit/WebChromeClient;
.source "PluginAuthWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$3;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebChromeClient;-><init>()V
    return-void 
.end method

.method public onCloseWindow(android.webkit.WebView)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$3;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$destroyChildWebView(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    return-void 
.end method
