# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/api/IApplog$DefaultImpls;
.super Ljava/lang/Object;
.source "IApplog.kt"


.method public static synthetic onAccountTypeChanged$default(com.bytedance.trae.applog.api.IApplog  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    if-nez v7, +017h
    and-int/lit8 v7, v6, 2
    const-string v0, ""
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-interface v1, v2, v3, v4, v5, Lcom/bytedance/trae/applog/api/IApplog;->onAccountTypeChanged(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    new-instance v1, Ljava/lang/UnsupportedOperationException;
    const-string v2, "Super calls with default arguments not supported in this target, function: onAccountTypeChanged"
    invoke-direct v1, v2, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v1
.end method
