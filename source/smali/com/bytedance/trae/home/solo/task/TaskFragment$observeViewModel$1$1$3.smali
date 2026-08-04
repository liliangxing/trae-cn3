# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $emptyStateView:Landroid/view/View;
.field final synthetic $networkErrorView:Landroid/view/View;
.field final synthetic $recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field final synthetic $searchEmptyText:Landroid/widget/TextView;
.field final synthetic $searchEmptyView:Landroid/view/View;
.field final synthetic $searchLoadingView:Landroid/view/View;
.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method public static synthetic $r8$lambda$_SU2_iQTZ2SyBMFh_SslZdmfzjI(java.util.List  com.bytedance.trae.home.solo.task.TaskFragment  androidx.recyclerview.widget.RecyclerView  boolean  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->invokeSuspend$lambda$3(Ljava/util/List; Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Z Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ns8kFzydZS7jKlvcUTomJFl8sAQ(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState  androidx.recyclerview.widget.RecyclerView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->invokeSuspend$lambda$0(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  androidx.recyclerview.widget.RecyclerView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View  kotlin.coroutines.Continuation)void
    .registers 9
    # ins_size=9
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$emptyStateView Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchLoadingView Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchEmptyView Landroid/view/View;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchEmptyText Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$networkErrorView Landroid/view/View;
    const/4 v1, 2
    invoke-direct v0, v1, v8, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState  androidx.recyclerview.widget.RecyclerView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$renderTaskContent(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final invokeSuspend$lambda$3(java.util.List  com.bytedance.trae.home.solo.task.TaskFragment  androidx.recyclerview.widget.RecyclerView  boolean  kotlin.jvm.functions.Function0)void
    .registers 13
    # ins_size=5
    invoke-static v8, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/task/TaskModel;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-static v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getTopTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Ljava/lang/String;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +010h
    if-eqz v0, +00eh
    invoke-static v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getTopTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    invoke-static v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getSuppressNextTopChangedScrollTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Ljava/lang/String;
    move-result-object v5
    invoke-static v8, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/task/TaskModel;
    if-eqz v2, +018h
    if-eqz v5, +016h
    if-eqz v6, +014h
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +00ah
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v6
    if-eqz v6, +004h
    move v6, v3
    goto +2h
    move v6, v4
    invoke-static v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getShouldScrollToTop$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Z
    move-result v7
    if-nez v7, +006h
    if-eqz v2, +016h
    if-nez v6, +014h
    move-object v2, v8
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v2, v3
    if-eqz v2, +00ah
    if-eqz v10, +005h
    invoke-virtual v10, v4, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V
    invoke-static v9, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$setShouldScrollToTop$p(Lcom/bytedance/trae/home/solo/task/TaskFragment; Z)V
    if-eqz v5, +067h
    check-cast v8, Ljava/lang/Iterable;
    instance-of v10, v8, Ljava/util/Collection;
    if-eqz v10, +00dh
    move-object v2, v8
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v2, v4
    goto +27h
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +00ah
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v6
    if-eqz v6, +004h
    move v6, v3
    goto +2h
    move v6, v4
    if-eqz v6, -01fh
    move v2, v3
    if-nez v2, +02bh
    if-eqz v10, +00ch
    move-object v10, v8
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    if-eqz v10, +003h
    goto +1ch
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +013h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, -014h
    move v3, v4
    if-eqz v3, +005h
    invoke-static v9, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$setSuppressNextTopChangedScrollTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment; Ljava/lang/String;)V
    invoke-static v9, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$setTopTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment; Ljava/lang/String;)V
    if-eqz v11, +005h
    invoke-interface v12, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 13
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v2, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v3, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$emptyStateView Landroid/view/View;
    iget-object v4, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchLoadingView Landroid/view/View;
    iget-object v5, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchEmptyView Landroid/view/View;
    iget-object v6, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchEmptyText Landroid/widget/TextView;
    iget-object v7, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$networkErrorView Landroid/view/View;
    move-object v0, v9
    move-object v8, v12
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    iput-object v11, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public final invoke(com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->invoke(Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->label I
    if-nez v0, +0cah
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->L$0 Ljava/lang/Object;
    move-object v2, v14
    check-cast v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getTasks()Ljava/util/List;
    move-result-object v14
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository;->hasMultipleLocalCliTypes()Z
    move-result v0
    iget-object v1, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    move-result-object v1
    const/4 v10, 0
    const-string v11, "adapter"
    if-nez v1, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v10
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->getShowProductType()Z
    move-result v1
    const/4 v3, 0
    if-eq v1, v0, +004h
    const/4 v1, 1
    goto +2h
    move v1, v3
    iget-object v4, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v10
    invoke-virtual v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->setShowProductType(Z)V
    if-eqz v1, +021h
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v10
    iget-object v1, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v10
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->getItemCount()I
    move-result v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->notifyItemRangeChanged(I I)V
    sget-object v3, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getHasError()Z
    move-result v5
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode()Z
    move-result v6
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getQuery()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading()Z
    move-result v8
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getSearchResults()Ljava/util/List;
    move-result-object v9
    move-object v4, v14
    invoke-virtual/range v3 ... v9, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->shouldWaitForListCommitBeforeShowingContent(Ljava/util/List; Z Z Ljava/lang/String; Z Ljava/util/List;)Z
    move-result v9
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v1, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    sget-object v3, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode()Z
    move-result v4
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getQuery()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->shouldSuppressListItemAnimations(Z Ljava/lang/String;)Z
    move-result v3
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$setTaskListItemAnimationsSuppressed(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Z)V
    iget-object v1, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v3, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v4, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$emptyStateView Landroid/view/View;
    iget-object v5, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchLoadingView Landroid/view/View;
    iget-object v6, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchEmptyView Landroid/view/View;
    iget-object v7, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$searchEmptyText Landroid/widget/TextView;
    iget-object v8, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$networkErrorView Landroid/view/View;
    new-instance v12, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda0;
    move-object v0, v12
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View;)V
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v10, v0
    iget-object v5, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v6, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;
    move-object v3, v0
    move-object v4, v14
    move v7, v9
    move-object v8, v12
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;-><init>(Ljava/util/List; Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Z Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v10, v14, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->submitList(Ljava/util/List; Ljava/lang/Runnable;)V
    if-nez v9, +005h
    invoke-interface v12, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
.end method
