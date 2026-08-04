# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;
.super Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
.source "VoiceSubTaskCoordinator.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;
    return-void 
.end method

.method private constructor <init>()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method
