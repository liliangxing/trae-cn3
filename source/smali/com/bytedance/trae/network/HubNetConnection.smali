# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubNetConnection;
.super Ljava/lang/Object;
.source "HubNetConnection.kt"

.field public static final Companion:Lcom/bytedance/trae/network/HubNetConnection$Companion;
.field private static final FILL_GAP_BATCH_SIZE:I
.field private static final FLUSH_COUNT_THRESHOLD:I
.field private static final FLUSH_INTERVAL_MS:J
.field private static final FRONTIER_CONNECT_TIMEOUT_MS:J
.field private static final HTTP_BACKOFF_BASE_SECS:J
.field private static final HTTP_BACKOFF_MAX_SECS:J
.field private static final HUB_MONITOR_EVENT:Ljava/lang/String;
.field private static final PENDING_QUEUE_RETRY_DELAY_MS:J
.field private static final POLL_INTERVAL_MS:J
.field private static final REGISTER_RETRY_EXPIRED_BACKOFF_SECS:J
.field private static final REGISTER_RETRY_INTERVAL_SECS:J
.field private static final REGISTER_RETRY_MAX_TOTAL_SECS:J
.field private static final TAG:Ljava/lang/String;
.field private final channelId:I
.field private clientMetadata:Lcom/bytedance/trae/network/HubClientMetadata;
.field private config:Lcom/bytedance/trae/network/FrontierConfig;
.field private final dispatchLock:Ljava/util/concurrent/locks/ReentrantLock;
.field private extraHeaders:Ljava/util/Map;
.field private frontier:Lcom/bytedance/trae/network/FrontierConnection;
.field private final frontierBytesListener:Lkotlin/jvm/functions/Function1;
.field private frontierConnectTimeoutJob:Lkotlinx/coroutines/Job;
.field private final frontierStateListener:Lkotlin/jvm/functions/Function1;
.field private final gson:Lcom/google/gson/Gson;
.field private httpFlushJob:Lkotlinx/coroutines/Job;
.field private httpPollJob:Lkotlinx/coroutines/Job;
.field private bridge isFillingGap:Z
.field private bridge isToB:Z
.field private final messageListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private final modeLock:Ljava/util/concurrent/locks/ReentrantLock;
.field private networkRecoveryJob:Lkotlinx/coroutines/Job;
.field private nextExpectedDownSeq:J
.field private pendingQueuePumpJob:Lkotlinx/coroutines/Job;
.field private final pendingSendQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field private sseBackgroundRetryJob:Lkotlinx/coroutines/Job;
.field private sseConnection:Lcom/bytedance/trae/network/SseConnection;
.field private final sseMessageListener:Lkotlin/jvm/functions/Function1;
.field private final sseStateListener:Lkotlin/jvm/functions/Function1;
.field private bridge transportMode:Lcom/bytedance/trae/network/TransportMode;
.field private final upSeqId:Ljava/util/concurrent/atomic/AtomicLong;
.field private websocketGeneration:J


