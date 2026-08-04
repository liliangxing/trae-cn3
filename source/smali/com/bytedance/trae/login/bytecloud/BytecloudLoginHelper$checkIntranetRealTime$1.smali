# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BytecloudLoginHelper.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;
.field  label:I


.method constructor <init>(com.bytedance.trae.login.bytecloud.BytecloudLoginHelper$NetworkCheckCallback  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->$callback Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;
    iget-object v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->$callback Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;-><init>(Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    move-object v1, v3
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->label I
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->checkIntranetRealTime(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    iget-object v0, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$checkIntranetRealTime$1;->$callback Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;
    invoke-interface v0, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;->onResult(Z)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
