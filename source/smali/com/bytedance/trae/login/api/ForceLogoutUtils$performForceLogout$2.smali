# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/ForceLogoutUtils$performForceLogout$2;
.super Ljava/lang/Object;
.source "ForceLogoutUtils.kt"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDeviceOverLimit(java.lang.String  java.util.Map)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    .registers 10
    # ins_size=10
    sget-object v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-static v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->access$navigateToLogin(Lcom/bytedance/trae/login/api/ForceLogoutUtils;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 4
    # ins_size=4
    sget-object v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-static v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->access$navigateToLogin(Lcom/bytedance/trae/login/api/ForceLogoutUtils;)V
    return-void 
.end method
