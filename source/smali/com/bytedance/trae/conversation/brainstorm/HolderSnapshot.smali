# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
.super Ljava/lang/Object;
.source "HolderTypes.kt"

.field private final attachmentSubTaskEnabled:Z
.field private final cliConversationId:Ljava/lang/String;
.field private final discussionStartPerfReported:Z
.field private final originConversationId:Ljava/lang/String;
.field private final parentConversationId:Ljava/lang/String;
.field private final perfApiRequestStartMs:J
.field private final perfBotJoinedMs:J
.field private final perfIsNewSession:Z
.field private final perfJoinRoomStartMs:J
.field private final perfJoinRoomSuccessMs:J
.field private final perfMicCheckEndMs:J
.field private final perfMicCheckStartMs:J
.field private final sessionBotMessageCount:I
.field private final sessionBotSpeakStartTimestamps:Ljava/util/List;
.field private final sessionHasEverEnabledSubtitle:Z
.field private final sessionUserMessageCount:I
.field private final sessionUserSpeakEndTimestamps:Ljava/util/List;
.field private final uiState:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
.field private final voiceCliType:Lcom/bytedance/trae/im/service/CliType;
.field private final voiceDiscussionAttemptState:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
.field private final voiceMode:Lcom/bytedance/trae/im/service/Mode;


.method public constructor <init>(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  boolean  long  long  long  long  long  long  boolean  boolean  int  int  java.util.List  java.util.List  boolean  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState)void
    .registers 35
    # ins_size=28
    move-object v0, v7
    move-object v1, v8
    move-object v2, v12
    move-object v3, v13
    move-object/from16 v4, v31
    move-object/from16 v5, v32
    const-string/jumbo v6, uiState
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, voiceCliType
    invoke-static v12, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, voiceMode
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, sessionUserSpeakEndTimestamps
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, sessionBotSpeakStartTimestamps
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    move v1, v14
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    move-wide v1, v15
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    move-wide/from16 v1, v17
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    move-wide/from16 v1, v19
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    move-wide/from16 v1, v21
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    move-wide/from16 v1, v23
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    move-wide/from16 v1, v25
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    move/from16 v1, v27
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    move/from16 v1, v28
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    move/from16 v1, v29
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    move/from16 v1, v30
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    move/from16 v1, v33
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  boolean  long  long  long  long  long  long  boolean  boolean  int  int  java.util.List  java.util.List  boolean  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 61
    # ins_size=30
    move/from16 v0, v59
    and-int/lit8 v1, v0, 4
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v34
    and-int/lit8 v1, v0, 16
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v36
    and-int/lit8 v1, v0, 32
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v37
    and-int/lit8 v1, v0, 64
    const/4 v3, 1
    if-eqz v1, +004h
    move v10, v3
    goto +3h
    move/from16 v10, v38
    and-int/lit16 v1, v0, 128
    const-wide/16 v4, 0
    if-eqz v1, +004h
    move-wide v11, v4
    goto +3h
    move-wide/from16 v11, v39
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-wide v13, v4
    goto +3h
    move-wide/from16 v13, v41
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-wide v15, v4
    goto +3h
    move-wide/from16 v15, v43
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +005h
    move-wide/from16 v17, v4
    goto +3h
    move-wide/from16 v17, v45
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +005h
    move-wide/from16 v19, v4
    goto +3h
    move-wide/from16 v19, v47
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +005h
    move-wide/from16 v21, v4
    goto +3h
    move-wide/from16 v21, v49
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +005h
    move/from16 v23, v3
    goto +3h
    move/from16 v23, v51
    and-int/lit16 v1, v0, 16384
    const/4 v3, 0
    if-eqz v1, +005h
    move/from16 v24, v3
    goto +3h
    move/from16 v24, v52
    const v1, 32768
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v25, v3
    goto +3h
    move/from16 v25, v53
    const/high16 v1, 65536
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v26, v3
    goto +3h
    move/from16 v26, v54
    const/high16 v1, 131072
    and-int/2addr v1, v0
    if-eqz v1, +009h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    move-object/from16 v27, v1
    goto +3h
    move-object/from16 v27, v55
    const/high16 v1, 262144
    and-int/2addr v1, v0
    if-eqz v1, +009h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    move-object/from16 v28, v1
    goto +3h
    move-object/from16 v28, v56
    const/high16 v1, 524288
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v29, v3
    goto +3h
    move/from16 v29, v57
    const/high16 v1, 1048576
    and-int/2addr v0, v1
    if-eqz v0, +005h
    move-object/from16 v30, v2
    goto +3h
    move-object/from16 v30, v58
    move-object/from16 v3, v31
    move-object/from16 v4, v32
    move-object/from16 v5, v33
    move-object/from16 v7, v35
    invoke-direct/range v3 ... v30, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.HolderSnapshot  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  boolean  long  long  long  long  long  long  boolean  boolean  int  int  java.util.List  java.util.List  boolean  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.HolderSnapshot
    .registers 47
    # ins_size=30
    move-object/from16 v0, v17
    move/from16 v1, v45
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    goto +3h
    move/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-wide v9, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    goto +3h
    move-wide/from16 v9, v25
    and-int/lit16 v11, v1, 256
    if-eqz v11, +005h
    iget-wide v11, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    goto +3h
    move-wide/from16 v11, v27
    and-int/lit16 v13, v1, 512
    if-eqz v13, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    goto +3h
    move-wide/from16 v13, v29
    and-int/lit16 v15, v1, 1024
    move-wide/from16 v29, v13
    if-eqz v15, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    goto +3h
    move-wide/from16 v13, v31
    and-int/lit16 v15, v1, 2048
    move-wide/from16 v31, v13
    if-eqz v15, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    goto +3h
    move-wide/from16 v13, v33
    and-int/lit16 v15, v1, 4096
    move-wide/from16 v33, v13
    if-eqz v15, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    goto +3h
    move-wide/from16 v13, v35
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    goto +3h
    move/from16 v15, v37
    move/from16 v37, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    goto +3h
    move/from16 v15, v38
    const v16, 32768
    and-int v16, v1, v16
    move/from16 v38, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    goto +3h
    move/from16 v15, v39
    const/high16 v16, 65536
    and-int v16, v1, v16
    move/from16 v39, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    goto +3h
    move/from16 v15, v40
    const/high16 v16, 131072
    and-int v16, v1, v16
    move/from16 v40, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v41, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    goto +3h
    move-object/from16 v15, v42
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v42, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    goto +3h
    move/from16 v15, v43
    const/high16 v16, 1048576
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    goto +3h
    move-object/from16 v1, v44
    move-object/from16 v18, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move/from16 v24, v8
    move-wide/from16 v25, v9
    move-wide/from16 v27, v11
    move-wide/from16 v35, v13
    move/from16 v43, v15
    move-object/from16 v44, v1
    invoke-virtual/range v17 ... v44, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->copy(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;)Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    return-object v0
