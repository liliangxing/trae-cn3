# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
.super Landroid/view/View;
.source "VoiceStatusWaveIconView.kt"

.field private static final BAR_COUNT:I
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$Companion;
.field private static final FAST_AMPLITUDE:F
.field private static final FAST_SPEED:F
.field private static final LERP:F
.field private static final NOISE_GATE:F
.field private static final SLOW_AMPLITUDE:F
.field private static final SLOW_SPEED:F
.field private static final SPEECH_REFERENCE:F
.field private static final VOLUME_WINDOW_SIZE:I
.field private amplitude:F
.field private animator:Landroid/animation/ValueAnimator;
.field private final barGap:F
.field private final barHeights:[F
.field private final barRect:Landroid/graphics/RectF;
.field private final barWidth:F
.field private final baseHeightsDp:[F
.field private final cornerRadius:F
.field private final density:F
.field private final floorHeight:F
.field private final maxHeight:F
.field private final minHeight:F
.field private final paint:Landroid/graphics/Paint;
.field private final phases:[F
.field private speed:F
.field private targetAmplitude:F
.field private targetSpeed:F
.field private final volumeWindow:Lkotlin/collections/ArrayDeque;
.field private waveTime:F


.method public static synthetic $r8$lambda$7rSFzwA4rab-iYbADbTWrQ5OvH4(com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->startAnimating$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$Companion;
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->density F
    new-instance v4, Landroid/graphics/Paint;
    const/4 v0, 1
    invoke-direct v4, v0, Landroid/graphics/Paint;-><init>(I)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v4, v2, Landroid/graphics/Paint;->setColor(I)V
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->paint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/RectF;
    invoke-direct v2, Landroid/graphics/RectF;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barRect Landroid/graphics/RectF;
    const/4 v2, 5
    new-array v4, v2, [F
    fill-array-data v4, +0000045h
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->baseHeightsDp [F
    new-array v4, v2, [F
    fill-array-data v4, +000004ch
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->phases [F
    new-array v2, v2, [F
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barHeights [F
    const/high16 v2, 1073741824
    mul-float v4, v3, v2
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barWidth F
    const/high16 v4, 1075838976
    mul-float/2addr v4, v3
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barGap F
    const/high16 v4, 1065353216
    mul-float/2addr v4, v3
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->cornerRadius F
    const/high16 v4, 1077936128
    mul-float/2addr v4, v3
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->floorHeight F
    mul-float/2addr v2, v3
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->minHeight F
    const/high16 v2, 1102053376
    mul-float/2addr v3, v2
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->maxHeight F
    const v2, 1022739087
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->speed F
    const/high16 v3, 1056964608
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->amplitude F
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetSpeed F
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetAmplitude F
    new-instance v2, Lkotlin/collections/ArrayDeque;
    invoke-direct v2, Lkotlin/collections/ArrayDeque;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->volumeWindow Lkotlin/collections/ArrayDeque;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->resetBarsToMin()V
    return-void 
    fill-array-data-payload b'\x00\x00\x00A\x00\x00`A\x00\x00\xa0A\x00\x00`A\x00\x00\x00A' | \x00\x00\x00\x41\x00\x00\x60\x41\x00\x00\xa0\x41\x00\x00\x60\x41\x00\x00\x00\x41
    fill-array-data-payload b'\x00\x00\x00\x00\x9a\x99\x99?\x9a\x99\x19@\x9a\x99\x99?\x00\x00\x00\x00' | \x00\x00\x00\x00\x9a\x99\x99\x3f\x9a\x99\x19\x40\x9a\x99\x99\x3f\x00\x00\x00\x00
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final normalizeVolume(float)float
    .registers 5
    # ins_size=2
    const v0, 1028443341
    cmpg-float v1, v4, v0
    const/4 v2, 0
    if-gtz v1, +003h
    return v2
    sub-float/2addr v4, v0
    const v0, 1050253721
    div-float/2addr v4, v0
    const/high16 v0, 1065353216
    invoke-static v4, v2, v0, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v4
    return v4
.end method

.method private final resetBarsToMin()void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 5
    if-ge v0, v1, +00bh
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barHeights [F
    iget v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->minHeight F
    aput v2, v1, v0
    add-int/lit8 v0, v0, 1
    goto -bh
    return-void 
.end method

.method private static final startAnimating$lambda$2$lambda$1(com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->updateFrame()V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->invalidate()V
    return-void 
.end method

.method private final updateFrame()void
    .registers 8
    # ins_size=1
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->speed F
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetSpeed F
    sub-float/2addr v1, v0
    const v2, 1025758986
    mul-float/2addr v1, v2
    add-float/2addr v0, v1
    iput v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->speed F
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->amplitude F
    iget v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetAmplitude F
    sub-float/2addr v3, v1
    mul-float/2addr v3, v2
    add-float/2addr v1, v3
    iput v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->amplitude F
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->waveTime F
    add-float/2addr v1, v0
    iput v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->waveTime F
    const/4 v0, 0
    const/4 v1, 5
    if-ge v0, v1, +044h
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->phases [F
    aget v1, v1, v0
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->baseHeightsDp [F
    aget v2, v2, v0
    iget v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->density F
    mul-float/2addr v2, v3
    iget v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->waveTime F
    add-float/2addr v3, v1
    float-to-double v3, v3
    invoke-static v3, v4, Ljava/lang/Math;->sin(D)D
    move-result-wide v3
    iget v5, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->waveTime F
    const v6, 1060320051
    mul-float/2addr v5, v6
    const v6, 1067869798
    mul-float/2addr v1, v6
    add-float/2addr v5, v1
    float-to-double v5, v5
    invoke-static v5, v6, Ljava/lang/Math;->cos(D)D
    move-result-wide v5
    mul-double/2addr v3, v5
    double-to-float v1, v3
    const/high16 v3, 1065353216
    add-float/2addr v1, v3
    const/high16 v3, 1073741824
    div-float/2addr v1, v3
    iget v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->floorHeight F
    sub-float/2addr v2, v3
    mul-float/2addr v2, v1
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->amplitude F
    mul-float/2addr v2, v1
    add-float/2addr v3, v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barHeights [F
    iget v2, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->minHeight F
    iget v4, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->maxHeight F
    invoke-static v3, v2, v4, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v2
    aput v2, v1, v0
    add-int/lit8 v0, v0, 1
    goto -44h
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroid/view/View;->onDetachedFromWindow()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->stopAnimating()V
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 12
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v10, v11, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    const/4 v0, 5
    int-to-float v1, v0
    iget v2, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barWidth F
    mul-float/2addr v1, v2
    const/4 v2, 4
    int-to-float v2, v2
    iget v3, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barGap F
    mul-float/2addr v2, v3
    add-float/2addr v1, v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->getWidth()I
    move-result v2
    int-to-float v2, v2
    sub-float/2addr v2, v1
    const/high16 v1, 1073741824
    div-float/2addr v2, v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->getHeight()I
    move-result v3
    int-to-float v3, v3
    div-float/2addr v3, v1
    const/4 v4, 0
    if-ge v4, v0, +024h
    int-to-float v5, v4
    iget v6, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barWidth F
    iget v7, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barGap F
    add-float/2addr v7, v6
    mul-float/2addr v5, v7
    add-float/2addr v5, v2
    iget-object v7, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barHeights [F
    aget v7, v7, v4
    div-float/2addr v7, v1
    iget-object v8, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barRect Landroid/graphics/RectF;
    sub-float v9, v3, v7
    add-float/2addr v6, v5
    add-float/2addr v7, v3
    invoke-virtual v8, v5, v9, v6, v7, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v5, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->barRect Landroid/graphics/RectF;
    iget v6, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->cornerRadius F
    iget-object v7, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->paint Landroid/graphics/Paint;
    invoke-virtual v11, v5, v6, v6, v7, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    add-int/lit8 v4, v4, 1
    goto -23h
    return-void 
.end method

.method public final setState(com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView$State)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +016h
    const/4 v0, 2
    if-ne v2, v0, +00dh
    const v2, 1039516303
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetSpeed F
    const v2, 1077097267
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetAmplitude F
    goto +10h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    const v2, 1022739087
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetSpeed F
    const/high16 v2, 1056964608
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetAmplitude F
    return-void 
.end method

.method public final setWaveColor(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->invalidate()V
    return-void 
.end method

.method public final startAnimating()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +003h
    return-void 
    const/4 v0, 2
    new-array v0, v0, [F
    fill-array-data v0, +0000028h
    invoke-static v0, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    const-wide/16 v1, 1000
    invoke-virtual v0, v1, v2, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    const/4 v1, -1
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setRepeatCount(I)V
    new-instance v1, Landroid/view/animation/LinearInterpolator;
    invoke-direct v1, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;)V
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->animator Landroid/animation/ValueAnimator;
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method public final stopAnimating()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->animator Landroid/animation/ValueAnimator;
    const v0, 1022739087
    iput v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->speed F
    const/high16 v1, 1056964608
    iput v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->amplitude F
    iput v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetSpeed F
    iput v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetAmplitude F
    const/4 v0, 0
    iput v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->waveTime F
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->volumeWindow Lkotlin/collections/ArrayDeque;
    invoke-virtual v0, Lkotlin/collections/ArrayDeque;->clear()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->resetBarsToMin()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->invalidate()V
    return-void 
.end method

.method public final updateVolume(float)void
    .registers 4
    # ins_size=2
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->normalizeVolume(F)F
    move-result v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->volumeWindow Lkotlin/collections/ArrayDeque;
    invoke-virtual v0, Lkotlin/collections/ArrayDeque;->size()I
    move-result v0
    const/16 v1, 8
    if-lt v0, v1, +007h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->volumeWindow Lkotlin/collections/ArrayDeque;
    invoke-virtual v0, Lkotlin/collections/ArrayDeque;->removeFirst()Ljava/lang/Object;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->volumeWindow Lkotlin/collections/ArrayDeque;
    invoke-static v3, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v3
    invoke-virtual v0, v3, Lkotlin/collections/ArrayDeque;->addLast(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->volumeWindow Lkotlin/collections/ArrayDeque;
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->maxOrNull(Ljava/lang/Iterable;)Ljava/lang/Float;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Float;->floatValue()F
    move-result v3
    goto +2h
    const/4 v3, 0
    const v0, 1035489771
    mul-float/2addr v0, v3
    const v1, 1022739087
    add-float/2addr v0, v1
    iput v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetSpeed F
    const v0, 1075000115
    mul-float/2addr v3, v0
    const/high16 v0, 1056964608
    add-float/2addr v3, v0
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->targetAmplitude F
    return-void 
.end method
