# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DouyinBindVerifyCodeFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isNewUser:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;


.method public static synthetic $r8$lambda$DWSbTNrKE84p07-0A9DrfULSdtg(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.Throwable  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/Throwable; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lOCxCpXBD5nKxxhXib0qszIQJG0(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.traeauth.ListDevicesResult  boolean  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->invokeSuspend$lambda$1(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Z Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  boolean  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iput-boolean v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->$isNewUser Z
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.Throwable  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 6
    # ins_size=4
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setSubmitting$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v1, 1
    invoke-virtual v5, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    check-cast v4, Landroid/content/Context;
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_device_limit I
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v2, "getString(...)"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v4, v3, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final invokeSuspend$lambda$1(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.traeauth.ListDevicesResult  boolean  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 6
    # ins_size=5
    const/4 v0, 0
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v0, 1
    invoke-virtual v5, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    invoke-static v1, v4, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$showDeviceOverLimitDialog(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iget-boolean v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->$isNewUser Z
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 25
    # ins_size=2
    move-object/from16 v1, v23
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v24
    goto +28h
    move-exception v0
    goto +37h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$result$1;
    const/4 v5, 0
    invoke-direct v4, v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$result$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->label I
    invoke-static v2, v4, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    check-cast v2, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iget-boolean v3, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->$isNewUser Z
    new-instance v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;
    invoke-direct v4, v0, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Z)V
    invoke-static v0, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "douyin_bind_device_limit"
    const-string v4, "douyin"
    const/4 v5, 0
    const-string v6, "device_limit_list"
    const/4 v7, 0
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-string v12, "fail"
    const-string v13, "device_limit_list"
    const/16 v14, 468
    const/4 v15, 0
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v16, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const/16 v17, 0
    const-string v18, "device_limit_list"
    const/16 v19, 0
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v20
    const/16 v21, 4
    const/16 v22, 0
    invoke-static/range v16 ... v22, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhoneResult$default(Lcom/bytedance/trae/login/tracker/LoginTracker; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/Throwable;)V
    invoke-static v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0xd
    :try_start_0x20
.end method
