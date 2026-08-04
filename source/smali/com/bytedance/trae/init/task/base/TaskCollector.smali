# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/base/TaskCollector;
.super Ljava/lang/Object;
.source "TaskCollector.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/task/base/TaskCollector;
.field private static final latch:Ljava/util/concurrent/CountDownLatch;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/base/TaskCollector;
    invoke-direct v0, Lcom/bytedance/trae/init/task/base/TaskCollector;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskCollector;
    new-instance v0, Ljava/util/concurrent/CountDownLatch;
    const/4 v1, 1
    invoke-direct v0, v1, Ljava/util/concurrent/CountDownLatch;-><init>(I)V
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->latch Ljava/util/concurrent/CountDownLatch;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getInitTaskIndexs()java.util.Map
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->latch Ljava/util/concurrent/CountDownLatch;
    sget-object v1, Ljava/util/concurrent/TimeUnit;->SECONDS Ljava/util/concurrent/TimeUnit;
    const-wide/16 v2, 10
    invoke-virtual v0, v2, v3, v1, Ljava/util/concurrent/CountDownLatch;->await(J Ljava/util/concurrent/TimeUnit;)Z
    move-result v0
    if-eqz v0, +016h
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static Lcom/bytedance/lego/init/TaskCollectorManager;->getInitTaskIndexs()Ljava/util/Map;
    move-result-object v1
    const-string v2, "getInitTaskIndexs(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v1, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    goto +ah
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    goto +5h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
    :try_start_0x0
.end method

.method public final markTaskInitialized()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->latch Ljava/util/concurrent/CountDownLatch;
    invoke-virtual v0, Ljava/util/concurrent/CountDownLatch;->countDown()V
    return-void 
.end method

.method public final start()void
    .registers 1
    # ins_size=1
    return-void 
.end method
