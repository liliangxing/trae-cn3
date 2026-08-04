# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
.super Landroid/widget/LinearLayout;
.source "AgentProcessSectionView.kt"

.field private final arrowView:Landroid/widget/ImageView;
.field private final contentContainer:Landroid/widget/LinearLayout;
.field private final durationView:Landroid/widget/TextView;
.field private final factory:Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
.field private final headerView:Landroid/widget/LinearLayout;
.field private isCollapsed:Z
.field private lastProcessBlocks:Ljava/util/List;
.field private pendingBlocks:Ljava/util/List;
.field private state:Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;


.method public static synthetic $r8$lambda$JH1htu_zYfiwXQ6xbNP2eXurcvo(com.bytedance.trae.conversation.chat.section.AgentProcessSectionView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->_init_$lambda$10(Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView; Landroid/view/View;)V
    return-void 
.end method

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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 16
    # ins_size=4
    const-string v0, "context"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v12, v13, v14, v15, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    const/4 v14, 1
    iput-boolean v14, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->isCollapsed Z
    sget-object v15, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    iput-object v15, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->state Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    sget-object v15, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;->getInstance()Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    move-result-object v15
    iput-object v15, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v15
    iput-object v15, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-virtual v12, v14, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setOrientation(I)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getResources()Landroid/content/res/Resources;
    move-result-object v15
    invoke-virtual v15, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v15
    iget v15, v15, Landroid/util/DisplayMetrics;->density F
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v13, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/4 v3, 4
    int-to-float v3, v3
    mul-float/2addr v3, v15
    float-to-int v3, v3
    invoke-virtual v0, v1, v3, v1, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    iput-object v0, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->headerView Landroid/widget/LinearLayout;
    move-object v4, v0
    check-cast v4, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -1
    const/4 v7, -2
    invoke-direct v5, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v4, v5, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v13, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    const/high16 v5, 1056964608
    mul-float/2addr v5, v15
    float-to-int v5, v5
    invoke-static v14, v5, Ljava/lang/Math;->max(I I)I
    move-result v5
    new-instance v8, Landroid/view/View;
    invoke-direct v8, v13, Landroid/view/View;-><init>(Landroid/content/Context;)V
    invoke-virtual v8, v4, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v10, 1065353216
    invoke-direct v9, v1, v5, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    iput v2, v9, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v8, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v8, Landroid/widget/TextView;
    invoke-direct v8, v13, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_chat_working I
    invoke-virtual v13, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v8, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v13, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v8, v9, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v9, 2
    const/high16 v11, 1097859072
    invoke-virtual v8, v9, v11, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v9, 17
    invoke-virtual v8, v9, Landroid/widget/TextView;->setGravity(I)V
    iput-object v8, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->durationView Landroid/widget/TextView;
    check-cast v8, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v7, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v9, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v8, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v8, v2
    mul-float/2addr v8, v15
    float-to-int v15, v8
    new-instance v8, Landroid/widget/ImageView;
    invoke-direct v8, v13, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_chevron_fold I
    invoke-virtual v8, v9, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v9, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v8, v9, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    iput-object v8, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->arrowView Landroid/widget/ImageView;
    check-cast v8, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v15, v15, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v9, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    iput v2, v9, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v8, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v15, Landroid/view/View;
    invoke-direct v15, v13, Landroid/view/View;-><init>(Landroid/content/Context;)V
    invoke-virtual v15, v4, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v1, v5, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    invoke-virtual v4, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    iput v2, v4, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v15, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v15, Landroid/widget/LinearLayout;
    invoke-direct v15, v13, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v15, v14, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v15, v1, v3, v1, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    iput-object v15, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    check-cast v15, Landroid/view/View;
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v13, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v15, v13, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v13, 8
    invoke-virtual v0, v13, Landroid/widget/LinearLayout;->setVisibility(I)V
    new-instance v13, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$$ExternalSyntheticLambda0;
    invoke-direct v13, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;)V
    invoke-virtual v0, v13, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private static final _init_$lambda$10(com.bytedance.trae.conversation.chat.section.AgentProcessSectionView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->toggleCollapsed()V
    return-void 
.end method

.method private final attachBlockTags(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getTag(I)Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v3, v0, v1, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getTag(I)Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v3, v0, v1, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View;)V
    return-void 
.end method

.method private final flushPendingBlocksIfNeeded()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->pendingBlocks Ljava/util/List;
    if-nez v0, +003h
    return-void 
    const/4 v1, 0
    iput-object v1, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->pendingBlocks Ljava/util/List;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->renderBlocks(Ljava/util/List;)V
    return-void 
.end method

.method private final notifyPureShowWidgetInlineViewCreated(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getTag(I)Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 1
    invoke-static v0, v1, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v1
    if-eqz v1, +005h
    check-cast v0, Lkotlin/jvm/functions/Function1;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final notifyPureShowWidgetInlineViewCreated(android.view.View  kotlin.jvm.functions.Function1)void
    .registers 7
    # ins_size=3
    instance-of v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    if-eqz v0, +006h
    invoke-interface v6, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    instance-of v0, v5, Landroid/view/ViewGroup;
    if-eqz v0, +01ah
    check-cast v5, Landroid/view/ViewGroup;
    invoke-virtual v5, Landroid/view/ViewGroup;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +011h
    invoke-virtual v5, v1, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    const-string v3, "getChildAt(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v2, v6, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    add-int/lit8 v1, v1, 1
    goto -10h
    return-void 
.end method

.method private final prefixTypesMatch(java.util.List  java.util.List)boolean
    .registers 8
    # ins_size=3
    move-object v0, v6
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->size()I
    move-result v0
    const/4 v1, 0
    move v2, v1
    if-ge v2, v0, +01fh
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v3
    if-ge v2, v3, +018h
    invoke-interface v6, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    invoke-interface v7, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    if-eq v3, v4, +003h
    goto +4h
    add-int/lit8 v2, v2, 1
    goto -1dh
    return v1
    const/4 v6, 1
    return v6
.end method

.method private final releasePureShowWidgetInlineViews(android.view.View)void
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    if-eqz v0, +008h
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->release()V
    return-void 
    instance-of v0, v5, Landroid/view/ViewGroup;
    if-eqz v0, +01ah
    check-cast v5, Landroid/view/ViewGroup;
    invoke-virtual v5, Landroid/view/ViewGroup;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +011h
    invoke-virtual v5, v1, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    const-string v3, "getChildAt(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    add-int/lit8 v1, v1, 1
    goto -10h
    return-void 
.end method

.method private final renderBlocks(java.util.List)void
    .registers 11
    # ins_size=2
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    const/4 v2, 0
    const/4 v3, 1
    if-lt v0, v1, +017h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v3
    if-eqz v0, +00ch
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-direct v9, v0, v10, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->prefixTypesMatch(Ljava/util/List; Ljava/util/List;)Z
    move-result v0
    if-eqz v0, +004h
    move v0, v3
    goto +2h
    move v0, v2
    const-string v1, "getContext(...)"
    if-nez v0, +03eh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    check-cast v0, Landroid/view/View;
    invoke-direct v9, v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +0e9h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-virtual v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v5
    if-nez v5, +003h
    goto -14h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getContext()Landroid/content/Context;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, v6, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Landroid/view/View;
    move-result-object v4
    invoke-direct v9, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->attachBlockTags(Landroid/view/View;)V
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -28h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->size()I
    move-result v0
    move v4, v2
    if-ge v4, v0, +084h
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v5
    if-ge v4, v5, +07ch
    invoke-interface v10, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    iget-object v6, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-interface v6, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +068h
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v5
    if-eqz v5, +02eh
    invoke-interface v10, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    iget-object v7, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-interface v7, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v7
    if-ne v6, v7, +01ah
    iget-object v6, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-interface v10, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v6
    if-eqz v6, +03eh
    invoke-interface v10, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-interface v6, v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    goto +33h
    if-eqz v5, +032h
    iget-object v6, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-interface v10, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v6
    if-nez v6, +003h
    goto +22h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getContext()Landroid/content/Context;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v10, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-interface v6, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Landroid/view/View;
    move-result-object v6
    invoke-direct v9, v6, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->attachBlockTags(Landroid/view/View;)V
    invoke-direct v9, v5, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->removeViewAt(I)V
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v6, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; I)V
    add-int/lit8 v4, v4, 1
    goto/16 -082h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v4
    if-ge v0, v4, +02dh
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-interface v10, v0, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v5
    if-nez v5, +003h
    goto +1ah
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getContext()Landroid/content/Context;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v10, v0, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-interface v5, v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Landroid/view/View;
    move-result-object v5
    invoke-direct v9, v5, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->attachBlockTags(Landroid/view/View;)V
    iget-object v6, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v6, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    add-int/lit8 v0, v0, 1
    goto -2ch
    check-cast v10, Ljava/lang/Iterable;
    invoke-static v10, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->state Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    if-ne v10, v0, +010h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-interface v10, Ljava/util/List;->isEmpty()Z
    move-result v10
    if-eqz v10, +008h
    const/16 v10, 8
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setVisibility(I)V
    goto +15h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->state Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    if-ne v10, v0, +010h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    xor-int/2addr v10, v3
    if-eqz v10, +005h
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setVisibility(I)V
    return-void 
.end method

.method public static synthetic setState$default(com.bytedance.trae.conversation.chat.section.AgentProcessSectionView  com.bytedance.trae.conversation.chat.section.AgentProcessSectionView$ProcessState  long  boolean  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    const-wide/16 v2, 0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v4, 1
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setState(Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState; J Z)V
    return-void 
.end method

.method private final toggleCollapsed()void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->isCollapsed Z
    xor-int/lit8 v0, v0, 1
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setCollapsed(Z)V
    return-void 
.end method

.method public static synthetic updateBlocks$default(com.bytedance.trae.conversation.chat.section.AgentProcessSectionView  java.util.List  com.bytedance.trae.conversation.chat.section.AgentProcessSectionView$ProcessState  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->updateBlocks(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;)V
    return-void 
.end method

.method public final reset()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    check-cast v0, Landroid/view/View;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->pendingBlocks Ljava/util/List;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->state Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->isCollapsed Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->headerView Landroid/widget/LinearLayout;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setVisibility(I)V
    return-void 
.end method

.method public final setCollapsed(boolean)void
    .registers 4
    # ins_size=2
    iput-boolean v3, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->isCollapsed Z
    if-nez v3, +005h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->flushPendingBlocksIfNeeded()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    if-eqz v3, +005h
    const/16 v1, 8
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->arrowView Landroid/widget/ImageView;
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_chevron_fold I
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method public final setDuration(long)void
    .registers 13
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v11, v0
    const/16 v0, 60
    int-to-long v0, v0
    div-long v2, v11, v0
    rem-long v0, v11, v0
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->durationView Landroid/widget/TextView;
    const-wide/16 v5, 0
    cmp-long v7, v2, v5
    const/4 v8, 1
    const/4 v9, 0
    if-lez v7, +01eh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getContext()Landroid/content/Context;
    move-result-object v11
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_worked_minutes I
    const/4 v5, 2
    new-array v5, v5, [Ljava/lang/Object;
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    aput-object v2, v5, v9
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    aput-object v0, v5, v8
    invoke-virtual v11, v12, v5, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    goto +26h
    cmp-long v0, v11, v5
    if-lez v0, +017h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_worked_seconds I
    new-array v2, v8, [Ljava/lang/Object;
    invoke-static v11, v12, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v2, v9
    invoke-virtual v0, v1, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    goto +dh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->getContext()Landroid/content/Context;
    move-result-object v11
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_working I
    invoke-virtual v11, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v4, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final setState(com.bytedance.trae.conversation.chat.section.AgentProcessSectionView$ProcessState  long  boolean)void
    .registers 9
    # ins_size=5
    const-string v0, "newState"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->state Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->ordinal()I
    move-result v5
    aget v5, v0, v5
    const/4 v0, 1
    const/16 v1, 8
    const/4 v2, 0
    if-eq v5, v0, +04ch
    const/4 v3, 2
    if-ne v5, v3, +043h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->pendingBlocks Ljava/util/List;
    if-nez v5, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->lastProcessBlocks Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +009h
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->requestLayout()V
    return-void 
    invoke-virtual v4, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->headerView Landroid/widget/LinearLayout;
    invoke-virtual v5, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v4, v6, v7, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setDuration(J)V
    if-eqz v8, +011h
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->isCollapsed Z
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->arrowView Landroid/widget/ImageView;
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setImageResource(I)V
    goto +26h
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->flushPendingBlocksIfNeeded()V
    iput-boolean v2, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->isCollapsed Z
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->arrowView Landroid/widget/ImageView;
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_chevron_fold I
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setImageResource(I)V
    goto +14h
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->headerView Landroid/widget/LinearLayout;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v4, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setVisibility(I)V
    return-void 
.end method

.method public final updateBlocks(java.util.List  com.bytedance.trae.conversation.chat.section.AgentProcessSectionView$ProcessState)void
    .registers 4
    # ins_size=3
    const-string v0, "blocks"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->state Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->COMPLETED Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    if-ne v3, v0, +009h
    iget-boolean v3, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->isCollapsed Z
    if-eqz v3, +005h
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->pendingBlocks Ljava/util/List;
    return-void 
    const/4 v3, 0
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->pendingBlocks Ljava/util/List;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->renderBlocks(Ljava/util/List;)V
    return-void 
.end method
