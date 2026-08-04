# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/IVerificationCodeCallback$DefaultImpls;
.super Ljava/lang/Object;
.source "IVerificationCodeCallback.kt"


.method public static synthetic onSendFailure$default(com.bytedance.trae.login.IVerificationCodeCallback  int  java.lang.String  java.lang.Integer  java.lang.String  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    if-nez v7, +011h
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-interface v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/IVerificationCodeCallback;->onSendFailure(I Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
    new-instance v1, Ljava/lang/UnsupportedOperationException;
    const-string v2, "Super calls with default arguments not supported in this target, function: onSendFailure"
    invoke-direct v1, v2, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v1
.end method
