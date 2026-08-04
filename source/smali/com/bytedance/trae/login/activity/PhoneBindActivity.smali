# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "PhoneBindActivity.kt"

.field private static final COUNTDOWN_SECONDS:I
.field public static final Companion:Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;
.field private static final ERROR_CODE_PHONE_ALREADY_BOUND:I
.field private static final ERROR_CODE_PHONE_ALREADY_BOUND_2:I
.field private static final ERROR_CODE_PHONE_ALREADY_BOUND_3:I
.field private static final EVENT_ACCOUNT_BINDING_RESULT:Ljava/lang/String;
.field public static final EXTRA_MODE:Ljava/lang/String;
.field public static final EXTRA_NEW_PHONE:Ljava/lang/String;
.field public static final EXTRA_PHONE_MASKED:Ljava/lang/String;
.field private static final EXTRA_SOURCE:Ljava/lang/String;
.field public static final MODE_BIND:Ljava/lang/String;
.field public static final MODE_CHANGE:Ljava/lang/String;
.field private static final NEW_CODE_LENGTH:I
.field private static final OLD_CODE_LENGTH:I
.field private static final RESULT_FAIL:Ljava/lang/String;
.field private static final RESULT_SUCCESS:Ljava/lang/String;
.field private static final SOURCE_SETTINGS:Ljava/lang/String;
.field private btnSendCode:Landroid/widget/TextView;
.field private btnSendCodeOld:Landroid/widget/TextView;
.field private countDownTimerNew:Landroid/os/CountDownTimer;
.field private countDownTimerOld:Landroid/os/CountDownTimer;
.field private etOldPhone:Landroid/widget/EditText;
.field private etPhone:Landroid/widget/EditText;
.field private final isSendingCode:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private loadingOverlay:Landroid/widget/FrameLayout;
.field private maskedPhone:Ljava/lang/String;
.field private mode:Ljava/lang/String;
.field private newPhoneNumber:Ljava/lang/String;
.field private oldPhoneNumber:Ljava/lang/String;
.field private source:Ljava/lang/String;
.field private ticket:Ljava/lang/String;
.field private tvNewPhoneTitle:Landroid/widget/TextView;
.field private tvResendNew:Landroid/widget/TextView;
.field private tvResendOld:Landroid/widget/TextView;
.field private tvVerifyNewHint:Landroid/widget/TextView;
.field private tvVerifyOldHint:Landroid/widget/TextView;
.field private verifyNewInput:Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
.field private verifyOldInput:Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
.field private viewFlipper:Landroid/widget/ViewFlipper;


