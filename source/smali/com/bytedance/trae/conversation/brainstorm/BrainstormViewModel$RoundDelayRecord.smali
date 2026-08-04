# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
.super Ljava/lang/Object;
.source "BrainstormViewModel.kt"

.field private attachmentCount:I
.field private botAnsweringMs:Ljava/lang/Long;
.field private botCharCount:I
.field private botCurrentParagraphChars:I
.field private botFinishMs:Ljava/lang/Long;
.field private botFirstCharMs:Ljava/lang/Long;
.field private botLatestCharMs:Ljava/lang/Long;
.field private final convRoundId:J
.field private hasSearch:Z
.field private hasSubtask:Z
.field private hasUpload:Z
.field private interruptPhase:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
.field private interrupted:Z
.field private reported:Z
.field private final roundIndex:I
.field private final toolNames:Ljava/util/Set;
.field private userCharCount:I
.field private userFinalReceived:Z
.field private final userSpeakEndMs:J
.field private userSpeakStartMs:Ljava/lang/Long;
.field private userSubtitleFirstCharMs:Ljava/lang/Long;
.field private userSubtitleLastCharMs:Ljava/lang/Long;


.method public constructor <init>(int  long  long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  int  int  int  java.lang.Long  java.lang.Long  java.lang.Long  boolean  boolean  com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$InterruptPhase  boolean  boolean  boolean  boolean  int  java.util.Set)void
    .registers 29
    # ins_size=25
    move-object v0, v4
    move-object/from16 v1, v28
    const-string/jumbo v2, toolNames
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, Ljava/lang/Object;-><init>()V
    move v2, v5
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    move-wide v2, v6
    iput-wide v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    move-wide v2, v8
    iput-wide v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    move-object v2, v10
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    move-object v2, v11
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    move-object v2, v12
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    move-object v2, v13
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    move v2, v14
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    move v2, v15
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    move/from16 v2, v16
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    move-object/from16 v2, v17
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    move-object/from16 v2, v18
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    move-object/from16 v2, v19
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    move/from16 v2, v20
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    move/from16 v2, v21
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    move-object/from16 v2, v22
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move/from16 v2, v23
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    move/from16 v2, v24
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    move/from16 v2, v25
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    move/from16 v2, v26
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    move/from16 v2, v27
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    return-void 
.end method

