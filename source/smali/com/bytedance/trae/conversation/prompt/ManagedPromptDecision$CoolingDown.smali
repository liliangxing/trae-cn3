# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
.super Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
.source "ManagedPromptArbitrationPolicy.kt"

.field private final nextEligibleAtMillis:J


.method public constructor <init>(long)void
    .registers 4
    # ins_size=3
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.prompt.ManagedPromptDecision$CoolingDown  long  int  java.lang.Object)com.bytedance.trae.conversation.prompt.ManagedPromptDecision$CoolingDown
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->copy(J)Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    return-wide v0
.end method

.method public final copy(long)com.bytedance.trae.conversation.prompt.ManagedPromptDecision$CoolingDown
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;-><init>(J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getNextEligibleAtMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    return-wide v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CoolingDown(nextEligibleAtMillis="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;->nextEligibleAtMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
