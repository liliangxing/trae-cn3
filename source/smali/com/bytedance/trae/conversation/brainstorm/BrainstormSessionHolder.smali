# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
.super Ljava/lang/Object;
.source "BrainstormSessionHolder.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
.field private static final TAG:Ljava/lang/String;
.field private static final TIMER_TICK_MS:J
.field private static final _elapsedMs:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static final _ended:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private static final _localAudioVolume:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private static final _state:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static final _subtitleHistorySize:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static bridge audioDeviceManager:Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
.field private static bridge currentSnapshot:Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
.field private static final elapsedMs:Lkotlinx/coroutines/flow/StateFlow;
.field private static final ended:Lkotlinx/coroutines/flow/SharedFlow;
.field private static final holderScope:Lkotlinx/coroutines/CoroutineScope;
.field private static final internalListener:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;
.field private static final localAudioVolume:Lkotlinx/coroutines/flow/SharedFlow;
.field private static bridge ownerConversationId:Ljava/lang/String;
.field private static final pendingTerminals:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final state:Lkotlinx/coroutines/flow/StateFlow;
.field private static subTaskTerminalJob:Lkotlinx/coroutines/Job;
.field private static final subtitleHistorySize:Lkotlinx/coroutines/flow/StateFlow;
.field private static timerJob:Lkotlinx/coroutines/Job;
.field private static bridge voiceChatSession:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
.field private static final voiceDiscussionAttemptLock:Ljava/lang/Object;


