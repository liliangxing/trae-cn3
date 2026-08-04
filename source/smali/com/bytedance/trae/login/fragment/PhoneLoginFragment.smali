# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
.super Lcom/bytedance/trae/common/fragment/TraceFragment;
.source "PhoneLoginFragment.kt"

.field public static final Companion:Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$Companion;
.field private static final TAG:Ljava/lang/String;
.field private _binding:Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
.field private isAgreementChecked:Z
.field private final viewModel$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$16HS302LJ8Qke--pPNlvs1NnsUk(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews$lambda$8(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$AVwwpRdfL3eKf1_iWrZzCEZlJEU(com.bytedance.trae.login.fragment.PhoneLoginFragment  java.lang.Boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->observeViewModel$lambda$9(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$FLWB1KhTyWHyDTX-iSBs2Ugu6hU(java.lang.CharSequence  int  int  android.text.Spanned  int  int)java.lang.CharSequence
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews$lambda$4(Ljava/lang/CharSequence; I I Landroid/text/Spanned; I I)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$GJ7csDb4trAy7OBVXcMWJ9I255o()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews$lambda$8$lambda$7()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$HPsDARvq1rN97JL73aX3VDApi5E(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews$lambda$3(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ROL7Wb4cJAJ8XpSj8LUM5nrDc3k(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.widget.EditText)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->onViewCreated$lambda$1$lambda$0(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Landroid/widget/EditText;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$TZWS7hVY4eBw3YCvYkw6DTgouhs(com.bytedance.trae.login.fragment.PhoneLoginFragment  com.bytedance.trae.login.fragment.PhoneLoginViewModel$SendCodeState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->observeViewModel$lambda$10(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gJIPqsOMa7X83q_9NgnGEseng0k(com.bytedance.trae.login.fragment.PhoneLoginFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews$lambda$8$lambda$6(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mqtY7XsEMG5awiIu-e_vIqNZsrU(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews$lambda$2(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$tjBYebbU11BjV0K_vI4h93dBKYs(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews$lambda$5(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->Companion Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/common/fragment/TraceFragment;-><init>()V
    move-object v0, v5
    check-cast v0, Landroidx/fragment/app/Fragment;
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$special$$inlined$viewModels$default$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$special$$inlined$viewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    const-class v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    invoke-static v2, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$special$$inlined$viewModels$default$2;
    invoke-direct v3, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$special$$inlined$viewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    new-instance v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$special$$inlined$viewModels$default$3;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/fragment/app/Fragment;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-static v0, v2, v3, v4, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment; Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->viewModel$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getViewModel(com.bytedance.trae.login.fragment.PhoneLoginFragment)com.bytedance.trae.login.fragment.PhoneLoginViewModel
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$openUrl(com.bytedance.trae.login.fragment.PhoneLoginFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->openUrl(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$updateClearButtonVisibility(com.bytedance.trae.login.fragment.PhoneLoginFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->updateClearButtonVisibility(Ljava/lang/String;)V
    return-void 
.end method

.method private final doSendCode()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const-string/jumbo v1, phone
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginClick(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v2, +005h
    check-cast v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->notifyLoginClicked(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->sendVerificationCode()V
    return-void 
.end method

.method private final getBinding()com.bytedance.trae.login.databinding.TraeFragmentLoginPhoneBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    return-object v0
.end method

.method private final getViewModel()com.bytedance.trae.login.fragment.PhoneLoginViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->viewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    return-object v0
.end method

.method private final observeViewModel()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->isButtonEnabled()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda8;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    new-instance v3, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->getSendCodeState()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda9;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    new-instance v3, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method private static final observeViewModel$lambda$10(com.bytedance.trae.login.fragment.PhoneLoginFragment  com.bytedance.trae.login.fragment.PhoneLoginViewModel$SendCodeState)kotlin.Unit
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Loading;
    const-string v1, ""
    const/4 v2, 0
    if-eqz v0, +02dh
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v6
    if-eqz v6, +009h
    iget-object v6, v6, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v6, +005h
    invoke-virtual v6, v2, Landroid/widget/Button;->setEnabled(Z)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v6
    if-eqz v6, +00bh
    iget-object v6, v6, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v6, +007h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v6, v1, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v5
    if-eqz v5, +0d4h
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v5, +0d0h
    invoke-virtual v5, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    goto/16 +0cbh
    instance-of v0, v6, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Success;
    const/16 v3, 8
    const/4 v4, 1
    if-eqz v0, +071h
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v6
    if-eqz v6, +009h
    iget-object v6, v6, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v6, +005h
    invoke-virtual v6, v4, Landroid/widget/Button;->setEnabled(Z)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v6
    if-eqz v6, +011h
    iget-object v6, v6, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v6, +00dh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_get_code I
    invoke-virtual v5, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v6, v0, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v6
    if-eqz v6, +009h
    iget-object v6, v6, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v6, +005h
    invoke-virtual v6, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v6
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_send_success I
    invoke-static v6, v0, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v6
    invoke-virtual v6, Landroid/widget/Toast;->show()V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->getPhoneNumber()Landroidx/lifecycle/LiveData;
    move-result-object v6
    invoke-virtual v6, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    if-nez v6, +003h
    goto +2h
    move-object v1, v6
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v6
    instance-of v0, v6, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v0, +005h
    check-cast v6, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v6, 0
    if-eqz v6, +005h
    invoke-virtual v6, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->notifyVerifyCodeNavigation()V
    sget-object v6, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->Companion Lcom/bytedance/trae/login/activity/VerifyCodeActivity$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v5
    const-string/jumbo v0, requireContext(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v5, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String;)V
    goto +54h
    instance-of v0, v6, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Error;
    if-eqz v0, +054h
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v0, +005h
    invoke-virtual v0, v4, Landroid/widget/Button;->setEnabled(Z)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +011h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v0, +00dh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_get_code I
    invoke-virtual v5, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    check-cast v6, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Error;
    invoke-virtual v6, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Error;->getErrorMessage()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +00dh
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_send_failed I
    invoke-virtual v5, v6, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v6
    const-string v5, "getString(...)"
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v0, v6, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
.end method

.method private static final observeViewModel$lambda$9(com.bytedance.trae.login.fragment.PhoneLoginFragment  java.lang.Boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +010h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v0, +00ch
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/Button;->setEnabled(Z)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$1$lambda$0(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.widget.EditText)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string v0, "input_method"
    invoke-virtual v1, v0, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    const-string/jumbo v0, null cannot be cast to non-null type android.view.inputmethod.InputMethodManager
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/view/inputmethod/InputMethodManager;
    check-cast v2, Landroid/view/View;
    const/4 v0, 1
    invoke-virtual v1, v2, v0, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method private final openUrl(java.lang.String)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;->INSTANCE Lcom/bytedance/trae/utils/AgreementUrlOpener;
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v2, requireContext(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/AgreementUrlOpener;->open(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
    :try_start_0x0
.end method

.method private final setupViews()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnBack Landroid/widget/ImageView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda2;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +00bh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->cbAgreement Landroid/widget/CheckBox;
    if-eqz v0, +007h
    iget-boolean v1, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->isAgreementChecked Z
    invoke-virtual v0, v1, Landroid/widget/CheckBox;->setChecked(Z)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->cbAgreement Landroid/widget/CheckBox;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda3;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    invoke-virtual v0, v1, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->login_agreement I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v1
    if-eqz v1, +009h
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->privacyPolicyText Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setUrlSpannedText(Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +010h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->privacyPolicyText Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    if-eqz v0, +00ch
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$3;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$3;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    check-cast v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setOnClickListener(Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +011h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v0, +00dh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_get_code I
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/Button;->setEnabled(Z)V
    new-instance v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda4;-><init>()V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v2
    if-eqz v2, +018h
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->etPhone Landroid/widget/EditText;
    if-eqz v2, +014h
    const/4 v3, 2
    new-array v3, v3, [Landroid/text/InputFilter;
    aput-object v0, v3, v1
    new-instance v0, Landroid/text/InputFilter$LengthFilter;
    const/16 v1, 11
    invoke-direct v0, v1, Landroid/text/InputFilter$LengthFilter;-><init>(I)V
    const/4 v1, 1
    aput-object v0, v3, v1
    invoke-virtual v2, v3, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +010h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->etPhone Landroid/widget/EditText;
    if-eqz v0, +00ch
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$4;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$4;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->ivClear Landroid/widget/ImageView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda5;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda6;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    invoke-virtual v0, v1, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupViews$lambda$2(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    return-void 
.end method

.method private static final setupViews$lambda$3(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    iput-boolean v2, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->isAgreementChecked Z
    return-void 
.end method

.method private static final setupViews$lambda$4(java.lang.CharSequence  int  int  android.text.Spanned  int  int)java.lang.CharSequence
    .registers 6
    # ins_size=6
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    move v4, v1
    if-ge v4, v2, +016h
    invoke-interface v0, v4, Ljava/lang/CharSequence;->charAt(I)C
    move-result v5
    invoke-static v5, Ljava/lang/Character;->isDigit(C)Z
    move-result v5
    if-eqz v5, +009h
    invoke-interface v0, v4, Ljava/lang/CharSequence;->charAt(I)C
    move-result v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    add-int/lit8 v4, v4, 1
    goto -15h
    invoke-virtual v3, Ljava/lang/StringBuilder;->length()I
    move-result v0
    sub-int/2addr v2, v1
    if-ne v0, v2, +004h
    const/4 v0, 0
    goto +7h
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    return-object v0
.end method

.method private static final setupViews$lambda$5(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +00fh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->etPhone Landroid/widget/EditText;
    if-eqz v0, +00bh
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Landroid/text/Editable;->clear()V
    return-void 
.end method

.method private static final setupViews$lambda$8(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.view.View)void
    .registers 16
    # ins_size=2
    iget-boolean v15, v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->isAgreementChecked Z
    if-nez v15, +035h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "agreement_dialog_shown"
    const-string/jumbo v2, phone
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2044
    const/4 v13, 0
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    new-instance v15, Lcom/bytedance/trae/login/activity/AgreementDialog;
    invoke-virtual v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)V
    new-instance v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda1;
    invoke-direct v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda1;-><init>()V
    invoke-direct v15, v0, v1, v14, Lcom/bytedance/trae/login/activity/AgreementDialog;-><init>(Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v15, Lcom/bytedance/trae/login/activity/AgreementDialog;->show()V
    return-void 
    invoke-direct v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->doSendCode()V
    return-void 
.end method

.method private static final setupViews$lambda$8$lambda$6(com.bytedance.trae.login.fragment.PhoneLoginFragment)kotlin.Unit
    .registers 15
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "agreement_accepted"
    const-string/jumbo v2, phone
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2044
    const/4 v13, 0
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    const/4 v0, 1
    iput-boolean v0, v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->isAgreementChecked Z
    invoke-direct v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v1
    if-eqz v1, +009h
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->cbAgreement Landroid/widget/CheckBox;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/widget/CheckBox;->setChecked(Z)V
    invoke-direct v14, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->doSendCode()V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method

.method private static final setupViews$lambda$8$lambda$7()kotlin.Unit
    .registers 14
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "agreement_rejected"
    const-string/jumbo v2, phone
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2044
    const/4 v13, 0
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final updateClearButtonVisibility(java.lang.String)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v0
    if-eqz v0, +01ah
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->ivClear Landroid/widget/ImageView;
    if-eqz v0, +016h
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v1, 0
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    move v3, v1
    if-eqz v3, +003h
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
.end method

.method public autoLogEnterPage()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 4
    # ins_size=4
    const-string v3, "inflater"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v2, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->getRoot()Landroid/widget/ScrollView;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/fragment/TraceFragment;->onDestroyView()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/bytedance/trae/common/fragment/TraceFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v3, +005h
    check-cast v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isPhoneLoginAgreementChecked()Z
    move-result v2
    goto +2h
    const/4 v2, 0
    iput-boolean v2, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->isAgreementChecked Z
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->setupViews()V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->observeViewModel()V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v2
    if-eqz v2, +011h
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->etPhone Landroid/widget/EditText;
    if-eqz v2, +00dh
    invoke-virtual v2, Landroid/widget/EditText;->requestFocus()Z
    new-instance v3, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda7;
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Landroid/widget/EditText;)V
    invoke-virtual v2, v3, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method
