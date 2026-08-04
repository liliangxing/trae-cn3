# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitSelectionViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $pageToken:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;


.method constructor <init>(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->$pageToken Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->$pageToken Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_repoLoadingMore$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v14
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v14, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v14
    iget-object v1, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->$pageToken Ljava/lang/String;
    move-object v3, v13
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->label I
    const/16 v2, 50
    invoke-virtual v14, v2, v1, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->fetchReposPage(I Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_repoLoadingMore$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getSuccess()Z
    move-result v0
    if-eqz v0, +085h
    iget-object v0, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getNextPageToken()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setRepoNextPageToken$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String;)V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_selectedRepo$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v14
    check-cast v14, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v14, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02eh
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/GitRepository;
    new-instance v12, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRepository;->getFullName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRepository;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRepository;->getUrl()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    const/4 v9, 0
    const/16 v10, 32
    const/4 v11, 0
    move-object v3, v12
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v12, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -31h
    check-cast v1, Ljava/util/List;
    iget-object v14, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$getCachedRepoItems$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    move-object v2, v1
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    invoke-static v14, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setCachedRepoItems$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/util/List;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_repoLoadMoreResult$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v14
    invoke-virtual v14, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
