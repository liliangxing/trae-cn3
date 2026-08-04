# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "RunCommandDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$DYWsidvQANcRUeyPxjiWHBYGlcs(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunCommandDetailCardCreator  com.bytedance.trae.im.model.ConfirmInfo  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->buildDetailClick$lambda$10(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildDetailClick(com.bytedance.trae.im.model.ParsedToolCallInfo  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ConfirmInfo)kotlin.jvm.functions.Function1
    .registers 12
    # ins_size=5
    new-instance v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$$ExternalSyntheticLambda0;
    move-object v0, v6
    move-object v1, v9
    move-object v2, v7
    move-object v3, v11
    move-object v4, v10
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V
    return-object v6
.end method

.method private static final buildDetailClick$lambda$10(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunCommandDetailCardCreator  com.bytedance.trae.im.model.ConfirmInfo  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  android.view.View)kotlin.Unit
    .registers 22
    # ins_size=6
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    const-string/jumbo v3, v
    move-object/from16 v4, v21
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[RunCommandCard] onDetailClick: command="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v6, "AgentTool"
    invoke-virtual v3, v6, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v6, tool_name
    invoke-virtual/range v20, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v6, tool_call_click
    invoke-virtual v3, v6, v5, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-virtual/range v21, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v3
    instance-of v5, v3, Landroidx/fragment/app/FragmentActivity;
    if-eqz v5, +005h
    check-cast v3, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v3, 0
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->findBottomSheet(Landroidx/fragment/app/FragmentActivity;)Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    move-result-object v3
    if-eqz v3, +06bh
    const/4 v5, 0
    if-eqz v2, +00ah
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ConfirmInfo;->isEnterpriseCommandBlacklist()Z
    move-result v6
    const/4 v7, 1
    if-ne v6, v7, +003h
    goto +2h
    move v7, v5
    if-eqz v7, +050h
    sget-object v8, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->resolveDetailCommand(Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v21, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_command I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v21, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_output I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v12
    const/4 v13, 0
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual/range v21, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_command_high_risk_detected I
    new-array v7, v5, [Ljava/lang/Object;
    invoke-virtual v0, v1, v6, v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual/range v21, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_command_blacklist_warning I
    new-array v4, v5, [Ljava/lang/Object;
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v15
    move-object/from16 v10, v19
    invoke-virtual/range v8 ... v15, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    move-result-object v0
    goto +9h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
    move-object/from16 v2, v19
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->navigateTo(Landroidx/fragment/app/Fragment;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final buildOutputText(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v4
    goto +2h
    move-object v4, v0
    if-eqz v4, +01ah
    const-string v1, "output"
    invoke-virtual v4, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +012h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +04bh
    if-eqz v4, +02ch
    const-string/jumbo v1, stdout
    invoke-virtual v4, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +023h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +019h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +013h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    goto +2h
    move-object v1, v0
    if-nez v1, +01ch
    if-eqz v4, +01bh
    const-string/jumbo v1, stderr
    invoke-virtual v4, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +012h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v4, v0
    if-eqz v4, +008h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    return-object v0
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

.method private final resolveDetailCommand(java.lang.String  com.bytedance.trae.im.model.ConfirmInfo)java.lang.String
    .registers 14
    # ins_size=3
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v13, +065h
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ConfirmInfo;->getBlockCommandList()Ljava/util/List;
    move-result-object v13
    if-eqz v13, +05fh
    check-cast v13, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v13, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +016h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v13, Ljava/util/ArrayList;
    invoke-direct v13, Ljava/util/ArrayList;-><init>()V
    check-cast v13, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v0
    goto +2h
    const/4 v4, 0
    if-eqz v4, -018h
    invoke-interface v13, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v13, Ljava/util/List;
    goto +2h
    move-object v13, v1
    if-nez v13, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v13
    move-object v2, v13
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v0, v2
    if-eqz v0, +003h
    move-object v1, v13
    if-eqz v1, +01ah
    move-object v2, v1
    check-cast v2, Ljava/lang/Iterable;
    const-string v13, "
"
    move-object v3, v13
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 62
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    if-nez v13, +003h
    goto +2h
    move-object v12, v13
    return-object v12
.end method

.method private final resolveStatus(com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus
    .registers 5
    # ins_size=3
    const/4 v0, 0
    if-eqz v4, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ConfirmInfo;->isEnterpriseCommandBlacklist()Z
    move-result v4
    const/4 v1, 1
    if-ne v4, v1, +003h
    move v0, v1
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    return-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v3
    return-object v3
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 26
    # ins_size=4
    move-object/from16 v0, v22
    move-object/from16 v1, v23
    move-object/from16 v2, v24
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    const/4 v6, 0
    if-eqz v25, +007h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v7
    goto +2h
    move-object v7, v6
    if-eqz v7, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ConfirmInfo;->isEnterpriseCommandBlacklist()Z
    move-result v8
    if-ne v8, v4, +004h
    move v8, v4
    goto +2h
    move v8, v5
    invoke-direct v0, v2, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->resolveStatus(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v15
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-eqz v9, +00ah
    const-string v10, "command"
    invoke-virtual v9, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-nez v9, +010h
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-eqz v9, +009h
    const-string v10, "cmd"
    invoke-virtual v9, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    goto +2h
    move-object v9, v6
    if-eqz v9, +012h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v6
    if-eqz v9, +008h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    move-object v14, v9
    goto +2h
    move-object v14, v6
    sget-object v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v15, v9, +017h
    if-eqz v25, +010h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v9
    if-eqz v9, +00ah
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v9
    if-ne v9, v4, +004h
    move v9, v4
    goto +2h
    move v9, v5
    if-eqz v9, +004h
    move v9, v4
    goto +2h
    move v9, v5
    const-string v10, "getString(...)"
    if-eqz v8, +026h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_canceled I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    sget-object v6, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v8, "getResources(...)"
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_command_blocked I
    new-array v9, v5, [Ljava/lang/Object;
    invoke-virtual v6, v1, v8, v9, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    move-object v13, v3
    move v11, v4
    move v12, v5
    move/from16 v18, v12
    goto +58h
    if-eqz v3, +03fh
    if-eqz v9, +003h
    goto +3bh
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v8
    aget v3, v3, v8
    if-eq v3, v4, +01fh
    const/4 v4, 2
    if-eq v3, v4, +00eh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_canceled I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    goto +ch
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_ran I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    move-object v13, v1
    move v11, v3
    goto -2fh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_failed I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    move-object v13, v1
    move v11, v3
    move v12, v4
    move/from16 v18, v5
    goto +19h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_running I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    if-eqz v9, +008h
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v1, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    move-object v13, v3
    move/from16 v18, v4
    move v12, v5
    move v11, v8
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->buildOutputText(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v2, v14, v1, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->buildDetailClick(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo;)Lkotlin/jvm/functions/Function1;
    move-result-object v19
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[RunCommandCard] onCreateDetail: name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", status="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", command="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "AgentTool"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v10, ""
    const/16 v16, 0
    const/16 v20, 64
    const/16 v21, 0
    move-object v9, v1
    move-object v2, v15
    move-object v15, v6
    move-object/from16 v17, v2
    invoke-direct/range v9 ... v21, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 21
    # ins_size=5
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v19
    const-string v4, "context"
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "card"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v4, toolCallInfo
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 1
    if-eqz v4, +004h
    move v4, v5
    goto +2h
    const/4 v4, 0
    if-eqz v20, +007h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v8
    goto +2h
    const/4 v8, 0
    if-eqz v8, +00ah
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ConfirmInfo;->isEnterpriseCommandBlacklist()Z
    move-result v9
    if-ne v9, v5, +004h
    move v9, v5
    goto +2h
    const/4 v9, 0
    invoke-direct v0, v3, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->resolveStatus(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v10
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v11
    if-eqz v11, +00ah
    const-string v12, "command"
    invoke-virtual v11, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-nez v11, +010h
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v11
    if-eqz v11, +009h
    const-string v12, "cmd"
    invoke-virtual v11, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    goto +2h
    const/4 v11, 0
    if-eqz v11, +011h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    const/4 v11, 0
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    goto +2h
    const/4 v11, 0
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v10, v12, +017h
    if-eqz v20, +010h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v12
    if-eqz v12, +00ah
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v12
    if-ne v12, v5, +004h
    move v12, v5
    goto +2h
    const/4 v12, 0
    if-eqz v12, +004h
    move v12, v5
    goto +2h
    const/4 v12, 0
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v15, "[RunCommandCard] onUpdateCard: name="
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v14, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v14, ", status="
    invoke-virtual v7, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v5, ", command="
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v6, "AgentTool"
    invoke-virtual v13, v6, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v7, "getString(...)"
    if-eqz v9, +035h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_canceled I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v2, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    const/4 v4, 0
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    sget-object v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual/range v17, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v9, "getResources(...)"
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_command_blocked I
    new-array v4, v4, [Ljava/lang/Object;
    invoke-virtual v7, v1, v9, v4, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    goto/16 +0a1h
    if-eqz v4, +075h
    if-eqz v12, +003h
    goto +71h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v9
    aget v4, v4, v9
    const/4 v9, 1
    if-eq v4, v9, +045h
    const/4 v9, 2
    if-eq v4, v9, +022h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_canceled I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v2, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    const/4 v4, 0
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    const/4 v9, 0
    invoke-virtual v2, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    goto +6dh
    const/4 v4, 0
    const/4 v9, 0
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_ran I
    invoke-virtual v1, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v2, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v2, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    goto +4dh
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_failed I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v2, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    const/4 v4, 0
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    const/4 v9, 0
    invoke-virtual v2, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    goto +2bh
    const/4 v4, 0
    const/4 v9, 0
    sget v13, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_running I
    invoke-virtual v1, v13, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v13, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v2, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_terminal I
    invoke-virtual v2, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    const/4 v4, 1
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    if-eqz v12, +009h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v9
    invoke-virtual v2, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v2, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->buildOutputText(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v3, v11, v1, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;->buildDetailClick(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo;)Lkotlin/jvm/functions/Function1;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setOnDetailClick(Lkotlin/jvm/functions/Function1;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
