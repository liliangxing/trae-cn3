# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $id:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.ConversationViewModel  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->$id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->$id Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->label I
    const/4 v2, 1
    packed-switch v1, +00000f3h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a9h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +08bh
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0d1h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/im/service/IDeleteConversationService;->Companion Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;
    new-instance v1, Lcom/bytedance/trae/im/service/DeleteConversationRequest;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->$id Ljava/lang/String;
    invoke-direct v1, v3, Lcom/bytedance/trae/im/service/DeleteConversationRequest;-><init>(Ljava/lang/String;)V
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->label I
    invoke-virtual v8, v1, v3, Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;->deleteConversationRawCall(Lcom/bytedance/trae/im/service/DeleteConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +092h
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    const-wide/32 v5, 2900101
    cmp-long v8, v3, v5
    if-nez v8, +01bh
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v7
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 2
    iput v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->label I
    invoke-interface v8, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +086h
    return-object v0
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +01fh
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1$1;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-direct v2, v3, v8, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    move-object v8, v7
    check-cast v8, Lkotlin/coroutines/Continuation;
    const/4 v3, 3
    iput v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->label I
    invoke-static v1, v2, v8, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_delete_success I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v7
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 4
    iput v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->label I
    invoke-interface v8, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_deleteSuccess$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v8
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v2, v7
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 5
    iput v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->label I
    invoke-interface v8, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +020h
    return-object v0
    instance-of v8, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v8, +01eh
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_delete_failed I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v7
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 6
    iput v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$deleteConversation$1;->label I
    invoke-interface v8, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    nop 
    packed-switch-payload 0 1 2 3 4 5 6
.end method
