# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Event;
.super Ljava/lang/Object;
.source "CustomActivityTracker.kt"

.field public static final HOME_ENTRY_CLICK:Ljava/lang/String;
.field public static final HOME_ENTRY_SHOW:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Event;
.field public static final SHARE_BUTTON_CLICK:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Event;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Event;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Event;->INSTANCE Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Event;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
