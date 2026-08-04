# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method public static synthetic $r8$lambda$IV_c6xo4L4Z5WV_gyJBWn8WaeLM(kotlin.jvm.functions.Function1  java.lang.Object)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->invokeSuspend$lambda$4(Lkotlin/jvm/functions/Function1; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$rxObfrh1oeIs3ZXxEFqTj2db1cs(java.util.Set  java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->invokeSuspend$lambda$3(Ljava/util/Set; Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$3(java.util.Set  java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    return v0
.end method

.method private static final invokeSuspend$lambda$4(kotlin.jvm.functions.Function1  java.lang.Object)boolean
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 30
    # ins_size=2
    move-object/from16 v1, v28
    const-string v0, "loadTasks conversations count: "
    const-string v2, "loadTasks error: code="
    const-string v3, "loadTasks biz error: code="
    const-string v4, "loadTasks success, code="
    const-string v5, "loadTasks result: "
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    iget v7, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->label I
    const-string v8, "access$getPendingDeleteIds$p(...)"
    const/4 v9, 2
    const-wide/16 v10, 0
    const-string v12, "TaskViewModel"
    const/4 v13, 0
    const/4 v14, 1
    if-eqz v7, +01eh
    if-eq v7, v14, +013h
    if-ne v7, v9, +009h
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v29
    goto/16 +181h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v7, v29
    goto +30h
    move-exception v0
    goto/16 +3f0h
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v15, Lcom/bytedance/trae/im/service/IListConversationsService;->Companion Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    sget-object v7, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->getPageSize()I
    move-result v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    move-object/from16 v25, v1
    check-cast v25, Lkotlin/coroutines/Continuation;
    const/16 v26, 510
    const/16 v27, 0
    iput v14, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->label I
    invoke-static/range v15 ... v27, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->listConversationsRawCall$default(Lcom/bytedance/trae/im/service/IListConversationsService$Companion; I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v6, +003h
    return-object v6
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    sget-object v15, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v15, v12, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    instance-of v5, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v9, ", msg="
    if-eqz v5, +309h
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-nez v2, +07ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v3, v7
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v12, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +00fh
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_loadError$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v13, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLoadingTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_contentReady$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getPendingReload$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Z
    move-result v2
    if-eqz v2, +011h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v13, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setPendingReload$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v10, v11, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLastLoadTime$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; J)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    return-object v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v4, v7
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v4, v7
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", data="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v4, v7
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v12, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/ListConversationsResponse;
    const/4 v3, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ListConversationsResponse;->getConversations()Ljava/util/List;
    move-result-object v2
    goto +2h
    move-object v2, v3
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v12, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getPendingDeleteIds$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Set;
    move-result-object v0
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;
    iget-object v7, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v5, v2, v0, v7, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;-><init>(Ljava/util/List; Ljava/util/Set; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    const/4 v2, 2
    iput v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->label I
    invoke-static v4, v5, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v6, +003h
    return-object v6
    check-cast v0, Lkotlin/Pair;
    if-eqz v0, +1b8h
    invoke-virtual v0, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    invoke-virtual v0, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v3
    invoke-interface v3, Ljava/util/Map;->clear()V
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    iget-object v4, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const-string v6, ", status="
    const-string v7, ", title="
    if-eqz v5, +085h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +009h
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v15
    invoke-interface v15, v9, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v15, Ljava/lang/StringBuilder;
    invoke-direct v15, Ljava/lang/StringBuilder;-><init>()V
    const-string v10, "loadTasks conv: id="
    invoke-virtual v15, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getStatus()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", environment="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", cliId="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", workspace="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getWorkspace()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", gitUri="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getGitUri()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v9, v12, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-wide/16 v10, 0
    goto/16 -08bh
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +012h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, -010h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v3
    iget-object v4, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getPendingDeleteIds$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Set;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda0;
    invoke-direct v5, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda0;-><init>(Ljava/util/Set;)V
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda1;
    invoke-direct v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v4, v3, Ljava/util/Set;->removeIf(Ljava/util/function/Predicate;)Z
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getPendingDeleteIds$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Set;
    move-result-object v3
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Iterable;
    iget-object v4, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v8
    invoke-interface v8, v5, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto -13h
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +061h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/task/TaskModel;
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    const-string v8, "loadTasks task: id="
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/task/TaskStatus;->name()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v8, 40
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getStatusCode()I
    move-result v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v8, "), isLocal="
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal()Z
    move-result v3
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v12, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto -64h
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$replaceAllConversations(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_loadError$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v13, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$isFirstLoadCompleted$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Z
    move-result v0
    if-nez v0, +030h
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setFirstLoadCompleted$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$reportFirstLoadEvent(Lcom/bytedance/trae/home/solo/task/TaskViewModel; I)V
    goto +20h
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +00fh
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_loadError$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->startPollingIfNeeded()V
    goto +6eh
    instance-of v0, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +099h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    const/16 v3, 401
    if-ne v0, v3, +013h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v3, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->performForceLogout(Landroid/app/Activity;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-object v3, v7
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v3
    invoke-virtual v0, v12, v2, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +00fh
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_loadError$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v13, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLoadingTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_contentReady$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getPendingReload$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Z
    move-result v0
    if-eqz v0, +013h
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v13, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setPendingReload$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const-wide/16 v2, 0
    invoke-static v0, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLastLoadTime$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; J)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v13, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLoadingTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_contentReady$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getPendingReload$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Z
    move-result v2
    if-eqz v2, +013h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v13, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setPendingReload$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const-wide/16 v3, 0
    invoke-static v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLastLoadTime$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; J)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    throw v0
    :try_start_0x21
    :try_start_0x30
    :try_start_0x3c
    :try_start_0x7f
    :try_start_0x106
    :try_start_0x1d3
    :try_start_0x421
.end method
