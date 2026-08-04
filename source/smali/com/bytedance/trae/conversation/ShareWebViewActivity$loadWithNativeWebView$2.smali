# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ShareWebViewActivity$loadWithNativeWebView$2;
.super Landroid/webkit/WebViewClient;
.source "ShareWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/ShareWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.ShareWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$loadWithNativeWebView$2;->this$0 Lcom/bytedance/trae/conversation/ShareWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    return-void 
.end method

.method public shouldOverrideUrlLoading(android.webkit.WebView  android.webkit.WebResourceRequest)boolean
    .registers 5
    # ins_size=3
    const/4 v3, 0
    if-eqz v4, +026h
    invoke-interface v4, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;
    move-result-object v4
    if-nez v4, +003h
    goto +1eh
    sget-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v4, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    return v3
    iget-object v3, v2, Lcom/bytedance/trae/conversation/ShareWebViewActivity$loadWithNativeWebView$2;->this$0 Lcom/bytedance/trae/conversation/ShareWebViewActivity;
    invoke-virtual v4, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v0, toString(...)
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->access$openInSystemBrowser(Lcom/bytedance/trae/conversation/ShareWebViewActivity; Ljava/lang/String;)V
    const/4 v3, 1
    return v3
.end method
