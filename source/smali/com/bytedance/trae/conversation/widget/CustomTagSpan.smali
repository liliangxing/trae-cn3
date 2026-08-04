# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/CustomTagSpan;
.super Landroid/text/style/ReplacementSpan;
.source "CustomTagSpan.kt"

.field private final bgPaint:Landroid/graphics/Paint;
.field private final content:Ljava/lang/String;
.field private final context:Landroid/content/Context;
.field private final cornerRadius:F
.field private final iconMarginEnd:F
.field private final iconRes:I
.field private final iconSize:F
.field private spanWidth:I
.field private final tagBgColor:I
.field private final tagPaddingH:F
.field private final tagPaddingV:F
.field private final tagTextColor:I
.field private final tagTextSize:F
.field private final textPaint:Landroid/graphics/Paint;


.method public constructor <init>(android.content.Context  java.lang.String  int  float  float  float  float  float  int  int  float)void
    .registers 13
    # ins_size=12
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/text/style/ReplacementSpan;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->context Landroid/content/Context;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->content Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconRes I
    iput v5, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagTextSize F
    iput v6, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagPaddingH F
    iput v7, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagPaddingV F
    iput v8, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconSize F
    iput v9, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconMarginEnd F
    iput v10, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagBgColor I
    iput v11, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagTextColor I
    iput v12, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->cornerRadius F
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v2, v5, Landroid/graphics/Paint;->setTextSize(F)V
    invoke-virtual v2, v11, Landroid/graphics/Paint;->setColor(I)V
    sget-object v4, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->textPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v2, v10, Landroid/graphics/Paint;->setColor(I)V
    sget-object v3, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->bgPaint Landroid/graphics/Paint;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.lang.String  int  float  float  float  float  float  int  int  float  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 26
    # ins_size=14
    move-object v1, v13
    move/from16 v0, v24
    and-int/lit8 v2, v0, 8
    if-eqz v2, +00ah
    const/high16 v2, 1096810496
    invoke-static v2, v13, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v4, v2
    goto +3h
    move/from16 v4, v16
    and-int/lit8 v2, v0, 16
    const/high16 v3, 1086324736
    if-eqz v2, +008h
    invoke-static v3, v13, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v5, v2
    goto +3h
    move/from16 v5, v17
    and-int/lit8 v2, v0, 32
    if-eqz v2, +00ah
    const/high16 v2, 1082130432
    invoke-static v2, v13, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v6, v2
    goto +3h
    move/from16 v6, v18
    and-int/lit8 v2, v0, 64
    if-eqz v2, +00ah
    const/high16 v2, 1095761920
    invoke-static v2, v13, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v7, v2
    goto +3h
    move/from16 v7, v19
    and-int/lit16 v2, v0, 128
    if-eqz v2, +00ah
    const/high16 v2, 1065353216
    invoke-static v2, v13, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v8, v2
    goto +3h
    move/from16 v8, v20
    and-int/lit16 v2, v0, 256
    if-eqz v2, +00ah
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_accent_accent_skill I
    invoke-static v13, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    move v9, v2
    goto +3h
    move/from16 v9, v21
    and-int/lit16 v2, v0, 512
    if-eqz v2, +00ah
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v13, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    move v10, v2
    goto +3h
    move/from16 v10, v22
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +008h
    invoke-static v3, v13, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v0
    move v11, v0
    goto +3h
    move/from16 v11, v23
    move-object v0, v12
    move-object v1, v13
    move-object v2, v14
    move v3, v15
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I F F F F F I I F)V
    return-void 
.end method

