# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;
.super Landroid/widget/LinearLayout;
.source "CollapsibleToolSegmentView.kt"

.field private final contentContainer:Landroid/widget/LinearLayout;
.field private final density:F
.field private expanded:Z
.field private final headerRow:Landroid/widget/LinearLayout;
.field private onExpandedStateChanged:Lkotlin/jvm/functions/Function1;
.field private final titleView:Landroid/widget/TextView;
.field private final unfoldIcon:Landroid/widget/ImageView;


.method public static synthetic $r8$lambda$8KvMk5WU_RX8UYJkpIhAWFBB_aU(com.bytedance.trae.conversation.chat.detail.CollapsibleToolSegmentView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->_init_$lambda$6(Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 13
    # ins_size=2
    const-string v0, "context"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v12, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    iput v0, v11, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->density F
    const/4 v1, 1
    invoke-virtual v11, v1, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->setOrientation(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 8
    int-to-float v6, v5
    mul-float v7, v6, v0
    float-to-int v7, v7
    iput v7, v2, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v7, 0
    invoke-virtual v2, v7, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v8, 16
    invoke-virtual v2, v8, Landroid/widget/LinearLayout;->setGravity(I)V
    mul-float/2addr v6, v0
    float-to-int v6, v6
    invoke-virtual v2, v7, v6, v7, v6, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    iput-object v2, v11, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->headerRow Landroid/widget/LinearLayout;
    move-object v6, v2
    check-cast v6, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v6, v9, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v6, Landroid/widget/TextView;
    invoke-direct v6, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v12, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v6, v9, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v9, 2
    const/high16 v10, 1095761920
    invoke-virtual v6, v9, v10, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v6, v1, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v9, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v6, v9, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    iput-object v6, v11, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->titleView Landroid/widget/TextView;
    check-cast v6, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v10, 1065353216
    invoke-direct v9, v7, v4, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v6, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v6, v8
    mul-float/2addr v6, v0
    float-to-int v6, v6
    new-instance v7, Landroid/widget/ImageView;
    invoke-direct v7, v12, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual v7, v8, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v8, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v7, v8, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    iput-object v7, v11, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->unfoldIcon Landroid/widget/ImageView;
    check-cast v7, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v6, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v6, 4
    int-to-float v6, v6
    mul-float/2addr v6, v0
    float-to-int v0, v6
    invoke-virtual v8, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v7, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v0, v5, Landroid/widget/LinearLayout;->setVisibility(I)V
    iput-object v0, v11, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->contentContainer Landroid/widget/LinearLayout;
    check-cast v0, Landroid/view/View;
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v12, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v0, v12, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v12, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView$$ExternalSyntheticLambda0;
    invoke-direct v12, v11, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;)V
    invoke-virtual v2, v12, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final _init_$lambda$6(com.bytedance.trae.conversation.chat.detail.CollapsibleToolSegmentView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->toggle()V
    return-void 
.end method

.method private final applyExpandedState()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->contentContainer Landroid/widget/LinearLayout;
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->expanded Z
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->unfoldIcon Landroid/widget/ImageView;
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->expanded Z
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->chevron_fold I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->chevron_unfold I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method public static synthetic bind$default(com.bytedance.trae.conversation.chat.detail.CollapsibleToolSegmentView  com.bytedance.trae.conversation.chat.detail.DetailSegment$ToolSegment  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  boolean  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    const/4 v4, 0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->bind(Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Z Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final renderChildren(java.util.List  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 16
    # ins_size=3
    invoke-interface v14, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +100h
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    const-string v2, "getContext(...)"
    if-eqz v1, +052h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getPlanItemId()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getReasoningContent()Ljava/lang/String;
    move-result-object v10
    const/16 v11, 62
    const/4 v12, 0
    move-object v3, v1
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    if-nez v0, +010h
    new-instance v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 31
    const/4 v12, 0
    move-object v5, v0
    invoke-direct/range v5 ... v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedToolCallResult; Lcom/google/gson/JsonObject; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v3, v4, v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createThinkingCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->bind(Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->contentContainer Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -61h
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v1, +05ch
    if-eqz v15, +019h
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v9
    const/4 v10, 0
    const/16 v11, 95
    const/4 v12, 0
    move-object v3, v15
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->copy$default(Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v1
    if-nez v1, +018h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v9
    const/4 v10, 0
    const/16 v11, 95
    const/4 v12, 0
    move-object v3, v1
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    invoke-virtual v3, v4, v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createDetailCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->bind(Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->contentContainer Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto/16 -0beh
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v1, +020h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -0d2h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-direct v13, v1, v15, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->renderChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    goto -13h
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v1, -0e4h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -0f4h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-direct v13, v1, v15, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->renderChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    goto -13h
    return-void 
.end method

.method static synthetic renderChildren$default(com.bytedance.trae.conversation.chat.detail.CollapsibleToolSegmentView  java.util.List  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->renderChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    return-void 
.end method

.method private final toggle()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->expanded Z
    xor-int/lit8 v0, v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->expanded Z
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->applyExpandedState()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->onExpandedStateChanged Lkotlin/jvm/functions/Function1;
    if-eqz v0, +00bh
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->expanded Z
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public static synthetic update$default(com.bytedance.trae.conversation.chat.detail.CollapsibleToolSegmentView  com.bytedance.trae.conversation.chat.detail.DetailSegment$ToolSegment  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->update(Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.chat.detail.DetailSegment$ToolSegment  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  boolean  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, segment
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->expanded Z
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->onExpandedStateChanged Lkotlin/jvm/functions/Function1;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->titleView Landroid/widget/TextView;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;->getTitle()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v4, Landroid/widget/LinearLayout;->removeAllViews()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;->getChildren()Ljava/util/List;
    move-result-object v2
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->renderChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->applyExpandedState()V
    return-void 
.end method

.method public final update(com.bytedance.trae.conversation.chat.detail.DetailSegment$ToolSegment  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, segment
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->titleView Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;->getTitle()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;->getChildren()Ljava/util/List;
    move-result-object v3
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;->renderChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    return-void 
.end method
