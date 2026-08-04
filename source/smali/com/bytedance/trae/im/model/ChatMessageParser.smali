# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ChatMessageParser;
.super Ljava/lang/Object;
.source "ChatMessageParser.kt"

.field private static final APPEND_INPUT_TYPE:Ljava/lang/String;
.field private static final APPEND_USER_CONTEXT_KEY:Ljava/lang/String;
.field private static final CHRONOLOGICAL_MESSAGE_COMPARATOR:Ljava/util/Comparator;
.field public static final INSTANCE:Lcom/bytedance/trae/im/model/ChatMessageParser;
.field private static final TAG:Ljava/lang/String;
.field private static final gson$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$5hN4iyg7R-5QJ_Uj8qeuR7tThps()com.google.gson.Gson
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/im/model/ChatMessageParser;->gson_delegate$lambda$0()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-direct v0, Lcom/bytedance/trae/im/model/ChatMessageParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    new-instance v0, Lcom/bytedance/trae/im/model/ChatMessageParser$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/im/model/ChatMessageParser$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->gson$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/im/model/ChatMessageParser$special$$inlined$compareBy$1;
    invoke-direct v0, Lcom/bytedance/trae/im/model/ChatMessageParser$special$$inlined$compareBy$1;-><init>()V
    check-cast v0, Ljava/util/Comparator;
    new-instance v1, Lcom/bytedance/trae/im/model/ChatMessageParser$special$$inlined$thenBy$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/im/model/ChatMessageParser$special$$inlined$thenBy$1;-><init>(Ljava/util/Comparator;)V
    check-cast v1, Ljava/util/Comparator;
    sput-object v1, Lcom/bytedance/trae/im/model/ChatMessageParser;->CHRONOLOGICAL_MESSAGE_COMPARATOR Ljava/util/Comparator;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final applyAppendInterjectionState(java.util.List)void
    .registers 12
    # ins_size=2
    check-cast v11, Ljava/lang/Iterable;
    sget-object v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->CHRONOLOGICAL_MESSAGE_COMPARATOR Ljava/util/Comparator;
    invoke-static v11, v0, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v11
    move-object v0, v11
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    move v2, v1
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +09dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    add-int/lit8 v4, v2, 1
    if-gez v2, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v5
    if-eqz v5, +00dh
    sget-object v5, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-direct v5, v3, Lcom/bytedance/trae/im/model/ChatMessageParser;->hasAppendInput(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v6
    if-eqz v6, +005h
    invoke-direct v5, v3, Lcom/bytedance/trae/im/model/ChatMessageParser;->markInterjected(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v5
    if-eqz v5, +017h
    sget-object v5, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getUserMessageContext()Lcom/google/gson/JsonObject;
    move-result-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/im/model/ChatMessageParser;->isAppendUserMessage(Lcom/google/gson/JsonObject;)Z
    move-result v6
    if-eqz v6, +00bh
    invoke-direct v5, v11, v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->findPreviousAssistant(Ljava/util/List; I)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v6
    if-eqz v6, +005h
    invoke-direct v5, v6, Lcom/bytedance/trae/im/model/ChatMessageParser;->markInterjected(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v5
    if-eqz v5, +05bh
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFromAppendMsg()Ljava/lang/Boolean;
    move-result-object v5
    const/4 v6, 1
    invoke-static v6, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v7
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +04ch
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v3
    const/4 v5, 0
    if-eqz v3, +034h
    invoke-interface v11, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v7
    move v8, v1
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +016h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +003h
    goto +5h
    add-int/lit8 v8, v8, 1
    goto -19h
    const/4 v8, -1
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    move-object v7, v3
    check-cast v7, Ljava/lang/Number;
    invoke-virtual v7, Ljava/lang/Number;->intValue()I
    move-result v7
    if-ltz v7, +003h
    goto +2h
    move v6, v1
    if-eqz v6, +003h
    move-object v5, v3
    if-eqz v5, +006h
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v2
    sget-object v3, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-direct v3, v11, v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->findPreviousAssistant(Ljava/util/List; I)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    if-eqz v2, +005h
    invoke-direct v3, v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->markInterjected(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    move v2, v4
    goto/16 -09fh
    return-void 
.end method

.method private final extractTextFromArray(com.google.gson.JsonArray)java.lang.String
    .registers 12
    # ins_size=2
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +025h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/google/gson/JsonElement;
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v2
    if-eqz v2, +012h
    sget-object v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v1
    const-string v3, "getAsJsonObject(...)"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v1, Lcom/bytedance/trae/im/model/ChatMessageParser;->extractTextFromObject(Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-eqz v1, -023h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -28h
    check-cast v0, Ljava/util/List;
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v11, "
"
    move-object v2, v11
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +004h
    const-string v11, ""
    check-cast v11, Ljava/lang/String;
    return-object v11
.end method

.method private final extractTextFromObject(com.google.gson.JsonObject)java.lang.String
    .registers 5
    # ins_size=2
    const-string/jumbo v0, type
    invoke-virtual v4, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    const-string/jumbo v2, text
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +019h
    const-string/jumbo v0, text_content
    invoke-virtual v4, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +010h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private final findPreviousAssistant(java.util.List  int)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 6
    # ins_size=3
    const/4 v0, 0
    if-gtz v5, +003h
    return-object v0
    add-int/lit8 v5, v5, -1
    const/4 v1, -1
    if-ge v1, v5, +012h
    invoke-interface v4, v5, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v2
    if-eqz v2, +003h
    return-object v1
    add-int/lit8 v5, v5, -1
    goto -12h
    return-object v0
.end method

.method private final getGson()com.google.gson.Gson
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->gson$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/Gson;
    return-object v0
.end method

.method private static final gson_delegate$lambda$0()com.google.gson.Gson
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    return-object v0
.end method

.method private final hasAppendInput(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v5
    const/4 v0, 0
    if-eqz v5, +03ah
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +034h
    check-cast v5, Ljava/lang/Iterable;
    instance-of v1, v5, Ljava/util/Collection;
    const/4 v2, 1
    if-eqz v1, +00dh
    move-object v1, v5
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v5, v0
    goto +1eh
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getType()Ljava/lang/String;
    move-result-object v1
    const-string v3, "append_input"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -016h
    move v5, v2
    if-ne v5, v2, +003h
    move v0, v2
    return v0
.end method

.method private final isAppendUserMessage(com.google.gson.JsonObject)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-eqz v3, +046h
    const-string v1, "is_append_msg"
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-nez v3, +003h
    goto +3ch
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v3
    invoke-virtual v3, Lcom/google/gson/JsonPrimitive;->getAsBoolean()Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    move v3, v0
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v3, v0
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    return v3
    return v0
    :try_start_0xc
.end method

.method private final isDisplayableHistoryMessage(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    if-eqz v0, +023h
    const-string v0, "in_progress"
    const-string v1, "queuing"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    return v3
.end method

.method private final markInterjected(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 3
    # ins_size=2
    const/4 v0, 1
    invoke-virtual v2, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setInterjected(Z)V
    return-void 
.end method

.method private final parseContent(java.lang.String  java.lang.String)java.lang.Object
    .registers 8
    # ins_size=3
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v1
    goto +2h
    move v3, v2
    const/4 v4, 0
    if-eqz v3, +003h
    return-object v4
    const-string/jumbo v3, user
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +007h
    invoke-direct v5, v6, Lcom/bytedance/trae/im/model/ChatMessageParser;->parseUserContent(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    goto +3ch
    const-string v3, "assistant"
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +035h
    if-eqz v0, +008h
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    move v1, v2
    if-eqz v1, +004h
    move-object v6, v4
    goto +27h
    invoke-direct v5, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v7
    const-class v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    invoke-virtual v7, v6, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    goto +1ch
    move-exception v7
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, safeParse<ParsedTaskContent> failed: 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v7, Ljava/lang/Throwable;
    const-string v0, "ChatMessageParser"
    invoke-static v0, v6, v7, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -27h
    return-object v6
    :try_start_0x38
.end method

.method private final parseNotifications(java.lang.String)java.util.List
    .registers 12
    # ins_size=2
    const-string v0, "ChatMessageParser"
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v3
    goto +2h
    move v1, v2
    const/4 v4, 0
    if-eqz v1, +003h
    return-object v4
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v5, "["
    const/4 v6, 2
    invoke-static v1, v5, v3, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +0aah
    invoke-direct v10, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v5
    const-class v6, Lcom/google/gson/JsonArray;
    invoke-virtual v5, v1, v6, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/google/gson/JsonArray;
    if-eqz v1, +0ceh
    check-cast v1, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +085h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/google/gson/JsonElement;
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +05ch
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v7
    invoke-virtual v7, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v7
    if-eqz v7, +052h
    sget-object v7, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    move-object v8, v6
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +3h
    move v8, v3
    goto +2h
    move v8, v2
    if-eqz v8, +004h
    move-object v6, v4
    goto +35h
    invoke-direct v7, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v7
    const-class v8, Lcom/bytedance/trae/im/model/NotificationPayload;
    invoke-virtual v7, v6, v8, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    goto +2ah
    move-exception v7
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v9, safeParse<
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-class v9, Lcom/bytedance/trae/im/model/NotificationPayload;
    const-string v9, "NotificationPayload"
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, "> failed: "
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v7, Ljava/lang/Throwable;
    invoke-static v0, v6, v7, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -35h
    check-cast v6, Lcom/bytedance/trae/im/model/NotificationPayload;
    goto +17h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v7
    if-eqz v7, +011h
    sget-object v7, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-direct v7, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v7
    const-class v8, Lcom/bytedance/trae/im/model/NotificationPayload;
    invoke-virtual v7, v6, v8, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/NotificationPayload;
    goto +2h
    move-object v6, v4
    if-eqz v6, -082h
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -087h
    check-cast v5, Ljava/util/List;
    move-object v4, v5
    goto +33h
    const-string/jumbo v2, {
    invoke-static v1, v2, v3, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +02bh
    invoke-direct v10, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v2
    const-class v3, Lcom/bytedance/trae/im/model/NotificationPayload;
    invoke-virtual v2, v1, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/NotificationPayload;
    if-eqz v1, +01dh
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    move-object v4, v11
    goto +16h
    move-exception v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "parseNotifications failed: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    check-cast v1, Ljava/lang/Throwable;
    invoke-static v0, v11, v1, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v4
    :try_start_0x17
    :try_start_0x7b
    :try_start_0x87
.end method

.method private final parseUserContent(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, {
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00bh
    const-string v1, "["
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return-object v6
    invoke-direct v5, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v1
    const-class v2, Lcom/google/gson/JsonElement;
    invoke-virtual v1, v0, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonElement;
    if-eqz v0, +034h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v1
    if-eqz v1, +003h
    goto +2ch
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v1
    if-eqz v1, +010h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v6
    const-string v0, "getAsJsonArray(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/im/model/ChatMessageParser;->extractTextFromArray(Lcom/google/gson/JsonArray;)Ljava/lang/String;
    move-result-object v6
    return-object v6
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +013h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
    const-string v1, "getAsJsonObject(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->extractTextFromObject(Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v6, v0
    return-object v6
    :try_start_0x20
.end method

.method private final synthetic safeParse(java.lang.String)java.lang.Object
    .registers 8
    # ins_size=2
    const-string v0, "T"
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v1, +003h
    return-object v2
    const/4 v1, 4
    invoke-direct v6, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(I Ljava/lang/String;)V
    const-class v4, Ljava/lang/Object;
    move-object v5, v4
    check-cast v5, Ljava/lang/Class;
    invoke-virtual v3, v7, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    goto +2fh
    move-exception v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParse<
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(I Ljava/lang/String;)V
    const-class v0, Ljava/lang/Object;
    move-object v1, v0
    check-cast v1, Ljava/lang/Class;
    invoke-virtual v0, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "> failed: "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    check-cast v3, Ljava/lang/Throwable;
    const-string v0, "ChatMessageParser"
    invoke-static v0, v7, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v2
    :try_start_0x16
.end method

.method private final safeParseJsonObject(java.lang.String)com.google.gson.JsonObject
    .registers 6
    # ins_size=2
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    invoke-direct v4, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v2, Lcom/google/gson/JsonObject;
    invoke-virtual v0, v5, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonObject;
    move-object v1, v0
    goto +19h
    move-exception v0
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, safeParseJsonObject failed: 
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    check-cast v0, Ljava/lang/Throwable;
    const-string v2, "ChatMessageParser"
    invoke-static v2, v5, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v1
    :try_start_0x13
.end method

.method private final synthetic safeParseList(java.lang.String)java.util.List
    .registers 9
    # ins_size=2
    const-string v0, "T"
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    const/4 v4, 0
    if-eqz v1, +003h
    return-object v4
    const/4 v1, 4
    const-class v5, Ljava/util/List;
    check-cast v5, Ljava/lang/reflect/Type;
    new-array v3, v3, [Ljava/lang/reflect/Type;
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(I Ljava/lang/String;)V
    const-class v6, Ljava/lang/Object;
    aput-object v6, v3, v2
    invoke-static v5, v3, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v2
    invoke-direct v7, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    invoke-virtual v3, v8, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    move-object v4, v2
    goto +32h
    move-exception v2
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParseList<
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(I Ljava/lang/String;)V
    const-class v0, Ljava/lang/Object;
    move-object v1, v0
    check-cast v1, Ljava/lang/Class;
    invoke-virtual v0, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "> failed: "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    check-cast v2, Ljava/lang/Throwable;
    const-string v0, "ChatMessageParser"
    invoke-static v0, v8, v2, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    move-object v8, v4
    check-cast v8, Ljava/util/List;
    return-object v4
    :try_start_0x18
.end method

.method public final normalizeDisplayableHistoryMessages(java.util.List)java.util.List
    .registers 6
    # ins_size=2
    const-string v0, "messages"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/im/model/ChatMessageParser;->applyAppendInterjectionState(Ljava/util/List;)V
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v2, 1
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHistory(Z)V
    goto -10h
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    sget-object v3, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-direct v3, v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->isDisplayableHistoryMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v2
    if-eqz v2, -013h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -18h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public final parse(com.bytedance.trae.im.model.ChatMessage)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 72
    # ins_size=2
    move-object/from16 v1, v70
    const-string v0, "dto"
    move-object/from16 v2, v71
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    const/4 v3, 0
    if-nez v4, +003h
    return-object v3
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getChatSessionId()Ljava/lang/String;
    move-result-object v0
    const-string v5, ""
    if-nez v0, +004h
    move-object v6, v5
    goto +2h
    move-object v6, v0
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getRole()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v9, v5
    goto +2h
    move-object v9, v0
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getContent()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, v9, Lcom/bytedance/trae/im/model/ChatMessageParser;->parseContent(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v15
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getQuery()Ljava/lang/String;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    const-string v10, "ChatMessageParser"
    if-eqz v0, +005h
    move-object/from16 v42, v3
    goto +39h
    const-class v0, Ljava/util/List;
    check-cast v0, Ljava/lang/reflect/Type;
    new-array v11, v7, [Ljava/lang/reflect/Type;
    const-class v12, Lcom/bytedance/trae/im/model/MessagePart;
    aput-object v12, v11, v8
    invoke-static v0, v11, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v0
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v11
    invoke-virtual v11, v5, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    goto +1ah
    move-exception v0
    new-instance v11, Ljava/lang/StringBuilder;
    const-string/jumbo v12, safeParseList<MessagePart> failed: 
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v12, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v11, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v5, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    move-object v0, v3
    move-object/from16 v42, v0
    const-string v0, "assistant"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +09bh
    instance-of v5, v15, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    if-eqz v5, +006h
    move-object v5, v15
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    goto +2h
    move-object v5, v3
    if-eqz v5, +00dh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +007h
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    goto +2h
    move v5, v8
    sget-object v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v13, "[Node2.5] Parser.parse: msgId="
    invoke-direct v12, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, ", role="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, ", contentType="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    if-eqz v15, +00dh
    invoke-virtual v15, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v3
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, ", planItemCount="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, ", agentType="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, ", agentId="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    const-string v13, "AgentDataFlow"
    invoke-virtual v11, v13, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v5, +024h
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "[Node2.5] Parser.parse WARNING: assistant message with 0 planItems! rawContent="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getContent()Ljava/lang/String;
    move-result-object v12
    if-eqz v12, +009h
    const/16 v14, 500
    invoke-static v12, v14, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v3
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v5, v13, v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getTurnId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v12
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, task
    goto +5h
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getMessageType()Ljava/lang/String;
    move-result-object v0
    move-object v13, v0
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getMessageIndex()Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +015h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v16
    const-wide/32 v18, -2147483648
    const-wide/32 v20, 2147483647
    move-object v14, v4
    invoke-static/range v16 ... v21, Lkotlin/ranges/RangesKt;->coerceIn(J J J)J
    move-result-wide v3
    long-to-int v0, v3
    move/from16 v16, v0
    goto +4h
    move-object v14, v4
    move/from16 v16, v8
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v17
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getUserMessageContext()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->safeParseJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v18
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getError()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    if-eqz v0, +004h
    const/4 v0, 0
    goto +25h
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual v0, v3, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    goto +1ah
    move-exception v0
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParse<ParsedError> failed: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v5, Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -25h
    move-object/from16 v20, v0
    check-cast v20, Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getRevertible()Ljava/lang/Boolean;
    move-result-object v21
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getVersionCode()Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +017h
    move-object v3, v0
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    const-wide/16 v23, 0
    cmp-long v3, v3, v23
    if-lez v3, +004h
    move v3, v7
    goto +2h
    move v3, v8
    if-eqz v3, +005h
    move-object/from16 v23, v0
    goto +3h
    const/16 v23, 0
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getReferences()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    if-eqz v0, +005h
    const/16 v24, 0
    goto +39h
    const-class v0, Ljava/util/List;
    check-cast v0, Ljava/lang/reflect/Type;
    new-array v4, v7, [Ljava/lang/reflect/Type;
    const-class v5, Lcom/bytedance/trae/im/model/Reference;
    aput-object v5, v4, v8
    invoke-static v0, v4, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v0
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v4
    invoke-virtual v4, v3, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    goto +1ah
    move-exception v0
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParseList<Reference> failed: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v5, Lcom/bytedance/trae/im/model/Reference;
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    const/4 v0, 0
    move-object/from16 v24, v0
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getContextMetadata()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->safeParseJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v25
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getSearchReferenceData()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    if-eqz v0, +004h
    const/4 v0, 0
    goto +25h
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/im/model/SearchReferenceData;
    invoke-virtual v0, v3, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    goto +1ah
    move-exception v0
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParse<SearchReferenceData> failed: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v5, Lcom/bytedance/trae/im/model/SearchReferenceData;
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -25h
    move-object/from16 v26, v0
    check-cast v26, Lcom/bytedance/trae/im/model/SearchReferenceData;
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getDocReferences()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    if-eqz v0, +004h
    const/4 v0, 0
    goto +25h
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-virtual v0, v3, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    goto +1ah
    move-exception v0
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParse<DocReferencesData> failed: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v5, Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -25h
    move-object/from16 v27, v0
    check-cast v27, Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v28
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v29
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getAgentName()Ljava/lang/String;
    move-result-object v30
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getAgentAvatarId()Ljava/lang/String;
    move-result-object v31
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getTraceId()Ljava/lang/String;
    move-result-object v32
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getCreatedAtMs()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +015h
    invoke-static v0, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +00fh
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    sget-object v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->Companion Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;->normalizeToMillis(J)J
    move-result-wide v3
    goto +5h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    move-wide/from16 v33, v3
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getFeeUsage()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->safeParseJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v35
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getMaxFeeUsage()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->safeParseJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v36
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getNotifications()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->parseNotifications(Ljava/lang/String;)Ljava/util/List;
    move-result-object v37
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getModelSmartSelectionMeta()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    if-eqz v0, +004h
    const/4 v0, 0
    goto +25h
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    invoke-virtual v0, v3, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    goto +1ah
    move-exception v0
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParse<ModelSmartSelectionMeta> failed: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v5, Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -25h
    move-object/from16 v38, v0
    check-cast v38, Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getFromAppendMsg()Ljava/lang/Boolean;
    move-result-object v39
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getShallowMementoType()Ljava/lang/String;
    move-result-object v40
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getChatProcessVersion()Ljava/lang/String;
    move-result-object v41
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getTokenUsage()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    if-eqz v0, +004h
    const/4 v0, 0
    goto +25h
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    invoke-virtual v0, v3, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    goto +1ah
    move-exception v0
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParse<ParsedTokenUsage> failed: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -25h
    move-object/from16 v62, v0
    check-cast v62, Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getContextUsage()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v8
    goto +2h
    move v0, v7
    if-eqz v0, +004h
    const/4 v0, 0
    goto +25h
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;
    invoke-virtual v0, v3, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    goto +1ah
    move-exception v0
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, safeParse<ParsedContextUsage> failed: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -25h
    move-object/from16 v63, v0
    check-cast v63, Lcom/bytedance/trae/im/model/ParsedContextUsage;
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getAgentProcessSupport()Ljava/lang/String;
    move-result-object v64
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree()Ljava/lang/Boolean;
    move-result-object v65
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled()Ljava/lang/Boolean;
    move-result-object v66
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getChatStartTime()Ljava/lang/Long;
    move-result-object v67
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getChatEndTime()Ljava/lang/Long;
    move-result-object v68
    invoke-virtual/range v71, Lcom/bytedance/trae/im/model/ChatMessage;->getFastRequestSavings()Ljava/lang/String;
    move-result-object v2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00ah
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +2h
    move v7, v8
    if-eqz v7, +004h
    const/4 v3, 0
    goto +26h
    invoke-direct/range v70, Lcom/bytedance/trae/im/model/ChatMessageParser;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v3, Lcom/bytedance/trae/im/model/FastRequestSavings;
    invoke-virtual v0, v2, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    goto +1ah
    move-exception v0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, safeParse<FastRequestSavings> failed: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-class v4, Lcom/bytedance/trae/im/model/FastRequestSavings;
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v10, v2, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -26h
    move-object/from16 v43, v3
    check-cast v43, Lcom/bytedance/trae/im/model/FastRequestSavings;
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, 4
    const v60, 8388352
    const/16 v61, 0
    new-instance v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v2, v0
    move-object v3, v6
    move-object v4, v14
    const/4 v5, 0
    move-object v6, v11
    move-object v7, v12
    move-object v8, v13
    move/from16 v10, v16
    move-object/from16 v11, v17
    move-object/from16 v12, v18
    move-object/from16 v13, v20
    move-object/from16 v14, v21
    move-object/from16 v69, v15
    move-object/from16 v15, v23
    move-object/from16 v16, v24
    move-object/from16 v17, v25
    move-object/from16 v18, v26
    move-object/from16 v19, v27
    move-object/from16 v20, v28
    move-object/from16 v21, v29
    move-object/from16 v22, v30
    move-object/from16 v23, v31
    move-object/from16 v24, v32
    move-wide/from16 v25, v33
    move-object/from16 v27, v35
    move-object/from16 v28, v36
    move-object/from16 v29, v37
    move-object/from16 v30, v38
    move-object/from16 v31, v39
    move-object/from16 v32, v40
    move-object/from16 v33, v41
    move-object/from16 v34, v62
    move-object/from16 v35, v63
    move-object/from16 v36, v64
    move-object/from16 v37, v65
    move-object/from16 v38, v66
    move-object/from16 v39, v67
    move-object/from16 v40, v68
    move-object/from16 v41, v69
    invoke-direct/range v2 ... v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    :try_start_0x49
    :try_start_0x178
    :try_start_0x1d9
    :try_start_0x230
    :try_start_0x26f
    :try_start_0x2f9
    :try_start_0x344
    :try_start_0x383
    :try_start_0x3d4
.end method

.method public final parseDisplayableHistoryList(java.util.List)java.util.List
    .registers 3
    # ins_size=2
    const-string v0, "messages"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->parseList(Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->normalizeDisplayableHistoryMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method public final parseList(java.util.List)java.util.List
    .registers 5
    # ins_size=2
    const-string v0, "messages"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ChatMessage;
    sget-object v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-virtual v2, v1, Lcom/bytedance/trae/im/model/ChatMessageParser;->parse(Lcom/bytedance/trae/im/model/ChatMessage;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    if-eqz v1, -012h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v0, Ljava/util/List;
    sget-object v4, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-direct v4, v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->applyAppendInterjectionState(Ljava/util/List;)V
    return-object v0
.end method
