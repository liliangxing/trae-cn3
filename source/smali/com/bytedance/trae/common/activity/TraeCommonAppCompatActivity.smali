# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "TraeCommonAppCompatActivity.kt"


.method public static synthetic $r8$lambda$pKAdW_t_yn48TdyrpKiDHgpe6KA(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->applySystemBarInsets$lambda$1(Landroid/view/View; Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/appcompat/app/AppCompatActivity;-><init>()V
    return-void 
.end method

.method private final applySystemBarAppearance()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getWindow()Landroid/view/Window;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-static v0, v1, Landroidx/core/view/WindowCompat;->getInsetsController(Landroid/view/Window; Landroid/view/View;)Landroidx/core/view/WindowInsetsControllerCompat;
    move-result-object v0
    const-string v1, "getInsetsController(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->isLightStatusBar()Z
    move-result v1
    invoke-virtual v0, v1, Landroidx/core/view/WindowInsetsControllerCompat;->setAppearanceLightStatusBars(Z)V
    return-void 
.end method

.method private static final applySystemBarInsets$lambda$1(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 6
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "insets"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroidx/core/view/WindowInsetsCompat$Type;->systemBars()I
    move-result v0
    invoke-virtual v5, v0, Landroidx/core/view/WindowInsetsCompat;->getInsets(I)Landroidx/core/graphics/Insets;
    move-result-object v0
    const-string v1, "getInsets(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroidx/core/view/WindowInsetsCompat$Type;->ime()I
    move-result v2
    invoke-virtual v5, v2, Landroidx/core/view/WindowInsetsCompat;->getInsets(I)Landroidx/core/graphics/Insets;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget v1, v0, Landroidx/core/graphics/Insets;->left I
    iget v2, v0, Landroidx/core/graphics/Insets;->top I
    iget v3, v0, Landroidx/core/graphics/Insets;->right I
    iget v0, v0, Landroidx/core/graphics/Insets;->bottom I
    iget v5, v5, Landroidx/core/graphics/Insets;->bottom I
    invoke-static v0, v5, Ljava/lang/Math;->max(I I)I
    move-result v5
    invoke-virtual v4, v1, v2, v3, v5, Landroid/view/View;->setPadding(I I I I)V
    sget-object v4, Landroidx/core/view/WindowInsetsCompat;->CONSUMED Landroidx/core/view/WindowInsetsCompat;
    return-object v4
.end method

.method private final onContentViewSet()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->isEdgeToEdgeEnabled()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    const v0, 16908290
    invoke-virtual v2, v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getDecorViewBackgroundColor()I
    move-result v1
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundColor(I)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->applySystemBarInsets(Landroid/view/View;)V
    return-void 
.end method

.method private final setupEdgeToEdge()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getWindow()Landroid/view/Window;
    move-result-object v0
    invoke-virtual v0, Landroid/view/Window;->getNavigationBarColor()I
    move-result v0
    invoke-virtual v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getWindow()Landroid/view/Window;
    move-result-object v1
    const/4 v2, 0
    invoke-static v1, v2, Landroidx/core/view/WindowCompat;->setDecorFitsSystemWindows(Landroid/view/Window; Z)V
    invoke-virtual v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, v2, Landroid/view/Window;->setStatusBarColor(I)V
    invoke-virtual v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/view/Window;->setNavigationBarColor(I)V
    return-void 
.end method

.method public applyOverrideConfiguration(android.content.res.Configuration)void
    .registers 6
    # ins_size=2
    if-nez v5, +007h
    new-instance v5, Landroid/content/res/Configuration;
    invoke-direct v5, Landroid/content/res/Configuration;-><init>()V
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, Lcom/bytedance/trae/utils/LocaleManager;->getAppLocale()Ljava/util/Locale;
    move-result-object v0
    invoke-static v0, Ljava/util/Locale;->setDefault(Ljava/util/Locale;)V
    invoke-virtual v5, v0, Landroid/content/res/Configuration;->setLocale(Ljava/util/Locale;)V
    new-instance v1, Landroid/os/LocaleList;
    const/4 v2, 1
    new-array v2, v2, [Ljava/util/Locale;
    const/4 v3, 0
    aput-object v0, v2, v3
    invoke-direct v1, v2, Landroid/os/LocaleList;-><init>([Ljava/util/Locale;)V
    invoke-static v1, Landroid/os/LocaleList;->setDefault(Landroid/os/LocaleList;)V
    invoke-virtual v5, v1, Landroid/content/res/Configuration;->setLocales(Landroid/os/LocaleList;)V
    invoke-super v4, v5, Landroidx/appcompat/app/AppCompatActivity;->applyOverrideConfiguration(Landroid/content/res/Configuration;)V
    return-void 
.end method

.method protected final applySystemBarInsets(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, rootView
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v2, v0, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View; Landroidx/core/view/OnApplyWindowInsetsListener;)V
    invoke-static v2, Landroidx/core/view/ViewCompat;->requestApplyInsets(Landroid/view/View;)V
    return-void 
.end method

.method protected attachBaseContext(android.content.Context)void
    .registers 3
    # ins_size=2
    if-eqz v2, +00ch
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, v2, Lcom/bytedance/trae/utils/LocaleManager;->wrapContext(Landroid/content/Context;)Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    invoke-super v1, v2, Landroidx/appcompat/app/AppCompatActivity;->attachBaseContext(Landroid/content/Context;)V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getColor(I)I
    move-result v0
    return v0
.end method

.method public isEdgeToEdgeEnabled()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public isLightStatusBar()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->INSTANCE Lcom/bytedance/trae/common/theme/ThemeManager;
    invoke-virtual v0, Lcom/bytedance/trae/common/theme/ThemeManager;->isDarkMode()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    return v0
.end method

.method protected onActivityResult(int  int  android.content.Intent)void
    .registers 4
    # ins_size=4
    invoke-super v0, v1, v2, v3, Landroidx/appcompat/app/AppCompatActivity;->onActivityResult(I I Landroid/content/Intent;)V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->isEdgeToEdgeEnabled()Z
    move-result v0
    if-eqz v0, +005h
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->setupEdgeToEdge()V
    invoke-super v2, v3, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget-object v3, Lcom/bytedance/trae/common/theme/ThemeManager;->INSTANCE Lcom/bytedance/trae/common/theme/ThemeManager;
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;
    move-result-object v0
    const-string v1, "getConfiguration(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/theme/ThemeManager;->updateDarkModeFlag(Landroid/content/res/Configuration;)V
    invoke-virtual v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->isEdgeToEdgeEnabled()Z
    move-result v3
    if-eqz v3, +005h
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->applySystemBarAppearance()V
    return-void 
.end method

.method protected onDestroy()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/appcompat/app/AppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onResume()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/appcompat/app/AppCompatActivity;->onResume()V
    return-void 
    :try_start_0x0
.end method

.method protected onSaveInstanceState(android.os.Bundle)void
    .registers 3
    # ins_size=2
    const-string v0, "outState"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, Landroidx/appcompat/app/AppCompatActivity;->onSaveInstanceState(Landroid/os/Bundle;)V
    return-void 
.end method

.method public setContentView(int)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroidx/appcompat/app/AppCompatActivity;->setContentView(I)V
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onContentViewSet()V
    return-void 
.end method

.method public setContentView(android.view.View)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroidx/appcompat/app/AppCompatActivity;->setContentView(Landroid/view/View;)V
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onContentViewSet()V
    return-void 
.end method

.method public setContentView(android.view.View  android.view.ViewGroup$LayoutParams)void
    .registers 3
    # ins_size=3
    invoke-super v0, v1, v2, Landroidx/appcompat/app/AppCompatActivity;->setContentView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onContentViewSet()V
    return-void 
.end method
