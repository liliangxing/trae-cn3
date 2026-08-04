# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
.super Ljava/lang/Object;
.source "VoiceDiscussionMetrics.kt"

.field public static final EVENT_FILE_UPLOAD_END:Ljava/lang/String;
.field public static final EVENT_SERVER_TOOL_END:Ljava/lang/String;
.field public static final EVENT_SUBTASK_END:Ljava/lang/String;
.field public static final EVENT_SUBTASK_START:Ljava/lang/String;
.field public static final EVENT_WINDOW_STATE_CLICK:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
.field private static final MISSING_DURATION_MS:J
.field public static final STATUS_FAILED:Ljava/lang/String;
.field public static final STATUS_SUCCESS:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final TOOL_DURATION_SOURCE_CLIENT:Ljava/lang/String;
.field private static final TOOL_DURATION_SOURCE_MISSING_START:Ljava/lang/String;
.field public static final TOOL_NAME_WEB_SEARCH:Ljava/lang/String;
.field public static final WINDOW_ACTION_MINIMIZE:Ljava/lang/String;
.field public static final WINDOW_ACTION_RESTORE:Ljava/lang/String;
.field public static final WINDOW_STATE_MINIMIZED:Ljava/lang/String;
.field public static final WINDOW_STATE_NORMAL:Ljava/lang/String;
.field private static final serverToolReportedTaskIds:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final serverToolStarts:Ljava/util/concurrent/ConcurrentHashMap;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->serverToolStarts Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->serverToolReportedTaskIds Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final chatMode(com.bytedance.trae.im.service.Mode)java.lang.String
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v2, v0, +005h
    const-string v2, "code"
    goto +3h
    const-string v2, "mtc"
    return-object v2
.end method

.method private final reportTea(java.lang.String  org.json.JSONObject)void
    .registers 7
    # ins_size=3
    const-string v0, "VoiceDiscussionMetrics"
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, v5, v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ": "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v0, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +17h
    move-exception v6
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, reportTea failed: event=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v0, v5, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x2
.end method

