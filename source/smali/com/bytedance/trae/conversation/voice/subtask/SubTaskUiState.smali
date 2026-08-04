# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
.super Ljava/lang/Object;
.source "SubTaskProtocol.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState$Companion;
.field public static final LONG_RUNNING_THRESHOLD_MS:J
.field private final content:Ljava/lang/String;
.field private final createStartedAtMs:J
.field private final executor:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
.field private final failureReason:Ljava/lang/String;
.field private final localTaskId:Ljava/lang/String;
.field private final longRunning:Z
.field private final proxyChatSessionId:Ljava/lang/String;
.field private final proxyConversationId:Ljava/lang/String;
.field private final sourceTaskId:Ljava/lang/String;
.field private final state:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
.field private final taskDescription:Ljava/lang/String;
.field private final toolName:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->Companion Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String  java.lang.String  long  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor  java.lang.String)void
    .registers 15
    # ins_size=14
    const-string/jumbo v0, sourceTaskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskDescription
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "executor"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    iput-wide v10, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    iput-boolean v12, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    iput-object v13, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String  java.lang.String  long  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 33
    # ins_size=16
    move/from16 v0, v31
    and-int/lit8 v1, v0, 4
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v20
    and-int/lit8 v1, v0, 8
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v21
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v22
    and-int/lit8 v1, v0, 64
    if-eqz v1, +006h
    const-string v1, ""
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v24
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v25
    and-int/lit16 v1, v0, 256
    if-eqz v1, +006h
    const-wide/16 v3, 0
    move-wide v12, v3
    goto +3h
    move-wide/from16 v12, v26
    and-int/lit16 v1, v0, 512
    if-eqz v1, +005h
    const/4 v1, 0
    move v14, v1
    goto +3h
    move/from16 v14, v28
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-object v15, v1
    goto +3h
    move-object/from16 v15, v29
    and-int/lit16 v0, v0, 2048
    if-eqz v0, +005h
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v30
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v9, v23
    invoke-direct/range v3 ... v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String  java.lang.String  long  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 30
    # ins_size=16
    move-object v0, v14
    move/from16 v1, v28
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    goto +2h
    move-object v2, v15
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v16
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v17
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    goto +3h
    move-object/from16 v7, v20
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v21
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v22
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    goto +3h
    move-wide/from16 v10, v23
    and-int/lit16 v12, v1, 512
    if-eqz v12, +005h
    iget-boolean v12, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    goto +3h
    move/from16 v12, v25
    and-int/lit16 v13, v1, 1024
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    goto +3h
    move-object/from16 v13, v26
    and-int/lit16 v1, v1, 2048
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v27
    move-object v15, v2
    move-object/from16 v16, v3
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-object/from16 v19, v6
    move-object/from16 v20, v7
    move-object/from16 v21, v8
    move-object/from16 v22, v9
    move-wide/from16 v23, v10
    move/from16 v25, v12
    move-object/from16 v26, v13
    move-object/from16 v27, v1
    invoke-virtual/range v14 ... v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    return v0
.end method

.method public final component11()com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    return-object v0
.end method

.method public final component12()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    return-object v0
.end method

.method public final component9()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    return-wide v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String  java.lang.String  long  boolean  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor  java.lang.String)com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 29
    # ins_size=14
    const-string/jumbo v0, sourceTaskId
    move-object/from16 v2, v16
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskDescription
    move-object/from16 v3, v17
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    move-object/from16 v7, v21
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    move-object/from16 v8, v22
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "executor"
    move-object/from16 v13, v27
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-object v1, v0
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v9, v23
    move-wide/from16 v10, v24
    move/from16 v12, v26
    move-object/from16 v14, v28
    invoke-direct/range v1 ... v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getCreateStartedAtMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    return-wide v0
.end method

.method public final getExecutor()com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    return-object v0
.end method

.method public final getFailureReason()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    return-object v0
.end method

.method public final getLocalTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final getLongRunning()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    return v0
.end method

.method public final getProxyChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getProxyConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getSourceTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final getState()com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    return-object v0
.end method

.method public final getTaskDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    return-object v0
.end method

.method public final getToolName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubTaskUiState(sourceTaskId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->sourceTaskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", taskDescription="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->taskDescription Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", localTaskId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->localTaskId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", proxyConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", proxyChatSessionId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->proxyChatSessionId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", state="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->state Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", content="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->content Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", failureReason="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->failureReason Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createStartedAtMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->createStartedAtMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", longRunning="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->longRunning Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", executor="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->executor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", toolName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->toolName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
