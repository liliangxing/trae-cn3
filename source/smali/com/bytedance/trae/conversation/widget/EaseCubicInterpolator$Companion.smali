# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;
.super Ljava/lang/Object;
.source "SpeakerInterpolator.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;-><init>()V
    return-void 
.end method

.method public final cubicCurves(double  double  double  double  double)double
    .registers 23
    # ins_size=11
    const/4 v0, 1
    int-to-double v0, v0
    sub-double/2addr v0, v13
    mul-double v2, v13, v13
    mul-double v4, v0, v0
    mul-double v6, v4, v0
    mul-double v8, v2, v13
    mul-double/2addr v6, v15
    const/4 v10, 3
    int-to-double v10, v10
    mul-double/2addr v4, v10
    mul-double/2addr v4, v13
    mul-double v4, v4, v17
    add-double/2addr v6, v4
    mul-double/2addr v10, v0
    mul-double/2addr v10, v2
    mul-double v10, v10, v19
    add-double/2addr v6, v10
    mul-double v8, v8, v21
    add-double/2addr v6, v8
    return-wide v6
.end method
