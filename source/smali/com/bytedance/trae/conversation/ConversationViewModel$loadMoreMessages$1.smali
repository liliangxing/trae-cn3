# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $anchorCreatedAtMs:Ljava/lang/Long;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $onComplete:Lkotlin/jvm/functions/Function0;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.Long  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$anchorCreatedAtMs Ljava/lang/Long;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$onComplete Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$conversationId Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$anchorCreatedAtMs Ljava/lang/Long;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$onComplete Lkotlin/jvm/functions/Function0;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/Long; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=2
    move-object/from16 v1, v19
    const-string v0, "loadMoreMessages: API success, raw messages count="
    const-string v2, "loadMoreMessages biz error: code="
    const-string v3, "loadMoreMessages: API error, code="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->label I
    const/4 v6, 2
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v5, +01ch
    if-eq v5, v8, +011h
    if-ne v5, v6, +007h
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +164h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v5, v20
    goto +27h
    move-exception v0
    goto/16 +16eh
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$conversationId Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$anchorCreatedAtMs Ljava/lang/Long;
    invoke-virtual v5, Ljava/lang/Long;->toString()Ljava/lang/String;
    move-result-object v11
    const/16 v12, 10
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    move-object/from16 v16, v1
    check-cast v16, Lkotlin/coroutines/Continuation;
    const/16 v17, 32
    const/16 v18, 0
    iput v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->label I
    invoke-static/range v9 ... v18, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v4, +003h
    return-object v4
    check-cast v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v9
    instance-of v10, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v11, ", msg="
    const-string v12, "ConversationViewModel"
    if-eqz v10, +0d1h
    move-object v3, v9
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v3
    if-nez v3, +033h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v12, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +0e4h
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;->getMessages()Ljava/util/List;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$filterDisplayableMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v12, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$toParsedHistoryMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/2addr v3, v8
    if-eqz v3, +015h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/List;
    invoke-static v3, v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$mergeMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    move-object v0, v2
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v8
    if-eqz v0, +022h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_hasMoreMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getRequest()Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;->getBeforeLimit()I
    move-result v4
    invoke-virtual v3, v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreHistoryPage$conversation_mainlandRelease(I I)Z
    move-result v2
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +60h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_hasMoreMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +52h
    instance-of v0, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +064h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v3, v9
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-object v3, v9
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object v3, v9
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v3
    invoke-virtual v0, v12, v2, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    const/16 v2, 401
    if-ne v0, v2, +016h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_forceLogout$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v3, v1
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->label I
    invoke-interface v0, v2, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_isLoadingMore$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$onComplete Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_isLoadingMore$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMoreMessages$1;->$onComplete Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    throw v0
    :try_start_0x17
    :try_start_0x24
    :try_start_0x30
    :try_start_0x5e
    :try_start_0x193
.end method
