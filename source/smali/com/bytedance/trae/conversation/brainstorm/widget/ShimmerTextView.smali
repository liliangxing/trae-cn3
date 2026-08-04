# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
.super Landroidx/appcompat/widget/AppCompatTextView;
.source "ShimmerTextView.kt"

.field private animator:Landroid/animation/ValueAnimator;
.field private baseColor:I
.field private highlightColor:I
.field private shimmerDuration:J
.field private shimmerProgress:F


.method public static synthetic $r8$lambda$wbdu-8mA15oG-uR_JyCHEybPwfE(com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->startShimmer$lambda$1$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView; Landroid/animation/ValueAnimator;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    sget v3, Lcom/bytedance/trae/conversation/R$color;->trae_shimmer_text_base I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->baseColor I
    sget v3, Lcom/bytedance/trae/conversation/R$color;->trae_shimmer_text_highlight I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->highlightColor I
    const-wide/16 v2, 1500
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->shimmerDuration J
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private static final startShimmer$lambda$1$lambda$0(com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView  android.animation.ValueAnimator)void
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
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->shimmerProgress F
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->updateShader()V
    return-void 
.end method

.method private final updateShader()void
    .registers 13
    # ins_size=1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v0
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->getText()Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F
    move-result v0
    const/4 v1, 0
    cmpg-float v1, v0, v1
    if-gtz v1, +003h
    return-void 
    const v1, 1053609165
    mul-float/2addr v1, v0
    const/4 v2, 2
    int-to-float v3, v2
    mul-float/2addr v3, v1
    add-float/2addr v0, v3
    neg-float v3, v1
    iget v4, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->shimmerProgress F
    mul-float/2addr v0, v4
    add-float/2addr v3, v0
    sub-float v5, v3, v1
    add-float v7, v3, v1
    new-instance v0, Landroid/graphics/LinearGradient;
    const/4 v6, 0
    const/4 v8, 0
    const/4 v1, 3
    new-array v9, v1, [I
    iget v3, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->baseColor I
    const/4 v4, 0
    aput v3, v9, v4
    const/4 v4, 1
    iget v10, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->highlightColor I
    aput v10, v9, v4
    aput v3, v9, v2
    new-array v10, v1, [F
    fill-array-data v10, +0000016h
    sget-object v11, Landroid/graphics/Shader$TileMode;->CLAMP Landroid/graphics/Shader$TileMode;
    move-object v4, v0
    invoke-direct/range v4 ... v11, Landroid/graphics/LinearGradient;-><init>(F F F F [I [F Landroid/graphics/Shader$TileMode;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v1
    check-cast v0, Landroid/graphics/Shader;
    invoke-virtual v1, v0, Landroid/text/TextPaint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->invalidate()V
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x00?\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x00\x3f\x00\x00\x80\x3f
.end method

.method protected onDetachedFromWindow()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/appcompat/widget/AppCompatTextView;->onDetachedFromWindow()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->animator Landroid/animation/ValueAnimator;
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroidx/appcompat/widget/AppCompatTextView;->onSizeChanged(I I I I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->animator Landroid/animation/ValueAnimator;
    const/4 v2, 0
    if-eqz v1, +00ah
    invoke-virtual v1, Landroid/animation/ValueAnimator;->isRunning()Z
    move-result v1
    const/4 v3, 1
    if-ne v1, v3, +003h
    move v2, v3
    if-eqz v2, +005h
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->updateShader()V
    return-void 
.end method

.method public final setShimmerColors(int  int)void
    .registers 3
    # ins_size=3
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->baseColor I
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->highlightColor I
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->updateShader()V
    return-void 
.end method

.method public final startShimmer()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->animator Landroid/animation/ValueAnimator;
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
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->shimmerDuration J
    invoke-virtual v0, v1, v2, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    const/4 v1, -1
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setRepeatCount(I)V
    new-instance v1, Landroid/view/animation/LinearInterpolator;
    invoke-direct v1, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;)V
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->animator Landroid/animation/ValueAnimator;
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method public final stopShimmer()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->animator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->animator Landroid/animation/ValueAnimator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/text/TextPaint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    iget v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->baseColor I
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setTextColor(I)V
    return-void 
.end method
