# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "EnterpriseAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
.field final synthetic $email:Ljava/lang/String;
.field final synthetic $tobSession:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.login.enterprise.EnterpriseAuthManager$Callback  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$email Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$tobSession Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$email Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$tobSession Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 25
    # ins_size=2
    move-object/from16 v1, v23
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    const/4 v6, 0
    const-string v7, "EnterpriseAuthManager"
    if-eqz v0, +01fh
    if-eq v0, v5, +013h
    if-eq v0, v4, +004h
    if-ne v0, v3, +007h
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +10eh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +101h
    move-exception v0
    goto +54h
    move-exception v0
    goto/16 +0a2h
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "loginWithSsoSession: starting SSO token flow"
    invoke-virtual v0, v7, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    iget-object v8, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$email Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$tobSession Ljava/lang/String;
    invoke-static v0, v8, v9, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->access$completeTokenFlow(Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "loginWithSsoSession: completed successfully"
    invoke-virtual v0, v7, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v10, "login_success"
    const-string v11, "enterprise"
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 2044
    const/16 v22, 0
    invoke-static/range v9 ... v22, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1$1;
    iget-object v9, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    invoke-direct v8, v9, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v5, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->label I
    invoke-static v0, v8, v9, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +0adh
    return-object v2
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "loginWithSsoSession unexpected error: "
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v7, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v9, "login_failure"
    const-string v10, "enterprise"
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 2012
    const/16 v21, 0
    invoke-static/range v8 ... v21, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1$3;
    iget-object v5, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1$3;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->label I
    invoke-static v0, v4, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +05dh
    return-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "loginWithSsoSession failed: "
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v7, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getErrorCode()I
    move-result v3
    invoke-static v3, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getFailedStep()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getMessage()Ljava/lang/String;
    move-result-object v14
    const-string v9, "login_failure"
    const-string v10, "enterprise"
    const/4 v11, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 1988
    const/16 v21, 0
    invoke-static/range v8 ... v21, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    new-instance v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1$2;
    iget-object v7, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    invoke-direct v5, v7, v0, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1$2;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback; Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    iput v4, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;->label I
    invoke-static v3, v5, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x23
    :try_start_0x30
.end method
