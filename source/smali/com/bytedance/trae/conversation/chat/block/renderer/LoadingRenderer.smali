# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer;
.super Ljava/lang/Object;
.source "LoadingRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Loading)android.view.View
    .registers 9
    # ins_size=3
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "AgentBlock"
    const-string v2, "[LoadingRenderer] render"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v4, 4
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v4, v4
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/ProgressBar;
    invoke-direct v3, v7, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V
    const/4 v4, 1
    invoke-virtual v3, v4, Landroid/widget/ProgressBar;->setIndeterminate(Z)V
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    invoke-direct v4, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;->getTailStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    move-result-object v8
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->ordinal()I
    move-result v8
    aget v8, v2, v8
    packed-switch v8, +0000067h
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_failed I
    invoke-virtual v7, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    goto +23h
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_done I
    invoke-virtual v7, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    goto +1ch
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_command_running I
    invoke-virtual v7, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    goto +15h
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_generating_code I
    invoke-virtual v7, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    goto +eh
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_pending I
    invoke-virtual v7, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    goto +7h
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_thinking I
    invoke-virtual v7, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v2, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v7, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v2, v7, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v7, 2
    const/high16 v8, 1095761920
    invoke-virtual v2, v7, v8, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v2, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v8, 8
    int-to-float v8, v8
    mul-float/2addr v8, v0
    float-to-int v8, v8
    invoke-virtual v7, v8, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    return-object v1
    packed-switch-payload 1 2 3 4 5 6
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Loading)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v4, Landroid/widget/LinearLayout;
    const/4 v1, 0
    if-eqz v0, +006h
    move-object v0, v4
    check-cast v0, Landroid/widget/LinearLayout;
    goto +2h
    move-object v0, v1
    if-nez v0, +003h
    return-void 
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v0
    instance-of v2, v0, Landroid/widget/TextView;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/widget/TextView;
    if-nez v1, +003h
    return-void 
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-virtual v4, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;->getTailStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->ordinal()I
    move-result v5
    aget v5, v0, v5
    packed-switch v5, +0000039h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_failed I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    goto +23h
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_done I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    goto +1ch
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_command_running I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    goto +15h
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_generating_code I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    goto +eh
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_pending I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    goto +7h
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_status_thinking I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
    nop 
    packed-switch-payload 1 2 3 4 5 6
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;)V
    return-void 
.end method
