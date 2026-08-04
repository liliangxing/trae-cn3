# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
.super Landroid/view/View;
.source "TraeTitleBar.kt"

.field private animator:Landroid/animation/ValueAnimator;
.field private onTabSelected:Lkotlin/jvm/functions/Function2;
.field private final outerPaint:Landroid/graphics/Paint;
.field private final outerRadius:F
.field private final outerRect:Landroid/graphics/RectF;
.field private final padding:F
.field private final segmentHeight:I
.field private final segmentWidth:I
.field private selectedIndex:I
.field private selectedLeft:F
.field private final selectedPaint:Landroid/graphics/Paint;
.field private final selectedRadius:F
.field private final selectedRect:Landroid/graphics/RectF;
.field private final selectedWidth:I
.field private final shadowDy:F
.field private final shadowRadius:F
.field private final slotWidth:I
.field private final tabs:Ljava/util/List;
.field private final textPaint:Landroid/graphics/Paint;


.method public static synthetic $r8$lambda$jklFdE2qUI0cBBKEe-a6Ug2ZXYU(com.bytedance.trae.common.widget.TitleBarSegmentedControl  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->animateSelection$lambda$5$lambda$4(Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl; Landroid/animation/ValueAnimator;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 8
    # ins_size=4
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, v6, v7, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    const-string v6, "Work"
    const-string v7, "Code"
    filled-new-array v6, v7, [Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->tabs Ljava/util/List;
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_segment_width I
    invoke-virtual v6, v7, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v6
    iput v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->segmentWidth I
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_page_height I
    invoke-virtual v6, v7, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v6
    iput v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->segmentHeight I
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_segment_slot_width I
    invoke-virtual v7, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    iput v7, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->slotWidth I
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_segment_padding I
    invoke-virtual v7, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    int-to-float v7, v7
    iput v7, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->padding F
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_segment_selected_width I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    iput v0, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedWidth I
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_segment_shadow_blur_radius I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimension(I)F
    move-result v0
    iput v0, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->shadowRadius F
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_shadow_offset_y I
    invoke-virtual v1, v2, Landroid/content/res/Resources;->getDimension(I)F
    move-result v1
    iput v1, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->shadowDy F
    int-to-float v2, v6
    const/high16 v3, 1073741824
    div-float/2addr v2, v3
    iput v2, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->outerRadius F
    int-to-float v6, v6
    mul-float/2addr v7, v3
    sub-float/2addr v6, v7
    div-float/2addr v6, v3
    iput v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedRadius F
    iget v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedIndex I
    invoke-direct v4, v6, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectionLeftFor(I)F
    move-result v6
    iput v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedLeft F
    new-instance v6, Landroid/graphics/RectF;
    invoke-direct v6, Landroid/graphics/RectF;-><init>()V
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->outerRect Landroid/graphics/RectF;
    new-instance v6, Landroid/graphics/RectF;
    invoke-direct v6, Landroid/graphics/RectF;-><init>()V
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedRect Landroid/graphics/RectF;
    new-instance v6, Landroid/graphics/Paint;
    const/4 v7, 1
    invoke-direct v6, v7, Landroid/graphics/Paint;-><init>(I)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l3 I
    invoke-static v5, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v6, v2, Landroid/graphics/Paint;->setColor(I)V
    sget-object v2, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v6, v2, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->outerPaint Landroid/graphics/Paint;
    new-instance v6, Landroid/graphics/Paint;
    invoke-direct v6, v7, Landroid/graphics/Paint;-><init>(I)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_menu I
    invoke-static v5, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v6, v2, Landroid/graphics/Paint;->setColor(I)V
    sget-object v2, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v6, v2, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_shadow I
    invoke-static v5, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    const/4 v3, 0
    invoke-virtual v6, v0, v3, v1, v2, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedPaint Landroid/graphics/Paint;
    new-instance v6, Landroid/graphics/Paint;
    invoke-direct v6, v7, Landroid/graphics/Paint;-><init>(I)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v5, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v6, v5, Landroid/graphics/Paint;->setColor(I)V
    sget-object v5, Landroid/graphics/Paint$Align;->CENTER Landroid/graphics/Paint$Align;
    invoke-virtual v6, v5, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V
    const-string/jumbo v5, sans-serif-medium
    const/4 v0, 0
    invoke-static v5, v0, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v5
    invoke-virtual v6, v5, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_xs_font_size_sp I
    invoke-virtual v5, v0, Landroid/content/res/Resources;->getDimension(I)F
    move-result v5
    invoke-virtual v6, v5, Landroid/graphics/Paint;->setTextSize(F)V
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->textPaint Landroid/graphics/Paint;
    invoke-virtual v4, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setClickable(Z)V
    invoke-virtual v4, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setFocusable(Z)V
    const/4 v5, 0
    invoke-virtual v4, v7, v5, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setLayerType(I Landroid/graphics/Paint;)V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final animateSelection(float  float)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 2
    new-array v0, v0, [F
    const/4 v1, 0
    aput v3, v0, v1
    const/4 v3, 1
    aput v4, v0, v3
    invoke-static v0, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v3
    const-wide/16 v0, 250
    invoke-virtual v3, v0, v1, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v4, Landroid/view/animation/DecelerateInterpolator;
    const/high16 v0, 1069547520
    invoke-direct v4, v0, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V
    check-cast v4, Landroid/animation/TimeInterpolator;
    invoke-virtual v3, v4, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl$$ExternalSyntheticLambda0;
    invoke-direct v4, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;)V
    invoke-virtual v3, v4, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v3, Landroid/animation/ValueAnimator;->start()V
    iput-object v3, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->animator Landroid/animation/ValueAnimator;
    return-void 
.end method

.method private static final animateSelection$lambda$5$lambda$4(com.bytedance.trae.common.widget.TitleBarSegmentedControl  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Float;
    invoke-virtual v2, Ljava/lang/Float;->floatValue()F
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedLeft F
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->invalidate()V
    return-void 
.end method

.method private final selectionLeftFor(int)float
    .registers 4
    # ins_size=2
    iget v0, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->slotWidth I
    mul-int/2addr v3, v0
    int-to-float v3, v3
    iget v1, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedWidth I
    sub-int/2addr v0, v1
    int-to-float v0, v0
    const/high16 v1, 1073741824
    div-float/2addr v0, v1
    add-float/2addr v3, v0
    return v3
.end method

.method public static synthetic setSelectedIndex$default(com.bytedance.trae.common.widget.TitleBarSegmentedControl  int  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setSelectedIndex(I Z)V
    return-void 
.end method

.method public final getOnTabSelected()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->onTabSelected Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getSelectedIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedIndex I
    return v0
.end method

.method public final getSelectedTab()java.lang.CharSequence
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->tabs Ljava/util/List;
    iget v1, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedIndex I
    invoke-interface v0, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    return-object v0
.end method

.method protected onDetachedFromWindow()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroid/view/View;->onDetachedFromWindow()V
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->animator Landroid/animation/ValueAnimator;
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 9
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v7, v8, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->outerRect Landroid/graphics/RectF;
    invoke-virtual v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getWidth()I
    move-result v1
    int-to-float v1, v1
    invoke-virtual v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getHeight()I
    move-result v2
    int-to-float v2, v2
    const/4 v3, 0
    invoke-virtual v0, v3, v3, v1, v2, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->outerRect Landroid/graphics/RectF;
    iget v1, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->outerRadius F
    iget-object v2, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->outerPaint Landroid/graphics/Paint;
    invoke-virtual v8, v0, v1, v1, v2, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedRect Landroid/graphics/RectF;
    iget v1, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedLeft F
    iget v2, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->padding F
    iget v3, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedWidth I
    int-to-float v3, v3
    add-float/2addr v3, v1
    invoke-virtual v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getHeight()I
    move-result v4
    int-to-float v4, v4
    iget v5, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->padding F
    sub-float/2addr v4, v5
    invoke-virtual v0, v1, v2, v3, v4, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedRect Landroid/graphics/RectF;
    iget v1, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedRadius F
    iget-object v2, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedPaint Landroid/graphics/Paint;
    invoke-virtual v8, v0, v1, v1, v2, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    invoke-virtual v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getHeight()I
    move-result v0
    int-to-float v0, v0
    const/high16 v1, 1073741824
    div-float/2addr v0, v1
    iget-object v2, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->textPaint Landroid/graphics/Paint;
    invoke-virtual v2, Landroid/graphics/Paint;->ascent()F
    move-result v2
    iget-object v3, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->textPaint Landroid/graphics/Paint;
    invoke-virtual v3, Landroid/graphics/Paint;->descent()F
    move-result v3
    add-float/2addr v2, v3
    div-float/2addr v2, v1
    sub-float/2addr v0, v2
    iget-object v2, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->tabs Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const/4 v3, 0
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01dh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    add-int/lit8 v5, v3, 1
    if-gez v3, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v4, Ljava/lang/String;
    iget v6, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->slotWidth I
    mul-int/2addr v3, v6
    int-to-float v3, v3
    int-to-float v6, v6
    div-float/2addr v6, v1
    add-float/2addr v3, v6
    iget-object v6, v7, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->textPaint Landroid/graphics/Paint;
    invoke-virtual v8, v4, v3, v0, v6, Landroid/graphics/Canvas;->drawText(Ljava/lang/String; F F Landroid/graphics/Paint;)V
    move v3, v5
    goto -20h
    return-void 
.end method

.method protected onMeasure(int  int)void
    .registers 4
    # ins_size=3
    iget v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->segmentWidth I
    invoke-static v0, v2, Landroid/view/View;->resolveSize(I I)I
    move-result v2
    iget v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->segmentHeight I
    invoke-static v0, v3, Landroid/view/View;->resolveSize(I I)I
    move-result v3
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setMeasuredDimension(I I)V
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroid/view/View;->onSizeChanged(I I I I)V
    iget v1, v0, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedIndex I
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectionLeftFor(I)F
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedLeft F
    return-void 
.end method

.method public onTouchEvent(android.view.MotionEvent)boolean
    .registers 5
    # ins_size=2
    const-string v0, "event"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->isEnabled()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v4, Landroid/view/MotionEvent;->getAction()I
    move-result v0
    const/4 v2, 1
    if-eqz v0, +026h
    if-eq v0, v2, +007h
    invoke-super v3, v4, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z
    move-result v2
    goto +1eh
    invoke-virtual v4, Landroid/view/MotionEvent;->getX()F
    move-result v4
    iget v0, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->slotWidth I
    int-to-float v0, v0
    div-float/2addr v4, v0
    float-to-int v4, v4
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->tabs Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v0
    invoke-static v4, v1, v0, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v4
    iget v0, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedIndex I
    if-eq v4, v0, +005h
    invoke-virtual v3, v4, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setSelectedIndex(I Z)V
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->performClick()Z
    return v2
.end method

.method public performClick()boolean
    .registers 2
    # ins_size=1
    invoke-super v1, Landroid/view/View;->performClick()Z
    move-result v0
    return v0
.end method

.method public final setOnTabSelected(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->onTabSelected Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setSelectedIndex(int  boolean)void
    .registers 5
    # ins_size=3
    const/4 v0, 0
    if-ltz v3, +00dh
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->tabs Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->size()I
    move-result v1
    if-ge v3, v1, +003h
    const/4 v0, 1
    if-nez v0, +003h
    return-void 
    iget v0, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedIndex I
    iput v3, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedIndex I
    if-eqz v4, +016h
    if-eq v0, v3, +014h
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getWidth()I
    move-result v4
    if-lez v4, +00eh
    invoke-direct v2, v0, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectionLeftFor(I)F
    move-result v4
    invoke-direct v2, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectionLeftFor(I)F
    move-result v0
    invoke-direct v2, v4, v0, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->animateSelection(F F)V
    goto +ah
    invoke-direct v2, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectionLeftFor(I)F
    move-result v4
    iput v4, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->selectedLeft F
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->invalidate()V
    iget-object v4, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->onTabSelected Lkotlin/jvm/functions/Function2;
    if-eqz v4, +00fh
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->tabs Ljava/util/List;
    invoke-interface v1, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    invoke-interface v4, v0, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
