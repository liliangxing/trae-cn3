# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "PluginsBottomSheet.kt"

.field private static final ARG_CLI_ID:Ljava/lang/String;
.field private static final ARG_WORKSPACE_FOLDER:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;
.field private static final SHEET_HEIGHT_DP:I
.field private adapter:Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
.field private onPluginSelected:Lkotlin/jvm/functions/Function1;
.field private final viewModel$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$FUSYqVR5Kv__EUeC8Y7gmymVF6s(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onCreateDialog$lambda$1(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$I7o9YrmlbmHv0PsIz4oh1UmWtPg(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  com.bytedance.trae.conversation.network.PluginItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Lcom/bytedance/trae/conversation/network/PluginItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$JQEb32DEw2btuJguSqsLPRvbHPE(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fFEWDOqLEPiJdIt31kvLZ3rPPe8(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.view.View  androidx.recyclerview.widget.RecyclerView  java.util.List)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Landroid/view/View; Landroidx/recyclerview/widget/RecyclerView; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rnc-FtUK9kqf8jNbI794LJ-eW5A(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.view.View  androidx.recyclerview.widget.RecyclerView  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onViewCreated$lambda$5(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Landroid/view/View; Landroidx/recyclerview/widget/RecyclerView; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->Companion Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    move-object v0, v5
    check-cast v0, Landroidx/fragment/app/Fragment;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    const-class v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v2, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$2;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    new-instance v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/fragment/app/Fragment;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-static v0, v2, v3, v4, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment; Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->viewModel$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private final getViewModel()com.bytedance.trae.conversation.plugin.PluginsViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->viewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    return-object v0
.end method

.method private static final onCreateDialog$lambda$1(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    sget v3, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-eqz v1, +036h
    new-instance v3, Landroid/graphics/drawable/ColorDrawable;
    const/4 v0, 0
    invoke-direct v3, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v3, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/16 v3, 326
    int-to-float v3, v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v3, v2
    float-to-int v2, v3
    invoke-virtual v1, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iput v2, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, Landroid/widget/FrameLayout;->requestLayout()V
    check-cast v1, Landroid/view/View;
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v1
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v2, 3
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v2, 1
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  com.bytedance.trae.conversation.network.PluginItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "plugin"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onPluginSelected Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->dismiss()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.view.View  androidx.recyclerview.widget.RecyclerView  java.util.List)kotlin.Unit
    .registers 4
    # ins_size=4
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->adapter Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->updateData(Ljava/util/List;)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +00bh
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    const/4 v0, 0
    invoke-virtual v2, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.view.View  androidx.recyclerview.widget.RecyclerView  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-nez v3, +027h
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->getPlugins()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    const/4 v3, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v3
    goto +2h
    const/4 v0, 1
    if-eqz v0, +00ah
    invoke-virtual v1, v3, Landroid/view/View;->setVisibility(I)V
    const/16 v0, 8
    invoke-virtual v2, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final getOnPluginSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onPluginSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public getTheme()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$style;->Trae_BottomSheetDialog I
    return v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_plugins I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 7
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v4, v5, v6, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +009h
    const-string v2, "arg_cli_id"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->setCliId(Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +009h
    const-string v2, "arg_workspace_folder"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->setWorkspaceFolder(Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->loadPlugins()V
    sget v6, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->recycler_view I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->empty_state_container I
    invoke-virtual v5, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    new-instance v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;)V
    invoke-virtual v6, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v6, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
    invoke-direct v6, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;-><init>()V
    iput-object v6, v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->adapter Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
    new-instance v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;)V
    invoke-virtual v6, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->setOnItemClickListener(Lkotlin/jvm/functions/Function1;)V
    new-instance v6, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v6, v2, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v0, v6, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v6, v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->adapter Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
    if-nez v6, +008h
    const-string v6, "adapter"
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v6
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->getPlugins()Landroidx/lifecycle/LiveData;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v2, v4, v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Landroid/view/View; Landroidx/recyclerview/widget/RecyclerView;)V
    new-instance v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v6, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->isLoading()Landroidx/lifecycle/LiveData;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v2, v4, v5, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Landroid/view/View; Landroidx/recyclerview/widget/RecyclerView;)V
    new-instance v5, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v5, Landroidx/lifecycle/Observer;
    invoke-virtual v6, v1, v5, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method public final setOnPluginSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->onPluginSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method
