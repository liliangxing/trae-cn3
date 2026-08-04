# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryLoadingRenderer;
.super Ljava/lang/Object;
.source "VoiceSummaryLoadingRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$VoiceSummaryLoading)android.view.View
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v9
    iget v9, v9, Landroid/util/DisplayMetrics;->density F
    new-instance v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_summary_loading I
    invoke-virtual v8, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v8, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v6, v8, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextColor(I)V
    const/4 v8, 2
    const/high16 v0, 1098907648
    invoke-virtual v6, v8, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextSize(I F)V
    const/4 v8, 0
    invoke-virtual v6, v8, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setIncludeFontPadding(Z)V
    move-object v8, v6
    check-cast v8, Landroid/widget/TextView;
    const/16 v0, 22
    int-to-float v0, v0
    mul-float/2addr v0, v9
    float-to-int v0, v0
    invoke-static v8, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v0, -1
    const/4 v1, -2
    invoke-direct v8, v0, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v0, 8
    int-to-float v0, v0
    mul-float/2addr v0, v9
    float-to-int v9, v0
    iput v9, v8, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v9, v8, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v8, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-wide/16 v8, 0
    invoke-virtual v6, v8, v9, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerTimeoutMs(J)V
    const/4 v8, 1
    invoke-virtual v6, v8, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    check-cast v6, Landroid/view/View;
    return-object v6
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryLoadingRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$VoiceSummaryLoading)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryLoadingRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;)V
    return-void 
.end method
