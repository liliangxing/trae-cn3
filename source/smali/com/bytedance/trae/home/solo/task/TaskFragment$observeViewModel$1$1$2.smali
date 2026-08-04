# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function3;

.field synthetic L$0:Ljava/lang/Object;
.field synthetic L$1:Ljava/lang/Object;
.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 3
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invoke(com.bytedance.trae.home.solo.task.TaskFragment$RawTaskContentState  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;-><init>(Lkotlin/coroutines/Continuation;)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;->L$0 Ljava/lang/Object;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;->L$1 Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
    check-cast v2, Ljava/util/List;
    check-cast v3, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;->invoke(Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;->label I
    if-nez v0, +037h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$2;->L$1 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Ljava/util/List;
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->getTasks()Ljava/util/List;
    move-result-object v1
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode()Z
    move-result v2
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->getQuery()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, v6, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->displayTasks(Ljava/util/List; Z Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->getHasError()Z
    move-result v3
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode()Z
    move-result v4
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->getQuery()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading()Z
    move-result v7
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;-><init>(Ljava/util/List; Z Z Ljava/lang/String; Ljava/util/List; Z)V
    return-object v0
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
.end method
