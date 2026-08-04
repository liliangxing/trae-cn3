# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda41;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda41;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    return-void 
.end method

.method public final onConversationChanged(com.bytedance.trae.im.service.IMService$ConversationChangeEvent)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda41;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->$r8$lambda$gnY9y5_9iNXII9lrbkzCD17VpxU(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    return-void 
.end method
