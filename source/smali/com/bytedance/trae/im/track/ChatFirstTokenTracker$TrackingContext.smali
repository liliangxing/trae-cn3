# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
.super Ljava/lang/Object;
.source "ChatFirstTokenTracker.kt"

.field private agentProcessSupport:Ljava/lang/String;
.field private agentTaskServiceStrategy:Ljava/lang/String;
.field private agentType:Ljava/lang/String;
.field private chatProcessVersion:Ljava/lang/String;
.field private configSource:Ljava/lang/String;
.field private hasText:Z
.field private imageCount:I
.field private isPreset:Ljava/lang/Boolean;
.field private model:Ljava/lang/String;
.field private modelStrategy:Ljava/lang/String;
.field private provider:Ljava/lang/String;
.field private queueStartTime:J
.field private queued:Z
.field private requestClient:Ljava/lang/String;
.field private sendResponseTime:J
.field private sessionId:Ljava/lang/String;
.field private sessionMessageCount:Ljava/lang/Integer;
.field private source:Ljava/lang/String;
.field private final startTime:J
.field private traceId:Ljava/lang/String;
.field private ttnetABTest:Ljava/lang/String;


.method public constructor <init>(long  long  java.lang.String  java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  boolean  int  java.lang.String  java.lang.String  java.lang.String)void
    .registers 31
    # ins_size=25
    move-object v0, v6
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    const-string/jumbo v4, sessionId
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "model"
    invoke-static v12, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "agentType"
    invoke-static v13, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, Ljava/lang/Object;-><init>()V
    move-wide v4, v7
    iput-wide v4, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    move-wide v4, v9
    iput-wide v4, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    move v1, v14
    iput-boolean v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    move-wide v1, v15
    iput-wide v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    move/from16 v1, v26
    iput-boolean v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    move/from16 v1, v27
    iput v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(long  long  java.lang.String  java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  boolean  int  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 56
    # ins_size=27
    move/from16 v0, v54
    and-int/lit8 v1, v0, 2
    const-wide/16 v2, 0
    if-eqz v1, +004h
    move-wide v7, v2
    goto +3h
    move-wide/from16 v7, v32
    and-int/lit8 v1, v0, 4
    const-string v4, ""
    if-eqz v1, +004h
    move-object v9, v4
    goto +3h
    move-object/from16 v9, v34
    and-int/lit8 v1, v0, 8
    if-eqz v1, +004h
    move-object v10, v4
    goto +3h
    move-object/from16 v10, v35
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v11, v4
    goto +3h
    move-object/from16 v11, v36
    and-int/lit8 v1, v0, 32
    const/4 v4, 0
    if-eqz v1, +004h
    move v12, v4
    goto +3h
    move/from16 v12, v37
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-wide v13, v2
    goto +3h
    move-wide/from16 v13, v38
    and-int/lit16 v1, v0, 128
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v15, v2
    goto +3h
    move-object/from16 v15, v40
    and-int/lit16 v1, v0, 256
    if-eqz v1, +005h
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v41
    and-int/lit16 v1, v0, 512
    if-eqz v1, +005h
    move-object/from16 v17, v2
    goto +3h
    move-object/from16 v17, v42
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +005h
    move-object/from16 v18, v2
    goto +3h
    move-object/from16 v18, v43
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +005h
    move-object/from16 v19, v2
    goto +3h
    move-object/from16 v19, v44
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +005h
    move-object/from16 v20, v2
    goto +3h
    move-object/from16 v20, v45
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +005h
    move-object/from16 v21, v2
    goto +3h
    move-object/from16 v21, v46
    and-int/lit16 v1, v0, 16384
    if-eqz v1, +005h
    move-object/from16 v22, v2
    goto +3h
    move-object/from16 v22, v47
    const v1, 32768
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move-object/from16 v23, v2
    goto +3h
    move-object/from16 v23, v48
    const/high16 v1, 65536
    and-int/2addr v1, v0
    if-eqz v1, +006h
    const/4 v1, 1
    move/from16 v24, v1
    goto +3h
    move/from16 v24, v49
    const/high16 v1, 131072
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move/from16 v25, v4
    goto +3h
    move/from16 v25, v50
    const/high16 v1, 262144
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move-object/from16 v26, v2
    goto +3h
    move-object/from16 v26, v51
    const/high16 v1, 524288
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move-object/from16 v27, v2
    goto +3h
    move-object/from16 v27, v52
    const/high16 v1, 1048576
    and-int/2addr v0, v1
    if-eqz v0, +005h
    move-object/from16 v28, v2
    goto +3h
    move-object/from16 v28, v53
    move-object/from16 v4, v29
    move-wide/from16 v5, v30
    invoke-direct/range v4 ... v28, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;-><init>(J J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Z I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.track.ChatFirstTokenTracker$TrackingContext  long  long  java.lang.String  java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  boolean  int  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.track.ChatFirstTokenTracker$TrackingContext
    .registers 44
    # ins_size=27
    move-object/from16 v0, v17
    move/from16 v1, v42
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    goto +3h
    move-wide/from16 v2, v18
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    goto +3h
    move-wide/from16 v4, v20
    and-int/lit8 v6, v1, 4
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 8
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 16
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit8 v9, v1, 32
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    goto +3h
    move/from16 v9, v25
    and-int/lit8 v10, v1, 64
    if-eqz v10, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    goto +3h
    move-wide/from16 v10, v26
    and-int/lit16 v12, v1, 128
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 256
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 512
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 1024
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 2048
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v32
    move-object/from16 v32, v15
    and-int/lit16 v15, v1, 4096
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v33
    move-object/from16 v33, v15
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v34
    move-object/from16 v34, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v35
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    goto +3h
    move/from16 v15, v37
    const/high16 v16, 131072
    and-int v16, v1, v16
    move/from16 v37, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    goto +3h
    move/from16 v15, v38
    const/high16 v16, 262144
    and-int v16, v1, v16
    move/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v16, 1048576
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v41
    move-wide/from16 v18, v2
    move-wide/from16 v20, v4
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move/from16 v25, v9
    move-wide/from16 v26, v10
    move-object/from16 v28, v12
    move-object/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v40, v15
    move-object/from16 v41, v1
    invoke-virtual/range v17 ... v41, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->copy(J J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Z I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    return-wide v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    return-object v0
.end method

.method public final component12()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component13()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    return-object v0
.end method

.method public final component15()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    return-object v0
.end method

.method public final component16()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final component17()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    return v0
.end method

.method public final component18()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    return v0
.end method

.method public final component19()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    return-wide v0
.end method

.method public final component20()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final component21()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    return v0
.end method

.method public final component7()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    return-wide v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    return-object v0
.end method

.method public final copy(long  long  java.lang.String  java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  boolean  int  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.im.track.ChatFirstTokenTracker$TrackingContext
    .registers 51
    # ins_size=25
    move-wide/from16 v1, v27
    move-wide/from16 v3, v29
    move-object/from16 v5, v31
    move-object/from16 v6, v32
    move-object/from16 v7, v33
    move/from16 v8, v34
    move-wide/from16 v9, v35
    move-object/from16 v11, v37
    move-object/from16 v12, v38
    move-object/from16 v13, v39
    move-object/from16 v14, v40
    move-object/from16 v15, v41
    move-object/from16 v16, v42
    move-object/from16 v17, v43
    move-object/from16 v18, v44
    move-object/from16 v19, v45
    move/from16 v20, v46
    move/from16 v21, v47
    move-object/from16 v22, v48
    move-object/from16 v23, v49
    move-object/from16 v24, v50
    const-string/jumbo v0, sessionId
    move-object/from16 v1, v31
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "model"
    move-object/from16 v1, v32
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "agentType"
    move-object/from16 v1, v33
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v25, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    move-object/from16 v0, v25
    move-wide/from16 v1, v27
    invoke-direct/range v0 ... v24, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;-><init>(J J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Z I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v25
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    iget-wide v3, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    iget-wide v5, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    iget-wide v5, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    iget-boolean v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    iget-wide v5, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    iget-boolean v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    iget v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAgentProcessSupport()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentTaskServiceStrategy()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getChatProcessVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getConfigSource()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    return-object v0
.end method

.method public final getHasText()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    return v0
.end method

.method public final getImageCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    return v0
.end method

.method public final getModel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    return-object v0
.end method

.method public final getModelStrategy()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    return-object v0
.end method

.method public final getProvider()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    return-object v0
.end method

.method public final getQueueStartTime()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    return-wide v0
.end method

.method public final getQueued()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    return v0
.end method

.method public final getRequestClient()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    return-object v0
.end method

.method public final getSendResponseTime()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    return-wide v0
.end method

.method public final getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getSessionMessageCount()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final getSource()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    return-object v0
.end method

.method public final getStartTime()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    return-wide v0
.end method

.method public final getTraceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final getTtnetABTest()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isPreset()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    return-object v0
.end method

.method public final setAgentProcessSupport(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    return-void 
.end method

.method public final setAgentTaskServiceStrategy(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    return-void 
.end method

.method public final setAgentType(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    return-void 
.end method

.method public final setChatProcessVersion(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    return-void 
.end method

.method public final setConfigSource(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    return-void 
.end method

.method public final setHasText(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    return-void 
.end method

.method public final setImageCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    return-void 
.end method

.method public final setModel(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    return-void 
.end method

.method public final setModelStrategy(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    return-void 
.end method

.method public final setPreset(java.lang.Boolean)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    return-void 
.end method

.method public final setProvider(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    return-void 
.end method

.method public final setQueueStartTime(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    return-void 
.end method

.method public final setQueued(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    return-void 
.end method

.method public final setRequestClient(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    return-void 
.end method

.method public final setSendResponseTime(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    return-void 
.end method

.method public final setSessionId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    return-void 
.end method

.method public final setSessionMessageCount(java.lang.Integer)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    return-void 
.end method

.method public final setSource(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    return-void 
.end method

.method public final setTraceId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    return-void 
.end method

.method public final setTtnetABTest(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    return-void 
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TrackingContext(startTime="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->startTime J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sendResponseTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sendResponseTime J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", model="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->model Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", queued="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queued Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", queueStartTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->queueStartTime J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", traceId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->traceId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", modelStrategy="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->modelStrategy Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", configSource="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->configSource Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", provider="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->provider Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isPreset="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatProcessVersion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->chatProcessVersion Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentTaskServiceStrategy="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentTaskServiceStrategy Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", ttnetABTest="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->ttnetABTest Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionMessageCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->sessionMessageCount Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->hasText Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", imageCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->imageCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", requestClient="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->requestClient Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentProcessSupport="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->agentProcessSupport Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", source="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->source Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
