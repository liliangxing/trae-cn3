# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
.super Ljava/lang/Object;
.source "BrainstormMessage.kt"

.field private final attachedSubTaskId:Ljava/lang/String;
.field private final content:Ljava/lang/String;
.field private final id:Ljava/lang/String;
.field private final role:Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
.field private final subTaskFailureReason:Ljava/lang/String;
.field private final subTaskTerminalState:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
.field private final taskResultRefersToTaskId:Ljava/lang/String;
.field private final taskResultStatus:Ljava/lang/String;
.field private final timestamp:J


.method public constructor <init>(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  long  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String)void
    .registers 12
    # ins_size=11
    const-string v0, "id"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    iput-wide v5, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    iput-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  long  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 27
    # ins_size=13
    move/from16 v0, v25
    and-int/lit8 v1, v0, 16
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v20
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v23
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v24
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-wide/from16 v7, v18
    invoke-direct/range v3 ... v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  long  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage
    .registers 24
    # ins_size=13
    move-object v0, v11
    move/from16 v1, v22
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    goto +2h
    move-object v2, v12
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    goto +2h
    move-object v3, v13
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    goto +2h
    move-object v4, v14
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    goto +2h
    move-wide v5, v15
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v17
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v18
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v10, v1, 128
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v21
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    move-wide v15, v5
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v21, v1
    invoke-virtual/range v11 ... v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->copy(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.brainstorm.model.MessageRole
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    return-wide v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component8()com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  long  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState  java.lang.String)com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage
    .registers 23
    # ins_size=11
    const-string v0, "id"
    move-object v2, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    move-object v4, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    move-object v1, v0
    move-wide/from16 v5, v16
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    move-object/from16 v9, v20
    move-object/from16 v10, v21
    move-object/from16 v11, v22
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAttachedSubTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getRole()com.bytedance.trae.conversation.brainstorm.model.MessageRole
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    return-object v0
.end method

.method public final getSubTaskFailureReason()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    return-object v0
.end method

.method public final getSubTaskTerminalState()com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    return-object v0
.end method

.method public final getTaskResultRefersToTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskResultStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BrainstormMessage(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", role="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", content="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->content Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", timestamp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->timestamp J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", attachedSubTaskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->attachedSubTaskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskResultRefersToTaskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultRefersToTaskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskResultStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->taskResultStatus Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", subTaskTerminalState="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskTerminalState Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", subTaskFailureReason="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->subTaskFailureReason Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
