# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
.super Ljava/lang/Object;
.source "VoiceAttemptMetricsTracker.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
.field private static final ERROR_REASON_THROWABLE:Ljava/lang/String;
.field public static final EVENT_ATTEMPT_END:Ljava/lang/String;
.field private static final FINAL_SOURCE_CANCEL:Ljava/lang/String;
.field public static final FINAL_SOURCE_CONV_THINKING:Ljava/lang/String;
.field public static final FINAL_SOURCE_CURRENT_TEXT_FALLBACK:Ljava/lang/String;
.field public static final FINAL_SOURCE_EMPTY:Ljava/lang/String;
.field public static final FINAL_SOURCE_PARAGRAPH:Ljava/lang/String;
.field private static final FINAL_SOURCE_UNKNOWN:Ljava/lang/String;
.field private static final FIRST_VOICE_VOLUME_THRESHOLD:I
.field public static final INPUT_STATE_UNKNOWN:Ljava/lang/String;
.field private static final MAX_FAILURE_REASON_LENGTH:I
.field public static final OUTCOME_AUTO_SEND:Ljava/lang/String;
.field public static final OUTCOME_CANCEL:Ljava/lang/String;
.field public static final OUTCOME_EMPTY_TEXT:Ljava/lang/String;
.field public static final OUTCOME_ERROR:Ljava/lang/String;
.field public static final OUTCOME_FILL_INPUT:Ljava/lang/String;
.field public static final OUTCOME_START_FAILED:Ljava/lang/String;
.field private static final PERF_MISSING_VALUE:J
.field private static final SILENT_VOLUME_THRESHOLD:I
.field public static final START_PATH_CACHED_JOIN_FIRST:Ljava/lang/String;
.field public static final START_PATH_COLD_API:Ljava/lang/String;
.field private static final START_PATH_UNKNOWN:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private _paragraphCount:I
.field private attemptReported:Z
.field private attemptRoomId:Ljava/lang/String;
.field private attemptStartElapsedMs:J
.field private attemptTaskId:Ljava/lang/String;
.field private final elapsedRealtime:Lkotlin/jvm/functions/Function0;
.field private finalSource:Ljava/lang/String;
.field private finalTextElapsedMs:J
.field private finalTextLength:I
.field private firstRecognizedTextElapsedMs:J
.field private firstSubvElapsedMs:J
.field private firstVoiceVolumeElapsedMs:J
.field private lastRecognizedTextElapsedMs:J
.field private final logEventForLocalDebug:Lkotlin/jvm/functions/Function1;
.field private maxVolume:I
.field private final reportEvent:Lkotlin/jvm/functions/Function2;
.field private silentVolumeSampleCount:I
.field private startPath:Ljava/lang/String;
.field private final traceIdFactory:Lkotlin/jvm/functions/Function0;
.field private transcriptionTraceId:Ljava/lang/String;
.field private voiceReleaseElapsedMs:J
.field private volumeSampleCount:I
.field private volumeSum:J


.method public static synthetic $r8$lambda$GVQ3HNHy3Lq_LuzCj0wZ4PN6XgE()long
    .registers 2
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_init_$lambda$0()J
    move-result-wide v0
    return-wide v0
.end method

