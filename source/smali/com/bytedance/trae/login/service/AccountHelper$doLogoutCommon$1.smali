# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;
.super Lcom/bytedance/sdk/account/api/call/AbsApiCall;
.source "AccountHelper.kt"

.field final synthetic $businessScene:Ljava/lang/String;
.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic $forceLogout:Z
.field final synthetic $platform:Lcom/bytedance/trae/login/api/LoginPlatform;


.method constructor <init>(boolean  com.bytedance.trae.login.api.IAccountCallback  com.bytedance.trae.login.api.LoginPlatform  java.lang.String)void
    .registers 5
    # ins_size=5
    iput-boolean v1, v0, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$forceLogout Z
    iput-object v2, v0, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$businessScene Ljava/lang/String;
    invoke-direct v0, Lcom/bytedance/sdk/account/api/call/AbsApiCall;-><init>()V
    return-void 
.end method

.method public bridge synthetic onResponse(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/LogoutApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->onResponse(Lcom/bytedance/sdk/account/api/call/LogoutApiResponse;)V
    return-void 
.end method

.method public onResponse(com.bytedance.sdk.account.api.call.LogoutApiResponse)void
    .registers 15
    # ins_size=2
    if-eqz v14, +03ch
    iget-boolean v0, v13, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$forceLogout Z
    iget-object v1, v13, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v7, v13, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    iget-object v8, v13, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;->$businessScene Ljava/lang/String;
    iget-boolean v2, v14, Lcom/bytedance/sdk/account/api/call/LogoutApiResponse;->success Z
    if-nez v2, +01bh
    if-eqz v0, +003h
    goto +17h
    if-eqz v1, +02bh
    iget v3, v14, Lcom/bytedance/sdk/account/api/call/LogoutApiResponse;->mDetailErrorCode I
    iget-object v4, v14, Lcom/bytedance/sdk/account/api/call/LogoutApiResponse;->errorMsg Ljava/lang/String;
    const/4 v6, 0
    const/4 v14, 0
    const/4 v0, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 480
    const/4 v12, 0
    move-object v2, v7
    move-object v5, v8
    move-object v7, v14
    move-object v8, v0
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    goto +16h
    if-eqz v1, +00ah
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v2, v7
    move-object v3, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onSuccess$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean; I Ljava/lang/Object;)V
    sget-object v14, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v0, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_OUT Lcom/bytedance/trae/login/api/AccountStatus;
    if-nez v8, +004h
    const-string v8, ""
    invoke-virtual v14, v0, v8, v7, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    return-void 
.end method
