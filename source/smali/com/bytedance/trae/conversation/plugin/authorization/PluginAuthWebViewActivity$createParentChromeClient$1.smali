# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;
.super Landroid/webkit/WebChromeClient;
.source "PluginAuthWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebChromeClient;-><init>()V
    return-void 
.end method

.method public onCloseWindow(android.webkit.WebView)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$getChildWebView$p(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)Landroid/webkit/WebView;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +007h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$destroyChildWebView(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    return-void 
.end method

.method public onCreateWindow(android.webkit.WebView  boolean  boolean  android.os.Message)boolean
    .registers 8
    # ins_size=5
    new-instance v4, Landroid/webkit/WebView;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    check-cast v5, Landroid/content/Context;
    invoke-direct v4, v5, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->getDecorViewBackgroundColor()I
    move-result v5
    invoke-virtual v4, v5, Landroid/webkit/WebView;->setBackgroundColor(I)V
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v5
    const/4 v6, 1
    invoke-virtual v5, v4, v6, Landroid/webkit/CookieManager;->setAcceptThirdPartyCookies(Landroid/webkit/WebView; Z)V
    invoke-virtual v4, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v5
    invoke-virtual v5, v6, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v5, v6, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    invoke-virtual v5, v6, Landroid/webkit/WebSettings;->setSupportMultipleWindows(Z)V
    invoke-virtual v5, v6, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V
    new-instance v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$2;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$2;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    check-cast v5, Landroid/webkit/WebViewClient;
    invoke-virtual v4, v5, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    new-instance v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$3;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1$onCreateWindow$3;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    check-cast v5, Landroid/webkit/WebChromeClient;
    invoke-virtual v4, v5, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-static v5, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$setChildWebView$p(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity; Landroid/webkit/WebView;)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;->this$0 Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->access$getWebViewContainer$p(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)Landroid/widget/FrameLayout;
    move-result-object v5
    if-eqz v5, +010h
    move-object v0, v4
    check-cast v0, Landroid/view/View;
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v2, -1
    invoke-direct v1, v2, v2, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v0, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v5, 0
    if-eqz v7, +005h
    iget-object v0, v7, Landroid/os/Message;->obj Ljava/lang/Object;
    goto +2h
    move-object v0, v5
    instance-of v1, v0, Landroid/webkit/WebView$WebViewTransport;
    if-eqz v1, +005h
    move-object v5, v0
    check-cast v5, Landroid/webkit/WebView$WebViewTransport;
    if-eqz v5, +005h
    invoke-virtual v5, v4, Landroid/webkit/WebView$WebViewTransport;->setWebView(Landroid/webkit/WebView;)V
    if-eqz v7, +005h
    invoke-virtual v7, Landroid/os/Message;->sendToTarget()V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "PluginAuthWebView"
    const-string v7, "onCreateWindow: child WebView created and attached"
    invoke-virtual v4, v5, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return v6
.end method
