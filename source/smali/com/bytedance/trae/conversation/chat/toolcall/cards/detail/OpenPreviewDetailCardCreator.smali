# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "OpenPreviewDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$0HSD9txBv-V_mSetWpo8IpsVSMU(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.OpenPreviewDetailCardCreator  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->onCreateDetail$lambda$1(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final extractPreviewUrl(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    const-string v1, "preview_url"
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +017h
    const-string/jumbo v2, url
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00dh
    invoke-direct v3, v4, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +007h
    invoke-direct v3, v4, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method private static final onCreateDetail$lambda$1(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.OpenPreviewDetailCardCreator  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 8
    # ins_size=5
    const-string/jumbo v0, view
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[OpenPreviewCard] onDetailClick: url="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentTool"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v7
    const-string v0, "getContext(...)"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v7, v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->openUrl(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v5, tool_name
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v5, tool_call_click
    invoke-virtual v3, v5, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final openUrl(android.content.Context  java.lang.String  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 10
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->Companion Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_web I
    invoke-virtual v7, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    const/4 v1, 0
    if-eqz v9, +008h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getChatSessionId()Ljava/lang/String;
    move-result-object v2
    move-object v4, v2
    goto +2h
    move-object v4, v1
    if-eqz v9, +008h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getEnvironment()Ljava/lang/String;
    move-result-object v9
    move-object v5, v9
    goto +2h
    move-object v5, v1
    move-object v1, v7
    move-object v2, v8
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +18h
    new-instance v9, Landroid/content/Intent;
    const-string v0, "android.intent.action.VIEW"
    invoke-static v8, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v8
    invoke-direct v9, v0, v8, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    instance-of v8, v7, Landroid/app/Activity;
    if-nez v8, +007h
    const/high16 v8, 268435456
    invoke-virtual v9, v8, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v7, v9, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
    :try_start_0x21
.end method

.method private final readString(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +033h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +02dh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +023h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +01dh
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +011h
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    move-object v0, v2
    return-object v0
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 23
    # ins_size=4
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    move-object/from16 v2, v21
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v14
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->extractPreviewUrl(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v11
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    const/4 v4, 1
    const/4 v6, 0
    if-ne v14, v3, +004h
    move v3, v4
    goto +2h
    move v3, v6
    sget-object v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v14, v7, +004h
    move v7, v4
    goto +2h
    move v7, v6
    if-nez v7, +006h
    if-nez v3, +004h
    move v15, v4
    goto +2h
    move v15, v6
    if-eqz v3, +00ah
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_failed I
    invoke-virtual v1, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v10, v1
    goto +11h
    if-eqz v7, +009h
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_opened I
    invoke-virtual v1, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    goto -ah
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_opening I
    invoke-virtual v1, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    goto -11h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v14, v1, +004h
    move v1, v4
    goto +2h
    move v1, v6
    if-nez v7, +007h
    if-eqz v1, +003h
    goto +3h
    move v1, v6
    goto +2h
    move v1, v4
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "[OpenPreviewCard] onCreateDetail: name="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", status="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", url="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "AgentTool"
    invoke-virtual v7, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_open_preview_web_fail I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_open_preview_web I
    move v8, v3
    if-eqz v1, +018h
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v4, v6
    if-nez v4, +009h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;
    move-object/from16 v1, v22
    invoke-direct v5, v11, v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V
    move-object/from16 v16, v5
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string/jumbo v7, 🌐
    const/4 v9, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v17, 100
    const/16 v18, 0
    move-object v6, v1
    invoke-direct/range v6 ... v18, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 12
    # ins_size=5
    const-string v11, "context"
    invoke-static v8, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v11, "card"
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v11, toolCallInfo
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v11
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->extractPreviewUrl(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    const/4 v2, 1
    const/4 v3, 0
    if-ne v11, v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v11, v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    const-string v5, "getString(...)"
    if-eqz v1, +00ch
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_failed I
    invoke-virtual v8, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +16h
    if-eqz v4, +00ch
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_opened I
    invoke-virtual v8, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +ah
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_opening I
    invoke-virtual v8, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    if-eqz v1, +005h
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_open_preview_web_fail I
    goto +3h
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_open_preview_web I
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    if-nez v4, +005h
    if-nez v1, +003h
    goto +2h
    move v2, v3
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v9, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v1, "[OpenPreviewCard] onUpdateCard: name="
    invoke-direct v9, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", status="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", url="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v10, "AgentTool"
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