.method public static synthetic $r8$lambda$opFNFiJ-J0T7DX-BjtmZIafkJco(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->endSession$lambda$4(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->IDLE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->state Lkotlinx/coroutines/flow/StateFlow;
    const-wide/16 v0, 0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_elapsedMs Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->elapsedMs Lkotlinx/coroutines/flow/StateFlow;
    const/4 v0, 0
    const/4 v1, 1
    const/4 v2, 0
    const/4 v3, 4
    invoke-static v0, v1, v2, v3, v2, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    sput-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_localAudioVolume Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    sput-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->localAudioVolume Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-static v4, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    sput-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_subtitleHistorySize Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    sput-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->subtitleHistorySize Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v0, v1, v2, v3, v2, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_ended Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->ended Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v2, v1, v2, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    invoke-virtual v1, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->holderScope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceDiscussionAttemptLock Ljava/lang/Object;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->pendingTerminals Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->internalListener Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$buildBrainstormMessage(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->buildBrainstormMessage(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getCurrentSnapshot$p()com.bytedance.trae.conversation.brainstorm.HolderSnapshot
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    return-object v0
.end method

.method public static final synthetic access$get_elapsedMs$p()kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_elapsedMs Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_localAudioVolume$p()kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_localAudioVolume Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_subtitleHistorySize$p()kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_subtitleHistorySize Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$logUnrecognizedRtcFrame(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder  java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->logUnrecognizedRtcFrame(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$reportServerToolEnd(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder  com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->reportServerToolEnd(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
.end method

.method public static final synthetic access$setCurrentSnapshot$p(com.bytedance.trae.conversation.brainstorm.HolderSnapshot)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    return-void 
.end method

.method public static final synthetic access$stampTerminalOnSnapshot(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->stampTerminalOnSnapshot(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    return-void 
.end method

.method public static final synthetic access$withVoiceDiscussionAttempt(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder  kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->withVoiceDiscussionAttempt(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final buildBrainstormMessage(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage
    .registers 16
    # ins_size=3
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    if-ne v15, v0, +024h
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, subtitle_user_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 496
    const/4 v12, 0
    move-object v0, v15
    move-object v3, v14
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v15
    invoke-static v14, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->parseAttachedSubTaskId(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead()Z
    move-result v0
    if-eqz v0, +003h
    goto +5h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getCleanedText()Ljava/lang/String;
    move-result-object v14
    move-object v3, v14
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v14
    if-eqz v14, +004h
    const/4 v14, 1
    goto +2h
    const/4 v14, 0
    const/4 v0, 0
    if-nez v14, +008h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    goto +2h
    move-object v6, v0
    if-eqz v6, +00bh
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->pendingTerminals Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v6, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    goto +2h
    move-object v1, v0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +094h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "buildBrainstormMessage[subtask]: taskId="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", role="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    if-eqz v14, +006h
    const-string/jumbo v8, result
    goto +3h
    const-string v8, "comfort"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", status="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", attachedId="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", pendingTerminal="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v8
    goto +2h
    move-object v8, v0
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", snapshotHistorySize="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    sget-object v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    if-eqz v8, +013h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v8
    if-eqz v8, +00dh
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v8
    if-eqz v8, +007h
    invoke-interface v8, Ljava/util/List;->size()I
    move-result v8
    goto +2h
    const/4 v8, -1
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", contentLen="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", incomplete="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead()Z
    move-result v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v8, "BrainstormHolder"
    invoke-virtual v2, v8, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v7, subtitle_bot_
    invoke-direct v2, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->Assistant Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    if-eqz v14, +007h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceTaskId()Ljava/lang/String;
    move-result-object v14
    goto +2h
    move-object v14, v0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getSourceStatus()Ljava/lang/String;
    move-result-object v8
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v15
    move-object v9, v15
    goto +2h
    move-object v9, v0
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v15
    move-object v10, v15
    goto +2h
    move-object v10, v0
    move-object v0, v11
    move-object v1, v2
    move-object v2, v7
    move-object v7, v14
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String;)V
    return-object v11
.end method

.method private static final endSession$lambda$4(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string/jumbo v0, tracker
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finishInferred()Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final formatDuration(long)java.lang.String
    .registers 13
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v11, v0
    const/16 v0, 3600
    int-to-long v0, v0
    div-long v2, v11, v0
    rem-long v0, v11, v0
    const/16 v4, 60
    int-to-long v4, v4
    div-long/2addr v0, v4
    rem-long/2addr v11, v4
    const-wide/16 v4, 0
    cmp-long v4, v2, v4
    const-string v5, "format(...)"
    const/4 v6, 1
    const/4 v7, 0
    const/4 v8, 2
    if-lez v4, +027h
    sget-object v4, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    const/4 v4, 3
    new-array v9, v4, [Ljava/lang/Object;
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    aput-object v2, v9, v7
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    aput-object v0, v9, v6
    invoke-static v11, v12, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v9, v8
    invoke-static v9, v4, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v12, "%02d:%02d:%02d"
    invoke-static v12, v11, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +1eh
    sget-object v2, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    new-array v2, v8, [Ljava/lang/Object;
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    aput-object v0, v2, v7
    invoke-static v11, v12, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v2, v6
    invoke-static v2, v8, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v12, "%02d:%02d"
    invoke-static v12, v11, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v11
.end method

.method private final logUnrecognizedRtcFrame(java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=4
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    return-void 
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    const/16 v2, 200
    if-le v0, v2, +02eh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, v1, v2, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, substring(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string/jumbo v1, …(len=
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v0, 41
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "internalListener.onRtcTextMessage: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v1, " frame from uid="
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", preview="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "BrainstormHolder"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->v(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method static synthetic logUnrecognizedRtcFrame$default(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +005h
    const-string/jumbo v3, unrecognized
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->logUnrecognizedRtcFrame(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final reportServerToolEnd(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)void
    .registers 11
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    if-nez v2, +004h
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v3
    if-nez v3, +004h
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    const/4 v4, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v4
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    move-object v5, v4
    const/4 v6, 0
    const/4 v7, 0
    move-object v4, v0
    move-object v8, v10
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportServerToolEnd(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Long; Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
.end method

.method private final stampTerminalOnSnapshot(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 65
    # ins_size=2
    invoke-virtual/range v64, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->pendingTerminals Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/Map;
    move-object/from16 v2, v64
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    const/4 v1, 0
    if-eqz v3, +0d7h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v4
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v33
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
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
    move/from16 v34, v1
    move/from16 v35, v34
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +039h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getAttachedSubTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +024h
    add-int/lit8 v34, v34, 1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getSubTaskTerminalState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v6
    if-nez v6, +01ch
    add-int/lit8 v35, v35, 1
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    invoke-virtual/range v64, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v16
    invoke-virtual/range v64, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v17
    const/16 v18, 127
    const/16 v19, 0
    invoke-static/range v7 ... v19, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    move-result-object v7
    invoke-interface v5, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ch
    move-object/from16 v38, v5
    check-cast v38, Ljava/util/List;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v36
    const/16 v37, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const-wide/16 v50, 0
    const-wide/16 v52, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, 0
    const/16 v60, 0
    const v61, 4194301
    const/16 v62, 0
    invoke-static/range v36 ... v62, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const-wide/16 v13, 0
    const-wide/16 v15, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const v31, 2097150
    const/16 v32, 0
    invoke-static/range v3 ... v32, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v3
    move/from16 v4, v33
    move/from16 v5, v34
    move/from16 v6, v35
    goto +8h
    const/16 v33, -1
    const/4 v3, 0
    move v5, v1
    move v6, v5
    move/from16 v4, v33
    sput-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v8, stampTerminalOnSnapshot: sourceTaskId=
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v7, ", state="
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v64, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", matchedAnchors="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", newlyStamped="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", historySize="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", snapshotReady="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    if-eqz v2, +003h
    const/4 v1, 1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "BrainstormHolder"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final startSubTaskTerminalCollect()void
    .registers 11
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->subTaskTerminalJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "BrainstormHolder"
    const-string/jumbo v3, startSubTaskTerminalCollect
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->holderScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v7, v0
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->subTaskTerminalJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startTimer(long)void
    .registers 9
    # ins_size=3
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->stopTimer()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->holderScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;
    const/4 v4, 0
    invoke-direct v3, v7, v8, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;-><init>(J Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v7
    sput-object v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->timerJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final stopSubTaskTerminalCollect()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHolder"
    const-string/jumbo v2, stopSubTaskTerminalCollect
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->subTaskTerminalJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->subTaskTerminalJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final stopTimer()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->timerJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->timerJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final withVoiceDiscussionAttempt(kotlin.jvm.functions.Function1)void
    .registers 43
    # ins_size=2
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceDiscussionAttemptLock Ljava/lang/Object;
    monitor-enter v1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    if-nez v0, +004h
    monitor-exit v1
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceDiscussionAttemptState()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v9
    if-nez v9, +004h
    monitor-exit v1
    return-void 
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getTerminalReported()Z
    move-result v2
    if-eqz v2, +004h
    monitor-exit v1
    return-void 
    new-instance v10, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 14
    const/4 v8, 0
    move-object v2, v10
    move-object v3, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;-><init>(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getContext()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    move-result-object v11
    const/4 v12, 0
    const/4 v13, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    move-object v14, v0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v2, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    if-nez v0, +004h
    const-string v0, ""
    move-object v15, v0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 51
    const/16 v19, 0
    invoke-static/range v11 ... v19, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->copy$default(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    move-result-object v0
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->updateContext(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;)V
    move-object/from16 v0, v42
    invoke-interface v0, v10, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    if-eqz v11, +033h
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const-wide/16 v23, 0
    const-wide/16 v25, 0
    const-wide/16 v27, 0
    const-wide/16 v29, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v38
    const v39, 1048575
    const/16 v40, 0
    invoke-static/range v11 ... v40, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v1
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x3
    :try_start_0x9
    :try_start_0x11
    :try_start_0x19
.end method

.method public final endSession$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.EndReason  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v1, v17
    move-object/from16 v3, v18
    move-object/from16 v0, v19
    instance-of v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;
    iget v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->label I
    sub-int/2addr v0, v5
    iput v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lkotlin/coroutines/Continuation;)V
    move-object v9, v2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v10
    iget v2, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->label I
    const-string v11, "BrainstormHolder"
    const/4 v12, 0
    const/4 v13, 1
    if-eqz v2, +019h
    if-ne v2, v13, +00fh
    iget v2, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->I$1 I
    iget v3, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->I$0 I
    iget-object v4, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +112h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->IDLE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    if-eq v2, v4, +125h
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->TERMINATED Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    if-ne v2, v4, +004h
    goto/16 +11bh
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ENDING Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    const-wide/16 v4, 0
    if-eqz v2, +013h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionStartTimeMs()J
    move-result-wide v14
    sub-long/2addr v6, v14
    invoke-static v6, v7, v4, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    invoke-direct v1, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->formatDuration(J)Ljava/lang/String;
    move-result-object v0
    if-eqz v2, +010h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v6
    if-eqz v6, +00ah
    invoke-static v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummaryEligibilityKt;->hasSummaryWorthyInput(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v6
    if-ne v6, v13, +004h
    move v14, v13
    goto +2h
    move v14, v12
    if-eqz v14, +013h
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_summary_query I
    new-array v8, v13, [Ljava/lang/Object;
    aput-object v0, v8, v12
    invoke-virtual v6, v7, v8, Landroid/app/Application;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    goto +3h
    const-string v0, ""
    move-object v6, v0
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->release()V
    goto +9h
    move-exception v0
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "endSession: session.release failed"
    invoke-virtual v7, v11, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->release()V
    goto +9h
    move-exception v0
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "endSession: audio.release failed"
    invoke-virtual v7, v11, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/EndReason;->UserAbortInActivity Lcom/bytedance/trae/conversation/brainstorm/EndReason;
    if-eq v3, v0, +009h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/EndReason;->UserAbortInConversation Lcom/bytedance/trae/conversation/brainstorm/EndReason;
    if-ne v3, v0, +003h
    goto +3h
    move v0, v12
    goto +2h
    move v0, v13
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$$ExternalSyntheticLambda0;
    invoke-direct v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$$ExternalSyntheticLambda0;-><init>()V
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->withVoiceDiscussionAttempt(Lkotlin/jvm/functions/Function1;)V
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v15, "endSession: reason="
    invoke-direct v8, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v15, ", isAbort="
    invoke-virtual v8, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v15, ", durationMs="
    invoke-virtual v8, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v11, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v15, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_ended Lkotlinx/coroutines/flow/MutableSharedFlow;
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;
    const/4 v4, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getCliConversationId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v4
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getParentConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v7
    invoke-interface v7, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    if-nez v7, +00bh
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getParentConversationId()Ljava/lang/String;
    move-result-object v2
    move-object v7, v2
    goto +2h
    move-object v7, v4
    if-nez v0, +007h
    if-nez v14, +005h
    move/from16 v16, v13
    goto +3h
    move/from16 v16, v12
    move-object v2, v8
    move-object/from16 v3, v18
    move-object v4, v5
    move-object v5, v7
    move v7, v0
    move-object v12, v8
    move/from16 v8, v16
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;-><init>(Lcom/bytedance/trae/conversation/brainstorm/EndReason; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z)V
    iput-object v1, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->L$0 Ljava/lang/Object;
    iput v14, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->I$0 I
    iput v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->I$1 I
    iput v13, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$endSession$1;->label I
    invoke-interface v15, v12, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v10, +003h
    return-object v10
    move v2, v0
    move-object v4, v1
    move v3, v14
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    if-nez v2, +007h
    if-nez v3, +003h
    goto +3h
    const/4 v12, 0
    goto +2h
    move v12, v13
    if-eqz v2, +005h
    const-string v2, "holder_brainstorm_abort"
    goto +8h
    if-nez v3, +005h
    const-string v2, "holder_brainstorm_empty_end"
    goto +3h
    const-string v2, "holder_brainstorm_normal_end"
    invoke-virtual v0, v12, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->release(Z Ljava/lang/String;)V
    goto +9h
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "endSession: coordinator.release failed"
    invoke-virtual v2, v11, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->reset()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "endSession noop, state="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v11, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0xa6
    :try_start_0xb6
    :try_start_0x14d
.end method

.method public final getAudioDeviceManager$conversation_mainlandRelease()com.bytedance.trae.conversation.brainstorm.audio.AudioDeviceManager
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    return-object v0
.end method

.method public final getCliConversationId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getElapsedMs()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->elapsedMs Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getEnded()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->ended Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getLocalAudioVolume()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->localAudioVolume Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getOwnerConversationId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->ownerConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->state Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getSubtitleHistorySize()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->subtitleHistorySize Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getVoiceChatSession$conversation_mainlandRelease()com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    return-object v0
.end method

.method public final isActive()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_FG Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    if-eq v1, v2, +00dh
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_MIN Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    if-ne v0, v1, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    return v0
.end method

.method public final isMicMuted()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final isMinimized()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_MIN Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    if-ne v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final markActiveForeground()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_FG Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final migrateFromViewModel$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String)boolean
    .registers 9
    # ins_size=3
    const-string/jumbo v0, vm
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->detachVoiceSession$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v0
    const/4 v1, 0
    const-string v2, "BrainstormHolder"
    if-nez v0, +00dh
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "migrateFromViewModel: vm.session is null, refuse minimize"
    invoke-virtual v7, v2, v8, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->detachAudioDeviceManager$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    move-result-object v3
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->snapshot$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v7
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sput-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    sput-object v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    sput-object v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->ownerConversationId Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_subtitleHistorySize Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v4
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_elapsedMs Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionElapsedMs()J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    invoke-interface v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->internalListener Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->setListener(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionStartTimeMs()J
    move-result-wide v3
    invoke-direct v6, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->startTimer(J)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->startSubTaskTerminalCollect()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_MIN Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v0
    if-eqz v0, +008h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->stopAudioCapture()V
    goto +13h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    check-cast v3, Landroid/content/Context;
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->startAudioCapture()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v3
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "migrated to holder; ownerConvId="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v1, ", cliId="
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getCliConversationId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v7, 1
    return v7
.end method

.method public final reportWindowStateClick(java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=3
    const-string v0, "action"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, windowStateBeforeClick
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    if-nez v2, +004h
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v3
    if-nez v3, +004h
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    const/4 v4, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v4
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    move-object v5, v4
    move-object v4, v0
    move-object v6, v9
    move-object v7, v10
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportWindowStateClick(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final reset()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->stopTimer()V
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->stopSubTaskTerminalCollect()V
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->ownerConversationId Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->pendingTerminals Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_elapsedMs Lkotlinx/coroutines/flow/MutableStateFlow;
    const-wide/16 v1, 0
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_subtitleHistorySize Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->IDLE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->stop(Landroid/content/Context;)V
    return-void 
.end method

.method public final restoreToViewModel$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)boolean
    .registers 7
    # ins_size=2
    const-string/jumbo v0, vm
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v1, 0
    const-string v2, "BrainstormHolder"
    if-nez v0, +00eh
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, restoreToViewModel: holder.session is null
    invoke-virtual v6, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v1
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    if-nez v4, +00eh
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, restoreToViewModel: snapshot is null
    invoke-virtual v6, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v1
    invoke-direct v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->stopTimer()V
    invoke-direct v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->stopSubTaskTerminalCollect()V
    invoke-virtual v6, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->restore$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;)V
    if-eqz v3, +005h
    invoke-virtual v6, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachAudioDeviceManager$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;)V
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->attachVoiceSession$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)V
    const/4 v6, 0
    sput-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sput-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    sput-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->currentSnapshot Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    sput-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->ownerConversationId Ljava/lang/String;
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->pendingTerminals Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v6, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_FG Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-interface v6, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v1
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, restored to vm
    invoke-virtual v6, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v6, 1
    return v6
.end method

.method public final setAudioDeviceManager$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.audio.AudioDeviceManager)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->audioDeviceManager Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
    return-void 
.end method

.method public final setVoiceChatSession$conversation_mainlandRelease(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->voiceChatSession Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    return-void 
.end method
