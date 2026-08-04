# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$3;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "BillingUpgradePromptCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;
.implements Lkotlin/coroutines/jvm/internal/SuspendFunction;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 2
    const-class v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;
    const-string v4, "fetchBillingUpgradePreparation"
    const-string v5, "fetchBillingUpgradePreparation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke(com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->fetchBillingUpgradePreparation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$3;->invoke(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
