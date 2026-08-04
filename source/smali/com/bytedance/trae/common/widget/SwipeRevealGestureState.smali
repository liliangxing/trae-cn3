# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
.super Ljava/lang/Object;
.source "SwipeRevealController.kt"

.field public static final Companion:Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$Companion;
.field private static final HORIZONTAL_DRAG_RATIO:F
.field private static final RELEASE_THRESHOLD_DIVISOR:F
.field private final dampingFactor:F
.field private isDragging:Z
.field private isOpen:Z
.field private startX:F
.field private startY:F
.field private final touchSlop:F
.field private translationX:F


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->Companion Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$Companion;
    return-void 
.end method

.method public constructor <init>(float  float)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->touchSlop F
    iput v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->dampingFactor F
    return-void 
.end method

.method public final getCanTriggerLongPress()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    if-nez v0, +008h
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final getTranslationX()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    return v0
.end method

.method public final isDragging()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    return v0
.end method

.method public final isOpen()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    return v0
.end method

.method public final onDown(float  float)void
    .registers 3
    # ins_size=3
    iput v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->startX F
    iput v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->startY F
    const/4 v1, 0
    iput-boolean v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    return-void 
.end method

.method public final onMove(float  float  float)com.bytedance.trae.common.widget.SwipeRevealGestureState$MoveResult
    .registers 7
    # ins_size=4
    iget v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->startX F
    sub-float/2addr v4, v0
    iget v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->startY F
    sub-float/2addr v5, v0
    const/4 v0, 0
    invoke-static v0, v6, Ljava/lang/Math;->max(F F)F
    move-result v6
    iget-boolean v1, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    if-nez v1, +01fh
    invoke-static v4, Ljava/lang/Math;->abs(F)F
    move-result v1
    iget v2, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->touchSlop F
    cmpl-float v1, v1, v2
    if-lez v1, +015h
    invoke-static v4, Ljava/lang/Math;->abs(F)F
    move-result v1
    invoke-static v5, Ljava/lang/Math;->abs(F)F
    move-result v5
    const/high16 v2, 1069547520
    mul-float/2addr v5, v2
    cmpl-float v5, v1, v5
    if-lez v5, +006h
    const/4 v5, 1
    iput-boolean v5, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    goto +2h
    const/4 v5, 0
    iget-boolean v1, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    if-eqz v1, +018h
    iget-boolean v1, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    if-eqz v1, +004h
    neg-float v1, v6
    goto +2h
    move v1, v0
    iget v2, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->dampingFactor F
    mul-float/2addr v4, v2
    add-float/2addr v1, v4
    neg-float v4, v6
    invoke-static v4, v1, Ljava/lang/Math;->max(F F)F
    move-result v4
    invoke-static v0, v4, Ljava/lang/Math;->min(F F)F
    move-result v4
    iput v4, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    new-instance v4, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
    iget-boolean v6, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    iget v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    invoke-direct v4, v6, v5, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;-><init>(Z Z F)V
    return-object v4
.end method

.method public final onRelease(float)com.bytedance.trae.common.widget.SwipeRevealGestureState$ReleaseResult
    .registers 9
    # ins_size=2
    iget-boolean v0, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    const/4 v1, 0
    invoke-static v1, v8, Ljava/lang/Math;->max(F F)F
    move-result v8
    const/high16 v2, 1077936128
    div-float v2, v8, v2
    const/4 v3, 0
    if-eqz v0, +01ah
    iget-boolean v4, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    const/4 v5, 1
    if-eqz v4, +00bh
    iget v4, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    neg-float v6, v8
    add-float/2addr v6, v2
    cmpg-float v2, v4, v6
    if-gtz v2, +00bh
    goto +dh
    iget v4, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    neg-float v2, v2
    cmpg-float v2, v4, v2
    if-gez v2, +003h
    goto +5h
    move v5, v3
    goto +3h
    iget-boolean v5, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    iput-boolean v3, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    iput-boolean v5, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    if-eqz v5, +003h
    neg-float v1, v8
    iput v1, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    new-instance v8, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;
    iget v1, v7, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    invoke-direct v8, v0, v5, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;-><init>(Z Z F)V
    return-object v8
.end method

.method public final setClosed()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    iput-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    const/4 v0, 0
    iput v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    return-void 
.end method

.method public final setOpen(float)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging Z
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen Z
    const/4 v0, 0
    invoke-static v0, v2, Ljava/lang/Math;->max(F F)F
    move-result v2
    neg-float v2, v2
    iput v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->translationX F
    return-void 
.end method
