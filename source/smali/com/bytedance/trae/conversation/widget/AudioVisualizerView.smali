# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
.super Landroid/view/View;
.source "AudioVisualizerView.kt"

.field private static final BAR_TYPE_OTHER:I
.field private static final BAR_TYPE_SIDE:I
.field private static final BAR_TYPE_TOP:I
.field public static final Companion:Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;
.field private static final GROUP_TYPE_OTHER:I
.field private static final GROUP_TYPE_SIDE:I
.field private static final GROUP_TYPE_TOP:I
.field private final amplitude:Ljava/util/LinkedList;
.field private barCount:I
.field private final barParams:Ljava/util/Map;
.field private final barWidth:F
.field private final density:F
.field private endAlphaSize:I
.field private final gapWidth:F
.field private isRunning:Z
.field private lastTime:J
.field private final maxBarHeight:F
.field private final minBarHeight:F
.field private final paint:Landroid/graphics/Paint;
.field private sideMargin:F
.field private startAlphaSize:I
.field private visualizerWidth:F
.field private waveGroupNumber:I


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->Companion Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->density F
    const/high16 v3, 1077936128
    mul-float v4, v2, v3
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barWidth F
    const/high16 v0, 1073741824
    mul-float/2addr v0, v2
    iput v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->gapWidth F
    const/high16 v0, 1109393408
    mul-float/2addr v0, v2
    iput v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->sideMargin F
    mul-float/2addr v3, v2
    iput v3, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    const/high16 v3, 1111490560
    mul-float/2addr v2, v3
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->maxBarHeight F
    new-instance v2, Ljava/util/LinkedList;
    invoke-direct v2, Ljava/util/LinkedList;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->amplitude Ljava/util/LinkedList;
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    const/4 v2, 5
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->startAlphaSize I
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->endAlphaSize I
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    sget-object v3, Landroid/graphics/Paint$Cap;->ROUND Landroid/graphics/Paint$Cap;
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setStrokeWidth(F)V
    const/4 v3, -1
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setColor(I)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->paint Landroid/graphics/Paint;
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final drawBars(long  android.graphics.Canvas)void
    .registers 21
    # ins_size=4
    move-object/from16 v0, v17
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->getWidth()I
    move-result v1
    int-to-float v1, v1
    iget v2, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->visualizerWidth F
    sub-float/2addr v1, v2
    const/4 v2, 2
    int-to-float v3, v2
    div-float/2addr v1, v3
    iget v4, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barCount I
    const/4 v5, 1
    if-gt v5, v4, +1d4h
    move v6, v5
    iget-object v7, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v7, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    if-nez v7, +004h
    goto/16 +1bch
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getGroupType()I
    move-result v8
    const/4 v9, 0
    if-nez v8, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarType()I
    move-result v8
    if-nez v8, +004h
    move v8, v5
    goto +2h
    move v8, v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getGroupType()I
    move-result v10
    if-nez v10, +008h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarType()I
    move-result v10
    if-eq v10, v5, +00eh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getGroupType()I
    move-result v10
    if-ne v10, v5, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarType()I
    move-result v10
    if-nez v10, +004h
    move v10, v5
    goto +2h
    move v10, v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getGroupType()I
    move-result v11
    if-nez v11, +008h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarType()I
    move-result v11
    if-eq v11, v2, +00eh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getGroupType()I
    move-result v11
    if-ne v11, v5, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarType()I
    move-result v11
    if-ne v11, v5, +004h
    move v11, v5
    goto +2h
    move v11, v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getGroupType()I
    move-result v12
    if-ne v12, v5, +008h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarType()I
    move-result v12
    if-eq v12, v2, +008h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getGroupType()I
    move-result v12
    if-ne v12, v2, +004h
    move v12, v5
    goto +2h
    move v12, v9
    const-wide/16 v13, 0
    cmp-long v13, v13, v18
    const-wide/16 v14, 50
    if-gtz v13, +008h
    cmp-long v13, v18, v14
    if-gez v13, +004h
    move v13, v5
    goto +2h
    move v13, v9
    const/16 v16, 0
    const/16 v2, 20
    if-eqz v13, +01fh
    if-eqz v8, +116h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    cmpl-float v8, v8, v16
    if-lez v8, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    goto +3h
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v9, v8
    int-to-float v2, v2
    div-float/2addr v9, v2
    invoke-virtual v7, v9, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto/16 +0fbh
    cmp-long v13, v14, v18
    const-wide/16 v14, 100
    if-gtz v13, +008h
    cmp-long v13, v18, v14
    if-gez v13, +004h
    move v13, v5
    goto +2h
    move v13, v9
    if-eqz v13, +01fh
    if-eqz v10, +0eah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    cmpl-float v8, v8, v16
    if-lez v8, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    goto +3h
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v9, v8
    int-to-float v2, v2
    div-float/2addr v9, v2
    invoke-virtual v7, v9, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto/16 +0cfh
    cmp-long v13, v14, v18
    const-wide/16 v14, 150
    if-gtz v13, +008h
    cmp-long v13, v18, v14
    if-gez v13, +004h
    move v13, v5
    goto +2h
    move v13, v9
    if-eqz v13, +01fh
    if-eqz v11, +0beh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    cmpl-float v8, v8, v16
    if-lez v8, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    goto +3h
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v9, v8
    int-to-float v2, v2
    div-float/2addr v9, v2
    invoke-virtual v7, v9, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto/16 +0a3h
    cmp-long v13, v14, v18
    const-wide/16 v14, 200
    if-gtz v13, +008h
    cmp-long v13, v18, v14
    if-gez v13, +004h
    move v13, v5
    goto +2h
    move v13, v9
    if-eqz v13, +01fh
    if-eqz v12, +092h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    cmpl-float v8, v8, v16
    if-lez v8, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v8
    goto +3h
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v9, v8
    int-to-float v2, v2
    div-float/2addr v9, v2
    invoke-virtual v7, v9, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto/16 +077h
    cmp-long v13, v14, v18
    const-wide/16 v14, 250
    if-gtz v13, +008h
    cmp-long v13, v18, v14
    if-gez v13, +004h
    move v13, v5
    goto +2h
    move v13, v9
    if-eqz v13, +011h
    if-eqz v8, +066h
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v8, v9
    int-to-float v2, v2
    div-float/2addr v8, v2
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto +58h
    cmp-long v8, v14, v18
    const-wide/16 v13, 300
    if-gtz v8, +008h
    cmp-long v8, v18, v13
    if-gez v8, +004h
    move v8, v5
    goto +2h
    move v8, v9
    if-eqz v8, +011h
    if-eqz v10, +048h
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v8, v9
    int-to-float v2, v2
    div-float/2addr v8, v2
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto +3ah
    cmp-long v8, v13, v18
    const-wide/16 v13, 350
    if-gtz v8, +008h
    cmp-long v8, v18, v13
    if-gez v8, +004h
    move v8, v5
    goto +2h
    move v8, v9
    if-eqz v8, +011h
    if-eqz v11, +02ah
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v8, v9
    int-to-float v2, v2
    div-float/2addr v8, v2
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto +1ch
    cmp-long v8, v13, v18
    if-gtz v8, +009h
    const-wide/16 v10, 400
    cmp-long v8, v18, v10
    if-gez v8, +003h
    move v9, v5
    if-eqz v9, +010h
    if-eqz v12, +00eh
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getBarHeight()F
    move-result v9
    sub-float/2addr v8, v9
    int-to-float v2, v2
    div-float/2addr v8, v2
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getCurBarHeight()F
    move-result v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->getChange()F
    move-result v8
    add-float/2addr v2, v8
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-static v2, v8, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v2
    invoke-virtual v7, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setCurBarHeight(F)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->getHeight()I
    move-result v7
    int-to-float v7, v7
    sub-float/2addr v7, v2
    div-float v10, v7, v3
    iget v7, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barWidth F
    iget v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->gapWidth F
    add-float/2addr v7, v8
    add-float/2addr v1, v7
    iget-object v7, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->paint Landroid/graphics/Paint;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->paintAlpha(I)I
    move-result v8
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setAlpha(I)V
    add-float v12, v10, v2
    iget-object v13, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->paint Landroid/graphics/Paint;
    move-object/from16 v8, v20
    move v9, v1
    move v11, v1
    invoke-virtual/range v8 ... v13, Landroid/graphics/Canvas;->drawLine(F F F F Landroid/graphics/Paint;)V
    if-eq v6, v4, +007h
    add-int/lit8 v6, v6, 1
    const/4 v2, 2
    goto/16 -1cfh
    return-void 
