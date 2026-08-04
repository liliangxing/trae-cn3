# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "AgentMessageViewHolder.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field private static final COPY_ICON_RESET_DELAY_MS:J
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;
.field private static final FINISH_TOOLS:Ljava/util/Set;
.field public static final MORE_BUTTON_TAG:Ljava/lang/String;
.field private final contentContainer:Landroid/widget/LinearLayout;
.field private final conversation:Lcom/bytedance/trae/im/service/Conversation;
.field private final copyIconResetHandler:Landroid/os/Handler;
.field private copyIconResetRunnable:Ljava/lang/Runnable;
.field private final factory:Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
.field private isLastAgent:Z
.field private lastBlocks:Ljava/util/List;
.field private lastIsLatestTurn:Z
.field private messageLister:Lcom/bytedance/trae/conversation/chat/IMessageListener;
.field private onContentChanged:Lkotlin/jvm/functions/Function0;
.field private onCopyClick:Lkotlin/jvm/functions/Function1;
.field private onFeedbackClick:Lkotlin/jvm/functions/Function2;
.field private onPureShowWidgetInlineViewCreated:Lkotlin/jvm/functions/Function1;
.field private onReportClick:Lkotlin/jvm/functions/Function2;
.field private onRetryClick:Lkotlin/jvm/functions/Function1;
.field private onUseExpressPassClick:Lkotlin/jvm/functions/Function1;
.field private processSectionView:Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;


