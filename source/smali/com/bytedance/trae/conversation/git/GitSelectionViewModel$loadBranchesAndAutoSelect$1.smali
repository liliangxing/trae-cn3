# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitSelectionViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $repoUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;


.method constructor <init>(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->$repoUrl Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->$repoUrl Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->label I
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +016h
    if-eq v1, v4, +010h
    if-ne v1, v3, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +59h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +30h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v14, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setBranchNextPageToken$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v14, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v14
    if-eqz v14, +024h
    sget-object v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v5
    iget-object v6, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->$repoUrl Ljava/lang/String;
    const/4 v7, 0
    const/16 v14, 50
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v8
    const-string v9, "1"
    move-object v10, v13
    check-cast v10, Lkotlin/coroutines/Continuation;
    const/4 v11, 2
    const/4 v12, 0
    iput v4, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->label I
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->fetchBranches$default(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +1dh
    sget-object v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v4
    iget-object v5, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->$repoUrl Ljava/lang/String;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    move-object v9, v13
    check-cast v9, Lkotlin/coroutines/Continuation;
    const/16 v10, 14
    const/4 v11, 0
    iput v3, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->label I
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->fetchBranches$default(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +072h
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-eqz v0, +066h
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-eqz v14, +006h
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setBranchNextPageToken$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String;)V
    if-eqz v14, +041h
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getItems()Ljava/util/List;
    move-result-object v14
    if-eqz v14, +03bh
    check-cast v14, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v14, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01fh
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
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
    iget-object v14, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v14, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$setCachedBranchItems$p(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/util/List;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;->this$0 Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-static v14, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->access$selectDefaultBranch(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/util/List;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
