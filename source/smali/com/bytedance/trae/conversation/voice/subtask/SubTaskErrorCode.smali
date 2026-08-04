# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/SubTaskErrorCode;
.super Ljava/lang/Object;
.source "SubTaskProtocol.kt"

.field public static final CONTAINER_NOT_READY:Ljava/lang/String;
.field public static final DEVICE_OFFLINE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskErrorCode;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskErrorCode;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskErrorCode;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskErrorCode;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/SubTaskErrorCode;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
