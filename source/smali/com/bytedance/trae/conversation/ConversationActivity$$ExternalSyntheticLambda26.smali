# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda26;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/ConversationActivity;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda26;->f$0 Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda26;->f$1 Lcom/bytedance/trae/conversation/ConversationActivity;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda26;->f$0 Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda26;->f$1 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v3, Ljava/util/List;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->$r8$lambda$QIrszbT4p8KxUKsIoG5jcjON5Fc(Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
