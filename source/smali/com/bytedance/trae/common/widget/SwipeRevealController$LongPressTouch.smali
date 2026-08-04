# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
.super Ljava/lang/Object;
.source "SwipeRevealController.kt"

.field private final rawX:F
.field private final rawY:F


.method public constructor <init>(float  float)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    iput v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch  float  float  int  java.lang.Object)com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->copy(F F)Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    move-result-object v0
    return-object v0
.end method

.method public final component1()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    return v0
.end method

.method public final component2()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    return v0
.end method

.method public final copy(float  float)com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;-><init>(F F)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    iget v1, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    iget v3, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    iget v5, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    invoke-static v1, v5, Ljava/lang/Float;->compare(F F)I
    move-result v5
    if-eqz v5, +003h
    return v2
    return v0
.end method

.method public final getRawX()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    return v0
.end method

.method public final getRawY()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    invoke-static v0, Ljava/lang/Float;->hashCode(F)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "LongPressTouch(rawX="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawX F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawY="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->rawY F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
