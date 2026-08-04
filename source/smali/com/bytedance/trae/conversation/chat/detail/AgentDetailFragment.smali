# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
.super Landroidx/fragment/app/Fragment;
.source "AgentDetailFragment.kt"

.field private static final ARG_BLOCK_KEY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;
.field private agentHeaderContainer:Landroid/widget/FrameLayout;
.field private blockKey:Ljava/lang/String;
.field private contentContainer:Landroid/widget/LinearLayout;
.field private final expandedSegments:Ljava/util/Set;


.method public static synthetic $r8$lambda$DstCt0-nRsh7QamcsdpuGKxY6dI(com.bytedance.trae.conversation.chat.detail.AgentDetailFragment  int  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->renderContent$lambda$0(Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment; I Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$siEJZ8LyB53GFzLHLX57914L2bk(com.bytedance.trae.conversation.chat.detail.AgentDetailFragment  com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->createSubAgentRow$lambda$7(Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->blockKey Ljava/lang/String;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->expandedSegments Ljava/util/Set;
    return-void 
.end method

.method private final buildPlanItemContext(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)com.bytedance.trae.conversation.chat.toolcall.PlanItemContext
    .registers 15
    # ins_size=2
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v1, "extra_conversation"
    invoke-virtual v0, v1, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/Conversation;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    goto +2h
    move-object v0, v2
    if-eqz v0, +018h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +012h
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +003h
    goto +19h
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-nez v1, +010h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v3, "extra_conversation_id"
    invoke-virtual v1, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object v7, v1
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    const/4 v4, 0
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentRunId()Ljava/lang/String;
    move-result-object v6
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    move-object v8, v2
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 97
    const/4 v12, 0
    move-object v3, v1
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method private final createSubAgentRow(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)android.view.View
    .registers 11
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 0
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v4, 16
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v4, 10
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v4, v4
    invoke-virtual v2, v3, v4, v3, v4, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v6, -2
    invoke-direct v4, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/ImageView;
    invoke-direct v4, v0, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v5, Landroid/widget/ImageView$ScaleType;->CENTER_CROP Landroid/widget/ImageView$ScaleType;
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;->getAvatarResId(Ljava/lang/String;)I
    move-result v5
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setImageResource(I)V
    const/16 v5, 24
    int-to-float v5, v5
    mul-float/2addr v5, v1
    float-to-int v5, v5
    check-cast v4, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v4, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +003h
    goto +ch
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_sub_agent_default I
    invoke-virtual v9, v5, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    const-string v7, "getString(...)"
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v4, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v5, 1096810496
    const/4 v7, 2
    invoke-virtual v4, v7, v5, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v5, 1
    invoke-virtual v4, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    check-cast v4, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v8, 1065353216
    invoke-direct v5, v3, v6, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v3, 6
    int-to-float v3, v3
    mul-float/2addr v3, v1
    float-to-int v1, v3
    invoke-virtual v5, v1, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v4, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const-string/jumbo v3, ›
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v0, 1098907648
    invoke-virtual v1, v7, v0, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v9, v10, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v2, Landroid/view/View;
    return-object v2
.end method

.method private static final createSubAgentRow$lambda$7(com.bytedance.trae.conversation.chat.detail.AgentDetailFragment  com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    if-eqz v2, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;->newInstance(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;
    move-result-object v1
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->navigateTo(Landroidx/fragment/app/Fragment;)V
    return-void 
.end method

.method private final createThoughtView(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Thought)android.view.View
    .registers 18
    # ins_size=2
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v6
    const-string/jumbo v0, requireContext(...)
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v7, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v15, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v15
    move-object v1, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v6, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextColor(I)V
    const/4 v0, 2
    const/high16 v1, 1097859072
    invoke-virtual v15, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextSize(I F)V
    const/4 v0, 0
    const v1, 1068708659
    invoke-virtual v15, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLineSpacing(F F)V
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v0
    invoke-virtual v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    const/16 v0, 8
    int-to-float v0, v0
    mul-float/2addr v0, v7
    float-to-int v0, v0
    const/4 v1, 0
    invoke-virtual v15, v1, v0, v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setPadding(I I I I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;->getThought()Ljava/lang/String;
    move-result-object v10
    const/4 v11, 1
    const/4 v12, 0
    const/16 v13, 8
    const/4 v14, 0
    move-object v9, v15
    invoke-static/range v8 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    check-cast v15, Landroid/view/View;
    return-object v15
.end method

.method private final renderAgentDetail(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->renderHeader(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->renderContent(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    return-void 
.end method

.method private final renderContent(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->contentContainer Landroid/widget/LinearLayout;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->segment(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->buildPlanItemContext(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v8
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +061h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;
    if-eqz v4, +02dh
    new-instance v4, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v5
    const-string/jumbo v6, requireContext(...)
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;-><init>(Landroid/content/Context;)V
    check-cast v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->expandedSegments Ljava/util/Set;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v5, v6, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    new-instance v6, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda1;
    invoke-direct v6, v7, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment; I)V
    invoke-virtual v4, v3, v8, v5, v6, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->bind(Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Z Lkotlin/jvm/functions/Function1;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    add-int/lit8 v2, v2, 1
    goto -3ah
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ThoughtSegment;
    if-eqz v4, +010h
    check-cast v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ThoughtSegment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ThoughtSegment;->getThought()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    move-result-object v3
    invoke-direct v7, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->createThoughtView(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;)Landroid/view/View;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -4ch
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
    if-eqz v4, +010h
    check-cast v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;->getSubAgent()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    move-result-object v3
    invoke-direct v7, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->createSubAgentRow(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)Landroid/view/View;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -5eh
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    return-void 
.end method

.method private static final renderContent$lambda$0(com.bytedance.trae.conversation.chat.detail.AgentDetailFragment  int  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    if-eqz v2, +00ch
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->expandedSegments Ljava/util/Set;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    goto +ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->expandedSegments Ljava/util/Set;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final renderHeader(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->agentHeaderContainer Landroid/widget/FrameLayout;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/FrameLayout;->removeAllViews()V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;-><init>(Landroid/content/Context;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getDescription()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v2, v3, v5, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->bind(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_agent_detail I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/conversation/R$id;->fl_agent_header I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/FrameLayout;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->agentHeaderContainer Landroid/widget/FrameLayout;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->ll_content I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/LinearLayout;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +009h
    const-string v0, "block_key"
    invoke-virtual v2, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    if-nez v2, +004h
    const-string v2, ""
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->blockKey Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->blockKey Ljava/lang/String;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-nez v0, +003h
    goto +2h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-nez v3, +003h
    return-void 
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;->renderAgentDetail(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    return-void 
.end method
