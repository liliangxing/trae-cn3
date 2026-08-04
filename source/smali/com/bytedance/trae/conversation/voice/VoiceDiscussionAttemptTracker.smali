# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
.super Ljava/lang/Object;
.source "VoiceDiscussionAttemptTracker.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
.field public static final EVENT_ATTEMPT_END:Ljava/lang/String;
.field private static final FIRST_VOICE_VOLUME_THRESHOLD:F
.field private static final MAX_FAILURE_REASON_LENGTH:I
.field private static final MISSING_STAGE_MS:J
.field private static final TAG:Ljava/lang/String;
.field private final elapsedRealtime:Lkotlin/jvm/functions/Function0;
.field private final logEvent:Lkotlin/jvm/functions/Function2;
.field private final reportEvent:Lkotlin/jvm/functions/Function2;
.field private state:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;


.method public static synthetic $r8$lambda$-sJPyX3xJQ_ZoMI54fQRnv5uWII(java.lang.String  java.util.Map)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->_init_$lambda$3(Ljava/lang/String; Ljava/util/Map;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Z9LZWnIdVbxCHi1zfJJXsVbL4AE()long
    .registers 2
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->_init_$lambda$0()J
    move-result-wide v0
    return-wide v0
.end method

.method public static synthetic $r8$lambda$fiRMG73rRebIvtszm5IiPCupRsA(java.lang.String  java.util.Map)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->_init_$lambda$4(Ljava/lang/String; Ljava/util/Map;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2)void
    .registers 6
    # ins_size=5
    const-string v0, "initialState"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "elapsedRealtime"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, reportEvent
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "logEvent"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->reportEvent Lkotlin/jvm/functions/Function2;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->logEvent Lkotlin/jvm/functions/Function2;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +007h
    new-instance v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda0;-><init>()V
    and-int/lit8 v6, v5, 4
    if-eqz v6, +007h
    new-instance v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda1;
    invoke-direct v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda1;-><init>()V
    and-int/lit8 v5, v5, 8
    if-eqz v5, +007h
    new-instance v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda2;
    invoke-direct v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda2;-><init>()V
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;-><init>(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final _init_$lambda$0()long
    .registers 2
    # ins_size=0
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    return-wide v0
.end method

.method private static final _init_$lambda$3(java.lang.String  java.util.Map)kotlin.Unit
    .registers 6
    # ins_size=2
    const-string v0, "event"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +016h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    invoke-virtual v1, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -19h
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final _init_$lambda$4(java.lang.String  java.util.Map)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v1, ": "
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "VoiceDiscussionAttempt"
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final baseParams()java.util.Map
    .registers 7
    # ins_size=1
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getContext()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->getMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v2, v3, +005h
    const-string v2, "code"
    goto +3h
    const-string v2, "mtc"
    iget-object v3, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v3
    const-string v4, "attempt_id"
    invoke-virtual v0, v4, v3, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    const-string v4, "cli_type"
    invoke-virtual v0, v4, v3, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->getMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v3
    const-string v4, "mode"
    invoke-virtual v0, v4, v3, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v3, "chat_mode"
    invoke-virtual v0, v3, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v4, 95
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "env_mode"
    invoke-virtual v0, v3, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v2, "conversation_id"
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->getConversationId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v2, room_id
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession()Z
    move-result v2
    const-string v3, "1"
    const-string v4, "0"
    if-eqz v2, +004h
    move-object v2, v3
    goto +2h
    move-object v2, v4
    const-string v5, "is_new_session"
    invoke-virtual v0, v5, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->getHasSeenIntro()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v4
    const-string v1, "has_seen_intro"
    invoke-virtual v0, v1, v3, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v0, Ljava/util/Map;
    return-object v0
.end method

.method private final canRecord()boolean
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    if-eqz v0, +017h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStartedAtElapsedMs()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v0, v2, v4
    if-lez v0, +00bh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getTerminalReported()Z
    move-result v0
    if-nez v0, +003h
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final elapsedSinceStart()long
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStartedAtElapsedMs()J
    move-result-wide v2
    sub-long/2addr v0, v2
    const-wide/16 v2, 0
    invoke-static v0, v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v0
    return-wide v0
.end method

.method public static synthetic finish$default(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptOutcome  java.lang.String  int  java.lang.Object)boolean
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finish(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome; Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method private final inferOutcome()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptOutcome
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getFurthestStage()Ljava/lang/String;
    move-result-object v0
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->stageOrder(Ljava/lang/String;)I
    move-result v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getLatestSignal()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +016h
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->PERMISSION_GRANTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ROUND_REPORTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v3
    if-lt v0, v3, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->SUCCESS Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +0e7h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->THINKING_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v3
    if-lt v0, v3, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ROUND_NOT_FINALIZED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +0dbh
    if-eqz v2, +00eh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RECORDING_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-ge v0, v2, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +0cdh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +0bdh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RTC_JOINED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +012h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->RTC_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_RUNTIME_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +0a5h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->FIRST_VOICE_DETECTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->SPEECH_NO_THINKING Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +099h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RTC_JOINED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->JOINED_NO_SPEECH Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +08dh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->DISCUSSION_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +012h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto/16 +075h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->DISCUSSION_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +011h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->RTC_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_JOIN_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto +5dh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->DISCUSSION_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->START_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto +52h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +011h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto +3bh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v2
    if-lt v0, v2, +011h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto +24h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->INTRO_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v1
    if-lt v0, v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->INTRO_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto +19h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v1
    if-lt v0, v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ACTIVITY_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto +eh
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_LAUNCH_REQUESTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v1
    if-lt v0, v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ACTIVITY_NOT_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->UNKNOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    return-object v0
.end method

.method public static synthetic recordSignal$default(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal  java.lang.String  int  int  java.lang.Object)boolean
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordSignal(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I)Z
    move-result v0
    return v0
.end method

.method private final reportSafely(java.lang.String  java.util.Map)void
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->reportEvent Lkotlin/jvm/functions/Function2;
    invoke-interface v0, v4, v5, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->logEvent Lkotlin/jvm/functions/Function2;
    invoke-interface v0, v4, v5, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +19h
    move-exception v5
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, report failed: event=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "VoiceDiscussionAttempt"
    invoke-virtual v0, v1, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final stageOrder(java.lang.String)int
    .registers 5
    # ins_size=2
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -015h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v4
    goto +2h
    const/4 v4, -1
    return v4
.end method

.method public final synchronized finish(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptOutcome  java.lang.String)boolean
    .registers 21
    # ins_size=3
    move-object/from16 v1, v18
    move-object/from16 v0, v20
    monitor-enter v18
    const-string v2, "outcome"
    move-object/from16 v3, v19
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "failureReason"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v18, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->canRecord()Z
    move-result v2
    if-nez v2, +005h
    monitor-exit v18
    const/4 v0, 0
    return v0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;->access$normalizeFailureReason(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    const/4 v5, 0
    const-wide/16 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 1
    const/16 v16, 511
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->copy$default(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    const-string/jumbo v2, voice_discussion_attempt_end
    invoke-direct/range v18, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->baseParams()Ljava/util/Map;
    move-result-object v4
    const-string v5, "outcome"
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-interface v4, v5, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v3, "last_stage"
    iget-object v5, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getFurthestStage()Ljava/lang/String;
    move-result-object v5
    invoke-interface v4, v3, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v3, "latest_signal"
    iget-object v5, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getLatestSignal()Ljava/lang/String;
    move-result-object v5
    invoke-interface v4, v3, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v3, "failure_reason"
    invoke-interface v4, v3, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "error_code"
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getErrorCode()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v4, v0, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v0, total_duration_ms
    invoke-direct/range v18, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->elapsedSinceStart()J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-interface v4, v0, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v0, stage_count
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v3
    invoke-interface v3, Ljava/util/Map;->size()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v4, v0, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +040h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "_ms"
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    iget-object v6, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v6
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-interface v6, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Long;
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v6
    goto +3h
    const-wide/16 v6, -1
    invoke-static v6, v7, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-interface v4, v5, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -43h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-direct v1, v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->reportSafely(Ljava/lang/String; Ljava/util/Map;)V
    monitor-exit v18
    const/4 v0, 1
    return v0
    move-exception v0
    monitor-exit v18
    throw v0
    :try_start_0x5
    :try_start_0x1a
.end method

.method public final synchronized finishInferred()boolean
    .registers 3
    # ins_size=1
    monitor-enter v2
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->inferOutcome()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    if-eq v0, v1, +019h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    if-eq v0, v1, +015h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    if-eq v0, v1, +011h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_JOIN_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    if-eq v0, v1, +00dh
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_RUNTIME_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    if-eq v0, v1, +009h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    if-ne v0, v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-eqz v1, +009h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getLatestFailureReason()Ljava/lang/String;
    move-result-object v1
    goto +3h
    const-string v1, ""
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finish(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome; Ljava/lang/String;)Z
    move-result v0
    monitor-exit v2
    return v0
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x1
.end method

.method public final synchronized onLocalAudioVolume(float)boolean
    .registers 3
    # ins_size=2
    monitor-enter v1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;->isVoiceDetected(F)Z
    move-result v2
    if-eqz v2, +01eh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RTC_JOINED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-interface v2, v0, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00ch
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->FIRST_VOICE_DETECTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    monitor-exit v1
    return v2
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public final synchronized recordSignal(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal  java.lang.String  int)boolean
    .registers 23
    # ins_size=4
    move-object/from16 v1, v19
    move-object/from16 v0, v21
    monitor-enter v19
    const-string/jumbo v2, signal
    move-object/from16 v3, v20
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "failureReason"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->canRecord()Z
    move-result v2
    const/4 v4, 0
    if-eqz v2, +060h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getRecordedSignals()Ljava/util/Set;
    move-result-object v2
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-interface v2, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +4eh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;->access$normalizeFailureReason(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    iget-object v5, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    const/4 v6, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getRecordedSignals()Ljava/util/Set;
    move-result-object v0
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/collections/SetsKt;->plus(Ljava/util/Set; Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v11
    const/4 v12, 0
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v13
    invoke-static/range v22, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    const/4 v3, 1
    if-eqz v2, +003h
    move v4, v3
    if-eqz v4, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +7h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getErrorCode()I
    move-result v0
    move v15, v0
    const/16 v16, 0
    const/16 v17, 559
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->copy$default(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    monitor-exit v19
    return v3
    monitor-exit v19
    return v4
    move-exception v0
    monitor-exit v19
    throw v0
    :try_start_0x5
.end method

.method public final synchronized recordStage(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage)boolean
    .registers 21
    # ins_size=2
    move-object/from16 v1, v19
    move-object/from16 v0, v20
    monitor-enter v19
    const-string/jumbo v2, stage
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->canRecord()Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +088h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v2
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    goto/16 +076h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getFurthestStage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getOrder$conversation_mainlandRelease()I
    move-result v4
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->stageOrder(Ljava/lang/String;)I
    move-result v5
    if-lt v4, v5, +006h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v2
    move-object v11, v2
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->PERMISSION_GRANTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const/16 v18, 1
    if-ne v0, v2, +016h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getLatestSignal()Ljava/lang/String;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    move/from16 v3, v18
    iget-object v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    const/4 v5, 0
    const-wide/16 v6, 0
    const/4 v8, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v2
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->elapsedSinceStart()J
    move-result-wide v9
    invoke-static v9, v10, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v9
    invoke-static v0, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v9
    const/4 v10, 0
    if-eqz v3, +005h
    const-string v0, ""
    goto +7h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getLatestSignal()Ljava/lang/String;
    move-result-object v0
    move-object v12, v0
    if-eqz v3, +005h
    const-string v0, ""
    goto +7h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getLatestFailureReason()Ljava/lang/String;
    move-result-object v0
    move-object v13, v0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 791
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->copy$default(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    monitor-exit v19
    return v18
    monitor-exit v19
    return v3
    move-exception v0
    monitor-exit v19
    throw v0
    :try_start_0x5
.end method

.method public final synchronized snapshot()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState
    .registers 2
    # ins_size=1
    monitor-enter v1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    monitor-exit v1
    return-object v0
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x1
.end method

.method public final synchronized updateContext(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext)void
    .registers 18
    # ins_size=2
    move-object/from16 v1, v16
    monitor-enter v16
    const-string v0, "context"
    move-object/from16 v6, v17
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->canRecord()Z
    move-result v0
    if-nez v0, +004h
    monitor-exit v16
    return-void 
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 1019
    const/4 v15, 0
    move-object/from16 v6, v17
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->copy$default(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->state Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    monitor-exit v16
    return-void 
    move-exception v0
    monitor-exit v16
    throw v0
    :try_start_0x3
    :try_start_0x12
.end method
