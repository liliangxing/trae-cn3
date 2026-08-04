# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "BrainstormActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;
.field private static final DEBUG_ALWAYS_SHOW_INTRO:Z
.field public static final EXTRA_ATTACHMENT_SUBTASK_ENABLED:Ljava/lang/String;
.field public static final EXTRA_ATTEMPT_ACTIVITY_LAUNCH_REQUESTED_MS:Ljava/lang/String;
.field public static final EXTRA_ATTEMPT_CLICK_MS:Ljava/lang/String;
.field public static final EXTRA_ATTEMPT_ELIGIBILITY_PASSED_MS:Ljava/lang/String;
.field public static final EXTRA_ATTEMPT_ID:Ljava/lang/String;
.field public static final EXTRA_ATTEMPT_START_ELAPSED_MS:Ljava/lang/String;
.field public static final EXTRA_CLI_CONVERSATION_ID:Ljava/lang/String;
.field public static final EXTRA_CLI_ID:Ljava/lang/String;
.field public static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field public static final EXTRA_CREATE_REMOTE_PARENT_SESSION:Ljava/lang/String;
.field public static final EXTRA_MESSAGES_TEXT:Ljava/lang/String;
.field public static final EXTRA_MIC_CHECK_END_MS:Ljava/lang/String;
.field public static final EXTRA_MIC_CHECK_START_MS:Ljava/lang/String;
.field public static final EXTRA_MINIMIZE_DISABLED:Ljava/lang/String;
.field public static final EXTRA_MODE:Ljava/lang/String;
.field public static final EXTRA_PARENT_AGENT_TYPE:Ljava/lang/String;
.field public static final EXTRA_PARENT_CONVERSATION_ID:Ljava/lang/String;
.field public static final EXTRA_RESTORE_FROM_HOLDER:Ljava/lang/String;
.field public static final EXTRA_SOURCE_BRANCH_NAME:Ljava/lang/String;
.field public static final EXTRA_SOURCE_REPO_NAME:Ljava/lang/String;
.field public static final EXTRA_SOURCE_REPO_URL:Ljava/lang/String;
.field public static final EXTRA_WORKSPACE_DIR:Ljava/lang/String;
.field private static final KEY_HAS_SEEN_INTRO:Ljava/lang/String;
.field private static final SOURCE_TYPE_GITHUB:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private isMinimizeDisabled:Z
.field private isRestoredFromMinimized:Z
.field private pendingAutoStartAfterPermission:Z
.field private final permissionLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private viewModel:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method public static synthetic $r8$lambda$BiVLqO-z42efLJ2YEmTY_ad_UK4(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->requestRequiredPermissions$lambda$13(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$HIvs1cam3hZI5Moo1kn2fwvNz_E(com.bytedance.trae.conversation.brainstorm.BrainstormActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->showExitConfirmDialog$lambda$15(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$JLkdE7-RrGMdseVIcp4h9r7NvN0(com.bytedance.trae.conversation.brainstorm.BrainstormActivity  java.util.Map)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->permissionLauncher$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity; Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$iT8Fpem1vYyb36vulDmULl9Zfbo(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->requestRequiredPermissions$lambda$14(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)V
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->permissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$getViewModel$p(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)com.bytedance.trae.conversation.brainstorm.BrainstormViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    return-object v0
.end method

.method public static com_bytedance_trae_conversation_brainstorm_BrainstormActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->com_bytedance_trae_conversation_brainstorm_BrainstormActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private final hasRequiredPermissions()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;
    move-object v1, v2
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->getUngrantedPermissions(Landroid/content/Context;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    return v0
.end method

.method private final observeBrainstormEnded()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeMinimizeRequested()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeMinimizeRequested$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeMinimizeRequested$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observePhaseNavigation()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final permissionLauncher$lambda$0(com.bytedance.trae.conversation.brainstorm.BrainstormActivity  java.util.Map)void
    .registers 10
    # ins_size=2
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v9, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v9
    invoke-interface v9, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +039h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "Permission result: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, " = "
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "BrainstormActivity"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto -3ch
    invoke-direct v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->hasRequiredPermissions()Z
    move-result v9
    const/4 v0, 0
    const-string/jumbo v1, viewModel
    if-eqz v9, +014h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v9, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v9
    sget-object v9, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->PERMISSION_GRANTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    invoke-direct v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->startPendingDiscussionIfNeeded()V
    goto +41h
    iget-boolean v9, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->pendingAutoStartAfterPermission Z
    if-eqz v9, +02bh
    iget-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v9, +007h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    goto +2h
    move-object v2, v9
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    const v9, 16908290
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Landroid/view/ViewGroup;
    if-nez v8, +003h
    return-void 
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MicPermissionDeniedRuntime;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MicPermissionDeniedRuntime;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    invoke-virtual v9, v8, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->enqueue(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)V
    goto +14h
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v8, +007h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    goto +2h
    move-object v2, v8
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    return-void 
.end method

.method private final requestRequiredPermissions()void
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;
    move-object v1, v5
    check-cast v1, Landroid/content/Context;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->permissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda2;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)V
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda3;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)V
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->requestPermissions(Landroid/content/Context; Landroidx/activity/result/ActivityResultLauncher; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final requestRequiredPermissions$lambda$13(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->PERMISSION_GRANTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->startPendingDiscussionIfNeeded()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final requestRequiredPermissions$lambda$14(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)kotlin.Unit
    .registers 7
    # ins_size=1
    iget-object v6, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v6, +009h
    const-string/jumbo v6, viewModel
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v6, 0
    move-object v0, v6
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private final setupBackHandler()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    move-object v1, v3
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)V
    check-cast v2, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v0, v1, v2, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method private static final showExitConfirmDialog$lambda$15(com.bytedance.trae.conversation.brainstorm.BrainstormActivity  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=2
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const/4 v0, 2
    const-string v1, "exit_discussion_click"
    const/4 v2, 0
    invoke-static v4, v1, v2, v0, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    move-object v0, v3
    check-cast v0, Landroid/content/Context;
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playEndDismiss(Landroid/content/Context;)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v3, +009h
    const-string/jumbo v3, viewModel
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    const/4 v3, 1
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->endBrainstorm(Z)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final startPendingDiscussionIfNeeded()void
    .registers 5
    # ins_size=1
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->pendingAutoStartAfterPermission Z
    if-nez v0, +003h
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getPhase()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    if-eq v0, v3, +003h
    return-void 
    const/4 v0, 0
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->pendingAutoStartAfterPermission Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startBrainstorm()V
    return-void 
.end method

.method public com_bytedance_trae_conversation_brainstorm_BrainstormActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public final isMinimizeDisabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->isMinimizeDisabled Z
    return v0
.end method

.method public final isRestoredFromMinimized()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->isRestoredFromMinimized Z
    return v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 39
    # ins_size=2
    move-object/from16 v1, v37
    invoke-super/range v37 ... v38, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v2, "extra_session_id"
    invoke-virtual v0, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v2, "extra_parent_conversation_id"
    invoke-virtual v0, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const/4 v2, 1
    if-eqz v0, +00eh
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +004h
    move-object v6, v0
    goto +2h
    const/4 v6, 0
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_create_remote_parent_session"
    const/4 v4, 0
    invoke-virtual v0, v3, v4, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v7
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_mic_check_start_ms"
    const-wide/16 v8, 0
    invoke-virtual v0, v3, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v13
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_mic_check_end_ms"
    invoke-virtual v0, v3, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v11
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_voice_discussion_attempt_id"
    invoke-virtual v0, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    move-object/from16 v17, v0
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_voice_discussion_attempt_start_elapsed_ms"
    invoke-virtual v0, v3, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v18
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_voice_discussion_attempt_click_ms"
    const-wide/16 v8, -1
    invoke-virtual v0, v3, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v21
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_voice_discussion_attempt_eligibility_passed_ms"
    invoke-virtual v0, v3, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v23
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_voice_discussion_attempt_activity_launch_requested_ms"
    invoke-virtual v0, v3, v8, v9, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v25
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_attachment_sub_task_enabled"
    invoke-virtual v0, v3, v2, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v16
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_restore_from_holder"
    invoke-virtual v0, v3, v4, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +00ch
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMinimized()Z
    move-result v0
    if-eqz v0, +004h
    move v0, v2
    goto +2h
    move v0, v4
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v8, "extra_minimize_disabled"
    invoke-virtual v3, v8, v4, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v3
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->isMinimizeDisabled Z
    sget v3, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_brainstorm I
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->setContentView(I)V
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getWindow()Landroid/view/Window;
    move-result-object v3
    const/16 v8, 128
    invoke-virtual v3, v8, Landroid/view/Window;->addFlags(I)V
    new-instance v3, Landroidx/lifecycle/ViewModelProvider;
    move-object v8, v1
    check-cast v8, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v3, v8, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v3, v8, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string/jumbo v27, viewModel
    if-eqz v0, +01ch
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v3, +006h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->restoreToViewModel$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Z
    move-result v4
    if-nez v4, +00ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "BrainstormActivity"
    const-string/jumbo v8, wantRestore but holder.restoreToViewModel returned false; fallback to fresh start
    invoke-virtual v0, v3, v8, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    move v10, v4
    iput-boolean v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->isRestoredFromMinimized Z
    if-nez v10, +1fch
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_sub_task_cli_id"
    invoke-virtual v0, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00eh
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +004h
    move-object v8, v0
    goto +2h
    const/4 v8, 0
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_sub_task_cli_type"
    invoke-virtual v0, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +027h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-static v0, Lcom/bytedance/trae/im/service/CliType;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/im/service/CliType;
    if-eqz v0, +003h
    goto +3h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object v9, v0
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_sub_task_mode"
    invoke-virtual v0, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +02ch
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +015h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object/from16 v20, v4
    check-cast v20, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual/range v20, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v15
    if-eqz v15, -016h
    goto +2h
    const/4 v4, 0
    check-cast v4, Lcom/bytedance/trae/im/service/Mode;
    if-eqz v4, +004h
    move-object v0, v4
    goto +3h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v4, "extra_sub_task_parent_agent_type"
    invoke-virtual v3, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00eh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +004h
    move-object v15, v3
    goto +2h
    const/4 v15, 0
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v4, "extra_sub_task_workspace_dir"
    invoke-virtual v3, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00fh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +005h
    move-object/from16 v20, v3
    goto +3h
    const/16 v20, 0
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;->hasSeenIntro$conversation_mainlandRelease()Z
    move-result v28
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v9, v3, +065h
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v0, v3, +061h
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v4, "extra_source_repo_url"
    invoke-virtual v3, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00dh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +003h
    goto +2h
    const/4 v3, 0
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    const-string v2, "extra_source_branch_name"
    invoke-virtual v4, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +010h
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    const/16 v29, 1
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v3, +02ch
    if-eqz v2, +02ah
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    move/from16 v30, v10
    const-string v10, "extra_source_repo_name"
    invoke-virtual v4, v10, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +010h
    move-object v10, v4
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v10
    const/16 v29, 1
    xor-int/lit8 v10, v10, 1
    if-eqz v10, +003h
    goto +2h
    const/4 v4, 0
    new-instance v10, Lcom/bytedance/trae/im/service/Source;
    move-wide/from16 v31, v11
    const-string v11, "github"
    invoke-direct v10, v3, v4, v2, v11, Lcom/bytedance/trae/im/service/Source;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object v2, v10
    goto +6h
    move/from16 v30, v10
    move-wide/from16 v31, v11
    const/4 v2, 0
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v3, +006h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    move-object v4, v1
    check-cast v4, Landroid/content/Context;
    move/from16 v29, v30
    move-object v10, v0
    move-wide/from16 v33, v31
    move-object v11, v15
    move-object/from16 v12, v20
    move-wide v14, v13
    move-object v13, v2
    move-wide/from16 v35, v14
    move/from16 v14, v16
    invoke-virtual/range v3 ... v14, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->initVoiceSession(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Source; Z)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +008h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/16 v16, 0
    goto +3h
    move-object/from16 v16, v0
    move/from16 v20, v28
    invoke-virtual/range v16 ... v26, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->initVoiceAttempt(Ljava/lang/String; J Z J J J)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +006h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    invoke-direct/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->hasRequiredPermissions()Z
    move-result v0
    if-eqz v0, +010h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +006h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->PERMISSION_GRANTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    goto +14h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +007h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    goto +2h
    move-object v2, v0
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +00bh
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-wide/from16 v4, v33
    move-wide/from16 v2, v35
    const/4 v0, 0
    goto +5h
    move-wide/from16 v4, v33
    move-wide/from16 v2, v35
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->setPerfMicCheckTimestamps(J J)V
    if-nez v38, +05ch
    if-eqz v28, +030h
    invoke-direct/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->hasRequiredPermissions()Z
    move-result v0
    xor-int/lit8 v2, v0, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->pendingAutoStartAfterPermission Z
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$id;->brainstorm_fragment_container I
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;-><init>()V
    check-cast v4, Landroidx/fragment/app/Fragment;
    invoke-virtual v2, v3, v4, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentTransaction;->commitNow()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v2, +007h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    goto +2h
    move-object v15, v2
    invoke-virtual v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->skipIntroAndStartBrainstorm(Z)V
    goto +2bh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +007h
    invoke-static/range v27, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    goto +2h
    move-object v15, v0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->INTRO_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    invoke-virtual/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$id;->brainstorm_fragment_container I
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;-><init>()V
    check-cast v3, Landroidx/fragment/app/Fragment;
    invoke-virtual v0, v2, v3, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitNow()V
    goto +3h
    move/from16 v29, v10
    invoke-direct/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->requestRequiredPermissions()V
    invoke-direct/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->observePhaseNavigation()V
    invoke-direct/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->observeBrainstormEnded()V
    invoke-direct/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->observeMinimizeRequested()V
    invoke-direct/range v37, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->setupBackHandler()V
    if-nez v29, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->markActiveForeground()V
    return-void 
    :try_start_0x11a
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->clearAll()V
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onResume()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onResume()V
    const v0, 16908290
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/view/ViewGroup;
    if-eqz v0, +009h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->APP_RESUMED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->checkAndToast(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->onHostResumed()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->com_bytedance_trae_conversation_brainstorm_BrainstormActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)V
    return-void 
.end method

.method public final requestVoicePermissions()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->requestRequiredPermissions()V
    return-void 
.end method

.method public final showExitConfirmDialog()void
    .registers 29
    # ins_size=1
    move-object/from16 v0, v28
    new-instance v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_exit_confirm_title I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    move-object v5, v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_exit_confirm_message I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getString(I)Ljava/lang/String;
    move-result-object v6
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_exit_confirm_discard I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    move-object v10, v3
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_exit_confirm_continue I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    move-object v9, v3
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v4, v3
    const/4 v7, 0
    const/4 v8, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda1;
    move-object/from16 v24, v7
    invoke-direct v7, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)V
    const/16 v25, 0
    const v26, 1572812
    const/16 v27, 0
    const/4 v7, 0
    invoke-direct/range v4 ... v27, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method
