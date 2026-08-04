# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "HistorySubtitleAdapter.kt"

.field private final dotsView:Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;


.method public constructor <init>(android.widget.LinearLayout)void
    .registers 3
    # ins_size=2
    const-string v0, "container"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->thinking_dots I
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const-string v0, "findViewById(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;->dotsView Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;
    return-void 
.end method

.method public final bind()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;->dotsView Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;->startShimmer()V
    return-void 
.end method
