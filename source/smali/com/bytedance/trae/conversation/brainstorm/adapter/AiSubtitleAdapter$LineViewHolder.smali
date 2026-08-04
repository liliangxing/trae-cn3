# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "AiSubtitleAdapter.kt"

.field private animStartTranslationX:F
.field private currentTranslationX:F
.field private displayedText:Ljava/lang/String;
.field private final measurePaint:Landroid/graphics/Paint;
.field private targetTranslationX:F
.field private final textView:Landroid/widget/TextView;
.field private final translateAnimator:Landroid/animation/ValueAnimator;
.field private final translateSpeed:F


.method public static synthetic $r8$lambda$7b16sVPNraQA8QIJrZpfMBjvm7k(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder  com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->bindImmediate$lambda$3(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder; Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$K3wCKI5FcUjJgFC_dkiOafH2h_c(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public constructor <init>(android.view.View  float)void
    .registers 6
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput v5, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateSpeed F
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_ai_subtitle_line I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    new-instance v0, Landroid/graphics/Paint;
    invoke-direct v0, Landroid/graphics/Paint;-><init>()V
    invoke-virtual v4, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    const/4 v1, 2
    const/high16 v2, 1099431936
    invoke-static v1, v2, v4, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v4
    invoke-virtual v0, v4, Landroid/graphics/Paint;->setTextSize(F)V
    const v4, -1134206910
    invoke-virtual v0, v4, Landroid/graphics/Paint;->setLetterSpacing(F)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->measurePaint Landroid/graphics/Paint;
    const-string v4, ""
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->displayedText Ljava/lang/String;
    new-array v4, v1, [F
    fill-array-data v4, +0000024h
    invoke-static v4, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v4
    const v0, 1184645120
    div-float/2addr v0, v5
    float-to-long v0, v0
    invoke-virtual v4, v0, v1, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v5, Landroid/view/animation/LinearInterpolator;
    invoke-direct v5, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v5, Landroid/animation/TimeInterpolator;
    invoke-virtual v4, v5, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v5, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;)V
    invoke-virtual v4, v5, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00@\x9c\xc6' | \x00\x00\x00\x00\x00\x40\x9c\xc6
.end method

.method private static final bindImmediate$lambda$3(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder  com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;->getText()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->calcCenterTranslationX(Ljava/lang/String;)F
    move-result v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTranslationX(F)V
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->currentTranslationX F
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->targetTranslationX F
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->animStartTranslationX F
    return-void 
.end method

.method private final calcCenterTranslationX(java.lang.String)float
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getWidth()I
    move-result v0
    int-to-float v0, v0
    const/4 v1, 0
    cmpg-float v2, v0, v1
    if-gtz v2, +003h
    return v1
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->measurePaint Landroid/graphics/Paint;
    invoke-virtual v1, v4, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F
    move-result v4
    sub-float/2addr v0, v4
    const/high16 v4, 1073741824
    div-float/2addr v0, v4
    return v0
.end method

.method private static final translateAnimator$lambda$2$lambda$1(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder  android.animation.ValueAnimator)void
    .registers 4
    # ins_size=2
    const-string v0, "animator"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Float;
    invoke-virtual v0, Ljava/lang/Float;->floatValue()F
    move-result v0
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->animStartTranslationX F
    add-float/2addr v1, v0
    iget v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->targetTranslationX F
    cmpg-float v0, v1, v0
    if-gtz v0, +00fh
    invoke-virtual v3, Landroid/animation/ValueAnimator;->pause()V
    iget v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->targetTranslationX F
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->currentTranslationX F
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTranslationX(F)V
    goto +8h
    iput v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->currentTranslationX F
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v2, v1, Landroid/widget/TextView;->setTranslationX(F)V
    return-void 
.end method

.method public final animateAppend(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "newFullText"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->displayedText Ljava/lang/String;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->calcCenterTranslationX(Ljava/lang/String;)F
    move-result v3
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->targetTranslationX F
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v3, Landroid/animation/ValueAnimator;->isPaused()Z
    move-result v3
    if-eqz v3, +011h
    iget v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->currentTranslationX F
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->animStartTranslationX F
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v3, Landroid/animation/ValueAnimator;->cancel()V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v3, Landroid/animation/ValueAnimator;->start()V
    goto +1ah
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v3, Landroid/animation/ValueAnimator;->isStarted()Z
    move-result v3
    if-eqz v3, +00ah
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v3, Landroid/animation/ValueAnimator;->isRunning()Z
    move-result v3
    if-nez v3, +00bh
    iget v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->currentTranslationX F
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->animStartTranslationX F
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v3, Landroid/animation/ValueAnimator;->start()V
    return-void 
.end method

.method public final bindImmediate(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine)void
    .registers 5
    # ins_size=2
    const-string v0, "line"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;->isSpecial()Z
    move-result v0
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$color;->trae_ai_subtitle_text_special I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$color;->trae_ai_subtitle_text_normal I
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v1, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;->getText()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;->getText()Ljava/lang/String;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->displayedText Ljava/lang/String;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder; Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final cancelAnimation()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->translateAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTranslationX(F)V
    iput v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->currentTranslationX F
    iput v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->targetTranslationX F
    iput v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->animStartTranslationX F
    return-void 
.end method

.method public final getDisplayedText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->displayedText Ljava/lang/String;
    return-object v0
.end method

.method public final getTextView()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->textView Landroid/widget/TextView;
    return-object v0
.end method
