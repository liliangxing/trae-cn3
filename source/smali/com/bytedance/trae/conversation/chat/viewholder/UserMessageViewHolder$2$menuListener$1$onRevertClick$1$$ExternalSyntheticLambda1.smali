# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/tracker/SoloChatMode;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$r8$lambda$_Q3jVqYhTQsoMidVRLvwj0vyKcg(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
