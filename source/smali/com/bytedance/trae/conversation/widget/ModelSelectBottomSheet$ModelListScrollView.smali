# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;
.super Landroidx/core/widget/NestedScrollView;
.source "ModelSelectBottomSheet.kt"

.field private lastY:F


.method public constructor <init>(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroidx/core/widget/NestedScrollView;-><init>(Landroid/content/Context;)V
    return-void 
.end method

.method public dispatchTouchEvent(android.view.MotionEvent)boolean
    .registers 6
    # ins_size=2
    const-string v0, "ev"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v0
    const/4 v1, 1
    if-eqz v0, +03eh
    const/4 v2, 0
    if-eq v0, v1, +031h
    const/4 v3, 2
    if-eq v0, v3, +006h
    const/4 v1, 3
    if-eq v0, v1, +02bh
    goto +42h
    invoke-virtual v5, Landroid/view/MotionEvent;->getY()F
    move-result v0
    iget v3, v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->lastY F
    cmpl-float v0, v0, v3
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00ah
    const/4 v0, -1
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->canScrollVertically(I)Z
    move-result v0
    if-nez v0, +003h
    move v2, v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +006h
    xor-int/2addr v1, v2
    invoke-interface v0, v1, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    invoke-virtual v5, Landroid/view/MotionEvent;->getY()F
    move-result v0
    iput v0, v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->lastY F
    goto +1ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +015h
    invoke-interface v0, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    goto +10h
    invoke-virtual v5, Landroid/view/MotionEvent;->getY()F
    move-result v0
    iput v0, v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->lastY F
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v1, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    invoke-super v4, v5, Landroidx/core/widget/NestedScrollView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    move-result v5
    return v5
.end method
