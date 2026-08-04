# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;
.super Ljava/lang/Object;
.source "ManagedPromptArbitrationPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final afterAttempt(com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome)com.bytedance.trae.conversation.prompt.ManagedPromptRoundAction
    .registers 4
    # ins_size=3
    const-string v0, "candidate"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "outcome"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    if-eq v3, v0, +01fh
    const/4 v0, 2
    if-eq v3, v0, +019h
    const/4 v0, 3
    if-ne v3, v0, +010h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getType()Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;->BillingUpgrade Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    if-ne v2, v3, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;->ContinueToLowerPriority Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;
    goto +fh
    sget-object v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;->Complete Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;
    goto +ch
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;->Retry Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;->Complete Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;
    return-object v2
.end method
