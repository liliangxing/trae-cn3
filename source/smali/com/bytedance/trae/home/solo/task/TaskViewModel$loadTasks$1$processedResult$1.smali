# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversations:Ljava/util/List;
.field final synthetic $deleteIdsSnapshot:Ljava/util/Set;
.field  I$0:I
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(java.util.List  java.util.Set  com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$conversations Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$deleteIdsSnapshot Ljava/util/Set;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$conversations Ljava/util/List;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$deleteIdsSnapshot Ljava/util/Set;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;-><init>(Ljava/util/List; Ljava/util/Set; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +017h
    if-ne v1, v3, +00dh
    iget v0, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->I$0 I
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +088h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$conversations Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    instance-of v4, v8, Ljava/util/Collection;
    if-eqz v4, +00dh
    move-object v4, v8
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v8, v2
    goto +50h
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v3
    if-nez v6, +028h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +018h
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, +004h
    move v4, v3
    goto +2h
    move v4, v2
    if-eqz v4, -048h
    move v8, v3
    if-eqz v8, +07eh
    move-object v8, v7
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->L$0 Ljava/lang/Object;
    iput v3, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->I$0 I
    iput v3, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->label I
    invoke-virtual v1, v8, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClisResult(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    move v0, v3
    check-cast v8, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess()Z
    move-result v8
    if-eqz v8, +066h
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$conversations Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    instance-of v0, v8, Ljava/util/Collection;
    if-eqz v0, +00ch
    move-object v0, v8
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +52h
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +049h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v2
    goto +2h
    move v5, v3
    if-nez v5, +029h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +019h
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v3
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v3
    if-nez v0, -049h
    move v0, v2
    goto +2h
    move v0, v3
    if-nez v0, +004h
    const/4 v8, 0
    return-object v8
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$conversations Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +024h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, -01ah
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    goto -27h
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$conversations Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$deleteIdsSnapshot Ljava/util/Set;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01eh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +00ah
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-ne v5, v3, +004h
    move v5, v3
    goto +2h
    move v5, v2
    if-nez v5, -01ch
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -21h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/HashSet;
    invoke-direct v8, Ljava/util/HashSet;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v8, v3, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -015h
    invoke-virtual v0, v2, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Conversation;
    invoke-static v8, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$toTaskModel(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v8, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$sortTasks(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v8
    new-instance v0, Lkotlin/Pair;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$processedResult$1;->$conversations Ljava/util/List;
    invoke-direct v0, v1, v8, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
.end method
