# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
.super Ljava/lang/Object;
.source "VoiceSubTaskCoordinator.kt"

.field private static final CANCEL_REMOTE_TERMINAL_WAIT_MS:J
.field private static final CHAT_SESSION_ID_KEYS:[Ljava/lang/String;
.field private static final COMPLETED_STATUSES:Ljava/util/Set;
.field private static final CREATE_TASK_LEGACY_SUCCESS_BIZ_CODE:J
.field private static final CREATE_TASK_MAX_RETRIES:I
.field private static final CREATE_TASK_RETRYABLE_BIZ_CODE:J
.field private static final CREATE_TASK_RETRY_BASE_DELAY_MS:J
.field private static final CREATE_TASK_RETRY_DELAY_CAP_MS:J
.field private static final CREATE_TASK_RETRY_MAX_DELAY_MS:J
.field private static final DROP_REASON_BUSY:Ljava/lang/String;
.field private static final ERROR_CODE_DEVICE_OFFLINE_NUMERIC:Ljava/lang/String;
.field private static final FINISH_TOOLS:Ljava/util/Set;
.field private static final HIDDEN_STATUS_VOICE_DISCUSSION:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
.field private static final IN_FLIGHT_STATES:Ljava/util/Set;
.field private static final ORIGIN:Ljava/lang/String;
.field private static final REMOTE_RESOURCE_PREFIX:Ljava/lang/String;
.field private static final RESULT_REPORT_CACHE_LIMIT:I
.field private static final STATUS_COMPLETED:Ljava/lang/String;
.field private static final STATUS_IN_PROGRESS:Ljava/lang/String;
.field public static final SUB_TASK_AGENT_TYPE:Ljava/lang/String;
.field private static final SUB_TASK_FAILURE_REASON_INTERRUPTED:Ljava/lang/String;
.field private static final SUPERSEDED_RESULT_NOTE:Ljava/lang/String;
.field private static final SUPERSEDE_REASON_CANCEL_PREVIOUS_FAILED:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final TOOL_NAME_TASK_CREATE:Ljava/lang/String;
.field private static final TRAE_RES_PREFIX:Ljava/lang/String;
.field private static final _activeTask:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static final _parallelTerminalToolResults:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private static final _parentChatSessionId:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static final _parentConversationId:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static final _proxyChatSessionId:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static final _proxyConversationId:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static final activeTask:Lkotlinx/coroutines/flow/StateFlow;
.field private static final cancelWaiterLock:Ljava/lang/Object;
.field private static final cancelWaiterSourceToLocal:Ljava/util/Map;
.field private static final cancelWaiters:Ljava/util/Map;
.field private static bridge cancelingClientProxyTaskId:Ljava/lang/String;
.field private static final cliStatusListener:Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
.field private static bridge config:Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
.field private static final coroutineScope:Lkotlinx/coroutines/CoroutineScope;
.field private static final createTaskBizErrorSuppressLock:Ljava/lang/Object;
.field private static final createTaskBizErrorSuppressedTaskIds:Ljava/util/LinkedHashSet;
.field private static bridge deviceOnline:Z
.field private static bridge latestRoomIdForMetrics:Ljava/lang/String;
.field private static bridge longRunningJob:Lkotlinx/coroutines/Job;
.field private static final parallelTerminalToolResults:Lkotlinx/coroutines/flow/SharedFlow;
.field private static final parentChatSessionId:Lkotlinx/coroutines/flow/StateFlow;
.field private static final parentConversationId:Lkotlinx/coroutines/flow/StateFlow;
.field private static bridge parentCreateJob:Lkotlinx/coroutines/Job;
.field private static bridge pendingClientProxyExecutor:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
.field private static bridge pendingClientProxyRequest:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
.field private static bridge pendingClientProxyStartJob:Lkotlinx/coroutines/Job;
.field private static final proxyChatSessionId:Lkotlinx/coroutines/flow/StateFlow;
.field private static final proxyConversationId:Lkotlinx/coroutines/flow/StateFlow;
.field private static final resultAliasLock:Ljava/lang/Object;
.field private static final resultTaskIdAlias:Ljava/util/Map;
.field private static bridge sendAckToBot:Lkotlin/jvm/functions/Function1;
.field private static bridge started:Z
.field private static final streamingListener:Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
.field private static bridge subTaskConfig:Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
.field private static final subTaskMetricEndedTaskIds:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final subTaskMetricFileCounts:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final subTaskMetricStartedAtMs:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final subTaskResultReportLock:Ljava/lang/Object;
.field private static final subTaskResultReportedTaskIds:Ljava/util/LinkedHashSet;
.field private static bridge taskCreateJob:Lkotlinx/coroutines/Job;
.field private static bridge timeoutJob:Lkotlinx/coroutines/Job;


.method public static synthetic $r8$lambda$3-0BN8KUER40ik4LCIbXxuNWjiI(com.bytedance.trae.im.service.IMService$CliStatusChangePayload)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cliStatusListener$lambda$0(Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7_Lfv36wmb9BACBmmv9gaxRBhCc(com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->extractContent$lambda$73(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$BY1VpKNVeeej_kWanRkIhGZj76M(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->extractContent$lambda$76(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VfNJazM-48k01JL8YFdSewkz-Hc(com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->streamingListener$lambda$1(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jVAY_kkeOrCyG9oLWE6XwRq4VIM(java.lang.String  java.util.Map$Entry)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->removeCancelWaiterInternal$lambda$16(Ljava/lang/String; Ljava/util/Map$Entry;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 15
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v2
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v2, v3, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->proxyConversationId Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->proxyChatSessionId Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentConversationId Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentChatSessionId Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->activeTask Lkotlinx/coroutines/flow/StateFlow;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricStartedAtMs Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricFileCounts Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricEndedTaskIds Ljava/util/concurrent/ConcurrentHashMap;
    const/16 v0, 16
    sget-object v2, Lkotlinx/coroutines/channels/BufferOverflow;->DROP_OLDEST Lkotlinx/coroutines/channels/BufferOverflow;
    const/4 v3, 0
    invoke-static v3, v0, v2, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow(I I Lkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parallelTerminalToolResults Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parallelTerminalToolResults Lkotlinx/coroutines/flow/SharedFlow;
    sput-boolean v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->deviceOnline Z
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cliStatusListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterLock Ljava/lang/Object;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiters Ljava/util/Map;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterSourceToLocal Ljava/util/Map;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportLock Ljava/lang/Object;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportedTaskIds Ljava/util/LinkedHashSet;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressLock Ljava/lang/Object;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressedTaskIds Ljava/util/LinkedHashSet;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultAliasLock Ljava/lang/Object;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultTaskIdAlias Ljava/util/Map;
    const-string v4, "chat_session_id"
    const-string v5, "chatSessionId"
    const-string v6, "cli_conversation_id"
    const-string v7, "cliConversationId"
    const-string v8, "parent_chat_session_id"
    const-string v9, "parentChatSessionId"
    const-string/jumbo v10, voice_conversation_id
    const-string/jumbo v11, voiceConversationId
    const-string/jumbo v12, session_id
    const-string/jumbo v13, sessionId
    const-string/jumbo v14, session
    filled-new-array/range v4 ... v14, [Ljava/lang/String;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->CHAT_SESSION_ID_KEYS [Ljava/lang/String;
    const-string v0, "failed"
    const-string v2, "canceled"
    const-string v4, "completed"
    filled-new-array v4, v0, v2, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->COMPLETED_STATUSES Ljava/util/Set;
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Creating Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    aput-object v2, v0, v3
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Thinking Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Streaming Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    aput-object v2, v0, v1
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    const-string v1, "finish"
    const-string v2, "Finish"
    const-string v3, "agent_finish"
    const-string v4, "AgentFinish"
    const-string/jumbo v5, response_to_user
    const-string v6, "ResponseToUser"
    const-string v7, "Task"
    filled-new-array/range v1 ... v7, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->FINISH_TOOLS Ljava/util/Set;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->streamingListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$awaitCancelRemoteTerminal(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  kotlinx.coroutines.CompletableDeferred  java.lang.String  java.lang.String  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->awaitCancelRemoteTerminal(Lkotlinx/coroutines/CompletableDeferred; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$cancelClientProxyTaskForReuse(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelClientProxyTaskForReuse(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$cancelPreviousTaskForSwitch(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  kotlinx.coroutines.Job  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelPreviousTaskForSwitch(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lkotlinx/coroutines/Job; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$cancelRemoteClientProxyTask(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelRemoteClientProxyTask(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$clearSubTaskResultReportStarted(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearSubTaskResultReportStarted(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$createRemoteParentSession(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createRemoteParentSession(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$createSubTask(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createSubTask(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$createTaskWithRetry(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.im.service.CreateTaskRequest  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskWithRetry(Lcom/bytedance/trae/im/service/CreateTaskRequest; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$failPendingClientProxyTask(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failPendingClientProxyTask(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$getCancelingClientProxyTaskId$p()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getIN_FLIGHT_STATES$p()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getPendingClientProxyExecutor$p()com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    return-object v0
.end method

.method public static final synthetic access$getPendingClientProxyRequest$p()com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    return-object v0
.end method

.method public static final synthetic access$getPendingClientProxyStartJob$p()kotlinx.coroutines.Job
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method public static final synthetic access$getStarted$p()boolean
    .registers 1
    # ins_size=0
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    return v0
.end method

.method public static final synthetic access$get_activeTask$p()kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$markCreateTaskRetryableBizErrorSuppressed(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->markCreateTaskRetryableBizErrorSuppressed(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$resolveParentConversationIdForSubTask(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveParentConversationIdForSubTask(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setCancelingClientProxyTaskId$p(java.lang.String)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setPendingClientProxyExecutor$p(com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    return-void 
.end method

.method public static final synthetic access$setPendingClientProxyRequest$p(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    return-void 
.end method

.method public static final synthetic access$setPendingClientProxyStartJob$p(kotlinx.coroutines.Job)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$startClientProxyTask(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startClientProxyTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    return-void 
.end method

.method public static final synthetic access$startServerClosedLoopTask(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startServerClosedLoopTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    return-void 
.end method

.method private final awaitCancelRemoteTerminal(kotlinx.coroutines.CompletableDeferred  java.lang.String  java.lang.String  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=7
    move-object/from16 v1, v20
    move-object/from16 v2, v22
    move-object/from16 v3, v23
    move-wide/from16 v4, v24
    move-object/from16 v0, v26
    instance-of v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;
    if-eqz v6, +012h
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;
    iget v7, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->label I
    const/high16 v8, -2147483648
    and-int/2addr v7, v8
    if-eqz v7, +008h
    iget v0, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->label I
    sub-int/2addr v0, v8
    iput v0, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->label I
    goto +6h
    new-instance v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;
    invoke-direct v6, v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v7
    iget v8, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->label I
    const/4 v9, 0
    const-string v10, ", waitMs="
    const-string v11, ", localTaskId="
    const-string v12, "VoiceSubTaskCoord"
    const/4 v13, 1
    if-eqz v8, +030h
    if-ne v8, v13, +026h
    iget-wide v2, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->J$1 J
    iget-wide v4, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->J$0 J
    iget-object v7, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->L$2 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v14, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->L$0 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide/from16 v18, v2
    move-object v3, v7
    move-object v2, v8
    move-object v7, v14
    move-wide/from16 v14, v18
    goto +5ah
    move-exception v0
    move-wide/from16 v18, v2
    move-object v3, v7
    move-object v2, v8
    move-object v7, v14
    move-wide/from16 v14, v18
    goto +59h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v14, "cancelForReuse[await-terminal]: sourceTaskId="
    invoke-direct v8, v14, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v12, v8, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v14
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$terminal$1;
    move-object/from16 v8, v21
    invoke-direct v0, v8, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$terminal$1;-><init>(Lkotlinx/coroutines/CompletableDeferred; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->L$0 Ljava/lang/Object;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->L$1 Ljava/lang/Object;
    iput-object v3, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->L$2 Ljava/lang/Object;
    iput-wide v4, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->J$0 J
    iput-wide v14, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->J$1 J
    iput v13, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->label I
    invoke-static v4, v5, v0, v6, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v7, +003h
    return-object v7
    move-object v7, v1
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    move-object v9, v0
    goto +20h
    move-exception v0
    goto +3h
    move-exception v0
    move-object v7, v1
    invoke-interface v6, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v6
    sget-object v8, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v8, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v6, v8, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v6
    check-cast v6, Lkotlinx/coroutines/Job;
    const/4 v8, 0
    if-eqz v6, +009h
    invoke-interface v6, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v6
    if-ne v6, v13, +003h
    goto +2h
    move v13, v8
    if-eqz v13, +081h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v16
    sub-long v13, v16, v14
    const-string v0, ", elapsedMs="
    if-eqz v9, +03dh
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "cancelForReuse[await-terminal-done]: sourceTaskId="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", outcome="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v9, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v12, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    goto +3ah
    invoke-direct v7, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearCancelWaiter(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "cancelForReuse[await-terminal-timeout]: sourceTaskId="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", proceed with create-retry fallback"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v12, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    return-object v0
    throw v0
    :try_start_0x47
    :try_start_0x8e
    :try_start_0xab
.end method

.method public static synthetic buildCreateTaskFailureReport$conversation_mainlandRelease$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.im.service.CreateTaskRawResult  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$CreateTaskFailureReport
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildCreateTaskFailureReport$conversation_mainlandRelease(Lcom/bytedance/trae/im/service/CreateTaskRawResult; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    move-result-object v0
    return-object v0
.end method

.method private final buildCreateTaskMissingFieldError(java.lang.String  long  java.lang.String)java.lang.String
    .registers 7
    # ins_size=5
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, tasks/create response missing 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v3, "; biz_code="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v6, +00ch
    const-string/jumbo v5, success
    invoke-static v6, v5, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v5
    if-nez v5, +003h
    goto +2h
    move-object v6, v4
    move-object v4, v6
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00ah
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +00ah
    const-string v3, "; message="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public static synthetic buildNotifyAttachmentParts$conversation_mainlandRelease$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.util.List  java.lang.String  int  java.lang.Object)java.util.List
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildNotifyAttachmentParts$conversation_mainlandRelease(Ljava/util/List; Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic buildNotifyAttachmentQueryJson$conversation_mainlandRelease$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.util.List  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildNotifyAttachmentQueryJson$conversation_mainlandRelease(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic buildSseFailureReport$conversation_mainlandRelease$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String  kotlin.jvm.functions.Function4  int  java.lang.Object)com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$CreateTaskFailureReport
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildSseFailureReport$conversation_mainlandRelease(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Lkotlin/jvm/functions/Function4;)Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic cancelActiveTask$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelActiveTask(Ljava/lang/String; Z)V
    return-void 
.end method

.method private final cancelClientProxyTaskForReuse(java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=8
    move-object/from16 v0, v19
    move-object/from16 v1, v21
    move-object/from16 v2, v22
    move-object/from16 v3, v23
    move-object/from16 v4, v26
    instance-of v5, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;
    if-eqz v5, +012h
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;
    iget v6, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->label I
    const/high16 v7, -2147483648
    and-int/2addr v6, v7
    if-eqz v6, +008h
    iget v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->label I
    sub-int/2addr v4, v7
    iput v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->label I
    goto +6h
    new-instance v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;
    invoke-direct v5, v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    iget v7, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->label I
    const/4 v8, 2
    const-string v9, ", reason="
    const-string v10, ", localTaskId="
    const-string v11, "VoiceSubTaskCoord"
    const/4 v12, 1
    const/4 v13, 0
    if-eqz v7, +02dh
    if-eq v7, v12, +011h
    if-ne v7, v8, +007h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0eeh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-wide v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->J$0 J
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$4 Ljava/lang/Object;
    check-cast v3, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v7, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$3 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v14, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$2 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    iget-object v15, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$1 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    iget-object v8, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5dh
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "cancelForReuse[start]: sourceTaskId="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v11, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->registerCancelWaiter(Ljava/lang/String; Ljava/lang/String;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v4
    sget-object v7, Lkotlinx/coroutines/NonCancellable;->INSTANCE Lkotlinx/coroutines/NonCancellable;
    check-cast v7, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$result$1;
    move-object/from16 v14, v20
    invoke-direct v8, v14, v1, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$result$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$0 Ljava/lang/Object;
    iput-object v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$1 Ljava/lang/Object;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$2 Ljava/lang/Object;
    iput-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$3 Ljava/lang/Object;
    iput-object v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$4 Ljava/lang/Object;
    move-wide/from16 v14, v24
    iput-wide v14, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->J$0 J
    iput v12, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->label I
    invoke-static v7, v8, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v6, +003h
    return-object v6
    move-object v8, v0
    move-wide/from16 v16, v14
    move-object v15, v1
    move-object v14, v2
    move-wide/from16 v1, v16
    move-object/from16 v18, v7
    move-object v7, v3
    move-object v3, v4
    move-object/from16 v4, v18
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v12, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v12, +06bh
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v0, "cancelForReuse[api-success]: sourceTaskId="
    invoke-direct v13, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v10, ", bizCode="
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    move-object/from16 v23, v14
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v13
    invoke-virtual v0, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v11, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-wide/16 v9, 0
    cmp-long v0, v1, v9
    if-gtz v0, +00bh
    invoke-direct v8, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearCancelWaiter(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    goto/16 +090h
    const/4 v0, 0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$0 Ljava/lang/Object;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$1 Ljava/lang/Object;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$2 Ljava/lang/Object;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$3 Ljava/lang/Object;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->L$4 Ljava/lang/Object;
    const/4 v0, 2
    iput v0, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;->label I
    move-object/from16 v20, v8
    move-object/from16 v21, v3
    move-object/from16 v22, v15
    move-wide/from16 v24, v1
    move-object/from16 v26, v5
    invoke-direct/range v20 ... v26, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->awaitCancelRemoteTerminal(Lkotlinx/coroutines/CompletableDeferred; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v6, +003h
    return-object v6
    return-object v4
    move-object/from16 v23, v14
    instance-of v0, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +06bh
    invoke-direct v8, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearCancelWaiter(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "cancelForReuse[api-failed]: sourceTaskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v14, v23
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", code="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", msg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v2
    invoke-virtual v0, v11, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v12, 1
    goto +2h
    const/4 v12, 0
    if-eqz v12, +004h
    const-string v0, "cancel_api_failed"
    check-cast v0, Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$Failed;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$Failed;-><init>(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method

.method static synthetic cancelClientProxyTaskForReuse$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 16
    if-eqz v0, +006h
    const-wide/16 v0, 15000
    move-wide v7, v0
    goto +2h
    move-wide v7, v15
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object/from16 v9, v17
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelClientProxyTaskForReuse(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final cancelLongRunningJob()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->longRunningJob Lkotlinx/coroutines/Job;
    if-eqz v0, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "VoiceSubTaskCoord"
    const-string v2, "cancelLongRunningJob"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->longRunningJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->longRunningJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final cancelPreviousTaskForSwitch(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  kotlinx.coroutines.Job  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=4
    instance-of v0, v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;
    invoke-direct v0, v11, v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    move-object v8, v0
    iget-object v14, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +018h
    if-eq v1, v3, +011h
    if-ne v1, v2, +007h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0afh
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v13, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v13, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +078h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v14
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const-string v4, "VoiceSubTaskCoord"
    if-eq v14, v1, +02bh
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v0, "cancelForReuse[local-only]: sourceTaskId="
    invoke-direct v14, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v0, ", executor="
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v12
    invoke-virtual v14, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v4, v12, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;
    return-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getProxyConversationId()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v5
    move-object v1, v14
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v6, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v6
    goto +2h
    move v1, v3
    if-nez v1, +029h
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +008h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v6, v3
    if-nez v6, +01bh
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    const-string v12, "local_sub_task_superseded"
    const-wide/16 v6, 0
    const/16 v9, 16
    const/4 v10, 0
    iput v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;->label I
    move-object v1, v11
    move-object v2, v14
    move-object v3, v5
    move-object v5, v12
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelClientProxyTaskForReuse$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    return-object v14
    if-eqz v13, +02ch
    invoke-interface v13, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v14
    if-eqz v14, +026h
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "cancelForReuse[wait-create]: sourceTaskId="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v14, v4, v12, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iput v2, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;->label I
    invoke-interface v13, v8, Lkotlinx/coroutines/Job;->join(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;
    return-object v12
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v0, "cancelForReuse[no-local-task]: sourceTaskId="
    invoke-direct v14, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v14, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v4, v12, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;
    return-object v12
.end method

.method private final cancelRemoteClientProxyTask(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=5
    instance-of v0, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;
    invoke-direct v0, v7, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->label I
    const-string v3, ", reason="
    const-string v4, "VoiceSubTaskCoord"
    const/4 v5, 1
    if-eqz v2, +01ah
    if-ne v2, v5, +010h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->L$1 Ljava/lang/Object;
    move-object v10, v8
    check-cast v10, Ljava/lang/String;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->L$0 Ljava/lang/Object;
    move-object v9, v8
    check-cast v9, Ljava/lang/String;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3fh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v9, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v9, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v6, "cancelRemoteClientProxyTask: localTaskId="
    invoke-direct v2, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v11, v4, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/im/service/ICancelTaskApi;->Companion Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$result$1;
    const/4 v6, 0
    invoke-direct v2, v8, v9, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$result$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->L$0 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->L$1 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;->label I
    invoke-virtual v11, v2, v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v8, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v8, +033h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "cancelRemoteClientProxyTask: ok localTaskId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v0, ", bizCode="
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v0
    invoke-virtual v9, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v4, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +44h
    instance-of v8, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v8, +046h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "cancelRemoteClientProxyTask: failed localTaskId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v0, ", code="
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v0, ", msg="
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v10
    invoke-virtual v8, v4, v9, v10, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    const/4 v5, 0
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    return-object v8
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
.end method

.method private final cancelTimer()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->timeoutJob Lkotlinx/coroutines/Job;
    if-eqz v0, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "VoiceSubTaskCoord"
    const-string v2, "cancelTimer"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->timeoutJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->timeoutJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final clearCancelWaiter(java.lang.String)void
    .registers 6
    # ins_size=2
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->removeCancelWaiterLocked(Ljava/lang/String;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v0
    if-eqz v0, +01fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "cancelForReuse[clear-waiter]: localTaskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "VoiceSubTaskCoord"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v0, Lkotlinx/coroutines/Job;
    const/4 v5, 1
    const/4 v1, 0
    invoke-static v0, v1, v5, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final clearCreateTaskRetryableBizErrorSuppressed(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v1, v3, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    monitor-exit v0
    return-void 
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x3
.end method

.method private final clearPendingClientProxyIfCurrent(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    if-eqz v3, +006h
    const/4 v0, 1
    invoke-static v3, v1, v0, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    return-void 
.end method

.method private final clearSubTaskResultReportStarted(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v1, v3, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    monitor-exit v0
    return-void 
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x3
.end method

.method private final clearSwitchingPendingForStop(java.lang.String)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleTaskStop[clear-pending]: active="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", pending="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, ", canceling="
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v0, "VoiceSubTaskCoord"
    invoke-virtual v1, v0, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    const/4 v0, 0
    if-eqz v5, +006h
    const/4 v1, 1
    invoke-static v5, v0, v1, v0, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    return-void 
.end method

.method private static final cliStatusListener$lambda$0(com.bytedance.trae.im.service.IMService$CliStatusChangePayload)void
    .registers 4
    # ins_size=1
    const-string v0, "payload"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eq v1, v2, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliId()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +03fh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getCliId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2fh
    invoke-virtual v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getAvailable()Z
    move-result v0
    sput-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->deviceOnline Z
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "cliStatus: cliId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", online="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getAvailable()Z
    move-result v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v1, "VoiceSubTaskCoord"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final completeCancelWaiterBySourceTaskId(java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterSourceToLocal Ljava/util/Map;
    invoke-interface v1, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +004h
    monitor-exit v0
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->removeCancelWaiterInternal(Ljava/lang/String;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    monitor-exit v0
    invoke-virtual v1, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-virtual v1, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/coroutines/CompletableDeferred;
    if-nez v1, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "VoiceSubTaskCoord"
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "cancelForReuse[task-result-terminal]: sourceTaskId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v4, ", localTaskId="
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", status="
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;
    invoke-interface v1, v7, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    return-void 
    move-exception v7
    monitor-exit v0
    throw v7
    :try_start_0x3
    :try_start_0xf
.end method

.method private final completeCancelWaiterIfNeeded(java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.String)void
    .registers 10
    # ins_size=6
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->removeCancelWaiterLocked(Ljava/lang/String;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "cancelForReuse[remote-terminal]: localTaskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", status="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", isHistory="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", errorCode="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", errorMsg="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v6, "VoiceSubTaskCoord"
    invoke-virtual v1, v6, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;
    invoke-interface v0, v5, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    return-void 
.end method

.method private final createRemoteParentSession(com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v19
    instance-of v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->label I
    move-object/from16 v13, v17
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;
    move-object/from16 v13, v17
    invoke-direct v1, v13, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v14
    iget v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->label I
    const/4 v15, 2
    const/4 v12, 1
    const-string v11, "VoiceSubTaskCoord"
    if-eqz v2, +023h
    if-eq v2, v12, +01ah
    if-ne v2, v15, +010h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v1, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v15, v11
    goto/16 +153h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v0
    move-object v15, v11
    move v0, v12
    goto +42h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getSource()Lcom/bytedance/trae/im/service/Source;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    const/16 v0, 216
    const/16 v16, 0
    move-object/from16 v2, v17
    move-object/from16 v3, v18
    move-object v15, v11
    move v11, v0
    move v0, v12
    move-object/from16 v12, v16
    invoke-static/range v2 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskRequest$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source; Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig; Z I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/CreateTaskRequest;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "createRemoteParentSession: posting empty parent, voiceConvId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getVoiceConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v15, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/im/service/ICreateAgentTask;->Companion Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    iput v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->label I
    invoke-virtual v3, v2, v1, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->createAgentTaskRawCall(Lcom/bytedance/trae/im/service/CreateTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v14, +003h
    return-object v14
    check-cast v2, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v4, 0
    if-nez v3, +017h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "createRemoteParentSession: create failed, result="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v3, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTask()Lcom/bytedance/trae/im/service/ConversationInfo;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ConversationInfo;->getId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v5, +00dh
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTask()Lcom/bytedance/trae/im/service/ConversationInfo;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ConversationInfo;->getCliConversationId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v4
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v12, 0
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v12
    goto +2h
    move v6, v0
    const-string v7, "createRemoteParentSession: bizCode="
    if-eqz v6, +01fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v2
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", conversationId empty"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +008h
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    move v12, v0
    if-eqz v12, +023h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v1, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatSessionId empty, parentConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v0, +017h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "createRemoteParentSession: released before create completed, drop convId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "createRemoteParentSession: parent ok, parentConversationId="
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", chatSessionId="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v15, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->L$0 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->L$1 Ljava/lang/Object;
    const/4 v2, 2
    iput v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createRemoteParentSession$1;->label I
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->wakeupSandboxRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v14, +003h
    return-object v14
    move-object v1, v3
    move-object v2, v5
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v3, +017h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "createRemoteParentSession: wakeup ok, chatSessionId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v15, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +45h
    instance-of v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +043h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "createRemoteParentSession: wakeup failed, chatSessionId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", parentConversationId="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", code="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", msg="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v0
    invoke-virtual v3, v15, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v1
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method

.method private final createSubTask(com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  kotlin.coroutines.Continuation)java.lang.Object
    .registers 36
    # ins_size=5
    move-object/from16 v0, v31
    move-object/from16 v1, v32
    move-object/from16 v2, v34
    move-object/from16 v3, v35
    instance-of v4, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;
    if-eqz v4, +012h
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;
    iget v5, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    sub-int/2addr v3, v6
    iput v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;
    invoke-direct v4, v0, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    const/4 v7, 4
    const/4 v8, 3
    const/4 v9, 2
    const-string v10, "VoiceSubTaskCoord"
    const/4 v11, 0
    const/4 v12, 1
    const/4 v13, 0
    if-eqz v6, +04ah
    if-eq v6, v12, +02bh
    if-eq v6, v9, +018h
    if-eq v6, v8, +011h
    if-ne v6, v7, +007h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +451h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +400h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$2 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +15ch
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$4 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    iget-object v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$2 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    iget-object v14, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$1 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    iget-object v15, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$0 Ljava/lang/Object;
    check-cast v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v18, v1
    move-object/from16 v16, v14
    move-object v1, v15
    goto +23h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildSubTaskQueryJson$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)Ljava/lang/String;
    move-result-object v3
    iput-object v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$0 Ljava/lang/Object;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$1 Ljava/lang/Object;
    move-object/from16 v6, v33
    iput-object v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$2 Ljava/lang/Object;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$3 Ljava/lang/Object;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$4 Ljava/lang/Object;
    iput v12, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveParentConversationIdForSubTask(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v5, +003h
    return-object v5
    move-object/from16 v16, v1
    move-object/from16 v18, v3
    move-object v3, v14
    move-object v1, v0
    check-cast v3, Ljava/lang/String;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v14
    sget-object v15, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v14, v15, +050h
    move-object v14, v6
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +00bh
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    goto +3h
    move v14, v11
    goto +2h
    move v14, v12
    if-eqz v14, +03fh
    move-object v14, v3
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +00bh
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    goto +3h
    move v14, v11
    goto +2h
    move v14, v12
    if-eqz v14, +02eh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "createSubTask: remote parent conversation is empty, taskId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v10, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v18
    const-string v19, "container_not_ready"
    const/16 v20, 0
    const/16 v21, 4
    const/16 v22, 0
    move-object/from16 v17, v1
    invoke-static/range v17 ... v22, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failActiveTaskAndReport$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-object v14, v6
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +00bh
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    goto +3h
    move v14, v11
    goto +2h
    move v14, v12
    if-eqz v14, +00dh
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v15
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v15, v7, +005h
    move-object/from16 v19, v3
    goto +3h
    move-object/from16 v19, v13
    if-eqz v14, +008h
    const-string/jumbo v3, voice_discussion
    move-object/from16 v20, v3
    goto +3h
    move-object/from16 v20, v13
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 224
    const/16 v25, 0
    move-object v15, v1
    move-object/from16 v17, v6
    invoke-static/range v15 ... v25, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskRequest$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source; Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig; Z I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/CreateTaskRequest;
    move-result-object v3
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v15, "createSubTask: posting, sourceTaskId="
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, ", proxyConvId="
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, ", parentConversationId="
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->getParentConversationId()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, ", hiddenStatus="
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->getHiddenStatus()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, ", files="
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v15
    if-eqz v15, +007h
    invoke-interface v15, Ljava/util/List;->size()I
    move-result v15
    goto +2h
    move v15, v11
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, ", descLen="
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/String;->length()I
    move-result v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v7, v10, v14, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->markCreatePostStart(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v7
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$0 Ljava/lang/Object;
    iput-object v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$1 Ljava/lang/Object;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$2 Ljava/lang/Object;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$3 Ljava/lang/Object;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$4 Ljava/lang/Object;
    iput v9, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    invoke-direct v1, v3, v7, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskWithRetry(Lcom/bytedance/trae/im/service/CreateTaskRequest; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object/from16 v30, v6
    move-object v6, v1
    move-object v1, v2
    move-object/from16 v2, v30
    move-object v15, v3
    check-cast v15, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    sget-boolean v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v3, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v3
    instance-of v7, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-nez v7, +04ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-direct v6, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearCreateTaskRetryableBizErrorSuppressed(Ljava/lang/String;)V
    const-string v16, "create_failed"
    const/16 v17, 0
    const/16 v18, 4
    const/16 v19, 0
    move-object v14, v6
    invoke-static/range v14 ... v19, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildCreateTaskFailureReport$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/im/service/CreateTaskRawResult; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v7, "createSubTask: failed, sourceTaskId="
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, ", result="
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;->getErrorCode()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;->getError()Ljava/lang/String;
    move-result-object v2
    invoke-direct v6, v1, v3, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failActiveTaskAndReport(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v13
    invoke-virtual v6, v13, v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isCreateTaskBizSuccess$conversation_mainlandRelease(J)Z
    move-result v13
    if-nez v13, +064h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v4
    invoke-direct v6, v2, v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->shouldSuppressCreateTaskBizError(Ljava/lang/String; J)Z
    move-result v2
    const-string v4, "create_failed"
    invoke-virtual v6, v15, v4, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildCreateTaskFailureReport$conversation_mainlandRelease(Lcom/bytedance/trae/im/service/CreateTaskRawResult; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "createSubTask: biz failed, sourceTaskId="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", bizCode="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v8
    invoke-virtual v7, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, ", suppressBizError="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", error="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;->getError()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;->getErrorCode()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;->getError()Ljava/lang/String;
    move-result-object v3
    invoke-direct v6, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failActiveTaskAndReport(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v13
    invoke-direct v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearCreateTaskRetryableBizErrorSuppressed(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTaskId()Ljava/lang/String;
    move-result-object v13
    goto +2h
    const/4 v13, 0
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v14, +00dh
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTask()Lcom/bytedance/trae/im/service/ConversationInfo;
    move-result-object v14
    if-eqz v14, +007h
    invoke-virtual v14, Lcom/bytedance/trae/im/service/ConversationInfo;->getId()Ljava/lang/String;
    move-result-object v14
    goto +2h
    const/4 v14, 0
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v15, +00dh
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTask()Lcom/bytedance/trae/im/service/ConversationInfo;
    move-result-object v15
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/im/service/ConversationInfo;->getCliConversationId()Ljava/lang/String;
    move-result-object v15
    goto +2h
    const/4 v15, 0
    if-eqz v2, +01dh
    move-object/from16 v16, v2
    check-cast v16, Ljava/lang/CharSequence;
    invoke-interface/range v16, Ljava/lang/CharSequence;->length()I
    move-result v16
    if-lez v16, +005h
    move/from16 v16, v12
    goto +3h
    move/from16 v16, v11
    if-eqz v16, +005h
    move-object/from16 v16, v2
    goto +3h
    const/16 v16, 0
    if-nez v16, +003h
    goto +3h
    move-object/from16 v14, v16
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v16
    check-cast v16, Ljava/lang/String;
    if-eqz v16, +01ah
    move-object/from16 v17, v16
    check-cast v17, Ljava/lang/CharSequence;
    invoke-interface/range v17, Ljava/lang/CharSequence;->length()I
    move-result v17
    if-lez v17, +005h
    move/from16 v17, v12
    goto +3h
    move/from16 v17, v11
    if-eqz v17, +003h
    goto +3h
    const/16 v16, 0
    if-eqz v16, +004h
    move-object/from16 v15, v16
    move-object/from16 v16, v13
    check-cast v16, Ljava/lang/CharSequence;
    if-eqz v16, +00ch
    invoke-interface/range v16, Ljava/lang/CharSequence;->length()I
    move-result v16
    if-nez v16, +003h
    goto +4h
    move/from16 v16, v11
    goto +3h
    move/from16 v16, v12
    if-eqz v16, +043h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "createSubTask: empty taskId, bizCode="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v4, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v10, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v4
    new-array v2, v9, [Ljava/lang/String;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v7
    aput-object v7, v2, v11
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    aput-object v3, v2, v12
    invoke-direct v6, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlankErrorMessage([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, task_id
    invoke-direct v6, v3, v4, v5, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildCreateTaskMissingFieldError(Ljava/lang/String; J Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "no_local_task_id"
    invoke-direct v6, v1, v3, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failActiveTaskAndReport(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-object/from16 v16, v14
    check-cast v16, Ljava/lang/CharSequence;
    if-eqz v16, +00ch
    invoke-interface/range v16, Ljava/lang/CharSequence;->length()I
    move-result v16
    if-nez v16, +003h
    goto +4h
    move/from16 v16, v11
    goto +3h
    move/from16 v16, v12
    if-eqz v16, +04ch
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "createSubTask: empty hidden conversationId, bizCode="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v4, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", taskId="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v10, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v4
    new-array v2, v9, [Ljava/lang/String;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v7
    aput-object v7, v2, v11
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    aput-object v3, v2, v12
    invoke-direct v6, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlankErrorMessage([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "conversation_id"
    invoke-direct v6, v3, v4, v5, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildCreateTaskMissingFieldError(Ljava/lang/String; J Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "container_not_ready"
    invoke-direct v6, v1, v3, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failActiveTaskAndReport(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v11
    goto +2h
    move v2, v12
    if-eqz v2, +025h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, v14, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v9, "createSubTask: hidden session created, proxyConversationId="
    invoke-direct v3, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v9, ", proxyChatSessionId="
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v2, v15
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v11
    goto +2h
    move v2, v12
    if-nez v2, +016h
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +008h
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    move v11, v12
    if-eqz v11, +005h
    invoke-interface v7, v15, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v7
    goto +2h
    const/4 v7, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v9
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +02bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "createSubTask: active task changed during create, cancel server task="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v1, 0
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$0 Ljava/lang/Object;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$1 Ljava/lang/Object;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$2 Ljava/lang/Object;
    iput v8, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    const-string v1, "active_changed_during_create"
    invoke-direct v6, v14, v13, v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelRemoteClientProxyTask(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v5, +003h
    return-object v5
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v9
    invoke-interface v8, v9, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +03ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v8, "createSubTask: active task already in terminal state="
    invoke-direct v2, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", cancel server task="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v1, 0
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$0 Ljava/lang/Object;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$1 Ljava/lang/Object;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->L$2 Ljava/lang/Object;
    const/4 v1, 4
    iput v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createSubTask$1;->label I
    const-string v1, "active_terminal_during_create"
    invoke-direct v6, v14, v13, v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelRemoteClientProxyTask(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v5, +003h
    return-object v5
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    const/4 v4, 0
    const/16 v16, 0
    sget-object v20, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Thinking Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/16 v21, 0
    const/16 v22, 0
    const-wide/16 v23, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 4035
    const/16 v29, 0
    move-object v5, v14
    move-object v14, v3
    move-object v3, v15
    move-object v15, v4
    move-object/from16 v17, v13
    move-object/from16 v18, v5
    move-object/from16 v19, v3
    invoke-static/range v14 ... v29, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v6, v2, v3, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startTimer(J Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public static synthetic createTaskRequest$conversation_mainlandRelease$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source  com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig  boolean  int  java.lang.Object)com.bytedance.trae.im.service.CreateTaskRequest
    .registers 23
    # ins_size=11
    move/from16 v0, v21
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit8 v1, v0, 64
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v19
    and-int/lit16 v0, v0, 128
    if-eqz v0, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    move v11, v0
    goto +3h
    move/from16 v11, v20
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    invoke-virtual/range v3 ... v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskRequest$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source; Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig; Z)Lcom/bytedance/trae/im/service/CreateTaskRequest;
    move-result-object v0
    return-object v0
.end method

.method private final createTaskWithRetry(com.bytedance.trae.im.service.CreateTaskRequest  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=4
    move-object/from16 v0, v22
    instance-of v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->label I
    move-object/from16 v2, v19
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;
    move-object/from16 v2, v19
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->label I
    const/4 v5, 2
    const/4 v6, 0
    const/4 v7, 1
    if-eqz v4, +056h
    if-eq v4, v7, +035h
    if-ne v4, v5, +02bh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$5 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$4 Ljava/lang/Object;
    check-cast v8, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$3 Ljava/lang/Object;
    check-cast v9, Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/im/service/CreateTaskRequest;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v2, v5
    move-object v0, v11
    move-object v5, v4
    move-object v4, v1
    move-object v1, v10
    move-object v10, v12
    move-object/from16 v17, v8
    move-object v8, v3
    move-object v3, v9
    move-object/from16 v9, v17
    goto/16 +114h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$4 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$3 Ljava/lang/Object;
    check-cast v8, Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/im/service/CreateTaskRequest;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v12, v11
    move-object/from16 v17, v8
    move-object v8, v4
    move-object v4, v9
    move-object/from16 v9, v17
    goto +3ch
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    new-instance v4, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v4, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    move-object v10, v2
    move-object v8, v3
    move-object v9, v4
    move-object v3, v0
    move-object v4, v1
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    sget-object v11, Lcom/bytedance/trae/im/service/ICreateAgentTask;->Companion Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    iput-object v10, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$2 Ljava/lang/Object;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$3 Ljava/lang/Object;
    iput-object v9, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$4 Ljava/lang/Object;
    iput-object v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$5 Ljava/lang/Object;
    iput v7, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->label I
    invoke-virtual v11, v0, v4, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->createAgentTaskRawCall(Lcom/bytedance/trae/im/service/CreateTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v8, +003h
    return-object v8
    move-object v12, v10
    move-object v10, v0
    move-object v0, v11
    move-object/from16 v17, v4
    move-object v4, v1
    move-object/from16 v1, v17
    move-object/from16 v18, v9
    move-object v9, v3
    move-object v3, v8
    move-object/from16 v8, v18
    check-cast v0, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v11
    instance-of v13, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v13, +005h
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    goto +2h
    move-object v11, v6
    if-eqz v11, +011h
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    if-eqz v11, +00bh
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v13
    invoke-static v13, v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v11
    goto +2h
    move-object v11, v6
    if-nez v11, +003h
    goto +ch
    invoke-virtual v11, Ljava/lang/Long;->longValue()J
    move-result-wide v13
    const-wide/32 v15, 995000
    cmp-long v13, v13, v15
    if-eqz v13, +003h
    return-object v0
    iget v13, v9, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget-wide v14, v8, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v12, v13, v14, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->calculateCreateTaskRetryDelayMs$conversation_mainlandRelease(I J)Ljava/lang/Long;
    move-result-object v13
    const-string v14, ", elapsedDelayMs="
    const-string v15, ", bizCode="
    const-string v6, "VoiceSubTaskCoord"
    if-eqz v13, +07fh
    move-object/from16 v20, v6
    invoke-virtual v13, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    iget v13, v9, Lkotlin/jvm/internal/Ref$IntRef;->element I
    add-int/2addr v13, v7
    iput v13, v9, Lkotlin/jvm/internal/Ref$IntRef;->element I
    move-object v13, v3
    iget-wide v2, v8, Lkotlin/jvm/internal/Ref$LongRef;->element J
    add-long/2addr v2, v5
    iput-wide v2, v8, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v7, "createTaskWithRetry[retry]: sourceTaskId="
    invoke-direct v3, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, ", retry="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget v7, v9, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, "/15, delayMs="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-wide v14, v8, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v3, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v7, v20
    invoke-virtual v2, v7, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v12, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$2 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$3 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$4 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->L$5 Ljava/lang/Object;
    const/4 v2, 2
    iput v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$createTaskWithRetry$1;->label I
    invoke-static v5, v6, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    move-object v5, v13
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v9
    move-object v9, v8
    move-object v8, v5
    move-object v5, v0
    move-object v0, v10
    move-object v10, v12
    move-object/from16 v17, v4
    move-object v4, v1
    move-object/from16 v1, v17
    sget-boolean v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v6, +003h
    return-object v5
    move v5, v2
    const/4 v6, 0
    const/4 v7, 1
    move-object/from16 v2, v19
    goto/16 -0dfh
    move-object v7, v6
    check-cast v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "createTaskWithRetry[exhausted]: sourceTaskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", retries="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget v3, v9, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-wide v3, v8, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v7, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method private final dataJsonObject(java.lang.Object)com.google.gson.JsonObject
    .registers 4
    # ins_size=2
    instance-of v0, v3, Lcom/google/gson/JsonObject;
    if-eqz v0, +005h
    check-cast v3, Lcom/google/gson/JsonObject;
    goto +41h
    const/4 v0, 0
    if-nez v3, +004h
    move-object v3, v0
    goto +3ch
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    new-instance v1, Lcom/google/gson/Gson;
    invoke-direct v1, Lcom/google/gson/Gson;-><init>()V
    invoke-virtual v1, v3, Lcom/google/gson/Gson;->toJsonTree(Ljava/lang/Object;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    goto +2h
    move-object v3, v0
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    move-object v3, v0
    check-cast v3, Lcom/google/gson/JsonObject;
    return-object v3
    :try_start_0xc
.end method

.method private final varargs dataLong(java.lang.Object  java.lang.String[])java.lang.Long
    .registers 8
    # ins_size=3
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->dataJsonObject(Ljava/lang/Object;)Lcom/google/gson/JsonObject;
    move-result-object v6
    const/4 v0, 0
    if-nez v6, +003h
    return-object v0
    array-length v1, v7
    const/4 v2, 0
    if-ge v2, v1, +045h
    aget-object v3, v7, v2
    invoke-virtual v6, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +03ah
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +030h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v3
    if-nez v3, +003h
    goto +28h
    invoke-virtual v3, Lcom/google/gson/JsonPrimitive;->isNumber()Z
    move-result v4
    if-eqz v4, +00bh
    invoke-virtual v3, Lcom/google/gson/JsonPrimitive;->getAsLong()J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    goto +16h
    invoke-virtual v3, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v4
    if-eqz v4, +010h
    invoke-virtual v3, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "getAsString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v3
    goto +2h
    move-object v3, v0
    if-eqz v3, +003h
    return-object v3
    add-int/lit8 v2, v2, 1
    goto -44h
    return-object v0
.end method

.method private final varargs dataString(java.lang.Object  java.lang.String[])java.lang.String
    .registers 8
    # ins_size=3
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->dataJsonObject(Ljava/lang/Object;)Lcom/google/gson/JsonObject;
    move-result-object v6
    const/4 v0, 0
    if-nez v6, +003h
    return-object v0
    array-length v1, v7
    const/4 v2, 0
    if-ge v2, v1, +02dh
    aget-object v3, v7, v2
    invoke-virtual v6, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +01eh
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +014h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00eh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +003h
    return-object v3
    add-int/lit8 v2, v2, 1
    goto -2ch
    return-object v0
.end method

.method private final deleteHubConversationAsync(java.lang.String  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$deleteHubConversationAsync$1;
    const/4 v4, 0
    invoke-direct v3, v7, v8, v9, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$deleteHubConversationAsync$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitParallelTerminal(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.lang.String)void
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parallelTerminalToolResults Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-interface v0, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +034h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "emitParallelTerminal["
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, "]: buffer overflow, taskId="
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, ", state="
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "VoiceSubTaskCoord"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final evaluatePrechecks()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    if-eqz v0, +025h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v1, v2, +01dh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +009h
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->deviceOnline Z
    if-nez v0, +005h
    const-string v0, "device_offline"
    return-object v0
    const/4 v0, 0
    return-object v0
.end method

.method private final extractContent(com.bytedance.trae.im.model.ParsedChatMessage)java.lang.String
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v6
    const-string v0, ""
    if-eqz v6, +094h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v6
    if-eqz v6, +08eh
    check-cast v6, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v2
    if-eqz v2, -010h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v6
    if-eqz v6, +003h
    return-object v0
    move-object v6, v1
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v6, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v6
    new-instance v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda2;
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v6, v2, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v6
    new-instance v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda3;
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v6, v2, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v6
    invoke-static v6, Lkotlin/sequences/SequencesKt;->lastOrNull(Lkotlin/sequences/Sequence;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v3
    if-nez v2, +003h
    return-object v6
    invoke-static v1, Lkotlin/collections/CollectionsKt;->asReversed(Ljava/util/List;)Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +01bh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00dh
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v3
    if-eqz v4, +003h
    move-object v2, v1
    if-eqz v2, -01eh
    if-nez v2, +003h
    goto +2h
    move-object v0, v2
    return-object v0
.end method

.method private static final extractContent$lambda$73(com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->FINISH_TOOLS Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method private static final extractContent$lambda$76(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.String
    .registers 3
    # ins_size=1
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    const/4 v0, 0
    if-eqz v2, +02dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +027h
    const-string/jumbo v1, summary
    invoke-virtual v2, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +01eh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00eh
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    move-object v0, v2
    return-object v0
.end method

.method private final failActiveTask(java.lang.String  java.lang.String)void
    .registers 22
    # ins_size=3
    move-object/from16 v0, v20
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "failActiveTask: sourceTaskId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", prev="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", executor="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", reason="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move-object/from16 v11, v21
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v4, "VoiceSubTaskCoord"
    invoke-virtual v2, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v10, 0
    const-wide/16 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 3935
    const/16 v18, 0
    invoke-static/range v3 ... v18, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final failActiveTaskAndReport(java.lang.String  java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v2, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    const-wide/16 v5, 0
    cmp-long v1, v3, v5
    const/4 v3, 1
    const/4 v4, 0
    if-lez v1, +004h
    move v1, v3
    goto +2h
    move v1, v4
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +013h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    sub-long/2addr v7, v0
    invoke-static v7, v8, v5, v6, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v0
    move-wide v10, v0
    goto +2h
    move-wide v10, v5
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v0, v1, +003h
    goto +2h
    move v3, v4
    invoke-direct v12, v13, v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failActiveTask(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v3, +01dh
    const-string v3, "failed"
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 16
    const/4 v8, 0
    move-object v1, v12
    move-object v4, v14
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    const-string v5, "failed"
    const-string v6, ""
    const-string v0, "fail-active-task"
    move-object v3, v12
    move-object v4, v13
    move-wide v7, v10
    move-object v9, v14
    move-object v10, v15
    move-object v11, v0
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method static synthetic failActiveTaskAndReport$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failActiveTaskAndReport(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final failPendingClientProxyTask(java.lang.String  java.lang.String)void
    .registers 24
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v15, v22
    invoke-static v2, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    const-wide/16 v5, 0
    cmp-long v3, v3, v5
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +014h
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->longValue()J
    move-result-wide v2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    sub-long/2addr v7, v2
    invoke-static v7, v8, v5, v6, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v2
    move-wide/from16 v18, v2
    goto +3h
    move-wide/from16 v18, v5
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v9, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    const/16 v17, 3935
    const/16 v20, 0
    move-object v2, v1
    move-object/from16 v10, v23
    move-object/from16 v15, v16
    move/from16 v16, v17
    move-object/from16 v17, v20
    invoke-static/range v2 ... v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v0, v2, +026h
    const-string v4, "failed"
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 16
    const/4 v9, 0
    move-object/from16 v2, v21
    move-object v3, v1
    move-object/from16 v5, v23
    invoke-static/range v2 ... v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    const-string v5, "failed"
    const-string v6, ""
    const/4 v10, 0
    const-string v11, "fail-pending-client-proxy"
    const/16 v12, 32
    const/4 v13, 0
    move-object/from16 v3, v21
    move-object/from16 v4, v22
    move-wide/from16 v7, v18
    move-object/from16 v9, v23
    invoke-static/range v3 ... v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final varargs firstNonBlank(java.lang.String[])java.lang.String
    .registers 9
    # ins_size=2
    array-length v0, v8
    const/4 v1, 0
    move v2, v1
    const/4 v3, 0
    if-ge v2, v0, +01bh
    aget-object v4, v8, v2
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 1
    if-eqz v5, +00bh
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v6
    xor-int/2addr v5, v6
    if-eqz v5, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -1bh
    move-object v4, v3
    if-eqz v4, +00ch
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final varargs firstNonBlankErrorMessage(java.lang.String[])java.lang.String
    .registers 5
    # ins_size=2
    array-length v0, v4
    invoke-static v4, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v4
    check-cast v4, [Ljava/lang/String;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +00dh
    const-string/jumbo v1, success
    const/4 v2, 1
    invoke-static v4, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v1
    if-nez v1, +003h
    goto +2h
    move-object v4, v0
    return-object v4
.end method

.method private final hasCancelWaiter(java.lang.String)boolean
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiters Ljava/util/Map;
    invoke-interface v1, v3, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v3
    monitor-exit v0
    return v3
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x3
.end method

.method private final isServerToolResultCandidate(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, task_create
    const/4 v1, 1
    invoke-static v3, v0, v1, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v3
    xor-int/2addr v3, v1
    return v3
.end method

.method private final isSubTaskResultReported(java.lang.String)boolean
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v1, v3, Ljava/util/LinkedHashSet;->contains(Ljava/lang/Object;)Z
    move-result v3
    monitor-exit v0
    return v3
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x3
.end method

.method private final isTerminalStreamingMessage(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->COMPLETED_STATUSES Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +017h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v0
    const-string v1, "in_progress"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +009h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    return v3
.end method

.method private final localizedString(int)java.lang.String
    .registers 5
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    new-array v2, v2, [Ljava/lang/Object;
    invoke-virtual v0, v1, v4, v2, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    move-object v4, v1
    check-cast v4, Ljava/lang/String;
    if-eqz v4, +00eh
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    move-object v1, v4
    return-object v1
    :try_start_0x0
.end method

.method private final markCreatePostStart(java.lang.String)void
    .registers 20
    # ins_size=2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    sget-object v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v15, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v2, v19
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v1, v1, v3
    if-lez v1, +003h
    return-void 
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 3839
    const/16 v16, 0
    move-object/from16 v17, v15
    move-object/from16 v15, v16
    invoke-static/range v0 ... v15, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    move-object/from16 v1, v17
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final markCreateTaskRetryableBizErrorSuppressed(java.lang.String)void
    .registers 5
    # ins_size=2
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v1, v4, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v4, Ljava/util/LinkedHashSet;->size()I
    move-result v1
    const/16 v2, 256
    if-le v1, v2, +012h
    move-object v1, v4
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/lang/Iterable;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v4, v1, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    goto -19h
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v4
    monitor-exit v0
    throw v4
    :try_start_0xd
.end method

.method private final markSubTaskResultReportStarted(java.lang.String)boolean
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v1, v4, Ljava/util/LinkedHashSet;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v4, 0
    goto +1fh
    invoke-virtual v1, v4, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v4, Ljava/util/LinkedHashSet;->size()I
    move-result v1
    const/16 v2, 256
    if-le v1, v2, +012h
    move-object v1, v4
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/lang/Iterable;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v4, v1, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    goto -19h
    const/4 v4, 1
    monitor-exit v0
    return v4
    move-exception v4
    monitor-exit v0
    throw v4
    :try_start_0x3
.end method

.method private final maybeCancelClientProxyTask(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 11
    # ins_size=2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-eq v0, v1, +003h
    return-void 
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getProxyConversationId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v10
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +023h
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +008h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v2, v3
    if-eqz v2, +003h
    goto +13h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;
    const/4 v2, 0
    invoke-direct v1, v0, v10, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final maybeDeleteEmptyRemoteParentSession(java.lang.String)void
    .registers 10
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00dh
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +003h
    goto +2h
    move-object v1, v3
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-eqz v4, +00dh
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v2
    if-eqz v5, +003h
    goto +2h
    move-object v4, v3
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    if-eqz v5, +00dh
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v2
    if-eqz v6, +003h
    goto +2h
    move-object v5, v3
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    const-string v7, "VoiceSubTaskCoord"
    if-ne v3, v6, +081h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCreateRemoteParentSession()Z
    move-result v0
    if-nez v0, +004h
    goto/16 +079h
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v3
    goto +2h
    move v0, v2
    const-string v6, ", reason="
    if-eqz v0, +020h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, skip delete empty parent: parentConversationId empty, parentChatSessionId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v7, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00ah
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move v2, v3
    if-nez v2, +034h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, skip delete empty parent: proxy exists, parentConversationId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", parentChatSessionId="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", proxyConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v7, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-direct v8, v4, v1, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->deleteHubConversationAsync(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, skip delete empty parent: not remote home, reason=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v7, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final normalizeAttachmentUriForCreate(java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, trae-res://
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +1ah
    const-string/jumbo v0, tos-
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +012h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, trae-res://remote_resource/
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private final postSubTaskResultOnceAsync(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String  java.lang.String)void
    .registers 29
    # ins_size=9
    move-object/from16 v10, v20
    move-object/from16 v0, v21
    move-object/from16 v11, v22
    move-object/from16 v12, v28
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const-string v13, "postSubTaskResult["
    const-string v14, "VoiceSubTaskCoord"
    if-eqz v1, +01fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "]: skip blank taskId status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v14, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-direct/range v20 ... v21, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveReportTaskId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +028h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "]: alias taskId="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, " reportAs="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v14, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v10, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->markSubTaskResultReportStarted(Ljava/lang/String;)Z
    move-result v16
    const/4 v0, 2
    new-array v9, v0, [Ljava/lang/String;
    const/16 v17, 0
    aput-object v27, v9, v17
    invoke-static/range v26, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 64
    const/16 v18, 0
    move-object/from16 v0, v20
    move-object/from16 v1, v26
    move-object/from16 v19, v14
    move-object v14, v9
    move-object/from16 v9, v18
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveSubTaskFailureMessage$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function4; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 1
    aput-object v0, v14, v1
    invoke-direct v10, v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    if-nez v16, +063h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "]: skip-duplicate taskId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " durationMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-wide/from16 v5, v24
    invoke-virtual v1, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " errorCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object/from16 v4, v26
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " resultLen="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v23, Ljava/lang/String;->length()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " errorLen="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v7, +006h
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v17
    move/from16 v2, v17
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v2, v19
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-wide/from16 v5, v24
    move-object/from16 v4, v26
    sget-object v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v14, 0
    const/16 v16, 0
    new-instance v17, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;
    const/4 v9, 0
    move-object/from16 v0, v17
    move-object v1, v15
    move-object/from16 v2, v23
    move-object/from16 v3, v22
    move-object/from16 v8, v28
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v0, v17
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v1, 3
    const/4 v2, 0
    move-object/from16 v21, v13
    move-object/from16 v22, v14
    move-object/from16 v23, v16
    move-object/from16 v24, v0
    move/from16 v25, v1
    move-object/from16 v26, v2
    invoke-static/range v21 ... v26, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method static synthetic postSubTaskResultOnceAsync$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 16
    if-eqz v0, +006h
    const-string v0, ""
    move-object v7, v0
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v0, v19, 32
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v17
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-wide v5, v14
    move-object/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final postToBotLLM(java.lang.String  int)boolean
    .registers 9
    # ins_size=3
    const-string v0, "postToBotLLM: sent, payloadLen="
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "Command"
    const-string v3, "ExternalTextToLLM"
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "Message"
    invoke-virtual v1, v2, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "InterruptMode"
    invoke-virtual v1, v2, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v1, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    const-string v3, "ctrl"
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->buildBinaryMessage(Ljava/lang/String; Ljava/lang/String;)[B
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->sendAckToBot Lkotlin/jvm/functions/Function1;
    const/4 v4, 0
    const-string v5, "VoiceSubTaskCoord"
    if-nez v3, +017h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v0, "postToBotLLM: no callback (P1), would send="
    invoke-direct v8, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v5, v8, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v4
    invoke-interface v3, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", interruptMode="
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v5, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 1
    goto +9h
    move-exception v7
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "postToBotLLM: failed"
    invoke-virtual v8, v5, v0, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return v4
    :try_start_0x46
.end method

.method private final queueSubTaskSupersede(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor  boolean)void
    .registers 30
    # ins_size=5
    move-object/from16 v8, v25
    move-object/from16 v7, v26
    move-object/from16 v6, v27
    move-object/from16 v5, v28
    move/from16 v4, v29
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    const-string v3, "local_sub_task_superseded"
    const-string v2, ", silent="
    const-string v9, "VoiceSubTaskCoord"
    if-eqz v1, +0bbh
    if-eqz v0, +0b9h
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +0abh
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +0a5h
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v10
    const-wide/16 v12, 0
    cmp-long v1, v10, v12
    if-nez v1, +09bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string/jumbo v11, switching[replace-pending]: canceling=
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", oldPending="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v10, ", newPending="
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v10, ", executor="
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v9, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    sget-object v15, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/16 v16, 0
    const-string v17, "local_sub_task_superseded"
    const-wide/16 v18, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 3935
    const/16 v24, 0
    move-object/from16 v9, v26
    invoke-static/range v9 ... v24, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    const-string/jumbo v9, replace-pending
    invoke-direct v8, v0, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->emitParallelTerminal(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String;)V
    const-string v2, "failed"
    const-string v10, "local_sub_task_superseded"
    const/4 v12, 0
    const/16 v13, 16
    move-object/from16 v0, v25
    move-object/from16 v1, v26
    move-object v15, v3
    move-object v3, v10
    move v10, v4
    move-object v4, v11
    move-object v11, v5
    move v5, v12
    move-object v12, v6
    move v6, v13
    move-object v13, v7
    move-object v7, v14
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    if-eqz v10, +00eh
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v8, v0, v1, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->registerUpdateChainAlias(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +4h
    invoke-direct v8, v13, v15, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportClientProxyFailureOnce(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String;)V
    sput-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    sput-object v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-direct v8, v12, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->showPendingTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)V
    return-void 
    move-object v15, v3
    move v10, v4
    move-object v11, v5
    move-object v12, v6
    move-object v13, v7
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v7
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->taskCreateJob Lkotlinx/coroutines/Job;
    sput-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    sput-object v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    sput-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v3, switching[start]: prevId=
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 40
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", "
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "), localTaskId="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", newId="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", newExecutor="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v9, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v25, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    const/4 v0, 0
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v14, 0
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/16 v16, 0
    const-string v17, "local_sub_task_superseded"
    const-wide/16 v18, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 3935
    const/16 v24, 0
    move-object/from16 v9, v26
    move-object v10, v0
    move-object v5, v11
    move-object v11, v1
    move-object v1, v12
    move-object v12, v2
    move-object v2, v13
    move-object v13, v3
    move-object v3, v15
    move-object v15, v4
    invoke-static/range v9 ... v24, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    const-string v9, "cancel-previous"
    invoke-direct v8, v0, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->emitParallelTerminal(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String;)V
    const-string v4, "failed"
    const-string v10, "local_sub_task_superseded"
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 16
    move-object/from16 v0, v25
    move-object v15, v1
    move-object/from16 v1, v26
    move-object v2, v4
    move-object v4, v3
    move-object v3, v10
    move-object v10, v4
    move-object v4, v11
    move-object v11, v5
    move v5, v12
    move-object v12, v6
    move v6, v13
    move-object v13, v7
    move-object v7, v14
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    if-eqz v29, +00ch
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-direct v8, v13, v0, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->registerUpdateChainAlias(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object/from16 v0, v26
    goto +6h
    move-object/from16 v0, v26
    invoke-direct v8, v0, v10, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportClientProxyFailureOnce(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v8, v15, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->showPendingTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v1, +006h
    const/4 v3, 1
    invoke-static v1, v2, v3, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v15, 0
    const/16 v16, 0
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;
    invoke-direct v1, v0, v12, v13, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lkotlinx/coroutines/Job; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v17, v1
    check-cast v17, Lkotlin/jvm/functions/Function2;
    const/16 v18, 3
    const/16 v19, 0
    invoke-static/range v14 ... v19, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method static synthetic queueSubTaskSupersede$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor  boolean  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->queueSubTaskSupersede(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Z)V
    return-void 
.end method

.method private final readStringProperty(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    if-eqz v3, +024h
    invoke-virtual v3, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +01eh
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v4
    if-nez v4, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +014h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00eh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +003h
    goto +2h
    move-object v3, v0
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0x1
.end method

.method private final registerCancelWaiter(java.lang.String  java.lang.String)kotlinx.coroutines.CompletableDeferred
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterLock Ljava/lang/Object;
    monitor-enter v0
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    move v1, v2
    if-nez v1, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterSourceToLocal Ljava/util/Map;
    invoke-interface v1, v5, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiters Ljava/util/Map;
    invoke-interface v5, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +00ah
    const/4 v1, 0
    invoke-static v1, v2, v1, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v1
    invoke-interface v5, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CompletableDeferred;
    monitor-exit v0
    return-object v1
    move-exception v4
    monitor-exit v0
    throw v4
    :try_start_0x3
.end method

.method static synthetic registerCancelWaiter$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.String  int  java.lang.Object)kotlinx.coroutines.CompletableDeferred
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->registerCancelWaiter(Ljava/lang/String; Ljava/lang/String;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v0
    return-object v0
.end method

.method private final registerUpdateChainAlias(java.lang.String  java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultAliasLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultTaskIdAlias Ljava/util/Map;
    invoke-interface v1, v6, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +003h
    move-object v2, v6
    invoke-interface v1, v7, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "VoiceSubTaskCoord"
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, updateChain[
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v3, "]: newTaskId="
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, " reportAs="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", prevId="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, " silent"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v6
    monitor-exit v0
    throw v6
    :try_start_0x3
.end method

.method private final rejectIfPrecheckFailed(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor)boolean
    .registers 16
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const/4 v1, 0
    if-eq v15, v0, +003h
    return v1
    invoke-direct v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->evaluatePrechecks()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "precheck-reject: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", executor="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v15
    const-string v1, ", code="
    invoke-virtual v15, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    const-string v1, "VoiceSubTaskCoord"
    invoke-virtual v0, v1, v15, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    const-string v4, "failed"
    const-string v5, ""
    const-wide/16 v6, 0
    const/4 v9, 0
    const-string v10, "precheck-reject"
    const/16 v11, 32
    const/4 v12, 0
    move-object v2, v13
    invoke-static/range v2 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    const/4 v14, 1
    return v14
.end method

.method public static synthetic release$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  boolean  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +003h
    const/4 v1, 0
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const-string v2, "released"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->release(Z Ljava/lang/String;)V
    return-void 
.end method

.method private final rememberMetricsRoom(java.lang.String)void
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +004h
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->latestRoomIdForMetrics Ljava/lang/String;
    return-void 
.end method

.method private final removeCancelWaiterInternal(java.lang.String)kotlinx.coroutines.CompletableDeferred
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterSourceToLocal Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda4;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$$ExternalSyntheticLambda4;-><init>(Ljava/lang/String;)V
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->removeAll(Ljava/lang/Iterable; Lkotlin/jvm/functions/Function1;)Z
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiters Ljava/util/Map;
    invoke-interface v0, v3, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lkotlinx/coroutines/CompletableDeferred;
    return-object v3
.end method

.method private static final removeCancelWaiterInternal$lambda$16(java.lang.String  java.util.Map$Entry)boolean
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method private final removeCancelWaiterLocked(java.lang.String)kotlinx.coroutines.CompletableDeferred
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->removeCancelWaiterInternal(Ljava/lang/String;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v3
    monitor-exit v0
    return-object v3
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x3
.end method

.method private final replaceSwitchingPending(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor)void
    .registers 29
    # ins_size=4
    move-object/from16 v0, v25
    move-object/from16 v15, v27
    move-object/from16 v14, v28
    sget-object v17, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, switching[replace-pending-active]: canceling=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", oldPending="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v18, 0
    if-eqz v17, +007h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    goto +3h
    move-object/from16 v3, v18
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", newPending="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", executor="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "VoiceSubTaskCoord"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v13, replace-pending-active
    if-eqz v26, +036h
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v8, 0
    const-string v9, "local_sub_task_superseded"
    const-wide/16 v10, 0
    const/16 v16, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 3935
    const/16 v22, 0
    move-object/from16 v1, v26
    move-object/from16 v23, v12
    move/from16 v12, v16
    move-object/from16 v24, v13
    move-object/from16 v13, v19
    move-object/from16 v14, v20
    move/from16 v15, v21
    move-object/from16 v16, v22
    invoke-static/range v1 ... v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v1
    move-object/from16 v2, v23
    move-object/from16 v3, v24
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->emitParallelTerminal(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String;)V
    goto +2h
    move-object v3, v13
    if-eqz v26, +008h
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +00ah
    if-eqz v17, +006h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v18
    move-object/from16 v1, v18
    if-eqz v1, +009h
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->registerUpdateChainAlias(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object/from16 v1, v27
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-object/from16 v2, v28
    sput-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->showPendingTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)V
    return-void 
.end method

.method private final reportClientProxyFailureOnce(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.lang.String  java.lang.String)void
    .registers 20
    # ins_size=4
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-eq v0, v1, +003h
    return-void 
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v1, v1, v3
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +011h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long/2addr v5, v0
    invoke-static v5, v6, v3, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v3
    move-wide v9, v3
    const-string v2, "failed"
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 16
    const/4 v7, 0
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object/from16 v3, v18
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    const-string v0, "local_sub_task_superseded"
    move-object/from16 v1, v18
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, 该任务已被用户的最新需求取代，由客户端主动取消，属于正常的任务切换，不是执行失败；更新后的新任务正在启动中。请不要向用户播报任务失败，简短确认正在按新需求处理即可。
    goto +3h
    const-string v0, ""
    move-object v8, v0
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    const-string v7, "failed"
    const/4 v12, 0
    const/16 v14, 32
    const/4 v15, 0
    move-object/from16 v5, v16
    move-object/from16 v11, v18
    move-object/from16 v13, v19
    invoke-static/range v5 ... v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final reportLocalSubtaskEnd(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.lang.String  java.lang.String  java.lang.Long  boolean)void
    .registers 21
    # ins_size=6
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-eq v0, v1, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricEndedTaskIds Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 1
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-virtual v1, v2, v3, Ljava/util/concurrent/ConcurrentHashMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-eqz v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricStartedAtMs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Long;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricFileCounts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Integer;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    goto +2h
    const/4 v2, 0
    move v13, v2
    const-wide/16 v2, 0
    if-nez v1, +00dh
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v4
    cmp-long v4, v4, v2
    if-gtz v4, +005h
    if-nez v19, +003h
    return-void 
    if-eqz v19, +008h
    invoke-virtual/range v19, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    move-wide v11, v1
    goto +2dh
    if-eqz v1, +016h
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v4
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sub-long/2addr v6, v4
    invoke-static v6, v7, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    goto -1fh
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v6
    sub-long/2addr v4, v6
    invoke-static v4, v5, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v1
    goto -2dh
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getVoiceConversationId()Ljava/lang/String;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->latestRoomIdForMetrics Ljava/lang/String;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v8
    move-object/from16 v9, v17
    move-object/from16 v10, v18
    move/from16 v14, v20
    invoke-virtual/range v3 ... v14, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportSubtaskEnd(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J I Z)V
    return-void 
.end method

.method static synthetic reportLocalSubtaskEnd$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.lang.String  java.lang.String  java.lang.Long  boolean  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 16
    if-eqz v12, +003h
    const/4 v11, 0
    move v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z)V
    return-void 
.end method

.method private final reportLocalSubtaskStart(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)void
    .registers 12
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    if-nez v0, +003h
    return-void 
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    const/4 v1, 0
    move-object v7, v1
    if-nez v7, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricStartedAtMs Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/Map;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-interface v1, v7, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricFileCounts Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/Map;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v3
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v1, v7, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricEndedTaskIds Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v7, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getVoiceConversationId()Ljava/lang/String;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->latestRoomIdForMetrics Ljava/lang/String;
    if-nez v0, +006h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v0
    move-object v6, v0
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v11
    if-eqz v11, +008h
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v11
    move v9, v11
    goto +2h
    move v9, v3
    move-object v3, v1
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->reportSubtaskStart(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method private final resolveAgentErrorDataType(com.google.gson.JsonObject)java.lang.String
    .registers 4
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    if-eqz v3, +01dh
    const-string/jumbo v1, type
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +014h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00eh
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0x1
.end method

.method private final resolveAgentErrorDisplayMessage(int  java.lang.String  com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 15
    # ins_size=5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    const-string v0, "getResources(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const/4 v7, 0
    const/16 v8, 32
    const/4 v9, 0
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->displayMessage$default(Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry; Landroid/content/res/Resources; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->getMessage()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    goto +ch
    move-exception v11
    sget-object v12, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v12
    const/4 v13, 0
    if-eqz v12, +003h
    move-object v11, v13
    check-cast v11, Ljava/lang/String;
    if-eqz v11, +00eh
    move-object v12, v11
    check-cast v12, Ljava/lang/CharSequence;
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    xor-int/lit8 v12, v12, 1
    if-eqz v12, +003h
    move-object v13, v11
    return-object v13
    :try_start_0x0
.end method

.method private final resolveLocalSubTaskErrorMessage(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    if-eqz v3, +03eh
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    const v1, -1191786997
    if-eq v0, v1, +026h
    const v1, 430710010
    if-eq v0, v1, +018h
    const v1, 784373497
    if-eq v0, v1, +003h
    goto +29h
    const-string v0, "container_not_ready"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +20h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_storage_error I
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->localizedString(I)Ljava/lang/String;
    move-result-object v3
    goto +1ah
    const-string v0, "device_offline"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00bh
    goto +10h
    const-string v0, "2900101"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +009h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->localizedString(I)Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    return-object v3
.end method

.method private final resolveParentConversationIdForSubTask(com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +014h
    if-ne v2, v4, +00ah
    iget-object v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v7
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-eq v7, v2, +003h
    return-object v3
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +011h
    move-object v2, v7
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v4
    if-eqz v2, +003h
    goto +2h
    move-object v7, v3
    if-eqz v7, +003h
    return-object v7
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentCreateJob Lkotlinx/coroutines/Job;
    if-eqz v7, +00dh
    iput-object v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;->label I
    invoke-interface v7, v0, Lkotlinx/coroutines/Job;->join(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +011h
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v4
    if-eqz v0, +003h
    goto +2h
    move-object v7, v3
    if-eqz v7, +003h
    return-object v7
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getParentConversationId()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +00dh
    move-object v7, v6
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    xor-int/2addr v7, v4
    if-eqz v7, +003h
    move-object v3, v6
    return-object v3
.end method

.method private final resolveReportTaskId(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultAliasLock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultTaskIdAlias Ljava/util/Map;
    invoke-interface v1, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +003h
    goto +2h
    move-object v3, v1
    monitor-exit v0
    return-object v3
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x3
.end method

.method public static synthetic resolveSubTaskFailureMessage$conversation_mainlandRelease$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  java.lang.String  java.lang.Integer  java.lang.String  com.google.gson.JsonObject  java.lang.String  java.lang.String  kotlin.jvm.functions.Function4  int  java.lang.Object)java.lang.String
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 64
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v16
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object v7, v15
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveSubTaskFailureMessage$conversation_mainlandRelease(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function4;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final resolveToolResultFailureReason(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)java.lang.String
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getError()Ljava/lang/String;
    move-result-object v5
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v5, +00dh
    move-object v3, v5
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, +003h
    goto +2h
    move-object v5, v2
    if-eqz v0, +00ch
    const-string/jumbo v3, success
    invoke-static v0, v3, v1, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v3
    if-nez v3, +003h
    goto +2h
    const/4 v1, 0
    if-nez v1, +005h
    if-nez v5, +003h
    return-object v2
    if-nez v5, +008h
    if-nez v0, +007h
    const-string/jumbo v0, task_result_failed
    goto +2h
    move-object v0, v5
    return-object v0
.end method

.method private final shouldFailPendingClientProxyTask(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  com.bytedance.trae.conversation.voice.subtask.ToolResultMessage  java.lang.String)boolean
    .registers 9
    # ins_size=4
    const/4 v0, 0
    if-nez v8, +003h
    return v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v8
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-eq v8, v1, +003h
    return v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +0c9h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v8, v1, v3
    if-eqz v8, +004h
    goto/16 +0bdh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v1, task_create
    const/4 v2, 1
    invoke-static v8, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v8
    if-nez v8, +003h
    return v0
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    const-string v1, "VoiceSubTaskCoord"
    if-eqz v8, +033h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +029h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleToolResult[skip-superseded-echo]: msgId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v2, " is the task being canceled for supersede, keep pending currId="
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v8, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-direct v5, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isSubTaskResultReported(Ljava/lang/String;)Z
    move-result v8
    if-eqz v8, +029h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleToolResult[skip-self-reported-echo]: msgId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v2, " terminal already reported by client itself, keep pending currId="
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v8, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-direct v5, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveReportTaskId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +033h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +029h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleToolResult[skip-update-chain-echo]: msgId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v2, " is the silenced origin of update chain, keep pending currId="
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v8, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v0
    return v2
    return v0
.end method

.method private final shouldSuppressCreateTaskBizError(java.lang.String  long)boolean
    .registers 6
    # ins_size=4
    const-wide/32 v0, 995000
    cmp-long v4, v4, v0
    const/4 v5, 0
    if-eqz v4, +003h
    return v5
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressLock Ljava/lang/Object;
    monitor-enter v4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v0, v3, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    move-result v0
    monitor-exit v4
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveReportTaskId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    const/4 v4, 1
    xor-int/2addr v3, v4
    if-nez v0, +004h
    if-eqz v3, +003h
    move v5, v4
    return v5
    move-exception v3
    monitor-exit v4
    throw v3
    :try_start_0xc
.end method

.method private final showPendingTask(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor)void
    .registers 24
    # ins_size=3
    move-object/from16 v12, v23
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    sget-object v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const/4 v6, 0
    if-ne v12, v5, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v6
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v12, v0, +003h
    move-object v6, v1
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Creating Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v8, 0
    const/4 v9, 0
    const-wide/16 v10, 0
    const/4 v13, 0
    const/16 v16, 0
    const/16 v17, 3012
    const/16 v18, 0
    move-object v0, v14
    move-object v1, v2
    move-object v2, v3
    move-object v3, v4
    move-object v4, v5
    move-object v5, v6
    move-object v6, v7
    move-object v7, v8
    move-object v8, v9
    move-wide v9, v10
    move v11, v13
    move-object/from16 v12, v23
    move-object/from16 v13, v16
    move-object/from16 v19, v14
    move/from16 v14, v17
    move-object/from16 v20, v15
    move-object/from16 v15, v18
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v1, v19
    move-object/from16 v0, v20
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v1, v21
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startLongRunningJob(Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->start(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final startClientProxyTask(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)void
    .registers 26
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Ljava/lang/String;
    const-string v15, "VoiceSubTaskCoord"
    if-nez v0, +01ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, startClientProxyTask[drop-config-not-ready]: taskId=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Creating Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const/16 v16, 0
    sget-object v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const/16 v18, 0
    const/16 v19, 3012
    const/16 v20, 0
    move-object v2, v13
    move-object v6, v1
    move-object/from16 v21, v13
    move/from16 v13, v16
    move-object/from16 v22, v14
    move-object/from16 v14, v17
    move-object/from16 v23, v15
    move-object/from16 v15, v18
    move/from16 v16, v19
    move-object/from16 v17, v20
    invoke-direct/range v2 ... v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v3, v21
    move-object/from16 v2, v22
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct/range v24 ... v25, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskStart(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, startClientProxyTask: taskId=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", proxyConvId="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", timeoutMs="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v4, v23
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v3, v24
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startLongRunningJob(Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->taskCreateJob Lkotlinx/coroutines/Job;
    const/4 v4, 0
    if-eqz v2, +006h
    const/4 v5, 1
    invoke-static v2, v4, v5, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startClientProxyTask$1;
    move-object/from16 v5, v25
    invoke-direct v2, v0, v1, v5, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startClientProxyTask$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lkotlin/coroutines/Continuation;)V
    move-object v9, v2
    check-cast v9, Lkotlin/jvm/functions/Function2;
    const/4 v10, 3
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->taskCreateJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startLongRunningJob(java.lang.String)void
    .registers 8
    # ins_size=2
    invoke-direct v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;
    const/4 v4, 0
    invoke-direct v3, v7, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v7
    sput-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->longRunningJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startServerClosedLoopTask(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)void
    .registers 22
    # ins_size=2
    move-object/from16 v0, v20
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v15, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Thinking Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    sget-object v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const/16 v16, 0
    const/16 v17, 3036
    const/16 v18, 0
    move-object v2, v15
    move-object/from16 v19, v15
    move-object/from16 v15, v16
    move/from16 v16, v17
    move-object/from16 v17, v18
    invoke-direct/range v2 ... v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v2, v19
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startLongRunningJob(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v1
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startTimer(J Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, startServerClosedLoopTask: task_id=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", timeoutMs="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "VoiceSubTaskCoord"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final startTaskStartUi(com.bytedance.trae.conversation.voice.subtask.TaskStartMessage)void
    .registers 22
    # ins_size=2
    move-object/from16 v0, v20
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v15, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    const-string v4, ""
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Thinking Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    sget-object v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v16
    const/16 v17, 988
    const/16 v18, 0
    move-object v2, v15
    move-object/from16 v19, v15
    move-object/from16 v15, v16
    move/from16 v16, v17
    move-object/from16 v17, v18
    invoke-direct/range v2 ... v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v2, v19
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startLongRunningJob(Ljava/lang/String;)V
    const-wide/32 v1, 600000
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startTimer(J Ljava/lang/String;)V
    return-void 
.end method

.method private final startTimer(long  java.lang.String)void
    .registers 13
    # ins_size=4
    invoke-direct v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, startTimer: sourceTaskId=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", timeoutMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v10, v11, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "VoiceSubTaskCoord"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startTimer$1;
    const/4 v1, 0
    invoke-direct v0, v10, v11, v12, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startTimer$1;-><init>(J Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    sput-object v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->timeoutJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final streamingListener$lambda$1(com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 37
    # ins_size=2
    move-object/from16 v1, v35
    const-string v0, "message"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v0
    const/4 v2, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    sget-object v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-direct v13, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isTerminalStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v14
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    const/16 v16, 1
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    const/4 v4, 0
    goto +3h
    move/from16 v4, v16
    const-string v12, ", isHistory="
    const-string v11, ", status="
    const-string v10, "VoiceSubTaskCoord"
    if-nez v4, +06ah
    invoke-direct v13, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->hasCancelWaiter(Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +064h
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "cancelForReuse[streaming-frame]: localTaskId="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", errorCode="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v6
    goto +2h
    move-object v6, v2
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", errorMsg="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v2
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", terminal="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v14, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v10, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    const/4 v3, 0
    goto +3h
    move/from16 v3, v16
    if-nez v3, +02bh
    if-eqz v14, +029h
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v6
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v3
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v3
    move-object v7, v3
    goto +2h
    move-object v7, v2
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v3
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v3
    move-object v8, v3
    goto +2h
    move-object v8, v2
    move-object v3, v13
    move-object v4, v0
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->completeCancelWaiterIfNeeded(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v9, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object/from16 v33, v3
    check-cast v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v33, +003h
    return-void 
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-eq v3, v4, +003h
    return-void 
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v13, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->extractContent(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v0
    if-eqz v14, +023h
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    const-string v4, "completed"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +014h
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    const-string v4, "in_progress"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00bh
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    goto +5h
    if-eqz v14, +006h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-object v8, v3
    goto +16h
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +005h
    move/from16 v3, v16
    goto +2h
    const/4 v3, 0
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Streaming Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    goto -13h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Thinking Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    goto -16h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-ne v8, v3, +071h
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +062h
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v3
    if-eqz v3, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v3
    if-eqz v3, +008h
    invoke-virtual v3, Ljava/lang/Integer;->toString()Ljava/lang/String;
    move-result-object v3
    move-object v4, v3
    goto +2h
    move-object v4, v2
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v3
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v3
    move-object v5, v3
    goto +2h
    move-object v5, v2
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v3
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v3
    move-object v6, v3
    goto +2h
    move-object v6, v2
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    move-object v7, v2
    const/4 v2, 0
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v17
    const/16 v18, 0
    const/16 v19, 64
    const/16 v20, 0
    move-object v3, v13
    move-object/from16 v36, v8
    move-object v8, v2
    move-object v2, v9
    move-object/from16 v9, v17
    move-object v15, v10
    move-object/from16 v10, v18
    move-object/from16 v34, v11
    move/from16 v11, v19
    move-object v1, v12
    move-object/from16 v12, v20
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveSubTaskFailureMessage$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function4; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +005h
    const-string/jumbo v3, task_failed
    move-object v11, v3
    move-object v3, v2
    goto +12h
    move-object/from16 v36, v8
    move-object v15, v10
    move-object/from16 v34, v11
    move-object v1, v12
    move-object v11, v3
    move-object v3, v9
    goto +9h
    move-object/from16 v36, v8
    move-object v3, v9
    move-object v15, v10
    move-object/from16 v34, v11
    move-object v1, v12
    move-object v11, v2
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +005h
    move/from16 v4, v16
    goto +2h
    const/4 v4, 0
    if-eqz v4, +005h
    move-object/from16 v24, v0
    goto +7h
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getContent()Ljava/lang/String;
    move-result-object v4
    move-object/from16 v24, v4
    const-wide/16 v26, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 3871
    const/16 v32, 0
    move-object/from16 v17, v33
    move-object/from16 v23, v36
    move-object/from16 v25, v11
    invoke-static/range v17 ... v32, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v4
    invoke-interface v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    if-eqz v14, +0f1h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, streamingListener[sse-terminal]: sourceTaskId=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", next="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v5, v36
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v6, v34
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v35, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", contentLen="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +005h
    move/from16 v4, v16
    goto +2h
    const/4 v4, 0
    if-eqz v4, +007h
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v4
    goto +9h
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getContent()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    invoke-direct v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v3
    const-wide/16 v6, 0
    cmp-long v1, v3, v6
    if-lez v1, +00dh
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v6
    sub-long/2addr v3, v6
    move-wide v14, v3
    goto +2h
    move-wide v14, v6
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-ne v5, v1, +039h
    const-string/jumbo v5, success
    const-string v6, ""
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 16
    const/4 v10, 0
    move-object v3, v13
    move-object/from16 v4, v33
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +003h
    goto +3h
    const/16 v16, 0
    if-eqz v16, +003h
    goto +5h
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getContent()Ljava/lang/String;
    move-result-object v0
    move-object v6, v0
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, success
    const/4 v9, 0
    const/4 v10, 0
    const-string/jumbo v11, sse-terminal-success
    const/16 v12, 48
    const/4 v0, 0
    move-object v3, v13
    move-wide v7, v14
    move-object v13, v0
    invoke-static/range v3 ... v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +37h
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    move-object/from16 v1, v35
    move-object v2, v11
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildSseFailureReport$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Lkotlin/jvm/functions/Function4; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    move-result-object v0
    const-string v5, "failed"
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 16
    const/4 v10, 0
    move-object v3, v13
    move-object/from16 v4, v33
    move-object v6, v11
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    const-string v5, "failed"
    if-nez v11, +006h
    const-string v1, ""
    move-object v6, v1
    goto +2h
    move-object v6, v11
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;->getErrorCode()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;->getError()Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v11, sse-terminal-failed
    move-object v3, v13
    move-wide v7, v14
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final awaitParentChatSessionId(kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +010h
    if-ne v2, v4, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    if-eqz v6, +011h
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v4
    if-eqz v2, +003h
    goto +2h
    move-object v6, v3
    if-eqz v6, +003h
    return-object v6
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentCreateJob Lkotlinx/coroutines/Job;
    if-eqz v6, +00bh
    iput v4, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitParentChatSessionId$1;->label I
    invoke-interface v6, v0, Lkotlinx/coroutines/Job;->join(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    if-eqz v6, +00dh
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v4
    if-eqz v0, +003h
    move-object v3, v6
    return-object v3
.end method

.method public final buildCreateTaskFailureReport$conversation_mainlandRelease(com.bytedance.trae.im.service.CreateTaskRawResult  java.lang.String  boolean)com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$CreateTaskFailureReport
    .registers 11
    # ins_size=4
    const-string v0, "raw"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fallbackCode"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v8
    instance-of v0, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v0, +051h
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v8
    if-nez v10, +00eh
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v7, v5, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isCreateTaskBizSuccess$conversation_mainlandRelease(J)Z
    move-result v10
    if-nez v10, +004h
    move v10, v3
    goto +2h
    move v10, v4
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    if-eqz v10, +00bh
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v9
    if-eqz v10, +027h
    const/4 v10, 4
    new-array v10, v10, [Ljava/lang/String;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v1
    aput-object v1, v10, v4
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v1
    aput-object v1, v10, v3
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v1
    aput-object v1, v10, v2
    const/4 v1, 3
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getPayload()Ljava/lang/String;
    move-result-object v8
    aput-object v8, v10, v1
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlankErrorMessage([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +4h
    move-object v9, v8
    goto +2h
    move-object v9, v1
    invoke-direct v0, v5, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    goto +27h
    instance-of v10, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v10, +025h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    new-array v10, v2, [Ljava/lang/String;
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    aput-object v2, v10, v4
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v8
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    aput-object v1, v10, v3
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v9
    invoke-direct v0, v9, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
.end method

.method public final buildNotifyAttachmentParts$conversation_mainlandRelease(java.util.List  java.lang.String)java.util.List
    .registers 11
    # ins_size=3
    const-string v0, "items"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    if-eqz v10, +00eh
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v10, v0
    check-cast v9, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v9, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +048h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->getUseImageUpload()Z
    move-result v2
    if-eqz v2, +015h
    sget-object v2, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->getUploadedRef()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->getDisplayName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->getSizeBytes()J
    move-result-wide v5
    invoke-virtual v2, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->imageUri(Ljava/lang/String; Ljava/lang/String; J)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v1
    goto +24h
    sget-object v2, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, trae-res://remote_resource/
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->getUploadedRef()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->getDisplayName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->getSizeBytes()J
    move-result-wide v5
    move-object v7, v10
    invoke-virtual/range v2 ... v7, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->attachment(Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -4bh
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public final buildNotifyAttachmentQueryJson$conversation_mainlandRelease(java.util.List  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    const-string v0, "items"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildNotifyAttachmentParts$conversation_mainlandRelease(Ljava/util/List; Ljava/lang/String;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, toJson(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public final buildSseFailureReport$conversation_mainlandRelease(com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String  kotlin.jvm.functions.Function4)com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$CreateTaskFailureReport
    .registers 15
    # ins_size=4
    const-string v0, "message"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +01dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +017h
    invoke-virtual v0, Ljava/lang/Integer;->toString()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +011h
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +003h
    goto +16h
    const/4 v0, 2
    new-array v0, v0, [Ljava/lang/String;
    const/4 v3, 0
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v4
    aput-object v4, v0, v3
    aput-object v13, v0, v1
    invoke-direct v11, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +005h
    const-string/jumbo v0, task_failed
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v1
    move-object v5, v1
    goto +2h
    move-object v5, v2
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    goto +2h
    move-object v6, v2
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    move-object v7, v2
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v9
    move-object v3, v11
    move-object v4, v0
    move-object v8, v13
    move-object v10, v14
    invoke-virtual/range v3 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveSubTaskFailureMessage$conversation_mainlandRelease(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function4;)Ljava/lang/String;
    move-result-object v12
    if-nez v12, +003h
    move-object v12, v0
    new-instance v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;
    invoke-direct v13, v0, v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v13
.end method

.method public final buildSubTaskCustomModel$conversation_mainlandRelease(com.google.gson.JsonObject)com.google.gson.JsonObject
    .registers 7
    # ins_size=2
    const/4 v0, 0
    if-nez v6, +003h
    return-object v0
    invoke-virtual v6, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v6
    invoke-virtual v6, Lcom/google/gson/JsonObject;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v6
    const-string v1, "name"
    invoke-direct v5, v6, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->readStringProperty(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 1
    if-eqz v1, +00dh
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    move-object v0, v1
    const/4 v1, 0
    if-eqz v0, +01eh
    const-string v3, "config_name"
    invoke-virtual v6, v3, v0, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v3, "model_name"
    invoke-direct v5, v6, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->readStringProperty(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00ah
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move v2, v1
    if-eqz v2, +005h
    invoke-virtual v6, v3, v0, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v0, "is_preset"
    invoke-virtual v6, v0, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +00ch
    invoke-virtual v6, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v2
    if-eqz v2, +009h
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v6, v0, v1, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/Boolean;)V
    return-object v6
.end method

.method public final buildSubTaskQueryJson$conversation_mainlandRelease(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)java.lang.String
    .registers 3
    # ins_size=2
    const-string/jumbo v0, req
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildSubTaskQueryParts$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toJson(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public final buildSubTaskQueryParts$conversation_mainlandRelease(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage)java.util.List
    .registers 5
    # ins_size=2
    const-string/jumbo v0, req
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +00fh
    sget-object v1, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->text(Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->normalizeSubTaskFilesForCreate$conversation_mainlandRelease(Ljava/util/List;)Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-interface v0, v4, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    return-object v0
.end method

.method public final calculateCreateTaskRetryDelayMs$conversation_mainlandRelease(int  long)java.lang.Long
    .registers 8
    # ins_size=4
    const/16 v0, 15
    const/4 v1, 0
    if-lt v5, v0, +003h
    return-object v1
    const-wide/32 v2, 300000
    sub-long/2addr v2, v6
    const-wide/16 v6, 0
    cmp-long v6, v2, v6
    if-gtz v6, +003h
    return-object v1
    const/16 v6, 30
    invoke-static v5, v6, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v5
    const-wide/16 v6, 1
    shl-long v5, v6, v5
    const-wide/16 v0, 5000
    mul-long/2addr v5, v0
    const-wide/32 v0, 60000
    invoke-static v0, v1, v2, v3, Ljava/lang/Math;->min(J J)J
    move-result-wide v0
    invoke-static v5, v6, v0, v1, Ljava/lang/Math;->min(J J)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    return-object v5
.end method

.method public final cancelActiveTask(java.lang.String  boolean)void
    .registers 31
    # ins_size=3
    move-object/from16 v15, v29
    move/from16 v14, v30
    const-string v0, "reason"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v13, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v16, v0
    check-cast v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v16, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v1, v1, v3
    const/16 v17, 1
    const/16 v18, 0
    if-lez v1, +005h
    move/from16 v1, v17
    goto +3h
    move/from16 v1, v18
    const/4 v12, 0
    if-eqz v1, +003h
    goto +2h
    move-object v0, v12
    if-eqz v0, +014h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long/2addr v5, v0
    invoke-static v5, v6, v3, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v0
    move-wide/from16 v19, v0
    goto +3h
    move-wide/from16 v19, v3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "cancelActiveTask: sourceTaskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", prev="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", executor="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", reason="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", reportClientProxyResult="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v11, "VoiceSubTaskCoord"
    invoke-virtual v0, v11, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v28, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    invoke-direct/range v28, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v7, 0
    const-wide/16 v9, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 3935
    const/16 v25, 0
    move-object/from16 v0, v16
    move-object/from16 v8, v29
    move-object/from16 v26, v11
    move/from16 v11, v21
    move-object/from16 v12, v22
    move-object/from16 v27, v13
    move-object/from16 v13, v23
    move/from16 v14, v24
    move-object/from16 v15, v25
    invoke-static/range v0 ... v15, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    move-object/from16 v1, v27
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    const-string v2, "failed"
    const/4 v5, 0
    const/16 v6, 16
    move-object/from16 v0, v28
    move-object/from16 v1, v16
    move-object/from16 v3, v29
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-eq v0, v1, +029h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "cancelActiveTask: skip remote cancel (executor="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "), reason="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object/from16 v11, v29
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v12, v26
    invoke-virtual v0, v12, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object/from16 v11, v29
    move-object/from16 v12, v26
    if-eqz v30, +026h
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    const-string v2, "failed"
    const-string v3, ""
    const/4 v7, 0
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v4, "cancel-active-"
    invoke-direct v0, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const/16 v9, 32
    const/4 v10, 0
    move-object/from16 v0, v28
    move-wide/from16 v4, v19
    move-object/from16 v6, v29
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getProxyConversationId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v1
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00ch
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +4h
    move/from16 v2, v18
    goto +3h
    move/from16 v2, v17
    if-nez v2, +025h
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move/from16 v17, v18
    if-eqz v17, +003h
    goto +13h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelActiveTask$1;
    const/4 v6, 0
    invoke-direct v5, v0, v1, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$cancelActiveTask$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "cancelActiveTask: skip remote cancel (no localTaskId), reason="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v12, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final createTaskRequest$conversation_mainlandRelease(com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Source  com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig  boolean)com.bytedance.trae.im.service.CreateTaskRequest
    .registers 42
    # ins_size=9
    move-object/from16 v0, v33
    move-object/from16 v1, v40
    const-string v2, "cfg"
    move-object/from16 v3, v34
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v34, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveSubTaskModelConfig$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig; Lcom/bytedance/trae/im/service/Mode;)Lcom/google/gson/JsonObject;
    move-result-object v2
    const-string v4, "name"
    const/4 v5, 0
    if-nez v2, +05bh
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "createTaskRequest: sub_task_config.models missing current mode="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v34, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", available="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    if-eqz v1, +030h
    invoke-virtual/range v40, Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;->getModels()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +02ah
    check-cast v1, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/google/gson/JsonObject;
    sget-object v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-direct v10, v9, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->readStringProperty(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    if-eqz v9, -012h
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v8, Ljava/util/List;
    goto +2h
    move-object v8, v5
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v7, "VoiceSubTaskCoord"
    invoke-virtual v6, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v0, v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->readStringProperty(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const/4 v4, 1
    if-eqz v1, +00eh
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v4
    if-eqz v6, +004h
    move-object v10, v1
    goto +2h
    move-object v10, v5
    if-nez v10, +005h
    sget-object v1, Lcom/bytedance/trae/im/service/ModelSelectionStrategy;->AUTO Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/im/service/ModelSelectionStrategy;->MANUAL Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    move-object v13, v1
    invoke-virtual/range v34, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliId()Ljava/lang/String;
    move-result-object v1
    const/4 v6, 0
    if-eqz v1, +015h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +004h
    move v7, v4
    goto +2h
    move v7, v6
    if-eqz v7, +003h
    move-object v1, v5
    check-cast v1, Ljava/lang/String;
    move-object/from16 v19, v1
    goto +3h
    move-object/from16 v19, v5
    invoke-virtual/range v34, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v20
    invoke-virtual/range v34, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v21
    invoke-virtual/range v34, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getWorkspaceDir()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +015h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +004h
    move v7, v4
    goto +2h
    move v7, v6
    if-eqz v7, +003h
    move-object v1, v5
    check-cast v1, Ljava/lang/String;
    move-object/from16 v23, v1
    goto +3h
    move-object/from16 v23, v5
    invoke-virtual/range v34, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getWorkspaceDir()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01ah
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +003h
    goto +2h
    move v4, v6
    if-eqz v4, +003h
    goto +2h
    move-object v1, v5
    if-eqz v1, +009h
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    move-object/from16 v24, v1
    goto +3h
    move-object/from16 v24, v5
    if-eqz v36, +02bh
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildSubTaskCustomModel$conversation_mainlandRelease(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;
    move-result-object v14
    invoke-static v6, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    if-eqz v41, +005h
    move-object/from16 v16, v1
    goto +3h
    move-object/from16 v16, v5
    new-instance v5, Lcom/bytedance/trae/im/service/InitialMessage;
    const/4 v9, 0
    const-string/jumbo v11, voice_chat
    const/4 v15, 0
    const/16 v17, 130
    const/16 v18, 0
    move-object v7, v5
    move-object/from16 v12, v36
    invoke-direct/range v7 ... v18, Lcom/bytedance/trae/im/service/InitialMessage;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ModelSelectionStrategy; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v26, v5
    new-instance v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;
    move-object v14, v1
    const/16 v17, 0
    const/16 v22, 0
    const/16 v25, 0
    const-string v28, "mobile"
    const/16 v29, 0
    const/16 v30, 0
    const v31, 50308
    const/16 v32, 0
    move-object/from16 v15, v35
    move-object/from16 v16, v37
    move-object/from16 v18, v38
    move-object/from16 v27, v39
    invoke-direct/range v14 ... v32, Lcom/bytedance/trae/im/service/CreateTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Z Lcom/bytedance/trae/im/service/InitialMessage; Lcom/bytedance/trae/im/service/Source; Ljava/lang/String; Ljava/util/Map; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method public final getActiveTask()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->activeTask Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getParallelTerminalToolResults()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parallelTerminalToolResults Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getParentChatSessionId()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentChatSessionId Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getParentConversationId()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentConversationId Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getProxyChatSessionId()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->proxyChatSessionId Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getProxyConversationId()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->proxyConversationId Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final handleSubTaskRequest(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  java.lang.String)boolean
    .registers 32
    # ins_size=3
    move-object/from16 v11, v29
    move-object/from16 v2, v30
    move-object/from16 v0, v31
    const-string/jumbo v1, req
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->Companion Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getExecutor()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;->fromProtocol(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    if-nez v0, +007h
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-direct v11, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->rememberMetricsRoom(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "handleSubTaskRequest[enter]: taskId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", executor="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v5, 40
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getExecutor()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, "), descLen="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", files="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v7
    const/16 v28, 0
    if-eqz v7, +007h
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v7
    goto +3h
    move/from16 v7, v28
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", room="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", currentRoom="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", timeoutMs="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v7
    invoke-virtual v4, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v7, "VoiceSubTaskCoord"
    invoke-virtual v1, v7, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-boolean v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v1, +01bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "handleSubTaskRequest[drop-not-started]: taskId="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v28
    const/4 v8, 1
    if-eqz v0, +04ch
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v8
    goto +3h
    move/from16 v1, v28
    if-eqz v1, +03dh
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +033h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "handleSubTaskRequest[drop-room-mismatch]: req="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", current="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", taskId="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v7, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v28
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-eqz v1, +043h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +035h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +029h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "handleSubTaskRequest[drop-terminal-arrived]: taskId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", state="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v1
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v28
    if-eqz v1, +029h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +01bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "handleSubTaskRequest[drop-duplicate]: taskId="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v28
    if-eqz v1, +105h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +0f9h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v0, v4, +019h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v3, v0, +015h
    invoke-direct v11, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->rejectIfPrecheckFailed(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)Z
    move-result v0
    if-eqz v0, +003h
    return v28
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object/from16 v0, v29
    move-object/from16 v2, v30
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->queueSubTaskSupersede$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Z I Ljava/lang/Object;)V
    return v8
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v8, "handleSubTaskRequest[drop-busy]: currId="
    invoke-direct v4, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", "
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, "), dropTaskId="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", dropExecutor="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v4
    if-eqz v4, +007h
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    goto +3h
    move/from16 v4, v28
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", descLen="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, " → emit local Failed(dropped_busy)"
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    sget-object v18, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/16 v19, 0
    const-string v20, "dropped_busy"
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v25, 0
    const/16 v26, 2908
    const/16 v27, 0
    move-object v12, v0
    move-object/from16 v24, v3
    invoke-direct/range v12 ... v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parallelTerminalToolResults Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v4, "handleSubTaskRequest[drop-busy]: parallelTerminal buffer overflow, dropped taskId="
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v3, v0, +019h
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    const-string v2, "failed"
    const-string v3, ""
    const-wide/16 v4, 0
    const-string v6, "dropped_busy"
    const/4 v7, 0
    const-string v8, "drop-busy"
    const/16 v9, 32
    const/4 v10, 0
    move-object/from16 v0, v29
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return v28
    invoke-direct v11, v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->rejectIfPrecheckFailed(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)Z
    move-result v0
    if-eqz v0, +003h
    return v28
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ordinal()I
    move-result v1
    aget v0, v0, v1
    if-eq v0, v8, +00fh
    const/4 v1, 2
    if-ne v0, v1, +006h
    invoke-direct/range v29 ... v30, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startServerClosedLoopTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    return v28
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    invoke-direct/range v29 ... v30, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startClientProxyTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    return v8
.end method

.method public final handleSubTaskUpdate(com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage  java.lang.String)boolean
    .registers 14
    # ins_size=3
    const-string/jumbo v0, req
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->Companion Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getExecutor()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;->fromProtocol(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    if-nez v13, +007h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v13
    invoke-direct v11, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->rememberMetricsRoom(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleSubTaskUpdate[enter]: taskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", executor="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v4, 40
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getExecutor()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, "), descLen="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskDescription()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", files="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getFiles()Ljava/util/List;
    move-result-object v5
    const/4 v6, 0
    if-eqz v5, +007h
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    goto +2h
    move v5, v6
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", room="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", currentRoom="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", timeoutMs="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTimeoutMs()J
    move-result-wide v7
    invoke-virtual v2, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v5, "VoiceSubTaskCoord"
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-boolean v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v1, +01bh
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "handleSubTaskUpdate[drop-not-started]: taskId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v5, v12, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v6
    const/4 v1, 1
    if-eqz v13, +04bh
    move-object v2, v13
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    move v2, v1
    goto +2h
    move v2, v6
    if-eqz v2, +03dh
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +033h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleSubTaskUpdate[drop-room-mismatch]: req="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", current="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v1, ", taskId="
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v5, v12, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v6
    sget-object v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v13, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    const/4 v7, 0
    const-string v8, ", state="
    if-eqz v2, +04bh
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    if-eqz v2, +047h
    if-eqz v13, +006h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +027h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleSubTaskUpdate[drop-same-pending]: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v5, v12, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v6
    invoke-direct v11, v12, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->rejectIfPrecheckFailed(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)Z
    move-result v2
    if-eqz v2, +003h
    return v6
    invoke-direct v11, v13, v12, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->replaceSwitchingPending(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v0, v12, +003h
    move v6, v1
    return v6
    if-eqz v13, +041h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v9
    invoke-static v2, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +033h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleSubTaskUpdate[drop-same-taskId]: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v1
    invoke-virtual v12, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v5, v12, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v6
    invoke-direct v11, v12, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->rejectIfPrecheckFailed(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)Z
    move-result v2
    if-eqz v2, +003h
    return v6
    const/4 v2, 2
    if-eqz v13, +0a5h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v8
    invoke-interface v3, v8, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +099h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    const-string v9, "), newId="
    if-ne v3, v8, +03ah
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v0, v3, +036h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v6, "handleSubTaskUpdate[queue-client-supersede]: prevId="
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v5, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v11, v13, v12, v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->queueSubTaskSupersede(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Z)V
    return v1
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v10, "handleSubTaskUpdate[supersede]: cancel prevId="
    invoke-direct v8, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", "
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v3, v4, +00bh
    invoke-direct v11, v13, v12, v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->queueSubTaskSupersede(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Z)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v0, v12, +003h
    move v6, v1
    return v6
    const-string/jumbo v13, task_update_supersede
    invoke-static v11, v13, v6, v2, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelActiveTask$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Z I Ljava/lang/Object;)V
    sget-object v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ordinal()I
    move-result v0
    aget v13, v13, v0
    if-eq v13, v1, +00eh
    if-ne v13, v2, +006h
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startServerClosedLoopTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    goto +12h
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v13
    invoke-direct v11, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->markCreateTaskRetryableBizErrorSuppressed(Ljava/lang/String;)V
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startClientProxyTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    move v6, v1
    return v6
.end method

.method public final handleTaskStart(com.bytedance.trae.conversation.voice.subtask.TaskStartMessage)void
    .registers 10
    # ins_size=2
    const-string v0, "msg"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    const-string v1, "VoiceSubTaskCoord"
    if-nez v0, +00ah
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "handleTaskStart: ignored, coordinator not started"
    invoke-virtual v9, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v0, +00fh
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v6
    invoke-interface v5, v6, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move v2, v3
    const-string v3, ", tool="
    if-eqz v4, +039h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "handleTaskStart[drop-duplicate]: taskId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", state="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v2, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +0c5h
    const-string v4, "), taskId="
    const/16 v5, 40
    if-eqz v2, +056h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "handleTaskStart[parallel]: currId="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", "
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v0, "; wait task_result for parallel terminal"
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v2, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +6ah
    if-eqz v0, +042h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "handleTaskStart[overwrite-terminal]: prevId="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startTaskStartUi(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    goto +28h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "handleTaskStart[start]: taskId="
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->startTaskStartUi(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    return-void 
.end method

.method public final handleTaskStop(com.bytedance.trae.conversation.voice.subtask.TaskStopMessage  java.lang.String)void
    .registers 31
    # ins_size=3
    move-object/from16 v11, v28
    move-object/from16 v0, v30
    const-string v1, "msg"
    move-object/from16 v6, v29
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleTaskStop[enter]: taskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", room="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", currentRoom="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", timeoutMs="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTimeoutMs()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "VoiceSubTaskCoord"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-boolean v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v1, +01bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleTaskStop[drop-not-started]: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +04bh
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +03dh
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getRoomId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +033h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "handleTaskStop[drop-room-mismatch]: req="
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getRoomId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", current="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", taskId="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v7, v4
    check-cast v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v7, +033h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleTaskStop[ack-no-active]: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, success
    const-string v3, ""
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const-string/jumbo v8, task-stop-no-active
    const/16 v9, 48
    const/4 v10, 0
    move-object/from16 v0, v28
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +012h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move v1, v2
    const/16 v4, 40
    const-string v5, ", active="
    if-nez v1, +04ch
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, "handleTaskStop[task-id-mismatch-cancel-current]: req="
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, "), localTaskId="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", canceling="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v3, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v9
    invoke-interface v8, v9, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +055h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v8, "handleTaskStop[ack-stale-terminal]: taskId="
    invoke-direct v2, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, "), matched="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, success
    const-string v3, ""
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const-string/jumbo v8, task-stop-stale-terminal
    const/16 v9, 48
    const/4 v10, 0
    move-object/from16 v0, v28
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v3
    const-wide/16 v8, 0
    cmp-long v1, v3, v8
    if-lez v1, +00ch
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getCreateStartedAtMs()J
    move-result-wide v8
    sub-long/2addr v3, v8
    move-wide v8, v3
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v1, v3, +055h
    invoke-direct/range v28, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    invoke-direct/range v28, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v11, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearSwitchingPendingForStop(Ljava/lang/String;)V
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    sget-object v18, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/16 v19, 0
    const-string/jumbo v20, task_stop
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 3935
    const/16 v27, 0
    move-object v12, v7
    invoke-static/range v12 ... v27, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    const-string v2, "failed"
    const-string/jumbo v3, task_stop
    const/4 v4, 0
    const/4 v5, 1
    move-object/from16 v0, v28
    move-object v1, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;
    const/4 v1, 0
    move-object v2, v0
    move-object v3, v7
    move-object/from16 v4, v29
    move-wide v5, v8
    move-object v7, v1
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage; J Lkotlin/coroutines/Continuation;)V
    move-object v15, v0
    check-cast v15, Lkotlin/jvm/functions/Function2;
    const/16 v16, 3
    invoke-static/range v12 ... v17, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +2ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-direct v11, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearSwitchingPendingForStop(Ljava/lang/String;)V
    const/4 v0, 2
    const/4 v1, 0
    const-string/jumbo v3, task_stop
    invoke-static v11, v3, v2, v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelActiveTask$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Z I Ljava/lang/Object;)V
    invoke-virtual/range v29, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, success
    const-string v3, ""
    const/4 v6, 0
    const/4 v7, 0
    const-string/jumbo v10, task-stop-server-closed-loop
    const/16 v12, 48
    const/4 v13, 0
    move-object/from16 v0, v28
    move-wide v4, v8
    move-object v8, v10
    move v9, v12
    move-object v10, v13
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final handleToolResult(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage)boolean
    .registers 31
    # ins_size=2
    move-object/from16 v8, v29
    move-object/from16 v9, v30
    const-string v0, "msg"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    const/4 v10, 0
    const-string v1, "VoiceSubTaskCoord"
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "handleToolResult: ignored, coordinator not started"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v10
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-direct v8, v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->completeCancelWaiterBySourceTaskId(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v29 ... v30, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveToolResultFailureReason(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getResult()Ljava/lang/String;
    move-result-object v3
    const-string v4, ""
    if-nez v3, +005h
    move-object/from16 v18, v4
    goto +3h
    move-object/from16 v18, v3
    if-nez v0, +005h
    const-string v3, "Done"
    goto +16h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "Failed("
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v5, 41
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-eqz v7, +012h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +004h
    const/4 v11, 1
    goto +2h
    move v11, v10
    if-eqz v7, +010h
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->IN_FLIGHT_STATES Ljava/util/Set;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v13
    invoke-interface v12, v13, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +004h
    const/4 v12, 1
    goto +2h
    move v12, v10
    const-string v13, ", status="
    const-string v14, ", resultLen="
    const-string v15, ", executor="
    const-string v10, ", terminal="
    const-string v6, ", tool="
    if-eqz v11, +0d7h
    if-eqz v12, +0d5h
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v12, Ljava/lang/StringBuilder;
    move-object/from16 v28, v4
    const-string v4, "handleToolResult[advance]: sourceTaskId="
    invoke-direct v12, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v12, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v12
    invoke-virtual v4, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v18, Ljava/lang/String;->length()I
    move-result v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", error="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getError()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v11, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v29, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    invoke-direct/range v29, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->taskCreateJob Lkotlinx/coroutines/Job;
    const/4 v3, 0
    const/4 v6, 1
    if-eqz v1, +005h
    invoke-static v1, v3, v6, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->taskCreateJob Lkotlinx/coroutines/Job;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getToolName()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v24, v1
    const/16 v25, 1823
    const/16 v26, 0
    move-object v11, v7
    move-object/from16 v17, v2
    move-object/from16 v19, v0
    invoke-static/range v11 ... v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v1
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-ne v2, v1, +006h
    const-string/jumbo v1, success
    goto +3h
    const-string v1, "failed"
    move-object v2, v1
    if-nez v0, +005h
    move-object/from16 v3, v28
    goto +2h
    move-object v3, v0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v10, 16
    const/4 v11, 0
    move-object/from16 v0, v29
    move-object v1, v7
    move/from16 v27, v6
    move v6, v10
    move-object v10, v7
    move-object v7, v11
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->reportLocalSubtaskEnd$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z I Ljava/lang/Object;)V
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->maybeCancelClientProxyTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    if-ne v0, v1, +00bh
    invoke-direct/range v29 ... v30, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isServerToolResultCandidate(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v0
    if-eqz v0, +005h
    move/from16 v10, v27
    goto +2h
    const/4 v10, 0
    return v10
    move-object v4, v7
    const/16 v27, 1
    if-eqz v11, +039h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleToolResult[skip-duplicate]: sourceTaskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", currState="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v7, 0
    return v7
    const/4 v7, 0
    if-eqz v12, +107h
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "handleToolResult[skip-busy]: currState="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", currId="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getExecutor()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", dropMsgId="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", dropTool="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v10, " → emit parallel terminal"
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v8, v4, v9, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->shouldFailPendingClientProxyTask(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage; Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +053h
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "handleToolResult[consume-local-pending]: currId="
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", msgId="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v10, ", reason="
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v5
    if-nez v0, +006h
    const-string/jumbo v6, task_create_failed
    goto +2h
    move-object v6, v0
    invoke-direct v8, v5, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->failPendingClientProxyTask(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-direct v8, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->clearPendingClientProxyIfCurrent(Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    const-string v13, ""
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    sget-object v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v24
    const/16 v25, 796
    const/16 v26, 0
    move-object v11, v4
    move-object/from16 v17, v2
    move-object/from16 v19, v0
    invoke-direct/range v11 ... v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parallelTerminalToolResults Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-interface v0, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "handleToolResult[skip-busy]: parallelTerminal buffer overflow, dropped taskId="
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v3, +00bh
    invoke-direct/range v29 ... v30, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isServerToolResultCandidate(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v0
    if-eqz v0, +005h
    move/from16 v10, v27
    goto +2h
    move v10, v7
    return v10
    if-eqz v4, +08ch
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "handleToolResult[lazy-init-overwrite]: prevId="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const/16 v12, 40
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    invoke-virtual v11, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v11, "), newId="
    invoke-virtual v4, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v4, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v18, Ljava/lang/String;->length()I
    move-result v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v7, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    const-string v13, ""
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    sget-object v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v24
    const/16 v25, 796
    const/16 v26, 0
    move-object v11, v1
    move-object/from16 v17, v2
    move-object/from16 v19, v0
    invoke-direct/range v11 ... v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct/range v29 ... v30, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isServerToolResultCandidate(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v0
    return v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v11, "handleToolResult[lazy-init]: taskId="
    invoke-direct v7, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v7, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v18, Ljava/lang/String;->length()I
    move-result v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v12
    const-string v13, ""
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    sget-object v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v24
    const/16 v25, 796
    const/16 v26, 0
    move-object v11, v1
    move-object/from16 v17, v2
    move-object/from16 v19, v0
    invoke-direct/range v11 ... v26, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct/range v29 ... v30, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->isServerToolResultCandidate(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v0
    return v0
.end method

.method public final isCreateTaskBizSuccess$conversation_mainlandRelease(long)boolean
    .registers 5
    # ins_size=3
    const-wide/16 v0, 0
    cmp-long v0, v3, v0
    if-eqz v0, +00bh
    const-wide/16 v0, 200
    cmp-long v3, v3, v0
    if-nez v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    return v3
.end method

.method public final normalizeImageIdForCreate$conversation_mainlandRelease(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "raw"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, trae-res://
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v2, v0, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final normalizeSubTaskFilesForCreate$conversation_mainlandRelease(java.util.List)java.util.List
    .registers 15
    # ins_size=2
    move-object v0, v14
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v14
    return-object v14
    check-cast v14, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +0cch
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/model/QueryItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/model/QueryItem;->getType()Ljava/lang/String;
    move-result-object v3
    const-string v4, "image"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    const-string/jumbo v5, uri
    const/4 v6, 0
    if-eqz v4, +033h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/model/QueryItem;->getData()Ljava/lang/Object;
    move-result-object v2
    const-string v4, "image_id"
    const-string v7, "imageId"
    filled-new-array v4, v7, v5, [Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->dataString(Ljava/lang/Object; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +09bh
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->normalizeImageIdForCreate$conversation_mainlandRelease(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +095h
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, +003h
    goto +2h
    move-object v2, v6
    if-eqz v2, +087h
    sget-object v3, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    const/4 v4, 2
    invoke-static v3, v2, v6, v4, v6, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->image$default(Lcom/bytedance/trae/conversation/model/QueryItem$Companion; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v2
    goto/16 +07dh
    const-string v4, "attachment"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +075h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/model/QueryItem;->getData()Ljava/lang/Object;
    move-result-object v4
    const-string/jumbo v7, tos_oid
    const-string/jumbo v8, tosOid
    filled-new-array v5, v7, v8, [Ljava/lang/String;
    move-result-object v5
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->dataString(Ljava/lang/Object; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +060h
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->normalizeAttachmentUriForCreate(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +05ah
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v1
    if-eqz v5, +004h
    move-object v8, v4
    goto +2h
    move-object v8, v6
    if-eqz v8, +04bh
    sget-object v7, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/model/QueryItem;->getData()Ljava/lang/Object;
    move-result-object v4
    const-string v5, "file_name"
    const-string v6, "name"
    const-string v9, "filename"
    filled-new-array v9, v5, v6, [Ljava/lang/String;
    move-result-object v5
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->dataString(Ljava/lang/Object; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    move-object v9, v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/model/QueryItem;->getData()Ljava/lang/Object;
    move-result-object v4
    const-string v5, "file_size"
    const-string v6, "fileSize"
    filled-new-array v5, v6, [Ljava/lang/String;
    move-result-object v5
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->dataLong(Ljava/lang/Object; [Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    goto +3h
    const-wide/16 v4, 0
    move-wide v10, v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/model/QueryItem;->getData()Ljava/lang/Object;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->CHAT_SESSION_ID_KEYS [Ljava/lang/String;
    array-length v5, v4
    invoke-static v4, v5, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v4
    check-cast v4, [Ljava/lang/String;
    invoke-direct v3, v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->dataString(Ljava/lang/Object; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    invoke-virtual/range v7 ... v12, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->attachment(Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v2
    move-object v6, v2
    if-eqz v6, -0c9h
    invoke-interface v0, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -0ceh
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public final notifyAttachmentsToBot(java.util.List)boolean
    .registers 7
    # ins_size=2
    const-string v0, "items"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v6, Ljava/util/List;->isEmpty()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return v1
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    const-string v2, "VoiceSubTaskCoord"
    if-nez v0, +01bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "notifyAttachmentsToBot: coordinator not started, drop count="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v2, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const/4 v1, 0
    if-eqz v0, +00eh
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    move-object v0, v1
    invoke-virtual v5, v6, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->buildNotifyAttachmentQueryJson$conversation_mainlandRelease(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "notifyAttachmentsToBot: count="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v3, ", query="
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v2, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v6, 2
    invoke-direct v5, v0, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postToBotLLM(Ljava/lang/String; I)Z
    move-result v6
    return v6
.end method

.method public final release(boolean  java.lang.String)void
    .registers 7
    # ins_size=3
    const-string v0, "reason"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    if-nez v0, +003h
    return-void 
    if-eqz v5, +005h
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->maybeDeleteEmptyRemoteParentSession(Ljava/lang/String;)V
    const-string v5, "released"
    const/4 v6, 2
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v4, v5, v0, v6, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelActiveTask$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Z I Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentCreateJob Lkotlinx/coroutines/Job;
    const/4 v6, 1
    if-eqz v5, +005h
    invoke-static v5, v1, v6, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentCreateJob Lkotlinx/coroutines/Job;
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->taskCreateJob Lkotlinx/coroutines/Job;
    if-eqz v5, +005h
    invoke-static v5, v1, v6, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->taskCreateJob Lkotlinx/coroutines/Job;
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    if-eqz v5, +005h
    invoke-static v5, v1, v6, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyStartJob Lkotlinx/coroutines/Job;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyRequest Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->pendingClientProxyExecutor Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelingClientProxyTaskId Ljava/lang/String;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->latestRoomIdForMetrics Ljava/lang/String;
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricStartedAtMs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v5, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricFileCounts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v5, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskMetricEndedTaskIds Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v5, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->clearServerToolTracking()V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterLock Ljava/lang/Object;
    monitor-enter v5
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiters Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +00eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lkotlinx/coroutines/CompletableDeferred;
    check-cast v3, Lkotlinx/coroutines/Job;
    invoke-static v3, v1, v6, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    goto -11h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiters Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->clear()V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelWaiterSourceToLocal Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->clear()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v5
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportLock Ljava/lang/Object;
    monitor-enter v5
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskResultReportedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v2, Ljava/util/LinkedHashSet;->clear()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v5
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressLock Ljava/lang/Object;
    monitor-enter v5
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->createTaskBizErrorSuppressedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v2, Ljava/util/LinkedHashSet;->clear()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v5
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultAliasLock Ljava/lang/Object;
    monitor-enter v5
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resultTaskIdAlias Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->clear()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v5
    invoke-direct v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelTimer()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelLongRunningJob()V
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->streamingListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-virtual v5, v2, Lcom/bytedance/trae/im/service/IMService;->removeStreamingMessageListener(Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;)V
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cliStatusListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    invoke-virtual v5, v2, Lcom/bytedance/trae/im/service/IMService;->removeCliStatusChangeListener(Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_proxyChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_activeTask Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->sendAckToBot Lkotlin/jvm/functions/Function1;
    sput-boolean v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->deviceOnline Z
    sput-boolean v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v6, "VoiceSubTaskCoord"
    const-string v0, "release: done"
    invoke-virtual v5, v6, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v6
    monitor-exit v5
    throw v6
    move-exception v6
    monitor-exit v5
    throw v6
    move-exception v6
    monitor-exit v5
    throw v6
    move-exception v6
    monitor-exit v5
    throw v6
    :try_start_0x52
    :try_start_0x80
    :try_start_0x8b
    :try_start_0x96
.end method

.method public final resolveSubTaskFailureMessage$conversation_mainlandRelease(java.lang.String  java.lang.Integer  java.lang.String  com.google.gson.JsonObject  java.lang.String  java.lang.String  kotlin.jvm.functions.Function4)java.lang.String
    .registers 14
    # ins_size=8
    const/4 v0, 1
    new-array v1, v0, [Ljava/lang/String;
    const/4 v2, 0
    aput-object v9, v1, v2
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +003h
    return-object v1
    const/4 v1, 2
    new-array v3, v1, [Ljava/lang/String;
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveLocalSubTaskErrorMessage(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    aput-object v7, v3, v2
    const/4 v7, 0
    if-eqz v8, +00fh
    invoke-virtual v8, Ljava/lang/Integer;->toString()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveLocalSubTaskErrorMessage(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v7
    aput-object v4, v3, v0
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +003h
    return-object v3
    if-eqz v8, +023h
    invoke-direct v6, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveAgentErrorDataType(Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v3
    if-eqz v13, +00ah
    invoke-interface v13, v8, v9, v10, v3, Lkotlin/jvm/functions/Function4;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/String;
    if-nez v13, +00ah
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v8
    invoke-direct v6, v8, v9, v10, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveAgentErrorDisplayMessage(I Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    new-array v8, v0, [Ljava/lang/String;
    aput-object v13, v8, v2
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +003h
    return-object v8
    const/4 v8, 3
    new-array v8, v8, [Ljava/lang/String;
    invoke-direct v6, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->resolveLocalSubTaskErrorMessage(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    aput-object v9, v8, v2
    aput-object v11, v8, v0
    aput-object v12, v8, v1
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->firstNonBlank([Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +003h
    return-object v8
    return-object v7
.end method

.method public final resolveSubTaskModelConfig$conversation_mainlandRelease(com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig  com.bytedance.trae.im.service.Mode)com.google.gson.JsonObject
    .registers 8
    # ins_size=3
    const-string v0, "mode"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v7
    const/4 v0, 0
    if-eqz v6, +033h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;->getModels()Ljava/util/List;
    move-result-object v6
    if-eqz v6, +02dh
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01fh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/google/gson/JsonObject;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    const-string v4, "name"
    invoke-direct v3, v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->readStringProperty(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +00ah
    const/4 v4, 1
    invoke-static v2, v7, v4, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    if-ne v2, v4, +003h
    move v3, v4
    if-eqz v3, -020h
    move-object v0, v1
    check-cast v0, Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final start(com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  kotlin.jvm.functions.Function1)void
    .registers 12
    # ins_size=3
    const-string v0, "config"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    sput-object v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->sendAckToBot Lkotlin/jvm/functions/Function1;
    sget-boolean v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    const-string v0, "VoiceSubTaskCoord"
    const/4 v1, 1
    if-nez v11, +058h
    sput-boolean v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->started Z
    sput-boolean v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->deviceOnline Z
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->streamingListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-virtual v11, v2, Lcom/bytedance/trae/im/service/IMService;->addStreamingMessageListener(Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;)V
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cliStatusListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    invoke-virtual v11, v2, Lcom/bytedance/trae/im/service/IMService;->addCliStatusChangeListener(Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;)V
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, start: voiceConvId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getVoiceConversationId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", parent="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getParentConversationId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", createRemoteParent="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCreateRemoteParentSession()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", parentAgentType="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getParentAgentType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v11, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +1ah
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, start: re-arm config, voiceConvId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getVoiceConversationId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v11, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentConversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getParentConversationId()Ljava/lang/String;
    move-result-object v0
    const/4 v2, 0
    if-eqz v0, +00dh
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    invoke-interface v11, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->_parentChatSessionId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v3, +037h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;->getCreateRemoteParentSession()Z
    move-result v0
    if-eqz v0, +031h
    invoke-interface v11, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    if-eqz v11, +00bh
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +003h
    goto +3h
    const/4 v11, 0
    goto +2h
    move v11, v1
    if-eqz v11, +01dh
    sget-object v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentCreateJob Lkotlinx/coroutines/Job;
    if-eqz v11, +005h
    invoke-static v11, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->coroutineScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;
    invoke-direct v11, v10, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/coroutines/Continuation;)V
    move-object v6, v11
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    sput-object v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->parentCreateJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final updateSubTaskConfig(com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig)void
    .registers 8
    # ins_size=2
    sput-object v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->subTaskConfig Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, updateSubTaskConfig: models=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v7, +032h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;->getModels()Ljava/util/List;
    move-result-object v7
    if-eqz v7, +02ch
    check-cast v7, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +016h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/google/gson/JsonObject;
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    const-string v5, "name"
    invoke-direct v4, v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->readStringProperty(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, -014h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v2, Ljava/util/List;
    goto +2h
    const/4 v2, 0
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v1, "VoiceSubTaskCoord"
    invoke-virtual v0, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
