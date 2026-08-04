# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;
.super Ljava/lang/Object;
.source "BranchSelectBottomSheet.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic $ivSearchClear:Landroid/widget/ImageView;
.field final synthetic $rvBranches:Landroidx/recyclerview/widget/RecyclerView;
.field final synthetic $selectedBranch:Lkotlin/jvm/internal/Ref$ObjectRef;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;


.method constructor <init>(android.widget.ImageView  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  androidx.recyclerview.widget.RecyclerView  kotlin.jvm.internal.Ref$ObjectRef)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$ivSearchClear Landroid/widget/ImageView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$selectedBranch Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 16
    # ins_size=2
    const/4 v0, 0
    if-eqz v15, +007h
    invoke-virtual v15, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v0
    if-nez v15, +004h
    const-string v15, ""
    move-object v2, v15
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$ivSearchClear Landroid/widget/ImageView;
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    if-lez v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    const/16 v6, 8
    if-eqz v3, +004h
    move v3, v5
    goto +2h
    move v3, v6
    invoke-virtual v15, v3, Landroid/widget/ImageView;->setVisibility(I)V
    sget-object v15, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v15, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v15
    if-eqz v15, +03ah
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getSearchJob$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Lkotlinx/coroutines/Job;
    move-result-object v15
    if-eqz v15, +005h
    invoke-static v15, v0, v4, v0, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    move-object v0, v15
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
    iget-object v3, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iget-object v4, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    iget-object v5, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$selectedBranch Lkotlin/jvm/internal/Ref$ObjectRef;
    const/4 v6, 0
    move-object v1, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/coroutines/Continuation;)V
    move-object v6, v9
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v1, 3
    const/4 v2, 0
    move-object v3, v0
    move-object v4, v7
    move-object v5, v8
    move v7, v1
    move-object v8, v2
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-static v15, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setSearchJob$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Lkotlinx/coroutines/Job;)V
    goto/16 +148h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v15
    if-nez v15, +004h
    move v15, v4
    goto +2h
    move v15, v5
    const-string v2, "adapter"
    const/16 v3, 10
    if-eqz v15, +07ch
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setSearching$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Z)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v15, v5, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getTvSearchEmpty$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Landroid/widget/TextView;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v6, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getFullBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    iget-object v4, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$selectedBranch Lkotlin/jvm/internal/Ref$ObjectRef;
    new-instance v5, Ljava/util/ArrayList;
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v5, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02bh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v6, v3
    check-cast v6, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v7, 0
    const/4 v8, 0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v3
    iget-object v9, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/git/BranchItem;
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v0
    invoke-static v3, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    const/4 v10, 0
    const/16 v11, 11
    const/4 v12, 0
    invoke-static/range v6 ... v12, Lcom/bytedance/trae/conversation/git/BranchItem;->copy$default(Lcom/bytedance/trae/conversation/git/BranchItem; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/BranchItem;
    move-result-object v3
    invoke-interface v5, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v5, Ljava/util/List;
    invoke-static v15, v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/util/List;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    move-result-object v15
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v15
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Ljava/util/List;
    move-result-object v15
    invoke-virtual v0, v15, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;->submitList(Ljava/util/List;)V
    goto/16 +0bfh
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setSearching$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Z)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getFullBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Ljava/util/List;
    move-result-object v15
    check-cast v15, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +019h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Lcom/bytedance/trae/conversation/git/BranchItem;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchItem;->getName()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, v1, v4, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v9
    if-eqz v9, -017h
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$selectedBranch Lkotlin/jvm/internal/Ref$ObjectRef;
    new-instance v1, Ljava/util/ArrayList;
    invoke-static v7, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v1, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02bh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v7, v4
    check-cast v7, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v8, 0
    const/4 v9, 0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v4
    iget-object v10, v15, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/git/BranchItem;
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v0
    invoke-static v4, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    const/4 v11, 0
    const/16 v12, 11
    const/4 v13, 0
    invoke-static/range v7 ... v13, Lcom/bytedance/trae/conversation/git/BranchItem;->copy$default(Lcom/bytedance/trae/conversation/git/BranchItem; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/BranchItem;
    move-result-object v4
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v15
    if-eqz v15, +013h
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v15, v6, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getTvSearchEmpty$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Landroid/widget/TextView;
    move-result-object v15
    if-eqz v15, +016h
    invoke-virtual v15, v5, Landroid/widget/TextView;->setVisibility(I)V
    goto +11h
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->$rvBranches Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v15, v5, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getTvSearchEmpty$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Landroid/widget/TextView;
    move-result-object v15
    if-eqz v15, +005h
    invoke-virtual v15, v6, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$setBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/util/List;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    move-result-object v15
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v15
    iget-object v15, v14, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->access$getBranchItems$p(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)Ljava/util/List;
    move-result-object v15
    invoke-virtual v0, v15, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;->submitList(Ljava/util/List;)V
    return-void 
.end method

.method public beforeTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method

.method public onTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method
