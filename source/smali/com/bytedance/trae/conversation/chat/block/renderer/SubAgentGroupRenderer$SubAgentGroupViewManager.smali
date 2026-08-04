# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;
.super Ljava/lang/Object;
.source "SubAgentGroupRenderer.kt"

.field private currentStatus:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
.field private headerRow:Landroid/widget/LinearLayout;
.field private iconView:Landroid/widget/ImageView;
.field private latestBlock:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
.field private final pureShowWidgetRenderer:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
.field private titleView:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
.field private widgetContainer:Landroid/widget/LinearLayout;


.method public static synthetic $r8$lambda$Dt2ycWEz7Bk5CvMzGr545CcHFDw(com.bytedance.trae.conversation.chat.block.renderer.SubAgentGroupRenderer$SubAgentGroupViewManager  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->render$lambda$7(Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    return-void 
.end method

.method private final applyStatus(com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-eq v2, v0, +009h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v2, v0, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    return-void 
.end method

.method private final bindWidgets(java.util.List)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->widgetContainer Landroid/widget/LinearLayout;
    if-nez v0, +003h
    return-void 
    check-cast v9, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00eh
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    if-eqz v3, -00ch
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v1, Ljava/util/List;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v9
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v2
    if-le v9, v2, +01ah
    invoke-virtual v0, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v9
    add-int/lit8 v9, v9, -1
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    invoke-virtual v0, v9, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v3
    const-string v4, "getChildAt(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->release$conversation_mainlandRelease(Landroid/view/View;)V
    invoke-virtual v0, v9, Landroid/widget/LinearLayout;->removeViewAt(I)V
    goto -21h
    move-object v9, v1
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    const/4 v2, 0
    move v3, v2
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +038h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    add-int/lit8 v5, v3, 1
    if-gez v3, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +008h
    iget-object v6, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    invoke-virtual v6, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)V
    goto +1ch
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v6
    const-string v7, "getContext(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)Landroid/view/View;
    move-result-object v3
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -1
    const/4 v7, -2
    invoke-direct v4, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move v3, v5
    goto -3bh
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v9
    if-eqz v9, +004h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
.end method

.method private static final render$lambda$7(com.bytedance.trae.conversation.chat.block.renderer.SubAgentGroupRenderer$SubAgentGroupViewManager  android.view.View)void
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
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-nez v1, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;->showAgentDetail(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    return-void 
.end method

.method public final getCurrentStatus()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v0
.end method

.method public final getHeaderRow()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public final getIconView()android.widget.ImageView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->iconView Landroid/widget/ImageView;
    return-object v0
.end method

.method public final getLatestBlock()com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    return-object v0
.end method

.method public final getPureShowWidgetRenderer()com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetToolcallGroupRenderer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    return-object v0
.end method

.method public final getTitleView()com.bytedance.trae.conversation.widget.ShimmerTextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    return-object v0
.end method

.method public final getWidgetContainer()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->widgetContainer Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public final render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)android.view.View
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v7, v19
    move-object/from16 v8, v20
    const-string v1, "context"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "block"
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual/range v19, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v9, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    new-instance v10, Landroid/widget/LinearLayout;
    invoke-direct v10, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v11, 1
    invoke-virtual v10, v11, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v12, -1
    const/4 v13, -2
    invoke-direct v1, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v2, 4
    int-to-float v2, v2
    mul-float/2addr v2, v9
    float-to-int v14, v2
    iput v14, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v14, v1, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v15, 0
    invoke-virtual v1, v15, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v1, v2
    mul-float/2addr v1, v9
    float-to-int v1, v1
    new-instance v2, Landroid/widget/ImageView;
    invoke-direct v2, v7, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->agent I
    invoke-virtual v2, v3, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v3, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v2, v3, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->iconView Landroid/widget/ImageView;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    if-eqz v3, +00eh
    check-cast v2, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v2, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getDescription()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +013h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +00dh
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_sub_agent_default I
    invoke-virtual v7, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "getString(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v16, v1
    new-instance v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/16 v17, 0
    move-object v1, v6
    move-object/from16 v2, v19
    move-object v12, v6
    move-object/from16 v6, v17
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v1, v16
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextColor(I)V
    const/4 v1, 2
    const/high16 v2, 1098907648
    invoke-virtual v12, v1, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextSize(I F)V
    move-object v6, v12
    check-cast v6, Landroid/widget/TextView;
    const/16 v1, 22
    int-to-float v1, v1
    mul-float/2addr v1, v9
    float-to-int v1, v1
    invoke-static v6, v1, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const v1, -1130650141
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setLetterSpacing(F)V
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setMaxLines(I)V
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v12, v14, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setCompoundDrawablePadding(I)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->chevron_right I
    invoke-virtual v12, v15, v15, v1, v15, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    iput-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    if-eqz v1, +014h
    move-object v6, v12
    check-cast v6, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v13, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v2, v14, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v6, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v11, Landroid/widget/LinearLayout;->setOrientation(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->widgetContainer Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    invoke-direct v2, v3, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->applyStatus(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->bindWidgets(Ljava/util/List;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    if-eqz v1, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager$$ExternalSyntheticLambda0;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;)V
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v10, Landroid/view/View;
    return-object v10
.end method

.method public final setCurrentStatus(com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-void 
.end method

.method public final setHeaderRow(android.widget.LinearLayout)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    return-void 
.end method

.method public final setIconView(android.widget.ImageView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->iconView Landroid/widget/ImageView;
    return-void 
.end method

.method public final setLatestBlock(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    return-void 
.end method

.method public final setTitleView(com.bytedance.trae.conversation.widget.ShimmerTextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    return-void 
.end method

.method public final setWidgetContainer(android.widget.LinearLayout)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->widgetContainer Landroid/widget/LinearLayout;
    return-void 
.end method

.method public final update(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup)void
    .registers 4
    # ins_size=2
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->latestBlock Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getDescription()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00bh
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v1, +007h
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->applyStatus(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;->bindWidgets(Ljava/util/List;)V
    return-void 
.end method
