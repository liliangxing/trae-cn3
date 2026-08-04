# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.super Ljava/lang/Object;
.source "VoiceChatModels.kt"

.field private final appId:Ljava/lang/String;
.field private final botName:Ljava/lang/String;
.field private final botUserId:Ljava/lang/String;
.field private final roomId:Ljava/lang/String;
.field private final subTaskConfig:Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
.field private final taskExpireAt:Ljava/lang/Long;
.field private final taskId:Ljava/lang/String;
.field private final token:Ljava/lang/String;
.field private final userId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 13
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 511
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=12
    move/from16 v0, v20
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v11
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v0, v0, 256
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v19
    move-object v11, v10
    move-object v12, v1
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v2
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.network.StartVoiceChatData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig  int  java.lang.Object)com.bytedance.trae.conversation.voice.network.StartVoiceChatData
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    goto +3h
    move-object/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v9
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;)Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component9()com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig)com.bytedance.trae.conversation.voice.network.StartVoiceChatData
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-object v0, v10
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    move-object/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAppId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    return-object v0
.end method

.method public final getBotName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    return-object v0
.end method

.method public final getBotUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    return-object v0
.end method

.method public final getRoomId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    return-object v0
.end method

.method public final getSubTaskConfig()com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    return-object v0
.end method

.method public final getTaskExpireAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final getToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "StartVoiceChatData(appId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->appId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", roomId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->roomId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", token="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->token Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", botName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", botUserId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->botUserId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskExpireAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->taskExpireAt Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", subTaskConfig="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
