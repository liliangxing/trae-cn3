# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/ILoginService$DefaultImpls;
.super Ljava/lang/Object;
.source "ILoginService.kt"


.method public static cleanupGoogleAuth(com.bytedance.trae.login.api.ILoginService)void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public static getGoogleSignInIntent(com.bytedance.trae.login.api.ILoginService  android.app.Activity)android.content.Intent
    .registers 2
    # ins_size=2
    const-string v0, "activity"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    return-object v0
.end method

.method public static handleGoogleAuthResult(com.bytedance.trae.login.api.ILoginService  int  int  android.content.Intent)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public static parseGoogleSignInResult(com.bytedance.trae.login.api.ILoginService  android.content.Intent)java.util.Map
    .registers 2
    # ins_size=2
    const/4 v0, 0
    return-object v0
.end method

.method public static synthetic refreshUserInfo$default(com.bytedance.trae.login.api.ILoginService  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/api/ILoginService;->refreshUserInfo(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: refreshUserInfo"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic registerAccountStatusChangeListener$default(com.bytedance.trae.login.api.ILoginService  com.bytedance.trae.login.api.IAccountStatusListener  java.lang.Boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00fh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +007h
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/api/ILoginService;->registerAccountStatusChangeListener(Lcom/bytedance/trae/login/api/IAccountStatusListener; Ljava/lang/Boolean;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: registerAccountStatusChangeListener"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
