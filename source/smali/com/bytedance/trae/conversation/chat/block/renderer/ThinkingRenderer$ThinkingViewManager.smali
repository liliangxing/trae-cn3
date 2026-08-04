# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;
.super Ljava/lang/Object;
.source "ThinkingRenderer.kt"

.field private contentView:Landroid/widget/TextView;
.field private expanded:Z
.field private titleView:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;


.method public static synthetic $r8$lambda$3_kK563bmtWTJsMG4gqX6z6AhFA(com.bytedance.trae.conversation.chat.block.renderer.ThinkingRenderer$ThinkingViewManager  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->render$lambda$5(Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final render$lambda$5(com.bytedance.trae.conversation.chat.block.renderer.ThinkingRenderer$ThinkingViewManager  android.view.View)void
    .registers 4
    # ins_size=2
    iget-boolean v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->expanded Z
    xor-int/lit8 v3, v3, 1
    iput-boolean v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->expanded Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->contentView Landroid/widget/TextView;
    const/4 v1, 0
    if-eqz v0, +00bh
    if-eqz v3, +004h
    move v3, v1
    goto +3h
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v3, +00eh
    iget-boolean v2, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->expanded Z
    if-eqz v2, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->chevron_fold I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->chevron_right I
    invoke-virtual v3, v1, v1, v2, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    return-void 
.end method

.method public final getContentView()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->contentView Landroid/widget/TextView;
    return-object v0
.end method

.method public final getExpanded()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->expanded Z
    return v0
.end method

.method public final getTitleView()com.bytedance.trae.conversation.widget.ShimmerTextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    return-object v0
.end method

.method public final render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Thinking)android.view.View
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v7, v19
    const-string v1, "context"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "block"
    move-object/from16 v8, v20
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v19, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
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
    float-to-int v14, v2
    iput v14, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v14, v1, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v15, Landroid/widget/LinearLayout;
    invoke-direct v15, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 0
    invoke-virtual v15, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v1, 16
    invoke-virtual v15, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    move-object v1, v15
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v5, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    const/4 v3, 0
    const/4 v4, 0
    const/16 v16, 6
    const/16 v17, 0
    move-object v1, v5
    move-object/from16 v2, v19
    move-object v12, v5
    move/from16 v5, v16
    move v13, v6
    move-object/from16 v6, v17
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->isThinking()Z
    move-result v1
    if-eqz v1, +00bh
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_thinking_collapsed I
    invoke-virtual v7, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    goto +9h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_thinking_title_complete I
    invoke-virtual v7, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextColor(I)V
    const/high16 v1, 1098907648
    const/4 v2, 2
    invoke-virtual v12, v2, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextSize(I F)V
    move-object v5, v12
    check-cast v5, Landroid/widget/TextView;
    const/16 v1, 22
    int-to-float v1, v1
    mul-float/2addr v1, v9
    float-to-int v1, v1
    invoke-static v5, v1, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const v1, -1130650141
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setLetterSpacing(F)V
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setMaxLines(I)V
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v12, v14, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setCompoundDrawablePadding(I)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->chevron_right I
    invoke-virtual v12, v13, v13, v1, v13, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    iput-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    move-object v5, v12
    check-cast v5, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v3, 1065353216
    const/4 v4, -2
    invoke-direct v1, v13, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v5, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getReasoningContent()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v7, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v1, v3, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v3, 1095761920
    invoke-virtual v1, v2, v3, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v2, 8
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v1, v13, v14, v13, v13, Landroid/widget/TextView;->setPadding(I I I I)V
    const/16 v2, 20
    invoke-virtual v1, v2, Landroid/widget/TextView;->setMaxLines(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->contentView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;)V
    invoke-virtual v15, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v1, +009h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->isThinking()Z
    move-result v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    check-cast v10, Landroid/view/View;
    return-object v10
.end method

.method public final setContentView(android.widget.TextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->contentView Landroid/widget/TextView;
    return-void 
.end method

.method public final setExpanded(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->expanded Z
    return-void 
.end method

.method public final setTitleView(com.bytedance.trae.conversation.widget.ShimmerTextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    return-void 
.end method

.method public final update(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Thinking)void
    .registers 4
    # ins_size=2
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->contentView Landroid/widget/TextView;
    if-eqz v0, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getReasoningContent()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->isThinking()Z
    move-result v3
    const/4 v0, 0
    if-eqz v3, +022h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v3, +015h
    if-eqz v3, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->getContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v1, +008h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_thinking_collapsed I
    invoke-virtual v1, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v3, +026h
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    goto +20h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v3, +015h
    if-eqz v3, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->getContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v1, +008h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_thinking_title_complete I
    invoke-virtual v1, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v3, +006h
    const/4 v0, 0
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    return-void 
.end method
