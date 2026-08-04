# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final agentDisplayName:Ljava/lang/String;
.field private final agentId:Ljava/lang/String;
.field private final agentRunId:Ljava/lang/String;
.field private final children:Ljava/util/List;
.field private final description:Ljava/lang/String;
.field private final isLastRunningSubAgent:Z
.field private final status:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus  boolean)void
    .registers 9
    # ins_size=8
    const-string v0, "agentRunId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    iput-boolean v8, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 32
    if-eqz v0, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-object v7, v0
    goto +2h
    move-object v7, v15
    and-int/lit8 v0, v17, 64
    if-eqz v0, +005h
    const/4 v0, 0
    move v8, v0
    goto +3h
    move/from16 v8, v16
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-boolean v12, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    move v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus  boolean)com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup
    .registers 17
    # ins_size=8
    const-string v0, "agentRunId"
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    move-object v6, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    move-object v1, v0
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAgentDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentRunId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    return-object v0
.end method

.method public final getChildren()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    return-object v0
.end method

.method public final getDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isLastRunningSubAgent()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubAgentGroup(agentRunId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentRunId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentDisplayName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->agentDisplayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", description="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->description Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", children="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->children Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isLastRunningSubAgent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->isLastRunningSubAgent Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
