# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "BubbleDrawable.java"

.field private arrowCenterXPx:F
.field private arrowHeightPx:F
.field private arrowWidthPx:F
.field private final backgroundPaint:Landroid/graphics/Paint;
.field private final bubblePath:Landroid/graphics/Path;
.field private cornerRadiusPx:F
.field private final shadowPaint:Landroid/graphics/Paint;


.method public constructor <init>(android.content.Context)void
    .registers 7
    # ins_size=2
    invoke-direct v5, Landroid/graphics/drawable/Drawable;-><init>()V
    new-instance v0, Landroid/graphics/Paint;
    const/4 v1, 1
    invoke-direct v0, v1, Landroid/graphics/Paint;-><init>(I)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->backgroundPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, v1, Landroid/graphics/Paint;-><init>(I)V
    iput-object v2, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->shadowPaint Landroid/graphics/Paint;
    new-instance v1, Landroid/graphics/Path;
    invoke-direct v1, Landroid/graphics/Path;-><init>()V
    iput-object v1, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->bubblePath Landroid/graphics/Path;
    invoke-virtual v6, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->density F
    const/high16 v1, 1098907648
    mul-float/2addr v1, v6
    iput v1, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->cornerRadiusPx F
    const/high16 v1, 1108344832
    mul-float/2addr v1, v6
    iput v1, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowWidthPx F
    const/high16 v1, 1095761920
    mul-float/2addr v1, v6
    iput v1, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowHeightPx F
    const/high16 v1, 1112801280
    mul-float/2addr v1, v6
    iput v1, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowCenterXPx F
    const/16 v1, 11
    const/16 v3, 10
    invoke-static v1, v1, v3, Landroid/graphics/Color;->rgb(I I I)I
    move-result v4
    invoke-virtual v0, v4, Landroid/graphics/Paint;->setColor(I)V
    sget-object v4, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v0, v4, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    invoke-static v1, v1, v3, Landroid/graphics/Color;->rgb(I I I)I
    move-result v0
    invoke-virtual v2, v0, Landroid/graphics/Paint;->setColor(I)V
    sget-object v0, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v0, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    const/high16 v0, 1103626240
    mul-float/2addr v0, v6
    const/high16 v1, 1094713344
    mul-float/2addr v6, v1
    const/16 v1, 20
    const/4 v3, 0
    invoke-static v1, v3, v3, v3, Landroid/graphics/Color;->argb(I I I I)I
    move-result v1
    const/4 v3, 0
    invoke-virtual v2, v0, v3, v6, v1, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    return-void 
.end method

.method private buildBubblePath(int  int)void
    .registers 14
    # ins_size=3
    iget-object v0, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->bubblePath Landroid/graphics/Path;
    invoke-virtual v0, Landroid/graphics/Path;->reset()V
    if-lez v12, +065h
    if-gtz v13, +003h
    goto +61h
    int-to-float v13, v13
    iget v0, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowHeightPx F
    sub-float/2addr v13, v0
    new-instance v0, Landroid/graphics/RectF;
    int-to-float v12, v12
    const/4 v1, 0
    invoke-direct v0, v1, v1, v12, v13, Landroid/graphics/RectF;-><init>(F F F F)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->bubblePath Landroid/graphics/Path;
    iget v1, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->cornerRadiusPx F
    sget-object v2, Landroid/graphics/Path$Direction;->CW Landroid/graphics/Path$Direction;
    invoke-virtual v12, v0, v1, v1, v2, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Path$Direction;)V
    iget v6, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowCenterXPx F
    iget v12, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowWidthPx F
    const/high16 v0, 1073741824
    div-float v0, v12, v0
    sub-float v8, v6, v0
    add-float/2addr v0, v6
    iget v1, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowHeightPx F
    new-instance v9, Landroid/graphics/Path;
    invoke-direct v9, Landroid/graphics/Path;-><init>()V
    invoke-virtual v9, v8, v13, Landroid/graphics/Path;->moveTo(F F)V
    const v2, 1046562734
    mul-float/2addr v2, v12
    add-float/2addr v2, v8
    const v3, 1052938076
    mul-float/2addr v3, v12
    add-float v4, v8, v3
    const v3, 1063675494
    mul-float/2addr v3, v1
    add-float v10, v13, v3
    add-float v7, v13, v1
    move-object v1, v9
    move v3, v13
    move v5, v10
    invoke-virtual/range v1 ... v7, Landroid/graphics/Path;->cubicTo(F F F F F F)V
    const v1, 1058977874
    mul-float/2addr v1, v12
    add-float v2, v8, v1
    const v1, 1061662228
    mul-float/2addr v12, v1
    add-float v4, v8, v12
    move-object v1, v9
    move v3, v10
    move v5, v13
    move v6, v0
    move v7, v13
    invoke-virtual/range v1 ... v7, Landroid/graphics/Path;->cubicTo(F F F F F F)V
    invoke-virtual v9, Landroid/graphics/Path;->close()V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->bubblePath Landroid/graphics/Path;
    sget-object v13, Landroid/graphics/Path$Op;->UNION Landroid/graphics/Path$Op;
    invoke-virtual v12, v9, v13, Landroid/graphics/Path;->op(Landroid/graphics/Path; Landroid/graphics/Path$Op;)Z
    return-void 
.end method

.method public draw(android.graphics.Canvas)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->bubblePath Landroid/graphics/Path;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->backgroundPaint Landroid/graphics/Paint;
    invoke-virtual v3, v0, v1, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path; Landroid/graphics/Paint;)V
    return-void 
.end method

.method public getOpacity()int
    .registers 2
    # ins_size=1
    const/4 v0, -3
    return v0
.end method

.method protected onBoundsChange(android.graphics.Rect)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Landroid/graphics/drawable/Drawable;->onBoundsChange(Landroid/graphics/Rect;)V
    invoke-virtual v2, Landroid/graphics/Rect;->width()I
    move-result v0
    invoke-virtual v2, Landroid/graphics/Rect;->height()I
    move-result v2
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->buildBubblePath(I I)V
    return-void 
.end method

.method public setAlpha(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->backgroundPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setAlpha(I)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->shadowPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setAlpha(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setArrowCenterX(float  float)void
    .registers 3
    # ins_size=3
    mul-float/2addr v1, v2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowCenterXPx F
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->onBoundsChange(Landroid/graphics/Rect;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setArrowSize(float  float  float)void
    .registers 4
    # ins_size=4
    mul-float/2addr v1, v3
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowWidthPx F
    mul-float/2addr v2, v3
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->arrowHeightPx F
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->onBoundsChange(Landroid/graphics/Rect;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setColor(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->backgroundPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColor(I)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->shadowPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setColorFilter(android.graphics.ColorFilter)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->backgroundPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->shadowPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setCornerRadius(float  float)void
    .registers 3
    # ins_size=3
    mul-float/2addr v1, v2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->cornerRadiusPx F
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->onBoundsChange(Landroid/graphics/Rect;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setShadow(float  float  float  int  float)void
    .registers 7
    # ins_size=6
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->shadowPaint Landroid/graphics/Paint;
    mul-float/2addr v2, v6
    mul-float/2addr v3, v6
    mul-float/2addr v4, v6
    invoke-virtual v0, v2, v3, v4, v5, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->invalidateSelf()V
    return-void 
.end method
