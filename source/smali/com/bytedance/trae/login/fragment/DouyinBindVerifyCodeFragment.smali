# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
.super Lcom/bytedance/trae/common/fragment/TraceFragment;
.source "DouyinBindVerifyCodeFragment.kt"

.field private static final ARG_PHONE_NUMBER:Ljava/lang/String;
.field private static final ARG_PROFILE_KEY:Ljava/lang/String;
.field private static final CODE_LENGTH:I
.field private static final COUNTDOWN_SECONDS:I
.field public static final Companion:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$Companion;
.field private static final ERROR_CODE_PHONE_ALREADY_BOUND:I
.field private static final ERROR_CODE_PHONE_ALREADY_BOUND_2:I
.field private static final ERROR_CODE_SMS_CODE_ERROR:I
.field private static final ERROR_CODE_SMS_CODE_EXPIRED:I
.field private static final ERROR_CODE_SMS_CODE_MISSING:I
.field private static final ERROR_CODE_SMS_CODE_TYPE_ERROR:I
.field private static final PLATFORM_ID:Ljava/lang/String;
.field private static final STAGE_DEVICE_LIMIT_CONTINUE:Ljava/lang/String;
.field private static final STAGE_DEVICE_LIMIT_LIST:Ljava/lang/String;
.field private static final STAGE_SUBMIT_BIND_PHONE:Ljava/lang/String;
.field private static final STAGE_TRAE_AUTH_AFTER_BIND:Ljava/lang/String;
.field private _binding:Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
.field private countDownTimer:Landroid/os/CountDownTimer;
.field private isResending:Z
.field private isSubmitting:Z
.field private phoneNumber:Ljava/lang/String;
.field private profileKey:Ljava/lang/String;


