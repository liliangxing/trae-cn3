# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
.super Ljava/lang/Object;
.source "ProcessDetailBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public final showAgentDetail(androidx.fragment.app.FragmentManager  com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 7
    # ins_size=3
    const-string v0, "fragmentManager"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroidx/fragment/app/FragmentManager;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->put(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "block_type"
    const-string v3, "agent_detail"
    invoke-virtual v1, v2, v3, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "block_key"
    invoke-virtual v1, v2, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->setArguments(Landroid/os/Bundle;)V
    const-string v6, "ProcessDetailBottomSheet"
    invoke-virtual v0, v5, v6, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
    :try_start_0x32
.end method

.method public final showToolList(androidx.fragment.app.FragmentManager  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)void
    .registers 7
    # ins_size=3
    const-string v0, "fragmentManager"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroidx/fragment/app/FragmentManager;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->put(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "block_type"
    const-string/jumbo v3, tool_list
    invoke-virtual v1, v2, v3, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "block_key"
    invoke-virtual v1, v2, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->setArguments(Landroid/os/Bundle;)V
    const-string v6, "ProcessDetailBottomSheet"
    invoke-virtual v0, v5, v6, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
    :try_start_0x33
.end method
