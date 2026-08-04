# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$DefaultImpls;
.super Ljava/lang/Object;
.source "AccountCancelApi.kt"


.method public static synthetic emailSendCode$default(com.bytedance.trae.home.solo.setting.IAccountCancelApi  java.util.Map  int  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    if-nez v5, +00ch
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v2, 1
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->emailSendCode(Ljava/util/Map; I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: emailSendCode"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic emailVerify$default(com.bytedance.trae.home.solo.setting.IAccountCancelApi  java.util.Map  int  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    if-nez v5, +00ch
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v2, 1
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->emailVerify(Ljava/util/Map; I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: emailVerify"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic smsValidateCode$default(com.bytedance.trae.home.solo.setting.IAccountCancelApi  java.lang.String  int  int  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    if-nez v6, +012h
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    const/16 v2, 22
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 1
    invoke-interface v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->smsValidateCode(Ljava/lang/String; I I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: smsValidateCode"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
