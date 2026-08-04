# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/fragment/CustomTypefaceSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "IntroFragment.kt"

.field private final typeface:Landroid/graphics/Typeface;


.method public constructor <init>(android.graphics.Typeface)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, typeface
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/text/style/MetricAffectingSpan;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/CustomTypefaceSpan;->typeface Landroid/graphics/Typeface;
    return-void 
.end method

.method private final applyTypeface(android.graphics.Paint)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/CustomTypefaceSpan;->typeface Landroid/graphics/Typeface;
    invoke-virtual v2, v0, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    return-void 
.end method

.method public updateDrawState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, tp
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/graphics/Paint;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/CustomTypefaceSpan;->applyTypeface(Landroid/graphics/Paint;)V
    return-void 
.end method

.method public updateMeasureState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, tp
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/graphics/Paint;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/CustomTypefaceSpan;->applyTypeface(Landroid/graphics/Paint;)V
    return-void 
.end method
