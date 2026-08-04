# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;
.super Lcom/bytedance/sdk/account/CommonCallBack;
.source "BytecloudPassportLogin.kt"

.field final synthetic $callback:Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;


.method constructor <init>(com.bytedance.trae.login.bytecloud.BytecloudPassportLogin$Callback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;->$callback Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;
    invoke-direct v0, Lcom/bytedance/sdk/account/CommonCallBack;-><init>()V
    return-void 
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;->onError(Lcom/bytedance/sdk/account/api/call/UserApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.UserApiResponse  int)void
    .registers 6
    # ins_size=3
    if-eqz v4, +006h
    iget-object v4, v4, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->errorMsg Ljava/lang/String;
    if-nez v4, +005h
    const-string/jumbo v4, unknown
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, ssoWithAccessTokenLogin failed: code=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", msg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "BytecloudPassportLogin"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;->$callback Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;
    invoke-interface v0, v5, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;->onError(I Ljava/lang/String;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/UserApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.UserApiResponse)void
    .registers 6
    # ins_size=2
    if-eqz v5, +009h
    iget-object v5, v5, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->userInfo Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;
    if-eqz v5, +005h
    iget-wide v0, v5, Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;->userId J
    goto +3h
    const-wide/16 v0, 0
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, ssoWithAccessTokenLogin success, userId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BytecloudPassportLogin"
    invoke-virtual v5, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;
    invoke-static v5, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;->access$reportBind(Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;)V
    iget-object v5, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;->$callback Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;
    invoke-interface v5, v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;->onSuccess(J)V
    return-void 
.end method
