# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
.super Ljava/lang/Object;
.source "VoiceHealthMonitor.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor$Companion;
.field private static final RTC_WEAK_NETWORK_LOSS_RATE:D
.field private static final RTC_WEAK_NETWORK_RTT_MS:I
.field private static final TAG:Ljava/lang/String;
.field private final appContext:Landroid/content/Context;
.field private isAiListening:Z
.field private lastUserSubtitleAtMs:J
.field private final lowAudioDetector:Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
.field private final outputVolumeDetector:Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->Companion Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    invoke-virtual v2, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->appContext Landroid/content/Context;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->lowAudioDetector Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->outputVolumeDetector Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;
    return-void 
.end method

.method private final canCheckLowAudio(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 4
    # ins_size=2
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->isAiListening Z
    if-eqz v0, +020h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v0
    if-eqz v0, +01ah
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v0
    if-nez v0, +014h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-eq v0, v1, +00ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-eq v3, v0, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    return v3
.end method

.method private final canCheckOutputVolume(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v2, v0, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private final hasSystemAudioProblem(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->appContext Landroid/content/Context;
    const-string v2, "audio"
    invoke-virtual v0, v2, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v2, v0, Landroid/media/AudioManager;
    if-eqz v2, +005h
    check-cast v0, Landroid/media/AudioManager;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v4
    if-nez v4, +009h
    invoke-virtual v0, Landroid/media/AudioManager;->isMicrophoneMute()Z
    move-result v4
    if-eqz v4, +003h
    const/4 v1, 1
    return v1
.end method

.method private final isMicPermissionGranted()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->appContext Landroid/content/Context;
    const-string v1, "android.permission.RECORD_AUDIO"
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final isWeakRtcNetwork(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality)boolean
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->getTxQuality()I
    move-result v0
    const/4 v1, 4
    if-ge v0, v1, +02dh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->getRxQuality()I
    move-result v0
    if-ge v0, v1, +027h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->getTxQuality()I
    move-result v0
    const/4 v1, 6
    if-eq v0, v1, +020h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->getRxQuality()I
    move-result v0
    if-eq v0, v1, +01ah
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->getFractionLost()D
    move-result-wide v0
    const-wide v2, 4596373779694328218
    cmpl-double v0, v0, v2
    if-gez v0, +00dh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->getRtt()I
    move-result v5
    const/16 v0, 800
    if-lt v5, v0, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    const/4 v5, 1
    return v5
.end method

.method public static synthetic markUserSubtitle$default(com.bytedance.trae.conversation.brainstorm.health.VoiceHealthMonitor  long  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +006h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->markUserSubtitle(J)V
    return-void 
.end method

.method private final readOutputVolumeSnapshot(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Snapshot
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->appContext Landroid/content/Context;
    const-string v1, "audio"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/media/AudioManager;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/media/AudioManager;
    goto +2h
    move-object v0, v2
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getCurrentAudioDevice()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v7
    const/4 v3, 3
    const/4 v4, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/media/AudioManager;->getMode()I
    move-result v5
    if-ne v5, v3, +004h
    const/4 v5, 1
    goto +2h
    move v5, v4
    if-eqz v0, +007h
    invoke-direct v6, v0, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->safeStreamVolume(Landroid/media/AudioManager; I)Ljava/lang/Integer;
    move-result-object v3
    goto +2h
    move-object v3, v2
    if-eqz v0, +006h
    invoke-direct v6, v0, v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->safeStreamVolume(Landroid/media/AudioManager; I)Ljava/lang/Integer;
    move-result-object v2
    invoke-direct v1, v7, v5, v3, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-object v1
.end method

.method private final safeStreamVolume(android.media.AudioManager  int)java.lang.Integer
    .registers 4
    # ins_size=3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, v3, Landroid/media/AudioManager;->getStreamVolume(I)I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    const/4 v2, 0
    check-cast v2, Ljava/lang/Integer;
    return-object v2
    :try_start_0x0
.end method

.method public final checkPreflight(com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger)com.bytedance.trae.conversation.brainstorm.health.VoicePrompt$Health
    .registers 3
    # ins_size=2
    const-string/jumbo v0, trigger
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->getCheckPermission()Z
    move-result v2
    if-eqz v2, +00dh
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->isMicPermissionGranted()Z
    move-result v2
    if-nez v2, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$MicPermissionDenied;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$MicPermissionDenied;
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method public final markUserSubtitle(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->lastUserSubtitleAtMs J
    return-void 
.end method

.method public final onOutputVolumeCheck(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)com.bytedance.trae.conversation.brainstorm.health.VoicePrompt$Health
    .registers 6
    # ins_size=2
    const-string/jumbo v0, uiState
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->readOutputVolumeSnapshot(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->outputVolumeDetector Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->canCheckOutputVolume(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v2
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->evaluate(Z Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getCheckHit()Z
    move-result v1
    if-nez v1, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getConfirmed()Z
    move-result v1
    if-eqz v1, +07eh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "output_volume_eval confirmed="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getConfirmed()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", checkHit="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getCheckHit()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", hitCount="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getHitCount()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", device="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getAudioDevice()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", inCommunication="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", musicVolume="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getMusicVolume()Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", voiceCallVolume="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getVoiceCallVolume()Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", aiState="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "VoiceHealthMonitor"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->getConfirmed()Z
    move-result v5
    if-eqz v5, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    goto +2h
    const/4 v5, 0
    return-object v5
.end method

.method public final onRtcAudioInputDeviceStateChanged(int  int  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)com.bytedance.trae.conversation.brainstorm.health.VoicePrompt$Health
    .registers 5
    # ins_size=4
    const-string/jumbo v0, uiState
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v4
    const/4 v0, 0
    if-nez v4, +003h
    return-object v0
    if-nez v3, +005h
    const/4 v3, 3
    if-ne v2, v3, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    return-object v0
.end method

.method public final onRtcAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)com.bytedance.trae.conversation.brainstorm.health.VoicePrompt$Health
    .registers 11
    # ins_size=3
    const-string v0, "properties"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uiState
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->canCheckLowAudio(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +008h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->lowAudioDetector Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->reset()V
    return-object v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iget-wide v4, v8, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->lastUserSubtitleAtMs J
    sub-long/2addr v2, v4
    const-wide/16 v4, 2500
    cmp-long v0, v2, v4
    if-gtz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    iget-object v2, v8, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->lowAudioDetector Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;->getLinearVolume()I
    move-result v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;->getVad()I
    move-result v4
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;->getTimestampMs()J
    move-result-wide v5
    move v7, v0
    invoke-virtual/range v2 ... v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->onAudioSample(I I J Z)Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    move-result-object v9
    if-nez v9, +003h
    return-object v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getWindowHit()Z
    move-result v2
    if-nez v2, +008h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getConfirmed()Z
    move-result v2
    if-eqz v2, +096h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "low_audio_eval confirmed="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getConfirmed()Z
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", windowHit="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getWindowHit()Z
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", hitCount="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getHitCount()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", avgVolume="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getAvgVolume()D
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", maxVolume="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getMaxVolume()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", voicedSize="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getVoicedSize()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", totalSize="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getTotalSize()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", lowRatio="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getLowRatio()F
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", recentUserSubtitle="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", aiState="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v10
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v0, "VoiceHealthMonitor"
    invoke-virtual v2, v0, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->getConfirmed()Z
    move-result v9
    if-eqz v9, +007h
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;
    move-object v1, v9
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    return-object v1
.end method

.method public final onRtcNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)java.util.List
    .registers 5
    # ins_size=3
    const-string v0, "local"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uiState
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v0
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    return-object v3
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->isWeakRtcNetwork(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;)Z
    move-result v3
    if-eqz v3, +00ah
    move-object v3, v0
    check-cast v3, Ljava/util/Collection;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$WeakNetwork;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$WeakNetwork;
    invoke-interface v3, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->hasSystemAudioProblem(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v3
    if-eqz v3, +00ah
    move-object v3, v0
    check-cast v3, Ljava/util/Collection;
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    return-object v0
.end method

.method public final resetOutputVolume()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->outputVolumeDetector Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->reset()V
    return-void 
.end method

.method public final resetRuntime()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->isAiListening Z
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->lowAudioDetector Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->reset()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->outputVolumeDetector Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->reset()V
    return-void 
.end method

.method public final setAiListening(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->isAiListening Z
    if-nez v1, +007h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->lowAudioDetector Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->reset()V
    return-void 
.end method
