# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;
.super Ljava/lang/Object;
.source "SubTaskProtocol.kt"


.method public static final mapHeadStatusToTerminal(java.lang.String)com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState
    .registers 3
    # ins_size=1
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    if-eqz v0, +004h
    const/4 v2, 0
    goto +fh
    const-string/jumbo v0, success
    invoke-static v2, v0, v1, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    return-object v2
.end method

.method private static final parseSubTaskEnvelope(java.lang.String  java.lang.String  boolean)com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage
    .registers 19
    # ins_size=3
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +003h
    return-object v3
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v2, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v2
    const-class v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    invoke-virtual v2, v0, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getType()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    const-string v4, ""
    if-nez v2, +004h
    move-object v6, v4
    goto +2h
    move-object v6, v2
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return-object v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v7, v4
    goto +2h
    move-object v7, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v8, v4
    goto +2h
    move-object v8, v2
    move-object v2, v7
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-nez v2, +090h
    move-object v2, v8
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +004h
    goto/16 +085h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->Companion Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getExecutor()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;->fromProtocol(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +015h
    const-string/jumbo v5, task_update
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +3h
    move-object v5, v1
    goto +2h
    move-object v5, v4
    move-object v10, v5
    check-cast v10, Ljava/lang/String;
    if-nez v18, +024h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v2, v1, +020h
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +017h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-eqz v1, +003h
    return-object v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v1
    const-wide/16 v11, 0
    cmp-long v1, v1, v11
    if-lez v1, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v1
    goto +4h
    const-wide/32 v1, 600000
    move-wide v13, v1
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getUserId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v9, v4
    goto +2h
    move-object v9, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getMessage()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v12
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getExecutor()Ljava/lang/String;
    move-result-object v15
    move-object v5, v1
    invoke-direct/range v5 ... v15, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; J Ljava/lang/String;)V
    move-object v3, v1
    nop 
    return-object v3
    :try_start_0xf
    :try_start_0x2c
.end method

.method public static final parseSubTaskRequest(java.lang.String)com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage
    .registers 3
    # ins_size=1
    const-string v0, "json"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sub_task_request
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskEnvelope(Ljava/lang/String; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v2
    return-object v2
.end method

.method public static final parseSubTaskUpdate(java.lang.String)com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage
    .registers 3
    # ins_size=1
    const-string v0, "json"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, task_update
    const/4 v1, 1
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskEnvelope(Ljava/lang/String; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v2
    return-object v2
.end method

.method public static final parseTaskStart(java.lang.String)com.bytedance.trae.conversation.voice.subtask.TaskStartMessage
    .registers 4
    # ins_size=1
    const-string v0, "json"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;
    invoke-virtual v0, v3, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getType()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    const-string/jumbo v2, task_start
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-object v1
    move-object v1, v3
    return-object v1
    :try_start_0x10
.end method

.method public static final parseTaskStop(java.lang.String)com.bytedance.trae.conversation.voice.subtask.TaskStopMessage
    .registers 12
    # ins_size=1
    const-string v0, "json"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    invoke-virtual v0, v11, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v11
    move-object v2, v11
    check-cast v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getType()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v1
    const-string/jumbo v0, task_stop
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    return-object v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    if-nez v11, +02eh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getRoomId()Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    if-eqz v11, +003h
    goto +20h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTimeoutMs()J
    move-result-wide v3
    const-wide/16 v5, 0
    cmp-long v11, v3, v5
    if-lez v11, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTimeoutMs()J
    move-result-wide v3
    goto +4h
    const-wide/32 v3, 600000
    move-wide v7, v3
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v9, 15
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    move-result-object v1
    nop 
    return-object v1
    :try_start_0x10
.end method

.method public static final parseToolResult(java.lang.String)com.bytedance.trae.conversation.voice.subtask.ToolResultMessage
    .registers 4
    # ins_size=1
    const-string v0, "json"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    invoke-virtual v0, v3, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getType()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    const-string/jumbo v2, task_result
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-object v1
    move-object v1, v3
    return-object v1
    :try_start_0x10
.end method

.method public static final peekSubTaskMessageType(java.lang.String)java.lang.String
    .registers 4
    # ins_size=1
    const-string v0, "json"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskTypeEnvelope;
    invoke-virtual v0, v3, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskTypeEnvelope;
    if-eqz v3, +014h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskTypeEnvelope;->getType()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00eh
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    move-object v1, v3
    return-object v1
    :try_start_0x10
.end method
