# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;
.super Ljava/lang/Object;
.source "PureShowWidgetInlineView.kt"

.implements Ljava/lang/Runnable;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public run()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->isAttachedToWindow()Z
    move-result v0
    if-eqz v0, +045h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getLoadingContainer$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)Landroid/widget/LinearLayout;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v0
    if-nez v0, +039h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getCurrentLoadingMessages$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    if-gt v0, v1, +003h
    goto +2ah
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getLoadingMessageIndex$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)I
    move-result v2
    add-int/2addr v2, v1
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getCurrentLoadingMessages$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    rem-int/2addr v2, v1
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$setLoadingMessageIndex$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$updateLoadingMessage(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getHandler$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)Landroid/os/Handler;
    move-result-object v0
    move-object v1, v4
    check-cast v1, Ljava/lang/Runnable;
    const-wide/16 v2, 3000
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$setLoadingMessageRotationActive$p(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Z)V
    return-void 
.end method