.method public draw(android.graphics.Canvas  java.lang.CharSequence  int  int  float  int  int  int  android.graphics.Paint)void
    .registers 12
    # ins_size=10
    const-string v4, "canvas"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "paint"
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v4, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
    move-result-object v4
    add-int/2addr v8, v10
    int-to-float v5, v8
    const/high16 v6, 1073741824
    div-float/2addr v5, v6
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconSize F
    iget v9, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagPaddingV F
    const/4 v10, 2
    int-to-float v10, v10
    mul-float/2addr v9, v10
    add-float/2addr v8, v9
    div-float/2addr v8, v10
    sub-float v9, v5, v8
    add-float/2addr v8, v5
    new-instance v11, Landroid/graphics/RectF;
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->spanWidth I
    int-to-float v0, v0
    add-float/2addr v0, v7
    invoke-direct v11, v7, v9, v0, v8, Landroid/graphics/RectF;-><init>(F F F F)V
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->cornerRadius F
    iget-object v9, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->bgPaint Landroid/graphics/Paint;
    invoke-virtual v3, v11, v8, v8, v9, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    iget-object v8, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->context Landroid/content/Context;
    iget v9, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconRes I
    invoke-static v8, v9, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v8
    if-eqz v8, +019h
    iget v9, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagPaddingH F
    add-float/2addr v9, v7
    float-to-int v9, v9
    iget v11, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconSize F
    div-float v10, v11, v10
    sub-float v10, v5, v10
    float-to-int v10, v10
    int-to-float v0, v9
    add-float/2addr v0, v11
    float-to-int v0, v0
    int-to-float v1, v10
    add-float/2addr v1, v11
    float-to-int v11, v1
    invoke-virtual v8, v9, v10, v0, v11, Landroid/graphics/drawable/Drawable;->setBounds(I I I I)V
    invoke-virtual v8, v3, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagPaddingH F
    add-float/2addr v7, v8
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconSize F
    add-float/2addr v7, v8
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconMarginEnd F
    add-float/2addr v7, v8
    iget v8, v4, Landroid/graphics/Paint$FontMetricsInt;->top I
    iget v4, v4, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    add-int/2addr v8, v4
    int-to-float v4, v8
    div-float/2addr v4, v6
    sub-float/2addr v5, v4
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->content Ljava/lang/String;
    iget-object v6, v2, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v3, v4, v7, v5, v6, Landroid/graphics/Canvas;->drawText(Ljava/lang/String; F F Landroid/graphics/Paint;)V
    return-void 
.end method

.method public getSize(android.graphics.Paint  java.lang.CharSequence  int  int  android.graphics.Paint$FontMetricsInt)int
    .registers 7
    # ins_size=6
    const-string v3, "paint"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->textPaint Landroid/graphics/Paint;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->content Ljava/lang/String;
    invoke-virtual v2, v3, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F
    move-result v2
    iget v3, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagPaddingH F
    iget v4, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconSize F
    add-float/2addr v4, v3
    iget v5, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconMarginEnd F
    add-float/2addr v4, v5
    add-float/2addr v4, v2
    add-float/2addr v4, v3
    float-to-int v2, v4
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->spanWidth I
    if-eqz v6, +027h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v2, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->iconSize F
    iget v4, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->tagPaddingV F
    const/4 v5, 2
    int-to-float v0, v5
    mul-float/2addr v4, v0
    add-float/2addr v3, v4
    float-to-int v3, v3
    iget v4, v2, Landroid/graphics/Paint$FontMetricsInt;->top I
    iget v2, v2, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    add-int/2addr v4, v2
    div-int/2addr v4, v5
    div-int/2addr v3, v5
    sub-int v2, v4, v3
    iput v2, v6, Landroid/graphics/Paint$FontMetricsInt;->top I
    add-int/2addr v4, v3
    iput v4, v6, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    iget v2, v6, Landroid/graphics/Paint$FontMetricsInt;->top I
    iput v2, v6, Landroid/graphics/Paint$FontMetricsInt;->ascent I
    iget v2, v6, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    iput v2, v6, Landroid/graphics/Paint$FontMetricsInt;->descent I
    iget v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;->spanWidth I
    return v2
.end method
