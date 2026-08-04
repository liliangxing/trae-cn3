# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
.super Ljava/lang/Object;
.source "BrainstormUiState.kt"

.field private final aiParticipantState:Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
.field private final aiReplyState:Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
.field private final aiStageDescription:Ljava/lang/String;
.field private final attachments:Ljava/util/List;
.field private final botTranscript:Ljava/lang/String;
.field private final currentAudioDevice:Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
.field private final currentTranscript:Ljava/lang/String;
.field private final finishedSubTasks:Ljava/util/Map;
.field private final isMicMuted:Z
.field private final isRtcJoined:Z
.field private final isSpeakerOn:Z
.field private final isSubtitleMode:Z
.field private final phase:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
.field private final recordingState:Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
.field private final sessionElapsedMs:J
.field private final sessionStartTimeMs:J
.field private final subTask:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
.field private final subtitleHistory:Ljava/util/List;
.field private final summary:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
.field private final timeoutRemainingSeconds:I
.field private final timeoutState:Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
.field private final userParticipantState:Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;


.method public constructor <init>()void
    .registers 28
    # ins_size=1
    move-object/from16 v0, v27
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-wide/16 v14, 0
    const-wide/16 v16, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const v25, 4194303
    const/16 v26, 0
    invoke-direct/range v0 ... v26, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase  java.util.List  com.bytedance.trae.conversation.brainstorm.model.RecordingState  com.bytedance.trae.conversation.brainstorm.model.AiReplyState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary  long  long  com.bytedance.trae.conversation.brainstorm.model.TimeoutState  int  java.lang.String  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.util.Map  java.util.List)void
    .registers 40
    # ins_size=25
    move-object v0, v15
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move-object/from16 v3, v18
    move-object/from16 v4, v19
    move-object/from16 v5, v20
    move-object/from16 v6, v21
    move-object/from16 v7, v22
    move-object/from16 v8, v23
    move-object/from16 v9, v24
    move-object/from16 v10, v33
    move-object/from16 v11, v35
    move-object/from16 v12, v38
    move-object/from16 v13, v39
    const-string v14, "phase"
    invoke-static v1, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v14, subtitleHistory
    invoke-static v2, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "recordingState"
    invoke-static v3, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "aiReplyState"
    invoke-static v4, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "aiParticipantState"
    invoke-static v5, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v14, userParticipantState
    invoke-static v6, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "currentTranscript"
    invoke-static v7, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "botTranscript"
    invoke-static v8, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "currentAudioDevice"
    invoke-static v9, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v14, timeoutState
    invoke-static v10, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "aiStageDescription"
    invoke-static v11, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "finishedSubTasks"
    invoke-static v12, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v14, "attachments"
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v15, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move/from16 v1, v25
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    move/from16 v1, v26
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    move/from16 v1, v27
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    move-wide/from16 v1, v29
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    move-wide/from16 v1, v31
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    iput-object v10, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    move/from16 v1, v34
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    iput-object v11, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    move/from16 v1, v36
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    move-object/from16 v1, v37
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase  java.util.List  com.bytedance.trae.conversation.brainstorm.model.RecordingState  com.bytedance.trae.conversation.brainstorm.model.AiReplyState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary  long  long  com.bytedance.trae.conversation.brainstorm.model.TimeoutState  int  java.lang.String  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.util.Map  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 52
    # ins_size=27
    move/from16 v0, v50
    and-int/lit8 v1, v0, 1
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Intro Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    goto +3h
    move-object/from16 v1, v26
    and-int/lit8 v2, v0, 2
    if-eqz v2, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    goto +3h
    move-object/from16 v2, v27
    and-int/lit8 v3, v0, 4
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    goto +3h
    move-object/from16 v3, v28
    and-int/lit8 v4, v0, 8
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    goto +3h
    move-object/from16 v4, v29
    and-int/lit8 v5, v0, 16
    if-eqz v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    goto +3h
    move-object/from16 v5, v30
    and-int/lit8 v6, v0, 32
    if-eqz v6, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    goto +3h
    move-object/from16 v6, v31
    and-int/lit8 v7, v0, 64
    const-string v8, ""
    if-eqz v7, +004h
    move-object v7, v8
    goto +3h
    move-object/from16 v7, v32
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v8
    goto +3h
    move-object/from16 v9, v33
    and-int/lit16 v10, v0, 256
    if-eqz v10, +005h
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Speaker Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    goto +3h
    move-object/from16 v10, v34
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    const/4 v11, 1
    goto +3h
    move/from16 v11, v35
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move/from16 v12, v36
    and-int/lit16 v14, v0, 2048
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move/from16 v14, v37
    and-int/lit16 v15, v0, 4096
    const/16 v16, 0
    if-eqz v15, +005h
    move-object/from16 v15, v16
    goto +3h
    move-object/from16 v15, v38
    and-int/lit16 v13, v0, 8192
    if-eqz v13, +007h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v17
    goto +3h
    move-wide/from16 v17, v39
    and-int/lit16 v13, v0, 16384
    if-eqz v13, +005h
    const-wide/16 v19, 0
    goto +3h
    move-wide/from16 v19, v41
    const v13, 32768
    and-int/2addr v13, v0
    if-eqz v13, +005h
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Normal Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    goto +3h
    move-object/from16 v13, v43
    const/high16 v21, 65536
    and-int v21, v0, v21
    if-eqz v21, +005h
    const/16 v21, -1
    goto +3h
    move/from16 v21, v44
    const/high16 v22, 131072
    and-int v22, v0, v22
    if-eqz v22, +003h
    goto +3h
    move-object/from16 v8, v45
    const/high16 v22, 262144
    and-int v22, v0, v22
    if-eqz v22, +005h
    const/16 v22, 0
    goto +3h
    move/from16 v22, v46
    const/high16 v23, 524288
    and-int v23, v0, v23
    if-eqz v23, +003h
    goto +3h
    move-object/from16 v16, v47
    const/high16 v23, 1048576
    and-int v23, v0, v23
    if-eqz v23, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v23
    goto +3h
    move-object/from16 v23, v48
    const/high16 v24, 2097152
    and-int v0, v0, v24
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    goto +3h
    move-object/from16 v0, v49
    move-object/from16 v26, v25
    move-object/from16 v27, v1
    move-object/from16 v28, v2
    move-object/from16 v29, v3
    move-object/from16 v30, v4
    move-object/from16 v31, v5
    move-object/from16 v32, v6
    move-object/from16 v33, v7
    move-object/from16 v34, v9
    move-object/from16 v35, v10
    move/from16 v36, v11
    move/from16 v37, v12
    move/from16 v38, v14
    move-object/from16 v39, v15
    move-wide/from16 v40, v17
    move-wide/from16 v42, v19
    move-object/from16 v44, v13
    move/from16 v45, v21
    move-object/from16 v46, v8
    move/from16 v47, v22
    move-object/from16 v48, v16
    move-object/from16 v49, v23
    move-object/from16 v50, v0
    invoke-direct/range v26 ... v50, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase  java.util.List  com.bytedance.trae.conversation.brainstorm.model.RecordingState  com.bytedance.trae.conversation.brainstorm.model.AiReplyState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary  long  long  com.bytedance.trae.conversation.brainstorm.model.TimeoutState  int  java.lang.String  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.util.Map  java.util.List  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState
    .registers 44
    # ins_size=27
    move-object/from16 v0, v17
    move/from16 v1, v42
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-boolean v11, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    goto +3h
    move/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-boolean v12, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    goto +3h
    move/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-boolean v13, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    goto +3h
    move/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    move-object/from16 v30, v14
    if-eqz v15, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    goto +3h
    move-wide/from16 v14, v31
    move-wide/from16 v31, v14
    and-int/lit16 v14, v1, 16384
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    goto +3h
    move-wide/from16 v14, v33
    const v16, 32768
    and-int v16, v1, v16
    move-wide/from16 v33, v14
    if-eqz v16, +005h
    iget-object v14, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    goto +3h
    move-object/from16 v14, v35
    const/high16 v15, 65536
    and-int/2addr v15, v1
    if-eqz v15, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    goto +3h
    move/from16 v15, v36
    const/high16 v16, 131072
    and-int v16, v1, v16
    move/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    goto +3h
    move/from16 v15, v38
    const/high16 v16, 524288
    and-int v16, v1, v16
    move/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v16, 2097152
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    goto +3h
    move-object/from16 v1, v41
    move-object/from16 v18, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move/from16 v27, v11
    move/from16 v28, v12
    move/from16 v29, v13
    move-object/from16 v35, v14
    move-object/from16 v40, v15
    move-object/from16 v41, v1
    invoke-virtual/range v17 ... v41, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    return-object v0