.method public static synthetic $r8$lambda$4TIStPKbXpiyH9pw9YcDyT2kiYY(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->initViews$lambda$0(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$5UImAn8DNE_OBEsYVQOu-QjJqoY(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showPhoneConflictDialog$lambda$6(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QUVahlRfwQJwCx_jnongXtC9jE4(com.bytedance.trae.login.activity.PhoneBindActivity  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->runOnUiThreadSafe$lambda$5(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cUCIpodkCEhdZZsaU2EFf0Akobk(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->initViews$lambda$3(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fiiA-MnCuTqW_-xDvW3D3PWLW4E(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->initViews$lambda$1(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$gyhh5LpaCjzI1lGnD-PJWcARwNA(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->initViews$lambda$4(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uuQMMHdzxnnbhqT7B-rSMnj12Zk(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->initViews$lambda$2(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->Companion Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const-string v0, "bind"
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->mode Ljava/lang/String;
    const-string v0, ""
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->source Ljava/lang/String;
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->maskedPhone Ljava/lang/String;
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->ticket Ljava/lang/String;
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->oldPhoneNumber Ljava/lang/String;
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->newPhoneNumber Ljava/lang/String;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isSendingCode Ljava/util/concurrent/atomic/AtomicBoolean;
    return-void 
.end method

.method public static final synthetic access$getBtnSendCode$p(com.bytedance.trae.login.activity.PhoneBindActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->btnSendCode Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getBtnSendCodeOld$p(com.bytedance.trae.login.activity.PhoneBindActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->btnSendCodeOld Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getNewPhoneNumber$p(com.bytedance.trae.login.activity.PhoneBindActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->newPhoneNumber Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getOldPhoneNumber$p(com.bytedance.trae.login.activity.PhoneBindActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->oldPhoneNumber Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getTvResendNew$p(com.bytedance.trae.login.activity.PhoneBindActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendNew Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getTvResendOld$p(com.bytedance.trae.login.activity.PhoneBindActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendOld Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getTvVerifyOldHint$p(com.bytedance.trae.login.activity.PhoneBindActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvVerifyOldHint Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getVerifyNewInput$p(com.bytedance.trae.login.activity.PhoneBindActivity)com.bytedance.trae.login.widget.VerifyCodeInputView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyNewInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    return-object v0
.end method

.method public static final synthetic access$getVerifyOldInput$p(com.bytedance.trae.login.activity.PhoneBindActivity)com.bytedance.trae.login.widget.VerifyCodeInputView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyOldInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    return-object v0
.end method

.method public static final synthetic access$goToVerifyNewStep(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->goToVerifyNewStep()V
    return-void 
.end method

.method public static final synthetic access$isPhoneAlreadyBoundError(com.bytedance.trae.login.activity.PhoneBindActivity  int  java.lang.String)boolean
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isPhoneAlreadyBoundError(I Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$isSendingCode$p(com.bytedance.trae.login.activity.PhoneBindActivity)java.util.concurrent.atomic.AtomicBoolean
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isSendingCode Ljava/util/concurrent/atomic/AtomicBoolean;
    return-object v0
.end method

.method public static final synthetic access$runOnUiThreadSafe(com.bytedance.trae.login.activity.PhoneBindActivity  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->runOnUiThreadSafe(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static final synthetic access$sendCodeToOldPhone(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->sendCodeToOldPhone()V
    return-void 
.end method

.method public static final synthetic access$setTicket$p(com.bytedance.trae.login.activity.PhoneBindActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->ticket Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$showLoading(com.bytedance.trae.login.activity.PhoneBindActivity  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showLoading(Z)V
    return-void 
.end method

.method public static final synthetic access$showPhoneConflictDialog(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showPhoneConflictDialog()V
    return-void 
.end method

.method public static final synthetic access$showStep(com.bytedance.trae.login.activity.PhoneBindActivity  int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showStep(I)V
    return-void 
.end method

.method public static final synthetic access$startCountdownOld(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->startCountdownOld()V
    return-void 
.end method

.method public static final synthetic access$submitFinal(com.bytedance.trae.login.activity.PhoneBindActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->submitFinal(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$trackSettingsPhoneBindingResult(com.bytedance.trae.login.activity.PhoneBindActivity  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->trackSettingsPhoneBindingResult(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$validateOldPhone(com.bytedance.trae.login.activity.PhoneBindActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->validateOldPhone(Ljava/lang/String;)V
    return-void 
.end method

.method private final checkSafeEnv()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    invoke-direct v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showLoading(Z)V
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v0, Lcom/bytedance/sdk/account/api/callback/SafeVerifyCallback;
    invoke-static v0, Lcom/bytedance/sdk/account/helper/ChangeMobileHelper;->checkSafeEnvBeforeSendCodeToOld(Lcom/bytedance/sdk/account/api/callback/SafeVerifyCallback;)V
    return-void 
.end method

.method public static com_bytedance_trae_login_activity_PhoneBindActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->com_bytedance_trae_login_activity_PhoneBindActivity__onStop$___twin___()V
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

.method private final goToVerifyNewStep()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvVerifyNewHint Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, tvVerifyNewHint
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_phone_code_sent_to I
    const/4 v3, 1
    new-array v4, v3, [Ljava/lang/Object;
    const/4 v5, 0
    iget-object v6, v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->newPhoneNumber Ljava/lang/String;
    aput-object v6, v4, v5
    invoke-virtual v7, v2, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/4 v0, 3
    invoke-direct v7, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showStep(I)V
    invoke-direct v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->startCountdownNew()V
    iget-object v0, v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyNewInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string/jumbo v2, verifyNewInput
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    const-string v0, "input_method"
    invoke-virtual v7, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v4, v0, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v4, +005h
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    move-object v0, v1
    if-eqz v0, +010h
    iget-object v4, v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyNewInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, v3, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method private final initViews()void
    .registers 7
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_back I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->view_flipper I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ViewFlipper;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->viewFlipper Landroid/widget/ViewFlipper;
    sget v0, Lcom/bytedance/trae/login/R$id;->loading_overlay I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->loadingOverlay Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_nav_title I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iget-object v2, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->mode Ljava/lang/String;
    const-string v3, "change"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_phone_change_title I
    goto +3h
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_phone_bind_title I
    invoke-virtual v6, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->et_old_phone I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->etOldPhone Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_send_code_old I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->btnSendCodeOld Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_verify_old_hint I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvVerifyOldHint Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->verify_old_input I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyOldInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string/jumbo v2, verifyOldInput
    const/4 v3, 0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/4 v4, 4
    invoke-virtual v0, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setBoxCount(I)V
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_resend_old I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendOld Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_new_phone_title I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvNewPhoneTitle Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->et_phone I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->etPhone Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_send_code I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->btnSendCode Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_verify_new_hint I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvVerifyNewHint Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->verify_new_input I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyNewInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string/jumbo v5, verifyNewInput
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setBoxCount(I)V
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_resend_new I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendNew Landroid/widget/TextView;
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->etOldPhone Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etOldPhone"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$2;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$2;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->btnSendCodeOld Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnSendCodeOld"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda2;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyOldInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$4;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$4;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendOld Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvResendOld
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda3;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->etPhone Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etPhone"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$6;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$6;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->btnSendCode Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda4;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyNewInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$8;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$8;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendNew Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, tvResendNew
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda5;
    invoke-direct v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-virtual v3, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final initViews$lambda$0(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->finish()V
    return-void 
.end method

.method private static final initViews$lambda$1(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->onSendCodeOldClicked()V
    return-void 
.end method

.method private static final initViews$lambda$2(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->sendCodeToOldPhone()V
    return-void 
.end method

.method private static final initViews$lambda$3(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->sendCodeToNewPhone()V
    return-void 
.end method

.method private static final initViews$lambda$4(com.bytedance.trae.login.activity.PhoneBindActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->resendCodeToNewPhone()V
    return-void 
.end method

.method private final isPhoneAlreadyBoundError(int  java.lang.String)boolean
    .registers 7
    # ins_size=3
    const/16 v0, 1001
    const/4 v1, 1
    if-eq v5, v0, +01eh
    const/16 v0, 1007
    if-eq v5, v0, +01ah
    const/16 v0, 1041
    if-eq v5, v0, +016h
    const/4 v5, 0
    if-eqz v6, +012h
    check-cast v6, Ljava/lang/CharSequence;
    const-string/jumbo v0, 已被绑定到其他账号
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v6, v0, v5, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v6
    if-ne v6, v1, +003h
    goto +2h
    move v1, v5
    return v1
.end method

.method private final onSendCodeOldClicked()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->etOldPhone Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etOldPhone"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    new-instance v2, Lkotlin/text/Regex;
    const-string v3, "^1\d{10}$"
    invoke-direct v2, v3, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v1, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +010h
    move-object v0, v4
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_phone_invalid I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    iput-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->oldPhoneNumber Ljava/lang/String;
    invoke-direct v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->checkSafeEnv()V
    return-void 
.end method

.method private final resendCodeToNewPhone()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->sendCodeToNewPhone()V
    return-void 
.end method

.method private final runOnUiThreadSafe(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final runOnUiThreadSafe$lambda$5(com.bytedance.trae.login.activity.PhoneBindActivity  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isDestroyed()Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final sendCodeToNewPhone()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->etPhone Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etPhone"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    new-instance v2, Lkotlin/text/Regex;
    const-string v3, "^1\d{10}$"
    invoke-direct v2, v3, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v1, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z
    move-result v1
    const/4 v2, 0
    if-nez v1, +00fh
    move-object v0, v4
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_phone_invalid I
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    iget-object v1, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isSendingCode Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v3, 1
    invoke-virtual v1, v2, v3, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v1
    if-nez v1, +003h
    return-void 
    iput-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->newPhoneNumber Ljava/lang/String;
    iget-object v1, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->mode Ljava/lang/String;
    const-string v3, "bind"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00dh
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v1, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
    invoke-static v0, v1, Lcom/bytedance/sdk/account/helper/BindMobileHelper;->sendCode(Ljava/lang/String; Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;)V
    goto +dh
    iget-object v1, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->ticket Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;
    invoke-direct v3, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v3, Lcom/bytedance/sdk/account/AccountSdkCallback;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/sdk/account/helper/ChangeMobileHelper;->sendCodeToNew(Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/sdk/account/AccountSdkCallback;)V
    return-void 
.end method

.method private final sendCodeToOldPhone()void
    .registers 3
    # ins_size=1
    const/4 v0, 1
    invoke-direct v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showLoading(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->oldPhoneNumber Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v1, Lcom/bytedance/sdk/account/AccountSdkCallback;
    invoke-static v0, v1, Lcom/bytedance/sdk/account/helper/ChangeMobileHelper;->sendCodeToOld(Ljava/lang/String; Lcom/bytedance/sdk/account/AccountSdkCallback;)V
    return-void 
.end method

.method private final showLoading(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->loadingOverlay Landroid/widget/FrameLayout;
    if-nez v0, +008h
    const-string v0, "loadingOverlay"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    return-void 
.end method

.method private final showPhoneConflictDialog()void
    .registers 22
    # ins_size=1
    move-object/from16 v0, v21
    sget-object v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_phone_conflict_title I
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    move-object v3, v4
    const-string v7, "getString(...)"
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_phone_conflict_message I
    invoke-virtual v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v5
    move-object v4, v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v5, 0
    sget v6, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_phone_conflict_button I
    invoke-virtual v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v8
    move-object v6, v8
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    new-instance v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda6;
    move-object/from16 v17, v5
    invoke-direct v5, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    const/16 v18, 0
    const v19, 98280
    const/16 v20, 0
    const/4 v5, 0
    invoke-static/range v1 ... v20, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showPhoneConflictDialog$lambda$6(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->etPhone Landroid/widget/EditText;
    if-nez v0, +008h
    const-string v0, "etPhone"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    const-string v1, ""
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    const/4 v0, 2
    invoke-direct v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showStep(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final showStep(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->viewFlipper Landroid/widget/ViewFlipper;
    if-nez v0, +009h
    const-string/jumbo v0, viewFlipper
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, Landroid/widget/ViewFlipper;->setDisplayedChild(I)V
    return-void 
.end method

.method private final startCountdownNew()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->countDownTimerNew Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendNew Landroid/widget/TextView;
    const/4 v1, 0
    const-string/jumbo v2, tvResendNew
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/TextView;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendNew Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getColor(I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;
    invoke-direct v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->start()Landroid/os/CountDownTimer;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->countDownTimerNew Landroid/os/CountDownTimer;
    return-void 
.end method

.method private final startCountdownOld()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->countDownTimerOld Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendOld Landroid/widget/TextView;
    const/4 v1, 0
    const-string/jumbo v2, tvResendOld
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/TextView;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvResendOld Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getColor(I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownOld$1;
    invoke-direct v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownOld$1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownOld$1;->start()Landroid/os/CountDownTimer;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->countDownTimerOld Landroid/os/CountDownTimer;
    return-void 
.end method

.method private final startFlow()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->mode Ljava/lang/String;
    const-string v1, "change"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    const-string/jumbo v2, tvNewPhoneTitle
    if-eqz v0, +015h
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvNewPhoneTitle Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/login/R$string;->trae_phone_input_new_title I
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(I)V
    const/4 v0, 0
    invoke-direct v3, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showStep(I)V
    goto +13h
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->tvNewPhoneTitle Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/login/R$string;->trae_phone_bind_title I
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(I)V
    const/4 v0, 2
    invoke-direct v3, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showStep(I)V
    return-void 
.end method

.method private final submitFinal(java.lang.String)void
    .registers 6
    # ins_size=2
    const/4 v0, 1
    invoke-direct v4, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showLoading(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyNewInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, verifyNewInput
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->mode Ljava/lang/String;
    const-string v3, "bind"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00fh
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->newPhoneNumber Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$1;
    invoke-direct v3, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v3, Lcom/bytedance/sdk/account/mobile/thread/call/BindMobileCallback;
    invoke-static v0, v5, v1, v2, v3, Lcom/bytedance/sdk/account/helper/BindMobileHelper;->bindMobile(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/sdk/account/mobile/thread/call/BindMobileCallback;)V
    goto +fh
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->newPhoneNumber Ljava/lang/String;
    iget-object v1, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->ticket Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;
    invoke-direct v2, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v2, Lcom/bytedance/sdk/account/mobile/thread/call/ChangeMobileNumCallback;
    invoke-static v0, v5, v1, v2, Lcom/bytedance/sdk/account/helper/ChangeMobileHelper;->changeBind(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/sdk/account/mobile/thread/call/ChangeMobileNumCallback;)V
    return-void 
.end method

.method private final trackSettingsPhoneBindingResult(java.lang.String  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 9
    # ins_size=5
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->source Ljava/lang/String;
    const-string/jumbo v1, settings
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "current_page"
    invoke-virtual v2, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, type
    const-string/jumbo v3, phone
    invoke-virtual v2, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v1, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->mode Ljava/lang/String;
    const-string v3, "change"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const-string v3, "bind"
    const-string v1, "action"
    invoke-virtual v2, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, result
    invoke-virtual v2, v1, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, stage
    invoke-virtual v2, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v7, +011h
    check-cast v7, Ljava/lang/Number;
    invoke-virtual v7, Ljava/lang/Number;->intValue()I
    move-result v5
    const-string v6, "error_code"
    invoke-static v5, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v8, +007h
    const-string v5, "fail_reason"
    invoke-virtual v2, v5, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v5, "icube_account_binding_result"
    invoke-virtual v0, v5, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method static synthetic trackSettingsPhoneBindingResult$default(com.bytedance.trae.login.activity.PhoneBindActivity  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->trackSettingsPhoneBindingResult(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method private final validateOldPhone(java.lang.String)void
    .registers 5
    # ins_size=2
    const/4 v0, 1
    invoke-direct v3, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->showLoading(Z)V
    iget-object v1, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->verifyOldInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-nez v1, +009h
    const-string/jumbo v1, verifyOldInput
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    check-cast v1, Lcom/bytedance/sdk/account/mobile/thread/call/ValidateCodeCallBack;
    invoke-static v4, v0, v1, Lcom/bytedance/sdk/account/helper/ChangeMobileHelper;->validateOld(Ljava/lang/String; Z Lcom/bytedance/sdk/account/mobile/thread/call/ValidateCodeCallBack;)V
    return-void 
.end method

.method public com_bytedance_trae_login_activity_PhoneBindActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/login/R$layout;->trae_activity_phone_bind I
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->setContentView(I)V
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v0, "extra_mode"
    invoke-virtual v3, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +004h
    const-string v3, "bind"
    iput-object v3, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->mode Ljava/lang/String;
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v0, "extra_source"
    invoke-virtual v3, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string v0, ""
    if-nez v3, +003h
    move-object v3, v0
    iput-object v3, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->source Ljava/lang/String;
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v1, "extra_phone_masked"
    invoke-virtual v3, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v0, v3
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->maskedPhone Ljava/lang/String;
    invoke-direct v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->initViews()V
    invoke-direct v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->startFlow()V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->countDownTimerOld Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->countDownTimerNew Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->com_bytedance_trae_login_activity_PhoneBindActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    return-void 
.end method
