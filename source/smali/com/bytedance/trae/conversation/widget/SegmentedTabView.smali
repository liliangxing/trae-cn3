# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/SegmentedTabView;
.super Landroid/view/View;
.source "SegmentedTabView.kt"

.field private static final ANIM_DURATION_MS:J
.field public static final Companion:Lcom/bytedance/trae/conversation/widget/SegmentedTabView$Companion;
.field private static final DEFAULT_INNER_CORNER_RADIUS_DP:F
.field private static final DEFAULT_OUTER_CORNER_RADIUS_DP:F
.field private static final DEFAULT_OUTER_HEIGHT_DP:F
.field private static final DEFAULT_PADDING_DP:F
.field private static final DEFAULT_SHADOW_COLOR:Ljava/lang/String;
.field private static final DEFAULT_SHADOW_DY_DP:F
.field private static final DEFAULT_SHADOW_RADIUS_DP:F
.field private static final DEFAULT_TAB_MIN_WIDTH_DP:F
.field private static final DEFAULT_TEXT_SIZE_SP:F
.field public static final INDEX_CODE:I
.field public static final INDEX_MTC:I
.field private animatedSelectionX:F
.field private animator:Landroid/animation/ValueAnimator;
.field private innerCornerRadius:F
.field private innerPadding:F
.field private onTabSelected:Lkotlin/jvm/functions/Function2;
.field private outerBgColor:I
.field private final outerBgPaint:Landroid/graphics/Paint;
.field private outerCornerRadius:F
.field private final outerRect:Landroid/graphics/RectF;
.field private preferredHeight:F
.field private selectedBgColor:I
.field private final selectedBgPaint:Landroid/graphics/Paint;
.field private selectedIndex:I
.field private final selectedRect:Landroid/graphics/RectF;
.field private selectedTextColor:I
.field private final selectedTextPaint:Landroid/graphics/Paint;
.field private shadowColor:I
.field private shadowDy:F
.field private shadowRadius:F
.field private tabMinWidth:F
.field private tabs:Ljava/util/List;
.field private unselectedTextColor:I
.field private final unselectedTextPaint:Landroid/graphics/Paint;


