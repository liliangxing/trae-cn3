# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BytecloudAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $regionIndex:I
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(int  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->$regionIndex I
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;
    iget v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->$regionIndex I
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;-><init>(I Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->label I
    const/4 v2, 2
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v1, +01ah
    if-eq v1, v4, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +61h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    iget-object v1, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/Deferred;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3bh
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$enableSso$1;
    iget v5, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->$regionIndex I
    invoke-direct v1, v5, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$enableSso$1;-><init>(I Lkotlin/coroutines/Continuation;)V
    move-object v8, v1
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    move-object v5, v13
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v1
    new-instance v5, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;
    iget v8, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->$regionIndex I
    invoke-direct v5, v8, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1;-><init>(I Lkotlin/coroutines/Continuation;)V
    move-object v8, v5
    check-cast v8, Lkotlin/jvm/functions/Function2;
    move-object v5, v13
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v13
    move-object v5, v12
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v13, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->L$0 Ljava/lang/Object;
    iput v4, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->label I
    invoke-interface v1, v5, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v11, v1
    move-object v1, v13
    move-object v13, v11
    check-cast v13, Ljava/lang/Boolean;
    invoke-virtual v13, Ljava/lang/Boolean;->booleanValue()Z
    move-result v13
    if-eqz v13, +019h
    move-object v13, v12
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v3, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->L$0 Ljava/lang/Object;
    iput v2, v12, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1;->label I
    invoke-interface v1, v13, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Ljava/lang/Boolean;
    invoke-virtual v13, Ljava/lang/Boolean;->booleanValue()Z
    move-result v13
    if-eqz v13, +003h
    goto +2h
    const/4 v4, 0
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v13
    return-object v13
.end method
