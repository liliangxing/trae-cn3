# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;
.super Ljava/lang/Object;
.source "ToolDisplayCategory.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic buildDynamicGroupTitle$default(com.bytedance.trae.conversation.chat.grouping.ToolDisplayCategory$Companion  java.util.List  boolean  android.content.res.Resources  boolean  java.util.Set  int  java.lang.Object)java.lang.String
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 8
    if-eqz v13, +003h
    const/4 v10, 0
    move v4, v10
    and-int/lit8 v10, v12, 16
    if-eqz v10, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v11
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move v2, v8
    move-object v3, v9
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;->buildDynamicGroupTitle(Ljava/util/List; Z Landroid/content/res/Resources; Z Ljava/util/Set;)Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method public final buildDynamicGroupTitle(java.util.List  boolean  android.content.res.Resources  boolean  java.util.Set)java.lang.String
    .registers 15
    # ins_size=6
    const-string/jumbo v0, toolcalls
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resources
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, waitingConfirmIds
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v10, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +017h
    if-eqz v11, +015h
    if-eqz v13, +00ch
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_thinking I
    invoke-virtual v12, v10, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +7h
    sget-object v10, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->getRunningTitle(Landroid/content/res/Resources;)Ljava/lang/String;
    move-result-object v10
    return-object v10
    move-object v13, v10
    check-cast v13, Ljava/util/Collection;
    invoke-interface v13, Ljava/util/Collection;->isEmpty()Z
    move-result v13
    const/4 v0, 1
    xor-int/2addr v13, v0
    const/4 v1, 0
    if-eqz v13, +041h
    move-object v13, v10
    check-cast v13, Ljava/lang/Iterable;
    instance-of v2, v13, Ljava/util/Collection;
    if-eqz v2, +00dh
    move-object v2, v13
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v13, v0
    goto +2ah
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -00ah
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    if-eqz v3, +011h
    move-object v3, v14
    check-cast v3, Ljava/lang/Iterable;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    move v2, v0
    goto +2h
    move v2, v1
    if-nez v2, -022h
    move v13, v1
    if-eqz v13, +004h
    move v13, v0
    goto +2h
    move v13, v1
    if-nez v13, +019h
    invoke-static v10, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v10
    goto +2h
    const/4 v10, 0
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;->fromToolName(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    move-result-object v10
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->getRunningTitle(Landroid/content/res/Resources;)Ljava/lang/String;
    move-result-object v10
    return-object v10
    new-instance v13, Ljava/util/LinkedHashMap;
    invoke-direct v13, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v13, Ljava/util/Map;
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v14
    if-eqz v14, +027h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v9, v14, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;->fromToolName(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    move-result-object v14
    invoke-interface v13, v14, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Integer;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    goto +2h
    move v2, v1
    add-int/2addr v2, v0
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v13, v14, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -2ah
    new-instance v10, Ljava/util/LinkedHashMap;
    invoke-direct v10, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v10, Ljava/util/Map;
    invoke-interface v13, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v14
    invoke-interface v14, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02ah
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    if-ne v3, v4, +00dh
    if-eqz v11, +00bh
    invoke-interface v13, Ljava/util/Map;->size()I
    move-result v3
    if-ne v3, v0, +003h
    goto +3h
    move v3, v1
    goto +2h
    move v3, v0
    if-eqz v3, -020h
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    invoke-interface v10, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -2dh
    invoke-interface v10, Ljava/util/Map;->isEmpty()Z
    move-result v13
    const-string v14, "getString(...)"
    if-eqz v13, +00eh
    if-eqz v11, +00ch
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_thinking I
    invoke-virtual v12, v10, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v10
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/List;
    invoke-interface v10, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v10
    invoke-interface v10, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +036h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/util/Map$Entry;
    invoke-interface v13, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-interface v13, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/Number;
    invoke-virtual v13, Ljava/lang/Number;->intValue()I
    move-result v13
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->getCountType()Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->ordinal()I
    move-result v2
    aget v2, v3, v2
    if-ne v2, v0, +00ah
    invoke-virtual v1, v12, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->getSummaryTitle(Landroid/content/res/Resources;)Ljava/lang/String;
    move-result-object v13
    invoke-interface v11, v13, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -31h
    invoke-virtual v1, v12, v13, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->getCompletedTitle(Landroid/content/res/Resources; I)Ljava/lang/String;
    move-result-object v13
    invoke-interface v11, v13, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -39h
    invoke-interface v11, Ljava/util/List;->isEmpty()Z
    move-result v10
    if-eqz v10, +009h
    sget-object v10, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->getRunningTitle(Landroid/content/res/Resources;)Ljava/lang/String;
    move-result-object v10
    goto +1ch
    move-object v0, v11
    check-cast v0, Ljava/lang/Iterable;
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_group_title_separator I
    invoke-virtual v12, v10, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method public final fromToolName(java.lang.String)com.bytedance.trae.conversation.chat.grouping.ToolDisplayCategory
    .registers 6
    # ins_size=2
    if-nez v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    return-object v5
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getFILE_EDIT_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_EDIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +0e9h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getFILE_VIEW_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +0dbh
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getFILE_CREATE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_CREATE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +0cdh
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getFOLDER_VIEW_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FOLDER_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +0bfh
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getFILE_DELETE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_DELETE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +0b1h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getCOMMAND_EXEC_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->COMMAND_EXEC Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +0a3h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getMCP_TOOL_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->MCP_TOOL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +095h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getSKILL_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SKILL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +087h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getFILE_SEARCH_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +079h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getWEB_SEARCH_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->WEB_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto/16 +06bh
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getTHINKING_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto +5dh
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getPREVIEW_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->PREVIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto +50h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getTASK_MANAGE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->TASK_MANAGE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto +43h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getENV_INIT_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ENV_INIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto +36h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getASK_USER_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ASK_USER Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto +29h
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "browser_"
    const/4 v3, 0
    invoke-static v5, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01dh
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getBROWSER_USE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +11h
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->access$getSUB_AGENT_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SUB_AGENT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto +6h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    goto +3h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->BROWSER_USE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    return-object v5
.end method
