# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final agentAvatarId:Ljava/lang/String;
.field private final agentName:Ljava/lang/String;
.field private final agentType:Ljava/lang/String;
.field private final cliType:Ljava/lang/String;
.field private final createdAt:J
.field private final isExpressPass:Ljava/lang/Boolean;
.field private final messageId:Ljava/lang/String;
.field private final replyToMessageId:Ljava/lang/String;
.field private final sessionId:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  long)void
    .registers 12
    # ins_size=11
    const-string v0, "messageId"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    iput-wide v10, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 27
    # ins_size=13
    move/from16 v0, v25
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v1, v0, 16
    const-string v3, ""
    if-eqz v1, +004h
    move-object v8, v3
    goto +3h
    move-object/from16 v8, v19
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v3
    goto +3h
    move-object/from16 v9, v20
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +009h
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    move-object v11, v1
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v0, v0, 256
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v12, v0
    goto +3h
    move-wide/from16 v12, v23
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    invoke-direct/range v3 ... v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; J)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Avatar  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  long  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Avatar
    .registers 25
    # ins_size=13
    move-object v0, v12
    move/from16 v1, v23
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v19
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    goto +3h
    move-wide/from16 v10, v21
    move-object v13, v2
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    move-object/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-wide/from16 v21, v10
    invoke-virtual/range v12 ... v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; J)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component9()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    return-wide v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  long)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Avatar
    .registers 23
    # ins_size=11
    const-string v0, "messageId"
    move-object/from16 v6, v17
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    move-object/from16 v7, v18
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    move-object v1, v0
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v8, v19
    move-object/from16 v9, v20
    move-wide/from16 v10, v21
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getAgentAvatarId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getCliType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    return-wide v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getReplyToMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isExpressPass()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Avatar(agentName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentAvatarId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentAvatarId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->agentType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cliType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->cliType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->sessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", replyToMessageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->replyToMessageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isExpressPass="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createdAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->createdAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
