# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;
.super Ljava/lang/Object;
.source "BillingUpgradePreparation.kt"

.field private final fetchCreditsBillingStatus:Lkotlin/jvm/functions/Function1;
.field private final fetchUserState:Lkotlin/jvm/functions/Function1;
.field private final isAccountCurrent:Lkotlin/jvm/functions/Function0;
.field private final switchBillingVersion:Lkotlin/jvm/functions/Function1;


.method public constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 6
    # ins_size=5
    const-string v0, "fetchCreditsBillingStatus"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fetchUserState"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, switchBillingVersion
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "isAccountCurrent"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->fetchCreditsBillingStatus Lkotlin/jvm/functions/Function1;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->fetchUserState Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->switchBillingVersion Lkotlin/jvm/functions/Function1;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->isAccountCurrent Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public static synthetic run$default(com.bytedance.trae.conversation.billing.BillingUpgradePreparationRunner  com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +004h
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->PromptEligible Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->run(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final run(com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    instance-of v0, v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;
    if-eqz v0, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    sub-int/2addr v10, v2
    iput v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;
    invoke-direct v0, v8, v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner; Lkotlin/coroutines/Continuation;)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    const/4 v3, 4
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v2, +040h
    if-eq v2, v6, +02eh
    if-eq v2, v5, +024h
    if-eq v2, v4, +019h
    if-ne v2, v3, +00fh
    iget-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$1 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0e8h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a7h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5ch
    iget-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$1 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v10
    move-object v10, v9
    move-object v9, v2
    move-object v2, v7
    goto +16h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->fetchCreditsBillingStatus Lkotlin/jvm/functions/Function1;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$1 Ljava/lang/Object;
    iput v6, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    move-object v2, v10
    move-object v10, v9
    move-object v9, v8
    check-cast v2, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->isAccountCurrent Lkotlin/jvm/functions/Function0;
    invoke-interface v6, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Boolean;
    invoke-virtual v6, Ljava/lang/Boolean;->booleanValue()Z
    move-result v6
    if-nez v6, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;
    return-object v9
    instance-of v6, v2, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
    if-eqz v6, +0e0h
    check-cast v2, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;->isCreditsBilling()Z
    move-result v2
    if-eqz v2, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;
    return-object v9
    sget-object v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->SilentRecovery Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    const/4 v6, 0
    if-ne v10, v2, +044h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->switchBillingVersion Lkotlin/jvm/functions/Function1;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$1 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;
    iget-object v9, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->isAccountCurrent Lkotlin/jvm/functions/Function0;
    invoke-interface v9, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/Boolean;
    invoke-virtual v9, Ljava/lang/Boolean;->booleanValue()Z
    move-result v9
    if-nez v9, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;
    return-object v9
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +007h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;
    check-cast v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    goto +dh
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +007h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    check-cast v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    return-object v9
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
    iget-object v10, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->fetchUserState Lkotlin/jvm/functions/Function1;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->isAccountCurrent Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-nez v2, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;
    return-object v9
    instance-of v2, v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
    if-eqz v2, +057h
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;->getUserState()Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v10
    iget-object v2, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->switchBillingVersion Lkotlin/jvm/functions/Function1;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$0 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner$run$1;->label I
    invoke-interface v2, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v7, v0
    move-object v0, v9
    move-object v9, v10
    move-object v10, v7
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;->isAccountCurrent Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v0, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;
    return-object v9
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00fh
    new-instance v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-direct v0, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)V
    invoke-direct v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    goto +eh
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +008h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    return-object v10
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    return-object v9
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
    sget-object v9, Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;
    invoke-static v2, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    return-object v9
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
.end method
