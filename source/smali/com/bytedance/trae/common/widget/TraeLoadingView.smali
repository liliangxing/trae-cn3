# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/TraeLoadingView;
.super Landroid/widget/FrameLayout;
.source "TraeLoadingView.kt"

.field private final progressDrawable:Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
.field private final progressImage:Landroidx/appcompat/widget/AppCompatImageView;


.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/TraeLoadingView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/TraeLoadingView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v3, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
    invoke-direct v3, v2, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;-><init>(Landroid/content/Context;)V
    const/4 v4, 1
    invoke-virtual v3, v4, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;->setStyle(I)V
    iput-object v3, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->progressDrawable Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
    new-instance v0, Landroidx/appcompat/widget/AppCompatImageView;
    invoke-direct v0, v2, Landroidx/appcompat/widget/AppCompatImageView;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v3, Landroidx/appcompat/widget/AppCompatImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    iput-object v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->progressImage Landroidx/appcompat/widget/AppCompatImageView;
    const/4 v3, 0
    invoke-virtual v1, v3, Lcom/bytedance/trae/common/widget/TraeLoadingView;->setContentDescription(Ljava/lang/CharSequence;)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_tooltip I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v3, v2, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v3, Lcom/bytedance/trae/common/widget/TraeLoadingView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    move-object v2, v1
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_loading_view_elevation I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimension(I)F
    move-result v3
    invoke-static v2, v3, Landroidx/core/view/ViewCompat;->setElevation(Landroid/view/View; F)V
    check-cast v0, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v3, -1
    invoke-direct v2, v3, v3, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/common/widget/TraeLoadingView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/common/widget/TraeLoadingView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final updateDrawableRunning()void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->isShown()Z
    move-result v0
    if-eqz v0, +016h
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->getWindowVisibility()I
    move-result v0
    if-nez v0, +010h
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->progressDrawable Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
    invoke-virtual v0, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;->isRunning()Z
    move-result v0
    if-nez v0, +015h
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->progressDrawable Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
    invoke-virtual v0, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;->start()V
    goto +eh
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->progressDrawable Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
    invoke-virtual v0, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;->isRunning()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->progressDrawable Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
    invoke-virtual v0, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;->stop()V
    return-void 
.end method

.method protected onAttachedToWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroid/widget/FrameLayout;->onAttachedToWindow()V
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeLoadingView;->updateDrawableRunning()V
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->progressDrawable Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;
    invoke-virtual v0, Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;->stop()V
    invoke-super v1, Landroid/widget/FrameLayout;->onDetachedFromWindow()V
    return-void 
.end method

.method protected onVisibilityChanged(android.view.View  int)void
    .registers 4
    # ins_size=3
    const-string v0, "changedView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroid/widget/FrameLayout;->onVisibilityChanged(Landroid/view/View; I)V
    invoke-direct v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->updateDrawableRunning()V
    return-void 
.end method

.method protected onWindowVisibilityChanged(int)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroid/widget/FrameLayout;->onWindowVisibilityChanged(I)V
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeLoadingView;->updateDrawableRunning()V
    return-void 
.end method

.method public final setLoadingVisible(boolean)void
    .registers 2
    # ins_size=2
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->setVisibility(I)V
    return-void 
.end method
