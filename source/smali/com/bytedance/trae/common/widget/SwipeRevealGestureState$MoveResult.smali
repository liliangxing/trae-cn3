# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
.super Ljava/lang/Object;
.source "SwipeRevealController.kt"

.field private final dragStarted:Z
.field private final isDragging:Z
.field private final translationX:F


.method public constructor <init>(boolean  boolean  float)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    iput-boolean v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    iput v3, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.common.widget.SwipeRevealGestureState$MoveResult  boolean  boolean  float  int  java.lang.Object)com.bytedance.trae.common.widget.SwipeRevealGestureState$MoveResult
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget v3, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->copy(Z Z F)Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    return v0
.end method

.method public final component3()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    return v0
.end method

.method public final copy(boolean  boolean  float)com.bytedance.trae.common.widget.SwipeRevealGestureState$MoveResult
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;-><init>(Z Z F)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
    iget-boolean v1, v4, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    iget-boolean v3, v5, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    iget-boolean v3, v5, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    iget v5, v5, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    invoke-static v1, v5, Ljava/lang/Float;->compare(F F)I
    move-result v5
    if-eqz v5, +003h
    return v2
    return v0
.end method

.method public final getDragStarted()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    return v0
.end method

.method public final getTranslationX()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isDragging()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MoveResult(isDragging="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", dragStarted="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->dragStarted Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", translationX="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->translationX F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
