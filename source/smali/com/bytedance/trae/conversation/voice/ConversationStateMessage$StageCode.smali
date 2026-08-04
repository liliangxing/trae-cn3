# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$StageCode;
.super Ljava/lang/Object;
.source "ConversationStateMessage.kt"

.field public static final ANSWERING:I
.field public static final ANSWER_FINISH:I
.field public static final ERROR_OCCURRED:I
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$StageCode;
.field public static final INTERRUPTED:I
.field public static final LISTENING:I
.field public static final THINKING:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$StageCode;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$StageCode;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$StageCode;->INSTANCE Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$StageCode;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
