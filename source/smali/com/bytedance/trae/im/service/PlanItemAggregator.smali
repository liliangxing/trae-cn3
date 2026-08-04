# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/service/PlanItemAggregator;
.super Ljava/lang/Object;
.source "IMMessage.kt"

.field private currentPlanItemId:Ljava/lang/String;
.field private currentToolCall:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
.field private final gson$delegate:Lkotlin/Lazy;
.field private final planItemMap:Ljava/util/LinkedHashMap;


.method public static synthetic $r8$lambda$IUcnKFLZZsIccy3JVeAcphVjo3M()com.google.gson.Gson
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/im/service/PlanItemAggregator;->gson_delegate$lambda$0()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/im/service/PlanItemAggregator;->planItemMap Ljava/util/LinkedHashMap;
    new-instance v0, Lcom/bytedance/trae/im/service/PlanItemAggregator$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/im/service/PlanItemAggregator$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/im/service/PlanItemAggregator;->gson$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private final appendNameIfNotSame(java.lang.String  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +023h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "IMMessage: appendNameIfNotSame same : currentName="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", newName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v1, "AgentDataFlow_IMMessage"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    if-nez v4, +003h
    return-object v5
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method public static synthetic apply$default(com.bytedance.trae.im.service.PlanItemAggregator  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.ChatEvent  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +005h
    const-string/jumbo v3, unknown
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/PlanItemAggregator;->apply(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String;)V
    return-void 
.end method

.method private final getGson()com.google.gson.Gson
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/PlanItemAggregator;->gson$delegate Lkotlin/Lazy;
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

.method private final syncTaskContent(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 9
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v0
    if-nez v0, +013h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;
    new-instance v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/im/model/ParsedTaskContent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setContent(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/im/service/PlanItemAggregator;->planItemMap Ljava/util/LinkedHashMap;
    invoke-virtual v8, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;
    move-result-object v8
    const-string v1, "<get-entries>(...)"
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v8, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    const/4 v2, 0
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +034h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    add-int/lit8 v4, v2, 1
    if-gez v2, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v3, Ljava/util/Map$Entry;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    const-string v5, "component1(...)"
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/String;
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    const-string v5, "component2(...)"
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    new-instance v5, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    const-string v6, "plan_item"
    invoke-direct v5, v2, v6, v3, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedPlanItem;)V
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move v2, v4
    goto -37h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +003h
    const/4 v1, 0
    check-cast v1, Ljava/util/List;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;->setMessages(Ljava/util/List;)V
    return-void 
.end method

.method public final apply(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.ChatEvent  java.lang.String)void
    .registers 36
    # ins_size=4
    move-object/from16 v0, v32
    move-object/from16 v1, v33
    move-object/from16 v2, v35
    const-string v3, "message"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "event"
    move-object/from16 v4, v34
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, source
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getData()Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-result-object v3
    instance-of v5, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    const-string v6, ", agentId="
    const-string v7, ",message="
    const-string v8, ", status="
    const-string v9, ", payload="
    const-string v10, ", seq="
    const-string v11, "AgentDataFlow_IMMessage"
    const/4 v13, 1
    invoke-static v13, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v14
    if-eqz v5, +1b6h
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v15, "IMMessage: [Node2] Aggregator.Metadata: source="
    invoke-direct v13, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", agentType="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentType()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v6, ", messageType="
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getMessageType()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v6, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v6
    invoke-virtual v6, v3, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    invoke-virtual v3, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v11, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getMessageId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +014h
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setMessageId(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getTurnId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setTurnId(Ljava/lang/String;)V
    invoke-virtual v1, v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHasMetaData(Ljava/lang/Boolean;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getStatus()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setStatus(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getMessageType()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setMessageType(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getMessageIndex()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    goto +5h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageIndex()I
    move-result v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setMessageIndex(I)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setReplyToMessageId(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setAgentType(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setAgentId(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setAgentName(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentAvatarId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setAgentAvatarId(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getTraceId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setTraceId(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getCreatedAt()Ljava/lang/Long;
    move-result-object v2
    const-wide/16 v5, 0
    if-eqz v2, +023h
    move-object v3, v2
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v7
    cmp-long v3, v7, v5
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +00fh
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->longValue()J
    move-result-wide v2
    sget-object v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->Companion Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
    invoke-virtual v7, v2, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;->normalizeToMillis(J)J
    move-result-wide v2
    goto +5h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v2
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setCreatedAt(J)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getChatProcessVersion()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setChatProcessVersion(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentProcessSupport()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setAgentProcessSupport(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getFromAppend()Ljava/lang/Boolean;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFromAppendMsg()Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setFromAppendMsg(Ljava/lang/Boolean;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree()Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setWorktree(Ljava/lang/Boolean;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getChatStartTime()Ljava/lang/Long;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setChatStartTime(Ljava/lang/Long;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getVersionCode()Ljava/lang/Long;
    move-result-object v2
    if-eqz v2, +016h
    move-object v3, v2
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v7
    cmp-long v3, v7, v5
    if-lez v3, +004h
    const/4 v12, 1
    goto +2h
    const/4 v12, 0
    if-eqz v12, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getVersionCode()Ljava/lang/Long;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setVersionCode(Ljava/lang/Long;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getShallowMementoType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setShallowMementoType(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getModelSmartSelectionMeta()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +01ah
    invoke-direct/range v32, Lcom/bytedance/trae/im/service/PlanItemAggregator;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    check-cast v2, Lcom/google/gson/JsonElement;
    const-class v5, Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    invoke-virtual v3, v2, v5, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    move-object v15, v2
    goto +2h
    const/4 v15, 0
    invoke-virtual v1, v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setModelSmartSelectionMeta(Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getUserMessageContext()Lcom/bytedance/trae/im/service/UserMessageContext;
    move-result-object v2
    if-eqz v2, +837h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/UserMessageContext;->getModelInfo()Lcom/bytedance/trae/im/service/ModelInfo;
    move-result-object v2
    if-eqz v2, +831h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ModelInfo;->getDisplayModelName()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +82bh
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setStreamingChatModel(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +822h
    instance-of v5, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    const-string v13, ", message="
    if-eqz v5, +6e5h
    move-object v5, v3
    check-cast v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getId()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    return-void 
    sget-object v15, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v4, "[Node2] Aggregator.PlanItem: source="
    invoke-direct v12, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v31, v13
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v13
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v13, ", id="
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v13, ", currentPlanItemId="
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v13, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentPlanItemId Ljava/lang/String;
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v13, ", hasThought="
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getThought()Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +004h
    const/4 v13, 1
    goto +2h
    const/4 v13, 0
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v13, ", hasReasoning="
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +004h
    const/4 v13, 1
    goto +2h
    const/4 v13, 0
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v13, ", hasTool="
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/service/ToolCallInfo;
    move-result-object v13
    if-eqz v13, +004h
    const/4 v13, 1
    goto +2h
    const/4 v13, 0
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v13, ", toolName="
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/service/ToolCallInfo;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/service/ToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v13
    goto +2h
    const/4 v13, 0
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", agentRunId="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", cleanThought="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getCleanThought()Ljava/lang/Boolean;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", thoughtFirstData="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getThoughtFirstData()Ljava/lang/Boolean;
    move-result-object v4
    invoke-virtual v12, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", toolcallFirstData="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getToolcallFirstData()Ljava/lang/Boolean;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ",payload="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v6
    invoke-virtual v6, v3, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v6
    invoke-virtual v6, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v15, v11, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentPlanItemId Ljava/lang/String;
    invoke-static v8, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +016h
    iput-object v8, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentPlanItemId Ljava/lang/String;
    iget-object v4, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->planItemMap Ljava/util/LinkedHashMap;
    invoke-virtual v4, v8, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    iput-object v4, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getHasMetaData()Ljava/lang/Boolean;
    move-result-object v4
    const-string v6, ""
    if-eqz v4, +033h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getHasMetaData()Ljava/lang/Boolean;
    move-result-object v4
    const/4 v7, 0
    invoke-static v7, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v12
    invoke-static v4, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +22h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +034h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +026h
    sget-object v4, Lcom/bytedance/trae/im/log/IMApmEvent;->INSTANCE Lcom/bytedance/trae/im/log/IMApmEvent;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v12, reply_to_message_is_not_same
    invoke-virtual v4, v1, v7, v12, Lcom/bytedance/trae/im/log/IMApmEvent;->reportMessageStatus(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String;)V
    goto +18h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    const-string v7, "no_meta_data"
    if-eqz v4, +00ch
    sget-object v4, Lcom/bytedance/trae/im/log/IMApmEvent;->INSTANCE Lcom/bytedance/trae/im/log/IMApmEvent;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v4, v1, v12, v7, Lcom/bytedance/trae/im/log/IMApmEvent;->reportMessageStatus(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String;)V
    goto +6h
    sget-object v4, Lcom/bytedance/trae/im/log/IMApmEvent;->INSTANCE Lcom/bytedance/trae/im/log/IMApmEvent;
    invoke-virtual v4, v1, v6, v7, Lcom/bytedance/trae/im/log/IMApmEvent;->reportMessageStatus(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "http"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +0a3h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/service/ToolCallInfo;
    move-result-object v2
    if-eqz v2, +044h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->getParams()Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +012h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    const/4 v4, 0
    if-eqz v4, +008h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v4
    move-object v12, v4
    goto +2h
    const/4 v12, 0
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->getResult()Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +00fh
    invoke-direct/range v32, Lcom/bytedance/trae/im/service/PlanItemAggregator;->getGson()Lcom/google/gson/Gson;
    move-result-object v6
    const-class v7, Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    invoke-virtual v6, v4, v7, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    goto +2h
    const/4 v4, 0
    move-object v13, v4
    goto +2h
    const/4 v13, 0
    new-instance v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v11
    const/4 v14, 0
    const/16 v15, 16
    const/16 v16, 0
    move-object v9, v4
    invoke-direct/range v9 ... v16, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedToolCallResult; Lcom/google/gson/JsonObject; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +2h
    const/4 v4, 0
    check-cast v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getConfirmInfo()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +012h
    invoke-direct/range v32, Lcom/bytedance/trae/im/service/PlanItemAggregator;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    check-cast v2, Lcom/google/gson/JsonElement;
    const-class v6, Lcom/bytedance/trae/im/model/ConfirmInfo;
    invoke-virtual v3, v2, v6, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-object v15, v2
    goto +2h
    const/4 v15, 0
    move-object/from16 v27, v15
    goto +3h
    const/16 v27, 0
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v19
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v20
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v21
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getSubAgentCallDescription()Ljava/lang/String;
    move-result-object v22
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getHide()Ljava/lang/Boolean;
    move-result-object v28
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getThought()Ljava/lang/String;
    move-result-object v23
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v25
    new-instance v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    const/16 v24, 0
    const/16 v29, 64
    const/16 v30, 0
    move-object/from16 v17, v2
    move-object/from16 v18, v8
    move-object/from16 v26, v4
    invoke-direct/range v17 ... v30, Lcom/bytedance/trae/im/model/ParsedPlanItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v3, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->planItemMap Ljava/util/LinkedHashMap;
    check-cast v3, Ljava/util/Map;
    invoke-interface v3, v8, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-direct/range v32 ... v33, Lcom/bytedance/trae/im/service/PlanItemAggregator;->syncTaskContent(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    return-void 
    iget-object v4, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->planItemMap Ljava/util/LinkedHashMap;
    check-cast v4, Ljava/util/Map;
    invoke-interface v4, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    if-nez v7, +030h
    new-instance v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v19
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v20
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v21
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getSubAgentCallDescription()Ljava/lang/String;
    move-result-object v22
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getHide()Ljava/lang/Boolean;
    move-result-object v28
    const/16 v29, 992
    const/16 v30, 0
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    invoke-direct/range v17 ... v30, Lcom/bytedance/trae/im/model/ParsedPlanItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v4, v8, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +009h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setAgentId(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +009h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setAgentRunId(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +009h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setAgentDisplayName(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getSubAgentCallDescription()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +009h
    invoke-virtual v7, v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setSubAgentCallDescription(Ljava/lang/String;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getHide()Ljava/lang/Boolean;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-virtual v7, v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setHide(Ljava/lang/Boolean;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getCleanThought()Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v4, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    const-string v12, ", oldThought="
    const-string v13, ", planItemId="
    if-eqz v4, +03dh
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v15, Ljava/lang/StringBuilder;
    move-object/from16 v17, v6
    const-string v6, "[Node2] Aggregator.PlanItem clean_thought: source="
    invoke-direct v15, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v15, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v15
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v11, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v7, v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setThought(Ljava/lang/String;)V
    goto +3h
    move-object/from16 v17, v6
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getThoughtFirstData()Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v4, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +011h
    move-object v15, v6
    check-cast v15, Ljava/lang/CharSequence;
    invoke-interface v15, Ljava/lang/CharSequence;->length()I
    move-result v15
    if-lez v15, +004h
    const/4 v15, 1
    goto +2h
    const/4 v15, 0
    if-eqz v15, +003h
    goto +2h
    const/4 v6, 0
    if-eqz v6, +0f4h
    const-string v15, ", reasoning="
    if-eqz v4, +04dh
    move-object/from16 v19, v14
    sget-object v14, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    move-object/from16 v20, v12
    const-string v12, "[Node2] Aggregator.PlanItem thought_first_data overwrite reasoning: source="
    invoke-direct v0, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v12
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v12, ", oldReasoning="
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v14, v11, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setReasoningContent(Ljava/lang/String;)V
    move/from16 v21, v4
    move-object/from16 v22, v5
    goto/16 +0adh
    move-object/from16 v20, v12
    move-object/from16 v19, v14
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +078h
    move-object v12, v0
    check-cast v12, Ljava/lang/CharSequence;
    move-object v14, v6
    check-cast v14, Ljava/lang/CharSequence;
    move/from16 v21, v4
    move-object/from16 v22, v5
    move-object/from16 v23, v7
    const/4 v4, 2
    const/4 v5, 0
    const/4 v7, 0
    invoke-static v12, v14, v5, v4, v7, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +069h
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v7, "[Node2] Aggregator.PlanItem DUPLICATE reasoning: source="
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, ", existingReasoning="
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    sget-object v7, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v7
    invoke-virtual v7, v3, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    move-object/from16 v12, v31
    invoke-virtual v5, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    sget-object v7, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v7
    invoke-virtual v7, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v11, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +9h
    move/from16 v21, v4
    move-object/from16 v22, v5
    move-object/from16 v23, v7
    move-object/from16 v12, v31
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    if-nez v0, +004h
    move-object/from16 v0, v17
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v7, v23
    invoke-virtual v7, v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setReasoningContent(Ljava/lang/String;)V
    goto +bh
    move/from16 v21, v4
    move-object/from16 v22, v5
    move-object/from16 v20, v12
    move-object/from16 v19, v14
    move-object/from16 v12, v31
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getThought()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +011h
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +0e7h
    const-string v4, ", thought="
    if-eqz v21, +045h
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[Node2] Aggregator.PlanItem thought_first_data overwrite thought: source="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v5, v20
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v11, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setThought(Ljava/lang/String;)V
    goto/16 +0a0h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +079h
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    move-object v14, v0
    check-cast v14, Ljava/lang/CharSequence;
    move-object/from16 v23, v7
    move-object/from16 v18, v11
    const/4 v7, 2
    const/4 v11, 0
    const/4 v15, 0
    invoke-static v6, v14, v15, v7, v11, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +063h
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v11, "[Node2] Aggregator.PlanItem DUPLICATE thought: source="
    invoke-direct v7, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v11
    invoke-virtual v7, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", existingThought="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v7, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v7
    invoke-virtual v7, v3, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v4
    invoke-virtual v4, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v4, v18
    invoke-virtual v6, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +8h
    move-object/from16 v4, v18
    goto +5h
    move-object/from16 v23, v7
    move-object v4, v11
    const/4 v15, 0
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    if-nez v5, +005h
    move-object/from16 v6, v17
    goto +2h
    move-object v6, v5
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v7, v23
    invoke-virtual v7, v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setThought(Ljava/lang/String;)V
    goto +3h
    move-object v4, v11
    const/4 v15, 0
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getConfirmInfo()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +038h
    invoke-direct/range v32, Lcom/bytedance/trae/im/service/PlanItemAggregator;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    check-cast v0, Lcom/google/gson/JsonElement;
    const-class v5, Lcom/bytedance/trae/im/model/ConfirmInfo;
    invoke-virtual v3, v0, v5, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ConfirmInfo;
    invoke-virtual v7, v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setConfirmInfo(Lcom/bytedance/trae/im/model/ConfirmInfo;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v0
    const/4 v3, 1
    if-ne v0, v3, +005h
    move v0, v3
    goto +3h
    const/4 v3, 1
    move v0, v15
    if-eqz v0, +00ah
    move-object/from16 v0, v32
    iget-object v5, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v7, v5, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setToolCallInfo(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V
    goto +6h
    move-object/from16 v0, v32
    goto +3h
    const/4 v3, 1
    goto -4h
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +4h
    const/4 v3, 1
    move-object/from16 v0, v32
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/service/ToolCallInfo;
    move-result-object v5
    if-nez v5, +003h
    return-void 
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    return-void 
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->getParams()Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +011h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v11
    if-eqz v11, +003h
    goto +2h
    const/4 v9, 0
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->getResult()Lcom/google/gson/JsonElement;
    move-result-object v11
    iget-object v12, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v12, +012h
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v12
    goto +2h
    const/4 v12, 0
    invoke-static v12, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +004h
    move v12, v3
    goto +2h
    move v12, v15
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getNewToolCall()Ljava/lang/Boolean;
    move-result-object v14
    move-object/from16 v3, v19
    invoke-static v14, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getToolcallFirstData()Ljava/lang/Boolean;
    move-result-object v15
    invoke-static v15, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v12, +009h
    if-nez v14, +007h
    if-eqz v3, +003h
    goto +3h
    const/4 v15, 0
    goto +2h
    const/4 v15, 1
    if-eqz v15, +0e3h
    if-nez v3, +008h
    if-eqz v14, +003h
    goto +4h
    move-object/from16 v17, v11
    goto +71h
    sget-object v15, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v17, v11
    const-string v11, "[Node2] Aggregator.PlanItem toolcall_first_data="
    invoke-direct v1, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", isNewToolCall="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", source="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", toolId="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", oldName="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v3, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", oldParams="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v3, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v15, v4, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v1, +04ah
    if-nez v12, +048h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v11, "[Node2] ToolCall id changed: source="
    invoke-direct v3, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", old="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", new="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v22
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 24
    const/16 v27, 0
    move-object/from16 v20, v1
    move-object/from16 v21, v6
    move-object/from16 v23, v9
    invoke-direct/range v20 ... v27, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedToolCallResult; Lcom/google/gson/JsonObject; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v7, v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->setToolCallInfo(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V
    goto +4fh
    move-object/from16 v17, v11
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +02dh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    const/4 v12, 1
    goto +2h
    const/4 v12, 0
    if-eqz v12, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +01bh
    iget-object v2, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v2, +013h
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/im/service/PlanItemAggregator;->appendNameIfNotSame(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->setName(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    if-eqz v9, +01bh
    iget-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +00ch
    iget-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v1, +00bh
    invoke-virtual v1, v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->setParams(Lcom/google/gson/JsonObject;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +4h
    invoke-static v1, v9, Lcom/bytedance/trae/im/service/JsonUtilsKt;->mergeJsonObjects(Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;
    invoke-direct/range v32, Lcom/bytedance/trae/im/service/PlanItemAggregator;->getGson()Lcom/google/gson/Gson;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-object/from16 v3, v17
    invoke-virtual v1, v3, v2, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-object v15, v1
    goto +2h
    const/4 v15, 0
    if-eqz v15, +00bh
    iget-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    if-eqz v1, +007h
    invoke-virtual v1, v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->setResult(Lcom/bytedance/trae/im/model/ParsedToolCallResult;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-direct/range v32 ... v33, Lcom/bytedance/trae/im/service/PlanItemAggregator;->syncTaskContent(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +139h
    move-object v4, v11
    move-object v12, v13
    instance-of v1, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    if-eqz v1, +0abh
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentPlanItemId Ljava/lang/String;
    iput-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;->getStatus()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lcom/bytedance/trae/im/service/IMMessageKt;->access$normalizeDoneStatus(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v5
    move-object/from16 v6, v33
    invoke-virtual v6, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setStatus(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;->getChatStartTime()Ljava/lang/Long;
    move-result-object v5
    if-nez v5, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatStartTime()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v6, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setChatStartTime(Ljava/lang/Long;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;->getChatEndTime()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v6, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setChatEndTime(Ljava/lang/Long;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setReplyToMessageId(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingPosition(Ljava/lang/Integer;)V
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingMessage(Ljava/lang/String;)V
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueueId(Ljava/lang/String;)V
    invoke-direct/range v32 ... v33, Lcom/bytedance/trae/im/service/PlanItemAggregator;->syncTaskContent(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v11, "IMMessage: [Node2] Aggregator.Done: source="
    invoke-direct v5, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", totalPlanItems="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v32, Lcom/bytedance/trae/im/service/PlanItemAggregator;->getAllItems()Ljava/util/List;
    move-result-object v5
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v5
    invoke-virtual v5, v3, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/IMService;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    invoke-virtual v3, v6, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +08ah
    move-object/from16 v6, v33
    instance-of v1, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    if-eqz v1, +082h
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentPlanItemId Ljava/lang/String;
    iput-object v1, v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->currentToolCall Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    new-instance v1, Lcom/bytedance/trae/im/model/ParsedError;
    check-cast v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;->getCode()Ljava/lang/Integer;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;->getData()Lcom/google/gson/JsonObject;
    move-result-object v9
    invoke-direct v1, v5, v7, v9, Lcom/bytedance/trae/im/model/ParsedError;-><init>(Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject;)V
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setError(Lcom/bytedance/trae/im/model/ParsedError;)V
    const-string v1, "failed"
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setStatus(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setReplyToMessageId(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingPosition(Ljava/lang/Integer;)V
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueuingMessage(Ljava/lang/String;)V
    invoke-virtual v6, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setQueueId(Ljava/lang/String;)V
    invoke-direct/range v32 ... v33, Lcom/bytedance/trae/im/service/PlanItemAggregator;->syncTaskContent(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v7, "IMMessage: [Node2] Aggregator.Error: source="
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v34, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", code="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;->getCode()Ljava/lang/Integer;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v33, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-void 
    :try_start_0x1b2
    :try_start_0x375
    :try_start_0x3a1
    :try_start_0x6e8
    :try_start_0x70e
    :try_start_0x8ab
.end method

.method public final getAllItems()java.util.List
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/service/PlanItemAggregator;->planItemMap Ljava/util/LinkedHashMap;
    invoke-virtual v0, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    const-string v1, "<get-values>(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method
