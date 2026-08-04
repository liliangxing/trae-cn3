# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
.super Ljava/lang/Object;
.source "BillingUpgradePreparation.kt"

.implements Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;

.field private final userState:Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;


.method public constructor <init>(com.bytedance.trae.conversation.billing.BillingUpgradeUserState)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, userState
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.billing.BillingUpgradeUserStateResult$Success  com.bytedance.trae.conversation.billing.BillingUpgradeUserState  int  java.lang.Object)com.bytedance.trae.conversation.billing.BillingUpgradeUserStateResult$Success
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->copy(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.billing.BillingUpgradeUserState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.billing.BillingUpgradeUserState)com.bytedance.trae.conversation.billing.BillingUpgradeUserStateResult$Success
    .registers 3
    # ins_size=2
    const-string/jumbo v0, userState
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    if-eq v1, v4, +003h
    return v2
    return v0
.end method

.method public final getUserState()com.bytedance.trae.conversation.billing.BillingUpgradeUserState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Success(userState="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->userState Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
