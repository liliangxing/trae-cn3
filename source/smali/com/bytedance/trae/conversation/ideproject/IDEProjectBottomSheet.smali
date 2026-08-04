# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "IDEProjectBottomSheet.kt"

.field private static final ARG_CLI_ID:Ljava/lang/String;
.field private static final ARG_PROJECT_ID:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private adapter:Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
.field private layoutEmpty:Landroid/view/View;
.field private onProjectSelected:Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
.field private progressLoading:Landroid/widget/ProgressBar;
.field private rvProjects:Landroidx/recyclerview/widget/RecyclerView;
.field private tvFooterHint:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$5rClju6lkMXb7rpximEmnNRIlWY(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  int  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->onCreateDialog$lambda$1(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; I Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$AViDlUly1Ds9Frm0tQqjzoURXGk(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MOa-qsdpS1DMnUo3gTQM6G5NN6I(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  com.bytedance.trae.conversation.network.ProjectItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; Lcom/bytedance/trae/conversation/network/ProjectItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->Companion Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    return-void 
.end method

.method public static final synthetic access$showContent(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->showContent(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$showEmpty(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->showEmpty()V
    return-void 
.end method

.method private final fetchProjects()void
    .registers 9
    # ins_size=1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +02eh
    const-string v1, "arg_cli_id"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +24h
    invoke-direct v8, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->showLoading()V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    const-string v2, "getViewLifecycleOwner(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;-><init>(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreateDialog$lambda$1(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  int  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->isAdded()Z
    move-result v1
    if-nez v1, +003h
    return-void 
    instance-of v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v1, +005h
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-void 
    sget v1, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v3, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    const v3, 17170445
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v3
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

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +006h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->onRouteBack()Z
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  com.bytedance.trae.conversation.network.ProjectItem)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "project"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->onProjectSelected Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
    if-eqz v1, +005h
    invoke-interface v1, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;->onProjectSelected(Lcom/bytedance/trae/conversation/network/ProjectItem;)V
    if-nez v0, +005h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->dismiss()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final showContent(java.util.List)void
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->progressLoading Landroid/widget/ProgressBar;
    const/16 v1, 8
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->rvProjects Landroidx/recyclerview/widget/RecyclerView;
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->layoutEmpty Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->tvFooterHint Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->adapter Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
    const-string v1, "adapter"
    const/4 v3, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->submitList(Ljava/util/List;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +009h
    const-string v4, "arg_project_id"
    invoke-virtual v0, v4, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v3
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +008h
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    const/4 v2, 1
    if-nez v2, +00eh
    iget-object v2, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->adapter Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->setSelectedProjectId(Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->trackPageView(Ljava/util/List;)V
    return-void 
.end method

.method private final showEmpty()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->progressLoading Landroid/widget/ProgressBar;
    const/16 v1, 8
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->rvProjects Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->layoutEmpty Landroid/view/View;
    if-eqz v0, +006h
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->tvFooterHint Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method private final showLoading()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->progressLoading Landroid/widget/ProgressBar;
    if-eqz v0, +006h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->rvProjects Landroidx/recyclerview/widget/RecyclerView;
    const/16 v1, 8
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->layoutEmpty Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->tvFooterHint Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method private final trackPageView(java.util.List)void
    .registers 10
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v1
    check-cast v9, Ljava/lang/Iterable;
    instance-of v2, v9, Ljava/util/Collection;
    const/4 v3, 0
    if-eqz v2, +00dh
    move-object v4, v9
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v5, v3
    goto +26h
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    move v5, v3
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01ch
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/network/ProjectItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ProjectItem;->getWorkspaceType()Ljava/lang/String;
    move-result-object v6
    const-string v7, "multi_root"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, -016h
    add-int/lit8 v5, v5, 1
    if-gez v5, -01ah
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -1fh
    if-eqz v2, +00ch
    move-object v2, v9
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +26h
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01dh
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/ProjectItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ProjectItem;->getWorkspaceType()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, unsaved_multi_root
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -017h
    add-int/lit8 v3, v3, 1
    if-gez v3, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    invoke-virtual v0, v1, v5, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackIdeProjectPageView(I I I)V
    return-void 
.end method

.method public final getOnProjectSelected()com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$OnProjectSelectedListener
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->onProjectSelected Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
    return-object v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v5
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-double v0, v0
    const-wide v2, 4606281698874543309
    mul-double/2addr v0, v2
    double-to-int v0, v0
    new-instance v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; I)V
    invoke-virtual v5, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v5, Landroid/app/Dialog;
    return-object v5
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_ide_project I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/conversation/R$id;->progress_loading I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/ProgressBar;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->progressLoading Landroid/widget/ProgressBar;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->rv_projects I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->rvProjects Landroidx/recyclerview/widget/RecyclerView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->layout_empty I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->layoutEmpty Landroid/view/View;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tv_footer_hint I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->tvFooterHint Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
    new-instance v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->adapter Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->rvProjects Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +010h
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-direct v3, v0, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->rvProjects Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +011h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->adapter Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
    if-nez v3, +008h
    const-string v3, "adapter"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->fetchProjects()V
    return-void 
.end method

.method public final setOnProjectSelected(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$OnProjectSelectedListener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->onProjectSelected Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
    return-void 
.end method

.method public final setProjectSelected(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$OnProjectSelectedListener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->onProjectSelected Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
    return-void 
.end method
