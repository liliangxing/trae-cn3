# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;
.super Ljava/lang/Object;
.source "SpringNetwokStrategyManager.kt"

.field private static final FEED_SHOW_TIMEOUT_MS:J
.field public static final INSTANCE:Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;
.field private static final MAX_DURATION_MILLIS:J
.field private static final MIN_DURATION_MILLIS:J
.field private static final TAG:Ljava/lang/String;
.field private static countdownJob:Lkotlinx/coroutines/Job;
.field private static currentStrategy:Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
.field private static durationMillis:J
.field private static final hasStarted:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final hasStopped:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static isEnabled:Z
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;
    invoke-direct v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->INSTANCE Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MINUTES Ljava/util/concurrent/TimeUnit;
    const-wide/16 v1, 5
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/TimeUnit;->toMillis(J)J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->MAX_DURATION_MILLIS J
    const-wide/16 v0, -1
    sput-wide v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->durationMillis J
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v1, v2, v1, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-virtual v0, v1, Lkotlinx/coroutines/MainCoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->hasStarted Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->hasStopped Ljava/util/concurrent/atomic/AtomicBoolean;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getCurrentStrategy$p()com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->currentStrategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    return-object v0
.end method

.method public static final synthetic access$safeResetToDefaultState(com.bytedance.trae.network.util.SpringNetworkStrategyManager)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->safeResetToDefaultState()V
    return-void 
.end method

.method public static final synthetic access$setCurrentStrategy$p(com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->currentStrategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    return-void 
.end method

.method private final cancelCurrentJob(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->countdownJob Lkotlinx/coroutines/Job;
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v3, +009h
    invoke-interface v3, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v3
    if-ne v3, v1, +003h
    move v0, v1
    const/4 v3, 0
    if-eqz v0, +009h
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->countdownJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v3, v1, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v3, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->countdownJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final executeStartTNC(java.lang.String)void
    .registers 3
    # ins_size=2
    invoke-static Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;->getInstance()Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;->startAppStateFromTNC(Ljava/lang/String;)V
    return-void 
    :try_start_0x0
.end method

.method private final safeResetToDefaultState()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->hasStopped Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-static Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;->getInstance()Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;->resetToDefaultState()V
    return-void 
    :try_start_0xb
.end method

.method public final synchronized isStrategyEnabled(boolean  long)void
    .registers 10
    # ins_size=4
    monitor-enter v6
    sput-boolean v7, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->isEnabled Z
    const-wide/16 v2, -1
    sget-wide v4, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->MAX_DURATION_MILLIS J
    move-wide v0, v8
    invoke-static/range v0 ... v5, Lkotlin/ranges/RangesKt;->coerceIn(J J J)J
    move-result-wide v8
    sput-wide v8, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->durationMillis J
    invoke-static v7, Lcom/bytedance/ttnet/TTNetInit;->setStateDelayNewStrategyEnabled(Z)V
    monitor-exit v6
    return-void 
    move-exception v7
    monitor-exit v6
    throw v7
    :try_start_0x1
.end method

.method public final synchronized startAppState(com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy)void
    .registers 11
    # ins_size=2
    const-string v0, "Starting new strategy: "
    monitor-enter v9
    const-string/jumbo v1, strategy
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->isEnabled Z
    if-eqz v1, +056h
    invoke-virtual v10, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->getSceneName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +003h
    goto +41h
    sget-object v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->hasStarted Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v1, v3, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v1
    if-nez v1, +004h
    monitor-exit v9
    return-void 
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->getSceneName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v9, v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->cancelCurrentJob(Ljava/lang/String;)V
    sput-object v10, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->currentStrategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    sget-wide v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->durationMillis J
    invoke-virtual v10, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->getSceneName()Ljava/lang/String;
    move-result-object v2
    invoke-direct v9, v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->executeStartTNC(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;
    const/4 v6, 0
    invoke-direct v2, v0, v1, v10, v6, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$startAppState$1;-><init>(J Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    sput-object v10, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->countdownJob Lkotlinx/coroutines/Job;
    monitor-exit v9
    return-void 
    monitor-exit v9
    return-void 
    move-exception v10
    monitor-exit v9
    throw v10
    :try_start_0x3
    :try_start_0x2b
.end method

.method public final synchronized stopAppState(com.bytedance.trae.network.util.SpringNetworkStrategyManager$SpringNetworkStrategy)void
    .registers 9
    # ins_size=2
    monitor-enter v7
    const-string/jumbo v0, strategy
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->isEnabled Z
    if-nez v0, +004h
    monitor-exit v7
    return-void 
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v8, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const/4 v1, 1
    if-ne v0, v1, +027h
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->currentStrategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    if-ne v0, v8, +021h
    const-string v8, "Stop called manually (Immediate Reset)"
    invoke-direct v7, v8, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->cancelCurrentJob(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->scope Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v8
    move-object v1, v8
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    const/4 v2, 0
    new-instance v8, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$stopAppState$1;
    const/4 v6, 0
    invoke-direct v8, v6, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$stopAppState$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v3, v8
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 2
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sput-object v6, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->currentStrategy Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    monitor-exit v7
    return-void 
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    move-exception v8
    monitor-exit v7
    throw v8
    :try_start_0x1
    :try_start_0xd
    :try_start_0x3d
.end method
