# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;
.super Ljava/lang/Object;
.source "PhoneLogin.kt"

.implements Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;

.field final synthetic $businessScene:Ljava/lang/String;
.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic $isNewUser:Z
.field final synthetic this$0:Lcom/bytedance/trae/login/PhoneLogin;


.method constructor <init>(boolean  com.bytedance.trae.login.api.IAccountCallback  java.lang.String  com.bytedance.trae.login.PhoneLogin)void
    .registers 5
    # ins_size=5
    iput-boolean v1, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$isNewUser Z
    iput-object v2, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v3, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$businessScene Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public deviceOverLimit(java.lang.String)void
    .registers 8
    # ins_size=2
    const-string v0, "deviceOverLimit"
    const-string v1, "TraeAuthManager"
    invoke-static v1, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v2, Ljava/util/HashMap;
    invoke-direct v2, Ljava/util/HashMap;-><init>()V
    move-object v3, v2
    check-cast v3, Ljava/util/Map;
    const-string v4, "is_new_user"
    iget-boolean v5, v6, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$isNewUser Z
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    check-cast v5, Ljava/lang/Object;
    invoke-interface v3, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v6, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    check-cast v2, Ljava/util/Map;
    invoke-interface v3, v7, v2, Lcom/bytedance/trae/login/api/IAccountCallback;->onDeviceOverLimit(Ljava/lang/String; Ljava/util/Map;)V
    goto +5h
    move-exception v7
    invoke-static v1, v0, v7, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x4
.end method

.method public onFailure(java.lang.String  java.lang.String)void
    .registers 15
    # ins_size=3
    iget-object v0, v12, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v1, v12, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-virtual v1, Lcom/bytedance/trae/login/PhoneLogin;->providePlatform()Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v1
    if-eqz v13, +00dh
    invoke-static v13, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    goto +2h
    const/4 v2, -1
    if-nez v14, +005h
    const-string v3, "Trae auth flow failed"
    goto +2h
    move-object v3, v14
    iget-object v4, v12, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$businessScene Ljava/lang/String;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 480
    const/4 v11, 0
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OneKey login Trae auth failed: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const/16 v0, 32
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    const-string v14, "PhoneLogin"
    invoke-static v14, v13, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public onSuccess()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v1, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    iget-object v2, v4, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$businessScene Ljava/lang/String;
    if-nez v2, +004h
    const-string v2, ""
    iget-object v3, v4, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-virtual v3, Lcom/bytedance/trae/login/PhoneLogin;->providePlatform()Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v1, v4, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-virtual v1, Lcom/bytedance/trae/login/PhoneLogin;->providePlatform()Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$businessScene Ljava/lang/String;
    iget-boolean v3, v4, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1;->$isNewUser Z
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/login/api/IAccountCallback;->onSuccess(Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean;)V
    const-string v0, "PhoneLogin"
    const-string v1, "OneKey login + Trae auth flow completed successfully"
    invoke-static v0, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method
