# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
.super Ljava/lang/Object;
.source "TranscriptionVoiceManager.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;
.field private static final EVENT_SESSION_PERF:Ljava/lang/String;
.field private static final EVENT_START_PERF:Ljava/lang/String;
.field public static final OUTCOME_AUTO_SEND:Ljava/lang/String;
.field public static final OUTCOME_CANCEL:Ljava/lang/String;
.field public static final OUTCOME_EMPTY_TEXT:Ljava/lang/String;
.field public static final OUTCOME_ERROR:Ljava/lang/String;
.field public static final OUTCOME_FILL_INPUT:Ljava/lang/String;
.field public static final OUTCOME_START_FAILED:Ljava/lang/String;
.field private static final POLL_INTERVAL_MS:J
.field private static final TAG:Ljava/lang/String;
.field private asrCallbackCount:I
.field private final attemptTracker:Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
.field private botCompleteText:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private currentRecognizedText:Ljava/lang/String;
.field private definiteText:Ljava/lang/String;
.field private hasReceiveVoice:Z
.field private hasStartedVoiceChat:Z
.field private hasStop:Z
.field private isWaitingBotResponse:Z
.field private listener:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
.field private perfApiRequestEndTimestamp:J
.field private perfJoinRoomSuccessTimestamp:J
.field private perfJoinRoomTimestamp:J
.field private perfPublishStreamTimestamp:J
.field private perfStartVoiceChatTimestamp:J
.field private final rtcListener:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field private subvMessageCount:I
.field private final uiScope:Lkotlinx/coroutines/CoroutineScope;
.field private voiceChat:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field private voiceReleaseTimestamp:J
.field private voiceStartCaptureDuration:J
.field private voiceStartTimestamp:J
.field private waitBotJob:Lkotlinx/coroutines/Job;
.field private final xAppId:Ljava/lang/String;


