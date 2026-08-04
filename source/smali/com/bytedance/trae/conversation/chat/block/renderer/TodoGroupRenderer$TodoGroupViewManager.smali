# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;
.super Ljava/lang/Object;
.source "TodoGroupRenderer.kt"

.field private childAdapter:Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
.field private childRecyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private contentArea:Landroid/widget/FrameLayout;
.field private contentRow:Landroid/widget/LinearLayout;
.field private currentStatus:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
.field private currentSummary:Ljava/lang/String;
.field private expanded:Z
.field private fadeMask:Landroid/view/View;
.field private frameAnimation:Landroid/graphics/drawable/AnimationDrawable;
.field private hasVisibleChildren:Z
.field private headerRow:Landroid/widget/LinearLayout;
.field private iconView:Landroid/widget/ImageView;
.field private recyclerWrapper:Landroidx/constraintlayout/widget/ConstraintLayout;
.field private summaryView:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field private titleView:Landroid/widget/TextView;
.field private userOverrodeExpanded:Z


.method public static synthetic $r8$lambda$nGVoGsmUYdL4SpoUYT9x_VK2TQc(com.bytedance.trae.conversation.chat.block.renderer.TodoGroupRenderer$TodoGroupViewManager  float  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->render$lambda$8(Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager; F Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-void 
.end method

.method private final applyCollapsedState(float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus)void
    .registers 9
    # ins_size=3
    iput-object v8, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentRow Landroid/widget/LinearLayout;
    if-nez v0, +003h
    return-void 
    iget-boolean v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->hasVisibleChildren Z
    const/16 v2, 8
    if-nez v1, +006h
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentArea Landroid/widget/FrameLayout;
    if-nez v0, +003h
    return-void 
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Landroidx/recyclerview/widget/RecyclerView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v4
    instance-of v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    if-eqz v5, +005h
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    goto +2h
    const/4 v4, 0
    if-nez v4, +003h
    return-void 
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-eq v8, v5, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v8, v5, +003h
    goto +3h
    move v8, v1
    goto +2h
    const/4 v8, 1
    if-eqz v8, +01dh
    iget-boolean v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-nez v5, +019h
    const/16 v8, 100
    int-to-float v8, v8
    mul-float/2addr v8, v7
    float-to-int v7, v8
    iput v7, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->matchConstraintMaxHeight I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Landroidx/recyclerview/widget/RecyclerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->fadeMask Landroid/view/View;
    if-eqz v7, +040h
    invoke-virtual v7, v1, Landroid/view/View;->setVisibility(I)V
    goto +3bh
    if-eqz v8, +018h
    iget-boolean v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-eqz v7, +014h
    iput v1, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->matchConstraintMaxHeight I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Landroidx/recyclerview/widget/RecyclerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->fadeMask Landroid/view/View;
    if-eqz v7, +028h
    invoke-virtual v7, v2, Landroid/view/View;->setVisibility(I)V
    goto +23h
    if-nez v8, +011h
    iget-boolean v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-nez v7, +00dh
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->fadeMask Landroid/view/View;
    if-eqz v7, +017h
    invoke-virtual v7, v2, Landroid/view/View;->setVisibility(I)V
    goto +12h
    iput v1, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->matchConstraintMaxHeight I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Landroidx/recyclerview/widget/RecyclerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->fadeMask Landroid/view/View;
    if-eqz v7, +005h
    invoke-virtual v7, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v7, +005h
    invoke-virtual v7, v1, Landroidx/recyclerview/widget/RecyclerView;->setNestedScrollingEnabled(Z)V
    return-void 
.end method

.method private final applyStatusIcon(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus  boolean)void
    .registers 5
    # ins_size=4
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->iconView Landroid/widget/ImageView;
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->ordinal()I
    move-result v3
    aget v3, v0, v3
    packed-switch v3, +000001dh
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    if-nez v4, +013h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->status_loading_anim I
    invoke-virtual v2, v3, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->startFrameAnimation()V
    goto +9h
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->stopSpinAnimation()V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->checkmark_circle I
    invoke-virtual v2, v3, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
    packed-switch-payload 1 2 3 4 5 6
.end method

.method private final buildContentArea(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup  float  android.widget.LinearLayout)void
    .registers 14
    # ins_size=5
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    iput-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentRow Landroid/widget/LinearLayout;
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    int-to-float v3, v2
    mul-float/2addr v3, v12
    float-to-int v3, v3
    invoke-virtual v0, v1, v3, v1, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v4, Landroid/view/View;
    invoke-direct v4, v10, Landroid/view/View;-><init>(Landroid/content/Context;)V
    const/16 v5, 105
    const/16 v6, 104
    const/16 v7, 45
    const/16 v8, 106
    invoke-static v7, v8, v5, v6, Landroid/graphics/Color;->argb(I I I I)I
    move-result v5
    invoke-virtual v4, v5, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    invoke-static v3, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v3
    const/high16 v6, 1065353216
    invoke-direct v5, v3, v1, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v3, 4
    int-to-float v3, v3
    mul-float/2addr v3, v12
    float-to-int v3, v3
    iput v3, v5, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v4, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v4, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentRow Landroid/widget/LinearLayout;
    const/4 v5, -1
    if-eqz v4, +013h
    check-cast v0, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v8, 20
    int-to-float v8, v8
    mul-float/2addr v8, v12
    float-to-int v8, v8
    invoke-direct v7, v8, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v0, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-direct v0, v10, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    iput-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentArea Landroid/widget/FrameLayout;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;-><init>()V
    iput-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childAdapter Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v11
    invoke-virtual v0, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->visibleChildren(Ljava/util/List;)Ljava/util/List;
    move-result-object v11
    move-object v0, v11
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v2
    iput-boolean v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->hasVisibleChildren Z
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childAdapter Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
    if-eqz v0, +005h
    invoke-virtual v0, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->submitList(Ljava/util/List;)V
    new-instance v11, Landroidx/recyclerview/widget/RecyclerView;
    invoke-direct v11, v10, Landroidx/recyclerview/widget/RecyclerView;-><init>(Landroid/content/Context;)V
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v0
    invoke-virtual v11, v0, Landroidx/recyclerview/widget/RecyclerView;->setId(I)V
    new-instance v0, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-direct v0, v10, v2, v1, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context; I Z)V
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/LinearLayoutManager;->setStackFromEnd(Z)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v11, v0, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childAdapter Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v11, v0, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    const/4 v0, 0
    invoke-virtual v11, v0, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V
    const/4 v0, 2
    invoke-virtual v11, v0, Landroidx/recyclerview/widget/RecyclerView;->setOverScrollMode(I)V
    invoke-virtual v11, v1, Landroidx/recyclerview/widget/RecyclerView;->setNestedScrollingEnabled(Z)V
    invoke-virtual v11, v1, Landroidx/recyclerview/widget/RecyclerView;->setHasFixedSize(Z)V
    iput-object v11, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v11, Landroidx/constraintlayout/widget/ConstraintLayout;
    invoke-direct v11, v10, Landroidx/constraintlayout/widget/ConstraintLayout;-><init>(Landroid/content/Context;)V
    iput-object v11, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->recyclerWrapper Landroidx/constraintlayout/widget/ConstraintLayout;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    check-cast v0, Landroid/view/View;
    new-instance v2, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    const/4 v4, -2
    invoke-direct v2, v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    iput v1, v2, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop I
    iput v1, v2, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToStart I
    iput v1, v2, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToEnd I
    const/16 v7, 100
    int-to-float v7, v7
    mul-float/2addr v7, v12
    float-to-int v7, v7
    iput v7, v2, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->matchConstraintMaxHeight I
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v0, v2, Landroidx/constraintlayout/widget/ConstraintLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentArea Landroid/widget/FrameLayout;
    if-eqz v11, +010h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->recyclerWrapper Landroidx/constraintlayout/widget/ConstraintLayout;
    check-cast v0, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v2, v5, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v0, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-static v10, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    invoke-static v11, Landroid/graphics/Color;->red(I)I
    move-result v0
    invoke-static v11, Landroid/graphics/Color;->green(I)I
    move-result v2
    invoke-static v11, Landroid/graphics/Color;->blue(I)I
    move-result v7
    invoke-static v1, v0, v2, v7, Landroid/graphics/Color;->argb(I I I I)I
    move-result v0
    new-instance v2, Landroid/view/View;
    invoke-direct v2, v10, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v10, Landroid/graphics/drawable/PaintDrawable;
    invoke-direct v10, Landroid/graphics/drawable/PaintDrawable;-><init>()V
    new-instance v7, Landroid/graphics/drawable/shapes/RectShape;
    invoke-direct v7, Landroid/graphics/drawable/shapes/RectShape;-><init>()V
    check-cast v7, Landroid/graphics/drawable/shapes/Shape;
    invoke-virtual v10, v7, Landroid/graphics/drawable/PaintDrawable;->setShape(Landroid/graphics/drawable/shapes/Shape;)V
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1;
    invoke-direct v7, v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1;-><init>(I I)V
    check-cast v7, Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;
    invoke-virtual v10, v7, Landroid/graphics/drawable/PaintDrawable;->setShaderFactory(Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;)V
    check-cast v10, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v10, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/16 v10, 8
    invoke-virtual v2, v10, Landroid/view/View;->setVisibility(I)V
    iput-object v2, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->fadeMask Landroid/view/View;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentArea Landroid/widget/FrameLayout;
    if-eqz v10, +011h
    new-instance v11, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v0, 24
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v12, v0
    invoke-direct v11, v5, v12, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v2, v11, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentRow Landroid/widget/LinearLayout;
    if-eqz v10, +015h
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentArea Landroid/widget/FrameLayout;
    check-cast v11, Landroid/view/View;
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v12, v1, v4, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    invoke-virtual v12, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v11, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentRow Landroid/widget/LinearLayout;
    if-eqz v10, +00eh
    check-cast v10, Landroid/view/View;
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v5, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v10, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final render$lambda$8(com.bytedance.trae.conversation.chat.block.renderer.TodoGroupRenderer$TodoGroupViewManager  float  android.view.View)void
    .registers 6
    # ins_size=3
    const/4 v5, 1
    iput-boolean v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->userOverrodeExpanded Z
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    xor-int/2addr v0, v5
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->titleView Landroid/widget/TextView;
    const/4 v2, 0
    if-eqz v1, +00ch
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_chevron_fold I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual v1, v2, v2, v0, v2, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->applyCollapsedState(F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v4, +021h
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-nez v0, +018h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-eq v0, v1, +012h
    iget-object v3, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentSummary Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00ah
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move v5, v2
    if-eqz v5, +004h
    const/16 v2, 8
    invoke-virtual v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setVisibility(I)V
    return-void 
.end method

.method private final startFrameAnimation()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->iconView Landroid/widget/ImageView;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    instance-of v1, v0, Landroid/graphics/drawable/AnimationDrawable;
    if-eqz v1, +005h
    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/graphics/drawable/AnimationDrawable;->isRunning()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->frameAnimation Landroid/graphics/drawable/AnimationDrawable;
    invoke-virtual v0, Landroid/graphics/drawable/AnimationDrawable;->start()V
    return-void 
.end method

.method private final stopSpinAnimation()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->frameAnimation Landroid/graphics/drawable/AnimationDrawable;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/graphics/drawable/AnimationDrawable;->stop()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->frameAnimation Landroid/graphics/drawable/AnimationDrawable;
    return-void 
.end method

.method public final getChildAdapter()com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childAdapter Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
    return-object v0
.end method

.method public final getChildRecyclerView()androidx.recyclerview.widget.RecyclerView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    return-object v0
.end method

.method public final getContentArea()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentArea Landroid/widget/FrameLayout;
    return-object v0
.end method

.method public final getContentRow()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentRow Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public final getCurrentStatus()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v0
.end method

.method public final getCurrentSummary()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentSummary Ljava/lang/String;
    return-object v0
.end method

.method public final getExpanded()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    return v0
.end method

.method public final getFadeMask()android.view.View
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->fadeMask Landroid/view/View;
    return-object v0
.end method

.method public final getFrameAnimation()android.graphics.drawable.AnimationDrawable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->frameAnimation Landroid/graphics/drawable/AnimationDrawable;
    return-object v0
.end method

.method public final getHasVisibleChildren()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->hasVisibleChildren Z
    return v0
.end method

.method public final getHeaderRow()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public final getIconView()android.widget.ImageView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->iconView Landroid/widget/ImageView;
    return-object v0
.end method

.method public final getRecyclerWrapper()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->recyclerWrapper Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method

.method public final getSummaryView()com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    return-object v0
.end method

.method public final getTitleView()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->titleView Landroid/widget/TextView;
    return-object v0
.end method

.method public final getUserOverrodeExpanded()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->userOverrodeExpanded Z
    return v0
.end method

.method public final render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup)android.view.View
    .registers 29
    # ins_size=3
    move-object/from16 v0, v26
    move-object/from16 v7, v27
    move-object/from16 v8, v28
    const-string v1, "context"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "block"
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v27, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v9, v1, Landroid/util/DisplayMetrics;->density F
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
    float-to-int v2, v2
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getSummary()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentSummary Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->shouldAutoExpand(Ljava/util/List;)Z
    move-result v1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v14, 0
    invoke-virtual v1, v14, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 16
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v1, 20
    int-to-float v1, v1
    mul-float/2addr v1, v9
    float-to-int v15, v1
    new-instance v1, Landroid/widget/ImageView;
    invoke-direct v1, v7, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v3, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v1, v3, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->iconView Landroid/widget/ImageView;
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v1
    invoke-direct v0, v7, v1, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->applyStatusIcon(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    if-eqz v1, +010h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->iconView Landroid/widget/ImageView;
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v15, v15, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_chevron_fold I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getTitle()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +013h
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getSummary()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_todo_in_progress I
    invoke-virtual v7, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v4, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v7, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v4, v3, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v6, 2
    const/high16 v5, 1097859072
    invoke-virtual v4, v6, v5, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v3, 24
    int-to-float v3, v3
    mul-float/2addr v3, v9
    float-to-int v3, v3
    invoke-static v4, v3, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v4, v11, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v3, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v4, v3, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v4, v2, Landroid/widget/TextView;->setCompoundDrawablePadding(I)V
    invoke-virtual v4, v14, v14, v1, v14, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->titleView Landroid/widget/TextView;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    if-eqz v1, +013h
    check-cast v4, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v13, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v0, v7, v8, v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->buildContentArea(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup; F Landroid/widget/LinearLayout;)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v3, 0
    const/16 v16, 0
    const/16 v17, 6
    const/16 v18, 0
    move-object v1, v4
    move-object/from16 v2, v27
    move-object v11, v4
    move/from16 v4, v16
    move v14, v5
    move/from16 v5, v17
    move v12, v6
    move-object/from16 v6, v18
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextColor(I)V
    invoke-virtual v11, v12, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextSize(I F)V
    move-object v4, v11
    check-cast v4, Landroid/widget/TextView;
    invoke-static v4, v15, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const/16 v1, 8
    invoke-virtual v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setVisibility(I)V
    iput-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getSummary()Ljava/lang/String;
    move-result-object v21
    move-object/from16 v2, v21
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    if-nez v3, +03ch
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v3, +005h
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v2, +012h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-nez v3, +00bh
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v3, v4, +003h
    const/4 v1, 0
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setVisibility(I)V
    sget-object v19, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v2, v3, +005h
    const/16 v22, 1
    goto +3h
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 8
    const/16 v25, 0
    move-object/from16 v20, v1
    invoke-static/range v19 ... v25, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    invoke-direct v2, v3, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v3, v12
    mul-float/2addr v3, v9
    float-to-int v3, v3
    iput v3, v2, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v1
    invoke-direct v0, v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->applyCollapsedState(F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    if-eqz v1, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0;
    invoke-direct v2, v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager; F)V
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v10, Landroid/view/View;
    return-object v10
.end method

.method public final setChildAdapter(com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childAdapter Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
    return-void 
.end method

.method public final setChildRecyclerView(androidx.recyclerview.widget.RecyclerView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    return-void 
.end method

.method public final setContentArea(android.widget.FrameLayout)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentArea Landroid/widget/FrameLayout;
    return-void 
.end method

.method public final setContentRow(android.widget.LinearLayout)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->contentRow Landroid/widget/LinearLayout;
    return-void 
.end method

.method public final setCurrentStatus(com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-void 
.end method

.method public final setCurrentSummary(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentSummary Ljava/lang/String;
    return-void 
.end method

.method public final setExpanded(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    return-void 
.end method

.method public final setFadeMask(android.view.View)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->fadeMask Landroid/view/View;
    return-void 
.end method

.method public final setFrameAnimation(android.graphics.drawable.AnimationDrawable)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->frameAnimation Landroid/graphics/drawable/AnimationDrawable;
    return-void 
.end method

.method public final setHasVisibleChildren(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->hasVisibleChildren Z
    return-void 
.end method

.method public final setHeaderRow(android.widget.LinearLayout)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->headerRow Landroid/widget/LinearLayout;
    return-void 
.end method

.method public final setIconView(android.widget.ImageView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->iconView Landroid/widget/ImageView;
    return-void 
.end method

.method public final setRecyclerWrapper(androidx.constraintlayout.widget.ConstraintLayout)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->recyclerWrapper Landroidx/constraintlayout/widget/ConstraintLayout;
    return-void 
.end method

.method public final setSummaryView(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    return-void 
.end method

.method public final setTitleView(android.widget.TextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->titleView Landroid/widget/TextView;
    return-void 
.end method

.method public final setUserOverrodeExpanded(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->userOverrodeExpanded Z
    return-void 
.end method

.method public final update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup)void
    .registers 15
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v2
    iput-object v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentStatus Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getSummary()Ljava/lang/String;
    move-result-object v2
    iput-object v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->currentSummary Ljava/lang/String;
    iget-boolean v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->userOverrodeExpanded Z
    const/4 v3, 1
    if-nez v2, +010h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->shouldAutoExpand(Ljava/util/List;)Z
    move-result v2
    if-eqz v2, +004h
    iput-boolean v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v2
    invoke-direct v12, v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->applyStatusIcon(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z)V
    iget-object v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->titleView Landroid/widget/TextView;
    if-eqz v2, +023h
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getTitle()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +005h
    check-cast v4, Ljava/lang/CharSequence;
    goto +16h
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getSummary()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +003h
    goto -9h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_todo_in_progress I
    invoke-virtual v0, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v4, "getString(...)"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v2, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getSummary()Ljava/lang/String;
    move-result-object v7
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v3
    if-nez v4, +01bh
    iget-object v6, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v6, +022h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v4
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v4, v8, +004h
    move v8, v3
    goto +2h
    move v8, v2
    const/4 v9, 0
    const/16 v10, 8
    const/4 v11, 0
    invoke-static/range v5 ... v11, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    goto +ch
    iget-object v4, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v4, +009h
    const-string v5, ""
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->summaryView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v4, +023h
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v3
    if-nez v0, +010h
    iget-boolean v0, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-nez v0, +00ch
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v0
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v0, v5, +004h
    move v0, v2
    goto +3h
    const/16 v0, 8
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setVisibility(I)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->visibleChildren(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/2addr v3, v4
    iput-boolean v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->hasVisibleChildren Z
    iget-object v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->childAdapter Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
    if-eqz v3, +005h
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->submitList(Ljava/util/List;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->titleView Landroid/widget/TextView;
    if-eqz v0, +00eh
    iget-boolean v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->expanded Z
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_chevron_fold I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual v0, v2, v2, v3, v2, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v14
    invoke-direct v12, v1, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->applyCollapsedState(F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    invoke-virtual v13, Landroid/view/View;->requestLayout()V
    sget v14, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    invoke-virtual v13, v14, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v13
    invoke-static v13, v2, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v14
    if-eqz v14, +007h
    check-cast v13, Lkotlin/jvm/functions/Function0;
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method
