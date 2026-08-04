# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IMService;
.super Ljava/lang/Object;
.source "IMService.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/service/IMService;
.field private static final MAX_PENDING_EVENTS:I
.field private static final MAX_PENDING_TASK_IDS:I
.field private static final POLLING_PAGE_SIZE:I
.field private static final STREAM_ACTIVE_THRESHOLD_MS:J
.field private static final TAG:Ljava/lang/String;
.field private static final WS_PROTO_CLI_REGISTER:I
.field private static final WS_PROTO_CLI_STATUS_CHANGE:I
.field private static final WS_PROTO_CLI_UNBIND:I
.field private static final WS_PROTO_PUSH_CONVERSATION_CREATE:I
.field private static final WS_PROTO_PUSH_CONVERSATION_DELETE:I
.field private static final WS_PROTO_PUSH_CONVERSATION_UPDATE:I
.field private static final WS_PROTO_PUSH_EVENT:I
.field private static final WS_PROTO_PUSH_MESSAGE_DELETE:I
.field private static final cliRegisterListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final cliStatusChangeListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final cliUnbindListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final conversationChangeListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final doneListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final fetchedConversationDone:Ljava/util/Set;
.field private static final fetchingTaskIds:Ljava/util/Set;
.field private static final firstSeqNum:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final gson:Lcom/google/gson/Gson;
.field private static final httpTaskSeqNum:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final ioScope:Lkotlinx/coroutines/CoroutineScope;
.field private static final lastStreamTimestamp:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final metadataDoneListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final payloadReceiver:Lcom/bytedance/trae/network/HubNetMessageListener;
.field private static final pendingEventsMap:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final pendingTaskIdOrder:Ljava/util/LinkedHashSet;
.field private static final pollingJobs:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final pollingScope:Lkotlinx/coroutines/CoroutineScope;
.field private static final remoteDeleteMessagePushListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final remoteUserMessageListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final seqNumbers:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final streamingMessageListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final thoughtMap:Ljava/util/concurrent/ConcurrentHashMap;


