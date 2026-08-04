# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;
.super Lcom/bytedance/sdk/account/mobile/thread/call/QuickLoginCallback;
.source "PhoneLogin.kt"

.field final synthetic $businessScene:Ljava/lang/String;
.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic $platform:Lcom/bytedance/trae/login/api/LoginPlatform;
.field final synthetic this$0:Lcom/bytedance/trae/login/PhoneLogin;


.method constructor <init>(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  com.bytedance.trae.login.api.LoginPlatform  com.bytedance.trae.login.PhoneLogin)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$businessScene Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    iput-object v4, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/QuickLoginCallback;-><init>()V
    return-void 
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->onError(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.MobileApiResponse  int)void
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    if-eqz v1, +01fh
    iget-object v3, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->mobileObj Lcom/bytedance/sdk/account/mobile/query/MobileQueryObj;
    check-cast v3, Lcom/bytedance/sdk/account/mobile/query/QuickLoginQueryObj;
    if-eqz v3, +019h
    iget-object v3, v3, Lcom/bytedance/sdk/account/mobile/query/QuickLoginQueryObj;->mCancelToken Ljava/lang/String;
    if-eqz v3, +015h
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +007h
    const-string v4, "cancel_token"
    invoke-interface v2, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v5, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v6, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    if-eqz v1, +006h
    iget-object v1, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    if-nez v1, +004h
    const-string v1, ""
    move-object v8, v1
    iget-object v9, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$businessScene Ljava/lang/String;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    invoke-interface v2, Ljava/util/Map;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    const/4 v2, 0
    move-object v14, v2
    const/16 v15, 224
    const/16 v16, 0
    move/from16 v7, v19
    invoke-static/range v5 ... v16, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 10
    # ins_size=2
    const/4 v0, 0
    if-eqz v9, +013h
    iget-object v9, v9, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->mobileObj Lcom/bytedance/sdk/account/mobile/query/MobileQueryObj;
    check-cast v9, Lcom/bytedance/sdk/account/mobile/query/QuickLoginQueryObj;
    if-eqz v9, +00dh
    iget-object v9, v9, Lcom/bytedance/sdk/account/mobile/query/QuickLoginQueryObj;->mUserInfo Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;
    if-eqz v9, +009h
    iget-boolean v9, v9, Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;->isNewUser Z
    const/4 v1, 1
    if-ne v9, v1, +004h
    move v3, v1
    goto +2h
    move v3, v0
    sget-object v9, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v9, v3, Lcom/bytedance/trae/login/service/AccountHelper;->setIsNewUser(Z)V
    sget-object v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;
    iget-object v4, v8, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v5, v8, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$businessScene Ljava/lang/String;
    iget-object v6, v8, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    iget-object v7, v8, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;-><init>(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform; Lcom/bytedance/trae/login/PhoneLogin;)V
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const-string/jumbo v1, phone
    invoke-virtual v9, v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onPassportLoginSuccess(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method
