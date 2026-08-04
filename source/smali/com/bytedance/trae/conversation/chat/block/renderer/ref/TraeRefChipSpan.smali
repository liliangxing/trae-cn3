# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;
.super Landroid/text/style/ReplacementSpan;
.source "TraeRefChipSpan.kt"

.field private final bgPaint:Landroid/graphics/Paint;
.field private cachedWidth:I
.field private final displayText:Ljava/lang/String;
.field private final group:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
.field private pressed:Z
.field private final spanStyle:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
.field private final textPaint:Landroid/graphics/Paint;


.method public constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefChipSpan$Style)void
    .registers 5
    # ins_size=3
    const-string v0, "group"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, spanStyle
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Landroid/text/style/ReplacementSpan;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    new-instance v0, Landroid/graphics/Paint;
    const/4 v1, 1
    invoke-direct v0, v1, Landroid/graphics/Paint;-><init>(I)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->bgPaint Landroid/graphics/Paint;
    new-instance v0, Landroid/graphics/Paint;
    invoke-direct v0, v1, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getTextColor()I
    move-result v1
    invoke-virtual v0, v1, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getTextSizePx()F
    move-result v4
    invoke-virtual v0, v4, Landroid/graphics/Paint;->setTextSize(F)V
    sget-object v4, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-virtual v0, v4, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getDisplayText()Ljava/lang/String;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->displayText Ljava/lang/String;
    const/4 v3, -1
    iput v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->cachedWidth I
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefChipSpan$Style  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 18
    # ins_size=5
    and-int/lit8 v0, v16, 2
    if-eqz v0, +017h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 511
    const/4 v12, 0
    move-object v1, v0
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;-><init>(I I I F F F F F F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v13
    move-object v2, v14
    goto +4h
    move-object v1, v13
    move-object v2, v14
    move-object v0, v15
    invoke-direct v13, v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;)V
    return-void 
.end method

.method public draw(android.graphics.Canvas  java.lang.CharSequence  int  int  float  int  int  int  android.graphics.Paint)void
    .registers 10
    # ins_size=10
    const-string v2, "canvas"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "paint"
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getMarginPx()F
    move-result v2
    add-float/2addr v2, v5
    iget v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->cachedWidth I
    int-to-float v3, v3
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getMarginPx()F
    move-result v4
    sub-float/2addr v3, v4
    add-float/2addr v5, v3
    invoke-virtual v9, Landroid/graphics/Paint;->getFontMetrics()Landroid/graphics/Paint$FontMetrics;
    move-result-object v3
    iget v4, v3, Landroid/graphics/Paint$FontMetrics;->descent F
    iget v6, v3, Landroid/graphics/Paint$FontMetrics;->ascent F
    sub-float/2addr v4, v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getVerticalPaddingPx()F
    move-result v6
    const/4 v8, 2
    int-to-float v8, v8
    mul-float/2addr v6, v8
    add-float/2addr v4, v6
    int-to-float v6, v7
    iget v3, v3, Landroid/graphics/Paint$FontMetrics;->ascent F
    add-float/2addr v6, v3
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getVerticalPaddingPx()F
    move-result v3
    sub-float/2addr v6, v3
    add-float v3, v6, v4
    new-instance v7, Landroid/graphics/RectF;
    invoke-direct v7, v2, v6, v5, v3, Landroid/graphics/RectF;-><init>(F F F F)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->bgPaint Landroid/graphics/Paint;
    iget-boolean v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->pressed Z
    if-eqz v5, +009h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getBgColorPressed()I
    move-result v5
    goto +7h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getBgColor()I
    move-result v5
    invoke-virtual v3, v5, Landroid/graphics/Paint;->setColor(I)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getCornerRadiusPx()F
    move-result v3
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getCornerRadiusPx()F
    move-result v5
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->bgPaint Landroid/graphics/Paint;
    invoke-virtual v1, v7, v3, v5, v9, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v3, Landroid/graphics/Paint;->descent()F
    move-result v3
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v5, Landroid/graphics/Paint;->ascent()F
    move-result v5
    sub-float/2addr v3, v5
    sub-float/2addr v4, v3
    div-float/2addr v4, v8
    add-float/2addr v6, v4
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v3, Landroid/graphics/Paint;->ascent()F
    move-result v3
    sub-float/2addr v6, v3
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getHorizontalPaddingPx()F
    move-result v3
    add-float/2addr v2, v3
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->displayText Ljava/lang/String;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v1, v3, v2, v6, v4, Landroid/graphics/Canvas;->drawText(Ljava/lang/String; F F Landroid/graphics/Paint;)V
    return-void 
.end method

.method public final getGroup()com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    return-object v0
.end method

.method public final getPressed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->pressed Z
    return v0
.end method

.method public getSize(android.graphics.Paint  java.lang.CharSequence  int  int  android.graphics.Paint$FontMetricsInt)int
    .registers 6
    # ins_size=6
    const-string v2, "paint"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->textPaint Landroid/graphics/Paint;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->displayText Ljava/lang/String;
    invoke-virtual v2, v3, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F
    move-result v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getHorizontalPaddingPx()F
    move-result v3
    const/4 v4, 2
    int-to-float v4, v4
    mul-float/2addr v3, v4
    add-float/2addr v2, v3
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->spanStyle Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->getMarginPx()F
    move-result v3
    mul-float/2addr v3, v4
    add-float/2addr v2, v3
    invoke-static v2, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v2
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->cachedWidth I
    if-eqz v5, +016h
    invoke-virtual v1, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
    move-result-object v1
    iget v2, v1, Landroid/graphics/Paint$FontMetricsInt;->ascent I
    iput v2, v5, Landroid/graphics/Paint$FontMetricsInt;->ascent I
    iget v2, v1, Landroid/graphics/Paint$FontMetricsInt;->descent I
    iput v2, v5, Landroid/graphics/Paint$FontMetricsInt;->descent I
    iget v2, v1, Landroid/graphics/Paint$FontMetricsInt;->top I
    iput v2, v5, Landroid/graphics/Paint$FontMetricsInt;->top I
    iget v1, v1, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    iput v1, v5, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->cachedWidth I
    return v1
.end method

.method public final setPressed(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;->pressed Z
    return-void 
.end method
