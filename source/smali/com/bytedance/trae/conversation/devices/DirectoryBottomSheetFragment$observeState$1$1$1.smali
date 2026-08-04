# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;
.super Ljava/lang/Object;
.source "DirectoryBottomSheetFragment.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;


.method constructor <init>(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(com.bytedance.trae.conversation.devices.DirectoryUiState  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getResolvedMode()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    move-result-object v10
    const/4 v0, -1
    if-nez v10, +004h
    move v10, v0
    goto +9h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->ordinal()I
    move-result v10
    aget v10, v1, v10
    const-string/jumbo v1, titleBar
    const/4 v2, 1
    const-string v3, "btnAddFolder"
    const/4 v4, 0
    if-eq v10, v0, +073h
    if-eq v10, v2, +03eh
    const/4 v0, 2
    if-ne v10, v0, +035h
    iget-object v10, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getTitleBar$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v4
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_your_folders I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v10, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    iget-object v10, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getBtnAddFolder$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroid/widget/Button;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v4
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_add_new_folder I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v10, v0, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    goto +6ch
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
    iget-object v10, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getTitleBar$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v4
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_recent_folders I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v10, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    iget-object v10, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getBtnAddFolder$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroid/widget/Button;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v4
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_more_folders I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v10, v0, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    goto +33h
    iget-object v10, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getTitleBar$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v4
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_your_folders I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v10, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    iget-object v10, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getBtnAddFolder$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroid/widget/Button;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v4
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_add_new_folder I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v10, v0, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading()Z
    move-result v10
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +006h
    if-nez v10, +004h
    move v0, v2
    goto +2h
    move v0, v1
    iget-object v5, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getProgressLoading$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroid/view/View;
    move-result-object v5
    if-nez v5, +008h
    const-string v5, "progressLoading"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    const/16 v6, 8
    if-eqz v10, +004h
    move v7, v1
    goto +2h
    move v7, v6
    invoke-virtual v5, v7, Landroid/view/View;->setVisibility(I)V
    iget-object v5, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getTvEmptyState$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroid/view/View;
    move-result-object v5
    if-nez v5, +009h
    const-string/jumbo v5, tvEmptyState
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    if-eqz v0, +004h
    move v7, v1
    goto +2h
    move v7, v6
    invoke-virtual v5, v7, Landroid/view/View;->setVisibility(I)V
    iget-object v5, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getRecyclerView$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroidx/recyclerview/widget/RecyclerView;
    move-result-object v5
    if-nez v5, +008h
    const-string v5, "recyclerView"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    if-nez v10, +006h
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v6
    invoke-virtual v5, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getBtnAddFolder$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroid/widget/Button;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    if-nez v10, +010h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    xor-int/2addr v10, v2
    if-eqz v10, +003h
    goto +2h
    move v1, v6
    invoke-virtual v0, v1, Landroid/widget/Button;->setVisibility(I)V
    iget-object v10, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getAdapter$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    move-result-object v10
    if-nez v10, +008h
    const-string v10, "adapter"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v10
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v9
    check-cast v9, Ljava/lang/Iterable;
    invoke-static v9, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v9
    invoke-virtual v4, v9, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->submitList(Ljava/util/List;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1$1$1;->emit(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
