# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;
.super Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
.source "PhoneLogin.kt"

.field final synthetic $callback:Lcom/bytedance/trae/login/IVerificationCodeCallback;


.method constructor <init>(com.bytedance.trae.login.IVerificationCodeCallback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;->$callback Lcom/bytedance/trae/login/IVerificationCodeCallback;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;-><init>()V
    return-void 
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;->onError(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.MobileApiResponse  int)void
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;->$callback Lcom/bytedance/trae/login/IVerificationCodeCallback;
    if-eqz v8, +005h
    iget-object v8, v8, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    goto +2h
    const/4 v8, 0
    move-object v2, v8
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 12
    const/4 v6, 0
    move v1, v9
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/login/IVerificationCodeCallback$DefaultImpls;->onSendFailure$default(Lcom/bytedance/trae/login/IVerificationCodeCallback; I Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;->$callback Lcom/bytedance/trae/login/IVerificationCodeCallback;
    invoke-interface v1, Lcom/bytedance/trae/login/IVerificationCodeCallback;->onSendSuccess()V
    return-void 
.end method