.method public static synthetic $r8$lambda$-qRo8_xb3eBwPPTp7rb3hc6RZTI(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->setupViews$lambda$1(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$FhhxaLG38lkTLreJK9xdX6l81zE(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->setupViews$lambda$0(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OW5w5sZsQQEKKaVvif4tWbcTxFs(com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->continueLoginAfterDeviceLimit$lambda$5(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$W_DSYIpNIPlf9NMDTHZihruJ1SY(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  kotlin.jvm.functions.Function2)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->runOnHost$lambda$6(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cmpLdybkBQJ8SteotlXtPGqmT9E(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  boolean  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->showDeviceOverLimitDialog$lambda$4(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hTaBCGEVDsHOgbTxBJ6atHe0Pe0(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->showDeviceOverLimitDialog$lambda$4$lambda$3(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pQ0JGfPlMwfybZACi0x7toCzuy0(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->showPhoneConflictDialog$lambda$2(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->Companion Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/fragment/TraceFragment;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->phoneNumber Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->profileKey Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$getBinding(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$handleDeviceOverLimit(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->handleDeviceOverLimit(Z)V
    return-void 
.end method

.method public static final synthetic access$isSubmitting$p(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isSubmitting Z
    return v0
.end method

.method public static final synthetic access$isVerifyCodeError(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isVerifyCodeError(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$runOnHost(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->runOnHost(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public static final synthetic access$setResendReady(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->setResendReady()V
    return-void 
.end method

.method public static final synthetic access$setResending$p(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isResending Z
    return-void 
.end method

.method public static final synthetic access$setSubmitting$p(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isSubmitting Z
    return-void 
.end method

.method public static final synthetic access$showDeviceOverLimitDialog(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.traeauth.ListDevicesResult  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->showDeviceOverLimitDialog(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Z)V
    return-void 
.end method

.method public static final synthetic access$showPhoneConflictDialog(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->showPhoneConflictDialog(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    return-void 
.end method

.method public static final synthetic access$startCountdown(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->startCountdown()V
    return-void 
.end method

.method public static final synthetic access$submitBind(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->submitBind(Ljava/lang/String;)V
    return-void 
.end method

.method private final continueLoginAfterDeviceLimit(boolean)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/service/AccountHelper;->setIsNewUser(Z)V
    new-instance v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda5;
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda5;-><init>()V
    invoke-direct v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->runOnHost(Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2;
    invoke-direct v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const-string v1, "douyin"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onLoginContinueByDeviceLimit(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/String;)V
    return-void 
.end method

.method private static final continueLoginAfterDeviceLimit$lambda$5(com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "binding"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    iget-object v1, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final getBinding()com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    return-object v0
.end method

.method private final handleDeviceOverLimit(boolean)void
    .registers 9
    # ins_size=2
    invoke-virtual v7, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final isVerifyCodeError(java.lang.String)boolean
    .registers 6
    # ins_size=2
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    const-string/jumbo v0, 验证码
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +018h
    const-string/jumbo v0, verification code
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00dh
    const-string/jumbo v0, sms code
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    const/4 v1, 1
    return v1
.end method

.method private final maskPhone(java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 7
    if-ge v0, v1, +003h
    return-object v5
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    const/4 v2, 0
    const/4 v3, 3
    invoke-virtual v5, v2, v3, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, substring(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, "****"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private final resendCode()void
    .registers 16
    # ins_size=1
    iget-boolean v0, v15, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isResending Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v15, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isResending Z
    invoke-direct v15, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->setResendSending()V
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "douyin_bind_resend_code"
    const-string v3, "douyin"
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
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    const-string v1, "is6Digits"
    const-string v2, "1"
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v1
    const-string v2, "app_name"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountAPIV3Impl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;
    move-result-object v1
    iget-object v2, v15, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->phoneNumber Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;
    invoke-direct v3, v15, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    check-cast v3, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
    const/16 v4, 24
    invoke-interface v1, v2, v4, v0, v3, Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;->sendCode2(Ljava/lang/String; I Ljava/util/Map; Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;)V
    return-void 
.end method

.method private final runOnHost(kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;
    invoke-direct v1, v2, v0, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lkotlin/jvm/functions/Function2;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final runOnHost$lambda$6(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isAdded()Z
    move-result v1
    if-eqz v1, +013h
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isFinishing()Z
    move-result v1
    if-nez v1, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isDestroyed()Z
    move-result v1
    if-nez v1, +007h
    if-eqz v0, +005h
    invoke-interface v3, v2, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final setResendReady()void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isResending Z
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v0, +006h
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setClickable(Z)V
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v1
    if-eqz v1, +00fh
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v1, +00bh
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +00bh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v0, +007h
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_phone_resend_ready I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(I)V
    return-void 
.end method

.method private final setResendSending()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v0, +006h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/TextView;->setClickable(Z)V
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v1
    if-eqz v1, +00fh
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v1, +00bh
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-static v0, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +011h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v0, +00dh
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_sending_code I
    invoke-virtual v3, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final setupViews()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +011h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvMaskedPhone Landroid/widget/TextView;
    if-eqz v0, +00dh
    iget-object v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->phoneNumber Ljava/lang/String;
    invoke-direct v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->maskPhone(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +010h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-eqz v0, +00ch
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$setupViews$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$setupViews$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->addTextChangedListener(Landroid/text/TextWatcher;)V
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final setupViews$lambda$0(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->resendCode()V
    return-void 
.end method

.method private static final setupViews$lambda$1(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +02bh
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +025h
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "input_method"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/view/inputmethod/InputMethodManager;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    move-object v0, v2
    if-eqz v0, +010h
    invoke-direct v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v3
    if-eqz v3, +004h
    iget-object v2, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    check-cast v2, Landroid/view/View;
    const/4 v3, 1
    invoke-virtual v0, v2, v3, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method private final showDeviceOverLimitDialog(com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.traeauth.ListDevicesResult  boolean)void
    .registers 7
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    check-cast v4, Landroid/app/Activity;
    sget-object v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->LOGIN Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4;
    invoke-direct v2, v3, v6, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    invoke-virtual v0, v4, v5, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    return-void 
.end method

.method private static final showDeviceOverLimitDialog$lambda$4(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  boolean  boolean)void
    .registers 25
    # ins_size=3
    move-object/from16 v0, v22
    if-eqz v24, +006h
    invoke-direct/range v22 ... v23, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->continueLoginAfterDeviceLimit(Z)V
    goto +33h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "device_limit_dismissed"
    const-string v3, "douyin"
    const/4 v4, 0
    const-string v5, "device_limit_continue"
    const/4 v6, 0
    const-string v7, "device_limit_dismissed"
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const-string v11, "fail"
    const-string v12, "device_limit_continue"
    const/16 v13, 468
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v15, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const/16 v16, 0
    const-string v17, "device_limit_continue"
    const/16 v18, 0
    const-string v19, "device_limit_dismissed"
    const/16 v20, 4
    const/16 v21, 0
    invoke-static/range v15 ... v21, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhoneResult$default(Lcom/bytedance/trae/login/tracker/LoginTracker; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->runOnHost(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final showDeviceOverLimitDialog$lambda$4$lambda$3(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 5
    # ins_size=3
    const-string v0, "host"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "binding"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isSubmitting Z
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    iget-object v4, v4, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v1, 1
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    check-cast v3, Landroid/content/Context;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit I
    invoke-virtual v2, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v3, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final showPhoneConflictDialog(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)void
    .registers 38
    # ins_size=2
    move-object/from16 v0, v36
    move-object/from16 v1, v37
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "douyin_bind_phone_conflict"
    const-string v4, "douyin"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-string v12, "fail"
    const-string/jumbo v13, submit_bind_phone
    const/16 v14, 508
    const/4 v15, 0
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v16, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    move-object/from16 v17, v1
    check-cast v17, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_phone_conflict_title I
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    move-object/from16 v18, v2
    const-string v3, "getString(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_phone_conflict_message I
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    move-object/from16 v19, v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v20, 0
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_phone_conflict_button I
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    move-object/from16 v21, v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    new-instance v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda3;
    move-object/from16 v32, v2
    invoke-direct v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    const/16 v33, 0
    const v34, 98280
    const/16 v35, 0
    invoke-static/range v16 ... v35, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showPhoneConflictDialog$lambda$2(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->popToPhoneInput()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final startCountdown()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->countDownTimer Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/TextView;->setClickable(Z)V
    invoke-virtual v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v2
    if-eqz v2, +00fh
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v2, +00bh
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v0
    if-eqz v0, +01ch
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v0, +018h
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_resend_countdown I
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/Object;
    const/16 v4, 60
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    aput-object v4, v3, v1
    invoke-virtual v5, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;
    invoke-direct v0, v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;->start()Landroid/os/CountDownTimer;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->countDownTimer Landroid/os/CountDownTimer;
    return-void 
.end method

.method private final submitBind(java.lang.String)void
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->isSubmitting Z
    invoke-direct/range v17, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v2
    if-eqz v2, +00ah
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-eqz v2, +006h
    const/4 v3, 0
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    invoke-virtual/range v17, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    if-eqz v3, +005h
    check-cast v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +005h
    invoke-virtual v2, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "douyin_bind_submit"
    const-string v5, "douyin"
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
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    move-object v7, v1
    check-cast v7, Ljava/util/Map;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v1
    const-string v2, "app_name"
    invoke-interface v7, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, platform_app_id
    const-string v2, "23081"
    invoke-interface v7, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountAPIV3Impl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->phoneNumber Ljava/lang/String;
    iget-object v5, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->profileKey Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    move-object v8, v1
    check-cast v8, Lcom/bytedance/sdk/account/mobile/thread/call/BindLoginCallback;
    move-object/from16 v4, v18
    invoke-interface/range v2 ... v8, Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;->bindLogin(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/sdk/account/mobile/thread/call/BindLoginCallback;)V
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
    invoke-static v1, v2, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->getRoot()Landroid/widget/LinearLayout;
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
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->countDownTimer Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->countDownTimer Landroid/os/CountDownTimer;
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/bytedance/trae/common/fragment/TraceFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +009h
    const-string v0, "arg_phone_number"
    invoke-virtual v2, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    const-string v0, ""
    if-nez v2, +003h
    move-object v2, v0
    iput-object v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->phoneNumber Ljava/lang/String;
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    if-eqz v2, +008h
    const-string v3, "arg_profile_key"
    invoke-virtual v2, v3, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v0, v3
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->profileKey Ljava/lang/String;
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->phoneNumber Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    const/4 v0, 0
    if-nez v2, +004h
    move v2, v3
    goto +2h
    move v2, v0
    if-nez v2, +018h
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->profileKey Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +2h
    move v3, v0
    if-eqz v3, +003h
    goto +8h
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->setupViews()V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->startCountdown()V
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Landroidx/fragment/app/FragmentActivity;->finish()V
    return-void 
.end method
