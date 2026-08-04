# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public abstract Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "TraeCmpBottomSheetFragment.kt"

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$Companion;
.field public static final DEFAULT_SHEET_HEIGHT_RATIO:F
.field private behavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
.field private contentGestureStartedWhileScrolled:Z
.field private final sheetHeightRatio:F


.method public static synthetic $r8$lambda$nCGo16CvarxWgPVNOLnQgA7LNm0(com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->onContentGestureEnded$lambda$5(Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$q5q4HfR4DPwsEEtjqFY94LfSj8Q(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->onCreateDialog$lambda$4(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$vegUhLQGZlJBWYnaB0nAjAhLvek(com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->onCreateDialog$lambda$1(Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment; Landroid/content/DialogInterface; I Landroid/view/KeyEvent;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->Companion Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    const v0, 1064514355
    iput v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->sheetHeightRatio F
    return-void 
.end method

.method private final applyContentGestureState()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    const/4 v1, 1
    if-eqz v0, +008h
    iget-boolean v2, v4, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->contentGestureStartedWhileScrolled Z
    xor-int/2addr v2, v1
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    iget-boolean v0, v4, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->contentGestureStartedWhileScrolled Z
    if-eqz v0, +019h
    iget-object v0, v4, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    const/4 v2, 3
    const/4 v3, 0
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->getState()I
    move-result v0
    if-ne v0, v2, +003h
    goto +2h
    move v1, v3
    if-nez v1, +009h
    iget-object v0, v4, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method

.method private static final onContentGestureEnded$lambda$5(com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment)void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->contentGestureStartedWhileScrolled Z
    invoke-direct v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->applyContentGestureState()V
    return-void 
.end method

.method private static final onCreateDialog$lambda$1(com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    const/4 v1, 4
    if-ne v2, v1, +010h
    invoke-virtual v3, Landroid/view/KeyEvent;->getAction()I
    move-result v1
    const/4 v2, 1
    if-ne v1, v2, +009h
    invoke-virtual v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->onBackPressed()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private static final onCreateDialog$lambda$4(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    sget v3, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-nez v1, +003h
    return-void 
    new-instance v3, Landroid/graphics/drawable/ColorDrawable;
    const/4 v0, 0
    invoke-direct v3, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v3, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-float v3, v3
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getSheetHeightRatio()F
    move-result v0
    mul-float/2addr v3, v0
    float-to-int v3, v3
    invoke-virtual v1, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    iput v3, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v1
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v3, 3
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v3, 1
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    iput-object v1, v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    invoke-direct v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->applyContentGestureState()V
    return-void 
.end method

.method protected abstract createRootFragment()androidx.fragment.app.Fragment
    # abstract or native
.end method

.method public final dismissSafely()void
    .registers 3
    # ins_size=1
    invoke-static Landroid/os/Looper;->myLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +014h
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +01ah
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->isRemoving()Z
    move-result v0
    if-eqz v0, +003h
    goto +12h
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-eqz v0, +006h
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->dismissAllowingStateLoss()V
    goto +4h
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->dismiss()V
    return-void 
.end method

.method protected abstract getFragmentContainerId()int
    # abstract or native
.end method

.method protected getSheetHeightRatio()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->sheetHeightRatio F
    return v0
.end method

.method protected onBackPressed()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method protected onCmpSheetViewCreated(android.view.View  android.os.Bundle)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, view
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public final onContentGestureEnded()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;)V
    invoke-virtual v0, v1, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final onContentGestureStarted(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->contentGestureStartedWhileScrolled Z
    invoke-direct v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->applyContentGestureState()V
    return-void 
.end method

.method public final onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string/jumbo v0, null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    const/4 v0, 0
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setCanceledOnTouchOutside(Z)V
    new-instance v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V
    new-instance v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$$ExternalSyntheticLambda1;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public final onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/kmp/base/R$layout;->trae_fragment_cmp_bottom_sheet I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/kmp/base/R$id;->trae_cmp_fragment_container I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/FrameLayout;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getFragmentContainerId()I
    move-result v4
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->setId(I)V
    const-string v3, "also(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public final onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v3, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/kmp/base/R$dimen;->trae_cmp_sheet_corner_radius I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    new-instance v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$onViewCreated$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$onViewCreated$1;-><init>(I)V
    check-cast v1, Landroid/view/ViewOutlineProvider;
    invoke-virtual v4, v1, Landroid/view/View;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    const/4 v0, 1
    invoke-virtual v4, v0, Landroid/view/View;->setClipToOutline(Z)V
    if-nez v5, +019h
    invoke-virtual v3, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->getFragmentContainerId()I
    move-result v1
    invoke-virtual v3, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->createRootFragment()Landroidx/fragment/app/Fragment;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commit()I
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;->onCmpSheetViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    return-void 
.end method
