# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->label I
    const/4 v2, 1
    if-eqz v1, +011h
    if-ne v1, v2, +007h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    goto +1fh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v6
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getPollingIntervalMs$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)J
    move-result-wide v3
    move-object v1, v7
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->label I
    invoke-static v3, v4, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    instance-of v3, v1, Ljava/util/Collection;
    const/4 v4, 0
    if-eqz v3, +00ch
    move-object v3, v1
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    goto +23h
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getDisplayState()Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    if-ne v3, v5, +004h
    move v3, v2
    goto +2h
    move v3, v4
    if-eqz v3, -01bh
    move v4, v2
    if-eqz v4, +008h
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->forceLoadTasks()V
    goto -56h
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
