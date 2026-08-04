# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
.super Ljava/lang/Object;
.source "IChatSessionApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$EXMT_5bJ4WCBkjPLCFcJMx9McuQ(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall$lambda$4(Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QsPH3476_k6r3Z5okztZzA-YPto(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->wakeupSandboxRawCall$lambda$6(Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nGkiixe0m07G247L8Axwg_9tGoQ(java.lang.String  com.bytedance.trae.im.service.IChatSessionApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->wakeupSandboxRawCall$lambda$7(Ljava/lang/String; Lcom/bytedance/trae/im/service/IChatSessionApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tWtY8zPKy3shH1BOgHPI7IByNHc(java.lang.String  com.bytedance.trae.im.service.IChatSessionApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall$lambda$5(Ljava/lang/String; Lcom/bytedance/trae/im/service/IChatSessionApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    const-wide/16 v0, 0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getBASE_URL()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final getChatSessionRawCall$lambda$4(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=2
    const-string v0, "body"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    invoke-virtual v2, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->parseChatSessionRawBody$im_mainlandRelease(Ljava/lang/String;)Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    return-object v1
.end method

.method private static final getChatSessionRawCall$lambda$5(java.lang.String  com.bytedance.trae.im.service.IChatSessionApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/IChatSessionApi;->getChatSessionRaw(Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private static final wakeupSandboxRawCall$lambda$6(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=2
    const-string v0, "body"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    invoke-virtual v2, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->parseWakeupSandboxRawBody$im_mainlandRelease(Ljava/lang/String;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    return-object v1
.end method

.method private static final wakeupSandboxRawCall$lambda$7(java.lang.String  com.bytedance.trae.im.service.IChatSessionApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/IChatSessionApi;->wakeupSandboxRaw(Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method public final getChatSessionRawCall(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=3
    move-object/from16 v0, v16
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v2, "chat_session"
    const-class v3, Lcom/bytedance/trae/im/service/IChatSessionApi;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "api/remote/v1/chat_sessions/"
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v15, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getBASE_URL()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 1
    const/4 v10, 0
    new-instance v11, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda2;
    invoke-direct v11, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda2;-><init>()V
    new-instance v12, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda3;
    invoke-direct v12, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda3;-><init>(Ljava/lang/String;)V
    const/16 v13, 368
    const/4 v14, 0
    move-object v0, v1
    move-object v1, v2
    move-object v2, v3
    move-object v3, v4
    move-object v4, v5
    move-object v5, v6
    move v6, v7
    move-object v7, v8
    move v8, v9
    move v9, v10
    move-object v10, v11
    move-object v11, v12
    move-object/from16 v12, v17
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final parseChatSessionRawBody$im_mainlandRelease(java.lang.String)com.bytedance.trae.im.service.IChatSessionApi$Companion$ChatSessionRawParseResult
    .registers 16
    # ins_size=2
    const-string v0, "bodyStr"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v1, Ljava/lang/reflect/Type;
    const/4 v2, 1
    new-array v3, v2, [Ljava/lang/reflect/Type;
    const-class v4, Lcom/google/gson/JsonElement;
    const/4 v5, 0
    aput-object v4, v3, v5
    invoke-static v1, v3, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v1
    invoke-virtual v1, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v1
    invoke-virtual v0, v15, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonElement;
    const/4 v1, 0
    if-eqz v0, +012h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v3
    if-eqz v3, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v1
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    goto +2h
    move-object v3, v1
    if-eqz v0, +01eh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v1
    if-eqz v4, +012h
    sget-object v6, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v6, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v6
    const-class v7, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    invoke-virtual v6, v4, v7, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    move-object v12, v4
    goto +2h
    move-object v12, v1
    new-instance v4, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getPayload()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v13
    move-object v6, v4
    invoke-direct/range v6 ... v13, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v15, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    invoke-virtual v4, v15, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    new-instance v15, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;
    if-eqz v0, +004h
    move v0, v2
    goto +2h
    move v0, v5
    const-string/jumbo v6, sandbox
    if-eqz v3, +009h
    invoke-virtual v3, v6, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v7
    if-ne v7, v2, +003h
    goto +2h
    move v2, v5
    if-eqz v3, +00ch
    invoke-virtual v3, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v15, v4, v0, v2, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Z Z Ljava/lang/String;)V
    return-object v15
.end method

.method public final parseWakeupSandboxRawBody$im_mainlandRelease(java.lang.String)com.bytedance.trae.network.response.BizResponse
    .registers 13
    # ins_size=2
    const-string v0, "bodyStr"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v1, Ljava/lang/reflect/Type;
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/reflect/Type;
    const/4 v3, 0
    const-class v4, Lcom/google/gson/JsonElement;
    aput-object v4, v2, v3
    invoke-static v1, v2, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v1
    invoke-virtual v1, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v1
    invoke-virtual v0, v12, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/network/response/BizResponse;
    new-instance v10, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v1
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getPayload()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v7
    const/16 v8, 16
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v12, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    invoke-virtual v10, v12, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    return-object v10
.end method

.method public final wakeupSandboxRawCall(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "chat_session"
    const-class v2, Lcom/bytedance/trae/im/service/IChatSessionApi;
    const/4 v3, 0
    invoke-direct v15, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getBASE_URL()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 1
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda0;
    invoke-direct v10, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda0;-><init>()V
    new-instance v11, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda1;
    move-object/from16 v12, v16
    invoke-direct v11, v12, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String;)V
    const/16 v13, 372
    const/4 v14, 0
    move-object/from16 v12, v17
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
