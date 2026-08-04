# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;
.super Landroid/view/View;
.source "ThinkingDotsView.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView$Companion;
.field private static final DOT_COUNT:I
.field private static final SHIMMER_DURATION_MS:J
.field private animator:Landroid/animation/ValueAnimator;
.field private final baseColor:I
.field private final density:F
.field private final desiredHeight:I
.field private final desiredWidth:I
.field private final dotDiameter:F
.field private final dotRadius:F
.field private final dotSpacing:F
.field private final highlightColor:I
.field private final paint:Landroid/graphics/Paint;
.field private shimmerProgress:F


.method public static synthetic $r8$lambda$WOJig0HEMH0EWju82IJytm8cL_c(com.bytedance.trae.conversation.brainstorm.widget.ThinkingDotsView  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->startShimmer$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView$Companion;
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->density F
    const/high16 v3, 1090519040
    mul-float/2addr v3, v2
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotDiameter F
    const/high16 v4, 1073741824
    div-float v4, v3, v4
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotRadius F
    const/high16 v4, 1084227584
    mul-float/2addr v2, v4
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotSpacing F
    const/4 v4, 3
    int-to-float v4, v4
    mul-float/2addr v4, v3
    const/4 v0, 2
    int-to-float v0, v0
    mul-float/2addr v2, v0
    add-float/2addr v4, v2
    float-to-int v2, v4
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->desiredWidth I
    float-to-int v2, v3
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->desiredHeight I
    const v2, 863204211
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->baseColor I
    const v3, -2760714
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->highlightColor I
    new-instance v3, Landroid/graphics/Paint;
    const/4 v4, 1
    invoke-direct v3, v4, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v3, v2, Landroid/graphics/Paint;->setColor(I)V
    sget-object v2, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v3, v2, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->paint Landroid/graphics/Paint;
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private static final startShimmer$lambda$2$lambda$1(com.bytedance.trae.conversation.brainstorm.widget.ThinkingDotsView  android.animation.ValueAnimator)void
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
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->shimmerProgress F
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->invalidate()V
    return-void 
.end method

.method private final updateShader()void
    .registers 16
    # ins_size=1
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->animator Landroid/animation/ValueAnimator;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/animation/ValueAnimator;->isRunning()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +048h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->getWidth()I
    move-result v0
    if-gtz v0, +003h
    goto +40h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->getWidth()I
    move-result v0
    int-to-float v0, v0
    const v3, 1061997773
    mul-float/2addr v0, v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->getWidth()I
    move-result v3
    int-to-float v3, v3
    const/4 v4, 2
    int-to-float v5, v4
    mul-float/2addr v5, v0
    add-float/2addr v3, v5
    neg-float v5, v0
    iget v6, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->shimmerProgress F
    mul-float/2addr v3, v6
    add-float/2addr v5, v3
    iget-object v3, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->paint Landroid/graphics/Paint;
    new-instance v14, Landroid/graphics/LinearGradient;
    sub-float v7, v5, v0
    const/4 v8, 0
    add-float v9, v5, v0
    const/4 v10, 0
    const/4 v0, 3
    new-array v11, v0, [I
    iget v5, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->baseColor I
    aput v5, v11, v2
    iget v2, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->highlightColor I
    aput v2, v11, v1
    aput v5, v11, v4
    new-array v12, v0, [F
    fill-array-data v12, +000001eh
    sget-object v13, Landroid/graphics/Shader$TileMode;->CLAMP Landroid/graphics/Shader$TileMode;
    move-object v6, v14
    invoke-direct/range v6 ... v13, Landroid/graphics/LinearGradient;-><init>(F F F F [I [F Landroid/graphics/Shader$TileMode;)V
    check-cast v14, Landroid/graphics/Shader;
    invoke-virtual v3, v14, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    return-void 
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->paint Landroid/graphics/Paint;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->paint Landroid/graphics/Paint;
    iget v1, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->baseColor I
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setColor(I)V
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x00?\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x00\x3f\x00\x00\x80\x3f
.end method

.method protected onAttachedToWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroid/view/View;->onAttachedToWindow()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->startShimmer()V
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->stopShimmer()V
    invoke-super v0, Landroid/view/View;->onDetachedFromWindow()V
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 9
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v7, v8, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->updateShader()V
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotDiameter F
    const/4 v1, 3
    int-to-float v2, v1
    mul-float/2addr v0, v2
    iget v2, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotSpacing F
    const/4 v3, 2
    int-to-float v3, v3
    mul-float/2addr v2, v3
    add-float/2addr v0, v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->getWidth()I
    move-result v2
    int-to-float v2, v2
    sub-float/2addr v2, v0
    const/high16 v0, 1073741824
    div-float/2addr v2, v0
    iget v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotRadius F
    add-float/2addr v2, v3
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->getHeight()I
    move-result v3
    int-to-float v3, v3
    div-float/2addr v3, v0
    const/4 v0, 0
    if-ge v0, v1, +014h
    int-to-float v4, v0
    iget v5, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotDiameter F
    iget v6, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotSpacing F
    add-float/2addr v5, v6
    mul-float/2addr v4, v5
    add-float/2addr v4, v2
    iget v5, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->dotRadius F
    iget-object v6, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->paint Landroid/graphics/Paint;
    invoke-virtual v8, v4, v3, v5, v6, Landroid/graphics/Canvas;->drawCircle(F F F Landroid/graphics/Paint;)V
    add-int/lit8 v0, v0, 1
    goto -13h
    return-void 
.end method

.method protected onMeasure(int  int)void
    .registers 4
    # ins_size=3
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->desiredWidth I
    invoke-static v0, v2, Landroid/view/View;->resolveSize(I I)I
    move-result v2
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->desiredHeight I
    invoke-static v0, v3, Landroid/view/View;->resolveSize(I I)I
    move-result v3
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->setMeasuredDimension(I I)V
    return-void 
.end method

.method public final startShimmer()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->animator Landroid/animation/ValueAnimator;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/animation/ValueAnimator;->isRunning()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    const/4 v0, 2
    new-array v0, v0, [F
    fill-array-data v0, +0000029h
    invoke-static v0, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    const-wide/16 v1, 1500
    invoke-virtual v0, v1, v2, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    const/4 v1, -1
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setRepeatCount(I)V
    new-instance v1, Landroid/view/animation/LinearInterpolator;
    invoke-direct v1, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;)V
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->animator Landroid/animation/ValueAnimator;
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method public final stopShimmer()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->animator Landroid/animation/ValueAnimator;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->paint Landroid/graphics/Paint;
    invoke-virtual v1, v0, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->paint Landroid/graphics/Paint;
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->baseColor I
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->invalidate()V
    return-void 
.end method
