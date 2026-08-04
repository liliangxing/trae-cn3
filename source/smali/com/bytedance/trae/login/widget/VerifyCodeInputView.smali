# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
.super Landroidx/appcompat/widget/AppCompatEditText;
.source "VerifyCodeInputView.kt"

.field private static final CURSOR_BLINK_INTERVAL:J
.field public static final Companion:Lcom/bytedance/trae/login/widget/VerifyCodeInputView$Companion;
.field public static final DEFAULT_BOX_COUNT:I
.field private alphanumeric:Z
.field private boxCount:I
.field private final boxErrorStrokeColor:I
.field private final boxFillColor:I
.field private final boxFilledStrokeColor:I
.field private final boxFixedSize:F
.field private final boxPaint:Landroid/graphics/Paint;
.field private final boxRadius:F
.field private final boxRect:Landroid/graphics/RectF;
.field private final boxSpace:F
.field private final boxStrokeColor:I
.field private final boxStrokeWidth:F
.field private final charPaint:Landroid/graphics/Paint;
.field private final cursorAnimator:Landroid/animation/ValueAnimator;
.field private final cursorDrawColor:I
.field private final cursorPaint:Landroid/graphics/Paint;
.field private cursorVisible:Z
.field private isError:Z
.field private suppressSelectionReset:Z
.field private final textDisplayColor:I


