# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;
.super Lcom/facebook/imagepipeline/image/CloseableImage;
.source "SvgFrescoDecoder.kt"

.field private closed:Z
.field private final svg:Lcom/caverock/androidsvg/SVG;


.method public constructor <init>(com.caverock.androidsvg.SVG)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, svg
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/facebook/imagepipeline/image/CloseableImage;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->svg Lcom/caverock/androidsvg/SVG;
    sget-object v2, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->INSTANCE Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;
    invoke-virtual v2, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->getSVG_FORMAT()Lcom/facebook/imageformat/ImageFormat;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->mImageFormat Lcom/facebook/imageformat/ImageFormat;
    return-void 
.end method

.method private final toPositiveRoundedIntOrNull(float)java.lang.Integer
    .registers 6
    # ins_size=2
    invoke-static v5, Ljava/lang/Float;->isInfinite(F)Z
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +00ah
    invoke-static v5, Ljava/lang/Float;->isNaN(F)Z
    move-result v0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    const/4 v3, 0
    if-eqz v0, +024h
    const/4 v0, 0
    cmpg-float v0, v5, v0
    if-gtz v0, +003h
    goto +1dh
    const/high16 v0, 1325400064
    invoke-static v5, v0, Lkotlin/ranges/RangesKt;->coerceAtMost(F F)F
    move-result v5
    invoke-static v5, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v3, v5
    return-object v3
.end method

.method public close()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->closed Z
    return-void 
.end method

.method public getHeight()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v0, Lcom/caverock/androidsvg/SVG;->getDocumentHeight()F
    move-result v0
    invoke-static v0, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->floatValue()F
    move-result v1
    const/4 v2, 0
    cmpl-float v1, v1, v2
    const/4 v2, 0
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Float;->floatValue()F
    move-result v0
    float-to-int v2, v0
    return v2
.end method

.method public getImageCount()int
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public getSizeInBytes()int
    .registers 6
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;
    iget-object v0, v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v0, Lcom/caverock/androidsvg/SVG;->getDocumentViewBox()Landroid/graphics/RectF;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v1, Lcom/caverock/androidsvg/SVG;->getDocumentWidth()F
    move-result v1
    invoke-direct v5, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->toPositiveRoundedIntOrNull(F)Ljava/lang/Integer;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +11h
    if-eqz v0, +00bh
    invoke-virtual v0, Landroid/graphics/RectF;->width()F
    move-result v1
    invoke-direct v5, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->toPositiveRoundedIntOrNull(F)Ljava/lang/Integer;
    move-result-object v1
    goto +2h
    move-object v1, v3
    if-eqz v1, +003h
    goto -13h
    move v1, v2
    iget-object v4, v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v4, Lcom/caverock/androidsvg/SVG;->getDocumentHeight()F
    move-result v4
    invoke-direct v5, v4, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->toPositiveRoundedIntOrNull(F)Ljava/lang/Integer;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v2
    goto +11h
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/graphics/RectF;->height()F
    move-result v0
    invoke-direct v5, v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->toPositiveRoundedIntOrNull(F)Ljava/lang/Integer;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v2
    int-to-long v0, v1
    int-to-long v2, v2
    mul-long/2addr v0, v2
    const-wide/16 v2, 4
    mul-long/2addr v0, v2
    const-wide/32 v2, 2147483647
    invoke-static v0, v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtMost(J J)J
    move-result-wide v0
    long-to-int v0, v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-nez v1, +003h
    goto +fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "SvgFrescoDecoder"
    const-string v3, "get svg size failed"
    invoke-virtual v0, v2, v3, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    const/4 v0, 4
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    return v0
    :try_start_0x0
.end method

.method public final getSvg()com.caverock.androidsvg.SVG
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->svg Lcom/caverock/androidsvg/SVG;
    return-object v0
.end method

.method public getWidth()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->svg Lcom/caverock/androidsvg/SVG;
    invoke-virtual v0, Lcom/caverock/androidsvg/SVG;->getDocumentWidth()F
    move-result v0
    invoke-static v0, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->floatValue()F
    move-result v1
    const/4 v2, 0
    cmpl-float v1, v1, v2
    const/4 v2, 0
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Float;->floatValue()F
    move-result v0
    float-to-int v2, v0
    return v2
.end method

.method public isClosed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->closed Z
    return v0
.end method

.method public isStateful()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method
