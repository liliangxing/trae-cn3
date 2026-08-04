# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;
.super Ljava/lang/Object;
.source "DouyinBindVerifyCodeFragment.kt"

.implements Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;

.field final synthetic $response:Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;


.method public static synthetic $r8$lambda$2aN0tNjVf3j6PtDpjZ1HGjpr8LA(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.String  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->onFailure$lambda$1(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wpVyBtxvIZQr9Onc3CXVnxoumN4(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->onSuccess$lambda$0(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.sdk.account.api.call.MobileApiResponse  com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->$response Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onFailure$lambda$1(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.String  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 6
    # ins_size=4
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "binding"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setSubmitting$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    iget-object v5, v5, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v1, 1
    invoke-virtual v5, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    check-cast v4, Landroid/content/Context;
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_login_fail I
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

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setSubmitting$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->navigateToMainActivity()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public deviceOverLimit(java.lang.String)void
    .registers 16
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "douyin_bind_device_limit"
    const-string v2, "douyin"
    const/4 v3, 0
    const-string/jumbo v4, submit_bind_phone
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const-string/jumbo v11, submit_bind_phone
    const/16 v12, 1012
    const/4 v13, 0
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iget-object v0, v14, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->$response Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    const/4 v1, 0
    if-eqz v0, +012h
    iget-object v0, v0, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->mobileObj Lcom/bytedance/sdk/account/mobile/query/MobileQueryObj;
    check-cast v0, Lcom/bytedance/sdk/account/mobile/query/BindLoginObj;
    if-eqz v0, +00ch
    iget-object v0, v0, Lcom/bytedance/sdk/account/mobile/query/BindLoginObj;->mUserInfo Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;
    if-eqz v0, +008h
    iget-boolean v0, v0, Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;->isNewUser Z
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    invoke-static v15, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$handleDeviceOverLimit(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    return-void 
.end method

.method public onFailure(java.lang.String  java.lang.String)void
    .registers 18
    # ins_size=3
    move-object/from16 v14, v17
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "douyin_bind_trae_auth_fail"
    const-string v2, "douyin"
    const/4 v3, 0
    const-string/jumbo v4, trae_auth_after_bind
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const-string v10, "fail"
    const-string/jumbo v11, trae_auth_after_bind
    const/16 v12, 452
    const/4 v13, 0
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const/4 v1, 0
    const-string/jumbo v2, trae_auth_after_bind
    move-object/from16 v3, v16
    invoke-virtual v0, v1, v2, v3, v14, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhoneResult(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v15
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1$$ExternalSyntheticLambda1;
    invoke-direct v2, v1, v14, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String;)V
    invoke-static v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public onSuccess()void
    .registers 27
    # ins_size=1
    move-object/from16 v0, v26
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->$response Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    const/4 v2, 0
    if-eqz v1, +012h
    iget-object v1, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->mobileObj Lcom/bytedance/sdk/account/mobile/query/MobileQueryObj;
    check-cast v1, Lcom/bytedance/sdk/account/mobile/query/BindLoginObj;
    if-eqz v1, +00ch
    iget-object v1, v1, Lcom/bytedance/sdk/account/mobile/query/BindLoginObj;->mUserInfo Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;
    if-eqz v1, +008h
    iget-boolean v1, v1, Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;->isNewUser Z
    const/4 v3, 1
    if-ne v1, v3, +003h
    move v2, v3
    sget-object v1, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/service/AccountHelper;->setIsNewUser(Z)V
    sget-object v1, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v2, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    const-string v3, ""
    sget-object v4, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v6, "douyin_bind_success"
    const-string v7, "douyin"
    const/4 v8, 0
    const-string/jumbo v9, submit_bind_phone
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const-string/jumbo v15, success
    const-string/jumbo v16, submit_bind_phone
    const/16 v17, 500
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v19, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const/16 v20, 1
    const-string/jumbo v21, submit_bind_phone
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 12
    const/16 v25, 0
    invoke-static/range v19 ... v25, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhoneResult$default(Lcom/bytedance/trae/login/tracker/LoginTracker; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    invoke-static v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method
