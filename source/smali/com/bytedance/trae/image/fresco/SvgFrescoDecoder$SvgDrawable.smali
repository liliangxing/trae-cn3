# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "SvgFrescoDecoder.kt"

.field private alphaValue:I
.field private colorFilterValue:Landroid/graphics/ColorFilter;
.field private final intrinsicHeight:I
.field private final intrinsicWidth:I
.field private final layerPaint:Landroid/graphics/Paint;
.field private final svg:Lcom/caverock/androidsvg/SVG;


.method public constructor <init>(com.caverock.androidsvg.SVG)void
    .registers 8
    # ins_size=2
    const-string/jumbo v0, svg
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, Landroid/graphics/drawable/Drawable;-><init>()V
    iput-object v7, v6, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    const/16 v0, 255
    iput v0, v6, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->alphaValue I
    new-instance v0, Landroid/graphics/Paint;
    invoke-direct v0, Landroid/graphics/Paint;-><init>()V
    iput-object v0, v6, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->layerPaint Landroid/graphics/Paint;
    invoke-virtual v7, Lcom/caverock/androidsvg/SVG;->getDocumentWidth()F
    move-result v0
    invoke-static v0, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->floatValue()F
    move-result v1
    const/4 v2, 0
    cmpl-float v1, v1, v2
    const/4 v3, 1
    const/4 v4, 0
    if-lez v1, +004h
    move v1, v3
    goto +2h
    move v1, v4
    const/4 v5, 0
    if-eqz v1, +003h
    goto +2h
    move-object v0, v5
    const/4 v1, -1
    if-eqz v0, +00bh
    invoke-virtual v0, Ljava/lang/Float;->floatValue()F
    move-result v0
    invoke-static v0, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v0
    goto +2h
    move v0, v1
    iput v0, v6, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->intrinsicWidth I
    invoke-virtual v7, Lcom/caverock/androidsvg/SVG;->getDocumentHeight()F
    move-result v7
    invoke-static v7, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v7
    move-object v0, v7
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->floatValue()F
    move-result v0
    cmpl-float v0, v0, v2
    if-lez v0, +003h
    goto +2h
    move v3, v4
    if-eqz v3, +003h
    move-object v5, v7
    if-eqz v5, +00ah
    invoke-virtual v5, Ljava/lang/Float;->floatValue()F
    move-result v7
    invoke-static v7, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    iput v1, v6, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->intrinsicHeight I
    return-void 
.end method

.method public draw(android.graphics.Canvas)void
    .registers 10
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v0
    const-string v1, "getBounds(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Landroid/graphics/Rect;->width()I
    move-result v1
    if-lez v1, +0aah
    invoke-virtual v0, Landroid/graphics/Rect;->height()I
    move-result v1
    if-gtz v1, +004h
    goto/16 +0a2h
    iget v1, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->alphaValue I
    const/16 v2, 255
    if-lt v1, v2, +00ch
    iget-object v2, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->colorFilterValue Landroid/graphics/ColorFilter;
    if-eqz v2, +003h
    goto +6h
    invoke-virtual v9, Landroid/graphics/Canvas;->save()I
    move-result v1
    goto +20h
    iget-object v2, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->layerPaint Landroid/graphics/Paint;
    invoke-virtual v2, v1, Landroid/graphics/Paint;->setAlpha(I)V
    iget-object v1, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->layerPaint Landroid/graphics/Paint;
    iget-object v2, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->colorFilterValue Landroid/graphics/ColorFilter;
    invoke-virtual v1, v2, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    iget v1, v0, Landroid/graphics/Rect;->left I
    int-to-float v3, v1
    iget v1, v0, Landroid/graphics/Rect;->top I
    int-to-float v4, v1
    iget v1, v0, Landroid/graphics/Rect;->right I
    int-to-float v5, v1
    iget v1, v0, Landroid/graphics/Rect;->bottom I
    int-to-float v6, v1
    iget-object v7, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->layerPaint Landroid/graphics/Paint;
    move-object v2, v9
    invoke-virtual/range v2 ... v7, Landroid/graphics/Canvas;->saveLayer(F F F F Landroid/graphics/Paint;)I
    move-result v1
    iget-object v2, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v2, Lcom/caverock/androidsvg/SVG;->getDocumentWidth()F
    move-result v2
    iget-object v3, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v3, Lcom/caverock/androidsvg/SVG;->getDocumentHeight()F
    move-result v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v4, v8
    check-cast v4, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;
    iget v4, v0, Landroid/graphics/Rect;->left I
    int-to-float v4, v4
    iget v5, v0, Landroid/graphics/Rect;->top I
    int-to-float v5, v5
    invoke-virtual v9, v4, v5, Landroid/graphics/Canvas;->translate(F F)V
    iget-object v4, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v0, Landroid/graphics/Rect;->width()I
    move-result v5
    int-to-float v5, v5
    invoke-virtual v4, v5, Lcom/caverock/androidsvg/SVG;->setDocumentWidth(F)V
    iget-object v4, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v0, Landroid/graphics/Rect;->height()I
    move-result v5
    int-to-float v5, v5
    invoke-virtual v4, v5, Lcom/caverock/androidsvg/SVG;->setDocumentHeight(F)V
    iget-object v4, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    new-instance v5, Landroid/graphics/RectF;
    invoke-virtual v0, Landroid/graphics/Rect;->width()I
    move-result v6
    int-to-float v6, v6
    invoke-virtual v0, Landroid/graphics/Rect;->height()I
    move-result v0
    int-to-float v0, v0
    const/4 v7, 0
    invoke-direct v5, v7, v7, v6, v0, Landroid/graphics/RectF;-><init>(F F F F)V
    invoke-virtual v4, v9, v5, Lcom/caverock/androidsvg/SVG;->renderToCanvas(Landroid/graphics/Canvas; Landroid/graphics/RectF;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +00bh
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v5, "SvgFrescoDecoder"
    const-string v6, "draw svg failed"
    invoke-virtual v4, v5, v6, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v0, v2, Lcom/caverock/androidsvg/SVG;->setDocumentWidth(F)V
    iget-object v0, v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v0, v3, Lcom/caverock/androidsvg/SVG;->setDocumentHeight(F)V
    invoke-virtual v9, v1, Landroid/graphics/Canvas;->restoreToCount(I)V
    return-void 
    :try_start_0x57
.end method

.method public getIntrinsicHeight()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->intrinsicHeight I
    return v0
.end method

.method public getIntrinsicWidth()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->intrinsicWidth I
    return v0
.end method

.method public getOpacity()int
    .registers 2
    # ins_size=1
    const/4 v0, -3
    return v0
.end method

.method public setAlpha(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->alphaValue I
    invoke-virtual v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setColorFilter(android.graphics.ColorFilter)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->colorFilterValue Landroid/graphics/ColorFilter;
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iput-object v2, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->colorFilterValue Landroid/graphics/ColorFilter;
    invoke-virtual v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;->invalidateSelf()V
    return-void 
.end method
