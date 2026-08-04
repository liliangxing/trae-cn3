# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/base/TaskDurationCollector$startReportingTimer$1;
.super Ljava/util/TimerTask;
.source "TaskDurationCollector.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/util/TimerTask;-><init>()V
    return-void 
.end method

.method public run()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskDurationCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector;->reportAndClearDurations()V
    return-void 
.end method