.method public static synthetic $r8$lambda$yqQZ7YNtR5NthlYolipf6IMa3-A(byte)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->handleSubvMessage$lambda$7(B)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->Companion Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;-><init>(Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string/jumbo v0, xAppId
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, Ljava/lang/Object;-><init>()V
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->xAppId Ljava/lang/String;
    new-instance v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    invoke-direct v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->rtcListener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    const/4 v8, 0
    const/4 v0, 1
    invoke-static v8, v0, v8, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    invoke-virtual v2, v0, Lkotlinx/coroutines/CoroutineDispatcher;->limitedParallelism(I)Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v1, v2, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    iput-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    invoke-static v8, v0, v8, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    invoke-virtual v0, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v8, v0, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v8
    invoke-static v8, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v8
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v8
    invoke-virtual v8, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v0, toString(...)
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->conversationId Ljava/lang/String;
    const-string v8, ""
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->definiteText Ljava/lang/String;
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->currentRecognizedText Ljava/lang/String;
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->botCompleteText Ljava/lang/String;
    new-instance v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v8
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const-string v1, "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;-><init>(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$buildSessionSnapshot(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->buildSessionSnapshot()Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$emitError(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.Throwable)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitError(Ljava/lang/Throwable;)V
    return-void 
.end method

.method public static final synthetic access$emitFinalText(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitFinalText(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$emitLocalAudioVolume(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitLocalAudioVolume(I)V
    return-void 
.end method

.method public static final synthetic access$emitRecognizedText(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitRecognizedText(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$emitStatus(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$Status)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    return-void 
.end method

.method public static final synthetic access$getAsrCallbackCount$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->asrCallbackCount I
    return v0
.end method

.method public static final synthetic access$getAttemptTracker$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    return-object v0
.end method

.method public static final synthetic access$getBotCompleteText$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->botCompleteText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getConversationId$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCurrentRecognizedText$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->currentRecognizedText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getDefiniteText$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->definiteText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getHasReceiveVoice$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasReceiveVoice Z
    return v0
.end method

.method public static final synthetic access$getHasStartedVoiceChat$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    return v0
.end method

.method public static final synthetic access$getPerfPublishStreamTimestamp$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfPublishStreamTimestamp J
    return-wide v0
.end method

.method public static final synthetic access$getRtcListener$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$rtcListener$1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->rtcListener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    return-object v0
.end method

.method public static final synthetic access$getScope$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)kotlinx.coroutines.CoroutineScope
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    return-object v0
.end method

.method public static final synthetic access$getUiScope$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)kotlinx.coroutines.CoroutineScope
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    return-object v0
.end method

.method public static final synthetic access$getWaitBotJob$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method public static final synthetic access$getXAppId$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->xAppId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$handleBinaryMessage(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String  byte[])void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->handleBinaryMessage(Ljava/lang/String; [B)V
    return-void 
.end method

.method public static final synthetic access$handleJoinRefused(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->handleJoinRefused(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    return-void 
.end method

.method public static final synthetic access$isVoiceChatDataValid(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  com.bytedance.trae.conversation.voice.network.StartVoiceChatData)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isVoiceChatDataValid(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$reportVoiceSessionPerf(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportVoiceSessionPerf(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$reportVoiceStartPerf(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportVoiceStartPerf(I)V
    return-void 
.end method

.method public static final synthetic access$setAsrCallbackCount$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->asrCallbackCount I
    return-void 
.end method

.method public static final synthetic access$setBotCompleteText$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->botCompleteText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setConversationId$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->conversationId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setCurrentRecognizedText$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->currentRecognizedText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setDefiniteText$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->definiteText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setHasReceiveVoice$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasReceiveVoice Z
    return-void 
.end method

.method public static final synthetic access$setPerfApiRequestEndTimestamp$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfApiRequestEndTimestamp J
    return-void 
.end method

.method public static final synthetic access$setPerfJoinRoomSuccessTimestamp$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomSuccessTimestamp J
    return-void 
.end method

.method public static final synthetic access$setPerfJoinRoomTimestamp$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomTimestamp J
    return-void 
.end method

.method public static final synthetic access$setPerfPublishStreamTimestamp$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfPublishStreamTimestamp J
    return-void 
.end method

.method public static final synthetic access$setPerfStartVoiceChatTimestamp$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfStartVoiceChatTimestamp J
    return-void 
.end method

.method public static final synthetic access$setVoiceChat$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    return-void 
.end method

.method public static final synthetic access$setVoiceStartCaptureDuration$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartCaptureDuration J
    return-void 
.end method

.method public static final synthetic access$setWaitBotJob$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setWaitingBotResponse$p(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isWaitingBotResponse Z
    return-void 
.end method

.method public static final synthetic access$stopInternal(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->stopInternal()V
    return-void 
.end method

.method private final buildSessionSnapshot()com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot
    .registers 24
    # ins_size=1
    move-object/from16 v0, v23
    new-instance v20, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    move-object/from16 v1, v20
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->conversationId Ljava/lang/String;
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasReceiveVoice Z
    iget-wide v4, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartTimestamp J
    iget-wide v6, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceReleaseTimestamp J
    iget-wide v8, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfStartVoiceChatTimestamp J
    iget-wide v10, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfApiRequestEndTimestamp J
    iget-wide v12, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomTimestamp J
    iget-wide v14, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomSuccessTimestamp J
    move-object/from16 v21, v1
    move-object/from16 v22, v2
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfPublishStreamTimestamp J
    move-wide/from16 v16, v1
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->subvMessageCount I
    move/from16 v18, v1
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->asrCallbackCount I
    move/from16 v19, v1
    move-object/from16 v1, v21
    move-object/from16 v2, v22
    invoke-direct/range v1 ... v19, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;-><init>(Ljava/lang/String; Z J J J J J J J I I)V
    return-object v20
.end method

.method private final emitConversationState(com.bytedance.trae.conversation.voice.ConversationStateMessage)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "emitConversationState:"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "VoiceChatSession"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getCode()I
    move-result v4
    const/4 v0, 2
    if-ne v4, v0, +046h
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    if-nez v4, +003h
    return-void 
    sget-object v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->rtcListener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    check-cast v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->botCompleteText Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->currentRecognizedText Ljava/lang/String;
    check-cast v4, Ljava/lang/String;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +005h
    const-string v1, "empty"
    goto +3h
    const-string v1, "conv_thinking"
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->markFinalText(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportVoiceStartPerf(I)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportVoiceSessionPerf(Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitFinalText(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->stopInternal()V
    const-string v4, ""
    iput-object v4, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->botCompleteText Ljava/lang/String;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->currentRecognizedText Ljava/lang/String;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->definiteText Ljava/lang/String;
    return-void 
.end method

.method private final emitError(java.lang.Throwable)void
    .registers 9
    # ins_size=2
    iget-wide v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceReleaseTimestamp J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-nez v0, +00ch
    iget-wide v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfPublishStreamTimestamp J
    cmp-long v0, v0, v2
    if-nez v0, +006h
    const-string/jumbo v0, start_failed
    goto +3h
    const-string v0, "error"
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    invoke-virtual v2, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->failureReasonFor(Ljava/lang/Throwable;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, unknown
    invoke-direct v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->buildSessionSnapshot()Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    move-result-object v4
    invoke-virtual v1, v0, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->report(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->listener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    if-nez v0, +003h
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitError$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitError$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener; Ljava/lang/Throwable; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitFinalText(java.lang.String)void
    .registers 9
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "emitFinalText: text="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "VoiceChatSession"
    invoke-static v1, v0, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->listener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    if-nez v0, +003h
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitFinalText$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitFinalText$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitLocalAudioVolume(int)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->onAudioVolume(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->listener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    if-nez v0, +003h
    return-void 
    int-to-float v8, v8
    const/high16 v1, 1132396544
    div-float/2addr v8, v1
    const/4 v1, 0
    const/high16 v2, 1065353216
    invoke-static v8, v1, v2, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v8
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitLocalAudioVolume$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitLocalAudioVolume$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener; F Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitRecognizedText(java.lang.String)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->listener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    if-nez v0, +003h
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitRecognizedText$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitRecognizedText$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitStatus(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$Status)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->listener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    if-nez v0, +003h
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitStatus$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$emitStatus$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final handleBinaryMessage(java.lang.String  byte[])void
    .registers 8
    # ins_size=3
    const-string v0, "VoiceChatSession"
    const-string/jumbo v1, unknown binary message magic: 0x
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    invoke-virtual v2, v7, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->readMagic([B)Ljava/lang/Integer;
    move-result-object v2
    if-nez v2, +003h
    goto +15h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v3
    const v4, 1937072758
    if-ne v3, v4, +00dh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "MAGIC_SUBV"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->handleSubvMessage(Ljava/lang/String; [B)V
    goto +5dh
    if-nez v2, +003h
    goto +1ah
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v6
    const v3, 1668247158
    if-ne v6, v3, +012h
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->unpackConvMessage([B)Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    move-result-object v6
    if-eqz v6, +04ah
    iget-boolean v7, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStop Z
    if-eqz v7, +046h
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitConversationState(Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;)V
    goto +41h
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v2, +018h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v1
    const/16 v2, 16
    invoke-static v2, Lkotlin/text/CharsKt;->checkRadix(I)I
    move-result v2
    invoke-static v1, v2, Ljava/lang/Integer;->toString(I I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v1, +004h
    const-string v1, "null"
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", size="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    array-length v7, v7
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v0, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +9h
    move-exception v6
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "handleBinaryMessage error"
    invoke-virtual v7, v0, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x5
.end method

.method private final handleJoinRefused(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 5
    # ins_size=2
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasReceiveVoice Z
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStop Z
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isWaitingBotResponse Z
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    iput-object v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->rtcListener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->stopVoiceChatBestEffort(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->Stopped Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    return-void 
.end method

.method private final handleSubvMessage(java.lang.String  byte[])void
    .registers 15
    # ins_size=3
    const-string v0, "VoiceChatSession"
    const-string/jumbo v1, subtitle unpack failed: size=
    iget v2, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->subvMessageCount I
    add-int/lit8 v2, v2, 1
    iput v2, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->subvMessageCount I
    iget-object v2, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->onFirstSubv()V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    invoke-virtual v2, v14, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->unpackSubvMessage([B)Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    move-result-object v4
    const-string v2, ""
    if-nez v4, +03ah
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    array-length v1, v14
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v1, ", head="
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const/16 v1, 16
    invoke-static v14, v1, Lkotlin/collections/ArraysKt;->take([B I)Ljava/util/List;
    move-result-object v14
    move-object v3, v14
    check-cast v3, Ljava/lang/Iterable;
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$$ExternalSyntheticLambda0;
    invoke-direct v9, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$$ExternalSyntheticLambda0;-><init>()V
    const/16 v10, 30
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-static v0, v13, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v14, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v14, +007h
    invoke-virtual v14, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotName()Ljava/lang/String;
    move-result-object v14
    goto +2h
    const/4 v14, 0
    if-nez v14, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v14
    iget-object v14, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v9, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;
    const/4 v8, 0
    move-object v3, v9
    move-object v6, v12
    move-object v7, v13
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;-><init>(Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    const/4 v10, 3
    const/4 v11, 0
    move-object v6, v14
    move-object v7, v1
    move-object v8, v2
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +7h
    move-exception v13
    const-string v14, "handleSubvMessage error"
    invoke-static v0, v14, v13, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x5
    :try_start_0x1a
.end method

.method private static final handleSubvMessage$lambda$7(byte)java.lang.CharSequence
    .registers 4
    # ins_size=1
    const/4 v0, 1
    new-array v1, v0, [Ljava/lang/Object;
    const/4 v2, 0
    invoke-static v3, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;
    move-result-object v3
    aput-object v3, v1, v2
    invoke-static v1, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v3
    const-string v0, "%02x"
    invoke-static v0, v3, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v0, "format(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    return-object v3
.end method

.method private final isVoiceChatDataValid(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)boolean
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +03fh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +02bh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getUserId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +017h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getToken()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v2
    if-nez v4, +003h
    move v1, v2
    return v1
.end method

.method public static synthetic reportAttemptOutcome$default(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +005h
    const-string/jumbo v2, unknown
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const-string v3, ""
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final reportVoiceSessionPerf(java.lang.String)void
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    const-string/jumbo v0, rtc_voice_session_perf
    const-string/jumbo v2, subv_message_count
    const-string v3, "asr_callback_count"
    const-string v4, "recognized_text_length"
    const-string v5, "release_to_final_ms"
    const-string/jumbo v6, total_duration_ms
    const-string/jumbo v7, room_id
    iget-wide v8, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartTimestamp J
    const-wide/16 v10, 0
    cmp-long v8, v8, v10
    if-gtz v8, +003h
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartTimestamp J
    sub-long v12, v8, v12
    invoke-static v12, v13, v10, v11, Ljava/lang/Math;->max(J J)J
    move-result-wide v12
    iget-wide v14, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceReleaseTimestamp J
    cmp-long v16, v14, v10
    if-lez v16, +007h
    sub-long/2addr v8, v14
    invoke-static v8, v9, v10, v11, Ljava/lang/Math;->max(J J)J
    move-result-wide v10
    iget-object v8, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    const/4 v8, 0
    if-nez v8, +004h
    const-string v8, ""
    new-instance v9, Lorg/json/JSONObject;
    invoke-direct v9, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v9, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v14, Lorg/json/JSONObject;
    invoke-direct v14, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v14, v6, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v14, v5, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual/range v18, Ljava/lang/String;->length()I
    move-result v15
    invoke-virtual v14, v4, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v15, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->asrCallbackCount I
    invoke-virtual v14, v3, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v15, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->subvMessageCount I
    invoke-virtual v14, v2, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v15, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    move-object/from16 v16, v7
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v15, v0, v7, v14, v9, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v7, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v9, Lorg/json/JSONObject;
    invoke-direct v9, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v9, v6, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v9, v5, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual/range v18, Ljava/lang/String;->length()I
    move-result v5
    invoke-virtual v9, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v4, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->asrCallbackCount I
    invoke-virtual v9, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->subvMessageCount I
    invoke-virtual v9, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object/from16 v2, v16
    invoke-virtual v9, v2, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v7, v0, v9, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +ah
    move-exception v0
    const-string v2, "VoiceChatSession"
    const-string/jumbo v3, reportVoiceSessionPerf failed
    invoke-static v2, v3, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x14
.end method

.method private final reportVoiceStartPerf(int)void
    .registers 23
    # ins_size=2
    move-object/from16 v1, v21
    move/from16 v0, v22
    const-string/jumbo v2, rtc_voice_start_perf
    const-string/jumbo v3, start_capture_ms
    const-string v4, "from_type"
    const-string/jumbo v5, total_ms
    const-string v6, "join_room_ms"
    const-string/jumbo v7, start_voice_chat_request_ms
    const-string/jumbo v8, room_id
    iget-wide v9, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartTimestamp J
    const-wide/16 v11, 0
    cmp-long v9, v9, v11
    if-gtz v9, +003h
    return-void 
    iget-object v9, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    if-nez v9, +004h
    const-string v9, ""
    iget-wide v13, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfStartVoiceChatTimestamp J
    cmp-long v15, v13, v11
    if-lez v15, +011h
    move-object v15, v2
    move-object/from16 v16, v3
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfApiRequestEndTimestamp J
    cmp-long v17, v2, v11
    if-lez v17, +00bh
    sub-long/2addr v2, v13
    invoke-static v2, v3, v11, v12, Ljava/lang/Math;->max(J J)J
    move-result-wide v2
    goto +5h
    move-object v15, v2
    move-object/from16 v16, v3
    move-wide v2, v11
    iget-wide v13, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomTimestamp J
    cmp-long v17, v13, v11
    if-lez v17, +012h
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    iget-wide v4, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomSuccessTimestamp J
    cmp-long v19, v4, v11
    if-lez v19, +00ch
    sub-long/2addr v4, v13
    invoke-static v4, v5, v11, v12, Ljava/lang/Math;->max(J J)J
    move-result-wide v4
    goto +6h
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-wide v4, v11
    iget-wide v13, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfPublishStreamTimestamp J
    cmp-long v19, v13, v11
    if-lez v19, +003h
    goto +9h
    iget-wide v13, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceReleaseTimestamp J
    iget-wide v10, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartTimestamp J
    invoke-static v13, v14, v10, v11, Ljava/lang/Math;->max(J J)J
    move-result-wide v13
    iget-wide v10, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartTimestamp J
    sub-long/2addr v13, v10
    const-wide/16 v10, 0
    invoke-static v13, v14, v10, v11, Ljava/lang/Math;->max(J J)J
    move-result-wide v10
    new-instance v13, Lorg/json/JSONObject;
    invoke-direct v13, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v13, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v14, Lorg/json/JSONObject;
    invoke-direct v14, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v14, v7, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v14, v6, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v12, v18
    invoke-virtual v14, v12, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v18, v15
    move-object/from16 v15, v17
    invoke-virtual v14, v15, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object/from16 v17, v8
    move-object/from16 v20, v9
    iget-wide v8, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartCaptureDuration J
    move-object/from16 v1, v16
    invoke-virtual v14, v1, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v8, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    move-object/from16 v16, v1
    move-object/from16 v9, v18
    const/4 v1, 0
    invoke-virtual v8, v9, v1, v14, v13, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v8, Lorg/json/JSONObject;
    invoke-direct v8, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v8, v7, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v8, v6, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v8, v12, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v8, v15, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object/from16 v2, v21
    move-object/from16 v0, v16
    iget-wide v3, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartCaptureDuration J
    invoke-virtual v8, v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v3, v17
    move-object/from16 v0, v20
    invoke-virtual v8, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v9, v8, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +11h
    move-exception v0
    goto +7h
    move-exception v0
    move-object/from16 v2, v21
    goto +3h
    move-exception v0
    move-object v2, v1
    const-string v1, "VoiceChatSession"
    const-string/jumbo v3, reportVoiceStartPerf failed
    invoke-static v1, v3, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x17
    :try_start_0xa1
    :try_start_0xc5
.end method

.method public static synthetic stop$default(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->stop(Z)V
    return-void 
.end method

.method private final stopInternal()void
    .registers 9
    # ins_size=1
    iget-boolean v0, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    if-nez v0, +003h
    return-void 
    const/4 v0, 0
    iput-boolean v0, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    iput-boolean v0, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasReceiveVoice Z
    iput-boolean v0, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isWaitingBotResponse Z
    iget-object v0, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-object v1, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;
    invoke-direct v5, v8, v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final stopVoiceChatBestEffort(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->conversationId Ljava/lang/String;
    const/4 v1, 0
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-eqz v2, +020h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +01ah
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +12h
    iget-object v3, v9, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;
    invoke-direct v2, v9, v10, v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final isRunning()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    return v0
.end method

.method public final onError()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->rtcListener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->stopInternal()V
    return-void 
.end method

.method public final release()void
    .registers 12
    # ins_size=1
    iget-boolean v0, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    iget-object v1, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "release on release failed"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "VoiceChatSession"
    invoke-static v3, v2, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v2, 0
    iput-boolean v2, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    iput-boolean v2, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasReceiveVoice Z
    const/4 v3, 1
    iput-boolean v3, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStop Z
    iput-boolean v2, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isWaitingBotResponse Z
    iget-object v2, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    const/4 v4, 0
    if-eqz v2, +005h
    invoke-static v2, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v4, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    iput-object v4, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-object v4, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->listener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    if-eqz v0, +016h
    if-eqz v1, +014h
    iget-object v5, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;
    invoke-direct v0, v1, v11, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/coroutines/Continuation;)V
    move-object v8, v0
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +30h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v1, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v1, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v1, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v1, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v1, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v1, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportAttemptOutcome(java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=4
    const-string v0, "outcome"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "inputStateWhenFinal"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "failureReason"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->buildSessionSnapshot()Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    move-result-object v1
    invoke-virtual v0, v3, v5, v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->report(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;)V
    return-void 
.end method

.method public final start(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$Listener)void
    .registers 12
    # ins_size=2
    iget-boolean v0, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    if-eqz v0, +003h
    return-void 
    new-instance v0, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    iput-wide v1, v0, Lkotlin/jvm/internal/Ref$LongRef;->element J
    iput-object v11, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->listener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    const/4 v11, 0
    iput-boolean v11, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasReceiveVoice Z
    iput-boolean v11, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStop Z
    const/4 v1, 1
    iput-boolean v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    const-string v2, ""
    iput-object v2, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->definiteText Ljava/lang/String;
    iput-object v2, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->currentRecognizedText Ljava/lang/String;
    iput-object v2, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->botCompleteText Ljava/lang/String;
    iput-boolean v11, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isWaitingBotResponse Z
    iget-object v2, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    const/4 v3, 0
    if-eqz v2, +005h
    invoke-static v2, v3, v1, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v3, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->waitBotJob Lkotlinx/coroutines/Job;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartTimestamp J
    const-wide/16 v1, 0
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceReleaseTimestamp J
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfStartVoiceChatTimestamp J
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfApiRequestEndTimestamp J
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomTimestamp J
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfJoinRoomSuccessTimestamp J
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->perfPublishStreamTimestamp J
    iput v11, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->subvMessageCount I
    iput v11, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->asrCallbackCount I
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceStartCaptureDuration J
    iget-object v11, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->reset()V
    sget-object v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->Starting Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    iget-object v4, v10, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v11, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;
    invoke-direct v11, v10, v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/jvm/internal/Ref$LongRef; Lkotlin/coroutines/Continuation;)V
    move-object v7, v11
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final startRoom()void
    .registers 9
    # ins_size=1
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toString(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->conversationId Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;
    const/4 v1, 0
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final stop(boolean)void
    .registers 9
    # ins_size=2
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStartedVoiceChat Z
    if-nez v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->hasStop Z
    const-string v0, "VoiceChatSession"
    const-string/jumbo v1, stop
    invoke-static v0, v1, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-wide v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceReleaseTimestamp J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-nez v0, +00dh
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iput-wide v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->voiceReleaseTimestamp J
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->onVoiceRelease()V
    if-eqz v8, +018h
    const-string v0, ""
    iput-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->currentRecognizedText Ljava/lang/String;
    iput-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->definiteText Ljava/lang/String;
    iput-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->botCompleteText Ljava/lang/String;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->attemptTracker Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->setFinalSourceCancel()V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->rtcListener Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->stopAudioCapture()V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Z Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
