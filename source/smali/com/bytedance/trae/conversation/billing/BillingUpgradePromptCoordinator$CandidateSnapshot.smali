# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
.super Ljava/lang/Object;
.source "BillingUpgradePromptCoordinator.kt"

.field private final promptData:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
.field private final state:Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;


.method public constructor <init>(com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState  com.bytedance.trae.conversation.billing.BillingUpgradePromptData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator$CandidateSnapshot  com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState  com.bytedance.trae.conversation.billing.BillingUpgradePromptData  int  java.lang.Object)com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator$CandidateSnapshot
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->copy(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.billing.BillingUpgradePromptData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator$CandidateSnapshot
    .registers 4
    # ins_size=3
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getPromptData()com.bytedance.trae.conversation.billing.BillingUpgradePromptData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    return-object v0
.end method

.method public final getState()com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CandidateSnapshot(state="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->state Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", promptData="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->promptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
