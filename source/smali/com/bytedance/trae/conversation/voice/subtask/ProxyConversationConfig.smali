# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
.super Ljava/lang/Object;
.source "SubTaskProtocol.kt"

.field private final cliId:Ljava/lang/String;
.field private final cliType:Lcom/bytedance/trae/im/service/CliType;
.field private final createRemoteParentSession:Z
.field private final mode:Lcom/bytedance/trae/im/service/Mode;
.field private final parentAgentType:Ljava/lang/String;
.field private final parentConversationId:Ljava/lang/String;
.field private final source:Lcom/bytedance/trae/im/service/Source;
.field private final voiceConversationId:Ljava/lang/String;
.field private final workspaceDir:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  boolean  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source)void
    .registers 11
    # ins_size=10
    const-string/jumbo v0, voiceConversationId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  boolean  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 25
    # ins_size=12
    move/from16 v0, v23
    and-int/lit8 v1, v0, 2
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v15
    and-int/lit8 v1, v0, 4
    if-eqz v1, +005h
    const/4 v1, 0
    move v6, v1
    goto +3h
    move/from16 v6, v16
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v21
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v22
    move-object v3, v13
    move-object v4, v14
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    move-object/from16 v9, v19
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  java.lang.String  java.lang.String  boolean  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source  int  java.lang.Object)com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    goto +2h
    move v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    goto +3h
    move-object/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v9
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->copy(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source;)Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    return-object v0
.end method

.method public final component9()com.bytedance.trae.im.service.Source
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  boolean  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source)com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig
    .registers 21
    # ins_size=10
    const-string/jumbo v0, voiceConversationId
    move-object v2, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    move-object/from16 v6, v16
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    move-object/from16 v7, v17
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    move-object v1, v0
    move-object v3, v13
    move v4, v14
    move-object v5, v15
    move-object/from16 v8, v18
    move-object/from16 v9, v19
    move-object/from16 v10, v20
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getCliType()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final getCreateRemoteParentSession()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    return v0
.end method

.method public final getMode()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public final getParentAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    return-object v0
.end method

.method public final getParentConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getSource()com.bytedance.trae.im.service.Source
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    return-object v0
.end method

.method public final getVoiceConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getWorkspaceDir()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Source;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ProxyConversationConfig(voiceConversationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->voiceConversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", parentConversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentConversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createRemoteParentSession="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->createRemoteParentSession Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cliId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cliType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", parentAgentType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->parentAgentType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", workspaceDir="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->workspaceDir Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", source="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->source Lcom/bytedance/trae/im/service/Source;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
