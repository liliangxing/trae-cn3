# Decompiled TRAE business class
# Source DEX: classes4.dex
.class 0x0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;
.super Ljava/lang/Object;
.source "AccountLoginActivity.java"

.implements Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;
.field final synthetic val$loginPlatform:Lcom/bytedance/trae/login/api/LoginPlatform;


.method constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity  com.bytedance.trae.login.api.LoginPlatform)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->val$loginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public deviceOverLimit(java.lang.String)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public onFailure(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    iget-object v3, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    iget-object v3, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string/jumbo v0, tag_one_click_login
    invoke-virtual v3, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    const/4 v0, 0
    if-eqz v3, +00bh
    const/4 v1, -1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v3, v0, v1, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyLoginResult(Z Ljava/lang/Integer; Ljava/lang/String;)V
    goto +13h
    iget-object v3, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v4, +003h
    goto +7h
    sget v4, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_login_fail I
    invoke-virtual v3, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method public onSuccess()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v1, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    iget-object v2, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->val$loginPlatform Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v3, ""
    invoke-virtual v0, v1, v3, v2, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string/jumbo v1, tag_one_click_login
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    const/4 v1, 1
    if-eqz v0, +007h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyLoginResult(Z Ljava/lang/Integer; Ljava/lang/String;)V
    goto +bh
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$502(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$5;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$600(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    return-void 
.end method
