# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/base/TaskDurationCollector$WhenMappings;
.super Ljava/lang/Object;
.source "TaskDurationCollector.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->values()[Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->FIRST_FRAME Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    invoke-virtual v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->FIRST_FEED Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    invoke-virtual v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->OTHER Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    invoke-virtual v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->DEFAULT Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    invoke-virtual v1, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/init/task/base/TaskDurationCollector$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
.end method
