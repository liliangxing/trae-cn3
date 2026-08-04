# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/AIEvent;
.super Ljava/lang/Object;
.source "TraeAITracker.kt"

.field public static final ASR_DISCUSS:Ljava/lang/String;
.field public static final ASR_RECOG:Ljava/lang/String;
.field public static final ASR_REWRITE:Ljava/lang/String;
.field public static final CANCELED:Ljava/lang/String;
.field public static final COMPLETE_SHOW:Ljava/lang/String;
.field public static final COPY_CLICK:Ljava/lang/String;
.field public static final DELETE_CLICK:Ljava/lang/String;
.field public static final DELETE_SUCCESS:Ljava/lang/String;
.field public static final FEEDBACK_CLICK:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/AIEvent;
.field public static final REPORT_CLICK:Ljava/lang/String;
.field public static final RETRY_CLICK:Ljava/lang/String;
.field public static final REVERT_CLICK:Ljava/lang/String;
.field public static final REVERT_SUCCESS:Ljava/lang/String;
.field public static final SHOW:Ljava/lang/String;
.field public static final TASK_CREATE_RESULT:Ljava/lang/String;
.field public static final TRIGGER:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/AIEvent;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/AIEvent;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/AIEvent;->INSTANCE Lcom/bytedance/trae/conversation/tracker/AIEvent;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
