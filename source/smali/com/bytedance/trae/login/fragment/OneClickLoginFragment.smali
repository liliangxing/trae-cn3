# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
.super Lcom/bytedance/trae/common/fragment/TraceFragment;
.source "OneClickLoginFragment.kt"

.implements Lcom/bytedance/trae/login/fragment/BytecloudSsoHost;

.field private static final ARG_CARRIER:Ljava/lang/String;
.field private static final ARG_MASKED_PHONE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;
.field private static final URL_CARRIER_MOBILE:Ljava/lang/String;
.field private static final URL_CARRIER_TELECOM:Ljava/lang/String;
.field private static final URL_CARRIER_UNICOM:Ljava/lang/String;
.field private _binding:Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
.field private callback:Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;
.field private final viewModel$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$9iEPHh5x8Y9eXR_u1yw0RPFq0gY(kotlin.jvm.internal.Ref$BooleanRef  com.bytedance.trae.login.fragment.OneClickLoginFragment)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setupViews$lambda$6$lambda$4(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$E90a1V6jcRJeVY6wWkmcHSsbcsA(com.bytedance.trae.login.fragment.OneClickLoginFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setupViews$lambda$2(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Hykp1yDTLfw2_IvqKYFvEsyHHww(com.bytedance.trae.login.fragment.OneClickLoginFragment  com.bytedance.trae.login.fragment.OneClickLoginViewModel$LoginState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->observeViewModel$lambda$8(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$TvfBdGq5-Nq0NVRjsFGfZFcQba0(kotlin.jvm.internal.Ref$BooleanRef  com.bytedance.trae.login.fragment.OneClickLoginFragment  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setupViews$lambda$6(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cI_jKoECVOgEb2sge_SKV9wkqSw()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setupViews$lambda$6$lambda$5()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oeYIQFHo8AeIbyw4lmpO_wrEBaM(kotlin.jvm.internal.Ref$BooleanRef  com.bytedance.trae.login.fragment.OneClickLoginFragment  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setupViews$lambda$3(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qgv1-UZxorMQtVIaRzgFPizqRMA(com.bytedance.trae.login.fragment.OneClickLoginFragment  java.util.Map  androidx.fragment.app.FragmentActivity  boolean)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyDeviceOffline$lambda$9(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Ljava/util/Map; Landroidx/fragment/app/FragmentActivity; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$wF0l6sXK7VrjhE6Qv3s_TH1dwJY(com.bytedance.trae.login.fragment.OneClickLoginFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->observeViewModel$lambda$7(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->Companion Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/common/fragment/TraceFragment;-><init>()V
    move-object v0, v5
    check-cast v0, Landroidx/fragment/app/Fragment;
    new-instance v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$special$$inlined$viewModels$default$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$special$$inlined$viewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    const-class v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    invoke-static v2, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$special$$inlined$viewModels$default$2;
    invoke-direct v3, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$special$$inlined$viewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    new-instance v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$special$$inlined$viewModels$default$3;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/fragment/app/Fragment;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-static v0, v2, v3, v4, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment; Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->viewModel$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$openUrl(com.bytedance.trae.login.fragment.OneClickLoginFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->openUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private final getBinding()com.bytedance.trae.login.databinding.TraeFragmentOneClickLoginBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    return-object v0
.end method

.method private final getCarrierAgreementName(com.bytedance.trae.login.PhoneOneKeyPlatform)java.lang.String
    .registers 3
    # ins_size=2
    if-nez v2, +004h
    const/4 v2, -1
    goto +9h
    sget-object v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +011h
    const/4 v0, 2
    if-eq v2, v0, +00bh
    const/4 v0, 3
    if-eq v2, v0, +005h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_carrier_agreement_mobile I
    goto +9h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_carrier_agreement_telecom I
    goto +6h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_carrier_agreement_unicom I
    goto +3h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_carrier_agreement_mobile I
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final getCarrierAgreementUrl(com.bytedance.trae.login.PhoneOneKeyPlatform)java.lang.String
    .registers 3
    # ins_size=2
    if-nez v2, +004h
    const/4 v2, -1
    goto +9h
    sget-object v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +010h
    const/4 v0, 2
    if-eq v2, v0, +00ah
    const/4 v0, 3
    if-eq v2, v0, +004h
    const/4 v2, 0
    goto +9h
    const-string v2, "https://e.189.cn/sdk/agreement/detail.do?hidetop=true"
    goto +6h
    const-string v2, "https://msv6.wosms.cn/html/oauth/protocol2.html"
    goto +3h
    const-string v2, "https://wap.cmpassport.com/resources/html/contract.html"
    return-object v2
.end method

.method private final getViewModel()com.bytedance.trae.login.fragment.OneClickLoginViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->viewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    return-object v0
.end method

.method private static final notifyDeviceOffline$lambda$9(com.bytedance.trae.login.fragment.OneClickLoginFragment  java.util.Map  androidx.fragment.app.FragmentActivity  boolean)void
    .registers 4
    # ins_size=4
    if-eqz v3, +014h
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->onDeviceLimitLoginContinue()V
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->callback Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;
    if-eqz v0, +04dh
    const-string/jumbo v2, one_click
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;->onDeviceLimitLoginContinue(Ljava/util/Map; Ljava/lang/String;)V
    goto +45h
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v1
    if-eqz v1, +00ah
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v1, +006h
    const/4 v3, 1
    invoke-virtual v1, v3, Landroid/widget/Button;->setEnabled(Z)V
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v1
    if-eqz v1, +011h
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v1, +00dh
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_one_click_login I
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v1
    if-eqz v1, +00bh
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v1, +007h
    const/16 v3, 8
    invoke-virtual v1, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    check-cast v2, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit I
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v2, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method public static synthetic notifyLoginResult$default(com.bytedance.trae.login.fragment.OneClickLoginFragment  boolean  java.lang.Integer  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyLoginResult(Z Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method private final observeViewModel()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->getMaskedPhone()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda0;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)V
    new-instance v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->getLoginState()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda1;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)V
    new-instance v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method private static final observeViewModel$lambda$7(com.bytedance.trae.login.fragment.OneClickLoginFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v0
    if-eqz v0, +00bh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->tvMaskedPhone Landroid/widget/TextView;
    if-eqz v0, +007h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final observeViewModel$lambda$8(com.bytedance.trae.login.fragment.OneClickLoginFragment  com.bytedance.trae.login.fragment.OneClickLoginViewModel$LoginState)kotlin.Unit
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Idle;
    const/16 v1, 8
    const/4 v2, 1
    if-eqz v0, +033h
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v5
    if-eqz v5, +009h
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v5, +005h
    invoke-virtual v5, v2, Landroid/widget/Button;->setEnabled(Z)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v5
    if-eqz v5, +011h
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v5, +00dh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_one_click_login I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v5, v0, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v4
    if-eqz v4, +09bh
    iget-object v4, v4, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v4, +097h
    invoke-virtual v4, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    goto/16 +092h
    instance-of v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Loading;
    const/4 v3, 0
    if-eqz v0, +02eh
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v5
    if-eqz v5, +009h
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v5, +005h
    invoke-virtual v5, v3, Landroid/widget/Button;->setEnabled(Z)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v5
    if-eqz v5, +00dh
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v5, +009h
    const-string v0, ""
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v5, v0, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v4
    if-eqz v4, +069h
    iget-object v4, v4, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v4, +065h
    invoke-virtual v4, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    goto +60h
    instance-of v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Success;
    if-eqz v0, +00ah
    iget-object v4, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->callback Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;
    if-eqz v4, +059h
    invoke-interface v4, Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;->onLoginSuccess()V
    goto +54h
    instance-of v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Error;
    if-eqz v0, +054h
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/widget/Button;->setEnabled(Z)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v0
    if-eqz v0, +011h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v0, +00dh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_one_click_login I
    invoke-virtual v4, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    check-cast v5, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Error;
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Error;->getErrorMessage()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +00dh
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_one_click_login_failed I
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    const-string v4, "getString(...)"
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
.end method

.method private final openUrl(java.lang.String)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;->INSTANCE Lcom/bytedance/trae/utils/AgreementUrlOpener;
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v2, requireContext(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/AgreementUrlOpener;->open(Landroid/content/Context; Ljava/lang/String;)V
    goto +5h
    move-exception v4
    invoke-virtual v4, Ljava/lang/Exception;->printStackTrace()V
    return-void 
    :try_start_0x0
.end method

.method private final setupViews()void
    .registers 6
    # ins_size=1
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +02dh
    const-string v2, "arg_carrier"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +025h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v5
    check-cast v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    invoke-static v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    invoke-direct v5, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getCarrierAgreementUrl(Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +013h
    invoke-direct v5, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getCarrierAgreementName(Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)Ljava/lang/String;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->login_agreement_with_carrier I
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/Object;
    const/4 v4, 0
    aput-object v1, v3, v4
    invoke-virtual v5, v2, v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +7h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->login_agreement I
    invoke-virtual v5, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v2
    if-eqz v2, +009h
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->privacyPolicyText Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    if-eqz v2, +005h
    invoke-virtual v2, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setUrlSpannedText(Ljava/lang/String;)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v1
    if-eqz v1, +010h
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->privacyPolicyText Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    if-eqz v1, +00ch
    new-instance v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;
    invoke-direct v2, v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)V
    check-cast v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;
    invoke-virtual v1, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setOnClickListener(Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->tvSwitch Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda5;
    invoke-direct v1, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v1
    if-eqz v1, +00eh
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->ivAgreementCheck Landroid/widget/ImageView;
    if-eqz v1, +00ah
    new-instance v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda6;
    invoke-direct v2, v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda6;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)V
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v1
    if-eqz v1, +00eh
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->btnOneClickLogin Landroid/widget/Button;
    if-eqz v1, +00ah
    new-instance v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda7;
    invoke-direct v2, v0, v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda7;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)V
    invoke-virtual v1, v2, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
    :try_start_0xf
.end method

.method private static final setupViews$lambda$2(com.bytedance.trae.login.fragment.OneClickLoginFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->callback Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;->onSwitchAccount()V
    return-void 
.end method

.method private static final setupViews$lambda$3(kotlin.jvm.internal.Ref$BooleanRef  com.bytedance.trae.login.fragment.OneClickLoginFragment  android.view.View)void
    .registers 4
    # ins_size=3
    iget-boolean v3, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    xor-int/lit8 v3, v3, 1
    iput-boolean v3, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    iget-boolean v3, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    if-eqz v3, +012h
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v3
    if-eqz v3, +01bh
    iget-object v3, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->ivAgreementCheck Landroid/widget/ImageView;
    if-eqz v3, +017h
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_filled I
    invoke-virtual v3, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +10h
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v3
    if-eqz v3, +00bh
    iget-object v3, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->ivAgreementCheck Landroid/widget/ImageView;
    if-eqz v3, +007h
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_unchecked I
    invoke-virtual v3, v0, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v2
    iget-boolean v1, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    invoke-virtual v2, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->onAgreementCheckedChanged(Z)V
    return-void 
.end method

.method private static final setupViews$lambda$6(kotlin.jvm.internal.Ref$BooleanRef  com.bytedance.trae.login.fragment.OneClickLoginFragment  android.view.View)void
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    sget-object v2, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const-string/jumbo v3, phone_oneclick
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginClick(Ljava/lang/String;)V
    iget-boolean v2, v0, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    if-nez v2, +036h
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "agreement_dialog_shown"
    const-string/jumbo v5, one_click
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 2044
    const/16 v16, 0
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    new-instance v2, Lcom/bytedance/trae/login/activity/AgreementDialog;
    invoke-virtual/range v18, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    const-string/jumbo v4, requireContext(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda2;
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef; Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;)V
    new-instance v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda3;-><init>()V
    invoke-direct v2, v3, v4, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;-><init>(Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AgreementDialog;->show()V
    return-void 
    invoke-direct/range v18, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->onOneClickLogin()V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->callback Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;->onOneClickLogin()V
    return-void 
.end method

.method private static final setupViews$lambda$6$lambda$4(kotlin.jvm.internal.Ref$BooleanRef  com.bytedance.trae.login.fragment.OneClickLoginFragment)kotlin.Unit
    .registers 16
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "agreement_accepted"
    const-string/jumbo v2, one_click
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
    iput-boolean v0, v14, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    invoke-direct v15, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v14
    if-eqz v14, +00bh
    iget-object v14, v14, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->ivAgreementCheck Landroid/widget/ImageView;
    if-eqz v14, +007h
    sget v1, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_filled I
    invoke-virtual v14, v1, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v15, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v14
    invoke-virtual v14, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->onAgreementCheckedChanged(Z)V
    invoke-direct v15, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->onOneClickLogin()V
    iget-object v14, v15, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->callback Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;
    if-eqz v14, +005h
    invoke-interface v14, Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;->onOneClickLogin()V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method

.method private static final setupViews$lambda$6$lambda$5()kotlin.Unit
    .registers 14
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "agreement_rejected"
    const-string/jumbo v2, one_click
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

.method public autoLogEnterPage()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public final notifyDeviceOffline(com.bytedance.trae.login.traeauth.ListDevicesResult  java.util.Map)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, result
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    move-object v2, v0
    check-cast v2, Landroid/app/Activity;
    sget-object v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->LOGIN Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda4;
    invoke-direct v4, v5, v7, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Ljava/util/Map; Landroidx/fragment/app/FragmentActivity;)V
    invoke-virtual v1, v2, v6, v3, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    return-void 
.end method

.method public final notifyLoginResult(boolean  java.lang.Integer  java.lang.String)void
    .registers 5
    # ins_size=4
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v0
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->onLoginResult(Z Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 4
    # ins_size=4
    const-string v3, "inflater"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v2, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;->getRoot()Landroid/widget/ScrollView;
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
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/bytedance/trae/common/fragment/TraceFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setupViews()V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->observeViewModel()V
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    if-eqz v2, +009h
    const-string v3, "arg_masked_phone"
    invoke-virtual v2, v3, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v3
    invoke-virtual v3, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->init(Ljava/lang/String;)V
    return-void 
.end method

.method public final resetLoginLoadingState()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->getViewModel()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->resetToIdle()V
    return-void 
.end method

.method public final setOneClickLoginCallback(com.bytedance.trae.login.fragment.OneClickLoginCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->callback Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;
    return-void 
.end method

.method public showBytecloudSso(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, onSsoClick
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
