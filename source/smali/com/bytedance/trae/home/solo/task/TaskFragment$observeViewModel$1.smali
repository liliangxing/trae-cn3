# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $emptyStateView:Landroid/view/View;
.field final synthetic $networkErrorView:Landroid/view/View;
.field final synthetic $recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field final synthetic $searchEmptyText:Landroid/widget/TextView;
.field final synthetic $searchEmptyView:Landroid/view/View;
.field final synthetic $searchLoadingView:Landroid/view/View;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  androidx.recyclerview.widget.RecyclerView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View  kotlin.coroutines.Continuation)void
    .registers 9
    # ins_size=9
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$emptyStateView Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchLoadingView Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchEmptyView Landroid/view/View;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchEmptyText Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$networkErrorView Landroid/view/View;
    const/4 v1, 2
    invoke-direct v0, v1, v8, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 12
    # ins_size=3
    new-instance v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v2, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$emptyStateView Landroid/view/View;
    iget-object v4, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchLoadingView Landroid/view/View;
    iget-object v5, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchEmptyView Landroid/view/View;
    iget-object v6, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchEmptyText Landroid/widget/TextView;
    iget-object v7, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$networkErrorView Landroid/view/View;
    move-object v0, v10
    move-object v8, v11
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/coroutines/Continuation;
    return-object v10
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3ch
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v14
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->STARTED Landroidx/lifecycle/Lifecycle$State;
    new-instance v12, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1;
    iget-object v4, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v5, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v6, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$emptyStateView Landroid/view/View;
    iget-object v7, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchLoadingView Landroid/view/View;
    iget-object v8, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchEmptyView Landroid/view/View;
    iget-object v9, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$searchEmptyText Landroid/widget/TextView;
    iget-object v10, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->$networkErrorView Landroid/view/View;
    const/4 v11, 0
    move-object v3, v12
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    move-object v3, v13
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;->label I
    invoke-static v14, v1, v12, v3, Landroidx/lifecycle/RepeatOnLifecycleKt;->repeatOnLifecycle(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Lifecycle$State; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
