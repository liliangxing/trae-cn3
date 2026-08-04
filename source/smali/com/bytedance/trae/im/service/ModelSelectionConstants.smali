# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ModelSelectionConstants;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field public static final AUTO:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/service/ModelSelectionConstants;
.field public static final MANUAL:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/ModelSelectionConstants;
    invoke-direct v0, Lcom/bytedance/trae/im/service/ModelSelectionConstants;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/ModelSelectionConstants;->INSTANCE Lcom/bytedance/trae/im/service/ModelSelectionConstants;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
