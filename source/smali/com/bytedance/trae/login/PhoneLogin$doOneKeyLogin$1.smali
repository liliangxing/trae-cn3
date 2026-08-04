# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;
.super Lcom/bytedance/sdk/account/platform/OnekeyLoginAdapter;
.source "PhoneLogin.kt"

.field final synthetic $businessScene:Ljava/lang/String;
.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic this$0:Lcom/bytedance/trae/login/PhoneLogin;


.method constructor <init>(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  com.bytedance.trae.login.PhoneLogin  android.app.Application)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->$businessScene Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    check-cast v4, Landroid/content/Context;
    invoke-direct v0, v4, Lcom/bytedance/sdk/account/platform/OnekeyLoginAdapter;-><init>(Landroid/content/Context;)V
    return-void 
.end method

.method public onLoginError(com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse)void
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    instance-of v3, v1, Lcom/bytedance/sdk/account/platform/base/OnekeyLoginErrorResponse;
    if-eqz v3, +01fh
    move-object v3, v1
    check-cast v3, Lcom/bytedance/sdk/account/platform/base/OnekeyLoginErrorResponse;
    iget v4, v3, Lcom/bytedance/sdk/account/platform/base/OnekeyLoginErrorResponse;->error I
    iget-object v3, v3, Lcom/bytedance/sdk/account/platform/base/OnekeyLoginErrorResponse;->mCancelToken Ljava/lang/String;
    if-eqz v3, +017h
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    if-eqz v5, +009h
    const-string v5, "cancel_token"
    invoke-interface v2, v5, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +2h
    const/4 v4, -1
    iget-object v5, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v3, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-virtual v3, Lcom/bytedance/trae/login/PhoneLogin;->providePlatform()Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v6
    if-eqz v1, +006h
    iget-object v3, v1, Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;->platformErrorMsg Ljava/lang/String;
    if-nez v3, +004h
    const-string v3, "OneKey login failed"
    move-object v8, v3
    iget-object v9, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->$businessScene Ljava/lang/String;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    invoke-interface v2, Ljava/util/Map;->isEmpty()Z
    move-result v3
    const/16 v17, 0
    if-eqz v3, +005h
    move-object/from16 v14, v17
    goto +2h
    move-object v14, v2
    const/16 v15, 224
    const/16 v16, 0
    move v7, v4
    invoke-static/range v5 ... v16, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "OneKey login error: error="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", code="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v1, +005h
    iget-object v3, v1, Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;->platformErrorCode Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v17
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", msg="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v1, +005h
    iget-object v1, v1, Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;->platformErrorMsg Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v17
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "PhoneLogin"
    invoke-static v2, v1, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public onLoginSuccess(com.bytedance.sdk.account.api.response.LoginByTicketResponse)void
    .registers 7
    # ins_size=2
    const/4 v0, 0
    if-eqz v6, +00eh
    invoke-virtual v6, Lcom/bytedance/sdk/account/api/response/LoginByTicketResponse;->getUserInfo()Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;
    move-result-object v6
    if-eqz v6, +008h
    iget-boolean v6, v6, Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;->isNewUser Z
    const/4 v1, 1
    if-ne v6, v1, +003h
    move v0, v1
    sget-object v6, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/service/AccountHelper;->setIsNewUser(Z)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v1, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;
    iget-object v2, v5, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v3, v5, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->$businessScene Ljava/lang/String;
    iget-object v4, v5, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v1, v0, v2, v3, v4, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;-><init>(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Lcom/bytedance/trae/login/PhoneLogin;)V
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const-string/jumbo v0, one_click
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onPassportLoginSuccess(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method
