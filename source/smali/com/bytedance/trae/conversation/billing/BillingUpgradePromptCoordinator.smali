# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
.super Ljava/lang/Object;
.source "BillingUpgradePromptCoordinator.kt"

.field public static final CONVERSATION_PROMPT_MAX_WAIT_MS:J
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
.field public static final NAVIGATION_MAX_WAIT_MS:J
.field private static final TAG:Ljava/lang/String;
.field private static final engine:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;


.method static constructor <clinit>()void
    .registers 13
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    new-instance v12, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v1, v2, v1, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v1, v2, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    new-instance v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$1;-><init>(Ljava/lang/Object;)V
    move-object v3, v1
    check-cast v3, Lkotlin/jvm/functions/Function0;
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$2;
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$2;-><init>(Ljava/lang/Object;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function1;
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$3;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->INSTANCE Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$3;-><init>(Ljava/lang/Object;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$4;
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$4;-><init>(Ljava/lang/Object;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function1;
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$5;
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$5;-><init>(Ljava/lang/Object;)V
    move-object v7, v0
    check-cast v7, Lkotlin/jvm/functions/Function2;
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$6;
    sget-object v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$engine$6;-><init>(Ljava/lang/Object;)V
    move-object v8, v0
    check-cast v8, Lkotlin/jvm/functions/Function1;
    const/4 v9, 0
    const/16 v10, 128
    const/4 v11, 0
    move-object v1, v12
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;-><init>(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v12, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->engine Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$currentSession(com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator)com.bytedance.trae.conversation.billing.BillingUpgradePromptSession
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->currentSession()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic awaitReady$default(com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator  long  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 1
    if-eqz v4, +004h
    const-wide/16 v1, 5000
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->awaitReady(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final currentSession()com.bytedance.trae.conversation.billing.BillingUpgradePromptSession
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-direct v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->currentUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;
    const/4 v3, 2
    invoke-direct v2, v0, v1, v3, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;-><init>(Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v2
.end method

.method private final currentUserId()java.lang.String
    .registers 4
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +024h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +01eh
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0x1
.end method

.method private final hasPrompt(androidx.fragment.app.FragmentActivity  java.lang.String)boolean
    .registers 3
    # ins_size=3
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, v2, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v1
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final isHostReady(androidx.fragment.app.FragmentActivity)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +024h
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->isDestroyed()Z
    move-result v0
    if-nez v0, +01eh
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v0
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->RESUMED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v0, v1, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v0
    if-eqz v0, +00eh
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v3
    if-nez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    return v3
.end method

.method private final recordShown(java.lang.String)void
    .registers 6
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->markShown(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +00bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "BillingUpgradePrompt"
    const-string v3, "persist billing upgrade prompt state failed"
    invoke-virtual v1, v2, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->engine Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->markShown(Ljava/lang/String;)V
    return-void 
    :try_start_0x0
.end method

.method public final awaitReady(long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->engine Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->awaitReady(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final candidateSnapshot$conversation_mainlandRelease()com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator$CandidateSnapshot
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    const/4 v1, 2
    const/4 v2, 0
    if-nez v0, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    sget-object v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    check-cast v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-direct v0, v3, v2, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    invoke-direct v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->currentUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    sget-object v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    check-cast v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-direct v0, v3, v2, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->engine Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->candidateState(Ljava/lang/String;)Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Preparing;
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    sget-object v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    check-cast v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-direct v0, v3, v2, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +30h
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    sget-object v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    check-cast v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-direct v0, v3, v2, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +1eh
    instance-of v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Eligible;
    if-eqz v1, +01ch
    new-instance v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    new-instance v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->getManagedCandidate$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)V
    check-cast v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Eligible;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Eligible;->getPromptData()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-result-object v0
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V
    move-object v0, v1
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method

.method public final clearCacheForDebug()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->clearAll()V
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->engine Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->reset()V
    return-void 
.end method

.method public final prewarm()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->engine Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->prewarm()V
    return-void 
.end method

.method public final showCandidate$conversation_mainlandRelease(androidx.fragment.app.FragmentActivity  java.lang.String  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome
    .registers 9
    # ins_size=4
    const-string v0, "activity"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "expectedUserId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "promptData"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->currentUserId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +09eh
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-nez v0, +004h
    goto/16 +094h
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;
    invoke-virtual v0, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;->hasShown(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +00ah
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->engine Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine;->markShown(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v6
    invoke-virtual v6, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "BillingUpgradePromptBottomSheet"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;
    if-eqz v2, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getOwnerUserId$conversation_mainlandRelease()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->recordShown(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->Shown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v6
    const-string v0, "DeviceFlowContainerBottomSheet"
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->hasPrompt(Landroidx/fragment/app/FragmentActivity; Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->TemporarilyBlocked Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->isHostReady(Landroidx/fragment/app/FragmentActivity;)Z
    move-result v0
    if-nez v0, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->TemporarilyBlocked Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v6
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->Companion Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;
    invoke-virtual v0, v7, v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;->newInstance(Ljava/lang/String; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;
    move-result-object v8
    invoke-virtual v6, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v8, v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->showNow(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->isAdded()Z
    move-result v0
    if-eqz v0, +012h
    invoke-virtual v6, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-ne v0, v8, +008h
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->recordShown(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->Shown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    goto +27h
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    goto +24h
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v3, "BillingUpgradePrompt"
    const-string/jumbo v4, show billing upgrade prompt failed
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->isAdded()Z
    move-result v0
    if-eqz v0, +012h
    invoke-virtual v6, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v6
    invoke-virtual v6, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v6
    if-ne v6, v8, +008h
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->recordShown(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->Shown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    goto +3h
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v6
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v6
    :try_start_0x71
.end method
