# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;
.super Ljava/lang/Object;
.source "ToolListFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Toolcall)com.bytedance.trae.conversation.chat.detail.ToolListFragment
    .registers 6
    # ins_size=2
    const-string v0, "block"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    move-object v1, v5
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->put(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[ToolList] newInstance(Toolcall): key="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", toolName="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "AgentTool"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    move-result-object v5
    return-object v5
.end method

.method public final newInstance(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)com.bytedance.trae.conversation.chat.detail.ToolListFragment
    .registers 6
    # ins_size=2
    const-string v0, "block"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    move-object v1, v5
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->put(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[ToolList] newInstance(ToolcallGroup): key="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", toolcalls="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getToolcalls()Ljava/util/List;
    move-result-object v5
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "AgentTool"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    move-result-object v5
    return-object v5
.end method

.method public final newInstance(java.lang.String)com.bytedance.trae.conversation.chat.detail.ToolListFragment
    .registers 5
    # ins_size=2
    const-string v0, "blockKey"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[ToolList] newInstance: blockKey="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentTool"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "block_key"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
