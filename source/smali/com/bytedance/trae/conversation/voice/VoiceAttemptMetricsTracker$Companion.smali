# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
.super Ljava/lang/Object;
.source "VoiceAttemptMetricsTracker.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$logAttemptEndForLocalDebug(com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$Companion  org.json.JSONObject)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->logAttemptEndForLocalDebug(Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static final synthetic access$normalizeFailureReason(com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$Companion  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->normalizeFailureReason(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final logAttemptEndForLocalDebug(org.json.JSONObject)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method private final normalizeFailureReason(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    const/16 v1, 13
    const/16 v2, 32
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const/16 v7, 10
    const/16 v8, 32
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v13
    const/16 v0, 120
    invoke-static v13, v0, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method public final failureReasonFor(java.lang.Throwable)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "error"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, "Throwable"
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->normalizeFailureReason(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final reportImmediate(java.lang.String  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=4
    const-string/jumbo v0, unknown
    const-string v1, ""
    const-string v2, "outcome"
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "failureReason"
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "inputStateWhenFinal"
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, trace_id
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v5
    invoke-virtual v5, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "conversation_id"
    invoke-virtual v3, v4, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, room_id
    invoke-virtual v3, v4, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, task_id
    invoke-virtual v3, v4, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, start_path
    invoke-virtual v3, v1, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v2, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "failure_reason"
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->normalizeFailureReason(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "recording_duration_ms"
    const-wide/16 v1, -1
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v7, start_total_ms
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v7, start_voice_chat_request_ms
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "join_room_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "first_voice_volume_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "first_subv_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "first_recognized_text_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "last_recognized_text_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "release_to_final_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "final_to_apply_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v7, total_duration_ms
    const-wide/16 v4, 0
    invoke-virtual v3, v7, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "recognized_text_length"
    const/4 v8, 0
    invoke-virtual v3, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v7, "asr_callback_count"
    invoke-virtual v3, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v7, subv_message_count
    invoke-virtual v3, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v7, "paragraph_count"
    invoke-virtual v3, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v7, "avg_volume"
    const-wide/high16 v4, -4616189618054758400
    invoke-virtual v3, v7, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    const-string v7, "max_volume"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v7, silent_ratio
    invoke-virtual v3, v7, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    const-string v7, "network_rtt_ms"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "packet_loss"
    invoke-virtual v3, v7, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v7, "input_state_when_final"
    invoke-virtual v3, v7, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "final_source"
    invoke-virtual v3, v7, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "has_receive_voice"
    const-string v8, "0"
    invoke-virtual v3, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->logAttemptEndForLocalDebug(Lorg/json/JSONObject;)V
    sget-object v7, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v8, voice_transcription_attempt_end
    invoke-virtual v7, v8, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +ah
    move-exception v7
    const-string v8, "VoiceChatSession"
    const-string/jumbo v9, reportImmediateAttemptEnd failed
    invoke-static v8, v9, v7, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x14
.end method
