# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "CreditsBalanceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 3
    # ins_size=3
    new-instance v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/coroutines/Continuation;
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v1, +01ch
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +34h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    move-exception v12
    goto/16 +095h
    move-exception v12
    goto/16 +0b0h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    const-wide/16 v6, 0
    move-object v8, v11
    check-cast v8, Lkotlin/coroutines/Continuation;
    const/4 v9, 1
    const/4 v10, 0
    iput v3, v11, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;->label I
    invoke-static/range v5 ... v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->awaitReady$default(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    move-object v12, v11
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput v2, v11, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;->label I
    invoke-static v12, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->fetchCreditsBalanceData(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    check-cast v12, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    if-nez v12, +01bh
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$isFetching$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$getRefreshPending$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z
    move-result v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refresh()V
    return-object v12
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    invoke-static v0, v12, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$belongsToCurrentUser(Lcom/bytedance/trae/conversation/CreditsBalanceManager; Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;)Z
    move-result v0
    if-nez v0, +01bh
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$isFetching$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$getRefreshPending$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z
    move-result v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refresh()V
    return-object v12
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$getListeners$p()Ljava/util/concurrent/CopyOnWriteArraySet;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager$OnBalanceChangedListener;
    invoke-interface v1, v12, Lcom/bytedance/trae/conversation/CreditsBalanceManager$OnBalanceChangedListener;->onBalanceChanged(Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;)V
    goto -fh
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$isFetching$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v12
    invoke-virtual v12, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$getRefreshPending$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v12
    invoke-virtual v12, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z
    move-result v12
    if-eqz v12, +023h
    sget-object v12, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refresh()V
    goto +1ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "CreditsBalanceManager"
    const-string v2, "refresh credits balance failed"
    invoke-virtual v0, v1, v2, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$isFetching$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v12
    invoke-virtual v12, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$getRefreshPending$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v12
    invoke-virtual v12, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z
    move-result v12
    if-eqz v12, +003h
    goto -20h
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    throw v12
    move-exception v12
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$isFetching$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    invoke-static Lcom/bytedance/trae/conversation/CreditsBalanceManager;->access$getRefreshPending$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z
    move-result v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refresh()V
    throw v12
    :try_start_0xf
    :try_start_0x1b
    :try_start_0x28
    :try_start_0x63
    :try_start_0x84
    :try_start_0xb5
    :try_start_0xd3
.end method
