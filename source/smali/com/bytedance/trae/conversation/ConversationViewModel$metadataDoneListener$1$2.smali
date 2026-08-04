# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $replyToMessageId:Ljava/lang/String;
.field final synthetic $userMessage:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$replyToMessageId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$userMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$replyToMessageId Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$userMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$conversationId Ljava/lang/String;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +018h
    if-eq v1, v3, +011h
    if-ne v1, v2, +007h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0aah
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07dh
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getRemoteUserMessageIds$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Ljava/util/Set;
    move-result-object v8
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$replyToMessageId Ljava/lang/String;
    invoke-interface v8, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$replyToMessageId Ljava/lang/String;
    instance-of v4, v8, Ljava/util/Collection;
    const/4 v5, 0
    if-eqz v4, +00ch
    move-object v4, v8
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +1ch
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +013h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -014h
    move v5, v3
    if-eqz v5, +005h
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getRemoteUserMessageIds$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Ljava/util/Set;
    move-result-object v8
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$replyToMessageId Ljava/lang/String;
    invoke-interface v8, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$userMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-static v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$upsertMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_remoteUserMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v8
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$userMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v4, v7
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->label I
    invoke-interface v8, v1, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v8
    check-cast v8, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2$2;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$conversationId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->$userMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v6, 0
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$metadataDoneListener$1$2;->label I
    invoke-static v8, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
