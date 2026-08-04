# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "TraeTitleBar.kt"

.field private final backgroundColor:I
.field private final contentInsets:Landroid/graphics/Rect;
.field private final cornerRadius:F
.field private final paint:Landroid/graphics/Paint;
.field private final rect:Landroid/graphics/RectF;
.field private final shadowColor:I
.field private final shadowDy:F
.field private final shadowRadius:F


.method public constructor <init>(int  int  float  float  float  android.graphics.Rect)void
    .registers 8
    # ins_size=7
    const-string v0, "contentInsets"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/graphics/drawable/Drawable;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->backgroundColor I
    iput v3, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->shadowColor I
    iput v4, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->cornerRadius F
    iput v5, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->shadowRadius F
    iput v6, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->shadowDy F
    iput-object v7, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->contentInsets Landroid/graphics/Rect;
    new-instance v4, Landroid/graphics/Paint;
    const/4 v7, 1
    invoke-direct v4, v7, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v4, v2, Landroid/graphics/Paint;->setColor(I)V
    sget-object v2, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v4, v2, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    const/4 v2, 0
    invoke-virtual v4, v5, v2, v6, v3, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    iput-object v4, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->paint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/RectF;
    invoke-direct v2, Landroid/graphics/RectF;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->rect Landroid/graphics/RectF;
    return-void 
.end method

.method public draw(android.graphics.Canvas)void
    .registers 8
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->rect Landroid/graphics/RectF;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v1
    iget v1, v1, Landroid/graphics/Rect;->left I
    int-to-float v1, v1
    iget-object v2, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->contentInsets Landroid/graphics/Rect;
    iget v2, v2, Landroid/graphics/Rect;->left I
    int-to-float v2, v2
    add-float/2addr v1, v2
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v2
    iget v2, v2, Landroid/graphics/Rect;->top I
    int-to-float v2, v2
    iget-object v3, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->contentInsets Landroid/graphics/Rect;
    iget v3, v3, Landroid/graphics/Rect;->top I
    int-to-float v3, v3
    add-float/2addr v2, v3
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v3
    iget v3, v3, Landroid/graphics/Rect;->right I
    int-to-float v3, v3
    iget-object v4, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->contentInsets Landroid/graphics/Rect;
    iget v4, v4, Landroid/graphics/Rect;->right I
    int-to-float v4, v4
    sub-float/2addr v3, v4
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v4
    iget v4, v4, Landroid/graphics/Rect;->bottom I
    int-to-float v4, v4
    iget-object v5, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->contentInsets Landroid/graphics/Rect;
    iget v5, v5, Landroid/graphics/Rect;->bottom I
    int-to-float v5, v5
    sub-float/2addr v4, v5
    invoke-virtual v0, v1, v2, v3, v4, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->rect Landroid/graphics/RectF;
    iget v1, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->cornerRadius F
    iget-object v2, v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v7, v0, v1, v1, v2, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    return-void 
.end method

.method public getOpacity()int
    .registers 2
    # ins_size=1
    const/4 v0, -3
    return v0
.end method

.method public setAlpha(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setAlpha(I)V
    return-void 
.end method

.method public setColorFilter(android.graphics.ColorFilter)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    return-void 
.end method
