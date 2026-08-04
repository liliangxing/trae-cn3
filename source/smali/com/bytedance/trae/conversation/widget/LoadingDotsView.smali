# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/LoadingDotsView;
.super Landroid/view/View;
.source "LoadingDotsView.kt"

.field private animatorSet:Landroid/animation/AnimatorSet;
.field private dotAlphas:[F
.field private dotColor:I
.field private dotCount:I
.field private dotScales:[F
.field private dotSizePx:F
.field private dotSpacingPx:F
.field private final paint:Landroid/graphics/Paint;


.method public static synthetic $r8$lambda$8f0cuWcwA5uHtd97p5L3sz7HEok(com.bytedance.trae.conversation.widget.LoadingDotsView  int  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->startAnimation$lambda$5$lambda$4$lambda$3(Lcom/bytedance/trae/conversation/widget/LoadingDotsView; I Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$q40PIQ5azH0egPkdqseA-n3i1nQ(com.bytedance.trae.conversation.widget.LoadingDotsView  int  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->startAnimation$lambda$5$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/widget/LoadingDotsView; I Landroid/animation/ValueAnimator;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, v4, v5, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    const-string v3, "#333333"
    invoke-static v3, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotColor I
    const/high16 v3, 1090519040
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dpToPx(F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSizePx F
    const/4 v3, 2
    iput v3, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    const/high16 v3, 1082130432
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dpToPx(F)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSpacingPx F
    new-instance v3, Landroid/graphics/Paint;
    const/4 v4, 1
    invoke-direct v3, v4, Landroid/graphics/Paint;-><init>(I)V
    iget v4, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotColor I
    invoke-virtual v3, v4, Landroid/graphics/Paint;->setColor(I)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->paint Landroid/graphics/Paint;
    iget v3, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    new-array v4, v3, [F
    const/4 v5, 0
    move v0, v5
    const/high16 v1, 1065353216
    if-ge v0, v3, +007h
    aput v1, v4, v0
    add-int/lit8 v0, v0, 1
    goto -8h
    iput-object v4, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotAlphas [F
    iget v3, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    new-array v4, v3, [F
    if-ge v5, v3, +007h
    aput v1, v4, v5
    add-int/lit8 v5, v5, 1
    goto -6h
    iput-object v4, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotScales [F
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final dpToPx(float)float
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v0
    return v2
.end method

.method private static final startAnimation$lambda$5$lambda$2$lambda$1(com.bytedance.trae.conversation.widget.LoadingDotsView  int  android.animation.ValueAnimator)void
    .registers 5
    # ins_size=3
    const-string v0, "it"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotAlphas [F
    invoke-virtual v4, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v4
    const-string v1, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Float;
    invoke-virtual v4, Ljava/lang/Float;->floatValue()F
    move-result v4
    aput v4, v0, v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->invalidate()V
    return-void 
.end method

.method private static final startAnimation$lambda$5$lambda$4$lambda$3(com.bytedance.trae.conversation.widget.LoadingDotsView  int  android.animation.ValueAnimator)void
    .registers 4
    # ins_size=3
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotScales [F
    invoke-virtual v3, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v3
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Float;
    invoke-virtual v3, Ljava/lang/Float;->floatValue()F
    move-result v3
    aput v3, v1, v2
    return-void 
.end method

.method public final getDotColor()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotColor I
    return v0
.end method

.method public final getDotCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    return v0
.end method

.method public final getDotSizePx()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSizePx F
    return v0
.end method

.method public final getDotSpacingPx()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSpacingPx F
    return v0
.end method

.method protected onAttachedToWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroid/view/View;->onAttachedToWindow()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->startAnimation()V
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->stopAnimation()V
    invoke-super v0, Landroid/view/View;->onDetachedFromWindow()V
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 11
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v9, v10, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    iget v0, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSizePx F
    const/high16 v1, 1073741824
    div-float/2addr v0, v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->getPaddingLeft()I
    move-result v1
    int-to-float v1, v1
    add-float/2addr v1, v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->getPaddingTop()I
    move-result v2
    int-to-float v2, v2
    add-float/2addr v2, v0
    iget v3, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    const/4 v4, 0
    if-ge v4, v3, +025h
    int-to-float v5, v4
    iget v6, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSizePx F
    iget v7, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSpacingPx F
    add-float/2addr v6, v7
    mul-float/2addr v5, v6
    add-float/2addr v5, v1
    iget-object v6, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->paint Landroid/graphics/Paint;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotAlphas [F
    aget v7, v7, v4
    const/16 v8, 255
    int-to-float v8, v8
    mul-float/2addr v7, v8
    float-to-int v7, v7
    invoke-virtual v6, v7, Landroid/graphics/Paint;->setAlpha(I)V
    iget-object v6, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotScales [F
    aget v6, v6, v4
    mul-float/2addr v6, v0
    iget-object v7, v9, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->paint Landroid/graphics/Paint;
    invoke-virtual v10, v5, v2, v6, v7, Landroid/graphics/Canvas;->drawCircle(F F F Landroid/graphics/Paint;)V
    add-int/lit8 v4, v4, 1
    goto -24h
    return-void 
.end method

.method protected onMeasure(int  int)void
    .registers 6
    # ins_size=3
    iget v0, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSizePx F
    iget v1, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    int-to-float v2, v1
    mul-float/2addr v0, v2
    iget v2, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSpacingPx F
    add-int/lit8 v1, v1, -1
    int-to-float v1, v1
    mul-float/2addr v2, v1
    add-float/2addr v0, v2
    float-to-int v0, v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->getPaddingLeft()I
    move-result v1
    add-int/2addr v0, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->getPaddingRight()I
    move-result v1
    add-int/2addr v0, v1
    iget v1, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSizePx F
    float-to-int v1, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->getPaddingTop()I
    move-result v2
    add-int/2addr v1, v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->getPaddingBottom()I
    move-result v2
    add-int/2addr v1, v2
    invoke-static v0, v4, Landroid/view/View;->resolveSize(I I)I
    move-result v4
    invoke-static v1, v5, Landroid/view/View;->resolveSize(I I)I
    move-result v5
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->setMeasuredDimension(I I)V
    return-void 
.end method

.method protected onVisibilityChanged(android.view.View  int)void
    .registers 4
    # ins_size=3
    const-string v0, "changedView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroid/view/View;->onVisibilityChanged(Landroid/view/View; I)V
    if-nez v3, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->startAnimation()V
    goto +4h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->stopAnimation()V
    return-void 
.end method

.method public final setDotColor(int)void
    .registers 3
    # ins_size=2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotColor I
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->invalidate()V
    return-void 
.end method

.method public final setDotCount(int)void
    .registers 6
    # ins_size=2
    iput v5, v4, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    new-array v0, v5, [F
    const/4 v1, 0
    move v2, v1
    const/high16 v3, 1065353216
    if-ge v2, v5, +007h
    aput v3, v0, v2
    add-int/lit8 v2, v2, 1
    goto -8h
    iput-object v0, v4, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotAlphas [F
    new-array v0, v5, [F
    if-ge v1, v5, +007h
    aput v3, v0, v1
    add-int/lit8 v1, v1, 1
    goto -6h
    iput-object v0, v4, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotScales [F
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->requestLayout()V
    return-void 
.end method

.method public final setDotSizePx(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSizePx F
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->requestLayout()V
    return-void 
.end method

.method public final setDotSpacingPx(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotSpacingPx F
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->requestLayout()V
    return-void 
.end method

.method public final startAnimation()void
    .registers 14
    # ins_size=1
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->stopAnimation()V
    iget v0, v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotCount I
    const/4 v1, 0
    invoke-static v1, v0, Lkotlin/ranges/RangesKt;->until(I I)Lkotlin/ranges/IntRange;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v0, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +087h
    move-object v3, v0
    check-cast v3, Lkotlin/collections/IntIterator;
    invoke-virtual v3, Lkotlin/collections/IntIterator;->nextInt()I
    move-result v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "dotAlpha"
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 3
    new-array v6, v5, [F
    fill-array-data v6, +0000084h
    invoke-static v13, v4, v6, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Ljava/lang/String; [F)Landroid/animation/ObjectAnimator;
    move-result-object v4
    const-wide/16 v6, 1400
    invoke-virtual v4, v6, v7, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    mul-int/lit16 v8, v3, 200
    int-to-long v8, v8
    invoke-virtual v4, v8, v9, Landroid/animation/ObjectAnimator;->setStartDelay(J)V
    const/4 v10, -1
    invoke-virtual v4, v10, Landroid/animation/ObjectAnimator;->setRepeatCount(I)V
    new-instance v11, Landroid/view/animation/AccelerateDecelerateInterpolator;
    invoke-direct v11, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V
    check-cast v11, Landroid/animation/TimeInterpolator;
    invoke-virtual v4, v11, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v11, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda0;
    invoke-direct v11, v13, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/LoadingDotsView; I)V
    invoke-virtual v4, v11, Landroid/animation/ObjectAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "dotScale"
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    new-array v5, v5, [F
    fill-array-data v5, +0000055h
    invoke-static v13, v11, v5, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Ljava/lang/String; [F)Landroid/animation/ObjectAnimator;
    move-result-object v5
    invoke-virtual v5, v6, v7, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    invoke-virtual v5, v8, v9, Landroid/animation/ObjectAnimator;->setStartDelay(J)V
    invoke-virtual v5, v10, Landroid/animation/ObjectAnimator;->setRepeatCount(I)V
    new-instance v6, Landroid/view/animation/AccelerateDecelerateInterpolator;
    invoke-direct v6, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V
    check-cast v6, Landroid/animation/TimeInterpolator;
    invoke-virtual v5, v6, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v6, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda1;
    invoke-direct v6, v13, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/LoadingDotsView; I)V
    invoke-virtual v5, v6, Landroid/animation/ObjectAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    const/4 v3, 2
    new-array v3, v3, [Landroid/animation/ObjectAnimator;
    aput-object v4, v3, v1
    const/4 v4, 1
    aput-object v5, v3, v4
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -089h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->flatten(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    new-instance v1, Landroid/animation/AnimatorSet;
    invoke-direct v1, Landroid/animation/AnimatorSet;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-virtual v1, v0, Landroid/animation/AnimatorSet;->playTogether(Ljava/util/Collection;)V
    invoke-virtual v1, Landroid/animation/AnimatorSet;->start()V
    iput-object v1, v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->animatorSet Landroid/animation/AnimatorSet;
    return-void 
    fill-array-data-payload b'\x00\x00\x80?\x9a\x99\x99>\x00\x00\x80?' | \x00\x00\x80\x3f\x9a\x99\x99\x3e\x00\x00\x80\x3f
    fill-array-data-payload b'\x00\x00\x80?\x9a\x99Y?\x00\x00\x80?' | \x00\x00\x80\x3f\x9a\x99\x59\x3f\x00\x00\x80\x3f
.end method

.method public final stopAnimation()void
    .registers 14
    # ins_size=1
    iget-object v0, v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->animatorSet Landroid/animation/AnimatorSet;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/AnimatorSet;->cancel()V
    const/4 v0, 0
    iput-object v0, v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->animatorSet Landroid/animation/AnimatorSet;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotAlphas [F
    const/high16 v2, 1065353216
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlin/collections/ArraysKt;->fill$default([F F I I I Ljava/lang/Object;)V
    iget-object v7, v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->dotScales [F
    const/high16 v8, 1065353216
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 6
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlin/collections/ArraysKt;->fill$default([F F I I I Ljava/lang/Object;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->invalidate()V
    return-void 
.end method
