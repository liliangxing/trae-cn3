# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
.super Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
.source "ManagedPromptArbitrationPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    invoke-direct v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    return-void 
.end method

.method private constructor <init>()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method
