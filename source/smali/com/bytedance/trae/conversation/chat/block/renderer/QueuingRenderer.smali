# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;
.super Ljava/lang/Object;
.source "QueuingRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildDisplayText(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)java.lang.String
    .registers 6
    # ins_size=3
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getMessage()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 1
    if-eqz v0, +011h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v1
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-object v0
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_queue_alert_body I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getPosition()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/4 v2, 0
    aput-object v5, v1, v2
    invoke-virtual v4, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v5, "getString(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final buildTitleText(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)java.lang.String
    .registers 4
    # ins_size=3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getNoticeTitle()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +011h
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_queue_alert_title I
    invoke-virtual v2, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v2, "getString(...)"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)android.view.View
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[QueuingRenderer] render: position="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getPosition()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentBlock"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const/4 v1, 4
    const/16 v2, 8
    const/4 v3, -2
    const/4 v4, -1
    if-nez v0, +02bh
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-direct v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;-><init>(Landroid/content/Context;)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    iput v2, v8, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v0, v1
    iput v0, v8, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v5, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->render(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)V
    check-cast v5, Landroid/view/View;
    return-object v5
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
    invoke-direct v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;-><init>(Landroid/content/Context;)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    iput v2, v6, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v0, v1
    iput v0, v6, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;->buildTitleText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;->buildDisplayText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->TIPS Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->info_filled_blue I
    invoke-virtual v5, v0, v8, v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->configure(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style; I)V
    check-cast v5, Landroid/view/View;
    return-object v5
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[QueuingRenderer] update: position="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getPosition()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentBlock"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +02dh
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
    if-eqz v0, +005h
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
    if-nez v1, +003h
    return-void 
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v2, "getContext(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;->buildTitleText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->updateTitle(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;->buildDisplayText(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->updateMessage(Ljava/lang/String;)V
    goto +eh
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    if-eqz v0, +005h
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->updateQueue(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)V
    return-void 
.end method
