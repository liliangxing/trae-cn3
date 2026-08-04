# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Param;
.super Ljava/lang/Object;
.source "NewTaskTracker.kt"

.field public static final ENTER_FROM:Ljava/lang/String;
.field public static final IDE_TASK_COUNT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Param;
.field public static final PC_TASK_COUNT:Ljava/lang/String;
.field public static final POSITION:Ljava/lang/String;
.field public static final REMOTE_TASK_COUNT:Ljava/lang/String;
.field public static final SHOW_TYPE:Ljava/lang/String;
.field public static final TASK_COUNT:Ljava/lang/String;
.field public static final TASK_ID:Ljava/lang/String;
.field public static final TASK_STATUS:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Param;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Param;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Param;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Param;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
