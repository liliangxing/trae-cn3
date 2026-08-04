# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/home/solo/task/TaskStatus;
.super Ljava/lang/Enum;
.source "TaskModel.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum CREATING:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final Companion:Lcom/bytedance/trae/home/solo/task/TaskStatus$Companion;
.field public static final enum FAILED:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum FINISHED:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum FROZEN:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum PENDING:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum REVERTING:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum RUNNING:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum STOPPED:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum STOPPING:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum UNKNOWN:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field public static final enum WAITING:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field private final bgColorRes:I
.field private final circleBgColorRes:I
.field private final circleBorderColorRes:I
.field private final circleBorderStyle:Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
.field private final displayState:Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
.field private final iconRes:I
.field private final label:Ljava/lang/String;
.field private final showBadge:Z
.field private final statusCode:I
.field private final textColorRes:I


.method private static final synthetic $values()com.bytedance.trae.home.solo.task.TaskStatus[]
    .registers 3
    # ins_size=0
    const/16 v0, 11
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->UNKNOWN Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->PENDING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->CREATING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->RUNNING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->STOPPED Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->FINISHED Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->FAILED Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->FROZEN Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->WAITING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->REVERTING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->STOPPING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 31
    # ins_size=0
    new-instance v15, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v1, "UNKNOWN"
    const/4 v2, 0
    const/4 v3, 0
    const-string v4, "Unknown"
    sget v5, Lcom/bytedance/trae/home/R$drawable;->ic_solo_unknown_circle I
    sget v6, Lcom/bytedance/trae/home/R$color;->solo_task_unknown_text I
    sget v7, Lcom/bytedance/trae/home/R$color;->solo_task_unknown_bg I
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 992
    const/4 v14, 0
    move-object v0, v15
    invoke-direct/range v0 ... v14, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v15, Lcom/bytedance/trae/home/solo/task/TaskStatus;->UNKNOWN Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v17, "PENDING"
    const/16 v18, 1
    const/16 v19, 1
    const-string v20, "Pending"
    sget v21, Lcom/bytedance/trae/home/R$drawable;->ic_solo_warning_circle I
    sget v22, Lcom/bytedance/trae/home/R$color;->solo_task_pending_text I
    sget v23, Lcom/bytedance/trae/home/R$color;->solo_task_pending_bg I
    sget-object v24, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    sget-object v25, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->SOLID Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    sget v26, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_bg I
    sget v27, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_border I
    const/16 v28, 0
    const/16 v29, 512
    const/16 v30, 0
    move-object/from16 v16, v0
    invoke-direct/range v16 ... v30, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->PENDING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v2, "CREATING"
    const/4 v3, 2
    const/4 v4, 2
    const-string v5, "Creating"
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_creating_circle I
    sget v7, Lcom/bytedance/trae/home/R$color;->solo_task_creating_text I
    sget v8, Lcom/bytedance/trae/home/R$color;->solo_task_creating_bg I
    sget-object v9, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    sget-object v10, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->SOLID Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_bg I
    sget v12, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_border I
    const/4 v13, 0
    const/16 v14, 512
    const/4 v15, 0
    move-object v1, v0
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->CREATING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v17, "RUNNING"
    const/16 v18, 3
    const/16 v19, 3
    const-string v20, "Running"
    sget v21, Lcom/bytedance/trae/home/R$drawable;->ic_solo_todo I
    sget v22, Lcom/bytedance/trae/home/R$color;->solo_task_running_text I
    sget v23, Lcom/bytedance/trae/home/R$color;->solo_task_running_bg I
    sget-object v24, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    sget-object v25, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->SOLID Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    sget v26, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_bg I
    sget v27, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_border I
    move-object/from16 v16, v0
    invoke-direct/range v16 ... v30, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->RUNNING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v2, "STOPPED"
    const/4 v3, 4
    const/4 v4, 4
    const-string v5, "Stopped"
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_stopped_circle I
    sget v7, Lcom/bytedance/trae/home/R$color;->solo_task_stopped_text I
    sget v8, Lcom/bytedance/trae/home/R$color;->solo_task_stopped_bg I
    const/4 v9, 0
    sget-object v10, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->SOLID Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    const/4 v11, 0
    sget v12, Lcom/bytedance/trae/home/R$color;->solo_task_circle_stopped_border I
    const/16 v14, 672
    move-object v1, v0
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->STOPPED Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v17, "FINISHED"
    const/16 v18, 5
    const/16 v19, 5
    const-string v20, "Finished"
    sget v21, Lcom/bytedance/trae/home/R$drawable;->ic_solo_checkmark_circle I
    sget v22, Lcom/bytedance/trae/home/R$color;->solo_task_finished_text I
    sget v23, Lcom/bytedance/trae/home/R$color;->solo_task_finished_bg I
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 992
    move-object/from16 v16, v0
    invoke-direct/range v16 ... v30, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->FINISHED Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v2, "FAILED"
    const/4 v3, 6
    const/4 v4, 6
    const-string v5, "Failed"
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_failed_circle I
    sget v7, Lcom/bytedance/trae/home/R$color;->solo_task_failed_text I
    sget v8, Lcom/bytedance/trae/home/R$color;->solo_task_failed_bg I
    sget-object v9, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->ERROR Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    sget-object v10, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->SOLID Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_task_circle_red_bg I
    sget v12, Lcom/bytedance/trae/home/R$color;->solo_task_circle_red_border I
    const/16 v14, 512
    move-object v1, v0
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->FAILED Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v17, "FROZEN"
    const/16 v18, 7
    const/16 v19, 7
    const-string v20, "Frozen"
    sget v21, Lcom/bytedance/trae/home/R$drawable;->ic_solo_frozen_circle I
    sget v22, Lcom/bytedance/trae/home/R$color;->solo_task_frozen_text I
    sget v23, Lcom/bytedance/trae/home/R$color;->solo_task_frozen_bg I
    move-object/from16 v16, v0
    invoke-direct/range v16 ... v30, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->FROZEN Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v2, "WAITING"
    const/16 v3, 8
    const/16 v4, 8
    const-string v5, "Waiting"
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_warning_circle I
    sget v7, Lcom/bytedance/trae/home/R$color;->solo_task_waiting_text I
    sget v8, Lcom/bytedance/trae/home/R$color;->solo_task_waiting_bg I
    sget-object v9, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->WAITING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    sget-object v10, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->DASHED Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_task_circle_orange_bg I
    sget v12, Lcom/bytedance/trae/home/R$color;->solo_task_circle_orange_border I
    move-object v1, v0
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->WAITING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v17, "REVERTING"
    const/16 v18, 9
    const/16 v19, 9
    const-string v20, "Reverting"
    sget v21, Lcom/bytedance/trae/home/R$drawable;->ic_solo_reverting_circle I
    sget v22, Lcom/bytedance/trae/home/R$color;->solo_task_reverting_text I
    sget v23, Lcom/bytedance/trae/home/R$color;->solo_task_reverting_bg I
    sget-object v24, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    sget-object v25, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->SOLID Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    sget v26, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_bg I
    sget v27, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_border I
    const/16 v29, 512
    move-object/from16 v16, v0
    invoke-direct/range v16 ... v30, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->REVERTING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    const-string v2, "STOPPING"
    const/16 v3, 10
    const/16 v4, 10
    const-string v5, "Stopping"
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_stopped_circle I
    sget v7, Lcom/bytedance/trae/home/R$color;->solo_task_stopped_text I
    sget v8, Lcom/bytedance/trae/home/R$color;->solo_task_stopped_bg I
    sget-object v9, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    sget-object v10, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->SOLID Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_bg I
    sget v12, Lcom/bytedance/trae/home/R$color;->solo_task_circle_blue_border I
    move-object v1, v0
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->STOPPING Lcom/bytedance/trae/home/solo/task/TaskStatus;
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskStatus;->$values()[Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->$VALUES [Lcom/bytedance/trae/home/solo/task/TaskStatus;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskStatus$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->Companion Lcom/bytedance/trae/home/solo/task/TaskStatus$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int  java.lang.String  int  int  int  com.bytedance.trae.home.solo.task.TaskDisplayState  com.bytedance.trae.home.solo.task.CircleBorderStyle  int  int  boolean)void
    .registers 13
    # ins_size=13
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->statusCode I
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->label Ljava/lang/String;
    iput v5, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->iconRes I
    iput v6, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->textColorRes I
    iput v7, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->bgColorRes I
    iput-object v8, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->displayState Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    iput-object v9, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->circleBorderStyle Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    iput v10, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->circleBgColorRes I
    iput v11, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->circleBorderColorRes I
    iput-boolean v12, v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->showBadge Z
    return-void 
.end method

.method synthetic constructor <init>(java.lang.String  int  int  java.lang.String  int  int  int  com.bytedance.trae.home.solo.task.TaskDisplayState  com.bytedance.trae.home.solo.task.CircleBorderStyle  int  int  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 30
    # ins_size=15
    move/from16 v0, v28
    and-int/lit8 v1, v0, 32
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->IDLE Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v23
    and-int/lit8 v1, v0, 64
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->NONE Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    move-object v11, v1
    goto +3h
    move-object/from16 v11, v24
    and-int/lit16 v1, v0, 128
    if-eqz v1, +006h
    sget v1, Lcom/bytedance/trae/home/R$color;->solo_task_circle_default_bg I
    move v12, v1
    goto +3h
    move/from16 v12, v25
    and-int/lit16 v1, v0, 256
    const/4 v2, 0
    if-eqz v1, +004h
    move v13, v2
    goto +3h
    move/from16 v13, v26
    and-int/lit16 v0, v0, 512
    if-eqz v0, +004h
    move v14, v2
    goto +3h
    move/from16 v14, v27
    move-object v2, v15
    move-object/from16 v3, v16
    move/from16 v4, v17
    move/from16 v5, v18
    move-object/from16 v6, v19
    move/from16 v7, v20
    move/from16 v8, v21
    move/from16 v9, v22
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/home/solo/task/TaskStatus;-><init>(Ljava/lang/String; I I Ljava/lang/String; I I I Lcom/bytedance/trae/home/solo/task/TaskDisplayState; Lcom/bytedance/trae/home/solo/task/CircleBorderStyle; I I Z)V
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.task.TaskStatus
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.task.TaskStatus[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskStatus;->$VALUES [Lcom/bytedance/trae/home/solo/task/TaskStatus;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/task/TaskStatus;
    return-object v0
.end method

.method public final getBgColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->bgColorRes I
    return v0
.end method

.method public final getCircleBgColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->circleBgColorRes I
    return v0
.end method

.method public final getCircleBorderColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->circleBorderColorRes I
    return v0
.end method

.method public final getCircleBorderStyle()com.bytedance.trae.home.solo.task.CircleBorderStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->circleBorderStyle Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    return-object v0
.end method

.method public final getDisplayState()com.bytedance.trae.home.solo.task.TaskDisplayState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->displayState Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    return-object v0
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->iconRes I
    return v0
.end method

.method public final getLabel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->label Ljava/lang/String;
    return-object v0
.end method

.method public final getShowBadge()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->showBadge Z
    return v0
.end method

.method public final getStatusCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->statusCode I
    return v0
.end method

.method public final getTextColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->textColorRes I
    return v0
.end method
