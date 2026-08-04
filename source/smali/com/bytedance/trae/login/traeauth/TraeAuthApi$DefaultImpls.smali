# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeAuthApi$DefaultImpls;
.super Ljava/lang/Object;
.source "TraeAuthApi.kt"


.method public static synthetic login$default(com.bytedance.trae.login.traeauth.TraeAuthApi  com.bytedance.trae.login.traeauth.TraeLoginRequest  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    if-nez v5, +00ch
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;->login(Lcom/bytedance/trae/login/traeauth/TraeLoginRequest; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: login"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
