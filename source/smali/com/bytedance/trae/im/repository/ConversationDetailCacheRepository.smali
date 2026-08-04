# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
.super Ljava/lang/Object;
.source "ConversationDetailCacheRepository.kt"

.field private static final CONTENT_TYPE_CHAT_MESSAGE:Ljava/lang/String;
.field private static final CONTENT_TYPE_PARSED_CHAT_MESSAGE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
.field private static final DIFF_TAG:Ljava/lang/String;
.field private static final MAX_ROWS:I
.field private static final TAG:Ljava/lang/String;
.field private static bridge trimExecuted:Z
.field private final chatMessageGson$delegate:Lkotlin/Lazy;
.field private final dao:Lcom/bytedance/trae/im/database/ConversationDetailDao;
.field private final parsedMessageGson$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$5sn6KdgFSTnZZqIv2OJgr9s9nVQ()com.google.gson.Gson
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->parsedMessageGson_delegate$lambda$1()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xR08fIT9TE9xxQf-hItcf7c7SPI()com.google.gson.Gson
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->chatMessageGson_delegate$lambda$0()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xsdzVIVOj4GBpF-YldltDpN79xY(com.bytedance.trae.im.repository.ConversationDetailCacheRepository)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->triggerTrimOnce$lambda$8(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->Companion Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.im.database.ConversationDetailDao)void
    .registers 3
    # ins_size=2
    const-string v0, "dao"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    new-instance v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$$ExternalSyntheticLambda1;
    invoke-direct v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->chatMessageGson$delegate Lkotlin/Lazy;
    new-instance v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$$ExternalSyntheticLambda2;
    invoke-direct v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->parsedMessageGson$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private static final chatMessageGson_delegate$lambda$0()com.google.gson.Gson
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    return-object v0
.end method

.method private final deserialize(com.bytedance.trae.im.database.ConversationDetailEntity)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 7
    # ins_size=2
    const/4 v0, 0
    invoke-virtual v6, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContentType()Ljava/lang/String;
    move-result-object v1
    const-string v2, "chat_message"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +022h
    invoke-direct v5, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->getChatMessageGson()Lcom/google/gson/Gson;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContent()Ljava/lang/String;
    move-result-object v2
    const-class v4, Lcom/bytedance/trae/im/model/ChatMessage;
    invoke-virtual v1, v2, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ChatMessage;
    sget-object v2, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/im/model/ChatMessageParser;->parse(Lcom/bytedance/trae/im/model/ChatMessage;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    if-eqz v1, +051h
    invoke-virtual v1, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHistory(Z)V
    move-object v0, v1
    goto +4bh
    const-string v2, "parsed_chat_message"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +044h
    invoke-direct v5, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->getParsedMessageGson()Lcom/google/gson/Gson;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContent()Ljava/lang/String;
    move-result-object v2
    const-class v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, v2, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v1, +032h
    invoke-virtual v1, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHistory(Z)V
    invoke-direct v5, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->repairContentType(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto -22h
    move-exception v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "deserialize failed: messageId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", contentType="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v6, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContentType()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v1, Ljava/lang/Throwable;
    const-string v2, "ConvDetailCacheRepo"
    invoke-static v2, v6, v1, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v0
    :try_start_0x1
.end method

.method private final getChatMessageGson()com.google.gson.Gson
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->chatMessageGson$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/Gson;
    return-object v0
.end method

.method private final getParsedMessageGson()com.google.gson.Gson
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->parsedMessageGson$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/google/gson/Gson;
    return-object v0
.end method

.method public static synthetic loadCachedMessages$default(com.bytedance.trae.im.repository.ConversationDetailCacheRepository  java.lang.String  int  int  java.lang.Object)java.util.List
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const/16 v2, 10
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->loadCachedMessages(Ljava/lang/String; I)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private static final parsedMessageGson_delegate$lambda$1()com.google.gson.Gson
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/google/gson/GsonBuilder;
    invoke-direct v0, Lcom/google/gson/GsonBuilder;-><init>()V
    const-class v1, Ljava/lang/Object;
    check-cast v1, Ljava/lang/reflect/Type;
    new-instance v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$ParsedContentTypeAdapter;
    invoke-direct v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$ParsedContentTypeAdapter;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type; Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method private final repairContentType(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Ljava/util/Map;
    if-eqz v1, +019h
    invoke-direct v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->getChatMessageGson()Lcom/google/gson/Gson;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->getChatMessageGson()Lcom/google/gson/Gson;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    invoke-virtual v1, v0, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    invoke-virtual v4, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setContent(Ljava/lang/Object;)V
    return-void 
    :try_start_0x8
.end method

.method private final toEntity(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)com.bytedance.trae.im.database.ConversationDetailEntity
    .registers 16
    # ins_size=3
    new-instance v12, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageIndex()I
    move-result v3
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRole()Ljava/lang/String;
    move-result-object v4
    const-string v5, "parsed_chat_message"
    invoke-direct v13, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->getParsedMessageGson()Lcom/google/gson/Gson;
    move-result-object v0
    invoke-virtual v0, v15, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v0, toJson(...)
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v8
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v10
    move-object v0, v12
    move-object v1, v14
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/im/database/ConversationDetailEntity;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J J)V
    return-object v12
.end method

.method private final triggerTrimOnce()void
    .registers 3
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->trimExecuted Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->trimExecuted Z
    new-instance v0, Ljava/lang/Thread;
    new-instance v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;)V
    invoke-direct v0, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V
    invoke-virtual v0, Ljava/lang/Thread;->start()V
    return-void 
.end method

.method private static final triggerTrimOnce$lambda$8(com.bytedance.trae.im.repository.ConversationDetailCacheRepository)void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v3, v2, v0, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->trimIfNeeded$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository; I I Ljava/lang/Object;)V
    return-void 