.method public static synthetic $r8$lambda$W684wVe2q3ZJsy3VH3HMgrC_GLM()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_init_$lambda$1()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$XK2RJMReDXPn8ewSy0XLz0KTAm4(org.json.JSONObject)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_init_$lambda$3(Lorg/json/JSONObject;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$bRXDNbkuk0wJGY2-ZeVrA7tKlos(java.lang.String  org.json.JSONObject)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_init_$lambda$2(Ljava/lang/String; Lorg/json/JSONObject;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=5
    const-string v0, "elapsedRealtime"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, traceIdFactory
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, reportEvent
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "logEventForLocalDebug"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->traceIdFactory Lkotlin/jvm/functions/Function0;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->reportEvent Lkotlin/jvm/functions/Function2;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->logEventForLocalDebug Lkotlin/jvm/functions/Function1;
    const-string v2, ""
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->transcriptionTraceId Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptRoomId Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptTaskId Ljava/lang/String;
    const/4 v2, -1
    iput v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->maxVolume I
    const-string/jumbo v2, unknown
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalSource Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->startPath Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +007h
    new-instance v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda0;-><init>()V
    and-int/lit8 v6, v5, 2
    if-eqz v6, +007h
    new-instance v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda1;
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda1;-><init>()V
    and-int/lit8 v6, v5, 4
    if-eqz v6, +007h
    new-instance v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda2;
    invoke-direct v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda2;-><init>()V
    and-int/lit8 v5, v5, 8
    if-eqz v5, +007h
    new-instance v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda3;
    invoke-direct v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda3;-><init>()V
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final _init_$lambda$0()long
    .registers 2
    # ins_size=0
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    return-wide v0
.end method

.method private static final _init_$lambda$1()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final _init_$lambda$2(java.lang.String  org.json.JSONObject)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "event"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final _init_$lambda$3(org.json.JSONObject)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "params"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->access$logAttemptEndForLocalDebug(Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion; Lorg/json/JSONObject;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final averageVolume()double
    .registers 6
    # ins_size=1
    iget v0, v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSampleCount I
    if-lez v0, +008h
    iget-wide v1, v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSum J
    long-to-double v1, v1
    int-to-double v3, v0
    div-double/2addr v1, v3
    goto +3h
    const-wide/high16 v1, -4616189618054758400
    return-wide v1
.end method

.method private final computeJoinRoomMs(com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot)long
    .registers 8
    # ins_size=2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfJoinRoomTimestamp()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +018h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfJoinRoomSuccessTimestamp()J
    move-result-wide v0
    cmp-long v0, v0, v2
    if-lez v0, +010h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfJoinRoomSuccessTimestamp()J
    move-result-wide v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfJoinRoomTimestamp()J
    move-result-wide v4
    sub-long/2addr v0, v4
    invoke-static v0, v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, -1
    return-wide v0
.end method

.method private final computeStartTotalMs(com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot)long
    .registers 9
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getVoiceStartTimestamp()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    const-wide/16 v4, -1
    if-gtz v0, +003h
    return-wide v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfPublishStreamTimestamp()J
    move-result-wide v0
    cmp-long v0, v0, v2
    if-lez v0, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfPublishStreamTimestamp()J
    move-result-wide v0
    goto +fh
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getVoiceReleaseTimestamp()J
    move-result-wide v0
    cmp-long v0, v0, v2
    if-lez v0, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getVoiceReleaseTimestamp()J
    move-result-wide v0
    goto +2h
    move-wide v0, v2
    cmp-long v6, v0, v2
    if-lez v6, +00bh
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getVoiceStartTimestamp()J
    move-result-wide v4
    sub-long/2addr v0, v4
    invoke-static v0, v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    return-wide v4
.end method

.method private final computeStartVoiceChatRequestMs(com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot)long
    .registers 8
    # ins_size=2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfStartVoiceChatTimestamp()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +018h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfApiRequestEndTimestamp()J
    move-result-wide v0
    cmp-long v0, v0, v2
    if-lez v0, +010h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfApiRequestEndTimestamp()J
    move-result-wide v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getPerfStartVoiceChatTimestamp()J
    move-result-wide v4
    sub-long/2addr v0, v4
    invoke-static v0, v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, -1
    return-wide v0
.end method

.method private final deltaFromAttemptStart(long)long
    .registers 8
    # ins_size=3
    const-wide/16 v0, 0
    cmp-long v2, v6, v0
    if-lez v2, +00eh
    iget-wide v2, v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptStartElapsedMs J
    cmp-long v4, v2, v0
    if-lez v4, +008h
    sub-long/2addr v6, v2
    invoke-static v6, v7, v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v6
    goto +3h
    const-wide/16 v6, -1
    return-wide v6
.end method

.method private final hasReceivedVoiceDuringAttempt(com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot)boolean
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getHasReceiveVoice()Z
    move-result v0
    if-nez v0, +01fh
    iget-wide v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstSubvElapsedMs J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-gtz v0, +017h
    iget-wide v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstRecognizedTextElapsedMs J
    cmp-long v0, v0, v2
    if-gtz v0, +011h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getSubvMessageCount()I
    move-result v0
    if-gtz v0, +00bh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getAsrCallbackCount()I
    move-result v5
    if-lez v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    const/4 v5, 1
    return v5
.end method

.method private final silentRatio()double
    .registers 6
    # ins_size=1
    iget v0, v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSampleCount I
    if-lez v0, +008h
    iget v1, v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->silentVolumeSampleCount I
    int-to-double v1, v1
    int-to-double v3, v0
    div-double/2addr v1, v3
    goto +3h
    const-wide/high16 v1, -4616189618054758400
    return-wide v1
.end method

.method public final captureVoiceChatData(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, roomId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptRoomId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptTaskId Ljava/lang/String;
    return-void 
.end method

.method public final markFinalText(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, source
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalTextElapsedMs J
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalTextLength I
    iput-object v4, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalSource Ljava/lang/String;
    return-void 
.end method

.method public final onAudioVolume(int)void
    .registers 8
    # ins_size=2
    iget-wide v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptStartElapsedMs J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +043h
    iget-boolean v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptReported Z
    if-eqz v0, +003h
    goto +3dh
    const/4 v0, 0
    const/16 v1, 255
    invoke-static v7, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v7
    iget v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSampleCount I
    add-int/lit8 v0, v0, 1
    iput v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSampleCount I
    iget-wide v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSum J
    int-to-long v4, v7
    add-long/2addr v0, v4
    iput-wide v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSum J
    iget v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->maxVolume I
    invoke-static v0, v7, Ljava/lang/Math;->max(I I)I
    move-result v0
    iput v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->maxVolume I
    const/4 v0, 5
    if-ge v7, v0, +008h
    iget v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->silentVolumeSampleCount I
    add-int/lit8 v0, v0, 1
    iput v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->silentVolumeSampleCount I
    iget-wide v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstVoiceVolumeElapsedMs J
    cmp-long v0, v0, v2
    if-nez v0, +014h
    const/16 v0, 13
    if-lt v7, v0, +010h
    iget-object v7, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Number;
    invoke-virtual v7, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iput-wide v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstVoiceVolumeElapsedMs J
    return-void 
.end method

.method public final onFirstSubv()void
    .registers 5
    # ins_size=1
    iget-wide v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstSubvElapsedMs J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-nez v0, +010h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iput-wide v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstSubvElapsedMs J
    return-void 
.end method

.method public final onParagraph()void
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_paragraphCount I
    add-int/lit8 v0, v0, 1
    iput v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_paragraphCount I
    return-void 
.end method

.method public final onRecognizedText(boolean)void
    .registers 8
    # ins_size=2
    if-nez v7, +003h
    return-void 
    iget-object v7, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Number;
    invoke-virtual v7, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iget-wide v2, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstRecognizedTextElapsedMs J
    const-wide/16 v4, 0
    cmp-long v7, v2, v4
    if-nez v7, +004h
    iput-wide v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstRecognizedTextElapsedMs J
    iput-wide v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->lastRecognizedTextElapsedMs J
    return-void 
.end method

.method public final onVoiceRelease()void
    .registers 5
    # ins_size=1
    iget-wide v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->voiceReleaseElapsedMs J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-nez v0, +010h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iput-wide v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->voiceReleaseElapsedMs J
    return-void 
.end method

.method public final paragraphCount$conversation_mainlandRelease()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_paragraphCount I
    return v0
.end method

.method public final recordingDurationMs$conversation_mainlandRelease()long
    .registers 8
    # ins_size=1
    iget-wide v0, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->voiceReleaseElapsedMs J
    const-wide/16 v2, 0
    cmp-long v4, v0, v2
    if-lez v4, +00eh
    iget-wide v4, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptStartElapsedMs J
    cmp-long v6, v4, v2
    if-lez v6, +008h
    sub-long/2addr v0, v4
    invoke-static v0, v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, -1
    return-wide v0
.end method

.method public final report(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot)void
    .registers 22
    # ins_size=5
    move-object/from16 v1, v17
    move-object/from16 v0, v18
    move-object/from16 v2, v19
    move-object/from16 v3, v20
    move-object/from16 v4, v21
    const-string v5, "outcome"
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "failureReason"
    invoke-static v2, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "inputStateWhenFinal"
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, session
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-wide v6, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptStartElapsedMs J
    const-wide/16 v8, 0
    cmp-long v6, v6, v8
    if-lez v6, +163h
    iget-boolean v6, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptReported Z
    if-eqz v6, +004h
    goto/16 +15dh
    const/4 v6, 1
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptReported Z
    iget-object v6, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v6, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->longValue()J
    move-result-wide v6
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->recordingDurationMs$conversation_mainlandRelease()J
    move-result-wide v10
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->voiceReleaseElapsedMs J
    cmp-long v14, v12, v8
    if-lez v14, +010h
    iget-wide v8, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalTextElapsedMs J
    const-wide/16 v14, 0
    cmp-long v16, v8, v14
    if-lez v16, +008h
    sub-long/2addr v8, v12
    invoke-static v8, v9, v14, v15, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v8
    goto +3h
    const-wide/16 v8, -1
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalTextElapsedMs J
    const-wide/16 v14, 0
    cmp-long v16, v12, v14
    if-lez v16, +009h
    sub-long v12, v6, v12
    invoke-static v12, v13, v14, v15, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v12
    goto +3h
    const-wide/16 v12, -1
    iget-wide v14, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptStartElapsedMs J
    sub-long/2addr v6, v14
    const-wide/16 v14, 0
    invoke-static v6, v7, v14, v15, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v6
    new-instance v14, Lorg/json/JSONObject;
    invoke-direct v14, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v15, trace_id
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->transcriptionTraceId Ljava/lang/String;
    invoke-virtual v14, v15, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "conversation_id"
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getConversationId()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v3, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, room_id
    iget-object v15, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptRoomId Ljava/lang/String;
    invoke-virtual v14, v3, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, task_id
    iget-object v15, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptTaskId Ljava/lang/String;
    invoke-virtual v14, v3, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, start_path
    iget-object v15, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->startPath Ljava/lang/String;
    invoke-virtual v14, v3, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v14, v5, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "failure_reason"
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->access$normalizeFailureReason(Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "recording_duration_ms"
    invoke-virtual v14, v0, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, start_total_ms
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->computeStartTotalMs(Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;)J
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, start_voice_chat_request_ms
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->computeStartVoiceChatRequestMs(Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;)J
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "join_room_ms"
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->computeJoinRoomMs(Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;)J
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "first_voice_volume_ms"
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstVoiceVolumeElapsedMs J
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->deltaFromAttemptStart(J)J
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "first_subv_ms"
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstSubvElapsedMs J
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->deltaFromAttemptStart(J)J
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "first_recognized_text_ms"
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstRecognizedTextElapsedMs J
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->deltaFromAttemptStart(J)J
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "last_recognized_text_ms"
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->lastRecognizedTextElapsedMs J
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->deltaFromAttemptStart(J)J
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "release_to_final_ms"
    invoke-virtual v14, v0, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "final_to_apply_ms"
    invoke-virtual v14, v0, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, total_duration_ms
    invoke-virtual v14, v0, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "recognized_text_length"
    iget v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalTextLength I
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "asr_callback_count"
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getAsrCallbackCount()I
    move-result v2
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v0, subv_message_count
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->getSubvMessageCount()I
    move-result v2
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "paragraph_count"
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->paragraphCount$conversation_mainlandRelease()I
    move-result v2
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "avg_volume"
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->averageVolume()D
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    const-string v0, "max_volume"
    iget v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->maxVolume I
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v0, silent_ratio
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->silentRatio()D
    move-result-wide v2
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    const-string v0, "network_rtt_ms"
    const-wide/16 v2, -1
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "packet_loss"
    invoke-virtual v14, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "input_state_when_final"
    move-object/from16 v2, v20
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "final_source"
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalSource Ljava/lang/String;
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "has_receive_voice"
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->hasReceivedVoiceDuringAttempt(Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;)Z
    move-result v2
    if-eqz v2, +005h
    const-string v2, "1"
    goto +3h
    const-string v2, "0"
    invoke-virtual v14, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->logEventForLocalDebug Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v14, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->reportEvent Lkotlin/jvm/functions/Function2;
    const-string/jumbo v2, voice_transcription_attempt_end
    invoke-interface v0, v2, v14, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +ah
    move-exception v0
    const-string v2, "VoiceChatSession"
    const-string/jumbo v3, reportAttemptEnd failed
    invoke-static v2, v3, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x30
.end method

.method public final reset()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->traceIdFactory Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->transcriptionTraceId Ljava/lang/String;
    const-string v0, ""
    iput-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptRoomId Ljava/lang/String;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptTaskId Ljava/lang/String;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptStartElapsedMs J
    const-wide/16 v0, 0
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->voiceReleaseElapsedMs J
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalTextElapsedMs J
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstVoiceVolumeElapsedMs J
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstSubvElapsedMs J
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->firstRecognizedTextElapsedMs J
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->lastRecognizedTextElapsedMs J
    const/4 v2, 0
    iput v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSampleCount I
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->volumeSum J
    const/4 v0, -1
    iput v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->maxVolume I
    iput v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->silentVolumeSampleCount I
    iput v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalTextLength I
    const-string/jumbo v0, unknown
    iput-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalSource Ljava/lang/String;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->startPath Ljava/lang/String;
    iput v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->_paragraphCount I
    iput-boolean v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->attemptReported Z
    return-void 
.end method

.method public final setFinalSourceCancel()void
    .registers 2
    # ins_size=1
    const-string v0, "cancel"
    iput-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->finalSource Ljava/lang/String;
    return-void 
.end method

.method public final setStartPath(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "path"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->startPath Ljava/lang/String;
    return-void 
.end method
