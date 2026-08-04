# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
.super Landroidx/lifecycle/AndroidViewModel;
.source "BrainstormViewModel.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;
.field private static final EVENT_DISCUSSION_ROUND_PERF:Ljava/lang/String;
.field private static final EVENT_DISCUSSION_SESSION_END:Ljava/lang/String;
.field private static final EVENT_DISCUSSION_SESSION_PERF:Ljava/lang/String;
.field private static final EVENT_DISCUSSION_START_PERF:Ljava/lang/String;
.field private static final MAX_ATTACHMENT_SIZE_BYTES:J
.field private static final MAX_TOTAL_ATTACHMENT_SIZE_BYTES:J
.field private static final OUTPUT_VOLUME_CHECK_INTERVAL_MS:J
.field private static final OUTPUT_VOLUME_ROUTE_SETTLE_DELAY_MS:J
.field private static final PERF_MISSING_VALUE:J
.field private static final TAG:Ljava/lang/String;
.field private static final TERMINAL_SUB_TASK_STATES:Ljava/util/Set;
.field private static final TIMEOUT_COUNTDOWN_SECONDS:I
.field private static final TIMEOUT_WARNING_THRESHOLD_MS:J
.field private static final USER_SPEAK_VAD_THRESHOLD:F
.field private final _botSubtitleBuffer:Ljava/lang/StringBuilder;
.field private final _botWordAggregateBuffer:Ljava/lang/StringBuilder;
.field private final _brainstormEnded:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private _cliConversationId:Ljava/lang/String;
.field private final _localAudioVolume:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _minimizeRequested:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _summaryFailed:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _summaryReady:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _uiState:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _userSubtitleBuffer:Ljava/lang/StringBuilder;
.field private final _userWordAggregateBuffer:Ljava/lang/StringBuilder;
.field private bridge _voiceCliType:Lcom/bytedance/trae/im/service/CliType;
.field private bridge _voiceMode:Lcom/bytedance/trae/im/service/Mode;
.field private final _voicePromptEvents:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private aiReplyJob:Lkotlinx/coroutines/Job;
.field private final attachmentManager:Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
.field private attachmentSubTaskEnabled:Z
.field private final attachmentUploadJobs:Ljava/util/concurrent/ConcurrentHashMap;
.field private audioDeviceManager:Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
.field private awaitingBotFirstChar:Z
.field private final brainstormEnded:Lkotlinx/coroutines/flow/SharedFlow;
.field private discussionStartPerfReported:Z
.field private final localAudioVolume:Lkotlinx/coroutines/flow/SharedFlow;
.field private final minimizeRequested:Lkotlinx/coroutines/flow/SharedFlow;
.field private needRemoteParentChatSessionForVoice:Z
.field private originConversationId:Ljava/lang/String;
.field private outputVolumeMonitorJob:Lkotlinx/coroutines/Job;
.field private parentConversationIdForVoice:Ljava/lang/String;
.field private pendingUserSpeakStartMs:Ljava/lang/Long;
.field private pendingUserSubtitleFirstCharMs:Ljava/lang/Long;
.field private pendingUserSubtitleLastCharMs:Ljava/lang/Long;
.field private perfApiRequestStartMs:J
.field private perfBotJoinedMs:J
.field private perfIsNewSession:Z
.field private perfJoinRoomStartMs:J
.field private perfJoinRoomSuccessMs:J
.field private perfMicCheckEndMs:J
.field private perfMicCheckStartMs:J
.field private roundIndexSeq:I
.field private sessionBotCharCount:I
.field private sessionBotMessageCount:I
.field private final sessionBotSpeakStartTimestamps:Ljava/util/List;
.field private sessionHasEverEnabledSubtitle:Z
.field private final sessionRoundDelays:Ljava/util/List;
.field private sessionTimerJob:Lkotlinx/coroutines/Job;
.field private sessionUserCharCount:I
.field private sessionUserMessageCount:I
.field private final sessionUserSpeakEndTimestamps:Ljava/util/List;
.field private startRecordingJob:Lkotlinx/coroutines/Job;
.field private final summaryFailed:Lkotlinx/coroutines/flow/SharedFlow;
.field private final summaryReady:Lkotlinx/coroutines/flow/SharedFlow;
.field private final summaryRepository:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
.field private final uiState:Lkotlinx/coroutines/flow/StateFlow;
.field private userVadActive:Z
.field private final voiceChatListener:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
.field private voiceChatSession:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
.field private voiceDiscussionAttemptTracker:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
.field private final voiceHealthMonitor:Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
.field private final voicePromptEvents:Lkotlinx/coroutines/flow/SharedFlow;


