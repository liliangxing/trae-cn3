# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;
.super Ljava/lang/Object;
.source "PhoneBindActivity.kt"

.implements Lcom/bytedance/sdk/account/AccountSdkCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method public static synthetic $r8$lambda$mgMFt9Q98qlvnTyQHNHEYh6XFOM(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;->onSuccess$lambda$0(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ynO0fAKUL7ZC8ff8rvsQhJGWCr4(com.bytedance.trae.login.activity.PhoneBindActivity  com.bytedance.sdk.account.AccountSdkResponse)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;->onError$lambda$1(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lcom/bytedance/sdk/account/AccountSdkResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.activity.PhoneBindActivity  com.bytedance.sdk.account.AccountSdkResponse)kotlin.Unit
    .registers 5
    # ins_size=2
    const/4 v0, 0
    invoke-static v3, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    iget-object v4, v4, Lcom/bytedance/sdk/account/AccountSdkResponse;->errorMessage Ljava/lang/String;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v0
    goto +2h
    const/4 v2, 1
    if-nez v2, +003h
    goto +ch
    sget v4, Lcom/bytedance/trae/login/R$string;->trae_phone_send_code_fail I
    invoke-virtual v3, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v3, "getString(...)"
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v1, v4, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 8
    # ins_size=1
    const/4 v0, 0
    invoke-static v7, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    invoke-static v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getTvVerifyOldHint$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Landroid/widget/TextView;
    move-result-object v1
    const/4 v2, 0
    if-nez v1, +009h
    const-string/jumbo v1, tvVerifyOldHint
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_phone_verify_old_hint I
    const/4 v4, 1
    new-array v5, v4, [Ljava/lang/Object;
    invoke-static v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getOldPhoneNumber$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Ljava/lang/String;
    move-result-object v6
    aput-object v6, v5, v0
    invoke-virtual v7, v3, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static v7, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showStep(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I)V
    invoke-static v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$startCountdownOld(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getVerifyOldInput$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v7
    if-nez v7, +009h
    const-string/jumbo v7, verifyOldInput
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v7
    invoke-virtual v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method public onError(com.bytedance.sdk.account.AccountSdkResponse)void
    .registers 10
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v8, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    const-string v2, "fail"
    const-string/jumbo v3, send_old_code
    const/4 v4, 0
    iget-object v5, v9, Lcom/bytedance/sdk/account/AccountSdkResponse;->errorMessage Ljava/lang/String;
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->trackSettingsPhoneBindingResult$default(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v0, v8, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, v9, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lcom/bytedance/sdk/account/AccountSdkResponse;)V
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.AccountSdkResponse)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToOldPhone$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
