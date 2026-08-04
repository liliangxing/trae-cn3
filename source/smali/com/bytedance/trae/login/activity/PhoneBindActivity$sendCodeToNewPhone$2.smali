# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;
.super Ljava/lang/Object;
.source "PhoneBindActivity.kt"

.implements Lcom/bytedance/sdk/account/AccountSdkCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method public static synthetic $r8$lambda$E3GXHb5P13b0ndcAD_EFxwbZUqk(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->onSuccess$lambda$0(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$x3NFK7J121aa55AY-s7UltGi5sE(com.bytedance.trae.login.activity.PhoneBindActivity  com.bytedance.sdk.account.AccountSdkResponse)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->onError$lambda$1(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lcom/bytedance/sdk/account/AccountSdkResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.activity.PhoneBindActivity  com.bytedance.sdk.account.AccountSdkResponse)kotlin.Unit
    .registers 5
    # ins_size=2
    iget v0, v4, Lcom/bytedance/sdk/account/AccountSdkResponse;->errorCode I
    iget-object v1, v4, Lcom/bytedance/sdk/account/AccountSdkResponse;->errorMessage Ljava/lang/String;
    invoke-static v3, v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$isPhoneAlreadyBoundError(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +006h
    invoke-static v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showPhoneConflictDialog(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    goto +2dh
    iget-object v4, v4, Lcom/bytedance/sdk/account/AccountSdkResponse;->errorMessage Ljava/lang/String;
    move-object v0, v3
    check-cast v0, Landroid/content/Context;
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    const/4 v1, 1
    if-nez v1, +003h
    goto +ch
    sget v4, Lcom/bytedance/trae/login/R$string;->trae_phone_send_code_fail I
    invoke-virtual v3, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v3, "getString(...)"
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v0, v4, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$goToVerifyNewStep(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public onError(com.bytedance.sdk.account.AccountSdkResponse)void
    .registers 11
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$isSendingCode$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    iget-object v2, v9, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    const-string v3, "fail"
    const-string/jumbo v4, send_new_code
    const/4 v5, 0
    iget-object v6, v10, Lcom/bytedance/sdk/account/AccountSdkResponse;->errorMessage Ljava/lang/String;
    const/4 v7, 4
    const/4 v8, 0
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->trackSettingsPhoneBindingResult$default(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, v10, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lcom/bytedance/sdk/account/AccountSdkResponse;)V
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.AccountSdkResponse)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$isSendingCode$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v2
    const/4 v0, 0
    invoke-virtual v2, v0, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
