# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;
.super Ljava/lang/Object;
.source "VerifyCodeViewModel.kt"

.implements Lcom/bytedance/trae/login/IVerificationCodeCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;


.method constructor <init>(com.bytedance.trae.login.fragment.VerifyCodeViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onSendFailure(int  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 24
    # ins_size=5
    move-object/from16 v0, v21
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v3, sms_resend_failed
    if-nez v0, +004h
    move-object v4, v3
    goto +2h
    move-object v4, v0
    const-string/jumbo v5, reason
    invoke-virtual v2, v5, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "error_code"
    invoke-static/range v20, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "login_platform"
    const-string/jumbo v5, phone
    invoke-virtual v2, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v4, "icube_login_failure"
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v6, sms_resend_error
    const-string/jumbo v7, phone
    const/4 v8, 0
    const/4 v9, 0
    invoke-static/range v20, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v10
    if-nez v0, +004h
    move-object v11, v3
    goto +2h
    move-object v11, v0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 1996
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    move-object/from16 v1, v19
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_resendState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Error;
    move/from16 v4, v20
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Error;-><init>(I Ljava/lang/String;)V
    invoke-virtual v2, v3, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public onSendSuccess()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_resendState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Success;->INSTANCE Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Success;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Idle;->INSTANCE Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Idle;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$clearCodeInput(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$startCountdown(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    return-void 
.end method
