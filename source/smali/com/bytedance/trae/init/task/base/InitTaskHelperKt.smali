# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;
.super Ljava/lang/Object;
.source "InitTaskHelper.kt"

.field private static final CORE_POOL_SIZE:I
.field private static final EVENT_APP_RECREATE:Ljava/lang/String;
.field private static final EVENT_INIT_TASK_CUSTOM_MONITOR:Ljava/lang/String;
.field private static final EVENT_INIT_TASK_SUSPICIOUS_MONITOR:Ljava/lang/String;
.field private static final KEEP_ALIVE_SECONDS:J
.field private static final KEY_ACTIVITY_NAME:Ljava/lang/String;
.field private static final KEY_FIRST_STYLE:Ljava/lang/String;
.field private static final KEY_PROCESS_NAME:Ljava/lang/String;
.field private static final KEY_RECREATE_RESULT:Ljava/lang/String;
.field private static final KEY_RECREATE_TYPE:Ljava/lang/String;
.field private static final KEY_TASK_COMPLETED:Ljava/lang/String;
.field private static final KEY_TASK_DURATION:Ljava/lang/String;
.field private static final KEY_TASK_NAME:Ljava/lang/String;
.field private static final KEY_TASK_RESULT:Ljava/lang/String;
.field private static final KEY_TASK_RUN_IN_MAIN:Ljava/lang/String;
.field private static final KEY_TASK_SCENE:Ljava/lang/String;
.field private static final KEY_TASK_STAGE:Ljava/lang/String;
.field private static final KEY_TASK_STARTED:Ljava/lang/String;
.field private static final KEY_THREAD_NAME:Ljava/lang/String;
.field private static final MAX_POOL_SIZE:I
.field private static final TAG:Ljava/lang/String;
.field private static final TYPE_ACTIVITY:Ljava/lang/String;
.field private static final TYPE_PROCESS:Ljava/lang/String;
.field private static final threadPoolExecutor$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$3l0fl6-mbPPaCRzpSuUBLNAKrIg(java.lang.String  java.lang.String  java.lang.String  boolean  boolean  com.bytedance.trae.init.task.base.TaskDurationCollector$AppInitStage  java.lang.String  java.lang.String  long)void
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorInitTask$lambda$6(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
.end method

.method public static synthetic $r8$lambda$60iwALz-OYW_ZRXIizite10RxdA()java.util.concurrent.ThreadPoolExecutor
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->threadPoolExecutor_delegate$lambda$1()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$S6RGaMgiRGU1a9zPIcKrj5FkQVc(java.lang.Runnable)java.lang.Thread
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->threadPoolExecutor_delegate$lambda$1$lambda$0(Ljava/lang/Runnable;)Ljava/lang/Thread;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gY-hNShGem6tU3PuzWmywYSBOdw(long)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->checkSuspiciousTask$lambda$3$lambda$2(J)V
    return-void 
.end method

.method public static synthetic $r8$lambda$tegCuEVuvOkXS-DdOIl-qRq_O3g(long)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->checkSuspiciousTask$lambda$3(J)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->threadPoolExecutor$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final checkSuspiciousTask(long)void
    .registers 4
    # ins_size=2
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v1, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda4;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda4;-><init>(J)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final checkSuspiciousTask$lambda$3(long)void
    .registers 4
    # ins_size=2
    invoke-static Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->getThreadPoolExecutor()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda3;-><init>(J)V
    invoke-virtual v0, v1, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final checkSuspiciousTask$lambda$3$lambda$2(long)void
    .registers 14
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->getInitTaskIndexs()Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, Ljava/util/Map;->isEmpty()Z
    move-result v1
    const-string v2, "flow_init"
    if-eqz v1, +00ah
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v13, "checkSuspiciousTask, getInitTaskIndexs is empty"
    invoke-virtual v12, v2, v13, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-static Lcom/bytedance/apm/ApmContext;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v0
    invoke-interface v0, Ljava/util/Collection;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +07ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/lego/init/model/InitTaskInfo;
    if-eqz v3, -00ch
    invoke-static v3, Lcom/bytedance/lego/init/util/InitTaskExtendKt;->isInternalTask(Lcom/bytedance/lego/init/model/InitTaskInfo;)Z
    move-result v4
    if-eqz v4, +003h
    goto -14h
    iget-wide v4, v3, Lcom/bytedance/lego/init/model/InitTaskInfo;->startTime J
    cmp-long v4, v4, v12
    if-lez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    iget-boolean v5, v3, Lcom/bytedance/lego/init/model/InitTaskInfo;->isCompleted Z
    if-eqz v4, +004h
    if-nez v5, -022h
    iget-object v3, v3, Lcom/bytedance/lego/init/model/InitTaskInfo;->taskClassName Ljava/lang/String;
    if-eqz v3, +010h
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    const/16 v7, 46
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 6
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v6
    goto +2h
    const/4 v6, -1
    if-ltz v6, +011h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    add-int/lit8 v6, v6, 1
    invoke-virtual v3, v6, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v6, substring(...)
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "Suspicious task -> ["
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "], started:"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", completed:"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", process:"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, v1, v4, v5, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorSuspiciousTask(Ljava/lang/String; Ljava/lang/String; Z Z)V
    goto -7dh
    return-void 
.end method

.method private static final getCurrentAppLaunchStage()com.bytedance.trae.init.task.base.TaskDurationCollector$AppInitStage
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFrame()Z
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->FIRST_FRAME Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    goto +29h
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFrame()Z
    move-result v0
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFeedShow()Z
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->FIRST_FEED Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    goto +16h
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFrame()Z
    move-result v0
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFeedShow()Z
    move-result v0
    if-eqz v0, +005h
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->OTHER Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->DEFAULT Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    return-object v0
.end method

.method private static final getThreadPoolExecutor()java.util.concurrent.ThreadPoolExecutor
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->threadPoolExecutor$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/concurrent/ThreadPoolExecutor;
    return-object v0
.end method

.method public static final monitorActivityRecreate(boolean  java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v0, v1, v2, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorAppRecreate(Ljava/lang/String; Z Ljava/lang/String;)V
    return-void 
.end method

.method private static final monitorAppRecreate(java.lang.String  boolean  java.lang.String)void
    .registers 5
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, type
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, result
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-static Lcom/bytedance/apm/ApmContext;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "process_name"
    invoke-virtual v0, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "activity_name"
    invoke-static v4, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "app_recreate_monitor"
    const/4 v3, 0
    invoke-static v2, v0, v3, v3, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private static final monitorInitTask(java.lang.String  java.lang.String  boolean  com.bytedance.trae.init.task.base.TaskDurationCollector$AppInitStage  java.lang.String  java.lang.String  java.lang.String  long  boolean)void
    .registers 23
    # ins_size=10
    invoke-static Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->getThreadPoolExecutor()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v0
    new-instance v12, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;
    move-object v1, v12
    move-object/from16 v2, v17
    move-object/from16 v3, v18
    move-object/from16 v4, v19
    move/from16 v5, v22
    move v6, v15
    move-object/from16 v7, v16
    move-object v8, v13
    move-object v9, v14
    move-wide/from16 v10, v20
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage; Ljava/lang/String; Ljava/lang/String; J)V
    invoke-virtual v0, v12, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final monitorInitTask$lambda$6(java.lang.String  java.lang.String  java.lang.String  boolean  boolean  com.bytedance.trae.init.task.base.TaskDurationCollector$AppInitStage  java.lang.String  java.lang.String  long)void
    .registers 12
    # ins_size=10
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_name
    invoke-static v2, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "process_name"
    invoke-static v3, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, thread_name
    invoke-static v4, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, task_result
    invoke-virtual v0, v2, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v2, task_run_in_main
    invoke-virtual v0, v2, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    const-string/jumbo v2, task_stage
    invoke-virtual v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->getStage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, task_scene
    invoke-virtual v0, v2, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, task_first_style
    invoke-virtual v0, v2, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v3, task_duration
    invoke-virtual v2, v3, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v3, 0
    const-string v4, "init_task_custom_monitor"
    invoke-static v4, v0, v2, v3, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static final monitorProcessRecreate(boolean  java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "process"
    invoke-static v0, v1, v2, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorAppRecreate(Ljava/lang/String; Z Ljava/lang/String;)V
    return-void 
.end method

.method private static final monitorSuspiciousTask(java.lang.String  java.lang.String  boolean  boolean)void
    .registers 6
    # ins_size=4
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_name
    invoke-static v2, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "process_name"
    invoke-static v3, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, task_started
    invoke-virtual v0, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v2, task_completed
    invoke-virtual v0, v2, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v2, "init_task_suspicious_monitor"
    const/4 v3, 0
    invoke-static v2, v0, v3, v3, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static final runWithMonitor(java.lang.String  java.lang.String  java.lang.Runnable  kotlin.jvm.functions.Function0)void
    .registers 27
    # ins_size=4
    const-string v1, "ms, thread:"
    const-string v2, ", process:"
    const-string v3, "flow_init"
    const-string v4, "["
    const-string/jumbo v0, scene
    move-object/from16 v15, v23
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, style
    move-object/from16 v14, v24
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, task
    move-object/from16 v5, v25
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "call"
    move-object/from16 v6, v26
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v25, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v12
    invoke-static Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Thread;->getName()Ljava/lang/String;
    move-result-object v13
    invoke-static Lcom/bytedance/apm/ApmContext;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v10
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v16
    invoke-static Lcom/bytedance/apm/util/ThreadUtils;->isMainThread()Z
    move-result v18
    invoke-static Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->getCurrentAppLaunchStage()Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    move-result-object v19
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, "] start, thread:"
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v3, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface/range v26, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long v8, v5, v16
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "] end success, duration:"
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v3, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    move-object/from16 v6, v23
    move/from16 v7, v18
    move-wide/from16 v20, v8
    move-object/from16 v8, v19
    move-object v9, v12
    move-object/from16 v25, v10
    move-wide/from16 v10, v20
    invoke-virtual/range v5 ... v11, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->addTaskDuration(Ljava/lang/String; Z Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage; Ljava/lang/String; J)V
    const/4 v0, 1
    move-object/from16 v5, v23
    move-object/from16 v6, v24
    move/from16 v7, v18
    move-object/from16 v8, v19
    move-object v9, v12
    move-object/from16 v10, v25
    move-object v11, v13
    move-object/from16 v22, v3
    move-object v15, v12
    move-object v3, v13
    move-wide/from16 v12, v20
    move v14, v0
    invoke-static/range v5 ... v14, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorInitTask(Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Z)V
    return-void 
    move-exception v0
    goto +ch
    move-exception v0
    move-object/from16 v22, v3
    goto +6h
    move-exception v0
    move-object/from16 v22, v3
    move-object/from16 v25, v10
    move-object v15, v12
    move-object v3, v13
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long v12, v5, v16
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, "] end failure, duration:"
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object/from16 v2, v25
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", err:"
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v4, v22
    invoke-virtual v5, v4, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    move-object/from16 v6, v23
    move/from16 v7, v18
    move-object/from16 v8, v19
    move-object v9, v15
    move-wide v10, v12
    invoke-virtual/range v5 ... v11, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->addTaskDuration(Ljava/lang/String; Z Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage; Ljava/lang/String; J)V
    const/4 v14, 0
    move-object/from16 v5, v23
    move-object/from16 v6, v24
    move-object v10, v2
    move-object v11, v3
    invoke-static/range v5 ... v14, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorInitTask(Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Z)V
    throw v0
    :try_start_0x47
    :try_start_0xaf
    :try_start_0xc6
.end method

.method private static final threadPoolExecutor_delegate$lambda$1()java.util.concurrent.ThreadPoolExecutor
    .registers 9
    # ins_size=0
    new-instance v8, Ljava/util/concurrent/ThreadPoolExecutor;
    const/4 v1, 1
    const/4 v2, 1
    const-wide/16 v3, 10
    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS Ljava/util/concurrent/TimeUnit;
    new-instance v0, Ljava/util/concurrent/LinkedBlockingQueue;
    invoke-direct v0, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V
    move-object v6, v0
    check-cast v6, Ljava/util/concurrent/BlockingQueue;
    new-instance v7, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda1;
    invoke-direct v7, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda1;-><init>()V
    move-object v0, v8
    invoke-direct/range v0 ... v7, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(I I J Ljava/util/concurrent/TimeUnit; Ljava/util/concurrent/BlockingQueue; Ljava/util/concurrent/ThreadFactory;)V
    return-object v8
.end method

.method private static final threadPoolExecutor_delegate$lambda$1$lambda$0(java.lang.Runnable)java.lang.Thread
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/Thread;
    const-string v1, "A-FlowInitLog"
    invoke-direct v0, v2, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable; Ljava/lang/String;)V
    return-object v0
.end method
