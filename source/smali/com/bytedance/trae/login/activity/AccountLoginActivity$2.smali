# Decompiled TRAE business class
# Source DEX: classes4.dex
.class 0x0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;
.super Ljava/lang/Object;
.source "AccountLoginActivity.java"

.implements Lcom/bytedance/trae/login/IPhoneOneKeyCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;


.method constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method synthetic lambda$onGetPhoneOneKeyInfoSuccess$0$com-bytedance-trae-login-activity-AccountLoginActivity$2(com.bytedance.trae.login.PhoneOneKeyInfo)void
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +04dh
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +43h
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/login/R$id;->fragment_container I
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentById(I)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v0, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
    if-nez v0, +003h
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStackImmediate()Z
    iget-object v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v10, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->getMaskPhone()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v10, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->getCarrier()Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    move-result-object v10
    invoke-virtual v0, v1, v10, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->showOneClickLoginFragment(Ljava/lang/String; Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "login_page_view_shown"
    const-string/jumbo v4, one_click
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    invoke-virtual/range v2 ... v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onGetPhoneOneKeyInfoFailure(int  java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=4
    iget-object v8, v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v8
    if-nez v8, +01bh
    iget-object v8, v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isDestroyed()Z
    move-result v8
    if-eqz v8, +003h
    goto +11h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v1, one_key_preload_result
    const-string/jumbo v2, one_click
    const/4 v3, 0
    const-string v4, "async_fail"
    move-object v5, v9
    move-object v6, v10
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onGetPhoneOneKeyInfoSuccess(com.bytedance.trae.login.PhoneOneKeyInfo)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +043h
    iget-object v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +39h
    iget-object v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$200(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Lcom/bytedance/trae/login/PhoneOneKeyInfo;)Z
    move-result v0
    if-nez v0, +013h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v2, one_key_preload_result
    const-string/jumbo v3, one_click
    const/4 v4, 0
    const-string v5, "async_invalid"
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$302(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Lcom/bytedance/trae/login/PhoneOneKeyInfo;)Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v2, one_key_preload_result
    const-string/jumbo v3, one_click
    const/4 v4, 0
    const-string v5, "async_success"
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2$$ExternalSyntheticLambda0;
    invoke-direct v1, v8, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$2; Lcom/bytedance/trae/login/PhoneOneKeyInfo;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method
