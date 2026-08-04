# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$2;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "BillingUpgradePromptCoordinator.kt"

.implements Lkotlin/jvm/functions/Function1;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 1
    const-class v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    const-string v4, "hasShown"
    const-string v5, "hasShown(Ljava/lang/String;)Z"
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke(java.lang.String)java.lang.Boolean
    .registers 3
    # ins_size=2
    const-string v0, "p0"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$2;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->hasShown(Ljava/lang/String;)Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/lang/String;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$2;->invoke(Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method
