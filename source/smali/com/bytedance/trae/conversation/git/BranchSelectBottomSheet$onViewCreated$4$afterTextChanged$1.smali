# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BranchSelectBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $keyword:Ljava/lang/String;
.field final synthetic $rvBranches:Landroidx/recyclerview/widget/RecyclerView;
.field final synthetic $selectedBranch:Lkotlin/jvm/internal/Ref$ObjectRef;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  androidx.recyclerview.widget.RecyclerView  kotlin.jvm.internal.Ref$ObjectRef  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$selectedBranch Lkotlin/jvm/internal/Ref$ObjectRef;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$selectedBranch Lkotlin/jvm/internal/Ref$ObjectRef;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v12
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput v2, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->label I
    const-wide/16 v3, 300
    invoke-static v3, v4, v13, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    const/4 v0, 0
    if-nez v13, +004h
    move v13, v2
    goto +2h
    move v13, v0
    const/4 v1, 0
    if-eqz v13, +081h
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v13, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setSearching$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Z)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v13, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v13, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getTvSearchEmpty$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Landroid/widget/TextView;
    move-result-object v13
    if-eqz v13, +007h
    const/16 v0, 8
    invoke-virtual v13, v0, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v13, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getFullBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    iget-object v2, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$selectedBranch Lkotlin/jvm/internal/Ref$ObjectRef;
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
    if-eqz v4, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v4
    iget-object v8, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/git/BranchItem;
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v1
    invoke-static v4, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    const/4 v9, 0
    const/16 v10, 11
    const/4 v11, 0
    invoke-static/range v5 ... v11, Lcom/bytedance/trae/conversation/git/BranchItem;->copy$default(Lcom/bytedance/trae/conversation/git/BranchItem; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/BranchItem;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v3, Ljava/util/List;
    invoke-static v13, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/util/List;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v13, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    move-result-object v13
    if-nez v13, +008h
    const-string v13, "adapter"
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v13
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v13, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Ljava/util/List;
    move-result-object v13
    invoke-virtual v1, v13, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;->submitList(Ljava/util/List;)V
    goto +1ah
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v13, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setSearching$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Z)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v13, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getGitViewModel$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v13
    if-nez v13, +008h
    const-string v13, "gitViewModel"
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v13
    iget-object v13, v12, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;->$keyword Ljava/lang/String;
    invoke-virtual v1, v13, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->searchBranches(Ljava/lang/String;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
.end method
