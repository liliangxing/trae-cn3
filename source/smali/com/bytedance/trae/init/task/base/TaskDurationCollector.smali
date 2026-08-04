# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
.super Ljava/lang/Object;
.source "TaskDurationCollector.kt"

.field public static final $stable:I
.field private static final APP_INIT_DURATION_DIFFERENTIATED_SERVICES_ERROR:Ljava/lang/String;
.field private static final FEED_SHOW_APP_INIT_DURATION_DIFFERENTIATED_SERVICES:Ljava/lang/String;
.field private static final FIRST_FEED_REPORT_DELAY_DURATION:J
.field private static final FIRST_FRAME_APP_INIT_DURATION_DIFFERENTIATED_SERVICES:Ljava/lang/String;
.field private static final FIRST_FRAME_REPORT_DELAY_DURATION:J
.field public static final INSTANCE:Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
.field private static final MAX_DURATION:I
.field private static final OTHER_APP_INIT_DURATION_DIFFERENTIATED_SERVICES:Ljava/lang/String;
.field private static final REPORT_TASK_KEY:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final TOTAL_APP_INIT_DURATION_DIFFERENTIATED_SERVICES:Ljava/lang/String;
.field private static final addedTaskNames:Ljava/util/Set;
.field private static bridge alreadyReported:Z
.field private static final firstFeedDurationsByScene:Ljava/util/Map;
.field private static final firstFramedDurationsByScene:Ljava/util/Map;
.field private static bridge isFirstFeedShow:Z
.field private static bridge isFirstFrame:Z
.field private static final otherDurationsByScene:Ljava/util/Map;
.field private static final totalInitDurationsByScene:Ljava/util/Map;


