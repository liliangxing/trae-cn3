# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(java.lang.String  com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->$conversationId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->$conversationId Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->label I
    const/4 v2, 4
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v1, +020h
    if-eq v1, v5, +01ah
    if-eq v1, v4, +013h
    if-eq v1, v3, +00dh
    if-ne v1, v2, +003h
    goto +dh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +72h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +123h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/im/service/IDeleteConversationService;->Companion Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;
    new-instance v1, Lcom/bytedance/trae/im/service/DeleteConversationRequest;
    iget-object v6, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->$conversationId Ljava/lang/String;
    invoke-direct v1, v6, Lcom/bytedance/trae/im/service/DeleteConversationRequest;-><init>(Ljava/lang/String;)V
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v5, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->label I
    invoke-virtual v10, v1, v6, Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;->deleteConversationRawCall(Lcom/bytedance/trae/im/service/DeleteConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v6, "TaskViewModel"
    if-eqz v1, +0b7h
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v1
    const-wide/32 v7, 2900101
    cmp-long v10, v1, v7
    if-nez v10, +01ah
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v10
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v9
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v4, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->label I
    invoke-interface v10, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +0d7h
    return-object v0
    sget-object v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "deleteConversation success"
    invoke-virtual v10, v6, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v10
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_delete_success I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v9
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v3, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->label I
    invoke-interface v10, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v10
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->$conversationId Ljava/lang/String;
    invoke-interface v10, v0, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v10
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->$conversationId Ljava/lang/String;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    xor-int/2addr v4, v5
    if-eqz v4, -016h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v2, Ljava/util/List;
    invoke-interface v10, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    check-cast v10, Landroidx/lifecycle/ViewModel;
    invoke-static v10, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v10
    move-object v1, v10
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    const/4 v2, 0
    new-instance v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1$2;
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-object v4, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->$conversationId Ljava/lang/String;
    const/4 v5, 0
    invoke-direct v10, v3, v4, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1$2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v3, v10
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 2
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +49h
    instance-of v1, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +049h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "deleteConversation error: code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", msg="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v10
    invoke-virtual v1, v6, v3, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v10
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_delete_failed I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v3, v9
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;->label I
    invoke-interface v10, v1, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
.end method
