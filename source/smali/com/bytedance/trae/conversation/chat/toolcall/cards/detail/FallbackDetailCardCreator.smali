# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "FallbackDetailCardCreator.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$Companion;
.field private static final MAX_DISPLAY_LENGTH:I
.field private static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$0oTzrMMcQMCTmWuS6ey4g32d0r8(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.FallbackDetailCardCreator  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->onCreateDetail$lambda$1(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final extractResultSummary(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +095h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +08dh
    const-string v1, "output"
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +012h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +048h
    const-string/jumbo v1, stdout
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +023h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +019h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +013h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    move-object v1, v2
    check-cast v1, Ljava/lang/String;
    goto +2h
    move-object v1, v2
    if-nez v1, +01bh
    const-string/jumbo v1, stderr
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    const/16 v3, 100
    if-eqz v1, +007h
    invoke-static v1, v3, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v5
    return-object v5
    const-string/jumbo v1, result
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +010h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +007h
    invoke-static v2, v3, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v5
    return-object v5
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v5
    return-object v5
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private final findBottomSheet(androidx.fragment.app.FragmentActivity)com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string v1, "ProcessDetailBottomSheet"
    invoke-virtual v3, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    instance-of v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    if-eqz v1, +005h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    return-object v0
.end method

.method private final formatJson(com.google.gson.JsonObject)java.lang.String
    .registers 4
    # ins_size=2
    if-eqz v3, +023h
    invoke-virtual v3, Lcom/google/gson/JsonObject;->size()I
    move-result v0
    if-nez v0, +003h
    goto +1bh
    new-instance v0, Lcom/google/gson/GsonBuilder;
    invoke-direct v0, Lcom/google/gson/GsonBuilder;-><init>()V
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->setPrettyPrinting()Lcom/google/gson/GsonBuilder;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v0
    move-object v1, v3
    check-cast v1, Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v3
    goto +5h
    invoke-virtual v3, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
    const/4 v3, 0
    return-object v3
    :try_start_0x9
.end method

.method private static final onCreateDetail$lambda$1(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.FallbackDetailCardCreator  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 16
    # ins_size=6
    const-string/jumbo v0, v
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[FallbackCard] onDetailClick: toolName="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentTool"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, tool_name
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v1, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v14, tool_call_click
    invoke-virtual v0, v14, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v14
    instance-of v0, v14, Landroidx/fragment/app/FragmentActivity;
    if-eqz v0, +005h
    check-cast v14, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v14, 0
    invoke-direct v11, v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->findBottomSheet(Landroidx/fragment/app/FragmentActivity;)Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    move-result-object v11
    if-eqz v11, +029h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_input I
    invoke-virtual v14, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_output I
    invoke-virtual v14, v15, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 96
    const/4 v9, 0
    move-object v1, v12
    move-object v2, v13
    move-object v5, v10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    move-result-object v10
    check-cast v10, Landroidx/fragment/app/Fragment;
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->navigateTo(Landroidx/fragment/app/Fragment;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 26
    # ins_size=4
    move-object/from16 v6, v22
    move-object/from16 v0, v23
    move-object/from16 v7, v24
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, toolCallInfo
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    const/4 v8, 0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v8
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v15
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, "Tool"
    move-object v9, v4
    if-eqz v25, +010h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v4
    if-eqz v4, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v4
    if-ne v4, v2, +004h
    move v4, v2
    goto +2h
    move v4, v3
    const-string v5, "getString(...)"
    if-nez v1, +01bh
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_calling I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v4, +009h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v8
    move-object/from16 v16, v0
    move-object v13, v1
    move/from16 v18, v2
    goto +19h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v4
    aget v1, v1, v4
    if-ne v1, v2, +012h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_failed I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v13, v0
    move/from16 v18, v3
    move-object/from16 v16, v8
    move-object v14, v9
    goto +14h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_called I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->extractResultSummary(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v1
    move-object v13, v0
    move-object v14, v1
    move/from16 v18, v3
    move-object/from16 v16, v8
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->formatJson(Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v0
    const/16 v1, 1000
    if-eqz v0, +008h
    invoke-static v0, v1, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    goto +2h
    move-object v3, v8
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    goto +2h
    move-object v0, v8
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->formatJson(Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +008h
    invoke-static v0, v1, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    move-object v4, v0
    goto +2h
    move-object v4, v8
    if-nez v3, +004h
    if-eqz v4, +00dh
    new-instance v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;
    move-object v0, v8
    move-object v1, v9
    move-object/from16 v2, v22
    move-object/from16 v5, v24
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V
    move-object/from16 v19, v8
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[FallbackCard] onCreateDetail: name="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", toolName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentTool"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v10, ""
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_mcp I
    const/4 v12, 0
    const/4 v1, 0
    const/16 v20, 68
    const/16 v21, 0
    move-object v9, v0
    move-object v2, v15
    move-object/from16 v15, v16
    move-object/from16 v16, v1
    move-object/from16 v17, v2
    invoke-direct/range v9 ... v21, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 12
    # ins_size=5
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v3
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, "Tool"
    if-eqz v11, +010h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v11
    if-eqz v11, +00ah
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v11
    if-ne v11, v1, +004h
    move v11, v1
    goto +2h
    move v11, v2
    const-string v6, "getString(...)"
    if-nez v0, +020h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_calling I
    invoke-virtual v8, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v9, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    if-eqz v11, +008h
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v8, v11, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v9, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v9, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +3ah
    sget-object v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v0
    aget v11, v11, v0
    if-ne v11, v1, +018h
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_failed I
    invoke-virtual v8, v11, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v9, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v9, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    goto +1ah
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_called I
    invoke-virtual v8, v11, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->extractResultSummary(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v9, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v9, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v11, "[FallbackCard] onUpdateCard: name="
    invoke-direct v9, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", status="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", toolName="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v10, "AgentTool"
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
