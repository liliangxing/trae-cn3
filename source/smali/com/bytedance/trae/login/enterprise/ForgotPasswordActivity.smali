# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "ForgotPasswordActivity.kt"

.field private static final COUNTDOWN_MILLIS:J
.field public static final Companion:Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$Companion;
.field private static final EXTRA_EMAIL:Ljava/lang/String;
.field public static final RESULT_EMAIL_KEY:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private btnGoLogin:Landroid/widget/Button;
.field private btnSendCode:Landroid/widget/Button;
.field private btnSetPassword:Landroid/widget/Button;
.field private countDownTimer:Landroid/os/CountDownTimer;
.field private email:Ljava/lang/String;
.field private etConfirmPassword:Landroid/widget/EditText;
.field private etEmailStep1:Landroid/widget/EditText;
.field private etNewPassword:Landroid/widget/EditText;
.field private isConfirmPasswordVisible:Z
.field private isCountdownActive:Z
.field private isLoading:Z
.field private isNewPasswordVisible:Z
.field private ivClearEmailStep1:Landroid/widget/ImageView;
.field private ivToggleConfirmPassword:Landroid/widget/ImageView;
.field private ivToggleNewPassword:Landroid/widget/ImageView;
.field private layoutConfirmPasswordInput:Landroid/view/View;
.field private layoutEmailInputStep1:Landroid/view/View;
.field private layoutErrorStep1:Landroid/view/View;
.field private layoutErrorStep2:Landroid/view/View;
.field private layoutErrorStep3:Landroid/view/View;
.field private layoutNewPasswordInput:Landroid/view/View;
.field private layoutStepNewPassword:Landroid/view/View;
.field private layoutStepSendCode:Landroid/view/View;
.field private layoutStepSuccess:Landroid/view/View;
.field private layoutStepVerifyCode:Landroid/view/View;
.field private pbLoadingStep1:Landroid/widget/ProgressBar;
.field private pbLoadingStep2:Landroid/widget/ProgressBar;
.field private pbLoadingStep3:Landroid/widget/ProgressBar;
.field private tvErrorStep1:Landroid/widget/TextView;
.field private tvErrorStep2:Landroid/widget/TextView;
.field private tvErrorStep3:Landroid/widget/TextView;
.field private tvResendCode:Landroid/widget/TextView;
.field private tvVerifyDesc:Landroid/widget/TextView;
.field private verificationCode:Ljava/lang/String;
.field private verifyCodeInput:Lcom/bytedance/trae/login/widget/VerifyCodeInputView;


