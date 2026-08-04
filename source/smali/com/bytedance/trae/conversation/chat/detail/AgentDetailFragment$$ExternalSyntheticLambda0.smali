# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.detail.AgentDetailFragment  com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->$r8$lambda$siEJZ8LyB53GFzLHLX57914L2bk(Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup; Landroid/view/View;)V
    return-void 
.end method
