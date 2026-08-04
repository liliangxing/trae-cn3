# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
.super Landroidx/fragment/app/Fragment;
.source "DeleteAccountFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Companion;
.field private static final TAG:Ljava/lang/String;
.field private authType:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
.field private btnGoogleVerify:Landroid/widget/TextView;
.field private btnOkCountdown:Landroid/widget/TextView;
.field private btnSendCode:Landroid/widget/TextView;
.field private btnSmsSendCode:Landroid/widget/TextView;
.field private btnSmsVerify:Landroid/widget/TextView;
.field private btnVerify:Landroid/widget/TextView;
.field private cancelTicket:Ljava/lang/String;
.field private currentStep:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
.field private etEmail:Landroid/widget/EditText;
.field private etSmsCode:Landroid/widget/EditText;
.field private etVerificationCode:Landroid/widget/EditText;
.field private finishCountdownJob:Lkotlinx/coroutines/Job;
.field private final googleSignInLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private isLoading:Z
.field private loginService:Lcom/bytedance/trae/login/api/ILoginService;
.field private nickname:Ljava/lang/String;
.field private progressLoading:Landroid/widget/ProgressBar;
.field private scrollContent:Landroid/widget/ScrollView;
.field private sendCodeCountdown:I
.field private sendCodeJob:Lkotlinx/coroutines/Job;
.field private stepConfirm:Landroid/view/View;
.field private stepEmailVerify:Landroid/view/View;
.field private stepOauthVerify:Landroid/view/View;
.field private stepSmsVerify:Landroid/view/View;
.field private stepSubmitted:Landroid/view/View;
.field private tvConfirmUserInfo:Landroid/widget/TextView;
.field private tvOauthNickname:Landroid/widget/TextView;
.field private tvOauthUnsupported:Landroid/widget/TextView;
.field private tvSmsVerifyHint:Landroid/widget/TextView;
.field private userMobile:Ljava/lang/String;
.field private valueTicket:Ljava/lang/String;
.field private verifyToken:Ljava/lang/String;