.method public static synthetic $r8$lambda$DKXfeVbp99s-6QYgHrRyj1XdImU(com.bytedance.trae.conversation.widget.SegmentedTabView  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animateSelection$lambda$6$lambda$5(Lcom/bytedance/trae/conversation/widget/SegmentedTabView; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->Companion Lcom/bytedance/trae/conversation/widget/SegmentedTabView$Companion;
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    const-string v3, "Work"
    const-string v4, "Code"
    filled-new-array v3, v4, [Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    const/high16 v3, 1102053376
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v3
    iput v3, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerCornerRadius F
    const/high16 v3, 1099956224
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v3
    iput v3, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerCornerRadius F
    const/high16 v3, 1082130432
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v4
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerPadding F
    const/high16 v4, 1117782016
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v4
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabMinWidth F
    const/high16 v4, 1110441984
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v4
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->preferredHeight F
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l3 I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerBgColor I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgColor I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextColor I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextColor I
    const/high16 v2, 1097859072
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->shadowRadius F
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->shadowDy F
    const-string v2, "#08000000"
    invoke-static v2, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->shadowColor I
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    sget-object v4, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerBgPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    sget-object v4, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    sget-object v4, Landroid/graphics/Paint$Align;->CENTER Landroid/graphics/Paint$Align;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    sget-object v4, Landroid/graphics/Paint$Align;->CENTER Landroid/graphics/Paint$Align;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/RectF;
    invoke-direct v2, Landroid/graphics/RectF;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerRect Landroid/graphics/RectF;
    new-instance v2, Landroid/graphics/RectF;
    invoke-direct v2, Landroid/graphics/RectF;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedRect Landroid/graphics/RectF;
    const/4 v2, 0
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->setLayerType(I Landroid/graphics/Paint;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->applyPaintProperties()V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final animateSelection(int  int)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getSelectionX(I)F
    move-result v3
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getSelectionX(I)F
    move-result v4
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
    new-instance v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView$$ExternalSyntheticLambda0;
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/SegmentedTabView;)V
    invoke-virtual v3, v4, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v3, Landroid/animation/ValueAnimator;->start()V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animator Landroid/animation/ValueAnimator;
    return-void 
.end method

.method private static final animateSelection$lambda$6$lambda$5(com.bytedance.trae.conversation.widget.SegmentedTabView  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=2
    const-string v0, "anim"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Float;
    invoke-virtual v2, Ljava/lang/Float;->floatValue()F
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animatedSelectionX F
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    return-void 
.end method

.method private final applyPaintProperties()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerBgPaint Landroid/graphics/Paint;
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerBgColor I
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgPaint Landroid/graphics/Paint;
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgColor I
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgPaint Landroid/graphics/Paint;
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->shadowRadius F
    iget v2, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->shadowDy F
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->shadowColor I
    const/4 v4, 0
    invoke-virtual v0, v1, v4, v2, v3, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextColor I
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    const/high16 v1, 1096810496
    invoke-direct v5, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->sp(F)F
    move-result v2
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setTextSize(F)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    const-string/jumbo v2, sans-serif-medium
    const/4 v3, 0
    invoke-static v2, v3, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextPaint Landroid/graphics/Paint;
    iget v2, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextColor I
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextPaint Landroid/graphics/Paint;
    invoke-direct v5, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->sp(F)F
    move-result v1
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setTextSize(F)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextPaint Landroid/graphics/Paint;
    const-string/jumbo v1, sans-serif
    invoke-static v1, v3, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    return-void 
.end method

.method private final calculateTabWidthByContent()float
    .registers 6
    # ins_size=1
    const/high16 v0, 1111490560
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +013h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    iget-object v4, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    invoke-virtual v4, v3, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F
    move-result v3
    invoke-static v2, v3, Ljava/lang/Math;->max(F F)F
    move-result v2
    goto -16h
    add-float/2addr v2, v0
    iget v0, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabMinWidth F
    invoke-static v2, v0, Ljava/lang/Math;->max(F F)F
    move-result v0
    return v0
.end method

.method private final dp(float)float
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, v3, v0, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v3
    return v3
.end method

.method private final getSelectionX(int)float
    .registers 4
    # ins_size=2
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerPadding F
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getTabWidth()F
    move-result v1
    int-to-float v3, v3
    mul-float/2addr v1, v3
    add-float/2addr v0, v1
    return v0
.end method

.method private final getTabWidth()float
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getWidth()I
    move-result v0
    int-to-float v0, v0
    iget v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerPadding F
    const/4 v2, 2
    int-to-float v2, v2
    mul-float/2addr v1, v2
    sub-float/2addr v0, v1
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    const/4 v2, 1
    invoke-static v1, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v1
    int-to-float v1, v1
    div-float/2addr v0, v1
    return v0
.end method

.method private final parseColorWithAlpha(java.lang.String  float)int
    .registers 5
    # ins_size=3
    invoke-static v3, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v3
    const/16 v0, 255
    int-to-float v1, v0
    mul-float/2addr v4, v1
    float-to-int v4, v4
    const/4 v1, 0
    invoke-static v4, v1, v0, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v4
    invoke-static v3, Landroid/graphics/Color;->red(I)I
    move-result v0
    invoke-static v3, Landroid/graphics/Color;->green(I)I
    move-result v1
    invoke-static v3, Landroid/graphics/Color;->blue(I)I
    move-result v3
    invoke-static v4, v0, v1, v3, Landroid/graphics/Color;->argb(I I I I)I
    move-result v3
    return v3
.end method

.method public static synthetic setOuterBackground$default(com.bytedance.trae.conversation.widget.SegmentedTabView  java.lang.String  float  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +005h
    const v2, 1041194025
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->setOuterBackground(Ljava/lang/String; F)V
    return-void 
.end method

.method public static synthetic setSelectedIndex$default(com.bytedance.trae.conversation.widget.SegmentedTabView  int  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->setSelectedIndex(I Z)V
    return-void 
.end method

.method private final sp(float)float
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    const/4 v1, 2
    invoke-static v1, v3, v0, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v3
    return v3
.end method

.method public final getOnTabSelected()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->onTabSelected Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getSelectedIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    return v0
.end method

.method public final getSelectedTab()java.lang.String
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    invoke-interface v0, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method public final getTabs()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method protected onDetachedFromWindow()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroid/view/View;->onDetachedFromWindow()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animator Landroid/animation/ValueAnimator;
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 10
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v8, v9, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getWidth()I
    move-result v0
    int-to-float v0, v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getHeight()I
    move-result v1
    int-to-float v1, v1
    iget-object v2, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerRect Landroid/graphics/RectF;
    const/4 v3, 0
    invoke-virtual v2, v3, v3, v0, v1, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerRect Landroid/graphics/RectF;
    iget v2, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerCornerRadius F
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerBgPaint Landroid/graphics/Paint;
    invoke-virtual v9, v0, v2, v2, v3, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getTabWidth()F
    move-result v0
    iget v2, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animatedSelectionX F
    iget v3, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerPadding F
    add-float v4, v2, v0
    sub-float v5, v1, v3
    iget-object v6, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedRect Landroid/graphics/RectF;
    invoke-virtual v6, v2, v3, v4, v5, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedRect Landroid/graphics/RectF;
    iget v3, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerCornerRadius F
    iget-object v4, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgPaint Landroid/graphics/Paint;
    invoke-virtual v9, v2, v3, v3, v4, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    const/high16 v2, 1073741824
    div-float/2addr v1, v2
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    invoke-virtual v3, Landroid/graphics/Paint;->ascent()F
    move-result v3
    iget-object v4, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    invoke-virtual v4, Landroid/graphics/Paint;->descent()F
    move-result v4
    add-float/2addr v3, v4
    div-float/2addr v3, v2
    sub-float/2addr v1, v3
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->size()I
    move-result v3
    const/4 v4, 0
    if-ge v4, v3, +021h
    iget v5, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerPadding F
    int-to-float v6, v4
    mul-float/2addr v6, v0
    add-float/2addr v5, v6
    div-float v6, v0, v2
    add-float/2addr v5, v6
    iget v6, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    if-ne v4, v6, +005h
    iget-object v6, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    goto +3h
    iget-object v6, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextPaint Landroid/graphics/Paint;
    iget-object v7, v8, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    invoke-interface v7, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    invoke-virtual v9, v7, v5, v1, v6, Landroid/graphics/Canvas;->drawText(Ljava/lang/String; F F Landroid/graphics/Paint;)V
    add-int/lit8 v4, v4, 1
    goto -20h
    return-void 
.end method

.method protected onMeasure(int  int)void
    .registers 6
    # ins_size=3
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->calculateTabWidthByContent()F
    move-result v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    int-to-float v1, v1
    mul-float/2addr v0, v1
    iget v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerPadding F
    const/4 v2, 2
    int-to-float v2, v2
    mul-float/2addr v1, v2
    add-float/2addr v0, v1
    float-to-int v0, v0
    iget v1, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->preferredHeight F
    float-to-int v1, v1
    invoke-static v0, v4, Landroid/view/View;->resolveSize(I I)I
    move-result v4
    invoke-static v1, v5, Landroid/view/View;->resolveSize(I I)I
    move-result v5
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->setMeasuredDimension(I I)V
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroid/view/View;->onSizeChanged(I I I I)V
    iget v1, v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getSelectionX(I)F
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animatedSelectionX F
    return-void 
.end method

.method public onTouchEvent(android.view.MotionEvent)boolean
    .registers 6
    # ins_size=2
    const-string v0, "event"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->isEnabled()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v5, Landroid/view/MotionEvent;->getAction()I
    move-result v0
    const/4 v2, 1
    if-eqz v0, +02bh
    if-eq v0, v2, +007h
    invoke-super v4, v5, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z
    move-result v5
    return v5
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getTabWidth()F
    move-result v0
    invoke-virtual v5, Landroid/view/MotionEvent;->getX()F
    move-result v5
    iget v3, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerPadding F
    sub-float/2addr v5, v3
    div-float/2addr v5, v0
    float-to-int v5, v5
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    sub-int/2addr v0, v2
    invoke-static v5, v1, v0, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v5
    iget v0, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    if-eq v5, v0, +005h
    invoke-virtual v4, v5, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->setSelectedIndex(I Z)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->performClick()Z
    return v2
.end method

.method public performClick()boolean
    .registers 2
    # ins_size=1
    invoke-super v1, Landroid/view/View;->performClick()Z
    move-result v0
    return v0
.end method

.method public final setCornerRadius(float  float)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerCornerRadius F
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->dp(F)F
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->innerCornerRadius F
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    return-void 
.end method

.method public final setOnTabSelected(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->onTabSelected Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOuterBackground(java.lang.String  float)void
    .registers 4
    # ins_size=3
    const-string v0, "colorHex"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->parseColorWithAlpha(Ljava/lang/String; F)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerBgColor I
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->outerBgPaint Landroid/graphics/Paint;
    invoke-virtual v3, v2, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    return-void 
.end method

.method public final setSelectedBackground(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "colorHex"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgColor I
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedBgPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    return-void 
.end method

.method public final setSelectedIndex(int  boolean)void
    .registers 5
    # ins_size=3
    if-ltz v3, +037h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    if-lt v3, v0, +003h
    goto +2dh
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    iput v3, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    if-eqz v4, +00eh
    if-eq v0, v3, +00ch
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getWidth()I
    move-result v4
    if-lez v4, +006h
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animateSelection(I I)V
    goto +ah
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->getSelectionX(I)F
    move-result v4
    iput v4, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->animatedSelectionX F
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->onTabSelected Lkotlin/jvm/functions/Function2;
    if-eqz v4, +00fh
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    invoke-interface v1, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    invoke-interface v4, v0, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final setTabs(java.util.List)void
    .registers 6
    # ins_size=2
    const-string/jumbo v0, tabList
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 2
    const/4 v2, 1
    const/4 v3, 0
    if-lt v0, v1, +004h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +018h
    iput-object v5, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->tabs Ljava/util/List;
    iget v0, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    sub-int/2addr v5, v2
    invoke-static v0, v3, v5, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v5
    iput v5, v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedIndex I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->requestLayout()V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    return-void 
    new-instance v5, Ljava/lang/IllegalArgumentException;
    const-string v0, "SegmentedTabView requires at least 2 tabs"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v5, v0, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v5
.end method

.method public final setTextColors(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, selectedHex
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, unselectedHex
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextColor I
    invoke-static v3, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextColor I
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    iget v3, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextColor I
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setColor(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextPaint Landroid/graphics/Paint;
    iget v3, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextColor I
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    return-void 
.end method

.method public final setTextSizeSp(float)void
    .registers 3
    # ins_size=2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->sp(F)F
    move-result v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->selectedTextPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setTextSize(F)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->unselectedTextPaint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setTextSize(F)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/SegmentedTabView;->invalidate()V
    return-void 
.end method
