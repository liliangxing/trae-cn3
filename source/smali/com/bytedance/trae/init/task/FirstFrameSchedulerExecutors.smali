# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;
.super Ljava/lang/Object;
.source "FirstFrameSchedulerExecutors.kt"

.field public static final $stable:I
.field private static final CORE_POOL_SIZE:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;
.field private static final KEEP_ALIVE_SECONDS:J
.field private static final MAX_POOL_SIZE:I
.field private static final threadPoolExecutor$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$49L-EhPtWVpdkns2LsSp40h_uJQ(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->useLaunchBoostExecutor$lambda$3(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OWKgOCl7khjUsrncFfmNgJVDUhw()java.util.concurrent.ThreadPoolExecutor
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->threadPoolExecutor_delegate$lambda$1()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fSkUnfzUewdR2BXiZC9jPO_q-lA(java.lang.Runnable)java.lang.Thread
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->threadPoolExecutor_delegate$lambda$1$lambda$0(Ljava/lang/Runnable;)Ljava/lang/Thread;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gC5puoLJyUjP4qqL4Hh-P5GgcMI(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->singleAsync$lambda$2(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;
    invoke-direct v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->INSTANCE Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;
    new-instance v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->threadPoolExecutor$delegate Lkotlin/Lazy;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getThreadPoolExecutor()java.util.concurrent.ThreadPoolExecutor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->threadPoolExecutor$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/concurrent/ThreadPoolExecutor;
    return-object v0
.end method

.method private static final singleAsync$lambda$2(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final threadPoolExecutor_delegate$lambda$1()java.util.concurrent.ThreadPoolExecutor
    .registers 9
    # ins_size=0
    new-instance v8, Ljava/util/concurrent/ThreadPoolExecutor;
    const/4 v1, 1
    const/4 v2, 1
    const-wide/16 v3, 30
    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS Ljava/util/concurrent/TimeUnit;
    new-instance v0, Ljava/util/concurrent/LinkedBlockingQueue;
    invoke-direct v0, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V
    move-object v6, v0
    check-cast v6, Ljava/util/concurrent/BlockingQueue;
    new-instance v7, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda2;
    invoke-direct v7, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda2;-><init>()V
    move-object v0, v8
    invoke-direct/range v0 ... v7, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(I I J Ljava/util/concurrent/TimeUnit; Ljava/util/concurrent/BlockingQueue; Ljava/util/concurrent/ThreadFactory;)V
    return-object v8
.end method

.method private static final threadPoolExecutor_delegate$lambda$1$lambda$0(java.lang.Runnable)java.lang.Thread
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/Thread;
    const-string v1, "A-FirstFrameSchedulerExecutors"
    invoke-direct v0, v2, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable; Ljava/lang/String;)V
    return-object v0
.end method

.method private static final useLaunchBoostExecutor$lambda$3(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final singleAsync(kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, runnable
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->getThreadPoolExecutor()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda1;
    invoke-direct v1, v3, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v1, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public final useLaunchBoostExecutor(kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, runnable
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->INSTANCE Lcom/bytedance/trae/init/LaunchBoostExecutor;
    invoke-virtual v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->executors$app_mainlandRelease()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda3;
    invoke-direct v1, v3, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v1, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method