.method public static synthetic $r8$lambda$KFLEvp2YoLgoRTmtScaZrRXNkPA(com.bytedance.trae.login.widget.VerifyCodeInputView  java.lang.CharSequence  int  int  android.text.Spanned  int  int)java.lang.CharSequence
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->applyFilters$lambda$1(Lcom/bytedance/trae/login/widget/VerifyCodeInputView; Ljava/lang/CharSequence; I I Landroid/text/Spanned; I I)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ZkuJFuP0DwBQwIwpKcCFbRsORnk(com.bytedance.trae.login.widget.VerifyCodeInputView)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->performLongClick$lambda$7(Lcom/bytedance/trae/login/widget/VerifyCodeInputView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$eet3BxyXfx5NaIwZ-2J59XcKbsY(com.bytedance.trae.login.widget.VerifyCodeInputView  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorAnimator$lambda$5$lambda$4(Lcom/bytedance/trae/login/widget/VerifyCodeInputView; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$pdK90CIC7m2TFH14dkjKvm9jYJc(com.bytedance.trae.login.widget.VerifyCodeInputView)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->onSelectionChanged$lambda$6(Lcom/bytedance/trae/login/widget/VerifyCodeInputView;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->Companion Lcom/bytedance/trae/login/widget/VerifyCodeInputView$Companion;
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 8
    # ins_size=4
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, v6, v7, Landroidx/appcompat/widget/AppCompatEditText;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    const/4 v6, 6
    iput v6, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    const/high16 v6, 1094713344
    invoke-direct v4, v6, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getDp(F)F
    move-result v6
    iput v6, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRadius F
    const/high16 v6, 1090519040
    invoke-direct v4, v6, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getDp(F)F
    move-result v6
    iput v6, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxSpace F
    const/high16 v6, 1069547520
    invoke-direct v4, v6, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getDp(F)F
    move-result v6
    iput v6, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxStrokeWidth F
    const/high16 v7, 1111490560
    invoke-direct v4, v7, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getDp(F)F
    move-result v7
    iput v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxFixedSize F
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    invoke-static v5, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    iput v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxFillColor I
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v5, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    iput v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxStrokeColor I
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l3 I
    invoke-static v5, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    iput v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxFilledStrokeColor I
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    invoke-static v5, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    iput v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxErrorStrokeColor I
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v5, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    iput v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->textDisplayColor I
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l3 I
    invoke-static v5, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    iput v5, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorDrawColor I
    new-instance v0, Landroid/graphics/Paint;
    const/4 v1, 1
    invoke-direct v0, v1, Landroid/graphics/Paint;-><init>(I)V
    iput-object v0, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    new-instance v0, Landroid/graphics/Paint;
    invoke-direct v0, v1, Landroid/graphics/Paint;-><init>(I)V
    const/high16 v2, 1098907648
    invoke-direct v4, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getSp(F)F
    move-result v2
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setTextSize(F)V
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setFakeBoldText(Z)V
    sget-object v2, Landroid/graphics/Paint$Align;->CENTER Landroid/graphics/Paint$Align;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V
    invoke-virtual v0, v7, Landroid/graphics/Paint;->setColor(I)V
    iput-object v0, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->charPaint Landroid/graphics/Paint;
    new-instance v7, Landroid/graphics/Paint;
    invoke-direct v7, v1, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v7, v5, Landroid/graphics/Paint;->setColor(I)V
    const/high16 v5, 1073741824
    invoke-direct v4, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getDp(F)F
    move-result v5
    invoke-virtual v7, v5, Landroid/graphics/Paint;->setStrokeWidth(F)V
    sget-object v5, Landroid/graphics/Paint$Cap;->ROUND Landroid/graphics/Paint$Cap;
    invoke-virtual v7, v5, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V
    iput-object v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorPaint Landroid/graphics/Paint;
    iput-boolean v1, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorVisible Z
    const/4 v5, 2
    new-array v7, v5, [I
    fill-array-data v7, +000005bh
    invoke-static v7, Landroid/animation/ValueAnimator;->ofInt([I)Landroid/animation/ValueAnimator;
    move-result-object v7
    const-wide/16 v2, 1000
    invoke-virtual v7, v2, v3, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    const/4 v0, -1
    invoke-virtual v7, v0, Landroid/animation/ValueAnimator;->setRepeatCount(I)V
    invoke-virtual v7, v1, Landroid/animation/ValueAnimator;->setRepeatMode(I)V
    new-instance v0, Landroid/view/animation/LinearInterpolator;
    invoke-direct v0, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v0, Landroid/animation/TimeInterpolator;
    invoke-virtual v7, v0, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda3;
    invoke-direct v0, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/widget/VerifyCodeInputView;)V
    invoke-virtual v7, v0, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    iput-object v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorAnimator Landroid/animation/ValueAnimator;
    new-instance v7, Landroid/graphics/RectF;
    invoke-direct v7, Landroid/graphics/RectF;-><init>()V
    iput-object v7, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    invoke-direct v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->applyFilters()V
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setInputType(I)V
    int-to-float v5, v5
    div-float/2addr v6, v5
    const/high16 v5, 1056964608
    add-float/2addr v6, v5
    float-to-int v5, v6
    invoke-virtual v4, v5, v5, v5, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setPadding(I I I I)V
    const/4 v5, 0
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setBackgroundColor(I)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setTextColor(I)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setCursorVisible(Z)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setHighlightColor(I)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setLongClickable(Z)V
    new-instance v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$pasteOnlyCallback$1;
    invoke-direct v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$pasteOnlyCallback$1;-><init>()V
    check-cast v5, Landroid/view/ActionMode$Callback;
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setCustomInsertionActionModeCallback(Landroid/view/ActionMode$Callback;)V
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x01\x00\x00\x00' | \x00\x00\x00\x00\x01\x00\x00\x00
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +005h
    const v3, 16842862
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final applyFilters()void
    .registers 4
    # ins_size=1
    const/4 v0, 2
    new-array v0, v0, [Landroid/text/InputFilter;
    new-instance v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/widget/VerifyCodeInputView;)V
    const/4 v2, 0
    aput-object v1, v0, v2
    new-instance v1, Landroid/text/InputFilter$LengthFilter;
    iget v2, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    invoke-direct v1, v2, Landroid/text/InputFilter$LengthFilter;-><init>(I)V
    const/4 v2, 1
    aput-object v1, v0, v2
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setFilters([Landroid/text/InputFilter;)V
    return-void 
.end method

.method private static final applyFilters$lambda$1(com.bytedance.trae.login.widget.VerifyCodeInputView  java.lang.CharSequence  int  int  android.text.Spanned  int  int)java.lang.CharSequence
    .registers 7
    # ins_size=7
    invoke-interface v1, v2, v3, Ljava/lang/CharSequence;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    check-cast v2, Ljava/lang/Appendable;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 0
    if-ge v4, v3, +01bh
    invoke-interface v1, v4, Ljava/lang/CharSequence;->charAt(I)C
    move-result v5
    iget-boolean v6, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->alphanumeric Z
    if-eqz v6, +007h
    invoke-static v5, Ljava/lang/Character;->isLetterOrDigit(C)Z
    move-result v6
    goto +5h
    invoke-static v5, Ljava/lang/Character;->isDigit(C)Z
    move-result v6
    if-eqz v6, +005h
    invoke-interface v2, v5, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;
    add-int/lit8 v4, v4, 1
    goto -1ah
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v0
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-ne v0, v1, +003h
    const/4 v2, 0
    return-object v2
.end method

.method private static final cursorAnimator$lambda$5$lambda$4(com.bytedance.trae.login.widget.VerifyCodeInputView  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Landroid/animation/ValueAnimator;->getAnimatedFraction()F
    move-result v2
    const/high16 v0, 1056964608
    cmpg-float v2, v2, v0
    if-gez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    iget-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorVisible Z
    if-eq v2, v0, +007h
    iput-boolean v2, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorVisible Z
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->invalidate()V
    return-void 
.end method

.method private final getDp(float)float
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v0
    return v2
.end method

.method private final getSp(float)float
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->scaledDensity F
    mul-float/2addr v2, v0
    return v2
.end method

.method private static final onSelectionChanged$lambda$6(com.bytedance.trae.login.widget.VerifyCodeInputView)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v0
    goto +2h
    const/4 v0, 0
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setSelection(I)V
    return-void 
.end method

.method private static final performLongClick$lambda$7(com.bytedance.trae.login.widget.VerifyCodeInputView)void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->suppressSelectionReset Z
    return-void 
.end method

.method private final shouldDrawCursor()boolean
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->isFocused()Z
    move-result v0
    if-eqz v0, +008h
    iget-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorVisible Z
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final getAlphanumeric()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->alphanumeric Z
    return v0
.end method

.method public final getBoxCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    return v0
.end method

.method public final isError()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->isError Z
    return v0
.end method

.method protected onAttachedToWindow()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/appcompat/widget/AppCompatEditText;->onAttachedToWindow()V
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->isFocused()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/appcompat/widget/AppCompatEditText;->onDetachedFromWindow()V
    iget-object v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 16
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getWidth()I
    move-result v1
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getPaddingStart()I
    move-result v2
    sub-int/2addr v1, v2
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getPaddingEnd()I
    move-result v2
    sub-int/2addr v1, v2
    iget v2, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxFixedSize F
    int-to-float v1, v1
    iget v3, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxSpace F
    iget v4, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    add-int/lit8 v5, v4, -1
    int-to-float v5, v5
    mul-float/2addr v3, v5
    sub-float v3, v1, v3
    int-to-float v4, v4
    div-float/2addr v3, v4
    invoke-static v2, v3, Lkotlin/ranges/RangesKt;->coerceAtMost(F F)F
    move-result v2
    iget v3, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    int-to-float v4, v3
    mul-float/2addr v4, v2
    iget v5, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxSpace F
    add-int/lit8 v3, v3, -1
    int-to-float v3, v3
    mul-float/2addr v5, v3
    add-float/2addr v4, v5
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getPaddingStart()I
    move-result v3
    int-to-float v3, v3
    sub-float/2addr v1, v4
    const/4 v4, 2
    int-to-float v4, v4
    div-float/2addr v1, v4
    add-float/2addr v3, v1
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v1
    iget v5, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    if-ge v1, v5, +007h
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v1
    goto +2h
    const/4 v1, -1
    iget v5, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    const/4 v6, 0
    if-ge v6, v5, +0c8h
    int-to-float v7, v6
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxSpace F
    add-float/2addr v8, v2
    mul-float/2addr v7, v8
    add-float/2addr v7, v3
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getPaddingTop()I
    move-result v8
    int-to-float v8, v8
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getHeight()I
    move-result v9
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getPaddingTop()I
    move-result v10
    sub-int/2addr v9, v10
    invoke-virtual v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getPaddingBottom()I
    move-result v10
    sub-int/2addr v9, v10
    int-to-float v9, v9
    sub-float/2addr v9, v2
    div-float/2addr v9, v4
    add-float/2addr v8, v9
    iget-object v9, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    add-float v10, v7, v2
    add-float v11, v8, v2
    invoke-virtual v9, v7, v8, v10, v11, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    sget-object v8, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxFillColor I
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setColor(I)V
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRadius F
    iget-object v9, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    invoke-virtual v15, v7, v8, v8, v9, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    sget-object v8, Landroid/graphics/Paint$Style;->STROKE Landroid/graphics/Paint$Style;
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxStrokeWidth F
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setStrokeWidth(F)V
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    iget-boolean v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->isError Z
    if-eqz v8, +005h
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxErrorStrokeColor I
    goto +ch
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v8
    if-ge v6, v8, +005h
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxFilledStrokeColor I
    goto +3h
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxStrokeColor I
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setColor(I)V
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    iget v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRadius F
    iget-object v9, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxPaint Landroid/graphics/Paint;
    invoke-virtual v15, v7, v8, v8, v9, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v7
    if-ge v6, v7, +02ah
    invoke-virtual v0, v6, Ljava/lang/String;->charAt(I)C
    move-result v7
    invoke-static v7, Ljava/lang/String;->valueOf(C)Ljava/lang/String;
    move-result-object v7
    iget-object v8, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    invoke-virtual v8, Landroid/graphics/RectF;->centerX()F
    move-result v8
    iget-object v9, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    invoke-virtual v9, Landroid/graphics/RectF;->centerY()F
    move-result v9
    iget-object v10, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->charPaint Landroid/graphics/Paint;
    invoke-virtual v10, Landroid/graphics/Paint;->descent()F
    move-result v10
    iget-object v11, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->charPaint Landroid/graphics/Paint;
    invoke-virtual v11, Landroid/graphics/Paint;->ascent()F
    move-result v11
    add-float/2addr v10, v11
    div-float/2addr v10, v4
    sub-float/2addr v9, v10
    iget-object v10, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->charPaint Landroid/graphics/Paint;
    invoke-virtual v15, v7, v8, v9, v10, Landroid/graphics/Canvas;->drawText(Ljava/lang/String; F F Landroid/graphics/Paint;)V
    if-ne v6, v1, +029h
    invoke-direct v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->shouldDrawCursor()Z
    move-result v7
    if-eqz v7, +023h
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    invoke-virtual v7, Landroid/graphics/RectF;->centerX()F
    move-result v11
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    invoke-virtual v7, Landroid/graphics/RectF;->centerY()F
    move-result v7
    const v8, 1050253722
    mul-float/2addr v8, v2
    sub-float v10, v7, v8
    iget-object v7, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxRect Landroid/graphics/RectF;
    invoke-virtual v7, Landroid/graphics/RectF;->centerY()F
    move-result v7
    add-float v12, v7, v8
    iget-object v13, v14, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorPaint Landroid/graphics/Paint;
    move-object v8, v15
    move v9, v11
    invoke-virtual/range v8 ... v13, Landroid/graphics/Canvas;->drawLine(F F F F Landroid/graphics/Paint;)V
    add-int/lit8 v6, v6, 1
    goto/16 -0c6h
    return-void 
.end method

.method protected onFocusChanged(boolean  int  android.graphics.Rect)void
    .registers 4
    # ins_size=4
    invoke-super v0, v1, v2, v3, Landroidx/appcompat/widget/AppCompatEditText;->onFocusChanged(Z I Landroid/graphics/Rect;)V
    if-eqz v1, +00bh
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorVisible Z
    iget-object v1, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v1, Landroid/animation/ValueAnimator;->start()V
    goto +6h
    iget-object v1, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->cursorAnimator Landroid/animation/ValueAnimator;
    invoke-virtual v1, Landroid/animation/ValueAnimator;->cancel()V
    invoke-virtual v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->invalidate()V
    return-void 
.end method

.method protected onSelectionChanged(int  int)void
    .registers 4
    # ins_size=3
    invoke-super v1, v2, v3, Landroidx/appcompat/widget/AppCompatEditText;->onSelectionChanged(I I)V
    iget-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->suppressSelectionReset Z
    if-eqz v0, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v0
    goto +2h
    const/4 v0, 0
    if-ne v2, v0, +004h
    if-eq v3, v0, +00ah
    new-instance v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda2;
    invoke-direct v2, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/widget/VerifyCodeInputView;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public performLongClick()boolean
    .registers 5
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->suppressSelectionReset Z
    invoke-super v4, Landroidx/appcompat/widget/AppCompatEditText;->performLongClick()Z
    move-result v0
    new-instance v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/widget/VerifyCodeInputView;)V
    const-wide/16 v2, 300
    invoke-virtual v4, v1, v2, v3, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->postDelayed(Ljava/lang/Runnable; J)Z
    return v0
.end method

.method public final setAlphanumeric(boolean)void
    .registers 3
    # ins_size=2
    iget-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->alphanumeric Z
    if-eq v0, v2, +010h
    iput-boolean v2, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->alphanumeric Z
    invoke-direct v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->applyFilters()V
    if-eqz v2, +005h
    const/16 v2, 145
    goto +2h
    const/4 v2, 2
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setInputType(I)V
    return-void 
.end method

.method public final setBoxCount(int)void
    .registers 3
    # ins_size=2
    iget v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    if-eq v0, v2, +00ah
    iput v2, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->boxCount I
    invoke-direct v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->applyFilters()V
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->invalidate()V
    return-void 
.end method

.method public final setError(boolean)void
    .registers 3
    # ins_size=2
    iget-boolean v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->isError Z
    if-eq v0, v2, +007h
    iput-boolean v2, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->isError Z
    invoke-virtual v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->invalidate()V
    return-void 
.end method
