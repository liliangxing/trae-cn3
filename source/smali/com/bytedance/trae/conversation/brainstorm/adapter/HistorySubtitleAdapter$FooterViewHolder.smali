# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "HistorySubtitleAdapter.kt"

.field private final container:Landroid/widget/LinearLayout;
.field private final shimmerTextView:Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;


.method public constructor <init>(android.widget.LinearLayout)void
    .registers 3
    # ins_size=2
    const-string v0, "container"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->container Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_footer_shimmer I
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const-string v0, "findViewById(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->shimmerTextView Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem)void
    .registers 4
    # ins_size=2
    const-string v0, "item"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->shimmerTextView Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getContent()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->container Landroid/widget/LinearLayout;
    const v0, 8388611
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->setGravity(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->shimmerTextView Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    const/4 v0, 0
    const/4 v1, 0
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setTypeface(Landroid/graphics/Typeface; I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->shimmerTextView Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    move-object v0, v3
    check-cast v0, Landroid/widget/TextView;
    const/16 v1, 20
    int-to-float v1, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v1, v3
    float-to-int v3, v1
    invoke-static v0, v3, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->shimmerTextView Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->startShimmer()V
    return-void 
.end method

.method public final updateText(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->shimmerTextView Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
