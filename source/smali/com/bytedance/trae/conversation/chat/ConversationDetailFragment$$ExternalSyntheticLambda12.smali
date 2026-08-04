# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
.field public final synthetic f$2:Z
.field public final synthetic f$3:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$4:Z


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.ConversationDetailFragment  com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor  boolean  kotlin.jvm.functions.Function0  boolean)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$1 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$2 Z
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$3 Lkotlin/jvm/functions/Function0;
    iput-boolean v5, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$4 Z
    return-void 
.end method

.method public final run()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$1 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    iget-boolean v2, v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$2 Z
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$3 Lkotlin/jvm/functions/Function0;
    iget-boolean v4, v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;->f$4 Z
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->$r8$lambda$7e8KBgZxDCKxEatFFucDH1Lc1QE(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor; Z Lkotlin/jvm/functions/Function0; Z)V
    return-void 
.end method