.method public static synthetic $r8$lambda$1FSxs4isgf2ZAKpI6EbvyuWUhwg(com.bytedance.trae.network.HubNetConnection)com.bytedance.trae.network.HubNetConnection$PendingSend
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->drainPendingQueueViaFrontier$lambda$42(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$5S-YrrKdIJ5zbkvoHu0arIpWgCI(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.WsMessage)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->sseMessageListener$lambda$19(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/WsMessage;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$5yC8f0kElfp7TBzylV3DGyPyh9Y(com.bytedance.trae.network.HubNetConnection  byte[])kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->frontierBytesListener$lambda$2(Lcom/bytedance/trae/network/HubNetConnection; [B)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$M19A3eGD2YhSeqvDWer8ppQRqQk(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.NetworkConnectState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->frontierStateListener$lambda$3(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/NetworkConnectState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$iMJEDkztJ6br82Hgx9CEq2iRwXo(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.SseState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->sseStateListener$lambda$20(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/SseState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$t6B1t06vTwpGouCyUuxcreZfq_c(long  com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.HubNetConnection$PendingSend  long  boolean)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->sendBytesToHub$lambda$26$lambda$25(J Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/HubNetConnection$PendingSend; J Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wYuHcgX2LB948iIg_7FEgZ2GiO4(com.bytedance.trae.network.HubNetConnection)com.bytedance.trae.network.HubNetConnection$PendingSend
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection;->flushPendingViaHttp$lambda$36(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$yxFMpTNIra4nupRAYLAnRiIL5Vc(com.bytedance.trae.network.HubNetConnection$PendingSend  com.bytedance.trae.network.HubNetConnection  long  boolean)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->drainPendingQueueViaFrontier$lambda$45(Lcom/bytedance/trae/network/HubNetConnection$PendingSend; Lcom/bytedance/trae/network/HubNetConnection; J Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/HubNetConnection$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/HubNetConnection;->Companion Lcom/bytedance/trae/network/HubNetConnection$Companion;
    return-void 
.end method

.method public constructor <init>(int)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    iput v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->channelId I
    new-instance v3, Lcom/google/gson/Gson;
    invoke-direct v3, Lcom/google/gson/Gson;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->gson Lcom/google/gson/Gson;
    new-instance v3, Ljava/util/concurrent/locks/ReentrantLock;
    invoke-direct v3, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    sget-object v3, Lcom/bytedance/trae/network/TransportMode;->IDLE Lcom/bytedance/trae/network/TransportMode;
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    new-instance v3, Ljava/util/concurrent/atomic/AtomicLong;
    const-wide/16 v0, 0
    invoke-direct v3, v0, v1, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->upSeqId Ljava/util/concurrent/atomic/AtomicLong;
    new-instance v3, Ljava/util/concurrent/locks/ReentrantLock;
    invoke-direct v3, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->dispatchLock Ljava/util/concurrent/locks/ReentrantLock;
    const-wide/16 v0, 1
    iput-wide v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    new-instance v3, Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-direct v3, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    const/4 v3, 0
    const/4 v0, 1
    invoke-static v3, v0, v3, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v3, v0, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v3
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/network/HubNetConnection$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/network/HubNetConnection$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v3, v1, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v3
    invoke-static v3, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v3, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v3, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->extraHeaders Ljava/util/Map;
    sget-object v3, Lcom/bytedance/trae/network/HubClientMetadata;->Companion Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->fromSystem()Lcom/bytedance/trae/network/HubClientMetadata;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->clientMetadata Lcom/bytedance/trae/network/HubClientMetadata;
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda2;
    invoke-direct v3, v2, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/network/HubNetConnection;)V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->frontierBytesListener Lkotlin/jvm/functions/Function1;
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda3;
    invoke-direct v3, v2, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/network/HubNetConnection;)V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->frontierStateListener Lkotlin/jvm/functions/Function1;
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda4;
    invoke-direct v3, v2, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/network/HubNetConnection;)V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->sseMessageListener Lkotlin/jvm/functions/Function1;
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda5;
    invoke-direct v3, v2, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/network/HubNetConnection;)V
    iput-object v3, v2, Lcom/bytedance/trae/network/HubNetConnection;->sseStateListener Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public static final synthetic access$awaitNetworkRecoveryAndRetry(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->awaitNetworkRecoveryAndRetry(Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener;)V
    return-void 
.end method

.method public static final synthetic access$dispatch(com.bytedance.trae.network.HubNetConnection  java.util.List  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->dispatch(Ljava/util/List; Z)V
    return-void 
.end method

.method public static final synthetic access$drainPendingQueueViaFrontier(com.bytedance.trae.network.HubNetConnection)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/network/HubNetConnection;->drainPendingQueueViaFrontier()V
    return-void 
.end method

.method public static final synthetic access$fillGap(com.bytedance.trae.network.HubNetConnection  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/HubNetConnection;->fillGap(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$flushPendingViaHttp(com.bytedance.trae.network.HubNetConnection  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->flushPendingViaHttp(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getFrontier$p(com.bytedance.trae.network.HubNetConnection)com.bytedance.trae.network.FrontierConnection
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    return-object v0
.end method

.method public static final synthetic access$getModeLock$p(com.bytedance.trae.network.HubNetConnection)java.util.concurrent.locks.ReentrantLock
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    return-object v0
.end method

.method public static final synthetic access$getNextExpectedDownSeq$p(com.bytedance.trae.network.HubNetConnection)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    return-wide v0
.end method

.method public static final synthetic access$getSseConnection$p(com.bytedance.trae.network.HubNetConnection)com.bytedance.trae.network.SseConnection
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    return-object v0
.end method

.method public static final synthetic access$getTransportMode$p(com.bytedance.trae.network.HubNetConnection)com.bytedance.trae.network.TransportMode
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    return-object v0
.end method

.method public static final synthetic access$isToB$p(com.bytedance.trae.network.HubNetConnection)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    return v0
.end method

.method public static final synthetic access$pollViaHttp(com.bytedance.trae.network.HubNetConnection  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/network/HubNetConnection;->pollViaHttp(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$pushMessagesViaHttp(com.bytedance.trae.network.HubNetConnection  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$registerApp(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->registerApp(Lcom/bytedance/trae/network/FrontierConfig; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setFrontierConnectTimeoutJob$p(com.bytedance.trae.network.HubNetConnection  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setNetworkRecoveryJob$p(com.bytedance.trae.network.HubNetConnection  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection;->networkRecoveryJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setPendingQueuePumpJob$p(com.bytedance.trae.network.HubNetConnection  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setTransportMode$p(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.TransportMode)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    return-void 
.end method

.method public static final synthetic access$startConnectedTransport(com.bytedance.trae.network.HubNetConnection  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->startConnectedTransport(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$startHttpFallback(com.bytedance.trae.network.HubNetConnection)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/network/HubNetConnection;->startHttpFallback()V
    return-void 
.end method

.method public static final synthetic access$startSseBackgroundRetry(com.bytedance.trae.network.HubNetConnection)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/network/HubNetConnection;->startSseBackgroundRetry()V
    return-void 
.end method

.method private final awaitNetworkRecoveryAndRetry(com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener)void
    .registers 12
    # ins_size=3
    iget-object v0, v9, Lcom/bytedance/trae/network/HubNetConnection;->networkRecoveryJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v3, v9, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;
    invoke-direct v0, v9, v10, v11, v1, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/network/HubNetConnection;->networkRecoveryJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method static synthetic awaitNetworkRecoveryAndRetry$default(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->awaitNetworkRecoveryAndRetry(Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener;)V
    return-void 
.end method

.method public static synthetic connect$default(com.bytedance.trae.network.HubNetConnection  java.lang.String  com.bytedance.trae.network.HubConnectionListener  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->connect(Ljava/lang/String; Lcom/bytedance/trae/network/HubConnectionListener;)V
    return-void 
.end method

.method private final dispatch(java.util.List  boolean)void
    .registers 24
    # ins_size=3
    move-object/from16 v7, v21
    iget-object v0, v7, Lcom/bytedance/trae/network/HubNetConnection;->dispatchLock Ljava/util/concurrent/locks/ReentrantLock;
    move-object v8, v0
    check-cast v8, Ljava/util/concurrent/locks/Lock;
    invoke-interface v8, Ljava/util/concurrent/locks/Lock;->lock()V
    if-eqz v23, +005h
    const-string v0, "HTTP"
    goto +3h
    const-string v0, "Frontier"
    move-object/from16 v1, v22
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v10, 0
    if-eqz v3, +025h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v4, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    goto +3h
    const-wide/16 v4, 0
    iget-wide v11, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    cmp-long v4, v4, v11
    if-ltz v4, +004h
    const/4 v9, 1
    goto +2h
    move v9, v10
    if-eqz v9, -024h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -29h
    move-object v11, v2
    check-cast v11, Ljava/util/List;
    invoke-interface/range v22, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v2
    sub-int v12, v1, v2
    const-string v13, "dispatch["
    const-string v14, "HubNetConnection"
    if-lez v12, +03fh
    const-string v2, "DropMessage"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object/from16 v1, v21
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "]: dropped "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " dup msgs (< expected="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-wide v3, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 41
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +182h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v1, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v15
    invoke-virtual v1, Lcom/bytedance/trae/network/WsMessage;->getProto()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, -014h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v6
    invoke-virtual v1, Lcom/bytedance/trae/network/WsMessage;->getData()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto -20h
    if-nez v15, +033h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "]: msg with null downSeqId"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "SeqNull"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v15, 6
    const/16 v16, 0
    move-object/from16 v1, v21
    move-object v9, v5
    move v5, v15
    move v15, v6
    move-object/from16 v6, v16
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    invoke-direct v7, v15, v9, v10, Lcom/bytedance/trae/network/HubNetConnection;->dispatchToListeners(I Ljava/lang/String; Z)V
    goto -53h
    move-object v9, v5
    move v2, v6
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "]: msg ="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v14, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-wide v3, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    invoke-virtual v15, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    cmp-long v1, v5, v3
    const-wide/16 v3, 1
    if-nez v1, +041h
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    if-eqz v1, +02ch
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "]: hit expected seq="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", proto="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v14, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v1, 1
    invoke-direct v7, v2, v9, v1, Lcom/bytedance/trae/network/HubNetConnection;->dispatchToListeners(I Ljava/lang/String; Z)V
    invoke-virtual v15, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    add-long/2addr v1, v3
    iput-wide v1, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    goto/16 -0bfh
    invoke-virtual v15, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    iget-wide v3, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    cmp-long v1, v5, v3
    if-lez v1, -0c9h
    const/4 v6, 0
    if-eqz v23, +02ch
    invoke-direct v7, v2, v9, v10, Lcom/bytedance/trae/network/HubNetConnection;->dispatchToListeners(I Ljava/lang/String; Z)V
    invoke-virtual v15, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    const-wide/16 v3, 1
    add-long/2addr v1, v3
    iput-wide v1, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, nextExpectedDownSeq
    iget-wide v3, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    invoke-virtual v1, v2, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v2, seq
    invoke-virtual v15, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    invoke-virtual v1, v2, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v2, "HttpGaped"
    invoke-direct v7, v2, v6, v1, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto/16 -0f6h
    iget-boolean v1, v7, Lcom/bytedance/trae/network/HubNetConnection;->isFillingGap Z
    if-nez v1, +05bh
    const-string v2, "FrontierGapedFilling"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v9, 0
    move-object/from16 v1, v21
    move-object v12, v6
    move-object v6, v9
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, "]: gap detected, expected="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v2, v7, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    invoke-virtual v0, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", got="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", starting fillGap"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v14, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v1, 1
    iput-boolean v1, v7, Lcom/bytedance/trae/network/HubNetConnection;->isFillingGap Z
    iget-object v15, v7, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/16 v16, 0
    const/16 v17, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$dispatch$1$1;
    invoke-direct v0, v7, v12, Lcom/bytedance/trae/network/HubNetConnection$dispatch$1$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v18, v0
    check-cast v18, Lkotlin/jvm/functions/Function2;
    const/16 v19, 3
    const/16 v20, 0
    invoke-static/range v15 ... v20, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +32h
    const-string v2, "FrontierGapedNoFilling"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object/from16 v1, v21
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, "]: gap at seq="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, " but fillGap already running"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v14, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v23, +015h
    invoke-interface v11, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +00fh
    iget-boolean v0, v7, Lcom/bytedance/trae/network/HubNetConnection;->isFillingGap Z
    if-eqz v0, +009h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "dispatch[HTTP]: all msgs filtered or empty, stopping fillGap"
    invoke-virtual v0, v14, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iput-boolean v10, v7, Lcom/bytedance/trae/network/HubNetConnection;->isFillingGap Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v8, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    move-exception v0
    invoke-interface v8, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    :try_start_0xc
    :try_start_0x5d
    :try_start_0x178
    :try_start_0x196
.end method

.method private final dispatchToListeners(int  java.lang.String  boolean)void
    .registers 6
    # ins_size=4
    iget-object v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetMessageListener;
    invoke-interface v1, v3, v4, v5, Lcom/bytedance/trae/network/HubNetMessageListener;->onMessage(I Ljava/lang/String; Z)V
    goto -fh
    return-void 
.end method

.method private final drainPendingQueueViaFrontier()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    const-string v1, "HubNetConnection"
    if-nez v0, +011h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "drainPendingQueueViaFrontier: frontier missing, switching to HTTP_FALLBACK"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    iput-object v0, v9, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-direct v9, Lcom/bytedance/trae/network/HubNetConnection;->startHttpFallback()V
    return-void 
    new-instance v2, Ljava/util/ArrayList;
    iget-object v3, v9, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v3, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda6;
    invoke-direct v3, v9, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/network/HubNetConnection;)V
    invoke-static v3, Lkotlin/sequences/SequencesKt;->generateSequence(Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;
    move-result-object v3
    invoke-interface v3, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +00ch
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v2, v4, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -fh
    invoke-virtual v2, Ljava/util/ArrayList;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    move-object v3, v2
    check-cast v3, Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v4
    const/4 v5, 1
    if-le v4, v5, +00ch
    new-instance v4, Lcom/bytedance/trae/network/HubNetConnection$drainPendingQueueViaFrontier$$inlined$sortBy$1;
    invoke-direct v4, Lcom/bytedance/trae/network/HubNetConnection$drainPendingQueueViaFrontier$$inlined$sortBy$1;-><init>()V
    check-cast v4, Ljava/util/Comparator;
    invoke-static v3, v4, Lkotlin/collections/CollectionsKt;->sortWith(Ljava/util/List; Ljava/util/Comparator;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "drainPendingQueueViaFrontier: "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Ljava/util/ArrayList;->size()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, " messages"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-wide v3, v9, Lcom/bytedance/trae/network/HubNetConnection;->websocketGeneration J
    invoke-virtual v2, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const-string v2, "iterator(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +020h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    const-string v5, "next(...)"
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    iget v5, v9, Lcom/bytedance/trae/network/HubNetConnection;->channelId I
    invoke-virtual v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getBytes()[B
    move-result-object v6
    invoke-virtual v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getHeaders()Ljava/util/Map;
    move-result-object v7
    new-instance v8, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda7;
    invoke-direct v8, v2, v9, v3, v4, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/network/HubNetConnection$PendingSend; Lcom/bytedance/trae/network/HubNetConnection; J)V
    invoke-virtual v0, v5, v6, v7, v8, Lcom/bytedance/trae/network/FrontierConnection;->sendBytes(I [B Ljava/util/Map; Lkotlin/jvm/functions/Function1;)V
    goto -23h
    return-void 
.end method

.method private static final drainPendingQueueViaFrontier$lambda$42(com.bytedance.trae.network.HubNetConnection)com.bytedance.trae.network.HubNetConnection$PendingSend
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentLinkedQueue;->poll()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    return-object v0
.end method

.method private static final drainPendingQueueViaFrontier$lambda$45(com.bytedance.trae.network.HubNetConnection$PendingSend  com.bytedance.trae.network.HubNetConnection  long  boolean)kotlin.Unit
    .registers 7
    # ins_size=5
    if-nez v6, +031h
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "drainViaFrontier: send failed upSeq="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getMessage()Lcom/bytedance/trae/network/WsMessage;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/WsMessage;->getUpSeqId()Ljava/lang/Long;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", re-queuing"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "HubNetConnection"
    invoke-virtual v6, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    invoke-direct v3, v2, v4, Lcom/bytedance/trae/network/HubNetConnection;->reEnqueuePendingSends(Ljava/util/List; Ljava/lang/Long;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final fillGap(long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=4
    const-string v0, "fillGap start: fromSeq="
    instance-of v1, v14, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;
    if-eqz v1, +012h
    move-object v1, v14
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;
    iget v2, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v14, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->label I
    sub-int/2addr v14, v3
    iput v14, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;
    invoke-direct v1, v11, v14, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->label I
    const-string v4, "HubNetConnection"
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v3, +01fh
    if-ne v3, v6, +015h
    iget-object v12, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->L$2 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v13, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->L$1 Ljava/lang/Object;
    check-cast v13, Lorg/json/JSONObject;
    iget-object v0, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4ah
    move-exception v12
    goto/16 +11dh
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v13, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v13, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v14, Lorg/json/JSONObject;
    invoke-direct v14, Lorg/json/JSONObject;-><init>()V
    const-string v3, "fromSeq"
    invoke-virtual v14, v3, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    iput-wide v12, v0, Lkotlin/jvm/internal/Ref$LongRef;->element J
    move-object v13, v14
    move-object v12, v0
    move-object v0, v11
    iget-boolean v14, v0, Lcom/bytedance/trae/network/HubNetConnection;->isFillingGap Z
    if-eqz v14, +0beh
    iget-wide v7, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    iput-object v0, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->L$0 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->L$2 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/network/HubNetConnection$fillGap$1;->label I
    invoke-direct v0, v7, v8, v1, Lcom/bytedance/trae/network/HubNetConnection;->pollViaHttp(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v2, +003h
    return-object v2
    check-cast v14, Ljava/util/List;
    move-object v3, v14
    check-cast v3, Ljava/util/Collection;
    const/4 v7, 0
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v3, v7
    goto +2h
    move v3, v6
    if-eqz v3, +010h
    const-string v14, "empty"
    invoke-direct v0, v14, v5, v13, Lcom/bytedance/trae/network/HubNetConnection;->monitorFillGap(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v14
    invoke-direct v0, v14, v6, Lcom/bytedance/trae/network/HubNetConnection;->dispatch(Ljava/util/List; Z)V
    goto/16 +08bh
    move-object v3, v14
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/2addr v3, v6
    if-eqz v3, +027h
    const-string/jumbo v3, response_min_seq_num
    invoke-interface v14, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v7, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v7
    invoke-virtual v13, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, response_max_seq_num
    invoke-interface v14, Ljava/util/List;->size()I
    move-result v7
    sub-int/2addr v7, v6
    invoke-interface v14, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v7, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v7
    invoke-virtual v13, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "full"
    invoke-direct v0, v3, v5, v13, Lcom/bytedance/trae/network/HubNetConnection;->monitorFillGap(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    invoke-direct v0, v14, v6, Lcom/bytedance/trae/network/HubNetConnection;->dispatch(Ljava/util/List; Z)V
    iget-boolean v3, v0, Lcom/bytedance/trae/network/HubNetConnection;->isFillingGap Z
    if-nez v3, +008h
    const-string v14, "break"
    invoke-direct v0, v14, v5, v13, Lcom/bytedance/trae/network/HubNetConnection;->monitorFillGap(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +49h
    check-cast v14, Ljava/lang/Iterable;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +038h
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v3, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v7
    goto +3h
    iget-wide v7, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01bh
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v3, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v9
    goto +3h
    iget-wide v9, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    cmp-long v3, v7, v9
    if-gez v3, -01bh
    move-wide v7, v9
    goto -1eh
    iput-wide v7, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    goto/16 -0b8h
    new-instance v12, Ljava/util/NoSuchElementException;
    invoke-direct v12, Ljava/util/NoSuchElementException;-><init>()V
    throw v12
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    const-string v2, "fillGap done: cursor="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v1, ", nextExpected="
    invoke-virtual v12, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    iget-wide v1, v0, Lcom/bytedance/trae/network/HubNetConnection;->nextExpectedDownSeq J
    invoke-virtual v12, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v14, v4, v12, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +27h
    move-exception v12
    move-object v0, v11
    move-object v13, v14
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "fillGap error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v14, v4, v12, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const-string v12, "error"
    invoke-direct v0, v12, v5, v13, Lcom/bytedance/trae/network/HubNetConnection;->monitorFillGap(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v12
    invoke-direct v0, v12, v6, Lcom/bytedance/trae/network/HubNetConnection;->dispatch(Ljava/util/List; Z)V
    invoke-static Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere()V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    :try_start_0x37
    :try_start_0x4e
    :try_start_0x53
    :try_start_0x6f
    :try_start_0xa6
    :try_start_0xda
.end method

.method private final flushPendingViaHttp(kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=2
    new-instance v0, Ljava/util/ArrayList;
    iget-object v1, v9, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v1, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    new-instance v1, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda1;
    invoke-direct v1, v9, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/network/HubNetConnection;)V
    invoke-static v1, Lkotlin/sequences/SequencesKt;->generateSequence(Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;
    move-result-object v1
    invoke-interface v1, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v0, v2, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -fh
    invoke-virtual v0, Ljava/util/ArrayList;->isEmpty()Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +007h
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v10
    return-object v10
    const-string v4, "HttpFlush"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v9
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    move-object v1, v0
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v3
    if-le v3, v2, +00ch
    new-instance v2, Lcom/bytedance/trae/network/HubNetConnection$flushPendingViaHttp$$inlined$sortBy$1;
    invoke-direct v2, Lcom/bytedance/trae/network/HubNetConnection$flushPendingViaHttp$$inlined$sortBy$1;-><init>()V
    check-cast v2, Ljava/util/Comparator;
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->sortWith(Ljava/util/List; Ljava/util/Comparator;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "flushPendingViaHttp: sending "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/util/ArrayList;->size()I
    move-result v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, " msgs, upSeq=["
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v1, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v3, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getMessage()Lcom/bytedance/trae/network/WsMessage;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/WsMessage;->getUpSeqId()Ljava/lang/Long;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ".."
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v1, Lkotlin/collections/CollectionsKt;->last(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v3, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getMessage()Lcom/bytedance/trae/network/WsMessage;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/WsMessage;->getUpSeqId()Ljava/lang/Long;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v3, 93
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v3, "HubNetConnection"
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v9, v1, v10, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    return-object v10
.end method

.method private static final flushPendingViaHttp$lambda$36(com.bytedance.trae.network.HubNetConnection)com.bytedance.trae.network.HubNetConnection$PendingSend
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentLinkedQueue;->poll()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    return-object v0
.end method

.method private static final frontierBytesListener$lambda$2(com.bytedance.trae.network.HubNetConnection  byte[])kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "bytes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->handleFrontierMessage([B)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final frontierStateListener$lambda$3(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.NetworkConnectState)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->handleFrontierStateChange(Lcom/bytedance/trae/network/NetworkConnectState;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final getEnterpriseUserIdFromToken()java.lang.String
    .registers 11
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v0
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
    return-object v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection;
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    const-string v0, "."
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 6
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +004h
    move-object v1, v3
    goto +4ah
    const/16 v1, 11
    invoke-static v0, v1, Landroid/util/Base64;->decode(Ljava/lang/String; I)[B
    move-result-object v0
    new-instance v1, Lorg/json/JSONObject;
    new-instance v4, Ljava/lang/String;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v5, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v4, v0, v5, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    invoke-direct v1, v4, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v0, "data"
    invoke-virtual v1, v0, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v0
    if-nez v0, +003h
    goto -1fh
    const-string/jumbo v1, user_id
    invoke-virtual v0, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +003h
    goto +2h
    move-object v1, v3
    if-nez v1, +015h
    const-string v1, "id"
    invoke-virtual v0, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v2
    if-eqz v0, -049h
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-eqz v1, +01ch
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "getEnterpriseUserIdFromToken failed: "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v4, "HubNetConnection"
    invoke-virtual v2, v4, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    check-cast v3, Ljava/lang/String;
    return-object v3
    :try_start_0x17
.end method

.method private final getFallbackHeaders()java.util.Map
    .registers 4
    # ins_size=1
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v0
    const-string v1, "Content-Type"
    const-string v2, "application/json"
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->extraHeaders Ljava/util/Map;
    invoke-interface v0, v1, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    invoke-static v0, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method private final getFrontierId()java.lang.Long
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    const/4 v1, 0
    if-eqz v0, +00fh
    iget-object v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/network/SseConnection;->getFrontierId()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    return-object v1
    iget-object v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/network/FrontierConnection;->getFrontierId()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    return-object v1
.end method

.method private final getRegisterFrontierId(com.bytedance.trae.network.FrontierConfig  java.lang.String  java.lang.String  int)java.lang.Long
    .registers 7
    # ins_size=5
    iget-boolean v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-nez v0, +007h
    invoke-direct v2, Lcom/bytedance/trae/network/HubNetConnection;->getFrontierId()Ljava/lang/Long;
    move-result-object v3
    return-object v3
    if-nez v4, +019h
    sget-object v4, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v4, Lcom/bytedance/trae/platform/service/ApplogService;->getUserID()Ljava/lang/String;
    move-result-object v4
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    goto +2h
    move-object v4, v1
    if-nez v4, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/network/FrontierIdGenerator;->INSTANCE Lcom/bytedance/trae/network/FrontierIdGenerator;
    invoke-virtual v3, Lcom/bytedance/trae/network/FrontierConfig;->getAppId()I
    move-result v3
    invoke-virtual v0, v4, v3, v5, v6, Lcom/bytedance/trae/network/FrontierIdGenerator;->generateFrontierId(Ljava/lang/String; I Ljava/lang/String; I)J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    return-object v3
.end method

.method private final getRegisterUserId()java.lang.String
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/HubNetConnection;->extraHeaders Ljava/util/Map;
    const-string/jumbo v1, user_id
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const/4 v1, 0
    if-eqz v0, +00eh
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    iget-boolean v2, v3, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-nez v2, +003h
    return-object v0
    invoke-direct v3, Lcom/bytedance/trae/network/HubNetConnection;->getEnterpriseUserIdFromToken()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +017h
    if-nez v0, +013h
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getUserID()Ljava/lang/String;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +005h
    move-object v1, v0
    goto +2h
    move-object v1, v2
    return-object v1
.end method

.method private final handleFrontierMessage(byte[])void
    .registers 5
    # ins_size=2
    new-instance v0, Ljava/lang/String;
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v0, v4, v1, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    iget-object v4, v3, Lcom/bytedance/trae/network/HubNetConnection;->gson Lcom/google/gson/Gson;
    const-class v1, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v4, v0, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/network/WsMessage;
    if-nez v4, +003h
    return-void 
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    const/4 v0, 0
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/network/HubNetConnection;->dispatch(Ljava/util/List; Z)V
    goto +1bh
    move-exception v4
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleFrontierMessage error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "HubNetConnection"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere()V
    return-void 
    :try_start_0x0
.end method

.method private final handleFrontierStateChange(com.bytedance.trae.network.NetworkConnectState)void
    .registers 8
    # ins_size=2
    const-string v0, "Frontier disconnected, switching "
    const-string v1, "Frontier connected, switching "
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "frontierStateChange: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", currentMode="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v4, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "HubNetConnection"
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v7, Lcom/bytedance/trae/network/NetworkConnectState;->ordinal()I
    move-result v7
    aget v7, v2, v7
    const-string/jumbo v2, transportMode
    const/4 v3, 1
    const/4 v5, 0
    if-eq v7, v3, +0c4h
    const/4 v1, 2
    if-eq v7, v1, +054h
    const/4 v0, 3
    if-ne v7, v0, +04bh
    iget-object v7, v6, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v7, Ljava/util/concurrent/locks/Lock;
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v1, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v0, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v0
    aget v0, v1, v0
    packed-switch v0, +0000128h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    goto +2ah
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->CONNECTING Lcom/bytedance/trae/network/TransportMode;
    iput-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    goto +19h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Frontier reconnecting, switching WEBSOCKET → HTTP_FALLBACK"
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v5, v3, v5, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v5, v6, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    iput-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-direct v6, Lcom/bytedance/trae/network/HubNetConnection;->startHttpFallback()V
    const/4 v3, 0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    if-eqz v3, +0f5h
    invoke-direct v6, Lcom/bytedance/trae/network/HubNetConnection;->scheduleInitialFrontierConnectTimeout()V
    goto/16 +0f0h
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    iget-object v1, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v1, Lcom/bytedance/trae/network/TransportMode;->name()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "FrontierDisconnected"
    invoke-direct v6, v1, v5, v7, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    iget-object v7, v6, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v7, Ljava/util/concurrent/locks/Lock;
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v1, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v2, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v1, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v1
    aget v1, v2, v1
    packed-switch v1, +00000d6h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    goto +3bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, " → HTTP_FALLBACK"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v5, v3, v5, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v5, v6, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v5, v3, v5, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v5, v6, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    iput-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-direct v6, Lcom/bytedance/trae/network/HubNetConnection;->startHttpFallback()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    goto/16 +07dh
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v0, Lcom/bytedance/trae/network/TransportMode;->name()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, v2, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "FrontierConnected"
    invoke-direct v6, v0, v5, v7, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    iget-object v7, v6, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v7, Ljava/util/concurrent/locks/Lock;
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v2, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v0, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v0
    aget v0, v2, v0
    packed-switch v0, +0000079h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    goto +4ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " → WEBSOCKET"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    if-ne v0, v1, +005h
    invoke-direct v6, Lcom/bytedance/trae/network/HubNetConnection;->stopHttpFallback()V
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v5, v3, v5, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v5, v6, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v5, v3, v5, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v5, v6, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->WEBSOCKET Lcom/bytedance/trae/network/TransportMode;
    iput-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    iget-wide v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->websocketGeneration J
    const-wide/16 v2, 1
    add-long/2addr v0, v2
    iput-wide v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->websocketGeneration J
    invoke-direct v6, Lcom/bytedance/trae/network/HubNetConnection;->drainPendingQueueViaFrontier()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    invoke-interface v7, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    nop 
    packed-switch-payload 1 2 3 4 5 6
    packed-switch-payload 1 2 3 4 5 6
    packed-switch-payload 1 2 3 4 5 6
    :try_start_0x42
    :try_start_0x7b
    :try_start_0x8a
    :try_start_0xa4
    :try_start_0xee
    :try_start_0xf7
    :try_start_0x111
    :try_start_0x16a
.end method

.method private final handleSseStateChange(com.bytedance.trae.network.SseState)void
    .registers 22
    # ins_size=2
    move-object/from16 v7, v20
    const-string v0, "SSE degrading to HTTP_FALLBACK after "
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, sseStateChange: 
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v3, v21
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", currentMode="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v4, v7, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v4, "HubNetConnection"
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v21, Lcom/bytedance/trae/network/SseState;->ordinal()I
    move-result v2
    aget v1, v1, v2
    const/4 v2, 1
    if-eq v1, v2, +07ah
    const/4 v2, 2
    if-eq v1, v2, +00dh
    const/4 v0, 3
    if-ne v1, v0, +004h
    goto/16 +0a8h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    iget-object v1, v7, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/SseConnection;->getConsecutiveFailures()I
    move-result v1
    goto +2h
    const/4 v1, 0
    new-instance v2, Lcom/bytedance/trae/network/SseConfig;
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const-wide/16 v13, 0
    const-wide/16 v15, 0
    const/16 v17, 0
    const/16 v18, 31
    const/16 v19, 0
    move-object v8, v2
    invoke-direct/range v8 ... v19, Lcom/bytedance/trae/network/SseConfig;-><init>(J J J J I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v2, Lcom/bytedance/trae/network/SseConfig;->getMaxConsecutiveFailures()I
    move-result v2
    if-lt v1, v2, +07eh
    iget-object v2, v7, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    move-object v8, v2
    check-cast v8, Ljava/util/concurrent/locks/Lock;
    invoke-interface v8, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v2, v7, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v3, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    if-ne v2, v3, +02fh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " failures"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    iput-object v0, v7, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-direct/range v20, Lcom/bytedance/trae/network/HubNetConnection;->startHttpFallback()V
    invoke-direct/range v20, Lcom/bytedance/trae/network/HubNetConnection;->startSseBackgroundRetry()V
    const-string v2, "SseDegradedToHttp"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object/from16 v1, v20
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v8, Ljava/util/concurrent/locks/Lock;->unlock()V
    goto +3ch
    move-exception v0
    invoke-interface v8, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    iget-object v0, v7, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    move-object v1, v0
    check-cast v1, Ljava/util/concurrent/locks/Lock;
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v0, v7, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v3, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    if-ne v0, v3, +010h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "SSE connected, switching HTTP_FALLBACK → SSE"
    invoke-virtual v0, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v20, Lcom/bytedance/trae/network/HubNetConnection;->stopHttpFallback()V
    sget-object v0, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    iput-object v0, v7, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    iget-object v0, v7, Lcom/bytedance/trae/network/HubNetConnection;->sseBackgroundRetryJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +005h
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v7, Lcom/bytedance/trae/network/HubNetConnection;->sseBackgroundRetryJob Lkotlinx/coroutines/Job;
    const-string v2, "SseConnected"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object/from16 v1, v20
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-void 
    move-exception v0
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    :try_start_0x6e
    :try_start_0xb4
.end method

.method private final monitorFillGap(java.lang.String  org.json.JSONObject  org.json.JSONObject)void
    .registers 6
    # ins_size=4
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, status
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "hub_http_fill_gap"
    invoke-static v3, v0, v4, v5, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
.end method

.method static synthetic monitorFillGap$default(com.bytedance.trae.network.HubNetConnection  java.lang.String  org.json.JSONObject  org.json.JSONObject  int  java.lang.Object)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->monitorFillGap(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private final monitorStatus(java.lang.String  org.json.JSONObject  org.json.JSONObject)void
    .registers 6
    # ins_size=4
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, status
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "hub_connection_monitor"
    invoke-static v3, v0, v4, v5, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method static synthetic monitorStatus$default(com.bytedance.trae.network.HubNetConnection  java.lang.String  org.json.JSONObject  org.json.JSONObject  int  java.lang.Object)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private final pollViaHttp(long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=4
    instance-of v0, v13, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;
    if-eqz v0, +012h
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;
    iget v1, v0, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v13, v0, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->label I
    sub-int/2addr v13, v2
    iput v13, v0, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;
    invoke-direct v0, v10, v13, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v8, v0
    iget-object v13, v8, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->label I
    const/4 v2, 1
    const/4 v9, 0
    if-eqz v1, +015h
    if-ne v1, v2, +00bh
    iget-object v11, v8, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v1, v11
    goto +48h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v12, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v12, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct v10, Lcom/bytedance/trae/network/HubNetConnection;->getFrontierId()Ljava/lang/Long;
    move-result-object v13
    if-eqz v13, +0b3h
    invoke-virtual v13, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    sget-object v13, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v13, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v5
    new-instance v13, Lorg/json/JSONObject;
    invoke-direct v13, Lorg/json/JSONObject;-><init>()V
    const-string v1, "fromDownSeqId"
    invoke-virtual v13, v1, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v1, "HttpPoll"
    invoke-direct v10, v1, v9, v13, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v1, Lcom/bytedance/trae/network/HubNetFallbackApi;->Companion Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
    invoke-direct v10, Lcom/bytedance/trae/network/HubNetConnection;->getFallbackHeaders()Ljava/util/Map;
    move-result-object v13
    invoke-static v11, v12, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v6
    const/16 v11, 20
    invoke-static v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v7
    iput-object v10, v8, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->L$0 Ljava/lang/Object;
    iput v2, v8, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->label I
    move-object v2, v13
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;->pollRawCall$ttnet_mainlandRelease(Ljava/util/Map; J Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Integer; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    move-object v1, v10
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v11, v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v12, "HubNetConnection"
    if-eqz v11, +04ch
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v11
    if-eqz v11, +019h
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/network/FallbackPollResponse;
    if-eqz v11, +008h
    invoke-virtual v11, Lcom/bytedance/trae/network/FallbackPollResponse;->getMsgs()Ljava/util/List;
    move-result-object v9
    if-nez v9, +050h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v9
    goto +4ah
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v2, pollViaHttp biz error: code=
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v2
    invoke-virtual v0, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v11, v12, v13, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "HttpPollError"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    goto +23h
    instance-of v11, v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v11, +021h
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v2, pollViaHttp error: 
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v11, v12, v13, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "HttpPollError"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-object v9
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    return-object v9
    :try_start_0x4c
.end method

.method private final pushMessagesViaHttp(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v0, v19
    instance-of v3, v0, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;
    if-eqz v3, +012h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;
    iget v4, v3, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v0, v3, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->label I
    sub-int/2addr v0, v5
    iput v0, v3, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;
    invoke-direct v3, v1, v0, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v11, v3
    iget-object v0, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->label I
    const/4 v14, 1
    const-string v15, "HubNetConnection"
    const/16 v16, 0
    if-eqz v4, +02ah
    if-ne v4, v14, +020h
    iget-object v2, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$BooleanRef;
    iget-object v3, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->L$1 Ljava/lang/Object;
    check-cast v3, Ljava/util/List;
    iget-object v4, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v14, v2
    move-object v2, v3
    move-object v9, v4
    goto/16 +0a1h
    move-exception v0
    move-object v14, v2
    move-object v2, v3
    goto/16 +189h
    move-exception v0
    move-object v14, v2
    move-object v2, v3
    goto/16 +1a7h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v13, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v13, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    invoke-direct/range v17, Lcom/bytedance/trae/network/HubNetConnection;->getFrontierId()Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +15bh
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +017h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v13, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp$requeueOnce(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List;)V
    invoke-static/range v16, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    move-exception v0
    move-object v4, v1
    move-object v14, v13
    goto/16 +152h
    move-exception v0
    move-object v4, v1
    move-object v14, v13
    goto/16 +170h
    invoke-static v0, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    move-result-wide v7
    move-object v0, v2
    check-cast v0, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v9, 10
    invoke-static v0, v9, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v9
    invoke-direct v4, v9, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v9, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getMessage()Lcom/bytedance/trae/network/WsMessage;
    move-result-object v9
    invoke-interface v4, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    move-object v9, v4
    check-cast v9, Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/network/FallbackPushRequest;
    move-object v4, v0
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/network/FallbackPushRequest;-><init>(J J Ljava/util/List;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v5, "hub_fallback"
    const-class v6, Lcom/bytedance/trae/network/HubNetFallbackApi;
    invoke-direct/range v17, Lcom/bytedance/trae/network/HubNetConnection;->getFallbackHeaders()Ljava/util/Map;
    move-result-object v7
    new-instance v8, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$result$1;
    const/4 v9, 0
    invoke-direct v8, v0, v9, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$result$1;-><init>(Lcom/bytedance/trae/network/FallbackPushRequest; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 0
    const/4 v10, 0
    const/16 v12, 48
    const/4 v0, 0
    iput-object v1, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->L$0 Ljava/lang/Object;
    iput-object v2, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->L$1 Ljava/lang/Object;
    iput-object v13, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->L$2 Ljava/lang/Object;
    iput v14, v11, Lcom/bytedance/trae/network/HubNetConnection$pushMessagesViaHttp$1;->label I
    move-object v14, v13
    move-object v13, v0
    invoke-static/range v4 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v9, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v4, " messages"
    const-string v5, ", re-queuing "
    if-eqz v3, +074h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v3
    if-eqz v3, +027h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    const-string v4, "HTTP push "
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " messages ok"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v15, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 1
    goto/16 +088h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    const-string v7, "HTTP push biz error: code="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v6, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v15, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v14, v9, v2, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp$requeueOnce(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List;)V
    const-string v4, "HttpPushError"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v9
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    goto +45h
    instance-of v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +050h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    const-string v7, "HTTP push error: "
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v15, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v14, v9, v2, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp$requeueOnce(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List;)V
    const-string v4, "HttpPushError"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v9
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v3
    instance-of v3, v3, Ljava/util/concurrent/CancellationException;
    if-nez v3, +009h
    move/from16 v0, v16
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v0
    throw v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    move-object v4, v9
    goto +17h
    move-exception v0
    move-object v4, v9
    goto +37h
    move-object v14, v13
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v14, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp$requeueOnce(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List;)V
    invoke-static/range v16, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    move-exception v0
    goto +5h
    move-exception v0
    goto +26h
    move-exception v0
    move-object v14, v13
    move-object v4, v1
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, pushMessagesViaHttp error: 
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v15, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v14, v4, v2, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp$requeueOnce(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List;)V
    invoke-static Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere()V
    invoke-static/range v16, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    move-exception v0
    move-object v14, v13
    move-object v4, v1
    invoke-static v14, v4, v2, Lcom/bytedance/trae/network/HubNetConnection;->pushMessagesViaHttp$requeueOnce(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List;)V
    throw v0
    :try_start_0x3d
    :try_start_0x5f
    :try_start_0x71
    :try_start_0x86
    :try_start_0xa4
    :try_start_0xb2
    :try_start_0xdc
    :try_start_0xe4
    :try_start_0xee
    :try_start_0x1bf
.end method

.method private static final pushMessagesViaHttp$requeueOnce(kotlin.jvm.internal.Ref$BooleanRef  com.bytedance.trae.network.HubNetConnection  java.util.List)void
    .registers 4
    # ins_size=3
    iget-boolean v0, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    if-nez v0, +00ah
    const/4 v0, 1
    iput-boolean v0, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    const/4 v1, 2
    const/4 v0, 0
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/network/HubNetConnection;->reEnqueuePendingSends$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/util/List; Ljava/lang/Long; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final reEnqueuePendingSends(java.util.List  java.lang.Long)void
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v0, Ljava/util/concurrent/locks/Lock;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    if-ne v1, v2, +006h
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    check-cast v4, Ljava/lang/Iterable;
    iget-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00ch
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v1, v2, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z
    goto -fh
    iget-object v4, v3, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->WEBSOCKET Lcom/bytedance/trae/network/TransportMode;
    if-ne v4, v1, +010h
    if-eqz v5, +00ch
    invoke-virtual v5, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    iget-wide v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->websocketGeneration J
    cmp-long v4, v4, v1
    if-gez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +006h
    invoke-direct v3, Lcom/bytedance/trae/network/HubNetConnection;->drainPendingQueueViaFrontier()V
    goto +4h
    invoke-direct v3, Lcom/bytedance/trae/network/HubNetConnection;->schedulePendingQueuePumpLocked()V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    move-exception v4
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v4
    :try_start_0x7
    :try_start_0x11
.end method

.method static synthetic reEnqueuePendingSends$default(com.bytedance.trae.network.HubNetConnection  java.util.List  java.lang.Long  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->reEnqueuePendingSends(Ljava/util/List; Ljava/lang/Long;)V
    return-void 
.end method

.method private final registerApp(com.bytedance.trae.network.FrontierConfig  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v19
    instance-of v2, v1, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;
    iget v3, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->label I
    const/4 v5, 0
    const-string v6, "HubNetConnection"
    const/4 v7, 1
    if-eqz v4, +016h
    if-ne v4, v7, +00ch
    iget-object v2, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v2
    goto/16 +0a4h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct/range v17, Lcom/bytedance/trae/network/HubNetConnection;->getRegisterUserId()Ljava/lang/String;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v4, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v10
    iget-boolean v4, v0, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-eqz v4, +005h
    const-string v4, "Trae"
    goto +3h
    const-string v4, "Android"
    invoke-static Landroid/os/Process;->myPid()I
    move-result v14
    move-object/from16 v15, v18
    invoke-direct v0, v15, v1, v4, v14, Lcom/bytedance/trae/network/HubNetConnection;->getRegisterFrontierId(Lcom/bytedance/trae/network/FrontierConfig; Ljava/lang/String; Ljava/lang/String; I)Ljava/lang/Long;
    move-result-object v12
    iget-boolean v9, v0, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    iget-object v13, v0, Lcom/bytedance/trae/network/HubNetConnection;->clientMetadata Lcom/bytedance/trae/network/HubClientMetadata;
    move-object/from16 v8, v18
    move-object v11, v1
    move-object/from16 v16, v13
    move-object v13, v4
    move-object/from16 v15, v16
    invoke-static/range v8 ... v15, Lcom/bytedance/trae/network/HubNetConnectionKt;->buildRegisterAppRequest(Lcom/bytedance/trae/network/FrontierConfig; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Lcom/bytedance/trae/network/HubClientMetadata;)Lcom/bytedance/trae/network/RegisterAppRequest;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string/jumbo v11, registerApp: appId=
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/network/FrontierConfig;->getAppId()I
    move-result v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", isToB="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    iget-boolean v11, v0, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", hasUserId="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +011h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v7
    goto +2h
    move v1, v5
    if-ne v1, v7, +004h
    move v1, v7
    goto +2h
    move v1, v5
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v10, ", appRuntimeType="
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v6, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/network/RegisterAppApi;->Companion Lcom/bytedance/trae/network/RegisterAppApi$Companion;
    iget-boolean v4, v0, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-eqz v4, +009h
    sget-object v4, Lcom/bytedance/trae/network/RegisterAppApi;->Companion Lcom/bytedance/trae/network/RegisterAppApi$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->getTOB_REGISTER_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v4
    goto +7h
    sget-object v4, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v4
    iput-object v0, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->L$0 Ljava/lang/Object;
    iput v7, v2, Lcom/bytedance/trae/network/HubNetConnection$registerApp$1;->label I
    invoke-virtual v1, v8, v4, v2, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->safeCall(Lcom/bytedance/trae/network/RegisterAppRequest; Ljava/util/Set; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v8, v0
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +0b1h
    iget-boolean v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-nez v2, +00fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, registerApp success
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-nez v2, +04ah
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, registerApp failed: code=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v3, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", message="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v6, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v9, registerAppFailed
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 6
    const/4 v13, 0
    invoke-static/range v8 ... v13, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/RegisterAppResponse;
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/network/RegisterAppResponse;->getApp()Lcom/bytedance/trae/network/AppInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/AppInfo;->getFrontierId()Ljava/lang/Long;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    iget-boolean v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-eqz v2, +019h
    if-eqz v1, +017h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v2, v2, v4
    if-lez v2, +00dh
    iget-object v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v2, +009h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/network/SseConnection;->updateFrontierId(J)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, registerApp success, serverFrontierId=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v6, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move v5, v7
    goto +24h
    instance-of v2, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +026h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, registerApp failed: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v6, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v9, registerAppFailed
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 6
    const/4 v13, 0
    invoke-static/range v8 ... v13, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method

.method private final scheduleInitialFrontierConnectTimeout()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v0, Ljava/util/concurrent/locks/Lock;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v1, +006h
    const/4 v3, 1
    invoke-static v1, v2, v3, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;
    invoke-direct v5, v8, v2, Lcom/bytedance/trae/network/HubNetConnection$scheduleInitialFrontierConnectTimeout$1$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    move-object v2, v1
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    iput-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    move-exception v1
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v1
    :try_start_0x7
.end method

.method private final schedulePendingQueuePumpLocked()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentLinkedQueue;->isEmpty()Z
    move-result v0
    if-nez v0, +034h
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    goto +23h
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->WEBSOCKET Lcom/bytedance/trae/network/TransportMode;
    if-eq v0, v1, +009h
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    if-eq v0, v1, +003h
    return-void 
    iget-object v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;
    const/4 v1, 0
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/network/HubNetConnection$schedulePendingQueuePumpLocked$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static synthetic sendBytesToHub$default(com.bytedance.trae.network.HubNetConnection  int  byte[]  java.util.Map  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/network/HubNetConnection;->sendBytesToHub(I [B Ljava/util/Map;)V
    return-void 
.end method

.method private static final sendBytesToHub$lambda$26$lambda$25(long  com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.HubNetConnection$PendingSend  long  boolean)kotlin.Unit
    .registers 9
    # ins_size=7
    if-nez v8, +024h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, sendBytesToHub[WS]: frontier send failed, enqueue upSeq=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "HubNetConnection"
    invoke-virtual v8, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v5, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-static v6, v7, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/network/HubNetConnection;->reEnqueuePendingSends(Ljava/util/List; Ljava/lang/Long;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public static synthetic setup$default(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  java.util.Map  boolean  com.bytedance.trae.network.HubClientMetadata  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +008h
    sget-object v4, Lcom/bytedance/trae/network/HubClientMetadata;->Companion Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->fromSystem()Lcom/bytedance/trae/network/HubClientMetadata;
    move-result-object v4
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->setup(Lcom/bytedance/trae/network/FrontierConfig; Ljava/util/Map; Z Lcom/bytedance/trae/network/HubClientMetadata;)V
    return-void 
.end method

.method private static final sseMessageListener$lambda$19(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.WsMessage)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "msg"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    const/4 v1, 1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->dispatch(Ljava/util/List; Z)V
    invoke-virtual v3, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v3
    if-eqz v3, +00fh
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iget-object v2, v2, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v2, +005h
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/network/SseConnection;->updateLastSeqId(J)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final sseStateListener$lambda$20(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.SseState)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->handleSseStateChange(Lcom/bytedance/trae/network/SseState;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final startConnectedTransport(java.lang.String)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isHubHttpFallbackForced()Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->startForcedHttpFallback(Ljava/lang/String;)V
    goto +ch
    iget-boolean v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-eqz v0, +006h
    invoke-direct v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->startSseTransport(Ljava/lang/String;)V
    goto +4h
    invoke-direct v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->startFrontierConnect(Ljava/lang/String;)V
    return-void 
.end method

.method private final startForcedHttpFallback(java.lang.String)void
    .registers 7
    # ins_size=2
    const-string/jumbo v0, startForcedHttpFallback: reason=
    iget-object v1, v5, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v1, Ljava/util/concurrent/locks/Lock;
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v2, v5, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v3, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    const-string v4, "HubNetConnection"
    if-ne v2, v3, +00eh
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, startForcedHttpFallback: already SHUTDOWN, skip
    invoke-virtual v6, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v4, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v6, +009h
    iget v0, v5, Lcom/bytedance/trae/network/HubNetConnection;->channelId I
    iget-object v2, v5, Lcom/bytedance/trae/network/HubNetConnection;->frontierBytesListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v6, v0, v2, Lcom/bytedance/trae/network/FrontierConnection;->unregisterBytesListener(I Lkotlin/jvm/functions/Function1;)V
    iget-object v6, v5, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v6, +007h
    iget-object v0, v5, Lcom/bytedance/trae/network/HubNetConnection;->frontierStateListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v6, v0, Lcom/bytedance/trae/network/FrontierConnection;->unregisterStateListener(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v5, Lcom/bytedance/trae/network/HubNetConnection;->stopHttpFallback()V
    sget-object v6, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    iput-object v6, v5, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-direct v5, Lcom/bytedance/trae/network/HubNetConnection;->startHttpFallback()V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    move-exception v6
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v6
    :try_start_0xa
    :try_start_0x12
    :try_start_0x1e
.end method

.method private final startFrontierConnect(java.lang.String)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v0, Ljava/util/concurrent/locks/Lock;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    if-ne v1, v2, +010h
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "HubNetConnection"
    const-string/jumbo v2, startFrontierConnect: already SHUTDOWN, skip
    invoke-virtual v5, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->IDLE Lcom/bytedance/trae/network/TransportMode;
    if-ne v1, v2, +006h
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->CONNECTING Lcom/bytedance/trae/network/TransportMode;
    iput-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v1, +009h
    iget v2, v4, Lcom/bytedance/trae/network/HubNetConnection;->channelId I
    iget-object v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontierBytesListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/network/FrontierConnection;->registerBytesListener(I Lkotlin/jvm/functions/Function1;)V
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v1, +007h
    iget-object v2, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontierStateListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/FrontierConnection;->registerStateListener(Lkotlin/jvm/functions/Function1;)V
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    if-eqz v1, +005h
    invoke-virtual v1, v5, Lcom/bytedance/trae/network/FrontierConnection;->connect(Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/network/HubNetConnection;->scheduleInitialFrontierConnectTimeout()V
    return-void 
    move-exception v5
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v5
    :try_start_0x7
    :try_start_0x1b
.end method

.method private final startHttpFallback()void
    .registers 16
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "HubNetConnection"
    const-string/jumbo v2, startHttpFallback: starting flush + poll timers
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "HttpFallbackStart"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v15
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    iget-object v9, v15, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v10, 0
    const/4 v11, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;
    const/4 v1, 0
    invoke-direct v0, v15, v1, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v12, v0
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v13, 3
    const/4 v14, 0
    invoke-static/range v9 ... v14, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v15, Lcom/bytedance/trae/network/HubNetConnection;->httpFlushJob Lkotlinx/coroutines/Job;
    iget-object v2, v15, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;
    invoke-direct v0, v15, v1, Lcom/bytedance/trae/network/HubNetConnection$startHttpFallback$2;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v15, Lcom/bytedance/trae/network/HubNetConnection;->httpPollJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startSseBackgroundRetry()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/network/HubNetConnection;->sseBackgroundRetryJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v3, v9, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;
    invoke-direct v0, v9, v1, Lcom/bytedance/trae/network/HubNetConnection$startSseBackgroundRetry$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/network/HubNetConnection;->sseBackgroundRetryJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startSseTransport(java.lang.String)void
    .registers 7
    # ins_size=2
    const-string/jumbo v0, startSseTransport: reason=
    iget-object v1, v5, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v1, Ljava/util/concurrent/locks/Lock;
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v2, v5, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v3, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    const-string v4, "HubNetConnection"
    if-ne v2, v3, +00eh
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, startSseTransport: already SHUTDOWN, skip
    invoke-virtual v6, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v4, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v6, +007h
    iget-object v0, v5, Lcom/bytedance/trae/network/HubNetConnection;->sseMessageListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v6, v0, Lcom/bytedance/trae/network/SseConnection;->registerMessageListener(Lkotlin/jvm/functions/Function1;)V
    iget-object v6, v5, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v6, +007h
    iget-object v0, v5, Lcom/bytedance/trae/network/HubNetConnection;->sseStateListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v6, v0, Lcom/bytedance/trae/network/SseConnection;->registerStateListener(Lkotlin/jvm/functions/Function1;)V
    iget-object v6, v5, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v6, +005h
    invoke-virtual v6, Lcom/bytedance/trae/network/SseConnection;->connect()V
    sget-object v6, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    iput-object v6, v5, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    move-exception v6
    invoke-interface v1, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v6
    :try_start_0xa
    :try_start_0x12
    :try_start_0x1e
.end method

.method private final stopHttpFallback()void
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "HubNetConnection"
    const-string/jumbo v2, stopHttpFallback: cancelling flush + poll timers
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "HttpFallbackStop"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v9
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/network/HubNetConnection;->monitorStatus$default(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    iget-object v0, v9, Lcom/bytedance/trae/network/HubNetConnection;->httpFlushJob Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v9, Lcom/bytedance/trae/network/HubNetConnection;->httpFlushJob Lkotlinx/coroutines/Job;
    iget-object v0, v9, Lcom/bytedance/trae/network/HubNetConnection;->httpPollJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v9, Lcom/bytedance/trae/network/HubNetConnection;->httpPollJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final stopSseTransport()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v0, +007h
    iget-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->sseMessageListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/SseConnection;->unregisterMessageListener(Lkotlin/jvm/functions/Function1;)V
    iget-object v0, v3, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v0, +007h
    iget-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->sseStateListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/SseConnection;->unregisterStateListener(Lkotlin/jvm/functions/Function1;)V
    iget-object v0, v3, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/network/SseConnection;->disconnect()V
    iget-object v0, v3, Lcom/bytedance/trae/network/HubNetConnection;->sseBackgroundRetryJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->sseBackgroundRetryJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final checkAliveAndReconnect()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;
    const/4 v4, 0
    invoke-direct v3, v6, v4, Lcom/bytedance/trae/network/HubNetConnection$checkAliveAndReconnect$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final connect(java.lang.String  com.bytedance.trae.network.HubConnectionListener)void
    .registers 13
    # ins_size=3
    const-string/jumbo v0, reason
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "connect: reason="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "HubNetConnection"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v10, Lcom/bytedance/trae/network/HubNetConnection;->config Lcom/bytedance/trae/network/FrontierConfig;
    if-nez v6, +00dh
    move-object v11, v10
    check-cast v11, Lcom/bytedance/trae/network/HubNetConnection;
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v12, "connect: config is null, call setup() first"
    invoke-virtual v11, v2, v12, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->isDisabled()Z
    move-result v0
    if-nez v0, +01eh
    iget-object v0, v10, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v0, Ljava/util/concurrent/locks/Lock;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v1, v10, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v2, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    if-ne v1, v2, +006h
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->IDLE Lcom/bytedance/trae/network/TransportMode;
    iput-object v1, v10, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    goto +6h
    move-exception v11
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v11
    iget-object v1, v10, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v0, 0
    new-instance v9, Lcom/bytedance/trae/network/HubNetConnection$connect$2;
    const/4 v8, 0
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v7, v12
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener; Lkotlin/coroutines/Continuation;)V
    move-object v4, v9
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    move-object v3, v0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    :try_start_0x3a
.end method

.method public final disconnect(java.lang.String)void
    .registers 6
    # ins_size=2
    const-string/jumbo v0, reason
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "disconnect: reason="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "HubNetConnection"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    check-cast v0, Ljava/util/concurrent/locks/Lock;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->lock()V
    sget-object v1, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    iput-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +005h
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontierConnectTimeoutJob Lkotlinx/coroutines/Job;
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    if-eqz v1, +005h
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->pendingQueuePumpJob Lkotlinx/coroutines/Job;
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->networkRecoveryJob Lkotlinx/coroutines/Job;
    if-eqz v1, +005h
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->networkRecoveryJob Lkotlinx/coroutines/Job;
    goto +4h
    invoke-static Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere()V
    invoke-direct v4, Lcom/bytedance/trae/network/HubNetConnection;->stopHttpFallback()V
    iget-boolean v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    if-eqz v1, +008h
    invoke-direct v4, Lcom/bytedance/trae/network/HubNetConnection;->stopSseTransport()V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +1eh
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v1, +009h
    iget v2, v4, Lcom/bytedance/trae/network/HubNetConnection;->channelId I
    iget-object v3, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontierBytesListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/network/FrontierConnection;->unregisterBytesListener(I Lkotlin/jvm/functions/Function1;)V
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v1, +007h
    iget-object v2, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontierStateListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/FrontierConnection;->unregisterStateListener(Lkotlin/jvm/functions/Function1;)V
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v1, +007h
    invoke-virtual v1, v5, Lcom/bytedance/trae/network/FrontierConnection;->disconnect(Ljava/lang/String;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    move-exception v5
    invoke-interface v0, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v5
    :try_start_0x23
    :try_start_0x3b
    :try_start_0x45
.end method

.method public final registerMessageListener(com.bytedance.trae.network.HubNetMessageListener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    monitor-enter v0
    iget-object v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v1, v3, Ljava/util/concurrent/CopyOnWriteArraySet;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    monitor-exit v0
    return-void 
    iget-object v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v1, v3, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    monitor-exit v0
    return-void 
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x8
    :try_start_0x12
.end method

.method public final sendBytesToHub(int  byte[]  java.util.Map)void
    .registers 24
    # ins_size=4
    move-object/from16 v8, v20
    move-object/from16 v0, v22
    const-string/jumbo v1, sendBytesToHub[WS]: queue(
    const-string/jumbo v2, sendBytesToHub[WS]: frontier missing, enqueue upSeq=
    const-string/jumbo v3, sendBytesToHub[WS]: queue not empty(
    const-string/jumbo v4, sendBytesToHub: SHUTDOWN, ignoring upSeq=
    const-string/jumbo v5, sendBytesToHub[
    const-string/jumbo v6, sendBytesToHub[HTTP]: enqueue upSeq=
    const-string/jumbo v7, sendBytesToHub[SSE]: enqueue upSeq=
    const-string v9, "bytes"
    invoke-static v0, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v9, v8, Lcom/bytedance/trae/network/HubNetConnection;->upSeqId Ljava/util/concurrent/atomic/AtomicLong;
    invoke-virtual v9, Ljava/util/concurrent/atomic/AtomicLong;->incrementAndGet()J
    move-result-wide v9
    new-instance v15, Ljava/lang/String;
    sget-object v11, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v15, v0, v11, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    new-instance v14, Lcom/bytedance/trae/network/WsMessage;
    invoke-static/range v21, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v9, v10, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v13
    const/16 v16, 0
    const/16 v17, 4
    const/16 v18, 0
    move-object v11, v14
    move-object/from16 v19, v2
    move-object v2, v14
    move-object/from16 v14, v16
    move/from16 v16, v17
    move-object/from16 v17, v18
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/network/WsMessage;-><init>(Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v11, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    array-length v12, v0
    invoke-static v0, v12, Ljava/util/Arrays;->copyOf([B I)[B
    move-result-object v0
    const-string v12, "copyOf(...)"
    invoke-static v0, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v23, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v12
    goto +3h
    move-object/from16 v12, v23
    invoke-static v12, Lkotlin/collections/MapsKt;->toMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v12
    invoke-direct v11, v2, v0, v12, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;-><init>(Lcom/bytedance/trae/network/WsMessage; [B Ljava/util/Map;)V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->modeLock Ljava/util/concurrent/locks/ReentrantLock;
    move-object v12, v0
    check-cast v12, Ljava/util/concurrent/locks/Lock;
    invoke-interface v12, Ljava/util/concurrent/locks/Lock;->lock()V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    sget-object v2, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v0, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v0
    aget v0, v2, v0
    const/4 v2, 5
    const/4 v13, 0
    const-string v14, ", queueSize="
    const-string v15, "HubNetConnection"
    packed-switch v0, +0000188h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    goto/16 +17ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +160h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->transportMode Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "]: buffering upSeq="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v2, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v2
    add-int/lit8 v2, v2, 1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, v11, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z
    goto/16 +12bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v3, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v3, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v3
    add-int/lit8 v3, v3, 1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, v11, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v0
    if-lt v0, v2, +0fch
    iget-object v14, v8, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v15, 0
    const/16 v16, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$sendBytesToHub$1$4;
    invoke-direct v0, v8, v13, Lcom/bytedance/trae/network/HubNetConnection$sendBytesToHub$1$4;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v17, v0
    check-cast v17, Lkotlin/jvm/functions/Function2;
    const/16 v18, 3
    const/16 v19, 0
    invoke-static/range v14 ... v19, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto/16 +0e5h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v2, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v2
    add-int/lit8 v2, v2, 1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, v11, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$sendBytesToHub$1$3;
    invoke-direct v0, v8, v13, Lcom/bytedance/trae/network/HubNetConnection$sendBytesToHub$1$3;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto/16 +0abh
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +064h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v3, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "), enqueue upSeq="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v15, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, v11, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z
    invoke-direct/range v20, Lcom/bytedance/trae/network/HubNetConnection;->drainPendingQueueViaFrontier()V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v0
    if-lt v0, v2, +06dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v1, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I
    move-result v1
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ") >= threshold, fallback to HTTP flush"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v8, Lcom/bytedance/trae/network/HubNetConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$sendBytesToHub$1$1;
    invoke-direct v0, v8, v13, Lcom/bytedance/trae/network/HubNetConnection$sendBytesToHub$1$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +3ch
    iget-wide v6, v8, Lcom/bytedance/trae/network/HubNetConnection;->websocketGeneration J
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-nez v0, +01fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v19
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/network/HubNetConnection;->pendingSendQueue Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-virtual v0, v11, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z
    invoke-direct/range v20, Lcom/bytedance/trae/network/HubNetConnection;->schedulePendingQueuePumpLocked()V
    goto +19h
    iget v13, v8, Lcom/bytedance/trae/network/HubNetConnection;->channelId I
    invoke-virtual v11, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getBytes()[B
    move-result-object v14
    invoke-virtual v11, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getHeaders()Ljava/util/Map;
    move-result-object v15
    new-instance v5, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;
    move-object v1, v5
    move-wide v2, v9
    move-object/from16 v4, v20
    move-object v9, v5
    move-object v5, v11
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;-><init>(J Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/HubNetConnection$PendingSend; J)V
    invoke-virtual v0, v13, v14, v15, v9, Lcom/bytedance/trae/network/FrontierConnection;->sendBytes(I [B Ljava/util/Map; Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v12, Ljava/util/concurrent/locks/Lock;->unlock()V
    return-void 
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    invoke-interface v12, Ljava/util/concurrent/locks/Lock;->unlock()V
    throw v0
    packed-switch-payload 1 2 3 4 5 6
    :try_start_0x6c
    :try_start_0x7f
    :try_start_0x1fb
.end method

.method public final setup(com.bytedance.trae.network.FrontierConfig  java.util.Map  boolean  com.bytedance.trae.network.HubClientMetadata)void
    .registers 15
    # ins_size=5
    const-string v0, "config"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraHeaders"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clientMetadata"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, setup: url=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/network/FrontierConfig;->getUrl()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", appId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/network/FrontierConfig;->getAppId()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isToB="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "HubNetConnection"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v11, v10, Lcom/bytedance/trae/network/HubNetConnection;->config Lcom/bytedance/trae/network/FrontierConfig;
    iput-object v12, v10, Lcom/bytedance/trae/network/HubNetConnection;->extraHeaders Ljava/util/Map;
    iput-boolean v13, v10, Lcom/bytedance/trae/network/HubNetConnection;->isToB Z
    iput-object v14, v10, Lcom/bytedance/trae/network/HubNetConnection;->clientMetadata Lcom/bytedance/trae/network/HubClientMetadata;
    if-eqz v13, +062h
    iget-object v13, v10, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-nez v13, +009h
    new-instance v13, Lcom/bytedance/trae/network/SseConnection;
    invoke-direct v13, Lcom/bytedance/trae/network/SseConnection;-><init>()V
    iput-object v13, v10, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    sget-object v13, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v14, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v13, v14, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v10, Lcom/bytedance/trae/network/HubNetConnection;->getRegisterUserId()Ljava/lang/String;
    move-result-object v13
    const-string v14, ""
    if-nez v13, +004h
    move-object v2, v14
    goto +2h
    move-object v2, v13
    invoke-virtual v11, Lcom/bytedance/trae/network/FrontierConfig;->getAppId()I
    move-result v3
    sget-object v11, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v11, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +004h
    move-object v4, v14
    goto +2h
    move-object v4, v11
    const-string v6, "Trae"
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v11
    invoke-interface v11, v12, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    sget-object v12, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v12
    move-object v13, v12
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    if-lez v13, +004h
    const/4 v13, 1
    goto +2h
    const/4 v13, 0
    if-eqz v13, +008h
    const-string/jumbo v13, x-ide-token
    invoke-interface v11, v13, v12, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v11, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v5
    iget-object v0, v10, Lcom/bytedance/trae/network/HubNetConnection;->sseConnection Lcom/bytedance/trae/network/SseConnection;
    if-eqz v0, +020h
    const/4 v7, 0
    const/16 v8, 64
    const/4 v9, 0
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/network/SseConnection;->setup$default(Lcom/bytedance/trae/network/SseConnection; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/String; Lcom/bytedance/trae/network/SseConfig; I Ljava/lang/Object;)V
    goto +17h
    iget-object v13, v10, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-nez v13, +00dh
    new-instance v13, Lcom/bytedance/trae/network/FrontierConnection;
    iget v0, v10, Lcom/bytedance/trae/network/HubNetConnection;->channelId I
    const/4 v1, 2
    const/4 v2, 0
    invoke-direct v13, v0, v2, v1, v2, Lcom/bytedance/trae/network/FrontierConnection;-><init>(I Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v13, v10, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    iget-object v13, v10, Lcom/bytedance/trae/network/HubNetConnection;->frontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v13, +005h
    invoke-virtual v13, v11, v12, v14, Lcom/bytedance/trae/network/FrontierConnection;->setup(Lcom/bytedance/trae/network/FrontierConfig; Ljava/util/Map; Lcom/bytedance/trae/network/HubClientMetadata;)V
    return-void 
.end method

.method public final unregisterMessageListener(com.bytedance.trae.network.HubNetMessageListener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    monitor-enter v0
    iget-object v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v1, v3, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    monitor-exit v0
    return-void 
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x8
.end method
