# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
.super Ljava/lang/Object;
.source "BillingUpgradePromptEngine.kt"

.field private final clearPending:Lkotlin/jvm/functions/Function1;
.field private final currentSession:Lkotlin/jvm/functions/Function0;
.field private final entries:Ljava/util/Map;
.field private final fetchPreparation:Lkotlin/jvm/functions/Function2;
.field private final hasShown:Lkotlin/jvm/functions/Function1;
.field private final loadPending:Lkotlin/jvm/functions/Function1;
.field private final lock:Ljava/lang/Object;
.field private final maxAttemptsPerSession:I
.field private final savePending:Lkotlin/jvm/functions/Function2;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$O4HbAsYYpv0_ZFQmwuxNa2-JdWw(java.lang.String  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->_init_$lambda$0(Ljava/lang/String; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Z8C6uajPlLeeiFTzz4n0piCl75g(java.lang.String)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->_init_$lambda$1(Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wcug08m_0Vyzzgww9x11v5SGr6A(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine  com.bytedance.trae.conversation.billing.BillingUpgradePromptSession  kotlinx.coroutines.Deferred  java.lang.Throwable)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->startPreparationIfNeeded$lambda$17$lambda$16(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession; Lkotlinx/coroutines/Deferred; Ljava/lang/Throwable;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  int)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, scope
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentSession"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hasShown"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fetchPreparation"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "loadPending"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, savePending
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clearPending"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->scope Lkotlinx/coroutines/CoroutineScope;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->currentSession Lkotlin/jvm/functions/Function0;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->hasShown Lkotlin/jvm/functions/Function1;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->fetchPreparation Lkotlin/jvm/functions/Function2;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->loadPending Lkotlin/jvm/functions/Function1;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->savePending Lkotlin/jvm/functions/Function2;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->clearPending Lkotlin/jvm/functions/Function1;
    iput v9, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->maxAttemptsPerSession I
    new-instance v2, Ljava/lang/Object;
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=11
    move/from16 v0, v20
    and-int/lit8 v1, v0, 16
    if-eqz v1, +008h
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;
    check-cast v1, Lkotlin/jvm/functions/Function1;
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v1, v0, 32
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda0;-><init>()V
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v1, v0, 64
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda1;-><init>()V
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v0, v0, 128
    if-eqz v0, +005h
    const/4 v0, 2
    move v10, v0
    goto +3h
    move/from16 v10, v19
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;-><init>(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; I)V
    return-void 
.end method

.method private static final _init_$lambda$0(java.lang.String  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final _init_$lambda$1(java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public static final synthetic access$completePreparation(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine  com.bytedance.trae.conversation.billing.BillingUpgradePromptSession  com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$Entry  com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->completePreparation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry; Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;)V
    return-void 
.end method

.method public static final synthetic access$getFetchPreparation$p(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->fetchPreparation Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$startPreparationIfNeeded(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine)kotlinx.coroutines.Deferred
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->startPreparationIfNeeded()Lkotlinx/coroutines/Deferred;
    move-result-object v0
    return-object v0
.end method

.method private final completePreparation(com.bytedance.trae.conversation.billing.BillingUpgradePromptSession  com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$Entry  com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult)void
    .registers 11
    # ins_size=4
    iget-object v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->currentSession Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    monitor-enter v1
    iget-object v2, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getKey()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    if-eqz v2, +0feh
    const/4 v3, 0
    const/4 v4, 1
    if-ne v2, v9, +004h
    move v9, v4
    goto +2h
    move v9, v3
    const/4 v5, 0
    if-eqz v9, +003h
    goto +2h
    move-object v2, v5
    if-eqz v2, +0f0h
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getKey()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v5
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getKey()Ljava/lang/String;
    move-result-object v0
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +00dh
    iget-object v9, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getKey()Ljava/lang/String;
    move-result-object v8
    invoke-interface v9, v8, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v1
    return-void 
    instance-of v9, v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;
    if-eqz v9, +07ah
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setTerminal(Z)V
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPromptShownInProcess()Z
    move-result v0
    if-nez v0, +017h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->hasShown Lkotlin/jvm/functions/Function1;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getUserId()Ljava/lang/String;
    move-result-object v6
    invoke-interface v0, v6, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v3
    goto +2h
    move v0, v4
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->shouldShow(Z)Z
    move-result v9
    if-eqz v9, +04dh
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v9, v7
    check-cast v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iget-object v9, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->savePending Lkotlin/jvm/functions/Function2;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getUserId()Ljava/lang/String;
    move-result-object v8
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;->getPromptData()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-result-object v0
    invoke-interface v9, v8, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v9
    invoke-static v8, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    move-object v8, v9
    check-cast v8, Ljava/lang/Boolean;
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;->getPromptData()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-result-object v9
    invoke-static v8, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    if-eqz v8, +003h
    move-object v5, v9
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +4eh
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +00bh
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setTerminal(Z)V
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +3dh
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +00bh
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setTerminal(Z)V
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +2ch
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +014h
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getAttempts()I
    move-result v8
    iget v9, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->maxAttemptsPerSession I
    if-lt v8, v9, +003h
    move v3, v4
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setTerminal(Z)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +12h
    sget-object v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +00dh
    iget-object v9, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getKey()Ljava/lang/String;
    move-result-object v8
    invoke-interface v9, v8, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v1
    return-void 
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    monitor-exit v1
    return-void 
    move-exception v8
    monitor-exit v1
    throw v8
    :try_start_0xb
    :try_start_0x44
    :try_start_0x6f
    :try_start_0x8e
    :try_start_0x10f
.end method

.method private final startPreparationIfNeeded()kotlinx.coroutines.Deferred
    .registers 20
    # ins_size=1
    move-object/from16 v7, v19
    iget-object v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->currentSession Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    move-object v8, v0
    check-cast v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    const/4 v1, 0
    if-nez v8, +003h
    return-object v1
    iget-object v9, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    monitor-enter v9
    iget-object v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getKey()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +016h
    new-instance v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 63
    const/16 v18, 0
    move-object v10, v3
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;-><init>(I Z Z Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; Lkotlinx/coroutines/Deferred; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-object v10, v3
    check-cast v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPromptShownInProcess()Z
    move-result v0
    const/4 v2, 1
    if-nez v0, +018h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->hasShown Lkotlin/jvm/functions/Function1;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getUserId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-eqz v0, +003h
    goto +4h
    const/4 v0, 0
    move v3, v0
    goto +2h
    move v3, v2
    if-eqz v3, +030h
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPromptShownInProcess(Z)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPendingRestored()Z
    move-result v0
    if-nez v0, +061h
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingRestored(Z)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->clearPending Lkotlin/jvm/functions/Function1;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getUserId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +49h
    move-exception v0
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +3eh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPendingRestored()Z
    move-result v0
    if-nez v0, +039h
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingRestored(Z)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->loadPending Lkotlin/jvm/functions/Function1;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getUserId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    if-eqz v0, +00ah
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setTerminal(Z)V
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    monitor-exit v9
    return-object v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPreparation()Lkotlinx/coroutines/Deferred;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-interface v0, Lkotlinx/coroutines/Deferred;->isCompleted()Z
    move-result v4
    if-nez v4, +004h
    monitor-exit v9
    return-object v0
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPreparation(Lkotlinx/coroutines/Deferred;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPendingPromptData()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-result-object v0
    if-eqz v0, +004h
    monitor-exit v9
    return-object v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getTerminal()Z
    move-result v0
    if-nez v0, +045h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getAttempts()I
    move-result v0
    iget v4, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->maxAttemptsPerSession I
    if-lt v0, v4, +003h
    goto +3bh
    if-eqz v3, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->SilentRecovery Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->PromptEligible Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    move-object v3, v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getAttempts()I
    move-result v0
    add-int/2addr v0, v2
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setAttempts(I)V
    iget-object v11, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v12, 0
    sget-object v13, Lkotlinx/coroutines/CoroutineStart;->LAZY Lkotlinx/coroutines/CoroutineStart;
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;
    const/4 v6, 0
    move-object v1, v0
    move-object/from16 v2, v19
    move-object v4, v8
    move-object v5, v10
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry; Lkotlin/coroutines/Continuation;)V
    move-object v14, v0
    check-cast v14, Lkotlin/jvm/functions/Function2;
    const/4 v15, 1
    const/16 v16, 0
    invoke-static/range v11 ... v16, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v0
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPreparation(Lkotlinx/coroutines/Deferred;)V
    new-instance v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;
    invoke-direct v1, v7, v8, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession; Lkotlinx/coroutines/Deferred;)V
    invoke-interface v0, v1, Lkotlinx/coroutines/Deferred;->invokeOnCompletion(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;
    invoke-interface v0, Lkotlinx/coroutines/Deferred;->start()Z
    monitor-exit v9
    return-object v0
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setTerminal(Z)V
    monitor-exit v9
    return-object v1
    move-exception v0
    monitor-exit v9
    throw v0
    :try_start_0x12
    :try_start_0x64
    :try_start_0x79
    :try_start_0x8c
    :try_start_0xa3
    :try_start_0xc0
    :try_start_0xce
    :try_start_0xd9
    :try_start_0x122
.end method

.method private static final startPreparationIfNeeded$lambda$17$lambda$16(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine  com.bytedance.trae.conversation.billing.BillingUpgradePromptSession  kotlinx.coroutines.Deferred  java.lang.Throwable)kotlin.Unit
    .registers 4
    # ins_size=4
    iget-object v3, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    monitor-enter v3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getKey()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    if-eqz v0, +015h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPreparation()Lkotlinx/coroutines/Deferred;
    move-result-object v1
    if-ne v1, v2, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    const/4 v2, 0
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +005h
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPreparation(Lkotlinx/coroutines/Deferred;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v3
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    monitor-exit v3
    throw v0
    :try_start_0x3
.end method

.method public final awaitReady(long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=4
    instance-of v0, v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;
    if-eqz v0, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;->label I
    sub-int/2addr v10, v2
    iput v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;
    invoke-direct v0, v7, v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lkotlin/coroutines/Continuation;)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +010h
    if-ne v2, v4, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v9, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v9, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const-wide/16 v5, 0
    cmp-long v10, v8, v5
    if-gtz v10, +00eh
    invoke-direct v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->startPreparationIfNeeded()Lkotlinx/coroutines/Deferred;
    move-result-object v8
    if-nez v8, +003h
    move v3, v4
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    return-object v8
    new-instance v10, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;
    const/4 v2, 0
    invoke-direct v10, v7, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$2;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    iput v4, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$awaitReady$1;->label I
    invoke-static v8, v9, v10, v0, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Ljava/lang/Boolean;
    if-eqz v10, +006h
    invoke-virtual v10, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    return-object v8
.end method

.method public final candidateState(java.lang.String)com.bytedance.trae.conversation.billing.BillingUpgradeCandidateState
    .registers 7
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->currentSession Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;->getUserId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-static v0, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +007h
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;
    return-object v6
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->shownKey(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    monitor-enter v1
    iget-object v2, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-interface v2, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPromptShownInProcess()Z
    move-result v3
    const/4 v4, 1
    if-ne v3, v4, +003h
    move v2, v4
    if-nez v2, +036h
    iget-object v2, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->hasShown Lkotlin/jvm/functions/Function1;
    invoke-interface v2, v6, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Boolean;
    invoke-virtual v6, Ljava/lang/Boolean;->booleanValue()Z
    move-result v6
    if-eqz v6, +003h
    goto +26h
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPendingPromptData()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-result-object v6
    if-eqz v6, +00bh
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Eligible;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Eligible;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;
    monitor-exit v1
    return-object v0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getTerminal()Z
    move-result v6
    if-nez v6, +003h
    goto +6h
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;
    goto +5h
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Preparing;
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;
    monitor-exit v1
    return-object v6
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;
    check-cast v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;
    monitor-exit v1
    return-object v6
    move-exception v6
    monitor-exit v1
    throw v6
    :try_start_0x2a
    :try_start_0x61
    :try_start_0x73
.end method

.method public final markShown(java.lang.String)void
    .registers 15
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v0, v14, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->shownKey(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v13, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    monitor-enter v1
    iget-object v2, v13, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-interface v2, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +014h
    new-instance v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 63
    const/4 v12, 0
    move-object v4, v3
    invoke-direct/range v4 ... v12, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;-><init>(I Z Z Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; Lkotlinx/coroutines/Deferred; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v0, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    const/4 v2, 1
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPromptShownInProcess(Z)V
    const/4 v2, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    check-cast v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    monitor-exit v1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->clearPending Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v14, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v14, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v14
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v14, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v14
    invoke-static v14, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    move-exception v14
    monitor-exit v1
    throw v14
    :try_start_0xf
    :try_start_0x37
.end method

.method public final pendingPromptData(java.lang.String)com.bytedance.trae.conversation.billing.BillingUpgradePromptData
    .registers 6
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->shownKey(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    monitor-enter v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-interface v2, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    const/4 v2, 0
    if-nez v0, +004h
    monitor-exit v1
    return-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPromptShownInProcess()Z
    move-result v3
    if-nez v3, +017h
    iget-object v3, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->hasShown Lkotlin/jvm/functions/Function1;
    invoke-interface v3, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-eqz v5, +003h
    goto +7h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->getPendingPromptData()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-result-object v5
    monitor-exit v1
    return-object v5
    const/4 v5, 1
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPromptShownInProcess(Z)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->setPendingPromptData(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    monitor-exit v1
    return-object v2
    move-exception v5
    monitor-exit v1
    throw v5
    :try_start_0xf
    :try_start_0x1c
    :try_start_0x38
.end method

.method public final prewarm()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->startPreparationIfNeeded()Lkotlinx/coroutines/Deferred;
    return-void 
.end method

.method public final reset()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->lock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->entries Ljava/util/Map;
    invoke-interface v1, Ljava/util/Map;->clear()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method
