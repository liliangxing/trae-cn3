# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;
.super Ljava/lang/Object;
.source "StepInterpolator.kt"

.implements Landroid/view/animation/Interpolator;

.field private final steps:I


.method public constructor <init>(int)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;->steps I
    if-lez v3, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, steps must be > 0, got 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    new-instance v0, Ljava/lang/IllegalArgumentException;
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public getInterpolation(float)float
    .registers 4
    # ins_size=2
    const/high16 v0, 1065353216
    cmpl-float v1, v3, v0
    if-ltz v1, +003h
    return v0
    const/4 v0, 0
    cmpg-float v1, v3, v0
    if-gtz v1, +003h
    return v0
    iget v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;->steps I
    int-to-float v0, v0
    mul-float/2addr v3, v0
    float-to-double v0, v3
    invoke-static v0, v1, Ljava/lang/Math;->floor(D)D
    move-result-wide v0
    double-to-float v3, v0
    iget v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;->steps I
    int-to-float v0, v0
    div-float/2addr v3, v0
    return v3
.end method
