# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitRepoSelectBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $keyword:Ljava/lang/String;
.field final synthetic $tempSelectedRepo:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$tempSelectedRepo Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$tempSelectedRepo Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v15, v14
    check-cast v15, Lkotlin/coroutines/Continuation;
    iput v2, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->label I
    const-wide/16 v3, 300
    invoke-static v3, v4, v15, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    check-cast v15, Ljava/lang/CharSequence;
    invoke-interface v15, Ljava/lang/CharSequence;->length()I
    move-result v15
    const/4 v0, 0
    if-nez v15, +004h
    move v15, v2
    goto +2h
    move v15, v0
    const/4 v1, 0
    const/16 v3, 8
    if-eqz v15, +086h
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setSearching$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Z)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getSearchLoadingBar$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/widget/ProgressBar;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getRvRepositories$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroidx/recyclerview/widget/RecyclerView;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getTvSearchEmpty$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/widget/TextView;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getFullRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    iget-object v2, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$tempSelectedRepo Ljava/lang/String;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v0, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +021h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    const/4 v11, 0
    const/16 v12, 47
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;->copy$default(Lcom/bytedance/trae/conversation/git/GitRepoItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -24h
    check-cast v3, Ljava/util/List;
    invoke-static v15, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/util/List;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    move-result-object v15
    if-nez v15, +008h
    const-string v15, "adapter"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v15
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Ljava/util/List;
    move-result-object v15
    invoke-virtual v1, v15, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->submitList(Ljava/util/List;)V
    goto +3bh
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setSearching$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Z)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getSearchLoadingBar$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/widget/ProgressBar;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getRvRepositories$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroidx/recyclerview/widget/RecyclerView;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v3, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getTvSearchEmpty$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/widget/TextView;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getGitViewModel$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v15
    if-nez v15, +008h
    const-string v15, "gitViewModel"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v15
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    invoke-virtual v1, v15, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->searchRepos(Ljava/lang/String;)V
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
.end method
