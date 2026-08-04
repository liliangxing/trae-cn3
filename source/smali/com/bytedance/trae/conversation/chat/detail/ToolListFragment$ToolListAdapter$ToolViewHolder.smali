# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "ToolListFragment.kt"

.field private card:Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
.field private final flContent:Landroid/widget/FrameLayout;
.field private final ivChevronRight:Landroid/widget/ImageView;
.field private final ivIcon:Landroid/widget/ImageView;
.field private final llBody:Landroid/widget/LinearLayout;
.field private final llHeader:Landroid/widget/LinearLayout;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
.field private final tvBadge:Landroid/widget/TextView;
.field private final tvIconEmoji:Landroid/widget/TextView;
.field private final tvSubtitle:Landroid/widget/TextView;
.field private final tvTitle:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;


.method public constructor <init>(com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
    invoke-direct v1, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const-string v0, "findViewById(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_icon_emoji I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvIconEmoji Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvTitle Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvSubtitle Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_badge I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvBadge Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_chevron_right I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->ivChevronRight Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->ll_header I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/LinearLayout;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->llHeader Landroid/widget/LinearLayout;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->ll_body I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/LinearLayout;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->llBody Landroid/widget/LinearLayout;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->fl_content I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/FrameLayout;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->flContent Landroid/widget/FrameLayout;
    return-void 
.end method

.method public final getCard()com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->card Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    return-object v0
.end method

.method public final getFlContent()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->flContent Landroid/widget/FrameLayout;
    return-object v0
.end method

.method public final getIvChevronRight()android.widget.ImageView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->ivChevronRight Landroid/widget/ImageView;
    return-object v0
.end method

.method public final getIvIcon()android.widget.ImageView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->ivIcon Landroid/widget/ImageView;
    return-object v0
.end method

.method public final getLlBody()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->llBody Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public final getLlHeader()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->llHeader Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public final getTvBadge()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvBadge Landroid/widget/TextView;
    return-object v0
.end method

.method public final getTvIconEmoji()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvIconEmoji Landroid/widget/TextView;
    return-object v0
.end method

.method public final getTvSubtitle()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvSubtitle Landroid/widget/TextView;
    return-object v0
.end method

.method public final getTvTitle()com.bytedance.trae.conversation.widget.ShimmerTextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->tvTitle Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    return-object v0
.end method

.method public final setCard(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->card Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    return-void 
.end method
