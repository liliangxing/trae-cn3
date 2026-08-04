# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IMService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $taskId:Ljava/lang/String;
.field  I$0:I
.field  I$1:I
.field  I$2:I
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$taskId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;
    iget-object v0, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$taskId Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$conversationId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->label I
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v2, +043h
    if-eq v2, v5, +027h
    if-ne v2, v3, +01dh
    iget v2, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$1 I
    iget v6, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$0 I
    iget-object v7, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$1 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v8, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$0 Ljava/lang/Object;
    check-cast v8, Ljava/util/List;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v0
    move-object/from16 v16, v8
    move v8, v2
    move-object/from16 v2, v16
    move-object/from16 v17, v7
    move v7, v6
    move-object/from16 v6, v17
    goto +36h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget v2, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$2 I
    iget v6, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$1 I
    iget v7, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$0 I
    iget-object v8, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$1 Ljava/lang/Object;
    check-cast v8, Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v9, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$0 Ljava/lang/Object;
    check-cast v9, Ljava/util/List;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v11, v19
    move v10, v2
    move v2, v6
    move v6, v7
    move-object v7, v8
    move-object v8, v9
    move-object v9, v0
    goto +47h
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    new-instance v6, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v6, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    const/4 v7, 0
    const/16 v8, 20
    move-object v9, v0
    if-ge v7, v8, +078h
    add-int/lit8 v7, v7, 1
    iget v10, v6, Lkotlin/jvm/internal/Ref$IntRef;->element I
    add-int/lit16 v10, v10, 500
    sget-object v11, Lcom/bytedance/trae/im/service/IListEventsService;->Companion Lcom/bytedance/trae/im/service/IListEventsService$Companion;
    new-instance v12, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$result$1;
    iget-object v13, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$taskId Ljava/lang/String;
    invoke-direct v12, v13, v10, v6, v4, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$result$1;-><init>(Ljava/lang/String; I Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    move-object v13, v9
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v2, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$0 Ljava/lang/Object;
    iput-object v6, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$1 Ljava/lang/Object;
    iput v7, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$0 I
    iput v8, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$1 I
    iput v10, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$2 I
    iput v5, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->label I
    invoke-virtual v11, v12, v13, Lcom/bytedance/trae/im/service/IListEventsService$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move/from16 v16, v8
    move-object v8, v2
    move/from16 v2, v16
    move/from16 v17, v7
    move-object v7, v6
    move/from16 v6, v17
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v12, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v12, +029h
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/ListEventsResponse;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/ListEventsResponse;->getEvents()Ljava/util/List;
    move-result-object v11
    goto +2h
    move-object v11, v4
    if-nez v11, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v11
    invoke-interface v11, Ljava/util/List;->isEmpty()Z
    move-result v12
    if-eqz v12, +004h
    move-object v2, v8
    goto +1eh
    check-cast v11, Ljava/util/Collection;
    invoke-interface v8, v11, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    iput v10, v7, Lkotlin/jvm/internal/Ref$IntRef;->element I
    move-object v10, v9
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput-object v8, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$0 Ljava/lang/Object;
    iput-object v7, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->L$1 Ljava/lang/Object;
    iput v6, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$0 I
    iput v2, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->I$1 I
    iput v3, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->label I
    const-wide/16 v11, 50
    invoke-static v11, v12, v10, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, -0b5h
    return-object v1
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getIoScope$p()Lkotlinx/coroutines/CoroutineScope;
    move-result-object v10
    const/4 v11, 0
    const/4 v12, 0
    new-instance v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;
    iget-object v3, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$taskId Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$conversationId Ljava/lang/String;
    invoke-direct v1, v2, v3, v5, v4, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v13, v1
    check-cast v13, Lkotlin/jvm/functions/Function2;
    const/4 v14, 3
    const/4 v15, 0
    invoke-static/range v10 ... v15, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getPollingJobs$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v1
    iget-object v2, v9, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1;->$taskId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
