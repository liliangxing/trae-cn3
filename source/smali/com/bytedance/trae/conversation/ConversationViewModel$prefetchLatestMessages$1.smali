# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->$conversationId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +26h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->$conversationId Ljava/lang/String;
    const/4 v3, 0
    const/16 v4, 10
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    move-object v8, v11
    check-cast v8, Lkotlin/coroutines/Continuation;
    const/16 v9, 32
    const/4 v10, 0
    iput v2, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->label I
    move-object v2, v12
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    check-cast v12, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +052h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-nez v1, +003h
    goto +44h
    iget-object v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->getMessages()Ljava/util/List;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$filterDisplayableMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    iget-object v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    iget-object v5, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$prefetchLatestMessages$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$toParsedHistoryMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    invoke-static v3, v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$mergeMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    invoke-virtual v12, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->getRequest()Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;->getBeforeLimit()I
    move-result v12
    invoke-direct v2, v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;-><init>(Ljava/util/List; I)V
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setLatestPrefetchMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
.end method