.method public static synthetic $r8$lambda$-07lnskdiSLixcc5ErhBW_jbV-k(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildCopyContent$lambda$19(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$BNHxyLYsfDXi8z7lV0IBUeRN148(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->showReportConfirmation$lambda$12(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$XRSI47tfg4ywIKpLtCZyFDBFzNc(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->showCopiedIconTemporarily$lambda$10(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fkBfRhPdPe5eG2X16rAVrFWDFjo(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildCopyContent$lambda$17(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedPlanItem;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$zVjxkL2TMcgh37lTxThT47yOXF4(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionType)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildActionCallback$lambda$4(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 9
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;
    const-string v2, "finish"
    const-string v3, "Finish"
    const-string v4, "agent_finish"
    const-string v5, "AgentFinish"
    const-string/jumbo v6, response_to_user
    const-string v7, "ResponseToUser"
    const-string v8, "Task"
    filled-new-array/range v2 ... v8, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->FINISH_TOOLS Ljava/util/Set;
    return-void 
.end method

.method public constructor <init>(android.widget.LinearLayout  com.bytedance.trae.im.service.Conversation  com.bytedance.trae.conversation.chat.IMessageListener)void
    .registers 5
    # ins_size=4
    const-string v0, "contentContainer"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->conversation Lcom/bytedance/trae/im/service/Conversation;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->messageLister Lcom/bytedance/trae/conversation/chat/IMessageListener;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;->getInstance()Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    const/4 v2, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastIsLatestTurn Z
    new-instance v2, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v3
    invoke-direct v2, v3, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetHandler Landroid/os/Handler;
    return-void 
.end method

.method public static final synthetic access$showReportConfirmation(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->showReportConfirmation(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    return-void 
.end method

.method private final applyBlockSpacing(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock  int  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 8
    # ins_size=5
    invoke-virtual v4, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    instance-of v1, v0, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v1, +005h
    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;
    goto +2h
    const/4 v0, 0
    if-nez v0, +009h
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    if-lez v6, +042h
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    if-eqz v1, +017h
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v5
    if-eqz v5, +00dh
    instance-of v5, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;
    if-eqz v5, +009h
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-virtual v6, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    goto +24h
    const/4 v5, 0
    goto +22h
    instance-of v7, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;
    if-nez v7, +019h
    instance-of v7, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    if-eqz v7, +003h
    goto +13h
    instance-of v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;
    if-eqz v5, +009h
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v6, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    goto +eh
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_24 I
    invoke-virtual v6, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    goto +7h
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-virtual v6, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    iput v5, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method public static synthetic bind$default(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  boolean  boolean  java.lang.String  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +003h
    const/4 v8, 1
    move v2, v8
    and-int/lit8 v8, v12, 4
    if-eqz v8, +003h
    const/4 v9, 0
    move v3, v9
    and-int/lit8 v8, v12, 8
    const/4 v9, 0
    if-eqz v8, +004h
    move-object v4, v9
    goto +2h
    move-object v4, v10
    and-int/lit8 v8, v12, 16
    if-eqz v8, +004h
    move-object v5, v9
    goto +2h
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->bind(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Z Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static synthetic bindStreaming$default(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  boolean  boolean  java.lang.String  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +003h
    const/4 v8, 1
    move v2, v8
    and-int/lit8 v8, v12, 4
    if-eqz v8, +003h
    const/4 v9, 0
    move v3, v9
    and-int/lit8 v8, v12, 8
    const/4 v9, 0
    if-eqz v8, +004h
    move-object v4, v9
    goto +2h
    move-object v4, v10
    and-int/lit8 v8, v12, 16
    if-eqz v8, +004h
    move-object v5, v9
    goto +2h
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->bindStreaming(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Z Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final buildActionCallback(com.bytedance.trae.im.model.ParsedChatMessage)kotlin.jvm.functions.Function1
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda4;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    return-object v0
.end method

.method private static final buildActionCallback$lambda$4(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionType)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "actionType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->ordinal()I
    move-result v3
    aget v3, v0, v3
    packed-switch v3, +0000033h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    if-eqz v1, +025h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +1ch
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->handleMore(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto +18h
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onRetryClick Lkotlin/jvm/functions/Function1;
    if-eqz v1, +015h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +ch
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->handleCopy(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto +8h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->handleThumbsDown(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto +4h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->handleThumbsUp(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    packed-switch-payload 1 2 3 4 5 6
.end method

.method private final buildCopyContent(com.bytedance.trae.im.model.ParsedChatMessage)java.lang.String
    .registers 12
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    const/4 v3, 0
    if-eqz v2, +005h
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    goto +2h
    move-object v1, v3
    if-eqz v1, +02eh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +028h
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +012h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v4
    if-eqz v4, -010h
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v2, Ljava/util/List;
    goto +2h
    move-object v2, v3
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v4, voice_summary
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const/4 v4, 1
    if-eqz v1, +017h
    invoke-direct v10, v11, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildVoiceSummaryCopyContent(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/util/List;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +011h
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v4
    if-eqz v5, +003h
    goto +2h
    move-object v1, v3
    if-eqz v1, +003h
    return-object v1
    const-string v1, "

"
    const/4 v5, 0
    if-eqz v2, +068h
    move-object v6, v2
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +05bh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Ljava/lang/CharSequence;
    if-eqz v9, +00bh
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +003h
    goto +3h
    move v9, v5
    goto +2h
    move v9, v4
    if-nez v9, +016h
    move-object v9, v0
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-lez v9, +004h
    move v9, v4
    goto +2h
    move v9, v5
    if-eqz v9, +005h
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +3h
    move v8, v5
    goto +2h
    move v8, v4
    if-nez v8, -048h
    move-object v8, v0
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +004h
    move v8, v4
    goto +2h
    move v8, v5
    if-eqz v8, +005h
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto -5eh
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +006h
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v6
    invoke-direct v10, v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->findMainAgentRunId(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-eqz v2, +027h
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v2
    if-eqz v2, +01fh
    new-instance v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v6, v10, v11, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Ljava/lang/String;)V
    invoke-static v2, v6, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v11
    if-eqz v11, +014h
    new-instance v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda3;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v11, v2, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v11
    if-eqz v11, +009h
    invoke-static v11, Lkotlin/sequences/SequencesKt;->firstOrNull(Lkotlin/sequences/Sequence;)Ljava/lang/Object;
    move-result-object v11
    move-object v3, v11
    check-cast v3, Ljava/lang/String;
    move-object v11, v3
    check-cast v11, Ljava/lang/CharSequence;
    if-eqz v11, +00bh
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +003h
    goto +3h
    move v11, v5
    goto +2h
    move v11, v4
    if-nez v11, +015h
    move-object v11, v0
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-lez v11, +003h
    goto +2h
    move v4, v5
    if-eqz v4, +005h
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v0, toString(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v11
.end method

.method private static final buildCopyContent$lambda$17(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 4
    # ins_size=3
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isFinishTool(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method private static final buildCopyContent$lambda$19(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.String
    .registers 3
    # ins_size=1
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    const/4 v0, 0
    if-eqz v2, +01fh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +019h
    const-string/jumbo v1, summary
    invoke-virtual v2, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +010h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final buildVoiceSummaryCopyContent(com.bytedance.trae.im.model.ParsedChatMessage  java.util.List)java.lang.String
    .registers 9
    # ins_size=3
    move-object v0, v8
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const/4 v2, 0
    if-eqz v0, +003h
    return-object v2
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v0
    invoke-direct v6, v8, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->findMainAgentRunId(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +074h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-direct v6, v3, v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isMainAgentPlanItem(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +025h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseThought(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v4
    if-eqz v4, +019h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getMarkdown()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +013h
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v1
    if-eqz v5, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +005h
    invoke-interface v0, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct v6, v3, v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isFinishTool(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, -039h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    goto +2h
    move-object v3, v2
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseParams(Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v4
    if-eqz v4, +008h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getMarkdown()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +013h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    if-eqz v3, +00ah
    const-string/jumbo v5, summary
    invoke-virtual v3, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    goto +2h
    move-object v3, v2
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->extractSummaryText(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v4
    move-object v3, v4
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, -072h
    invoke-interface v0, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -77h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    return-object v7
.end method

.method private final cancelAllTypewriters()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +018h
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    if-nez v2, +003h
    goto +bh
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;->cancelTypewriter(Landroid/view/View;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;->cancelTypewriter(Landroid/view/View;)V
    add-int/lit8 v1, v1, 1
    goto -17h
    return-void 
.end method

.method private final cancelCopyIconReset()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetHandler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method private final currentConversation()com.bytedance.trae.im.service.Conversation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->messageLister Lcom/bytedance/trae/conversation/chat/IMessageListener;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-nez v0, +004h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->conversation Lcom/bytedance/trae/im/service/Conversation;
    return-object v0
.end method

.method private final findFirstResultIndex(java.util.List)int
    .registers 7
    # ins_size=2
    invoke-interface v6, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    move v2, v1
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +03eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    if-nez v4, +02dh
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;
    if-nez v4, +029h
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    if-nez v4, +025h
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;
    if-nez v4, +021h
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    if-nez v4, +01dh
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    if-nez v4, +019h
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;
    if-nez v4, +015h
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    if-nez v4, +011h
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    if-nez v4, +00dh
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    if-nez v4, +009h
    instance-of v3, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    if-eqz v3, +003h
    goto +3h
    move v3, v1
    goto +2h
    const/4 v3, 1
    if-eqz v3, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -41h
    const/4 v2, -1
    if-gez v2, +006h
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v2
    return v2
.end method

.method private final findMainAgentRunId(java.util.List  java.lang.String)java.lang.String
    .registers 10
    # ins_size=3
    const/4 v0, 0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v8, +047h
    move-object v3, v8
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02dh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +018h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v0
    goto +2h
    move v5, v2
    if-nez v5, +004h
    move v5, v2
    goto +2h
    move v5, v0
    if-eqz v5, -02eh
    goto +2h
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v4, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +004h
    move-object v1, v9
    goto +35h
    if-eqz v8, +034h
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01fh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v3, v9
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v0
    goto +2h
    move v3, v2
    xor-int/2addr v3, v2
    if-eqz v3, -020h
    goto +2h
    move-object v9, v1
    check-cast v9, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v9, +006h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private final findViewByBlockClass(kotlin.reflect.KClass)android.view.View
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +018h
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tag_block_class I
    invoke-virtual v2, v3, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    return-object v2
    add-int/lit8 v1, v1, 1
    goto -17h
    const/4 v5, 0
    return-object v5
.end method

.method private final fullRebuild(java.util.List  float)void
    .registers 19
    # ins_size=3
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v2, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->cancelAllTypewriters()V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->cancelCopyIconReset()V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    check-cast v3, Landroid/view/View;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v3, Landroid/widget/LinearLayout;->removeAllViews()V
    const/4 v9, 0
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    move-object v10, v3
    check-cast v10, Ljava/util/List;
    move-object v3, v1
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    const/4 v12, 0
    move v3, v12
    move v4, v3
    move v13, v4
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +0fbh
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    add-int/lit8 v14, v3, 1
    if-gez v3, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;
    if-eqz v6, +04ch
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->reset()V
    if-nez v3, +010h
    new-instance v15, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v15
    move-object v4, v2
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onContentChanged Lkotlin/jvm/functions/Function0;
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setTag(I Ljava/lang/Object;)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setTag(I Ljava/lang/Object;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -2
    const/4 v6, -1
    invoke-direct v4, v6, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    if-lez v13, +00ah
    const/16 v5, 24
    int-to-float v5, v5
    mul-float v5, v5, v18
    float-to-int v5, v5
    iput v5, v4, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    check-cast v3, Landroid/view/View;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-interface v10, Ljava/util/List;->clear()V
    add-int/lit8 v13, v13, 1
    const/4 v3, 1
    move v4, v3
    goto/16 +09dh
    instance-of v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    if-eqz v6, +057h
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted()Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->COMPLETED Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v4, +00ch
    move-object v6, v10
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v6, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v6
    invoke-virtual v4, v6, v3, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->updateBlocks(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v3, +018h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted()Z
    move-result v4
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->COMPLETED Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    goto +3h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->getDurationMs()J
    move-result-wide v6
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->getAutoCollapse()Z
    move-result v8
    invoke-virtual v3, v4, v6, v7, v8, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setState(Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState; J Z)V
    invoke-interface v10, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-eqz v3, +01ah
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted()Z
    move-result v3
    if-eqz v3, +014h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v3, +00ch
    check-cast v3, Landroid/view/View;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v4, v3, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    add-int/lit8 v13, v13, -1
    move v4, v12
    goto +43h
    if-eqz v4, +006h
    invoke-interface v10, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +3dh
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-virtual v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v6
    if-nez v6, +003h
    goto +34h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v6, v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Landroid/view/View;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onContentChanged Lkotlin/jvm/functions/Function0;
    invoke-virtual v6, v7, v8, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v6, v7, v8, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tag_block_class I
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v8
    invoke-virtual v6, v7, v8, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View;)V
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->previousRenderableBlock(Ljava/util/List; I)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v3
    invoke-direct v0, v6, v5, v13, v3, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->applyBlockSpacing(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; I Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v3, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    add-int/lit8 v13, v13, 1
    move v3, v14
    goto/16 -0fdh
    return-void 
.end method

.method private final handleCopy(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildCopyContent(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +008h
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_no_copyable_content I
    invoke-static v0, v5, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    return-void 
    const-string v2, "clipboard"
    invoke-virtual v0, v2, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    const-string v3, "null cannot be cast to non-null type android.content.ClipboardManager"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/content/ClipboardManager;
    const-string v3, "message"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, v1, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v1
    invoke-virtual v2, v1, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_copied I
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->showCopiedIconTemporarily()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onCopyClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +009h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-interface v0, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final handleMore(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 8
    # ins_size=2
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->findViewByBlockClass(Lkotlin/reflect/KClass;)Landroid/view/View;
    move-result-object v0
    instance-of v1, v0, Landroid/view/ViewGroup;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    move-object v0, v2
    if-nez v0, +003h
    return-void 
    const-string v1, "more_button"
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    instance-of v1, v0, Landroid/view/ViewGroup;
    if-eqz v1, +005h
    move-object v2, v0
    check-cast v2, Landroid/view/ViewGroup;
    if-eqz v2, +009h
    const/4 v1, 0
    invoke-virtual v2, v1, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v1
    if-nez v1, +003h
    move-object v1, v0
    invoke-static v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isBrainstormMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    new-instance v3, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v4, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v4
    const-string v5, "getContext(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$handleMore$popup$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    check-cast v5, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;
    invoke-direct v3, v4, v5, v2, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener; Z)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->showAbove(Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method private final handleThumbsDown(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->INSTANCE Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getFeedbackState(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_DOWN Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-ne v0, v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_DOWN Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->INSTANCE Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->saveFeedbackState(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    const/4 v2, 6
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->performHapticFeedback(I)Z
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-eq v0, v1, +00fh
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    if-eqz v1, +00bh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    const-string v3, "dislike"
    invoke-interface v1, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->refreshFeedbackState(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;)V
    return-void 
.end method

.method private final handleThumbsUp(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->INSTANCE Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getFeedbackState(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_UP Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-ne v0, v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_UP Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->INSTANCE Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->saveFeedbackState(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    const/4 v2, 6
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->performHapticFeedback(I)Z
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-eq v0, v1, +00fh
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    if-eqz v1, +00bh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    const-string v3, "like"
    invoke-interface v1, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->refreshFeedbackState(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;)V
    return-void 
.end method

.method private final incrementalUpdate(java.util.List)void
    .registers 15
    # ins_size=2
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v1
    const/4 v2, -1
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v1, +01bh
    invoke-interface v0, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;
    if-nez v5, +009h
    instance-of v1, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    if-eqz v1, +003h
    goto +3h
    move v1, v3
    goto +2h
    move v1, v4
    if-eqz v1, -01bh
    invoke-interface v0, Ljava/util/ListIterator;->nextIndex()I
    move-result v0
    goto +2h
    move v0, v2
    if-ltz v0, +056h
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v1, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v1
    iget-object v5, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    sub-int/2addr v5, v0
    sub-int/2addr v1, v5
    if-ltz v1, +00ch
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v0
    if-ge v1, v0, +004h
    move v0, v4
    goto +2h
    move v0, v3
    if-eqz v0, +007h
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->removeViewAt(I)V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +01bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v7, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;
    if-nez v7, +009h
    instance-of v6, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    if-eqz v6, +003h
    goto +3h
    move v6, v3
    goto +2h
    move v6, v4
    if-nez v6, -019h
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    check-cast v1, Ljava/util/List;
    iput-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 0
    if-eqz v5, +00eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v7, v5
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v7, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    if-eqz v7, -010h
    goto +2h
    move-object v5, v6
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-object v1, v14
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +00eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v8, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    if-eqz v8, -00fh
    goto +2h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    if-eqz v5, +02fh
    if-eqz v7, +02dh
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +027h
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +01fh
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tag_block_class I
    invoke-virtual v1, v5, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v5
    const-class v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-static v8, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v8
    invoke-static v5, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +00dh
    iget-object v5, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v5
    if-eqz v5, +005h
    invoke-interface v5, v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    invoke-interface v14, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    move v5, v3
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v7, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;
    if-eqz v7, +003h
    goto +5h
    add-int/lit8 v5, v5, 1
    goto -13h
    move v5, v2
    invoke-interface v14, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v14, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v7
    if-eqz v7, +011h
    invoke-interface v1, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v7, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    if-eqz v7, -00eh
    invoke-interface v1, Ljava/util/ListIterator;->nextIndex()I
    move-result v1
    goto +2h
    move v1, v2
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v7, +068h
    if-ltz v5, +066h
    if-le v1, v5, +064h
    if-eqz v7, +009h
    sget v8, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    iget-object v9, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onContentChanged Lkotlin/jvm/functions/Function0;
    invoke-virtual v7, v8, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setTag(I Ljava/lang/Object;)V
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v7, +009h
    sget v8, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    iget-object v9, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v7, v8, v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setTag(I Ljava/lang/Object;)V
    add-int/2addr v5, v4
    invoke-interface v14, v5, v1, Ljava/util/List;->subList(I I)Ljava/util/List;
    move-result-object v5
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v7, +006h
    const/4 v8, 2
    invoke-static v7, v5, v6, v8, v6, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->updateBlocks$default(Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState; I Ljava/lang/Object;)V
    invoke-interface v14, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    const-string v8, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.ProcessEnd"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v8, +018h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted()Z
    move-result v9
    if-eqz v9, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->COMPLETED Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    goto +3h
    sget-object v9, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->getDurationMs()J
    move-result-wide v10
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->getAutoCollapse()Z
    move-result v12
    invoke-virtual v8, v9, v10, v11, v12, Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;->setState(Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState; J Z)V
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +018h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted()Z
    move-result v5
    if-eqz v5, +012h
    iget-object v5, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    if-eqz v5, +00ch
    check-cast v5, Landroid/view/View;
    invoke-direct v13, v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v7, v5, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V
    iput-object v6, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    iget-object v5, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v6
    invoke-interface v5, v6, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v6
    if-eqz v6, +010h
    invoke-interface v5, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v6, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    if-eqz v6, -00eh
    invoke-interface v5, Ljava/util/ListIterator;->nextIndex()I
    move-result v2
    if-ltz v2, +004h
    add-int/2addr v2, v4
    goto +7h
    iget-object v2, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-direct v13, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->findFirstResultIndex(Ljava/util/List;)I
    move-result v2
    if-ltz v1, +004h
    add-int/2addr v1, v4
    goto +5h
    invoke-direct v13, v14, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->findFirstResultIndex(Ljava/util/List;)I
    move-result v1
    iget-object v4, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    if-ge v2, v4, +00dh
    iget-object v4, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v5
    invoke-interface v4, v2, v5, Ljava/util/List;->subList(I I)Ljava/util/List;
    move-result-object v2
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-interface v14, Ljava/util/List;->size()I
    move-result v4
    if-ge v1, v4, +00bh
    invoke-interface v14, Ljava/util/List;->size()I
    move-result v4
    invoke-interface v14, v1, v4, Ljava/util/List;->subList(I I)Ljava/util/List;
    move-result-object v4
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    iget-object v5, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v5
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v6
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v7, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v7
    invoke-static v6, v7, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v6
    sub-int/2addr v5, v6
    move-object v6, v2
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->size()I
    move-result v6
    if-ge v3, v6, +0b6h
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v7
    if-ge v3, v7, +0b0h
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    invoke-interface v2, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +09eh
    add-int v7, v5, v3
    if-ltz v7, +09ah
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v8, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v8
    if-lt v7, v8, +004h
    goto/16 +090h
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v8, v7, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v8
    if-nez v8, +004h
    goto/16 +086h
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v9
    invoke-interface v2, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v10
    if-ne v9, v10, +01ah
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v7, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v7
    if-eqz v7, +066h
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-interface v7, v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    goto +5bh
    iget-object v9, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v9
    if-nez v9, +003h
    goto +4ch
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-interface v9, v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Landroid/view/View;
    move-result-object v9
    sget v10, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    iget-object v11, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onContentChanged Lkotlin/jvm/functions/Function0;
    invoke-virtual v9, v10, v11, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    sget v10, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    iget-object v11, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v9, v10, v11, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    sget v10, Lcom/bytedance/trae/conversation/R$id;->tag_block_class I
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v11
    invoke-static v11, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v11
    invoke-virtual v9, v10, v11, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    invoke-direct v13, v9, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View;)V
    add-int v10, v1, v3
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v13, v14, v10, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->previousRenderableBlock(Ljava/util/List; I)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v12
    invoke-direct v13, v9, v11, v10, v12, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->applyBlockSpacing(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; I Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    invoke-direct v13, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v8, v7, Landroid/widget/LinearLayout;->removeViewAt(I)V
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v8, v9, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; I)V
    add-int/lit8 v3, v3, 1
    goto/16 -0b4h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v3
    if-ge v2, v3, +050h
    invoke-interface v4, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;
    if-nez v6, +043h
    instance-of v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    if-eqz v6, +003h
    goto +3dh
    iget-object v6, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->factory Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-virtual v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->getRenderer(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    move-result-object v6
    if-nez v6, +003h
    goto +34h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v6, v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Landroid/view/View;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onContentChanged Lkotlin/jvm/functions/Function0;
    invoke-virtual v6, v7, v8, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v6, v7, v8, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tag_block_class I
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v8
    invoke-virtual v6, v7, v8, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    invoke-direct v13, v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View;)V
    add-int v7, v1, v2
    invoke-direct v13, v14, v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->previousRenderableBlock(Ljava/util/List; I)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v8
    invoke-direct v13, v6, v5, v7, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->applyBlockSpacing(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; I Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    iget-object v5, v13, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    add-int/lit8 v2, v2, 1
    goto -4fh
    return-void 
.end method

.method private final isFinishTool(com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String)boolean
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +03eh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +36h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->FINISH_TOOLS Ljava/util/Set;
    invoke-interface v2, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return v1
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v2, 1
    if-nez v0, +022h
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +013h
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +003h
    move v1, v2
    return v1
.end method

.method private final isMainAgentPlanItem(com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String)boolean
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v4
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +018h
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +012h
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +003h
    move v1, v2
    return v1
.end method

.method private final notifyPureShowWidgetInlineViewCreated(android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    if-nez v0, +003h
    return-void 
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
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
    invoke-direct v4, v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->notifyPureShowWidgetInlineViewCreated(Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    add-int/lit8 v1, v1, 1
    goto -10h
    return-void 
.end method

.method private final previousRenderableBlock(java.util.List  int)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 5
    # ins_size=3
    add-int/lit8 v4, v4, -1
    const/4 v0, -1
    if-ge v0, v4, +014h
    invoke-interface v3, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;
    if-nez v1, +007h
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    if-nez v1, +003h
    return-object v0
    add-int/lit8 v4, v4, -1
    goto -14h
    const/4 v3, 0
    return-object v3
.end method

.method private final refreshFeedbackState(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState)void
    .registers 25
    # ins_size=3
    move-object/from16 v8, v22
    move-object/from16 v0, v24
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v2
    invoke-interface v1, v2, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v2
    if-eqz v2, +011h
    invoke-interface v1, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v2, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    if-eqz v2, -00eh
    invoke-interface v1, Ljava/util/ListIterator;->nextIndex()I
    move-result v1
    goto +2h
    const/4 v1, -1
    if-gez v1, +013h
    iget-boolean v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastIsLatestTurn Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isLastAgent Z
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 24
    const/4 v7, 0
    move-object/from16 v0, v22
    move-object/from16 v1, v23
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->bind$default(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Z Ljava/lang/String; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    return-void 
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v2, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    const-string v3, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.ActionBar"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v9, v2
    check-cast v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 1007
    const/16 v21, 0
    move-object/from16 v14, v24
    invoke-static/range v9 ... v21, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->copy$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Ljava/lang/Boolean; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; Z Z Z Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    move-result-object v2
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v3
    invoke-interface v3, v1, v2, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iput-object v3, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    const-class v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-static v1, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v1
    invoke-direct v8, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->findViewByBlockClass(Lkotlin/reflect/KClass;)Landroid/view/View;
    move-result-object v1
    instance-of v2, v1, Landroid/view/ViewGroup;
    const/4 v3, 0
    if-eqz v2, +005h
    check-cast v1, Landroid/view/ViewGroup;
    goto +2h
    move-object v1, v3
    if-nez v1, +016h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    iget-boolean v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastIsLatestTurn Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isLastAgent Z
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 24
    const/4 v7, 0
    move-object/from16 v0, v22
    move-object/from16 v1, v23
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->bind$default(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Z Ljava/lang/String; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    return-void 
    const-string/jumbo v2, thumbs_up_button
    invoke-virtual v1, v2, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/FrameLayout;
    const/4 v4, 0
    if-eqz v2, +007h
    invoke-virtual v2, v4, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    goto +2h
    move-object v2, v3
    instance-of v5, v2, Landroid/widget/ImageView;
    if-eqz v5, +005h
    check-cast v2, Landroid/widget/ImageView;
    goto +2h
    move-object v2, v3
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_UP Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    const/4 v6, 1
    if-ne v0, v5, +004h
    move v5, v6
    goto +2h
    move v5, v4
    if-eqz v2, +00ch
    if-eqz v5, +005h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_up_filled I
    goto +3h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_up I
    invoke-virtual v2, v5, Landroid/widget/ImageView;->setImageResource(I)V
    if-eqz v2, +007h
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-direct v8, v2, v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->tintIcon(Landroid/widget/ImageView; I)V
    const-string/jumbo v2, thumbs_down_button
    invoke-virtual v1, v2, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-eqz v1, +007h
    invoke-virtual v1, v4, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v1
    goto +2h
    move-object v1, v3
    instance-of v2, v1, Landroid/widget/ImageView;
    if-eqz v2, +005h
    move-object v3, v1
    check-cast v3, Landroid/widget/ImageView;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_DOWN Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-ne v0, v1, +003h
    move v4, v6
    if-eqz v3, +00ch
    if-eqz v4, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_down_filled I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_down I
    invoke-virtual v3, v0, Landroid/widget/ImageView;->setImageResource(I)V
    if-eqz v3, +007h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-direct v8, v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->tintIcon(Landroid/widget/ImageView; I)V
    return-void 
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
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    add-int/lit8 v1, v1, 1
    goto -10h
    return-void 
.end method

.method private final setCopyButtonCopiedState(boolean)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-static v1, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v1
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->findViewByBlockClass(Lkotlin/reflect/KClass;)Landroid/view/View;
    move-result-object v1
    instance-of v2, v1, Landroid/view/ViewGroup;
    const/4 v3, 0
    if-eqz v2, +005h
    check-cast v1, Landroid/view/ViewGroup;
    goto +2h
    move-object v1, v3
    if-nez v1, +003h
    return-void 
    const-string v2, "copy_button"
    invoke-virtual v1, v2, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-nez v1, +003h
    return-void 
    if-eqz v5, +005h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_copied I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_message_menu_copy I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setContentDescription(Ljava/lang/CharSequence;)V
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v0
    instance-of v1, v0, Landroid/widget/ImageView;
    if-eqz v1, +005h
    move-object v3, v0
    check-cast v3, Landroid/widget/ImageView;
    if-nez v3, +003h
    return-void 
    if-eqz v5, +00dh
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_copy_checkmark I
    invoke-virtual v3, v5, Landroid/widget/ImageView;->setImageResource(I)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-direct v4, v3, v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->tintIcon(Landroid/widget/ImageView; I)V
    goto +bh
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_copy I
    invoke-virtual v3, v5, Landroid/widget/ImageView;->setImageResource(I)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-direct v4, v3, v5, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->tintIcon(Landroid/widget/ImageView; I)V
    invoke-virtual v3, Landroid/widget/ImageView;->jumpDrawablesToCurrentState()V
    invoke-virtual v3, Landroid/widget/ImageView;->invalidate()V
    return-void 
.end method

.method private final showCopiedIconTemporarily()void
    .registers 5
    # ins_size=1
    const/4 v0, 1
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setCopyButtonCopiedState(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetHandler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetRunnable Ljava/lang/Runnable;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetHandler Landroid/os/Handler;
    const-wide/16 v2, 3000
    invoke-virtual v1, v0, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final showCopiedIconTemporarily$lambda$10(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder)void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->copyIconResetRunnable Ljava/lang/Runnable;
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setCopyButtonCopiedState(Z)V
    return-void 
.end method

.method private final showReportConfirmation(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 30
    # ins_size=2
    move-object/from16 v0, v28
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v1, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    new-instance v15, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v3, v15
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_report_confirm_title I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    move-object v4, v5
    const-string v10, "getString(...)"
    invoke-static v5, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_report_confirm_message I
    invoke-virtual v1, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_report_cancel I
    invoke-virtual v1, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    move-object v8, v9
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_report_confirm I
    invoke-virtual v1, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    move-object v9, v11
    invoke-static v11, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v27, v15
    move-object/from16 v15, v16
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    new-instance v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda0;
    move-object/from16 v23, v6
    move-object/from16 v7, v29
    invoke-direct v6, v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    const/16 v24, 0
    const v25, 1572812
    const/16 v26, 0
    const/4 v6, 0
    const/4 v7, 0
    invoke-direct/range v3 ... v26, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v3, v27
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showReportConfirmation$lambda$12(com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildCopyContent(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onReportClick Lkotlin/jvm/functions/Function2;
    if-eqz v0, +009h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final tintIcon(android.widget.ImageView  int)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-static v3, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v3
    invoke-static v2, v3, Landroidx/core/widget/ImageViewCompat;->setImageTintList(Landroid/widget/ImageView; Landroid/content/res/ColorStateList;)V
    return-void 
.end method

.method private final withUpgradeReminder(java.util.List  java.lang.String  kotlin.jvm.functions.Function1)java.util.List
    .registers 6
    # ins_size=4
    if-eqz v4, +041h
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v4, 0
    if-nez v4, +003h
    goto +30h
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v0
    invoke-interface v3, v0, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v1
    if-eqz v1, +011h
    invoke-interface v0, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v1, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    if-eqz v1, -00eh
    invoke-interface v0, Ljava/util/ListIterator;->nextIndex()I
    move-result v0
    goto +2h
    const/4 v0, -1
    if-gez v0, +003h
    return-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v3
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;
    invoke-direct v1, v4, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;-><init>(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    invoke-interface v3, v0, v1, Ljava/util/List;->add(I Ljava/lang/Object;)V
    return-object v3
.end method

.method public final bind(com.bytedance.trae.im.model.ParsedChatMessage  boolean  boolean  java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 22
    # ins_size=6
    move-object/from16 v0, v16
    const-string v1, "message"
    move-object/from16 v3, v17
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v1, v18
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastIsLatestTurn Z
    move/from16 v2, v19
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isLastAgent Z
    invoke-direct/range v16 ... v17, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildActionCallback(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lkotlin/jvm/functions/Function1;
    move-result-object v6
    sget-object v2, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->INSTANCE Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getFeedbackState(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-result-object v10
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    const-string v5, "getResources(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->currentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v5
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->messageLister Lcom/bytedance/trae/conversation/chat/IMessageListener;
    iget-boolean v9, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isLastAgent Z
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 1792
    const/4 v15, 0
    move/from16 v8, v18
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->build$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Landroid/content/res/Resources; Lcom/bytedance/trae/im/service/Conversation; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/IMessageListener; Z Z Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; I I Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    move-object/from16 v2, v20
    move-object/from16 v3, v21
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->withUpgradeReminder(Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function1;)Ljava/util/List;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node8] VH.bind: blockCount="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", types="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v4, v1
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    const/16 v6, 10
    invoke-static v4, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v5, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +018h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v6
    invoke-interface v6, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v6
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v5, Ljava/util/List;
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "AgentDataFlow"
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +015h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v2, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v2
    if-lez v2, +00dh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    return-void 
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v2, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->fullRebuild(Ljava/util/List; F)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    return-void 
.end method

.method public final bindStreaming(com.bytedance.trae.im.model.ParsedChatMessage  boolean  boolean  java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 22
    # ins_size=6
    move-object/from16 v0, v16
    const-string v1, "message"
    move-object/from16 v3, v17
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v1, v18
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastIsLatestTurn Z
    move/from16 v2, v19
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isLastAgent Z
    invoke-direct/range v16 ... v17, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->buildActionCallback(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lkotlin/jvm/functions/Function1;
    move-result-object v6
    sget-object v2, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->INSTANCE Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getFeedbackState(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-result-object v10
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    const-string v5, "getResources(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->currentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v5
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->messageLister Lcom/bytedance/trae/conversation/chat/IMessageListener;
    iget-boolean v9, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->isLastAgent Z
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 1792
    const/4 v15, 0
    move/from16 v8, v18
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->build$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Landroid/content/res/Resources; Lcom/bytedance/trae/im/service/Conversation; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/IMessageListener; Z Z Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; I I Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    move-object/from16 v2, v20
    move-object/from16 v3, v21
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->withUpgradeReminder(Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function1;)Ljava/util/List;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v2, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-nez v3, +00eh
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v3, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v3
    if-nez v3, +003h
    goto +4h
    const-string v3, "incremental"
    goto +3h
    const-string v3, "fullRebuild"
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[Node8] VH.bindStreaming: blockCount="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", mode="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ", lastBlockCount="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ", containerChildren="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v5, "AgentDataFlow"
    invoke-virtual v4, v5, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-nez v3, +00fh
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v3, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v3
    if-nez v3, +003h
    goto +5h
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->incrementalUpdate(Ljava/util/List;)V
    goto +4h
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->fullRebuild(Ljava/util/List; F)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    return-void 
.end method

.method public final getMessageLister()com.bytedance.trae.conversation.chat.IMessageListener
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->messageLister Lcom/bytedance/trae/conversation/chat/IMessageListener;
    return-object v0
.end method

.method public final getOnContentChanged()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onContentChanged Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnCopyClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onCopyClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnFeedbackClick()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnReportClick()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onReportClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getOnRetryClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onRetryClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnUseExpressPassClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final resetState()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->cancelAllTypewriters()V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->cancelCopyIconReset()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->lastBlocks Ljava/util/List;
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->processSectionView Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->contentContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    return-void 
.end method

.method public final setMessageLister(com.bytedance.trae.conversation.chat.IMessageListener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->messageLister Lcom/bytedance/trae/conversation/chat/IMessageListener;
    return-void 
.end method

.method public final setOnContentChanged(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onContentChanged Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnCopyClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onCopyClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnFeedbackClick(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnReportClick(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onReportClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOnRetryClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onRetryClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnUseExpressPassClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method
