# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitSelectionViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;


.method constructor <init>(com.bytedance.trae.conversation.git.GitSelectionViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +010h
    if-ne v1, v3, +006h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_repoLoading$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v15
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v15, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v15, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v15
    move-object v1, v14
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v3, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->label I
    const/16 v3, 50
    invoke-virtual v15, v3, v2, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->fetchReposPage(I Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    check-cast v15, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    iget-object v0, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_repoLoading$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getSuccess()Z
    move-result v0
    if-eqz v0, +07dh
    iget-object v0, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getNextPageToken()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setRepoNextPageToken$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_selectedRepo$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v2
    iget-object v0, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v15
    check-cast v15, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v15, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v1, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02eh
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/network/GitRepository;
    new-instance v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/GitRepository;->getFullName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/GitRepository;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/GitRepository;->getUrl()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    const/4 v10, 0
    const/16 v11, 32
    const/4 v12, 0
    move-object v4, v13
    invoke-direct/range v4 ... v12, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v13, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -31h
    check-cast v1, Ljava/util/List;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setCachedRepoItems$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/util/List;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_repoListReady$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v15
    iget-object v0, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$getCachedRepoItems$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Ljava/util/List;
    move-result-object v0
    invoke-virtual v15, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +eh
    iget-object v0, v14, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_repoLoadError$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getErrorMessage()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v0, v15, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
.end method
