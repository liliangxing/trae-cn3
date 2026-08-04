# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "ThinkingDetailCardCreator.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;
.field private static final MAX_CONTENT_LENGTH:I
.field private static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$nZUsB_vzb1XQDUaj0z6EMBw73Og(java.lang.String  boolean  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;->onCreateDetail$lambda$1(Ljava/lang/String; Z Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private static final onCreateDetail$lambda$1(java.lang.String  boolean  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;
    xor-int/lit8 v2, v2, 1
    invoke-virtual v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;->buildContentView$conversation_mainlandRelease(Landroid/content/Context; Ljava/lang/String; Z)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 23
    # ins_size=4
    move-object/from16 v0, v20
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, toolCallInfo
    move-object/from16 v2, v21
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    if-eqz v22, +00dh
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getPlanItemId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getReasoningContent()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v1
    if-nez v3, +004h
    const-string v3, ""
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v1
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v14
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    const/4 v5, 0
    const/4 v6, 1
    if-eq v14, v4, +009h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v14, v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    move v4, v6
    if-eqz v4, +009h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_thinking_title_running I
    invoke-virtual v0, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +7h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_thinking_title_complete I
    invoke-virtual v0, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    move-object v10, v0
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    xor-int/lit8 v0, v4, 1
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "[ThinkingCard] onCreateDetail: name="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v8, ", isComplete="
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", contentLength="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v2, "AgentTool"
    invoke-virtual v7, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v7, ""
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_brain I
    const/4 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    move-object v2, v3
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    move v5, v6
    if-eqz v5, +007h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Z)V
    move-object v13, v1
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 820
    const/16 v18, 0
    move-object v6, v0
    invoke-direct/range v6 ... v18, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 16
    # ins_size=5
    const-string v0, "context"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    const/4 v3, 1
    if-eq v0, v1, +009h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v0, v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    move v1, v3
    if-eqz v1, +00ch
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_thinking_title_running I
    invoke-virtual v12, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +ah
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_thinking_title_complete I
    invoke-virtual v12, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v13, v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    if-eqz v15, +00dh
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getPlanItemId()Ljava/lang/String;
    move-result-object v12
    if-eqz v12, +007h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getReasoningContent()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v2
    if-nez v12, +004h
    const-string v12, ""
    invoke-virtual v12, Ljava/lang/String;->length()I
    move-result v15
    const/16 v0, 5000
    if-le v15, v0, +01bh
    new-instance v15, Ljava/lang/StringBuilder;
    invoke-direct v15, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v12, v0, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v15, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    const/16 v0, 8230
    invoke-virtual v15, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    move-object v6, v15
    goto +2h
    move-object v6, v12
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getContentViewInstance()Landroid/view/View;
    move-result-object v13
    instance-of v15, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v15, +005h
    move-object v2, v13
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    move-object v5, v2
    if-eqz v5, +00dh
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    xor-int/lit8 v7, v1, 1
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    invoke-static/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    xor-int/lit8 v13, v1, 1
    sget-object v15, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "[ThinkingCard] onUpdateCard: name="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v0, ", isComplete="
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, ", contentLength="
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v12, Ljava/lang/String;->length()I
    move-result v12
    invoke-virtual v13, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    const-string v13, "AgentTool"
    invoke-virtual v15, v13, v12, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
