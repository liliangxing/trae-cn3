# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "ConversationDetailFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;


.method constructor <init>(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V
    return-void 
.end method

.method public onScrollStateChanged(androidx.recyclerview.widget.RecyclerView  int)void
    .registers 4
    # ins_size=3
    const-string v0, "recyclerView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    if-ne v3, v2, +00dh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getOnUserScrolled()Lkotlin/jvm/functions/Function0;
    move-result-object v2
    if-eqz v2, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    if-nez v3, +011h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$updateScrollToBottomVisibility(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$maybeLoadOlderAtTop(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$maybeLoadNewerAtBottom(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    return-void 
.end method
