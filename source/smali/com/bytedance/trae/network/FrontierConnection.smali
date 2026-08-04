# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/FrontierConnection;
.super Ljava/lang/Object;
.source "FrontierConnection.kt"

.implements Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;

.field private static final ALIVE_TIMEOUT_MS:J
.field public static final Companion:Lcom/bytedance/trae/network/FrontierConnection$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final bytesListeners:Ljava/util/concurrent/ConcurrentHashMap;
.field private final channelId:I
.field private clientMetadata:Lcom/bytedance/trae/network/HubClientMetadata;
.field private connectScope:Lkotlinx/coroutines/CoroutineScope;
.field private currentState:Lcom/bytedance/trae/network/NetworkConnectState;
.field private final customFrontierId:Ljava/lang/Long;
.field private extraHeaders:Ljava/util/Map;
.field private final frontierId$delegate:Lkotlin/Lazy;
.field private isConnecting:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private lastConnectTime:J
.field private bridge lastDataReceivedTime:J
.field private pendingCloseDeferred:Lkotlinx/coroutines/CompletableDeferred;
.field private pendingConsumeCloseEvent:Z
.field private bridge pushListener:Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;
.field private final stateListeners:Ljava/util/Set;
.field private wsChannel:Lcom/bytedance/common/wschannel/WsChannel;
.field private wsConfig:Lcom/bytedance/trae/network/FrontierConfig;


