# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitSelectionViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $keyword:Ljava/lang/String;
.field final synthetic $repoUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;


.method constructor <init>(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->$repoUrl Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->$keyword Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->$repoUrl Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->$keyword Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +37h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_branchLoadingMore$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v11
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v11, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v11, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v3
    iget-object v4, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->$repoUrl Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->$keyword Ljava/lang/String;
    const/16 v11, 50
    invoke-static v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "1"
    move-object v8, v10
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->label I
    invoke-virtual/range v3 ... v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->fetchBranches(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_branchLoadingMore$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    instance-of v0, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +073h
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-eqz v0, +067h
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setSearchNextPageToken$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String;)V
    if-eqz v11, +041h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getItems()Ljava/util/List;
    move-result-object v11
    if-eqz v11, +03bh
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v11, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01fh
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/GitBranch;
    new-instance v9, Lcom/bytedance/trae/conversation/git/BranchItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/GitBranch;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/GitBranch;->getName()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 12
    const/4 v8, 0
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/git/BranchItem;-><init>(Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -22h
    check-cast v0, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iget-object v11, v10, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_branchSearchResult$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v11
    invoke-virtual v11, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
