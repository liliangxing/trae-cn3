# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;
.super Landroid/text/style/ReplacementSpan;
.source "LoadingDotsSpan.kt"

.field private final alphas:[F
.field private final baseRadii:[F
.field private final dotColors:[I
.field private final dotCount:I
.field private final dotRadius:F
.field private final dotSpacing:F
.field private final scales:[F


.method public constructor <init>(int[]  float  float  int)void
    .registers 6
    # ins_size=5
    const-string v0, "dotColors"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/text/style/ReplacementSpan;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotColors [I
    iput v3, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotRadius F
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotSpacing F
    iput v5, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotCount I
    new-array v2, v5, [F
    const/4 v3, 0
    move v4, v3
    const/high16 v0, 1065353216
    if-ge v4, v5, +007h
    aput v0, v2, v4
    add-int/lit8 v4, v4, 1
    goto -8h
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->alphas [F
    iget v2, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotCount I
    new-array v4, v2, [F
    move v5, v3
    if-ge v5, v2, +007h
    aput v0, v4, v5
    add-int/lit8 v5, v5, 1
    goto -6h
    iput-object v4, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->scales [F
    iget v2, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotCount I
    new-array v4, v2, [F
    if-ge v3, v2, +010h
    iget v5, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotRadius F
    if-nez v3, +003h
    goto +5h
    const v0, 1059481190
    mul-float/2addr v5, v0
    aput v5, v4, v3
    add-int/lit8 v3, v3, 1
    goto -fh
    iput-object v4, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->baseRadii [F
    return-void 
.end method

.method public synthetic constructor <init>(int[]  float  float  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    move v3, v2
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 2
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;-><init>([I F F I)V
    return-void 
.end method

.method public draw(android.graphics.Canvas  java.lang.CharSequence  int  int  float  int  int  int  android.graphics.Paint)void
    .registers 12
    # ins_size=10
    const-string v4, "canvas"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "paint"
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Landroid/graphics/Paint;->getColor()I
    move-result v4
    invoke-virtual v11, Landroid/graphics/Paint;->getAlpha()I
    move-result v5
    add-int/2addr v8, v10
    int-to-float v6, v8
    const/high16 v8, 1073741824
    div-float/2addr v6, v8
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotSpacing F
    add-float/2addr v7, v8
    iget-object v8, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->baseRadii [F
    const/4 v9, 0
    aget v8, v8, v9
    add-float/2addr v7, v8
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotCount I
    if-ge v9, v8, +037h
    iget-object v10, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotColors [I
    aget v10, v10, v9
    invoke-virtual v11, v10, Landroid/graphics/Paint;->setColor(I)V
    iget-object v10, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->alphas [F
    aget v10, v10, v9
    const/16 v0, 255
    int-to-float v0, v0
    mul-float/2addr v10, v0
    float-to-int v10, v10
    invoke-virtual v11, v10, Landroid/graphics/Paint;->setAlpha(I)V
    iget-object v10, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->baseRadii [F
    aget v10, v10, v9
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->scales [F
    aget v0, v0, v9
    mul-float/2addr v10, v0
    invoke-virtual v3, v7, v6, v10, v11, Landroid/graphics/Canvas;->drawCircle(F F F Landroid/graphics/Paint;)V
    iget v10, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotCount I
    add-int/lit8 v10, v10, -1
    if-ge v9, v10, +00fh
    iget-object v10, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->baseRadii [F
    aget v0, v10, v9
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotSpacing F
    add-float/2addr v0, v1
    add-int/lit8 v1, v9, 1
    aget v10, v10, v1
    add-float/2addr v0, v10
    add-float/2addr v7, v0
    add-int/lit8 v9, v9, 1
    goto -36h
    invoke-virtual v11, v4, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v11, v5, Landroid/graphics/Paint;->setAlpha(I)V
    return-void 
.end method

.method public final getAlphas()float[]
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->alphas [F
    return-object v0
.end method

.method public final getScales()float[]
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->scales [F
    return-object v0
.end method

.method public getSize(android.graphics.Paint  java.lang.CharSequence  int  int  android.graphics.Paint$FontMetricsInt)int
    .registers 9
    # ins_size=6
    const-string v5, "paint"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v4, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotSpacing F
    iget-object v5, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->baseRadii [F
    array-length v6, v5
    const-wide/16 v7, 0
    const/4 v0, 0
    if-ge v0, v6, +00ch
    aget v1, v5, v0
    const/4 v2, 2
    int-to-float v2, v2
    mul-float/2addr v1, v2
    float-to-double v1, v1
    add-double/2addr v7, v1
    add-int/lit8 v0, v0, 1
    goto -bh
    double-to-float v5, v7
    add-float/2addr v4, v5
    iget v5, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotCount I
    add-int/lit8 v5, v5, -1
    int-to-float v5, v5
    iget v6, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;->dotSpacing F
    mul-float/2addr v5, v6
    add-float/2addr v4, v5
    float-to-int v4, v4
    return v4
.end method
