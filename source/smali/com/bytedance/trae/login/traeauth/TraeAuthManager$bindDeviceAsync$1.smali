# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $onResult:Lkotlin/jvm/functions/Function1;
.field  label:I


.method constructor <init>(kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->$onResult Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->$onResult Lkotlin/jvm/functions/Function1;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    const-string v0, "bindDeviceAsync: success, boundDeviceId="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->label I
    const/4 v3, 1
    const-string v4, "TraeAuthManager"
    if-eqz v2, +015h
    if-ne v2, v3, +00bh
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +46h
    move-exception v13
    goto +72h
    move-exception v13
    goto/16 +089h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getRefreshToken()Ljava/lang/String;
    move-result-object v6
    move-object v13, v6
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    if-nez v13, +004h
    move v13, v3
    goto +2h
    const/4 v13, 0
    if-eqz v13, +00ch
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "bindDeviceAsync: no refresh token, skip"
    invoke-virtual v13, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    sget-object v13, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getDeviceInfo()Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    move-result-object v7
    const/4 v8, 0
    move-object v9, v12
    check-cast v9, Lkotlin/coroutines/Continuation;
    const/4 v10, 4
    const/4 v11, 0
    iput v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->label I
    invoke-static/range v5 ... v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->bindDevice$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v1, +003h
    return-object v1
    check-cast v13, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;->getBoundDeviceId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", status="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;->getDeviceBindStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;->$onResult Lkotlin/jvm/functions/Function1;
    if-eqz v0, +045h
    invoke-interface v0, v13, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +40h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "bindDeviceAsync unexpected error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, v4, v13, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +27h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "bindDeviceAsync failed: ["
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "] "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, v4, v13, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    :try_start_0xf
    :try_start_0x23
.end method
