# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Event;
.super Ljava/lang/Object;
.source "NewTaskTracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Event;
.field public static final NEW_TASK_PAGE_VIEW:Ljava/lang/String;
.field public static final TASK_CARD_CLICK:Ljava/lang/String;
.field public static final TASK_CARD_SLIDE:Ljava/lang/String;
.field public static final TASK_DELETE_CLICK:Ljava/lang/String;
.field public static final TASK_DETAIL_PAGE_VIEW:Ljava/lang/String;
.field public static final TASK_LIST_PAGE_VIEW:Ljava/lang/String;
.field public static final TASK_RENAME_CLICK:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Event;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Event;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Event;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Event;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
