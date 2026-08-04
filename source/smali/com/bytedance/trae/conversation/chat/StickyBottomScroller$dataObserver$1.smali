# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;
.super Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;
.source "StickyBottomScroller.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;


.method constructor <init>(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;-><init>()V
    return-void 
.end method

.method public onChanged()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$handleDataChanged(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public onItemRangeChanged(int  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$handleDataChanged(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public onItemRangeInserted(int  int)void
    .registers 3
    # ins_size=3
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$handleDataChanged(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method
