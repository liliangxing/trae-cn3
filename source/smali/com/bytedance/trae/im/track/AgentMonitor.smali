# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/track/AgentMonitor;
.super Ljava/lang/Object;
.source "AgentMonitor.kt"

.field private static final AGENT_NOT_END_TIMEOUT_MS:J
.field private static final EVENT_AGENT_DONE:Ljava/lang/String;
.field private static final EVENT_AGENT_ERROR:Ljava/lang/String;
.field private static final EVENT_AGENT_NOT_END:Ljava/lang/String;
.field private static final EVENT_AGENT_QUEUING:Ljava/lang/String;
.field private static final EVENT_AGENT_START:Ljava/lang/String;
.field private static final EVENT_USER_MESSAGE_START:Ljava/lang/String;
.field private static final EVENT_USER_MESSAGE_SUCCESS:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/track/AgentMonitor;
.field private static final handler:Landroid/os/Handler;
.field private static final pendingTaskConversations:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final pendingTaskSources:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final pendingTimeoutRunnables:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final reportedEvents:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final userMessageSuccessTimestamps:Ljava/util/concurrent/ConcurrentHashMap;


.method public static synthetic $r8$lambda$rImV47Z4WfNRrTaXx3_QvbuL-Kk(java.lang.String)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/im/track/AgentMonitor;->scheduleNotEndTimeout$lambda$15(Ljava/lang/String;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v0, Lcom/bytedance/trae/im/track/AgentMonitor;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->reportedEvents Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->userMessageSuccessTimestamps Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskConversations Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskSources Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTimeoutRunnables Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->handler Landroid/os/Handler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final calculateAgentTime(com.bytedance.trae.im.model.ParsedChatMessage)long
    .registers 9
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatStartTime()Ljava/lang/Long;
    move-result-object v0
    const-wide/16 v1, 0
    if-eqz v0, +016h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatEndTime()Ljava/lang/Long;
    move-result-object v8
    if-eqz v8, +00ch
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    sub-long/2addr v5, v3
    cmp-long v8, v5, v1
    if-ltz v8, +003h
    move-wide v1, v5
    return-wide v1
.end method

.method private final cancelNotEndTimeout(java.lang.String)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTimeoutRunnables Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Runnable;
    if-eqz v2, +007h
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->handler Landroid/os/Handler;
    invoke-virtual v0, v2, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private final getScope()java.lang.String
    .registers 6
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v2
    goto +2h
    move-object v2, v1
    const/4 v3, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v0
    const/4 v4, 1
    if-ne v0, v4, +003h
    move v3, v4
    if-nez v3, +006h
    const-string/jumbo v0, unknown
    goto +33h
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    const-string v3, "enterprise"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, saas
    goto +1fh
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v1
    const-string v0, "bytecloud"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "bytedance"
    goto +eh
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "marscode-us"
    goto +3h
    const-string v0, "marscode"
    return-object v0
.end method

.method private final hasReported(java.lang.String  java.lang.String)boolean
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->reportedEvents Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Set;
    const/4 v0, 0
    if-eqz v2, +00ah
    invoke-interface v2, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    const/4 v3, 1
    if-ne v2, v3, +003h
    move v0, v3
    return v0
.end method

.method private final markReported(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->reportedEvents Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/concurrent/ConcurrentMap;
    invoke-interface v0, v3, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +015h
    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v1, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    invoke-static v1, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v1
    invoke-interface v0, v3, v1, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v1, v3
    check-cast v1, Ljava/util/Set;
    invoke-interface v1, v4, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method private final reportAgentNotEnd(java.lang.String)void
    .registers 7
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTimeoutRunnables Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v6, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskConversations Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v6, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    sget-object v2, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskSources Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v2, v6, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v3, source
    invoke-virtual v2, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, scope
    sget-object v3, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v3, Lcom/bytedance/trae/im/track/AgentMonitor;->getScope()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, task_id
    invoke-virtual v3, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v6, "conversation_id"
    invoke-virtual v3, v6, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v6, "device_id"
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v6, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v6, user_id
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getUserID()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v6, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v0, "agent_not_end"
    invoke-virtual v6, v0, v2, v1, v3, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
    :try_start_0x12
.end method

.method private final scheduleNotEndTimeout(java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskConversations Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskSources Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v4, Ljava/util/Map;
    invoke-interface v4, v3, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v4, Lcom/bytedance/trae/im/track/AgentMonitor$$ExternalSyntheticLambda0;
    invoke-direct v4, v3, Lcom/bytedance/trae/im/track/AgentMonitor$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTimeoutRunnables Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v5, Ljava/util/Map;
    invoke-interface v5, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/im/track/AgentMonitor;->handler Landroid/os/Handler;
    const-wide/32 v0, 3600000
    invoke-virtual v3, v4, v0, v1, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final scheduleNotEndTimeout$lambda$15(java.lang.String)void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v0, v1, Lcom/bytedance/trae/im/track/AgentMonitor;->reportAgentNotEnd(Ljava/lang/String;)V
    return-void 
.end method

.method public final clear(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/im/track/AgentMonitor;->cancelNotEndTimeout(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->reportedEvents Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->userMessageSuccessTimestamps Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskConversations Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->pendingTaskSources Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x6
.end method

.method public final onAgentDone(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 12
    # ins_size=4
    const-string v0, "agent_done"
    const-string/jumbo v1, taskId
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "conversationId"
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "message"
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v9, v0, Lcom/bytedance/trae/im/track/AgentMonitor;->hasReported(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    invoke-direct v8, v9, v0, Lcom/bytedance/trae/im/track/AgentMonitor;->markReported(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/track/AgentMonitor;->userMessageSuccessTimestamps Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v9, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, status
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, source
    if-eqz v2, +005h
    const-string v2, "local"
    goto +3h
    const-string v2, "remote"
    invoke-virtual v3, v4, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, scope
    sget-object v4, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v4, Lcom/bytedance/trae/im/track/AgentMonitor;->getScope()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-direct v8, v11, Lcom/bytedance/trae/im/track/AgentMonitor;->calculateAgentTime(Lcom/bytedance/trae/im/model/ParsedChatMessage;)J
    move-result-wide v4
    new-instance v11, Lorg/json/JSONObject;
    invoke-direct v11, Lorg/json/JSONObject;-><init>()V
    const-string v2, "agent_time"
    invoke-virtual v11, v2, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v1, v9, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Long;
    if-eqz v1, +018h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    sub-long/2addr v4, v1
    const-string v1, "local_agent_time"
    const-wide/16 v6, 0
    cmp-long v2, v4, v6
    if-ltz v2, +003h
    goto +2h
    move-wide v4, v6
    invoke-virtual v11, v1, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, task_id
    invoke-virtual v1, v2, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "conversation_id"
    invoke-virtual v1, v2, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v10, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v10, v0, v3, v11, v1, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    invoke-direct v8, v9, Lcom/bytedance/trae/im/track/AgentMonitor;->cancelNotEndTimeout(Ljava/lang/String;)V
    return-void 
    :try_start_0x12
.end method

.method public final onAgentError(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 16
    # ins_size=4
    const-string v0, "error_code"
    const-string v1, "agent_error"
    const-string/jumbo v2, taskId
    invoke-static v13, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "conversationId"
    invoke-static v14, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "message"
    invoke-static v15, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v12, v13, v1, Lcom/bytedance/trae/im/track/AgentMonitor;->hasReported(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    invoke-direct v12, v13, v1, Lcom/bytedance/trae/im/track/AgentMonitor;->markReported(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v2
    goto +2h
    move-object v2, v3
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v4
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/track/AgentMonitor;->userMessageSuccessTimestamps Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v4, v13, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v5
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v7, status
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v8
    const-string v9, ""
    if-nez v8, +003h
    move-object v8, v9
    invoke-virtual v6, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v2, +004h
    move-object v7, v9
    goto +2h
    move-object v7, v2
    invoke-virtual v6, v0, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v7, source
    if-eqz v5, +005h
    const-string v5, "local"
    goto +3h
    const-string v5, "remote"
    invoke-virtual v6, v7, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, scope
    sget-object v7, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v7, Lcom/bytedance/trae/im/track/AgentMonitor;->getScope()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v5, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-direct v12, v15, Lcom/bytedance/trae/im/track/AgentMonitor;->calculateAgentTime(Lcom/bytedance/trae/im/model/ParsedChatMessage;)J
    move-result-wide v7
    new-instance v15, Lorg/json/JSONObject;
    invoke-direct v15, Lorg/json/JSONObject;-><init>()V
    const-string v5, "agent_time"
    invoke-virtual v15, v5, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v4, v13, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Long;
    if-eqz v4, +018h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    invoke-virtual v4, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    sub-long/2addr v7, v4
    const-string v4, "local_agent_time"
    const-wide/16 v10, 0
    cmp-long v5, v7, v10
    if-ltz v5, +003h
    goto +2h
    move-wide v7, v10
    invoke-virtual v15, v4, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v5, task_id
    invoke-virtual v4, v5, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "conversation_id"
    invoke-virtual v4, v5, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v2, +003h
    move-object v2, v9
    invoke-virtual v4, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v14, "error_message"
    if-nez v3, +003h
    move-object v3, v9
    invoke-virtual v4, v14, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v14, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v14, v1, v6, v15, v4, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    invoke-direct v12, v13, Lcom/bytedance/trae/im/track/AgentMonitor;->cancelNotEndTimeout(Ljava/lang/String;)V
    return-void 
    :try_start_0x14
    :try_start_0x4c
.end method

.method public final onAgentQueuing(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string v0, "agent_queuing"
    const-string/jumbo v1, taskId
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "conversationId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/im/track/AgentMonitor;->hasReported(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/im/track/AgentMonitor;->markReported(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, scope
    sget-object v3, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v3, Lcom/bytedance/trae/im/track/AgentMonitor;->getScope()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, task_id
    invoke-virtual v3, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v6, "conversation_id"
    invoke-virtual v3, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v6, v0, v1, v2, v3, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xd
.end method

.method public final onAgentStart(java.lang.String  java.lang.String)void
    .registers 15
    # ins_size=3
    const-string v0, "agent_start"
    const-string/jumbo v1, taskId
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "conversationId"
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v12, v13, v0, Lcom/bytedance/trae/im/track/AgentMonitor;->hasReported(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    invoke-direct v12, v13, v0, Lcom/bytedance/trae/im/track/AgentMonitor;->markReported(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/track/AgentMonitor;->userMessageSuccessTimestamps Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v13, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, source
    const-string v5, "local"
    const-string v6, "remote"
    if-eqz v2, +004h
    move-object v7, v5
    goto +2h
    move-object v7, v6
    invoke-virtual v3, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, scope
    sget-object v7, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v7, Lcom/bytedance/trae/im/track/AgentMonitor;->getScope()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v13, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Long;
    if-eqz v1, +018h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v9
    sub-long/2addr v7, v9
    const-string v1, "agent_first_token_time"
    const-wide/16 v9, 0
    cmp-long v11, v7, v9
    if-ltz v11, +003h
    goto +2h
    move-wide v7, v9
    invoke-virtual v4, v1, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v7, task_id
    invoke-virtual v1, v7, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "conversation_id"
    invoke-virtual v1, v7, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v7, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v7, v0, v3, v4, v1, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    if-eqz v2, +003h
    goto +2h
    move-object v5, v6
    invoke-direct v12, v13, v14, v5, Lcom/bytedance/trae/im/track/AgentMonitor;->scheduleNotEndTimeout(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0xd
    :try_start_0x2e
.end method

.method public final onUserMessageStart(java.lang.String)void
    .registers 6
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, scope
    sget-object v2, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v2, Lcom/bytedance/trae/im/track/AgentMonitor;->getScope()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "conversation_id"
    if-nez v5, +004h
    const-string v5, ""
    invoke-virtual v2, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string/jumbo v3, user_message_start
    invoke-virtual v5, v3, v0, v1, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
.end method

.method public final onUserMessageSuccess(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, taskId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    const-string/jumbo v1, user_message_success
    if-eqz v0, +01bh
    invoke-direct v5, v6, v1, Lcom/bytedance/trae/im/track/AgentMonitor;->hasReported(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-direct v5, v6, v1, Lcom/bytedance/trae/im/track/AgentMonitor;->markReported(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/AgentMonitor;->userMessageSuccessTimestamps Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-interface v0, v6, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, scope
    sget-object v3, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-direct v3, Lcom/bytedance/trae/im/track/AgentMonitor;->getScope()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, task_id
    invoke-virtual v3, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v6, "conversation_id"
    invoke-virtual v3, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v6, v1, v0, v2, v3, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xb
    :try_start_0x1c
.end method
