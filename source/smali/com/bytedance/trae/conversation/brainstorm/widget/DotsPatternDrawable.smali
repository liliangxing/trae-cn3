# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "DotsPatternDrawable.kt"

.field private final dotColor:I
.field private final dotRadius:F
.field private final paint:Landroid/graphics/Paint;
.field private final spacing:F


.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;-><init>(I F F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  float  float)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Landroid/graphics/drawable/Drawable;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->dotColor I
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->dotRadius F
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->spacing F
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v2, v1, Landroid/graphics/Paint;->setColor(I)V
    sget-object v1, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v1, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->paint Landroid/graphics/Paint;
    return-void 
.end method

.method public synthetic constructor <init>(int  float  float  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +005h
    const v1, 813727872
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    const/high16 v2, 1075838976
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const/high16 v3, 1096810496
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;-><init>(I F F)V
    return-void 
.end method

.method public draw(android.graphics.Canvas)void
    .registers 8
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v0
    const-string v1, "getBounds(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget v1, v0, Landroid/graphics/Rect;->top I
    int-to-float v1, v1
    iget v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->spacing F
    const/4 v3, 2
    int-to-float v3, v3
    div-float/2addr v2, v3
    add-float/2addr v1, v2
    iget v2, v0, Landroid/graphics/Rect;->bottom I
    int-to-float v2, v2
    cmpg-float v2, v1, v2
    if-gez v2, +01dh
    iget v2, v0, Landroid/graphics/Rect;->left I
    int-to-float v2, v2
    iget v4, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->spacing F
    div-float/2addr v4, v3
    add-float/2addr v2, v4
    iget v4, v0, Landroid/graphics/Rect;->right I
    int-to-float v4, v4
    cmpg-float v4, v2, v4
    if-gez v4, +00ch
    iget v4, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->dotRadius F
    iget-object v5, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v7, v2, v1, v4, v5, Landroid/graphics/Canvas;->drawCircle(F F F Landroid/graphics/Paint;)V
    iget v4, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->spacing F
    goto -11h
    iget v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->spacing F
    goto -22h
    return-void 
.end method

.method public getOpacity()int
    .registers 2
    # ins_size=1
    const/4 v0, -3
    return v0
.end method

.method public setAlpha(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setAlpha(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->invalidateSelf()V
    return-void 
.end method

.method public setColorFilter(android.graphics.ColorFilter)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/DotsPatternDrawable;->invalidateSelf()V
    return-void 
.end method
