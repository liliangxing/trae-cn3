# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
.super Ljava/lang/Object;
.source "VoiceDiscussionAttemptTracker.kt"

.field private final attemptId:Ljava/lang/String;
.field private final context:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
.field private final errorCode:I
.field private final furthestStage:Ljava/lang/String;
.field private final latestFailureReason:Ljava/lang/String;
.field private final latestSignal:Ljava/lang/String;
.field private final recordedSignals:Ljava/util/Set;
.field private final stageElapsedMs:Ljava/util/Map;
.field private final startedAtElapsedMs:J
.field private final terminalReported:Z


.method public constructor <init>(java.lang.String  long  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext  java.util.Map  java.util.Set  java.lang.String  java.lang.String  java.lang.String  int  boolean)void
    .registers 13
    # ins_size=12
    const-string v0, "attemptId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, stageElapsedMs
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "recordedSignals"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "furthestStage"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "latestSignal"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "latestFailureReason"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    iput-wide v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    iput v11, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    iput-boolean v12, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  long  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext  java.util.Map  java.util.Set  java.lang.String  java.lang.String  java.lang.String  int  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 37
    # ins_size=14
    move/from16 v0, v35
    and-int/lit8 v1, v0, 4
    if-eqz v1, +013h
    new-instance v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 63
    const/4 v10, 0
    move-object v2, v1
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;-><init>(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v15, v1
    goto +3h
    move-object/from16 v15, v27
    and-int/lit8 v1, v0, 8
    if-eqz v1, +009h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    move-object/from16 v16, v1
    goto +3h
    move-object/from16 v16, v28
    and-int/lit8 v1, v0, 16
    if-eqz v1, +009h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v1
    move-object/from16 v17, v1
    goto +3h
    move-object/from16 v17, v29
    and-int/lit8 v1, v0, 32
    const-string v2, ""
    if-eqz v1, +005h
    move-object/from16 v18, v2
    goto +3h
    move-object/from16 v18, v30
    and-int/lit8 v1, v0, 64
    if-eqz v1, +005h
    move-object/from16 v19, v2
    goto +3h
    move-object/from16 v19, v31
    and-int/lit16 v1, v0, 128
    if-eqz v1, +005h
    move-object/from16 v20, v2
    goto +3h
    move-object/from16 v20, v32
    and-int/lit16 v1, v0, 256
    const/4 v2, 0
    if-eqz v1, +005h
    move/from16 v21, v2
    goto +3h
    move/from16 v21, v33
    and-int/lit16 v0, v0, 512
    if-eqz v0, +005h
    move/from16 v22, v2
    goto +3h
    move/from16 v22, v34
    move-object/from16 v11, v23
    move-object/from16 v12, v24
    move-wide/from16 v13, v25
    invoke-direct/range v11 ... v22, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;-><init>(Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState  java.lang.String  long  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext  java.util.Map  java.util.Set  java.lang.String  java.lang.String  java.lang.String  int  boolean  int  java.lang.Object)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState
    .registers 26
    # ins_size=14
    move-object v0, v12
    move/from16 v1, v24
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-wide v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    goto +2h
    move-wide v3, v14
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v19
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v10, v1, 128
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v11, v1, 256
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    goto +3h
    move/from16 v11, v22
    and-int/lit16 v1, v1, 512
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    goto +3h
    move/from16 v1, v23
    move-object v13, v2
    move-wide v14, v3
    move-object/from16 v16, v5
    move-object/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-object/from16 v21, v10
    move/from16 v22, v11
    move/from16 v23, v1
    invoke-virtual/range v12 ... v23, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->copy(Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    return v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    return-wide v0
.end method

.method public final component3()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    return-object v0
.end method

.method public final component4()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    return-object v0
.end method

.method public final component5()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    return-object v0
.end method

.method public final component9()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    return v0
.end method

.method public final copy(java.lang.String  long  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext  java.util.Map  java.util.Set  java.lang.String  java.lang.String  java.lang.String  int  boolean)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState
    .registers 25
    # ins_size=12
    const-string v0, "attemptId"
    move-object v2, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "context"
    move-object/from16 v5, v17
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, stageElapsedMs
    move-object/from16 v6, v18
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "recordedSignals"
    move-object/from16 v7, v19
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "furthestStage"
    move-object/from16 v8, v20
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "latestSignal"
    move-object/from16 v9, v21
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "latestFailureReason"
    move-object/from16 v10, v22
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-object v1, v0
    move-wide v3, v15
    move/from16 v11, v23
    move/from16 v12, v24
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;-><init>(Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    iget v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    iget-boolean v8, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getAttemptId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    return-object v0
.end method

.method public final getContext()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    return-object v0
.end method

.method public final getErrorCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    return v0
.end method

.method public final getFurthestStage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    return-object v0
.end method

.method public final getLatestFailureReason()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    return-object v0
.end method

.method public final getLatestSignal()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    return-object v0
.end method

.method public final getRecordedSignals()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    return-object v0
.end method

.method public final getStageElapsedMs()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    return-object v0
.end method

.method public final getStartedAtElapsedMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    return-wide v0
.end method

.method public final getTerminalReported()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "VoiceDiscussionAttemptState(attemptId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->attemptId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", startedAtElapsedMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->startedAtElapsedMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", context="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->context Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", stageElapsedMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->stageElapsedMs Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", recordedSignals="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->recordedSignals Ljava/util/Set;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", furthestStage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->furthestStage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", latestSignal="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestSignal Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", latestFailureReason="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->latestFailureReason Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->errorCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", terminalReported="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->terminalReported Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
