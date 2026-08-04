# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment$showTaskTemplates$1;
.super Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
.source "InputFragment.kt"

.field final synthetic $itemSpacing:I


.method constructor <init>(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$showTaskTemplates$1;->$itemSpacing I
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;-><init>()V
    return-void 
.end method

.method public getItemOffsets(android.graphics.Rect  android.view.View  androidx.recyclerview.widget.RecyclerView  androidx.recyclerview.widget.RecyclerView$State)void
    .registers 6
    # ins_size=5
    const-string v0, "outRect"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "parent"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v3, Landroidx/recyclerview/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I
    move-result v3
    if-lez v3, +006h
    iget v3, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$showTaskTemplates$1;->$itemSpacing I
    iput v3, v2, Landroid/graphics/Rect;->top I
    return-void 
.end method
