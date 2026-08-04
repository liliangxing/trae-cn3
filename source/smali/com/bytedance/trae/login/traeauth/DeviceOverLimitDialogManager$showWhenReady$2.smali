# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceOverLimitDialogManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $activity:Landroid/app/Activity;
.field final synthetic $callback:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
.field final synthetic $listResult:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
.field final synthetic $scene:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
.field  label:I


.method constructor <init>(android.app.Activity  com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$activity Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iput-object v3, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$scene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iput-object v4, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$callback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;
    iget-object v1, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$activity Landroid/app/Activity;
    iget-object v2, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v3, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$scene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iget-object v4, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$callback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;-><init>(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->label I
    if-nez v0, +015h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
    iget-object v0, v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$activity Landroid/app/Activity;
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v2, v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$scene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iget-object v3, v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;->$callback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    invoke-static v5, v0, v1, v2, v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->access$showDialog(Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager; Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
