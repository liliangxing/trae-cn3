# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;
.super Ljava/lang/Object;
.source "AudioVisualizerView.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;-><init>()V
    return-void 
.end method

.method public final optAmplitude(double)float
    .registers 5
    # ins_size=3
    const-wide v0, 4605380978949069210
    cmpl-double v0, v3, v0
    if-lez v0, +005h
    const-wide/high16 v3, 4607182418800017408
    goto +bh
    const-wide v0, 4614256656552045848
    mul-double/2addr v3, v0
    invoke-static v3, v4, Ljava/lang/Math;->sin(D)D
    move-result-wide v3
    double-to-float v3, v3
    const/high16 v4, 1075838976
    mul-float/2addr v3, v4
    const/high16 v4, 1065353216
    invoke-static v3, v4, Lkotlin/ranges/RangesKt;->coerceAtMost(F F)F
    move-result v3
    return v3
.end method