.method public static synthetic $r8$lambda$HeSXrJ-5MZMDUJB2XdevA9nmhJA(com.bytedance.common.wschannel.ChannelInfo$Builder  com.bytedance.trae.network.FrontierConnection)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/FrontierConnection;->connect$lambda$10$lambda$9(Lcom/bytedance/common/wschannel/ChannelInfo$Builder; Lcom/bytedance/trae/network/FrontierConnection;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Vi1vKv5rwaAj9z-rLCeFiCKhn0A(com.bytedance.trae.network.FrontierConnection)long
    .registers 3
    # ins_size=1
    invoke-static v2, Lcom/bytedance/trae/network/FrontierConnection;->frontierId_delegate$lambda$2(Lcom/bytedance/trae/network/FrontierConnection;)J
    move-result-wide v0
    return-wide v0
.end method

.method public static synthetic $r8$lambda$dkIKqWGDKbx_I4YtbGvNjErePmE(kotlin.jvm.functions.Function1  com.bytedance.common.wschannel.model.WsChannelMsg  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/network/FrontierConnection;->sendBytes$lambda$6(Lkotlin/jvm/functions/Function1; Lcom/bytedance/common/wschannel/model/WsChannelMsg; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/FrontierConnection$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/FrontierConnection$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/FrontierConnection;->Companion Lcom/bytedance/trae/network/FrontierConnection$Companion;
    return-void 
.end method

.method public constructor <init>(int  java.lang.Long)void
    .registers 4
    # ins_size=3
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->channelId I
    iput-object v3, v1, Lcom/bytedance/trae/network/FrontierConnection;->customFrontierId Ljava/lang/Long;
    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v2, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->bytesListeners Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v2, Ljava/util/LinkedHashSet;
    invoke-direct v2, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v2, Ljava/util/Set;
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->stateListeners Ljava/util/Set;
    sget-object v2, Lcom/bytedance/trae/ApiHost;->FRONTIER_CONFIG Lcom/bytedance/trae/network/FrontierConfig;
    const-string v3, "FRONTIER_CONFIG"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->wsConfig Lcom/bytedance/trae/network/FrontierConfig;
    sget-object v2, Lcom/bytedance/trae/network/HubClientMetadata;->Companion Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->fromSystem()Lcom/bytedance/trae/network/HubClientMetadata;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->clientMetadata Lcom/bytedance/trae/network/HubClientMetadata;
    sget-object v2, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->currentState Lcom/bytedance/trae/network/NetworkConnectState;
    new-instance v2, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v3, 0
    invoke-direct v2, v3, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->isConnecting Ljava/util/concurrent/atomic/AtomicBoolean;
    const-wide/16 v2, -1
    iput-wide v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->lastConnectTime J
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    sget-object v3, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v0, Lcom/bytedance/trae/network/FrontierConnection$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/network/FrontierConnection$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v0, Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-virtual v2, v0, Lkotlinx/coroutines/CoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->connectScope Lkotlinx/coroutines/CoroutineScope;
    new-instance v2, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda2;
    invoke-direct v2, v1, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/network/FrontierConnection;)V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->frontierId$delegate Lkotlin/Lazy;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->extraHeaders Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/FrontierConnection;-><init>(I Ljava/lang/Long;)V
    return-void 
.end method

.method public static final synthetic access$getPendingCloseDeferred$p(com.bytedance.trae.network.FrontierConnection)kotlinx.coroutines.CompletableDeferred
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/network/FrontierConnection;->pendingCloseDeferred Lkotlinx/coroutines/CompletableDeferred;
    return-object v0
.end method

.method public static final synthetic access$setPendingCloseDeferred$p(com.bytedance.trae.network.FrontierConnection  kotlinx.coroutines.CompletableDeferred)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/network/FrontierConnection;->pendingCloseDeferred Lkotlinx/coroutines/CompletableDeferred;
    return-void 
.end method

.method private static final connect$lambda$10$lambda$9(com.bytedance.common.wschannel.ChannelInfo$Builder  com.bytedance.trae.network.FrontierConnection)kotlin.Unit
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-virtual v2, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->builder()Lcom/bytedance/common/wschannel/ChannelInfo;
    move-result-object v2
    move-object v1, v3
    check-cast v1, Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;
    invoke-static v0, v2, v1, Lcom/bytedance/common/wschannel/WsChannelSdk2;->registerChannel(Landroid/content/Context; Lcom/bytedance/common/wschannel/ChannelInfo; Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;)Lcom/bytedance/common/wschannel/WsChannel;
    move-result-object v2
    const-string/jumbo v0, registerChannel(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v2, Lcom/bytedance/trae/network/FrontierConnection;->updateWsChannel(Lcom/bytedance/common/wschannel/WsChannel;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final frontierId_delegate$lambda$2(com.bytedance.trae.network.FrontierConnection)long
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/network/FrontierConnection;->extraHeaders Ljava/util/Map;
    const-string/jumbo v1, user_id
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +020h
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getFrontierUserId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    const/4 v0, 0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +008h
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getUserID()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/network/FrontierConnection;->customFrontierId Ljava/lang/Long;
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    goto +13h
    sget-object v1, Lcom/bytedance/trae/network/FrontierIdGenerator;->INSTANCE Lcom/bytedance/trae/network/FrontierIdGenerator;
    iget-object v4, v4, Lcom/bytedance/trae/network/FrontierConnection;->wsConfig Lcom/bytedance/trae/network/FrontierConfig;
    invoke-virtual v4, Lcom/bytedance/trae/network/FrontierConfig;->getAppId()I
    move-result v4
    const-string v2, "Android"
    invoke-static Landroid/os/Process;->myPid()I
    move-result v3
    invoke-virtual v1, v0, v4, v2, v3, Lcom/bytedance/trae/network/FrontierIdGenerator;->generateFrontierId(Ljava/lang/String; I Ljava/lang/String; I)J
    move-result-wide v0
    return-wide v0
.end method

.method public static synthetic sendBytes$default(com.bytedance.trae.network.FrontierConnection  int  byte[]  java.util.Map  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/FrontierConnection;->sendBytes(I [B Ljava/util/Map; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final sendBytes$lambda$6(kotlin.jvm.functions.Function1  com.bytedance.common.wschannel.model.WsChannelMsg  boolean)void
    .registers 3
    # ins_size=3
    if-eqz v0, +009h
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public static synthetic setup$default(com.bytedance.trae.network.FrontierConnection  com.bytedance.trae.network.FrontierConfig  java.util.Map  com.bytedance.trae.network.HubClientMetadata  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    and-int/lit8 v4, v4, 4
    if-eqz v4, +008h
    sget-object v3, Lcom/bytedance/trae/network/HubClientMetadata;->Companion Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->fromSystem()Lcom/bytedance/trae/network/HubClientMetadata;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/network/FrontierConnection;->setup(Lcom/bytedance/trae/network/FrontierConfig; Ljava/util/Map; Lcom/bytedance/trae/network/HubClientMetadata;)V
    return-void 
.end method

.method private final tryWaitLastChannelClose(kotlin.jvm.functions.Function0)void
    .registers 10
    # ins_size=2
    const/4 v0, 0
    invoke-direct v8, v0, Lcom/bytedance/trae/network/FrontierConnection;->updateWsChannel(Lcom/bytedance/common/wschannel/WsChannel;)Z
    move-result v1
    if-eqz v1, +014h
    iget-object v2, v8, Lcom/bytedance/trae/network/FrontierConnection;->connectScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;
    invoke-direct v1, v8, v9, v0, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;-><init>(Lcom/bytedance/trae/network/FrontierConnection; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +4h
    invoke-interface v9, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final updateWsChannel(com.bytedance.common.wschannel.WsChannel)boolean
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/network/FrontierConnection;->wsChannel Lcom/bytedance/common/wschannel/WsChannel;
    const/4 v1, 0
    if-eqz v0, +02fh
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    const/4 v2, 1
    iput-boolean v2, v4, Lcom/bytedance/trae/network/FrontierConnection;->pendingConsumeCloseEvent Z
    const/4 v3, 0
    invoke-static v3, v2, v3, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v3
    iput-object v3, v4, Lcom/bytedance/trae/network/FrontierConnection;->pendingCloseDeferred Lkotlinx/coroutines/CompletableDeferred;
    sget-object v3, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-direct v4, v3, Lcom/bytedance/trae/network/FrontierConnection;->updateWsState(Lcom/bytedance/trae/network/NetworkConnectState;)V
    invoke-interface v0, Lcom/bytedance/common/wschannel/WsChannel;->unregister()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move v1, v2
    goto +fh
    move-exception v0
    move v1, v2
    goto +2h
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->box-impl(Ljava/lang/Object;)Lkotlin/Result;
    if-eqz v5, +02bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, updateWsChannel: #
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v5, Lcom/bytedance/common/wschannel/WsChannel;->getChannelId()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", isConnected: "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-interface v5, Lcom/bytedance/common/wschannel/WsChannel;->isConnected()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "IM/FrontierConnection"
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v5, v4, Lcom/bytedance/trae/network/FrontierConnection;->wsChannel Lcom/bytedance/common/wschannel/WsChannel;
    return v1
    :try_start_0x5
    :try_start_0x19
.end method

.method private final updateWsState(com.bytedance.trae.network.NetworkConnectState)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/network/FrontierConnection;->currentState Lcom/bytedance/trae/network/NetworkConnectState;
    if-eq v0, v3, +026h
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    if-ne v3, v0, +008h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iput-wide v0, v2, Lcom/bytedance/trae/network/FrontierConnection;->lastDataReceivedTime J
    iget-object v0, v2, Lcom/bytedance/trae/network/FrontierConnection;->stateListeners Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-interface v1, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto -fh
    iput-object v3, v2, Lcom/bytedance/trae/network/FrontierConnection;->currentState Lcom/bytedance/trae/network/NetworkConnectState;
    return-void 
.end method

.method public final synchronized connect(java.lang.String)void
    .registers 9
    # ins_size=2
    monitor-enter v7
    const-string/jumbo v0, reason
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    iget-wide v2, v7, Lcom/bytedance/trae/network/FrontierConnection;->lastConnectTime J
    sub-long v2, v0, v2
    const-wide/16 v4, 1000
    cmp-long v8, v2, v4
    const/4 v2, 0
    if-lez v8, +00fh
    iget-object v8, v7, Lcom/bytedance/trae/network/FrontierConnection;->isConnecting Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v8, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z
    move-result v8
    if-eqz v8, +007h
    iget-object v8, v7, Lcom/bytedance/trae/network/FrontierConnection;->isConnecting Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v8, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    iget-object v8, v7, Lcom/bytedance/trae/network/FrontierConnection;->isConnecting Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v3, 1
    invoke-virtual v8, v2, v3, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v8
    if-nez v8, +004h
    monitor-exit v7
    return-void 
    iput-wide v0, v7, Lcom/bytedance/trae/network/FrontierConnection;->lastConnectTime J
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/network/FrontierConnection;
    new-instance v8, Ljava/util/LinkedHashMap;
    invoke-direct v8, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v8, Ljava/util/Map;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, v8, Lcom/bytedance/trae/platform/service/ApplogService;->putCommonParams(Ljava/util/Map;)V
    const-string v0, "aid"
    invoke-interface v8, v0, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "device_id"
    invoke-interface v8, v0, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v0, process_id
    invoke-static Landroid/os/Process;->myPid()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    invoke-interface v8, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "app_runtime_type"
    const-string v1, "Android"
    invoke-interface v8, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    const-string/jumbo v1, ttnet_heartbeat_interval
    const-string v4, "15"
    invoke-interface v0, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, ttnet_timeout_millis
    const-string v4, "15000"
    invoke-interface v0, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v7, Lcom/bytedance/trae/network/FrontierConnection;->wsConfig Lcom/bytedance/trae/network/FrontierConfig;
    invoke-virtual v1, Lcom/bytedance/trae/network/FrontierConfig;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    const-string/jumbo v4, qos_level
    const-string v5, "2"
    invoke-interface v0, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v0, v8, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    invoke-virtual v7, Lcom/bytedance/trae/network/FrontierConnection;->getFrontierId()J
    move-result-wide v4
    iget-object v8, v7, Lcom/bytedance/trae/network/FrontierConnection;->clientMetadata Lcom/bytedance/trae/network/HubClientMetadata;
    invoke-static v4, v5, v8, Lcom/bytedance/trae/network/HubClientMetadataKt;->buildFrontierIdentityExtras(J Lcom/bytedance/trae/network/HubClientMetadata;)Ljava/util/Map;
    move-result-object v8
    iget v4, v7, Lcom/bytedance/trae/network/FrontierConnection;->channelId I
    invoke-static v4, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->create(I)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v4
    iget-object v5, v7, Lcom/bytedance/trae/network/FrontierConnection;->wsConfig Lcom/bytedance/trae/network/FrontierConfig;
    invoke-virtual v5, Lcom/bytedance/trae/network/FrontierConfig;->getProductId()I
    move-result v5
    invoke-virtual v4, v5, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->setFPID(I)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v4
    iget-object v5, v7, Lcom/bytedance/trae/network/FrontierConnection;->wsConfig Lcom/bytedance/trae/network/FrontierConfig;
    invoke-virtual v5, Lcom/bytedance/trae/network/FrontierConfig;->getAppId()I
    move-result v5
    invoke-virtual v4, v5, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->setAid(I)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v5, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->setDeviceId(Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v5, Lcom/bytedance/trae/platform/service/ApplogService;->getInstallId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->setInstallId(Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v4
    iget-object v5, v7, Lcom/bytedance/trae/network/FrontierConnection;->wsConfig Lcom/bytedance/trae/network/FrontierConfig;
    invoke-virtual v5, Lcom/bytedance/trae/network/FrontierConfig;->getAppKey()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->setAppKey(Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v4
    const-string v5, "frontier_id"
    const-string v6, "frontier_id"
    invoke-static v8, v6, Lkotlin/collections/MapsKt;->getValue(Ljava/util/Map; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-virtual v4, v5, v6, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->extra(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v4
    const-string v5, "name"
    const-string v6, "name"
    invoke-static v8, v6, Lkotlin/collections/MapsKt;->getValue(Ljava/util/Map; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    invoke-virtual v4, v5, v8, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->extra(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v8
    invoke-virtual v8, v0, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->extras(Ljava/util/Map;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v8
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v0
    invoke-virtual v8, v0, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->setAppVersion(I)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v8
    invoke-virtual v8, v1, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->urls(Ljava/util/List;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    move-result-object v8
    iget-object v0, v7, Lcom/bytedance/trae/network/FrontierConnection;->customFrontierId Ljava/lang/Long;
    if-eqz v0, +00ah
    const-string/jumbo v0, notify
    const-string v1, "1"
    invoke-virtual v8, v0, v1, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->extra(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    iget-object v0, v7, Lcom/bytedance/trae/network/FrontierConnection;->extraHeaders Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v8, v4, v1, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->header(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    goto -1bh
    const-string/jumbo v0, sdk-version
    const-string v1, "2"
    invoke-virtual v8, v0, v1, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->header(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    move v0, v3
    goto +2h
    move v0, v2
    if-eqz v0, +00eh
    const-string/jumbo v0, x-ide-token
    sget-object v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, v0, v1, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->header(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getCommonAppendHeaders()Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v8, v4, v1, Lcom/bytedance/common/wschannel/ChannelInfo$Builder;->header(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    goto -1bh
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-static v0, v3, Lcom/bytedance/common/wschannel/WsChannelSdk;->setEnableReportAppState(Landroid/content/Context; Z)V
    new-instance v0, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda0;
    invoke-direct v0, v8, v7, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/common/wschannel/ChannelInfo$Builder; Lcom/bytedance/trae/network/FrontierConnection;)V
    invoke-direct v7, v0, Lcom/bytedance/trae/network/FrontierConnection;->tryWaitLastChannelClose(Lkotlin/jvm/functions/Function0;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v8
    if-eqz v8, +021h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "IM/FrontierConnection"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    const-string v4, "connect error: "
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v1, v8, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v8, v7, Lcom/bytedance/trae/network/FrontierConnection;->isConnecting Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v8, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    monitor-exit v7
    return-void 
    move-exception v8
    monitor-exit v7
    throw v8
    :try_start_0x1
    :try_start_0x2e
    :try_start_0x30
    :try_start_0x19a
.end method

.method public final synchronized disconnect(java.lang.String)void
    .registers 3
    # ins_size=2
    monitor-enter v1
    const-string/jumbo v0, reason
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    invoke-direct v1, v2, Lcom/bytedance/trae/network/FrontierConnection;->updateWsChannel(Lcom/bytedance/common/wschannel/WsChannel;)Z
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public final getFrontierId()long
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/network/FrontierConnection;->frontierId$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    return-wide v0
.end method

.method public final isReallyAlive()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/network/FrontierConnection;->currentState Lcom/bytedance/trae/network/NetworkConnectState;
    sget-object v1, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    if-eq v0, v1, +004h
    const/4 v0, 0
    return v0
    const/4 v0, 1
    return v0
.end method

.method public synchronized onReceiveConnectEvent(com.bytedance.common.wschannel.event.ConnectEvent  org.json.JSONObject)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, onReceiveConnectEvent:
    monitor-enter v7
    if-eqz v8, +024h
    if-eqz v9, +022h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "HubNetConnection"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/common/wschannel/event/ConnectEvent;->connectionState Lcom/bytedance/common/wschannel/event/ConnectionState;
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v3, 32
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/network/FrontierConnection;->wsChannel Lcom/bytedance/common/wschannel/WsChannel;
    const/4 v1, 2
    const/4 v2, 1
    const/4 v3, 0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    goto +2ah
    if-eqz v8, +005h
    iget-object v0, v8, Lcom/bytedance/common/wschannel/event/ConnectEvent;->connectionState Lcom/bytedance/common/wschannel/event/ConnectionState;
    goto +2h
    move-object v0, v3
    if-nez v0, +004h
    const/4 v0, -1
    goto +9h
    sget-object v4, Lcom/bytedance/trae/network/FrontierConnection$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/common/wschannel/event/ConnectionState;->ordinal()I
    move-result v0
    aget v0, v4, v0
    if-eq v0, v2, +015h
    if-eq v0, v1, +010h
    const/4 v4, 3
    if-eq v0, v4, +00ah
    const/4 v4, 4
    if-eq v0, v4, +004h
    monitor-exit v7
    return-void 
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    goto +9h
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    goto +6h
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTING Lcom/bytedance/trae/network/NetworkConnectState;
    iget-boolean v4, v7, Lcom/bytedance/trae/network/FrontierConnection;->pendingConsumeCloseEvent Z
    const/4 v5, 0
    if-eqz v4, +019h
    if-eqz v8, +005h
    iget-object v4, v8, Lcom/bytedance/common/wschannel/event/ConnectEvent;->connectionState Lcom/bytedance/common/wschannel/event/ConnectionState;
    goto +2h
    move-object v4, v3
    sget-object v6, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECT_CLOSED Lcom/bytedance/common/wschannel/event/ConnectionState;
    if-ne v4, v6, +00fh
    iput-boolean v5, v7, Lcom/bytedance/trae/network/FrontierConnection;->pendingConsumeCloseEvent Z
    iget-object v4, v7, Lcom/bytedance/trae/network/FrontierConnection;->pendingCloseDeferred Lkotlinx/coroutines/CompletableDeferred;
    if-eqz v4, +007h
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v4, v6, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    move v4, v2
    goto +2h
    move v4, v5
    new-array v1, v1, [Lcom/bytedance/common/wschannel/event/ConnectionState;
    sget-object v6, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECTED Lcom/bytedance/common/wschannel/event/ConnectionState;
    aput-object v6, v1, v5
    sget-object v6, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECT_FAILED Lcom/bytedance/common/wschannel/event/ConnectionState;
    aput-object v6, v1, v2
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    if-eqz v8, +005h
    iget-object v2, v8, Lcom/bytedance/common/wschannel/event/ConnectEvent;->connectionState Lcom/bytedance/common/wschannel/event/ConnectionState;
    goto +2h
    move-object v2, v3
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00ch
    if-nez v4, +00fh
    if-eqz v8, +004h
    iget-object v3, v8, Lcom/bytedance/common/wschannel/event/ConnectEvent;->connectionState Lcom/bytedance/common/wschannel/event/ConnectionState;
    sget-object v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECT_CLOSED Lcom/bytedance/common/wschannel/event/ConnectionState;
    if-ne v3, v1, +007h
    iget-object v1, v7, Lcom/bytedance/trae/network/FrontierConnection;->isConnecting Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v1, v5, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    invoke-direct v7, v0, Lcom/bytedance/trae/network/FrontierConnection;->updateWsState(Lcom/bytedance/trae/network/NetworkConnectState;)V
    iget-object v0, v7, Lcom/bytedance/trae/network/FrontierConnection;->pushListener Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;
    if-eqz v0, +005h
    invoke-interface v0, v8, v9, Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;->onReceiveConnectEvent(Lcom/bytedance/common/wschannel/event/ConnectEvent; Lorg/json/JSONObject;)V
    monitor-exit v7
    return-void 
    move-exception v8
    monitor-exit v7
    throw v8
    :try_start_0x8
    :try_start_0x28
    :try_start_0x50
.end method

.method public onReceiveMsg(com.bytedance.common.wschannel.model.WsChannelMsg)void
    .registers 5
    # ins_size=2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iput-wide v0, v3, Lcom/bytedance/trae/network/FrontierConnection;->lastDataReceivedTime J
    iget-object v0, v3, Lcom/bytedance/trae/network/FrontierConnection;->pushListener Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;
    if-eqz v0, +005h
    invoke-interface v0, v4, Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;->onReceiveMsg(Lcom/bytedance/common/wschannel/model/WsChannelMsg;)V
    if-eqz v4, +03fh
    invoke-virtual v4, Lcom/bytedance/common/wschannel/model/WsChannelMsg;->getPayload()[B
    move-result-object v4
    if-nez v4, +003h
    goto +37h
    iget-object v0, v3, Lcom/bytedance/trae/network/FrontierConnection;->bytesListeners Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    const-string v1, "<get-values>(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +021h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Set;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -019h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlin/jvm/functions/Function1;
    invoke-interface v2, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto -fh
    return-void 
.end method

.method public final registerBytesListener(int  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=3
    const-string v0, "listener"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/network/FrontierConnection;->bytesListeners Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Set;
    if-nez v0, +009h
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    invoke-interface v0, v4, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    iget-object v4, v2, Lcom/bytedance/trae/network/FrontierConnection;->bytesListeners Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v4, Ljava/util/Map;
    invoke-interface v4, v3, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final registerPushListener(com.bytedance.common.wschannel.app.OnMessageReceiveListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/network/FrontierConnection;->pushListener Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;
    return-void 
.end method

.method public final registerStateListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConnection;->stateListeners Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final sendBytes(int  byte[]  java.util.Map  kotlin.jvm.functions.Function1)void
    .registers 8
    # ins_size=5
    const-string v0, "bytes"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/network/FrontierConnection;->wsChannel Lcom/bytedance/common/wschannel/WsChannel;
    if-nez v0, +010h
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v7, +00ah
    const/4 v4, 0
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-interface v7, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    invoke-interface v0, Lcom/bytedance/common/wschannel/WsChannel;->getChannelId()I
    move-result v1
    invoke-static v1, Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;->create(I)Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;
    move-result-object v1
    invoke-virtual v1, v4, Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;->setService(I)Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;
    move-result-object v4
    const/4 v1, 1
    invoke-virtual v4, v1, Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;->setMethod(I)Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;
    move-result-object v4
    invoke-virtual v4, v5, Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;->setPayload([B)Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;
    move-result-object v4
    const-wide/16 v1, 1
    invoke-virtual v4, v1, v2, Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;->setSeqId(J)Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;
    move-result-object v4
    if-eqz v6, +024h
    invoke-interface v6, Ljava/util/Map;->keySet()Ljava/util/Set;
    move-result-object v5
    if-eqz v5, +01eh
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +012h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v6, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v4, v1, v2, Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;->addMsgHeader(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;
    goto -15h
    invoke-virtual v4, Lcom/bytedance/common/wschannel/model/WsChannelMsg$Builder;->build()Lcom/bytedance/common/wschannel/model/WsChannelMsg;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda1;
    invoke-direct v5, v7, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v0, v4, v5, Lcom/bytedance/common/wschannel/WsChannel;->sendMsg(Lcom/bytedance/common/wschannel/model/WsChannelMsg; Lcom/bytedance/common/wschannel/MsgSendListener;)V
    return-void 
.end method

.method public final setup(com.bytedance.trae.network.FrontierConfig  java.util.Map  com.bytedance.trae.network.HubClientMetadata)void
    .registers 12
    # ins_size=4
    const-string v0, "config"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraHeaders"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clientMetadata"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v1, v9
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/network/FrontierConfig;->copy$default(Lcom/bytedance/trae/network/FrontierConfig; I I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/network/FrontierConfig;
    move-result-object v9
    iput-object v9, v8, Lcom/bytedance/trae/network/FrontierConnection;->wsConfig Lcom/bytedance/trae/network/FrontierConfig;
    iput-object v10, v8, Lcom/bytedance/trae/network/FrontierConnection;->extraHeaders Ljava/util/Map;
    iput-object v11, v8, Lcom/bytedance/trae/network/FrontierConnection;->clientMetadata Lcom/bytedance/trae/network/HubClientMetadata;
    return-void 
.end method

.method public final unregisterBytesListener(int  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConnection;->bytesListeners Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Set;
    if-eqz v2, +005h
    invoke-interface v2, v3, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final unregisterPushListener()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/network/FrontierConnection;->pushListener Lcom/bytedance/common/wschannel/app/OnMessageReceiveListener;
    return-void 
.end method

.method public final unregisterStateListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConnection;->stateListeners Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    return-void 
.end method
