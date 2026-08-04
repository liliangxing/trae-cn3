# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;
.super Ljava/lang/Object;
.source "IAccountCallback.kt"


.method public static synthetic onFailed$default(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map  int  java.lang.Object)void
    .registers 25
    # ins_size=12
    move/from16 v0, v23
    if-nez v24, +030h
    and-int/lit8 v1, v0, 32
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v19
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v21
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v22
    move-object v3, v13
    move-object v4, v14
    move v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    invoke-interface/range v3 ... v12, Lcom/bytedance/trae/login/api/IAccountCallback;->onFailed(Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: onFailed"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic onSuccess$default(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    if-nez v5, +00fh
    and-int/lit8 v4, v4, 4
    if-eqz v4, +007h
    const/4 v3, 0
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/login/api/IAccountCallback;->onSuccess(Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: onSuccess"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
