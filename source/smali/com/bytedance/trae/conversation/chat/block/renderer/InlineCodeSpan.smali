# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "InlineCodeSpan.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroid/text/style/MetricAffectingSpan;-><init>()V
    return-void 
.end method

.method private final apply(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    return-void 
.end method

.method public updateDrawState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, tp
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;->apply(Landroid/text/TextPaint;)V
    return-void 
.end method

.method public updateMeasureState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string v0, "p"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;->apply(Landroid/text/TextPaint;)V
    return-void 
.end method
