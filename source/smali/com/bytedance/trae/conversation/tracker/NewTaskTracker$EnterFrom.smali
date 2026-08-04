# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$EnterFrom;
.super Ljava/lang/Object;
.source "NewTaskTracker.kt"

.field public static final DEEPLINK:Ljava/lang/String;
.field public static final HISTORY_CHAT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$EnterFrom;
.field public static final NOTIFICATION:Ljava/lang/String;
.field public static final TASK_LIST:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$EnterFrom;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$EnterFrom;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$EnterFrom;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$EnterFrom;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
