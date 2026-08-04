# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/log/IMLog;
.super Ljava/lang/Object;
.source "IMLog.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/log/IMLog;
.field private static final MAX_LOG_LENGTH:I
.field private static final MAX_VALUE_LENGTH:I
.field private static final gson$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$BPd9vwXQlFZVmLsqAqbmqewfqVQ()com.google.gson.Gson
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/im/log/IMLog;->gson_delegate$lambda$0()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/log/IMLog;
    invoke-direct v0, Lcom/bytedance/trae/im/log/IMLog;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/log/IMLog;->INSTANCE Lcom/bytedance/trae/im/log/IMLog;
    new-instance v0, Lcom/bytedance/trae/im/log/IMLog$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/im/log/IMLog$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/log/IMLog;->gson$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getGson()com.google.gson.Gson
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/log/IMLog;->gson$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/google/gson/Gson;
    return-object v0
.end method

.method private static final gson_delegate$lambda$0()com.google.gson.Gson
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/google/gson/GsonBuilder;
    invoke-direct v0, Lcom/google/gson/GsonBuilder;-><init>()V
    const-class v1, Ljava/lang/Object;
    check-cast v1, Ljava/lang/reflect/Type;
    new-instance v2, Lcom/bytedance/trae/im/log/IMLog$ParsedContentTypeAdapter;
    invoke-direct v2, Lcom/bytedance/trae/im/log/IMLog$ParsedContentTypeAdapter;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type; Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->setPrettyPrinting()Lcom/google/gson/GsonBuilder;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method private final logFullJson(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 7
    # ins_size=3
    invoke-direct v4, Lcom/bytedance/trae/im/log/IMLog;->getGson()Lcom/google/gson/Gson;
    move-result-object v0
    invoke-virtual v0, v6, Lcom/google/gson/Gson;->toJsonTree(Ljava/lang/Object;)Lcom/google/gson/JsonElement;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v0, Lcom/bytedance/trae/im/log/IMLog;->truncateValues(Lcom/google/gson/JsonElement;)V
    invoke-direct v4, Lcom/bytedance/trae/im/log/IMLog;->getGson()Lcom/google/gson/Gson;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "["
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "] ParsedChatMessage fullJson (msgId="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", role="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRole()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v1, ", totalLen="
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v1
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const/16 v1, 41
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v3, "AgentDataFlowNew"
    invoke-virtual v1, v3, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "] fullJson"
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/im/log/IMLog;->logLongText(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final logLongText(java.lang.String  java.lang.String)void
    .registers 12
    # ins_size=3
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v0
    const-string v1, "AgentDataFlowNew"
    const/16 v2, 4000
    if-gt v0, v2, +01fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v2, ": "
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v0, v1, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v0
    add-int/2addr v0, v2
    const/4 v3, 1
    sub-int/2addr v0, v3
    div-int/2addr v0, v2
    const/4 v2, 0
    move v4, v3
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v5
    if-ge v2, v5, +049h
    add-int/lit16 v5, v2, 4000
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v6
    invoke-static v5, v6, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v5
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, " [part "
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const/16 v8, 47
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "]: "
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v11, v2, v5, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v8, substring(...)
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    add-int/2addr v4, v3
    move v2, v5
    goto -4ch
    return-void 
.end method

.method private final logPlanItems(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 16
    # ins_size=3
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v0
    const/16 v1, 41
    const-string v2, "["
    const-string v3, "AgentDataFlowNew"
    if-nez v0, +02ah
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/im/log/IMLog;
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v2, "] PlanItems: no taskContent (role="
    invoke-virtual v14, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRole()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v3, v14, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v15
    move-object v4, v15
    check-cast v4, Ljava/util/Collection;
    const/4 v5, 0
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    const/4 v4, 1
    if-eqz v4, +027h
    sget-object v15, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v2, "] PlanItems: empty (taskId="
    invoke-virtual v14, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v15, v3, v14, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "] PlanItems: count="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-interface v15, Ljava/util/List;->size()I
    move-result v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", taskId="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v15
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +0a2h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    add-int/lit8 v6, v5, 1
    if-gez v5, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "] PlanItem["
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v7, 47
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-interface v15, Ljava/util/List;->size()I
    move-result v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v7, 93
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    sget-object v7, Lcom/bytedance/trae/im/log/IMLog;->INSTANCE Lcom/bytedance/trae/im/log/IMLog;
    invoke-direct v7, Lcom/bytedance/trae/im/log/IMLog;->getGson()Lcom/google/gson/Gson;
    move-result-object v8
    invoke-virtual v8, v4, Lcom/google/gson/Gson;->toJsonTree(Ljava/lang/Object;)Lcom/google/gson/JsonElement;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v8, Lcom/bytedance/trae/im/log/IMLog;->truncateValues(Lcom/google/gson/JsonElement;)V
    invoke-direct v7, Lcom/bytedance/trae/im/log/IMLog;->getGson()Lcom/google/gson/Gson;
    move-result-object v9
    invoke-virtual v9, v8, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v10, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, " (id="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v11
    const/4 v12, 0
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v12
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", toolCall="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v4
    if-eqz v4, +00ch
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v10, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v9, v3, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v5, v8, Lcom/bytedance/trae/im/log/IMLog;->logLongText(Ljava/lang/String; Ljava/lang/String;)V
    move v5, v6
    goto/16 -0a4h
    return-void 
.end method

.method private final truncateValues(com.google.gson.JsonElement)void
    .registers 11
    # ins_size=2
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v0
    const/16 v1, 41
    const-string/jumbo v2, …(truncated, total=
    const/16 v3, 500
    if-eqz v0, +072h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v10
    invoke-virtual v10, Lcom/google/gson/JsonObject;->keySet()Ljava/util/Set;
    move-result-object v0
    const-string v4, "keySet(...)"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +0bch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v10, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +03eh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v6
    invoke-virtual v6, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v6
    if-eqz v6, +034h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v6
    if-le v6, v3, -028h
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v5, v3, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v5
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v10, v4, v5, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    goto -51h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v9, v5, Lcom/bytedance/trae/im/log/IMLog;->truncateValues(Lcom/google/gson/JsonElement;)V
    goto -58h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    if-eqz v0, +063h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v10
    invoke-virtual v10, Lcom/google/gson/JsonArray;->size()I
    move-result v0
    const/4 v4, 0
    if-ge v4, v0, +058h
    invoke-virtual v10, v4, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +045h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v6
    invoke-virtual v6, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v6
    if-eqz v6, +03bh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v6
    if-le v6, v3, +037h
    new-instance v6, Lcom/google/gson/JsonPrimitive;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v5, v3, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v5
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct v6, v5, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/String;)V
    check-cast v6, Lcom/google/gson/JsonElement;
    invoke-virtual v10, v4, v6, Lcom/google/gson/JsonArray;->set(I Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonElement;
    goto +7h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v9, v5, Lcom/bytedance/trae/im/log/IMLog;->truncateValues(Lcom/google/gson/JsonElement;)V
    add-int/lit8 v4, v4, 1
    goto -57h
    return-void 
.end method

.method public final logParsedChatMessage(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 6
    # ins_size=3
    const-string v0, "label"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/im/log/IMLog;->logFullJson(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/im/log/IMLog;->logPlanItems(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto +26h
    move-exception v5
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "["
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, "] logParsedChatMessage error: "
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "AgentDataFlowNew"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0xa
.end method
