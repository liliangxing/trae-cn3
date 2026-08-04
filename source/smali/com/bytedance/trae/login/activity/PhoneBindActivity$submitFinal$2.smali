# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;
.super Lcom/bytedance/sdk/account/mobile/thread/call/ChangeMobileNumCallback;
.source "PhoneBindActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method public static synthetic $r8$lambda$dHe1RHLqZlXKOCZVrjbOQb6X57o(com.bytedance.trae.login.activity.PhoneBindActivity  int  com.bytedance.sdk.account.api.call.MobileApiResponse)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->onError$lambda$1(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dM5stnx_vpdu0vPqZw1ljwDgln4(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->onSuccess$lambda$0(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/ChangeMobileNumCallback;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.activity.PhoneBindActivity  int  com.bytedance.sdk.account.api.call.MobileApiResponse)kotlin.Unit
    .registers 8
    # ins_size=3
    const/4 v0, 0
    invoke-static v5, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    invoke-static v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getVerifyNewInput$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v1
    const-string/jumbo v2, verifyNewInput
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    const/4 v4, 1
    invoke-virtual v1, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    invoke-static v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getVerifyNewInput$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    const-string v2, ""
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    if-eqz v7, +004h
    iget-object v3, v7, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    invoke-static v5, v6, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$isPhoneAlreadyBoundError(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Ljava/lang/String;)Z
    move-result v6
    if-eqz v6, +006h
    invoke-static v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showPhoneConflictDialog(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    goto +1dh
    if-eqz v7, +006h
    iget-object v6, v7, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    if-nez v6, +00dh
    sget v6, Lcom/bytedance/trae/login/R$string;->trae_phone_bind_fail I
    invoke-virtual v5, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v6
    const-string v7, "getString(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/content/Context;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v5, v6, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 4
    # ins_size=1
    const/4 v0, 0
    invoke-static v3, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_phone_change_success I
    invoke-static v1, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    const-string v1, "extra_new_phone"
    invoke-static v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getNewPhoneNumber$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v0
    const/4 v1, -1
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->setResult(I Landroid/content/Intent;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->finish()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->onError(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.MobileApiResponse  int)void
    .registers 8
    # ins_size=3
    iget-object v0, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    if-eqz v6, +005h
    iget-object v2, v6, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    goto +2h
    const/4 v2, 0
    const-string v3, "fail"
    const-string/jumbo v4, submit_new_phone
    invoke-static v0, v3, v4, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$trackSettingsPhoneBindingResult(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, v7, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->onSuccess(Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    const-string/jumbo v1, success
    const-string/jumbo v2, submit_new_phone
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 12
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->trackSettingsPhoneBindingResult$default(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2$$ExternalSyntheticLambda1;
    invoke-direct v0, v8, Lcom/bytedance/trae/login/activity/PhoneBindActivity$submitFinal$2$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v8, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
