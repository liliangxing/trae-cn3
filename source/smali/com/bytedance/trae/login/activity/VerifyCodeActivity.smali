# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/VerifyCodeActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "VerifyCodeActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/login/activity/VerifyCodeActivity$Companion;
.field private static final EXTRA_PHONE_NUMBER:Ljava/lang/String;
.field private binding:Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
.field private final viewModel$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$4zr3KQu-qV9GpDMs7S76YrdSPs8(com.bytedance.trae.login.activity.VerifyCodeActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->setupViews$lambda$1(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$8_Be-Th8XvN8cK8OmGLZ4ymBJAo(com.bytedance.trae.login.activity.VerifyCodeActivity  com.bytedance.trae.login.fragment.VerifyCodeViewModel$ResendState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$12(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$At9jj_I-OU2MdpmrifrFB97JJiI(com.bytedance.trae.login.activity.VerifyCodeActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->setupViews$lambda$2(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$DWXPRBDpVL9IHYPQkJO1CKI3K0o(com.bytedance.trae.login.activity.VerifyCodeActivity  com.bytedance.trae.login.fragment.VerifyCodeViewModel$Event)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$5(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$GUkVeQag-KAXUmfG910iLbwVU-0(com.bytedance.trae.login.activity.VerifyCodeActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$3(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$JS9hTkuy4IOCHPKXnXuFymo4IMY(com.bytedance.trae.login.activity.VerifyCodeActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$11$lambda$10(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_eob7w2KnewzY64bFM1O_XTJC4E(com.bytedance.trae.login.activity.VerifyCodeActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->setupViews$lambda$0(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cX5YcGcKIEwFlhaiqm_mV0sCtHY(com.bytedance.trae.login.activity.VerifyCodeActivity  java.lang.Integer)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$6(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Ljava/lang/Integer;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$f30F9eYGC0_GzeXvwmQWny_2H4U(com.bytedance.trae.login.activity.VerifyCodeActivity  com.bytedance.trae.login.fragment.VerifyCodeViewModel$LoginState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$11(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jqcJLHILFnWFL5ORqS8RfrcIV1c(com.bytedance.trae.login.activity.VerifyCodeActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$11$lambda$8(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$x6VtGSxfRmyHkXXO5vkUz_rz6C4(com.bytedance.trae.login.activity.VerifyCodeActivity  java.lang.Boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel$lambda$7(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->Companion Lcom/bytedance/trae/login/activity/VerifyCodeActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    move-object v0, v5
    check-cast v0, Landroidx/activity/ComponentActivity;
    new-instance v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;
    const-class v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v3, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$2;
    invoke-direct v4, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-direct v2, v3, v4, v1, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    check-cast v2, Lkotlin/Lazy;
    iput-object v2, v5, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->viewModel$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getBinding$p(com.bytedance.trae.login.activity.VerifyCodeActivity)com.bytedance.trae.login.databinding.TraeActivityVerifyCodeBinding
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    return-object v0
.end method

.method public static final synthetic access$getViewModel(com.bytedance.trae.login.activity.VerifyCodeActivity)com.bytedance.trae.login.fragment.VerifyCodeViewModel
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    return-object v0
.end method

.method public static com_bytedance_trae_login_activity_VerifyCodeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.activity.VerifyCodeActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->com_bytedance_trae_login_activity_VerifyCodeActivity__onStop$___twin___()V
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

.method private final getViewModel()com.bytedance.trae.login.fragment.VerifyCodeViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->viewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    return-object v0
.end method

.method private final navigateToMainActivity()void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-string v2, "com.bytedance.trae.home.MainActivity"
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v1, 268468224
    invoke-virtual v0, v1, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    const-string v1, "from_login_success"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->finish()V
    return-void 
.end method

.method private final observeViewModel()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->getMaskedPhone()Landroidx/lifecycle/LiveData;
    move-result-object v0
    move-object v1, v4
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    new-instance v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda0;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->getClearInputEvent()Landroidx/lifecycle/LiveData;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda2;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->getCountdownSeconds()Landroidx/lifecycle/LiveData;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda3;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->isResendEnabled()Landroidx/lifecycle/LiveData;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda4;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->getLoginState()Landroidx/lifecycle/LiveData;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda5;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->getResendState()Landroidx/lifecycle/LiveData;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda6;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method private static final observeViewModel$lambda$11(com.bytedance.trae.login.activity.VerifyCodeActivity  com.bytedance.trae.login.fragment.VerifyCodeViewModel$LoginState)kotlin.Unit
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Idle;
    const/4 v1, 1
    const/16 v2, 8
    const/4 v3, 0
    const-string v4, "binding"
    if-eqz v0, +01fh
    iget-object v7, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v7, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    iget-object v7, v7, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v7, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v6, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v6, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v6
    iget-object v6, v3, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v6, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    goto/16 +0efh
    instance-of v0, v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Loading;
    const/4 v5, 0
    if-eqz v0, +01fh
    iget-object v7, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v7, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    iget-object v7, v7, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v7, v5, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v6, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v6, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v6
    iget-object v6, v3, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v6, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    goto/16 +0cdh
    instance-of v0, v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Success;
    if-eqz v0, +015h
    iget-object v7, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v7, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v7
    iget-object v7, v3, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v7, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->navigateToMainActivity()V
    goto/16 +0b6h
    instance-of v0, v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeletionPending;
    if-eqz v0, +032h
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    iget-object v0, v3, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    sget-object v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    move-object v1, v6
    check-cast v1, Landroid/app/Activity;
    check-cast v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeletionPending;
    invoke-virtual v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeletionPending;->getToken()Ljava/lang/String;
    move-result-object v7
    new-instance v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda10;
    invoke-direct v2, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    invoke-virtual v0, v1, v7, v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    goto/16 +082h
    instance-of v0, v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeviceOverLimit;
    if-eqz v0, +033h
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    iget-object v0, v3, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    move-object v1, v6
    check-cast v1, Landroid/app/Activity;
    check-cast v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeviceOverLimit;
    invoke-virtual v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeviceOverLimit;->getResult()Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    move-result-object v7
    sget-object v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->LOGIN Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda1;
    invoke-direct v3, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    invoke-virtual v0, v1, v7, v2, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    goto +4ch
    instance-of v0, v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;
    if-eqz v0, +04ch
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    iget-object v0, v3, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setError(Z)V
    move-object v0, v6
    check-cast v0, Landroid/content/Context;
    check-cast v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;
    invoke-virtual v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;->getErrorMessage()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +00dh
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_verify_code_login_failed I
    invoke-virtual v6, v7, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getString(I)Ljava/lang/String;
    move-result-object v7
    const-string v6, "getString(...)"
    invoke-static v7, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v0, v7, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v6
    invoke-virtual v6, Landroid/widget/Toast;->show()V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
.end method

.method private static final observeViewModel$lambda$11$lambda$10(com.bytedance.trae.login.activity.VerifyCodeActivity  boolean)void
    .registers 21
    # ins_size=2
    move-object/from16 v0, v19
    const/4 v1, 0
    if-eqz v20, +019h
    iget-object v2, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v2, +008h
    const-string v2, "binding"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v2, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct/range v19, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->onDeviceLimitLoginContinue()V
    goto +4dh
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, reason
    const-string v5, "device_over_limit"
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "login_platform"
    const-string/jumbo v5, phone
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v4, "icube_login_failure"
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v6, "login_failure"
    const-string/jumbo v7, phone
    const/4 v8, 0
    const-string/jumbo v9, user_logout_error
    const-string/jumbo v10, user_logout_device_is_little
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 2020
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit I
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v2, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final observeViewModel$lambda$11$lambda$8(com.bytedance.trae.login.activity.VerifyCodeActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->navigateToMainActivity()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final observeViewModel$lambda$12(com.bytedance.trae.login.activity.VerifyCodeActivity  com.bytedance.trae.login.fragment.VerifyCodeViewModel$ResendState)kotlin.Unit
    .registers 4
    # ins_size=2
    instance-of v0, v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Loading;
    if-nez v0, +04dh
    instance-of v0, v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Success;
    const/4 v1, 0
    if-eqz v0, +01eh
    iget-object v3, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v3, +008h
    const-string v3, "binding"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    iget-object v3, v3, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_send_success I
    invoke-static v2, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    goto +2bh
    instance-of v0, v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Error;
    if-eqz v0, +022h
    move-object v0, v2
    check-cast v0, Landroid/content/Context;
    check-cast v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Error;
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Error;->getErrorMessage()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_send_failed I
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v2, "getString(...)"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v0, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    goto +7h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final observeViewModel$lambda$3(com.bytedance.trae.login.activity.VerifyCodeActivity  java.lang.String)kotlin.Unit
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->tvSubtitle Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_verify_code_subtitle_prefix I
    invoke-virtual v4, v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    iget-object v4, v1, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->tvPhone Landroid/widget/TextView;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final observeViewModel$lambda$5(com.bytedance.trae.login.activity.VerifyCodeActivity  com.bytedance.trae.login.fragment.VerifyCodeViewModel$Event)kotlin.Unit
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;->getContentIfNotHandled()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lkotlin/Unit;
    if-eqz v4, +024h
    iget-object v4, v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    const/4 v0, 0
    const-string v1, "binding"
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    iget-object v4, v4, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string v2, ""
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v4, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    iget-object v3, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final observeViewModel$lambda$6(com.bytedance.trae.login.activity.VerifyCodeActivity  java.lang.Integer)kotlin.Unit
    .registers 6
    # ins_size=2
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v0
    const/4 v1, 0
    const-string v2, "binding"
    if-lez v0, +01fh
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_verify_code_resend_phone I
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/Object;
    const/4 v3, 0
    aput-object v5, v2, v3
    invoke-virtual v4, v1, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +17h
    iget-object v5, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    iget-object v5, v1, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_verify_code_resend_enabled I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v5, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final observeViewModel$lambda$7(com.bytedance.trae.login.activity.VerifyCodeActivity  java.lang.Boolean)kotlin.Unit
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/TextView;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-eqz v5, +005h
    sget v5, Lcom/bytedance/trae/login/R$color;->trae_login_enable I
    goto +3h
    sget v5, Lcom/bytedance/trae/login/R$color;->trae_login_disable I
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getColor(I)I
    move-result v4
    invoke-virtual v0, v4, Landroid/widget/TextView;->setTextColor(I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private final setupViews()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->ivBack Landroid/widget/ImageView;
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda7;
    invoke-direct v3, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda8;
    invoke-direct v3, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    invoke-virtual v0, v3, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    new-instance v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$setupViews$3;
    invoke-direct v3, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$setupViews$3;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    check-cast v3, Landroid/text/TextWatcher;
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    invoke-virtual v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    new-instance v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda9;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final setupViews$lambda$0(com.bytedance.trae.login.activity.VerifyCodeActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->finish()V
    return-void 
.end method

.method private static final setupViews$lambda$1(com.bytedance.trae.login.activity.VerifyCodeActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->resendCode()V
    return-void 
.end method

.method private static final setupViews$lambda$2(com.bytedance.trae.login.activity.VerifyCodeActivity)void
    .registers 4
    # ins_size=1
    const-string v0, "input_method"
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/view/inputmethod/InputMethodManager;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    move-object v0, v2
    if-eqz v0, +015h
    iget-object v3, v3, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v3, +008h
    const-string v3, "binding"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    iget-object v3, v2, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    check-cast v3, Landroid/view/View;
    const/4 v1, 1
    invoke-virtual v0, v3, v1, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method public com_bytedance_trae_login_activity_VerifyCodeActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getWindow()Landroid/view/Window;
    move-result-object v2
    const/4 v0, 5
    invoke-virtual v2, v0, Landroid/view/Window;->setSoftInputMode(I)V
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getLayoutInflater()Landroid/view/LayoutInflater;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    move-result-object v2
    const-string v0, "inflate(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    if-nez v2, +008h
    const-string v2, "binding"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v2
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->setContentView(Landroid/view/View;)V
    invoke-direct v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->setupViews()V
    invoke-direct v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->observeViewModel()V
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v0, "extra_phone_number"
    invoke-virtual v2, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    invoke-direct v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->getViewModel()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->init(Ljava/lang/String;)V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->com_bytedance_trae_login_activity_VerifyCodeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)V
    return-void 
.end method
