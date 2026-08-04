# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;
.super Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
.source "DouyinBindPhoneInputFragment.kt"

.field final synthetic $phone:Ljava/lang/String;
.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;


.method public static synthetic $r8$lambda$cfBumCLLns7Kbq3RhmUEdTXJm1o(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->onSuccess$lambda$0(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vRmOJFLRZjQ871WHek5Vn2aC0Sw(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  com.bytedance.sdk.account.api.call.MobileApiResponse)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->onError$lambda$1(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->$phone Ljava/lang/String;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  com.bytedance.sdk.account.api.call.MobileApiResponse)kotlin.Unit
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +031h
    invoke-static v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$getBinding(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;)Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-nez v0, +003h
    goto +29h
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$setSendingCode$p(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Z)V
    invoke-static v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$updateSendButton(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v3, +006h
    iget-object v3, v3, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_phone_send_code_fail I
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v2, "getString(...)"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v1, v3, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-static v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$setSendingCode$p(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Z)V
    invoke-static v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$updateSendButton(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    instance-of v0, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    if-eqz v0, +005h
    check-cast v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +005h
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->showVerifyCodeInput(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->onError(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.MobileApiResponse  int)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    iget-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    const/4 v3, 0
    invoke-static v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$setSendingCode$p(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Z)V
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "douyin_bind_send_code_fail"
    const-string v6, "douyin"
    const/4 v7, 0
    const/4 v8, 0
    invoke-static/range v20, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v9
    if-eqz v1, +005h
    iget-object v2, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    goto +2h
    const/4 v2, 0
    move-object v10, v2
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1984
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    new-instance v3, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    invoke-static v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$runOnUiThread(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->$phone Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda1;
    invoke-direct v1, v3, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Ljava/lang/String;)V
    invoke-static v3, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$runOnUiThread(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
