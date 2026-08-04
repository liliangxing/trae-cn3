# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/BlockReason;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/im/service/BlockReason;
.field public static final NOT_IN_ACTIVITY_TIME:I
.field public static final NO_SOLO_ENT:I
.field public static final PARALLEL_LIMITED:I
.field public static final UNKNOWN:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/BlockReason;
    invoke-direct v0, Lcom/bytedance/trae/im/service/BlockReason;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/BlockReason;->INSTANCE Lcom/bytedance/trae/im/service/BlockReason;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
