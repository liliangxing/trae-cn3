# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitSelectionViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $repoUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;


.method constructor <init>(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->$repoUrl Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->$repoUrl Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +010h
    if-ne v1, v3, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3bh
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_branchLoading$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v12
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v12, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v12, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setBranchNextPageToken$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v4
    iget-object v5, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->$repoUrl Ljava/lang/String;
    const/16 v12, 50
    invoke-static v12, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    const/4 v7, 0
    move-object v8, v11
    check-cast v8, Lkotlin/coroutines/Continuation;
    const/4 v9, 4
    const/4 v10, 0
    iput v3, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->label I
    invoke-static/range v4 ... v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->listBranches$default(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    check-cast v12, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_branchLoading$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    instance-of v0, v12, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +083h
    move-object v1, v12
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v4
    if-eqz v4, +076h
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-eqz v12, +006h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setBranchNextPageToken$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String;)V
    if-eqz v12, +04ch
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getItems()Ljava/util/List;
    move-result-object v12
    if-eqz v12, +046h
    check-cast v12, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v12, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +02ah
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/GitBranch;
    new-instance v2, Lcom/bytedance/trae/conversation/git/BranchItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/GitBranch;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/GitBranch;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault()Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/git/BranchItem;-><init>(Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2dh
    check-cast v0, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v12, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setCachedBranchItems$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/util/List;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_branchListReady$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v12
    invoke-virtual v12, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +2fh
    if-eqz v0, +017h
    check-cast v12, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v12, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +015h
    invoke-virtual v12, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v0
    goto +bh
    instance-of v0, v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +018h
    check-cast v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$get_branchLoadError$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v12
    if-nez v0, +004h
    const-string v0, "Failed to load branches"
    invoke-virtual v12, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
.end method
