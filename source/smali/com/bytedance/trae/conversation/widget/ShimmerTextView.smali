# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
.super Landroidx/appcompat/widget/AppCompatTextView;
.source "ShimmerTextView.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/ShimmerTextView$Companion;
.field public static final NO_TIMEOUT:J
.field private gradient:Landroid/graphics/LinearGradient;
.field private final gradientMatrix:Landroid/graphics/Matrix;
.field private shimmerAnimator:Landroid/animation/ValueAnimator;
.field private final shimmerBaseColor:I
.field private shimmerEnabled:Z
.field private final shimmerHighlightColor:I
.field private shimmerTimeoutMs:J
.field private timeoutRunnable:Ljava/lang/Runnable;


.method public static synthetic $r8$lambda$A6RfpUOfZPdMXE5fjSYrZpWOJkc(com.bytedance.trae.conversation.widget.ShimmerTextView  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/widget/ShimmerTextView; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$aLId0yAHSSWSrkhAvMJBbwMCZiI(com.bytedance.trae.conversation.widget.ShimmerTextView)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer$lambda$0(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$l0wXWR9HWXqkYOs6WTlnZQkj28M(com.bytedance.trae.conversation.widget.ShimmerTextView)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer$lambda$3(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->Companion Lcom/bytedance/trae/conversation/widget/ShimmerTextView$Companion;
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v3, Landroid/graphics/Matrix;
    invoke-direct v3, Landroid/graphics/Matrix;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradientMatrix Landroid/graphics/Matrix;
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_brand_grey_600 I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    iput v3, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerBaseColor I
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_brand_grey_300 I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerHighlightColor I
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final startShimmer()void
    .registers 14
    # ins_size=1
    iget-object v0, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerAnimator Landroid/animation/ValueAnimator;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/animation/ValueAnimator;->isRunning()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return-void 
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->getWidth()I
    move-result v0
    if-nez v0, +00bh
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$$ExternalSyntheticLambda0;
    invoke-direct v0, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->post(Ljava/lang/Runnable;)Z
    return-void 
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->getWidth()I
    move-result v0
    int-to-float v0, v0
    new-instance v11, Landroid/graphics/LinearGradient;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v7, 0
    const/4 v3, 3
    new-array v8, v3, [I
    iget v6, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerBaseColor I
    aput v6, v8, v2
    iget v9, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerHighlightColor I
    aput v9, v8, v1
    const/4 v12, 2
    aput v6, v8, v12
    new-array v9, v3, [F
    fill-array-data v9, +0000057h
    sget-object v10, Landroid/graphics/Shader$TileMode;->CLAMP Landroid/graphics/Shader$TileMode;
    move-object v3, v11
    move v6, v0
    invoke-direct/range v3 ... v10, Landroid/graphics/LinearGradient;-><init>(F F F F [I [F Landroid/graphics/Shader$TileMode;)V
    iput-object v11, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradient Landroid/graphics/LinearGradient;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v3
    iget-object v4, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradient Landroid/graphics/LinearGradient;
    check-cast v4, Landroid/graphics/Shader;
    invoke-virtual v3, v4, Landroid/text/TextPaint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    new-array v3, v12, [F
    neg-float v4, v0
    aput v4, v3, v2
    aput v0, v3, v1
    invoke-static v3, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    const-wide/16 v1, 1500
    invoke-virtual v0, v1, v2, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    const/4 v1, -1
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setRepeatCount(I)V
    new-instance v1, Landroid/view/animation/LinearInterpolator;
    invoke-direct v1, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$$ExternalSyntheticLambda1;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerAnimator Landroid/animation/ValueAnimator;
    iget-wide v0, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerTimeoutMs J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +00eh
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$$ExternalSyntheticLambda2;
    invoke-direct v0, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V
    iput-object v0, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->timeoutRunnable Ljava/lang/Runnable;
    iget-wide v1, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerTimeoutMs J
    invoke-virtual v13, v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x00?\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x00\x3f\x00\x00\x80\x3f
.end method

.method private static final startShimmer$lambda$0(com.bytedance.trae.conversation.widget.ShimmerTextView)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer()V
    return-void 
.end method

.method private static final startShimmer$lambda$2$lambda$1(com.bytedance.trae.conversation.widget.ShimmerTextView  android.animation.ValueAnimator)void
    .registers 4
    # ins_size=2
    const-string v0, "animation"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v3
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Float;
    invoke-virtual v3, Ljava/lang/Float;->floatValue()F
    move-result v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradientMatrix Landroid/graphics/Matrix;
    invoke-virtual v0, Landroid/graphics/Matrix;->reset()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradientMatrix Landroid/graphics/Matrix;
    const/4 v1, 0
    invoke-virtual v0, v3, v1, Landroid/graphics/Matrix;->setTranslate(F F)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradient Landroid/graphics/LinearGradient;
    if-eqz v3, +007h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradientMatrix Landroid/graphics/Matrix;
    invoke-virtual v3, v0, Landroid/graphics/LinearGradient;->setLocalMatrix(Landroid/graphics/Matrix;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->invalidate()V
    return-void 
.end method

.method private static final startShimmer$lambda$3(com.bytedance.trae.conversation.widget.ShimmerTextView)void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerEnabled Z
    if-eqz v0, +006h
    const/4 v0, 0
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    return-void 
.end method

.method private final stopShimmer()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->timeoutRunnable Ljava/lang/Runnable;
    if-eqz v0, +005h
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->removeCallbacks(Ljava/lang/Runnable;)Z
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->timeoutRunnable Ljava/lang/Runnable;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerAnimator Landroid/animation/ValueAnimator;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/animation/ValueAnimator;->cancel()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerAnimator Landroid/animation/ValueAnimator;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->gradient Landroid/graphics/LinearGradient;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/text/TextPaint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->invalidate()V
    return-void 
.end method

.method public final getShimmerTimeoutMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerTimeoutMs J
    return-wide v0
.end method

.method protected onAttachedToWindow()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/appcompat/widget/AppCompatTextView;->onAttachedToWindow()V
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerEnabled Z
    if-eqz v0, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer()V
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/appcompat/widget/AppCompatTextView;->onDetachedFromWindow()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->stopShimmer()V
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroidx/appcompat/widget/AppCompatTextView;->onSizeChanged(I I I I)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerEnabled Z
    if-eqz v2, +00ah
    if-lez v1, +008h
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->stopShimmer()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer()V
    return-void 
.end method

.method protected onVisibilityChanged(android.view.View  int)void
    .registers 4
    # ins_size=3
    const-string v0, "changedView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/appcompat/widget/AppCompatTextView;->onVisibilityChanged(Landroid/view/View; I)V
    if-eqz v3, +006h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->stopShimmer()V
    goto +8h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerEnabled Z
    if-eqz v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer()V
    return-void 
.end method

.method public final setShimmerEnabled(boolean)void
    .registers 3
    # ins_size=2
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerEnabled Z
    if-ne v0, v2, +003h
    return-void 
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerEnabled Z
    if-eqz v2, +006h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->startShimmer()V
    goto +4h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->stopShimmer()V
    return-void 
.end method

.method public final setShimmerTimeoutMs(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->shimmerTimeoutMs J
    return-void 
.end method
