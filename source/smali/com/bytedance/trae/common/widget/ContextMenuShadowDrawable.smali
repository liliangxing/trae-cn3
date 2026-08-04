# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "ContextMenuPopupWindow.kt"

.field private final cardInsets:Landroid/graphics/Rect;
.field private final cornerRadius:F
.field private final paint:Landroid/graphics/Paint;
.field private final rect:Landroid/graphics/RectF;
.field private final shadowColor:I
.field private final shadowDy:F
.field private final shadowRadius:F


.method public constructor <init>(float  float  float  int  android.graphics.Rect)void
    .registers 7
    # ins_size=6
    const-string v0, "cardInsets"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/graphics/drawable/Drawable;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->cornerRadius F
    iput v3, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->shadowRadius F
    iput v4, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->shadowDy F
    iput v5, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->shadowColor I
    iput-object v6, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->cardInsets Landroid/graphics/Rect;
    new-instance v2, Landroid/graphics/Paint;
    const/4 v6, 1
    invoke-direct v2, v6, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v2, v5, Landroid/graphics/Paint;->setColor(I)V
    sget-object v6, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v6, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    const/4 v6, 0
    invoke-virtual v2, v3, v6, v4, v5, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->paint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/RectF;
    invoke-direct v2, Landroid/graphics/RectF;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->rect Landroid/graphics/RectF;
    return-void 
.end method

.method public draw(android.graphics.Canvas)void
    .registers 8
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->rect Landroid/graphics/RectF;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v1
    iget v1, v1, Landroid/graphics/Rect;->left I
    int-to-float v1, v1
    iget-object v2, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->cardInsets Landroid/graphics/Rect;
    iget v2, v2, Landroid/graphics/Rect;->left I
    int-to-float v2, v2
    add-float/2addr v1, v2
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v2
    iget v2, v2, Landroid/graphics/Rect;->top I
    int-to-float v2, v2
    iget-object v3, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->cardInsets Landroid/graphics/Rect;
    iget v3, v3, Landroid/graphics/Rect;->top I
    int-to-float v3, v3
    add-float/2addr v2, v3
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v3
    iget v3, v3, Landroid/graphics/Rect;->right I
    int-to-float v3, v3
    iget-object v4, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->cardInsets Landroid/graphics/Rect;
    iget v4, v4, Landroid/graphics/Rect;->right I
    int-to-float v4, v4
    sub-float/2addr v3, v4
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v4
    iget v4, v4, Landroid/graphics/Rect;->bottom I
    int-to-float v4, v4
    iget-object v5, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->cardInsets Landroid/graphics/Rect;
    iget v5, v5, Landroid/graphics/Rect;->bottom I
    int-to-float v5, v5
    sub-float/2addr v4, v5
    invoke-virtual v0, v1, v2, v3, v4, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->rect Landroid/graphics/RectF;
    iget v1, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->cornerRadius F
    iget-object v2, v6, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->paint Landroid/graphics/Paint;
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
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setAlpha(I)V
    return-void 
.end method

.method public setColorFilter(android.graphics.ColorFilter)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    return-void 
.end method
