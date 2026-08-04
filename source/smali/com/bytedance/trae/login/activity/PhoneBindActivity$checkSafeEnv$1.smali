# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;
.super Lcom/bytedance/sdk/account/api/callback/SafeVerifyCallback;
.source "PhoneBindActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method public static synthetic $r8$lambda$FKjkqMT9weCAPAEm80oL_bzxYGE(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;->onSuccess$lambda$0(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oE5wkhwfL4HBuUIuQqbE_3yMufs(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;->onError$lambda$1(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, Lcom/bytedance/sdk/account/api/callback/SafeVerifyCallback;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-static v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    invoke-static v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$sendCodeToOldPhone(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onSuccess$lambda$0(com.bytedance.trae.login.activity.PhoneBindActivity)kotlin.Unit
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-static v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$showLoading(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Z)V
    invoke-static v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$sendCodeToOldPhone(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/response/SafeVerifyResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;->onError(Lcom/bytedance/sdk/account/api/response/SafeVerifyResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.response.SafeVerifyResponse  int)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, response
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/response/SafeVerifyResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;->onSuccess(Lcom/bytedance/sdk/account/api/response/SafeVerifyResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.response.SafeVerifyResponse)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)V
    invoke-static v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$runOnUiThreadSafe(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
