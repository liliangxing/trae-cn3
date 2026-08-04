# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
.super Landroidx/fragment/app/Fragment;
.source "OnboardingFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;
.field private static final KEVA_REPO:Ljava/lang/String;
.field private static final KEY_SHOWN:Ljava/lang/String;
.field private barColor:I
.field private btnAction:Landroid/widget/TextView;
.field private currentPage:I
.field private final exposedPositions:Ljava/util/Set;
.field private final indicators:Ljava/util/List;
.field private onFinished:Lkotlin/jvm/functions/Function0;
.field private final pages:Ljava/util/List;
.field private viewPager:Landroidx/viewpager2/widget/ViewPager2;


.method public static synthetic $r8$lambda$9OKxVf75o39dekGAZAbqBuf-axE(com.bytedance.trae.home.onboarding.OnboardingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->onViewCreated$lambda$10(Lcom/bytedance/trae/home/onboarding/OnboardingFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->Companion Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 15
    # ins_size=1
    invoke-direct v14, Landroidx/fragment/app/Fragment;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v14, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->indicators Ljava/util/List;
    const/4 v0, -1
    iput v0, v14, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->barColor I
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    iput-object v0, v14, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->exposedPositions Ljava/util/Set;
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    new-instance v7, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    sget v2, Lcom/bytedance/trae/home/R$string;->onboarding_title_normal_1 I
    sget v3, Lcom/bytedance/trae/home/R$string;->onboarding_title_italic_1 I
    sget v4, Lcom/bytedance/trae/home/R$drawable;->onboarding_page_1 I
    sget v5, Lcom/bytedance/trae/home/R$string;->onboarding_btn_continue I
    const/4 v6, 0
    move-object v1, v7
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;-><init>(I I I I Z)V
    const/4 v1, 0
    aput-object v7, v0, v1
    new-instance v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    sget v9, Lcom/bytedance/trae/home/R$string;->onboarding_title_normal_2 I
    sget v10, Lcom/bytedance/trae/home/R$string;->onboarding_title_italic_2 I
    sget v11, Lcom/bytedance/trae/home/R$drawable;->onboarding_page_2 I
    sget v12, Lcom/bytedance/trae/home/R$string;->onboarding_btn_continue I
    const/4 v13, 0
    move-object v8, v1
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;-><init>(I I I I Z)V
    const/4 v2, 1
    aput-object v1, v0, v2
    new-instance v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    sget v4, Lcom/bytedance/trae/home/R$string;->onboarding_title_normal_3 I
    sget v5, Lcom/bytedance/trae/home/R$string;->onboarding_title_italic_3 I
    sget v6, Lcom/bytedance/trae/home/R$drawable;->onboarding_page_3 I
    sget v7, Lcom/bytedance/trae/home/R$string;->onboarding_btn_lets_go I
    const/4 v8, 1
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;-><init>(I I I I Z)V
    const/4 v2, 2
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->pages Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getBtnAction$p(com.bytedance.trae.home.onboarding.OnboardingFragment)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getCurrentPage$p(com.bytedance.trae.home.onboarding.OnboardingFragment)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->currentPage I
    return v0
.end method

.method public static final synthetic access$getExposedPositions$p(com.bytedance.trae.home.onboarding.OnboardingFragment)java.util.Set
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->exposedPositions Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getPages$p(com.bytedance.trae.home.onboarding.OnboardingFragment)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->pages Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$setCurrentPage$p(com.bytedance.trae.home.onboarding.OnboardingFragment  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->currentPage I
    return-void 
.end method

.method public static final synthetic access$updateButtonStyle(com.bytedance.trae.home.onboarding.OnboardingFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->updateButtonStyle(Z)V
    return-void 
.end method

.method public static final synthetic access$updateIndicator(com.bytedance.trae.home.onboarding.OnboardingFragment  int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->updateIndicator(I)V
    return-void 
.end method

.method private static final onViewCreated$lambda$10(com.bytedance.trae.home.onboarding.OnboardingFragment  android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v5, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    const/4 v0, 0
    const-string/jumbo v1, viewPager
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    invoke-virtual v5, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I
    move-result v5
    iget-object v2, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->pages Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    const/4 v3, 1
    sub-int/2addr v2, v3
    if-ge v5, v2, +010h
    iget-object v4, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v4
    add-int/2addr v5, v3
    invoke-virtual v0, v5, v3, Landroidx/viewpager2/widget/ViewPager2;->setCurrentItem(I Z)V
    goto +dh
    sget-object v5, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->Companion Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;->markShown()V
    iget-object v4, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->onFinished Lkotlin/jvm/functions/Function0;
    if-eqz v4, +005h
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final updateBarColor()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +081h
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getWindow()Landroid/view/Window;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    iget v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->barColor I
    const/4 v2, -1
    const/high16 v3, -2147483648
    if-eq v1, v2, +030h
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/view/Window;->clearFlags(I)V
    if-eqz v0, +014h
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v1, Landroid/content/Context;
    iget v2, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->barColor I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/view/Window;->setStatusBarColor(I)V
    if-eqz v0, +053h
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v1, Landroid/content/Context;
    iget v2, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->barColor I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/view/Window;->setNavigationBarColor(I)V
    goto +3fh
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/view/Window;->addFlags(I)V
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/home/R$color;->onboarding_bg I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    iput v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->barColor I
    if-eqz v0, +014h
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/home/R$color;->onboarding_bg I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/view/Window;->setStatusBarColor(I)V
    if-eqz v0, +014h
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/home/R$color;->onboarding_bg I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/view/Window;->setNavigationBarColor(I)V
    return-void 
    :try_start_0x6
.end method

.method private final updateButtonStyle(boolean)void
    .registers 6
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    const/4 v1, 0
    const-string v2, "btnAction"
    if-eqz v5, +026h
    iget-object v5, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    sget v3, Lcom/bytedance/trae/home/R$color;->onboarding_btn_text_dark I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v5, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v5, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    sget v5, Lcom/bytedance/trae/home/R$drawable;->onboarding_btn_dark I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v5
    invoke-virtual v1, v5, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    goto +24h
    iget-object v5, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    sget v3, Lcom/bytedance/trae/home/R$color;->onboarding_btn_text_light I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v5, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v5, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    sget v5, Lcom/bytedance/trae/home/R$drawable;->onboarding_btn_light I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v5
    invoke-virtual v1, v5, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-void 
.end method

.method private final updateIndicator(int)void
    .registers 10
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v8, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    iget-object v2, v8, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->indicators Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->size()I
    move-result v2
    const/4 v3, 0
    if-ge v3, v2, +059h
    iget-object v4, v8, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->indicators Ljava/util/List;
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Landroid/view/View;
    const/4 v5, 2
    const-string v6, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
    if-ne v3, v9, +026h
    sget v7, Lcom/bytedance/trae/home/R$drawable;->onboarding_indicator_active I
    invoke-static v0, v7, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v7
    invoke-virtual v4, v7, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v4, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v7
    invoke-static v7, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v6, 32
    int-to-float v6, v6
    mul-float/2addr v6, v1
    float-to-int v6, v6
    iput v6, v7, Landroid/widget/LinearLayout$LayoutParams;->width I
    int-to-float v5, v5
    mul-float/2addr v5, v1
    float-to-int v5, v5
    iput v5, v7, Landroid/widget/LinearLayout$LayoutParams;->height I
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v7, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    goto +24h
    sget v7, Lcom/bytedance/trae/home/R$drawable;->onboarding_indicator_inactive I
    invoke-static v0, v7, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v7
    invoke-virtual v4, v7, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v4, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v7
    invoke-static v7, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v6, 8
    int-to-float v6, v6
    mul-float/2addr v6, v1
    float-to-int v6, v6
    iput v6, v7, Landroid/widget/LinearLayout$LayoutParams;->width I
    int-to-float v5, v5
    mul-float/2addr v5, v1
    float-to-int v5, v5
    iput v5, v7, Landroid/widget/LinearLayout$LayoutParams;->height I
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v7, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    add-int/lit8 v3, v3, 1
    goto -58h
    return-void 
.end method

.method public final getOnFinished()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->onFinished Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 15
    # ins_size=4
    const-string v13, "inflater"
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->requireContext()Landroid/content/Context;
    move-result-object v12
    const-string/jumbo v13, requireContext(...)
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    invoke-virtual v13, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v13
    iget v13, v13, Landroid/util/DisplayMetrics;->density F
    invoke-direct v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->updateBarColor()V
    new-instance v14, Landroid/widget/FrameLayout;
    invoke-direct v14, v12, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    sget v0, Lcom/bytedance/trae/home/R$color;->onboarding_bg I
    invoke-static v12, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v14, v0, Landroid/widget/FrameLayout;->setBackgroundColor(I)V
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;
    const/4 v1, -1
    invoke-direct v0, v1, v1, Landroid/view/ViewGroup$LayoutParams;-><init>(I I)V
    invoke-virtual v14, v0, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroidx/viewpager2/widget/ViewPager2;
    invoke-direct v0, v12, Landroidx/viewpager2/widget/ViewPager2;-><init>(Landroid/content/Context;)V
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v2
    invoke-virtual v0, v2, Landroidx/viewpager2/widget/ViewPager2;->setId(I)V
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v2, v1, v1, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroidx/viewpager2/widget/ViewPager2;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v0, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    new-instance v2, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;
    iget-object v3, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->pages Ljava/util/List;
    invoke-direct v2, v3, v13, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;-><init>(Ljava/util/List; F)V
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v2, Landroidx/viewpager2/widget/ViewPager2;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v0, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    const/4 v2, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewPager
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    invoke-virtual v14, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 1
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v4, 80
    const/4 v5, -2
    invoke-direct v3, v1, v5, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    const/16 v1, 58
    int-to-float v1, v1
    mul-float/2addr v1, v13
    float-to-int v1, v1
    iput v1, v3, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin I
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 0
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v4, 17
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 24
    int-to-float v5, v5
    mul-float/2addr v5, v13
    float-to-int v5, v5
    iput v5, v6, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v6, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v5, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->pages Ljava/util/List;
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->size()I
    move-result v5
    move v6, v3
    const/4 v7, 2
    if-ge v6, v5, +036h
    new-instance v8, Landroid/view/View;
    invoke-direct v8, v12, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v9, Lcom/bytedance/trae/home/R$drawable;->onboarding_indicator_inactive I
    invoke-static v12, v9, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v9
    invoke-virtual v8, v9, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v10, 8
    int-to-float v10, v10
    mul-float/2addr v10, v13
    float-to-int v10, v10
    int-to-float v7, v7
    mul-float/2addr v7, v13
    float-to-int v7, v7
    invoke-direct v9, v10, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    if-lez v6, +009h
    const/4 v7, 4
    int-to-float v7, v7
    mul-float/2addr v7, v13
    float-to-int v7, v7
    invoke-virtual v9, v7, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v9, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v7, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->indicators Ljava/util/List;
    invoke-interface v7, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v1, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    add-int/lit8 v6, v6, 1
    goto -36h
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iget-object v12, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->pages Ljava/util/List;
    invoke-interface v12, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    invoke-virtual v12, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->getButtonTextResId()I
    move-result v12
    invoke-virtual v11, v12, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getString(I)Ljava/lang/String;
    move-result-object v12
    check-cast v12, Ljava/lang/CharSequence;
    invoke-virtual v1, v12, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v12, 1099431936
    invoke-virtual v1, v7, v12, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v12, sans-serif-medium
    invoke-static v12, v3, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v12
    invoke-virtual v1, v12, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v1, v4, Landroid/widget/TextView;->setGravity(I)V
    const v12, -1127271012
    invoke-virtual v1, v12, Landroid/widget/TextView;->setLetterSpacing(F)V
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v4, 345
    int-to-float v4, v4
    mul-float/2addr v4, v13
    float-to-int v4, v4
    const/16 v5, 48
    int-to-float v5, v5
    mul-float/2addr v5, v13
    float-to-int v13, v5
    invoke-direct v12, v4, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v12, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v1, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    invoke-direct v11, v3, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->updateButtonStyle(Z)V
    iget-object v12, v11, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    if-nez v12, +008h
    const-string v12, "btnAction"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v12
    check-cast v2, Landroid/view/View;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v14, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    check-cast v14, Landroid/view/View;
    return-object v14
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, v4, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    const/4 v3, 0
    invoke-direct v2, v3, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->updateIndicator(I)V
    iget-object v4, v2, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->exposedPositions Ljava/util/Set;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v4, v0, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +015h
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "position"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v3, "onboarding_page_view"
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    const/4 v4, 0
    if-nez v3, +009h
    const-string/jumbo v3, viewPager
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    new-instance v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;-><init>(Lcom/bytedance/trae/home/onboarding/OnboardingFragment;)V
    check-cast v0, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;
    invoke-virtual v3, v0, Landroidx/viewpager2/widget/ViewPager2;->registerOnPageChangeCallback(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->btnAction Landroid/widget/TextView;
    if-nez v3, +008h
    const-string v3, "btnAction"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v3
    new-instance v3, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$$ExternalSyntheticLambda0;
    invoke-direct v3, v2, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/onboarding/OnboardingFragment;)V
    invoke-virtual v4, v3, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnFinished(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->onFinished Lkotlin/jvm/functions/Function0;
    return-void 
.end method
