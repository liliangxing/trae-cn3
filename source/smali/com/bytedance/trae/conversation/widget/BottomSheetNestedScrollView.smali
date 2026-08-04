# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;
.super Landroidx/core/widget/NestedScrollView;
.source "BottomSheetNestedScrollView.kt"

.field private maxHeight:I
.field private startY:F


.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroidx/core/widget/NestedScrollView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public final getMaxHeight()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->maxHeight I
    return v0
.end method

.method public onInterceptTouchEvent(android.view.MotionEvent)boolean
    .registers 5
    # ins_size=2
    const-string v0, "ev"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/MotionEvent;->getAction()I
    move-result v0
    const/4 v1, 1
    if-eqz v0, +01dh
    const/4 v2, 0
    if-eq v0, v1, +010h
    const/4 v1, 3
    if-eq v0, v1, +003h
    goto +1eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +019h
    invoke-interface v0, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    goto +14h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +00fh
    invoke-interface v0, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    goto +ah
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v1, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    invoke-super v3, v4, Landroidx/core/widget/NestedScrollView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    move-result v4
    return v4
.end method

.method protected onMeasure(int  int)void
    .registers 4
    # ins_size=3
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->maxHeight I
    if-lez v0, +008h
    const/high16 v3, -2147483648
    invoke-static v0, v3, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v3
    invoke-super v1, v2, v3, Landroidx/core/widget/NestedScrollView;->onMeasure(I I)V
    return-void 
.end method

.method public final setMaxHeight(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->maxHeight I
    return-void 
.end method
