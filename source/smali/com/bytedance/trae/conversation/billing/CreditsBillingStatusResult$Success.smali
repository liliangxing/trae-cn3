# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
.super Ljava/lang/Object;
.source "BillingUpgradePreparation.kt"

.implements Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;

.field private final isCreditsBilling:Z


.method public constructor <init>(boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.billing.CreditsBillingStatusResult$Success  boolean  int  java.lang.Object)com.bytedance.trae.conversation.billing.CreditsBillingStatusResult$Success
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->copy(Z)Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    return v0
.end method

.method public final copy(boolean)com.bytedance.trae.conversation.billing.CreditsBillingStatusResult$Success
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;-><init>(Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    iget-boolean v4, v4, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    if-eq v1, v4, +003h
    return v2
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    return v0
.end method

.method public final isCreditsBilling()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Success(isCreditsBilling="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
