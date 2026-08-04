# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;
.super Lcom/bytedance/sdk/account/mobile/thread/call/ValidateCodeCallBack;
.source "PhoneBindActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method public static synthetic $r8$lambda$QBnEiQmMJiuwzNvYvzhS2hflL4c(com.bytedance.trae.login.activity.PhoneBindActivity  com.bytedance.sdk.account.api.call.ValidateCodeResponse)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->onSuccess$lambda$0(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fcXp9PJK00dUssz97rrEV55XYRU(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->onError$lambda$1(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/ValidateCodeCallBack;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 7
    # ins_size=1
    const/4 v0, 0
    invoke-static v6, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    invoke-static v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getVerifyOldInput$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v1
    const/4 v2, 0
    const-string/jumbo v3, verifyOldInput
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const/4 v4, 1
    invoke-virtual v1, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    invoke-static v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getVerifyOldInput$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const-string v5, ""
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v1, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    invoke-static v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getVerifyOldInput$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    invoke-virtual v2, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setError(Z)V
    check-cast v6, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_phone_verify_fail I
    invoke-static v6, v1, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v6
    invoke-virtual v6, Landroid/widget/Toast;->show()V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.activity.PhoneBindActivity  com.bytedance.sdk.account.api.call.ValidateCodeResponse)kotlin.Unit
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-static v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    invoke-virtual v2, Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;->getTicket()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    invoke-static v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$setTicket$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Ljava/lang/String;)V
    const/4 v2, 2
    invoke-static v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showStep(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->onError(Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.ValidateCodeResponse  int)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, response
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    iget-object v4, v4, Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;->errorMsg Ljava/lang/String;
    const-string v1, "fail"
    const-string/jumbo v2, validate_old_code
    invoke-static v0, v1, v2, v5, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$trackSettingsPhoneBindingResult(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1$$ExternalSyntheticLambda1;
    invoke-direct v5, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v4, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.ValidateCodeResponse)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;)V
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
