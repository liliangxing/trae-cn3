# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "BranchSelectBottomSheet.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private adapter:Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
.field private branchItems:Ljava/util/List;
.field private btnGoToGithub:Landroid/widget/TextView;
.field private contentView:Landroid/view/View;
.field private emptyStateView:Landroid/view/View;
.field private fullBranchItems:Ljava/util/List;
.field private gitViewModel:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
.field private isLoadingMore:Z
.field private isSearching:Z
.field private onBranchSelected:Lkotlin/jvm/functions/Function1;
.field private searchJob:Lkotlinx/coroutines/Job;
.field private selectedBranchId:Ljava/lang/String;
.field private tvSearchEmpty:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$Ax4vKtlleHXhUGkuwyElgnYM3BM(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onCreateDialog$lambda$1(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$EhJdgZVRvPELqclRhcdkSyfzUQU(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  androidx.recyclerview.widget.RecyclerView  kotlin.jvm.internal.Ref$ObjectRef  java.util.List)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$6(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IB5kFvckaliquMHuzNpAoDXq2ys(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.widget.ProgressBar  java.lang.Boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$12(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/widget/ProgressBar; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$KNLSLGQZue8SIlMEwAlY_tj4Xbo(kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  com.bytedance.trae.conversation.git.BranchItem)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$3(Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Lcom/bytedance/trae/conversation/git/BranchItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$OcsO-RLTHods7FyMzzc8AKkuFS0(android.widget.EditText  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$4(Landroid/widget/EditText; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$QpbHQUQcVoYC3IS6CX4bXpC3Xms(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fBANrBdpetf-6mE2rCduQ_UJ-CY(android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$7(Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gTgPf_GtAbeasQp4EmC9--WniKA(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  kotlin.jvm.internal.Ref$ObjectRef  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$14(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ruymjyXp4D9Z_e2Ojc3r8gOyg0E(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  kotlin.jvm.internal.Ref$ObjectRef  java.util.List)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$10(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$zDp5JSLNyNqFhTUnXWqAFg6eofs(android.widget.ProgressBar  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onViewCreated$lambda$11(Landroid/widget/ProgressBar; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->fullBranchItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)com.bytedance.trae.conversation.git.BranchItemAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    return-object v0
.end method

.method public static final synthetic access$getBranchItems$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getFullBranchItems$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->fullBranchItems Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getGitViewModel$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)com.bytedance.trae.conversation.git.GitSelectionViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    return-object v0
.end method

.method public static final synthetic access$getSearchJob$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->searchJob Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method public static final synthetic access$getTvSearchEmpty$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$isLoadingMore$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->isLoadingMore Z
    return v0
.end method

.method public static final synthetic access$isSearching$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->isSearching Z
    return v0
.end method

.method public static final synthetic access$setBranchItems$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setSearchJob$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->searchJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setSearching$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->isSearching Z
    return-void 
.end method

.method public static final synthetic access$setSelectedBranchId$p(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->selectedBranchId Ljava/lang/String;
    return-void 
.end method

.method private static final onCreateDialog$lambda$1(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    sget v3, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +031h
    const v3, 17170445
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->heightPixels I
    mul-int/lit8 v2, v2, 9
    div-int/lit8 v2, v2, 10
    invoke-virtual v3, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v0, 3
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v1, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iput v2, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$10(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  kotlin.jvm.internal.Ref$ObjectRef  java.util.List)kotlin.Unit
    .registers 14
    # ins_size=5
    iget-object v0, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "gitViewModel"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getBranchLoading()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    const/16 v0, 8
    invoke-virtual v10, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-interface v13, Ljava/util/List;->isEmpty()Z
    move-result v10
    const/4 v2, 0
    if-eqz v10, +012h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->contentView Landroid/view/View;
    if-eqz v10, +005h
    invoke-virtual v10, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v9, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->emptyStateView Landroid/view/View;
    if-eqz v9, +08dh
    invoke-virtual v9, v2, Landroid/view/View;->setVisibility(I)V
    goto/16 +088h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->emptyStateView Landroid/view/View;
    if-eqz v10, +005h
    invoke-virtual v10, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->contentView Landroid/view/View;
    if-eqz v10, +005h
    invoke-virtual v10, v2, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v11, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    if-eqz v10, +005h
    invoke-virtual v10, v0, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->selectedBranchId Ljava/lang/String;
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v13, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    const/16 v0, 10
    invoke-static v13, v0, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v0
    invoke-direct v11, v0, Ljava/util/ArrayList;-><init>(I)V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01fh
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v3, 0
    const/4 v4, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const/4 v6, 0
    const/16 v7, 11
    const/4 v8, 0
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/conversation/git/BranchItem;->copy$default(Lcom/bytedance/trae/conversation/git/BranchItem; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/BranchItem;
    move-result-object v0
    invoke-interface v11, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -22h
    check-cast v11, Ljava/util/List;
    iput-object v11, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    iput-object v11, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->fullBranchItems Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +010h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v13, v11
    check-cast v13, Lcom/bytedance/trae/conversation/git/BranchItem;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/git/BranchItem;->isSelected()Z
    move-result v13
    if-eqz v13, -011h
    goto +2h
    move-object v11, v1
    iput-object v11, v12, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    if-nez v10, +008h
    const-string v10, "adapter"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v10
    iget-object v9, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    invoke-virtual v1, v9, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;->submitList(Ljava/util/List;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method private static final onViewCreated$lambda$11(android.widget.ProgressBar  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->emptyStateView Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$12(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.widget.ProgressBar  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->isLoadingMore Z
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v2, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$14(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  kotlin.jvm.internal.Ref$ObjectRef  java.util.List)kotlin.Unit
    .registers 13
    # ins_size=3
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v12
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +069h
    iget-boolean v0, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->isSearching Z
    if-nez v0, +065h
    iget-object v11, v11, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v0, 0
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v0
    check-cast v12, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v12, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01fh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    const/4 v7, 0
    const/16 v8, 11
    const/4 v9, 0
    invoke-static/range v3 ... v9, Lcom/bytedance/trae/conversation/git/BranchItem;->copy$default(Lcom/bytedance/trae/conversation/git/BranchItem; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/BranchItem;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -22h
    check-cast v1, Ljava/util/List;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    check-cast v11, Ljava/util/Collection;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v11, v1, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v11
    iput-object v11, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->fullBranchItems Ljava/util/List;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    if-nez v11, +008h
    const-string v11, "adapter"
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v11
    iget-object v10, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    invoke-virtual v0, v10, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;->submitList(Ljava/util/List;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.view.View)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v3
    const-string v0, "android.intent.action.VIEW"
    if-eqz v3, +011h
    new-instance v3, Landroid/content/Intent;
    const-string v1, "https://code.byted.org/repository/new"
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-direct v3, v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->startActivity(Landroid/content/Intent;)V
    goto +fh
    new-instance v3, Landroid/content/Intent;
    const-string v1, "https://github.com"
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-direct v3, v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
    :try_start_0xa
.end method

.method private static final onViewCreated$lambda$3(kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  com.bytedance.trae.conversation.git.BranchItem)kotlin.Unit
    .registers 5
    # ins_size=3
    const-string v0, "branch"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v0, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00ah
    iget-object v2, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onBranchSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +00dh
    invoke-interface v2, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +8h
    iget-object v2, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onBranchSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +005h
    invoke-interface v2, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->dismiss()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onViewCreated$lambda$4(android.widget.EditText  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    return-void 
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  androidx.recyclerview.widget.RecyclerView  kotlin.jvm.internal.Ref$ObjectRef  java.util.List)kotlin.Unit
    .registers 13
    # ins_size=4
    iget-boolean v0, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->isSearching Z
    if-eqz v0, +07ah
    invoke-interface v12, Ljava/util/List;->isEmpty()Z
    move-result v0
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v0, +00dh
    invoke-virtual v10, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    if-eqz v10, +010h
    invoke-virtual v10, v2, Landroid/widget/TextView;->setVisibility(I)V
    goto +bh
    invoke-virtual v10, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    if-eqz v10, +005h
    invoke-virtual v10, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v10, v11, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v11, 0
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v11
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
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
    if-eqz v1, +01fh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/git/BranchItem;
    const/4 v3, 0
    const/4 v4, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const/4 v6, 0
    const/16 v7, 11
    const/4 v8, 0
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/conversation/git/BranchItem;->copy$default(Lcom/bytedance/trae/conversation/git/BranchItem; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/BranchItem;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -22h
    check-cast v0, Ljava/util/List;
    iput-object v0, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    if-nez v10, +008h
    const-string v10, "adapter"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v11, v10
    iget-object v9, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->branchItems Ljava/util/List;
    invoke-virtual v11, v9, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;->submitList(Ljava/util/List;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method private static final onViewCreated$lambda$7(android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  com.bytedance.trae.conversation.git.BranchSelectBottomSheet  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-eqz v3, +020h
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    const/16 v0, 8
    invoke-virtual v1, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->emptyStateView Landroid/view/View;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->contentView Landroid/view/View;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final getOnBranchSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onBranchSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda9;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda9;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_branch_select I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 12
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v9, v10, v11, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v11, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v11, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-virtual v11, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iput-object v11, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    sget v11, Lcom/bytedance/trae/conversation/R$id;->rv_branches I
    invoke-virtual v10, v11, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v11
    check-cast v11, Landroidx/recyclerview/widget/RecyclerView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v10, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_loading_more I
    invoke-virtual v10, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ProgressBar;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v10, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/ProgressBar;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->et_search I
    invoke-virtual v10, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/EditText;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->iv_search_clear I
    invoke-virtual v10, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/ImageView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tv_search_empty I
    invoke-virtual v10, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->layout_empty_state I
    invoke-virtual v10, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    iput-object v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->emptyStateView Landroid/view/View;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->layout_content I
    invoke-virtual v10, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    iput-object v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->contentView Landroid/view/View;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_go_to_github I
    invoke-virtual v10, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    sget-object v5, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v5, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v5
    if-eqz v5, +00ch
    iget-object v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    if-eqz v5, +011h
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_go_to_bits_code I
    invoke-virtual v5, v6, Landroid/widget/TextView;->setText(I)V
    goto +ah
    iget-object v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    if-eqz v5, +007h
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_go_to_github I
    invoke-virtual v5, v6, Landroid/widget/TextView;->setText(I)V
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tv_empty_hint I
    invoke-virtual v10, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    check-cast v10, Landroid/widget/TextView;
    sget-object v5, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v5, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v5
    if-eqz v5, +00ah
    if-eqz v10, +00fh
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_bits_code_branch_empty_hint I
    invoke-virtual v10, v5, Landroid/widget/TextView;->setText(I)V
    goto +8h
    if-eqz v10, +007h
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_repo_empty_hint I
    invoke-virtual v10, v5, Landroid/widget/TextView;->setText(I)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    if-eqz v10, +00ah
    new-instance v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)V
    invoke-virtual v10, v5, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v10, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v10, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    const/4 v5, 0
    invoke-virtual v2, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    const/16 v6, 8
    invoke-virtual v11, v6, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v7, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->contentView Landroid/view/View;
    if-eqz v7, +005h
    invoke-virtual v7, v6, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionsVisible(Z)V
    new-instance v0, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-direct v0, v5, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    move-object v5, v0
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v11, v5, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    new-instance v5, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    new-instance v6, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v6, v10, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    iput-object v5, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v11, v5, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    new-instance v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v5, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda2;-><init>(Landroid/widget/EditText;)V
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;
    invoke-direct v5, v4, v9, v11, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$4;-><init>(Landroid/widget/ImageView; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    check-cast v5, Landroid/text/TextWatcher;
    invoke-virtual v3, v5, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const/4 v4, 0
    const-string v5, "gitViewModel"
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getBranchSearchResult()Landroidx/lifecycle/LiveData;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v7, v9, v11, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    new-instance v8, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v8, v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v8, Landroidx/lifecycle/Observer;
    invoke-virtual v3, v6, v8, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->fetchBranchesFromServer()V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getBranchLoading()Landroidx/lifecycle/LiveData;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v7, v2, v11, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;-><init>(Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)V
    new-instance v8, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v8, v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v8, Landroidx/lifecycle/Observer;
    invoke-virtual v3, v6, v8, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getBranchRefreshResult()Landroidx/lifecycle/LiveData;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;
    invoke-direct v7, v9, v2, v11, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    new-instance v8, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v8, v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v8, Landroidx/lifecycle/Observer;
    invoke-virtual v3, v6, v8, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getBranchLoadError()Landroidx/lifecycle/LiveData;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda6;
    invoke-direct v7, v2, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda6;-><init>(Landroid/widget/ProgressBar; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)V
    new-instance v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v2, v7, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v2, Landroidx/lifecycle/Observer;
    invoke-virtual v3, v6, v2, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    new-instance v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$9;
    invoke-direct v2, v0, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$onViewCreated$9;-><init>(Landroidx/recyclerview/widget/LinearLayoutManager; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;)V
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v11, v2, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v11, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v4
    invoke-virtual v11, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getBranchLoadingMore()Landroidx/lifecycle/LiveData;
    move-result-object v11
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda7;
    invoke-direct v2, v9, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/widget/ProgressBar;)V
    new-instance v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Landroidx/lifecycle/Observer;
    invoke-virtual v11, v0, v1, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v11, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getBranchLoadMoreResult()Landroidx/lifecycle/LiveData;
    move-result-object v11
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda8;
    invoke-direct v1, v9, v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    new-instance v10, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v10, Landroidx/lifecycle/Observer;
    invoke-virtual v11, v0, v10, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method public final setOnBranchSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->onBranchSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method