.method public static synthetic $r8$lambda$1qd7H2FhiPqx4zAHBbud6ZCNJ4U(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$4(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$F0gI9TsQe6s0U_seatWgH8lFqJg(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$3(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$KytIY0yFm6PZ0B9trB7LGqlK7dg(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$12(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Pidob9m8Q_zlLIe63Gfy7ugGQOs(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showFinalConfirmDialog$lambda$14(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$PwD5bJYKSHnh0x8JLJHOVwsi1Ks(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$7(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$SfiqVlfbqNP7xtNEvPWIdHgUPzI(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->googleSignInLauncher$lambda$0(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Z-vo2JHSWD18oZaA2RfJx80-KSY(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$10(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$bC2A7kpOfEONuZF3eAfuOU-Mh7I(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$11(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$e1nDqEokw--GuoUXvyVSt-tUq4s(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$9(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hS25zSrbHk-BekHTMFB3huBH3RQ(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$5(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hcXs_KsiBdgUHxDZKSvP2lqKT_o(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$8(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$t2WJXuRDCmDMeJfD6WNdGs4POO4(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$2(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$yIBZZjEO-O4_Iio-eFaEIrx0SEA(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$6(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$yjI7aXTpQlgsmjs5Ghb3NWlmBEY(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners$lambda$1(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/fragment/app/Fragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->VERIFY Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->currentStep Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda5;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->googleSignInLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$getBtnGoogleVerify$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnGoogleVerify Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getBtnOkCountdown$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnOkCountdown Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getBtnSendCode$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSendCode Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getBtnSmsSendCode$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsSendCode Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getBtnSmsVerify$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsVerify Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getBtnVerify$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnVerify Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getCancelTicket$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->cancelTicket Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getLoginService$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)com.bytedance.trae.login.api.ILoginService
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->loginService Lcom/bytedance/trae/login/api/ILoginService;
    return-object v0
.end method

.method public static final synthetic access$getSendCodeCountdown$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeCountdown I
    return v0
.end method

.method public static final synthetic access$getValueTicket$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->valueTicket Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getVerifyToken$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->verifyToken Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$navigateToLogin(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->navigateToLogin()V
    return-void 
.end method

.method public static final synthetic access$performCancelCheckAndProceed(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->performCancelCheckAndProceed(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setAuthType$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  com.bytedance.trae.home.solo.setting.DeleteAccountFragment$AuthType)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->authType Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    return-void 
.end method

.method public static final synthetic access$setLoading$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    return-void 
.end method

.method public static final synthetic access$setNickname$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->nickname Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setSendCodeCountdown$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeCountdown I
    return-void 
.end method

.method public static final synthetic access$setUserMobile$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->userMobile Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setValueTicket$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->valueTicket Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setVerifyToken$p(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->verifyToken Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$showLoading(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showLoading(Z)V
    return-void 
.end method

.method public static final synthetic access$showStep(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  com.bytedance.trae.home.solo.setting.DeleteAccountFragment$Step)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showStep(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;)V
    return-void 
.end method

.method public static final synthetic access$showToast(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showToast(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$startFinishCountdown(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->startFinishCountdown()V
    return-void 
.end method

.method public static final synthetic access$startSendCodeCountdown(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->startSendCodeCountdown()V
    return-void 
.end method

.method public static final synthetic access$startSmsSendCodeCountdown(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->startSmsSendCodeCountdown()V
    return-void 
.end method

.method private final bindViews(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/home/R$id;->progress_loading I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->progressLoading Landroid/widget/ProgressBar;
    sget v0, Lcom/bytedance/trae/home/R$id;->scroll_content I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ScrollView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->scrollContent Landroid/widget/ScrollView;
    sget v0, Lcom/bytedance/trae/home/R$id;->step_email_verify I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepEmailVerify Landroid/view/View;
    sget v0, Lcom/bytedance/trae/home/R$id;->et_email I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etEmail Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/home/R$id;->et_verification_code I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etVerificationCode Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_send_code I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSendCode Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_verify I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnVerify Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->step_oauth_verify I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepOauthVerify Landroid/view/View;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_oauth_nickname I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvOauthNickname Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_oauth_unsupported I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvOauthUnsupported Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_google_verify I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnGoogleVerify Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->step_sms_verify I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepSmsVerify Landroid/view/View;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_sms_verify_hint I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvSmsVerifyHint Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->et_sms_code I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etSmsCode Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_sms_send_code I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsSendCode Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_sms_verify I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsVerify Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->step_confirm I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepConfirm Landroid/view/View;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_confirm_user_info I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvConfirmUserInfo Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->step_submitted I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepSubmitted Landroid/view/View;
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_ok_countdown I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnOkCountdown Landroid/widget/TextView;
    return-void 
.end method

.method private final confirmDelete()void
    .registers 8
    # ins_size=1
    iget-boolean v0, v7, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v7, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final googleSignInLauncher$lambda$0(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  androidx.activity.result.ActivityResult)void
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "googleSignInLauncher result: resultCode="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasData="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v7, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "DeleteAccountFragment"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->loginService Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-virtual v7, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v5
    invoke-interface v0, v5, Lcom/bytedance/trae/login/api/ILoginService;->parseGoogleSignInResult(Landroid/content/Intent;)Ljava/util/Map;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +006h
    invoke-direct v6, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->handleGoogleAuthSuccess(Ljava/util/Map;)V
    goto +2dh
    iput-boolean v4, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnGoogleVerify Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnGoogleVerify"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v3, Landroid/widget/TextView;->setEnabled(Z)V
    invoke-virtual v7, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v7
    if-nez v7, +00ah
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v7, "Google sign-in cancelled by user"
    invoke-virtual v6, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +fh
    sget v7, Lcom/bytedance/trae/home/R$string;->trae_delete_verify_failed I
    invoke-virtual v6, v7, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v7
    const-string v0, "getString(...)"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showToast(Ljava/lang/String;)V
    return-void 
.end method

.method private final handleGoogleAuthSuccess(java.util.Map)void
    .registers 9
    # ins_size=2
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isAdded()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$handleGoogleAuthSuccess$1;
    const/4 v4, 0
    invoke-direct v0, v8, v7, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$handleGoogleAuthSuccess$1;-><init>(Ljava/util/Map; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final init()void
    .registers 8
    # ins_size=1
    const/4 v0, 1
    invoke-direct v7, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showLoading(Z)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final maskPhone(java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 4
    if-gt v0, v1, +003h
    return-object v5
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    sub-int/2addr v0, v1
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v2
    sub-int/2addr v2, v1
    const/4 v3, 3
    invoke-static v3, v2, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v2
    sub-int/2addr v0, v2
    const/4 v2, 0
    invoke-virtual v5, v2, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, substring(...)
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v5, v1, Lkotlin/text/StringsKt;->takeLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v5
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v2
    sub-int/2addr v5, v2
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v2
    sub-int/2addr v5, v2
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, "*"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, v5, Lkotlin/text/StringsKt;->repeat(Ljava/lang/CharSequence; I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private final navigateToLogin()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isAdded()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseManager;->onUserLogout()V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->loginService Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00fh
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$navigateToLogin$1;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$navigateToLogin$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/login/api/IAccountCallback;
    const-string v2, "account_deleted"
    const/4 v3, 1
    invoke-interface v0, v3, v1, v2, Lcom/bytedance/trae/login/api/ILoginService;->logout(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method private final performCancelCheckAndProceed(kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=2
    const-string v0, "cancelCheck failed: "
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;
    if-eqz v1, +012h
    move-object v1, v8
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;
    iget v2, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v8, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->label I
    sub-int/2addr v8, v3
    iput v8, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;
    invoke-direct v1, v7, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->label I
    const-string v4, ", proceeding without cancel_ticket"
    const-string v5, "DeleteAccountFragment"
    const/4 v6, 1
    if-eqz v3, +016h
    if-ne v3, v6, +00ch
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    move-exception v8
    goto +50h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->Companion Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->valueTicket Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->L$0 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$performCancelCheckAndProceed$1;->label I
    invoke-virtual v8, v3, v1, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->cancelCheck(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v2, +003h
    return-object v2
    move-object v1, v7
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/CancelCheckResponse;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/CancelCheckResponse;->getErrorCode()I
    move-result v2
    if-eqz v2, +01dh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/CancelCheckResponse;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v5, v8, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +2eh
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/CancelCheckResponse;->getData()Lcom/bytedance/trae/home/solo/setting/CancelCheckData;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/CancelCheckData;->getCancelTicket()Ljava/lang/String;
    move-result-object v8
    goto +2h
    const/4 v8, 0
    iput-object v8, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->cancelTicket Ljava/lang/String;
    goto +1fh
    move-exception v8
    move-object v1, v7
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "cancelCheck error: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v5, v8, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->CONFIRM Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-direct v1, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showStep(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    :try_start_0x30
    :try_start_0x41
    :try_start_0x51
.end method

.method private final sendSmsVerificationCode()void
    .registers 11
    # ins_size=1
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->userMobile Ljava/lang/String;
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +011h
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_delete_sms_no_phone I
    invoke-virtual v10, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v10, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showToast(Ljava/lang/String;)V
    return-void 
    iget v1, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeCountdown I
    if-gtz v1, +030h
    iget-boolean v1, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    if-eqz v1, +003h
    goto +2ah
    iput-boolean v3, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsSendCode Landroid/widget/TextView;
    const/4 v3, 0
    if-nez v1, +008h
    const-string v1, "btnSmsSendCode"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v1, v2, Landroid/widget/TextView;->setEnabled(Z)V
    move-object v1, v10
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendSmsVerificationCode$1;
    invoke-direct v1, v0, v10, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendSmsVerificationCode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final sendVerificationCode()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etEmail Landroid/widget/EditText;
    const-string v1, "etEmail"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v4
    const/4 v5, 1
    const/4 v6, 0
    if-nez v4, +004h
    move v4, v5
    goto +2h
    move v4, v6
    if-nez v4, +041h
    sget-object v4, Landroid/util/Patterns;->EMAIL_ADDRESS Ljava/util/regex/Pattern;
    invoke-virtual v4, v3, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    move-result-object v3
    invoke-virtual v3, Ljava/util/regex/Matcher;->matches()Z
    move-result v3
    if-nez v3, +003h
    goto +33h
    iget v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeCountdown I
    if-gtz v1, +02fh
    iget-boolean v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    if-eqz v1, +003h
    goto +29h
    iput-boolean v5, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSendCode Landroid/widget/TextView;
    if-nez v1, +008h
    const-string v1, "btnSendCode"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, v6, Landroid/widget/TextView;->setEnabled(Z)V
    move-object v1, v9
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;
    invoke-direct v1, v0, v9, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etEmail Landroid/widget/EditText;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Landroid/widget/EditText;->requestFocus()Z
    return-void 
.end method

.method private final setupListeners(android.view.View)void
    .registers 5
    # ins_size=2
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda6;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSendCode Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "btnSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda9;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnVerify Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnVerify"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda10;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel_verify I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda11;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel_oauth I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda12;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnGoogleVerify Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnGoogleVerify"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda13;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsSendCode Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnSmsSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda1;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsVerify Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnSmsVerify"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda2;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel_sms I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda3;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_confirm_delete I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda4;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel_confirm I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda7;
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v4, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnOkCountdown Landroid/widget/TextView;
    if-nez v4, +008h
    const-string v4, "btnOkCountdown"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda8;
    invoke-direct v4, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    invoke-virtual v1, v4, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupListeners$lambda$1(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final setupListeners$lambda$10(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showFinalConfirmDialog()V
    return-void 
.end method

.method private static final setupListeners$lambda$11(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final setupListeners$lambda$12(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->finishCountdownJob Lkotlinx/coroutines/Job;
    if-eqz v3, +007h
    const/4 v0, 1
    const/4 v1, 0
    invoke-static v3, v1, v0, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->navigateToLogin()V
    return-void 
.end method

.method private static final setupListeners$lambda$2(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendVerificationCode()V
    return-void 
.end method

.method private static final setupListeners$lambda$3(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->verifyEmailCode()V
    return-void 
.end method

.method private static final setupListeners$lambda$4(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final setupListeners$lambda$5(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final setupListeners$lambda$6(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->verifyGoogleAuth()V
    return-void 
.end method

.method private static final setupListeners$lambda$7(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendSmsVerificationCode()V
    return-void 
.end method

.method private static final setupListeners$lambda$8(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->verifySmsCode()V
    return-void 
.end method

.method private static final setupListeners$lambda$9(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private final showFinalConfirmDialog()void
    .registers 22
    # ins_size=1
    move-object/from16 v0, v21
    invoke-virtual/range v21, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->authType Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    const/4 v3, -1
    if-nez v1, +004h
    move v1, v3
    goto +9h
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->ordinal()I
    move-result v1
    aget v1, v4, v1
    const/4 v4, 1
    const-string v5, ""
    if-eq v1, v3, +046h
    const/4 v3, 0
    if-eq v1, v4, +026h
    const/4 v6, 2
    if-eq v1, v6, +016h
    const/4 v3, 3
    if-eq v1, v3, +00ch
    const/4 v3, 4
    if-ne v1, v3, +003h
    goto +7h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->nickname Ljava/lang/String;
    if-nez v1, +003h
    goto +2dh
    move-object v5, v1
    goto +2bh
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->userMobile Ljava/lang/String;
    if-eqz v1, +006h
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->maskPhone(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +20h
    move-object v5, v3
    goto +1eh
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etEmail Landroid/widget/EditText;
    if-nez v1, +008h
    const-string v1, "etEmail"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v3, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    sget-object v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_delete_dialog_title I
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v6
    move-object v3, v6
    const-string v7, "getString(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/home/R$string;->trae_delete_dialog_message I
    new-array v4, v4, [Ljava/lang/Object;
    const/4 v8, 0
    aput-object v5, v4, v8
    invoke-virtual v0, v6, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    move-object v4, v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_cancel I
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v6
    move-object v5, v6
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/home/R$string;->trae_delete_confirm_delete I
    invoke-virtual v0, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
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
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda0;
    move-object/from16 v17, v7
    invoke-direct v7, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    const/16 v18, 0
    const v19, 98272
    const/16 v20, 0
    const/4 v7, 0
    invoke-static/range v1 ... v20, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showFinalConfirmDialog$lambda$14(com.bytedance.trae.home.solo.setting.DeleteAccountFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->confirmDelete()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final showLoading(boolean)void
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->progressLoading Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressLoading"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    const/16 v3, 8
    if-eqz v6, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v0, v4, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->scrollContent Landroid/widget/ScrollView;
    if-nez v0, +009h
    const-string/jumbo v0, scrollContent
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    if-eqz v6, +003h
    move v2, v3
    invoke-virtual v1, v2, Landroid/widget/ScrollView;->setVisibility(I)V
    return-void 
.end method

.method private final showStep(com.bytedance.trae.home.solo.setting.DeleteAccountFragment$Step)void
    .registers 16
    # ins_size=2
    iput-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->currentStep Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepEmailVerify Landroid/view/View;
    const-string/jumbo v1, stepEmailVerify
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepSmsVerify Landroid/view/View;
    const-string/jumbo v4, stepSmsVerify
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepOauthVerify Landroid/view/View;
    const-string/jumbo v5, stepOauthVerify
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepConfirm Landroid/view/View;
    const-string/jumbo v6, stepConfirm
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepSubmitted Landroid/view/View;
    const-string/jumbo v7, stepSubmitted
    if-nez v0, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->ordinal()I
    move-result v15
    aget v15, v0, v15
    const/4 v0, 4
    const/4 v8, 3
    const/4 v9, 2
    const-string v10, ""
    const/4 v11, -1
    const/4 v12, 1
    const/4 v13, 0
    if-eq v15, v12, +087h
    if-eq v15, v9, +018h
    if-ne v15, v8, +010h
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepSubmitted Landroid/view/View;
    if-nez v15, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v15
    invoke-virtual v2, v13, Landroid/view/View;->setVisibility(I)V
    goto/16 +157h
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepConfirm Landroid/view/View;
    if-nez v15, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    invoke-virtual v15, v13, Landroid/view/View;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->authType Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    if-nez v15, +004h
    move v15, v11
    goto +9h
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->ordinal()I
    move-result v15
    aget v15, v1, v15
    if-eq v15, v11, +041h
    if-eq v15, v12, +023h
    if-eq v15, v9, +014h
    if-eq v15, v8, +00bh
    if-ne v15, v0, +003h
    goto +7h
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->nickname Ljava/lang/String;
    if-nez v15, +003h
    goto +2ch
    move-object v10, v15
    goto +2ah
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->userMobile Ljava/lang/String;
    if-eqz v15, +007h
    invoke-direct v14, v15, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->maskPhone(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v2
    if-nez v15, -00ch
    goto +1dh
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etEmail Landroid/widget/EditText;
    if-nez v15, +008h
    const-string v15, "etEmail"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    invoke-virtual v15, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v15
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v15, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvConfirmUserInfo Landroid/widget/TextView;
    if-nez v15, +009h
    const-string/jumbo v15, tvConfirmUserInfo
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v15
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v2, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto/16 +0e4h
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->authType Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    if-nez v15, +004h
    move v15, v11
    goto +9h
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->ordinal()I
    move-result v15
    aget v15, v6, v15
    if-eq v15, v11, +0cdh
    if-eq v15, v12, +0beh
    if-eq v15, v9, +087h
    const-string/jumbo v1, tvOauthNickname
    const-string/jumbo v4, tvOauthUnsupported
    if-eq v15, v8, +04bh
    if-ne v15, v0, +043h
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepOauthVerify Landroid/view/View;
    if-nez v15, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    invoke-virtual v15, v13, Landroid/view/View;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvOauthNickname Landroid/widget/TextView;
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->nickname Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v15, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvOauthUnsupported Landroid/widget/TextView;
    if-nez v15, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    invoke-virtual v15, v13, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvOauthUnsupported Landroid/widget/TextView;
    if-nez v15, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v15
    sget v15, Lcom/bytedance/trae/home/R$string;->trae_delete_oauth_unsupported I
    new-array v0, v12, [Ljava/lang/Object;
    const-string v1, "GitHub"
    aput-object v1, v0, v13
    invoke-virtual v14, v15, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v15
    check-cast v15, Ljava/lang/CharSequence;
    invoke-virtual v2, v15, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto/16 +085h
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepOauthVerify Landroid/view/View;
    if-nez v15, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    invoke-virtual v15, v13, Landroid/view/View;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvOauthNickname Landroid/widget/TextView;
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->nickname Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v15, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvOauthUnsupported Landroid/widget/TextView;
    if-nez v15, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    invoke-virtual v15, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnGoogleVerify Landroid/widget/TextView;
    if-nez v15, +008h
    const-string v15, "btnGoogleVerify"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v15
    invoke-virtual v2, v13, Landroid/widget/TextView;->setVisibility(I)V
    goto +4ah
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepSmsVerify Landroid/view/View;
    if-nez v15, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v2
    invoke-virtual v15, v13, Landroid/view/View;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->userMobile Ljava/lang/String;
    if-eqz v15, +007h
    invoke-direct v14, v15, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->maskPhone(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v2
    if-nez v15, +003h
    goto +2h
    move-object v10, v15
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->tvSmsVerifyHint Landroid/widget/TextView;
    if-nez v15, +009h
    const-string/jumbo v15, tvSmsVerifyHint
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v15
    sget v15, Lcom/bytedance/trae/home/R$string;->trae_delete_sms_verify_hint I
    new-array v0, v12, [Ljava/lang/Object;
    aput-object v10, v0, v13
    invoke-virtual v14, v15, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v15
    check-cast v15, Ljava/lang/CharSequence;
    invoke-virtual v2, v15, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +15h
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->stepEmailVerify Landroid/view/View;
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v15
    invoke-virtual v2, v13, Landroid/view/View;->setVisibility(I)V
    goto +8h
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v15
    invoke-virtual v15, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private final showToast(java.lang.String)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isAdded()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v0, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final startFinishCountdown()void
    .registers 10
    # ins_size=1
    new-instance v0, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    const/4 v1, 5
    iput v1, v0, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnOkCountdown Landroid/widget/TextView;
    const/4 v2, 0
    if-nez v1, +008h
    const-string v1, "btnOkCountdown"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_delete_ok_countdown I
    const/4 v4, 1
    new-array v4, v4, [Ljava/lang/Object;
    iget v5, v0, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/4 v6, 0
    aput-object v5, v4, v6
    invoke-virtual v9, v3, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    move-object v1, v9
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;
    invoke-direct v1, v0, v9, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;-><init>(Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->finishCountdownJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startSendCodeCountdown()void
    .registers 9
    # ins_size=1
    const/16 v0, 60
    iput v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeCountdown I
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSendCode Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "btnSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/TextView;->setEnabled(Z)V
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeJob Lkotlinx/coroutines/Job;
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startSendCodeCountdown$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startSendCodeCountdown$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final startSmsSendCodeCountdown()void
    .registers 9
    # ins_size=1
    const/16 v0, 60
    iput v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeCountdown I
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsSendCode Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "btnSmsSendCode"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/TextView;->setEnabled(Z)V
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeJob Lkotlinx/coroutines/Job;
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startSmsSendCodeCountdown$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startSmsSendCodeCountdown$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final verifyEmailCode()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etVerificationCode Landroid/widget/EditText;
    const-string v1, "etVerificationCode"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    if-nez v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    if-eqz v3, +00fh
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etVerificationCode Landroid/widget/EditText;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Landroid/widget/EditText;->requestFocus()Z
    return-void 
    iget-boolean v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    if-eqz v1, +003h
    return-void 
    iput-boolean v4, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnVerify Landroid/widget/TextView;
    if-nez v1, +008h
    const-string v1, "btnVerify"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, v5, Landroid/widget/TextView;->setEnabled(Z)V
    move-object v1, v9
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;
    invoke-direct v1, v0, v9, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final verifyGoogleAuth()void
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    iget-boolean v1, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    if-eqz v1, +003h
    return-void 
    const/4 v1, 1
    iput-boolean v1, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnGoogleVerify Landroid/widget/TextView;
    const-string v3, "btnGoogleVerify"
    const/4 v4, 0
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v4
    const/4 v5, 0
    invoke-virtual v2, v5, Landroid/widget/TextView;->setEnabled(Z)V
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->loginService Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v2, +009h
    check-cast v0, Landroid/app/Activity;
    invoke-interface v2, v0, Lcom/bytedance/trae/login/api/ILoginService;->getGoogleSignInIntent(Landroid/app/Activity;)Landroid/content/Intent;
    move-result-object v0
    goto +2h
    move-object v0, v4
    if-nez v0, +01fh
    iput-boolean v5, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnGoogleVerify Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    invoke-virtual v4, v1, Landroid/widget/TextView;->setEnabled(Z)V
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_delete_verify_failed I
    invoke-virtual v6, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->showToast(Ljava/lang/String;)V
    return-void 
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->googleSignInLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private final verifySmsCode()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etSmsCode Landroid/widget/EditText;
    const-string v1, "etSmsCode"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    if-nez v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    if-eqz v3, +00fh
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->etSmsCode Landroid/widget/EditText;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Landroid/widget/EditText;->requestFocus()Z
    return-void 
    iget-boolean v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    if-eqz v1, +003h
    return-void 
    iput-boolean v4, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isLoading Z
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->btnSmsVerify Landroid/widget/TextView;
    if-nez v1, +008h
    const-string v1, "btnSmsVerify"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, v5, Landroid/widget/TextView;->setEnabled(Z)V
    move-object v1, v9
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifySmsCode$1;
    invoke-direct v1, v0, v9, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifySmsCode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_delete_account I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/fragment/app/Fragment;->onDestroyView()V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->sendCodeJob Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->finishCountdownJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v3
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v3, v0, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    goto +2h
    const/4 v3, 0
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->loginService Lcom/bytedance/trae/login/api/ILoginService;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->bindViews(Landroid/view/View;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->setupListeners(Landroid/view/View;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->init()V
    return-void 
    :try_start_0x9
.end method
