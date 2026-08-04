# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.detail.AgentDetailFragment  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda1;->f$1 I
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda1;->f$1 I
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->$r8$lambda$DstCt0-nRsh7QamcsdpuGKxY6dI(Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment; I Z)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
