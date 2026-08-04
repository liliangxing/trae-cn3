# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;
.super Landroid/text/style/ClickableSpan;
.source "TraeRefClickableSpan.kt"

.field private final group:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
.field private final listener:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;


.method public constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefClickListener)void
    .registers 4
    # ins_size=3
    const-string v0, "group"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/text/style/ClickableSpan;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;->listener Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    return-void 
.end method

.method public onClick(android.view.View)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, widget
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;->listener Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    invoke-interface v0, v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;->onRefClick(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;)V
    return-void 
.end method

.method public updateDrawState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string v0, "ds"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setUnderlineText(Z)V
    return-void 
.end method
