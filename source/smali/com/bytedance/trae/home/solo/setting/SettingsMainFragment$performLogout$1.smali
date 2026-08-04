# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1;
.super Ljava/lang/Object;
.source "SettingsMainFragment.kt"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;

.field final synthetic $loginService:Lcom/bytedance/trae/login/api/ILoginService;
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsMainFragment  com.bytedance.trae.login.api.ILoginService)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1;->$loginService Lcom/bytedance/trae/login/api/ILoginService;
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
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1;->$loginService Lcom/bytedance/trae/login/api/ILoginService;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1$onFailed$1;
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1$onFailed$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;)V
    check-cast v2, Lcom/bytedance/trae/login/api/IAccountCallback;
    const-string/jumbo v3, user_logout
    const/4 v4, 1
    invoke-interface v1, v4, v2, v3, Lcom/bytedance/trae/login/api/ILoginService;->logout(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 4
    # ins_size=4
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$performLogout$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;->access$dismissAfterLogout(Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;)V
    return-void 
.end method
