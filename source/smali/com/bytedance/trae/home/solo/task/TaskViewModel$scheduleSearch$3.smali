# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/String;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->invoke(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->label I
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v2, +023h
    if-eq v2, v6, +017h
    if-ne v2, v3, +00dh
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v3, v19
    goto/16 +0e3h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v3, v19
    goto +51h
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->L$0 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchQuery$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isSearchMode$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Boolean;
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    if-eqz v8, +24eh
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +004h
    goto/16 +246h
    sget-object v7, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-virtual v7, Lcom/bytedance/trae/network/NetworkMonitor;->isNetworkAvailable()Z
    move-result v7
    if-nez v7, +060h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->L$0 Ljava/lang/Object;
    iput v6, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->label I
    invoke-static v3, v2, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$searchLocalTasks(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    move-object v1, v2
    check-cast v3, Ljava/util/List;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isSearchMode$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-eqz v2, +038h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchQuery$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +1ah
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchResults$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isSearchLoading$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isSearchLoading$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-interface v7, v8, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchResults$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    invoke-interface v7, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/im/service/IListConversationsService;->Companion Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const-wide/16 v13, 0
    move-object v15, v0
    check-cast v15, Lkotlin/coroutines/Continuation;
    const/16 v16, 6
    const/16 v17, 0
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->label I
    move-object v8, v2
    invoke-static/range v7 ... v17, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->searchRawCall$default(Lcom/bytedance/trae/im/service/IListConversationsService$Companion; Ljava/lang/String; I I J J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    move-object v1, v2
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isSearchMode$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-eqz v2, +197h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchQuery$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +179h
    instance-of v2, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v7, ", msg="
    const-string v8, "TaskViewModel"
    if-eqz v2, +11fh
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-eqz v2, +0d8h
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/SearchConversationsResponse;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/SearchConversationsResponse;->getItems()Ljava/util/List;
    move-result-object v2
    goto +2h
    move-object v2, v4
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/SearchConversationsResponse;
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/SearchConversationsResponse;->getHighlightKeywords()Ljava/util/List;
    move-result-object v4
    if-nez v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchResults$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    check-cast v2, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +037h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Lcom/bytedance/trae/im/service/SearchConversationItem;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/SearchConversationItem;->getCliId()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +003h
    goto +3h
    move v10, v5
    goto +2h
    move v10, v6
    if-nez v10, +015h
    sget-object v10, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v10
    invoke-virtual v9, Lcom/bytedance/trae/im/service/SearchConversationItem;->getCliId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +003h
    goto +3h
    move v9, v5
    goto +2h
    move v9, v6
    if-eqz v9, -035h
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ah
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +012h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/im/service/SearchConversationItem;
    invoke-static v2, v8, v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$toTaskModel(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/SearchConversationItem; Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v8
    if-eqz v8, -010h
    invoke-interface v6, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/HashSet;
    invoke-direct v1, Ljava/util/HashSet;-><init>()V
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +017h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v7, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -015h
    invoke-virtual v2, v6, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v2, Ljava/util/List;
    invoke-interface v3, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +78h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v4, searchConversations biz error: code=
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v8, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchResults$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +3dh
    instance-of v1, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +04ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v4, searchConversations error: code=
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v3
    invoke-virtual v1, v8, v2, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_searchResults$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_isSearchLoading$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
