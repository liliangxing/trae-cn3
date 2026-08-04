# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/SseConnection;
.super Ljava/lang/Object;
.source "SseConnection.kt"

.field public static final Companion:Lcom/bytedance/trae/network/SseConnection$Companion;
.field private static final DEFAULT_SSE_EVENT:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private bridge activeCall:Lcom/bytedance/retrofit2/Call;
.field private baseUrl:Ljava/lang/String;
.field private config:Lcom/bytedance/trae/network/SseConfig;
.field private connectJob:Lkotlinx/coroutines/Job;
.field private final consecutiveFailures:Ljava/util/concurrent/atomic/AtomicInteger;
.field private deviceId:Ljava/lang/String;
.field private final frontierId:Ljava/util/concurrent/atomic/AtomicLong;
.field private final gson:Lcom/google/gson/Gson;
.field private headers:Ljava/util/Map;
.field private heartbeatWatchdogJob:Lkotlinx/coroutines/Job;
.field private bridge lastDataReceivedTime:J
.field private final lastDownSeqId:Ljava/util/concurrent/atomic/AtomicLong;
.field private final messageListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field private bridge state:Lcom/bytedance/trae/network/SseState;
.field private final stateListeners:Ljava/util/concurrent/CopyOnWriteArraySet;


.method public static synthetic $r8$lambda$9XuXdB4gjqWX47DN4fmTFI4B6v4(com.bytedance.trae.network.SseConnection  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/SseConnection;->createSseApi$lambda$4(Lcom/bytedance/trae/network/SseConnection; Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/SseConnection$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/SseConnection$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/SseConnection;->Companion Lcom/bytedance/trae/network/SseConnection$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    invoke-direct/range v17, Ljava/lang/Object;-><init>()V
    const-string v1, ""
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->baseUrl Ljava/lang/String;
    new-instance v2, Ljava/util/concurrent/atomic/AtomicLong;
    const-wide/16 v3, 0
    invoke-direct v2, v3, v4, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V
    iput-object v2, v0, Lcom/bytedance/trae/network/SseConnection;->frontierId Ljava/util/concurrent/atomic/AtomicLong;
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->deviceId Ljava/lang/String;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->headers Ljava/util/Map;
    new-instance v1, Lcom/bytedance/trae/network/SseConfig;
    const-wide/16 v6, 0
    const-wide/16 v8, 0
    const-wide/16 v10, 0
    const-wide/16 v12, 0
    const/4 v14, 0
    const/16 v15, 31
    const/16 v16, 0
    move-object v5, v1
    invoke-direct/range v5 ... v16, Lcom/bytedance/trae/network/SseConfig;-><init>(J J J J I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    sget-object v1, Lcom/bytedance/trae/network/SseState;->DISCONNECTED Lcom/bytedance/trae/network/SseState;
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    new-instance v1, Ljava/util/concurrent/atomic/AtomicLong;
    invoke-direct v1, v3, v4, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->lastDownSeqId Ljava/util/concurrent/atomic/AtomicLong;
    new-instance v1, Ljava/util/concurrent/atomic/AtomicInteger;
    const/4 v2, 0
    invoke-direct v1, v2, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->consecutiveFailures Ljava/util/concurrent/atomic/AtomicInteger;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v1, v2, v1, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v1, v2, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    sget-object v2, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v3, Lcom/bytedance/trae/network/SseConnection$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v3, v2, Lcom/bytedance/trae/network/SseConnection$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v3, Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v1, v3, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/google/gson/Gson;
    invoke-direct v1, Lcom/google/gson/Gson;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->gson Lcom/google/gson/Gson;
    new-instance v1, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v1, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v1, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v1, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/SseConnection;->stateListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    return-void 
.end method

.method public static final synthetic access$cancelActiveCall(com.bytedance.trae.network.SseConnection)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/network/SseConnection;->cancelActiveCall()V
    return-void 
.end method

.method public static final synthetic access$getConfig$p(com.bytedance.trae.network.SseConnection)com.bytedance.trae.network.SseConfig
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    return-object v0
.end method

.method public static final synthetic access$getLastDataReceivedTime$p(com.bytedance.trae.network.SseConnection)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConnection;->lastDataReceivedTime J
    return-wide v0
.end method

.method public static final synthetic access$runSseLoop(com.bytedance.trae.network.SseConnection  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/SseConnection;->runSseLoop(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$startSseStream(com.bytedance.trae.network.SseConnection  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/SseConnection;->startSseStream(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$updateState(com.bytedance.trae.network.SseConnection  com.bytedance.trae.network.SseState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/SseConnection;->updateState(Lcom/bytedance/trae/network/SseState;)V
    return-void 
.end method

.method private final buildSseUrl()java.lang.String
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/network/SseConnection;->baseUrl Ljava/lang/String;
    const/4 v1, 1
    new-array v1, v1, [C
    const/4 v2, 0
    const/16 v3, 47
    aput-char v3, v1, v2
    invoke-static v0, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/network/SseConnection;->lastDownSeqId Ljava/util/concurrent/atomic/AtomicLong;
    invoke-virtual v1, Ljava/util/concurrent/atomic/AtomicLong;->get()J
    move-result-wide v1
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, "/api/solo_hub/v1/wsmessages/sse/poll?frontier_id="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/network/SseConnection;->getFrontierId()J
    move-result-wide v3
    invoke-virtual v0, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, "&device_id="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v3, v5, Lcom/bytedance/trae/network/SseConnection;->deviceId Ljava/lang/String;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, "&from_down_seq_id="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final calculateBackoff(int)long
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    invoke-virtual v0, Lcom/bytedance/trae/network/SseConfig;->getReconnectBaseMs()J
    move-result-wide v0
    const/16 v2, 15
    invoke-static v7, v2, Ljava/lang/Math;->min(I I)I
    move-result v7
    const-wide/16 v2, 1
    shl-long/2addr v2, v7
    mul-long/2addr v0, v2
    iget-object v7, v6, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    invoke-virtual v7, Lcom/bytedance/trae/network/SseConfig;->getReconnectMaxMs()J
    move-result-wide v2
    invoke-static v0, v1, v2, v3, Ljava/lang/Math;->min(J J)J
    move-result-wide v0
    invoke-static Ljava/lang/Math;->random()D
    move-result-wide v2
    iget-object v7, v6, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    invoke-virtual v7, Lcom/bytedance/trae/network/SseConfig;->getReconnectJitterMs()J
    move-result-wide v4
    long-to-double v4, v4
    mul-double/2addr v2, v4
    double-to-long v2, v2
    add-long/2addr v0, v2
    return-wide v0
.end method

.method private final cancelActiveCall()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->cancel()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    return-void 
    :try_start_0x0
.end method

.method private final createSseApi()com.bytedance.trae.network.SseConnection$SseApi
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/network/SseConnection$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/network/SseConnection$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/network/SseConnection;)V
    iget-object v1, v3, Lcom/bytedance/trae/network/SseConnection;->baseUrl Ljava/lang/String;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    const/4 v2, 0
    invoke-static v1, v0, v2, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/network/SseConnection$SseApi;
    invoke-virtual v0, v1, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "create(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/network/SseConnection$SseApi;
    return-object v0
.end method

.method private static final createSseApi$lambda$4(com.bytedance.trae.network.SseConnection  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 7
    # ins_size=2
    invoke-interface v6, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +004h
    const/4 v5, 0
    return-object v5
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getHeaders()Ljava/util/List;
    move-result-object v1
    const-string v2, "getHeaders(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v1
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    const-string v3, "Accept"
    const-string/jumbo v4, text/event-stream
    invoke-direct v2, v3, v4, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    const-string v3, "Cache-Control"
    const-string/jumbo v4, no-cache
    invoke-direct v2, v3, v4, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    const-string/jumbo v3, x-ttnet-req-biz-id
    const-string/jumbo v4, sse_connection
    invoke-direct v2, v3, v4, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v2, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +00dh
    new-instance v3, Lcom/bytedance/retrofit2/client/Header;
    const-string/jumbo v4, x-ide-token
    invoke-direct v3, v4, v2, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v5, v5, Lcom/bytedance/trae/network/SseConnection;->headers Ljava/util/Map;
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01dh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    new-instance v4, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v4, v3, v2, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -20h
    sget-object v5, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v5, Lcom/bytedance/trae/network/DebugSettings;->getCustomHeaders()Ljava/util/Map;
    move-result-object v5
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01dh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    new-instance v4, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v4, v3, v2, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -20h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v5
    invoke-virtual v5, v1, Lcom/bytedance/retrofit2/client/Request$Builder;->headers(Ljava/util/List;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v5
    invoke-interface v6, v5, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v5
    return-object v5
.end method

.method private final dispatchSseEvent(java.lang.String  java.lang.String  java.lang.String)void
    .registers 13
    # ins_size=4
    const-string v0, "dispatchSseEvent: message data="
    move-object v1, v12
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    const-string v4, "message"
    if-eqz v1, +009h
    invoke-static v10, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +004h
    move v5, v2
    goto +2h
    move v5, v3
    if-eqz v5, +004h
    move-object v5, v4
    goto +2h
    move-object v5, v1
    check-cast v5, Ljava/lang/String;
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v6
    const v7, 94756344
    const-string v8, "SseConnection"
    if-eq v6, v7, +09fh
    const v7, 200896764
    if-eq v6, v7, +089h
    const v7, 954925063
    if-eq v6, v7, +004h
    goto/16 +09bh
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +093h
    sget-object v10, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v10, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/network/SseConnection;->gson Lcom/google/gson/Gson;
    const-class v0, Lcom/bytedance/trae/network/WsMessage;
    invoke-virtual v10, v12, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/network/WsMessage;
    if-nez v0, +003h
    return-void 
    invoke-static v11, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v10
    if-nez v10, +006h
    invoke-virtual v0, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v10
    move-object v3, v10
    if-eqz v3, +009h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v10
    invoke-virtual v9, v10, v11, Lcom/bytedance/trae/network/SseConnection;->updateLastSeqId(J)V
    invoke-virtual v0, Lcom/bytedance/trae/network/WsMessage;->getDownSeqId()Ljava/lang/Long;
    move-result-object v10
    if-nez v10, +00eh
    if-eqz v3, +00ch
    const/4 v1, 0
    const/4 v2, 0
    const/4 v4, 0
    const/16 v5, 11
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/network/WsMessage;->copy$default(Lcom/bytedance/trae/network/WsMessage; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/network/WsMessage;
    move-result-object v0
    iget-object v10, v9, Lcom/bytedance/trae/network/SseConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +075h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lkotlin/jvm/functions/Function1;
    invoke-interface v11, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto -fh
    move-exception v10
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v0, "dispatchSseEvent: parse message error: "
    invoke-direct v12, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v12, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v11, v8, v10, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +50h
    const-string v11, "heartbeat"
    invoke-virtual v5, v11, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +11h
    sget-object v10, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v11, "dispatchSseEvent: heartbeat received"
    invoke-virtual v10, v8, v11, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +3fh
    const-string v11, "close"
    invoke-virtual v5, v11, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +021h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-lez v11, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +02eh
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v0, "dispatchSseEvent: unknown event="
    invoke-direct v12, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v11, v8, v10, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +18h
    sget-object v10, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v0, "dispatchSseEvent: close event, data="
    invoke-direct v11, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v8, v11, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v9, Lcom/bytedance/trae/network/SseConnection;->cancelActiveCall()V
    return-void 
    :try_start_0x4d
.end method

.method private final runSseLoop(kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=2
    instance-of v0, v13, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;
    if-eqz v0, +012h
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;
    iget v1, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v13, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->label I
    sub-int/2addr v13, v2
    iput v13, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;
    invoke-direct v0, v12, v13, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;-><init>(Lcom/bytedance/trae/network/SseConnection; Lkotlin/coroutines/Continuation;)V
    iget-object v13, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->label I
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 1
    const-string v6, "SseConnection"
    if-eqz v2, +024h
    if-eq v2, v5, +015h
    if-ne v2, v4, +00bh
    iget-object v2, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/network/SseConnection;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0d1h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    iget-object v2, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/network/SseConnection;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1fh
    move-exception v13
    goto +24h
    move-exception v13
    goto/16 +0c3h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v12
    invoke-interface v0, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v13
    invoke-static v13, Lkotlinx/coroutines/JobKt;->isActive(Lkotlin/coroutines/CoroutineContext;)Z
    move-result v13
    if-eqz v13, +0b6h
    iput-object v2, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->label I
    invoke-direct v2, v0, Lcom/bytedance/trae/network/SseConnection;->startSseStream(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v1, +003h
    return-object v1
    check-cast v13, Ljava/lang/Boolean;
    invoke-virtual v13, Ljava/lang/Boolean;->booleanValue()Z
    move-result v13
    goto +1ah
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "SSE stream error: "
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v8, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v7, v6, v13, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    move v13, v3
    invoke-interface v0, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v7
    invoke-static v7, Lkotlinx/coroutines/JobKt;->isActive(Lkotlin/coroutines/CoroutineContext;)Z
    move-result v7
    if-eqz v7, +081h
    if-eqz v13, +008h
    iget-object v13, v2, Lcom/bytedance/trae/network/SseConnection;->consecutiveFailures Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v13, v3, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V
    goto +ah
    iget-object v13, v2, Lcom/bytedance/trae/network/SseConnection;->consecutiveFailures Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v13, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I
    move-result v13
    invoke-static v13, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    sget-object v13, Lcom/bytedance/trae/network/SseState;->DISCONNECTED Lcom/bytedance/trae/network/SseState;
    invoke-direct v2, v13, Lcom/bytedance/trae/network/SseConnection;->updateState(Lcom/bytedance/trae/network/SseState;)V
    invoke-direct v2, Lcom/bytedance/trae/network/SseConnection;->stopHeartbeatWatchdog()V
    iget-object v13, v2, Lcom/bytedance/trae/network/SseConnection;->consecutiveFailures Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v13, Ljava/util/concurrent/atomic/AtomicInteger;->get()I
    move-result v13
    iget-object v7, v2, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    invoke-virtual v7, Lcom/bytedance/trae/network/SseConfig;->getMaxConsecutiveFailures()I
    move-result v7
    if-lt v13, v7, +01eh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, runSseLoop: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v1, " consecutive failures, giving up"
    invoke-virtual v13, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, v6, v13, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +3dh
    invoke-direct v2, v13, Lcom/bytedance/trae/network/SseConnection;->calculateBackoff(I)J
    move-result-wide v7
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string/jumbo v11, runSseLoop: reconnecting in 
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, "ms (attempt "
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v13
    const/16 v10, 41
    invoke-virtual v13, v10, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v9, v6, v13, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v2, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/network/SseConnection$runSseLoop$1;->label I
    invoke-static v7, v8, v0, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v1, +003h
    return-object v1
    sget-object v13, Lcom/bytedance/trae/network/SseState;->CONNECTING Lcom/bytedance/trae/network/SseState;
    invoke-direct v2, v13, Lcom/bytedance/trae/network/SseConnection;->updateState(Lcom/bytedance/trae/network/SseState;)V
    goto/16 -0bbh
    throw v13
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    :try_start_0x41
    :try_start_0x58
.end method

.method public static synthetic setup$default(com.bytedance.trae.network.SseConnection  java.lang.String  java.lang.String  int  java.lang.String  java.util.Map  java.lang.String  com.bytedance.trae.network.SseConfig  int  java.lang.Object)void
    .registers 30
    # ins_size=10
    and-int/lit8 v0, v28, 32
    if-eqz v0, +006h
    const-string v0, "Android"
    move-object v7, v0
    goto +3h
    move-object/from16 v7, v26
    and-int/lit8 v0, v28, 64
    if-eqz v0, +017h
    new-instance v0, Lcom/bytedance/trae/network/SseConfig;
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const-wide/16 v13, 0
    const-wide/16 v15, 0
    const/16 v17, 0
    const/16 v18, 31
    const/16 v19, 0
    move-object v8, v0
    invoke-direct/range v8 ... v19, Lcom/bytedance/trae/network/SseConfig;-><init>(J J J J I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +3h
    move-object/from16 v8, v27
    move-object/from16 v1, v20
    move-object/from16 v2, v21
    move-object/from16 v3, v22
    move/from16 v4, v23
    move-object/from16 v5, v24
    move-object/from16 v6, v25
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/SseConnection;->setup(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/String; Lcom/bytedance/trae/network/SseConfig;)V
    return-void 
.end method

.method private final startConnection()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/network/SseConnection;->connectJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-direct v9, Lcom/bytedance/trae/network/SseConnection;->cancelActiveCall()V
    iget-object v3, v9, Lcom/bytedance/trae/network/SseConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/network/SseConnection$startConnection$1;
    invoke-direct v0, v9, v1, Lcom/bytedance/trae/network/SseConnection$startConnection$1;-><init>(Lcom/bytedance/trae/network/SseConnection; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/network/SseConnection;->connectJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startHeartbeatWatchdog()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/network/SseConnection;->heartbeatWatchdogJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v3, v9, Lcom/bytedance/trae/network/SseConnection;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;
    invoke-direct v0, v9, v1, Lcom/bytedance/trae/network/SseConnection$startHeartbeatWatchdog$1;-><init>(Lcom/bytedance/trae/network/SseConnection; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/network/SseConnection;->heartbeatWatchdogJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startSseStream(kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    const-string v0, "data:"
    const-string v2, "id:"
    const-string v3, "event:"
    const-string/jumbo v4, startSseStream: http code=
    invoke-direct/range v17, Lcom/bytedance/trae/network/SseConnection;->buildSseUrl()Ljava/lang/String;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v8, startSseStream: 
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v8, "SseConnection"
    invoke-virtual v6, v8, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v17, Lcom/bytedance/trae/network/SseConnection;->createSseApi()Lcom/bytedance/trae/network/SseConnection$SseApi;
    move-result-object v6
    new-instance v7, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v7, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const-wide/16 v9, 30000
    iput-wide v9, v7, Lcom/bytedance/ttnet/http/RequestContext;->timeout_connect J
    const-wide/32 v11, 60000
    iput-wide v11, v7, Lcom/bytedance/ttnet/http/RequestContext;->timeout_read J
    iput-wide v9, v7, Lcom/bytedance/ttnet/http/RequestContext;->timeout_write J
    const-wide/16 v13, 0
    iput-wide v13, v7, Lcom/bytedance/ttnet/http/RequestContext;->protect_timeout J
    iput-wide v9, v7, Lcom/bytedance/ttnet/http/RequestContext;->socket_connect_timeout J
    iput-wide v11, v7, Lcom/bytedance/ttnet/http/RequestContext;->socket_read_timeout J
    iput-wide v9, v7, Lcom/bytedance/ttnet/http/RequestContext;->socket_write_timeout J
    invoke-interface v6, v5, v7, Lcom/bytedance/trae/network/SseConnection$SseApi;->connectSse(Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v5
    iput-object v5, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    const/4 v6, 0
    const/4 v7, 0
    invoke-interface v5, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v9
    const-string v10, "execute(...)"
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/retrofit2/SsResponse;->isSuccessful()Z
    move-result v10
    if-nez v10, +027h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v8, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    iput-object v6, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    return-object v0
    invoke-virtual v9, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v4, +019h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, startSseStream: response body is null
    invoke-virtual v0, v8, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    iput-object v6, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    return-object v0
    sget-object v10, Lcom/bytedance/trae/network/SseState;->CONNECTED Lcom/bytedance/trae/network/SseState;
    invoke-direct v1, v10, Lcom/bytedance/trae/network/SseConnection;->updateState(Lcom/bytedance/trae/network/SseState;)V
    iget-object v10, v1, Lcom/bytedance/trae/network/SseConnection;->consecutiveFailures Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v10, v7, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v10
    iput-wide v10, v1, Lcom/bytedance/trae/network/SseConnection;->lastDataReceivedTime J
    invoke-direct/range v17, Lcom/bytedance/trae/network/SseConnection;->startHeartbeatWatchdog()V
    new-instance v10, Ljava/io/BufferedReader;
    new-instance v11, Ljava/io/InputStreamReader;
    invoke-interface v4, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v4
    sget-object v12, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v11, v4, v12, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v11, Ljava/io/Reader;
    invoke-direct v10, v11, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    const-string v11, ""
    const-string v12, "message"
    move-object v14, v11
    move-object v13, v12
    invoke-interface/range v18, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v15
    invoke-static v15, Lkotlinx/coroutines/JobKt;->isActive(Lkotlin/coroutines/CoroutineContext;)Z
    move-result v15
    if-eqz v15, +0a4h
    invoke-virtual v10, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    move-result-object v15
    if-nez v15, +004h
    goto/16 +09ch
    move-object/from16 v16, v10
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    iput-wide v9, v1, Lcom/bytedance/trae/network/SseConnection;->lastDataReceivedTime J
    move-object v9, v15
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +004h
    const/4 v9, 1
    goto +2h
    move v9, v7
    if-eqz v9, +019h
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v9, toString(...)
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v13, v14, v4, Lcom/bytedance/trae/network/SseConnection;->dispatchSseEvent(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    move-object v14, v11
    move-object v13, v12
    move-object/from16 v10, v16
    goto -3eh
    const/4 v9, 2
    invoke-static v15, v3, v7, v9, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +014h
    move-object v9, v3
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v15, v9, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v13
    goto -1bh
    invoke-static v15, v2, v7, v9, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +014h
    move-object v9, v2
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v15, v9, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v14
    goto -33h
    invoke-static v15, v0, v7, v9, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +02ah
    move-object v9, v4
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-lez v9, +004h
    const/4 v9, 1
    goto +2h
    move v9, v7
    if-eqz v9, +007h
    const-string v9, "
"
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-object v9, v0
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v15, v9, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto -61h
    const-string v10, ":"
    invoke-static v15, v10, v7, v9, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    goto -67h
    move-exception v0
    move-object/from16 v10, v16
    goto +20h
    move-exception v0
    move-object/from16 v10, v16
    goto +5eh
    move-object/from16 v16, v10
    invoke-virtual/range v16, Ljava/io/BufferedReader;->close()V
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    iput-object v6, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    const/4 v9, 1
    goto +46h
    move-exception v0
    move-object/from16 v16, v10
    goto +7h
    move-exception v0
    move-object/from16 v16, v10
    goto +45h
    move-exception v0
    move-object v10, v6
    const/4 v7, 1
    goto +3h
    move-exception v0
    move-object v10, v6
    invoke-interface/range v18, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/JobKt;->isActive(Lkotlin/coroutines/CoroutineContext;)Z
    move-result v2
    if-eqz v2, +01fh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v4, startSseStream error: 
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v10, +005h
    invoke-virtual v10, Ljava/io/BufferedReader;->close()V
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    iput-object v6, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    move v9, v7
    invoke-static v9, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    move-exception v0
    move-object v10, v6
    throw v0
    move-exception v0
    if-eqz v10, +005h
    invoke-virtual v10, Ljava/io/BufferedReader;->close()V
    iget-object v2, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    iput-object v6, v1, Lcom/bytedance/trae/network/SseConnection;->activeCall Lcom/bytedance/retrofit2/Call;
    throw v0
    :try_start_0x4c
    :try_start_0x80
    :try_start_0x9f
    :try_start_0xc4
    :try_start_0xcf
    :try_start_0xe3
    :try_start_0x19a
    :try_start_0x1d8
.end method

.method private final stopHeartbeatWatchdog()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/SseConnection;->heartbeatWatchdogJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/network/SseConnection;->heartbeatWatchdogJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final updateState(com.bytedance.trae.network.SseState)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    if-ne v0, v5, +003h
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    iput-object v5, v4, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, state: 
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, " → "
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v2, "SseConnection"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/network/SseConnection;->stateListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-interface v1, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto -fh
    return-void 
.end method

.method public final connect()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    sget-object v1, Lcom/bytedance/trae/network/SseState;->CONNECTING Lcom/bytedance/trae/network/SseState;
    const-string v2, "SseConnection"
    if-eq v0, v1, +01ah
    iget-object v0, v4, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    sget-object v1, Lcom/bytedance/trae/network/SseState;->CONNECTED Lcom/bytedance/trae/network/SseState;
    if-ne v0, v1, +003h
    goto +12h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "connect: starting SSE connection"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/network/SseConnection;->consecutiveFailures Ljava/util/concurrent/atomic/AtomicInteger;
    const/4 v1, 0
    invoke-virtual v0, v1, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V
    invoke-direct v4, Lcom/bytedance/trae/network/SseConnection;->startConnection()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "connect: already "
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v4, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", skip"
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final disconnect()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "SseConnection"
    const-string v2, "disconnect"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/network/SseConnection;->connectJob Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v3, Lcom/bytedance/trae/network/SseConnection;->connectJob Lkotlinx/coroutines/Job;
    iget-object v0, v3, Lcom/bytedance/trae/network/SseConnection;->heartbeatWatchdogJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v3, Lcom/bytedance/trae/network/SseConnection;->heartbeatWatchdogJob Lkotlinx/coroutines/Job;
    invoke-direct v3, Lcom/bytedance/trae/network/SseConnection;->cancelActiveCall()V
    sget-object v0, Lcom/bytedance/trae/network/SseState;->DISCONNECTED Lcom/bytedance/trae/network/SseState;
    invoke-direct v3, v0, Lcom/bytedance/trae/network/SseConnection;->updateState(Lcom/bytedance/trae/network/SseState;)V
    return-void 
.end method

.method public final getConsecutiveFailures()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->consecutiveFailures Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicInteger;->get()I
    move-result v0
    return v0
.end method

.method public final getFrontierId()long
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/network/SseConnection;->frontierId Ljava/util/concurrent/atomic/AtomicLong;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicLong;->get()J
    move-result-wide v0
    return-wide v0
.end method

.method public final getState()com.bytedance.trae.network.SseState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    return-object v0
.end method

.method public final isReallyAlive()boolean
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/network/SseConnection;->state Lcom/bytedance/trae/network/SseState;
    sget-object v1, Lcom/bytedance/trae/network/SseState;->CONNECTED Lcom/bytedance/trae/network/SseState;
    const/4 v2, 0
    if-eq v0, v1, +003h
    return v2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iget-wide v3, v5, Lcom/bytedance/trae/network/SseConnection;->lastDataReceivedTime J
    sub-long/2addr v0, v3
    iget-object v3, v5, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    invoke-virtual v3, Lcom/bytedance/trae/network/SseConfig;->getHeartbeatTimeoutMs()J
    move-result-wide v3
    cmp-long v0, v0, v3
    if-gez v0, +003h
    const/4 v2, 1
    return v2
.end method

.method public final registerMessageListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final registerStateListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->stateListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final setup(java.lang.String  java.lang.String  int  java.lang.String  java.util.Map  java.lang.String  com.bytedance.trae.network.SseConfig)void
    .registers 10
    # ins_size=8
    const-string v0, "baseUrl"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceId"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "appRuntimeType"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sseConfig
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/network/SseConnection;->baseUrl Ljava/lang/String;
    iget-object v3, v2, Lcom/bytedance/trae/network/SseConnection;->frontierId Ljava/util/concurrent/atomic/AtomicLong;
    sget-object v0, Lcom/bytedance/trae/network/FrontierIdGenerator;->INSTANCE Lcom/bytedance/trae/network/FrontierIdGenerator;
    invoke-static Landroid/os/Process;->myPid()I
    move-result v1
    invoke-virtual v0, v4, v5, v8, v1, Lcom/bytedance/trae/network/FrontierIdGenerator;->generateFrontierId(Ljava/lang/String; I Ljava/lang/String; I)J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V
    iput-object v6, v2, Lcom/bytedance/trae/network/SseConnection;->deviceId Ljava/lang/String;
    iput-object v7, v2, Lcom/bytedance/trae/network/SseConnection;->headers Ljava/util/Map;
    iput-object v9, v2, Lcom/bytedance/trae/network/SseConnection;->config Lcom/bytedance/trae/network/SseConfig;
    return-void 
.end method

.method public final unregisterMessageListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->messageListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final unregisterStateListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/network/SseConnection;->stateListeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final updateFrontierId(long)void
    .registers 8
    # ins_size=3
    invoke-virtual v5, Lcom/bytedance/trae/network/SseConnection;->getFrontierId()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v6, v2
    if-lez v2, +02dh
    cmp-long v2, v0, v6
    if-nez v2, +003h
    goto +27h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, updateFrontierId: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " -> "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "SseConnection"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/network/SseConnection;->frontierId Ljava/util/concurrent/atomic/AtomicLong;
    invoke-virtual v0, v6, v7, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V
    return-void 
.end method

.method public final updateLastSeqId(long)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/network/SseConnection;->lastDownSeqId Ljava/util/concurrent/atomic/AtomicLong;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicLong;->get()J
    move-result-wide v0
    cmp-long v0, v3, v0
    if-lez v0, +007h
    iget-object v0, v2, Lcom/bytedance/trae/network/SseConnection;->lastDownSeqId Ljava/util/concurrent/atomic/AtomicLong;
    invoke-virtual v0, v3, v4, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V
    return-void 
.end method
