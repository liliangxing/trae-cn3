# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $filtered:Ljava/util/List;
.field final synthetic $tasks:Ljava/util/List;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(java.util.List  com.bytedance.trae.home.solo.task.TaskViewModel  java.util.List  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->$filtered Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->$tasks Ljava/util/List;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->$filtered Ljava/util/List;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->$tasks Ljava/util/List;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;-><init>(Ljava/util/List; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->label I
    if-nez v0, +057h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->$filtered Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, -010h
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationMap$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Ljava/util/Map;
    move-result-object v3
    invoke-interface v3, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -19h
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +01bh
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_allTasks$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->$tasks Ljava/util/List;
    invoke-interface v5, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_contentReady$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    const/4 v0, 1
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v5, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
