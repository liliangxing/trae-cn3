# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
.field public final synthetic f$2:Lkotlinx/coroutines/Deferred;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine  com.bytedance.trae.conversation.billing.BillingUpgradePromptSession  kotlinx.coroutines.Deferred)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;->f$2 Lkotlinx/coroutines/Deferred;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;->f$2 Lkotlinx/coroutines/Deferred;
    check-cast v4, Ljava/lang/Throwable;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->$r8$lambda$wcug08m_0Vyzzgww9x11v5SGr6A(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession; Lkotlinx/coroutines/Deferred; Ljava/lang/Throwable;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
