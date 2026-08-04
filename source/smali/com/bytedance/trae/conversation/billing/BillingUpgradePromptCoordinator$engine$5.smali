# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$5;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "BillingUpgradePromptCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 2
    const-class v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    const-string/jumbo v4, savePending
    const-string/jumbo v5, savePending(Ljava/lang/String;Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/String;
    check-cast v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$5;->invoke(Ljava/lang/String; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(java.lang.String  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)void
    .registers 4
    # ins_size=3
    const-string v0, "p0"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "p1"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$5;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->savePending(Ljava/lang/String; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    return-void 
.end method
