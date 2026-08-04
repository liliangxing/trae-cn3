# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "ToolListFragment.kt"

.field private final items:Ljava/util/List;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;


.method public static synthetic $r8$lambda$KPt4KrXAyA2dnUUgU0P8SQ59amw(kotlin.jvm.functions.Function1  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->bindCard$lambda$0(Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.chat.detail.ToolListFragment  java.util.List)void
    .registers 4
    # ins_size=3
    const-string v0, "items"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->items Ljava/util/List;
    return-void 
.end method

.method private final bindCard(com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListAdapter$ToolViewHolder  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard)void
    .registers 9
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconResId()I
    move-result v1
    const/16 v2, 8
    const/4 v3, 0
    if-eqz v1, +040h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconResId()I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconTintColorRes()I
    move-result v4
    if-eqz v4, +00fh
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconTintColorRes()I
    move-result v4
    invoke-static v0, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-static v4, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v4
    goto +bh
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v0, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-static v4, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v4
    invoke-virtual v1, v4, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v1
    invoke-virtual v1, v3, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvIconEmoji()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    goto +1ch
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvIconEmoji()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconEmoji()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvIconEmoji()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v1, v3, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v1
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvTitle()Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getTitle()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvTitle()Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getShimmerTitle()Z
    move-result v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getSubtitle()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v4, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v3
    goto +2h
    move v1, v4
    if-eqz v1, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvSubtitle()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    goto +15h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvSubtitle()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getSubtitle()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v1, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvSubtitle()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v1, v3, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getBadgeText()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v4, v3
    if-eqz v4, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvBadge()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    goto +4ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvBadge()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getBadgeText()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getStatus()Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v1, v4, +019h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvBadge()Landroid/widget/TextView;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_tool_badge_cancel I
    invoke-virtual v1, v4, Landroid/widget/TextView;->setBackgroundResource(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvBadge()Landroid/widget/TextView;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v0, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTextColor(I)V
    goto +17h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvBadge()Landroid/widget/TextView;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_tool_badge_warning I
    invoke-virtual v1, v4, Landroid/widget/TextView;->setBackgroundResource(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvBadge()Landroid/widget/TextView;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-static v0, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getTvBadge()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v1, v3, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getFlContent()Landroid/widget/FrameLayout;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/FrameLayout;->removeAllViews()V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOrCreateContentView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +028h
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v4
    if-eqz v4, +013h
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v4
    instance-of v5, v4, Landroid/view/ViewGroup;
    if-eqz v5, +005h
    check-cast v4, Landroid/view/ViewGroup;
    goto +2h
    move-object v4, v1
    if-eqz v4, +005h
    invoke-virtual v4, v0, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getFlContent()Landroid/widget/FrameLayout;
    move-result-object v4
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getFlContent()Landroid/widget/FrameLayout;
    move-result-object v0
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setVisibility(I)V
    goto +8h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getFlContent()Landroid/widget/FrameLayout;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOnDetailClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +01ch
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getIvChevronRight()Landroid/widget/ImageView;
    move-result-object v0
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getLlHeader()Landroid/widget/LinearLayout;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOnDetailClick()Lkotlin/jvm/functions/Function1;
    move-result-object v8
    if-eqz v8, +007h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$$ExternalSyntheticLambda0;
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v7, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +16h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getIvChevronRight()Landroid/widget/ImageView;
    move-result-object v8
    invoke-virtual v8, v2, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getLlHeader()Landroid/widget/LinearLayout;
    move-result-object v8
    invoke-virtual v8, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getLlHeader()Landroid/widget/LinearLayout;
    move-result-object v7
    invoke-virtual v7, v3, Landroid/widget/LinearLayout;->setClickable(Z)V
    return-void 
.end method

.method private static final bindCard$lambda$0(kotlin.jvm.functions.Function1  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final createCard(com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListItem)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 16
    # ins_size=2
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    if-eqz v1, +013h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    check-cast v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->getPlanItemContext()Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v15
    invoke-virtual v1, v0, v2, v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createDetailCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v15
    goto +2fh
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;
    if-eqz v1, +02dh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    check-cast v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    new-instance v13, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;->getThinking()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getPlanItemId()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;->getThinking()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getReasoningContent()Ljava/lang/String;
    move-result-object v10
    const/16 v11, 62
    const/4 v12, 0
    move-object v3, v13
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v1, v0, v2, v13, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createThinkingCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v15
    return-object v15
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
.end method

.method private final updateCard(com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListItem)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 16
    # ins_size=2
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    if-eqz v1, +013h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    check-cast v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->getPlanItemContext()Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v15
    invoke-virtual v1, v0, v2, v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->updateDetailCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v15
    return-object v15
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;
    if-eqz v1, +02dh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    check-cast v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    new-instance v13, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;->getThinking()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getPlanItemId()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;->getThinking()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getReasoningContent()Ljava/lang/String;
    move-result-object v10
    const/16 v11, 62
    const/4 v12, 0
    move-object v3, v13
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v1, v0, v2, v13, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->updateThinkingCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v15
    return-object v15
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListAdapter$ToolViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->items Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->getCard()Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    if-nez v0, +007h
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->createCard(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v3
    goto +dh
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->updateCard(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    if-nez v0, +007h
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->createCard(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v3
    goto +2h
    move-object v3, v0
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;->setCard(Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->bindCard(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder; Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListAdapter$ToolViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_tool_list I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;-><init>(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter; Landroid/view/View;)V
    return-object v4
.end method
