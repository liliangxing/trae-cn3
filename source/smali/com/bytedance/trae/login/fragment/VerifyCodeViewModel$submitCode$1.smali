# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;
.super Ljava/lang/Object;
.source "VerifyCodeViewModel.kt"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;


.method constructor <init>(com.bytedance.trae.login.fragment.VerifyCodeViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDeviceOverLimit(java.lang.String  java.util.Map)void
    .registers 9
    # ins_size=3
    iget-object v7, v6, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    check-cast v7, Landroidx/lifecycle/ViewModel;
    invoke-static v7, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 0
    new-instance v7, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;
    iget-object v3, v6, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    const/4 v4, 0
    invoke-direct v7, v3, v8, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;-><init>(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel; Ljava/util/Map; Lkotlin/coroutines/Continuation;)V
    move-object v3, v7
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    .registers 33
    # ins_size=10
    move-object/from16 v0, v23
    move/from16 v1, v25
    move-object/from16 v2, v26
    move-object/from16 v3, v32
    iget-object v4, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginExtras$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v4
    const/4 v5, 0
    invoke-virtual v4, v5, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    const/16 v4, 1075
    const/4 v6, 1
    const/4 v7, 0
    if-ne v1, v4, +033h
    if-eqz v3, +009h
    const-string v4, "cancel_token"
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +2h
    move-object v3, v5
    instance-of v4, v3, Ljava/lang/String;
    if-eqz v4, +005h
    move-object v5, v3
    check-cast v5, Ljava/lang/String;
    move-object v3, v5
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v7
    goto +2h
    move v3, v6
    if-nez v3, +011h
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeletionPending;
    invoke-direct v2, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeletionPending;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v5, sms_verify_failed
    if-nez v2, +004h
    move-object v8, v5
    goto +2h
    move-object v8, v2
    const-string/jumbo v9, reason
    invoke-virtual v4, v9, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "error_code"
    invoke-static/range v25, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "login_platform"
    const-string/jumbo v9, phone
    invoke-virtual v4, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v8, "icube_login_failure"
    invoke-virtual v3, v8, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v10, passport_fail
    const-string/jumbo v11, phone
    const/4 v12, 0
    const/4 v13, 0
    invoke-static/range v25, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v14
    if-nez v2, +004h
    move-object v15, v5
    goto +2h
    move-object v15, v2
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 1996
    const/16 v22, 0
    invoke-static/range v9 ... v22, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v3, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;
    invoke-direct v4, v1, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;-><init>(I Ljava/lang/String;)V
    invoke-virtual v3, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$clearCodeInput(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_countdownSeconds$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Integer;
    if-nez v1, +003h
    goto +8h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v6, v7
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_isResendEnabled$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-static v6, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 4
    # ins_size=4
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginExtras$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Success;->INSTANCE Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Success;
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method
