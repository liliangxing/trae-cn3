# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;
.super Landroid/widget/FrameLayout;
.source "VideoArtifactCardView.kt"


.method public constructor <init>(android.content.Context)void
    .registers 6
    # ins_size=2
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v0, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_onbrand I
    invoke-static v5, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    const/high16 v2, 1124007936
    invoke-static v2, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v2
    invoke-static v1, v2, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(I I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    check-cast v0, Landroid/graphics/drawable/Drawable;
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/4 v0, 0
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;->setClickable(Z)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;->setFocusable(Z)V
    new-instance v0, Landroid/widget/ImageView;
    invoke-direct v0, v5, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v5, Lcom/bytedance/trae/kmp/artifacts/R$drawable;->trae_video_preview_play I
    invoke-virtual v0, v5, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v5, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v5, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v0, Landroid/view/View;
    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_play_icon_size I
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;->dimen(I)I
    move-result v1
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_play_icon_size I
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;->dimen(I)I
    move-result v2
    const/16 v3, 17
    invoke-direct v5, v1, v2, v3, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final dimen(int)int
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    return v2
.end method
