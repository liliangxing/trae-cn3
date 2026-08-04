# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
.field public final synthetic f$1:I
.field public final synthetic f$2:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/tracker/SoloChatMode;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  int  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$1 I
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$2 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$3 Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$1 I
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$2 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;->f$3 Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->$r8$lambda$95piRekkOZlNjgRVarTEHf-1CSo(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; I Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
