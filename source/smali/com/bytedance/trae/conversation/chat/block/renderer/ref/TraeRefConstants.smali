# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefConstants;
.super Ljava/lang/Object;
.source "TraeRefModels.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefConstants;
.field public static final SPECIAL_TOKEN:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefConstants;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefConstants;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefConstants;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefConstants;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
