# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;
.super Ljava/lang/Object;
.source "ManagedPromptArbitrationPolicy.kt"

.field public static final GLOBAL_COOLDOWN_MILLIS:J
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final decide(long  com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState  com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState  com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState)com.bytedance.trae.conversation.prompt.ManagedPromptDecision
    .registers 10
    # ins_size=6
    const-string v0, "ledger"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "billing"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "guide"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownAtMillis()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +013h
    sub-long/2addr v5, v0
    const-wide/32 v2, 86400000
    cmp-long v5, v5, v2
    if-gez v5, +00bh
    new-instance v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    add-long/2addr v0, v2
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;-><init>(J)V
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    return-object v5
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    invoke-static v8, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    return-object v5
    instance-of v5, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;
    if-eqz v5, +01ah
    check-cast v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v5
    invoke-virtual v7, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->hasShownAtLeast(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)Z
    move-result v5
    if-nez v5, +016h
    new-instance v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)V
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    return-object v5
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    invoke-static v8, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +043h
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    invoke-static v9, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    goto +2eh
    instance-of v5, v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;
    if-eqz v5, +01fh
    check-cast v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v5
    invoke-virtual v7, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->hasShownAtLeast(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)Z
    move-result v5
    if-eqz v5, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    goto +19h
    new-instance v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)V
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    goto +dh
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    invoke-static v9, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    return-object v5
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
.end method
