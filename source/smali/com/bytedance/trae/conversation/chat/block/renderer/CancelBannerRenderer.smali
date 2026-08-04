# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/CancelBannerRenderer;
.super Ljava/lang/Object;
.source "CancelBannerRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$CancelBanner)android.view.View
    .registers 7
    # ins_size=3
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->density F
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -1
    const/4 v3, -2
    invoke-direct v1, v2, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v2, 8
    int-to-float v2, v2
    mul-float/2addr v2, v6
    float-to-int v2, v2
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    const/4 v2, 4
    int-to-float v2, v2
    mul-float/2addr v2, v6
    float-to-int v6, v2
    iput v6, v1, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_stream_canceled_title I
    invoke-virtual v5, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    const-string v1, "getString(...)"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_stream_canceled I
    invoke-virtual v5, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->TIPS Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->info_filled_blue I
    invoke-virtual v0, v6, v5, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->configure(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style; I)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/CancelBannerRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$CancelBanner)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/CancelBannerRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;)V
    return-void 
.end method
