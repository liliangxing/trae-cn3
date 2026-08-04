# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;
.super Ljava/lang/Object;
.source "SpeakerInterpolator.kt"

.implements Landroid/view/animation/Interpolator;

.field private static final ACCURACY:I
.field public static final Companion:Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;
.field private final mControlPoint1:Landroid/graphics/PointF;
.field private final mControlPoint2:Landroid/graphics/PointF;
.field private mLastI:I


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->Companion Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Landroid/graphics/PointF;
    invoke-direct v0, Landroid/graphics/PointF;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint1 Landroid/graphics/PointF;
    new-instance v0, Landroid/graphics/PointF;
    invoke-direct v0, Landroid/graphics/PointF;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint2 Landroid/graphics/PointF;
    return-void 
.end method

.method public getInterpolation(float)float
    .registers 15
    # ins_size=2
    iget v0, v13, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mLastI I
    move v1, v14
    const/16 v2, 4096
    if-ge v0, v2, +029h
    const/high16 v1, 1065353216
    int-to-float v3, v0
    mul-float/2addr v3, v1
    int-to-float v1, v2
    div-float v1, v3, v1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->Companion Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;
    float-to-double v3, v1
    const-wide/16 v5, 0
    iget-object v7, v13, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint1 Landroid/graphics/PointF;
    iget v7, v7, Landroid/graphics/PointF;->x F
    float-to-double v7, v7
    iget-object v9, v13, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint2 Landroid/graphics/PointF;
    iget v9, v9, Landroid/graphics/PointF;->x F
    float-to-double v9, v9
    const-wide/high16 v11, 4607182418800017408
    invoke-virtual/range v2 ... v12, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;->cubicCurves(D D D D D)D
    move-result-wide v2
    float-to-double v4, v14
    cmpl-double v2, v2, v4
    if-ltz v2, +005h
    iput v0, v13, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mLastI I
    goto +4h
    add-int/lit8 v0, v0, 1
    goto -2ah
    sget-object v2, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->Companion Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;
    float-to-double v3, v1
    const-wide/16 v5, 0
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint1 Landroid/graphics/PointF;
    iget v14, v14, Landroid/graphics/PointF;->y F
    float-to-double v7, v14
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint2 Landroid/graphics/PointF;
    iget v14, v14, Landroid/graphics/PointF;->y F
    float-to-double v9, v14
    const-wide/high16 v11, 4607182418800017408
    invoke-virtual/range v2 ... v12, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;->cubicCurves(D D D D D)D
    move-result-wide v0
    const-wide v2, 4607173411600762667
    cmpl-double v14, v0, v2
    if-lez v14, +007h
    const/4 v14, 0
    iput v14, v13, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mLastI I
    const-wide/high16 v0, 4607182418800017408
    double-to-float v14, v0
    return v14
.end method

.method protected final getMControlPoint1()android.graphics.PointF
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint1 Landroid/graphics/PointF;
    return-object v0
.end method

.method protected final getMControlPoint2()android.graphics.PointF
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;->mControlPoint2 Landroid/graphics/PointF;
    return-object v0
.end method
