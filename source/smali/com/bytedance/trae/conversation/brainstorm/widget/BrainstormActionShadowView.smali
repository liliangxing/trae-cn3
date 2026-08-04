# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
.super Landroid/view/View;
.source "BrainstormActionShadowView.kt"

.field private contentHeight:I
.field private contentInsetTop:F
.field private contentWidth:I
.field private final paint:Landroid/graphics/Paint;
.field private final rect:Landroid/graphics/RectF;
.field private shadowRadius:F


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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v2, Landroid/graphics/RectF;
    invoke-direct v2, Landroid/graphics/RectF;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->rect Landroid/graphics/RectF;
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    sget-object v4, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->paint Landroid/graphics/Paint;
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setClickable(Z)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setFocusable(Z)V
    const/4 v2, 2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setImportantForAccessibility(I)V
    const/4 v2, 0
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setLayerType(I Landroid/graphics/Paint;)V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public final configure(int  int  float  float  float)void
    .registers 6
    # ins_size=6
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->shadowRadius F
    iput v5, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentInsetTop F
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->paint Landroid/graphics/Paint;
    invoke-virtual v5, v2, Landroid/graphics/Paint;->setColor(I)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->paint Landroid/graphics/Paint;
    const/4 v5, 0
    invoke-virtual v2, v3, v5, v4, v1, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 7
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v5, v6, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    iget v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentWidth I
    if-lez v0, +021h
    iget v1, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentHeight I
    if-gtz v1, +003h
    goto +1bh
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->rect Landroid/graphics/RectF;
    iget v3, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->shadowRadius F
    iget v4, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentInsetTop F
    int-to-float v0, v0
    add-float/2addr v0, v3
    int-to-float v1, v1
    add-float/2addr v1, v4
    invoke-virtual v2, v3, v4, v0, v1, Landroid/graphics/RectF;->set(F F F F)V
    iget v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentHeight I
    int-to-float v0, v0
    const/high16 v1, 1073741824
    div-float/2addr v0, v1
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->rect Landroid/graphics/RectF;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->paint Landroid/graphics/Paint;
    invoke-virtual v6, v1, v0, v0, v2, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    return-void 
.end method

.method protected onMeasure(int  int)void
    .registers 3
    # ins_size=3
    const/4 v1, 0
    invoke-virtual v0, v1, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setMeasuredDimension(I I)V
    return-void 
.end method

.method public final setContentSize(int  int)void
    .registers 4
    # ins_size=3
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentWidth I
    if-ne v0, v2, +007h
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentHeight I
    if-ne v0, v3, +003h
    return-void 
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentWidth I
    iput v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->contentHeight I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->invalidate()V
    return-void 
.end method
