# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +01eh
    if-eq v1, v3, +014h
    if-ne v1, v2, +00ah
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->L$0 Ljava/lang/Object;
    check-cast v0, Landroidx/lifecycle/MutableLiveData;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3fh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1bh
    move-exception v10
    goto +35h
    move-exception v10
    goto +50h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    const-wide/16 v4, 0
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    const/4 v7, 1
    const/4 v8, 0
    iput v3, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->label I
    move-object v3, v10
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->awaitReady$default(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_creditsBalanceSnapshot$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v10
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    move-object v3, v9
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v10, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->L$0 Ljava/lang/Object;
    iput v2, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;->label I
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCacheCreditsBalanceSnapshot(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v10
    move-object v10, v1
    invoke-virtual v0, v10, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +1bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "fetchCreditsBalance failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v1, "SettingsViewModel"
    invoke-virtual v0, v1, v10, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    throw v10
    :try_start_0x12
    :try_start_0x1e
    :try_start_0x29
.end method
