# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationViewModel)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    return-void 
.end method

.method public final onStreamingMessage(com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->$r8$lambda$F8-xlKjHGu51kmnupT_aPHttNv0(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    return-void 
.end method
