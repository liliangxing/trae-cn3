# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "EnvironmentSetupDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$ySp_EHfmRpZVc3UwrNOshS5GlWw(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EnvironmentSetupDetailCardCreator  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;->onCreateDetail$lambda$5(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
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

.method private static final onCreateDetail$lambda$5(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EnvironmentSetupDetailCardCreator  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 16
    # ins_size=3
    const-string/jumbo v0, v
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "AgentTool"
    const-string v2, "[EnvironmentSetupCard] onDetailClick"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, tool_name
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v2, tool_call_click
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    instance-of v1, v0, Landroidx/fragment/app/FragmentActivity;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    move-object v0, v2
    invoke-direct v13, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;->findBottomSheet(Landroidx/fragment/app/FragmentActivity;)Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    move-result-object v13
    if-eqz v13, +090h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v14
    if-eqz v14, +007h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v14
    goto +2h
    move-object v14, v2
    if-eqz v14, +01ah
    const-string v0, "output"
    invoke-virtual v14, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +04ch
    if-eqz v14, +02ch
    const-string/jumbo v0, stdout
    invoke-virtual v14, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +023h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +019h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    move-object v0, v2
    check-cast v0, Ljava/lang/String;
    goto +2h
    move-object v0, v2
    if-nez v0, +01dh
    if-eqz v14, +019h
    const-string/jumbo v0, stderr
    invoke-virtual v14, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v14
    if-eqz v14, +010h
    invoke-virtual v14, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v14, v2
    if-eqz v14, +006h
    invoke-virtual v14, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    move-object v5, v2
    goto +2h
    move-object v5, v0
    sget-object v3, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
    const/4 v4, 0
    const/4 v6, 0
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_output I
    invoke-virtual v14, v15, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 96
    const/4 v12, 0
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    move-result-object v14
    check-cast v14, Landroidx/fragment/app/Fragment;
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->navigateTo(Landroidx/fragment/app/Fragment;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 24
    # ins_size=4
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    const-string v2, "context"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, toolCallInfo
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    sget-object v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v15
    const-string v5, "getString(...)"
    if-nez v2, +013h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_env_setting_up I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->environment_repair I
    move-object v11, v0
    move v9, v2
    move/from16 v16, v3
    move v10, v4
    goto +2eh
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v6
    aget v2, v2, v6
    if-ne v2, v3, +015h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_env_failed I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    move-object v11, v0
    move v9, v2
    move v10, v3
    move/from16 v16, v4
    goto +11h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_env_set_up I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->environment_repair I
    move-object v11, v0
    move v9, v2
    move v10, v4
    move/from16 v16, v10
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0;
    move-object/from16 v2, v20
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "[EnvironmentSetupCard] onCreateDetail: name="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", status="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v4, "AgentTool"
    invoke-virtual v3, v4, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v8, ""
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v18, 64
    const/16 v19, 0
    move-object v7, v1
    move-object/from16 v17, v0
    invoke-direct/range v7 ... v19, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 11
    # ins_size=5
    const-string v10, "context"
    invoke-static v7, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v10, "card"
    invoke-static v8, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v10, toolCallInfo
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v10
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v10, +004h
    move v10, v0
    goto +2h
    move v10, v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v2
    const-string v3, "getString(...)"
    if-nez v10, +01ah
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_env_setting_up I
    invoke-virtual v7, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->environment_repair I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +3ch
    sget-object v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v5
    aget v10, v10, v5
    if-ne v10, v0, +01ch
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_env_failed I
    invoke-virtual v7, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +18h
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_env_set_up I
    invoke-virtual v7, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->environment_repair I
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v8, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v8, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v10, "[EnvironmentSetupCard] onUpdateCard: name="
    invoke-direct v8, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", status="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "AgentTool"
    invoke-virtual v7, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
