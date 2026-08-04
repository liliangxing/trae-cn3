# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/IAccountTokenUpdateCallback$DefaultImpls;
.super Ljava/lang/Object;
.source "IAccountTokenUpdateCallback.kt"


.method public static synthetic onTokenUpdateFailed$default(com.bytedance.trae.login.api.IAccountTokenUpdateCallback  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/api/IAccountTokenUpdateCallback;->onTokenUpdateFailed(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: onTokenUpdateFailed"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic onTokenUpdateSuccess$default(com.bytedance.trae.login.api.IAccountTokenUpdateCallback  java.lang.String  android.os.Bundle  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/api/IAccountTokenUpdateCallback;->onTokenUpdateSuccess(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: onTokenUpdateSuccess"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
