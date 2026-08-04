# Decompiled TRAE business class
# Source DEX: classes4.dex
.class 0x0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;
.super Ljava/lang/Object;
.source "AccountLoginActivity.java"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;


.method constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method synthetic lambda$onDeviceOverLimit$0$com-bytedance-trae-login-activity-AccountLoginActivity$4()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$702(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$800(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)V
    return-void 
.end method

.method synthetic lambda$onFailed$2$com-bytedance-trae-login-activity-AccountLoginActivity$4(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$702(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$800(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)V
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v3, +003h
    goto +7h
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_douyin_auth_failed I
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method synthetic lambda$onFailed$3$com-bytedance-trae-login-activity-AccountLoginActivity$4()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$702(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$800(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)V
    return-void 
.end method

.method synthetic lambda$onFailed$4$com-bytedance-trae-login-activity-AccountLoginActivity$4()kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 1
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$502(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$600(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method synthetic lambda$onFailed$5$com-bytedance-trae-login-activity-AccountLoginActivity$4(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$702(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$800(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)V
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$900(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Ljava/lang/String;)V
    return-void 
.end method

.method synthetic lambda$onFailed$6$com-bytedance-trae-login-activity-AccountLoginActivity$4()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$702(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$800(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)V
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_douyin_authorize_cancelled I
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method synthetic lambda$onSuccess$1$com-bytedance-trae-login-activity-AccountLoginActivity$4()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$702(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$800(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)V
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$600(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    return-void 
.end method

.method public onDeviceOverLimit(java.lang.String  java.util.Map)void
    .registers 4
    # ins_size=3
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda6;
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v2, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$400(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Ljava/util/Map;)V
    return-void 
.end method

.method public onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    .registers 24
    # ins_size=10
    move-object v0, v14
    move-object/from16 v1, v17
    move-object/from16 v2, v20
    move-object/from16 v3, v23
    const-string v4, "douyin_login_failed"
    iget-object v5, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v5, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v5
    if-eqz v5, +003h
    return-void 
    const/4 v5, 0
    if-eqz v3, +009h
    const-string v6, "failed_step"
    invoke-interface v3, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +2h
    move-object v6, v5
    instance-of v7, v6, Ljava/lang/String;
    if-eqz v7, +006h
    check-cast v6, Ljava/lang/String;
    move-object v11, v6
    goto +2h
    move-object v11, v5
    const-string/jumbo v6, trae_auth_after_douyin_auth
    invoke-virtual v6, v11, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    const/4 v7, 1
    if-eqz v6, +027h
    iget-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v2, v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$502(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    sget-object v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v8, "douyin_auth_trae_auth_fail"
    const-string v9, "douyin"
    const/4 v10, 0
    invoke-static/range v16, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v12
    if-eqz v1, +004h
    move-object v13, v1
    goto +4h
    const-string v2, "douyin_trae_auth_failed"
    move-object v13, v2
    invoke-virtual/range v7 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda1;
    invoke-direct v3, v14, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$4; Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
    const/16 v6, 1075
    move/from16 v8, v16
    if-ne v8, v6, +03ah
    if-eqz v3, +00bh
    const-string v5, "cancel_token"
    invoke-interface v3, v5, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    move-object v5, v3
    check-cast v5, Ljava/lang/String;
    if-eqz v5, +02dh
    invoke-virtual v5, Ljava/lang/String;->isEmpty()Z
    move-result v3
    if-nez v3, +027h
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda2;
    invoke-direct v2, v14, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    sget-object v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    iget-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda3;
    invoke-direct v3, v14, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;)V
    const/4 v4, 0
    const-string v6, "douyin"
    move-object v15, v1
    move-object/from16 v16, v2
    move-object/from16 v17, v5
    move-object/from16 v18, v3
    move-object/from16 v19, v4
    move-object/from16 v20, v6
    invoke-virtual/range v15 ... v20, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Ljava/lang/String;)V
    return-void 
    const-string v3, "douyin"
    if-eqz v2, +026h
    invoke-virtual/range v20, Ljava/lang/String;->isEmpty()Z
    move-result v5
    if-nez v5, +020h
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v1, v7, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$502(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "douyin_auth_need_bind"
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "douyin_bind_phone_shown"
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda4;
    invoke-direct v3, v14, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$4; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v5, reason
    if-eqz v1, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v4
    invoke-virtual v2, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "error_code"
    invoke-static/range v16, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "login_platform"
    invoke-virtual v2, v5, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v5, "icube_login_failure"
    invoke-virtual v3, v5, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "douyin_auth_cancelled"
    const-string v5, "douyin"
    const/4 v6, 0
    const/4 v7, 0
    invoke-static/range v16, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v8
    if-eqz v1, +003h
    goto +2h
    move-object v1, v4
    move-object v15, v2
    move-object/from16 v16, v3
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move-object/from16 v19, v7
    move-object/from16 v20, v8
    move-object/from16 v21, v1
    invoke-virtual/range v15 ... v21, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda5;
    invoke-direct v2, v14, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
    :try_start_0xc0
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 4
    # ins_size=4
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isFinishing()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v2, 1
    invoke-static v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$502(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda0;
    invoke-direct v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$4$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$4;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method
