# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
.field public final synthetic f$1:I
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.ConversationDetailFragment  int  com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;->f$1 I
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;->f$2 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;->f$1 I
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;->f$2 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->$r8$lambda$MO75z2KP0q5HptqaUWfDgrYDxaI(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; I Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;)V
    return-void 
.end method
