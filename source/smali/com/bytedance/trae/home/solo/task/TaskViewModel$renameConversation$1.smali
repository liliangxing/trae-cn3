# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $newTitle:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$conversationId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$conversationId Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 35
    # ins_size=2
    move-object/from16 v0, v33
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->label I
    const/4 v3, 4
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v2, +027h
    if-eq v2, v6, +01fh
    if-eq v2, v5, +018h
    if-eq v2, v4, +00dh
    if-ne v2, v3, +003h
    goto +12h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07ch
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +23ah
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v34
    goto +1bh
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IRenameConversationService;->Companion Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;
    new-instance v7, Lcom/bytedance/trae/im/service/RenameConversationRequest;
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$conversationId Ljava/lang/String;
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/im/service/RenameConversationRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v8, v0
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v6, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->label I
    invoke-virtual v2, v7, v8, Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;->renameConversationRawCall(Lcom/bytedance/trae/im/service/RenameConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v6, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v7, "TaskViewModel"
    if-eqz v6, +1c9h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v8
    const-wide/32 v10, 2900101
    cmp-long v3, v8, v10
    if-nez v3, +01ah
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v3
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v5, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +1e9h
    return-object v1
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string/jumbo v5, renameConversation success
    invoke-virtual v3, v7, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_toast_rename_success I
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v5
    move-object v6, v0
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->label I
    invoke-interface v3, v5, v6, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/RenameConversationResponse;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/RenameConversationResponse;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    const/16 v2, 10
    if-eqz v1, +086h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +013h
    sget-object v3, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00bh
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v4
    invoke-interface v4, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    invoke-static v3, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$persistConversations(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)V
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$toTaskModel(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v1
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$conversationId Ljava/lang/String;
    new-instance v6, Ljava/util/ArrayList;
    invoke-static v4, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v6, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +017h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    move-object v4, v1
    invoke-interface v6, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v6, Ljava/util/List;
    invoke-interface v3, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto/16 +129h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v1
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$conversationId Ljava/lang/String;
    invoke-interface v1, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v3, +048h
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$conversationId Ljava/lang/String;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object v2, v15
    move-object/from16 v15, v16
    const/16 v17, 0
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
    const v30, 67108799
    const/16 v31, 0
    invoke-static/range v3 ... v31, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v3
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v4
    invoke-interface v4, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$persistConversations(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$conversationId Ljava/lang/String;
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->$newTitle Ljava/lang/String;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v2, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +054h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object/from16 v29, v5
    check-cast v29, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual/range v29, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +036h
    const/4 v5, 0
    const/4 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const v27, 4194299
    const/16 v28, 0
    move-object/from16 v32, v4
    move-object/from16 v4, v29
    move-object/from16 v30, v7
    invoke-static/range v4 ... v28, Lcom/bytedance/trae/home/solo/task/TaskModel;->copy$default(Lcom/bytedance/trae/home/solo/task/TaskModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v29
    move-object/from16 v4, v29
    move-object/from16 v5, v32
    goto +6h
    move-object/from16 v30, v7
    move-object v5, v4
    move-object/from16 v4, v29
    invoke-interface v5, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object v4, v5
    move-object/from16 v7, v30
    goto -57h
    move-object v5, v4
    move-object v4, v5
    check-cast v4, Ljava/util/List;
    invoke-interface v1, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +4ah
    instance-of v4, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v4, +04ah
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, renameConversation error: code=
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", msg="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v2
    invoke-virtual v4, v7, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/home/R$string;->solo_toast_rename_failed I
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v4
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;->label I
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
