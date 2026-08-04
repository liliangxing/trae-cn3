# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->$conversationId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v2, +024h
    if-eq v2, v5, +01ch
    if-eq v2, v4, +011h
    if-ne v2, v3, +007h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1a5h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->L$0 Ljava/lang/Object;
    check-cast v2, Ljava/util/List;
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +143h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v18
    goto +1eh
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->$conversationId Ljava/lang/String;
    const/4 v9, 0
    const/16 v10, 10
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    move-object v14, v0
    check-cast v14, Lkotlin/coroutines/Continuation;
    const/16 v15, 32
    const/16 v16, 0
    iput v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->label I
    invoke-static/range v7 ... v16, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v2
    instance-of v5, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v5, +135h
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;->getMessages()Ljava/util/List;
    move-result-object v2
    goto +2h
    move-object v2, v6
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v5, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$filterDisplayableMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "[Node3] refreshMessagesOnResume: API success, count="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v8, "AgentDataFlow"
    invoke-virtual v5, v8, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v5, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$toParsedHistoryMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    move-object v7, v5
    check-cast v7, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +013h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v10
    if-eqz v10, -011h
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v8, Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->$conversationId Ljava/lang/String;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +012h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    sget-object v10, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v10, v7, v9, Lcom/bytedance/trae/im/service/IMService;->cancelThoughtByMessageId(Ljava/lang/String; Ljava/lang/String;)V
    goto -15h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/util/List;
    invoke-static v7, v8, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$mergeMessagesIntoState(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    invoke-static v5, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v5, +06bh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v7
    if-eqz v7, +065h
    const-string v7, "completed"
    const-string v8, "failed"
    const-string v9, "canceled"
    filled-new-array v7, v8, v9, [Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v10
    invoke-static v7, v10, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +04bh
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v10, 0
    invoke-virtual v7, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_sessionTurnStatus$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    sget-object v10, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STREAMING Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    if-ne v7, v10, +021h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_sessionTurnStatus$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +00ch
    invoke-static v5, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +4h
    sget-object v5, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->FINISHED Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    goto +3h
    sget-object v5, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STOPPED Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    invoke-interface v7, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_taskDone$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v5
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v8, v0
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->label I
    invoke-interface v5, v7, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v1, +003h
    return-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v5, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1$3;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->$conversationId Ljava/lang/String;
    invoke-direct v5, v7, v8, v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1$3;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$refreshMessagesOnResume$1;->label I
    invoke-static v4, v5, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +035h
    return-object v1
    instance-of v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +033h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "refreshMessagesOnResume: API error, code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", msg="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v2
    const-string v4, "ConversationViewModel"
    invoke-virtual v1, v4, v3, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
