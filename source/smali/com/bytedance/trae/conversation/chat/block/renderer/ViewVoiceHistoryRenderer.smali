# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;
.super Ljava/lang/Object;
.source "ViewVoiceHistoryRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$Companion;


.method public static synthetic $r8$lambda$ctpJ9yujqnQF6UsFBl2LqZzVyr0(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ViewVoiceHistory  android.content.Context  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;->render$lambda$1$lambda$0(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory; Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final render$lambda$1$lambda$0(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ViewVoiceHistory  android.content.Context  android.view.View)void
    .registers 5
    # ins_size=3
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "[ViewVoiceHistoryRenderer] click: sessionId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;->getSessionId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "AgentBlock"
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    instance-of v4, v3, Landroidx/fragment/app/FragmentActivity;
    if-eqz v4, +005h
    check-cast v3, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-void 
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string v0, "getSupportFragmentManager(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;->getSessionId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;->getConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v3, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ViewVoiceHistory)android.view.View
    .registers 9
    # ins_size=3
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[ViewVoiceHistoryRenderer] render: sessionId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;->getSessionId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", convId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;->getConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentBlock"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_view_voice_history I
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(I)V
    const/16 v2, 17
    invoke-virtual v1, v2, Landroid/widget/TextView;->setGravity(I)V
    const-string v2, "#0A0A0A"
    invoke-static v2, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v2, 2
    const/high16 v3, 1099431936
    invoke-virtual v1, v2, v3, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v2, sans-serif-medium
    const/4 v3, 0
    invoke-static v2, v3, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const v2, -1127428915
    invoke-virtual v1, v2, Landroid/widget/TextView;->setLetterSpacing(F)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_view_voice_history_btn I
    invoke-virtual v1, v2, Landroid/widget/TextView;->setBackgroundResource(I)V
    new-instance v2, Landroid/util/TypedValue;
    invoke-direct v2, Landroid/util/TypedValue;-><init>()V
    invoke-virtual v7, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;
    move-result-object v3
    const v4, 16843534
    const/4 v5, 1
    invoke-virtual v3, v4, v2, v5, Landroid/content/res/Resources$Theme;->resolveAttribute(I Landroid/util/TypedValue; Z)Z
    iget v2, v2, Landroid/util/TypedValue;->resourceId I
    invoke-virtual v7, v2, Landroid/content/Context;->getDrawable(I)Landroid/graphics/drawable/Drawable;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setForeground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v1, v5, Landroid/widget/TextView;->setClickable(Z)V
    invoke-virtual v1, v5, Landroid/widget/TextView;->setFocusable(Z)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v3, 36
    int-to-float v3, v3
    mul-float/2addr v3, v0
    float-to-int v0, v3
    const/4 v3, -1
    invoke-direct v2, v3, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0;
    invoke-direct v0, v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory; Landroid/content/Context;)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ViewVoiceHistory)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;)V
    return-void 
.end method
