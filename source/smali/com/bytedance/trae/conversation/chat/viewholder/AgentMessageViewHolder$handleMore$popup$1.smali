# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;
.super Ljava/lang/Object;
.source "AgentMessageViewHolder.kt"

.implements Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;

.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;


.method constructor <init>(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onReportClick()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->access$showReportConfirmation(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    return-void 
.end method

.method public onRetryClick()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->getOnRetryClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +00bh
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
