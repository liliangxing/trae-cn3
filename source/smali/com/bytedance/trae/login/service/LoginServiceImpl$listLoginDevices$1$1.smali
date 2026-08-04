# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "LoginServiceImpl.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $devices:Ljava/util/List;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function1;
.field final synthetic $result:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
.field  label:I


.method constructor <init>(kotlin.jvm.functions.Function1  java.util.List  com.bytedance.trae.login.traeauth.ListDevicesResult  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$devices Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$result Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;
    iget-object v0, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iget-object v1, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$devices Ljava/util/List;
    iget-object v2, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$result Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;-><init>(Lkotlin/jvm/functions/Function1; Ljava/util/List; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->label I
    if-nez v0, +01ah
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    new-instance v0, Lcom/bytedance/trae/login/api/LoginDeviceListResult;
    iget-object v1, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$devices Ljava/util/List;
    iget-object v2, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;->$result Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;->getMaxDeviceCount()Ljava/lang/Integer;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginDeviceListResult;-><init>(Ljava/util/List; Ljava/lang/Integer;)V
    invoke-interface v4, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
