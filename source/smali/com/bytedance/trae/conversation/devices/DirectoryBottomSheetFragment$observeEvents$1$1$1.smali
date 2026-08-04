# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;
.super Ljava/lang/Object;
.source "DirectoryBottomSheetFragment.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;


.method public static synthetic $r8$lambda$y7MABKKgxtZCXM_O25ryIjr6vLc(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryEvent)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->emit$lambda$0(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryEvent;)V
    return-void 
.end method

.method constructor <init>(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final emit$lambda$0(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryEvent)void
    .registers 2
    # ins_size=2
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getRecyclerView$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Landroidx/recyclerview/widget/RecyclerView;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "recyclerView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FocusNewFolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FocusNewFolder;->getPosition()I
    move-result v1
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V
    return-void 
.end method

.method public final emit(com.bytedance.trae.conversation.devices.DirectoryEvent  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    instance-of v6, v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    const/4 v0, 0
    if-eqz v6, +018h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->requireContext()Landroid/content/Context;
    move-result-object v6
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;->getMessage()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v6, v5, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    goto +5eh
    instance-of v6, v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FolderCreated;
    if-eqz v6, +025h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->requireContext()Landroid/content/Context;
    move-result-object v6
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_folder_created I
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FolderCreated;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FolderCreated;->getName()Ljava/lang/String;
    move-result-object v5
    aput-object v5, v3, v0
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v6, v5, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    goto +37h
    instance-of v6, v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FocusNewFolder;
    if-eqz v6, +037h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getAdapter$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    move-result-object v6
    if-nez v6, +008h
    const-string v6, "adapter"
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v6, 0
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getViewModel(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryEvent;)V
    invoke-virtual v6, v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->submitList(Ljava/util/List; Ljava/lang/Runnable;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryEvent;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;->emit(Lcom/bytedance/trae/conversation/devices/DirectoryEvent; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
