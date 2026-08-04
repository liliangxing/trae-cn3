# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitRepoSelectBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 25
    # ins_size=2
    move-object/from16 v0, v23
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->label I
    const-string v3, "adapter"
    const/4 v4, 2
    const/16 v5, 10
    const/16 v6, 8
    const/4 v7, 0
    const/4 v8, 1
    const/4 v9, 0
    if-eqz v2, +024h
    if-eq v2, v8, +01bh
    if-ne v2, v4, +011h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v24
    goto/16 +124h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v24
    goto/16 +0cch
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v2
    if-nez v2, +0adh
    sget-object v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->getCachedRepos()Ljava/util/List;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    xor-int/2addr v10, v8
    if-eqz v10, +099h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/widget/ProgressBar;
    move-result-object v10
    if-eqz v10, +005h
    invoke-virtual v10, v6, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getContentView$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/view/View;
    move-result-object v10
    if-eqz v10, +005h
    invoke-virtual v10, v9, Landroid/view/View;->setVisibility(I)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    invoke-static v2, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v12
    invoke-direct v11, v12, Ljava/util/ArrayList;-><init>(I)V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +047h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/network/GitRepository;
    new-instance v15, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/GitRepository;->getFullName()Ljava/lang/String;
    move-result-object v16
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/GitRepository;->getName()Ljava/lang/String;
    move-result-object v17
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/GitRepository;->getUrl()Ljava/lang/String;
    move-result-object v18
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getSelectedRepo()Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v7
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    const/16 v19, 0
    const/16 v20, 32
    const/16 v21, 0
    move-object v13, v15
    move-object v5, v15
    move-object/from16 v15, v16
    move-object/from16 v16, v17
    move-object/from16 v17, v18
    move/from16 v18, v12
    invoke-direct/range v13 ... v21, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v11, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/16 v5, 10
    goto -4ah
    check-cast v11, Ljava/util/List;
    invoke-static v10, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/util/List;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Ljava/util/List;
    move-result-object v5
    invoke-static v2, v5, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setFullRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/util/List;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v7
    iget-object v5, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v5, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Ljava/util/List;
    move-result-object v5
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->submitList(Ljava/util/List;)V
    sget-object v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v2
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v8, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->label I
    const/16 v10, 50
    invoke-virtual v2, v10, v7, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->fetchReposPage(I Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    new-instance v5, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v5, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getSelectedRepo()Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v10
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getTitle()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v7
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +003h
    goto +3h
    move v10, v9
    goto +2h
    move v10, v8
    if-nez v10, +065h
    sget-object v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v10
    iget-object v11, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getSelectedRepo()Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v11
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getTitle()Ljava/lang/String;
    move-result-object v11
    move-object v12, v0
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->label I
    invoke-virtual v10, v11, v12, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->searchRepos(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v1, +003h
    return-object v1
    move-object v1, v5
    check-cast v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getSuccess()Z
    move-result v5
    if-eqz v5, +038h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/2addr v5, v8
    if-eqz v5, +02bh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v4
    invoke-interface v4, v9, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/GitRepository;
    new-instance v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRepository;->getFullName()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRepository;->getName()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRepository;->getUrl()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 1
    const/16 v16, 0
    const/16 v17, 32
    const/16 v18, 0
    move-object v10, v5
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v5, v1, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    move-object v5, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getContentView$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v9, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/widget/ProgressBar;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v6, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getSuccess()Z
    move-result v1
    if-eqz v1, +16ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +01eh
    iget-object v1, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v1, +01ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getContentView$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v6, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getEmptyStateView$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +18eh
    invoke-virtual v1, v9, Landroid/view/View;->setVisibility(I)V
    goto/16 +189h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getEmptyStateView$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v6, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-eqz v1, +03dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    instance-of v4, v1, Ljava/util/Collection;
    if-eqz v4, +00dh
    move-object v4, v1
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v1, v9
    goto +24h
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/GitRepository;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v4
    iget-object v6, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -01ch
    move v1, v8
    if-eqz v1, +003h
    goto +2h
    move v8, v9
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    if-nez v8, +05eh
    iget-object v4, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v4, +003h
    goto +58h
    iget-object v4, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    const/16 v8, 10
    invoke-static v5, v8, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v8
    invoke-direct v6, v8, Ljava/util/ArrayList;-><init>(I)V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +02bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/network/GitRepository;
    new-instance v15, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRepository;->getFullName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRepository;->getName()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRepository;->getUrl()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v8, 0
    const/16 v16, 32
    const/16 v17, 0
    move-object v9, v15
    move-object v7, v15
    move v15, v8
    invoke-direct/range v9 ... v17, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v6, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/4 v7, 0
    goto -2eh
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v4, v6, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v4
    goto +5fh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    const/16 v7, 10
    invoke-static v4, v7, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v7
    invoke-direct v6, v7, Ljava/util/ArrayList;-><init>(I)V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +040h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/network/GitRepository;
    new-instance v15, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/GitRepository;->getFullName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/GitRepository;->getName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/GitRepository;->getUrl()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/GitRepository;->getRepoId()Ljava/lang/String;
    move-result-object v7
    iget-object v8, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    const/4 v8, 0
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    const/4 v14, 0
    const/16 v7, 32
    const/16 v16, 0
    move-object v8, v15
    move-object/from16 v22, v15
    move v15, v7
    invoke-direct/range v8 ... v16, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v7, v22
    invoke-interface v6, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -43h
    move-object v4, v6
    check-cast v4, Ljava/util/List;
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/util/List;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Ljava/util/List;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setFullRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/util/List;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    iget-object v3, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getRepoItems$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Ljava/util/List;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->submitList(Ljava/util/List;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getGitViewModel$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v1
    if-nez v1, +009h
    const-string v1, "gitViewModel"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v7, 0
    goto +2h
    move-object v7, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getNextPageToken()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->setRepoNextPageToken(Ljava/lang/String;)V
    goto +46h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getErrorCode()Ljava/lang/Long;
    move-result-object v1
    if-nez v1, +003h
    goto +ch
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    const-wide/32 v5, 991402
    cmp-long v1, v3, v5
    if-eqz v1, +025h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getErrorCode()Ljava/lang/Long;
    move-result-object v1
    if-nez v1, +003h
    goto +dh
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    const-wide/32 v3, 991403
    cmp-long v1, v1, v3
    if-nez v1, +003h
    goto +11h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-static v1, v2, v9, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    goto +11h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->dismissAllowingStateLoss()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getOnAuthFailed()Lkotlin/jvm/functions/Function0;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
