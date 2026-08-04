# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "ConversationViewModel.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field private static final ANCHOR_WINDOW_HAS_MORE_SIDE_THRESHOLD:I
.field private static final CODE_APPEND_NOT_ALLOWED:J
.field public static final CODE_DEVICE_OFFLINE:J
.field public static final CODE_IDE_DEVICE_OFFLINE:J
.field private static final CODE_INSUFFICIENT_RESOURCES:J
.field private static final CODE_INTERNAL_USAGE_LIMIT:J
.field private static final CODE_INVALID_ARGS:J
.field private static final CODE_MODEL_NOT_EXISTED:J
.field private static final CODE_MODEL_OVERLOADED:J
.field private static final CODE_PARALLEL_LIMIT:J
.field private static final CODE_PIN_VERSION_INCOMPATIBLE:J
.field private static final CODE_REPO_LEVEL_RESTRICTED:J
.field private static final CODE_RISK_CONTROL_LOGOUT:J
.field private static final CODE_RISK_CONTROL_LOGOUT_2:J
.field private static final CODE_RISK_CONTROL_REJECTED:J
.field private static final CODE_SERVER_ERROR:J
.field public static final Companion:Lcom/bytedance/trae/conversation/ConversationViewModel$Companion;
.field private static final DEFAULT_PARALLEL_LIMIT:I
.field private static final DOWNLOAD_FILE_TOO_LARGE_MESSAGE:Ljava/lang/String;
.field private static final EVENT_CHECKPOINT_CONFIRM_TASK_ERROR:Ljava/lang/String;
.field private static final EVENT_DISCUSSION_SUMMARY_END:Ljava/lang/String;
.field private static final EVENT_DISCUSSION_SUMMARY_PERF:Ljava/lang/String;
.field private static final PERF_MISSING_VALUE:J
.field private static final PERF_REPORT_RENDER_TIMEOUT_MS:J
.field private static final STREAMING_THROTTLE_MS:J
.field private static final SUMMARY_FINISH_TOOLS:Ljava/util/Set;
.field private static final TAG:Ljava/lang/String;
.field private final _cancelTaskResult:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _contentSecurityToastText:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _conversation:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _conversationId:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _conversations:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _createTask:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _createTaskFailed:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _currentMode:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private _currentTaskId:Ljava/lang/String;
.field private final _deleteSuccess:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _forceLogout:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _hasMoreMessages:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _isAnchorWindowLoading:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _isLoadingMore:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _loadError:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _messages:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _modelSelectionResetToAuto:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _newMessage:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _refreshedMessages:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _remoteUserMessage:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _renameSuccess:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _selectedDevice:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _sendMessageSuccess:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _sessionTurnStatus:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _shownCheckpointToolCallIds:Ljava/util/Set;
.field private final _streamingStarted:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _taskDone:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _throttledStreamingMessage:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _toastMessage:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _toastText:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _upgradeReminder:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private bufferedAgentMessage:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field private final cacheRepository$delegate:Lkotlin/Lazy;
.field private final cancelTaskResult:Lkotlinx/coroutines/flow/SharedFlow;
.field private final contentSecurityToastText:Lkotlinx/coroutines/flow/SharedFlow;
.field private final conversation:Lkotlinx/coroutines/flow/StateFlow;
.field private final conversationId:Lkotlinx/coroutines/flow/StateFlow;
.field private final conversations:Lkotlinx/coroutines/flow/StateFlow;
.field private final createTask:Lkotlinx/coroutines/flow/SharedFlow;
.field private final createTaskFailed:Lkotlinx/coroutines/flow/SharedFlow;
.field private createTaskJob:Lkotlinx/coroutines/Job;
.field private final currentMode:Lkotlinx/coroutines/flow/StateFlow;
.field private final deleteSuccess:Lkotlinx/coroutines/flow/SharedFlow;
.field private final doneListener:Lcom/bytedance/trae/im/service/IMService$DoneListener;
.field private final forceLogout:Lkotlinx/coroutines/flow/SharedFlow;
.field private final gson:Lcom/google/gson/Gson;
.field private final handledModelFallbackErrorKeys:Ljava/util/Set;
.field private final hasMoreMessages:Lkotlinx/coroutines/flow/StateFlow;
.field private hasMoreNewerAnchorMessages:Z
.field private final isAnchorWindowLoading:Lkotlinx/coroutines/flow/StateFlow;
.field private isAnchorWindowMode:Z
.field private isInited:Z
.field private isLoadingNewerAnchorMessages:Z
.field private isMessageListCommitPendingForUpgradeReminder:Z
.field private isNewConversation:Z
.field private isSummaryTracking:Z
.field private isTaskRunning:Z
.field private bridge isUserMessagePending:Z
.field private lastDoneMessage:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field private lastStreamingEmitTime:J
.field private latestPrefetchMessages:Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;
.field private final loadError:Lkotlinx/coroutines/flow/StateFlow;
.field private final messages:Lkotlinx/coroutines/flow/StateFlow;
.field private final metadataDoneListener:Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;
.field private final modelSelectionResetToAuto:Lkotlinx/coroutines/flow/SharedFlow;
.field private final newMessage:Lkotlinx/coroutines/flow/SharedFlow;
.field private pendingStreamingMessage:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field private bridge pendingSummaryIsSuccess:Z
.field private pendingUpgradeReminderRefresh:Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
.field private final refreshedMessages:Lkotlinx/coroutines/flow/SharedFlow;
.field private final remoteUserMessage:Lkotlinx/coroutines/flow/SharedFlow;
.field private final remoteUserMessageIds:Ljava/util/Set;
.field private final remoteUserMessageListener:Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;
.field private final renameSuccess:Lkotlinx/coroutines/flow/SharedFlow;
.field private final runtimeMessageIds:Ljava/util/Set;
.field private selectedBranchName:Ljava/lang/String;
.field private final selectedDevice:Lkotlinx/coroutines/flow/StateFlow;
.field private selectedRepo:Lcom/bytedance/trae/conversation/git/GitRepoItem;
.field private selectedRepoName:Ljava/lang/String;
.field private selectedRepoUrl:Ljava/lang/String;
.field private final sendMessageSuccess:Lkotlinx/coroutines/flow/SharedFlow;
.field private final sessionTurnStatus:Lkotlinx/coroutines/flow/StateFlow;
.field private final streamingMessage:Lkotlinx/coroutines/flow/SharedFlow;
.field private final streamingMessageListener:Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
.field private final streamingStarted:Lkotlinx/coroutines/flow/SharedFlow;
.field private final streamingThrottleMutex:Lkotlinx/coroutines/sync/Mutex;
.field private streamingTrailingJob:Lkotlinx/coroutines/Job;
.field private summaryCharCount:I
.field private summaryCliType:Lcom/bytedance/trae/im/service/CliType;
.field private summaryDataFirstCharTimestamp:J
.field private summaryIsNewSession:Z
.field private summaryMode:Lcom/bytedance/trae/im/service/Mode;
.field private bridge summaryReportSubmitted:Z
.field private summaryReportTimeoutJob:Lkotlinx/coroutines/Job;
.field private summarySessionId:Ljava/lang/String;
.field private summaryStartTimestamp:J
.field private final taskDone:Lkotlinx/coroutines/flow/SharedFlow;
.field private final toastMessage:Lkotlinx/coroutines/flow/SharedFlow;
.field private final toastText:Lkotlinx/coroutines/flow/SharedFlow;
.field private final upgradeReminder:Lkotlinx/coroutines/flow/StateFlow;


