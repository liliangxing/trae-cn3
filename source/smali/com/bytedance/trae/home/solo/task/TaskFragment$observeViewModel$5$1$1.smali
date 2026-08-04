# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic Z$0:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    iput-boolean v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->Z$0 Z
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->invoke(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->label I
    if-nez v0, +015h
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->Z$0 Z
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getSwipeRefresh$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setRefreshing(Z)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
