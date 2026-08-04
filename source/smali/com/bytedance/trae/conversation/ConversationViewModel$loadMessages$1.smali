# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 35
    # ins_size=2
    move-object/from16 v1, v33
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    const-string v3, "loadMessages: fetchEventsIfNeeded error, conversationId="
    const-string v4, "completed"
    const-string v5, "interrupted"
    const/4 v6, 0
    const/4 v7, 1
    const-string v8, "ConversationViewModel"
    const/4 v9, 0
    packed-switch v0, +00006a5h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$2 Ljava/lang/Object;
    check-cast v0, Ljava/util/List;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/util/List;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v12, v0
    move-object/from16 v0, v34
    goto/16 +38dh
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +675h
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v34
    goto +75h
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v34
    goto +21h
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v10, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1$cachedMessages$1;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    invoke-direct v10, v11, v12, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1$cachedMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    move-object v11, v1
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    invoke-static v0, v10, v11, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Ljava/util/List;
    move-object v10, v0
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    xor-int/2addr v10, v7
    if-eqz v10, +026h
    sget-object v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "loadMessages: cache hit, count="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v8, v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string v11, "cache"
    invoke-static v10, v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$handleModelUnavailableLoadedMessagesIfNeeded(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/lang/String;)V
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$replaceMessagesPreservingRuntime(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    const/4 v13, 0
    const/16 v14, 10
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    move-object/from16 v18, v1
    check-cast v18, Lkotlin/coroutines/Continuation;
    const/16 v19, 32
    const/16 v20, 0
    const/4 v0, 2
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    invoke-static/range v11 ... v20, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v11, v0
    check-cast v11, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    instance-of v10, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v12, "getString(...)"
    const-string v13, ", msg="
    if-eqz v10, +558h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v10
    if-nez v10, +06fh
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "loadMessages biz error: code="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v8, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +00fh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_loadError$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/4 v5, 3
    iput v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    invoke-interface v0, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +574h
    return-object v2
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_loadError$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v10
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v12
    invoke-interface v10, v12, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->getMessages()Ljava/util/List;
    move-result-object v0
    goto +2h
    move-object v0, v9
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$filterDisplayableMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v10
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-eqz v0, +038h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v13, "loadMessages: API success, raw messages count="
    invoke-direct v12, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v8, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v13, "loadMessages: rawMessages json="
    invoke-direct v12, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->getGson()Lcom/google/gson/Gson;
    move-result-object v13
    invoke-virtual v13, v10, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v8, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$toParsedHistoryMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v12
    move-object v0, v12
    check-cast v0, Ljava/lang/Iterable;
    new-instance v13, Ljava/util/ArrayList;
    invoke-direct v13, Ljava/util/ArrayList;-><init>()V
    check-cast v13, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v15
    if-eqz v15, +014h
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v15
    move-object/from16 v16, v15
    check-cast v16, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual/range v16, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v16
    if-eqz v16, -012h
    invoke-interface v13, v15, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v13, Ljava/util/List;
    check-cast v13, Ljava/lang/Iterable;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v16
    const-string v9, "AgentClean"
    if-eqz v16, +050h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v16
    check-cast v16, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v18
    invoke-interface/range v18, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v18
    check-cast v18, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v18, +009h
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v18
    move-object/from16 v6, v18
    goto +2h
    const/4 v6, 0
    if-eqz v6, +028h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    move-object/from16 v20, v14
    new-instance v14, Ljava/lang/StringBuilder;
    move-object/from16 v34, v15
    const-string v15, "assistant_message:"
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v7, v9, v14, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual/range v16, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, v6, v9, Lcom/bytedance/trae/im/service/IMService;->cancelThoughtByMessageId(Ljava/lang/String; Ljava/lang/String;)V
    goto +5h
    move-object/from16 v20, v14
    move-object/from16 v34, v15
    move-object/from16 v15, v34
    move-object/from16 v14, v20
    const/4 v6, 0
    const/4 v7, 1
    const/4 v9, 0
    goto -55h
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +029h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    move-object v14, v13
    check-cast v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v14
    if-eqz v14, +007h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v14
    goto +2h
    const/4 v14, 0
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +00bh
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    goto +3h
    const/4 v14, 0
    goto +2h
    const/4 v14, 1
    if-eqz v14, -027h
    invoke-interface v6, v13, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ch
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +041h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +02ah
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v15
    if-eqz v15, +01ah
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v15
    move-object/from16 v16, v15
    check-cast v16, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object/from16 v34, v0
    invoke-virtual/range v16, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +7h
    move-object/from16 v0, v34
    goto -1dh
    move-object/from16 v34, v0
    const/4 v15, 0
    check-cast v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    goto +4h
    move-object/from16 v34, v0
    const/4 v15, 0
    if-eqz v15, +005h
    invoke-interface v7, v15, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v0, v34
    goto -44h
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    invoke-static v7, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +057h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v13
    if-eqz v13, +046h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v13
    invoke-interface v13, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v13
    goto +2h
    const/4 v13, 0
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v14
    const-string v15, "in_progress"
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-nez v14, +028h
    if-eqz v13, +026h
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    move-object/from16 v34, v0
    const-string v0, "cancelThoughtByMessageId:"
    invoke-direct v15, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v15, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v14, v9, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v13, v7, Lcom/bytedance/trae/im/service/IMService;->cancelThoughtByMessageId(Ljava/lang/String; Ljava/lang/String;)V
    goto +3h
    move-object/from16 v34, v0
    move-object/from16 v0, v34
    goto -5ah
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isInited$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v0
    if-nez v0, +1c8h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v6, 1
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setInited$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->getLatestUnpairedUserMessage(Ljava/util/List;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRole()Ljava/lang/String;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    const-string/jumbo v7, user
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +1abh
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    if-eqz v6, +195h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v6
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskUpdateTime()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Ljava/time/OffsetDateTime;->parse(Ljava/lang/CharSequence;)Ljava/time/OffsetDateTime;
    move-result-object v0
    invoke-virtual v0, Ljava/time/OffsetDateTime;->toInstant()Ljava/time/Instant;
    move-result-object v0
    invoke-virtual v0, Ljava/time/Instant;->toEpochMilli()J
    move-result-wide v13
    goto +3h
    const-wide/16 v13, 0
    cmp-long v0, v6, v13
    if-lez v0, +0ceh
    sget-object v20, Lcom/bytedance/trae/im/service/IListConversationsService;->Companion Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    sget-object v0, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->getPageSize()I
    move-result v21
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    move-object/from16 v30, v1
    check-cast v30, Lkotlin/coroutines/Continuation;
    const/16 v31, 510
    const/16 v32, 0
    iput-object v11, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$2 Ljava/lang/Object;
    const/4 v0, 4
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    invoke-static/range v20 ... v32, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->listConversationsRawCall$default(Lcom/bytedance/trae/im/service/IListConversationsService$Companion; I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v6, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v6, +132h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v6
    if-eqz v6, +126h
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ListConversationsResponse;
    if-eqz v0, +02ch
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ListConversationsResponse;->getConversations()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +026h
    check-cast v0, Ljava/lang/Iterable;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v9, v7
    check-cast v9, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, -015h
    goto +2h
    const/4 v7, 0
    check-cast v7, Lcom/bytedance/trae/im/service/Conversation;
    goto +2h
    const/4 v7, 0
    if-eqz v7, +0edh
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +0e7h
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskStatus()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +0ddh
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskStatus()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +0d3h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->fetchEventsIfNeeded(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +0c3h
    move-exception v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ", taskId="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v4, v8, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto/16 +09ch
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskStatus()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +082h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskStatus()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +068h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v5, +008h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +019h
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->fetchEventsIfNeeded(Ljava/lang/String; Ljava/lang/String;)V
    goto +36h
    move-exception v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ",taskId="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v4, v8, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "loadMessages: parsed messages count="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v8, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node3] loadMessages: rawCount="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", parsedCount="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "AgentDataFlow"
    invoke-virtual v0, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v12
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +05fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v5
    if-eqz v5, -010h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v5
    if-eqz v5, +00dh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +007h
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    goto +2h
    const/4 v5, 0
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "[Node3] loadMessages agent: msgId="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", status="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", planItemCount="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, ", agentType="
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v6, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto -62h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$replaceMessagesPreservingRuntime(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/List;
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$updateUpgradeReminder(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string v3, "network"
    invoke-static v0, v12, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$handleModelUnavailableLoadedMessagesIfNeeded(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/lang/String;)V
    move-object v0, v10
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    const/4 v3, 1
    xor-int/2addr v0, v3
    if-eqz v0, +022h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_hasMoreMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v11, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getRequest()Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;->getBeforeLimit()I
    move-result v5
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->hasMoreHistoryPage$conversation_mainlandRelease(I I)Z
    move-result v3
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +fh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_hasMoreMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    const/4 v3, 0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1$6;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->$conversationId Ljava/lang/String;
    const/4 v6, 0
    invoke-direct v3, v4, v5, v10, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1$6;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$1 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->L$2 Ljava/lang/Object;
    const/4 v5, 5
    iput v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    invoke-static v0, v3, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +097h
    return-object v2
    instance-of v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +09ah
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    const/16 v4, 401
    if-ne v3, v4, +01eh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v3, "loadMessages: logout"
    invoke-virtual v0, v8, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_forceLogout$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/4 v5, 6
    iput v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    invoke-interface v0, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +06dh
    return-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "loadMessages: API error, code="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v0
    invoke-virtual v3, v8, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +010h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_loadError$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    const/4 v3, 1
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/4 v5, 7
    iput v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->label I
    invoke-interface v0, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$recoverStreamingMessages(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    packed-switch-payload 0 1 2 3 4 5 6 7
    :try_start_0x364
    :try_start_0x422
    :try_start_0x459
.end method
