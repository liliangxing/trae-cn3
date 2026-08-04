# Decompiled TRAE business class
# Source DEX: classes4.dex
.class 0x0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;
.super Ljava/lang/Object;
.source "AccountLoginActivity.java"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;


.method constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method synthetic lambda$onFailed$0$com-bytedance-trae-login-activity-AccountLoginActivity$3()kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 1
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$502(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$600(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method synthetic lambda$onFailed$1$com-bytedance-trae-login-activity-AccountLoginActivity$3()kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string/jumbo v1, tag_one_click_login
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->resetLoginLoadingState()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public onDeviceOverLimit(java.lang.String  java.util.Map)void
    .registers 3
    # ins_size=3
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$400(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Ljava/util/Map;)V
    return-void 
.end method

.method public onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    .registers 24
    # ins_size=10
    move-object v0, v14
    move-object/from16 v1, v17
    move-object/from16 v2, v23
    const-string/jumbo v3, one_click_login_failed
    iget-object v4, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v4
    if-eqz v4, +003h
    return-void 
    const/16 v4, 1075
    move/from16 v5, v16
    if-ne v5, v4, +028h
    if-eqz v2, +00bh
    const-string v4, "cancel_token"
    invoke-interface v2, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +01ah
    invoke-virtual v2, Ljava/lang/String;->isEmpty()Z
    move-result v4
    if-nez v4, +014h
    sget-object v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    iget-object v3, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3$$ExternalSyntheticLambda0;
    invoke-direct v4, v14, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;)V
    new-instance v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3$$ExternalSyntheticLambda1;
    invoke-direct v5, v14, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;)V
    invoke-virtual v1, v3, v2, v4, v5, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, reason
    if-eqz v1, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v3
    invoke-virtual v2, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "error_code"
    invoke-static/range v16, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "login_platform"
    const-string/jumbo v6, one_click
    invoke-virtual v2, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v6, "icube_login_failure"
    invoke-virtual v4, v6, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v8, passport_fail
    const-string/jumbo v9, one_click
    const/4 v10, 0
    const/4 v11, 0
    invoke-static/range v16, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v12
    if-eqz v1, +004h
    move-object v13, v1
    goto +2h
    move-object v13, v3
    invoke-virtual/range v7 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    const-string/jumbo v3, tag_one_click_login
    invoke-virtual v2, v3, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    if-eqz v2, +00ah
    const/4 v3, 0
    invoke-static/range v16, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v2, v3, v4, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyLoginResult(Z Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
    :try_start_0x42
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 4
    # ins_size=4
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string/jumbo v2, tag_one_click_login
    invoke-virtual v1, v2, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    if-eqz v1, +007h
    const/4 v2, 1
    const/4 v3, 0
    invoke-virtual v1, v2, v3, v3, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->notifyLoginResult(Z Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method
