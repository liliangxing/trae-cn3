# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/ParsedChatMessage;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->$r8$lambda$zVjxkL2TMcgh37lTxThT47yOXF4(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
