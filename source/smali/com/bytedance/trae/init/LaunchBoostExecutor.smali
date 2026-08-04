# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/LaunchBoostExecutor;
.super Ljava/lang/Object;
.source "LaunchBoostExecutor.kt"

.field public static final $stable:I
.field private static final CORE_POOL_SIZE:I
.field private static final CPU_COUNT:I
.field private static final EXECUTORS:Ljava/util/concurrent/ThreadPoolExecutor;
.field public static final INSTANCE:Lcom/bytedance/trae/init/LaunchBoostExecutor;
.field private static final KEEP_ALIVE:J
.field private static final MAXIMUM_POOL_SIZE:I
.field private static final threadFactory:Ljava/util/concurrent/ThreadFactory;


.method static constructor <clinit>()void
    .registers 10
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;
    invoke-direct v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->INSTANCE Lcom/bytedance/trae/init/LaunchBoostExecutor;
    new-instance v0, Lcom/bytedance/trae/init/LaunchBoostExecutor$threadFactory$1;
    invoke-direct v0, Lcom/bytedance/trae/init/LaunchBoostExecutor$threadFactory$1;-><init>()V
    move-object v8, v0
    check-cast v8, Ljava/util/concurrent/ThreadFactory;
    sput-object v8, Lcom/bytedance/trae/init/LaunchBoostExecutor;->threadFactory Ljava/util/concurrent/ThreadFactory;
    invoke-static Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Runtime;->availableProcessors()I
    move-result v0
    sput v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->CPU_COUNT I
    add-int/lit8 v2, v0, 1
    sput v2, Lcom/bytedance/trae/init/LaunchBoostExecutor;->CORE_POOL_SIZE I
    mul-int/lit8 v0, v0, 2
    const/4 v9, 1
    add-int/lit8 v3, v0, 1
    sput v3, Lcom/bytedance/trae/init/LaunchBoostExecutor;->MAXIMUM_POOL_SIZE I
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;
    const-wide/16 v4, 5
    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS Ljava/util/concurrent/TimeUnit;
    new-instance v1, Ljava/util/concurrent/LinkedBlockingQueue;
    invoke-direct v1, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V
    move-object v7, v1
    check-cast v7, Ljava/util/concurrent/BlockingQueue;
    move-object v1, v0
    invoke-direct/range v1 ... v8, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(I I J Ljava/util/concurrent/TimeUnit; Ljava/util/concurrent/BlockingQueue; Ljava/util/concurrent/ThreadFactory;)V
    invoke-virtual v0, v9, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V
    sput-object v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->EXECUTORS Ljava/util/concurrent/ThreadPoolExecutor;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final executors$app_mainlandRelease()java.util.concurrent.ThreadPoolExecutor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->EXECUTORS Ljava/util/concurrent/ThreadPoolExecutor;
    return-object v0
.end method
