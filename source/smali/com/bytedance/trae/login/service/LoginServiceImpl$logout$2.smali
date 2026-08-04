# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;
.super Ljava/lang/Object;
.source "LoginServiceImpl.kt"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;

.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic $currentLoginPlatform:Lcom/bytedance/trae/login/api/LoginPlatform;


.method constructor <init>(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.trae.login.api.LoginPlatform)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;->$currentLoginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDeviceOverLimit(java.lang.String  java.util.Map)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    .registers 16
    # ins_size=10
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v11, "logout: passport logout failed (code="
    invoke-direct v9, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, "), fallback to local cleanup"
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "LoginServiceImpl"
    invoke-virtual v7, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v8, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_OUT Lcom/bytedance/trae/login/api/AccountStatus;
    if-nez v10, +005h
    const-string v9, ""
    goto +2h
    move-object v9, v10
    iget-object v11, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;->$currentLoginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-virtual v7, v8, v9, v11, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    if-eqz v0, +00bh
    iget-object v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;->$currentLoginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v2, v10
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onSuccess$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean; I Ljava/lang/Object;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 10
    # ins_size=4
    iget-object v0, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    if-eqz v0, +00eh
    if-nez v7, +004h
    iget-object v7, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;->$currentLoginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    move-object v1, v7
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v2, v8
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onSuccess$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean; I Ljava/lang/Object;)V
    return-void 
.end method
