# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->label I
    if-nez v0, +030h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +00dh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getCacheRepository(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$streamingMessageListener$1$3;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->cacheParsedMessage(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