.end method

.method public final component10()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    return-wide v0
.end method

.method public final component11()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    return-wide v0
.end method

.method public final component12()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    return-wide v0
.end method

.method public final component13()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    return-wide v0
.end method

.method public final component14()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    return v0
.end method

.method public final component15()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    return v0
.end method

.method public final component16()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    return v0
.end method

.method public final component17()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    return v0
.end method

.method public final component18()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    return-object v0
.end method

.method public final component19()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component20()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    return v0
.end method

.method public final component21()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    return v0
.end method

.method public final component8()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    return-wide v0
.end method

.method public final component9()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    return-wide v0
.end method

.method public final copy(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  boolean  long  long  long  long  long  long  boolean  boolean  int  int  java.util.List  java.util.List  boolean  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState)com.bytedance.trae.conversation.brainstorm.HolderSnapshot
    .registers 58
    # ins_size=28
    move-object/from16 v1, v31
    move-object/from16 v2, v32
    move-object/from16 v3, v33
    move-object/from16 v4, v34
    move-object/from16 v5, v35
    move-object/from16 v6, v36
    move/from16 v7, v37
    move-wide/from16 v8, v38
    move-wide/from16 v10, v40
    move-wide/from16 v12, v42
    move-wide/from16 v14, v44
    move-wide/from16 v16, v46
    move-wide/from16 v18, v48
    move/from16 v20, v50
    move/from16 v21, v51
    move/from16 v22, v52
    move/from16 v23, v53
    move-object/from16 v24, v54
    move-object/from16 v25, v55
    move/from16 v26, v56
    move-object/from16 v27, v57
    const-string/jumbo v0, uiState
    move-object/from16 v28, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, voiceCliType
    move-object/from16 v1, v35
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, voiceMode
    move-object/from16 v1, v36
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionUserSpeakEndTimestamps
    move-object/from16 v1, v54
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionBotSpeakStartTimestamps
    move-object/from16 v1, v55
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v29, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-object/from16 v0, v29
    move-object/from16 v1, v28
    invoke-direct/range v0 ... v27, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;)V
    return-object v29
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAttachmentSubTaskEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    return v0
.end method

.method public final getCliConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getDiscussionStartPerfReported()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    return v0
.end method

.method public final getOriginConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getParentConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getPerfApiRequestStartMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    return-wide v0
.end method

.method public final getPerfBotJoinedMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    return-wide v0
.end method

.method public final getPerfIsNewSession()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    return v0
.end method

.method public final getPerfJoinRoomStartMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    return-wide v0
.end method

.method public final getPerfJoinRoomSuccessMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    return-wide v0
.end method

.method public final getPerfMicCheckEndMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    return-wide v0
.end method

.method public final getPerfMicCheckStartMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    return-wide v0
.end method

.method public final getSessionBotMessageCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    return v0
.end method

.method public final getSessionBotSpeakStartTimestamps()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    return-object v0
.end method

.method public final getSessionHasEverEnabledSubtitle()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    return v0
.end method

.method public final getSessionUserMessageCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    return v0
.end method

.method public final getSessionUserSpeakEndTimestamps()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    return-object v0
.end method

.method public final getUiState()com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    return-object v0
.end method

.method public final getVoiceCliType()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final getVoiceDiscussionAttemptState()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    return-object v0
.end method

.method public final getVoiceMode()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "HolderSnapshot(uiState="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->uiState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->cliConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", parentConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->parentConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", originConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->originConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", voiceCliType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", voiceMode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", attachmentSubTaskEnabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->attachmentSubTaskEnabled Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfMicCheckStartMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckStartMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfMicCheckEndMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfMicCheckEndMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfApiRequestStartMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfApiRequestStartMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfJoinRoomStartMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomStartMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfJoinRoomSuccessMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-wide v1, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfJoinRoomSuccessMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfBotJoinedMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfBotJoinedMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfIsNewSession="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->perfIsNewSession Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", discussionStartPerfReported="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->discussionStartPerfReported Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionUserMessageCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserMessageCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionBotMessageCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotMessageCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionUserSpeakEndTimestamps="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionUserSpeakEndTimestamps Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionBotSpeakStartTimestamps="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionBotSpeakStartTimestamps Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionHasEverEnabledSubtitle="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->sessionHasEverEnabledSubtitle Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", voiceDiscussionAttemptState="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->voiceDiscussionAttemptState Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