.method private final resolveFailureReason(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getError()Ljava/lang/String;
    move-result-object v4
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v4, +00dh
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v0
    if-eqz v2, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +003h
    return-object v4
    const-string/jumbo v4, success
    invoke-static v5, v4, v0, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-nez v4, +003h
    return-object v5
    const-string v4, ""
    return-object v4
.end method

.method private final resolveToolStatus(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)java.lang.String
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00dh
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v0, v1
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v3
    goto +2h
    move v1, v2
    if-nez v1, +003h
    return-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getError()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00ah
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +006h
    const-string/jumbo v5, success
    goto +3h
    const-string v5, "failed"
    return-object v5
.end method

.method public final boolValue(boolean)java.lang.String
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    const-string v1, "1"
    goto +3h
    const-string v1, "0"
    return-object v1
.end method

.method public final clearServerToolTracking()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->serverToolStarts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->serverToolReportedTaskIds Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    return-void 
.end method

.method public final commonCategory(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode)org.json.JSONObject
    .registers 4
    # ins_size=3
    const-string v0, "cliType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    move-result-object v2
    return-object v2
.end method

.method public final putVoiceCommonParams(org.json.JSONObject  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode)org.json.JSONObject
    .registers 8
    # ins_size=4
    const-string v0, "<this>"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->chatMode(Lcom/bytedance/trae/im/service/Mode;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "cli_type"
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v0, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "chat_mode"
    invoke-virtual v5, v7, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const/16 v7, 95
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v7, "env_mode"
    invoke-virtual v5, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-object v5
.end method

.method public final recordServerToolStart(com.bytedance.trae.conversation.voice.subtask.TaskStartMessage)void
    .registers 7
    # ins_size=2
    const-string v0, "msg"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->serverToolStarts Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/Map;
    new-instance v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    const-string v6, ""
    invoke-direct v2, v3, v4, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;-><init>(J Ljava/lang/String;)V
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final reportFileUploadEnd(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Long  java.lang.String  java.lang.String  long  java.lang.String  long  java.lang.String  java.lang.String)void
    .registers 26
    # ins_size=16
    move-object v0, v11
    move-object v1, v12
    move-object/from16 v2, v17
    move-object/from16 v3, v18
    move-object/from16 v4, v21
    move-object/from16 v5, v24
    const-string v6, "cliType"
    invoke-static v11, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "mode"
    invoke-static v12, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "fileType"
    invoke-static v2, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "mimeType"
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, uploadMethod
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, status
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    sget-object v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v8, v7, v11, v12, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    const-string v0, ""
    if-nez v13, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v13
    const-string v8, "conversation_id"
    invoke-virtual v7, v8, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v14, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v14
    const-string/jumbo v8, room_id
    invoke-virtual v7, v8, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v15, +007h
    invoke-virtual v15, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, -1
    const-string/jumbo v8, round_index
    invoke-virtual v7, v8, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    if-eqz v16, +007h
    invoke-virtual/range v16, Ljava/lang/Long;->longValue()J
    move-result-wide v8
    goto +3h
    const-wide/16 v8, -1
    const-string v1, "conv_round_id"
    invoke-virtual v7, v1, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v1, "file_type"
    invoke-virtual v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "mime_type"
    invoke-virtual v7, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "file_size_bytes"
    const-wide/16 v2, 0
    move-wide/from16 v8, v19
    invoke-static v8, v9, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v8
    invoke-virtual v7, v1, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v1, upload_method
    invoke-virtual v7, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "duration_ms"
    move-wide/from16 v8, v22
    invoke-static v8, v9, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v2
    invoke-virtual v7, v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v7, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v25, +003h
    goto +3h
    move-object/from16 v0, v25
    const-string v1, "failure_reason"
    invoke-virtual v7, v1, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, voice_discussion_file_upload_end
    move-object v1, v10
    invoke-direct v10, v0, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportTea(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final reportServerToolEnd(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Long  com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)void
    .registers 24
    # ins_size=8
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v23
    const-string v4, "cliType"
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "mode"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "msg"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    const/4 v6, 1
    xor-int/2addr v5, v6
    const/4 v7, 0
    if-eqz v5, +003h
    goto +2h
    move-object v4, v7
    if-nez v4, +003h
    return-void 
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->serverToolReportedTaskIds Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static v6, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-virtual v5, v4, v8, Ljava/util/concurrent/ConcurrentHashMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    if-eqz v5, +003h
    return-void 
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->serverToolStarts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v5, v4, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    const-wide/16 v10, -1
    if-eqz v5, +00eh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->getStartMs()J
    move-result-wide v12
    sub-long/2addr v8, v12
    const-wide/16 v12, 0
    invoke-static v8, v9, v12, v13, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v8
    goto +2h
    move-wide v8, v10
    if-eqz v5, +005h
    const-string v12, "client_observed"
    goto +3h
    const-string v12, "missing_task_start"
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v13
    const-string v14, ""
    if-eqz v13, +010h
    move-object v15, v13
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v15, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v15
    xor-int/2addr v6, v15
    if-eqz v6, +003h
    goto +2h
    move-object v13, v7
    if-nez v13, +00dh
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->getToolName()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +004h
    move-object v13, v14
    goto +2h
    move-object v13, v7
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->resolveToolStatus(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Ljava/lang/String;
    move-result-object v5
    invoke-direct v0, v3, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->resolveFailureReason(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    sget-object v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v7, v6, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    if-nez v19, +004h
    move-object v1, v14
    goto +3h
    move-object/from16 v1, v19
    const-string v2, "conversation_id"
    invoke-virtual v6, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v20, +003h
    goto +3h
    move-object/from16 v14, v20
    const-string/jumbo v1, room_id
    invoke-virtual v6, v1, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v21, +007h
    invoke-virtual/range v21, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, -1
    const-string/jumbo v2, round_index
    invoke-virtual v6, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    if-eqz v22, +006h
    invoke-virtual/range v22, Ljava/lang/Long;->longValue()J
    move-result-wide v10
    const-string v1, "conv_round_id"
    invoke-virtual v6, v1, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v1, task_id
    invoke-virtual v6, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, tool_name
    invoke-virtual v6, v1, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, tool_status
    invoke-virtual v6, v1, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "failure_reason"
    invoke-virtual v6, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, tool_observed_duration_ms
    invoke-virtual v6, v1, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v1, tool_duration_source
    invoke-virtual v6, v1, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, web_search
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->boolValue(Z)Ljava/lang/String;
    move-result-object v1
    const-string v2, "has_search"
    invoke-virtual v6, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, voice_discussion_server_tool_end
    invoke-direct v0, v1, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportTea(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final reportSubtaskEnd(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  int  boolean)void
    .registers 15
    # ins_size=12
    const-string v0, "cliType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sourceTaskId
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v2, v1, v4, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    const-string v4, ""
    if-nez v6, +003h
    move-object v6, v4
    const-string v5, "conversation_id"
    invoke-virtual v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v7, +003h
    move-object v7, v4
    const-string/jumbo v5, room_id
    invoke-virtual v1, v5, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, type
    const-string/jumbo v6, sub_task_request
    invoke-virtual v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "executor"
    const-string v6, "client"
    invoke-virtual v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, source_task_id
    invoke-virtual v1, v5, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v0, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v10, +003h
    move-object v10, v4
    const-string v4, "failure_reason"
    invoke-virtual v1, v4, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-wide/16 v4, 0
    invoke-static v11, v12, v4, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    const-string v6, "duration_ms"
    invoke-virtual v1, v6, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v4, "file_count"
    invoke-virtual v1, v4, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v4, "is_cancelled"
    invoke-virtual v2, v14, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->boolValue(Z)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, voice_discussion_subtask_end
    invoke-direct v3, v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportTea(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final reportSubtaskStart(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int)void
    .registers 10
    # ins_size=8
    const-string v0, "cliType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sourceTaskId
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskDescription
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v1, v0, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    const-string v3, ""
    if-nez v5, +003h
    move-object v5, v3
    const-string v4, "conversation_id"
    invoke-virtual v0, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v6, +003h
    move-object v6, v3
    const-string/jumbo v3, room_id
    invoke-virtual v0, v3, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, type
    const-string/jumbo v4, sub_task_request
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "executor"
    const-string v4, "client"
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, source_task_id
    invoke-virtual v0, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, task_description_length
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v3, "file_count"
    invoke-virtual v0, v3, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v3, voice_discussion_subtask_start
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportTea(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final reportWindowStateClick(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=7
    const-string v0, "cliType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "action"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, windowStateBeforeClick
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v2, v1, v4, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    const-string v4, ""
    if-nez v6, +003h
    move-object v6, v4
    const-string v5, "conversation_id"
    invoke-virtual v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v7, +003h
    move-object v7, v4
    const-string/jumbo v4, room_id
    invoke-virtual v1, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v0, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, window_state_before_click
    invoke-virtual v1, v4, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, voice_discussion_window_state_click
    invoke-direct v3, v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportTea(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
