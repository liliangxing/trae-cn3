# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda10;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationViewModel)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    return-void 
.end method

.method public final onMetadataDone(java.lang.String  java.lang.String  com.bytedance.trae.im.service.UserMessageContext)void
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->$r8$lambda$GlRakyJbegTt9_HoMR3YAho06P0(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext;)V
    return-void 
.end method
