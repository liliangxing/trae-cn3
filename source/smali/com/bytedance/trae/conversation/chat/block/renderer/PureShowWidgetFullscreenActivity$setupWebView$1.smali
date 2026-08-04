# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$setupWebView$1;
.super Landroid/webkit/WebViewClient;
.source "PureShowWidgetFullscreenActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    return-void 
.end method

.method public onRenderProcessGone(android.webkit.WebView  android.webkit.RenderProcessGoneDetail)boolean
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "detail"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Fullscreen] WebView render process gone, didCrash="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Landroid/webkit/RenderProcessGoneDetail;->didCrash()Z
    move-result v5
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v1, "PureShowWidget"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->access$getWebView$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;)Landroid/webkit/WebView;
    move-result-object v5
    const/4 v0, 0
    if-ne v4, v5, +007h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;
    invoke-static v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->access$setWebView$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity; Landroid/webkit/WebView;)V
    invoke-virtual v4, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;
    move-result-object v5
    instance-of v1, v5, Landroid/view/ViewGroup;
    if-eqz v1, +005h
    move-object v0, v5
    check-cast v0, Landroid/view/ViewGroup;
    if-eqz v0, +008h
    move-object v5, v4
    check-cast v5, Landroid/view/View;
    invoke-virtual v0, v5, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    invoke-virtual v4, Landroid/webkit/WebView;->destroy()V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$setupWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->finish()V
    const/4 v4, 1
    return v4
.end method

.method public shouldOverrideUrlLoading(android.webkit.WebView  android.webkit.WebResourceRequest)boolean
    .registers 3
    # ins_size=3
    const/4 v1, 1
    return v1
.end method

.method public shouldOverrideUrlLoading(android.webkit.WebView  java.lang.String)boolean
    .registers 3
    # ins_size=3
    const/4 v1, 1
    return v1
.end method
