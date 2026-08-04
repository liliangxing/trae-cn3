# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;
.super Ljava/lang/Object;
.source "VerifyCodeViewModel.kt"

.implements Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;


.method constructor <init>(com.bytedance.trae.login.fragment.VerifyCodeViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public deviceOverLimit(java.lang.String)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public onFailure(java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=3
    iget-object v0, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginExtras$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    if-nez v6, +006h
    const-string/jumbo v2, sms_verify_failed
    goto +2h
    move-object v2, v6
    const-string/jumbo v3, reason
    invoke-virtual v1, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "error_code"
    invoke-static v5, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v2, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "login_platform"
    const-string/jumbo v2, phone
    invoke-virtual v1, v5, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v5, "icube_login_failure"
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v5, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;
    const/4 v1, -1
    invoke-direct v0, v1, v6, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;-><init>(I Ljava/lang/String;)V
    invoke-virtual v5, v0, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$clearCodeInput(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    iget-object v5, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_countdownSeconds$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v5
    invoke-virtual v5, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Integer;
    if-nez v5, +003h
    goto +9h
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v5
    if-nez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    iget-object v6, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v6, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_isResendEnabled$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v6
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-virtual v6, v5, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public onSuccess()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v1, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    const-string v2, ""
    sget-object v3, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginExtras$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Success;->INSTANCE Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Success;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method
