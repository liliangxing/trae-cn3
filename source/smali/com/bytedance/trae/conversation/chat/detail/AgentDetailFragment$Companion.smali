# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;
.super Ljava/lang/Object;
.source "AgentDetailFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)com.bytedance.trae.conversation.chat.detail.AgentDetailFragment
    .registers 3
    # ins_size=2
    const-string v0, "block"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->put(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    move-result-object v2
    return-object v2
.end method

.method public final newInstance(java.lang.String)com.bytedance.trae.conversation.chat.detail.AgentDetailFragment
    .registers 5
    # ins_size=2
    const-string v0, "blockKey"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "block_key"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
