# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthDeviceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
.field  label:I


.method constructor <init>(com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$TraeAuthDeviceCallback  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +018h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +56h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +14h
    move-exception v7
    goto +30h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->label I
    invoke-virtual v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->listDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;
    iget-object v4, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    const/4 v5, 0
    invoke-direct v3, v7, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;-><init>(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v7, v6
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;->label I
    invoke-static v1, v3, v7, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +01bh
    return-object v0
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "listDevices failed: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v0, "InitAppLog"
    invoke-static v0, v7, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0xe
    :try_start_0x1a
    :try_start_0x23
.end method