.method public static synthetic $r8$lambda$-il7H3UNzdg6j05ZW0VKKmMMkSk(com.bytedance.trae.im.model.ParsedChatMessage)java.lang.Long
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateUpgradeReminder$lambda$23(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/Long;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$8B-rFeup_Sp7_WgVkDqbKfLx8o8(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->doneListener$lambda$3(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$AoiphhL8e6ql0l4TswV9Ih6gJGc(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleModelUnavailableLoadedMessagesIfNeeded$lambda$56(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$DTL-gkyNnuGZW_8a9OY6JMN5Ggo(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleModelUnavailableLoadedMessagesIfNeeded$lambda$55(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$F8-xlKjHGu51kmnupT_aPHttNv0(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessageListener$lambda$2(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$GlRakyJbegTt9_HoMR3YAho06P0(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  com.bytedance.trae.im.service.UserMessageContext)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->metadataDoneListener$lambda$7(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HDpXcdYGkve2Fbx6SmAP7XtqD-8(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->mergeMessagesIntoState$lambda$33(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$PufFAoMv4ba_UjYsaAcKcJbveDc(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleModelUnavailableLoadedMessagesIfNeeded$lambda$57(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$qd7lkxYaixR-P9QP3c9b5-FPdF0()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/ConversationViewModel;->loadNewerAnchorMessages$lambda$25()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rQlFD6juOUd0AO691a7PMffR_X8(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.Integer
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->extractSummaryCharCount$lambda$85(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$v11wVcq9X9YD0uPN6GhyBPNO2J0(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.Integer  java.lang.Long  boolean)void
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageListener$lambda$5(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/Integer; Ljava/lang/Long; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xXCpd87CZMcQuDnni_tktxbmMoM()com.bytedance.trae.im.repository.ConversationDetailCacheRepository
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/ConversationViewModel;->cacheRepository_delegate$lambda$1()Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 9
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->Companion Lcom/bytedance/trae/conversation/ConversationViewModel$Companion;
    const-string v2, "finish"
    const-string v3, "Finish"
    const-string v4, "agent_finish"
    const-string v5, "AgentFinish"
    const-string/jumbo v6, response_to_user
    const-string v7, "ResponseToUser"
    const-string v8, "Task"
    filled-new-array/range v2 ... v8, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->SUMMARY_FINISH_TOOLS Ljava/util/Set;
    return-void 
.end method

.method public constructor <init>()void
    .registers 7
    # ins_size=1
    invoke-direct v6, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    iput-object v0, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->gson Lcom/google/gson/Gson;
    const/4 v0, 0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->conversation Lkotlinx/coroutines/flow/StateFlow;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-static v1, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversations Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->conversations Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->conversationId Lkotlinx/coroutines/flow/StateFlow;
    new-instance v1, Ljava/util/LinkedHashSet;
    invoke-direct v1, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v1, Ljava/util/Set;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_shownCheckpointToolCallIds Ljava/util/Set;
    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v1, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    invoke-static v1, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->handledModelFallbackErrorKeys Ljava/util/Set;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;-><init>(Ljava/util/List;)V
    invoke-static v1, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->messages Lkotlinx/coroutines/flow/StateFlow;
    new-instance v1, Ljava/util/LinkedHashSet;
    invoke-direct v1, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v1, Ljava/util/Set;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    const/4 v3, 7
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_newMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->newMessage Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_upgradeReminder Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->upgradeReminder Lkotlinx/coroutines/flow/StateFlow;
    sget-object v4, Lkotlinx/coroutines/channels/BufferOverflow;->DROP_OLDEST Lkotlinx/coroutines/channels/BufferOverflow;
    const/4 v5, 1
    invoke-static v1, v5, v4, v5, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_throttledStreamingMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessage Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v5, v0, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingThrottleMutex Lkotlinx/coroutines/sync/Mutex;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->toastMessage Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->toastText Lkotlinx/coroutines/flow/SharedFlow;
    sget-object v4, Lkotlinx/coroutines/channels/BufferOverflow;->DROP_OLDEST Lkotlinx/coroutines/channels/BufferOverflow;
    invoke-static v1, v5, v4, v5, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_contentSecurityToastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->contentSecurityToastText Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_renameSuccess Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->renameSuccess Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_deleteSuccess Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->deleteSuccess Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sendMessageSuccess Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessageSuccess Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isAnchorWindowLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->isAnchorWindowLoading Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_refreshedMessages Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->refreshedMessages Lkotlinx/coroutines/flow/SharedFlow;
    const/4 v4, 6
    invoke-static v5, v1, v0, v4, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_createTask Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTask Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_createTaskFailed Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskFailed Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_modelSelectionResetToAuto Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->modelSelectionResetToAuto Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_forceLogout Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->forceLogout Lkotlinx/coroutines/flow/SharedFlow;
    sget-object v4, Lkotlinx/coroutines/channels/BufferOverflow;->DROP_OLDEST Lkotlinx/coroutines/channels/BufferOverflow;
    invoke-static v1, v5, v4, v5, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_streamingStarted Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingStarted Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedDevice Lkotlinx/coroutines/flow/StateFlow;
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-static v4, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentMode Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->currentMode Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v4, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreMessages Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isLoadingMore Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v4, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->IDLE Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    invoke-static v4, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v4, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    iput-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->sessionTurnStatus Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_loadError Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadError Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_remoteUserMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v2
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessage Lkotlinx/coroutines/flow/SharedFlow;
    new-instance v2, Ljava/util/LinkedHashSet;
    invoke-direct v2, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v2, Ljava/util/Set;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageIds Ljava/util/Set;
    const-string v2, ""
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->summarySessionId Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryCliType Lcom/bytedance/trae/im/service/CliType;
    sget-object v2, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryMode Lcom/bytedance/trae/im/service/Mode;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda6;
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda6;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->cacheRepository$delegate Lkotlin/Lazy;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda7;
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_taskDone Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v2
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->taskDone Lkotlinx/coroutines/flow/SharedFlow;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda8;
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->doneListener Lcom/bytedance/trae/im/service/IMService$DoneListener;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda9;
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageListener Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda10;
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->metadataDoneListener Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;
    invoke-static v1, v1, v0, v3, v0, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    iput-object v0, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_cancelTaskResult Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v0
    iput-object v0, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->cancelTaskResult Lkotlinx/coroutines/flow/SharedFlow;
    return-void 
.end method

.method public static final synthetic access$applyPinSuccess(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  boolean  com.bytedance.trae.im.service.PinConversationResponse)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->applyPinSuccess(Ljava/lang/String; Z Lcom/bytedance/trae/im/service/PinConversationResponse;)V
    return-void 
.end method

.method public static final synthetic access$buildParallelLimitMessage(com.bytedance.trae.conversation.ConversationViewModel  java.lang.Integer)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildParallelLimitMessage(Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$cacheTaskModelSelection(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.RemoteModelItem)void
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->cacheTaskModelSelection(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    return-void 
.end method

.method public static final synthetic access$contentSecurityBlockedText(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->contentSecurityBlockedText(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$emitStreamingThrottled(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->emitStreamingThrottled(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$filterDisplayableMessages(com.bytedance.trae.conversation.ConversationViewModel  java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->filterDisplayableMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$flushPendingUpgradeReminderIfAllowed(com.bytedance.trae.conversation.ConversationViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->flushPendingUpgradeReminderIfAllowed()V
    return-void 
.end method

.method public static final synthetic access$getBufferedAgentMessage$p(com.bytedance.trae.conversation.ConversationViewModel)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->bufferedAgentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public static final synthetic access$getCacheRepository(com.bytedance.trae.conversation.ConversationViewModel)com.bytedance.trae.im.repository.ConversationDetailCacheRepository
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getCacheRepository()Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getKeva(com.bytedance.trae.conversation.ConversationViewModel)com.bytedance.keva.Keva
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getPendingStreamingMessage$p(com.bytedance.trae.conversation.ConversationViewModel)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingStreamingMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public static final synthetic access$getPendingSummaryIsSuccess$p(com.bytedance.trae.conversation.ConversationViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingSummaryIsSuccess Z
    return v0
.end method

.method public static final synthetic access$getRemoteUserMessageIds$p(com.bytedance.trae.conversation.ConversationViewModel)java.util.Set
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageIds Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getStreamingMessageListener$p(com.bytedance.trae.conversation.ConversationViewModel)com.bytedance.trae.im.service.IMService$StreamingMessageListener
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    return-object v0
.end method

.method public static final synthetic access$getStreamingThrottleMutex$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.sync.Mutex
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingThrottleMutex Lkotlinx/coroutines/sync/Mutex;
    return-object v0
.end method

.method public static final synthetic access$getSummaryReportTimeoutJob$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportTimeoutJob Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method public static final synthetic access$get_cancelTaskResult$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_cancelTaskResult Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_contentSecurityToastText$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_contentSecurityToastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_conversation$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_conversationId$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_createTask$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_createTask Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_createTaskFailed$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_createTaskFailed Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_deleteSuccess$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_deleteSuccess Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_forceLogout$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_forceLogout Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_hasMoreMessages$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_isAnchorWindowLoading$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isAnchorWindowLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_isLoadingMore$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isLoadingMore Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_loadError$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_loadError Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_messages$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_newMessage$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_newMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_remoteUserMessage$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_remoteUserMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_renameSuccess$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_renameSuccess Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_selectedDevice$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_sendMessageSuccess$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sendMessageSuccess Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_sessionTurnStatus$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_taskDone$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_taskDone Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_throttledStreamingMessage$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_throttledStreamingMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_toastMessage$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_toastText$p(com.bytedance.trae.conversation.ConversationViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$handleAnchorLoadError(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.network.response.HttpDataResult$Error  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleAnchorLoadError(Lcom/bytedance/trae/network/response/HttpDataResult$Error; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$handleCreateTaskErrorWithoutModelFallbackIfNeeded(com.bytedance.trae.conversation.ConversationViewModel  long  java.lang.String  com.google.gson.JsonObject  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleCreateTaskErrorWithoutModelFallbackIfNeeded(J Ljava/lang/String; Lcom/google/gson/JsonObject; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$handleModelUnavailableCreateTaskErrorIfNeeded(com.bytedance.trae.conversation.ConversationViewModel  long  java.lang.String  com.google.gson.JsonObject  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleModelUnavailableCreateTaskErrorIfNeeded(J Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$handleModelUnavailableLoadedMessagesIfNeeded(com.bytedance.trae.conversation.ConversationViewModel  java.util.List  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleModelUnavailableLoadedMessagesIfNeeded(Ljava/util/List; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$hasLoadedNewerSide(com.bytedance.trae.conversation.ConversationViewModel  java.util.List  java.lang.String  int)boolean
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasLoadedNewerSide(Ljava/util/List; Ljava/lang/String; I)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$hasLoadedOlderSide(com.bytedance.trae.conversation.ConversationViewModel  java.util.List  java.lang.String  int)boolean
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasLoadedOlderSide(Ljava/util/List; Ljava/lang/String; I)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$isInited$p(com.bytedance.trae.conversation.ConversationViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isInited Z
    return v0
.end method

.method public static final synthetic access$isSummaryTracking$p(com.bytedance.trae.conversation.ConversationViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isSummaryTracking Z
    return v0
.end method

.method public static final synthetic access$isUserMessagePending$p(com.bytedance.trae.conversation.ConversationViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isUserMessagePending Z
    return v0
.end method

.method public static final synthetic access$loadAnchorMessagesByCreatedAt(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  int  int  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadAnchorMessagesByCreatedAt(Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$mergeMessages(com.bytedance.trae.conversation.ConversationViewModel  java.util.List  java.util.List)java.util.List
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->mergeMessages(Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$mergeMessagesIntoState(com.bytedance.trae.conversation.ConversationViewModel  java.util.List  java.util.List)java.util.List
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->mergeMessagesIntoState(Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$performCreateTaskCheck(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->performCreateTaskCheck(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$pinFailureString(com.bytedance.trae.conversation.ConversationViewModel  boolean)int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->pinFailureString(Z)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$pinSuccessString(com.bytedance.trae.conversation.ConversationViewModel  boolean)int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->pinSuccessString(Z)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$prefetchLatestMessages(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->prefetchLatestMessages(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$processTraeRefInSummary(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->processTraeRefInSummary(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$recoverStreamingMessages(com.bytedance.trae.conversation.ConversationViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->recoverStreamingMessages()V
    return-void 
.end method

.method public static final synthetic access$replaceMessagesPreservingRuntime(com.bytedance.trae.conversation.ConversationViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->replaceMessagesPreservingRuntime(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$reportCheckpointConfirmTaskError(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision  java.lang.String  com.bytedance.trae.network.response.HttpDataResult$Error)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->reportCheckpointConfirmTaskError(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Ljava/lang/String; Lcom/bytedance/trae/network/response/HttpDataResult$Error;)V
    return-void 
.end method

.method public static final synthetic access$saveSelectedRepo(com.bytedance.trae.conversation.ConversationViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->saveSelectedRepo()V
    return-void 
.end method

.method public static final synthetic access$setBufferedAgentMessage$p(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->bufferedAgentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-void 
.end method

.method public static final synthetic access$setCreateTaskJob$p(com.bytedance.trae.conversation.ConversationViewModel  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setHasMoreNewerAnchorMessages$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreNewerAnchorMessages Z
    return-void 
.end method

.method public static final synthetic access$setInited$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isInited Z
    return-void 
.end method

.method public static final synthetic access$setLastStreamingEmitTime$p(com.bytedance.trae.conversation.ConversationViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->lastStreamingEmitTime J
    return-void 
.end method

.method public static final synthetic access$setLatestPrefetchMessages$p(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.conversation.ConversationViewModel$LatestPrefetchMessages)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->latestPrefetchMessages Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;
    return-void 
.end method

.method public static final synthetic access$setLoadingNewerAnchorMessages$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isLoadingNewerAnchorMessages Z
    return-void 
.end method

.method public static final synthetic access$setMessages(com.bytedance.trae.conversation.ConversationViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMessages(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$setPendingStreamingMessage$p(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingStreamingMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-void 
.end method

.method public static final synthetic access$setPendingSummaryIsSuccess$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingSummaryIsSuccess Z
    return-void 
.end method

.method public static final synthetic access$setSummaryCharCount$p(com.bytedance.trae.conversation.ConversationViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryCharCount I
    return-void 
.end method

.method public static final synthetic access$setSummaryCliType$p(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.service.CliType)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryCliType Lcom/bytedance/trae/im/service/CliType;
    return-void 
.end method

.method public static final synthetic access$setSummaryDataFirstCharTimestamp$p(com.bytedance.trae.conversation.ConversationViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryDataFirstCharTimestamp J
    return-void 
.end method

.method public static final synthetic access$setSummaryIsNewSession$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryIsNewSession Z
    return-void 
.end method

.method public static final synthetic access$setSummaryMode$p(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.service.Mode)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryMode Lcom/bytedance/trae/im/service/Mode;
    return-void 
.end method

.method public static final synthetic access$setSummaryReportSubmitted$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportSubmitted Z
    return-void 
.end method

.method public static final synthetic access$setSummaryReportTimeoutJob$p(com.bytedance.trae.conversation.ConversationViewModel  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportTimeoutJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setSummarySessionId$p(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summarySessionId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setSummaryStartTimestamp$p(com.bytedance.trae.conversation.ConversationViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryStartTimestamp J
    return-void 
.end method

.method public static final synthetic access$setSummaryTracking$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isSummaryTracking Z
    return-void 
.end method

.method public static final synthetic access$setUserMessagePending$p(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isUserMessagePending Z
    return-void 
.end method

.method public static final synthetic access$set_currentTaskId$p(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentTaskId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$submitSummaryPerfReport(com.bytedance.trae.conversation.ConversationViewModel  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->submitSummaryPerfReport(Z)V
    return-void 
.end method

.method public static final synthetic access$switchSelectedModelToAuto(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->switchSelectedModelToAuto(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toCreateTaskCustomModel(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.conversation.network.RemoteModelItem)com.google.gson.JsonObject
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->toCreateTaskCustomModel(Lcom/bytedance/trae/conversation/network/RemoteModelItem;)Lcom/google/gson/JsonObject;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toParsedHistoryMessages(com.bytedance.trae.conversation.ConversationViewModel  java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->toParsedHistoryMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$updateUpgradeReminder(com.bytedance.trae.conversation.ConversationViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateUpgradeReminder(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$upsertMessages(com.bytedance.trae.conversation.ConversationViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->upsertMessages(Ljava/util/List;)V
    return-void 
.end method

.method private final applyCreateTaskCheckResult(com.bytedance.trae.im.service.CreateTaskCheckResponse)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;->INSTANCE Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;
    invoke-virtual v1, v0, v3, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;->applyCreateTaskCheck(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateConversationEnvironment(Lcom/bytedance/trae/im/service/CliType;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +017h
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/conversation/CliListRepository;->saveCliId(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final applyPinSuccess(java.lang.String  boolean  com.bytedance.trae.im.service.PinConversationResponse)void
    .registers 36
    # ins_size=4
    move-object/from16 v0, v32
    if-eqz v35, +00dh
    invoke-virtual/range v35, Lcom/bytedance/trae/im/service/PinConversationResponse;->isPinned()Ljava/lang/Boolean;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    goto +3h
    move/from16 v1, v34
    const/4 v2, 0
    if-eqz v1, +00ch
    if-eqz v35, +006h
    invoke-virtual/range v35, Lcom/bytedance/trae/im/service/PinConversationResponse;->getPinnedAt()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    move-object/from16 v29, v2
    if-eqz v35, +008h
    invoke-virtual/range v35, Lcom/bytedance/trae/im/service/PinConversationResponse;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    if-nez v2, +073h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v3, +034h
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
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v28
    const v30, 16777215
    const/16 v31, 0
    invoke-static/range v3 ... v31, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    goto +35h
    new-instance v2, Lcom/bytedance/trae/im/service/Conversation;
    move-object v3, v2
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
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v28
    const v30, 16777214
    const/16 v31, 0
    move-object/from16 v4, v33
    invoke-direct/range v3 ... v31, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateConversation(Lcom/bytedance/trae/im/service/Conversation;)V
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    new-instance v3, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    move-object/from16 v4, v33
    const-string/jumbo v5, update
    invoke-direct v3, v5, v4, v2, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/im/service/IMService;->notifyConversationChanged(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    return-void 
.end method

.method private final armSummaryPerfReport(boolean)void
    .registers 9
    # ins_size=2
    iput-boolean v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingSummaryIsSuccess Z
    sget-object v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->getLastCharOnScreenMs()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +006h
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->submitSummaryPerfReport(Z)V
    return-void 
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportTimeoutJob Lkotlinx/coroutines/Job;
    const/4 v0, 0
    if-eqz v8, +006h
    const/4 v1, 1
    invoke-static v8, v0, v1, v0, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    move-object v8, v7
    check-cast v8, Landroidx/lifecycle/ViewModel;
    invoke-static v8, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v8, Lcom/bytedance/trae/conversation/ConversationViewModel$armSummaryPerfReport$1;
    invoke-direct v8, v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$armSummaryPerfReport$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v8
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v8
    iput-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportTimeoutJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final buildInternalUsageLimitMessage(android.content.res.Resources  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode)java.lang.String
    .registers 14
    # ins_size=4
    invoke-direct v10, v12, v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->internalUsageLimitModelNames(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode;)Ljava/util/List;
    move-result-object v12
    invoke-interface v12, Ljava/util/List;->isEmpty()Z
    move-result v13
    if-eqz v13, +00eh
    sget-object v12, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v13, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_internalUsageLimit_message I
    const/4 v0, 0
    new-array v0, v0, [Ljava/lang/Object;
    invoke-virtual v12, v11, v13, v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    return-object v11
    sget-object v13, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_internalUsageLimit_messageWithModels I
    move-object v1, v12
    check-cast v1, Ljava/lang/Iterable;
    const-string v12, ", "
    move-object v2, v12
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    const-string v1, "models"
    invoke-static v1, v12, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    invoke-static v12, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v12
    invoke-virtual v13, v11, v0, v12, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringWithNamedArgs(Landroid/content/res/Resources; I Ljava/util/Map;)Ljava/lang/String;
    move-result-object v11
    return-object v11
.end method

.method private final buildListMessagesLargeFileRetryRequests(java.lang.String  java.lang.String  int  int  boolean)java.util.List
    .registers 15
    # ins_size=6
    const/4 v0, 4
    const/4 v1, 3
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v3, 2
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const/4 v5, 1
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const/4 v7, 0
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    if-lez v12, +02bh
    if-lez v13, +029h
    new-array v0, v0, [Lkotlin/Pair;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v7
    invoke-static v2, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v5
    invoke-static v6, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v3
    invoke-static v6, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    goto +6ch
    const/4 v2, 6
    if-lez v12, +02dh
    new-array v0, v0, [Lkotlin/Pair;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v7
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v12, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v5
    invoke-static v4, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v3
    invoke-static v6, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    goto +3eh
    if-lez v13, +02dh
    new-array v0, v0, [Lkotlin/Pair;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v7
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v8, v12, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v5
    invoke-static v8, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v3
    invoke-static v8, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    goto +11h
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    invoke-static v12, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/lang/Iterable;
    invoke-static v12, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/lang/Iterable;
    new-instance v13, Ljava/util/ArrayList;
    const/16 v0, 10
    invoke-static v12, v0, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v0
    invoke-direct v13, v0, Ljava/util/ArrayList;-><init>(I)V
    check-cast v13, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +029h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlin/Pair;
    invoke-virtual v0, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v5
    invoke-virtual v0, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v6
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    move-object v2, v0
    move-object v3, v10
    move-object v4, v11
    move v7, v14
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;-><init>(Ljava/lang/String; Ljava/lang/String; I I Z)V
    invoke-interface v13, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ch
    check-cast v13, Ljava/util/List;
    return-object v13
.end method

.method private final buildModelUnavailableMessage(long  java.lang.String  com.google.gson.JsonObject  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode)java.lang.String
    .registers 18
    # ins_size=7
    move-object v0, v11
    move-wide v1, v12
    move-object v5, v15
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    invoke-virtual v3, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    const-wide/16 v6, 4023
    cmp-long v4, v1, v6
    if-nez v4, +023h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    long-to-int v1, v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 48
    const/4 v10, 0
    move-object v1, v4
    move-object v2, v3
    move-object v3, v6
    move-object v4, v14
    move-object v5, v15
    move-object v6, v7
    move v7, v8
    move v8, v9
    move-object v9, v10
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->displayMessage$default(Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry; Landroid/content/res/Resources; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->getMessage()Ljava/lang/String;
    move-result-object v1
    goto +5fh
    const-wide/16 v6, 4008
    cmp-long v4, v1, v6
    if-nez v4, +00eh
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    invoke-direct v11, v3, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildInternalUsageLimitMessage(Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode;)Ljava/lang/String;
    move-result-object v1
    goto +4dh
    const-wide/16 v6, 4037
    cmp-long v1, v1, v6
    const-string v2, ""
    if-nez v1, +041h
    const-string/jumbo v1, type
    invoke-direct v11, v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v4, "empty_git"
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +011h
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_repoLevelModelUnavailable_emptyGit I
    const/4 v4, 0
    new-array v4, v4, [Ljava/lang/Object;
    invoke-virtual v1, v3, v2, v4, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +27h
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_repoLevelModelUnavailable I
    const-string v6, "level"
    invoke-direct v11, v15, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +2h
    move-object v2, v5
    const-string/jumbo v5, repoLevel
    invoke-static v5, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    invoke-virtual v1, v3, v4, v2, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringWithNamedArgs(Landroid/content/res/Resources; I Ljava/util/Map;)Ljava/lang/String;
    move-result-object v1
    goto +6h
    if-nez v14, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v14
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +017h
    if-nez v14, +014h
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_send_retry I
    invoke-virtual v1, v2, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "getString(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v1, v14
    check-cast v1, Ljava/lang/String;
    return-object v1
.end method

.method private final buildParallelLimitMessage(java.lang.Integer)java.lang.String
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;->INSTANCE Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v7, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;->parallelLimitMessage(Landroid/content/res/Resources; Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +036h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_parallel_limit I
    const/4 v2, 1
    new-array v3, v2, [Ljava/lang/Object;
    const/4 v4, 0
    if-eqz v7, +018h
    move-object v5, v7
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    if-lez v5, +003h
    goto +2h
    move v2, v4
    if-eqz v2, +003h
    goto +2h
    const/4 v7, 0
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2h
    const/4 v7, 2
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    aput-object v7, v3, v4
    invoke-virtual v0, v1, v3, Landroid/app/Application;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v7, "getString(...)"
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method private final buildRemoteUserMessage(java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.Integer  java.lang.Long  boolean)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 69
    # ins_size=7
    sget-object v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    move-object/from16 v1, v65
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->parseContent(Lcom/google/gson/JsonElement;)Ljava/util/List;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v1, v0, v3, v2, v3, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->extractText$default(Lcom/bytedance/trae/im/model/MessagePartNormalizer; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v40
    move-object/from16 v1, v40
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    const/4 v4, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v4
    goto +2h
    move v1, v2
    if-eqz v1, +012h
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move v2, v4
    if-eqz v2, +003h
    return-object v3
    if-eqz v66, +008h
    invoke-virtual/range v66, Ljava/lang/Integer;->intValue()I
    move-result v1
    move v9, v1
    goto +2h
    move v9, v4
    if-eqz v67, +011h
    move-object/from16 v1, v67
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v1
    sget-object v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->Companion Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;->normalizeToMillis(J)J
    move-result-wide v1
    goto +5h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    move-wide/from16 v24, v1
    new-instance v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object/from16 v1, v61
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const-string/jumbo v8, user
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v42, 0
    const/16 v43, 1
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const v58, -4194500
    const v59, 8387743
    const/16 v60, 0
    move-object/from16 v2, v63
    move-object/from16 v3, v64
    move-object/from16 v41, v0
    move/from16 v44, v68
    invoke-direct/range v1 ... v60, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v61
.end method

.method static synthetic buildRemoteUserMessage$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.Integer  java.lang.Long  boolean  int  java.lang.Object)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 16
    # ins_size=9
    and-int/lit8 v14, v14, 32
    if-eqz v14, +003h
    const/4 v13, 0
    move v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildRemoteUserMessage(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/Integer; Ljava/lang/Long; Z)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v7
    return-object v7
.end method

.method private final buildSelectedDeviceFromConversation(com.bytedance.trae.im.service.Conversation)com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -019h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/im/service/Cli;
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationDevicePolicy;->INSTANCE Lcom/bytedance/trae/conversation/ConversationDevicePolicy;
    sget-object v2, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v5, v1, v2, Lcom/bytedance/trae/conversation/ConversationDevicePolicy;->buildSelectedDevice(Lcom/bytedance/trae/im/service/Conversation; Lcom/bytedance/trae/im/service/Cli; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v5
    return-object v5
.end method

.method private static final cacheRepository_delegate$lambda$1()com.bytedance.trae.im.repository.ConversationDetailCacheRepository
    .registers 3
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00fh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    goto +3h
    const-string v0, "anonymous"
    sget-object v1, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    check-cast v2, Landroid/content/Context;
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/im/database/DatabaseManager;->getDatabase(Landroid/content/Context; Ljava/lang/String;)Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-direct v1, v0, Lcom/bytedance/trae/im/database/ConversationDetailDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V
    new-instance v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    invoke-direct v0, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;-><init>(Lcom/bytedance/trae/im/database/ConversationDetailDao;)V
    return-object v0
.end method

.method private final cacheTaskModelSelection(com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.RemoteModelItem)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, voice_summary
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    return-void 
    sget-object v5, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    invoke-virtual v5, v2, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->environmentKey(Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-virtual v5, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->modeKey(Lcom/bytedance/trae/im/service/Mode;)Ljava/lang/String;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    if-nez v6, +008h
    sget-object v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v6
    invoke-virtual v5, v2, v3, v4, v6, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->saveSessionSelection(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    return-void 
.end method

.method private final contentSecurityBlockedText(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->contentSecurityBlockedMessage(Landroid/content/res/Resources; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method static synthetic contentSecurityBlockedText$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->contentSecurityBlockedText(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final currentConversationMode()com.bytedance.trae.im.service.Mode
    .registers 6
    # ins_size=1
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +022h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v3
    iget-object v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -024h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/service/Mode;
    if-nez v2, +006h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->currentTaskMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v2
    return-object v2
.end method

.method private final currentTaskMode()com.bytedance.trae.im.service.Mode
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentMode Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +005h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method private static final doneListener$lambda$3(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=3
    const-string/jumbo v0, taskId
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const-string v1, "AgentDataFlow"
    if-eqz v0, +00ah
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v7, "[Node3] doneListener: SKIP currentId null/empty"
    invoke-virtual v6, v1, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +021h
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "[Node3] doneListener: SKIP convId mismatch, convId="
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v0, ", currentId="
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v1, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    const/4 v7, 0
    iput-object v7, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentTaskId Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[Node3] doneListener: EMIT taskDone for convId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v1, v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v8, v6
    check-cast v8, Landroidx/lifecycle/ViewModel;
    invoke-static v8, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 0
    new-instance v8, Lcom/bytedance/trae/conversation/ConversationViewModel$doneListener$1$1;
    invoke-direct v8, v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$doneListener$1$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v3, v8
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitStreamingThrottled(com.bytedance.trae.im.model.ParsedChatMessage  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=3
    move-object/from16 v1, v19
    move-object/from16 v0, v21
    const-string v2, "[Node3] throttle: EMIT_IMMEDIATE, elapsed="
    const-string v3, "[Node3] throttle: DEFERRED, elapsed="
    instance-of v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;
    if-eqz v4, +012h
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;
    iget v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->label I
    sub-int/2addr v0, v6
    iput v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->label I
    const/4 v7, 2
    const/4 v8, 1
    const/4 v9, 0
    if-eqz v6, +02fh
    if-eq v6, v8, +018h
    if-ne v6, v7, +00eh
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0deh
    move-exception v0
    goto/16 +0e5h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v6, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Mutex;
    iget-object v10, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$1 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v11, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v18, v10
    move-object v10, v6
    move-object/from16 v6, v18
    goto +19h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingThrottleMutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$0 Ljava/lang/Object;
    move-object/from16 v6, v20
    iput-object v6, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$1 Ljava/lang/Object;
    iput-object v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$2 Ljava/lang/Object;
    iput v8, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->label I
    invoke-interface v0, v9, v4, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v5, +003h
    return-object v5
    move-object v10, v0
    move-object v11, v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v12
    iget-wide v14, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->lastStreamingEmitTime J
    sub-long v14, v12, v14
    const-wide/16 v16, 50
    cmp-long v0, v14, v16
    const-string v7, "ms"
    const-string v8, "AgentDataFlow"
    if-ltz v0, +043h
    iput-wide v12, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->lastStreamingEmitTime J
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingTrailingJob Lkotlinx/coroutines/Job;
    if-eqz v0, +006h
    const/4 v3, 1
    invoke-static v0, v9, v3, v9, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v9, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingStreamingMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v8, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    invoke-direct v11, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->upsertMessages(Ljava/util/List;)V
    invoke-direct v11, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->processTraeRefInSummary(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    if-eqz v0, +064h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_throttledStreamingMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    iput-object v10, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$0 Ljava/lang/Object;
    iput-object v9, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$1 Ljava/lang/Object;
    iput-object v9, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->L$2 Ljava/lang/Object;
    const/4 v2, 2
    iput v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$1;->label I
    invoke-interface v0, v6, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v5, +053h
    return-object v5
    iput-object v6, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingStreamingMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "ms, remaining="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sub-long v3, v16, v14
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v8, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingTrailingJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v5, 1
    if-ne v0, v5, +004h
    move v8, v5
    goto +2h
    move v8, v2
    if-nez v8, +01dh
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v12
    const/4 v13, 0
    const/4 v14, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;
    invoke-direct v0, v3, v4, v11, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;-><init>(J Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v15, v0
    check-cast v15, Lkotlin/jvm/functions/Function2;
    const/16 v16, 3
    const/16 v17, 0
    invoke-static/range v12 ... v17, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingTrailingJob Lkotlinx/coroutines/Job;
    move-object v2, v10
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, v9, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    move-object v2, v10
    invoke-interface v2, v9, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    :try_start_0x36
    :try_start_0x73
    :try_start_0x85
    :try_start_0x117
.end method

.method private final extractQueryFromUserMessageContext(com.bytedance.trae.im.service.UserMessageContext)java.lang.String
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/im/service/UserMessageContext;->getQuery()Ljava/lang/Object;
    move-result-object v3
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    instance-of v1, v3, Ljava/lang/String;
    if-eqz v1, +005h
    check-cast v3, Ljava/lang/String;
    goto +bh
    new-instance v1, Lcom/google/gson/Gson;
    invoke-direct v1, Lcom/google/gson/Gson;-><init>()V
    invoke-virtual v1, v3, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    return-object v3
    :try_start_0xf
.end method

.method private final extractSummaryCharCount(com.bytedance.trae.im.model.ParsedChatMessage)int
    .registers 9
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +0a1h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +09bh
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v3
    if-eqz v3, -010h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move v3, v1
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +03fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-eqz v5, +028h
    sget-object v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->SUMMARY_FINISH_TOOLS Ljava/util/Set;
    invoke-interface v6, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +020h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    if-eqz v4, +01ah
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +014h
    const-string/jumbo v5, summary
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +00bh
    invoke-direct v7, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->extractVoiceSummaryText(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v4
    goto +2h
    move v4, v1
    add-int/2addr v3, v4
    goto -42h
    if-lez v3, +003h
    return v3
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v0, voice_summary
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v1
    invoke-static v2, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v8
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda11;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda11;-><init>()V
    invoke-static v8, v0, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v8
    invoke-static v8, Lkotlin/sequences/SequencesKt;->lastOrNull(Lkotlin/sequences/Sequence;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Integer;
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v1
    return v1
.end method

.method private static final extractSummaryCharCount$lambda$85(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.Integer
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseThought(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getMarkdown()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00bh
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method private final extractVoiceSummaryText(com.google.gson.JsonElement)java.lang.String
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->extractSummaryText(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private final filterDisplayableMessages(java.util.List)java.util.List
    .registers 7
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-virtual v0, v6, Lcom/bytedance/trae/im/model/ChatMessageParser;->parseDisplayableHistoryList(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    check-cast v6, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ChatMessage;
    move-object v4, v0
    check-cast v4, Ljava/lang/Iterable;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-static v4, v3, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -018h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method private final flushPendingUpgradeReminderIfAllowed()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingUpgradeReminderRefresh Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    if-nez v0, +003h
    return-void 
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;->getConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 0
    if-nez v1, +005h
    iput-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingUpgradeReminderRefresh Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    return-void 
    invoke-direct v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->shouldDeferUpgradeReminder()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iput-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingUpgradeReminderRefresh Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;->getMessages()Ljava/util/List;
    move-result-object v0
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateUpgradeReminder(Ljava/util/List;)V
    return-void 
.end method

.method private final getCacheRepository()com.bytedance.trae.im.repository.ConversationDetailCacheRepository
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->cacheRepository$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    return-object v0
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00eh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "events"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method private final handleAnchorLoadError(com.bytedance.trae.network.response.HttpDataResult$Error  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "loadAnchorWindow: API error, code="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", msg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v2
    const-string v3, "ConversationViewModel"
    invoke-virtual v0, v3, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v5
    const/16 v0, 401
    if-ne v5, v0, +014h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_forceLogout Lkotlinx/coroutines/flow/MutableSharedFlow;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v5, v0, v6, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    if-ne v5, v6, +003h
    return-object v5
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +00ch
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_loadError Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v6, 1
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-interface v5, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method public static synthetic handleBrainstormResult$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleBrainstormResult(Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final handleCreateTaskErrorWithoutModelFallbackIfNeeded(long  java.lang.String  com.google.gson.JsonObject  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=6
    move-object/from16 v0, v17
    move-wide/from16 v1, v18
    move-object/from16 v3, v22
    instance-of v4, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;
    if-eqz v4, +012h
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;
    iget v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->label I
    sub-int/2addr v3, v6
    iput v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;
    invoke-direct v4, v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->label I
    const/4 v7, 1
    if-eqz v6, +011h
    if-ne v6, v7, +007h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +086h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const-wide/16 v8, 4001
    cmp-long v3, v1, v8
    if-eqz v3, +008h
    const/4 v1, 0
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v8, sendMessageIternal: create task failed without model fallback, code=
    invoke-direct v6, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v8, ", msg="
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    move-object/from16 v11, v20
    invoke-virtual v6, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v8, "ConversationViewModel"
    invoke-virtual v3, v8, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    invoke-virtual v3, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    const-string v3, "getResources(...)"
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    long-to-int v1, v1
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v10
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 48
    const/16 v16, 0
    move-object/from16 v12, v21
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->displayMessage$default(Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry; Landroid/content/res/Resources; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->getMessage()Ljava/lang/String;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +013h
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_send_retry I
    invoke-virtual v1, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v3, "getString(...)"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput v7, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->label I
    invoke-interface v2, v1, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v5, +003h
    return-object v5
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method

.method private final handleModelUnavailableCreateTaskErrorIfNeeded(long  java.lang.String  com.google.gson.JsonObject  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=8
    move-object v0, v15
    move-wide/from16 v1, v16
    move-object/from16 v3, v19
    move-object/from16 v4, v20
    move-object/from16 v5, v21
    move-object/from16 v6, v22
    instance-of v7, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;
    if-eqz v7, +012h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;
    iget v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->label I
    const/high16 v9, -2147483648
    and-int/2addr v8, v9
    if-eqz v8, +008h
    iget v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->label I
    sub-int/2addr v6, v9
    iput v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->label I
    goto +6h
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;
    invoke-direct v7, v15, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v8
    iget v9, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->label I
    const/4 v10, 2
    const/4 v11, 1
    if-eqz v9, +030h
    if-eq v9, v11, +011h
    if-ne v9, v10, +007h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +089h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-wide v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->J$0 J
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$4 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/im/service/Mode;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$3 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lcom/google/gson/JsonObject;
    iget-object v9, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v12, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v14, v5
    move-object v5, v3
    move-object v3, v14
    goto +3dh
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const-wide/16 v12, 4023
    cmp-long v6, v1, v12
    if-eqz v6, +00eh
    invoke-direct v15, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->shouldSwitchToAutoForModelError(J Lcom/google/gson/JsonObject;)Z
    move-result v6
    if-nez v6, +008h
    const/4 v1, 0
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v9, "create_task_code_"
    invoke-direct v6, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    iput-object v0, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$0 Ljava/lang/Object;
    move-object/from16 v9, v18
    iput-object v9, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$1 Ljava/lang/Object;
    iput-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$2 Ljava/lang/Object;
    iput-object v4, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$3 Ljava/lang/Object;
    iput-object v5, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$4 Ljava/lang/Object;
    iput-wide v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->J$0 J
    iput v11, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->label I
    invoke-direct v15, v4, v5, v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->switchSelectedModelToAuto(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v8, +003h
    return-object v8
    move-object v12, v0
    move-object/from16 v16, v12
    move-wide/from16 v17, v1
    move-object/from16 v19, v9
    move-object/from16 v20, v3
    move-object/from16 v21, v4
    move-object/from16 v22, v5
    invoke-direct/range v16 ... v22, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildModelUnavailableMessage(J Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode;)Ljava/lang/String;
    move-result-object v1
    iget-object v2, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    const/4 v3, 0
    iput-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$0 Ljava/lang/Object;
    iput-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$1 Ljava/lang/Object;
    iput-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$2 Ljava/lang/Object;
    iput-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$3 Ljava/lang/Object;
    iput-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->L$4 Ljava/lang/Object;
    iput v10, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1;->label I
    invoke-interface v2, v1, v7, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v8, +003h
    return-object v8
    invoke-static v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method

.method private final handleModelUnavailableLoadedMessagesIfNeeded(java.util.List  java.lang.String)void
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    if-eqz v2, +003h
    return-void 
    check-cast v8, Ljava/lang/Iterable;
    invoke-static v8, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v8
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v8, v2, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v8
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda3;
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v8, v2, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v8
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda4;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda4;-><init>(Ljava/lang/String;)V
    invoke-static v8, v2, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v8
    invoke-interface v8, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-nez v0, +003h
    goto +2ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-nez v0, +003h
    goto +1fh
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v2
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v4
    cmp-long v6, v2, v4
    if-gez v6, +004h
    move-object v1, v0
    move-wide v2, v4
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-nez v0, -015h
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v1, +003h
    return-void 
    invoke-direct v7, v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleModelUnavailableMessageErrorIfNeeded(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)V
    return-void 
.end method

.method private static final handleModelUnavailableLoadedMessagesIfNeeded$lambda$55(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v1
    return v1
.end method

.method private static final handleModelUnavailableLoadedMessagesIfNeeded$lambda$56(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 3
    # ins_size=1
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v0
    const-string v1, "failed"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private static final handleModelUnavailableLoadedMessagesIfNeeded$lambda$57(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method private final handleModelUnavailableMessageErrorIfNeeded(com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String)void
    .registers 19
    # ins_size=3
    move-object/from16 v9, v16
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +066h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    int-to-long v4, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    invoke-direct v9, v4, v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->shouldSwitchToAutoForModelError(J Lcom/google/gson/JsonObject;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v2, +003h
    return-void 
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/ConversationViewModel;->currentConversationMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v3
    move-object/from16 v7, v17
    invoke-direct v9, v7, v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->modelFallbackErrorKey(Lcom/bytedance/trae/im/model/ParsedChatMessage; J)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +021h
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->handledModelFallbackErrorKeys Ljava/util/Set;
    invoke-interface v1, v0, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +019h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleModelUnavailableMessageErrorIfNeeded: already handled, key="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v2, "ConversationViewModel"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v10
    const/4 v11, 0
    const/4 v12, 0
    new-instance v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;
    const/4 v8, 0
    move-object v0, v13
    move-object/from16 v1, v16
    move-object/from16 v6, v18
    move-object/from16 v7, v17
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; J Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v13, Lkotlin/jvm/functions/Function2;
    const/4 v14, 3
    const/4 v15, 0
    invoke-static/range v10 ... v15, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final hasLoadedNewerSide(java.util.List  java.lang.String  int)boolean
    .registers 10
    # ins_size=4
    invoke-static v8, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v8
    const/4 v0, 0
    if-eqz v8, +041h
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    check-cast v7, Ljava/lang/Iterable;
    instance-of v8, v7, Ljava/util/Collection;
    const/4 v3, 1
    if-eqz v8, +00dh
    move-object v8, v7
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +004h
    move v8, v0
    goto +27h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    move v8, v0
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01dh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v4
    cmp-long v4, v4, v1
    if-lez v4, +004h
    move v4, v3
    goto +2h
    move v4, v0
    if-eqz v4, -017h
    add-int/lit8 v8, v8, 1
    if-gez v8, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    if-lt v8, v9, +003h
    move v0, v3
    return v0
.end method

.method private final hasLoadedOlderSide(java.util.List  java.lang.String  int)boolean
    .registers 10
    # ins_size=4
    invoke-static v8, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v8
    const/4 v0, 0
    if-eqz v8, +041h
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    check-cast v7, Ljava/lang/Iterable;
    instance-of v8, v7, Ljava/util/Collection;
    const/4 v3, 1
    if-eqz v8, +00dh
    move-object v8, v7
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +004h
    move v8, v0
    goto +27h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    move v8, v0
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01dh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v4
    cmp-long v4, v4, v1
    if-gez v4, +004h
    move v4, v3
    goto +2h
    move v4, v0
    if-eqz v4, -017h
    add-int/lit8 v8, v8, 1
    if-gez v8, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    if-lt v8, v9, +003h
    move v0, v3
    return v0
.end method

.method public static synthetic init$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  com.bytedance.trae.im.service.Conversation  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.Conversation
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->init(Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    return-object v0
.end method

.method private final initSelectedDevice(com.bytedance.trae.im.service.Conversation)void
    .registers 15
    # ins_size=2
    if-nez v14, +01dh
    iget-object v14, v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const-string v1, ""
    const-string v2, ""
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 496
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v14, v12, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
    invoke-direct v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildSelectedDeviceFromConversation(Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v14
    iget-object v0, v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v14, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v14
    invoke-direct v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateConversationEnvironment(Lcom/bytedance/trae/im/service/CliType;)V
    return-void 
.end method

.method private final internalUsageLimitModelNames(com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode)java.util.List
    .registers 7
    # ins_size=3
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->modelListFunctions(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode;)Ljava/util/List;
    move-result-object v6
    invoke-interface v6, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    return-object v5
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->getCachedModelsForUi(Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    if-nez v5, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +01bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit()Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -01ah
    invoke-interface v6, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    const/16 v0, 10
    invoke-static v6, v0, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v0
    invoke-direct v5, v0, Ljava/util/ArrayList;-><init>(I)V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v5, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -21h
    check-cast v5, Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +016h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v1
    if-eqz v2, -014h
    invoke-interface v6, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v6, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v5
    return-object v5
.end method

.method private final isDownloadFileTooLargeBizError(com.bytedance.trae.network.response.HttpDataResult)boolean
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v1, 0
    if-eqz v0, +02fh
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v0, v2, v4
    if-nez v0, +01fh
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v7
    const/4 v0, 1
    if-eqz v7, +010h
    check-cast v7, Ljava/lang/CharSequence;
    const-string v2, "Download file too large"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v7, v2, v0, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v7
    if-ne v7, v0, +004h
    move v7, v0
    goto +2h
    move v7, v1
    if-eqz v7, +003h
    move v1, v0
    return v1
.end method

.method private final isInternalUser()boolean
    .registers 5
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v1
    const-string v2, "bytecloud"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 1
    if-nez v1, +014h
    const/4 v1, 0
    if-eqz v0, +00ch
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getOdinUserType()I
    move-result v0
    const/16 v3, 12
    if-ne v0, v3, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    goto +2h
    move v2, v1
    return v2
.end method

.method private final loadAnchorMessagesByCreatedAt(java.lang.String  java.lang.String  int  int  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=7
    move-object v10, v15
    move-object/from16 v0, v21
    instance-of v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;
    if-eqz v1, +012h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;
    invoke-direct v1, v15, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v11, v1
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v12
    iget v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->label I
    const/4 v13, 2
    const/4 v2, 1
    const/4 v14, 0
    if-eqz v1, +01bh
    if-eq v1, v2, +011h
    if-ne v1, v13, +007h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a4h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/4 v6, 0
    const/16 v8, 32
    const/4 v9, 0
    iput-object v10, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->L$0 Ljava/lang/Object;
    iput v2, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->label I
    move-object v0, v15
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move/from16 v3, v18
    move/from16 v4, v19
    move/from16 v5, v20
    move-object v7, v11
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v12, +003h
    return-object v12
    move-object v1, v10
    check-cast v0, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +05ah
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-nez v2, +033h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "loadAnchorMessagesByCreatedAt biz error: code="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", msg="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v2, "ConversationViewModel"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +2dh
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->getMessages()Ljava/util/List;
    move-result-object v14
    if-nez v14, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v14
    invoke-direct v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->filterDisplayableMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v14
    goto +12h
    instance-of v2, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +010h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    iput-object v14, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->L$0 Ljava/lang/Object;
    iput v13, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorMessagesByCreatedAt$1;->label I
    invoke-direct v1, v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleAnchorLoadError(Lcom/bytedance/trae/network/response/HttpDataResult$Error; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v12, +003h
    return-object v12
    return-object v14
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method

.method private final loadAnchorWindow(java.lang.String)void
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
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
    if-eqz v1, +003h
    return-void 
    iput-boolean v3, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->isAnchorWindowMode Z
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isAnchorWindowLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMessages(Ljava/util/List;)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iput-boolean v2, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreNewerAnchorMessages Z
    const/4 v1, 0
    iput-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->latestPrefetchMessages Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;
    invoke-direct v2, v9, v0, v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static synthetic loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  int  int  boolean  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 32
    if-eqz v0, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$2;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$2;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    move-object v7, v0
    goto +2h
    move-object v7, v15
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move v4, v12
    move v5, v13
    move v6, v14
    move-object/from16 v8, v16
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease(Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic loadNewerAnchorMessages$default(com.bytedance.trae.conversation.ConversationViewModel  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +007h
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda2;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadNewerAnchorMessages(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final loadNewerAnchorMessages$lambda$25()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final mergeMessages(java.util.List  java.util.List)java.util.List
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    check-cast v2, Ljava/util/Collection;
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v2, v3, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->sortMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method private final mergeMessagesIntoState(java.util.List  java.util.List)java.util.List
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda5;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    invoke-virtual v0, v3, v4, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->mergeMessages(Ljava/util/List; Ljava/util/List; Lkotlin/jvm/functions/Function2;)Ljava/util/List;
    move-result-object v3
    return-object v3
.end method

.method private static final mergeMessagesIntoState$lambda$33(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)kotlin.Unit
    .registers 5
    # ins_size=3
    const-string v0, "oldMessageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fixedMessage"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00bh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->onUserMessageFixup(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final metadataDoneListener$lambda$7(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  com.bytedance.trae.im.service.UserMessageContext)void
    .registers 68
    # ins_size=4
    move-object/from16 v1, v64
    move-object/from16 v0, v65
    move-object/from16 v4, v66
    move-object/from16 v3, v67
    const-string v2, "conversationId"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, userMessageContext
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/16 v41, 1
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v6
    goto +3h
    move/from16 v5, v41
    if-nez v5, +149h
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +141h
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v6
    goto +3h
    move/from16 v2, v41
    if-eqz v2, +003h
    return-void 
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageIds Ljava/util/Set;
    invoke-interface v2, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    instance-of v5, v2, Ljava/util/Collection;
    if-eqz v5, +00dh
    move-object v5, v2
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +004h
    move v2, v6
    goto +1dh
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, -00ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -014h
    move/from16 v2, v41
    if-eqz v2, +003h
    return-void 
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->extractQueryFromUserMessageContext(Lcom/bytedance/trae/im/service/UserMessageContext;)Ljava/lang/String;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v6
    goto +3h
    move/from16 v5, v41
    if-eqz v5, +003h
    return-void 
    sget-object v5, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-virtual v5, v2, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->parseQuery(Ljava/lang/String;)Ljava/util/List;
    move-result-object v15
    sget-object v2, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    const/4 v5, 2
    const/4 v7, 0
    invoke-static v2, v15, v7, v5, v7, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->extractText$default(Lcom/bytedance/trae/im/model/MessagePartNormalizer; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v42
    move-object/from16 v2, v42
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v6
    goto +3h
    move/from16 v2, v41
    if-eqz v2, +012h
    move-object v2, v15
    check-cast v2, Ljava/util/Collection;
    if-eqz v2, +008h
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move/from16 v6, v41
    if-eqz v6, +003h
    return-void 
    new-instance v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object/from16 v2, v62
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const-string/jumbo v9, user
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v63, v15
    move-object/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const-wide/16 v25, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v43, 0
    const/16 v44, 1
    invoke-virtual/range v67, Lcom/bytedance/trae/im/service/UserMessageContext;->isAppendMsg()Ljava/lang/Boolean;
    move-result-object v3
    invoke-static/range v41, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v45
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, -68
    const v60, 8387743
    const/16 v61, 0
    move-object/from16 v3, v65
    move-object/from16 v4, v66
    move-object/from16 v41, v42
    move-object/from16 v42, v63
    const/4 v5, 0
    invoke-direct/range v2 ... v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v2, v1
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v6
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;
    const/4 v5, 0
    move-object v0, v9
    move-object/from16 v1, v64
    move-object/from16 v2, v66
    move-object/from16 v3, v62
    move-object/from16 v4, v65
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v0, v9
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v1, 3
    const/4 v2, 0
    move-object v3, v6
    move-object v4, v7
    move-object v5, v8
    move-object v6, v0
    move v7, v1
    move-object v8, v2
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final modelFallbackErrorKey(com.bytedance.trae.im.model.ParsedChatMessage  long)java.lang.String
    .registers 7
    # ins_size=4
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    const/4 v2, 0
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    if-nez v0, +030h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v0
    if-eqz v0, +014h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00eh
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    if-nez v0, +015h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskIdUser()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00eh
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +025h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v1, 124
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private final modelListFunctions(com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode)java.util.List
    .registers 5
    # ins_size=3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00ah
    const-string/jumbo v3, solo_agent
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +55h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00eh
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v4, v0, +00ah
    const-string/jumbo v3, solo_agent_lite
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +41h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00eh
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    if-ne v4, v0, +00ah
    const-string/jumbo v3, solo_work_lite
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +2dh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00eh
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v4, v0, +00ah
    const-string/jumbo v3, solo_agent_remote
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +19h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +00eh
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    if-ne v4, v3, +00ah
    const-string/jumbo v3, solo_work_remote
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    return-object v3
.end method

.method private final notifyTaskListStatusChanged(java.lang.String  java.lang.String)void
    .registers 34
    # ins_size=3
    move-object/from16 v0, v31
    move-object/from16 v1, v33
    if-eqz v1, +08bh
    invoke-virtual/range v33, Ljava/lang/String;->hashCode()I
    move-result v2
    sparse-switch v2, +0000086h
    goto/16 +082h
    const-string v2, "canceled"
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +078h
    const-string v1, "4"
    goto +24h
    const-string v2, "in_progress"
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +6bh
    const-string v1, "3"
    goto +18h
    const-string v2, "failed"
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +5fh
    const-string v1, "6"
    goto +ch
    const-string v2, "completed"
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +53h
    const-string v1, "5"
    move-object v13, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v2, +003h
    return-void 
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 67107839
    const/16 v30, 0
    invoke-static/range v2 ... v30, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    new-instance v3, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;
    const-string/jumbo v4, update
    move-object/from16 v5, v32
    invoke-direct v3, v4, v5, v1, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/service/IMService;->notifyConversationChanged(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    return-void 
    sparse-switch-payload -539f09b5 -4c696bc3 -2cea1ff9 -7577b67
.end method

.method private final performCreateTaskCheck(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=3
    instance-of v0, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;
    invoke-direct v0, v12, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v2, +022h
    if-eq v2, v5, +018h
    if-eq v2, v4, +011h
    if-ne v2, v3, +007h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0b0h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v14, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v14, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0dch
    iget-object v13, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v14, Lcom/bytedance/trae/im/service/ICreateTaskCheck;->Companion Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
    new-instance v2, Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;
    invoke-direct v2, v13, Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;-><init>(Ljava/lang/String;)V
    iput-object v12, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->label I
    invoke-virtual v14, v2, v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->createTaskCheckRawCall(Lcom/bytedance/trae/im/service/CreateTaskCheckRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    move-object v13, v12
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v5, "ConversationViewModel"
    if-eqz v2, +0b7h
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    const-wide/32 v9, 2900101
    cmp-long v2, v7, v9
    const-string v7, "getString(...)"
    const-wide/32 v8, 2900105
    if-eqz v2, +075h
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v10
    cmp-long v2, v10, v8
    if-nez v2, +003h
    goto +67h
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    if-eqz v14, +009h
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;
    goto +2h
    move-object v14, v6
    if-eqz v14, +04eh
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v8, "createTaskCheck success: projectId="
    invoke-direct v4, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getProjectId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", available="
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getAvailable()Z
    move-result v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v5, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getAvailable()Z
    move-result v2
    if-nez v2, +01fh
    iget-object v13, v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    sget-object v14, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v14
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_ide_device_offline I
    invoke-virtual v14, v2, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->label I
    invoke-interface v13, v14, v0, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v1, +003h
    return-object v1
    return-object v6
    invoke-direct v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->applyCreateTaskCheckResult(Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;)V
    iget-object v13, v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v13, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    move-object v6, v13
    check-cast v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    goto +59h
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v2
    cmp-long v14, v2, v8
    if-nez v14, +005h
    sget v14, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_ide_device_offline I
    goto +3h
    sget v14, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    iget-object v13, v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->_toastText Lkotlinx/coroutines/flow/MutableSharedFlow;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    invoke-virtual v2, v14, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$performCreateTaskCheck$1;->label I
    invoke-interface v13, v14, v0, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v1, +003h
    return-object v1
    return-object v6
    instance-of v13, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v13, +02bh
    sget-object v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "createTaskCheck error: code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", msg="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v13, v5, v14, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v6
    new-instance v13, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v13, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v13
.end method

.method private final performPinAction(boolean)void
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +015h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +003h
    return-void 
    invoke-virtual v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->supportsPin()Z
    move-result v2
    if-nez v2, +003h
    return-void 
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$performPinAction$1;
    invoke-direct v2, v10, v0, v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$performPinAction$1;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final pinFailureString(boolean)int
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_pin_failed I
    goto +3h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_unpin_failed I
    return v1
.end method

.method private final pinSuccessString(boolean)int
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_pin_success I
    goto +3h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_unpin_success I
    return v1
.end method

.method private final prefetchLatestMessages(java.lang.String)void
    .registers 9
    # ins_size=2
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final processTraeRefInSummary(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v4
    instance-of v0, v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    if-eqz v0, +005h
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    goto +2h
    const/4 v4, 0
    const/4 v0, 1
    if-nez v4, +003h
    return v0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v4
    if-eqz v4, +060h
    invoke-static v4, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    if-nez v4, +003h
    goto +56h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v4
    if-nez v4, +003h
    return v0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    if-eqz v1, +04ah
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +42h
    sget-object v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->SUMMARY_FINISH_TOOLS Ljava/util/Set;
    invoke-interface v2, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    if-eqz v4, +034h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +02eh
    const-string/jumbo v1, summary
    invoke-virtual v4, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-nez v4, +003h
    goto +23h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-nez v1, +003h
    return v0
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    return v0
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->canEmit(Ljava/lang/String;)Z
    move-result v4
    if-nez v4, +004h
    const/4 v4, 0
    return v4
    return v0
.end method

.method private final readBoolean(com.google.gson.JsonObject  java.lang.String)java.lang.Boolean
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +036h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +030h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +026h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
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
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/Boolean;
    return-object v0
    :try_start_0x13
.end method

.method private final readString(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +03fh
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +039h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +02fh
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
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
    move-object v2, v0
    check-cast v2, Ljava/lang/String;
    if-eqz v2, +00eh
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    move-object v0, v2
    return-object v0
    :try_start_0x13
.end method

.method private final recoverHistoricalIdeProjectDevice(com.bytedance.trae.conversation.devices.SelectedDeviceItem)com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 17
    # ins_size=2
    move-object v0, v15
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation Z
    if-nez v1, +08ch
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v1, v2, +084h
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +004h
    goto/16 +06ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v1, +003h
    return-object v16
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ownerIdeProjectId(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v7
    if-nez v7, +003h
    return-object v16
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +008h
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ideProjectPath(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v1
    move-object v5, v1
    goto +2h
    move-object v5, v4
    const/4 v4, 0
    const/4 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 1
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectName()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +024h
    const/4 v1, 0
    if-eqz v5, +021h
    new-array v11, v3, [C
    const/16 v12, 47
    aput-char v12, v11, v2
    invoke-static v5, v11, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +015h
    const/4 v11, 2
    invoke-static v2, v12, v1, v11, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00eh
    move-object v11, v2
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    xor-int/2addr v3, v11
    if-eqz v3, +004h
    move-object v11, v2
    goto +2h
    move-object v11, v1
    const/4 v12, 0
    const/16 v13, 279
    const/4 v14, 0
    move-object/from16 v1, v16
    move-object v2, v4
    move-object v3, v6
    move-object v4, v8
    move-object v6, v9
    move v8, v10
    move-object v9, v11
    move v10, v12
    move v11, v13
    move-object v12, v14
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-object v1
    return-object v16
.end method

.method private final recoverStreamingMessages()void
    .registers 15
    # ins_size=1
    iget-object v0, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
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
    if-eqz v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v1, v0, Lcom/bytedance/trae/im/service/IMService;->getStreamingMessages(Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iget-object v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +013h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v6
    if-eqz v6, -011h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-nez v4, +004h
    const/4 v1, 0
    goto +2ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-nez v5, +004h
    move-object v1, v4
    goto +20h
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v5
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v8
    cmp-long v10, v5, v8
    if-gez v10, +004h
    move-object v4, v7
    move-wide v5, v8
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-nez v7, -015h
    goto -20h
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const-string v4, "AgentDataFlow"
    if-nez v1, +00ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "[Node3] recoverStreamingMessages: no user message found in _messages, skip recovery"
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    move-object v5, v0
    check-cast v5, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +017h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -015h
    invoke-interface v6, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v6, Ljava/util/List;
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "[Node3] recoverStreamingMessages: cached="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v9
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v9, ", latestUserMsgId="
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v10, ", matched="
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v11
    invoke-virtual v7, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v4, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v6, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +04eh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    sget-object v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v12
    const/16 v13, 32
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v4, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v11
    if-eqz v11, +008h
    iget-object v11, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-interface v11, v7, v3, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -4bh
    iget-object v11, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-interface v11, v7, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -51h
    return-void 
.end method

.method private static final remoteUserMessageListener$lambda$5(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.Integer  java.lang.Long  boolean)void
    .registers 18
    # ins_size=7
    move-object v0, v11
    move-object v1, v12
    move-object v2, v13
    const-string v3, "conversationId"
    invoke-static v12, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "messageId"
    invoke-static v13, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v6
    goto +2h
    move v4, v5
    if-nez v4, +087h
    invoke-static v12, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +07fh
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageIds Ljava/util/Set;
    invoke-interface v3, v13, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    instance-of v4, v3, Ljava/util/Collection;
    if-eqz v4, +00dh
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v5, v6
    goto +1bh
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -014h
    if-eqz v5, +003h
    return-void 
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildRemoteUserMessage(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/Integer; Ljava/lang/Long; Z)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageIds Ljava/util/Set;
    invoke-interface v4, v13, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-object v2, v0
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationViewModel$remoteUserMessageListener$1$2;
    const/4 v10, 0
    invoke-direct v7, v11, v3, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$remoteUserMessageListener$1$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationViewModel$remoteUserMessageListener$1$3;
    invoke-direct v6, v11, v12, v3, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$remoteUserMessageListener$1$3;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    move-object v0, v6
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v1, 2
    const/4 v3, 0
    move-object v11, v2
    move-object v12, v4
    move-object v13, v5
    move-object v14, v0
    move v15, v1
    move-object/from16 v16, v3
    invoke-static/range v11 ... v16, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final replaceMessagesPreservingRuntime(java.util.List)void
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +019h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v4, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -017h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v1, Ljava/util/List;
    invoke-direct v5, v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->mergeMessagesIntoState(Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMessages(Ljava/util/List;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v1, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    check-cast v6, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-static v6, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v3, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v3, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v6
    check-cast v6, Ljava/util/Collection;
    invoke-interface v1, v6, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, v0, Ljava/util/Set;->retainAll(Ljava/util/Collection;)Z
    return-void 
.end method

.method private final reportCheckpointConfirmTaskError(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision  java.lang.String  com.bytedance.trae.network.response.HttpDataResult$Error)void
    .registers 9
    # ins_size=4
    const-string v0, "error_code"
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "decision"
    invoke-virtual v1, v2, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v7, tool_name
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getToolName()Ljava/lang/String;
    move-result-object v2
    const-string v3, ""
    if-nez v2, +003h
    move-object v2, v3
    invoke-virtual v1, v7, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v7
    invoke-static v7, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v0, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "has_throwable"
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v2
    if-eqz v2, +005h
    const-string v2, "1"
    goto +3h
    const-string v2, "0"
    invoke-virtual v1, v7, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v2
    invoke-virtual v7, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v2, "conversation_id"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getConversationId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +2h
    move-object v3, v4
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, task_id
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "plan_item_id"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getPlanItemId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v2, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v6, "error_msg"
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v6, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v6
    if-eqz v6, +014h
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    if-eqz v6, +00eh
    invoke-virtual v6, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +008h
    const-string/jumbo v8, throwable_type
    invoke-virtual v0, v8, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v8, "checkpoint_confirm_task_error"
    invoke-virtual v6, v8, v1, v7, v0, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +ch
    move-exception v6
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "ConversationViewModel"
    const-string/jumbo v0, reportCheckpointConfirmTaskError failed
    invoke-virtual v7, v8, v0, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x2
    :try_start_0x18
.end method

.method private final reportDiscussionSummaryPerf(boolean)void
    .registers 36
    # ins_size=2
    move-object/from16 v1, v34
    move/from16 v0, v35
    const-string v2, "conversation_id"
    const-string v3, "is_new_session"
    const-string v4, "is_success"
    const-string/jumbo v5, render_first_char_lag_ms
    const-string v6, "data_first_char_ms"
    const-string v7, "char_count"
    const-string/jumbo v8, streaming_ms
    const-string v9, "last_char_ms"
    const-string v10, "first_char_ms"
    const-string/jumbo v11, total_ms
    const-string v12, "ConversationViewModel"
    const-string/jumbo v13, reportDiscussionSummaryPerf: success=
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v14
    move-object/from16 v16, v12
    move-object/from16 v17, v13
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryStartTimestamp J
    sub-long/2addr v14, v12
    const-wide/16 v12, 0
    invoke-static v14, v15, v12, v13, Ljava/lang/Math;->max(J J)J
    move-result-wide v14
    sget-object v18, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->getFirstCharOnScreenMs()J
    move-result-wide v18
    sget-object v20, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->getLastCharOnScreenMs()J
    move-result-wide v20
    cmp-long v22, v18, v12
    const-wide/16 v23, -1
    if-lez v22, +011h
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryStartTimestamp J
    sub-long v12, v18, v12
    move-object/from16 v27, v2
    move-object/from16 v28, v3
    const-wide/16 v2, 0
    invoke-static v12, v13, v2, v3, Ljava/lang/Math;->max(J J)J
    move-result-wide v12
    goto +8h
    move-object/from16 v27, v2
    move-object/from16 v28, v3
    move-wide v2, v12
    move-wide/from16 v12, v23
    cmp-long v25, v20, v2
    if-lez v25, +011h
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryStartTimestamp J
    sub-long v2, v20, v2
    move-object/from16 v26, v4
    move-object/from16 v31, v5
    const-wide/16 v4, 0
    invoke-static v2, v3, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v2
    goto +8h
    move-object/from16 v26, v4
    move-object/from16 v31, v5
    move-wide v4, v2
    move-wide/from16 v2, v23
    if-lez v22, +011h
    if-lez v25, +00fh
    move-object/from16 v25, v6
    move-object/from16 v29, v7
    sub-long v6, v20, v18
    invoke-static v6, v7, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v6
    move-wide/from16 v20, v6
    goto +7h
    move-object/from16 v25, v6
    move-object/from16 v29, v7
    move-wide/from16 v20, v23
    iget-wide v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryDataFirstCharTimestamp J
    cmp-long v30, v6, v4
    if-lez v30, +00ch
    iget-wide v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryStartTimestamp J
    sub-long/2addr v6, v4
    const-wide/16 v4, 0
    invoke-static v6, v7, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v6
    goto +3h
    move-wide/from16 v6, v23
    if-lez v22, +011h
    move-wide/from16 v32, v6
    iget-wide v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryDataFirstCharTimestamp J
    cmp-long v22, v6, v4
    if-lez v22, +00bh
    sub-long v6, v18, v6
    invoke-static v6, v7, v4, v5, Ljava/lang/Math;->max(J J)J
    move-result-wide v23
    goto +3h
    move-wide/from16 v32, v6
    move-wide/from16 v4, v23
    iget v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryCharCount I
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v7, v11, v14, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v7, v10, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v7, v9, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v18, v2
    move-wide/from16 v2, v20
    invoke-virtual v7, v8, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v20, v2
    move-object/from16 v2, v29
    invoke-virtual v7, v2, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object/from16 v29, v2
    move/from16 v22, v6
    move-object/from16 v6, v25
    move-wide/from16 v2, v32
    invoke-virtual v7, v6, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v32, v2
    move-object/from16 v2, v31
    invoke-virtual v7, v2, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    move-object/from16 v31, v2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryCliType Lcom/bytedance/trae/im/service/CliType;
    move-wide/from16 v23, v4
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v3, v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->commonCategory(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    move-result-object v2
    const-string v3, "1"
    const-string v4, "0"
    if-eqz v0, +006h
    move-object v5, v3
    move-object/from16 v25, v5
    goto +4h
    move-object/from16 v25, v3
    move-object v5, v4
    move-object/from16 v3, v26
    invoke-virtual v2, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-boolean v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryIsNewSession Z
    if-eqz v5, +007h
    move-object/from16 v26, v4
    move-object/from16 v5, v25
    goto +4h
    move-object v5, v4
    move-object/from16 v26, v5
    move-object/from16 v4, v28
    invoke-virtual v2, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    move-object/from16 v28, v6
    const-string/jumbo v6, session_id
    move-object/from16 v30, v8
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summarySessionId Ljava/lang/String;
    invoke-virtual v5, v6, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summarySessionId Ljava/lang/String;
    move-object/from16 v8, v27
    invoke-virtual v5, v8, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v6, room_id
    move-object/from16 v27, v9
    const-string v9, ""
    invoke-virtual v5, v6, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string/jumbo v9, voice_discussion_summary_perf
    invoke-virtual v6, v9, v2, v7, v5, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryMode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v5, v2, v6, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->putVoiceCommonParams(Lorg/json/JSONObject; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode;)Lorg/json/JSONObject;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summarySessionId Ljava/lang/String;
    invoke-virtual v2, v8, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v0, +005h
    move-object/from16 v5, v25
    goto +3h
    move-object/from16 v5, v26
    invoke-virtual v2, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-boolean v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryIsNewSession Z
    if-eqz v3, +005h
    move-object/from16 v3, v25
    goto +3h
    move-object/from16 v3, v26
    invoke-virtual v2, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v11, v14, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v2, v10, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v3, v18
    move-object/from16 v5, v27
    invoke-virtual v2, v5, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v6, v20
    move-object/from16 v5, v30
    invoke-virtual v2, v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move/from16 v5, v22
    move-object/from16 v8, v29
    invoke-virtual v2, v8, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object/from16 v10, v28
    move-wide/from16 v8, v32
    invoke-virtual v2, v10, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-wide/from16 v10, v23
    move-object/from16 v1, v31
    invoke-virtual v2, v1, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    move/from16 v22, v5
    const-string/jumbo v5, voice_discussion_summary_end
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v17
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " total="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "ms first="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "ms last="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "ms streaming="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "ms data_first="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "ms render_first_lag="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v10, v11, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "ms chars="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move/from16 v1, v22
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v1, v16
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    goto +fh
    move-exception v0
    goto +7h
    move-exception v0
    move-object/from16 v1, v16
    goto +3h
    move-exception v0
    move-object v1, v12
    const-string/jumbo v2, reportDiscussionSummaryPerf failed
    invoke-static v1, v2, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    sget-object v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->stop()V
    return-void 
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->stop()V
    throw v0
    :try_start_0x20
    :try_start_0x28
    :try_start_0xfe
    :try_start_0x1f1
    :try_start_0x1fd
.end method

.method private final resetAnchorWindowState()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->isAnchorWindowMode Z
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isAnchorWindowLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreNewerAnchorMessages Z
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v3, 1
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isLoadingMore Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->isLoadingNewerAnchorMessages Z
    return-void 
.end method

.method private final resolveInitialConversation(java.lang.String  com.bytedance.trae.im.service.Conversation)com.bytedance.trae.im.service.Conversation
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationUtils;->INSTANCE Lcom/bytedance/trae/conversation/ConversationUtils;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/ConversationUtils;->resolveInitialConversation(Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    return-object v2
.end method

.method private final resolveModelListFunctions(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode)java.util.List
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v0, +00eh
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v3, v0, +00ah
    const-string/jumbo v2, solo_agent_lite
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    goto +31h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v0, +00ah
    const-string/jumbo v2, solo_work_lite
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    goto +25h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v0, +00eh
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v3, v0, +00ah
    const-string/jumbo v2, solo_agent_remote
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    goto +15h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v0, +00eh
    sget-object v2, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    if-ne v3, v2, +00ah
    const-string/jumbo v2, solo_work_remote
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method public static synthetic retryMessage$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.util.List  com.bytedance.trae.conversation.network.RemoteModelItem  boolean  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    const/4 v5, 0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->retryMessage(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z)V
    return-void 
.end method

.method private final saveSelectedRepo()void
    .registers 6
    # ins_size=1
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation Z
    if-eqz v0, +07ah
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v0
    if-eqz v0, +072h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const-string/jumbo v1, selected_repo
    if-eqz v0, +062h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +053h
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v2, "id"
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, title
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getTitle()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, subtitle
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getSubtitle()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, repoUrl
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v2
    invoke-virtual v0, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    goto +ah
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/bytedance/keva/Keva;->erase(Ljava/lang/String;)V
    return-void 
    :try_start_0x4
    :try_start_0x13
.end method

.method public static synthetic sendMessage$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Mode  com.bytedance.trae.conversation.network.RemoteModelItem  boolean  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 8
    if-eqz v13, +003h
    const/4 v10, 0
    move-object v4, v10
    and-int/lit8 v10, v12, 16
    if-eqz v10, +003h
    const/4 v11, 0
    move v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessage(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z)V
    return-void 
.end method

.method public static synthetic sendMessageIternal$default(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  com.bytedance.trae.im.service.Mode  java.lang.String  com.bytedance.trae.conversation.network.RemoteModelItem  boolean  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 25
    # ins_size=12
    move/from16 v0, v23
    and-int/lit8 v1, v0, 16
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +005h
    const/4 v1, 0
    move v9, v1
    goto +3h
    move/from16 v9, v19
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v21
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v22
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    invoke-virtual/range v3 ... v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessageIternal(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final setMessages(java.util.List)void
    .registers 4
    # ins_size=2
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->isMessageListCommitPendingForUpgradeReminder Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;-><init>(Ljava/util/List;)V
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final shouldDeferUpgradeReminder()boolean
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning Z
    const/4 v1, 1
    if-nez v0, +039h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STREAMING Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    if-eq v0, v2, +02fh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +01fh
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->isUserMessagePending Z
    if-nez v0, +01bh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingStreamingMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v0, +017h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingTrailingJob Lkotlinx/coroutines/Job;
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +008h
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->isMessageListCommitPendingForUpgradeReminder Z
    if-eqz v0, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method private final shouldSwitchToAutoForModelError(long  com.google.gson.JsonObject)boolean
    .registers 9
    # ins_size=4
    const-wide/16 v0, 4008
    cmp-long v0, v6, v0
    const/4 v1, 0
    const/4 v2, 1
    if-nez v0, +019h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->isInternalUser()Z
    move-result v6
    if-eqz v6, +01ah
    const-string v6, "is_internal_usage_limit"
    invoke-direct v5, v8, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +00ah
    goto +7h
    const-wide/16 v3, 4037
    cmp-long v6, v6, v3
    if-nez v6, +003h
    move v1, v2
    return v1
.end method

.method private static final streamingMessageListener$lambda$2(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 23
    # ins_size=3
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    move/from16 v2, v22
    const-string v3, "message"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v6
    goto +2h
    move v4, v5
    const-string v7, "AgentDataFlow"
    if-eqz v4, +00ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "[Node3] streamingListener: SKIP currentId null/empty"
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +025h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "[Node3] streamingListener: SKIP sessionId mismatch, msg.sessionId="
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", currentId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v4
    if-eqz v4, +00dh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v4
    if-eqz v4, +007h
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    goto +2h
    move v4, v6
    sget-object v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, "[Node3] streamingListener: EMIT, planItemCount="
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v9, ", status="
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v9, ", isHistory="
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v9
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v9, ", isDone="
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v8, v7, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v4
    const/4 v7, 0
    if-nez v4, +010h
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v7
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentTaskId Ljava/lang/String;
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isSummaryTracking Z
    if-eqz v4, +01eh
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v4
    if-nez v4, +018h
    invoke-direct/range v20 ... v21, Lcom/bytedance/trae/conversation/ConversationViewModel;->extractSummaryCharCount(Lcom/bytedance/trae/im/model/ParsedChatMessage;)I
    move-result v4
    if-lez v4, +012h
    iget-wide v8, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryDataFirstCharTimestamp J
    const-wide/16 v10, 0
    cmp-long v8, v8, v10
    if-nez v8, +008h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    iput-wide v8, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryDataFirstCharTimestamp J
    iput v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryCharCount I
    const-string v4, "completed"
    const-string v8, "failed"
    const-string v9, "canceled"
    filled-new-array v4, v8, v9, [Ljava/lang/String;
    move-result-object v10
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v11
    invoke-static v10, v11, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +01ch
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v10
    const-string v11, "in_progress"
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +008h
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v10
    if-nez v10, +00ah
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move v5, v6
    if-eqz v5, +01bh
    iput-boolean v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning Z
    const-string/jumbo v10, stream
    invoke-direct v0, v1, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleModelUnavailableMessageErrorIfNeeded(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)V
    iget-boolean v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isSummaryTracking Z
    if-eqz v10, +00fh
    iput-boolean v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isSummaryTracking Z
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->armSummaryPerfReport(Z)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_streamingStarted Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-interface v4, v5, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v4
    if-nez v4, +020h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v3, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STREAMING Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    move-object v2, v0
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$1;
    invoke-direct v2, v0, v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    move-object v11, v2
    check-cast v11, Lkotlin/jvm/functions/Function2;
    const/4 v12, 3
    const/4 v13, 0
    invoke-static/range v8 ... v13, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +64h
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v4
    if-eqz v4, +026h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STOPPED Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    goto +ch
    invoke-static v5, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STOPPED Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    goto +3h
    sget-object v5, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->FINISHED Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    invoke-interface v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->notifyTaskListStatusChanged(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v2, +004h
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->lastDoneMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v3, v0
    check-cast v3, Landroidx/lifecycle/ViewModel;
    invoke-static v3, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;
    invoke-direct v4, v0, v1, v2, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Lkotlin/coroutines/Continuation;)V
    move-object v11, v4
    check-cast v11, Lkotlin/jvm/functions/Function2;
    const/4 v12, 3
    const/4 v13, 0
    invoke-static/range v8 ... v13, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    if-eqz v2, +01fh
    invoke-static v3, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v14
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Lkotlin/coroutines/CoroutineContext;
    const/16 v16, 0
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;
    invoke-direct v2, v0, v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v17, v2
    check-cast v17, Lkotlin/jvm/functions/Function2;
    const/16 v18, 2
    const/16 v19, 0
    invoke-static/range v14 ... v19, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final submitSummaryPerfReport(boolean)void
    .registers 5
    # ins_size=2
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportSubmitted Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportSubmitted Z
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportTimeoutJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v1, +005h
    invoke-static v1, v2, v0, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->summaryReportTimeoutJob Lkotlinx/coroutines/Job;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->reportDiscussionSummaryPerf(Z)V
    return-void 
.end method

.method private final switchSelectedModelToAuto(com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=5
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->environmentKey(Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-virtual v1, v7, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->modeKey(Lcom/bytedance/trae/im/service/Mode;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    sget-object v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v3
    invoke-virtual v2, v0, v1, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->saveModeSelection(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    sget-object v2, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    sget-object v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v4
    invoke-virtual v2, v0, v1, v3, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->saveSessionSelection(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, switchSelectedModelToAuto: reason=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v1, ", cliId="
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v1, ", cliType="
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v8, ", mode="
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v7, "ConversationViewModel"
    invoke-virtual v0, v7, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->_modelSelectionResetToAuto Lkotlinx/coroutines/flow/MutableSharedFlow;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v6, v7, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v7
    if-ne v6, v7, +003h
    return-object v6
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private final toCreateTaskCustomModel(com.bytedance.trae.conversation.network.RemoteModelItem)com.google.gson.JsonObject
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getRawModel()Lcom/google/gson/JsonObject;
    move-result-object v0
    const/4 v1, 1
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonObject;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-nez v0, +087h
    new-instance v0, Lcom/google/gson/JsonObject;
    invoke-direct v0, Lcom/google/gson/JsonObject;-><init>()V
    const-string v2, "name"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "display_name"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "model_name"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "display_model_name"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getMultimodal()Ljava/lang/Boolean;
    move-result-object v2
    if-eqz v2, +00fh
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    const-string v3, "multimodal"
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v0, v3, v2, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/Boolean;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getConfigSource()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +013h
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    const-string v3, "config_source"
    invoke-virtual v0, v3, v2, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/Number;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getProvider()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +015h
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v1
    if-eqz v4, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +007h
    const-string v4, "provider"
    invoke-virtual v0, v4, v2, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getCustomModelId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +014h
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v1
    if-eqz v4, +003h
    move-object v3, v2
    if-eqz v3, +007h
    const-string v2, "custom_model_id"
    invoke-virtual v0, v2, v3, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "config_name"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getConfigSource()Ljava/lang/Integer;
    move-result-object v6
    if-nez v6, +003h
    goto +8h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v6
    if-ne v6, v1, +003h
    goto +2h
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v6
    const-string v1, "is_preset"
    invoke-virtual v0, v1, v6, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/Boolean;)V
    return-object v0
.end method

.method private final toParsedHistoryMessages(java.util.List)java.util.List
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-virtual v0, v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->parseDisplayableHistoryList(Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method private final updateConversationEnvironment(com.bytedance.trae.im.service.CliType)void
    .registers 33
    # ins_size=2
    move-object/from16 v0, v31
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v2, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    move-object/from16 v14, v32
    if-ne v14, v1, +040h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v14
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v12
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v13, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 67106303
    const/16 v30, 0
    invoke-static/range v2 ... v30, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +39h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v3, 0
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
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 67106815
    const/16 v30, 0
    invoke-static/range v2 ... v30, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final updateMessagesAfterDeletion(java.lang.String  java.util.List  java.util.List)void
    .registers 8
    # ins_size=4
    move-object v0, v7
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v1, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    check-cast v6, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-static v6, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +015h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/String;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, -013h
    invoke-interface v6, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -18h
    check-cast v6, Ljava/util/List;
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-virtual v0, v7, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->sortMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v7
    invoke-direct v4, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMessages(Ljava/util/List;)V
    iget-object v7, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    move-object v0, v6
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-interface v7, v0, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z
    invoke-virtual v4, v5, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->deleteCachedMessages(Ljava/lang/String; Ljava/util/List;)V
    return-void 
.end method

.method private final updateUpgradeReminder(java.util.List)void
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-eqz v0, +07ch
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    const/4 v3, 0
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    if-nez v0, +003h
    goto +6ah
    move-object v1, v10
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v1
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda1;
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v1, v4, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v1
    invoke-static v1, Lkotlin/sequences/SequencesKt;->maxOrNull(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;
    move-result-object v1
    check-cast v1, Ljava/lang/Long;
    const/4 v4, 0
    if-eqz v1, +043h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    sget-object v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;->INSTANCE Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;->getConfig()Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
    move-result-object v1
    if-eqz v1, +019h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->getEnabled()Z
    move-result v7
    if-eqz v7, +013h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;->getRecommendedHighest()J
    move-result-wide v7
    cmp-long v1, v7, v5
    if-gez v1, +00bh
    sget-object v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;->INSTANCE Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;->isDismissed(Ljava/lang/String;)Z
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v2, v4
    if-eqz v2, +010h
    invoke-direct v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->shouldDeferUpgradeReminder()Z
    move-result v1
    if-eqz v1, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    invoke-direct v1, v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;-><init>(Ljava/lang/String; Ljava/util/List;)V
    iput-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingUpgradeReminderRefresh Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    return-void 
    iput-object v3, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingUpgradeReminderRefresh Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_upgradeReminder Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;-><init>(Ljava/lang/String; Z)V
    invoke-interface v10, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v3, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingUpgradeReminderRefresh Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->_upgradeReminder Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;
    invoke-direct v1, v0, v4, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;-><init>(Ljava/lang/String; Z)V
    invoke-interface v10, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final updateUpgradeReminder$lambda$23(com.bytedance.trae.im.model.ParsedChatMessage)java.lang.Long
    .registers 6
    # ins_size=1
    const-string v0, "it"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getVersionCode()Ljava/lang/Long;
    move-result-object v5
    const/4 v0, 0
    if-eqz v5, +015h
    move-object v1, v5
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
    move-object v5, v0
    return-object v5
.end method

.method private final upsertMessages(java.util.List)void
    .registers 7
    # ins_size=2
    invoke-interface v6, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->runtimeMessageIds Ljava/util/Set;
    move-object v1, v6
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +017h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, -015h
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, v1, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-direct v5, v0, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->mergeMessagesIntoState(Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMessages(Ljava/util/List;)V
    return-void 
.end method

.method public final cancelCurrentTask()void
    .registers 15
    # ins_size=1
    iget-object v0, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v5, v0
    check-cast v5, Ljava/lang/String;
    iget-object v4, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentTaskId Ljava/lang/String;
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +029h
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +008h
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    move v1, v2
    if-eqz v1, +003h
    goto +19h
    move-object v0, v14
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;
    const/4 v1, 0
    invoke-direct v0, v5, v4, v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v9, v0
    check-cast v9, Lkotlin/jvm/functions/Function2;
    const/4 v10, 3
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->INSTANCE Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;
    const-string/jumbo v2, skipped_null_id
    const-string/jumbo v3, user_click
    const/4 v6, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    iget-boolean v10, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning Z
    const/4 v11, 0
    const/16 v12, 368
    const/4 v13, 0
    invoke-static/range v1 ... v13, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->report$default(Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/Long; Z Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final checkIdeProjectForSkills(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->performCreateTaskCheck(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final createTaskCheck(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$createTaskCheck$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$createTaskCheck$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final deleteCachedMessages(java.lang.String  java.util.List)void
    .registers 10
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageIds"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v9, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteCachedMessages$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v9, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteCachedMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final deleteConversation()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;
    const/4 v5, 0
    invoke-direct v1, v0, v8, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final deleteMessageAndReplies(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->deleteMessagesAndReplies(Ljava/lang/String; Ljava/util/Collection;)V
    return-void 
.end method

.method public final deleteMessagesAndReplies(java.lang.String  java.util.Collection)void
    .registers 10
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageIds"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    check-cast v9, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +016h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v2, v3
    if-eqz v2, -015h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v9
    invoke-interface v9, Ljava/util/Set;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +029h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-interface v9, v6, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +011h
    move-object v6, v9
    check-cast v6, Ljava/lang/Iterable;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-static v6, v5, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +004h
    move v5, v2
    goto +2h
    const/4 v5, 0
    if-eqz v5, -027h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ch
    check-cast v3, Ljava/util/List;
    invoke-direct v7, v8, v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateMessagesAfterDeletion(Ljava/lang/String; Ljava/util/List; Ljava/util/List;)V
    return-void 
.end method

.method public final dismissUpgradeReminder(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;->INSTANCE Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;->markDismissed(Ljava/lang/String;)V
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->pendingUpgradeReminderRefresh Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->_upgradeReminder Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;-><init>(Ljava/lang/String; Z)V
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final exitAnchorWindowAndLoadLatest()boolean
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->isAnchorWindowMode Z
    const/4 v2, 0
    if-eqz v1, +048h
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +003h
    goto +34h
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->resetAnchorWindowState()V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->latestPrefetchMessages Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;
    if-eqz v1, +023h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;->getMessages()Ljava/util/List;
    move-result-object v0
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMessages(Ljava/util/List;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;->getMessages()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;->getPageLimit()I
    move-result v1
    invoke-virtual v4, v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreHistoryPage$conversation_mainlandRelease(I I)Z
    move-result v1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +bh
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMessages(Ljava/util/List;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessages(Ljava/lang/String;)V
    return v3
    return v2
.end method

.method public final fetchEventsIfNeeded(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v1
    invoke-virtual v0, v4, v3, v1, Lcom/bytedance/trae/im/service/IMService;->fetchEventsIfNeeded(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/keva/Keva;)V
    return-void 
.end method

.method public final getCancelTaskResult()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->cancelTaskResult Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getContentSecurityToastText()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->contentSecurityToastText Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getConversation()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->conversation Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getConversationId()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->conversationId Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getConversations()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->conversations Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getCreateTask()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTask Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getCreateTaskFailed()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskFailed Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getCurrentMode()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->currentMode Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getDeleteSuccess()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->deleteSuccess Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getForceLogout()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->forceLogout Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getGson()com.google.gson.Gson
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->gson Lcom/google/gson/Gson;
    return-object v0
.end method

.method public final getHasMoreMessages()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreMessages Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getLastDoneMessage()com.bytedance.trae.im.model.ParsedChatMessage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->lastDoneMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public final getLatestUnpairedUserMessage(java.util.List)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 9
    # ins_size=2
    const-string v0, "messages"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v3
    if-eqz v3, -011h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, -010h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +022h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v4
    if-eqz v4, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, -020h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -25h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-nez v0, +004h
    const/4 v8, 0
    goto +2ch
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-nez v1, +004h
    move-object v8, v0
    goto +20h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v1
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v4
    cmp-long v6, v1, v4
    if-gez v6, +004h
    move-object v0, v3
    move-wide v1, v4
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-nez v3, -015h
    goto -20h
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v8
.end method

.method public final getLoadError()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadError Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getMessages()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->messages Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getModelSelectionResetToAuto()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->modelSelectionResetToAuto Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getNewMessage()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->newMessage Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getRefreshedMessages()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->refreshedMessages Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getRemoteUserMessage()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessage Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getRenameSuccess()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->renameSuccess Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getSelectedBranchName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedBranchName Ljava/lang/String;
    return-object v0
.end method

.method public final getSelectedDevice()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedDevice Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getSelectedRepo()com.bytedance.trae.conversation.git.GitRepoItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    return-object v0
.end method

.method public final getSelectedRepoName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepoName Ljava/lang/String;
    return-object v0
.end method

.method public final getSelectedRepoUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepoUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getSendMessageSuccess()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessageSuccess Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getSessionTurnStatus()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->sessionTurnStatus Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getStreamingMessage()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessage Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getStreamingStarted()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingStarted Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getTaskDone()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->taskDone Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getToastMessage()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->toastMessage Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getToastText()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->toastText Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getUpgradeReminder()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->upgradeReminder Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final handleBrainstormResult(java.lang.String  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=5
    const-string v0, "messagesText"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliConversationId"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/SummaryMessagePart;
    invoke-direct v0, v12, Lcom/bytedance/trae/im/service/SummaryMessagePart;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/im/service/SummaryMessagePart;->toJsonArray()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v5, voice_summary
    const/4 v6, 0
    const/4 v7, 0
    const-string/jumbo v8, summary_mobile
    move-object v1, v11
    move-object v2, v12
    move-object v4, v13
    move-object v9, v14
    move-object v10, v15
    invoke-virtual/range v1 ... v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessageIternal(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final handleCheckpointDecision(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision)void
    .registers 9
    # ins_size=2
    const-string v0, "decision"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;
    const/4 v4, 0
    invoke-direct v0, v8, v7, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final handleCliDisconnected()void
    .registers 34
    # ins_size=1
    move-object/from16 v0, v33
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v2, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STOPPED Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentTaskId Ljava/lang/String;
    const/4 v2, 0
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning Z
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +008h
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    const/4 v2, 1
    if-nez v2, +053h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v4, +003h
    return-void 
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
    const-string v15, "4"
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const v31, 67107839
    const/16 v32, 0
    invoke-static/range v4 ... v32, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v4, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    new-instance v5, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;
    const-string/jumbo v6, update
    invoke-direct v5, v6, v3, v2, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/im/service/IMService;->notifyConversationChanged(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    move-object v2, v0
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCliDisconnected$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCliDisconnected$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-direct/range v33, Lcom/bytedance/trae/conversation/ConversationViewModel;->flushPendingUpgradeReminderIfAllowed()V
    return-void 
.end method

.method public final hasMoreHistoryPage$conversation_mainlandRelease(int  int)boolean
    .registers 3
    # ins_size=3
    if-lez v2, +006h
    if-lt v1, v2, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method public final init(java.lang.String  com.bytedance.trae.im.service.Conversation  java.lang.String)com.bytedance.trae.im.service.Conversation
    .registers 8
    # ins_size=4
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->resolveInitialConversation(Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v6
    const/4 v0, 0
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00bh
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/service/Conversation;->setMode(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "init: conversationId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", Conversation="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", conversation.title="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "ConversationViewModel"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    if-nez v5, +009h
    if-eqz v6, +008h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v5
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v0
    goto +2h
    move v5, v1
    if-eqz v5, +006h
    if-nez v6, +004h
    move v5, v1
    goto +2h
    move v5, v0
    iput-boolean v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation Z
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->initSelectedDevice(Lcom/bytedance/trae/im/service/Conversation;)V
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/IMService;->init()V
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-virtual v5, v2, Lcom/bytedance/trae/im/service/IMService;->addStreamingMessageListener(Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;)V
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->doneListener Lcom/bytedance/trae/im/service/IMService$DoneListener;
    invoke-virtual v5, v2, Lcom/bytedance/trae/im/service/IMService;->addDoneListener(Lcom/bytedance/trae/im/service/IMService$DoneListener;)V
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageListener Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;
    invoke-virtual v5, v2, Lcom/bytedance/trae/im/service/IMService;->addRemoteUserMessageListener(Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;)V
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->metadataDoneListener Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;
    invoke-virtual v5, v2, Lcom/bytedance/trae/im/service/IMService;->addMetadataDoneListener(Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v0
    goto +2h
    move v5, v1
    if-nez v5, +065h
    move-object v5, v7
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +008h
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    move v0, v1
    if-nez v0, +02ch
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "init: loading anchor window for conversationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", anchorCreatedAtMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v4, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadAnchorWindow(Ljava/lang/String;)V
    goto +33h
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v0, "init: loading messages for conversationId="
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v3, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v5, Ljava/lang/String;
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessages(Ljava/lang/String;)V
    goto +8h
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v7, "init: no conversationId, skip loadMessages (new conversation)"
    invoke-virtual v5, v3, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v6
.end method

.method public final isAnchorWindowLoading()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->isAnchorWindowLoading Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final isNewConversation()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation Z
    return v0
.end method

.method public final isTaskRunning()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning Z
    return v0
.end method

.method public final loadMessages(java.lang.String)void
    .registers 10
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "loadMessages: start, conversationId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ConversationViewModel"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-boolean v0, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->isAnchorWindowMode Z
    const/4 v1, 0
    if-nez v0, +007h
    const/4 v0, 0
    iput-boolean v0, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreNewerAnchorMessages Z
    iput-object v1, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->latestPrefetchMessages Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;
    invoke-direct v0, v8, v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease(java.lang.String  java.lang.String  int  int  boolean  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 26
    # ins_size=8
    move-object/from16 v0, v25
    instance-of v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    move-object/from16 v2, v18
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;
    move-object/from16 v2, v18
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v4, +047h
    if-eq v4, v6, +015h
    if-ne v4, v5, +00bh
    iget-object v1, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c9h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-boolean v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->Z$0 Z
    iget v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->I$1 I
    iget v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->I$0 I
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$5 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$4 Ljava/lang/Object;
    check-cast v11, Ljava/util/Iterator;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$3 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/functions/Function2;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$2 Ljava/lang/Object;
    check-cast v13, Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$1 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$0 Ljava/lang/Object;
    check-cast v15, Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v16, v11
    move-object v11, v1
    move-object v1, v13
    move-object/from16 v13, v16
    move-object/from16 v17, v12
    move-object v12, v3
    move v3, v9
    move v9, v4
    move v4, v8
    move-object/from16 v8, v17
    goto +50h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct/range v18 ... v23, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildListMessagesLargeFileRetryRequests(Ljava/lang/String; Ljava/lang/String; I I Z)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move/from16 v4, v22
    move/from16 v9, v23
    move-object/from16 v8, v24
    move-object v12, v0
    move-object v10, v1
    move-object v15, v2
    move-object v11, v3
    move-object v13, v7
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    move/from16 v3, v21
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v14
    if-eqz v14, +044h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    iput-object v15, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$0 Ljava/lang/Object;
    iput-object v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$1 Ljava/lang/Object;
    iput-object v1, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$2 Ljava/lang/Object;
    iput-object v8, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$3 Ljava/lang/Object;
    iput-object v12, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$4 Ljava/lang/Object;
    iput-object v13, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$5 Ljava/lang/Object;
    iput v3, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->I$0 I
    iput v4, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->I$1 I
    iput-boolean v9, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->Z$0 Z
    iput v6, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    invoke-interface v8, v13, v10, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v11, +003h
    return-object v11
    move-object/from16 v16, v14
    move-object v14, v0
    move-object/from16 v0, v16
    move-object/from16 v17, v11
    move-object v11, v10
    move-object v10, v13
    move-object v13, v12
    move-object/from16 v12, v17
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-direct v6, v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;)V
    invoke-direct v15, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isDownloadFileTooLargeBizError(Lcom/bytedance/trae/network/response/HttpDataResult;)Z
    move-result v0
    if-nez v0, +003h
    return-object v6
    move-object v10, v11
    move-object v11, v12
    move-object v12, v13
    move-object v0, v14
    move-object v13, v6
    const/4 v6, 1
    goto -47h
    if-nez v13, +032h
    check-cast v15, Lcom/bytedance/trae/conversation/ConversationViewModel;
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    move-object/from16 v19, v6
    move-object/from16 v20, v0
    move-object/from16 v21, v1
    move/from16 v22, v3
    move/from16 v23, v4
    move/from16 v24, v9
    invoke-direct/range v19 ... v24, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;-><init>(Ljava/lang/String; Ljava/lang/String; I I Z)V
    iput-object v6, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$0 Ljava/lang/Object;
    iput-object v7, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$1 Ljava/lang/Object;
    iput-object v7, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$2 Ljava/lang/Object;
    iput-object v7, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$3 Ljava/lang/Object;
    iput-object v7, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$4 Ljava/lang/Object;
    iput-object v7, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->L$5 Ljava/lang/Object;
    iput v5, v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    invoke-interface v8, v6, v10, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v11, +003h
    return-object v11
    move-object v1, v6
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    new-instance v13, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-direct v13, v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;)V
    return-object v13
.end method

.method public final loadMoreMessages(kotlin.jvm.functions.Function0)void
    .registers 14
    # ins_size=2
    const-string v0, "onComplete"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isLoadingMore Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    const-string v1, "ConversationViewModel"
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "loadMoreMessages: skip, already loading"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Ljava/lang/String;
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v3
    goto +2h
    move v0, v2
    if-eqz v0, +016h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "loadMoreMessages: skip, conversationId is null"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    move-object v5, v0
    if-nez v5, +016h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "loadMoreMessages: skip, no anchor created_at_ms"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_hasMoreMessages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "loadMoreMessages: skip, hasMoreMessages=false"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v6, "loadMoreMessages: start, conversationId="
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v6, ", anchorCreatedAtMs="
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_isLoadingMore Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    move-object v0, v12
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;
    const/4 v7, 0
    move-object v2, v9
    move-object v3, v12
    move-object v6, v13
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/Long; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    const/4 v10, 3
    const/4 v11, 0
    move-object v6, v0
    move-object v7, v1
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadNewerAnchorMessages(kotlin.jvm.functions.Function0)void
    .registers 13
    # ins_size=2
    const-string v0, "onComplete"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->isAnchorWindowMode Z
    if-eqz v0, +06ah
    iget-boolean v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->isLoadingNewerAnchorMessages Z
    if-eqz v0, +004h
    goto/16 +064h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/String;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    move-object v4, v0
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    if-nez v0, +02ah
    if-eqz v4, +028h
    iget-boolean v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreNewerAnchorMessages Z
    if-nez v0, +003h
    goto +22h
    iput-boolean v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->isLoadingNewerAnchorMessages Z
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;
    const/4 v6, 0
    move-object v1, v9
    move-object v2, v11
    move-object v5, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/Long; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    move-object v12, v9
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    move-object v5, v0
    move-object v6, v7
    move-object v7, v8
    move-object v8, v12
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    invoke-interface v12, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    invoke-interface v12, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method protected onCleared()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/lifecycle/ViewModel;->onCleared()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingTrailingJob Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeStreamingMessageListener(Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->remoteUserMessageListener Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeRemoteUserMessageListener(Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->metadataDoneListener Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeMetadataDoneListener(Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->doneListener Lcom/bytedance/trae/im/service/IMService$DoneListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeDoneListener(Lcom/bytedance/trae/im/service/IMService$DoneListener;)V
    return-void 
.end method

.method public final onConversationFullDetailLoaded(com.bytedance.trae.im.service.ConversationFullDetailResponse)void
    .registers 33
    # ins_size=2
    move-object/from16 v0, v31
    if-eqz v32, +0b0h
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    if-eqz v1, +0aah
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;->getCliProductType()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +048h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v3
    const v4, -934610874
    if-eq v3, v4, +02fh
    const v4, 777040398
    if-eq v3, v4, +019h
    const v4, 1271977997
    if-eq v3, v4, +003h
    goto +33h
    const-string/jumbo v3, trae_ide
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +29h
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    goto +26h
    const-string/jumbo v3, trae_work
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +18h
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    goto +15h
    const-string v3, "remote"
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +8h
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    move-object v13, v2
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v13, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +008h
    sget-object v2, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v2
    move-object v11, v2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->buildSelectedDeviceFromConversation(Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v15, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v12, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v30, v15
    move-object/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 67106303
    const/16 v29, 0
    invoke-static/range v1 ... v29, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    move-object/from16 v2, v30
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final onMessageListCommitComplete()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->isMessageListCommitPendingForUpgradeReminder Z
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->flushPendingUpgradeReminderIfAllowed()V
    return-void 
.end method

.method public final onUserMessageFixup(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 13
    # ins_size=3
    const-string v0, "oldMessageId"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newMessage"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/String;
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-void 
    move-object v0, v10
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Lkotlin/coroutines/CoroutineContext;
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationViewModel$onUserMessageFixup$1;
    const/4 v6, 0
    move-object v1, v9
    move-object v2, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/ConversationViewModel$onUserMessageFixup$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    move-object v11, v9
    check-cast v11, Lkotlin/jvm/functions/Function2;
    const/4 v12, 2
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v7
    move-object v6, v8
    move-object v7, v11
    move v8, v12
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final parseGitDisplayName(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    const/4 v0, 0
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +003h
    return-object v0
    new-instance v1, Lkotlin/text/Regex;
    const-string v4, "^git@[^:]+:(.+?)(\.git)?$"
    invoke-direct v1, v4, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    move-object v4, v7
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 2
    invoke-static v1, v4, v2, v5, v0, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v1
    if-eqz v1, +00dh
    invoke-interface v1, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v7
    invoke-interface v7, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    return-object v7
    new-instance v1, Lkotlin/text/Regex;
    const-string v4, "^https?://[^/]+/(.+?)(\.git)?$"
    invoke-direct v1, v4, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v1, v7, v2, v5, v0, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v7
    if-eqz v7, +00dh
    invoke-interface v7, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v7
    invoke-interface v7, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    return-object v7
    return-object v0
    :try_start_0x1
.end method

.method public final parseWorkspaceDisplayName(java.lang.String)java.lang.String
    .registers 13
    # ins_size=2
    move-object v0, v12
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
    const/4 v3, 0
    if-eqz v0, +003h
    return-object v3
    const/16 v5, 92
    const/16 v6, 47
    const/4 v7, 0
    const/4 v8, 4
    const/4 v9, 0
    move-object v4, v12
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    new-array v0, v2, [C
    const/16 v4, 47
    aput-char v4, v0, v1
    invoke-static v12, v0, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v12
    move-object v5, v12
    check-cast v5, Ljava/lang/CharSequence;
    new-array v6, v2, [C
    aput-char v4, v6, v1
    const/4 v8, 0
    const/4 v9, 6
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v0
    invoke-interface v12, v0, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v0
    if-eqz v0, +017h
    invoke-interface v12, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v2
    goto +2h
    move v4, v1
    if-eqz v4, -018h
    move-object v3, v0
    check-cast v3, Ljava/lang/String;
    return-object v3
.end method

.method public final pinConversation()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->performPinAction(Z)V
    return-void 
.end method

.method public final refreshMessagesOnResume()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-eqz v1, +003h
    return-void 
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final renameConversation(java.lang.String)void
    .registers 10
    # ins_size=2
    const-string v0, "newTitle"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;
    const/4 v5, 0
    invoke-direct v1, v0, v9, v8, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final resolveParentAgentTypeForSubTask(com.bytedance.trae.im.service.Mode  com.bytedance.trae.im.service.CliType)java.lang.String
    .registers 10
    # ins_size=3
    const-string v0, "mode"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->asReversed(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +02ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    if-eqz v5, +00bh
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v6
    goto +2h
    move v5, v3
    if-nez v5, +00ch
    const-string/jumbo v5, voice_summary
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    move v6, v3
    if-eqz v6, -02fh
    goto +2h
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v1, +016h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +010h
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v3
    if-eqz v1, +003h
    move-object v2, v0
    if-eqz v2, +003h
    return-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/AgentResolver;->INSTANCE Lcom/bytedance/trae/conversation/AgentResolver;
    invoke-virtual v0, v8, v9, Lcom/bytedance/trae/conversation/AgentResolver;->resolveDefaultAgentType(Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v8
    return-object v8
.end method

.method public final retryLoad()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->_loadError Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +008h
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    const/4 v1, 1
    if-nez v1, +005h
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessages(Ljava/lang/String;)V
    return-void 
.end method

.method public final retryMessage(java.lang.String  java.util.List  com.bytedance.trae.conversation.network.RemoteModelItem  boolean)void
    .registers 16
    # ins_size=5
    const-string v0, "assistantMessageId"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STREAMING Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    const/4 v2, 0
    if-ne v0, v1, +019h
    move-object v12, v11
    check-cast v12, Landroidx/lifecycle/ViewModel;
    invoke-static v12, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v12, Lcom/bytedance/trae/conversation/ConversationViewModel$retryMessage$1;
    invoke-direct v12, v11, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$retryMessage$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v12
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    if-nez v13, +00ah
    iget-object v13, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v13, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/util/List;
    invoke-interface v13, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    move v3, v1
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +016h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    add-int/lit8 v3, v3, 1
    goto -19h
    const/4 v3, -1
    const-string v0, "ConversationViewModel"
    if-gez v3, +018h
    sget-object v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string/jumbo v15, retryMessage: assistant message not found, id=
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v0, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-interface v13, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 1
    if-eqz v4, +02fh
    check-cast v13, Ljava/lang/Iterable;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01fh
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v6, v3
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v7
    if-eqz v7, +00eh
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    move v6, v5
    goto +2h
    move v6, v1
    if-eqz v6, -020h
    goto +2h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    goto +24h
    invoke-interface v13, v1, v3, Ljava/util/List;->subList(I I)Ljava/util/List;
    move-result-object v13
    invoke-interface v13, Ljava/util/List;->size()I
    move-result v3
    invoke-interface v13, v3, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v13, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v4
    if-eqz v4, -011h
    goto +2h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v3, +018h
    sget-object v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string/jumbo v15, retryMessage: user message not found for assistant=
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v0, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v13
    check-cast v13, Ljava/util/Collection;
    if-eqz v13, +00bh
    invoke-interface v13, Ljava/util/Collection;->isEmpty()Z
    move-result v13
    if-eqz v13, +003h
    goto +3h
    move v13, v1
    goto +2h
    move v13, v5
    if-eqz v13, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getUserContent()Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +00dh
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v2
    move-object v4, v13
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +008h
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    move v1, v5
    if-eqz v1, +058h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v13
    if-eqz v13, +051h
    check-cast v13, Ljava/lang/Iterable;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, text
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -018h
    goto +2h
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/im/model/MessagePart;
    if-eqz v1, +02bh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v13
    if-eqz v13, +025h
    const-string v1, "content"
    invoke-virtual v13, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v13
    if-eqz v13, +01dh
    invoke-virtual v13, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v13, v2
    if-eqz v13, +013h
    invoke-virtual v13, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +00dh
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v2
    iget-object v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->gson Lcom/google/gson/Gson;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    iget-object v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v1, v4, +03ch
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +024h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v5
    iget-object v6, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v2
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -025h
    goto +2h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/im/service/Mode;
    if-nez v4, +040h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    goto +3ah
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +024h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v5
    iget-object v6, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v2
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -025h
    goto +2h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/im/service/Mode;
    if-nez v4, +006h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    move-object v8, v1
    goto +2h
    move-object v8, v4
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, retryMessage: re-sending userMessage=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " for assistant="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v3, ", selectedModel="
    invoke-virtual v12, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    if-eqz v14, +006h
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v12, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, v0, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v13, +004h
    const-string v13, ""
    move-object v6, v13
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v5, v11
    move-object v9, v14
    move v10, v15
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessage(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z)V
    return-void 
.end method

.method public final revertMessageAndFollowingUsers(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 14
    # ins_size=4
    const-string v0, "conversationId"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->_messages Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v1
    goto +6h
    const-wide v1, 9223372036854775807
    move-object v13, v0
    check-cast v13, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v5, +01fh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v8, v5
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v9
    if-eqz v9, +00bh
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v8
    cmp-long v8, v8, v1
    if-lez v8, +003h
    goto +2h
    move v6, v7
    if-eqz v6, -01fh
    invoke-interface v3, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -24h
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v3, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v1
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +03dh
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +025h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +01bh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-interface v1, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +011h
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-static v5, v4, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    move v4, v6
    goto +2h
    move v4, v7
    if-eqz v4, -03bh
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -40h
    check-cast v2, Ljava/util/List;
    invoke-direct v10, v11, v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateMessagesAfterDeletion(Ljava/lang/String; Ljava/util/List; Ljava/util/List;)V
    return-void 
.end method

.method public final sendMessage(java.lang.String  java.lang.String  com.bytedance.trae.im.service.Mode  com.bytedance.trae.conversation.network.RemoteModelItem  boolean)void
    .registers 19
    # ins_size=6
    move-object/from16 v3, v16
    const-string/jumbo v0, text
    move-object v1, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    move-object v2, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v12, v13
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v0, +003h
    return-void 
    sget-object v4, Lcom/bytedance/trae/conversation/AgentResolver;->INSTANCE Lcom/bytedance/trae/conversation/AgentResolver;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/conversation/AgentResolver;->resolveDefaultAgentType(Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v4
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 448
    const/4 v11, 0
    move-object v0, v13
    move-object v1, v14
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v5, v17
    move/from16 v6, v18
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessageIternal$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final sendMessageIternal(java.lang.String  java.lang.String  com.bytedance.trae.im.service.Mode  java.lang.String  com.bytedance.trae.conversation.network.RemoteModelItem  boolean  java.lang.String  java.lang.String  java.lang.String)void
    .registers 30
    # ins_size=10
    move-object/from16 v15, v20
    move-object/from16 v12, v24
    const-string/jumbo v0, text
    move-object/from16 v1, v21
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    move-object/from16 v2, v22
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    move-object/from16 v6, v23
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "agentType"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskJob Lkotlinx/coroutines/Job;
    const/4 v3, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v4, 1
    if-ne v0, v4, +003h
    move v3, v4
    const-string v0, "ConversationViewModel"
    if-eqz v3, +00bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string/jumbo v2, sendMessageIternal: skipped, task creation already in progress
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v3, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->_sessionTurnStatus Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v4, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->IDLE Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    invoke-interface v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v3, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v3, +003h
    return-void 
    invoke-direct v15, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->recoverHistoricalIdeProjectDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v5
    sget-object v3, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;->INSTANCE Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;
    invoke-virtual v3, v5, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;->fromDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    move-result-object v10
    iget-boolean v3, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation Z
    if-eqz v3, +033h
    sget-object v3, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;->INSTANCE Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;
    invoke-virtual v3, v5, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;->requiresWorkspace(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Z
    move-result v3
    if-eqz v3, +02bh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->getWorkspaceDir()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +025h
    move-object v0, v15
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$1;
    const/4 v4, 0
    invoke-direct v3, v15, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    move-object/from16 v21, v0
    move-object/from16 v22, v1
    move-object/from16 v23, v2
    move-object/from16 v24, v3
    move/from16 v25, v4
    move-object/from16 v26, v5
    invoke-static/range v21 ... v26, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    const-string/jumbo v3, voice_summary
    invoke-static v12, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +010h
    iget-object v3, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->gson Lcom/google/gson/Gson;
    new-instance v4, Lcom/bytedance/trae/im/service/CommonParams;
    move-object/from16 v13, v28
    invoke-direct v4, v13, Lcom/bytedance/trae/im/service/CommonParams;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    goto +5h
    move-object/from16 v13, v28
    const-string v3, ""
    move-object v11, v3
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, sendMessageIternal: local_common_params_str=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    move-object v0, v15
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 0
    new-instance v19, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;
    const/4 v14, 0
    move-object/from16 v0, v19
    move-object/from16 v1, v21
    move-object/from16 v2, v22
    move-object/from16 v3, v20
    move-object/from16 v4, v29
    move-object/from16 v6, v23
    move-object/from16 v7, v25
    move-object/from16 v8, v27
    move/from16 v9, v26
    move-object/from16 v12, v24
    move-object/from16 v13, v28
    invoke-direct/range v0 ... v14, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v0, v19
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v1, 3
    const/4 v2, 0
    move-object/from16 v21, v16
    move-object/from16 v22, v17
    move-object/from16 v23, v18
    move-object/from16 v24, v0
    move/from16 v25, v1
    move-object/from16 v26, v2
    invoke-static/range v21 ... v26, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final setMode(com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 3
    # ins_size=2
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->_currentMode Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final setNewConversation(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation Z
    return-void 
.end method

.method public final setSelectedBranchName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedBranchName Ljava/lang/String;
    return-void 
.end method

.method public final setSelectedDevice(com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    .registers 3
    # ins_size=2
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final setSelectedRepo(com.bytedance.trae.conversation.git.GitRepoItem)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    return-void 
.end method

.method public final setSelectedRepoName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepoName Ljava/lang/String;
    return-void 
.end method

.method public final setSelectedRepoUrl(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedRepoUrl Ljava/lang/String;
    return-void 
.end method

.method public final setTaskRunning(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning Z
    return-void 
.end method

.method public final shouldCheckIdeProject(com.bytedance.trae.im.service.Conversation)boolean
    .registers 4
    # ins_size=2
    const-string v0, "conversation"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v3, 1
    return v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +01bh
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    return v3
    const/4 v3, 0
    return v3
.end method

.method public final shouldShowCheckpoint(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string/jumbo v0, toolCallId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->_shownCheckpointToolCallIds Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final supportsPin()boolean
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v0, +004h
    const/4 v0, 0
    return v0
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v4, 0
    if-eqz v3, +018h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v5, v3
    check-cast v5, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -01ah
    goto +2h
    move-object v3, v4
    check-cast v3, Lcom/bytedance/trae/im/service/Cli;
    if-eqz v3, +00ah
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +004h
    move-object v4, v2
    goto +21h
    iget-object v2, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->selectedDevice Lkotlinx/coroutines/flow/StateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v2, +018h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v2, v4
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskPinCapability;
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->isSupported(Z Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public final syncCodeSelectedDeviceWithItems(java.util.List)void
    .registers 16
    # ins_size=2
    const-string v0, "items"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-eq v0, v2, +080h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    goto/16 +072h
    check-cast v15, Ljava/lang/Iterable;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +02dh
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eq v3, v4, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v4, +012h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -02eh
    goto +2h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    if-nez v0, +018h
    new-instance v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const-string v3, ""
    const-string v4, ""
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 496
    const/4 v13, 0
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +1ah
    const/4 v2, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    const/4 v5, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 489
    const/4 v12, 0
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v0
    invoke-interface v15, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final syncSelectedDeviceWithItems(java.util.List)void
    .registers 16
    # ins_size=2
    const-string v0, "items"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v2, +074h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +66h
    check-cast v15, Ljava/lang/Iterable;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +025h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v4, +012h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -026h
    goto +2h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->_selectedDevice Lkotlinx/coroutines/flow/MutableStateFlow;
    if-nez v0, +018h
    new-instance v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const-string v3, ""
    const-string v4, ""
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 496
    const/4 v13, 0
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +17h
    const/4 v2, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 493
    const/4 v12, 0
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v0
    invoke-interface v15, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final unpinConversation()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->performPinAction(Z)V
    return-void 
.end method

.method public final updateConversation(com.bytedance.trae.im.service.Conversation)void
    .registers 33
    # ins_size=2
    move-object/from16 v0, v31
    const-string v1, "conversation"
    move-object/from16 v2, v32
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v3
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    move v7, v5
    goto +2h
    move v7, v6
    if-nez v7, +01ah
    move-object v7, v3
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    move v7, v5
    goto +2h
    move v7, v6
    if-nez v7, +009h
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return-void 
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v5
    goto +2h
    move v1, v6
    if-eqz v1, +015h
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +008h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v5, v6
    if-nez v5, +007h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversationId Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Conversation;
    const/4 v3, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v3
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +008h
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v3
    if-nez v1, +006h
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    move-object v14, v1
    if-nez v3, +008h
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    move-object v12, v1
    goto +2h
    move-object v12, v3
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v13, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 67106303
    const/16 v30, 0
    move-object/from16 v2, v32
    invoke-static/range v2 ... v30, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->_conversation Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->initSelectedDevice(Lcom/bytedance/trae/im/service/Conversation;)V
    return-void 
.end method
