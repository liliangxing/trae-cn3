# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda9;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.StickyBottomScroller  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda9;->f$1 I
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda9;->f$1 I
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->$r8$lambda$nHn2NP0MQrCKLmZpcvtXQ_X0-g0(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; I)V
    return-void 
.end method
