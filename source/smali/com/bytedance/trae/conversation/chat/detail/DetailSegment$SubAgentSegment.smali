# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
.super Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;
.source "DetailSegment.kt"

.field private final subAgent:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;


.method public constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, subAgent
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.detail.DetailSegment$SubAgentSegment  com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup  int  java.lang.Object)com.bytedance.trae.conversation.chat.detail.DetailSegment$SubAgentSegment
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->copy(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)com.bytedance.trae.conversation.chat.detail.DetailSegment$SubAgentSegment
    .registers 3
    # ins_size=2
    const-string/jumbo v0, subAgent
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getSubAgent()com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubAgentSegment(subAgent="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->subAgent Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