.end method

.method public static synthetic trimIfNeeded$default(com.bytedance.trae.im.repository.ConversationDetailCacheRepository  int  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const/16 v1, 2000
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->trimIfNeeded(I)V
    return-void 
.end method

.method public final cacheNetworkMessages(java.lang.String  java.util.List)void
    .registers 19
    # ins_size=3
    move-object/from16 v13, v17
    move-object/from16 v0, v18
    const-string v1, "conversationId"
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "messages"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    move-object v14, v1
    check-cast v14, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +074h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    const/4 v2, 0
    if-nez v3, +003h
    goto +5fh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChatMessage;->getRole()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +58h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChatMessage;->getMessageIndex()Ljava/lang/Long;
    move-result-object v2
    if-eqz v2, +012h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v6
    const-wide/32 v8, -2147483648
    const-wide/32 v10, 2147483647
    invoke-static/range v6 ... v11, Lkotlin/ranges/RangesKt;->coerceIn(J J J)J
    move-result-wide v6
    long-to-int v2, v6
    goto +2h
    const/4 v2, 0
    move v4, v2
    const-string v6, "chat_message"
    invoke-direct/range v16, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->getChatMessageGson()Lcom/google/gson/Gson;
    move-result-object v2
    invoke-virtual v2, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v2, toJson(...)
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChatMessage;->getCreatedAtMs()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +015h
    invoke-static v1, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v1
    if-eqz v1, +00fh
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v1
    sget-object v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;->Companion Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
    invoke-virtual v9, v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;->normalizeToMillis(J)J
    move-result-wide v1
    goto +5h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    move-wide v9, v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    new-instance v15, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    move-object v1, v15
    move-object/from16 v2, v17
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/im/database/ConversationDetailEntity;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J J)V
    move-object v2, v15
    if-eqz v2, -072h
    invoke-interface v14, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -77h
    check-cast v14, Ljava/util/List;
    move-object/from16 v1, v16
    iget-object v0, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v13, v14, Lcom/bytedance/trae/im/database/ConversationDetailDao;->replaceAllForConversation(Ljava/lang/String; Ljava/util/List;)V
    goto +1ch
    move-exception v0
    goto +4h
    move-exception v0
    move-object/from16 v1, v16
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "cacheNetworkMessages failed: conversationId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v0, Ljava/lang/Throwable;
    const-string v3, "ConvDetailCacheRepo"
    invoke-static v3, v2, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0xe
    :try_start_0x98
.end method