.end method

.method private final ensureCapacity(int)void
    .registers 14
    # ins_size=2
    iget-object v0, v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->clear()V
    const/4 v0, 1
    if-gt v0, v13, +01eh
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    iget-object v2, v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    new-instance v11, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 31
    const/4 v10, 0
    move-object v3, v11
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;-><init>(I I F F F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eq v0, v13, +005h
    add-int/lit8 v0, v0, 1
    goto -1bh
    return-void 
.end method

.method private final genBarData(float)void
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    iget v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    const/4 v2, 2
    div-int/2addr v1, v2
    sget-object v3, Lkotlin/random/Random;->Default Lkotlin/random/Random$Default;
    add-int/lit8 v4, v1, 3
    iget v5, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    const/4 v6, 1
    add-int/2addr v5, v6
    invoke-static v4, v5, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v5
    invoke-virtual v3, v1, v5, Lkotlin/random/Random$Default;->nextInt(I I)I
    move-result v3
    iget v5, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    if-gt v6, v5, +115h
    move v7, v6
    const/4 v8, 0
    if-ne v7, v3, +005h
    const/high16 v9, 1065353216
    goto +2ah
    add-int/lit8 v9, v3, -1
    add-int/lit8 v10, v3, 1
    if-gt v7, v10, +006h
    if-gt v9, v7, +004h
    move v9, v6
    goto +2h
    move v9, v8
    if-eqz v9, +010h
    sget-object v9, Lkotlin/random/Random;->Default Lkotlin/random/Random$Default;
    invoke-virtual v9, Lkotlin/random/Random$Default;->nextFloat()F
    move-result v9
    const v10, 1045220557
    mul-float/2addr v9, v10
    const v10, 1058642330
    goto +eh
    sget-object v9, Lkotlin/random/Random;->Default Lkotlin/random/Random$Default;
    invoke-virtual v9, Lkotlin/random/Random$Default;->nextFloat()F
    move-result v9
    const v10, 1036831949
    mul-float/2addr v9, v10
    const v10, 1053609165
    add-float/2addr v9, v10
    if-ne v7, v3, +004h
    move v10, v8
    goto +13h
    if-gt v1, v7, +00ch
    iget v10, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    invoke-static v4, v10, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v10
    if-gt v7, v10, +004h
    move v10, v6
    goto +2h
    move v10, v8
    if-eqz v10, +004h
    move v10, v6
    goto +2h
    move v10, v2
    sget-object v11, Lkotlin/random/Random;->Default Lkotlin/random/Random$Default;
    const/4 v12, 5
    invoke-virtual v11, v2, v12, Lkotlin/random/Random$Default;->nextInt(I I)I
    move-result v11
    iget v13, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->maxBarHeight F
    mul-float v13, v13, v17
    mul-float/2addr v13, v9
    iget v14, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-static v13, v14, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v13
    const v14, 1060320051
    mul-float v15, v13, v14
    mul-float v2, v15, v9
    iget v6, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-static v2, v6, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v2
    mul-float/2addr v15, v14
    mul-float/2addr v15, v9
    iget v6, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->minBarHeight F
    invoke-static v15, v6, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v6
    const/4 v9, 1
    const/4 v14, 6
    if-ge v9, v14, +09ah
    add-int/lit8 v14, v7, -1
    mul-int/2addr v14, v12
    add-int/2addr v14, v9
    iget-object v15, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-interface v15, v12, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    if-eqz v12, +005h
    invoke-virtual v12, v10, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setGroupType(I)V
    if-ne v9, v11, +027h
    iget-object v12, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v15
    invoke-interface v12, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    if-eqz v12, +005h
    invoke-virtual v12, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setBarType(I)V
    iget-object v12, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-interface v12, v14, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    if-eqz v12, +005h
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setBarHeight(F)V
    const/4 v12, 2
    const/4 v15, 1
    goto +57h
    add-int/lit8 v12, v11, -1
    add-int/lit8 v15, v11, 1
    if-gt v9, v15, +006h
    if-gt v12, v9, +004h
    const/4 v12, 1
    goto +2h
    move v12, v8
    if-eqz v12, +027h
    iget-object v12, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v15
    invoke-interface v12, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    const/4 v15, 1
    if-eqz v12, +005h
    invoke-virtual v12, v15, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setBarType(I)V
    iget-object v12, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-interface v12, v14, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    if-eqz v12, +005h
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setBarHeight(F)V
    const/4 v12, 2
    goto +25h
    const/4 v15, 1
    iget-object v12, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v12, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    const/4 v12, 2
    if-eqz v8, +005h
    invoke-virtual v8, v12, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setBarType(I)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-interface v8, v14, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    if-eqz v8, +005h
    invoke-virtual v8, v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setBarHeight(F)V
    add-int/lit8 v9, v9, 1
    const/4 v8, 0
    const/4 v12, 5
    goto/16 -099h
    const/4 v12, 2
    const/4 v15, 1
    if-eq v7, v5, +008h
    add-int/lit8 v7, v7, 1
    move v2, v12
    move v6, v15
    goto/16 -110h
    return-void 
.end method

.method private final getAmplitude()float
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->amplitude Ljava/util/LinkedList;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->maxOrNull(Ljava/lang/Iterable;)Ljava/lang/Float;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Float;->floatValue()F
    move-result v0
    goto +2h
    const/4 v0, 0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->amplitude Ljava/util/LinkedList;
    invoke-virtual v1, Ljava/util/LinkedList;->clear()V
    return v0
.end method

.method private final paintAlpha(int)int
    .registers 8
    # ins_size=2
    iget v0, v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->startAlphaSize I
    iget v1, v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->endAlphaSize I
    iget v2, v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barCount I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v0, +00fh
    if-gt v3, v7, +006h
    if-gt v7, v0, +004h
    move v5, v3
    goto +2h
    move v5, v4
    if-eqz v5, +006h
    int-to-float v5, v7
    int-to-float v0, v0
    div-float/2addr v5, v0
    goto +3h
    const/high16 v5, 1065353216
    if-eqz v1, +012h
    sub-int v0, v2, v1
    add-int/2addr v0, v3
    if-gt v0, v7, +005h
    if-gt v7, v2, +003h
    goto +2h
    move v3, v4
    if-eqz v3, +007h
    sub-int/2addr v2, v7
    int-to-float v7, v2
    int-to-float v0, v1
    div-float v5, v7, v0
    const/16 v7, 255
    int-to-float v0, v7
    mul-float/2addr v5, v0
    float-to-int v0, v5
    invoke-static v0, v4, v7, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v7
    return v7
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 10
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v8, v9, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    iget-boolean v0, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->isRunning Z
    if-nez v0, +003h
    return-void 
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    iget-wide v2, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->lastTime J
    sub-long v2, v0, v2
    const-wide/16 v4, 400
    cmp-long v4, v2, v4
    if-ltz v4, +01ch
    iput-wide v0, v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->lastTime J
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->getAmplitude()F
    move-result v0
    const-wide/16 v4, 800
    cmp-long v1, v2, v4
    if-ltz v1, +009h
    const-wide/16 v0, 0
    const/4 v2, 0
    move-wide v6, v0
    move v0, v2
    move-wide v2, v6
    goto +5h
    const/16 v1, 400
    int-to-long v4, v1
    sub-long/2addr v2, v4
    invoke-direct v8, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->genBarData(F)V
    invoke-direct v8, v2, v3, v9, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->drawBars(J Landroid/graphics/Canvas;)V
    const-wide/16 v0, 10
    invoke-virtual v8, v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->postInvalidateDelayed(J)V
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroid/view/View;->onSizeChanged(I I I I)V
    int-to-float v1, v1
    iget v2, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->sideMargin F
    const/4 v3, 2
    int-to-float v3, v3
    mul-float/2addr v2, v3
    sub-float/2addr v1, v2
    iget v2, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barWidth F
    iget v3, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->gapWidth F
    add-float/2addr v2, v3
    const/4 v3, 5
    int-to-float v4, v3
    mul-float/2addr v2, v4
    div-float/2addr v1, v2
    float-to-int v1, v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    rem-int/lit8 v4, v1, 2
    if-nez v4, +006h
    add-int/lit8 v1, v1, -1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    iget v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    const/4 v4, 3
    invoke-static v1, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->waveGroupNumber I
    int-to-float v4, v1
    mul-float/2addr v4, v2
    iput v4, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->visualizerWidth F
    mul-int/2addr v1, v3
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barCount I
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->ensureCapacity(I)V
    return-void 
.end method

.method public final setAmplitude(float)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->amplitude Ljava/util/LinkedList;
    invoke-static v2, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/util/LinkedList;->offer(Ljava/lang/Object;)Z
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->amplitude Ljava/util/LinkedList;
    invoke-virtual v2, Ljava/util/LinkedList;->size()I
    move-result v2
    const/16 v0, 10
    if-le v2, v0, +007h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->amplitude Ljava/util/LinkedList;
    invoke-virtual v2, Ljava/util/LinkedList;->poll()Ljava/lang/Object;
    return-void 
.end method

.method public final setBarColor(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->paint Landroid/graphics/Paint;
    invoke-virtual v0, v2, Landroid/graphics/Paint;->setColor(I)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->invalidate()V
    return-void 
.end method

.method public final startAnimation()void
    .registers 3
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->isRunning Z
    const-wide/16 v0, 0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->lastTime J
    const-wide/16 v0, 10
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->postInvalidateDelayed(J)V
    return-void 
.end method

.method public final stopAnimation()void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->isRunning Z
    const-wide/16 v0, 0
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->lastTime J
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->barParams Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setCurBarHeight(F)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->setChange(F)V
    goto -13h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->invalidate()V
    return-void 
.end method
