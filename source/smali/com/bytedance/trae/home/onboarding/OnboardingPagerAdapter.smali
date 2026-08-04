# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "OnboardingPagerAdapter.kt"

.field public static final $stable:I
.field private final density:F
.field private final pages:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.util.List  float)void
    .registers 4
    # ins_size=3
    const-string v0, "pages"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->pages Ljava/util/List;
    iput v3, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->pages Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->onBindViewHolder(Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.home.onboarding.OnboardingPagerAdapter$PageViewHolder  int)void
    .registers 9
    # ins_size=3
    const-string v0, "holder"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->pages Ljava/util/List;
    invoke-interface v0, v8, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    iget-object v0, v7, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    iget-object v7, v7, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;->itemView Landroid/view/View;
    const-string v1, "null cannot be cast to non-null type android.widget.LinearLayout"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Landroid/widget/LinearLayout;
    const-string/jumbo v1, title
    invoke-virtual v7, v1, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    const-string v2, "image"
    invoke-virtual v7, v2, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v7
    check-cast v7, Landroid/widget/ImageView;
    invoke-virtual v8, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->getTitleNormalResId()I
    move-result v2
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v3, "getString(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;
    move-result-object v4
    invoke-static v4, Landroidx/core/os/ConfigurationCompat;->getLocales(Landroid/content/res/Configuration;)Landroidx/core/os/LocaleListCompat;
    move-result-object v4
    const/4 v5, 0
    invoke-virtual v4, v5, Landroidx/core/os/LocaleListCompat;->get(I)Ljava/util/Locale;
    move-result-object v4
    if-nez v4, +004h
    sget-object v4, Ljava/util/Locale;->ENGLISH Ljava/util/Locale;
    invoke-virtual v4, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Ljava/util/Locale;->ENGLISH Ljava/util/Locale;
    invoke-virtual v5, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +02ah
    invoke-virtual v8, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->getTitleItalicResId()I
    move-result v4
    invoke-virtual v0, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 10
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +6h
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v8, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->getImageResId()I
    move-result v8
    invoke-virtual v7, v8, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.home.onboarding.OnboardingPagerAdapter$PageViewHolder
    .registers 11
    # ins_size=3
    const-string v10, "parent"
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v9
    new-instance v10, Landroid/widget/LinearLayout;
    invoke-direct v10, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 1
    invoke-virtual v10, v0, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v10, v0, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v1, Landroid/view/ViewGroup$LayoutParams;
    const/4 v2, -1
    invoke-direct v1, v2, v2, Landroid/view/ViewGroup$LayoutParams;-><init>(I I)V
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-float v1, v1
    iget v3, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    div-float/2addr v1, v3
    const v3, 1135312896
    const/high16 v4, 1124335616
    sub-float/2addr v1, v4
    sub-float/2addr v1, v3
    const v3, 1053005185
    mul-float/2addr v1, v3
    const/high16 v3, 1114636288
    invoke-static v1, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v1
    iget v3, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v1, v3
    float-to-int v1, v1
    const/4 v3, 0
    invoke-virtual v10, v3, v1, v3, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/4 v4, 2
    const/high16 v5, 1107296256
    invoke-virtual v1, v4, v5, Landroid/widget/TextView;->setTextSize(I F)V
    sget v4, Lcom/bytedance/trae/home/R$color;->onboarding_text_default I
    invoke-static v9, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTextColor(I)V
    const/16 v4, 17
    invoke-virtual v1, v4, Landroid/widget/TextView;->setGravity(I)V
    const-string/jumbo v4, title
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -2
    invoke-direct v4, v2, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 24
    int-to-float v5, v5
    iget v6, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v6, v5
    float-to-int v6, v6
    invoke-virtual v4, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    iget v6, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v6, v5
    float-to-int v6, v6
    invoke-virtual v4, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/Space;
    invoke-direct v1, v9, Landroid/widget/Space;-><init>(Landroid/content/Context;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v6, 60
    int-to-float v6, v6
    iget v7, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v6, v7
    float-to-int v6, v6
    invoke-direct v4, v3, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, Landroid/widget/Space;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v4, 203
    int-to-float v4, v4
    iget v6, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v4, v6
    float-to-int v4, v4
    invoke-direct v3, v2, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v4, 40
    int-to-float v4, v4
    iget v6, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v6, v4
    float-to-int v6, v6
    invoke-virtual v3, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    iget v6, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v4, v6
    float-to-int v4, v4
    invoke-virtual v3, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    iget v4, v8, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;->density F
    mul-float/2addr v5, v4
    invoke-virtual v3, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setClipToOutline(Z)V
    sget-object v0, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    new-instance v0, Landroid/widget/ImageView;
    invoke-direct v0, v9, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v9, Landroid/widget/ImageView$ScaleType;->CENTER_CROP Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v9, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    const-string v9, "image"
    invoke-virtual v0, v9, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v9, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    const-string v9, "imageContainer"
    invoke-virtual v1, v9, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v9, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;
    check-cast v10, Landroid/view/View;
    invoke-direct v9, v10, Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;-><init>(Landroid/view/View;)V
    return-object v9
.end method
