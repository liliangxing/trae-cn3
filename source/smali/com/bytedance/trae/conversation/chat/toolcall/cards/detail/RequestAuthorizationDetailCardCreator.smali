# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "RequestAuthorizationDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$Companion;
.field public static final SERVICE_SEPARATOR:Ljava/lang/String;


.method public static synthetic $r8$lambda$AQkKvdd85JJ2AELUIqo91ZNMuFk(java.lang.String)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;->displayName$lambda$4(Ljava/lang/String;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final displayName(java.lang.String)java.lang.String
    .registers 12
    # ins_size=2
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    sparse-switch v1, +0000093h
    goto +34h
    const-string v1, "dingtalk"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2bh
    const-string v11, "DingTalk"
    goto/16 +083h
    const-string/jumbo v1, wecom
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1dh
    const-string v11, "WeCom"
    goto/16 +075h
    const-string v1, "lark"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +10h
    const-string v11, "Lark"
    goto +68h
    const-string v1, "feishu"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +4h
    const-string v11, "Feishu"
    goto +5ch
    invoke-static v11, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v11
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v11, 2
    new-array v1, v11, [C
    fill-array-data v1, +0000060h
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, -015h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v11, " "
    move-object v2, v11
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$$ExternalSyntheticLambda0;-><init>()V
    const/16 v8, 30
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    return-object v11
    sparse-switch-payload -4c30f30a 32926e 6bc57f3 7fa92aa
    fill-array-data-payload b'-\x00_\x00' | \x2d\x00\x5f\x00
.end method

.method private static final displayName$lambda$4(java.lang.String)java.lang.CharSequence
    .registers 6
    # ins_size=1
    const-string/jumbo v0, word
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +039h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, v2, Ljava/lang/String;->charAt(I)C
    move-result v2
    invoke-static v2, Ljava/lang/Character;->isLowerCase(C)Z
    move-result v3
    if-eqz v3, +00eh
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v4, "ROOT"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lkotlin/text/CharsKt;->titlecase(C Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    goto +5h
    invoke-static v2, Ljava/lang/String;->valueOf(C)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, substring(...)
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    return-object v5
.end method

.method private final extractPluginDisplayName(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 12
    # ins_size=3
    const-string v0, ""
    const/4 v1, 0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v11
    if-eqz v11, +010h
    const-string/jumbo v2, service
    invoke-virtual v11, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v1
    if-nez v11, +003h
    move-object v11, v0
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    goto +ch
    move-exception v11
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v11
    check-cast v0, Ljava/lang/String;
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    const-string v8, "Authorization"
    if-eqz v11, +003h
    return-object v8
    const-string v3, "::"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v11
    const/4 v2, 0
    if-lez v11, +00ch
    invoke-virtual v0, v2, v11, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v11, substring(...)
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->getCachedLocalizedDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    move-object v3, v11
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 1
    if-eqz v3, +008h
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    move v2, v4
    if-nez v2, +003h
    return-object v11
    const/16 v11, 58
    const/4 v2, 2
    invoke-static v0, v11, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;->localizedDisplayName(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    move-object v11, v10
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    xor-int/2addr v11, v4
    if-eqz v11, +003h
    move-object v1, v10
    if-nez v1, +003h
    goto +2h
    move-object v8, v1
    return-object v8
    :try_start_0x3
.end method

.method private final localizedDisplayName(android.content.Context  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Configuration;->getLocales()Landroid/os/LocaleList;
    move-result-object v4
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/os/LocaleList;->get(I)Ljava/util/Locale;
    move-result-object v4
    invoke-virtual v4, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v4
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, zh
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +03fh
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v4
    sparse-switch v4, +000003eh
    goto +31h
    const-string v4, "dingtalk"
    invoke-virtual v0, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +28h
    const-string/jumbo v4, 钉钉
    goto +28h
    const-string/jumbo v4, wecom
    invoke-virtual v0, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +01ch
    const-string/jumbo v4, 企业微信
    goto +1bh
    const-string v4, "lark"
    invoke-virtual v0, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +00ch
    goto +eh
    const-string v4, "feishu"
    invoke-virtual v0, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +5h
    const-string/jumbo v4, 飞书
    goto +5h
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;->displayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    return-object v4
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;->displayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    return-object v4
    sparse-switch-payload -4c30f30a 32926e 6bc57f3 7fa92aa
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 22
    # ins_size=4
    move-object/from16 v0, v19
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, toolCallInfo
    move-object/from16 v2, v20
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v20, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v13
    const/4 v1, 1
    const/4 v3, 0
    if-eqz v21, +010h
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v5
    if-eqz v5, +00ah
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v5
    if-ne v5, v1, +004h
    move v5, v1
    goto +2h
    move v5, v3
    invoke-direct/range v18 ... v20, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;->extractPluginDisplayName(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v10
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v6
    aget v2, v2, v6
    const-string v6, "getString(...)"
    packed-switch v2, +0000051h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_completed I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +14h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_skipped I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +ah
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_failed I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v9, v0
    move v14, v3
    move-object v11, v4
    goto +16h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_waiting I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v5, +009h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v0, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    move-object v4, v0
    move v14, v1
    move-object v9, v2
    goto -16h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v6, ""
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->explorer_file_authorization I
    const/4 v8, 0
    const/4 v12, 0
    const/4 v15, 0
    const/16 v16, 580
    const/16 v17, 0
    move-object v5, v0
    invoke-direct/range v5 ... v17, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    packed-switch-payload 1 2 3 4 5 6
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 11
    # ins_size=5
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v0
    const/4 v1, 1
    const/4 v3, 0
    if-eqz v10, +010h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v10
    if-eqz v10, +00ah
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v10
    if-ne v10, v1, +004h
    move v10, v1
    goto +2h
    move v10, v3
    invoke-direct v6, v7, v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;->extractPluginDisplayName(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v9
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v5
    aget v4, v4, v5
    const-string v5, "getString(...)"
    packed-switch v4, +0000064h
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_completed I
    invoke-virtual v7, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +41h
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_skipped I
    invoke-virtual v7, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +2eh
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_failed I
    invoke-virtual v7, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +1bh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_authorization_waiting I
    invoke-virtual v7, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-eqz v10, +008h
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v7, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    return-void 
    nop 
    packed-switch-payload 1 2 3 4 5 6
.end method
