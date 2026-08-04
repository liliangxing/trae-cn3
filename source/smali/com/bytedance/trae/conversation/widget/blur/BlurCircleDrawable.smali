# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "BlurCircleDrawable.kt"

.field private final blurRadius:F
.field private centerX:F
.field private centerY:F
.field private circleRadius:F
.field private circleScale:F
.field private currentColors:[I
.field private final gradientCenterYRatio:F
.field private final gradientRadiusXRatio:F
.field private final gradientRadiusYRatio:F
.field private final paint:Landroid/graphics/Paint;
.field private radiusWidthRatio:F
.field private final showHeight:I
.field private final softBlurEdgeFraction:F
.field private final useMaskFilter:Z
.field private final useSoftBlur:Z


.method public constructor <init>(int[]  float  float  int  android.graphics.Xfermode  float  float  float  boolean  boolean)void
    .registers 12
    # ins_size=11
    const-string v0, "circleColors"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/graphics/drawable/Drawable;-><init>()V
    iput v3, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->blurRadius F
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->radiusWidthRatio F
    iput v5, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->showHeight I
    iput v7, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->gradientRadiusXRatio F
    iput v8, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->gradientRadiusYRatio F
    iput v9, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->gradientCenterYRatio F
    iput-boolean v10, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->useMaskFilter Z
    iput-boolean v11, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->useSoftBlur Z
    new-instance v4, Landroid/graphics/Paint;
    const/4 v5, 1
    invoke-direct v4, v5, Landroid/graphics/Paint;-><init>(I)V
    iput-object v4, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    const/high16 v5, 1065353216
    iput v5, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->currentColors [I
    if-eqz v10, +01bh
    if-nez v11, +019h
    mul-float/2addr v3, v5
    const/4 v2, 0
    cmpl-float v2, v3, v2
    if-lez v2, +00fh
    new-instance v2, Landroid/graphics/BlurMaskFilter;
    sget-object v5, Landroid/graphics/BlurMaskFilter$Blur;->NORMAL Landroid/graphics/BlurMaskFilter$Blur;
    invoke-direct v2, v3, v5, Landroid/graphics/BlurMaskFilter;-><init>(F Landroid/graphics/BlurMaskFilter$Blur;)V
    check-cast v2, Landroid/graphics/MaskFilter;
    invoke-virtual v4, v2, Landroid/graphics/Paint;->setMaskFilter(Landroid/graphics/MaskFilter;)Landroid/graphics/MaskFilter;
    goto +5h
    const/4 v2, 0
    invoke-virtual v4, v2, Landroid/graphics/Paint;->setMaskFilter(Landroid/graphics/MaskFilter;)Landroid/graphics/MaskFilter;
    invoke-virtual v4, v6, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    const v2, 1036831949
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->softBlurEdgeFraction F
    return-void 
.end method

.method public synthetic constructor <init>(int[]  float  float  int  android.graphics.Xfermode  float  float  float  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 23
    # ins_size=13
    move/from16 v0, v21
    and-int/lit8 v1, v0, 2
    if-eqz v1, +005h
    const/high16 v1, 1114636288
    goto +2h
    move v1, v12
    and-int/lit8 v2, v0, 4
    if-eqz v2, +006h
    const v2, 1064061370
    goto +2h
    move v2, v13
    and-int/lit8 v3, v0, 8
    const/4 v4, 0
    if-eqz v3, +004h
    move v3, v4
    goto +2h
    move v3, v14
    and-int/lit8 v5, v0, 16
    if-eqz v5, +004h
    const/4 v5, 0
    goto +2h
    move-object v5, v15
    and-int/lit8 v6, v0, 32
    if-eqz v6, +006h
    const v6, 1058461136
    goto +3h
    move/from16 v6, v16
    and-int/lit8 v7, v0, 64
    if-eqz v7, +006h
    const v7, 1052760238
    goto +3h
    move/from16 v7, v17
    and-int/lit16 v8, v0, 128
    if-eqz v8, +006h
    const v8, 1055464725
    goto +3h
    move/from16 v8, v18
    and-int/lit16 v9, v0, 256
    if-eqz v9, +004h
    const/4 v9, 1
    goto +3h
    move/from16 v9, v19
    and-int/lit16 v0, v0, 512
    if-eqz v0, +003h
    goto +3h
    move/from16 v4, v20
    move-object v12, v10
    move-object v13, v11
    move v14, v1
    move v15, v2
    move/from16 v16, v3
    move-object/from16 v17, v5
    move/from16 v18, v6
    move/from16 v19, v7
    move/from16 v20, v8
    move/from16 v21, v9
    move/from16 v22, v4
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;-><init>([I F F I Landroid/graphics/Xfermode; F F F Z Z)V
    return-void 
.end method

.method private final updateGradientShader()void
    .registers 16
    # ins_size=1
    iget v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    const/4 v1, 0
    cmpg-float v0, v0, v1
    if-gtz v0, +003h
    return-void 
    iget-boolean v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->useSoftBlur Z
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v0, +066h
    iget-object v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->currentColors [I
    array-length v5, v0
    if-ge v5, v3, +013h
    new-array v5, v3, [I
    invoke-static v0, Lkotlin/collections/ArraysKt;->first([I)I
    move-result v0
    aput v0, v5, v2
    iget-object v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->currentColors [I
    invoke-static v0, Lkotlin/collections/ArraysKt;->first([I)I
    move-result v0
    aput v0, v5, v4
    move-object v0, v5
    iget v5, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    iget v6, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->blurRadius F
    iget v7, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    mul-float/2addr v6, v7
    iget v7, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->softBlurEdgeFraction F
    mul-float/2addr v6, v7
    add-float/2addr v6, v5
    cmpl-float v7, v6, v1
    const/high16 v8, 1065353216
    if-lez v7, +004h
    div-float/2addr v5, v6
    goto +2h
    move v5, v8
    array-length v6, v0
    add-int/2addr v6, v4
    new-array v6, v6, [I
    array-length v7, v0
    add-int/2addr v7, v4
    new-array v7, v7, [F
    array-length v9, v0
    move v10, v2
    if-ge v10, v9, +015h
    aget v11, v0, v10
    aput v11, v6, v10
    int-to-float v11, v10
    mul-float/2addr v11, v5
    array-length v12, v0
    sub-int/2addr v12, v4
    invoke-static v12, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v12
    int-to-float v12, v12
    div-float/2addr v11, v12
    aput v11, v7, v10
    add-int/lit8 v10, v10, 1
    goto -14h
    invoke-static v0, Lkotlin/collections/ArraysKt;->last([I)I
    move-result v4
    array-length v5, v0
    invoke-static v4, Landroid/graphics/Color;->red(I)I
    move-result v9
    invoke-static v4, Landroid/graphics/Color;->green(I)I
    move-result v10
    invoke-static v4, Landroid/graphics/Color;->blue(I)I
    move-result v4
    invoke-static v2, v9, v10, v4, Landroid/graphics/Color;->argb(I I I I)I
    move-result v2
    aput v2, v6, v5
    array-length v0, v0
    aput v8, v7, v0
    goto +1ah
    iget-object v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->currentColors [I
    array-length v5, v0
    if-ge v5, v3, +014h
    new-array v5, v3, [I
    invoke-static v0, Lkotlin/collections/ArraysKt;->first([I)I
    move-result v0
    aput v0, v5, v2
    iget-object v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->currentColors [I
    invoke-static v0, Lkotlin/collections/ArraysKt;->first([I)I
    move-result v0
    aput v0, v5, v4
    move-object v6, v5
    goto +2h
    move-object v6, v0
    const/4 v7, 0
    move-object v12, v6
    move-object v13, v7
    iget v9, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerX F
    iget v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerY F
    iget v2, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    sub-float/2addr v0, v2
    int-to-float v3, v3
    mul-float v4, v2, v3
    iget v5, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->gradientCenterYRatio F
    mul-float/2addr v4, v5
    add-float v10, v0, v4
    mul-float v0, v2, v3
    iget v4, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->gradientRadiusXRatio F
    mul-float/2addr v0, v4
    mul-float/2addr v2, v3
    iget v3, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->gradientRadiusYRatio F
    mul-float/2addr v2, v3
    invoke-static v0, v2, Ljava/lang/Math;->max(F F)F
    move-result v0
    iget-boolean v2, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->useSoftBlur Z
    if-eqz v2, +00bh
    iget v2, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->blurRadius F
    iget v3, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    mul-float/2addr v2, v3
    iget v3, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->softBlurEdgeFraction F
    mul-float/2addr v2, v3
    add-float/2addr v0, v2
    move v11, v0
    cmpg-float v0, v11, v1
    if-gtz v0, +003h
    return-void 
    iget-object v0, v15, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    new-instance v1, Landroid/graphics/RadialGradient;
    sget-object v14, Landroid/graphics/Shader$TileMode;->CLAMP Landroid/graphics/Shader$TileMode;
    move-object v8, v1
    invoke-direct/range v8 ... v14, Landroid/graphics/RadialGradient;-><init>(F F F [I [F Landroid/graphics/Shader$TileMode;)V
    check-cast v1, Landroid/graphics/Shader;
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    return-void 
.end method

.method public draw(android.graphics.Canvas)void
    .registers 6
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->useSoftBlur Z
    if-eqz v0, +017h
    iget v0, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->blurRadius F
    iget v2, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    mul-float/2addr v1, v2
    iget v2, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->softBlurEdgeFraction F
    mul-float/2addr v1, v2
    add-float/2addr v0, v1
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerX F
    iget v2, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerY F
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v5, v1, v2, v0, v3, Landroid/graphics/Canvas;->drawCircle(F F F Landroid/graphics/Paint;)V
    goto +ch
    iget v0, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerX F
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerY F
    iget v2, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v5, v0, v1, v2, v3, Landroid/graphics/Canvas;->drawCircle(F F F Landroid/graphics/Paint;)V
    return-void 
.end method

.method public final getCircleScale()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    return v0
.end method

.method public getOpacity()int
    .registers 2
    # ins_size=1
    const/4 v0, -3
    return v0
.end method

.method protected onBoundsChange(android.graphics.Rect)void
    .registers 5
    # ins_size=2
    const-string v0, "bounds"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/graphics/Rect;->width()I
    move-result v0
    int-to-float v0, v0
    iget v1, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->radiusWidthRatio F
    mul-float/2addr v0, v1
    iput v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    iget v0, v4, Landroid/graphics/Rect;->left I
    int-to-float v0, v0
    invoke-virtual v4, Landroid/graphics/Rect;->width()I
    move-result v1
    int-to-float v1, v1
    const/high16 v2, 1073741824
    div-float/2addr v1, v2
    add-float/2addr v0, v1
    iput v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerX F
    iget v4, v4, Landroid/graphics/Rect;->bottom I
    iget v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->showHeight I
    sub-int/2addr v4, v0
    int-to-float v4, v4
    iget v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    add-float/2addr v4, v0
    iput v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->centerY F
    iget v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    mul-float/2addr v0, v4
    iput v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->updateGradientShader()V
    return-void 
.end method

.method public setAlpha(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setAlpha(I)V
    return-void 
.end method

.method public final setCircleColor(int[])void
    .registers 3
    # ins_size=2
    const-string v0, "colors"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->currentColors [I
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->updateGradientShader()V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public final setCircleScale(float)void
    .registers 5
    # ins_size=2
    iput v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v4
    invoke-virtual v4, Landroid/graphics/Rect;->width()I
    move-result v4
    int-to-float v4, v4
    iget v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->radiusWidthRatio F
    mul-float/2addr v4, v0
    iget v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleScale F
    mul-float/2addr v4, v0
    iput v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->circleRadius F
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->useMaskFilter Z
    if-eqz v4, +023h
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->useSoftBlur Z
    if-nez v4, +01fh
    iget v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->blurRadius F
    mul-float/2addr v4, v0
    const/4 v0, 0
    cmpl-float v0, v4, v0
    if-lez v0, +011h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    new-instance v1, Landroid/graphics/BlurMaskFilter;
    sget-object v2, Landroid/graphics/BlurMaskFilter$Blur;->NORMAL Landroid/graphics/BlurMaskFilter$Blur;
    invoke-direct v1, v4, v2, Landroid/graphics/BlurMaskFilter;-><init>(F Landroid/graphics/BlurMaskFilter$Blur;)V
    check-cast v1, Landroid/graphics/MaskFilter;
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setMaskFilter(Landroid/graphics/MaskFilter;)Landroid/graphics/MaskFilter;
    goto +7h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/graphics/Paint;->setMaskFilter(Landroid/graphics/MaskFilter;)Landroid/graphics/MaskFilter;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->updateGradientShader()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setColorFilter(android.graphics.ColorFilter)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    return-void 
.end method
