# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/AsrRewriteAction;
.super Ljava/lang/Object;
.source "TraeAITracker.kt"

.field public static final APPLY:Ljava/lang/String;
.field public static final EDIT:Ljava/lang/String;
.field public static final FAIL:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/AsrRewriteAction;
.field public static final REQUEST:Ljava/lang/String;
.field public static final SUCCESS:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/AsrRewriteAction;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/AsrRewriteAction;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/AsrRewriteAction;->INSTANCE Lcom/bytedance/trae/conversation/tracker/AsrRewriteAction;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
