# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "StickyBottomScroller.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;


.method constructor <init>(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V
    return-void 
.end method

.method public onScrollStateChanged(androidx.recyclerview.widget.RecyclerView  int)void
    .registers 4
    # ins_size=3
    const-string v0, "recyclerView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    if-eqz v3, +011h
    const/4 v0, 1
    if-eq v3, v0, +003h
    goto +22h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$setUserScrolling$p(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$setStickToBottom$p(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z)V
    goto +17h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$isUserScrolling$p(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)Z
    move-result v3
    if-eqz v3, +010h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$setUserScrolling$p(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$isAtBottom(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)Z
    move-result v3
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->access$setStickToBottom$p(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z)V
    return-void 
.end method
