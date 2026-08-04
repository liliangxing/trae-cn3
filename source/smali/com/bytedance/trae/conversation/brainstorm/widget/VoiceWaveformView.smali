# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;
.super Landroid/view/View;
.source "VoiceWaveformView.kt"

.field private animationDurationMs:J
.field private animator:Landroid/animation/ValueAnimator;
.field private barCornerRadius:F
.field private barCornerRadiusDp:F
.field private barCount:I
.field private barGapDp:F
.field private barGapPx:F
.field private barHeights:[F
.field private barLerpFactor:F
.field private final barRect:Landroid/graphics/RectF;
.field private barWidthDp:F
.field private barWidthPx:F
.field private currentVolume:F
.field private final density:F
.field private envelopeMin:F
.field private envelopeWeights:[F
.field private gradientBottomColor:I
.field private gradientTopColor:I
.field private idleWaveRatio:F
.field private isAnimating:Z
.field private jitterStrength:F
.field private maxBarHeight:F
.field private maxBarHeightDp:F
.field private minBarHeight:F
.field private minBarHeightDp:F
.field private final paint:Landroid/graphics/Paint;
.field private phaseOffsets:[F
.field private smoothedVolume:F
.field private targetHeights:[F
.field private volumeSensitivityPow:F
.field private volumeSmoothFactor:F


.method public static synthetic $r8$lambda$vyMwU9KWGNdtpoAnQmkvwbvjPOw(com.bytedance.trae.conversation.brainstorm.widget.VoiceWaveformView  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->startAnimating$lambda$1$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 8
    # ins_size=4
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, v6, v7, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    const/16 v5, 30
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    const/high16 v5, 1073741824
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barWidthDp F
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barGapDp F
    const/high16 v5, 1065353216
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCornerRadiusDp F
    const/high16 v5, 1113325568
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->maxBarHeightDp F
    const/high16 v5, 1084227584
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeightDp F
    const-wide/16 v5, 600
    iput-wide v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->animationDurationMs J
    const v5, 1053609165
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->volumeSmoothFactor F
    const/high16 v5, 1056964608
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->volumeSensitivityPow F
    const v5, 1051931443
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barLerpFactor F
    const v5, 1061997773
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->jitterStrength F
    const/high16 v5, 1048576000
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->envelopeMin F
    const v5, 1022739087
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->idleWaveRatio F
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->density F
    iget v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barWidthDp F
    mul-float/2addr v6, v5
    iput v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barWidthPx F
    iget v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barGapDp F
    mul-float/2addr v6, v5
    iput v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barGapPx F
    iget v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCornerRadiusDp F
    mul-float/2addr v6, v5
    iput v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCornerRadius F
    iget v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->maxBarHeightDp F
    mul-float/2addr v6, v5
    iput v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->maxBarHeight F
    iget v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeightDp F
    mul-float/2addr v6, v5
    iput v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    new-instance v5, Landroid/graphics/Paint;
    const/4 v6, 1
    invoke-direct v5, v6, Landroid/graphics/Paint;-><init>(I)V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->paint Landroid/graphics/Paint;
    new-instance v5, Landroid/graphics/RectF;
    invoke-direct v5, Landroid/graphics/RectF;-><init>()V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barRect Landroid/graphics/RectF;
    const v5, -15066339
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->gradientTopColor I
    const v5, -9078141
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->gradientBottomColor I
    iget v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    new-array v6, v5, [F
    const/4 v7, 0
    move v0, v7
    if-ge v0, v5, +009h
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    aput v1, v6, v0
    add-int/lit8 v0, v0, 1
    goto -8h
    iput-object v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barHeights [F
    iget v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    new-array v6, v5, [F
    move v0, v7
    if-ge v0, v5, +009h
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    aput v1, v6, v0
    add-int/lit8 v0, v0, 1
    goto -8h
    iput-object v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->targetHeights [F
    iget v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    new-array v6, v5, [F
    if-ge v7, v5, +015h
    invoke-static Ljava/lang/Math;->random()D
    move-result-wide v0
    const-wide v2, 4614256656552045848
    mul-double/2addr v0, v2
    const/4 v2, 2
    int-to-double v2, v2
    mul-double/2addr v0, v2
    double-to-float v0, v0
    aput v0, v6, v7
    add-int/lit8 v7, v7, 1
    goto -14h
    iput-object v6, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->phaseOffsets [F
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->buildEnvelopeWeights()[F
    move-result-object v5
    iput-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->envelopeWeights [F
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->updateGradient()V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final buildEnvelopeWeights()float[]
    .registers 11
    # ins_size=1
    iget v0, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    new-array v1, v0, [F
    const/4 v2, 0
    if-ge v2, v0, +027h
    int-to-float v3, v2
    iget v4, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    add-int/lit8 v4, v4, -1
    int-to-float v4, v4
    div-float/2addr v3, v4
    const/high16 v4, 1073741824
    mul-float/2addr v3, v4
    const/high16 v5, 1065353216
    sub-float/2addr v3, v5
    float-to-double v6, v3
    const-wide v8, 4614256656552045848
    mul-double/2addr v6, v8
    invoke-static v6, v7, Ljava/lang/Math;->cos(D)D
    move-result-wide v6
    double-to-float v3, v6
    add-float/2addr v3, v5
    div-float/2addr v3, v4
    iget v4, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->envelopeMin F
    sub-float/2addr v5, v4
    mul-float/2addr v5, v3
    add-float/2addr v4, v5
    aput v4, v1, v2
    add-int/lit8 v2, v2, 1
    goto -26h
    return-object v1
.end method

.method private final rebuildBarArrays()void
    .registers 8
    # ins_size=1
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    new-array v1, v0, [F
    const/4 v2, 0
    move v3, v2
    if-ge v3, v0, +009h
    iget v4, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    aput v4, v1, v3
    add-int/lit8 v3, v3, 1
    goto -8h
    iput-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barHeights [F
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    new-array v1, v0, [F
    move v3, v2
    if-ge v3, v0, +009h
    iget v4, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    aput v4, v1, v3
    add-int/lit8 v3, v3, 1
    goto -8h
    iput-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->targetHeights [F
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    new-array v1, v0, [F
    if-ge v2, v0, +015h
    invoke-static Ljava/lang/Math;->random()D
    move-result-wide v3
    const-wide v5, 4614256656552045848
    mul-double/2addr v3, v5
    const/4 v5, 2
    int-to-double v5, v5
    mul-double/2addr v3, v5
    double-to-float v3, v3
    aput v3, v1, v2
    add-int/lit8 v2, v2, 1
    goto -14h
    iput-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->phaseOffsets [F
    invoke-direct v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->buildEnvelopeWeights()[F
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->envelopeWeights [F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->invalidate()V
    return-void 
.end method

.method private static final startAnimating$lambda$1$lambda$0(com.bytedance.trae.conversation.brainstorm.widget.VoiceWaveformView  android.animation.ValueAnimator)void
    .registers 10
    # ins_size=2
    const-string v0, "anim"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v9
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Ljava/lang/Float;
    invoke-virtual v9, Ljava/lang/Float;->floatValue()F
    move-result v9
    iget v0, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->smoothedVolume F
    iget v1, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->currentVolume F
    sub-float/2addr v1, v0
    iget v2, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->volumeSmoothFactor F
    mul-float/2addr v1, v2
    add-float/2addr v0, v1
    iput v0, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->smoothedVolume F
    iget v1, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->idleWaveRatio F
    const/high16 v2, 1065353216
    sub-float v3, v2, v1
    float-to-double v4, v0
    iget v0, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->volumeSensitivityPow F
    float-to-double v6, v0
    invoke-static v4, v5, v6, v7, Ljava/lang/Math;->pow(D D)D
    move-result-wide v4
    double-to-float v0, v4
    mul-float/2addr v3, v0
    add-float/2addr v1, v3
    const/4 v0, 0
    invoke-static v1, v0, v2, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v0
    iget v1, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->maxBarHeight F
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    sub-float/2addr v1, v3
    mul-float/2addr v1, v0
    iget v0, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    const/4 v3, 0
    if-ge v3, v0, +048h
    float-to-double v4, v9
    const-wide v6, 4614256656552045848
    mul-double/2addr v4, v6
    const/4 v6, 2
    int-to-double v6, v6
    mul-double/2addr v4, v6
    iget-object v6, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->phaseOffsets [F
    aget v6, v6, v3
    float-to-double v6, v6
    add-double/2addr v4, v6
    invoke-static v4, v5, Ljava/lang/Math;->sin(D)D
    move-result-wide v4
    const-wide/high16 v6, 4602678819172646912
    mul-double/2addr v4, v6
    add-double/2addr v4, v6
    double-to-float v4, v4
    invoke-static Ljava/lang/Math;->random()D
    move-result-wide v5
    double-to-float v5, v5
    const/high16 v6, 1056964608
    sub-float/2addr v5, v6
    iget v6, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->jitterStrength F
    mul-float/2addr v5, v6
    const/high16 v7, 1048576000
    mul-float/2addr v6, v7
    sub-float v6, v2, v6
    add-float/2addr v5, v6
    iget-object v6, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->targetHeights [F
    iget v7, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    mul-float/2addr v4, v1
    mul-float/2addr v4, v5
    iget-object v5, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->envelopeWeights [F
    aget v5, v5, v3
    mul-float/2addr v4, v5
    add-float/2addr v7, v4
    aput v7, v6, v3
    iget-object v4, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barHeights [F
    aget v5, v4, v3
    sub-float/2addr v7, v5
    iget v6, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barLerpFactor F
    mul-float/2addr v7, v6
    add-float/2addr v5, v7
    aput v5, v4, v3
    add-int/lit8 v3, v3, 1
    goto -47h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->invalidate()V
    return-void 
.end method

.method private final updateGradient()void
    .registers 11
    # ins_size=1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->getHeight()I
    move-result v0
    if-lez v0, +01dh
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->paint Landroid/graphics/Paint;
    new-instance v9, Landroid/graphics/LinearGradient;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->getHeight()I
    move-result v1
    int-to-float v5, v1
    iget v6, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->gradientTopColor I
    iget v7, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->gradientBottomColor I
    sget-object v8, Landroid/graphics/Shader$TileMode;->CLAMP Landroid/graphics/Shader$TileMode;
    move-object v1, v9
    invoke-direct/range v1 ... v8, Landroid/graphics/LinearGradient;-><init>(F F F F I I Landroid/graphics/Shader$TileMode;)V
    check-cast v9, Landroid/graphics/Shader;
    invoke-virtual v0, v9, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroid/view/View;->onDetachedFromWindow()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->stopAnimating()V
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 12
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v10, v11, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->paint Landroid/graphics/Paint;
    invoke-virtual v0, Landroid/graphics/Paint;->getShader()Landroid/graphics/Shader;
    move-result-object v0
    if-nez v0, +005h
    invoke-direct v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->updateGradient()V
    iget v0, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    int-to-float v1, v0
    iget v2, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barWidthPx F
    mul-float/2addr v1, v2
    add-int/lit8 v0, v0, -1
    int-to-float v0, v0
    iget v2, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barGapPx F
    mul-float/2addr v0, v2
    add-float/2addr v1, v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->getWidth()I
    move-result v0
    int-to-float v0, v0
    sub-float/2addr v0, v1
    const/high16 v1, 1073741824
    div-float/2addr v0, v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->getHeight()I
    move-result v2
    int-to-float v2, v2
    div-float/2addr v2, v1
    iget v3, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    const/4 v4, 0
    if-ge v4, v3, +024h
    int-to-float v5, v4
    iget v6, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barWidthPx F
    iget v7, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barGapPx F
    add-float/2addr v7, v6
    mul-float/2addr v5, v7
    add-float/2addr v5, v0
    iget-object v7, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barHeights [F
    aget v7, v7, v4
    div-float/2addr v7, v1
    iget-object v8, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barRect Landroid/graphics/RectF;
    sub-float v9, v2, v7
    add-float/2addr v6, v5
    add-float/2addr v7, v2
    invoke-virtual v8, v5, v9, v6, v7, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v5, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barRect Landroid/graphics/RectF;
    iget v6, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCornerRadius F
    iget-object v7, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->paint Landroid/graphics/Paint;
    invoke-virtual v11, v5, v6, v6, v7, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    add-int/lit8 v4, v4, 1
    goto -23h
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroid/view/View;->onSizeChanged(I I I I)V
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->updateGradient()V
    return-void 
.end method

.method public final setAnimationDuration(long)void
    .registers 5
    # ins_size=3
    const-wide/16 v0, 100
    invoke-static v3, v4, v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v3
    iput-wide v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->animationDurationMs J
    return-void 
.end method

.method public final setBarCount(int)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-static v2, v0, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->rebuildBarArrays()V
    return-void 
.end method

.method public final setBarDimensions(float  float  float)void
    .registers 5
    # ins_size=4
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barWidthDp F
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barGapDp F
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCornerRadiusDp F
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->density F
    mul-float/2addr v2, v0
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barWidthPx F
    mul-float/2addr v3, v0
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barGapPx F
    mul-float/2addr v4, v0
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCornerRadius F
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->invalidate()V
    return-void 
.end method

.method public final setBarHeightRange(float  float)void
    .registers 4
    # ins_size=3
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeightDp F
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->maxBarHeightDp F
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->density F
    mul-float/2addr v2, v0
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    mul-float/2addr v3, v0
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->maxBarHeight F
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->rebuildBarArrays()V
    return-void 
.end method

.method public final setBarLerpFactor(float)void
    .registers 4
    # ins_size=2
    const v0, 1008981770
    const/high16 v1, 1065353216
    invoke-static v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barLerpFactor F
    return-void 
.end method

.method public final setEnvelopeMin(float)void
    .registers 4
    # ins_size=2
    const/4 v0, 0
    const/high16 v1, 1065353216
    invoke-static v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->envelopeMin F
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->buildEnvelopeWeights()[F
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->envelopeWeights [F
    return-void 
.end method

.method public final setIdleWaveRatio(float)void
    .registers 4
    # ins_size=2
    const/4 v0, 0
    const/high16 v1, 1065353216
    invoke-static v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->idleWaveRatio F
    return-void 
.end method

.method public final setJitterStrength(float)void
    .registers 4
    # ins_size=2
    const/4 v0, 0
    const/high16 v1, 1065353216
    invoke-static v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->jitterStrength F
    return-void 
.end method

.method public final setVolumeSensitivityPow(float)void
    .registers 4
    # ins_size=2
    const v0, 1036831949
    const/high16 v1, 1065353216
    invoke-static v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->volumeSensitivityPow F
    return-void 
.end method

.method public final setVolumeSmoothFactor(float)void
    .registers 4
    # ins_size=2
    const v0, 1008981770
    const/high16 v1, 1065353216
    invoke-static v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->volumeSmoothFactor F
    return-void 
.end method

.method public final setWaveColors(int  int)void
    .registers 3
    # ins_size=3
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->gradientTopColor I
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->gradientBottomColor I
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->updateGradient()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->invalidate()V
    return-void 
.end method

.method public final startAnimating()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->isAnimating Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->isAnimating Z
    const/4 v0, 2
    new-array v0, v0, [F
    fill-array-data v0, +0000029h
    invoke-static v0, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->animationDurationMs J
    invoke-virtual v0, v1, v2, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    const/4 v1, -1
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setRepeatCount(I)V
    new-instance v1, Landroid/view/animation/LinearInterpolator;
    invoke-direct v1, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;)V
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->animator Landroid/animation/ValueAnimator;
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method public final stopAnimating()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->isAnimating Z
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->animator Landroid/animation/ValueAnimator;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v1, 0
    iput-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->animator Landroid/animation/ValueAnimator;
    const/4 v1, 0
    iput v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->currentVolume F
    iput v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->smoothedVolume F
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barCount I
    if-ge v0, v1, +00bh
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->barHeights [F
    iget v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->minBarHeight F
    aput v3, v2, v0
    add-int/lit8 v0, v0, 1
    goto -ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->invalidate()V
    return-void 
.end method

.method public final updateVolume(float)void
    .registers 4
    # ins_size=2
    const/4 v0, 0
    const/high16 v1, 1065353216
    invoke-static v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;->currentVolume F
    return-void 
.end method
