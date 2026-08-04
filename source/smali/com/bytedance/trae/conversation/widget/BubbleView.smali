# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/conversation/widget/BubbleView;
.super Landroid/view/View;
.source "BubbleView.java"

.field private arrowCenterXPx:F
.field private arrowHeightPx:F
.field private arrowWidthPx:F
.field private final backgroundPaint:Landroid/graphics/Paint;
.field private final bubblePath:Landroid/graphics/Path;
.field private cornerRadiusPx:F
.field private shadowPaint:Landroid/graphics/Paint;


.method public constructor <init>(android.content.Context)void
    .registers 3
    # ins_size=2
    invoke-direct v1, v2, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/graphics/Paint;
    const/4 v0, 1
    invoke-direct v2, v0, Landroid/graphics/Paint;-><init>(I)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/BubbleView;->backgroundPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Path;
    invoke-direct v2, Landroid/graphics/Path;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/BubbleView;->init()V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet;)V
    new-instance v1, Landroid/graphics/Paint;
    const/4 v2, 1
    invoke-direct v1, v2, Landroid/graphics/Paint;-><init>(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/BubbleView;->backgroundPaint Landroid/graphics/Paint;
    new-instance v1, Landroid/graphics/Path;
    invoke-direct v1, Landroid/graphics/Path;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/BubbleView;->init()V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v1, Landroid/graphics/Paint;
    const/4 v2, 1
    invoke-direct v1, v2, Landroid/graphics/Paint;-><init>(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/BubbleView;->backgroundPaint Landroid/graphics/Paint;
    new-instance v1, Landroid/graphics/Path;
    invoke-direct v1, Landroid/graphics/Path;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/BubbleView;->init()V
    return-void 
.end method

.method private buildBubblePath(int  int)void
    .registers 14
    # ins_size=3
    iget-object v0, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    invoke-virtual v0, Landroid/graphics/Path;->reset()V
    int-to-float v13, v13
    iget v0, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->arrowHeightPx F
    sub-float/2addr v13, v0
    new-instance v0, Landroid/graphics/RectF;
    const/4 v1, 0
    int-to-float v12, v12
    invoke-direct v0, v1, v1, v12, v13, Landroid/graphics/RectF;-><init>(F F F F)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    iget v1, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->cornerRadiusPx F
    sget-object v2, Landroid/graphics/Path$Direction;->CW Landroid/graphics/Path$Direction;
    invoke-virtual v12, v0, v1, v1, v2, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Path$Direction;)V
    iget v6, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->arrowCenterXPx F
    iget v12, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->arrowWidthPx F
    const/high16 v0, 1073741824
    div-float v0, v12, v0
    sub-float v8, v6, v0
    add-float/2addr v0, v6
    iget v1, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->arrowHeightPx F
    new-instance v9, Landroid/graphics/Path;
    invoke-direct v9, Landroid/graphics/Path;-><init>()V
    invoke-virtual v9, v8, v13, Landroid/graphics/Path;->moveTo(F F)V
    const v2, 1046562734
    mul-float/2addr v2, v12
    add-float/2addr v2, v8
    const v3, 1052938076
    mul-float/2addr v3, v12
    add-float v4, v8, v3
    const v3, 1063675494
    mul-float/2addr v3, v1
    add-float v10, v13, v3
    add-float v7, v13, v1
    move-object v1, v9
    move v3, v13
    move v5, v10
    invoke-virtual/range v1 ... v7, Landroid/graphics/Path;->cubicTo(F F F F F F)V
    const v1, 1058977874
    mul-float/2addr v1, v12
    add-float v2, v8, v1
    const v1, 1061662228
    mul-float/2addr v12, v1
    add-float v4, v8, v12
    move-object v1, v9
    move v3, v10
    move v5, v13
    move v6, v0
    move v7, v13
    invoke-virtual/range v1 ... v7, Landroid/graphics/Path;->cubicTo(F F F F F F)V
    invoke-virtual v9, Landroid/graphics/Path;->close()V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    sget-object v13, Landroid/graphics/Path$Op;->UNION Landroid/graphics/Path$Op;
    invoke-virtual v12, v9, v13, Landroid/graphics/Path;->op(Landroid/graphics/Path; Landroid/graphics/Path$Op;)Z
    return-void 
.end method

.method private init()void
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    const/high16 v1, 1098907648
    mul-float/2addr v1, v0
    iput v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->cornerRadiusPx F
    const/high16 v1, 1113587712
    mul-float/2addr v1, v0
    iput v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->arrowWidthPx F
    const/high16 v1, 1095761920
    mul-float/2addr v1, v0
    iput v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->arrowHeightPx F
    const/high16 v1, 1112801280
    mul-float/2addr v1, v0
    iput v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->arrowCenterXPx F
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_invert I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    iget-object v2, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->backgroundPaint Landroid/graphics/Paint;
    invoke-virtual v2, v1, Landroid/graphics/Paint;->setColor(I)V
    iget-object v2, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->backgroundPaint Landroid/graphics/Paint;
    sget-object v3, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->shadowPaint Landroid/graphics/Paint;
    invoke-virtual v2, v1, Landroid/graphics/Paint;->setColor(I)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->shadowPaint Landroid/graphics/Paint;
    sget-object v2, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v1, v2, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleView;->shadowPaint Landroid/graphics/Paint;
    const/high16 v2, 1103626240
    mul-float/2addr v2, v0
    const/high16 v4, 1094713344
    mul-float/2addr v0, v4
    const/16 v4, 20
    const/4 v5, 0
    invoke-static v4, v5, v5, v5, Landroid/graphics/Color;->argb(I I I I)I
    move-result v4
    const/4 v5, 0
    invoke-virtual v1, v2, v5, v0, v4, Landroid/graphics/Paint;->setShadowLayer(F F F I)V
    const/4 v0, 0
    invoke-virtual v6, v3, v0, Lcom/bytedance/trae/conversation/widget/BubbleView;->setLayerType(I Landroid/graphics/Paint;)V
    return-void 
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/BubbleView;->shadowPaint Landroid/graphics/Paint;
    invoke-virtual v3, v0, v1, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path; Landroid/graphics/Paint;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/BubbleView;->bubblePath Landroid/graphics/Path;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/BubbleView;->backgroundPaint Landroid/graphics/Paint;
    invoke-virtual v3, v0, v1, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path; Landroid/graphics/Paint;)V
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroid/view/View;->onSizeChanged(I I I I)V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/BubbleView;->buildBubblePath(I I)V
    return-void 
.end method
