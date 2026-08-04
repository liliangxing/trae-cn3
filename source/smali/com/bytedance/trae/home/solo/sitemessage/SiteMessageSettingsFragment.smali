# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
.super Landroidx/fragment/app/Fragment;
.source "SiteMessageSettingsFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$Companion;
.field private items:Ljava/util/List;
.field private loadingView:Landroid/widget/ProgressBar;
.field private preferences:Ljava/util/Map;
.field private scrollView:Landroid/widget/ScrollView;
.field private stackView:Landroid/widget/LinearLayout;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method public static synthetic $r8$lambda$Nqy6XbhI3S5-Z_2T3CI1Sa2f0Os(androidx.appcompat.widget.SwitchCompat  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->makeCard$lambda$9(Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_x44wKeJ98nskBPTW1xMV8O6UBI(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$gzSCF86m79n8Sa7cQDwJYXDny04(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  androidx.appcompat.widget.SwitchCompat  android.widget.LinearLayout  android.widget.CompoundButton  boolean)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->makeCard$lambda$8(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Landroidx/appcompat/widget/SwitchCompat; Landroid/widget/LinearLayout; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->Companion Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCurrentPreferences()Ljava/util/Map;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->preferences Ljava/util/Map;
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCurrentItems()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->items Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getLoadingView$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->loadingView Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getScrollView$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment)android.widget.ScrollView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->scrollView Landroid/widget/ScrollView;
    return-object v0
.end method

.method public static final synthetic access$onSwitchToggled(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  boolean  androidx.appcompat.widget.SwitchCompat  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->onSwitchToggled(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Z Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View;)V
    return-void 
.end method

.method public static final synthetic access$renderItems(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->renderItems()V
    return-void 
.end method

.method public static final synthetic access$setItems$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->items Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setPreferences$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  java.util.Map)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->preferences Ljava/util/Map;
    return-void 
.end method

.method private final dpToPx(int)int
    .registers 3
    # ins_size=2
    int-to-float v2, v2
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v0
    float-to-int v2, v2
    return v2
.end method

.method private final fetchLatest()void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final makeCard(com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  int)android.view.View
    .registers 16
    # ins_size=3
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    sget v3, Lcom/bytedance/trae/home/R$drawable;->bg_site_message_settings_card I
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    const/16 v3, 16
    invoke-direct v13, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v4
    invoke-direct v13, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v5
    const/4 v6, 4
    invoke-direct v13, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v7
    invoke-direct v13, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v8
    invoke-virtual v1, v4, v5, v7, v8, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v7, -2
    invoke-direct v4, v5, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct v4, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v8, 1
    invoke-virtual v4, v8, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v10, 1065353216
    invoke-direct v9, v2, v7, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    invoke-direct v13, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v3
    invoke-virtual v9, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v9, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getTitle()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;
    move-result-object v9
    if-eqz v9, +009h
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;->getLocalized()Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +003h
    goto +5h
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getKey()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v3, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v3, v9, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v9, 1099431936
    invoke-virtual v3, v9, Landroid/widget/TextView;->setTextSize(F)V
    const/4 v9, 0
    invoke-virtual v3, v9, v10, Landroid/widget/TextView;->setLineSpacing(F F)V
    invoke-virtual v3, v2, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v4, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getDescription()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;
    move-result-object v3
    const/4 v11, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;->getLocalized()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v11
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v2
    goto +2h
    move v3, v8
    if-nez v3, +049h
    new-instance v3, Landroid/view/View;
    invoke-direct v3, v0, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v13, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v6
    invoke-direct v12, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v12, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v4, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getDescription()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;
    move-result-object v5
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;->getLocalized()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +004h
    const-string v11, ""
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v3, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v3, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v5, 1095761920
    invoke-virtual v3, v5, Landroid/widget/TextView;->setTextSize(F)V
    invoke-virtual v3, v9, v10, Landroid/widget/TextView;->setLineSpacing(F F)V
    invoke-virtual v3, v2, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v4, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v3, Landroidx/appcompat/widget/SwitchCompat;
    invoke-direct v3, v0, Landroidx/appcompat/widget/SwitchCompat;-><init>(Landroid/content/Context;)V
    iget-object v5, v13, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->preferences Ljava/util/Map;
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getKey()Ljava/lang/String;
    move-result-object v6
    invoke-interface v5, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Boolean;
    if-eqz v5, +007h
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    goto +2h
    move v5, v8
    invoke-virtual v3, v5, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    sget v5, Lcom/bytedance/trae/home/R$drawable;->bg_toggle_track I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v5
    invoke-virtual v3, v5, Landroidx/appcompat/widget/SwitchCompat;->setTrackDrawable(Landroid/graphics/drawable/Drawable;)V
    sget v5, Lcom/bytedance/trae/home/R$drawable;->bg_toggle_thumb I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v0
    invoke-virtual v3, v0, Landroidx/appcompat/widget/SwitchCompat;->setThumbDrawable(Landroid/graphics/drawable/Drawable;)V
    const/16 v0, 52
    invoke-direct v13, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v0
    invoke-virtual v3, v0, Landroidx/appcompat/widget/SwitchCompat;->setSwitchMinWidth(I)V
    invoke-virtual v3, v2, Landroidx/appcompat/widget/SwitchCompat;->setShowText(Z)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v7, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v2, 8
    invoke-direct v13, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v5
    invoke-direct v13, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v6
    const/16 v7, 12
    invoke-direct v13, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v7
    invoke-direct v13, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v2
    invoke-virtual v0, v5, v6, v7, v2, Landroid/widget/LinearLayout$LayoutParams;->setMargins(I I I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v0, Landroidx/appcompat/widget/SwitchCompat;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v15
    invoke-virtual v3, v15, Landroidx/appcompat/widget/SwitchCompat;->setTag(Ljava/lang/Object;)V
    new-instance v15, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$$ExternalSyntheticLambda1;
    invoke-direct v15, v13, v14, v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Landroidx/appcompat/widget/SwitchCompat; Landroid/widget/LinearLayout;)V
    invoke-virtual v3, v15, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object v14, v3
    check-cast v14, Landroid/view/View;
    invoke-virtual v1, v14, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v1, v8, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-virtual v1, v8, Landroid/widget/LinearLayout;->setFocusable(Z)V
    new-instance v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$$ExternalSyntheticLambda2;
    invoke-direct v14, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$$ExternalSyntheticLambda2;-><init>(Landroidx/appcompat/widget/SwitchCompat;)V
    invoke-virtual v1, v14, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private static final makeCard$lambda$8(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  androidx.appcompat.widget.SwitchCompat  android.widget.LinearLayout  android.widget.CompoundButton  boolean)void
    .registers 6
    # ins_size=6
    check-cast v3, Landroid/view/View;
    invoke-direct v0, v1, v5, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->onSwitchToggled(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Z Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View;)V
    return-void 
.end method

.method private static final makeCard$lambda$9(androidx.appcompat.widget.SwitchCompat  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroidx/appcompat/widget/SwitchCompat;->isEnabled()Z
    move-result v1
    if-eqz v1, +00bh
    invoke-virtual v0, Landroidx/appcompat/widget/SwitchCompat;->isChecked()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    invoke-virtual v0, v1, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    return-void 
.end method

.method private final onSwitchToggled(com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  boolean  androidx.appcompat.widget.SwitchCompat  android.view.View)void
    .registers 20
    # ins_size=5
    move-object v8, v15
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->preferences Ljava/util/Map;
    invoke-static v0, Lkotlin/collections/MapsKt;->toMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v4
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->preferences Ljava/util/Map;
    invoke-static v0, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    invoke-static/range v17, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual/range v16, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getKey()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iput-object v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->preferences Ljava/util/Map;
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->save(Ljava/util/Map;)V
    const/4 v0, 0
    move-object/from16 v5, v18
    invoke-virtual v5, v0, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    move-object/from16 v6, v19
    invoke-virtual v6, v0, Landroid/view/View;->setClickable(Z)V
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v9, v0
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    const/4 v10, 0
    const/4 v11, 0
    new-instance v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;
    const/4 v7, 0
    move-object v0, v12
    move-object/from16 v1, v16
    move/from16 v2, v17
    move-object v3, v15
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Z Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Ljava/util/Map; Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v13, 3
    const/4 v14, 0
    invoke-static/range v9 ... v14, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private final renderItems()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->stackView Landroid/widget/LinearLayout;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->items Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +03ah
    add-int/lit8 v3, v2, 1
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    invoke-direct v7, v4, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->makeCard(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; I)Landroid/view/View;
    move-result-object v4
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->items Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    add-int/lit8 v4, v4, -1
    if-ge v2, v4, +01fh
    new-instance v2, Landroid/view/View;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-direct v2, v4, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v5, 12
    invoke-direct v7, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->dpToPx(I)I
    move-result v5
    const/4 v6, -1
    invoke-direct v4, v6, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v4, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move v2, v3
    goto -3dh
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_site_message_settings I
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
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v3, Lcom/bytedance/trae/home/R$id;->scroll_view I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/ScrollView;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->scrollView Landroid/widget/ScrollView;
    sget v3, Lcom/bytedance/trae/home/R$id;->stack_view I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/LinearLayout;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->stackView Landroid/widget/LinearLayout;
    sget v3, Lcom/bytedance/trae/home/R$id;->loading I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/ProgressBar;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->loadingView Landroid/widget/ProgressBar;
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    sget-object v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->trackSettingsPageView()V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->items Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +014h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->loadingView Landroid/widget/ProgressBar;
    if-eqz v2, +006h
    const/4 v3, 0
    invoke-virtual v2, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->scrollView Landroid/widget/ScrollView;
    if-eqz v2, +00bh
    const/16 v3, 8
    invoke-virtual v2, v3, Landroid/widget/ScrollView;->setVisibility(I)V
    goto +4h
    invoke-direct v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->renderItems()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->fetchLatest()V
    return-void 
.end method
