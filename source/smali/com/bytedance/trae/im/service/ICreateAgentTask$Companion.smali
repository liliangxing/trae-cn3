# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$ASRyn786m_Hdy9Q0LztrpNAqGgs(com.bytedance.trae.im.service.CreateTaskRequest  com.bytedance.trae.im.service.ICreateAgentTask  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->createAgentTaskRawCall$lambda$0(Lcom/bytedance/trae/im/service/CreateTaskRequest; Lcom/bytedance/trae/im/service/ICreateAgentTask; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final createAgentTaskRawCall$lambda$0(com.bytedance.trae.im.service.CreateTaskRequest  com.bytedance.trae.im.service.ICreateAgentTask  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCallWithBody"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/ICreateAgentTask;->createAgentTaskRaw(Lcom/bytedance/trae/im/service/CreateTaskRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private final getDEFAULT_HEADERS()java.util.Map
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/network/DebugSettings;->buildDefaultHeaders$default(Lcom/bytedance/trae/network/DebugSettings; Ljava/util/Map; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method private final parseErrorData(java.lang.String)com.google.gson.JsonObject
    .registers 4
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    invoke-static v3, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +029h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +01fh
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +019h
    const-string v1, "data"
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    goto +2h
    move-object v3, v0
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Lcom/google/gson/JsonObject;
    return-object v0
    :try_start_0x1
.end method

.method private final parseErrorDetail(java.lang.String  java.lang.String)com.bytedance.trae.im.service.CreateTaskErrorDetail
    .registers 8
    # ins_size=3
    const-string v0, "error"
    invoke-static v6, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v6
    invoke-virtual v6, v0, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +036h
    invoke-virtual v6, v0, Lcom/google/gson/JsonObject;->getAsJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    const-string v1, "block_reason"
    invoke-virtual v6, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v1
    goto +2h
    move v1, v2
    const-string v3, "limit"
    invoke-virtual v6, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v3
    goto +2h
    move v3, v2
    const-string/jumbo v4, running
    invoke-virtual v6, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v2
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;-><init>(I I I)V
    goto +ah
    invoke-direct v5, v7, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->parseErrorDetailFromMessage(Ljava/lang/String;)Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    move-result-object v0
    goto +5h
    invoke-direct v5, v7, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->parseErrorDetailFromMessage(Ljava/lang/String;)Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    move-result-object v0
    return-object v0
    :try_start_0x2
.end method

.method private final parseErrorDetailFromMessage(java.lang.String)com.bytedance.trae.im.service.CreateTaskErrorDetail
    .registers 10
    # ins_size=2
    check-cast v9, Ljava/lang/CharSequence;
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v9, +00bh
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v0
    const/4 v3, 0
    if-eqz v2, +003h
    return-object v3
    new-instance v2, Lkotlin/text/Regex;
    const-string v4, "block_reason=(\d+)"
    invoke-direct v2, v4, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    const/4 v4, 2
    invoke-static v2, v9, v1, v4, v3, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v2
    if-eqz v2, +015h
    invoke-interface v2, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +00fh
    invoke-static v2, v0, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-eqz v2, +007h
    invoke-static v2, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v2
    goto +2h
    move-object v2, v3
    new-instance v5, Lkotlin/text/Regex;
    const-string v6, "limit=(\d+)"
    invoke-direct v5, v6, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-static v5, v9, v1, v4, v3, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v5
    if-eqz v5, +01bh
    invoke-interface v5, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +015h
    invoke-static v5, v0, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    if-eqz v5, +00dh
    invoke-static v5, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v5
    goto +2h
    move v5, v1
    new-instance v6, Lkotlin/text/Regex;
    const-string/jumbo v7, running=(\d+)
    invoke-direct v6, v7, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-static v6, v9, v1, v4, v3, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v9
    if-eqz v9, +01ah
    invoke-interface v9, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v9
    if-eqz v9, +014h
    invoke-static v9, v0, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    if-eqz v9, +00ch
    invoke-static v9, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v9
    if-eqz v9, +006h
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v1
    if-eqz v2, +00bh
    new-instance v3, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v9
    invoke-direct v3, v9, v5, v1, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;-><init>(I I I)V
    return-object v3
.end method

.method public final createAgentTaskRawCall(com.bytedance.trae.im.service.CreateTaskRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    instance-of v3, v2, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;
    if-eqz v3, +012h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;
    iget v4, v3, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v2, v3, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->label I
    sub-int/2addr v2, v5
    iput v2, v3, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;-><init>(Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion; Lkotlin/coroutines/Continuation;)V
    move-object v15, v3
    iget-object v2, v15, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v15, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->label I
    const/4 v5, 1
    const-string v14, "ICreateAgentTask"
    if-eqz v4, +018h
    if-ne v4, v5, +00eh
    iget-object v1, v15, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v3, v2
    move-object v2, v1
    move-object v1, v14
    goto/16 +095h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    const-string v4, "create_task"
    invoke-virtual v2, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->triggerRefreshIfNeeded(Ljava/lang/String;)Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v6, "POST /api/solo_hub/v1/conversations/tasks/create rawCall: conversationId="
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/im/service/CreateTaskRequest;->getConversationId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", cliId="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v19, Lcom/bytedance/trae/im/service/CreateTaskRequest;->getCliId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", cliType="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v19, Lcom/bytedance/trae/im/service/CreateTaskRequest;->getCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v14, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v6, "POST /api/solo_hub/v1/conversations/tasks/create requestBody="
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v6, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v6
    invoke-virtual v6, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v14, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v2, "base"
    const-class v6, Lcom/bytedance/trae/im/service/ICreateAgentTask;
    const-class v7, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    check-cast v7, Ljava/lang/reflect/Type;
    const/4 v8, 0
    const/4 v9, 0
    invoke-direct/range v18, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v10
    const/4 v11, 1
    sget-object v12, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->SUCCESS_CODES Ljava/util/Set;
    new-instance v13, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$$ExternalSyntheticLambda0;
    invoke-direct v13, v1, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/service/CreateTaskRequest;)V
    const/16 v16, 280
    const/16 v17, 0
    iput-object v0, v15, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->L$0 Ljava/lang/Object;
    iput v5, v15, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$createAgentTaskRawCall$1;->label I
    move-object v5, v2
    move-object v2, v13
    const/4 v1, 0
    move v13, v1
    move-object v1, v14
    move-object v14, v2
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v3, +003h
    return-object v3
    move-object v3, v2
    move-object v2, v0
    check-cast v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v4
    instance-of v5, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v6, 0
    if-eqz v5, +005h
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    goto +2h
    move-object v4, v6
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getBody()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +011h
    if-eqz v4, +00fh
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-direct v2, v5, v7, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->parseErrorDetail(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    move-result-object v7
    goto +2h
    move-object v7, v6
    if-eqz v5, +008h
    if-eqz v4, +006h
    invoke-direct v2, v5, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->parseErrorData(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v7, +036h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "rawCall: errorDetail blockReason="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;->getBlockReason()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", limit="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;->getLimit()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", running="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;->getRunning()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v1, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v2
    invoke-direct v1, v2, v7, v6, Lcom/bytedance/trae/im/service/CreateTaskRawResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Lcom/bytedance/trae/im/service/CreateTaskErrorDetail; Lcom/google/gson/JsonObject;)V
    return-object v1
.end method

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "base"
    const-class v2, Lcom/bytedance/trae/im/service/ICreateAgentTask;
    invoke-direct v10, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v3
    const/4 v5, 0
    const/4 v6, 0
    const/16 v8, 48
    const/4 v9, 0
    move-object v4, v11
    move-object v7, v12
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    return-object v11
.end method
