# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;
.super Ljava/lang/Object;
.source "ToolcallGroupRenderer.kt"

.field private latestBlock:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
.field private titleView:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;


.method public static synthetic $r8$lambda$sOWuLHLTggPFAIi6oWjnJ2kZnEs(com.bytedance.trae.conversation.chat.block.renderer.ToolcallGroupRenderer$ToolcallGroupViewManager  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->render$lambda$3(Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final render$lambda$3(com.bytedance.trae.conversation.chat.block.renderer.ToolcallGroupRenderer$ToolcallGroupViewManager  android.view.View)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    instance-of v0, v2, Landroidx/fragment/app/FragmentActivity;
    if-eqz v0, +005h
    check-cast v2, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +013h
    invoke-virtual v2, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    if-nez v2, +003h
    goto +bh
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-nez v1, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;->showToolList(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)V
    return-void 
.end method

.method public final getLatestBlock()com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    return-object v0
.end method

.method public final getTitleView()com.bytedance.trae.conversation.widget.ShimmerTextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    return-object v0
.end method

.method public final render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)android.view.View
    .registers 15
    # ins_size=3
    const-string v0, "context"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v14, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v13, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v13, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 16
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v4, 2
    int-to-float v6, v4
    mul-float/2addr v6, v0
    float-to-int v6, v6
    iput v6, v3, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v6, v3, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    invoke-virtual v1, v2, v6, v2, v6, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 6
    const/4 v11, 0
    move-object v6, v3
    move-object v7, v13
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getTitle()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v3, v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v13, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v13
    invoke-virtual v3, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextColor(I)V
    const/high16 v13, 1097859072
    invoke-virtual v3, v4, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextSize(I F)V
    const/4 v13, 1
    invoke-virtual v3, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setMaxLines(I)V
    sget-object v4, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    const/4 v4, 4
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v0, v4
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setCompoundDrawablePadding(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->chevron_right I
    invoke-virtual v3, v2, v2, v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    iput-object v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    check-cast v3, Landroid/view/View;
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v0, +00ah
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getGroupFinished()Z
    move-result v14
    xor-int/2addr v13, v14
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    new-instance v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager$$ExternalSyntheticLambda0;
    invoke-direct v13, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;)V
    invoke-virtual v1, v13, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v14, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v14, +005h
    invoke-virtual v14, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public final setLatestBlock(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    return-void 
.end method

.method public final setTitleView(com.bytedance.trae.conversation.widget.ShimmerTextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    return-void 
.end method

.method public final update(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)void
    .registers 4
    # ins_size=2
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v0, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getTitle()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v0, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getGroupFinished()Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    return-void 
.end method
