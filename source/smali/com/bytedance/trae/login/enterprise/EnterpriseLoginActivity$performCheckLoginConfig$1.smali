# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "EnterpriseLoginActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $email:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->$email Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->$email Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 22
    # ins_size=2
    move-object/from16 v1, v20
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->label I
    const/4 v3, 0
    const-string v4, "EnterpriseLoginActivity"
    const/4 v5, 1
    if-eqz v2, +017h
    if-ne v2, v5, +00dh
    invoke-static/range v21, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v21
    goto +2dh
    move-exception v0
    goto +36h
    move-exception v0
    goto/16 +086h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v21, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;
    iget-object v7, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->$email Ljava/lang/String;
    const/4 v8, 0
    invoke-direct v6, v7, v8, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    move-object v7, v1
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v5, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->label I
    invoke-static v2, v6, v7, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    check-cast v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    iget-object v5, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->$email Ljava/lang/String;
    invoke-static v0, v5, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$handleCheckLoginConfigResult(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;)V
    goto/16 +099h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "checkLoginConfig unexpected error: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v7, "enterprise_check_config_fail"
    const-string v8, "enterprise"
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v12
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 2012
    const/16 v19, 0
    invoke-static/range v6 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$setEmailStepLoading(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    instance-of v0, v0, Ljava/io/IOException;
    if-eqz v0, +009h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_network I
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +7h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$showEmailError(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Ljava/lang/String;)V
    goto +46h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "checkLoginConfig failed: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v7, "enterprise_check_config_fail"
    const-string v8, "enterprise"
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getMessage()Ljava/lang/String;
    move-result-object v12
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 2012
    const/16 v19, 0
    invoke-static/range v6 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$setEmailStepLoading(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getUserMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    invoke-static v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$showEmailError(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x10
    :try_start_0x26
.end method