.method public static synthetic $r8$lambda$VWJNoLpied5VHHurN-Kpga68G6w(int  java.lang.String  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IMService;->payloadReceiver$lambda$1(I Ljava/lang/String; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IMService;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IMService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    new-instance v0, Lcom/google/gson/GsonBuilder;
    invoke-direct v0, Lcom/google/gson/GsonBuilder;-><init>()V
    const-class v1, Lcom/bytedance/trae/im/service/ChatEvent;
    check-cast v1, Ljava/lang/reflect/Type;
    new-instance v2, Lcom/bytedance/trae/im/service/ChatEventDeserializer;
    invoke-direct v2, Lcom/bytedance/trae/im/service/ChatEventDeserializer;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type; Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->firstSeqNum Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->httpTaskSeqNum Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->pendingEventsMap Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->pendingTaskIdOrder Ljava/util/LinkedHashSet;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->seqNumbers Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->lastStreamTimestamp Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual v0, v1, Lkotlinx/coroutines/CoroutineDispatcher;->limitedParallelism(I)Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    sget-object v1, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v2, Lcom/bytedance/trae/im/service/IMService$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v2, v1, Lcom/bytedance/trae/im/service/IMService$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v2, Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-virtual v0, v2, Lkotlinx/coroutines/CoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->ioScope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->conversationChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->doneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->remoteUserMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->metadataDoneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->cliStatusChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->cliUnbindListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->cliRegisterListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->remoteDeleteMessagePushListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Lcom/bytedance/trae/im/service/IMService$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IMService$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->payloadReceiver Lcom/bytedance/trae/network/HubNetMessageListener;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static v0, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->fetchedConversationDone Ljava/util/Set;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static v0, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->fetchingTaskIds Ljava/util/Set;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->pollingJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    sget-object v1, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v2, Lcom/bytedance/trae/im/service/IMService$special$$inlined$CoroutineExceptionHandler$2;
    invoke-direct v2, v1, Lcom/bytedance/trae/im/service/IMService$special$$inlined$CoroutineExceptionHandler$2;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v2, Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-virtual v0, v2, Lkotlinx/coroutines/CoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IMService;->pollingScope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getFetchedConversationDone$p()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->fetchedConversationDone Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFetchingTaskIds$p()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->fetchingTaskIds Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFirstSeqNum$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->firstSeqNum Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getHttpTaskSeqNum$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->httpTaskSeqNum Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getIoScope$p()kotlinx.coroutines.CoroutineScope
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->ioScope Lkotlinx/coroutines/CoroutineScope;
    return-object v0
.end method

.method public static final synthetic access$getPendingEventsMap$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->pendingEventsMap Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getPendingTaskIdOrder$p()java.util.LinkedHashSet
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->pendingTaskIdOrder Ljava/util/LinkedHashSet;
    return-object v0
.end method

.method public static final synthetic access$getPollingJobs$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->pollingJobs Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getSeqNumbers$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->seqNumbers Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getThoughtMap$p()java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$parseEvent(com.bytedance.trae.im.service.IMService  com.bytedance.trae.im.service.EventItem  java.lang.String)boolean
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/service/IMService;->parseEvent(Lcom/bytedance/trae/im/service/EventItem; Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$parsePayload(com.bytedance.trae.im.service.IMService  int  java.lang.String  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/im/service/IMService;->parsePayload(I Ljava/lang/String; Z)V
    return-void 
.end method

.method private final parseEvent(com.bytedance.trae.im.service.EventItem  java.lang.String)boolean
    .registers 83
    # ins_size=3
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getTaskId()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 1
    if-nez v6, +003h
    return v7
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getType()Ljava/lang/String;
    move-result-object v0
    const-string v8, "error"
    const-string v9, "done"
    const/4 v1, 0
    if-eqz v0, +1f4h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v2
    sparse-switch v2, +00002e5h
    goto/16 +1ebh
    const-string v2, "plan_item"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1e1h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    if-nez v0, +021h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
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
    const/16 v24, 8191
    const/16 v25, 0
    move-object v10, v0
    invoke-direct/range v10 ... v25, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ToolCallInfo; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +1adh
    const-string v2, "fast_request_savings"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1a3h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    if-nez v0, +00dh
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 7
    const/4 v15, 0
    move-object v10, v0
    invoke-direct/range v10 ... v15, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +183h
    const-string v2, "queuing"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +179h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    if-nez v0, +015h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 127
    const/16 v19, 0
    move-object v10, v0
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +151h
    const-string v2, "notification"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +147h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    if-nez v0, +019h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 511
    const/16 v21, 0
    move-object v10, v0
    invoke-direct/range v10 ... v21, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;-><init>(Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +11bh
    const-string/jumbo v2, session_title_message
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +110h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v2
    const-class v3, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;
    invoke-virtual v0, v2, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;
    if-nez v0, +008h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;
    const/4 v2, 3
    invoke-direct v0, v1, v1, v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;-><init>(Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +0f5h
    invoke-virtual v0, v8, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0edh
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    if-nez v0, +010h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 15
    const/16 v16, 0
    move-object v10, v0
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;-><init>(Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +0cah
    invoke-virtual v0, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0c2h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    if-nez v0, +010h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 15
    const/16 v16, 0
    move-object v10, v0
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;-><init>(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +09fh
    const-string v2, "metadata"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +095h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    if-nez v0, +04bh
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    move-object v10, v0
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
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, -1
    const/16 v45, 1
    const/16 v46, 0
    invoke-direct/range v10 ... v46, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object; Ljava/lang/Object; Lcom/bytedance/trae/im/service/DocReferences; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Object; Ljava/lang/Object; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto +37h
    const-string/jumbo v2, user_message
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2dh
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getData()Ljava/lang/String;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
    if-nez v0, +01bh
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
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
    const/16 v21, 1023
    const/16 v22, 0
    move-object v10, v0
    invoke-direct/range v10 ... v22, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/im/service/UserMessageContext; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-object v13, v1
    const/16 v18, 0
    if-nez v13, +003h
    return v18
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getType()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getSeq()Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    move v12, v0
    goto +3h
    move/from16 v12, v18
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getNewToolCall()Ljava/lang/Boolean;
    move-result-object v14
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getCleanThought()Ljava/lang/Boolean;
    move-result-object v15
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getThoughtFirstData()Ljava/lang/Boolean;
    move-result-object v16
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getToolcallFirstData()Ljava/lang/Boolean;
    move-result-object v17
    new-instance v19, Lcom/bytedance/trae/im/service/ChatEvent;
    move-object/from16 v10, v19
    invoke-direct/range v10 ... v17, Lcom/bytedance/trae/im/service/ChatEvent;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/im/service/ChatEventPayload; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    move-object v10, v0
    check-cast v10, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v10, v6, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-nez v0, +096h
    new-instance v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-object/from16 v59, v0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v1, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/model/ParsedTaskContent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object/from16 v20, v0
    const-string v22, ""
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const-string/jumbo v26, task
    const-string v27, "assistant"
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
    const/16 v41, 0
    const/16 v42, 0
    const-wide/16 v43, 0
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
    const/16 v58, 0
    const/16 v60, 0
    const/16 v61, 0
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, 0
    const/16 v66, 0
    const/16 v67, 0
    const/16 v68, 0
    const/16 v69, 0
    const/16 v70, 0
    const/16 v71, 0
    const/16 v72, 0
    const/16 v73, 0
    const/16 v74, 0
    const/16 v75, 0
    const/16 v76, 0
    const/16 v77, -100
    const v78, 8388319
    const/16 v79, 0
    move-object/from16 v21, v82
    invoke-direct/range v20 ... v79, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v1, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAMING Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setSourcePhase(Lcom/bytedance/trae/im/model/MessageSourcePhase;)V
    invoke-interface v10, v6, v0, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v0, v1
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v5, "http"
    move-object/from16 v0, v80
    move-object/from16 v1, v19
    move-object v2, v6
    move-object/from16 v3, v82
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/im/service/IMService;->realChatEvent(Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)V
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getType()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00eh
    invoke-virtual/range v81, Lcom/bytedance/trae/im/service/EventItem;->getType()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    return v18
    return v7
    sparse-switch-payload -6c25686d -1ad284d1 2f2382 5c4d208 14760737 237a88eb 270d358e 5a567d26 7d4d3a69
.end method

.method private final parsePayload(int  java.lang.String  boolean)void
    .registers 14
    # ins_size=4
    const-string v0, "ImService"
    const-string v1, "IMMessage_info_origin: taskId="
    const-string v2, "[Node0] WS_EVENT: type="
    const-string v3, "cli_register: cliId="
    const-string v4, "remote_message_delete: conversationId="
    const-string v5, "cli_unbind: cliId="
    const-string v6, "cli_status_change: cliId="
    const-string v7, "parsePayload: proto="
    sget-object v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v9, ", data="
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v9, ", isConsecutiveSeq="
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v8, v0, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v13, 3
    if-eq v11, v13, +190h
    const/4 v13, 6
    const/4 v1, 5
    const/4 v2, 4
    if-eq v11, v2, +14dh
    if-eq v11, v1, +14bh
    if-eq v11, v13, +149h
    const-string v13, ", timestamp="
    packed-switch v11, +0000240h
    goto/16 +23bh
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    const-class v1, Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;
    invoke-virtual v11, v12, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;
    if-nez v11, +003h
    return-void 
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;->getTimestamp()J
    move-result-wide v1
    invoke-virtual v13, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v0, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/im/service/IMService;->cliRegisterListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v12, Ljava/lang/Iterable;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +1feh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;
    invoke-interface v13, v11, Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;->onCliRegister(Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;)V
    goto -fh
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    const-class v13, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;
    invoke-virtual v11, v12, v13, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;
    if-nez v11, +003h
    return-void 
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getConversationId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v1, ", messageIds="
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getMessageIds()Ljava/util/List;
    move-result-object v1
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v0, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getMessageIds()Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/lang/Iterable;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +012h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, v13, Lcom/bytedance/trae/im/service/IMService;->cancelThoughtByMessageId(Ljava/lang/String; Ljava/lang/String;)V
    goto -15h
    sget-object v12, Lcom/bytedance/trae/im/service/IMService;->remoteDeleteMessagePushListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v12, Ljava/lang/Iterable;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +195h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;
    invoke-interface v13, v11, Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;->onMessagesDeletedRemotely(Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;)V
    goto -fh
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    const-class v1, Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;
    invoke-virtual v11, v12, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;
    if-nez v11, +003h
    return-void 
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;->getTimestamp()J
    move-result-wide v1
    invoke-virtual v13, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v0, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/im/service/IMService;->cliUnbindListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v12, Ljava/lang/Iterable;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +14eh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;
    invoke-interface v13, v11, Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;->onCliUnbound(Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;)V
    goto -fh
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    const-class v13, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;
    invoke-virtual v11, v12, v13, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;
    if-nez v11, +003h
    return-void 
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getCliId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v1, ", available="
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getAvailable()Z
    move-result v1
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v0, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/im/service/IMService;->cliStatusChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v12, Ljava/lang/Iterable;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +105h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    invoke-interface v13, v11, Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;->onCliStatusChanged(Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;)V
    goto -fh
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v3, v12, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v12, +003h
    return-void 
    if-eq v11, v2, +00eh
    if-eq v11, v1, +008h
    if-eq v11, v13, +003h
    return-void 
    const-string v11, "delete"
    goto +7h
    const-string/jumbo v11, update
    goto +3h
    const-string v11, "create"
    new-instance v13, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;
    invoke-virtual v12, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v13, v11, v1, v12, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)V
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->conversationChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v11, Ljava/lang/Iterable;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +0c7h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
    invoke-interface v12, v13, Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;->onConversationChanged(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    goto -fh
    sget-object v11, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    const-class v13, Lcom/bytedance/trae/im/service/IMService$Event;
    invoke-virtual v11, v12, v13, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/IMService$Event;
    if-nez v13, +003h
    return-void 
    invoke-virtual v13, Lcom/bytedance/trae/im/service/IMService$Event;->getTaskId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    invoke-virtual v13, Lcom/bytedance/trae/im/service/IMService$Event;->getConversationId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    return-void 
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v6, "AgentDataFlow"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/service/IMService$Event;->getType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v7, ", taskId="
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v7, ", convId="
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v7, ", seq="
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v13, Lcom/bytedance/trae/im/service/IMService$Event;->getSeq()Ljava/lang/Integer;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v6, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/service/IMService$Event;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string/jumbo v5, ，conversationId=
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/im/service/IMService$Event;->getConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string/jumbo v5, ，type=
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/im/service/IMService$Event;->getType()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, ", payload="
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v11, v13, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v2, v0, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-class v13, Lcom/bytedance/trae/im/service/ChatEvent;
    invoke-virtual v11, v12, v13, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/ChatEvent;
    if-nez v11, +003h
    return-void 
    invoke-virtual v10, v11, v3, v4, Lcom/bytedance/trae/im/service/IMService;->applyChatEvent(Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String; Ljava/lang/String;)V
    goto +16h
    move-exception v11
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v1, "parsePayload error: "
    invoke-direct v13, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v12, v0, v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    nop 
    packed-switch-payload 1e 1f 20 21
    :try_start_0x10
    :try_start_0x49
.end method

.method private static final payloadReceiver$lambda$1(int  java.lang.String  boolean)void
    .registers 10
    # ins_size=3
    const-string v0, "data"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->ioScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v9, v4, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;-><init>(I Ljava/lang/String; Z Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static synthetic realChatEvent$default(com.bytedance.trae.im.service.IMService  com.bytedance.trae.im.service.ChatEvent  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 16
    if-eqz v12, +005h
    const-string/jumbo v11, unknown
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/im/service/IMService;->realChatEvent(Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)V
    return-void 
.end method

.method private final triggerFetchEvents(java.lang.String  java.lang.String)void
    .registers 12
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->fetchingTaskIds Ljava/util/Set;
    invoke-interface v0, v10, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Node1] triggerFetchEvents: stream not continuous, taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", convId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentDataFlow"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->pollingJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v10, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v1, +006h
    const/4 v3, 1
    invoke-static v1, v2, v3, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    check-cast v0, Ljava/util/Map;
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->pollingScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;
    invoke-direct v1, v10, v11, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v11
    invoke-interface v0, v10, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final addCliRegisterListener(com.bytedance.trae.im.service.IMService$CliRegisterListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->cliRegisterListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addCliStatusChangeListener(com.bytedance.trae.im.service.IMService$CliStatusChangeListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->cliStatusChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addCliUnbindListener(com.bytedance.trae.im.service.IMService$CliUnbindListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->cliUnbindListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addConversationChangeListener(com.bytedance.trae.im.service.IMService$ConversationChangeListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->conversationChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addDoneListener(com.bytedance.trae.im.service.IMService$DoneListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->doneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addFetchedConversation(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->fetchedConversationDone Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addMetadataDoneListener(com.bytedance.trae.im.service.IMService$MetadataDoneListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->metadataDoneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addRemoteDeleteMessagePushListener(com.bytedance.trae.im.service.IMService$RemoteDeleteMessagePushListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->remoteDeleteMessagePushListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addRemoteUserMessageListener(com.bytedance.trae.im.service.IMService$RemoteUserMessageListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->remoteUserMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addStreamingMessageListener(com.bytedance.trae.im.service.IMService$StreamingMessageListener)void
    .registers 5
    # ins_size=2
    const-string v0, "listener"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v4, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    invoke-interface v0, Ljava/util/Collection;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    const-string v2, "next(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v2, 0
    invoke-interface v4, v1, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -15h
    return-void 
.end method

.method public final applyChatEvent(com.bytedance.trae.im.service.ChatEvent  java.lang.String  java.lang.String)void
    .registers 72
    # ins_size=4
    move-object/from16 v0, v69
    move-object/from16 v7, v70
    move-object/from16 v9, v71
    const-string v1, "[Node1] pendingEventsMap evict oldest taskId="
    const-string v2, "chatEvent"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, taskId
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "conversationId"
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v69, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v2
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->firstSeqNum Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v7, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v4
    const/4 v5, 1
    if-nez v4, +11bh
    if-eq v2, v5, +119h
    sget-object v4, Lcom/bytedance/trae/im/service/IMService;->fetchedConversationDone Ljava/util/Set;
    invoke-interface v4, v9, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +111h
    if-lez v2, +055h
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->seqNumbers Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v3, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v3, v7, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-nez v4, +010h
    invoke-static Ljava/util/concurrent/ConcurrentHashMap;->newKeySet()Ljava/util/concurrent/ConcurrentHashMap$KeySetView;
    move-result-object v4
    check-cast v4, Ljava/util/Set;
    invoke-interface v3, v7, v4, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v4, v3
    check-cast v4, Ljava/util/Set;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v4, v3, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +031h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v3, "AgentDataFlow"
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "[Node1] SKIP duplicate seq="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", type="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v69, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", taskId="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "AgentDataFlow"
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[Node1] repair seq="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", type="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v69, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", taskId="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, " chat="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual v5, v0, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v4, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IMService;->pendingEventsMap Ljava/util/concurrent/ConcurrentHashMap;
    move-object v3, v2
    check-cast v3, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v3, v7, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-nez v4, +05ch
    sget-object v4, Lcom/bytedance/trae/im/service/IMService;->pendingTaskIdOrder Ljava/util/LinkedHashSet;
    monitor-enter v4
    invoke-virtual v4, Ljava/util/LinkedHashSet;->size()I
    move-result v5
    const/16 v6, 10
    if-lt v5, v6, +035h
    move-object v5, v4
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v5, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/lang/Iterable;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    if-eqz v5, +02ah
    invoke-virtual v4, v5, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    invoke-virtual v2, v5, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v8, "AgentDataFlow"
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, ", current size="
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v2, Ljava/util/concurrent/ConcurrentHashMap;->size()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v8, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, v7, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z
    monitor-exit v4
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    invoke-static v1, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-interface v3, v7, v1, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-nez v2, +004h
    move-object v4, v1
    goto +6h
    move-object v4, v2
    goto +4h
    move-exception v0
    monitor-exit v4
    throw v0
    check-cast v4, Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v1
    const/16 v2, 500
    if-lt v1, v2, +006h
    const/4 v1, 0
    invoke-interface v4, v1, Ljava/util/List;->remove(I)Ljava/lang/Object;
    invoke-interface v4, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object/from16 v15, v68
    invoke-direct v15, v7, v9, Lcom/bytedance/trae/im/service/IMService;->triggerFetchEvents(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object/from16 v15, v68
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v3, v7, v1, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->lastStreamTimestamp Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/Map;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-interface v1, v7, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-lez v2, +0a0h
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->httpTaskSeqNum Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v7, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Integer;
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, -1
    if-gt v2, v1, +03bh
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "AgentDataFlow"
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[Node1] SKIP seq="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, " <= httpMaxSeq="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", type="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v69, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->seqNumbers Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v1, v7, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +010h
    invoke-static Ljava/util/concurrent/ConcurrentHashMap;->newKeySet()Ljava/util/concurrent/ConcurrentHashMap$KeySetView;
    move-result-object v3
    check-cast v3, Ljava/util/Set;
    invoke-interface v1, v7, v3, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v3, v1
    check-cast v3, Ljava/util/Set;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v3, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +031h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v3, "AgentDataFlow"
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "[Node1] SKIP duplicate seq="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", type="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v69, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", taskId="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    move-object v14, v1
    check-cast v14, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v14, v7, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +096h
    new-instance v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-object/from16 v47, v1
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object/from16 v2, v70
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/im/model/ParsedTaskContent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v8, v1
    const-string v10, ""
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-string/jumbo v2, task
    move-object v3, v14
    move-object v14, v2
    const-string v2, "assistant"
    move-object v15, v2
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
    const-wide/16 v31, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
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
    const/16 v59, 0
    const/16 v60, 0
    const/16 v61, 0
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, -100
    const v66, 8388319
    const/16 v67, 0
    move-object/from16 v9, v71
    invoke-direct/range v8 ... v67, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAMING Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setSourcePhase(Lcom/bytedance/trae/im/model/MessageSourcePhase;)V
    invoke-interface v3, v7, v1, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    move-object v5, v1
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string/jumbo v6, socket
    move-object/from16 v1, v68
    move-object/from16 v2, v69
    move-object/from16 v3, v70
    move-object/from16 v4, v71
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/im/service/IMService;->realChatEvent(Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)V
    return-void 
    :try_start_0xd0
.end method

.method public final cancelThoughtByMessageId(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->entrySet()Ljava/util/Set;
    move-result-object v0
    const-string v1, "<get-entries>(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
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
    move-object v3, v2
    check-cast v3, Ljava/util/Map$Entry;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    const-string v4, "component2(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, -032h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -37h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    const/16 v7, 10
    invoke-static v1, v7, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v7
    invoke-direct v6, v7, Ljava/util/ArrayList;-><init>(I)V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +012h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-interface v6, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +039h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v7, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->seqNumbers Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v7, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->pendingEventsMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v7, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->pendingTaskIdOrder Ljava/util/LinkedHashSet;
    monitor-enter v0
    invoke-virtual v0, v7, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    monitor-exit v0
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->firstSeqNum Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v7, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
    invoke-virtual v0, v7, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    invoke-virtual v0, v7, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->clear(Ljava/lang/String;)V
    goto -39h
    move-exception v6
    monitor-exit v0
    throw v6
    return-void 
    :try_start_0xa
    :try_start_0xab
    :try_start_0xae
.end method

.method public final fetchEventsIfNeeded(java.lang.String  java.lang.String  com.bytedance.keva.Keva)void
    .registers 8
    # ins_size=4
    const-string/jumbo v0, taskId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "keva"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v6, +003h
    return-void 
    sget-object v7, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v7, v5, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v7, +01ah
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +009h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v7
    if-eqz v7, +003h
    return-void 
    sget-object v7, Lcom/bytedance/trae/im/service/IMService;->lastStreamTimestamp Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v7, v5, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Long;
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, 0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sub-long/2addr v2, v0
    const-wide/32 v0, 120000
    cmp-long v7, v2, v0
    if-gez v7, +019h
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v0, "[Node1] fetchEventsIfNeeded: skip, socket stream active within 120000ms, taskId="
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v7, "AgentDataFlow"
    invoke-virtual v6, v7, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/im/service/IMService;->triggerFetchEvents(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final getGson()com.google.gson.Gson
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    return-object v0
.end method

.method public final getStreamingMessage(java.lang.String)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v2
.end method

.method public final getStreamingMessages(java.lang.String)java.util.List
    .registers 6
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    const-string v1, "<get-values>(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -015h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public final init()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/im/network/INetworkDepend;->getHubNetConnection()Lcom/bytedance/trae/network/HubNetConnection;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->payloadReceiver Lcom/bytedance/trae/network/HubNetMessageListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->registerMessageListener(Lcom/bytedance/trae/network/HubNetMessageListener;)V
    return-void 
.end method

.method public final notifyConversationChanged(com.bytedance.trae.im.service.IMService$ConversationChangeEvent)void
    .registers 4
    # ins_size=2
    const-string v0, "event"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->conversationChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
    invoke-interface v1, v3, Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;->onConversationChanged(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    goto -fh
    return-void 
.end method

.method public final realChatEvent(com.bytedance.trae.im.service.ChatEvent  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String)void
    .registers 29
    # ins_size=6
    move-object/from16 v0, v24
    move-object/from16 v8, v25
    move-object/from16 v9, v26
    move-object/from16 v10, v27
    move-object/from16 v1, v28
    const-string v2, "chatEvent"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, taskId
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "conversationId"
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "message"
    invoke-static v10, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, source
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v2
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +8b7h
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v4
    const-string v5, ", position="
    const-string v6, ", agentType="
    const-string v7, ", e="
    const-string/jumbo v11, token_usage handle error: taskId=
    const-string v12, "error"
    const-string v13, "done"
    const-string v14, ", payload="
    const-string v15, ", agentId="
    move/from16 v16, v2
    const-string v2, ", status="
    move-object/from16 v17, v14
    const-string v14, "metadata"
    move-object/from16 v18, v14
    const-string v14, "ImService"
    move-object/from16 v19, v15
    const-string v15, ", convId="
    move-object/from16 v20, v6
    const-string v6, "AgentDataFlow"
    move-object/from16 v21, v13
    const/4 v13, 0
    sparse-switch v4, +000088dh
    goto/16 +886h
    const-string v4, "plan_item"
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +87ch
    move-object/from16 v11, v17
    move-object/from16 v12, v18
    move-object/from16 v7, v19
    move-object/from16 v5, v20
    move-object/from16 v4, v21
    goto/16 +5b6h
    const-string v1, "fast_request_savings"
    invoke-virtual v3, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +866h
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    if-eqz v1, +005h
    move-object v13, v0
    check-cast v13, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    if-eqz v13, +859h
    new-instance v6, Lcom/bytedance/trae/im/model/FastRequestSavings;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/model/FastRequestSavings;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;->getSavedTimeSec()Ljava/lang/Long;
    move-result-object v0
    invoke-virtual v6, v0, Lcom/bytedance/trae/im/model/FastRequestSavings;->setSavedTimeSec(Ljava/lang/Long;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;->getSavePositions()Ljava/lang/Long;
    move-result-object v0
    invoke-virtual v6, v0, Lcom/bytedance/trae/im/model/FastRequestSavings;->setSavePositions(Ljava/lang/Long;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;->getTotalSaved()Ljava/lang/Long;
    move-result-object v0
    invoke-virtual v6, v0, Lcom/bytedance/trae/im/model/FastRequestSavings;->setTotalSaved(Ljava/lang/Long;)V
    invoke-virtual v10, v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setFastRequestSavings(Lcom/bytedance/trae/im/model/FastRequestSavings;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +828h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    const/4 v2, 0
    invoke-interface v1, v10, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -10h
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v14, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +800h
    const-string v1, "queuing"
    invoke-virtual v3, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +7f6h
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    goto +2h
    move-object v0, v13
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v1, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onQueuing(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v1, v8, v9, Lcom/bytedance/trae/im/track/AgentMonitor;->onAgentQueuing(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->getQueueStatus()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v13
    const-string v2, "end"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +029h
    invoke-virtual v10, v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingPosition(Ljava/lang/Integer;)V
    invoke-virtual v10, v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingMessage(Ljava/lang/String;)V
    invoke-virtual v10, v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueueId(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Node1] queuing end: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +072h
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->getPosition()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +dh
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->getQueuePosition()Ljava/lang/Integer;
    move-result-object v1
    goto +2h
    move-object v1, v13
    if-eqz v1, +003h
    goto -fh
    const/4 v1, 0
    if-lez v1, +01fh
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v10, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingPosition(Ljava/lang/Integer;)V
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->getMessage()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v13
    invoke-virtual v10, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingMessage(Ljava/lang/String;)V
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->getQueueId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v13
    invoke-virtual v10, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueueId(Ljava/lang/String;)V
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->getRequestUUId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v13
    invoke-virtual v10, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setRequestUUID(Ljava/lang/String;)V
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v13
    invoke-virtual v10, v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setFastRequestEvent(Lcom/bytedance/trae/im/service/FastRequestEvent;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[Node1] queuing event: taskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    const/4 v2, 0
    invoke-interface v1, v10, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -10h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +71eh
    const-string v1, "notification"
    invoke-virtual v3, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +712h
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    goto +2h
    move-object v0, v13
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getNotificationType()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v13
    const-string v2, "queue"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +07eh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getPosition()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, 0
    if-lez v1, +009h
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v10, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingPosition(Ljava/lang/Integer;)V
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getRequestUUId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v10, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setRequestUUID(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v2
    invoke-virtual v10, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setFastRequestEvent(Lcom/bytedance/trae/im/service/FastRequestEvent;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node1] notification(queue) event: taskId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 32
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQueueId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "notification_33"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +0aeh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    const/4 v2, 0
    invoke-interface v1, v10, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -10h
    const-string v2, "content_filter_warning"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +09bh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getActionType()Ljava/lang/Integer;
    move-result-object v1
    if-nez v1, +004h
    const/4 v2, 1
    goto +bh
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    const/4 v2, 1
    if-ne v1, v2, +005h
    const-string v1, "content_filter_blocked"
    goto +1ch
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getExecutePoint()Ljava/lang/Integer;
    move-result-object v1
    if-nez v1, +003h
    goto +ah
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v3
    if-ne v3, v2, +005h
    const-string v1, "content_filter_input_desensitized"
    goto +ch
    const-string v2, "content_filter_output_desensitized"
    if-nez v1, +003h
    goto +6h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    const/4 v3, 2
    move-object v1, v2
    invoke-virtual v10, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeType(Ljava/lang/String;)V
    invoke-virtual v10, v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeMessage(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getHitRuleName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v10, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setContentSecurityRuleName(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[Node1] notification(content_filter_warning): taskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", actionType="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getActionType()Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", executePoint="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getExecutePoint()Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", rule="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->getHitRuleName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v6, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    const/4 v2, 0
    invoke-interface v1, v10, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -10h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +5d7h
    invoke-virtual v3, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +5cdh
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v8, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->seqNumbers Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v8, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->lastStreamTimestamp Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v8, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v10, v0, v1, Lcom/bytedance/trae/im/service/IMMessageKt;->applyEvent(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String;)V
    invoke-static/range v27, Lcom/bytedance/trae/im/service/IMMessageKt;->releaseAggregator(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    const/4 v0, 1
    invoke-virtual v10, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHistory(Z)V
    sget-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAM_ERROR Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-virtual v10, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setSourcePhase(Lcom/bytedance/trae/im/model/MessageSourcePhase;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "[Node1] ERROR: taskId="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", errorCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v2
    goto +2h
    move-object v2, v13
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", errorMsg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v13
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/log/IMLog;->INSTANCE Lcom/bytedance/trae/im/log/IMLog;
    const-string v1, "IMMessage:Error"
    invoke-virtual v0, v1, v10, Lcom/bytedance/trae/im/log/IMLog;->logParsedChatMessage(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    const/4 v2, 1
    invoke-interface v1, v10, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -10h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->doneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$DoneListener;
    invoke-interface v1, v8, v9, Lcom/bytedance/trae/im/service/IMService$DoneListener;->onDone(Ljava/lang/String; Ljava/lang/String;)V
    goto -fh
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v0
    goto +2h
    move-object v0, v13
    if-nez v0, +007h
    const/4 v0, -2
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    move-object v4, v0
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    sget-object v2, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Failed Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    goto +2h
    move-object v3, v13
    const/4 v5, 0
    const/16 v6, 16
    const/4 v7, 0
    move-object/from16 v1, v25
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->onStreamStopped$default(Lcom/bytedance/trae/im/track/ChatFrontResponseTracker; Ljava/lang/String; Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v0, v8, v9, v10, Lcom/bytedance/trae/im/track/AgentMonitor;->onAgentError(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/AgentMonitor;->clear(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +4e2h
    move-object/from16 v4, v21
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +4d6h
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->thoughtMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v8, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->seqNumbers Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v8, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->lastStreamTimestamp Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v3, v8, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v10, v0, v1, Lcom/bytedance/trae/im/service/IMMessageKt;->applyEvent(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String;)V
    invoke-static/range v27, Lcom/bytedance/trae/im/service/IMMessageKt;->releaseAggregator(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    const/4 v1, 1
    invoke-virtual v10, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHistory(Z)V
    sget-object v1, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAM_DONE Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-virtual v10, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setSourcePhase(Lcom/bytedance/trae/im/model/MessageSourcePhase;)V
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v1
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +007h
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    goto +2h
    const/4 v1, 0
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "[Node1] DONE: taskId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", planItemCount="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object/from16 v5, v20
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object/from16 v7, v19
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v6, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v1
    if-eqz v1, +02eh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +028h
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +012h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v3
    if-eqz v3, -010h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v2, Ljava/util/List;
    goto +2h
    move-object v2, v13
    if-eqz v2, +099h
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +08ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    add-int/lit8 v4, v2, 1
    if-gez v2, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v15, "[Node1] DONE planItem["
    invoke-direct v11, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v11, "]: id="
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v11, ", agentRunId="
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v11, ", tool="
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v13
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v11, ", hasThought="
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v11
    if-eqz v11, +004h
    const/4 v11, 1
    goto +2h
    const/4 v11, 0
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v11, ", hasReasoning="
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v6, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move v2, v4
    goto/16 -08ch
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "IMMessage_info_down: type="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-object/from16 v11, v17
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual v3, v0, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v14, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/log/IMLog;->INSTANCE Lcom/bytedance/trae/im/log/IMLog;
    const-string v1, "IMMessage:Done"
    invoke-virtual v0, v1, v10, Lcom/bytedance/trae/im/log/IMLog;->logParsedChatMessage(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    const/4 v2, 1
    invoke-interface v1, v10, v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -10h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->doneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$DoneListener;
    invoke-interface v1, v8, v9, Lcom/bytedance/trae/im/service/IMService$DoneListener;->onDone(Ljava/lang/String; Ljava/lang/String;)V
    goto -fh
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +035h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const v2, -1281977283
    if-eq v1, v2, +020h
    const v2, -123173735
    if-eq v1, v2, +00fh
    const v2, 96784904
    if-eq v1, v2, +003h
    goto +20h
    invoke-virtual v0, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +018h
    goto +19h
    const-string v1, "canceled"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +10h
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Canceled Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    goto +fh
    const-string v1, "failed"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +4h
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Failed Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Success Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    move-object v2, v0
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 28
    const/4 v7, 0
    move-object/from16 v1, v25
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->onStreamStopped$default(Lcom/bytedance/trae/im/track/ChatFrontResponseTracker; Ljava/lang/String; Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v0, v8, v9, v10, Lcom/bytedance/trae/im/track/AgentMonitor;->onAgentDone(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->clear(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v0, v8, Lcom/bytedance/trae/im/track/AgentMonitor;->clear(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +2d0h
    move-object/from16 v11, v17
    move-object/from16 v12, v18
    move-object/from16 v7, v19
    move-object/from16 v5, v20
    move-object/from16 v4, v21
    invoke-virtual v3, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +2bch
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    move-object/from16 v18, v14
    const-string v14, "[Node1] applyChatEvent: type="
    invoke-direct v13, v14, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, ", seq="
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    move/from16 v14, v16
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, ", taskId="
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v3, v6, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v10, v0, v1, Lcom/bytedance/trae/im/service/IMMessageKt;->applyEvent(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String;)V
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v3
    if-eqz v3, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v3
    if-eqz v3, +007h
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    goto +2h
    const/4 v3, 0
    sget-object v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v15, "[Node1] afterApply: planItemCount="
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", isHistory="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v27, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v13, v6, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +04eh
    sget-object v2, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v2, v8, v9, Lcom/bytedance/trae/im/track/AgentMonitor;->onAgentStart(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    if-eqz v3, +005h
    check-cast v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, v2, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onMetadata(Ljava/lang/String; Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata; Ljava/lang/String;)V
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getMetadataStatus()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +028h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getUserMessageContext()Lcom/bytedance/trae/im/service/UserMessageContext;
    move-result-object v1
    if-eqz v1, +022h
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->metadataDoneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getUserMessageContext()Lcom/bytedance/trae/im/service/UserMessageContext;
    move-result-object v5
    invoke-interface v3, v9, v4, v5, Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;->onMetadataDone(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext;)V
    goto -17h
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    const/4 v7, 0
    invoke-interface v2, v10, v7, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto -10h
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +03ch
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    if-eqz v2, +005h
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +021h
    sget-object v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getThought()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/service/ToolCallInfo;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    goto +2h
    const/4 v6, 0
    move-object v1, v2
    move-object/from16 v2, v25
    move-object/from16 v3, v26
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->checkAndFireFirstToken(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Z
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v1, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->hasFirstTokenFired(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +007h
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    invoke-virtual v1, v8, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->onPlanItemToken(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "IMMessage: type="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->gson Lcom/google/gson/Gson;
    invoke-virtual v3, v10, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v4, v18
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v5, "IMMessage_info: type="
    invoke-direct v2, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getType()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, v0, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +128h
    move-object v4, v14
    const-string/jumbo v1, token_usage
    invoke-virtual v3, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +11ah
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    if-eqz v1, +006h
    move-object v13, v0
    check-cast v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    goto +2h
    const/4 v13, 0
    if-eqz v13, +023h
    sget-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
    invoke-virtual v0, v8, v13, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->onTokenUsage(Ljava/lang/String; Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;)V
    goto +1ch
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +0e8h
    const-string/jumbo v1, timing_events
    invoke-virtual v3, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +0dbh
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;
    if-eqz v1, +006h
    move-object v13, v0
    check-cast v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;
    goto +2h
    const/4 v13, 0
    if-eqz v13, +037h
    new-instance v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getModelName()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getLogid()Ljava/lang/String;
    move-result-object v16
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getModelAccountName()Ljava/lang/String;
    move-result-object v17
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getModelAccountType()Ljava/lang/String;
    move-result-object v18
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getModelProviderName()Ljava/lang/String;
    move-result-object v19
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getServerTimingInfo()Ljava/lang/String;
    move-result-object v20
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->isServerRetried()Ljava/lang/Boolean;
    move-result-object v21
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getEnableDbOpt()Ljava/lang/Boolean;
    move-result-object v22
    move-object v14, v0
    invoke-direct/range v14 ... v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;->getData()Ljava/util/Map;
    move-result-object v1
    if-eqz v1, +00bh
    sget-object v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v2, v8, v1, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onTimingEvents(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/im/service/IMService$TimingMeta;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +095h
    const/4 v7, 0
    const-string/jumbo v1, user_message
    invoke-virtual v3, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +087h
    invoke-virtual/range v24, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
    if-eqz v1, +006h
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
    move-object v8, v0
    goto +2h
    const/4 v8, 0
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;->getMessageId()Ljava/lang/String;
    move-result-object v13
    goto +2h
    const/4 v13, 0
    if-eqz v8, +06dh
    move-object v0, v13
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v2, v7
    goto +2h
    const/4 v2, 1
    if-nez v2, +05ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Node1] user_message: msgId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->remoteUserMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +032h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;->getContent()Lcom/google/gson/JsonElement;
    move-result-object v3
    invoke-virtual v8, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;->getMessageIndex()Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;->getCreatedAt()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v8, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;->getUserMessageContext()Lcom/bytedance/trae/im/service/UserMessageContext;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/UserMessageContext;->isAppendMsg()Ljava/lang/Boolean;
    move-result-object v1
    const/4 v11, 1
    invoke-static v11, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    move v6, v1
    goto +3h
    const/4 v11, 1
    move v6, v7
    move-object/from16 v1, v26
    move-object v2, v13
    invoke-interface/range v0 ... v6, Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;->onRemoteUserMessage(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/Integer; Ljava/lang/Long; Z)V
    goto -35h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +3h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-void 
    nop 
    sparse-switch-payload -6c25686d -57cc1952 -44658425 -1ad284d1 2f2382 5c4d208 237a88eb 270d358e 5a567d26 7d4d3a69
    :try_start_0x80
    :try_start_0x3bb
    :try_start_0x5b2
    :try_start_0x736
    :try_start_0x763
    :try_start_0x7cc
    :try_start_0x80b
.end method

.method public final release()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/im/network/INetworkDepend;->getHubNetConnection()Lcom/bytedance/trae/network/HubNetConnection;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->payloadReceiver Lcom/bytedance/trae/network/HubNetMessageListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->unregisterMessageListener(Lcom/bytedance/trae/network/HubNetMessageListener;)V
    return-void 
.end method

.method public final removeCliRegisterListener(com.bytedance.trae.im.service.IMService$CliRegisterListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->cliRegisterListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeCliStatusChangeListener(com.bytedance.trae.im.service.IMService$CliStatusChangeListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->cliStatusChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeCliUnbindListener(com.bytedance.trae.im.service.IMService$CliUnbindListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->cliUnbindListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeConversationChangeListener(com.bytedance.trae.im.service.IMService$ConversationChangeListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->conversationChangeListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeDoneListener(com.bytedance.trae.im.service.IMService$DoneListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->doneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeMetadataDoneListener(com.bytedance.trae.im.service.IMService$MetadataDoneListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->metadataDoneListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeRemoteDeleteMessagePushListener(com.bytedance.trae.im.service.IMService$RemoteDeleteMessagePushListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->remoteDeleteMessagePushListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeRemoteUserMessageListener(com.bytedance.trae.im.service.IMService$RemoteUserMessageListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->remoteUserMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeStreamingMessageListener(com.bytedance.trae.im.service.IMService$StreamingMessageListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->streamingMessageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method
