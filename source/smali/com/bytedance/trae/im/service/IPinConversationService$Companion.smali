# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
.super Ljava/lang/Object;
.source "IPinConversationService.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$U1Q9UhV4uoZaNiskvW4HT-bx9d4(com.bytedance.trae.im.service.PinConversationRequest  com.bytedance.trae.im.service.IPinConversationService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->pinRawCall$lambda$1(Lcom/bytedance/trae/im/service/PinConversationRequest; Lcom/bytedance/trae/im/service/IPinConversationService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ZETAbnVAwmAPF-dS3y4Ey3xeLTs(com.bytedance.trae.im.service.PinConversationRequest  com.bytedance.trae.im.service.IPinConversationService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->unpinRawCall$lambda$3(Lcom/bytedance/trae/im/service/PinConversationRequest; Lcom/bytedance/trae/im/service/IPinConversationService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$j8hFY1vTU2_LEBVjwHjpssUgQmk(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->pinRawCall$lambda$0(Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ym42e2cECWpXUh4wiuInyIRz6U4(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->unpinRawCall$lambda$2(Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
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

.method private static final pinRawCall$lambda$0(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=2
    const-string v0, "body"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    invoke-virtual v2, v1, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->parseRawBody$im_mainlandRelease(Ljava/lang/String;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    return-object v1
.end method

.method private static final pinRawCall$lambda$1(com.bytedance.trae.im.service.PinConversationRequest  com.bytedance.trae.im.service.IPinConversationService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/IPinConversationService;->pinRaw(Lcom/bytedance/trae/im/service/PinConversationRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private static final unpinRawCall$lambda$2(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=2
    const-string v0, "body"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    invoke-virtual v2, v1, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->parseRawBody$im_mainlandRelease(Ljava/lang/String;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    return-object v1
.end method

.method private static final unpinRawCall$lambda$3(com.bytedance.trae.im.service.PinConversationRequest  com.bytedance.trae.im.service.IPinConversationService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/IPinConversationService;->unpinRaw(Lcom/bytedance/trae/im/service/PinConversationRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method public final parseRawBody$im_mainlandRelease(java.lang.String)com.bytedance.trae.network.response.BizResponse
    .registers 7
    # ins_size=2
    const-string v0, "bodyStr"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v1, Ljava/lang/reflect/Type;
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/reflect/Type;
    const/4 v3, 0
    const-class v4, Lcom/bytedance/trae/im/service/PinConversationResponse;
    aput-object v4, v2, v3
    invoke-static v1, v2, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v1
    invoke-virtual v1, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v1
    invoke-virtual v0, v6, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    sget-object v1, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->SUCCESS_CODES Ljava/util/Set;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    const-string v1, "apply(...)"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final pinRawCall(com.bytedance.trae.im.service.PinConversationRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "pin_conversation"
    const-class v2, Lcom/bytedance/trae/im/service/IPinConversationService;
    const/4 v3, 0
    const/4 v4, 0
    invoke-direct v15, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v5
    const/4 v6, 1
    sget-object v7, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda0;
    invoke-direct v10, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda0;-><init>()V
    new-instance v11, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda1;
    move-object/from16 v12, v16
    invoke-direct v11, v12, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/im/service/PinConversationRequest;)V
    const/16 v13, 396
    const/4 v14, 0
    move-object/from16 v12, v17
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final unpinRawCall(com.bytedance.trae.im.service.PinConversationRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "pin_conversation"
    const-class v2, Lcom/bytedance/trae/im/service/IPinConversationService;
    const/4 v3, 0
    const/4 v4, 0
    invoke-direct v15, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v5
    const/4 v6, 1
    sget-object v7, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda2;
    invoke-direct v10, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda2;-><init>()V
    new-instance v11, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda3;
    move-object/from16 v12, v16
    invoke-direct v11, v12, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/im/service/PinConversationRequest;)V
    const/16 v13, 396
    const/4 v14, 0
    move-object/from16 v12, v17
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
