# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VerifyCodeViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $extras:Ljava/util/Map;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;


.method constructor <init>(com.bytedance.trae.login.fragment.VerifyCodeViewModel  java.util.Map  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->$extras Ljava/util/Map;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->$extras Ljava/util/Map;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;-><init>(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel; Ljava/util/Map; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 34
    # ins_size=2
    move-object/from16 v1, v32
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v2, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    invoke-static/range v33, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v33
    goto +28h
    move-exception v0
    goto +43h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v33, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1;
    const/4 v5, 0
    invoke-direct v4, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->label I
    invoke-static v2, v4, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    check-cast v2, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginExtras$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    iget-object v4, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->$extras Ljava/util/Map;
    invoke-virtual v0, v4, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    new-instance v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeviceOverLimit;
    invoke-direct v4, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeviceOverLimit;-><init>(Lcom/bytedance/trae/login/traeauth/ListDevicesResult;)V
    invoke-virtual v0, v4, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto/16 +09ch
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v5, reason
    const-string v6, "device_over_limit_list_failed"
    invoke-virtual v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "login_platform"
    const-string/jumbo v6, phone
    invoke-virtual v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v5, "icube_login_failure"
    invoke-virtual v2, v5, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    instance-of v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    if-eqz v2, +020h
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getHttpCode()Ljava/lang/Integer;
    move-result-object v12
    const-string v5, "list_device"
    const-string/jumbo v6, phone
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const-string v10, "list_device_error"
    const/4 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1872
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +21h
    sget-object v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v19, "list_device"
    const-string/jumbo v20, phone
    const/16 v21, 0
    const/16 v22, 0
    const-string v23, "-1"
    const-string v24, "list_device_error"
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 1984
    const/16 v31, 0
    invoke-static/range v18 ... v31, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_loginState$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;
    const/4 v4, -1
    const-string v5, ""
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;-><init>(I Ljava/lang/String;)V
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$clearCodeInput(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_countdownSeconds$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Integer;
    if-nez v0, +003h
    goto +8h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    if-nez v0, +003h
    goto +2h
    const/4 v3, 0
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_isResendEnabled$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0xd
    :try_start_0x20
.end method
