# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BytecloudAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $regionIndex:I
.field  label:I


.method constructor <init>(int  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;->$regionIndex I
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;
    iget v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;->$regionIndex I
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;-><init>(I Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;->label I
    if-nez v0, +01ch
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-static Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->access$getINTERNAL_CHECK_LIST$p()Ljava/util/List;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;->$regionIndex I
    invoke-interface v0, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-static v3, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->access$checkSingleUrl(Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager; Ljava/lang/String;)Z
    move-result v3
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