.method public static synthetic $r8$lambda$-OVzqkK_0DxYRZ-eoGrQmBhjMTU()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->reportAndClearDurations$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    invoke-direct v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFramedDurationsByScene Ljava/util/Map;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFeedDurationsByScene Ljava/util/Map;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->otherDurationsByScene Ljava/util/Map;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->totalInitDurationsByScene Ljava/util/Map;
    new-instance v0, Ljava/util/HashSet;
    invoke-direct v0, Ljava/util/HashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    invoke-static v0, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;
    move-result-object v0
    const-string/jumbo v1, synchronizedSet(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->addedTaskNames Ljava/util/Set;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final synchronized clearData()void
    .registers 2
    # ins_size=1
    monitor-enter v1
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFramedDurationsByScene Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->clear()V
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFeedDurationsByScene Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->clear()V
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->totalInitDurationsByScene Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->clear()V
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->addedTaskNames Ljava/util/Set;
    invoke-interface v0, Ljava/util/Set;->clear()V
    monitor-exit v1
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x1
.end method

.method private static final reportAndClearDurations$lambda$0()kotlin.Unit
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    const-string/jumbo v1, total_app_init_duration_differentiated_services
    sget-object v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->totalInitDurationsByScene Ljava/util/Map;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->reportData(Ljava/lang/String; Ljava/util/Map;)V
    const-string v1, "first_frame_init_duration_differentiated_services"
    sget-object v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFramedDurationsByScene Ljava/util/Map;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->reportData(Ljava/lang/String; Ljava/util/Map;)V
    const-string v1, "feed_show_init_duration_differentiated_services"
    sget-object v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFeedDurationsByScene Ljava/util/Map;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->reportData(Ljava/lang/String; Ljava/util/Map;)V
    const-string v1, "other_app_init_duration_differentiated_services"
    sget-object v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->otherDurationsByScene Ljava/util/Map;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->reportData(Ljava/lang/String; Ljava/util/Map;)V
    invoke-direct v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->clearData()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final reportData(java.lang.String  java.util.Map)void
    .registers 8
    # ins_size=3
    invoke-interface v7, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-interface v7, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v7
    invoke-interface v7, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ch
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    invoke-virtual v0, v2, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    goto -1fh
    sget-object v7, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    invoke-virtual v7, v6, v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->reportTeaEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v7, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const/4 v2, 0
    invoke-virtual v7, v6, v1, v0, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->reportApmEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v7
    if-eqz v7, +022h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "key: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v1, ", data: "
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v0, "TaskDurationCollector"
    invoke-virtual v7, v0, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final reportTaskInfoError(java.lang.String)void
    .registers 9
    # ins_size=2
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v0, task
    invoke-virtual v2, v0, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v8, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    const-string v0, "app_init_duration_differentiated_services_error"
    invoke-virtual v8, v0, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->reportTeaEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v8, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/apm/api/IApmTrace;
    const-string v1, "app_init_duration_differentiated_services_error"
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 12
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/apm/api/IApmTrace$DefaultImpls;->reportApmEvent$default(Lcom/bytedance/trae/apm/api/IApmTrace; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final synchronized startReportingTimer(long)void
    .registers 5
    # ins_size=3
    monitor-enter v2
    new-instance v0, Ljava/util/Timer;
    invoke-direct v0, Ljava/util/Timer;-><init>()V
    new-instance v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$startReportingTimer$1;
    invoke-direct v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$startReportingTimer$1;-><init>()V
    check-cast v1, Ljava/util/TimerTask;
    invoke-virtual v0, v1, v3, v4, Ljava/util/Timer;->schedule(Ljava/util/TimerTask; J)V
    monitor-exit v2
    return-void 
    move-exception v3
    monitor-exit v2
    throw v3
    :try_start_0x1
.end method

.method public final synchronized addTaskDuration(java.lang.String  boolean  com.bytedance.trae.init.task.base.TaskDurationCollector$AppInitStage  java.lang.String  long)void
    .registers 12
    # ins_size=7
    monitor-enter v5
    const-string/jumbo v0, scene
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, stage
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v7, +004h
    monitor-exit v5
    return-void 
    move-object v7, v6
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-nez v7, +0a4h
    move-object v7, v9
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v0, 1
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    const/4 v7, 0
    goto +2h
    move v7, v0
    if-eqz v7, +004h
    goto/16 +090h
    const-wide/16 v1, 20000
    cmp-long v7, v10, v1
    if-lez v7, +004h
    monitor-exit v5
    return-void 
    sget-object v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->addedTaskNames Ljava/util/Set;
    invoke-interface v7, v9, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +07eh
    sget-boolean v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFeedShow Z
    const-wide/16 v1, 0
    if-nez v7, +01ah
    sget-object v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->totalInitDurationsByScene Ljava/util/Map;
    invoke-interface v7, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/Long;
    if-eqz v9, +007h
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    goto +2h
    move-wide v3, v1
    add-long/2addr v3, v10
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v9
    invoke-interface v7, v6, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v8, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->ordinal()I
    move-result v8
    aget v7, v7, v8
    if-eq v7, v0, +040h
    const/4 v8, 2
    if-eq v7, v8, +026h
    const/4 v8, 3
    if-eq v7, v8, +00ch
    const/4 v8, 4
    if-ne v7, v8, +003h
    goto +7h
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    sget-object v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->otherDurationsByScene Ljava/util/Map;
    invoke-interface v7, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Long;
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    add-long/2addr v1, v10
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v8
    invoke-interface v7, v6, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +2eh
    sget-object v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFeedDurationsByScene Ljava/util/Map;
    invoke-interface v7, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Long;
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    add-long/2addr v1, v10
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v8
    invoke-interface v7, v6, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +17h
    sget-object v7, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->firstFramedDurationsByScene Ljava/util/Map;
    invoke-interface v7, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Long;
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    add-long/2addr v1, v10
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v8
    invoke-interface v7, v6, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v5
    return-void 
    invoke-direct v5, v9, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->reportTaskInfoError(Ljava/lang/String;)V
    monitor-exit v5
    return-void 
    move-exception v6
    monitor-exit v5
    throw v6
    :try_start_0x1
    :try_start_0x11
    :try_start_0x36
    :try_start_0xbc
.end method

.method public final isFirstFeedShow()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFeedShow Z
    return v0
.end method

.method public final isFirstFrame()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFrame Z
    return v0
.end method

.method public final synchronized reportAndClearDurations()void
    .registers 3
    # ins_size=1
    monitor-enter v2
    sget-boolean v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->alreadyReported Z
    if-eqz v0, +004h
    monitor-exit v2
    return-void 
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->alreadyReported Z
    sget-object v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->INSTANCE Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;
    new-instance v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->singleAsync(Lkotlin/jvm/functions/Function0;)V
    monitor-exit v2
    return-void 
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x1
    :try_start_0x8
.end method

.method public final synchronized setIsFirstFeedShow(boolean)void
    .registers 6
    # ins_size=2
    const-string/jumbo v0, setIsFirstFrame:
    monitor-enter v4
    sput-boolean v5, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFeedShow Z
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "TaskDurationCollector"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFrame Z
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-wide/16 v0, 10000
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->startReportingTimer(J)V
    monitor-exit v4
    return-void 
    move-exception v5
    monitor-exit v4
    throw v5
    :try_start_0x4
.end method

.method public final synchronized setIsFirstFrame(boolean)void
    .registers 6
    # ins_size=2
    const-string/jumbo v0, setIsFirstFrame:
    monitor-enter v4
    sput-boolean v5, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->isFirstFrame Z
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "TaskDurationCollector"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-wide/16 v0, 20000
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->startReportingTimer(J)V
    monitor-exit v4
    return-void 
    move-exception v5
    monitor-exit v4
    throw v5
    :try_start_0x4
.end method
