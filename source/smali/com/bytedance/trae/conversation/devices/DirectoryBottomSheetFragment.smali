# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "DirectoryBottomSheetFragment.kt"

.field private static final ARG_CHAT_MODE:Ljava/lang/String;
.field private static final ARG_CLI_ID:Ljava/lang/String;
.field private static final ARG_SELECTED_DIRECTORY:Ljava/lang/String;
.field private static final ARG_USE_FLOW_ROUTE_BACK:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
.field public static final TAG:Ljava/lang/String;
.field private adapter:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
.field private btnAddFolder:Landroid/widget/Button;
.field private forceDocumentRootPath:Ljava/lang/String;
.field private listener:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
.field private progressLoading:Landroid/view/View;
.field private recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field private tvEmptyState:Landroid/view/View;
.field private final viewModel$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$-X34UXFPzGueRxfoXt25D4Oi1ZU(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setupRecyclerView$lambda$7(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$0AOxBUff8ZNTqalW3yCoAeO59_w(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setupRecyclerView$lambda$8(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$BpoifB9Bvgh1Keg5K6G6qJHLGso(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleNodeSelect$lambda$14$lambda$13(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IJdGXVSdfFt5QyCq5N4IiJxH36A(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setupRecyclerView$lambda$10(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$JRosfs_zuYK5EScIwn5A4gL-pZo(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->onCreateDialog$lambda$3(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$O37_T21ax1Swlyjcbt7bnAZM0yM(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->initViews$lambda$5(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$STa12SKlvTPPsXvA_cszT644xuE(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleNodeSelect$lambda$14$lambda$12$lambda$11(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$W8RzMKdvNiSLHeFVQVgq_vAomQA(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleNodeSelect$lambda$14(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Y5vpZK91_HxPU7-77WmxXTG8PYM(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->onCreateDialog$lambda$0(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Landroid/content/DialogInterface; I Landroid/view/KeyEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$Z0uvPxNdPKUgOxOMZ0bDy9iWjTc(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->initViews$lambda$6(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fsF0fdeoElMCucoF-E3ZKS0tfKQ(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setupRecyclerView$lambda$9(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$yXhoZGhpSpgVZnVKN36fEN8Z1EI(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleNodeSelect$lambda$14$lambda$12(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    move-object v0, v5
    check-cast v0, Landroidx/fragment/app/Fragment;
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$special$$inlined$viewModels$default$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$special$$inlined$viewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    const-class v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$special$$inlined$viewModels$default$2;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$special$$inlined$viewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$special$$inlined$viewModels$default$3;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/fragment/app/Fragment;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-static v0, v2, v3, v4, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment; Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->viewModel$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)com.bytedance.trae.conversation.devices.DirectoryAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->adapter Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    return-object v0
.end method

.method public static final synthetic access$getBtnAddFolder$p(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)android.widget.Button
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->btnAddFolder Landroid/widget/Button;
    return-object v0
.end method

.method public static final synthetic access$getListener$p(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$OnDirectorySelectedListener
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    return-object v0
.end method

.method public static final synthetic access$getProgressLoading$p(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->progressLoading Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getRecyclerView$p(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)androidx.recyclerview.widget.RecyclerView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    return-object v0
.end method

.method public static final synthetic access$getTitleBar$p(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)com.bytedance.trae.common.widget.TraeTitleBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    return-object v0
.end method

.method public static final synthetic access$getTvEmptyState$p(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->tvEmptyState Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getViewModel(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)com.bytedance.trae.conversation.devices.DirectoryViewModel
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    return-object v0
.end method

.method private final getViewModel()com.bytedance.trae.conversation.devices.DirectoryViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->viewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    return-object v0
.end method

.method private final handleAddNewFolderClicked()void
    .registers 7
    # ins_size=1
    invoke-direct v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getResolvedMode()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->RECENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    if-ne v0, v1, +064h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +05dh
    const-string v1, "arg_cli_id"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +53h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v1
    if-eqz v1, +010h
    const-string v2, "arg_chat_mode"
    invoke-virtual v1, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +008h
    invoke-static v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v1
    if-nez v1, +004h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-direct v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getDefaultFolder()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v5, "arg_selected_directory"
    invoke-virtual v4, v5, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v3, v0, v1, v4, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;->newInstance(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    move-result-object v0
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->forceDocumentRootPath Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$handleAddNewFolderClicked$1;
    invoke-direct v1, v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$handleAddNewFolderClicked$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setOnDirectorySelectedListener(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v2, "DirectoryBottomSheet_document"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    goto +9h
    return-void 
    invoke-direct v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->onAddNewFolderClicked()V
    return-void 
.end method

.method private final handleNodeClick(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getResolvedMode()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->RECENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    if-ne v0, v1, +006h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleNodeSelect(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    goto +8h
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->onNodeClicked(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    return-void 
.end method

.method private final handleNodeSelect(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getResolvedMode()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    move-result-object v0
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v1
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->onNodeSelected(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->RECENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    if-ne v0, v1, +00dh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    if-eqz v0, +005h
    invoke-interface v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;->onDirectorySelected(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismiss()V
    goto +11h
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda2;
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->checkNeedAuthorization(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final handleNodeSelect$lambda$14(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode  boolean)kotlin.Unit
    .registers 6
    # ins_size=3
    if-eqz v5, +023h
    new-instance v5, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getName()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda9;
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda10;
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    invoke-direct v5, v0, v1, v2, v4, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;-><init>(Landroid/content/Context; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->show()V
    goto +bh
    iget-object v5, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    if-eqz v5, +005h
    invoke-interface v5, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;->onDirectorySelected(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismiss()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final handleNodeSelect$lambda$14$lambda$12(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda6;
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    const-string v3, "allow"
    invoke-virtual v0, v1, v3, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->submitAuthorizationResult(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final handleNodeSelect$lambda$14$lambda$12$lambda$11(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;->onDirectorySelected(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismiss()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final handleNodeSelect$lambda$14$lambda$13(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->clearSelection()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final handleOkClicked()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected()Z
    move-result v2
    if-eqz v2, -011h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    if-eqz v1, +00dh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;->onDirectorySelected(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismiss()V
    goto +15h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_please_select I
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final initViews(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_directory I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_add_folder I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->btnAddFolder Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_empty_state I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->tvEmptyState Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_loading I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->progressLoading Landroid/view/View;
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const/4 v0, 0
    if-nez v3, +009h
    const-string/jumbo v3, titleBar
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda11;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    invoke-virtual v3, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->btnAddFolder Landroid/widget/Button;
    if-nez v3, +008h
    const-string v3, "btnAddFolder"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    new-instance v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda1;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    invoke-virtual v0, v3, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final initViews$lambda$5(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->useFlowRouteBack()Z
    move-result v1
    if-eqz v1, +013h
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +006h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->onRouteBack()Z
    goto +8h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismiss()V
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismiss()V
    return-void 
.end method

.method private static final initViews$lambda$6(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleAddNewFolderClicked()V
    return-void 
.end method

.method private final observeEvents()void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeState()void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeState$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreateDialog$lambda$0(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->useFlowRouteBack()Z
    move-result v1
    if-nez v1, +010h
    const/4 v1, 4
    if-ne v2, v1, +00dh
    invoke-virtual v3, Landroid/view/KeyEvent;->getAction()I
    move-result v1
    const/4 v2, 1
    if-ne v1, v2, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismissAllowingStateLoss()V
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private static final onCreateDialog$lambda$3(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  android.content.DialogInterface)void
    .registers 7
    # ins_size=2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    sget v0, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v6, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v6
    if-eqz v6, +036h
    const v0, 17170445
    invoke-virtual v6, v0, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v6, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-double v1, v5
    const-wide v3, 4606281698874543309
    mul-double/2addr v1, v3
    double-to-int v5, v1
    invoke-virtual v6, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    iput v5, v1, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v6, v1, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v5, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v5, 3
    invoke-virtual v0, v5, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v5, 1
    invoke-virtual v0, v5, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    const/4 v5, 0
    invoke-virtual v6, v5, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-void 
.end method

.method private final setupRecyclerView()void
    .registers 6
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda3;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    new-instance v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda4;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda5;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->adapter Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    const-string v1, "recyclerView"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-direct v3, v4, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v0, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v1, v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->adapter Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    if-nez v1, +008h
    const-string v1, "adapter"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    return-void 
.end method

.method private static final setupRecyclerView$lambda$10(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "placeholderId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v1
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cancelNewFolder(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupRecyclerView$lambda$7(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "node"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleNodeClick(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupRecyclerView$lambda$8(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  com.bytedance.trae.conversation.devices.DirectoryNode)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "node"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->handleNodeSelect(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupRecyclerView$lambda$9(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "placeholderId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v1
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->onNewFolderNameConfirmed(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final useFlowRouteBack()boolean
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    const-string v3, "arg_use_flow_route_back"
    invoke-virtual v0, v3, v2, Landroid/os/Bundle;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    if-nez v0, +003h
    move v1, v2
    xor-int/lit8 v0, v1, 1
    return v0
.end method

.method public onAttach(android.content.Context)void
    .registers 5
    # ins_size=2
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onAttach(Landroid/content/Context;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    if-nez v0, +01ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    goto +2h
    move-object v0, v2
    if-nez v0, +00ah
    instance-of v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    if-eqz v0, +007h
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    goto +2h
    move-object v2, v0
    iput-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda7;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda8;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->fragment_directory_bottom_sheet I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public onDetach()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDetach()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v7, v8, v9, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_24 I
    invoke-virtual v9, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v9
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$onViewCreated$1;
    invoke-direct v0, v9, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$onViewCreated$1;-><init>(I)V
    check-cast v0, Landroid/view/ViewOutlineProvider;
    invoke-virtual v8, v0, Landroid/view/View;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    const/4 v9, 1
    invoke-virtual v8, v9, Landroid/view/View;->setClipToOutline(Z)V
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->initViews(Landroid/view/View;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setupRecyclerView()V
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->observeState()V
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->observeEvents()V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v8
    if-eqz v8, +010h
    const-string v9, "arg_chat_mode"
    invoke-virtual v8, v9, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +008h
    invoke-static v8, Lcom/bytedance/trae/conversation/widget/ChatMode;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v8
    if-nez v8, +004h
    sget-object v8, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v9
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v8, v0, +005h
    sget-object v8, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    sget-object v8, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->setChatMode(Lcom/bytedance/trae/im/service/Mode;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v8
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v9
    const/4 v0, 0
    if-eqz v9, +009h
    const-string v1, "arg_cli_id"
    invoke-virtual v9, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v0
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->setCliId(Ljava/lang/String;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v8
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v9
    if-eqz v9, +009h
    const-string v1, "arg_selected_directory"
    invoke-virtual v9, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v0
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->setPreselectedPath(Ljava/lang/String;)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->forceDocumentRootPath Ljava/lang/String;
    if-eqz v2, +010h
    iput-object v0, v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->forceDocumentRootPath Ljava/lang/String;
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v1
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->loadDocumentFolder$default(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; I Z I Ljava/lang/Object;)V
    goto +8h
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->getViewModel()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->loadInitialData()V
    return-void 
.end method

.method public final setOnDirectorySelectedListener(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$OnDirectorySelectedListener)void
    .registers 3
    # ins_size=2
    const-string v0, "l"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->listener Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    return-void 
.end method