.method public static synthetic $r8$lambda$3Z4hE8DvyeB3HqS83v3HLEMD_PE(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$7(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$43iqjFgZKXqXDRZToB5gE0T_qVQ(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$3(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$BluH4Z-Q3TpIa2Y24oJvPFwvImE(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$9(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ELqIBoARvD-O3SNEFKcyck-HbWs(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$0(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HLswtT2yMGe0e5tWkPy8GM5VUUo(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$2(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Mken6V5A_Iwenrpkz3tZOFckS1Q(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$5(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$QkvgWSB9fg231DgTPJ5clN4iLQs(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$10(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$bH2R4c6Dygk--KsYYYBfg8xLRsg(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$4(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$sQhspMu2XZiMw_43wfCNck06hnc(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$6(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$u6oBOkAgJfn1MlmR2sHIGC2a0Rs(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$1(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$z0FnsivMsv7yngYsdGodpHtHVpo(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners$lambda$8(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->Companion Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verificationCode Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$clearStep1Error(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep1Error()V
    return-void 
.end method

.method public static final synthetic access$clearStep2Error(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep2Error()V
    return-void 
.end method

.method public static final synthetic access$clearStep3Error(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep3Error()V
    return-void 
.end method

.method public static final synthetic access$finishWithEmail(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->finishWithEmail()V
    return-void 
.end method

.method public static final synthetic access$getEmail$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->email Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getLayoutErrorStep1$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep1 Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getLayoutErrorStep2$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep2 Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getLayoutErrorStep3$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep3 Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getLayoutStepSuccess$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSuccess Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getTvResendCode$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getVerificationCode$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verificationCode Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getVerifyCodeInput$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)com.bytedance.trae.login.widget.VerifyCodeInputView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    return-object v0
.end method

.method public static final synthetic access$goToStep2(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->goToStep2()V
    return-void 
.end method

.method public static final synthetic access$goToStep3(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->goToStep3()V
    return-void 
.end method

.method public static final synthetic access$goToStep4(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->goToStep4()V
    return-void 
.end method

.method public static final synthetic access$isLoading$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isLoading Z
    return v0
.end method

.method public static final synthetic access$performVerifyCode(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->performVerifyCode()V
    return-void 
.end method

.method public static final synthetic access$setCountdownActive$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isCountdownActive Z
    return-void 
.end method

.method public static final synthetic access$setStep1Loading(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep1Loading(Z)V
    return-void 
.end method

.method public static final synthetic access$setStep2Loading(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep2Loading(Z)V
    return-void 
.end method

.method public static final synthetic access$setStep3Loading(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep3Loading(Z)V
    return-void 
.end method

.method public static final synthetic access$setVerificationCode$p(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verificationCode Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$showStep1Error(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->showStep1Error(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showStep2Error(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->showStep2Error(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showStep3Error(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->showStep3Error(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$startResendCountdown(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->startResendCountdown()V
    return-void 
.end method

.method public static final synthetic access$updateSetPasswordButtonState(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->updateSetPasswordButtonState()V
    return-void 
.end method

.method private final clearStep1Error()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep1 Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutErrorStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutEmailInputStep1 Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutEmailInputStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_new I
    invoke-virtual v1, v0, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private final clearStep2Error()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep2 Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutErrorStep2"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v0, +009h
    const-string/jumbo v0, verifyCodeInput
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setError(Z)V
    return-void 
.end method

.method private final clearStep3Error()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep3 Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutErrorStep3"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutNewPasswordInput Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutNewPasswordInput"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v2, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_new I
    invoke-virtual v0, v2, Landroid/view/View;->setBackgroundResource(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutConfirmPasswordInput Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutConfirmPasswordInput"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_new I
    invoke-virtual v1, v0, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method public static com_bytedance_trae_login_enterprise_ForgotPasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->com_bytedance_trae_login_enterprise_ForgotPasswordActivity__onStop$___twin___()V
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

.method private final finishWithEmail()void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    iget-object v1, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->email Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "email"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    const-string/jumbo v2, result_email
    invoke-virtual v0, v2, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v0
    const/4 v1, -1
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setResult(I Landroid/content/Intent;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->finish()V
    return-void 
.end method

.method private final goToStep1()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepVerifyCode Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutStepVerifyCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepNewPassword Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSuccess Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepSuccess"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSendCode Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    invoke-direct v3, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep1Loading(Z)V
    invoke-direct v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep1Error()V
    return-void 
.end method

.method private final goToStep2()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSendCode Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutStepSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepNewPassword Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSuccess Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepSuccess"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepVerifyCode Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepVerifyCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvVerifyDesc Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvVerifyDesc
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v3, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->email Ljava/lang/String;
    if-nez v3, +008h
    const-string v3, "email"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v4, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep2Loading(Z)V
    invoke-direct v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep2Error()V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string/jumbo v2, verifyCodeInput
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Landroid/text/Editable;->clear()V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    return-void 
.end method

.method private final goToStep3()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSendCode Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutStepSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepVerifyCode Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepVerifyCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepNewPassword Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSuccess Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepSuccess"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    invoke-direct v4, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep3Loading(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvErrorStep3 Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvErrorStep3
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    const-string v2, "etNewPassword"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etConfirmPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Landroid/widget/EditText;->requestFocus()Z
    return-void 
.end method

.method private final goToStep4()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSendCode Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutStepSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepVerifyCode Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepVerifyCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepNewPassword Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSuccess Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "layoutStepSuccess"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final initViews()void
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_step_send_code I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSendCode Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_email_input_step1 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutEmailInputStep1 Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->et_email_step1 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etEmailStep1 Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_clear_email_step1 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivClearEmailStep1 Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_send_code I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSendCode Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading_step1 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->pbLoadingStep1 Landroid/widget/ProgressBar;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_error_step1 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep1 Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_error_step1 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvErrorStep1 Landroid/widget/TextView;
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etEmailStep1 Landroid/widget/EditText;
    const/4 v2, 0
    if-nez v0, +008h
    const-string v0, "etEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v3, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->email Ljava/lang/String;
    if-nez v3, +008h
    const-string v3, "email"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_step_verify_code I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepVerifyCode Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_verify_desc I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvVerifyDesc Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->verify_code_input I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v0, +009h
    const-string/jumbo v0, verifyCodeInput
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    const/4 v0, 1
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setAlphanumeric(Z)V
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading_step2 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->pbLoadingStep2 Landroid/widget/ProgressBar;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_error_step2 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep2 Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_error_step2 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvErrorStep2 Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_resend_code I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_step_new_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepNewPassword Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_new_password_input I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutNewPasswordInput Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_confirm_password_input I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutConfirmPasswordInput Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->et_new_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/login/R$id;->et_confirm_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_set_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSetPassword Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading_step3 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->pbLoadingStep3 Landroid/widget/ProgressBar;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_error_step3 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep3 Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_error_step3 I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvErrorStep3 Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_toggle_new_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleNewPassword Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_toggle_confirm_password I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleConfirmPassword Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/login/R$id;->layout_step_success I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutStepSuccess Landroid/view/View;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_go_login I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnGoLogin Landroid/widget/Button;
    return-void 
.end method

.method private final performSendCode()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etEmailStep1 Landroid/widget/EditText;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "etEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    iput-object v0, v8, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->email Ljava/lang/String;
    if-nez v0, +008h
    const-string v0, "email"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v2, 1
    if-nez v0, +004h
    move v0, v2
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    invoke-direct v8, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep1Loading(Z)V
    invoke-direct v8, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep1Error()V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSendCode$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSendCode$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final performSetPassword()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "etNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    iget-object v2, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v2, +008h
    const-string v2, "etConfirmPassword"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    invoke-virtual v2, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +011h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_forgot_password_mismatch I
    invoke-virtual v9, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->showStep3Error(Ljava/lang/String;)V
    return-void 
    const/4 v2, 1
    invoke-direct v9, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep3Loading(Z)V
    invoke-direct v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep3Error()V
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1;
    invoke-direct v2, v9, v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final performVerifyCode()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, verifyCodeInput
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-static v0, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v2
    const/4 v3, 6
    if-eq v2, v3, +003h
    return-void 
    const/4 v2, 1
    invoke-direct v9, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setStep2Loading(Z)V
    invoke-direct v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->clearStep2Error()V
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;
    invoke-direct v2, v9, v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final setStep1Loading(boolean)void
    .registers 7
    # ins_size=2
    iput-boolean v6, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isLoading Z
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->pbLoadingStep1 Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, pbLoadingStep1
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSendCode Landroid/widget/Button;
    const-string v2, "btnSendCode"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +005h
    const-string v3, ""
    goto +ch
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_forgot_password_send_code I
    invoke-virtual v5, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSendCode Landroid/widget/Button;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    xor-int/lit8 v6, v6, 1
    invoke-virtual v1, v6, Landroid/widget/Button;->setEnabled(Z)V
    return-void 
.end method

.method private final setStep2Loading(boolean)void
    .registers 6
    # ins_size=2
    iput-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isLoading Z
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->pbLoadingStep2 Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, pbLoadingStep2
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    if-eqz v5, +004h
    move v3, v2
    goto +3h
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v0, +009h
    const-string/jumbo v0, verifyCodeInput
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    xor-int/lit8 v3, v5, 1
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvResendCode
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    if-nez v5, +007h
    iget-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isCountdownActive Z
    if-nez v5, +003h
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/TextView;->setEnabled(Z)V
    return-void 
.end method

.method private final setStep3Loading(boolean)void
    .registers 7
    # ins_size=2
    iput-boolean v6, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isLoading Z
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->pbLoadingStep3 Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, pbLoadingStep3
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSetPassword Landroid/widget/Button;
    const-string v2, "btnSetPassword"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v6, +005h
    const-string v3, ""
    goto +ch
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_forgot_password_set_password_btn I
    invoke-virtual v5, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSetPassword Landroid/widget/Button;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    xor-int/lit8 v2, v6, 1
    invoke-virtual v0, v2, Landroid/widget/Button;->setEnabled(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    xor-int/lit8 v2, v6, 1
    invoke-virtual v0, v2, Landroid/widget/EditText;->setEnabled(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etConfirmPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    xor-int/lit8 v6, v6, 1
    invoke-virtual v1, v6, Landroid/widget/EditText;->setEnabled(Z)V
    return-void 
.end method

.method private final setupBackHandler()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    move-object v1, v3
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupBackHandler$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupBackHandler$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    check-cast v2, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v0, v1, v2, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method private final setupListeners()void
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back_step1 I
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivClearEmailStep1 Landroid/widget/ImageView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "ivClearEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda3;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSendCode Landroid/widget/Button;
    if-nez v0, +008h
    const-string v0, "btnSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda4;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etEmailStep1 Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$4;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$4;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v0, v2, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back_step2 I
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda5;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v0, +009h
    const-string/jumbo v0, verifyCodeInput
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvResendCode
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda6;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back_step3 I
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda7;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$passwordWatcher$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$passwordWatcher$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    if-nez v2, +008h
    const-string v2, "etNewPassword"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    check-cast v0, Landroid/text/TextWatcher;
    invoke-virtual v2, v0, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v2, +008h
    const-string v2, "etConfirmPassword"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    invoke-virtual v2, v0, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSetPassword Landroid/widget/Button;
    if-nez v0, +008h
    const-string v0, "btnSetPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda8;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleNewPassword Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "ivToggleNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda9;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleConfirmPassword Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "ivToggleConfirmPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda10;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back_step4 I
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda1;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnGoLogin Landroid/widget/Button;
    if-nez v0, +008h
    const-string v0, "btnGoLogin"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda2;
    invoke-direct v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v1, v0, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupListeners$lambda$0(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->finish()V
    return-void 
.end method

.method private static final setupListeners$lambda$1(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etEmailStep1 Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etEmailStep1"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    return-void 
.end method

.method private static final setupListeners$lambda$10(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->finishWithEmail()V
    return-void 
.end method

.method private static final setupListeners$lambda$2(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->performSendCode()V
    return-void 
.end method

.method private static final setupListeners$lambda$3(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->goToStep1()V
    return-void 
.end method

.method private static final setupListeners$lambda$4(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    if-nez v1, +009h
    const-string/jumbo v1, tvResendCode
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Landroid/widget/TextView;->isEnabled()Z
    move-result v1
    if-eqz v1, +005h
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->performSendCode()V
    return-void 
.end method

.method private static final setupListeners$lambda$5(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->goToStep2()V
    return-void 
.end method

.method private static final setupListeners$lambda$6(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->performSetPassword()V
    return-void 
.end method

.method private static final setupListeners$lambda$7(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 6
    # ins_size=2
    iget-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isNewPasswordVisible Z
    xor-int/lit8 v5, v5, 1
    iput-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isNewPasswordVisible Z
    const-string v0, "ivToggleNewPassword"
    const-string v1, "etNewPassword"
    const/4 v2, 0
    if-eqz v5, +01dh
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    const/16 v3, 145
    invoke-virtual v5, v3, Landroid/widget/EditText;->setInputType(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleNewPassword Landroid/widget/ImageView;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_eye_open I
    invoke-virtual v5, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +1bh
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    const/16 v3, 129
    invoke-virtual v5, v3, Landroid/widget/EditText;->setInputType(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleNewPassword Landroid/widget/ImageView;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_eye_slash I
    invoke-virtual v5, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    iget-object v4, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
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

.method private static final setupListeners$lambda$8(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 6
    # ins_size=2
    iget-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isConfirmPasswordVisible Z
    xor-int/lit8 v5, v5, 1
    iput-boolean v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isConfirmPasswordVisible Z
    const-string v0, "ivToggleConfirmPassword"
    const-string v1, "etConfirmPassword"
    const/4 v2, 0
    if-eqz v5, +01dh
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    const/16 v3, 145
    invoke-virtual v5, v3, Landroid/widget/EditText;->setInputType(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleConfirmPassword Landroid/widget/ImageView;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_eye_open I
    invoke-virtual v5, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +1bh
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    const/16 v3, 129
    invoke-virtual v5, v3, Landroid/widget/EditText;->setInputType(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->ivToggleConfirmPassword Landroid/widget/ImageView;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_eye_slash I
    invoke-virtual v5, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    iget-object v4, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
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

.method private static final setupListeners$lambda$9(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->finishWithEmail()V
    return-void 
.end method

.method private final showStep1Error(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvErrorStep1 Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, tvErrorStep1
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep1 Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutErrorStep1"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    const/4 v0, 0
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutEmailInputStep1 Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutEmailInputStep1"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    sget v3, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_error I
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private final showStep2Error(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvErrorStep2 Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, tvErrorStep2
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep2 Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutErrorStep2"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    const/4 v0, 0
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v3, +009h
    const-string/jumbo v3, verifyCodeInput
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    const/4 v3, 1
    invoke-virtual v1, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setError(Z)V
    return-void 
.end method

.method private final showStep3Error(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvErrorStep3 Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, tvErrorStep3
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutErrorStep3 Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutErrorStep3"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    const/4 v0, 0
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutNewPasswordInput Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutNewPasswordInput"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_error I
    invoke-virtual v3, v0, Landroid/view/View;->setBackgroundResource(I)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->layoutConfirmPasswordInput Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "layoutConfirmPasswordInput"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    sget v3, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_edit_error I
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private final startResendCountdown()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    const/4 v1, 0
    const-string/jumbo v2, tvResendCode
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/TextView;->setEnabled(Z)V
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isCountdownActive Z
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v3, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->tvResendCode Landroid/widget/TextView;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Landroid/widget/TextView;->getPaintFlags()I
    move-result v1
    and-int/lit8 v1, v1, -9
    invoke-virtual v0, v1, Landroid/widget/TextView;->setPaintFlags(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->countDownTimer Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    new-instance v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;
    invoke-direct v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->start()Landroid/os/CountDownTimer;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->countDownTimer Landroid/os/CountDownTimer;
    return-void 
.end method

.method private final updateSetPasswordButtonState()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etNewPassword Landroid/widget/EditText;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "etNewPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    iget-object v2, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->etConfirmPassword Landroid/widget/EditText;
    if-nez v2, +008h
    const-string v2, "etConfirmPassword"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    invoke-virtual v2, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->btnSetPassword Landroid/widget/Button;
    if-nez v3, +008h
    const-string v3, "btnSetPassword"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v3, 1
    const/4 v4, 0
    if-lez v0, +004h
    move v0, v3
    goto +2h
    move v0, v4
    if-eqz v0, +014h
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    move v0, v3
    goto +2h
    move v0, v4
    if-eqz v0, +007h
    iget-boolean v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->isLoading Z
    if-nez v0, +003h
    goto +2h
    move v3, v4
    invoke-virtual v1, v3, Landroid/widget/Button;->setEnabled(Z)V
    return-void 
.end method

.method public com_bytedance_trae_login_enterprise_ForgotPasswordActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v2, Lcom/bytedance/trae/login/R$layout;->trae_activity_forgot_password I
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setContentView(I)V
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v0, "extra_email"
    invoke-virtual v2, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    iput-object v2, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->email Ljava/lang/String;
    if-nez v2, +008h
    const-string v2, "email"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +006h
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->finish()V
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->initViews()V
    invoke-direct v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupListeners()V
    invoke-direct v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->setupBackHandler()V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->countDownTimer Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->com_bytedance_trae_login_enterprise_ForgotPasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    return-void 
.end method
