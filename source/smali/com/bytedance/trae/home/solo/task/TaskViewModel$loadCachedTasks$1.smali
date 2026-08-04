# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->label I
    const/4 v2, 1
    if-eqz v1, +011h
    if-ne v1, v2, +007h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +11ch
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/CoroutineScope;
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationDao$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lcom/bytedance/trae/im/database/ConversationDao;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/im/database/ConversationDao;->queryAll()Ljava/util/List;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-nez v1, +003h
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/util/List;
    move-object v1, v8
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +0dah
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +0c8h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "loadCachedTasks: loaded "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v8, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, " conversations from DB"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "TaskViewModel"
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v8, Ljava/lang/Iterable;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +013h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    invoke-static v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$isConversationDisplayable(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/Conversation;)Z
    move-result v5
    if-eqz v5, -011h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v3, Ljava/util/List;
    move-object v8, v3
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, -01ah
    sget-object v5, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    goto -2dh
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v8, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +010h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    invoke-static v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$toTaskModel(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v4, Ljava/util/List;
    invoke-static v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$sortTasks(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;
    iget-object v5, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v6, 0
    invoke-direct v4, v3, v5, v8, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;-><init>(Ljava/util/List; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v8, v7
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;->label I
    invoke-static v1, v4, v8, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    :try_start_0x21
.end method
