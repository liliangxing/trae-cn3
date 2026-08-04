# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 24
    # ins_size=2
    move-object/from16 v1, v22
    const-string v0, "refreshTasks error: code="
    const-string v2, "refreshTasks biz error: code="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    const-string v7, "TaskViewModel"
    const/4 v8, 0
    if-eqz v4, +01eh
    if-eq v4, v6, +013h
    if-ne v4, v5, +009h
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v23
    goto/16 +0d2h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v23
    goto +2bh
    move-exception v0
    goto/16 +198h
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v9, Lcom/bytedance/trae/im/service/IListConversationsService;->Companion Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    sget-object v4, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->getPageSize()I
    move-result v10
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    move-object/from16 v19, v1
    check-cast v19, Lkotlin/coroutines/Continuation;
    const/16 v20, 510
    const/16 v21, 0
    iput v6, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->label I
    invoke-static/range v9 ... v21, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->listConversationsRawCall$default(Lcom/bytedance/trae/im/service/IListConversationsService$Companion; I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v3, +003h
    return-object v3
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v6, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v9, ", msg="
    if-eqz v6, +0f7h
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-nez v0, +04fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v3, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v7, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLoadingTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isRefreshing$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v3
    invoke-static v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLastLoadTime$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; J)V
    return-object v0
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ListConversationsResponse;
    const/4 v2, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ListConversationsResponse;->getConversations()Ljava/util/List;
    move-result-object v0
    goto +2h
    move-object v0, v2
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1$processedResult$1;
    iget-object v9, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v6, v0, v9, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1$processedResult$1;-><init>(Ljava/util/List; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    iput v5, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->label I
    invoke-static v4, v6, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Lkotlin/Pair;
    if-eqz v0, +05bh
    invoke-virtual v0, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    invoke-virtual v0, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v3
    invoke-interface v3, Ljava/util/Map;->clear()V
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    iget-object v4, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +016h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, -010h
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v7
    invoke-interface v7, v6, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -19h
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_loadError$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$replaceAllConversations(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->startPollingIfNeeded()V
    goto +57h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "refreshTasks: processedResult is null, cli types not fully resolved"
    invoke-virtual v0, v7, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +4fh
    instance-of v2, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +06ah
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v2
    const/16 v3, 401
    if-ne v2, v3, +013h
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v2
    invoke-interface v2, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v2
    if-eqz v2, +007h
    sget-object v3, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-virtual v3, v2, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->performForceLogout(Landroid/app/Activity;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move-object v3, v4
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v3
    invoke-virtual v2, v7, v0, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLoadingTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isRefreshing$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    invoke-static v0, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLastLoadTime$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; J)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLoadingTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isRefreshing$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v3
    invoke-static v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$setLastLoadTime$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel; J)V
    throw v0
    :try_start_0x17
    :try_start_0x26
    :try_start_0x32
    :try_start_0x5e
    :try_start_0xb8
    :try_start_0x1bf
.end method
