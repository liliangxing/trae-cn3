# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Position;
.super Ljava/lang/Object;
.source "CustomActivityTracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Position;
.field public static final NEW_SESSION:Ljava/lang/String;
.field public static final TASK_MANAGE:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Position;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Position;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Position;->INSTANCE Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Position;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
