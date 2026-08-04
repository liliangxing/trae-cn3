# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
.super Ljava/lang/Object;
.source "ChatTokenUsageTracker.kt"

.field private static final EVENT_NAME:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
.field private static final TAG:Ljava/lang/String;
.field private static final cumulativeTokenUsage:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final lastTokenUsageTimes:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final reportedTaskIds:Ljava/util/Set;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
    invoke-direct v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static v0, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->reportedTaskIds Ljava/util/Set;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->lastTokenUsageTimes Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->cumulativeTokenUsage Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final flattenJsonObject(org.json.JSONObject  java.lang.String  org.json.JSONObject)void
    .registers 8
    # ins_size=4
    invoke-virtual v5, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "keys(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +04ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +004h
    move-object v2, v1
    goto +18h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "__"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v1, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    instance-of v3, v1, Ljava/lang/Number;
    if-eqz v3, +006h
    invoke-virtual v7, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -3eh
    instance-of v3, v1, Lorg/json/JSONObject;
    if-eqz v3, -041h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;
    check-cast v1, Lorg/json/JSONObject;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v1, v2, v7, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->flattenJsonObject(Lorg/json/JSONObject; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto -4dh
    return-void 
.end method

.method private final parseServerTimingMetrics(java.lang.String)org.json.JSONObject
    .registers 7
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-eqz v1, +003h
    return-object v0
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, v6, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v2, ""
    invoke-direct v5, v1, v2, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->flattenJsonObject(Lorg/json/JSONObject; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +22h
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "parseServerTimingMetrics: parse error, serverTimingInfo="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v3, ", e="
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v1, "ChatTokenUsageTracker"
    invoke-virtual v2, v1, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    :try_start_0x17
.end method

.method public final clear(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->reportedTaskIds Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    sget-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->lastTokenUsageTimes Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->cumulativeTokenUsage Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x6
.end method

.method public final onTokenUsage(java.lang.String  com.bytedance.trae.im.service.ChatEventPayload$TokenUsage)void
    .registers 23
    # ins_size=3
    move-object/from16 v0, v21
    const-string/jumbo v1, taskId
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "payload"
    move-object/from16 v2, v22
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->reportedTaskIds Ljava/util/Set;
    invoke-interface v1, v0, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v3
    const-string v4, ", skip"
    const-string v5, "ChatTokenUsageTracker"
    if-nez v3, +01bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onTokenUsage: already reported for taskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->getReportedContext(Ljava/lang/String;)Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    move-result-object v3
    if-nez v3, +01eh
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v6, "onTokenUsage: no firstToken context for taskId="
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v5, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v0, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getCompletionTokens()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, 0
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getReasoningTokens()Ljava/lang/Integer;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2h
    const/4 v7, 0
    add-int v8, v1, v7
    sget-object v9, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->lastTokenUsageTimes Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v9, v0, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/Long;
    if-eqz v9, +007h
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v9
    goto +5h
    invoke-virtual v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->getFirstTokenTime()J
    move-result-wide v9
    if-lez v8, +020h
    sub-long v9, v4, v9
    invoke-static v9, v10, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v12
    const-wide/16 v14, 0
    cmp-long v10, v12, v14
    if-lez v10, +00eh
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v12
    long-to-double v12, v12
    int-to-double v14, v8
    div-double/2addr v12, v14
    invoke-static v12, v13, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v8
    goto +5h
    const/4 v8, 0
    goto +3h
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lorg/json/JSONObject;
    invoke-direct v10, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->getMetrics()Lorg/json/JSONObject;
    move-result-object v12
    const-string/jumbo v13, rs_
    const-string/jumbo v14, svr_
    const-string v15, "fe_"
    filled-new-array v15, v13, v14, [Ljava/lang/String;
    move-result-object v13
    invoke-static v13, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v13
    invoke-virtual v12, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v14
    const-string v15, "keys(...)"
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v16
    if-eqz v16, +05bh
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v16
    move-object/from16 v6, v16
    check-cast v6, Ljava/lang/String;
    move-object v11, v13
    check-cast v11, Ljava/lang/Iterable;
    instance-of v2, v11, Ljava/util/Collection;
    if-eqz v2, +011h
    move-object v2, v11
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +008h
    move-object/from16 v18, v13
    move-object/from16 v19, v14
    const/4 v14, 0
    goto +2ch
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, -00eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object/from16 v17, v2
    const/4 v2, 2
    move-object/from16 v18, v13
    move-object/from16 v19, v14
    const/4 v13, 0
    const/4 v14, 0
    invoke-static v6, v11, v14, v2, v13, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v14, 1
    goto +8h
    move-object/from16 v2, v17
    move-object/from16 v13, v18
    move-object/from16 v14, v19
    goto -26h
    if-nez v14, +009h
    invoke-virtual v12, v6, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    invoke-virtual v10, v6, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object/from16 v2, v22
    move-object/from16 v13, v18
    move-object/from16 v14, v19
    goto -5eh
    invoke-virtual v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->getServerTimingInfo()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v6, v20
    invoke-direct v6, v2, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->parseServerTimingMetrics(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v2
    new-instance v11, Lorg/json/JSONObject;
    invoke-direct v11, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v10, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v12
    invoke-static v12, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +010h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/String;
    invoke-virtual v10, v13, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v14
    invoke-virtual v11, v13, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -13h
    invoke-virtual v2, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v10
    invoke-static v10, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +010h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Ljava/lang/String;
    invoke-virtual v2, v12, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v13
    invoke-virtual v11, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -13h
    const-string v2, "completionTokens"
    invoke-virtual v11, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v2, "reasoningTokens"
    invoke-virtual v11, v2, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getTotalTokens()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v14
    goto +2h
    const/4 v14, 0
    const-string/jumbo v2, totalTokens
    invoke-virtual v11, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getCacheCreationInputTokens()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v14
    goto +2h
    const/4 v14, 0
    const-string v2, "cacheCreationInputTokens"
    invoke-virtual v11, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getCacheReadInputTokens()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v14
    goto +2h
    const/4 v14, 0
    const-string v2, "cacheReadInputTokens"
    invoke-virtual v11, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getLastTurnTotalTokens()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v14
    goto +2h
    const/4 v14, 0
    const-string v2, "lastTurnTotalTokens"
    invoke-virtual v11, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getPromptTokensTotal()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v14
    goto +2h
    const/4 v14, 0
    const-string v2, "promptTokensTotal"
    invoke-virtual v11, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getPromptTokens()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v14
    goto +2h
    const/4 v14, 0
    const-string v2, "promptTokens"
    invoke-virtual v11, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->getCompletionTokensTotal()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v14
    goto +2h
    const/4 v14, 0
    const-string v2, "completionTokensTotal"
    invoke-virtual v11, v2, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    if-eqz v8, +00eh
    check-cast v8, Ljava/lang/Number;
    invoke-virtual v8, Ljava/lang/Number;->doubleValue()D
    move-result-wide v12
    const-string/jumbo v2, tpot
    invoke-virtual v11, v2, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    if-eqz v9, +00dh
    check-cast v9, Ljava/lang/Number;
    invoke-virtual v9, Ljava/lang/Number;->longValue()J
    move-result-wide v8
    const-string v2, "outputDuration"
    invoke-virtual v11, v2, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->getCategories()Lorg/json/JSONObject;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v8, "icube_ai_chat_token_usage"
    const/4 v9, 0
    invoke-virtual v3, v8, v2, v11, v9, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->lastTokenUsageTimes Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v3, Ljava/util/Map;
    invoke-interface v3, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;->cumulativeTokenUsage Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v2, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v2, v0, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +011h
    new-instance v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;
    const/4 v4, 3
    const/4 v5, 0
    invoke-direct v3, v5, v5, v4, v9, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;-><init>(I I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v0, v3, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;
    invoke-virtual v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->getCompletionTokens()I
    move-result v0
    add-int/2addr v0, v1
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->setCompletionTokens(I)V
    invoke-virtual v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->getReasoningTokens()I
    move-result v0
    add-int/2addr v0, v7
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->setReasoningTokens(I)V
    return-void 
.end method
