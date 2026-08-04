# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;
.super Landroid/view/ViewGroup;
.source "NotifyUserDialogCreator.kt"

.field private horizontalGap:I
.field private verticalGap:I


.method public constructor <init>(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V
    return-void 
.end method

.method protected checkLayoutParams(android.view.ViewGroup$LayoutParams)boolean
    .registers 2
    # ins_size=2
    instance-of v1, v1, Landroid/view/ViewGroup$MarginLayoutParams;
    return v1
.end method

.method protected generateDefaultLayoutParams()android.view.ViewGroup$LayoutParams
    .registers 3
    # ins_size=1
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;
    const/4 v1, -2
    invoke-direct v0, v1, v1, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    return-object v0
.end method

.method public generateLayoutParams(android.util.AttributeSet)android.view.ViewGroup$LayoutParams
    .registers 4
    # ins_size=2
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v0, v1, v3, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/content/Context; Landroid/util/AttributeSet;)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    return-object v0
.end method

.method protected generateLayoutParams(android.view.ViewGroup$LayoutParams)android.view.ViewGroup$LayoutParams
    .registers 3
    # ins_size=2
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-direct v0, v2, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    return-object v0
.end method

.method public final getHorizontalGap()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->horizontalGap I
    return v0
.end method

.method public final getVerticalGap()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->verticalGap I
    return v0
.end method

.method protected onLayout(boolean  int  int  int  int)void
    .registers 15
    # ins_size=6
    sub-int/2addr v13, v11
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v10
    sub-int/2addr v13, v10
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingRight()I
    move-result v10
    sub-int/2addr v13, v10
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v10
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingTop()I
    move-result v11
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getChildCount()I
    move-result v12
    const/4 v14, 0
    move v0, v14
    move v1, v0
    if-ge v0, v12, +06dh
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    invoke-virtual v2, Landroid/view/View;->getVisibility()I
    move-result v3
    const/16 v4, 8
    if-eq v3, v4, +05eh
    invoke-virtual v2, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    const-string v4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual v2, Landroid/view/View;->getMeasuredWidth()I
    move-result v4
    iget v5, v3, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin I
    add-int/2addr v4, v5
    iget v5, v3, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin I
    add-int/2addr v4, v5
    invoke-virtual v2, Landroid/view/View;->getMeasuredHeight()I
    move-result v5
    iget v6, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    add-int/2addr v5, v6
    iget v6, v3, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin I
    add-int/2addr v5, v6
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v6
    if-le v10, v6, +018h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v6
    sub-int v6, v10, v6
    iget v7, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->horizontalGap I
    add-int/2addr v6, v7
    add-int/2addr v6, v4
    if-le v6, v13, +00ch
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v10
    iget v6, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->verticalGap I
    add-int/2addr v1, v6
    add-int/2addr v11, v1
    move v1, v14
    goto +ah
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v6
    if-le v10, v6, +005h
    iget v6, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->horizontalGap I
    add-int/2addr v10, v6
    iget v6, v3, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin I
    add-int/2addr v6, v10
    iget v3, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    add-int/2addr v3, v11
    invoke-virtual v2, Landroid/view/View;->getMeasuredWidth()I
    move-result v7
    add-int/2addr v7, v6
    invoke-virtual v2, Landroid/view/View;->getMeasuredHeight()I
    move-result v8
    add-int/2addr v8, v3
    invoke-virtual v2, v6, v3, v7, v8, Landroid/view/View;->layout(I I I I)V
    add-int/2addr v10, v4
    invoke-static v1, v5, Ljava/lang/Math;->max(I I)I
    move-result v1
    add-int/lit8 v0, v0, 1
    goto -6ch
    return-void 
.end method

.method protected onMeasure(int  int)void
    .registers 18
    # ins_size=3
    move-object v6, v15
    invoke-static/range v16, Landroid/view/View$MeasureSpec;->getSize(I)I
    move-result v0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v1
    sub-int/2addr v0, v1
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingRight()I
    move-result v1
    sub-int v7, v0, v1
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingTop()I
    move-result v0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingBottom()I
    move-result v1
    add-int/2addr v0, v1
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getChildCount()I
    move-result v8
    const/4 v1, 0
    move v9, v0
    move v10, v1
    move v11, v10
    move v12, v11
    move v13, v12
    if-ge v10, v8, +05bh
    invoke-virtual v15, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v14
    invoke-virtual v14, Landroid/view/View;->getVisibility()I
    move-result v0
    const/16 v1, 8
    if-eq v0, v1, +04ch
    const/4 v3, 0
    const/4 v5, 0
    move-object v0, v15
    move-object v1, v14
    move/from16 v2, v16
    move/from16 v4, v17
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->measureChildWithMargins(Landroid/view/View; I I I I)V
    invoke-virtual v14, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual v14, Landroid/view/View;->getMeasuredWidth()I
    move-result v1
    iget v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin I
    add-int/2addr v1, v2
    iget v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin I
    add-int/2addr v1, v2
    invoke-virtual v14, Landroid/view/View;->getMeasuredHeight()I
    move-result v2
    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    add-int/2addr v2, v3
    iget v0, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin I
    add-int/2addr v2, v0
    if-lez v13, +014h
    iget v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->horizontalGap I
    add-int/2addr v0, v13
    add-int/2addr v0, v1
    if-le v0, v7, +00eh
    iget v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->verticalGap I
    add-int/2addr v11, v0
    add-int/2addr v9, v11
    invoke-static v12, v13, Ljava/lang/Math;->max(I I)I
    move-result v0
    move v12, v0
    move v13, v1
    move v11, v2
    goto +dh
    if-nez v13, +003h
    goto +4h
    iget v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->horizontalGap I
    add-int/2addr v1, v0
    add-int/2addr v13, v1
    invoke-static v11, v2, Ljava/lang/Math;->max(I I)I
    move-result v0
    move v11, v0
    add-int/lit8 v10, v10, 1
    goto -5ah
    add-int/2addr v9, v11
    invoke-static v12, v13, Ljava/lang/Math;->max(I I)I
    move-result v0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingLeft()I
    move-result v1
    add-int/2addr v0, v1
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->getPaddingRight()I
    move-result v1
    add-int/2addr v0, v1
    move/from16 v1, v16
    invoke-static v0, v1, Landroid/view/ViewGroup;->resolveSize(I I)I
    move-result v0
    move/from16 v1, v17
    invoke-static v9, v1, Landroid/view/ViewGroup;->resolveSize(I I)I
    move-result v1
    invoke-virtual v15, v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->setMeasuredDimension(I I)V
    return-void 
.end method

.method public final setHorizontalGap(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->horizontalGap I
    return-void 
.end method

.method public final setVerticalGap(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;->verticalGap I
    return-void 
.end method
