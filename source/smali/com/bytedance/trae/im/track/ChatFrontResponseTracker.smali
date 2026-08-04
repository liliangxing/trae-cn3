# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
.super Ljava/lang/Object;
.source "ChatFrontResponseTracker.kt"

.field private static final EVENT_NAME:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
.field private static final TAG:Ljava/lang/String;
.field private static final tokenOutputContexts:Ljava/util/concurrent/ConcurrentHashMap;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    invoke-direct v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->tokenOutputContexts Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic onStreamStopped$default(com.bytedance.trae.im.track.ChatFrontResponseTracker  java.lang.String  com.bytedance.trae.im.track.ChatFrontResponseTracker$StopType  java.lang.String  java.lang.Integer  java.lang.String  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v10, v13, 8
    if-eqz v10, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v10, v13, 16
    if-eqz v10, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->onStreamStopped(Ljava/lang/String; Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public final clear(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->tokenOutputContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final onPlanItemToken(java.lang.String)void
    .registers 10
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->tokenOutputContexts Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v0, v9, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +015h
    new-instance v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;
    const-wide/16 v3, 0
    const/4 v5, 0
    const/4 v6, 3
    const/4 v7, 0
    move-object v2, v1
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;-><init>(J Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v9, v1, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    if-nez v9, +003h
    goto +2h
    move-object v1, v9
    check-cast v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;->getLastOutputTime()J
    move-result-wide v4
    const-wide/16 v6, 0
    cmp-long v9, v4, v6
    if-lez v9, +013h
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;->getDurations()Ljava/util/List;
    move-result-object v9
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;->getLastOutputTime()J
    move-result-wide v4
    sub-long v4, v2, v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-interface v9, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;->setLastOutputTime(J)V
    return-void 
    :try_start_0x6
.end method

.method public final onStreamStopped(java.lang.String  com.bytedance.trae.im.track.ChatFrontResponseTracker$StopType  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 23
    # ins_size=6
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    move-object/from16 v3, v22
    const-string/jumbo v4, startTime
    const-string/jumbo v5, taskId
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v5, stopType
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v5, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->getTrackingContext(Ljava/lang/String;)Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    move-result-object v5
    if-nez v5, +003h
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sget-object v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v8, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->getReportedContext(Ljava/lang/String;)Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    move-result-object v8
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getStartTime()J
    move-result-wide v9
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->getCategories()Lorg/json/JSONObject;
    move-result-object v8
    goto +2h
    const/4 v8, 0
    sub-long/2addr v6, v9
    sget-object v12, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;->tokenOutputContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v12, v0, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;
    const/4 v12, 1
    if-eqz v0, +029h
    invoke-virtual v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;->getDurations()Ljava/util/List;
    move-result-object v13
    check-cast v13, Ljava/util/Collection;
    invoke-interface v13, Ljava/util/Collection;->isEmpty()Z
    move-result v13
    xor-int/2addr v13, v12
    if-eqz v13, +01ch
    invoke-virtual v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;->getDurations()Ljava/util/List;
    move-result-object v13
    check-cast v13, Ljava/lang/Iterable;
    invoke-static v13, Lkotlin/collections/CollectionsKt;->sumOfLong(Ljava/lang/Iterable;)J
    move-result-wide v13
    long-to-double v13, v13
    invoke-virtual v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;->getDurations()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    int-to-double v11, v0
    div-double/2addr v13, v11
    invoke-static v13, v14, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v11, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v19, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->ordinal()I
    move-result v12
    aget v11, v11, v12
    const/4 v12, 1
    if-eq v11, v12, +014h
    const/4 v12, 2
    if-eq v11, v12, +00eh
    const/4 v12, 3
    if-ne v11, v12, +005h
    const-string v11, "Canceled"
    goto +ch
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const-string v11, "Failed"
    goto +3h
    const-string v11, "Success"
    const-string v12, "model"
    const-string v13, ""
    if-eqz v8, +012h
    invoke-virtual v8, v12, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v14
    if-eqz v14, +00ch
    invoke-virtual v8, v12, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-string v14, "optString(...)"
    invoke-static v8, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +7h
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getModel()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v13
    new-instance v14, Lorg/json/JSONObject;
    invoke-direct v14, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v15, status
    invoke-virtual v14, v15, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v14, v4, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v11, "agent_process_support"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getAgentProcessSupport()Ljava/lang/String;
    move-result-object v15
    if-nez v15, +003h
    move-object v15, v13
    invoke-virtual v14, v11, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v11, "isPreset"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->isPreset()Ljava/lang/Boolean;
    move-result-object v15
    move-object/from16 v18, v13
    const/16 v16, 1
    invoke-static/range v16, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v13
    invoke-static v15, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    const/4 v15, 0
    if-eqz v13, +005h
    move/from16 v13, v16
    goto +2h
    move v13, v15
    invoke-virtual v14, v11, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v14, v12, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v11, "appVersion"
    invoke-virtual v14, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "agentType"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getAgentType()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v14, v8, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "queued"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getQueued()Z
    move-result v11
    if-eqz v11, +005h
    move/from16 v12, v16
    goto +2h
    move v12, v15
    invoke-virtual v14, v8, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v8, "chat_process_version"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getChatProcessVersion()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +004h
    move-object/from16 v11, v18
    invoke-virtual v14, v8, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v8, traceId
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getTraceId()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +004h
    move-object/from16 v11, v18
    invoke-virtual v14, v8, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v8, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Success Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    if-eq v1, v8, +020h
    if-eqz v2, +007h
    const-string v1, "errorMsg"
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v21, +00fh
    move-object/from16 v1, v21
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    const-string v2, "errCode"
    invoke-virtual v14, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    if-eqz v3, +008h
    const-string/jumbo v1, serverError
    invoke-virtual v14, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, ttnetABTest
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getTtnetABTest()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object/from16 v2, v18
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, requestClient
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getRequestClient()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object/from16 v2, v18
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "agentProcessSupport"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getAgentProcessSupport()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object/from16 v2, v18
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getSource()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +008h
    const-string/jumbo v2, source
    invoke-virtual v14, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "hasText"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getHasText()Z
    move-result v2
    if-eqz v2, +006h
    const-string/jumbo v2, true
    goto +3h
    const-string v2, "false"
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "imageCount"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getImageCount()I
    move-result v2
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v1, "agentTaskServiceStrategy"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getAgentTaskServiceStrategy()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object/from16 v2, v18
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "chatProcessVersion"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getChatProcessVersion()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object/from16 v2, v18
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "modelStrategy"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getModelStrategy()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, "auto"
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "configSource"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getConfigSource()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object/from16 v2, v18
    invoke-virtual v14, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "provider"
    invoke-virtual v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getProvider()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +005h
    move-object/from16 v13, v18
    goto +2h
    move-object v13, v2
    invoke-virtual v14, v1, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "costTime"
    invoke-virtual v1, v2, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v1, v4, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    if-eqz v0, +00eh
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->doubleValue()D
    move-result-wide v2
    const-string/jumbo v0, tokenOutputInterval
    invoke-virtual v1, v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v2, "icube_ai_front_response"
    const/4 v3, 0
    invoke-virtual v0, v2, v14, v1, v3, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x17
    :try_start_0x8f
    :try_start_0xa5
.end method
