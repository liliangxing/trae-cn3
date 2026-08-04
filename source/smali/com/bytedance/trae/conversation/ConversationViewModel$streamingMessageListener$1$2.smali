# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isDone:Z
.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage  boolean  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->$isDone Z
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->$isDone Z
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3eh
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-static v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$upsertMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-boolean v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->$isDone Z
    if-eqz v5, +011h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    invoke-static v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$updateUpgradeReminder(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_newMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v5
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$2;->label I
    invoke-interface v5, v1, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method
