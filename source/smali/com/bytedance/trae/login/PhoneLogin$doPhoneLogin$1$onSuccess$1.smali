# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;
.super Ljava/lang/Object;
.source "PhoneLogin.kt"

.implements Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;

.field final synthetic $businessScene:Ljava/lang/String;
.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic $isNewUser:Z
.field final synthetic $platform:Lcom/bytedance/trae/login/api/LoginPlatform;
.field final synthetic this$0:Lcom/bytedance/trae/login/PhoneLogin;


.method constructor <init>(boolean  com.bytedance.trae.login.api.IAccountCallback  java.lang.String  com.bytedance.trae.login.api.LoginPlatform  com.bytedance.trae.login.PhoneLogin)void
    .registers 6
    # ins_size=6
    iput-boolean v1, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$isNewUser Z
    iput-object v2, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v3, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$businessScene Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    iput-object v5, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public deviceOverLimit(java.lang.String)void
    .registers 5
    # ins_size=2
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iget-boolean v1, v3, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$isNewUser Z
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    check-cast v1, Ljava/lang/Object;
    const-string v2, "is_new_user"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v3, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    invoke-interface v1, v4, v0, Lcom/bytedance/trae/login/api/IAccountCallback;->onDeviceOverLimit(Ljava/lang/String; Ljava/util/Map;)V
    return-void 
.end method

.method public onFailure(java.lang.String  java.lang.String)void
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    move-object/from16 v2, v19
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "Trae auth flow failed: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v4, 32
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "PhoneLogin"
    invoke-static v4, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v5, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v6, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    if-eqz v1, +00dh
    invoke-static/range v18, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, -1
    move v7, v1
    if-nez v2, +006h
    const-string v1, "Trae auth flow failed"
    move-object v8, v1
    goto +2h
    move-object v8, v2
    iget-object v9, v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$businessScene Ljava/lang/String;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 480
    const/16 v16, 0
    invoke-static/range v5 ... v16, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    return-void 
.end method

.method public onSuccess()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v1, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    iget-object v2, v4, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$businessScene Ljava/lang/String;
    if-nez v2, +004h
    const-string v2, ""
    iget-object v3, v4, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$platform Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v1, v4, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->this$0 Lcom/bytedance/trae/login/PhoneLogin;
    invoke-virtual v1, Lcom/bytedance/trae/login/PhoneLogin;->providePlatform()Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$businessScene Ljava/lang/String;
    iget-boolean v3, v4, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1$onSuccess$1;->$isNewUser Z
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/login/api/IAccountCallback;->onSuccess(Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean;)V
    const-string v0, "PhoneLogin"
    const-string v1, "Trae auth flow completed successfully:"
    invoke-static v0, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method
