# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;
.super Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
.source "DouyinBindVerifyCodeFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;


.method public static synthetic $r8$lambda$CcCchWuOf_9LeQIhaWbuMhXCmy4(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->onSuccess$lambda$0(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$c1H173pgU5JBLNOXnPYpP9qZU6k(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.sdk.account.api.call.MobileApiResponse  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->onError$lambda$1(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/sdk/account/api/call/MobileApiResponse; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.sdk.account.api.call.MobileApiResponse  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setResendReady(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    check-cast v3, Landroid/content/Context;
    if-eqz v2, +006h
    iget-object v2, v2, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    if-nez v2, +00dh
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_phone_send_code_fail I
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v1, "getString(...)"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v3, v2, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "<unused var>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "binding"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    invoke-static v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setResending$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    iget-object v2, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string v3, ""
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    invoke-static v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$startCountdown(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->onError(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.MobileApiResponse  int)void
    .registers 35
    # ins_size=3
    move-object/from16 v0, v32
    move-object/from16 v1, v33
    iget-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    const/4 v3, 0
    invoke-static v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setResending$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "douyin_bind_resend_code_fail"
    const-string v6, "douyin"
    const/4 v7, 0
    const/4 v8, 0
    invoke-static/range v34, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v9
    const/4 v2, 0
    if-eqz v1, +006h
    iget-object v3, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    move-object v10, v3
    goto +2h
    move-object v10, v2
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-string v14, "fail"
    const/4 v15, 0
    const/16 v16, 1484
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v19, sms_resend_error
    const-string v20, "douyin"
    const/16 v21, 0
    const/16 v22, 0
    invoke-static/range v34, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v23
    if-eqz v1, +004h
    iget-object v2, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    move-object/from16 v24, v2
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 1984
    const/16 v31, 0
    invoke-static/range v18 ... v31, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    invoke-static v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 16
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "douyin_bind_resend_code_success"
    const-string v2, "douyin"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const-string/jumbo v10, success
    const/4 v11, 0
    const/16 v12, 1532
    const/4 v13, 0
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1$$ExternalSyntheticLambda1;
    invoke-direct v0, v15, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    invoke-static v15, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method
