# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "EnterpriseLoginActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$Companion;
.field private static final MAIN_ACTIVITY_CLASS:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private btnContinue:Landroid/widget/Button;
.field private btnLogin:Landroid/widget/Button;
.field private btnSsoLogin:Landroid/view/View;
.field private currentEmail:Ljava/lang/String;
.field private etEmailStep1:Landroid/widget/EditText;
.field private etPassword:Landroid/widget/EditText;
.field private final forgotPasswordLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private isLoading:Z
.field private isPasswordVisible:Z
.field private ivClearEmail:Landroid/widget/ImageView;
.field private ivClearPassword:Landroid/widget/ImageView;
.field private ivTogglePassword:Landroid/widget/ImageView;
.field private layoutEmailInput:Landroid/view/View;
.field private layoutErrorEmail:Landroid/view/View;
.field private layoutErrorPassword:Landroid/view/View;
.field private layoutOrDivider:Landroid/view/View;
.field private layoutPasswordInput:Landroid/view/View;
.field private layoutStepEmail:Landroid/view/View;
.field private layoutStepPassword:Landroid/view/View;
.field private loginSuccess:Z
.field private pbLoading:Landroid/widget/ProgressBar;
.field private pbLoadingEmail:Landroid/widget/ProgressBar;
.field private ssoAuthUrl:Ljava/lang/String;
.field private tvEmailDisplay:Landroid/widget/TextView;
.field private tvError:Landroid/widget/TextView;
.field private tvErrorEmail:Landroid/widget/TextView;
.field private tvForgotPassword:Landroid/widget/TextView;
.field private tvStep2Title:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$10q675Knb7iEA_I_70aWWt6X2nw(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->initViews$lambda$1(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2WCrnUMLrljV2HBRIvA1S1fCK3U(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep1Listeners$lambda$3(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$8rLN0rfQI4ILjMe0wiz3h3Wd9Ko(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep2Listeners$lambda$6(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$9e9MWefO1xg5qIYhbpT2PQTQ3hI(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep2Listeners$lambda$5(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$G9k6uEgGp4TE52-PHsobJbfRpUM(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep2Listeners$lambda$7(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$RcR1C-6RLjQ2lbK4M4Wzzui8fLk(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->forgotPasswordLauncher$lambda$0(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$SzGwIl6t64QXCRj93aQF5tEj87s(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->initViews$lambda$2(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$T2Wrhwzmx-mVwQQv4lv1OIY9Lrs(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep1Listeners$lambda$4(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cJ6yhoiHDknHNJCvNRAGtdTnUno(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep2Listeners$lambda$9(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xU1UHSfnGfZFKyUteWQZEvdlD9U(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep2Listeners$lambda$10(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$yu-7use5Bu_s0dYBqN2AxqL6k2g(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->showPasswordStep$lambda$11(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->Companion Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const-string v0, ""
    iput-object v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda6;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string/jumbo v1, registerForActivityResult(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->forgotPasswordLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$clearEmailError(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->clearEmailError()V
    return-void 
.end method

.method public static final synthetic access$clearPasswordError(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->clearPasswordError()V
    return-void 
.end method

.method public static final synthetic access$getBtnContinue$p(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)android.widget.Button
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnContinue Landroid/widget/Button;
    return-object v0
.end method

.method public static final synthetic access$getIvClearEmail$p(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)android.widget.ImageView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivClearEmail Landroid/widget/ImageView;
    return-object v0
.end method

.method public static final synthetic access$getIvClearPassword$p(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)android.widget.ImageView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivClearPassword Landroid/widget/ImageView;
    return-object v0
.end method

.method public static final synthetic access$handleCheckLoginConfigResult(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  java.lang.String  com.bytedance.trae.login.enterprise.CheckLoginConfigResult)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->handleCheckLoginConfigResult(Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;)V
    return-void 
.end method

.method public static final synthetic access$isLoading$p(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->isLoading Z
    return v0
.end method

.method public static final synthetic access$navigateToMain(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->navigateToMain()V
    return-void 
.end method

.method public static final synthetic access$setEmailStepLoading(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setEmailStepLoading(Z)V
    return-void 
.end method

.method public static final synthetic access$setLoginLoading(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setLoginLoading(Z)V
    return-void 
.end method

.method public static final synthetic access$setLoginSuccess$p(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->loginSuccess Z
    return-void 
.end method

.method public static final synthetic access$showEmailError(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->showEmailError(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showError(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->showError(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$updateLoginButtonState(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->updateLoginButtonState()V
    return-void 
.end method

.method private final clearEmailError()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutErrorEmail Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutErrorEmail"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutEmailInput Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutEmailInput"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_new I
    invoke-virtual v1, v0, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private final clearPasswordError()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutErrorPassword Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutErrorPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutPasswordInput Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutPasswordInput"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_new I
    invoke-virtual v1, v0, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method public static com_bytedance_trae_login_enterprise_EnterpriseLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->com_bytedance_trae_login_enterprise_EnterpriseLoginActivity__onStop$___twin___()V
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

.method private static final forgotPasswordLauncher$lambda$0(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  androidx.activity.result.ActivityResult)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, -1
    if-ne v0, v1, +036h
    invoke-virtual v4, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +00ah
    const-string/jumbo v1, result_email
    invoke-virtual v4, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    if-nez v2, +015h
    iput-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etEmailStep1 Landroid/widget/EditText;
    if-nez v4, +008h
    const-string v4, "etEmailStep1"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v4
    invoke-virtual v0, v1, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->goBackToStep1()V
    return-void 
.end method

.method private final goBackToStep1()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutStepPassword Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutStepPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutStepEmail Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepEmail"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    invoke-direct v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->clearPasswordError()V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnSsoLogin Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "btnSsoLogin"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutOrDivider Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutOrDivider"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iput-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ssoAuthUrl Ljava/lang/String;
    return-void 
.end method

.method private final handleCheckLoginConfigResult(java.lang.String  com.bytedance.trae.login.enterprise.CheckLoginConfigResult)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    const/4 v2, 0
    invoke-direct v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setEmailStepLoading(Z)V
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked()Z
    move-result v3
    if-eqz v3, +006h
    const-string v3, "blocked"
    move-object v14, v3
    goto +fh
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired()Z
    move-result v3
    if-eqz v3, +006h
    const-string/jumbo v3, sso_required
    goto -bh
    const-string/jumbo v3, password
    goto -fh
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "enterprise_check_config_result"
    const-string v6, "enterprise"
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v15, 0
    const/16 v16, 1532
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked()Z
    move-result v3
    const-string v4, "getString(...)"
    if-eqz v3, +00fh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_login_blocked_domain I
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->showEmailError(Ljava/lang/String;)V
    return-void 
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired()Z
    move-result v3
    const/4 v5, 1
    if-eqz v3, +030h
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso()Z
    move-result v1
    if-eqz v1, +01bh
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->getSsoAuthUrl()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +008h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v2, v5
    if-nez v2, +00ah
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->getSsoAuthUrl()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->openSsoUrl(Ljava/lang/String;)V
    goto +dh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_login_service_error I
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->showEmailError(Ljava/lang/String;)V
    return-void 
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->getSsoAuthUrl()Ljava/lang/String;
    move-result-object v3
    iput-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ssoAuthUrl Ljava/lang/String;
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso()Z
    move-result v3
    if-eqz v3, +017h
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->getSsoAuthUrl()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v2
    goto +2h
    move v3, v5
    if-nez v3, +003h
    move v2, v5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->showPasswordStep(Ljava/lang/String; Z)V
    return-void 
.end method

.method private final initViews()void
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_step_email I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutStepEmail Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_email_input I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutEmailInput Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->et_email_step1 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etEmailStep1 Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_clear_email I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivClearEmail Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_continue I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnContinue Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading_email I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->pbLoadingEmail Landroid/widget/ProgressBar;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_error_email I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutErrorEmail Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_error_email I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvErrorEmail Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda7;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_step_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutStepPassword Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_password_input I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutPasswordInput Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_step2_title I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvStep2Title Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_email_display I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvEmailDisplay Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->et_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_login I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnLogin Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->pbLoading Landroid/widget/ProgressBar;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_error_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutErrorPassword Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_error I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvError Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_toggle_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivTogglePassword Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_clear_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivClearPassword Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_sso_login I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnSsoLogin Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_or_divider I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutOrDivider Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_forgot_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvForgotPassword Landroid/widget/TextView;
    const/4 v1, 0
    const-string/jumbo v2, tvForgotPassword
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvForgotPassword Landroid/widget/TextView;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Landroid/widget/TextView;->getPaintFlags()I
    move-result v1
    or-int/lit8 v1, v1, 8
    invoke-virtual v0, v1, Landroid/widget/TextView;->setPaintFlags(I)V
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda8;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final initViews$lambda$1(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->finish()V
    return-void 
.end method

.method private static final initViews$lambda$2(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->goBackToStep1()V
    return-void 
.end method

.method private final navigateToMain()void
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
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->finish()V
    return-void 
.end method

.method private final openSsoUrl(java.lang.String)void
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "EnterpriseLoginActivity"
    const-string v3, "Opening SSO URL in WebView"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "enterprise_sso_opened"
    const-string v6, "enterprise"
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 2044
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->Companion Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    iget-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    move-object/from16 v4, v19
    invoke-virtual v1, v2, v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final performCheckLoginConfig()void
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etEmailStep1 Landroid/widget/EditText;
    const/4 v2, 0
    if-nez v1, +008h
    const-string v1, "etEmailStep1"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v4
    const/4 v5, 1
    if-nez v4, +004h
    move v4, v5
    goto +2h
    const/4 v4, 0
    if-eqz v4, +003h
    return-void 
    sget-object v4, Landroid/util/Patterns;->EMAIL_ADDRESS Ljava/util/regex/Pattern;
    invoke-virtual v4, v3, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    move-result-object v3
    invoke-virtual v3, Ljava/util/regex/Matcher;->matches()Z
    move-result v3
    if-nez v3, +011h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_login_email_invalid I
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "getString(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->showEmailError(Ljava/lang/String;)V
    return-void 
    invoke-direct v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setEmailStepLoading(Z)V
    invoke-direct/range v17, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->clearEmailError()V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "enterprise_email_submitted"
    const-string v5, "enterprise"
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
    move-object v3, v0
    check-cast v3, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v3, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    new-instance v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;
    invoke-direct v3, v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v7, v3
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final performLogin()void
    .registers 34
    # ins_size=1
    move-object/from16 v0, v33
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v1, +008h
    const-string v1, "etPassword"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 0
    const/4 v4, 1
    if-nez v2, +004h
    move v2, v4
    goto +2h
    move v2, v3
    if-nez v2, +062h
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    move v3, v4
    if-eqz v3, +003h
    goto +54h
    invoke-direct v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setLoginLoading(Z)V
    invoke-direct/range v33, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->clearPasswordError()V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v6, "login_method_selected"
    const-string v7, "enterprise"
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 2044
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v19, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v20, "enterprise_password_submitted"
    const-string v21, "enterprise"
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 2044
    const/16 v32, 0
    invoke-static/range v19 ... v32, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    move-object v3, v0
    check-cast v3, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v3, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v3
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    new-instance v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;
    invoke-direct v5, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    check-cast v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    invoke-virtual v2, v3, v4, v1, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->login(Lkotlinx/coroutines/CoroutineScope; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;)V
    return-void 
.end method

.method private final setEmailStepLoading(boolean)void
    .registers 7
    # ins_size=2
    iput-boolean v6, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->isLoading Z
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->pbLoadingEmail Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, pbLoadingEmail
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnContinue Landroid/widget/Button;
    const-string v2, "btnContinue"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +005h
    const-string v3, ""
    goto +ch
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_login_continue I
    invoke-virtual v5, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnContinue Landroid/widget/Button;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    xor-int/lit8 v2, v6, 1
    invoke-virtual v0, v2, Landroid/widget/Button;->setEnabled(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etEmailStep1 Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    xor-int/lit8 v6, v6, 1
    invoke-virtual v1, v6, Landroid/widget/EditText;->setEnabled(Z)V
    return-void 
.end method

.method private final setLoginLoading(boolean)void
    .registers 7
    # ins_size=2
    iput-boolean v6, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->isLoading Z
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->pbLoading Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, pbLoading
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnLogin Landroid/widget/Button;
    const-string v2, "btnLogin"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +005h
    const-string v3, ""
    goto +ch
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_login_btn I
    invoke-virtual v5, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnLogin Landroid/widget/Button;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    xor-int/lit8 v2, v6, 1
    invoke-virtual v0, v2, Landroid/widget/Button;->setEnabled(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    xor-int/lit8 v6, v6, 1
    invoke-virtual v1, v6, Landroid/widget/EditText;->setEnabled(Z)V
    return-void 
.end method

.method private final setupStep1Listeners()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etEmailStep1 Landroid/widget/EditText;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "etEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v0, v2, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivClearEmail Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "ivClearEmail"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda9;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnContinue Landroid/widget/Button;
    if-nez v0, +008h
    const-string v0, "btnContinue"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda10;
    invoke-direct v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v1, v0, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupStep1Listeners$lambda$3(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etEmailStep1 Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    return-void 
.end method

.method private static final setupStep1Listeners$lambda$4(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->performCheckLoginConfig()V
    return-void 
.end method

.method private final setupStep2Listeners()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "etPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep2Listeners$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep2Listeners$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v0, v2, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivClearPassword Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "ivClearPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda0;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivTogglePassword Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "ivTogglePassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda2;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnLogin Landroid/widget/Button;
    if-nez v0, +008h
    const-string v0, "btnLogin"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda3;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v0, v2, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnSsoLogin Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "btnSsoLogin"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda4;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvForgotPassword Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvForgotPassword
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda5;
    invoke-direct v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupStep2Listeners$lambda$10(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +012h
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->forgotPasswordLauncher Landroidx/activity/result/ActivityResultLauncher;
    sget-object v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->Companion Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$Companion;
    move-object v1, v2
    check-cast v1, Landroid/content/Context;
    iget-object v2, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$Companion;->createIntent(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v2
    invoke-virtual v3, v2, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final setupStep2Listeners$lambda$5(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    return-void 
.end method

.method private static final setupStep2Listeners$lambda$6(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 6
    # ins_size=2
    iget-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->isPasswordVisible Z
    xor-int/lit8 v5, v5, 1
    iput-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->isPasswordVisible Z
    const-string v0, "ivTogglePassword"
    const-string v1, "etPassword"
    const/4 v2, 0
    if-eqz v5, +01dh
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    const/16 v3, 145
    invoke-virtual v5, v3, Landroid/widget/EditText;->setInputType(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivTogglePassword Landroid/widget/ImageView;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_eye_open I
    invoke-virtual v5, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +1bh
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    const/16 v3, 129
    invoke-virtual v5, v3, Landroid/widget/EditText;->setInputType(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ivTogglePassword Landroid/widget/ImageView;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_eye_slash I
    invoke-virtual v5, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    iget-object v4, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v4
    invoke-virtual v2, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v4
    invoke-interface v4, Landroid/text/Editable;->length()I
    move-result v4
    invoke-virtual v5, v4, Landroid/widget/EditText;->setSelection(I)V
    return-void 
.end method

.method private static final setupStep2Listeners$lambda$7(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->performLogin()V
    return-void 
.end method

.method private static final setupStep2Listeners$lambda$9(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->ssoAuthUrl Ljava/lang/String;
    if-eqz v1, +005h
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->openSsoUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private final showEmailError(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvErrorEmail Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, tvErrorEmail
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutErrorEmail Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutErrorEmail"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    const/4 v0, 0
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutEmailInput Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutEmailInput"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    sget v3, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_error I
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private final showError(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvError Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, tvError
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutErrorPassword Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutErrorPassword"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    const/4 v0, 0
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutPasswordInput Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutPasswordInput"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    sget v3, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_error I
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private final showPasswordStep(java.lang.String  boolean)void
    .registers 11
    # ins_size=3
    iput-object v9, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->currentEmail Ljava/lang/String;
    iget-object v0, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutStepEmail Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutStepEmail"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutStepPassword Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvEmailDisplay Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvEmailDisplay
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v0, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v9
    iget v9, v9, Landroid/util/DisplayMetrics;->density F
    const-string v0, "layoutPasswordInput"
    const-string v4, "layoutOrDivider"
    const-string v5, "btnSsoLogin"
    const-string/jumbo v6, null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams
    const-string/jumbo v7, tvStep2Title
    if-eqz v10, +05ch
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvStep2Title Landroid/widget/TextView;
    if-nez v10, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_login_choose_method I
    invoke-virtual v8, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v10, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnSsoLogin Landroid/view/View;
    if-nez v10, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutOrDivider Landroid/view/View;
    if-nez v10, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvStep2Title Landroid/widget/TextView;
    if-nez v10, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v10
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v2, 40
    int-to-float v2, v2
    mul-float/2addr v2, v9
    float-to-int v2, v2
    iput v2, v10, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutPasswordInput Landroid/view/View;
    if-nez v10, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v10
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v0, 14
    int-to-float v0, v0
    mul-float/2addr v0, v9
    float-to-int v9, v0
    iput v9, v10, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    goto +5ah
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvStep2Title Landroid/widget/TextView;
    if-nez v10, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_login_subtitle_password I
    invoke-virtual v8, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v10, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnSsoLogin Landroid/view/View;
    if-nez v10, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutOrDivider Landroid/view/View;
    if-nez v10, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->tvStep2Title Landroid/widget/TextView;
    if-nez v10, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v10
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v2, 80
    int-to-float v2, v2
    mul-float/2addr v2, v9
    float-to-int v2, v2
    iput v2, v10, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iget-object v10, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->layoutPasswordInput Landroid/view/View;
    if-nez v10, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v10, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v10
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v0, 24
    int-to-float v0, v0
    mul-float/2addr v0, v9
    float-to-int v9, v0
    iput v9, v10, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iget-object v9, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    const-string v10, "etPassword"
    if-nez v9, +006h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v1
    invoke-virtual v9, Landroid/widget/EditText;->requestFocus()Z
    iget-object v9, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v9, +006h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v9
    new-instance v9, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda1;
    invoke-direct v9, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    invoke-virtual v1, v9, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final showPasswordStep$lambda$11(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 4
    # ins_size=1
    const-string v0, "input_method"
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/view/inputmethod/InputMethodManager;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    move-object v0, v2
    if-eqz v0, +013h
    iget-object v3, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    if-nez v3, +008h
    const-string v3, "etPassword"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    check-cast v2, Landroid/view/View;
    const/4 v3, 1
    invoke-virtual v0, v2, v3, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method private final updateLoginButtonState()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etPassword Landroid/widget/EditText;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "etPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    iget-object v2, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->btnLogin Landroid/widget/Button;
    if-nez v2, +008h
    const-string v2, "btnLogin"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v2, 1
    const/4 v3, 0
    if-lez v0, +004h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +007h
    iget-boolean v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->isLoading Z
    if-nez v0, +003h
    goto +2h
    move v2, v3
    invoke-virtual v1, v2, Landroid/widget/Button;->setEnabled(Z)V
    return-void 
.end method

.method public com_bytedance_trae_login_enterprise_EnterpriseLoginActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 16
    # ins_size=2
    invoke-super v14, v15, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v15, Lcom/bytedance/trae/login/R$layout;->trae_activity_enterprise_login I
    invoke-virtual v14, v15, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setContentView(I)V
    invoke-direct v14, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->initViews()V
    invoke-direct v14, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep1Listeners()V
    invoke-direct v14, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->setupStep2Listeners()V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "enterprise_page_shown"
    const-string v2, "enterprise"
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
    iget-object v15, v14, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->etEmailStep1 Landroid/widget/EditText;
    if-nez v15, +008h
    const-string v15, "etEmailStep1"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v15, Landroid/widget/EditText;->requestFocus()Z
    invoke-virtual v14, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getWindow()Landroid/view/Window;
    move-result-object v15
    const/4 v0, 4
    invoke-virtual v15, v0, Landroid/view/Window;->setSoftInputMode(I)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 16
    # ins_size=1
    invoke-super v15, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    iget-boolean v0, v15, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->loginSuccess Z
    if-nez v0, +017h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "enterprise_page_exit"
    const-string v3, "enterprise"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 2044
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->com_bytedance_trae_login_enterprise_EnterpriseLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    return-void 
.end method
