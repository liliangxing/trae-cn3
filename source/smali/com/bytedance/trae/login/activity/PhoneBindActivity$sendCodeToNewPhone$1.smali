# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;
.super Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
.source "PhoneBindActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method public static synthetic $r8$lambda$k-VGQcamYRVkUvWMvAtOq0h8mYc(com.bytedance.trae.login.activity.PhoneBindActivity  int  com.bytedance.sdk.account.api.call.MobileApiResponse)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->onError$lambda$1(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sURTpSEIWoGlKXesWsg3vVVDRBI(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->onSuccess$lambda$0(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.activity.PhoneBindActivity  int  com.bytedance.sdk.account.api.call.MobileApiResponse)kotlin.Unit
    .registers 4
    # ins_size=3
    if-eqz v3, +005h
    iget-object v0, v3, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    goto +2h
    const/4 v0, 0
    invoke-static v1, v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$isPhoneAlreadyBoundError(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +006h
    invoke-static v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showPhoneConflictDialog(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    goto +1fh
    move-object v2, v1
    check-cast v2, Landroid/content/Context;
    if-eqz v3, +006h
    iget-object v3, v3, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_phone_send_code_fail I
    invoke-virtual v1, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v1, "getString(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v2, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$goToVerifyNewStep(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->onError(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.MobileApiResponse  int)void
    .registers 8
    # ins_size=3
    iget-object v0, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$isSendingCode$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    if-eqz v6, +005h
    iget-object v2, v6, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    goto +2h
    const/4 v2, 0
    const-string v3, "fail"
    const-string/jumbo v4, send_new_code
    invoke-static v0, v3, v4, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$trackSettingsPhoneBindingResult(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;
    invoke-direct v1, v0, v7, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$isSendingCode$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v2
    const/4 v0, 0
    invoke-virtual v2, v0, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
