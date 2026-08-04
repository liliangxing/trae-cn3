# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;
.super Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;
.source "SpeakerInterpolator.kt"


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;-><init>()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;->getMControlPoint1()Landroid/graphics/PointF;
    move-result-object v0
    const/4 v1, 0
    iput v1, v0, Landroid/graphics/PointF;->x F
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;->getMControlPoint1()Landroid/graphics/PointF;
    move-result-object v0
    iput v1, v0, Landroid/graphics/PointF;->y F
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;->getMControlPoint2()Landroid/graphics/PointF;
    move-result-object v0
    const v1, 1058306785
    iput v1, v0, Landroid/graphics/PointF;->x F
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;->getMControlPoint2()Landroid/graphics/PointF;
    move-result-object v0
    const/high16 v1, 1065353216
    iput v1, v0, Landroid/graphics/PointF;->y F
    return-void 
.end method
