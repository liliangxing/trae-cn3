# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;
.super Ljava/lang/Object;
.source "LoginServiceImpl.kt"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;

.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic $currentLoginPlatform:Lcom/bytedance/trae/login/api/LoginPlatform;


.method constructor <init>(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.trae.login.api.LoginPlatform)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;->$currentLoginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDeviceOverLimit(java.lang.String  java.util.Map)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    .registers 23
    # ins_size=10
    move-object v0, v13
    iget-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    if-eqz v1, +014h
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 480
    const/4 v12, 0
    move-object v2, v14
    move v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    move-object/from16 v6, v18
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 10
    # ins_size=4
    iget-object v0, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    if-eqz v0, +00eh
    if-nez v7, +004h
    iget-object v7, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;->$currentLoginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    move-object v1, v7
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v2, v8
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onSuccess$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean; I Ljava/lang/Object;)V
    return-void 
.end method