.method public final cacheParsedMessage(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 6
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->Companion Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
    const-string v1, "WRITE_cache"
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v1, v2, v5, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->access$dumpParsedMessageFields(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->toEntity(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v4, Lcom/bytedance/trae/im/database/ConversationDetailDao;->insertOrReplace(Lcom/bytedance/trae/im/database/ConversationDetailEntity;)V
    goto +1ch
    move-exception v4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "cacheParsedMessage failed: messageId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    check-cast v4, Ljava/lang/Throwable;
    const-string v0, "ConvDetailCacheRepo"
    invoke-static v0, v5, v4, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0xa
.end method

.method public final deleteAll()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/ConversationDetailDao;->deleteAll()V
    goto +bh
    move-exception v0
    const-string v1, "deleteAll failed"
    check-cast v0, Ljava/lang/Throwable;
    const-string v2, "ConvDetailCacheRepo"
    invoke-static v2, v1, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x0
.end method

.method public final deleteByConversationId(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v4, Lcom/bytedance/trae/im/database/ConversationDetailDao;->deleteByConversationId(Ljava/lang/String;)V
    goto +18h
    move-exception v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "deleteByConversationId failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v0, Ljava/lang/Throwable;
    const-string v1, "ConvDetailCacheRepo"
    invoke-static v1, v4, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x5
.end method

.method public final deleteUserMessage(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/im/database/ConversationDetailDao;->deleteByMessageId(Ljava/lang/String; Ljava/lang/String;)V
    goto +18h
    move-exception v3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "deleteUserMessage failed: messageId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v3, Ljava/lang/Throwable;
    const-string v0, "ConvDetailCacheRepo"
    invoke-static v0, v4, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0xa
.end method

.method public final deleteUserMessages(java.lang.String  java.util.List)void
    .registers 5
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageIds"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/im/database/ConversationDetailDao;->deleteByMessageIds(Ljava/lang/String; Ljava/util/List;)V
    goto +1ch
    move-exception v3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "deleteUserMessages failed: count="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v3, Ljava/lang/Throwable;
    const-string v0, "ConvDetailCacheRepo"
    invoke-static v0, v4, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0xa
.end method

.method public final loadCachedMessages(java.lang.String  int)java.util.List
    .registers 8
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v6, v7, Lcom/bytedance/trae/im/database/ConversationDetailDao;->queryLatest(Ljava/lang/String; I)Ljava/util/List;
    move-result-object v7
    move-object v0, v7
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +02ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    invoke-virtual v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContentType()Ljava/lang/String;
    move-result-object v2
    const-string v3, "parsed_chat_message"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -016h
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v2
    if-eqz v2, -01eh
    sget-object v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->Companion Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
    const-string v3, "READ_raw"
    invoke-virtual v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContent()Ljava/lang/String;
    move-result-object v1
    invoke-static v2, v3, v4, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->access$dumpRawJsonFields(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto -2fh
    check-cast v7, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +012h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    invoke-direct v5, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->deserialize(Lcom/bytedance/trae/im/database/ConversationDetailEntity;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    if-eqz v1, -010h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ch
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v2
    if-eqz v2, -012h
    sget-object v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->Companion Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
    const-string v3, "READ_parsed"
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v3, v4, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->access$dumpParsedMessageFields(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto -1fh
    new-instance v7, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$loadCachedMessages$$inlined$sortedBy$1;
    invoke-direct v7, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$loadCachedMessages$$inlined$sortedBy$1;-><init>()V
    check-cast v7, Ljava/util/Comparator;
    invoke-static v0, v7, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v7
    sget-object v0, Lcom/bytedance/trae/im/model/ChatMessageParser;->INSTANCE Lcom/bytedance/trae/im/model/ChatMessageParser;
    invoke-virtual v0, v7, Lcom/bytedance/trae/im/model/ChatMessageParser;->normalizeDisplayableHistoryMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v7
    invoke-direct v5, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->triggerTrimOnce()V
    goto +1ch
    move-exception v7
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "loadCachedMessages failed: conversationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v7, Ljava/lang/Throwable;
    const-string v0, "ConvDetailCacheRepo"
    invoke-static v0, v6, v7, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v7
    return-object v7
    :try_start_0x5
.end method

.method public final replaceUserMessage(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 7
    # ins_size=4
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "oldMessageId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->Companion Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
    const-string v1, "WRITE_replace"
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v1, v2, v6, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->access$dumpParsedMessageFields(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/im/database/ConversationDetailDao;->deleteByMessageId(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v3, v4, v6, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->toEntity(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v0, v4, Lcom/bytedance/trae/im/database/ConversationDetailDao;->insertOrReplace(Lcom/bytedance/trae/im/database/ConversationDetailEntity;)V
    goto +27h
    move-exception v4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, replaceUserMessage failed: old=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, ", new="
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    check-cast v4, Ljava/lang/Throwable;
    const-string v6, "ConvDetailCacheRepo"
    invoke-static v6, v5, v4, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0xf
.end method

.method public final trimIfNeeded(int)void
    .registers 5
    # ins_size=2
    const-string v0, "ConvDetailCacheRepo"
    const-string/jumbo v1, trimIfNeeded: removed 
    iget-object v2, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->dao Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-virtual v2, v4, Lcom/bytedance/trae/im/database/ConversationDetailDao;->trimOldConversations(I)I
    move-result v4
    if-lez v4, +022h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, " stale conversation(s)"
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    goto +ah
    move-exception v4
    const-string/jumbo v1, trimIfNeeded failed
    check-cast v4, Ljava/lang/Throwable;
    invoke-static v0, v1, v4, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x5
.end method
