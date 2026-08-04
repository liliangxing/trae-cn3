# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "AccountSettingsBottomSheet.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private behavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
.field private final childFragmentLifecycleCallbacks:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;
.field private contentCanScrollUp:Z
.field private final scrollableViews:Ljava/util/Set;


.method public static synthetic $r8$lambda$4FiuSfROTUB38T8yb64KxYD1aJs(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  androidx.core.widget.NestedScrollView  int  int  int  int)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->installScrollGuards$lambda$3(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Landroidx/core/widget/NestedScrollView; I I I I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$AB_6dh0OoKveQkX3NBNfh1UJBMo(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  com.google.android.material.bottomsheet.BottomSheetDialog  int  android.content.DialogInterface)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->onCreateDialog$lambda$1(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Lcom/google/android/material/bottomsheet/BottomSheetDialog; I Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$CzHSX2l_h6VnF3xNacMiodFICcI(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->onCreateDialog$lambda$0(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Landroid/content/DialogInterface; I Landroid/view/KeyEvent;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->Companion Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->scrollableViews Ljava/util/Set;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)V
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->childFragmentLifecycleCallbacks Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;
    return-void 
.end method

.method public static final synthetic access$getBehavior$p(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)com.google.android.material.bottomsheet.BottomSheetBehavior
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    return-object v0
.end method

.method public static final synthetic access$getContentCanScrollUp$p(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->contentCanScrollUp Z
    return v0
.end method

.method public static final synthetic access$getScrollableViews$p(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)java.util.Set
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->scrollableViews Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$installScrollGuards(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->installScrollGuards(Landroid/view/View;)V
    return-void 
.end method

.method public static final synthetic access$updateHideable(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->updateHideable(Landroid/view/View;)V
    return-void 
.end method

.method private final applyContentScrollState()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    const/4 v1, 1
    if-eqz v0, +008h
    iget-boolean v2, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->contentCanScrollUp Z
    xor-int/2addr v2, v1
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    iget-boolean v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->contentCanScrollUp Z
    if-eqz v0, +019h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    const/4 v2, 3
    const/4 v3, 0
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->getState()I
    move-result v0
    if-ne v0, v2, +003h
    goto +2h
    move v1, v3
    if-nez v1, +009h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method

.method private final hasBackStack()boolean
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final installScrollGuards(android.view.View)void
    .registers 6
    # ins_size=2
    instance-of v0, v5, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +016h
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->registerScrollableView(Landroid/view/View;)V
    move-object v0, v5
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$installScrollGuards$1;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$installScrollGuards$1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->updateHideable(Landroid/view/View;)V
    goto +21h
    instance-of v0, v5, Landroidx/core/widget/NestedScrollView;
    if-eqz v0, +014h
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->registerScrollableView(Landroid/view/View;)V
    move-object v0, v5
    check-cast v0, Landroidx/core/widget/NestedScrollView;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)V
    invoke-virtual v0, v1, Landroidx/core/widget/NestedScrollView;->setOnScrollChangeListener(Landroidx/core/widget/NestedScrollView$OnScrollChangeListener;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->updateHideable(Landroid/view/View;)V
    goto +bh
    instance-of v0, v5, Landroid/widget/ScrollView;
    if-eqz v0, +008h
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->registerScrollableView(Landroid/view/View;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->updateHideable(Landroid/view/View;)V
    instance-of v0, v5, Landroid/view/ViewGroup;
    if-eqz v0, +01ah
    check-cast v5, Landroid/view/ViewGroup;
    invoke-virtual v5, Landroid/view/ViewGroup;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +011h
    invoke-virtual v5, v1, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    const-string v3, "getChildAt(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->installScrollGuards(Landroid/view/View;)V
    add-int/lit8 v1, v1, 1
    goto -10h
    return-void 
.end method

.method private static final installScrollGuards$lambda$3(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  androidx.core.widget.NestedScrollView  int  int  int  int)void
    .registers 6
    # ins_size=6
    const-string/jumbo v2, v
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/view/View;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->updateHideable(Landroid/view/View;)V
    return-void 
.end method

.method private static final onCreateDialog$lambda$0(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 5
    # ins_size=4
    const/4 v2, 4
    const/4 v0, 0
    if-ne v3, v2, +013h
    invoke-virtual v4, Landroid/view/KeyEvent;->getAction()I
    move-result v2
    const/4 v3, 1
    if-ne v2, v3, +00ch
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->hasBackStack()Z
    move-result v2
    if-eqz v2, +006h
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->popChildBackStack()V
    move v0, v3
    return v0
.end method

.method private static final onCreateDialog$lambda$1(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  com.google.android.material.bottomsheet.BottomSheetDialog  int  android.content.DialogInterface)void
    .registers 5
    # ins_size=4
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->isAdded()Z
    move-result v4
    if-eqz v4, +056h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getDialog()Landroid/app/Dialog;
    move-result-object v4
    if-eq v4, v2, +003h
    goto +4eh
    sget v4, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v2, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/FrameLayout;
    if-nez v2, +003h
    return-void 
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;
    const/4 v0, 0
    invoke-direct v4, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v4, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v4
    iput v3, v4, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v2, v4, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v2, Landroid/view/View;
    invoke-static v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v2, +005h
    invoke-virtual v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v2, +006h
    const/4 v3, 3
    invoke-virtual v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v2, +006h
    const/4 v3, 1
    invoke-virtual v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v2, +00ch
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onCreateDialog$2$1;
    invoke-direct v3, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onCreateDialog$2$1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)V
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;
    invoke-virtual v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setBottomSheetCallback(Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->applyContentScrollState()V
    return-void 
.end method

.method private final popChildBackStack()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v0, +006h
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method

.method private final registerScrollableView(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->scrollableViews Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    const/4 v0, 1
    invoke-static v3, v0, Landroidx/core/view/ViewCompat;->setNestedScrollingEnabled(Landroid/view/View; Z)V
    invoke-virtual v3, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;-><init>(Landroid/view/View; Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)V
    check-cast v1, Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    return-void 
.end method

.method private final updateHideable(android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->scrollableViews Ljava/util/Set;
    check-cast v5, Ljava/lang/Iterable;
    instance-of v0, v5, Ljava/util/Collection;
    const/4 v1, 0
    if-eqz v0, +00ch
    move-object v0, v5
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +25h
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01ch
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->isShown()Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +00bh
    const/4 v2, -1
    invoke-virtual v0, v2, Landroid/view/View;->canScrollVertically(I)Z
    move-result v0
    if-eqz v0, +004h
    move v0, v3
    goto +2h
    move v0, v1
    if-eqz v0, -01dh
    move v1, v3
    invoke-virtual v4, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->setContentCanScrollUp(Z)V
    return-void 
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
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->isAdded()Z
    move-result v0
    if-eqz v0, +01ah
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->isRemoving()Z
    move-result v0
    if-eqz v0, +003h
    goto +12h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-eqz v0, +006h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->dismissAllowingStateLoss()V
    goto +4h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->dismiss()V
    return-void 
.end method

.method public onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->childFragmentLifecycleCallbacks Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;
    check-cast v0, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
    const/4 v1, 0
    invoke-virtual v3, v0, v1, Landroidx/fragment/app/FragmentManager;->registerFragmentLifecycleCallbacks(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks; Z)V
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v5
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-virtual v5, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-double v0, v0
    const-wide v2, 4606732058837280358
    mul-double/2addr v0, v2
    double-to-int v0, v0
    const/4 v1, 0
    invoke-virtual v5, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setCanceledOnTouchOutside(Z)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)V
    invoke-virtual v5, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, v5, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Lcom/google/android/material/bottomsheet/BottomSheetDialog; I)V
    invoke-virtual v5, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v5, Landroid/app/Dialog;
    return-object v5
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_account_settings I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroy()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->childFragmentLifecycleCallbacks Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;
    check-cast v1, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->unregisterFragmentLifecycleCallbacks(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;)V
    invoke-super v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroy()V
    return-void 
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getDialog()Landroid/app/Dialog;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/app/Dialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setBottomSheetCallback(Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;)V
    iput-object v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->behavior Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->contentCanScrollUp Z
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->scrollableViews Ljava/util/Set;
    invoke-interface v0, Ljava/util/Set;->clear()V
    invoke-super v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$dimen;->trae_setting_corner_radius I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onViewCreated$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onViewCreated$1;-><init>(I)V
    check-cast v1, Landroid/view/ViewOutlineProvider;
    invoke-virtual v3, v1, Landroid/view/View;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    const/4 v0, 1
    invoke-virtual v3, v0, Landroid/view/View;->setClipToOutline(Z)V
    if-nez v4, +01bh
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$id;->settings_fragment_container I
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;->Companion Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-virtual v3, v4, v0, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentTransaction;->commit()I
    return-void 
.end method

.method public final setContentCanScrollUp(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->contentCanScrollUp Z
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->applyContentScrollState()V
    return-void 
.end method