.method public static synthetic $r8$lambda$8UHm5Uv6oCmpaNqTRUjPpM1tAYA(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  byte[])kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->initVoiceSession$lambda$32(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; [B)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$JZMr0JxeG8DbPSX2cU6mMe3UGyw(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->maybeNotifyPendingAttachments$lambda$20$lambda$19(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$X_5w1T6Unu1bZpkjfFQUF5QB38k(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->retryAttachment$lambda$5(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tmRFUVUHllIBAddFMU0x2kLP5ZI(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->cancelAttachment$lambda$6(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    aput-object v2, v0, v1
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->TERMINAL_SUB_TASK_STATES Ljava/util/Set;
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 32
    # ins_size=2
    move-object/from16 v0, v30
    move-object/from16 v1, v31
    const-string v2, "application"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v30 ... v31, Landroidx/lifecycle/AndroidViewModel;-><init>(Landroid/app/Application;)V
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-object v3, v2
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 4194303
    const/16 v29, 0
    invoke-direct/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->uiState Lkotlinx/coroutines/flow/StateFlow;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;-><init>()V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->summaryRepository Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    move-object v3, v1
    check-cast v3, Landroid/content/Context;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;-><init>(Landroid/content/Context;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;-><init>(Landroid/content/Context;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceHealthMonitor Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    sget-object v2, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    const/4 v2, 1
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentSubTaskEnabled Z
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserSpeakEndTimestamps Ljava/util/List;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotSpeakStartTimestamps Ljava/util/List;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    const/4 v3, 0
    const/4 v5, 6
    invoke-static v3, v3, v4, v5, v4, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_summaryReady Lkotlinx/coroutines/flow/MutableSharedFlow;
    const/4 v7, 4
    invoke-static v3, v2, v4, v7, v4, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v8
    iput-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_localAudioVolume Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v8, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v8
    iput-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->localAudioVolume Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v6, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v6
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->summaryReady Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v3, v3, v4, v5, v4, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_summaryFailed Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v6, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v6
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->summaryFailed Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v3, v3, v4, v5, v4, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v5
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_brainstormEnded Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v5, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v5
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->brainstormEnded Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v3, v2, v4, v7, v4, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_minimizeRequested Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v2
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->minimizeRequested Lkotlinx/coroutines/flow/SharedFlow;
    const/16 v2, 8
    invoke-static v3, v2, v4, v7, v4, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voicePromptEvents Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v2
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voicePromptEvents Lkotlinx/coroutines/flow/SharedFlow;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botSubtitleBuffer Ljava/lang/StringBuilder;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userSubtitleBuffer Ljava/lang/StringBuilder;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botWordAggregateBuffer Ljava/lang/StringBuilder;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userWordAggregateBuffer Ljava/lang/StringBuilder;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;-><init>(Landroid/app/Application;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentManager Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v1, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->init()V
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatListener Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
    move-object v1, v0
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1;
    invoke-direct v2, v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v8, v2
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v11
    const/4 v13, 0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$2;
    invoke-direct v1, v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v14, v1
    check-cast v14, Lkotlin/jvm/functions/Function2;
    const/4 v15, 3
    invoke-static/range v11 ... v16, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$applySubTaskTerminal(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->applySubTaskTerminal(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    return-void 
.end method

.method public static final synthetic access$closeLastRoundAsInterruptedIfNeeded(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->closeLastRoundAsInterruptedIfNeeded(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$currentRound(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->currentRound()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$emitOutputVolumePromptIfNeeded(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->emitOutputVolumePromptIfNeeded(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$getAttachmentManager$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentManager Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    return-object v0
.end method

.method public static final synthetic access$getAttachmentUploadJobs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getAwaitingBotFirstChar$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->awaitingBotFirstChar Z
    return v0
.end method

.method public static final synthetic access$getPendingUserSpeakStartMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.lang.Long
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pendingUserSpeakStartMs Ljava/lang/Long;
    return-object v0
.end method

.method public static final synthetic access$getPendingUserSubtitleFirstCharMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.lang.Long
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pendingUserSubtitleFirstCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public static final synthetic access$getPendingUserSubtitleLastCharMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.lang.Long
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pendingUserSubtitleLastCharMs Ljava/lang/Long;
    return-object v0
.end method

.method public static final synthetic access$getRoundIndexSeq$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->roundIndexSeq I
    return v0
.end method

.method public static final synthetic access$getSessionBotCharCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotCharCount I
    return v0
.end method

.method public static final synthetic access$getSessionBotMessageCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotMessageCount I
    return v0
.end method

.method public static final synthetic access$getSessionBotSpeakStartTimestamps$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotSpeakStartTimestamps Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getSessionRoundDelays$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getSessionUserCharCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserCharCount I
    return v0
.end method

.method public static final synthetic access$getSessionUserMessageCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserMessageCount I
    return v0
.end method

.method public static final synthetic access$getSessionUserSpeakEndTimestamps$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserSpeakEndTimestamps Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getTERMINAL_SUB_TASK_STATES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->TERMINAL_SUB_TASK_STATES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getUserVadActive$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->userVadActive Z
    return v0
.end method

.method public static final synthetic access$getVoiceChatListener$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$voiceChatListener$1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatListener Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
    return-object v0
.end method

.method public static final synthetic access$getVoiceChatSession$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    return-object v0
.end method

.method public static final synthetic access$getVoiceDiscussionAttemptTracker$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    return-object v0
.end method

.method public static final synthetic access$getVoiceHealthMonitor$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)com.bytedance.trae.conversation.brainstorm.health.VoiceHealthMonitor
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceHealthMonitor Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    return-object v0
.end method

.method public static final synthetic access$get_botSubtitleBuffer$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.lang.StringBuilder
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botSubtitleBuffer Ljava/lang/StringBuilder;
    return-object v0
.end method

.method public static final synthetic access$get_botWordAggregateBuffer$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.lang.StringBuilder
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botWordAggregateBuffer Ljava/lang/StringBuilder;
    return-object v0
.end method

.method public static final synthetic access$get_brainstormEnded$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_brainstormEnded Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_localAudioVolume$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_localAudioVolume Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_uiState$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_userSubtitleBuffer$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.lang.StringBuilder
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userSubtitleBuffer Ljava/lang/StringBuilder;
    return-object v0
.end method

.method public static final synthetic access$get_userWordAggregateBuffer$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)java.lang.StringBuilder
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userWordAggregateBuffer Ljava/lang/StringBuilder;
    return-object v0
.end method

.method public static final synthetic access$get_voicePromptEvents$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voicePromptEvents Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$handleBotFinalText(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->handleBotFinalText(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$handleUserFinalText(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->handleUserFinalText(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$isCjkChar(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  char)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->isCjkChar(C)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$logUnrecognizedRtcFrame(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->logUnrecognizedRtcFrame(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$markCurrentRoundHasSubtask(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->markCurrentRoundHasSubtask()V
    return-void 
.end method

.method public static final synthetic access$markCurrentRoundServerTool(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->markCurrentRoundServerTool(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$onAttachmentUploadDone(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->onAttachmentUploadDone(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$refreshVoiceAttemptContext(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->refreshVoiceAttemptContext()V
    return-void 
.end method

.method public static final synthetic access$reportDiscussionStartPerfIfNeeded(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->reportDiscussionStartPerfIfNeeded()V
    return-void 
.end method

.method public static final synthetic access$reportServerToolEnd(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->reportServerToolEnd(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
.end method

.method public static final synthetic access$reportVoiceFileUploadEnd(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  long  long  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->reportVoiceFileUploadEnd(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; J J Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$resolveVoiceConversationIdForRecording(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->resolveVoiceConversationIdForRecording(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$restartOutputVolumeMonitoring(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->restartOutputVolumeMonitoring(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$rtcDiag(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setAwaitingBotFirstChar$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->awaitingBotFirstChar Z
    return-void 
.end method

.method public static final synthetic access$setPendingUserSpeakStartMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pendingUserSpeakStartMs Ljava/lang/Long;
    return-void 
.end method

.method public static final synthetic access$setPendingUserSubtitleFirstCharMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pendingUserSubtitleFirstCharMs Ljava/lang/Long;
    return-void 
.end method

.method public static final synthetic access$setPendingUserSubtitleLastCharMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pendingUserSubtitleLastCharMs Ljava/lang/Long;
    return-void 
.end method

.method public static final synthetic access$setPerfApiRequestStartMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfApiRequestStartMs J
    return-void 
.end method

.method public static final synthetic access$setPerfBotJoinedMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfBotJoinedMs J
    return-void 
.end method

.method public static final synthetic access$setPerfJoinRoomStartMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomStartMs J
    return-void 
.end method

.method public static final synthetic access$setPerfJoinRoomSuccessMs$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomSuccessMs J
    return-void 
.end method

.method public static final synthetic access$setRoundIndexSeq$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->roundIndexSeq I
    return-void 
.end method

.method public static final synthetic access$setSessionBotCharCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotCharCount I
    return-void 
.end method

.method public static final synthetic access$setSessionBotMessageCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotMessageCount I
    return-void 
.end method

.method public static final synthetic access$setSessionUserCharCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserCharCount I
    return-void 
.end method

.method public static final synthetic access$setSessionUserMessageCount$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserMessageCount I
    return-void 
.end method

.method public static final synthetic access$setUserVadActive$p(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->userVadActive Z
    return-void 
.end method

.method public static final synthetic access$startSessionTimer(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startSessionTimer()V
    return-void 
.end method

.method public static final synthetic access$stopOutputVolumeMonitoring(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopOutputVolumeMonitoring()V
    return-void 
.end method

.method public static final synthetic access$stopSessionTimer(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopSessionTimer()V
    return-void 
.end method

.method public static final synthetic access$tryReportRoundIfFinal(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->tryReportRoundIfFinal(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord; Ljava/lang/String;)V
    return-void 
.end method

.method private final applySubTaskTerminal(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 37
    # ins_size=2
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    move-object/from16 v1, v35
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v5
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v6
    invoke-interface v6, v0, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v15
    const/16 v31, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    const/16 v8, 10
    invoke-static v6, v8, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v8
    invoke-direct v7, v8, Ljava/util/ArrayList;-><init>(I)V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    const/4 v8, 0
    move v13, v8
    move v14, v13
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +042h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object/from16 v16, v8
    check-cast v16, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getAttachedSubTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +02ah
    add-int/lit8 v14, v14, 1
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getSubTaskTerminalState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v8
    if-nez v8, +022h
    add-int/lit8 v13, v13, 1
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v25
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v26
    const/16 v27, 127
    const/16 v28, 0
    invoke-static/range v16 ... v28, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    move-result-object v16
    move-object/from16 v8, v16
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -45h
    move-object v6, v7
    check-cast v6, Ljava/util/List;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v16, 0
    move/from16 v32, v13
    move-object/from16 v13, v16
    const/16 v16, 0
    move/from16 v33, v14
    move/from16 v14, v16
    move/from16 v34, v15
    move/from16 v15, v16
    const/16 v17, 0
    const-wide/16 v18, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v7
    move-object/from16 v8, v36
    invoke-static v0, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    invoke-static v7, v9, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v27
    const/16 v28, 0
    const v29, 3145725
    const/16 v30, 0
    move v7, v5
    move-object/from16 v5, v31
    move v1, v7
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    invoke-static/range v4 ... v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +055h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[SubTask] applyTerminal: taskId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", state="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", matchedAnchors="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move/from16 v14, v33
    invoke-virtual v0, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", newlyStamped="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move/from16 v8, v32
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", historySize="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", existingFinished="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move/from16 v1, v34
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "BrainstormViewModel"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object/from16 v1, v35
    goto/16 -11dh
.end method

.method private final avgOrMissing(java.util.List)long
    .registers 6
    # ins_size=2
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +005h
    const-wide/16 v0, -1
    goto +eh
    move-object v0, v5
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->sumOfLong(Ljava/lang/Iterable;)J
    move-result-wide v0
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    int-to-long v2, v5
    div-long/2addr v0, v2
    return-wide v0
.end method

.method private final cancelAllPendingUploads(boolean)void
    .registers 32
    # ins_size=2
    move-object/from16 v0, v30
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;
    move-result-object v1
    const-string v2, "<get-values>(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/Job;
    const/4 v3, 1
    const/4 v4, 0
    invoke-static v2, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    goto -11h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    if-nez v31, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    const/16 v6, 10
    invoke-static v4, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v5, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +033h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v6
    sget-object v8, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v6, v8, +020h
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    sget-object v16, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Cancelled Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 16255
    const/16 v25, 0
    invoke-static/range v7 ... v25, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v7
    invoke-interface v5, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -36h
    move-object/from16 v27, v5
    check-cast v27, Ljava/util/List;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const v28, 2097151
    const/16 v29, 0
    invoke-static/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v1, v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -084h
    return-void 
.end method

.method private static final cancelAttachment$lambda$6(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 21
    # ins_size=1
    const-string v0, "current"
    move-object/from16 v1, v20
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploaded Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v0, v2, +004h
    move-object v0, v1
    goto +1dh
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const-wide/16 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Cancelled Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const-wide/16 v15, 0
    const/16 v17, 0
    const/16 v18, 16255
    const/16 v19, 0
    move-object/from16 v1, v20
    invoke-static/range v1 ... v19, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method private final closeLastRoundAsInterruptedIfNeeded(java.lang.String)void
    .registers 6
    # ins_size=2
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->currentRound()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterrupted()Z
    move-result v1
    if-eqz v1, +006h
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->tryReportRoundIfFinal(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord; Ljava/lang/String;)V
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFinishMs()Ljava/lang/Long;
    move-result-object v1
    if-eqz v1, +006h
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->tryReportRoundIfFinal(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord; Ljava/lang/String;)V
    return-void 
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setInterrupted(Z)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v1
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->DURING_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    goto +ch
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v1
    if-nez v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_FIRST_CHAR Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setInterruptPhase(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;)V
    const/4 v1, 0
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->awaitingBotFirstChar Z
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "closeLastRoundAsInterrupted: idx="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getRoundIndex()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " phase="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterruptPhase()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " reason="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BrainstormViewModel"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->tryReportRoundIfFinal(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord; Ljava/lang/String;)V
    return-void 
.end method

.method private final currentRound()com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    return-object v0
.end method

.method private final emitOutputVolumePromptIfNeeded(java.lang.String)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceHealthMonitor Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->onOutputVolumeCheck(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "output_volume_prompt reason="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "BrainstormViewModel"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voicePromptEvents Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-interface v5, v0, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    return-void 
.end method

.method public static synthetic endBrainstorm$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->endBrainstorm(Z)V
    return-void 
.end method

.method private final flushSubtitleBuffers()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botWordAggregateBuffer Ljava/lang/StringBuilder;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +010h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botSubtitleBuffer Ljava/lang/StringBuilder;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botWordAggregateBuffer Ljava/lang/StringBuilder;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botWordAggregateBuffer Ljava/lang/StringBuilder;
    invoke-static v0, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userWordAggregateBuffer Ljava/lang/StringBuilder;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +010h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userSubtitleBuffer Ljava/lang/StringBuilder;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userWordAggregateBuffer Ljava/lang/StringBuilder;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_userWordAggregateBuffer Ljava/lang/StringBuilder;
    invoke-static v0, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    return-void 
.end method

.method private final handleBotFinalText(java.lang.String)void
    .registers 37
    # ins_size=2
    move-object/from16 v0, v35
    move-object/from16 v1, v36
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[BotReply] len="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v36, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " | content="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "BrainstormViewModel"
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +03dh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v9, 0
    const/4 v10, 0
    const-string v11, ""
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 4194159
    const/16 v29, 0
    invoke-static/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v2, v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -036h
    return-void 
    invoke-static/range v36, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->parseAttachedSubTaskId(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead()Z
    move-result v3
    if-eqz v3, +017h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[BotReply] final text looks like incomplete head tag, fallback to raw: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getCleanedText()Ljava/lang/String;
    move-result-object v1
    move-object v8, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    const/4 v3, 0
    if-nez v1, +008h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v5
    move-object v11, v5
    goto +2h
    move-object v11, v3
    if-eqz v11, +015h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v5
    invoke-interface v5, v11, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    goto +2h
    move-object v5, v3
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v7
    const-string v15, ", status="
    const-string/jumbo v16, result
    const-string v17, "comfort"
    const-string v14, ", role="
    if-eqz v7, +0abh
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, "[SubTask] botFinalParsed: taskId="
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    if-eqz v1, +005h
    move-object/from16 v10, v16
    goto +3h
    move-object/from16 v10, v17
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", attachedId="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", pendingTerminal="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v10
    goto +2h
    move-object v10, v3
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", active="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v10
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v3
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const/16 v10, 58
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v10
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v10
    goto +2h
    move-object v10, v3
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", historySize="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v6
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v6
    invoke-virtual v9, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v9, ", cleanedLen="
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v9
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v9, ", incomplete="
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead()Z
    move-result v9
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, v4, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v19
    if-eqz v1, +03dh
    if-eqz v19, +03bh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->mapHeadStatusToTerminal(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v6
    if-eqz v6, +031h
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-ne v6, v7, +009h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v7
    move-object/from16 v26, v7
    goto +3h
    move-object/from16 v26, v3
    new-instance v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    const-string v20, ""
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v25, 0
    const-wide/16 v27, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 3932
    const/16 v33, 0
    move-object/from16 v18, v7
    move-object/from16 v24, v6
    invoke-direct/range v18 ... v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->applySubTaskTerminal(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    new-instance v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, subtitle_bot_
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    invoke-virtual v6, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->Assistant Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    if-eqz v1, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v18
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v19
    goto +3h
    move-object/from16 v19, v3
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v3
    move-object v5, v13
    move-object/from16 v34, v13
    move-object/from16 v13, v18
    move-object v0, v14
    move-object/from16 v14, v19
    move-object/from16 v18, v4
    move-object v4, v15
    move-object v15, v3
    invoke-direct/range v5 ... v15, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +037h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[BotReply] subTask tag parsed: sourceTaskId="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    if-eqz v1, +005h
    move-object/from16 v1, v16
    goto +3h
    move-object/from16 v1, v17
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v1, v18
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object/from16 v0, v35
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-object v3, v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    move-object/from16 v15, v34
    invoke-static v4, v15, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Object;)Ljava/util/List;
    move-result-object v5
    sget-object v8, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    const/4 v4, 0
    const/4 v6, 0
    const/4 v9, 0
    const/4 v10, 0
    const-string v11, ""
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v30, v15
    move/from16 v15, v16
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 4194149
    const/16 v29, 0
    invoke-static/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v1, v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    move-object/from16 v34, v30
    goto -4dh
.end method

.method private final handleUserFinalText(java.lang.String)void
    .registers 44
    # ins_size=2
    move-object/from16 v0, v42
    move-object/from16 v1, v43
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +07ah
    new-instance v14, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, subtitle_user_
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 496
    const/4 v13, 0
    move-object v1, v14
    move-object/from16 v4, v43
    invoke-direct/range v1 ... v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-object v15, v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-static v3, v14, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Object;)Ljava/util/List;
    move-result-object v17
    sget-object v18, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    sget-object v21, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    sget-object v19, Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    sget-object v20, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/16 v16, 0
    const-string v22, ""
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const-wide/16 v29, 0
    const-wide/16 v31, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const v40, 4194177
    const/16 v41, 0
    invoke-static/range v15 ... v41, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v1, v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -049h
    goto +3ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v4, 0
    const/4 v5, 0
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const-string v10, ""
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 4194203
    const/16 v29, 0
    invoke-static/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v1, v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -037h
    return-void 
.end method

.method public static synthetic initVoiceSession$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  android.content.Context  java.lang.String  java.lang.String  boolean  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source  boolean  int  java.lang.Object)void
    .registers 29
    # ins_size=14
    move/from16 v0, v27
    and-int/lit8 v1, v0, 4
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v1, v0, 8
    if-eqz v1, +005h
    const/4 v1, 0
    move v7, v1
    goto +3h
    move/from16 v7, v19
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v20
    and-int/lit8 v1, v0, 32
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v21
    and-int/lit8 v1, v0, 64
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v25
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +005h
    const/4 v0, 1
    move v14, v0
    goto +3h
    move/from16 v14, v26
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    invoke-virtual/range v3 ... v14, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->initVoiceSession(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source; Z)V
    return-void 
.end method

.method private static final initVoiceSession$lambda$32(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  byte[])kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "bytes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getBotName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +004h
    const-string v1, ""
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +00fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "BrainstormViewModel"
    const-string/jumbo v0, sendAckToBot: botName empty, drop ack
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->sendUserBinaryMessageToBot(Ljava/lang/String; [B)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final isCjkChar(char)boolean
    .registers 3
    # ins_size=2
    invoke-static v2, Ljava/lang/Character$UnicodeBlock;->of(C)Ljava/lang/Character$UnicodeBlock;
    move-result-object v2
    sget-object v0, Ljava/lang/Character$UnicodeBlock;->CJK_UNIFIED_IDEOGRAPHS Ljava/lang/Character$UnicodeBlock;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +035h
    sget-object v0, Ljava/lang/Character$UnicodeBlock;->CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A Ljava/lang/Character$UnicodeBlock;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +02dh
    sget-object v0, Ljava/lang/Character$UnicodeBlock;->CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B Ljava/lang/Character$UnicodeBlock;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +025h
    sget-object v0, Ljava/lang/Character$UnicodeBlock;->CJK_COMPATIBILITY_IDEOGRAPHS Ljava/lang/Character$UnicodeBlock;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01dh
    sget-object v0, Ljava/lang/Character$UnicodeBlock;->CJK_SYMBOLS_AND_PUNCTUATION Ljava/lang/Character$UnicodeBlock;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +015h
    sget-object v0, Ljava/lang/Character$UnicodeBlock;->HALFWIDTH_AND_FULLWIDTH_FORMS Ljava/lang/Character$UnicodeBlock;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00dh
    sget-object v0, Ljava/lang/Character$UnicodeBlock;->GENERAL_PUNCTUATION Ljava/lang/Character$UnicodeBlock;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method private final logUnrecognizedRtcFrame(java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=4
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "onRtcTextMessage: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v1, " frame from uid="
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", length="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", hash="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const-string v5, "BrainstormViewModel"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method static synthetic logUnrecognizedRtcFrame$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +005h
    const-string/jumbo v3, unrecognized
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->logUnrecognizedRtcFrame(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final markCurrentRoundHasSubtask()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->currentRound()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    if-eqz v0, +006h
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setHasSubtask(Z)V
    return-void 
.end method

.method private final markCurrentRoundServerTool(java.lang.String)void
    .registers 5
    # ins_size=2
    if-eqz v4, +02bh
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    if-eqz v0, +003h
    goto +2h
    const/4 v4, 0
    if-nez v4, +003h
    goto +1ah
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->currentRound()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    if-eqz v0, +015h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getToolNames()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, v4, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    const-string/jumbo v2, web_search
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setHasSearch(Z)V
    return-void 
.end method

.method private final markCurrentRoundUpload()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->currentRound()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    if-eqz v0, +00eh
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setHasUpload(Z)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getAttachmentCount()I
    move-result v2
    add-int/2addr v2, v1
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setAttachmentCount(I)V
    return-void 
.end method

.method private final maxOrMissing(java.util.List)long
    .registers 4
    # ins_size=2
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->maxOrNull(Ljava/lang/Iterable;)Ljava/lang/Comparable;
    move-result-object v3
    check-cast v3, Ljava/lang/Long;
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, -1
    return-wide v0
.end method

.method private final maybeNotifyPendingAttachments()void
    .registers 13
    # ins_size=1
    iget-object v0, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    instance-of v2, v1, Ljava/util/Collection;
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +00dh
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v1, v4
    goto +1fh
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -00ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v2, v5, +004h
    move v2, v3
    goto +2h
    move v2, v4
    if-eqz v2, -017h
    move v1, v3
    if-eqz v1, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +034h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploaded Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v6, v7, +01eh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUploadedRef()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v4
    goto +2h
    move v6, v3
    if-nez v6, +00ah
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getNotifiedToBot()Z
    move-result v5
    if-nez v5, +004h
    move v5, v3
    goto +2h
    move v5, v4
    if-eqz v5, -032h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -37h
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v0, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +029h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    new-instance v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUploadedRef()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getDisplayName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUseImageUpload()Z
    move-result v8
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v9
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J)V
    invoke-interface v0, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ch
    check-cast v0, Ljava/util/List;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->notifyAttachmentsToBot(Ljava/util/List;)Z
    move-result v2
    const-string v3, "BrainstormViewModel"
    if-nez v2, +01bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "maybeNotifyPendingAttachments: refused, count="
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "maybeNotifyPendingAttachments: notified "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, " items to bot LLM"
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +019h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda2;
    invoke-direct v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda2;-><init>()V
    const/4 v6, 2
    const/4 v7, 0
    move-object v2, v12
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    goto -1ch
    return-void 
.end method

.method private static final maybeNotifyPendingAttachments$lambda$20$lambda$19(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 20
    # ins_size=1
    move-object/from16 v0, v19
    const-string v1, "it"
    move-object/from16 v2, v19
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 1
    const-wide/16 v14, 0
    const/16 v16, 0
    const/16 v17, 14335
    const/16 v18, 0
    invoke-static/range v0 ... v18, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method private final onAttachmentUploadDone(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->maybeNotifyPendingAttachments()V
    return-void 
.end method

.method public static synthetic pickAndUpload$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  android.net.Uri  java.lang.String  java.lang.String  long  boolean  java.lang.String  int  java.lang.Object)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 32
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v16
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-wide v5, v13
    move v7, v15
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pickAndUpload(Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String; J Z Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic recordVoiceAttemptSignal$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal  java.lang.String  int  int  java.lang.Object)boolean
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->getValue()Ljava/lang/String;
    move-result-object v2
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I)Z
    move-result v0
    return v0
.end method

.method private final refreshVoiceAttemptContext()void
    .registers 12
    # ins_size=1
    iget-object v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getContext()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    move-result-object v2
    iget-object v3, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v4, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    const-string v5, ""
    if-nez v1, +003h
    move-object v1, v5
    iget-object v6, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    if-nez v6, +003h
    move-object v6, v5
    iget-boolean v7, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    const/4 v8, 0
    const/16 v9, 32
    const/4 v10, 0
    move-object v5, v1
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->copy$default(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->updateContext(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;)V
    return-void 
.end method

.method private final reportDiscussionSessionPerf(java.lang.String)void
    .registers 56
    # ins_size=2
    move-object/from16 v1, v54
    move-object/from16 v0, v55
    const-string/jumbo v2, valid_round_count
    const-string v3, "max_user_subtitle_last_char_ms"
    const-string v4, "avg_user_subtitle_last_char_ms"
    const-string v5, "max_user_subtitle_first_char_ms"
    const-string v6, "avg_user_subtitle_first_char_ms"
    const-string v7, "max_last_char_on_screen_ms"
    const-string v8, "avg_last_char_on_screen_ms"
    const-string v9, "max_first_char_on_screen_ms"
    const-string v10, "avg_first_char_on_screen_ms"
    const-string v11, "bot_char_count"
    const-string/jumbo v12, user_char_count
    const-string v13, "bot_message_count"
    const-string/jumbo v14, user_message_count
    const-string/jumbo v15, total_duration_ms
    move-object/from16 v16, v2
    const-string v2, "BrainstormViewModel"
    const-string/jumbo v0, session_end
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->closeLastRoundAsInterruptedIfNeeded(Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-object/from16 v17, v3
    move-object/from16 v18, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionElapsedMs()J
    move-result-wide v3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    if-nez v0, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, reportDiscussionSessionPerf: totalRounds=0, skip both reports
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object/from16 v19, v2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v20, Ljava/util/ArrayList;
    invoke-direct/range v20, Ljava/util/ArrayList;-><init>()V
    move/from16 v21, v0
    move-object/from16 v0, v20
    check-cast v0, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v20
    const/16 v22, 1
    const/16 v23, 0
    if-eqz v20, +029h
    move-object/from16 v20, v5
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object/from16 v24, v5
    check-cast v24, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterrupted()Z
    move-result v25
    if-nez v25, +00fh
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v25
    if-eqz v25, +009h
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFinishMs()Ljava/lang/Long;
    move-result-object v24
    if-eqz v24, +003h
    goto +3h
    move/from16 v22, v23
    if-eqz v22, +005h
    invoke-interface v0, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v5, v20
    goto -30h
    move-object/from16 v20, v5
    check-cast v0, Ljava/util/List;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v24
    if-eqz v24, +025h
    move-object/from16 v24, v6
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object/from16 v25, v6
    check-cast v25, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterrupted()Z
    move-result v26
    if-nez v26, +00bh
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v25
    if-eqz v25, +005h
    move/from16 v25, v22
    goto +3h
    move/from16 v25, v23
    if-eqz v25, +005h
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v6, v24
    goto -28h
    move-object/from16 v24, v6
    check-cast v5, Ljava/util/List;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v25
    if-eqz v25, +025h
    move-object/from16 v25, v7
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object/from16 v26, v7
    check-cast v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterrupted()Z
    move-result v27
    if-nez v27, +00bh
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserFinalReceived()Z
    move-result v26
    if-eqz v26, +005h
    move/from16 v26, v22
    goto +3h
    move/from16 v26, v23
    if-eqz v26, +005h
    invoke-interface v6, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v7, v25
    goto -28h
    move-object/from16 v25, v7
    check-cast v6, Ljava/util/List;
    move-object v2, v0
    check-cast v2, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v26
    const/16 v27, 0
    if-eqz v26, +02ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v26
    check-cast v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v28
    if-eqz v28, +012h
    check-cast v28, Ljava/lang/Number;
    invoke-virtual/range v28, Ljava/lang/Number;->longValue()J
    move-result-wide v27
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v29
    sub-long v27, v27, v29
    invoke-static/range v27 ... v28, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v27
    move-object/from16 v26, v2
    move-object/from16 v2, v27
    if-eqz v2, +005h
    invoke-interface v7, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v2, v26
    goto -2fh
    check-cast v7, Ljava/util/List;
    move-object v2, v0
    check-cast v2, Ljava/lang/Iterable;
    new-instance v26, Ljava/util/ArrayList;
    invoke-direct/range v26, Ljava/util/ArrayList;-><init>()V
    move-object/from16 v28, v0
    move-object/from16 v0, v26
    check-cast v0, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v26
    if-eqz v26, +031h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v26
    check-cast v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotLatestCharMs()Ljava/lang/Long;
    move-result-object v29
    if-eqz v29, +019h
    check-cast v29, Ljava/lang/Number;
    invoke-virtual/range v29, Ljava/lang/Number;->longValue()J
    move-result-wide v29
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v31
    sub-long v29, v29, v31
    invoke-static/range v29 ... v30, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v26
    move-object/from16 v53, v26
    move-object/from16 v26, v2
    move-object/from16 v2, v53
    goto +5h
    move-object/from16 v26, v2
    move-object/from16 v2, v27
    if-eqz v2, +005h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v2, v26
    goto -34h
    check-cast v0, Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v26
    if-eqz v26, +031h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v26
    check-cast v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v29
    if-eqz v29, +019h
    check-cast v29, Ljava/lang/Number;
    invoke-virtual/range v29, Ljava/lang/Number;->longValue()J
    move-result-wide v29
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v31
    sub-long v29, v29, v31
    invoke-static/range v29 ... v30, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v26
    move-object/from16 v53, v26
    move-object/from16 v26, v5
    move-object/from16 v5, v53
    goto +5h
    move-object/from16 v26, v5
    move-object/from16 v5, v27
    if-eqz v5, +005h
    invoke-interface v2, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v5, v26
    goto -34h
    check-cast v2, Ljava/util/List;
    move-object v5, v6
    check-cast v5, Ljava/lang/Iterable;
    new-instance v26, Ljava/util/ArrayList;
    invoke-direct/range v26, Ljava/util/ArrayList;-><init>()V
    move-object/from16 v29, v8
    move-object/from16 v8, v26
    check-cast v8, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v26
    move-object/from16 v30, v9
    move-object/from16 v31, v10
    const-wide/16 v9, 0
    if-eqz v26, +04dh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v26
    check-cast v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakStartMs()Ljava/lang/Long;
    move-result-object v32
    if-eqz v32, +02dh
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleFirstCharMs()Ljava/lang/Long;
    move-result-object v32
    if-eqz v32, +027h
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleFirstCharMs()Ljava/lang/Long;
    move-result-object v32
    invoke-static/range v32, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual/range v32, Ljava/lang/Long;->longValue()J
    move-result-wide v32
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakStartMs()Ljava/lang/Long;
    move-result-object v26
    invoke-static/range v26, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual/range v26, Ljava/lang/Long;->longValue()J
    move-result-wide v34
    move-object/from16 v26, v11
    move-object/from16 v36, v12
    sub-long v11, v32, v34
    invoke-static v11, v12, v9, v10, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v9
    invoke-static v9, v10, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v9
    goto +7h
    move-object/from16 v26, v11
    move-object/from16 v36, v12
    move-object/from16 v9, v27
    if-eqz v9, +005h
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v11, v26
    move-object/from16 v9, v30
    move-object/from16 v10, v31
    move-object/from16 v12, v36
    goto -56h
    move-object/from16 v26, v11
    move-object/from16 v36, v12
    check-cast v8, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +02bh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleLastCharMs()Ljava/lang/Long;
    move-result-object v12
    if-eqz v12, +017h
    check-cast v12, Ljava/lang/Number;
    invoke-virtual v12, Ljava/lang/Number;->longValue()J
    move-result-wide v32
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v11
    sub-long v11, v32, v11
    invoke-static v11, v12, v9, v10, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v11
    invoke-static v11, v12, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    goto +3h
    move-object/from16 v11, v27
    if-eqz v11, -029h
    invoke-interface v5, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v5, Ljava/util/List;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->avgOrMissing(Ljava/util/List;)J
    move-result-wide v9
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->maxOrMissing(Ljava/util/List;)J
    move-result-wide v6
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->avgOrMissing(Ljava/util/List;)J
    move-result-wide v11
    move-wide/from16 v32, v11
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->maxOrMissing(Ljava/util/List;)J
    move-result-wide v11
    move-wide/from16 v34, v11
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->avgOrMissing(Ljava/util/List;)J
    move-result-wide v11
    move-wide/from16 v37, v6
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->maxOrMissing(Ljava/util/List;)J
    move-result-wide v6
    move-wide/from16 v39, v9
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->avgOrMissing(Ljava/util/List;)J
    move-result-wide v9
    move-wide/from16 v41, v9
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->maxOrMissing(Ljava/util/List;)J
    move-result-wide v8
    move-wide/from16 v43, v8
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->avgOrMissing(Ljava/util/List;)J
    move-result-wide v8
    move-wide/from16 v45, v8
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->maxOrMissing(Ljava/util/List;)J
    move-result-wide v8
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    instance-of v2, v0, Ljava/util/Collection;
    if-eqz v2, +00eh
    move-object v2, v0
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +005h
    move/from16 v2, v23
    goto +2ah
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move/from16 v2, v23
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +01fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterruptPhase()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move-result-object v5
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-ne v5, v10, +005h
    move/from16 v5, v22
    goto +3h
    move/from16 v5, v23
    if-eqz v5, -019h
    add-int/lit8 v2, v2, 1
    if-gez v2, -01dh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -22h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    instance-of v5, v0, Ljava/util/Collection;
    if-eqz v5, +00eh
    move-object v5, v0
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +005h
    move/from16 v5, v23
    goto +2eh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move/from16 v5, v23
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +023h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterruptPhase()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move-result-object v10
    move-object/from16 v47, v0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_FIRST_CHAR Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-ne v10, v0, +005h
    move/from16 v0, v22
    goto +3h
    move/from16 v0, v23
    if-eqz v0, +009h
    add-int/lit8 v5, v5, 1
    if-gez v5, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    move-object/from16 v0, v47
    goto -26h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionRoundDelays Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    instance-of v10, v0, Ljava/util/Collection;
    if-eqz v10, +010h
    move-object v10, v0
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    if-eqz v10, +007h
    move-wide/from16 v49, v8
    move/from16 v10, v23
    goto +34h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move/from16 v10, v23
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v47
    if-eqz v47, +027h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v47
    check-cast v47, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-object/from16 v48, v0
    invoke-virtual/range v47, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterruptPhase()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move-result-object v0
    move-wide/from16 v49, v8
    sget-object v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->DURING_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-ne v0, v8, +005h
    move/from16 v0, v22
    goto +3h
    move/from16 v0, v23
    if-eqz v0, +009h
    add-int/lit8 v10, v10, 1
    if-gez v10, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    move-object/from16 v0, v48
    move-wide/from16 v8, v49
    goto -2ah
    move-wide/from16 v49, v8
    add-int v0, v2, v5
    iget-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v8
    goto +3h
    move-object/from16 v8, v27
    const-string v9, ""
    if-nez v8, +006h
    move-object v8, v9
    move-object/from16 v22, v8
    goto +3h
    move-object/from16 v22, v9
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->originConversationId Ljava/lang/String;
    move/from16 v23, v10
    if-nez v9, +004h
    move-object/from16 v9, v22
    new-instance v10, Lorg/json/JSONObject;
    invoke-direct v10, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v10, v15, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move/from16 v47, v5
    iget v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserMessageCount I
    invoke-virtual v10, v14, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotMessageCount I
    invoke-virtual v10, v13, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserCharCount I
    move-object/from16 v48, v13
    move-object/from16 v13, v36
    invoke-virtual v10, v13, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotCharCount I
    move-object/from16 v36, v13
    move-object/from16 v13, v26
    invoke-virtual v10, v13, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v5, "avg_response_delay_ms"
    invoke-virtual v10, v5, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v5, "max_response_delay_ms"
    invoke-virtual v10, v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v7, v31
    move-wide/from16 v5, v39
    invoke-virtual v10, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v31, v13
    move-object/from16 v26, v14
    move-wide/from16 v13, v37
    move-wide/from16 v37, v11
    move-object/from16 v11, v30
    invoke-virtual v10, v11, v13, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v30, v11
    move-wide/from16 v11, v32
    move-wide/from16 v32, v13
    move-object/from16 v13, v29
    invoke-virtual v10, v13, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v39, v11
    move-object/from16 v14, v25
    move-wide/from16 v11, v34
    invoke-virtual v10, v14, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v34, v11
    move-object/from16 v25, v14
    move-object/from16 v14, v24
    move-wide/from16 v11, v41
    invoke-virtual v10, v14, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v41, v11
    move-object/from16 v24, v14
    move-object/from16 v14, v20
    move-wide/from16 v11, v43
    invoke-virtual v10, v14, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v43, v11
    move-object/from16 v20, v14
    move-object/from16 v14, v18
    move-wide/from16 v11, v45
    invoke-virtual v10, v14, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v45, v11
    move-object/from16 v18, v14
    move-object/from16 v14, v17
    move-wide/from16 v11, v49
    invoke-virtual v10, v14, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v49, v11
    invoke-interface/range v28, Ljava/util/List;->size()I
    move-result v11
    move-object/from16 v12, v16
    invoke-virtual v10, v12, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v11, total_round_count
    move-object/from16 v17, v14
    move/from16 v14, v21
    invoke-virtual v10, v11, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v11, "interrupted_before_reply_count"
    invoke-virtual v10, v11, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v11, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    move/from16 v16, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    move-object/from16 v29, v13
    iget-object v13, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v11, v0, v13, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->commonCategory(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    move-result-object v0
    const-string v11, "end_type"
    move-object/from16 v13, v55
    invoke-virtual v0, v11, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v11, subtitle_enabled
    move-wide/from16 v51, v5
    iget-boolean v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionHasEverEnabledSubtitle Z
    const-string v6, "1"
    const-string v21, "0"
    if-eqz v5, +004h
    move-object v5, v6
    goto +3h
    move-object/from16 v5, v21
    invoke-virtual v0, v11, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v11, session_id
    invoke-virtual v5, v11, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v9, room_id
    invoke-virtual v5, v9, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v9, "attempt_id"
    iget-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v11, +00dh
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v11
    goto +3h
    move-object/from16 v11, v27
    if-nez v11, +004h
    move-object/from16 v11, v22
    invoke-virtual v5, v9, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v9, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string/jumbo v11, voice_discussion_session_perf
    invoke-virtual v9, v11, v0, v10, v5, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v5, v0, v9, v10, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    const-string v5, "conversation_id"
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    if-nez v9, +004h
    move-object/from16 v9, v22
    invoke-virtual v0, v5, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, room_id
    invoke-virtual v0, v5, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "attempt_id"
    iget-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v8, +00ch
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v8
    if-eqz v8, +006h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v27
    if-nez v27, +005h
    move-object/from16 v9, v22
    goto +3h
    move-object/from16 v9, v27
    invoke-virtual v0, v5, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "end_type"
    invoke-virtual v0, v5, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, v15, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v5, total_round_count
    invoke-virtual v0, v5, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-interface/range v28, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v0, v12, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v5, "interrupted_before_answering_count"
    invoke-virtual v0, v5, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v2, "interrupted_before_first_char_count"
    move/from16 v5, v47
    invoke-virtual v0, v2, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v2, "interrupted_during_answering_count"
    move/from16 v10, v23
    invoke-virtual v0, v2, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-wide/from16 v8, v51
    invoke-virtual v0, v7, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v2, v30
    move-wide/from16 v11, v32
    invoke-virtual v0, v2, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v2, v29
    move-wide/from16 v11, v39
    invoke-virtual v0, v2, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object v2, v6
    move-object/from16 v7, v25
    move-wide/from16 v5, v34
    invoke-virtual v0, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v7, v24
    move-wide/from16 v5, v41
    invoke-virtual v0, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v7, v20
    move-wide/from16 v5, v43
    invoke-virtual v0, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v7, v18
    move-wide/from16 v5, v45
    invoke-virtual v0, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v7, v17
    move-wide/from16 v5, v49
    invoke-virtual v0, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v5, "avg_server_thinking_ms"
    move-wide/from16 v6, v37
    invoke-virtual v0, v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v5, subtitle_enabled
    iget-boolean v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionHasEverEnabledSubtitle Z
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v21
    invoke-virtual v0, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "is_new_session"
    iget-boolean v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v21
    invoke-virtual v0, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserMessageCount I
    move-object/from16 v5, v26
    invoke-virtual v0, v5, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotMessageCount I
    move-object/from16 v5, v48
    invoke-virtual v0, v5, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserCharCount I
    move-object/from16 v5, v36
    invoke-virtual v0, v5, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotCharCount I
    move-object/from16 v5, v31
    invoke-virtual v0, v5, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v5, voice_discussion_session_end
    invoke-virtual v2, v5, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v5, reportDiscussionSessionPerf: endType=
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, " total="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "ms rounds="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " valid="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-interface/range v28, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " interruptBeforeReply="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move/from16 v4, v16
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " duringAns="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " avgFirstChar="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "ms avgLastChar="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, v12, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "ms userMsg="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserMessageCount I
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " userChar="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserCharCount I
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " botMsg="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotMessageCount I
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " botChar="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotCharCount I
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " subtitle="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-boolean v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionHasEverEnabledSubtitle Z
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v3, v19
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +11h
    move-exception v0
    goto +7h
    move-exception v0
    move-object/from16 v3, v19
    goto +3h
    move-exception v0
    move-object v3, v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v4, reportDiscussionSessionPerf failed
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x28
    :try_start_0x51
    :try_start_0x39f
    :try_start_0x46b
    :try_start_0x61d
.end method

.method private final reportDiscussionStartPerfIfNeeded()void
    .registers 18
    # ins_size=1
    move-object/from16 v1, v17
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->discussionStartPerfReported Z
    if-eqz v0, +003h
    return-void 
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckStartMs J
    const-wide/16 v4, 0
    cmp-long v0, v2, v4
    if-gtz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->discussionStartPerfReported Z
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iget-wide v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckEndMs J
    iget-wide v8, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckStartMs J
    sub-long/2addr v6, v8
    invoke-static v6, v7, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v6
    iget-wide v8, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomStartMs J
    iget-wide v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfApiRequestStartMs J
    sub-long/2addr v8, v10
    invoke-static v8, v9, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v8
    iget-wide v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomSuccessMs J
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomStartMs J
    sub-long/2addr v10, v12
    invoke-static v10, v11, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v10
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfBotJoinedMs J
    cmp-long v0, v12, v4
    if-lez v0, +00ah
    iget-wide v14, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomSuccessMs J
    sub-long/2addr v12, v14
    invoke-static v12, v13, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v12
    goto +2h
    move-wide v12, v4
    iget-wide v14, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckStartMs J
    sub-long/2addr v2, v14
    invoke-static v2, v3, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    const-string v5, ""
    if-nez v0, +003h
    move-object v0, v5
    sget-object v14, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v14, v15, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->commonCategory(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    move-result-object v4
    const-string v14, "is_new_session"
    iget-boolean v15, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    if-eqz v15, +005h
    const-string v15, "1"
    goto +3h
    const-string v15, "0"
    invoke-virtual v4, v14, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v14, Lorg/json/JSONObject;
    invoke-direct v14, Lorg/json/JSONObject;-><init>()V
    const-string v15, "mic_check_ms"
    invoke-virtual v14, v15, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v6, start_voice_chat_request_ms
    invoke-virtual v14, v6, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v6, "join_room_ms"
    invoke-virtual v14, v6, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v6, "bot_join_ms"
    invoke-virtual v14, v6, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v6, total_ms
    invoke-virtual v14, v6, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v3, room_id
    invoke-virtual v2, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "attempt_id"
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v3, +00fh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v3
    if-eqz v3, +009h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v16, v3
    goto +3h
    const/16 v16, 0
    if-nez v16, +003h
    goto +3h
    move-object/from16 v5, v16
    invoke-virtual v2, v0, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string/jumbo v3, rtc_voice_discussion_start_perf
    invoke-virtual v0, v3, v4, v14, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +ch
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "BrainstormViewModel"
    const-string/jumbo v4, reportDiscussionStartPerf failed
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x2
    :try_start_0x57
.end method

.method private final reportRoundPerf(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord)void
    .registers 29
    # ins_size=2
    move-object/from16 v1, v27
    const-string v2, "BrainstormViewModel"
    const-string/jumbo v0, voice_discussion_round_perf: 
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +00eh
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v6
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v8
    sub-long/2addr v6, v8
    goto +3h
    const-wide/16 v6, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotLatestCharMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +00eh
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v8
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v10
    sub-long/2addr v8, v10
    goto +3h
    const-wide/16 v8, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +00eh
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v10
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v12
    sub-long/2addr v10, v12
    goto +3h
    const-wide/16 v10, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +020h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +01ah
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v12
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v14
    sub-long/2addr v12, v14
    goto +3h
    const-wide/16 v12, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +021h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotLatestCharMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +01bh
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotLatestCharMs()Ljava/lang/Long;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v14
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v16
    sub-long v14, v14, v16
    goto +3h
    const-wide/16 v14, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterrupted()Z
    move-result v3
    if-eqz v3, +015h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    if-nez v3, +00fh
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v16
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v18
    sub-long v16, v16, v18
    move-wide/from16 v4, v16
    goto +3h
    const-wide/16 v4, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakStartMs()Ljava/lang/Long;
    move-result-object v3
    move-wide/from16 v18, v4
    const-wide/16 v4, 0
    if-eqz v3, +027h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +021h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleFirstCharMs()Ljava/lang/Long;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v20
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakStartMs()Ljava/lang/Long;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v22
    move-object/from16 v24, v2
    sub-long v2, v20, v22
    invoke-static v2, v3, v4, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v2
    goto +5h
    move-object/from16 v24, v2
    const-wide/16 v2, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleLastCharMs()Ljava/lang/Long;
    move-result-object v20
    if-eqz v20, +015h
    check-cast v20, Ljava/lang/Number;
    invoke-virtual/range v20, Ljava/lang/Number;->longValue()J
    move-result-wide v16
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakEndMs()J
    move-result-wide v20
    move-wide/from16 v22, v2
    sub-long v2, v16, v20
    invoke-static v2, v3, v4, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    goto +5h
    move-wide/from16 v22, v2
    const-wide/16 v4, -1
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterrupted()Z
    move-result v2
    if-nez v2, +011h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFinishMs()Ljava/lang/Long;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v2
    if-eqz v2, +005h
    const-string v2, "normal"
    goto +25h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterruptPhase()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-ne v2, v3, +005h
    const-string v2, "interrupted_before_answering"
    goto +1ah
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterruptPhase()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_FIRST_CHAR Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-ne v2, v3, +005h
    const-string v2, "interrupted_before_first_char"
    goto +fh
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterruptPhase()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->DURING_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    if-ne v2, v3, +005h
    const-string v2, "interrupted_during_answering"
    goto +4h
    const-string/jumbo v2, session_end_dangling
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotCharCount()I
    move-result v3
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotCurrentParagraphChars()I
    move-result v16
    add-int v3, v3, v16
    move-object/from16 v16, v0
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserCharCount()I
    move-result v0
    move/from16 v17, v3
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    move/from16 v20, v0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    move-wide/from16 v25, v4
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v0, v3, v4, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    const-string v0, "conversation_id"
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    const-string v5, ""
    if-nez v4, +003h
    move-object v4, v5
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, room_id
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/16 v21, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v21
    if-nez v4, +003h
    move-object v4, v5
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "attempt_id"
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v4, +00ch
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v4
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v21
    if-nez v21, +003h
    goto +3h
    move-object/from16 v5, v21
    invoke-virtual v3, v0, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, round_index
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getRoundIndex()I
    move-result v4
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "conv_round_id"
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getConvRoundId()J
    move-result-wide v4
    invoke-virtual v3, v0, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, round_result
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "first_char_on_screen_ms"
    invoke-virtual v3, v0, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "last_char_on_screen_ms"
    invoke-virtual v3, v0, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, server_thinking_ms
    invoke-virtual v3, v0, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "answering_to_first_char_ms"
    invoke-virtual v3, v0, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "bot_speaking_duration_ms"
    invoke-virtual v3, v0, v14, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, waited_before_interrupt_ms
    move-wide/from16 v4, v18
    invoke-virtual v3, v0, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, user_subtitle_first_char_ms
    move-wide/from16 v4, v22
    invoke-virtual v3, v0, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, user_subtitle_last_char_ms
    move-wide/from16 v4, v25
    invoke-virtual v3, v0, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, user_char_count
    move/from16 v2, v20
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "bot_char_count"
    move/from16 v2, v17
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "is_new_session"
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    if-eqz v2, +005h
    const-string v2, "1"
    goto +3h
    const-string v2, "0"
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "has_search"
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getHasSearch()Z
    move-result v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->boolValue(Z)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "has_subtask"
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getHasSubtask()Z
    move-result v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->boolValue(Z)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "has_upload"
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getHasUpload()Z
    move-result v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->boolValue(Z)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "attachment_count"
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getAttachmentCount()I
    move-result v2
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v0, tool_name
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getToolNames()Ljava/util/Set;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Ljava/lang/Iterable;
    const-string v2, ","
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 62
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v2, voice_discussion_round_perf
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    move-object/from16 v4, v16
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v3, v24
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ROUND_REPORTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v0, +016h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finishInferred()Z
    goto +11h
    move-exception v0
    goto +7h
    move-exception v0
    move-object/from16 v3, v24
    goto +3h
    move-exception v0
    move-object v3, v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v4, reportRoundPerf failed
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x7
    :try_start_0xd5
    :try_start_0x161
    :try_start_0x269
.end method

.method private final reportServerToolEnd(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)void
    .registers 12
    # ins_size=2
    invoke-direct v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->currentRound()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v6, 0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v6
    if-nez v5, +004h
    const-string v5, ""
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getRoundIndex()I
    move-result v7
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    goto +2h
    move-object v7, v6
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getConvRoundId()J
    move-result-wide v8
    invoke-static v8, v9, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    goto +2h
    move-object v0, v6
    move-object v6, v7
    move-object v7, v0
    move-object v8, v11
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportServerToolEnd(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Long; Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
.end method

.method private final reportVoiceFileUploadEnd(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  long  long  java.lang.String  java.lang.String)void
    .registers 26
    # ins_size=8
    move-object/from16 v0, v18
    invoke-direct/range v18, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->currentRound()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v7, 0
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v7
    if-nez v6, +004h
    const-string v6, ""
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getRoundIndex()I
    move-result v8
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    goto +2h
    move-object v8, v7
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getConvRoundId()J
    move-result-wide v9
    invoke-static v9, v10, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    goto +2h
    move-object v1, v7
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage()Z
    move-result v7
    if-eqz v7, +005h
    const-string v7, "image"
    goto +3h
    const-string v7, "attachment"
    move-object v9, v7
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getMimeType()Ljava/lang/String;
    move-result-object v10
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUseImageUpload()Z
    move-result v7
    if-eqz v7, +005h
    const-string v7, "imagex"
    goto +3h
    const-string v7, "remote_resource"
    move-object v13, v7
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    sub-long v14, v11, v22
    move-object v7, v8
    move-object v8, v1
    move-wide/from16 v11, v20
    move-object/from16 v16, v24
    move-object/from16 v17, v25
    invoke-virtual/range v2 ... v17, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportFileUploadEnd(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final resolveVoiceConversationIdForRecording(kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +014h
    if-ne v2, v4, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +30h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->needRemoteParentChatSessionForVoice Z
    if-nez v6, +014h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getCliConversationId()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +00dh
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v4
    if-eqz v0, +003h
    move-object v3, v6
    return-object v3
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->label I
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->awaitParentChatSessionId(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    move-object v0, v5
    check-cast v6, Ljava/lang/String;
    if-eqz v6, +00dh
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v4
    if-eqz v1, +003h
    goto +2h
    move-object v6, v3
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    const/4 v4, 0
    if-eqz v4, +003h
    return-object v3
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    invoke-static v1, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +027h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, resolveVoiceConversationIdForRecording: switch voice cliConversationId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " -> "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BrainstormViewModel"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    return-object v6
.end method

.method private final restartOutputVolumeMonitoring(java.lang.String)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->outputVolumeMonitorJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceHealthMonitor Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->resetOutputVolume()V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;
    invoke-direct v0, v8, v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v9
    iput-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->outputVolumeMonitorJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final retryAttachment$lambda$5(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v1
.end method

.method private final rtcDiag(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RTC_DIAG "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public static synthetic skipIntroAndStartBrainstorm$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    const/4 v3, 1
    and-int/2addr v2, v3
    if-eqz v2, +003h
    move v1, v3
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->skipIntroAndStartBrainstorm(Z)V
    return-void 
.end method

.method private final startSessionTimer()void
    .registers 8
    # ins_size=1
    invoke-direct v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopSessionTimer()V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionTimerJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startUpload(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  android.net.Uri)void
    .registers 19
    # ins_size=3
    move-object/from16 v8, v16
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v9
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v9, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +007h
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->markCurrentRoundUpload()V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v10
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v11, v0
    check-cast v11, Lkotlin/coroutines/CoroutineContext;
    const/4 v12, 0
    new-instance v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;
    const/4 v7, 0
    move-object v0, v13
    move-object/from16 v1, v16
    move-object/from16 v2, v18
    move-object/from16 v3, v17
    move-object v4, v9
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Landroid/net/Uri; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)V
    check-cast v13, Lkotlin/jvm/functions/Function2;
    const/4 v14, 2
    const/4 v15, 0
    invoke-static/range v10 ... v15, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iget-object v1, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/Map;
    invoke-interface v1, v9, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final stopOutputVolumeMonitoring()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->outputVolumeMonitorJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->outputVolumeMonitorJob Lkotlinx/coroutines/Job;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceHealthMonitor Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->resetOutputVolume()V
    return-void 
.end method

.method private final stopSessionTimer()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionTimerJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionTimerJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final tryReportRoundIfFinal(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$RoundDelayRecord  java.lang.String)void
    .registers 5
    # ins_size=3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getInterrupted()Z
    move-result v0
    const/4 v1, 1
    if-nez v0, +022h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFinishMs()Ljava/lang/Long;
    move-result-object v0
    if-nez v0, +01ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +00ah
    const-string v0, "new_thinking"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00eh
    const-string/jumbo v0, session_end
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    const/4 v4, 0
    goto +2h
    move v4, v1
    if-nez v4, +003h
    return-void 
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setReported(Z)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->reportRoundPerf(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;)V
    return-void 
.end method

.method public static synthetic updateAttachment$default(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String  boolean  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment(Ljava/lang/String; Z Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public final attachAudioDeviceManager$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.audio.AudioDeviceManager)void
    .registers 3
    # ins_size=2
    const-string v0, "mgr"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    if-eq v0, v2, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->release()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v2, v0, +007h
    const-string v2, "attach_audio_device"
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->restartOutputVolumeMonitoring(Ljava/lang/String;)V
    return-void 
.end method

.method public final attachVoiceSession$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, session
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatListener Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->setListener(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;)V
    return-void 
.end method

.method public final buildDiscussionDebugLogInfo()com.bytedance.trae.conversation.debug.ConversationDebugLogInfo
    .registers 19
    # ins_size=1
    move-object/from16 v0, v18
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getActiveTask()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v2, +018h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v2
    if-nez v2, +012h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v2
    invoke-interface v2, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/lang/Iterable;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getProxyChatSessionId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModelKt;->resolveVoiceDiscussionDebugSubTaskSessionId(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    sget-object v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->INSTANCE Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionStartTimeMs()J
    move-result-wide v12
    const/4 v1, 0
    const/4 v14, 0
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    const-string v5, ""
    if-nez v4, +004h
    move-object v15, v5
    goto +2h
    move-object v15, v4
    new-instance v16, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v6, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v6
    if-nez v4, +004h
    move-object v8, v5
    goto +2h
    move-object v8, v4
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getTaskId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v6
    if-nez v4, +004h
    move-object v9, v5
    goto +2h
    move-object v9, v4
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getParentConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-nez v4, +004h
    move-object v10, v5
    goto +2h
    move-object v10, v4
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v6
    if-nez v4, +004h
    move-object v11, v5
    goto +2h
    move-object v11, v4
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v6
    if-nez v4, +005h
    move-object/from16 v17, v5
    goto +3h
    move-object/from16 v17, v4
    if-eqz v2, +00ch
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v2
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->name()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    move-object v2, v5
    goto +2h
    move-object v2, v6
    move-object/from16 v4, v16
    move-object v5, v8
    move-object v6, v9
    move-object v8, v10
    move-object v9, v11
    move-object/from16 v10, v17
    move-object v11, v2
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    const/4 v2, 6
    const/4 v4, 0
    move-object v8, v3
    move-wide v9, v12
    move-object v11, v1
    move-object v12, v14
    move-object v13, v15
    move-object/from16 v14, v16
    move v15, v2
    move-object/from16 v16, v4
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->buildInfo$default(Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    move-result-object v1
    return-object v1
.end method

.method public final cancelAttachment(java.lang.String)void
    .registers 11
    # ins_size=2
    const-string v0, "attachmentId"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v10, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +007h
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    const/4 v5, 0
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda0;
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda0;-><init>()V
    const/4 v7, 2
    const/4 v8, 0
    move-object v3, v9
    move-object v4, v10
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final detachAudioDeviceManager$conversation_mainlandRelease()com.bytedance.trae.conversation.brainstorm.audio.AudioDeviceManager
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    return-object v0
.end method

.method public final detachVoiceSession$conversation_mainlandRelease()com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v1, 0
    if-eqz v0, +005h
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->setListener(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;)V
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    return-object v0
.end method

.method public final drainBotSubtitleChars()java.lang.String
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botSubtitleBuffer Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toString(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_botSubtitleBuffer Ljava/lang/StringBuilder;
    invoke-static v1, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    return-object v0
.end method

.method public final endBrainstorm(boolean)void
    .registers 15
    # ins_size=2
    invoke-direct v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopSessionTimer()V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->aiReplyJob Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->aiReplyJob Lkotlinx/coroutines/Job;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecordingJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecordingJob Lkotlinx/coroutines/Job;
    invoke-direct v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopOutputVolumeMonitoring()V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummaryEligibilityKt;->hasSummaryWorthyInput(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getParentConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +004h
    iget-object v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->parentConversationIdForVoice Ljava/lang/String;
    move-object v5, v0
    if-eqz v14, +005h
    const-string v0, "discard"
    goto +17h
    iget-object v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getTimeoutState()Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    move-result-object v0
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Expired Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-ne v0, v6, +006h
    const-string/jumbo v0, timeout
    goto +3h
    const-string v0, "normal"
    invoke-direct v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->reportDiscussionSessionPerf(Ljava/lang/String;)V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finishInferred()Z
    iget-object v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->release()V
    iput-object v2, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    if-nez v14, +007h
    if-nez v4, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v1
    if-eqz v14, +005h
    const-string v6, "brainstorm_abort"
    goto +8h
    if-nez v4, +005h
    const-string v6, "brainstorm_empty_end"
    goto +3h
    const-string v6, "brainstorm_normal_end"
    invoke-virtual v0, v2, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->release(Z Ljava/lang/String;)V
    invoke-direct v13, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->cancelAllPendingUploads(Z)V
    move-object v0, v13
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;
    const/4 v6, 0
    move-object v0, v10
    move-object v1, v3
    move-object v2, v13
    move v3, v4
    move v4, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z Z Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getAttachmentSubTaskEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentSubTaskEnabled Z
    return v0
.end method

.method public final getBrainstormEnded()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->brainstormEnded Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getCliConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getCurrentChatMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v0, v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final getLocalAudioVolume()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->localAudioVolume Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getMinimizeRequested()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->minimizeRequested Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getSummaryFailed()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->summaryFailed Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getSummaryReady()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->summaryReady Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getUiState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->uiState Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getVoiceChatListenerForHolder$conversation_mainlandRelease()com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatListener Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    return-object v0
.end method

.method public final getVoiceCliType()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final getVoiceMode()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public final getVoicePromptEvents()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voicePromptEvents Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final initVoiceAttempt(java.lang.String  long  boolean  long  long  long)void
    .registers 35
    # ins_size=11
    move-object/from16 v0, v24
    move-object/from16 v2, v25
    const-string v1, "attemptId"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +0ebh
    const-wide/16 v3, 0
    cmp-long v1, v26, v3
    if-lez v1, +0e5h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v1, +004h
    goto/16 +0dfh
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    cmp-long v5, v29, v3
    if-ltz v5, +00fh
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->CLICK Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static/range v29 ... v30, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    invoke-virtual v1, v5, v6, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    cmp-long v5, v31, v3
    if-ltz v5, +00fh
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ELIGIBILITY_PASSED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static/range v31 ... v32, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    invoke-virtual v1, v5, v6, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    cmp-long v3, v33, v3
    if-ltz v3, +00fh
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_LAUNCH_REQUESTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static/range v33 ... v34, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    invoke-virtual v1, v3, v4, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v3
    check-cast v3, Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v4
    invoke-interface v3, v4, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v4
    const/4 v5, 0
    if-eqz v4, +017h
    invoke-interface v3, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    move-object v7, v1
    check-cast v7, Ljava/util/Map;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-interface v7, v6, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, -019h
    goto +2h
    move-object v4, v5
    check-cast v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v5
    const-string v4, ""
    if-nez v3, +004h
    move-object v8, v4
    goto +2h
    move-object v8, v3
    new-instance v15, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    new-instance v16, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    new-instance v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    if-nez v9, +005h
    move-object/from16 v20, v4
    goto +3h
    move-object/from16 v20, v9
    iget-object v9, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v9, +006h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +005h
    move-object/from16 v21, v4
    goto +3h
    move-object/from16 v21, v5
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    move-object/from16 v17, v6
    move-object/from16 v18, v3
    move-object/from16 v19, v7
    move/from16 v22, v4
    move/from16 v23, v28
    invoke-direct/range v17 ... v23, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;-><init>(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z)V
    move-object v7, v1
    check-cast v7, Ljava/util/Map;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 976
    const/16 v17, 0
    move-object/from16 v1, v16
    move-object/from16 v2, v25
    move-wide/from16 v3, v26
    move-object v5, v6
    move-object v6, v7
    move-object v7, v9
    move-object v9, v10
    move-object v10, v11
    move v11, v12
    move v12, v13
    move v13, v14
    move-object/from16 v14, v17
    invoke-direct/range v1 ... v14, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;-><init>(Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/16 v4, 14
    const/4 v5, 0
    move-object/from16 v25, v15
    move-object/from16 v26, v16
    move-object/from16 v27, v1
    move-object/from16 v28, v2
    move-object/from16 v29, v3
    move/from16 v30, v4
    move-object/from16 v31, v5
    invoke-direct/range v25 ... v31, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;-><init>(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    return-void 
.end method

.method public final initVoiceSession(android.content.Context  java.lang.String  java.lang.String  boolean  java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source  boolean)void
    .registers 27
    # ins_size=12
    move-object v0, v15
    move-object/from16 v1, v17
    move-object/from16 v6, v21
    move-object/from16 v7, v22
    move/from16 v2, v26
    const-string v3, "context"
    move-object/from16 v4, v16
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "cliType"
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "mode"
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v3, +003h
    return-void 
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->originConversationId Ljava/lang/String;
    const/4 v3, 0
    const/4 v5, 1
    if-eqz v18, +010h
    move-object/from16 v8, v18
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v5
    if-eqz v8, +005h
    move-object/from16 v8, v18
    goto +2h
    move-object v8, v3
    iput-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->parentConversationIdForVoice Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentSubTaskEnabled Z
    const/4 v14, 0
    if-eqz v2, +01bh
    if-eqz v19, +019h
    sget-object v8, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v6, v8, +015h
    move-object v8, v1
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v14
    goto +2h
    move v8, v5
    if-eqz v8, +004h
    move v8, v5
    goto +2h
    move v8, v14
    iput-boolean v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->needRemoteParentChatSessionForVoice Z
    move-object v8, v1
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +003h
    goto +3h
    move v9, v14
    goto +2h
    move v9, v5
    if-eqz v9, +00ah
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v1
    invoke-virtual v1, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v14
    goto +2h
    move v1, v5
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 6
    const/4 v13, 0
    move-object v8, v1
    move-object/from16 v9, v16
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;-><init>(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v2, +04fh
    sget-object v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    if-nez v1, +004h
    const-string v1, ""
    move-object v2, v1
    if-eqz v18, +010h
    move-object/from16 v1, v18
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v5
    if-eqz v1, +005h
    move-object/from16 v4, v18
    goto +2h
    move-object v4, v3
    if-eqz v19, +007h
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v6, v1, +003h
    move v14, v5
    if-eqz v23, +010h
    move-object/from16 v1, v23
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v5
    if-eqz v1, +005h
    move-object/from16 v8, v23
    goto +2h
    move-object v8, v3
    new-instance v12, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    move-object v1, v12
    move-object v3, v4
    move v4, v14
    move-object/from16 v5, v20
    move-object/from16 v6, v21
    move-object/from16 v7, v22
    move-object/from16 v9, v24
    move-object/from16 v10, v25
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source;)V
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda1;
    invoke-direct v1, v15, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    invoke-virtual v11, v12, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->start(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/jvm/functions/Function1;)V
    goto +ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "BrainstormViewModel"
    const-string v3, "initVoiceSession: attachment/subtask disabled, skip coordinator start"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final minimize(java.lang.String)com.bytedance.trae.conversation.brainstorm.MinimizeResult
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getPhase()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    if-eq v0, v1, +00ch
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;
    const-string v0, "Only allowed in Discussing phase"
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;
    return-object v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-nez v0, +00ch
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;
    const-string v0, "Voice session not ready"
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;
    return-object v3
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopSessionTimer()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->migrateFromViewModel$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)Z
    move-result v3
    if-nez v3, +00fh
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startSessionTimer()V
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;
    const-string v0, "Holder migration failed"
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;
    return-object v3
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_minimizeRequested Lkotlinx/coroutines/flow/MutableSharedFlow;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v3, v0, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;
    return-object v3
.end method

.method protected onCleared()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/lifecycle/AndroidViewModel;->onCleared()V
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopSessionTimer()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->aiReplyJob Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecordingJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecordingJob Lkotlinx/coroutines/Job;
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->stopOutputVolumeMonitoring()V
    const/4 v0, 0
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->cancelAllPendingUploads(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentManager Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->release()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMinimized()Z
    move-result v0
    if-nez v0, +01fh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finishInferred()Z
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->release()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->release()V
    iput-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    const-string/jumbo v2, view_model_cleared
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->release(Z Ljava/lang/String;)V
    return-void 
.end method

.method public final onHostResumed()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v0, v1, +007h
    const-string v0, "host_resumed"
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->restartOutputVolumeMonitoring(Ljava/lang/String;)V
    return-void 
.end method

.method public final pickAndUpload(android.net.Uri  java.lang.String  java.lang.String  long  boolean  java.lang.String)void
    .registers 57
    # ins_size=8
    move-object/from16 v0, v49
    move-object/from16 v1, v50
    const-string/jumbo v2, uri
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "mime"
    move-object/from16 v5, v51
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "displayName"
    move-object/from16 v4, v52
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentSubTaskEnabled Z
    if-nez v2, +00ch
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "BrainstormViewModel"
    const-string v3, "pickAndUpload: attachment/subtask disabled, ignore"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    const-wide/16 v2, 1
    cmp-long v2, v2, v53
    const/4 v3, 0
    const/4 v9, 1
    if-gtz v2, +00dh
    const-wide v6, 9223372036854775807
    cmp-long v2, v53, v6
    if-gez v2, +004h
    move v2, v9
    goto +2h
    move v2, v3
    if-eqz v2, +011h
    const-wide/32 v6, 157286400
    cmp-long v2, v53, v6
    if-lez v2, +00ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voicePromptEvents Lkotlinx/coroutines/flow/MutableSharedFlow;
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTooLarge;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTooLarge;
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    return-void 
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +022h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-eq v10, v11, +00ch
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v8
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Cancelled Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-eq v8, v10, +004h
    move v8, v9
    goto +2h
    move v8, v3
    if-eqz v8, -020h
    invoke-interface v6, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -25h
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const-wide/16 v6, 0
    move-wide v10, v6
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +018h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v12
    cmp-long v8, v12, v6
    if-lez v8, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v12
    goto +2h
    move-wide v12, v6
    add-long/2addr v10, v12
    goto -1bh
    cmp-long v2, v53, v6
    if-lez v2, +013h
    add-long v10, v10, v53
    const-wide/32 v2, 209715200
    cmp-long v2, v10, v2
    if-lez v2, +00ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voicePromptEvents Lkotlinx/coroutines/flow/MutableSharedFlow;
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTotalTooLarge;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTotalTooLarge;
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    return-void 
    invoke-virtual/range v49, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getCurrentChatMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v2
    move/from16 v6, v55
    invoke-static v2, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModelKt;->shouldUseVoiceDiscussionImageUpload(Lcom/bytedance/trae/conversation/widget/ChatMode; Z)Z
    move-result v10
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-object v2, v7
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v3
    invoke-virtual v3, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v8
    move-object v3, v8
    const-string/jumbo v11, toString(...)
    invoke-static v8, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v50, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v12
    move-object v8, v12
    invoke-static v12, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v16
    const/16 v19, 3584
    const/16 v20, 0
    move-object/from16 v4, v52
    move-object/from16 v5, v51
    move-object/from16 v21, v7
    move-wide/from16 v6, v53
    move/from16 v9, v55
    move-object/from16 v18, v56
    invoke-direct/range v2 ... v20, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode()Z
    move-result v2
    const/4 v3, 1
    xor-int/2addr v2, v3
    if-eqz v2, +004h
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionHasEverEnabledSubtitle Z
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-object/from16 v22, v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    move-object/from16 v5, v21
    invoke-static v4, v5, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Object;)Ljava/util/List;
    move-result-object v46
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 1
    const/16 v35, 0
    const-wide/16 v36, 0
    const-wide/16 v38, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const v47, 2095103
    const/16 v48, 0
    invoke-static/range v22 ... v48, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +006h
    invoke-direct v0, v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startUpload(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Landroid/net/Uri;)V
    return-void 
    move-object/from16 v21, v5
    goto -54h
.end method

.method public final recordVoiceAttemptSignal(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal  java.lang.String  int)boolean
    .registers 6
    # ins_size=4
    const-string/jumbo v0, signal
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "failureReason"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->refreshVoiceAttemptContext()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, v3, v4, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordSignal(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I)Z
    move-result v3
    const/4 v4, 1
    if-ne v3, v4, +003h
    move v1, v4
    return v1
.end method

.method public final recordVoiceAttemptStage(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage)boolean
    .registers 4
    # ins_size=2
    const-string/jumbo v0, stage
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->refreshVoiceAttemptContext()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    move-result v3
    const/4 v0, 1
    if-ne v3, v0, +003h
    move v1, v0
    return v1
.end method

.method public final removeAttachment(java.lang.String)void
    .registers 34
    # ins_size=2
    move-object/from16 v0, v32
    move-object/from16 v1, v33
    const-string v2, "attachmentId"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentUploadJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v2, v1, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/Job;
    const/4 v3, 1
    if-eqz v2, +006h
    const/4 v4, 0
    invoke-static v2, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v29
    check-cast v29, Ljava/lang/Iterable;
    new-instance v30, Ljava/util/ArrayList;
    invoke-direct/range v30, Ljava/util/ArrayList;-><init>()V
    move-object/from16 v15, v30
    check-cast v15, Ljava/util/Collection;
    invoke-interface/range v29, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v29
    invoke-interface/range v29, Ljava/util/Iterator;->hasNext()Z
    move-result v30
    if-eqz v30, +019h
    invoke-interface/range v29, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    move-object/from16 v30, v14
    check-cast v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    xor-int/2addr v13, v3
    if-eqz v13, -017h
    invoke-interface v15, v14, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    move-object/from16 v29, v15
    check-cast v29, Ljava/util/List;
    const v30, 2097151
    const/16 v31, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    invoke-static/range v5 ... v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v5
    invoke-interface v2, v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -068h
    return-void 
.end method

.method public final reportWindowStateClick(java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=3
    const-string v0, "action"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, windowStateBeforeClick
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v5, v0
    move-object v6, v9
    move-object v7, v10
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportWindowStateClick(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final restore$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.HolderSnapshot)void
    .registers 32
    # ins_size=2
    move-object/from16 v0, v30
    const-string/jumbo v1, snapshot
    move-object/from16 v2, v31
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v26
    const/16 v27, 0
    const v28, 3145727
    const/16 v29, 0
    invoke-static/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getOriginConversationId()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->originConversationId Ljava/lang/String;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getParentConversationId()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->parentConversationIdForVoice Ljava/lang/String;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getAttachmentSubTaskEnabled()Z
    move-result v1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentSubTaskEnabled Z
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getPerfMicCheckStartMs()J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckStartMs J
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getPerfMicCheckEndMs()J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckEndMs J
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getPerfApiRequestStartMs()J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfApiRequestStartMs J
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getPerfJoinRoomStartMs()J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomStartMs J
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getPerfJoinRoomSuccessMs()J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomSuccessMs J
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getPerfBotJoinedMs()J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfBotJoinedMs J
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getPerfIsNewSession()Z
    move-result v1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getDiscussionStartPerfReported()Z
    move-result v1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->discussionStartPerfReported Z
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getSessionUserMessageCount()I
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserMessageCount I
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getSessionBotMessageCount()I
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotMessageCount I
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserSpeakEndTimestamps Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserSpeakEndTimestamps Ljava/util/List;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getSessionUserSpeakEndTimestamps()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, v3, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotSpeakStartTimestamps Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotSpeakStartTimestamps Ljava/util/List;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getSessionBotSpeakStartTimestamps()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, v3, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getSessionHasEverEnabledSubtitle()Z
    move-result v1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionHasEverEnabledSubtitle Z
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceDiscussionAttemptState()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v4
    if-eqz v4, +00fh
    new-instance v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 14
    const/4 v9, 0
    move-object v3, v1
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;-><init>(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +2h
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getPhase()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    if-ne v1, v3, +011h
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getTimeoutState()Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Expired Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-eq v1, v3, +005h
    invoke-direct/range v30, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startSessionTimer()V
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v1, v2, +008h
    const-string/jumbo v1, restore
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->restartOutputVolumeMonitoring(Ljava/lang/String;)V
    return-void 
.end method

.method public final retryAttachment(java.lang.String)void
    .registers 29
    # ins_size=2
    move-object/from16 v7, v27
    move-object/from16 v2, v28
    const-string v0, "attachmentId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v3, 0
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -016h
    goto +2h
    move-object v1, v3
    move-object v8, v1
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-nez v8, +003h
    return-void 
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-eq v0, v1, +003h
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getLocalUri()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    move-object v0, v3
    check-cast v0, Landroid/net/Uri;
    if-nez v0, +003h
    return-void 
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-wide/16 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    sget-object v17, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const/16 v24, 0
    const/16 v25, 14975
    const/16 v26, 0
    invoke-static/range v8 ... v26, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v8
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda3;
    invoke-direct v4, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    const/4 v5, 2
    const/4 v6, 0
    move-object/from16 v1, v27
    move-object/from16 v2, v28
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startUpload(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Landroid/net/Uri;)V
    return-void 
    :try_start_0x44
.end method

.method public final setPerfMicCheckTimestamps(long  long)void
    .registers 5
    # ins_size=5
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckStartMs J
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckEndMs J
    return-void 
.end method

.method public final skipIntroAndStartBrainstorm(boolean)void
    .registers 32
    # ins_size=2
    move-object/from16 v0, v30
    if-eqz v31, +006h
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startBrainstorm()V
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->DISCUSSION_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    const/4 v5, 0
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 4194266
    const/16 v29, 0
    invoke-static/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v1, v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -037h
    return-void 
.end method

.method public final snapshot$conversation_mainlandRelease()com.bytedance.trae.conversation.brainstorm.HolderSnapshot
    .registers 33
    # ins_size=1
    move-object/from16 v0, v32
    new-instance v29, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_cliConversationId Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getParentConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->parentConversationIdForVoice Ljava/lang/String;
    move-object v4, v1
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->originConversationId Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_voiceMode Lcom/bytedance/trae/im/service/Mode;
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachmentSubTaskEnabled Z
    iget-wide v9, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckStartMs J
    iget-wide v11, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfMicCheckEndMs J
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfApiRequestStartMs J
    move-wide v15, v13
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomStartMs J
    move-wide/from16 v17, v13
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfJoinRoomSuccessMs J
    move-wide/from16 v19, v13
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfBotJoinedMs J
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->perfIsNewSession Z
    move-wide/from16 v21, v13
    iget-boolean v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->discussionStartPerfReported Z
    iget v14, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserMessageCount I
    move/from16 v23, v13
    iget v13, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotMessageCount I
    move/from16 v24, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionUserSpeakEndTimestamps Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v25
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionBotSpeakStartTimestamps Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v26
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionHasEverEnabledSubtitle Z
    move/from16 v27, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    move-object/from16 v28, v1
    move-object/from16 v1, v29
    move/from16 v31, v13
    move/from16 v30, v14
    move-wide v13, v15
    move-wide/from16 v15, v17
    move-wide/from16 v17, v19
    move-wide/from16 v19, v21
    move/from16 v21, v24
    move/from16 v22, v23
    move/from16 v23, v30
    move/from16 v24, v31
    invoke-direct/range v1 ... v28, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;)V
    return-object v29
.end method

.method public final startBrainstorm()void
    .registers 33
    # ins_size=1
    move-object/from16 v0, v32
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->DISCUSSION_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v29
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v15
    move-object v2, v15
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v31, v15
    move-object/from16 v15, v16
    const-wide/16 v18, 0
    sget-object v20, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Normal Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    const/16 v21, -1
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const v27, 4071422
    const/16 v28, 0
    move-wide/from16 v16, v29
    invoke-static/range v2 ... v28, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v2
    move-object/from16 v3, v31
    invoke-interface v1, v3, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -03bh
    invoke-direct/range v32, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startSessionTimer()V
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecording()V
    return-void 
.end method

.method public final startRecording()void
    .registers 32
    # ins_size=1
    move-object/from16 v0, v31
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const-string v2, "BrainstormViewModel"
    if-nez v1, +012h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, startRecording ignored: voiceChatSession is null
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isRunning()Z
    move-result v3
    if-eqz v3, +044h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, startRecording ignored: session already running, room=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", task="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", isRtcJoined="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecordingJob Lkotlinx/coroutines/Job;
    const/4 v4, 0
    if-eqz v3, +00ah
    invoke-interface v3, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v3
    const/4 v5, 1
    if-ne v3, v5, +003h
    move v4, v5
    if-eqz v4, +00fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, startRecording ignored: startRecordingJob active
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RECORDING_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Recording Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    const/4 v8, 0
    const/4 v9, 0
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const-string v11, ""
    const-string v12, ""
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 4194075
    const/16 v30, 0
    invoke-static/range v4 ... v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -039h
    move-object v2, v0
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;
    const/4 v6, 0
    invoke-direct v2, v0, v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecordingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final toggleMic()void
    .registers 37
    # ins_size=1
    move-object/from16 v0, v36
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const-string v2, "BrainstormViewModel"
    if-nez v1, +00eh
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, toggleMic ignored: voiceChatSession is null
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, toggleMic: oldMuted=
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", newMuted="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", phase="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getPhase()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", recordingState="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getRecordingState()Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v15, ", isRtcJoined="
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v3
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v6, ", sessionRunning="
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isRunning()Z
    move-result v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v14, ", room="
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v13, ", task="
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v4, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->muteMic()V
    goto +4h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->unmuteMic()V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v12
    move-object v5, v12
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v16, 0
    move-object/from16 v32, v12
    move-object/from16 v12, v16
    move-object/from16 v33, v13
    move-object/from16 v13, v16
    move-object/from16 v34, v14
    move-object/from16 v14, v16
    const/16 v16, 0
    move-object/from16 v35, v15
    move/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const v30, 4193279
    const/16 v31, 0
    move/from16 v16, v4
    invoke-static/range v5 ... v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v5
    move-object/from16 v6, v32
    invoke-interface v3, v6, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +056h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, toggleMic applied: isMicMuted=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v5, v35
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v6, v34
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v7, v33
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object/from16 v13, v33
    move-object/from16 v14, v34
    move-object/from16 v15, v35
    goto/16 -0a4h
.end method

.method public final toggleSpeaker()void
    .registers 33
    # ins_size=1
    move-object/from16 v0, v32
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v3, 1
    if-ne v1, v2, +004h
    move v1, v3
    goto +2h
    const/4 v1, 0
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSpeakerOn()Z
    move-result v6
    xor-int/lit8 v15, v6, 1
    if-eqz v15, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Speaker Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    goto +3h
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Earpiece Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-object v14, v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    invoke-virtual v6, v14, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->switchToDevice(Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;)V
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const v30, 4193535
    const/16 v31, 0
    invoke-static/range v5 ... v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v5
    invoke-interface v2, v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -047h
    if-eqz v1, +008h
    const-string/jumbo v1, route_changed
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->restartOutputVolumeMonitoring(Ljava/lang/String;)V
    return-void 
.end method

.method public final toggleSubtitleMode()void
    .registers 31
    # ins_size=1
    move-object/from16 v0, v30
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode()Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    if-eqz v1, +004h
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->sessionHasEverEnabledSubtitle Z
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v15
    move-object v3, v15
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 4192255
    const/16 v29, 0
    move-object v0, v15
    move v15, v1
    invoke-static/range v3 ... v29, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v2, v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +4h
    move-object/from16 v0, v30
    goto -3ah
    return-void 
    :try_start_0x2
.end method

.method public final updateAttachment(java.lang.String  boolean  kotlin.jvm.functions.Function1)void
    .registers 36
    # ins_size=4
    move-object/from16 v0, v33
    move-object/from16 v1, v35
    const-string v2, "attachmentId"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, updater
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v2, v32
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    const/4 v8, 0
    move-object v9, v8
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +023h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +bh
    invoke-interface v1, v10, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-eqz v34, +004h
    move-object v9, v10
    move-object v10, v8
    if-eqz v10, -021h
    invoke-interface v7, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -26h
    check-cast v7, Ljava/util/List;
    if-eqz v9, +00fh
    move-object v6, v7
    check-cast v6, Ljava/util/Collection;
    invoke-static v6, v9, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    if-nez v6, +003h
    goto +4h
    move-object/from16 v29, v6
    goto +3h
    move-object/from16 v29, v7
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v30, 2097151
    const/16 v31, 0
    invoke-static/range v5 ... v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v5
    invoke-interface v3, v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -081h
    return-void 
.end method