.method public synthetic constructor <init>(int  long  long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  int  int  int  java.lang.Long  java.lang.Long  java.lang.Long  boolean  boolean  com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$InterruptPhase  boolean  boolean  boolean  boolean  int  java.util.Set  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 55
    # ins_size=27
    move/from16 v0, v53
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v34
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v35
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v36
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v37
    and-int/lit16 v1, v0, 128
    const/4 v3, 0
    if-eqz v1, +004h
    move v13, v3
    goto +3h
    move/from16 v13, v38
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move v14, v3
    goto +3h
    move/from16 v14, v39
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move v15, v3
    goto +3h
    move/from16 v15, v40
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +005h
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v41
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +005h
    move-object/from16 v17, v2
    goto +3h
    move-object/from16 v17, v42
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +005h
    move-object/from16 v18, v2
    goto +3h
    move-object/from16 v18, v43
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +005h
    move/from16 v19, v3
    goto +3h
    move/from16 v19, v44
    and-int/lit16 v1, v0, 16384
    if-eqz v1, +005h
    move/from16 v20, v3
    goto +3h
    move/from16 v20, v45
    const v1, 32768
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move-object/from16 v21, v2
    goto +3h
    move-object/from16 v21, v46
    const/high16 v1, 65536
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v22, v3
    goto +3h
    move/from16 v22, v47
    const/high16 v1, 131072
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v23, v3
    goto +3h
    move/from16 v23, v48
    const/high16 v1, 262144
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v24, v3
    goto +3h
    move/from16 v24, v49
    const/high16 v1, 524288
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v25, v3
    goto +3h
    move/from16 v25, v50
    const/high16 v1, 1048576
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v26, v3
    goto +3h
    move/from16 v26, v51
    const/high16 v1, 2097152
    and-int/2addr v0, v1
    if-eqz v0, +00ch
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    move-object/from16 v27, v0
    goto +3h
    move-object/from16 v27, v52
    move-object/from16 v3, v28
    move/from16 v4, v29
    move-wide/from16 v5, v30
    move-wide/from16 v7, v32
    invoke-direct/range v3 ... v27, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;-><init>(I J J Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I I I Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Z Z Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase; Z Z Z Z I Ljava/util/Set;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord  int  long  long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  int  int  int  java.lang.Long  java.lang.Long  java.lang.Long  boolean  boolean  com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$InterruptPhase  boolean  boolean  boolean  boolean  int  java.util.Set  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord
    .registers 44
    # ins_size=27
    move-object/from16 v0, v17
    move/from16 v1, v42
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    goto +3h
    move/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    goto +3h
    move-wide/from16 v3, v19
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    goto +3h
    move-wide/from16 v5, v21
    and-int/lit8 v7, v1, 8
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 16
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit8 v9, v1, 32
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit8 v10, v1, 64
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 128
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    goto +3h
    move/from16 v11, v27
    and-int/lit16 v12, v1, 256
    if-eqz v12, +005h
    iget v12, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    goto +3h
    move/from16 v12, v28
    and-int/lit16 v13, v1, 512
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    goto +3h
    move/from16 v13, v29
    and-int/lit16 v14, v1, 1024
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 2048
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 4096
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v32
    move-object/from16 v32, v15
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    goto +3h
    move/from16 v15, v33
    move/from16 v33, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    goto +3h
    move/from16 v15, v34
    const v16, 32768
    and-int v16, v1, v16
    move/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    goto +3h
    move/from16 v15, v36
    const/high16 v16, 131072
    and-int v16, v1, v16
    move/from16 v36, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    goto +3h
    move/from16 v15, v37
    const/high16 v16, 262144
    and-int v16, v1, v16
    move/from16 v37, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    goto +3h
    move/from16 v15, v38
    const/high16 v16, 524288
    and-int v16, v1, v16
    move/from16 v38, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    goto +3h
    move/from16 v15, v39
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move/from16 v39, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    goto +3h
    move/from16 v15, v40
    const/high16 v16, 2097152
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    goto +3h
    move-object/from16 v1, v41
    move/from16 v18, v2
    move-wide/from16 v19, v3
    move-wide/from16 v21, v5
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move/from16 v27, v11
    move/from16 v28, v12
    move/from16 v29, v13
    move-object/from16 v30, v14
    move/from16 v40, v15
    move-object/from16 v41, v1
    invoke-virtual/range v17 ... v41, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->copy(I J J Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I I I Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Z Z Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase; Z Z Z Z I Ljava/util/Set;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    return v0
.end method

.method public final component10()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    return v0
.end method

.method public final component11()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    return-object v0
.end method

.method public final component12()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public final component13()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public final component14()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    return v0
.end method

.method public final component15()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    return v0
.end method

.method public final component16()com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$InterruptPhase
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    return-object v0
.end method

.method public final component17()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    return v0
.end method

.method public final component18()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    return v0
.end method

.method public final component19()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    return v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    return-wide v0
.end method

.method public final component20()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    return v0
.end method

.method public final component21()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    return v0
.end method

.method public final component22()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    return-object v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    return-wide v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public final component6()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public final component7()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    return-object v0
.end method

.method public final component8()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    return v0
.end method

.method public final component9()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    return v0
.end method

.method public final copy(int  long  long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  int  int  int  java.lang.Long  java.lang.Long  java.lang.Long  boolean  boolean  com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$InterruptPhase  boolean  boolean  boolean  boolean  int  java.util.Set)com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord
    .registers 51
    # ins_size=25
    move/from16 v1, v27
    move-wide/from16 v2, v28
    move-wide/from16 v4, v30
    move-object/from16 v6, v32
    move-object/from16 v7, v33
    move-object/from16 v8, v34
    move-object/from16 v9, v35
    move/from16 v10, v36
    move/from16 v11, v37
    move/from16 v12, v38
    move-object/from16 v13, v39
    move-object/from16 v14, v40
    move-object/from16 v15, v41
    move/from16 v16, v42
    move/from16 v17, v43
    move-object/from16 v18, v44
    move/from16 v19, v45
    move/from16 v20, v46
    move/from16 v21, v47
    move/from16 v22, v48
    move/from16 v23, v49
    move-object/from16 v24, v50
    const-string/jumbo v0, toolNames
    move-object/from16 v1, v50
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v25, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-object/from16 v0, v25
    move/from16 v1, v27
    invoke-direct/range v0 ... v24, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;-><init>(I J J Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I I I Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Z Z Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase; Z Z Z Z I Ljava/util/Set;)V
    return-object v25
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAttachmentCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    return v0
.end method

.method public final getBotAnsweringMs()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    return-object v0
.end method

.method public final getBotCharCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    return v0
.end method

.method public final getBotCurrentParagraphChars()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    return v0
.end method

.method public final getBotFinishMs()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    return-object v0
.end method

.method public final getBotFirstCharMs()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public final getBotLatestCharMs()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public final getConvRoundId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    return-wide v0
.end method

.method public final getHasSearch()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    return v0
.end method

.method public final getHasSubtask()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    return v0
.end method

.method public final getHasUpload()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    return v0
.end method

.method public final getInterruptPhase()com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$InterruptPhase
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    return-object v0
.end method

.method public final getInterrupted()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    return v0
.end method

.method public final getReported()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    return v0
.end method

.method public final getRoundIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    return v0
.end method

.method public final getToolNames()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    return-object v0
.end method

.method public final getUserCharCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    return v0
.end method

.method public final getUserFinalReceived()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    return v0
.end method

.method public final getUserSpeakEndMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    return-wide v0
.end method

.method public final getUserSpeakStartMs()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    return-object v0
.end method

.method public final getUserSubtitleFirstCharMs()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public final getUserSubtitleLastCharMs()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final setAttachmentCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    return-void 
.end method

.method public final setBotAnsweringMs(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    return-void 
.end method

.method public final setBotCharCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    return-void 
.end method

.method public final setBotCurrentParagraphChars(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    return-void 
.end method

.method public final setBotFinishMs(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    return-void 
.end method

.method public final setBotFirstCharMs(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    return-void 
.end method

.method public final setBotLatestCharMs(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    return-void 
.end method

.method public final setHasSearch(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    return-void 
.end method

.method public final setHasSubtask(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    return-void 
.end method

.method public final setHasUpload(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    return-void 
.end method

.method public final setInterruptPhase(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$InterruptPhase)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    return-void 
.end method

.method public final setInterrupted(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    return-void 
.end method

.method public final setReported(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    return-void 
.end method

.method public final setUserCharCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    return-void 
.end method

.method public final setUserFinalReceived(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    return-void 
.end method

.method public final setUserSpeakStartMs(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    return-void 
.end method

.method public final setUserSubtitleFirstCharMs(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    return-void 
.end method

.method public final setUserSubtitleLastCharMs(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    return-void 
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RoundDelayRecord(roundIndex="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->roundIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", convRoundId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->convRoundId J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userSpeakEndMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakEndMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", botAnsweringMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botAnsweringMs Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", botFirstCharMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFirstCharMs Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", botLatestCharMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botLatestCharMs Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", botFinishMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botFinishMs Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userCharCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userCharCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", botCharCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCharCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", botCurrentParagraphChars="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->botCurrentParagraphChars I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userSpeakStartMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSpeakStartMs Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userSubtitleFirstCharMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleFirstCharMs Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userSubtitleLastCharMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userSubtitleLastCharMs Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userFinalReceived="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->userFinalReceived Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", interrupted="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interrupted Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", interruptPhase="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->interruptPhase Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", reported="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->reported Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasSearch="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSearch Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasSubtask="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasSubtask Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasUpload="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->hasUpload Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", attachmentCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->attachmentCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", toolNames="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->toolNames Ljava/util/Set;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