.end method

.method public final component10()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    return v0
.end method

.method public final component11()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    return v0
.end method

.method public final component12()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    return v0
.end method

.method public final component13()com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    return-object v0
.end method

.method public final component14()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    return-wide v0
.end method

.method public final component15()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    return-wide v0
.end method

.method public final component16()com.bytedance.trae.conversation.brainstorm.model.TimeoutState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    return-object v0
.end method

.method public final component17()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    return v0
.end method

.method public final component18()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    return-object v0
.end method

.method public final component19()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    return v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    return-object v0
.end method

.method public final component20()com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    return-object v0
.end method

.method public final component21()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    return-object v0
.end method

.method public final component22()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.brainstorm.model.RecordingState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.conversation.brainstorm.model.AiReplyState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.conversation.brainstorm.model.ParticipantState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.conversation.brainstorm.model.ParticipantState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final component9()com.bytedance.trae.conversation.brainstorm.model.AudioDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase  java.util.List  com.bytedance.trae.conversation.brainstorm.model.RecordingState  com.bytedance.trae.conversation.brainstorm.model.AiReplyState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary  long  long  com.bytedance.trae.conversation.brainstorm.model.TimeoutState  int  java.lang.String  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.util.Map  java.util.List)com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState
    .registers 52
    # ins_size=25
    move-object/from16 v1, v28
    move-object/from16 v2, v29
    move-object/from16 v3, v30
    move-object/from16 v4, v31
    move-object/from16 v5, v32
    move-object/from16 v6, v33
    move-object/from16 v7, v34
    move-object/from16 v8, v35
    move-object/from16 v9, v36
    move/from16 v10, v37
    move/from16 v11, v38
    move/from16 v12, v39
    move-object/from16 v13, v40
    move-wide/from16 v14, v41
    move-wide/from16 v16, v43
    move-object/from16 v18, v45
    move/from16 v19, v46
    move-object/from16 v20, v47
    move/from16 v21, v48
    move-object/from16 v22, v49
    move-object/from16 v23, v50
    move-object/from16 v24, v51
    const-string v0, "phase"
    move-object/from16 v25, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, subtitleHistory
    move-object/from16 v1, v29
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "recordingState"
    move-object/from16 v1, v30
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "aiReplyState"
    move-object/from16 v1, v31
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "aiParticipantState"
    move-object/from16 v1, v32
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userParticipantState
    move-object/from16 v1, v33
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentTranscript"
    move-object/from16 v1, v34
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "botTranscript"
    move-object/from16 v1, v35
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentAudioDevice"
    move-object/from16 v1, v36
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, timeoutState
    move-object/from16 v1, v45
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "aiStageDescription"
    move-object/from16 v1, v47
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "finishedSubTasks"
    move-object/from16 v1, v50
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "attachments"
    move-object/from16 v1, v51
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v26, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-object/from16 v0, v26
    move-object/from16 v1, v25
    invoke-direct/range v0 ... v24, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List;)V
    return-object v26
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAiParticipantState()com.bytedance.trae.conversation.brainstorm.model.ParticipantState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    return-object v0
.end method

