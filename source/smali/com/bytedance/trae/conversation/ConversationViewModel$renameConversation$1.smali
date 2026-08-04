# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $id:Ljava/lang/String;
.field final synthetic $newTitle:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.ConversationViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->$id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->$id Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 36
    # ins_size=2
    move-object/from16 v0, v34
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->label I
    const/4 v3, 5
    const/4 v4, 4
    const/4 v5, 3
    const/4 v6, 2
    const/4 v7, 1
    if-eqz v2, +028h
    if-eq v2, v7, +020h
    if-eq v2, v6, +019h
    if-eq v2, v5, +00fh
    if-eq v2, v4, +015h
    if-ne v2, v3, +003h
    goto +11h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static/range v35, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +70h
    invoke-static/range v35, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +116h
    invoke-static/range v35, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v35
    goto +1bh
    invoke-static/range v35, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IRenameConversationService;->Companion Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;
    new-instance v8, Lcom/bytedance/trae/im/service/RenameConversationRequest;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->$id Ljava/lang/String;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    invoke-direct v8, v9, v10, Lcom/bytedance/trae/im/service/RenameConversationRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v9, v0
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->label I
    invoke-virtual v2, v8, v9, Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;->renameConversationRawCall(Lcom/bytedance/trae/im/service/RenameConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v7, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v7, +0d4h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    const-wide/32 v9, 2900101
    cmp-long v3, v7, v9
    if-nez v3, +01ah
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v3
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +0c7h
    return-object v1
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_rename_success I
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    move-object v7, v0
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->label I
    invoke-interface v3, v6, v7, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/RenameConversationResponse;
    const/4 v3, 0
    if-eqz v2, +06ah
    invoke-virtual v2, Lcom/bytedance/trae/im/service/RenameConversationResponse;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v5
    if-eqz v5, +064h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v6, +009h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v6
    move-object/from16 v17, v6
    goto +3h
    move-object/from16 v17, v3
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v15
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const v32, 67106303
    const/16 v33, 0
    move-object v4, v15
    move-object v15, v2
    invoke-static/range v5 ... v33, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    invoke-interface v4, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_renameSuccess$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->L$0 Ljava/lang/Object;
    const/4 v3, 4
    iput v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->label I
    invoke-interface v2, v4, v5, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +01fh
    return-object v1
    instance-of v2, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +01dh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_toast_rename_failed I
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v4
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$renameConversation$1;->label I
    invoke-interface v2, v4, v5, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
