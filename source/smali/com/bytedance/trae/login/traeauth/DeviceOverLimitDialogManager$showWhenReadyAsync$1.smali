# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceOverLimitDialogManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
.field final synthetic $listResult:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
.field final synthetic $scene:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
.field  label:I


.method constructor <init>(com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$scene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iput-object v3, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$callback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;
    iget-object v0, v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v1, v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$scene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$callback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;-><init>(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
    iget-object v1, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v3, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$scene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iget-object v4, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->$callback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;->label I
    invoke-virtual v7, v1, v3, v4, v5, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->showWhenReady(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
