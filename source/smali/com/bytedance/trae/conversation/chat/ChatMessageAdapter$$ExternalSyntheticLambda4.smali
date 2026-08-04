# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnLongClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field public final synthetic f$2:I


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.ChatMessageAdapter  com.bytedance.trae.im.model.ParsedChatMessage  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;->f$2 I
    return-void 
.end method

.method public final onLongClick(android.view.View)boolean
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;->f$2 I
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->$r8$lambda$MYpiezSnQ35Vo9A3fbeDwY9B870(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Lcom/bytedance/trae/im/model/ParsedChatMessage; I Landroid/view/View;)Z
    move-result v4
    return v4
.end method
