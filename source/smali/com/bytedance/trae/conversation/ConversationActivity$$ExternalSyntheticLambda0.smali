# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/ConversationActivity;


.method public synthetic constructor <init>(com.bytedance.trae.im.service.IMService$DeleteMessagePushPayload  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/ConversationActivity;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->$r8$lambda$6dqdmktIKUqudSBhjow9Js00xpI(Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method