.method public final getAiReplyState()com.bytedance.trae.conversation.brainstorm.model.AiReplyState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    return-object v0
.end method

.method public final getAiStageDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    return-object v0
.end method

.method public final getAttachments()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final getBotTranscript()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final getCurrentAudioDevice()com.bytedance.trae.conversation.brainstorm.model.AudioDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-object v0
.end method

.method public final getCurrentTranscript()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final getFinishedSubTasks()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    return-object v0
.end method

.method public final getPhase()com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    return-object v0
.end method

.method public final getRecordingState()com.bytedance.trae.conversation.brainstorm.model.RecordingState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    return-object v0
.end method

.method public final getSessionElapsedMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    return-wide v0
.end method

.method public final getSessionStartTimeMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    return-wide v0
.end method

.method public final getSubTask()com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    return-object v0
.end method

.method public final getSubtitleHistory()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    return-object v0
.end method

.method public final getSummary()com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    return-object v0
.end method

.method public final getTimeoutRemainingSeconds()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    return v0
.end method

.method public final getTimeoutState()com.bytedance.trae.conversation.brainstorm.model.TimeoutState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    return-object v0
.end method

.method public final getUserParticipantState()com.bytedance.trae.conversation.brainstorm.model.ParticipantState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    return-object v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isMicMuted()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    return v0
.end method

.method public final isRtcJoined()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    return v0
.end method

.method public final isSpeakerOn()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    return v0
.end method

.method public final isSubtitleMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BrainstormUiState(phase="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->phase Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", subtitleHistory="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subtitleHistory Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", recordingState="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->recordingState Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", aiReplyState="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiReplyState Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", aiParticipantState="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userParticipantState="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->userParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", currentTranscript="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentTranscript Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", botTranscript="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->botTranscript Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", currentAudioDevice="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->currentAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isSpeakerOn="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isMicMuted="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isSubtitleMode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", summary="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionStartTimeMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionStartTimeMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionElapsedMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->sessionElapsedMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", timeoutState="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", timeoutRemainingSeconds="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->timeoutRemainingSeconds I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", aiStageDescription="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->aiStageDescription Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isRtcJoined="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", subTask="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", finishedSubTasks="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->finishedSubTasks Ljava/util/Map;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", attachments="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->attachments Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
