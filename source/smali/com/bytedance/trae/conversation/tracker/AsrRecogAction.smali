# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/AsrRecogAction;
.super Ljava/lang/Object;
.source "TraeAITracker.kt"

.field public static final BUTTON_CLICK:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/AsrRecogAction;
.field public static final RECOG_CANCEL:Ljava/lang/String;
.field public static final RECOG_END:Ljava/lang/String;
.field public static final RECOG_KEEP:Ljava/lang/String;
.field public static final RECOG_START:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/AsrRecogAction;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/AsrRecogAction;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/AsrRecogAction;->INSTANCE Lcom/bytedance/trae/conversation/tracker/AsrRecogAction;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
