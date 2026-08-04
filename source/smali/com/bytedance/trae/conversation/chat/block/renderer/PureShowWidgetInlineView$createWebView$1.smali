# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;
.super Landroid/webkit/WebViewClient;
.source "PureShowWidgetInlineView.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    return-void 
.end method

.method public onPageFinished(android.webkit.WebView  java.lang.String)void
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getReleased$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)Z
    move-result v2
    if-nez v2, +01fh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getWebView$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)Landroid/webkit/WebView;
    move-result-object v2
    if-eq v1, v2, +003h
    goto +15h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->isAttachedToWindow()Z
    move-result v1
    if-nez v1, +009h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    const/4 v2, 1
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$setPendingHeightChecksAfterAttach$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Z)V
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$scheduleHeightChecks(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    return-void 
.end method

.method public onRenderProcessGone(android.webkit.WebView  android.webkit.RenderProcessGoneDetail)boolean
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "detail"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-virtual v3, Landroid/webkit/RenderProcessGoneDetail;->didCrash()Z
    move-result v3
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$handleRenderProcessGone(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/webkit/WebView; Z)V
    const/4 v2, 1
    return v2
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
