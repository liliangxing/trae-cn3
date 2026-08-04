# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;
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
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$anchorCreatedAtMs Ljava/lang/Long;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$onComplete Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$conversationId Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$anchorCreatedAtMs Ljava/lang/Long;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$onComplete Lkotlin/jvm/functions/Function0;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/Long; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    const-string v0, "loadNewerAnchorMessages biz error: code="
    const-string v2, "loadNewerAnchorMessages: API error, code="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->label I
    const/4 v5, 0
    const/4 v6, 2
    const/4 v7, 1
    if-eqz v4, +01ch
    if-eq v4, v7, +011h
    if-ne v4, v6, +007h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +122h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v18
    goto +27h
    move-exception v0
    goto/16 +124h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$conversationId Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$anchorCreatedAtMs Ljava/lang/Long;
    invoke-virtual v9, Ljava/lang/Long;->toString()Ljava/lang/String;
    move-result-object v9
    const/4 v10, 0
    const/16 v11, 10
    const/4 v12, 0
    const/4 v13, 0
    move-object v14, v1
    check-cast v14, Lkotlin/coroutines/Continuation;
    const/16 v15, 32
    const/16 v16, 0
    iput v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->label I
    move-object v7, v4
    invoke-static/range v7 ... v16, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v3, +003h
    return-object v3
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v7
    instance-of v8, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v9, ", msg="
    const-string v10, "ConversationViewModel"
    if-eqz v8, +08fh
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-nez v2, +033h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v11
    invoke-virtual v3, v11, v12, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v10, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +0a2h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;->getMessages()Ljava/util/List;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$filterDisplayableMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$toParsedHistoryMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/List;
    invoke-static v3, v6, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$mergeMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getRequest()Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;->getAfterLimit()I
    move-result v3
    invoke-virtual v2, v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreHistoryPage$conversation_mainlandRelease(I I)Z
    move-result v0
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setHasMoreNewerAnchorMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    goto +52h
    instance-of v0, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +05ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v2
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-object v4, v7
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object v4, v7
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v4
    invoke-virtual v0, v10, v2, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    const/16 v2, 401
    if-ne v0, v2, +016h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_forceLogout$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->label I
    invoke-interface v0, v2, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setLoadingNewerAnchorMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$onComplete Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setLoadingNewerAnchorMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadNewerAnchorMessages$2;->$onComplete Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    throw v0
    :try_start_0x15
    :try_start_0x22
    :try_start_0x2e
    :try_start_0x5c
    :try_start_0x147
.end method
