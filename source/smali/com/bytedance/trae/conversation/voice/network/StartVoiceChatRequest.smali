# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;
.super Ljava/lang/Object;
.source "VoiceChatModels.kt"

.field private final agentConfig:Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
.field private final botUserId:Ljava/lang/String;
.field private final configOnly:Z
.field private final roomId:Ljava/lang/String;
.field private final sceneId:Ljava/lang/String;
.field private final taskId:Ljava/lang/String;
.field private final token:Ljava/lang/String;
.field private final userId:Ljava/lang/String;


.method public constructor <init>(java.lang.String  boolean  com.bytedance.trae.conversation.voice.network.AgentConfig  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, sceneId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "agentConfig"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  com.bytedance.trae.conversation.voice.network.AgentConfig  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 19
    # ins_size=11
    move/from16 v0, v17
    and-int/lit8 v1, v0, 2
    const/4 v2, 0
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v10
    and-int/lit8 v3, v0, 4
    const/4 v4, 0
    if-eqz v3, +009h
    new-instance v3, Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    const/4 v5, 1
    invoke-direct v3, v2, v5, v4, Lcom/bytedance/trae/conversation/voice/network/AgentConfig;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +2h
    move-object v3, v11
    and-int/lit8 v2, v0, 8
    if-eqz v2, +004h
    move-object v2, v4
    goto +2h
    move-object v2, v12
    and-int/lit8 v5, v0, 16
    if-eqz v5, +004h
    move-object v5, v4
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v0, 32
    if-eqz v6, +004h
    move-object v6, v4
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v0, 64
    if-eqz v7, +004h
    move-object v7, v4
    goto +2h
    move-object v7, v15
    and-int/lit16 v0, v0, 128
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v4, v16
    move-object v10, v8
    move-object v11, v9
    move v12, v1
    move-object v13, v3
    move-object v14, v2
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-object/from16 v18, v4
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;-><init>(Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/network/AgentConfig; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.network.StartVoiceChatRequest  java.lang.String  boolean  com.bytedance.trae.conversation.voice.network.AgentConfig  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.voice.network.StartVoiceChatRequest
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    goto +2h
    move v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v17
    move-object v10, v2
    move v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    move-object/from16 v16, v8
    move-object/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->copy(Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/network/AgentConfig; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    return v0
.end method

.method public final component3()com.bytedance.trae.conversation.voice.network.AgentConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  boolean  com.bytedance.trae.conversation.voice.network.AgentConfig  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.voice.network.StartVoiceChatRequest
    .registers 19
    # ins_size=9
    const-string/jumbo v0, sceneId
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "agentConfig"
    move-object v4, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;
    move-object v1, v0
    move v3, v12
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    move-object/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;-><init>(Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/network/AgentConfig; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAgentConfig()com.bytedance.trae.conversation.voice.network.AgentConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    return-object v0
.end method

.method public final getBotUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    return-object v0
.end method

.method public final getConfigOnly()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    return v0
.end method

.method public final getRoomId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    return-object v0
.end method

.method public final getSceneId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final getToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/network/AgentConfig;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "StartVoiceChatRequest(sceneId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->sceneId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", configOnly="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->configOnly Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentConfig="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->agentConfig Lcom/bytedance/trae/conversation/voice/network/AgentConfig;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", roomId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->roomId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", token="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->token Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", botUserId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;->botUserId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
