# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "ProcessDetailBottomSheet.kt"

.field private static final ARG_BLOCK_KEY:Ljava/lang/String;
.field private static final ARG_BLOCK_TYPE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private static final TYPE_AGENT_DETAIL:Ljava/lang/String;
.field private static final TYPE_TOOL_LIST:Ljava/lang/String;
.field private behavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method public static synthetic $r8$lambda$01SLRr0svRzQiiiyyIzf_CjSKL4(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->onCreateDialog$lambda$2(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$6dP-Rzs__Cx76wABUPvG-V7YfoE(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->onCreateDialog$lambda$0(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet; Landroid/content/DialogInterface; I Landroid/view/KeyEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$T7Kzw0nyO1FDxEkGvml4trdfcM4(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$bAimBgTBaGKwJpaxfGPiwwSg6H8(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xyu_YdNisMeglNMWeJDIH2cyPls(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->onViewCreated$lambda$5(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    return-void 
.end method

.method private final createInitialFragment()androidx.fragment.app.Fragment
    .registers 6
    # ins_size=1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +009h
    const-string v2, "block_type"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    const-string v2, ""
    if-nez v0, +003h
    move-object v0, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v3
    if-eqz v3, +009h
    const-string v4, "block_key"
    invoke-virtual v3, v4, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v1
    if-nez v3, +003h
    goto +2h
    move-object v2, v3
    const-string/jumbo v3, tool_list
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ch
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    goto +12h
    const-string v3, "agent_detail"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00bh
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    return-object v1
.end method

.method private static final onCreateDialog$lambda$0(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 5
    # ins_size=4
    const/4 v2, 4
    const/4 v0, 0
    if-ne v3, v2, +01bh
    invoke-virtual v4, Landroid/view/KeyEvent;->getAction()I
    move-result v2
    const/4 v3, 1
    if-ne v2, v3, +014h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v2
    if-lez v2, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    move v0, v3
    return v0
.end method

.method private static final onCreateDialog$lambda$2(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.content.DialogInterface)void
    .registers 7
    # ins_size=3
    sget v6, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v4, v6, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/FrameLayout;
    if-eqz v4, +045h
    new-instance v6, Landroid/graphics/drawable/ColorDrawable;
    const/4 v0, 0
    invoke-direct v6, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v6, Landroid/graphics/drawable/Drawable;
    invoke-virtual v4, v6, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-double v0, v6
    const-wide v2, 4606281698874543309
    mul-double/2addr v0, v2
    double-to-int v6, v0
    invoke-virtual v4, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    iput v6, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Landroid/view/View;
    invoke-static v4, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v4
    iput-object v4, v5, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v4, +005h
    invoke-virtual v4, v6, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v4, +006h
    const/4 v6, 3
    invoke-virtual v4, v6, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v4, +006h
    const/4 v5, 1
    invoke-virtual v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v1
    if-lez v1, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->updateBackButtonVisibility()V
    return-void 
.end method

.method private final updateBackButtonVisibility()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setLeftActionVisible(Z)V
    return-void 
.end method

.method public final navigateTo(androidx.fragment.app.Fragment)void
    .registers 7
    # ins_size=2
    const-string v0, "fragment"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_in_right I
    sget v2, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_out_left I
    sget v3, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_in_left I
    sget v4, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_out_right I
    invoke-virtual v0, v1, v2, v3, v4, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->detail_fragment_container I
    invoke-virtual v0, v1, v6, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v6
    const/4 v0, 0
    invoke-virtual v6, v0, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v6
    invoke-virtual v6, Landroidx/fragment/app/FragmentTransaction;->commit()I
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
    const/4 v0, 1
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setCanceledOnTouchOutside(Z)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_process_detail I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->clear()V
    return-void 
.end method

.method public onDismiss(android.content.DialogInterface)void
    .registers 3
    # ins_size=2
    const-string v0, "dialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDismiss(Landroid/content/DialogInterface;)V
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->clear()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 7
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v4, v5, v6, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_24 I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$onViewCreated$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$onViewCreated$1;-><init>(I)V
    check-cast v1, Landroid/view/ViewOutlineProvider;
    invoke-virtual v5, v1, Landroid/view/View;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    const/4 v0, 1
    invoke-virtual v5, v0, Landroid/view/View;->setClipToOutline(Z)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v5, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v5, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;)V
    invoke-virtual v5, v0, Landroidx/fragment/app/FragmentManager;->addOnBackStackChangedListener(Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;)V
    if-nez v6, +025h
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->createInitialFragment()Landroidx/fragment/app/Fragment;
    move-result-object v5
    if-eqz v5, +01fh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v6
    invoke-virtual v6, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v6
    sget v0, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_in_right I
    sget v1, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_out_left I
    sget v2, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_in_left I
    sget v3, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_out_right I
    invoke-virtual v6, v0, v1, v2, v3, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v6
    sget v0, Lcom/bytedance/trae/conversation/R$id;->detail_fragment_container I
    invoke-virtual v6, v0, v5, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v5
    invoke-virtual v5, Landroidx/fragment/app/FragmentTransaction;->commit()I
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->updateBackButtonVisibility()V
    return-void 
.end method

.method public final setTitle(java.lang.String)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v0, +007h
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    return-void 
.end method
