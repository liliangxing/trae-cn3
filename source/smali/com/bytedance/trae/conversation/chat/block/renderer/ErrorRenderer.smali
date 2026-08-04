# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer;
.super Ljava/lang/Object;
.source "ErrorRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Error)android.view.View
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[ErrorRenderer] render: error="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", level="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->getLevel()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentBlock"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->getLevel()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ordinal()I
    move-result v1
    aget v1, v2, v1
    const/4 v2, 1
    if-eq v1, v2, +02ah
    const/4 v2, 2
    if-eq v1, v2, +019h
    const/4 v2, 3
    if-ne v1, v2, +010h
    new-instance v1, Lkotlin/Pair;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->TIPS Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_stream_tips_title I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-direct v1, v2, v3, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    goto +22h
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    new-instance v1, Lkotlin/Pair;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->WARNING Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_stream_warning_title I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-direct v1, v2, v3, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    goto +eh
    new-instance v1, Lkotlin/Pair;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->ERROR Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_stream_error_title I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-direct v1, v2, v3, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-virtual v1, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    invoke-virtual v1, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
    invoke-direct v3, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;-><init>(Landroid/content/Context;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v6, -2
    invoke-direct v4, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 8
    int-to-float v5, v5
    mul-float/2addr v5, v0
    float-to-int v0, v5
    iput v0, v4, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v0, v4, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->getDisplayTitle()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00bh
    invoke-virtual v8, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v8, "getString(...)"
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->getDisplayMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->getShowInfoIcon()Z
    move-result v9
    if-eqz v9, +009h
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->info_filled I
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    invoke-virtual v3, v0, v8, v2, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->configureInlineAlert(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style; Ljava/lang/Integer;)V
    check-cast v3, Landroid/view/View;
    return-object v3
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Error)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;)V
    return-void 
.end method
