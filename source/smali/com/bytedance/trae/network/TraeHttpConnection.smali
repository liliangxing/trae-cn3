# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/TraeHttpConnection;
.super Ljava/lang/Object;
.source "TraeHttpConnection.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/TraeHttpConnection;
.field private static final apiRespInterceptors:Ljava/util/concurrent/CopyOnWriteArrayList;
.field private static final httpGson:Lcom/google/gson/Gson;
.field private static final interceptor:Lcom/bytedance/retrofit2/intercept/Interceptor;


.method public static synthetic $r8$lambda$SYIHu2BUGDsRgQTU6f8F-YjgG0E(java.lang.reflect.Type  java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$lambda$15(Ljava/lang/reflect/Type; Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VnPw36bnXLgmKxRkwGnEu7LPtyY(java.lang.String  java.util.Map  boolean  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$lambda$11(Ljava/lang/String; Ljava/util/Map; Z Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$h5DZwOljY8mp3ILpEaHJRf1xRkY(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/TraeHttpConnection;->interceptor$lambda$3(Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$l-voyZFwfkAoART7GY8hmVGo2as(kotlin.jvm.functions.Function2  java.lang.Object  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.SsResponse
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$lambda$12(Lkotlin/jvm/functions/Function2; Ljava/lang/Object; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nICCAA9HMD5wDAzc2lMmUDfvE14(kotlin.jvm.functions.Function2  java.lang.Object  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.SsResponse
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$lambda$13(Lkotlin/jvm/functions/Function2; Ljava/lang/Object; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-direct v0, Lcom/bytedance/trae/network/TraeHttpConnection;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    new-instance v0, Lcom/google/gson/GsonBuilder;
    invoke-direct v0, Lcom/google/gson/GsonBuilder;-><init>()V
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v0
    const-string v1, "create(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->httpGson Lcom/google/gson/Gson;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    new-instance v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda4;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->interceptor Lcom/bytedance/retrofit2/intercept/Interceptor;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$elapsedRealtime(com.bytedance.trae.network.TraeHttpConnection)long
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/network/TraeHttpConnection;->elapsedRealtime()J
    move-result-wide v0
    return-wide v0
.end method

.method public static final synthetic access$extractErrorInfo(com.bytedance.trae.network.TraeHttpConnection  java.lang.Throwable)com.bytedance.trae.network.TraeHttpConnection$ErrorInfo
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection;->extractErrorInfo(Ljava/lang/Throwable;)Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$normalizeJsonBody(com.bytedance.trae.network.TraeHttpConnection  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection;->normalizeJsonBody(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$readRawBody(com.bytedance.trae.network.TraeHttpConnection  com.bytedance.retrofit2.SsResponse)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection;->readRawBody(Lcom/bytedance/retrofit2/SsResponse;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$successResult(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  com.bytedance.trae.network.response.BizResponse)com.bytedance.trae.network.response.HttpDataResult
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection;->successResult(Ljava/lang/String; Lcom/bytedance/trae/network/response/BizResponse;)Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$takeIfPresentBody(com.bytedance.trae.network.TraeHttpConnection  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection;->takeIfPresentBody(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$trackRequestEventSafely(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  long  com.bytedance.trae.network.response.HttpDataResult)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/TraeHttpConnection;->trackRequestEventSafely(Ljava/lang/String; J Lcom/bytedance/trae/network/response/HttpDataResult;)V
    return-void 
.end method

.method public static synthetic buildServiceHeaders$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.util.Map  boolean  boolean  java.lang.String  java.util.Map  java.lang.String  java.util.Map  java.util.Map  int  java.lang.Object)java.util.Map
    .registers 21
    # ins_size=12
    move/from16 v0, v19
    and-int/lit8 v1, v0, 2
    if-eqz v1, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    goto +2h
    move-object v1, v11
    and-int/lit8 v2, v0, 4
    if-eqz v2, +004h
    const/4 v2, 0
    goto +2h
    move v2, v12
    and-int/lit8 v3, v0, 8
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    move v3, v13
    and-int/lit8 v4, v0, 16
    if-eqz v4, +009h
    sget-object v4, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v14
    and-int/lit8 v5, v0, 32
    const/4 v6, 0
    if-eqz v5, +004h
    move-object v5, v6
    goto +2h
    move-object v5, v15
    and-int/lit8 v7, v0, 64
    if-eqz v7, +005h
    const-string v7, ""
    goto +3h
    move-object/from16 v7, v16
    and-int/lit16 v8, v0, 128
    if-eqz v8, +004h
    move-object v8, v6
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v0, v0, 256
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v6, v18
    move-object v11, v9
    move-object v12, v10
    move-object v13, v1
    move v14, v2
    move v15, v3
    move-object/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v6
    invoke-virtual/range v11 ... v20, Lcom/bytedance/trae/network/TraeHttpConnection;->buildServiceHeaders(Ljava/lang/String; Ljava/util/Map; Z Z Ljava/lang/String; Ljava/util/Map; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic createService$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.Class  com.bytedance.retrofit2.Converter$Factory  java.lang.String  java.util.Map  boolean  int  java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 4
    if-eqz v15, +003h
    const/4 v10, 0
    move-object v3, v10
    and-int/lit8 v10, v14, 8
    if-eqz v10, +006h
    invoke-virtual v7, Lcom/bytedance/trae/network/TraeHttpConnection;->baseUrl()Ljava/lang/String;
    move-result-object v11
    move-object v4, v11
    and-int/lit8 v10, v14, 16
    if-eqz v10, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v12
    move-object v5, v12
    and-int/lit8 v10, v14, 32
    if-eqz v10, +003h
    const/4 v13, 0
    move v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/network/TraeHttpConnection;->createService(Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method private static final createService$lambda$11(java.lang.String  java.util.Map  boolean  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 17
    # ins_size=4
    invoke-interface/range v16, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 496
    const/4 v12, 0
    move-object v2, v13
    move-object v3, v14
    move v4, v15
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/network/TraeHttpConnection;->buildServiceHeaders$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/util/Map; Z Z Ljava/lang/String; Ljava/util/Map; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getHeaders()Ljava/util/List;
    move-result-object v2
    const-string v3, "getHeaders(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/util/Collection;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v2
    invoke-interface v1, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v1
    invoke-interface v1, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    new-instance v5, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v5, v4, v3, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -20h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/retrofit2/client/Request$Builder;->headers(Ljava/util/List;)Lcom/bytedance/retrofit2/client/Request$Builder;
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    move-object/from16 v1, v16
    invoke-interface v1, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method private final elapsedRealtime()long
    .registers 3
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-nez v1, +003h
    goto +9h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    return-wide v0
    :try_start_0x0
.end method

.method private final extractErrorInfo(java.lang.Throwable)com.bytedance.trae.network.TraeHttpConnection$ErrorInfo
    .registers 4
    # ins_size=2
    instance-of v0, v3, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    const-string v1, ""
    if-eqz v0, +012h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    invoke-virtual v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;->getStatusCode()I
    move-result v0
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +1fh
    move-object v1, v3
    goto +1dh
    instance-of v0, v3, Lcom/bytedance/frameworks/baselib/network/http/exception/NetworkNotAvailabeException;
    if-eqz v0, +010h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/frameworks/baselib/network/http/exception/NetworkNotAvailabeException;
    invoke-virtual v0, Lcom/bytedance/frameworks/baselib/network/http/exception/NetworkNotAvailabeException;->getCronetInternalErrorCode()I
    move-result v0
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-nez v3, -011h
    goto +bh
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v1, v3
    const/16 v0, -1000
    new-instance v3, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;-><init>(I Ljava/lang/String;)V
    return-object v3
.end method

.method private static final interceptor$lambda$3(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 8
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getCommonParams()Ljava/util/Map;
    move-result-object v0
    invoke-interface v7, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/frameworks/baselib/network/http/util/UrlBuilder;
    invoke-virtual v1, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/frameworks/baselib/network/http/util/UrlBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/Map$Entry;
    invoke-interface v4, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    invoke-interface v4, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v3, v5, v4, Lcom/bytedance/frameworks/baselib/network/http/util/UrlBuilder;->addParam(Ljava/lang/String; Ljava/lang/String;)V
    goto -1bh
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getCommonAppendHeaders()Ljava/util/Map;
    move-result-object v0
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    invoke-virtual v1, Lcom/bytedance/retrofit2/client/Request;->getHeaders()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-virtual v4, v1, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    new-instance v5, Lcom/bytedance/retrofit2/client/Header;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-direct v5, v6, v1, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, v5, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -20h
    invoke-virtual v3, Lcom/bytedance/frameworks/baselib/network/http/util/UrlBuilder;->build()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Lcom/bytedance/retrofit2/client/Request$Builder;->url(Ljava/lang/String;)Lcom/bytedance/retrofit2/client/Request$Builder;
    check-cast v4, Ljava/util/List;
    invoke-virtual v2, v4, Lcom/bytedance/retrofit2/client/Request$Builder;->headers(Ljava/util/List;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-interface v7, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v7
    return-object v7
.end method

.method private final normalizeJsonBody(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, """
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +015h
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00fh
    sget-object v7, Lcom/bytedance/trae/network/TraeHttpConnection;->httpGson Lcom/google/gson/Gson;
    const-class v1, Ljava/lang/String;
    invoke-virtual v7, v0, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v7, Ljava/lang/String;
    return-object v7
.end method

.method public static synthetic rawBizCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.Class  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 30
    # ins_size=15
    move/from16 v0, v28
    and-int/lit8 v1, v0, 4
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v5, v1
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v1, v0, 8
    if-eqz v1, +008h
    invoke-virtual v15, Lcom/bytedance/trae/network/TraeHttpConnection;->baseUrl()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v1, v0, 16
    if-eqz v1, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v20
    and-int/lit8 v1, v0, 32
    const/4 v2, 0
    if-eqz v1, +004h
    move v8, v2
    goto +3h
    move/from16 v8, v21
    and-int/lit8 v1, v0, 64
    if-eqz v1, +00ah
    sget-object v1, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v1
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v22
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move v10, v2
    goto +3h
    move/from16 v10, v23
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v24
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move-object/from16 v12, v25
    move-object/from16 v13, v26
    move-object/from16 v14, v27
    invoke-virtual/range v2 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic rawBizCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.Class  java.lang.reflect.Type  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 28
    # ins_size=14
    move/from16 v0, v26
    and-int/lit8 v1, v0, 8
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v1, v0, 16
    if-eqz v1, +008h
    invoke-virtual v14, Lcom/bytedance/trae/network/TraeHttpConnection;->baseUrl()Ljava/lang/String;
    move-result-object v1
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v1, v0, 32
    if-eqz v1, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v20
    and-int/lit8 v1, v0, 64
    const/4 v2, 0
    if-eqz v1, +004h
    move v9, v2
    goto +3h
    move/from16 v9, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +00ah
    sget-object v1, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v1
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v23
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    move-object/from16 v12, v24
    move-object/from16 v13, v25
    invoke-virtual/range v2 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic rawBizCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 1
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v2, v0
    goto +2h
    move-object v2, v10
    and-int/lit8 v0, v17, 2
    if-eqz v0, +00ah
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    move-object v3, v0
    goto +2h
    move-object v3, v11
    and-int/lit8 v0, v17, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move v4, v1
    goto +2h
    move v4, v12
    and-int/lit8 v0, v17, 8
    if-eqz v0, +004h
    move v5, v1
    goto +2h
    move v5, v13
    move-object v1, v9
    move-object v6, v14
    move-object v7, v15
    move-object/from16 v8, v16
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall(Ljava/lang/String; Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic rawBizCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.reflect.Type  java.lang.String  java.util.Set  boolean  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 2
    if-eqz v15, +003h
    const/4 v9, 0
    move-object v2, v9
    and-int/lit8 v9, v14, 4
    if-eqz v9, +008h
    sget-object v9, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v10
    move-object v3, v10
    and-int/lit8 v9, v14, 8
    if-eqz v9, +003h
    const/4 v11, 0
    move v4, v11
    move-object v0, v7
    move-object v1, v8
    move-object v5, v12
    move-object v6, v13
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall(Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/util/Set; Z Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method public static synthetic rawBizCallWithBody$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.Class  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 30
    # ins_size=15
    move/from16 v0, v28
    and-int/lit8 v1, v0, 4
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v5, v1
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v1, v0, 8
    if-eqz v1, +008h
    invoke-virtual v15, Lcom/bytedance/trae/network/TraeHttpConnection;->baseUrl()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v1, v0, 16
    if-eqz v1, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v20
    and-int/lit8 v1, v0, 32
    const/4 v2, 0
    if-eqz v1, +004h
    move v8, v2
    goto +3h
    move/from16 v8, v21
    and-int/lit8 v1, v0, 64
    if-eqz v1, +00ah
    sget-object v1, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v1
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v22
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move v10, v2
    goto +3h
    move/from16 v10, v23
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v24
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move-object/from16 v12, v25
    move-object/from16 v13, v26
    move-object/from16 v14, v27
    invoke-virtual/range v2 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic rawBizCallWithBody$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.Class  java.lang.reflect.Type  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 28
    # ins_size=14
    move/from16 v0, v26
    and-int/lit8 v1, v0, 8
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v1, v0, 16
    if-eqz v1, +008h
    invoke-virtual v14, Lcom/bytedance/trae/network/TraeHttpConnection;->baseUrl()Ljava/lang/String;
    move-result-object v1
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v1, v0, 32
    if-eqz v1, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v20
    and-int/lit8 v1, v0, 64
    const/4 v2, 0
    if-eqz v1, +004h
    move v9, v2
    goto +3h
    move/from16 v9, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +00ah
    sget-object v1, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v1
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v23
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    move-object/from16 v12, v24
    move-object/from16 v13, v25
    invoke-virtual/range v2 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic rawBizCallWithBody$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 1
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v2, v0
    goto +2h
    move-object v2, v10
    and-int/lit8 v0, v17, 2
    if-eqz v0, +00ah
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    move-object v3, v0
    goto +2h
    move-object v3, v11
    and-int/lit8 v0, v17, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move v4, v1
    goto +2h
    move v4, v12
    and-int/lit8 v0, v17, 8
    if-eqz v0, +004h
    move v5, v1
    goto +2h
    move v5, v13
    move-object v1, v9
    move-object v6, v14
    move-object v7, v15
    move-object/from16 v8, v16
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/String; Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic rawBizCallWithBody$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.reflect.Type  java.lang.String  java.util.Set  boolean  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 2
    if-eqz v15, +003h
    const/4 v9, 0
    move-object v2, v9
    and-int/lit8 v9, v14, 4
    if-eqz v9, +008h
    sget-object v9, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v10
    move-object v3, v10
    and-int/lit8 v9, v14, 8
    if-eqz v9, +003h
    const/4 v11, 0
    move v4, v11
    move-object v0, v7
    move-object v1, v8
    move-object v5, v12
    move-object v6, v13
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/util/Set; Z Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method private static final rawBizCallWithBody$lambda$12(kotlin.jvm.functions.Function2  java.lang.Object  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.SsResponse
    .registers 4
    # ins_size=3
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/retrofit2/Call;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method private static final rawBizCallWithBody$lambda$13(kotlin.jvm.functions.Function2  java.lang.Object  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.SsResponse
    .registers 4
    # ins_size=3
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/retrofit2/Call;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method private static final rawBizCallWithBody$lambda$15(java.lang.reflect.Type  java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 7
    # ins_size=3
    const-string v0, "body"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, ssResponse
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->httpGson Lcom/google/gson/Gson;
    const-class v1, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v1, Ljava/lang/reflect/Type;
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/reflect/Type;
    const/4 v3, 0
    aput-object v4, v2, v3
    invoke-static v1, v2, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v4
    invoke-virtual v4, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v4
    invoke-virtual v0, v5, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v5, v6, Lcom/bytedance/trae/network/response/BizResponse;->setupSSResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    const-string v6, "apply(...)"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method

.method private final readRawBody(com.bytedance.retrofit2.SsResponse)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +03eh
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +037h
    invoke-interface v4, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v4
    if-eqz v4, +031h
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v2, Ljava/io/InputStreamReader;
    invoke-direct v2, v4, v1, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v2, Ljava/io/Reader;
    instance-of v4, v2, Ljava/io/BufferedReader;
    if-eqz v4, +005h
    check-cast v2, Ljava/io/BufferedReader;
    goto +9h
    new-instance v4, Ljava/io/BufferedReader;
    const/16 v1, 8192
    invoke-direct v4, v2, v1, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v2, v4
    check-cast v2, Ljava/io/Closeable;
    move-object v4, v2
    check-cast v4, Ljava/io/BufferedReader;
    check-cast v4, Ljava/io/Reader;
    invoke-static v4, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    move-object v0, v4
    goto +8h
    move-exception v4
    throw v4
    move-exception v0
    invoke-static v2, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v0
    return-object v0
    :try_start_0x2f
    :try_start_0x3e
.end method

.method public static synthetic safeCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.String  java.lang.reflect.Type  java.lang.String  java.lang.Class  java.util.Map  kotlin.jvm.functions.Function1  java.util.Set  int  java.lang.Object)com.bytedance.trae.network.response.HttpDataResult
    .registers 23
    # ins_size=11
    move/from16 v0, v21
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v0, v0, 128
    if-eqz v0, +00ah
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    move-object v11, v0
    goto +3h
    move-object/from16 v11, v20
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v8, v17
    move-object/from16 v10, v19
    invoke-virtual/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall(Ljava/lang/String; Ljava/lang/String; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function1; Ljava/util/Set;)Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic safeCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.reflect.Type  java.lang.String  java.lang.Class  java.util.Map  kotlin.jvm.functions.Function1  java.util.Set  int  java.lang.Object)com.bytedance.trae.network.response.HttpDataResult
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v18, 16
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v15
    and-int/lit8 v0, v18, 64
    if-eqz v0, +00ah
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    move-object v9, v0
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v6, v14
    move-object/from16 v8, v16
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall(Ljava/lang/String; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function1; Ljava/util/Set;)Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic safeCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.Class  java.util.Map  kotlin.jvm.functions.Function2  java.lang.String  java.util.Set  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 16
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v6, v0
    goto +2h
    move-object v6, v14
    and-int/lit8 v0, v17, 32
    if-eqz v0, +00ah
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    move-object v7, v0
    goto +2h
    move-object v7, v15
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object/from16 v8, v16
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall(Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic safeCall$default(com.bytedance.trae.network.TraeHttpConnection  java.lang.String  java.lang.Class  kotlin.jvm.functions.Function2  java.lang.String  java.util.Set  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 8
    if-eqz v15, +003h
    const/4 v11, 0
    move-object v4, v11
    and-int/lit8 v11, v14, 16
    if-eqz v11, +008h
    sget-object v11, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v12
    move-object v5, v12
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v6, v13
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall(Ljava/lang/String; Ljava/lang/Class; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method private final successResult(java.lang.String  com.bytedance.trae.network.response.BizResponse)com.bytedance.trae.network.response.HttpDataResult
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    const/4 v3, 0
    if-eqz v1, +01ch
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/IApiRespInterceptor;
    invoke-interface v1, v5, v6, Lcom/bytedance/trae/network/IApiRespInterceptor;->intercept(Ljava/lang/String; Lcom/bytedance/trae/network/response/BizResponse;)Z
    move-result v1
    if-eqz v1, -010h
    move v3, v2
    goto -13h
    new-instance v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v0, 0
    if-eqz v3, +008h
    new-instance v1, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;
    invoke-direct v1, v0, v2, v0, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;-><init>(Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Ljava/lang/Throwable;
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v5
.end method

.method private final takeIfPresentBody(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00ch
    const-string/jumbo v1, null
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2h
    const/4 v3, 0
    return-object v3
.end method

.method private final trackRequestEvent(java.lang.String  long  com.bytedance.trae.network.response.HttpDataResult)void
    .registers 14
    # ins_size=5
    instance-of v0, v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +086h
    sget-object v1, Lcom/bytedance/trae/network/TraeRequestEventReporter;->INSTANCE Lcom/bytedance/trae/network/TraeRequestEventReporter;
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00eh
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    move-object v7, v0
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/network/response/BizResponse;->getSSResponse()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v13
    if-eqz v13, +049h
    invoke-virtual v13, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v13
    if-eqz v13, +043h
    check-cast v13, Ljava/lang/Iterable;
    const/16 v0, 10
    invoke-static v13, v0, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v0
    const/16 v2, 16
    invoke-static v0, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, v0, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v2, Ljava/util/Map;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +021h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-virtual v0, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v3
    invoke-virtual v0, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    invoke-interface v2, v3, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -23h
    const/4 v2, 0
    if-nez v2, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v13
    move-object v8, v13
    goto +2h
    move-object v8, v2
    move-object v2, v10
    move-wide v3, v11
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/TraeRequestEventReporter;->report(Ljava/lang/String; J J Ljava/lang/String; Ljava/util/Map;)V
    goto +1bh
    instance-of v0, v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +019h
    sget-object v1, Lcom/bytedance/trae/network/TraeRequestEventReporter;->INSTANCE Lcom/bytedance/trae/network/TraeRequestEventReporter;
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    int-to-long v5, v0
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v7
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v8
    move-object v2, v10
    move-wide v3, v11
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/TraeRequestEventReporter;->report(Ljava/lang/String; J J Ljava/lang/String; Ljava/util/Map;)V
    return-void 
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
.end method

.method private final trackRequestEventSafely(java.lang.String  long  com.bytedance.trae.network.response.HttpDataResult)void
    .registers 6
    # ins_size=5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/network/TraeHttpConnection;->trackRequestEvent(Ljava/lang/String; J Lcom/bytedance/trae/network/response/HttpDataResult;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method public final addApiRespInterceptor(com.bytedance.trae.network.IApiRespInterceptor)boolean
    .registers 3
    # ins_size=2
    const-string v0, "interceptor"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final appendParamToBody(com.bytedance.retrofit2.client.Request$Builder  com.bytedance.retrofit2.client.Request  kotlin.jvm.functions.Function1)void
    .registers 7
    # ins_size=4
    const-string v0, "<this>"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, request
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "appendParam"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v0, Ljava/io/ByteArrayOutputStream;
    invoke-direct v0, Ljava/io/ByteArrayOutputStream;-><init>()V
    invoke-virtual v5, Lcom/bytedance/retrofit2/client/Request;->getBody()Lcom/bytedance/retrofit2/mime/TypedOutput;
    move-result-object v1
    move-object v2, v0
    check-cast v2, Ljava/io/OutputStream;
    invoke-interface v1, v2, Lcom/bytedance/retrofit2/mime/TypedOutput;->writeTo(Ljava/io/OutputStream;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-virtual v0, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-interface v6, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/retrofit2/client/Request;->getMethod()Ljava/lang/String;
    move-result-object v6
    new-instance v0, Lcom/bytedance/retrofit2/mime/TypedByteArray;
    invoke-virtual v5, Lcom/bytedance/retrofit2/client/Request;->getBody()Lcom/bytedance/retrofit2/mime/TypedOutput;
    move-result-object v5
    invoke-interface v5, Lcom/bytedance/retrofit2/mime/TypedOutput;->mimeType()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v1, v2, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v1
    const-string v2, "getBytes(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    new-array v2, v2, [Ljava/lang/String;
    invoke-direct v0, v5, v1, v2, Lcom/bytedance/retrofit2/mime/TypedByteArray;-><init>(Ljava/lang/String; [B [Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/retrofit2/mime/TypedOutput;
    invoke-virtual v4, v6, v0, Lcom/bytedance/retrofit2/client/Request$Builder;->method(Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedOutput;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v4
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x10
.end method

.method public final baseUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getOnlineBaseUrl()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final buildServiceHeaders(java.lang.String  java.util.Map  boolean  boolean  java.lang.String  java.util.Map  java.lang.String  java.util.Map  java.util.Map)java.util.Map
    .registers 14
    # ins_size=10
    const-string v0, "extraHeaders"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ideToken"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "envLane"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v5, +019h
    move-object v3, v5
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v5, v1
    if-eqz v5, +00bh
    const-string/jumbo v3, x-ttnet-req-biz-id
    invoke-interface v0, v3, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    move-object v5, v9
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    const/4 v3, 0
    if-lez v5, +004h
    move v5, v2
    goto +2h
    move v5, v3
    if-eqz v5, +008h
    const-string/jumbo v5, x-ide-token
    invoke-interface v0, v5, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v7, +015h
    const-string v5, "X-Use-PPE"
    invoke-interface v6, v5, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00dh
    if-nez v10, +008h
    sget-object v5, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v5, Lcom/bytedance/trae/network/DebugSettings;->getPpeHeaders()Ljava/util/Map;
    move-result-object v10
    invoke-interface v0, v10, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    move-object v5, v11
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +003h
    goto +2h
    move-object v11, v1
    if-eqz v11, +00ah
    const-string v5, "X-Env-Lane"
    invoke-interface v0, v5, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    if-nez v12, +008h
    sget-object v5, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v5, Lcom/bytedance/trae/network/DebugSettings;->getCustomHeaders()Ljava/util/Map;
    move-result-object v12
    invoke-interface v0, v12, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    invoke-interface v0, v6, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    if-eqz v8, +00dh
    if-nez v13, +008h
    sget-object v5, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getCommonAppendHeaders()Ljava/util/Map;
    move-result-object v13
    invoke-interface v0, v13, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    invoke-static v0, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v5
    return-object v5
.end method

.method public final createService(java.lang.String  java.lang.Class  com.bytedance.retrofit2.Converter$Factory  java.lang.String  java.util.Map  boolean)java.lang.Object
    .registers 8
    # ins_size=7
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "apiClazz"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "baseUrl"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraHeaders"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, v6, v7, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; Ljava/util/Map; Z)V
    const/4 v2, 2
    new-array v2, v2, [Lcom/bytedance/retrofit2/intercept/Interceptor;
    const/4 v6, 0
    aput-object v0, v2, v6
    const/4 v6, 1
    sget-object v7, Lcom/bytedance/trae/network/TraeHttpConnection;->interceptor Lcom/bytedance/retrofit2/intercept/Interceptor;
    aput-object v7, v2, v6
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-static v5, v2, v4, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v2
    invoke-virtual v2, v3, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final getHttpGson()com.google.gson.Gson
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->httpGson Lcom/google/gson/Gson;
    return-object v0
.end method

.method public final getInterceptor()com.bytedance.retrofit2.intercept.Interceptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->interceptor Lcom/bytedance/retrofit2/intercept/Interceptor;
    return-object v0
.end method

.method public final rawBizCall(java.lang.String  java.lang.Class  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 29
    # ins_size=13
    move-object/from16 v0, v28
    instance-of v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;
    iget v2, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;->label I
    move-object/from16 v15, v16
    goto +8h
    new-instance v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;
    move-object/from16 v15, v16
    invoke-direct v1, v15, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;-><init>(Lcom/bytedance/trae/network/TraeHttpConnection; Lkotlin/coroutines/Continuation;)V
    move-object v14, v1
    iget-object v0, v14, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v14, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v3, v14, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$2;->label I
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v21
    move/from16 v8, v22
    move-object/from16 v9, v23
    move/from16 v10, v24
    move/from16 v11, v25
    move-object/from16 v12, v26
    move-object/from16 v13, v27
    invoke-virtual/range v2 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method

.method public final rawBizCall(java.lang.String  java.lang.Class  java.lang.reflect.Type  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=12
    move-object/from16 v0, v26
    instance-of v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;
    if-eqz v1, +013h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;
    iget v2, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +009h
    iget v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->label I
    move-object v14, v15
    goto +7h
    new-instance v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;
    move-object v14, v15
    invoke-direct v1, v15, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;-><init>(Lcom/bytedance/trae/network/TraeHttpConnection; Lkotlin/coroutines/Continuation;)V
    move-object v13, v1
    iget-object v0, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ah
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v3, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->label I
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    move-object/from16 v7, v20
    move-object/from16 v8, v21
    move/from16 v9, v22
    move-object/from16 v10, v23
    move/from16 v11, v24
    move-object/from16 v12, v25
    invoke-virtual/range v2 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method

.method public final rawBizCall(java.lang.String  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=8
    move-object/from16 v0, v18
    instance-of v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;
    if-eqz v1, +013h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;
    iget v2, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +009h
    iget v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;->label I
    move-object v10, v11
    goto +7h
    new-instance v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;
    move-object v10, v11
    invoke-direct v1, v11, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;-><init>(Lcom/bytedance/trae/network/TraeHttpConnection; Lkotlin/coroutines/Continuation;)V
    move-object v9, v1
    iget-object v0, v9, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v9, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v3, v9, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$4;->label I
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move v5, v14
    move v6, v15
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/String; Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method

.method public final rawBizCall(java.lang.reflect.Type  java.lang.String  java.util.Set  boolean  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=7
    instance-of v0, v14, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;
    iget v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;
    invoke-direct v0, v8, v14, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;-><init>(Lcom/bytedance/trae/network/TraeHttpConnection; Lkotlin/coroutines/Continuation;)V
    move-object v7, v0
    iget-object v14, v7, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1bh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v2, v7, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$3;->label I
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move v5, v12
    move-object v6, v13
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/util/Set; Z Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-virtual v14, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v9
    return-object v9
.end method

.method public final rawBizCallWithBody(java.lang.String  java.lang.Class  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=13
    const/4 v3, 0
    const/4 v7, 4
    const/4 v8, 0
    move-object v0, v9
    move-object v1, v10
    move-object v2, v11
    move-object v4, v13
    move-object v5, v14
    move v6, v15
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    new-instance v7, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda2;
    move-object/from16 v1, v20
    invoke-direct v7, v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function2; Ljava/lang/Object;)V
    move-object v1, v9
    move-object v2, v12
    move-object/from16 v3, v16
    move/from16 v4, v17
    move/from16 v5, v18
    move-object/from16 v6, v19
    move-object/from16 v8, v21
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/String; Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final rawBizCallWithBody(java.lang.String  java.lang.Class  java.lang.reflect.Type  java.lang.String  java.lang.String  java.util.Map  boolean  java.util.Set  boolean  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=12
    const/4 v3, 0
    const/4 v7, 4
    const/4 v8, 0
    move-object v0, v9
    move-object v1, v10
    move-object v2, v11
    move-object v4, v14
    move-object v5, v15
    move/from16 v6, v16
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    new-instance v6, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda3;
    move-object/from16 v1, v19
    invoke-direct v6, v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function2; Ljava/lang/Object;)V
    move-object v1, v9
    move-object v2, v12
    move-object v3, v13
    move-object/from16 v4, v17
    move/from16 v5, v18
    move-object/from16 v7, v20
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody(Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/util/Set; Z Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final rawBizCallWithBody(java.lang.String  java.util.Set  boolean  boolean  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v9, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;
    const/4 v8, 0
    move-object v1, v9
    move-object/from16 v2, v16
    move v3, v14
    move v4, v13
    move-object v5, v15
    move-object v6, v12
    move-object v7, v11
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;-><init>(Lkotlin/jvm/functions/Function1; Z Z Lkotlin/jvm/functions/Function2; Ljava/util/Set; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    move-object/from16 v1, v17
    invoke-static v0, v9, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final rawBizCallWithBody(java.lang.reflect.Type  java.lang.String  java.util.Set  boolean  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 17
    # ins_size=7
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda0;
    move-object v0, v11
    invoke-direct v5, v11, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda0;-><init>(Ljava/lang/reflect/Type;)V
    const/16 v8, 8
    const/4 v9, 0
    move-object v0, v10
    move-object v1, v12
    move-object v2, v13
    move v3, v14
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final removeApiRespInterceptor(com.bytedance.trae.network.IApiRespInterceptor)boolean
    .registers 3
    # ins_size=2
    const-string v0, "interceptor"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final safeCall(java.lang.String  java.lang.String  java.lang.reflect.Type  java.lang.String  java.lang.Class  java.util.Map  kotlin.jvm.functions.Function1  java.util.Set)com.bytedance.trae.network.response.HttpDataResult
    .registers 25
    # ins_size=9
    move-object/from16 v10, v16
    move-object/from16 v0, v19
    move-object/from16 v11, v20
    move-object/from16 v12, v23
    move-object/from16 v13, v24
    const-string v1, "baseUrl"
    move-object/from16 v5, v17
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, tag
    move-object/from16 v2, v18
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, outType
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "apiClazz"
    move-object/from16 v3, v21
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "call"
    invoke-static v12, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, successCodes
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v14
    const/4 v4, 0
    if-nez v22, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v22
    const/4 v7, 0
    const/16 v8, 36
    const/4 v9, 0
    move-object/from16 v1, v16
    move-object/from16 v2, v18
    move-object/from16 v3, v21
    move-object/from16 v5, v17
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-interface v12, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/retrofit2/SsResponse;
    if-nez v1, +020h
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v3, -1005
    const-string/jumbo v4, ssResponse is null
    new-instance v1, Ljava/lang/Exception;
    const-string/jumbo v2, ssResponse is null
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v5, v1
    check-cast v5, Ljava/lang/Throwable;
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +096h
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->httpGson Lcom/google/gson/Gson;
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    const-class v4, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v4, Ljava/lang/reflect/Type;
    const/4 v5, 1
    new-array v6, v5, [Ljava/lang/reflect/Type;
    const/4 v7, 0
    aput-object v0, v6, v7
    invoke-static v4, v6, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v0
    invoke-virtual v2, v3, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->setupSSResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    invoke-virtual v0, v13, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v2, v5
    if-eqz v2, +01ch
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/IApiRespInterceptor;
    invoke-interface v2, v11, v0, Lcom/bytedance/trae/network/IApiRespInterceptor;->intercept(Ljava/lang/String; Lcom/bytedance/trae/network/response/BizResponse;)Z
    move-result v2
    if-eqz v2, -010h
    move v7, v5
    goto -13h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/4 v2, 0
    if-eqz v7, +008h
    new-instance v3, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;
    invoke-direct v3, v2, v5, v2, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;-><init>(Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v2, v3
    check-cast v2, Ljava/lang/Throwable;
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +32h
    move-exception v0
    move-object v4, v0
    invoke-direct v10, v4, Lcom/bytedance/trae/network/TraeHttpConnection;->extractErrorInfo(Ljava/lang/Throwable;)Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;
    move-result-object v0
    new-instance v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getCode()I
    move-result v2
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getMessage()Ljava/lang/String;
    move-result-object v3
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v8
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +16h
    move-exception v0
    new-instance v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v2, -1001
    const-string v3, ""
    move-object v4, v0
    check-cast v4, Ljava/lang/Throwable;
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v8
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v1
    sub-long/2addr v1, v14
    invoke-direct v10, v11, v1, v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection;->trackRequestEvent(Ljava/lang/String; J Lcom/bytedance/trae/network/response/HttpDataResult;)V
    return-object v0
    :try_start_0x38
.end method

.method public final safeCall(java.lang.String  java.lang.reflect.Type  java.lang.String  java.lang.Class  java.util.Map  kotlin.jvm.functions.Function1  java.util.Set)com.bytedance.trae.network.response.HttpDataResult
    .registers 24
    # ins_size=8
    move-object/from16 v10, v16
    move-object/from16 v0, v18
    move-object/from16 v11, v19
    move-object/from16 v12, v22
    move-object/from16 v13, v23
    const-string/jumbo v1, tag
    move-object/from16 v2, v17
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, outType
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "apiClazz"
    move-object/from16 v3, v20
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "call"
    invoke-static v12, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, successCodes
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v14
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 60
    const/4 v9, 0
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move-object/from16 v3, v20
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-interface v12, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/retrofit2/SsResponse;
    if-nez v1, +020h
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v3, -1005
    const-string/jumbo v4, ssResponse is null
    new-instance v1, Ljava/lang/Exception;
    const-string/jumbo v2, ssResponse is null
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v5, v1
    check-cast v5, Ljava/lang/Throwable;
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +096h
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->httpGson Lcom/google/gson/Gson;
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    const-class v4, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v4, Ljava/lang/reflect/Type;
    const/4 v5, 1
    new-array v6, v5, [Ljava/lang/reflect/Type;
    const/4 v7, 0
    aput-object v0, v6, v7
    invoke-static v4, v6, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v0
    invoke-virtual v2, v3, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->setupSSResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    invoke-virtual v0, v13, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v2, v5
    if-eqz v2, +01ch
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/IApiRespInterceptor;
    invoke-interface v2, v11, v0, Lcom/bytedance/trae/network/IApiRespInterceptor;->intercept(Ljava/lang/String; Lcom/bytedance/trae/network/response/BizResponse;)Z
    move-result v2
    if-eqz v2, -010h
    move v7, v5
    goto -13h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/4 v2, 0
    if-eqz v7, +008h
    new-instance v3, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;
    invoke-direct v3, v2, v5, v2, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;-><init>(Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v2, v3
    check-cast v2, Ljava/lang/Throwable;
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +32h
    move-exception v0
    move-object v4, v0
    invoke-direct v10, v4, Lcom/bytedance/trae/network/TraeHttpConnection;->extractErrorInfo(Ljava/lang/Throwable;)Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;
    move-result-object v0
    new-instance v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getCode()I
    move-result v2
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getMessage()Ljava/lang/String;
    move-result-object v3
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v8
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +16h
    move-exception v0
    new-instance v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v2, -1001
    const-string v3, ""
    move-object v4, v0
    check-cast v4, Ljava/lang/Throwable;
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v8
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v1
    sub-long/2addr v1, v14
    invoke-direct v10, v11, v1, v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection;->trackRequestEvent(Ljava/lang/String; J Lcom/bytedance/trae/network/response/HttpDataResult;)V
    return-object v0
    :try_start_0x3b
.end method

.method public final safeCall(java.lang.String  java.lang.Class  java.util.Map  kotlin.jvm.functions.Function2  java.lang.String  java.util.Set  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=8
    move-object v10, v15
    move-object/from16 v0, v22
    instance-of v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;
    if-eqz v1, +012h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;
    iget v2, v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;
    invoke-direct v1, v15, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;-><init>(Lcom/bytedance/trae/network/TraeHttpConnection; Lkotlin/coroutines/Continuation;)V
    move-object v0, v1
    iget-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v11
    iget v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->label I
    const/4 v12, 1
    if-eqz v2, +02ch
    if-ne v2, v12, +022h
    iget-wide v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->J$0 J
    iget-object v4, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/util/Set;
    iget-object v5, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->L$0 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide v13, v2
    move-object v3, v4
    move-object v2, v5
    goto +43h
    move-exception v0
    move-wide v13, v2
    move-object v2, v5
    goto/16 +0bch
    move-exception v0
    move-wide v13, v2
    move-object v2, v5
    goto/16 +0e2h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v13
    const/4 v4, 0
    const/4 v5, 0
    const/4 v7, 0
    const/16 v8, 44
    const/4 v9, 0
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v6, v18
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    iput-object v10, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->L$0 Ljava/lang/Object;
    move-object/from16 v2, v20
    iput-object v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->L$1 Ljava/lang/Object;
    move-object/from16 v3, v21
    iput-object v3, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->L$2 Ljava/lang/Object;
    iput-wide v13, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->J$0 J
    iput v12, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$1;->label I
    move-object/from16 v4, v19
    invoke-interface v4, v1, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v11, +003h
    return-object v11
    move-object v6, v10
    check-cast v1, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v1, +02ah
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1005
    const-string v3, "BizResponse is null"
    new-instance v4, Ljava/lang/Exception;
    const-string v5, "BizResponse is null"
    invoke-direct v4, v5, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Throwable;
    const/4 v5, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object/from16 v16, v0
    move/from16 v17, v1
    move-object/from16 v18, v3
    move-object/from16 v19, v4
    move-object/from16 v20, v5
    move/from16 v21, v7
    move-object/from16 v22, v8
    invoke-direct/range v16 ... v22, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +09eh
    invoke-virtual v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/2addr v4, v12
    if-eqz v4, +01dh
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +011h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/network/IApiRespInterceptor;
    invoke-interface v4, v2, v1, Lcom/bytedance/trae/network/IApiRespInterceptor;->intercept(Ljava/lang/String; Lcom/bytedance/trae/network/response/BizResponse;)Z
    move-result v4
    if-eqz v4, -010h
    iput-boolean v12, v0, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    goto -14h
    new-instance v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    iget-boolean v0, v0, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    const/4 v4, 0
    if-eqz v0, +008h
    new-instance v0, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;
    invoke-direct v0, v4, v12, v4, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;-><init>(Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v4, v0
    check-cast v4, Ljava/lang/Throwable;
    invoke-direct v3, v1, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +58h
    move-exception v0
    goto +bh
    move-exception v0
    goto +34h
    move-exception v0
    goto +6h
    move-exception v0
    goto +2fh
    move-exception v0
    move-object/from16 v2, v20
    move-object v6, v10
    invoke-direct v6, v0, Lcom/bytedance/trae/network/TraeHttpConnection;->extractErrorInfo(Ljava/lang/Throwable;)Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getCode()I
    move-result v4
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getMessage()Ljava/lang/String;
    move-result-object v1
    const/4 v5, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object/from16 v16, v3
    move/from16 v17, v4
    move-object/from16 v18, v1
    move-object/from16 v19, v0
    move-object/from16 v20, v5
    move/from16 v21, v7
    move-object/from16 v22, v8
    invoke-direct/range v16 ... v22, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +25h
    move-exception v0
    move-object/from16 v2, v20
    move-object v6, v10
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v3, -1001
    const-string v4, ""
    check-cast v0, Ljava/lang/Throwable;
    const/4 v5, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object/from16 v16, v1
    move/from16 v17, v3
    move-object/from16 v18, v4
    move-object/from16 v19, v0
    move-object/from16 v20, v5
    move/from16 v21, v7
    move-object/from16 v22, v8
    invoke-direct/range v16 ... v22, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v3
    sub-long/2addr v3, v13
    invoke-direct v6, v2, v3, v4, v0, Lcom/bytedance/trae/network/TraeHttpConnection;->trackRequestEvent(Ljava/lang/String; J Lcom/bytedance/trae/network/response/HttpDataResult;)V
    return-object v0
    :try_start_0x39
    :try_start_0x66
    :try_start_0x6e
    :try_start_0x82
.end method

.method public final safeCall(java.lang.String  java.lang.Class  kotlin.jvm.functions.Function2  java.lang.String  java.util.Set  kotlin.coroutines.Continuation)java.lang.Object
    .registers 29
    # ins_size=7
    move-object/from16 v10, v22
    move-object/from16 v0, v28
    instance-of v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;
    if-eqz v1, +012h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;
    iget v2, v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;
    invoke-direct v1, v10, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;-><init>(Lcom/bytedance/trae/network/TraeHttpConnection; Lkotlin/coroutines/Continuation;)V
    move-object v0, v1
    iget-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v11
    iget v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->label I
    const/4 v12, 1
    if-eqz v2, +02ch
    if-ne v2, v12, +022h
    iget-wide v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->J$0 J
    iget-object v4, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/util/Set;
    iget-object v5, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->L$0 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide v13, v2
    move-object v3, v4
    move-object v2, v5
    goto +43h
    move-exception v0
    move-wide v13, v2
    move-object v2, v5
    goto/16 +0b3h
    move-exception v0
    move-wide v13, v2
    move-object v2, v5
    goto/16 +0d0h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v13
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 60
    const/4 v9, 0
    move-object/from16 v1, v22
    move-object/from16 v2, v23
    move-object/from16 v3, v24
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    iput-object v10, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->L$0 Ljava/lang/Object;
    move-object/from16 v2, v26
    iput-object v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->L$1 Ljava/lang/Object;
    move-object/from16 v3, v27
    iput-object v3, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->L$2 Ljava/lang/Object;
    iput-wide v13, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->J$0 J
    iput v12, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->label I
    move-object/from16 v4, v25
    invoke-interface v4, v1, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v11, +003h
    return-object v11
    move-object v6, v10
    check-cast v1, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v1, +021h
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v16, -1005
    const-string v17, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v3, "BizResponse is null"
    invoke-direct v1, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object/from16 v18, v1
    check-cast v18, Ljava/lang/Throwable;
    const/16 v19, 0
    const/16 v20, 8
    const/16 v21, 0
    move-object v15, v0
    invoke-direct/range v15 ... v21, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +08ch
    invoke-virtual v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->apiRespInterceptors Ljava/util/concurrent/CopyOnWriteArrayList;
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/2addr v4, v12
    if-eqz v4, +01dh
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +011h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/network/IApiRespInterceptor;
    invoke-interface v4, v2, v1, Lcom/bytedance/trae/network/IApiRespInterceptor;->intercept(Ljava/lang/String; Lcom/bytedance/trae/network/response/BizResponse;)Z
    move-result v4
    if-eqz v4, -010h
    iput-boolean v12, v0, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    goto -14h
    new-instance v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    iget-boolean v0, v0, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    const/4 v4, 0
    if-eqz v0, +008h
    new-instance v0, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;
    invoke-direct v0, v4, v12, v4, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;-><init>(Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v4, v0
    check-cast v4, Ljava/lang/Throwable;
    invoke-direct v3, v1, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +46h
    move-exception v0
    goto +bh
    move-exception v0
    goto +2bh
    move-exception v0
    goto +6h
    move-exception v0
    goto +26h
    move-exception v0
    move-object/from16 v2, v26
    move-object v6, v10
    invoke-direct v6, v0, Lcom/bytedance/trae/network/TraeHttpConnection;->extractErrorInfo(Ljava/lang/Throwable;)Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getCode()I
    move-result v16
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getMessage()Ljava/lang/String;
    move-result-object v17
    const/16 v19, 0
    const/16 v20, 8
    const/16 v21, 0
    move-object v15, v3
    move-object/from16 v18, v0
    invoke-direct/range v15 ... v21, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +1ch
    move-exception v0
    move-object/from16 v2, v26
    move-object v6, v10
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v16, -1001
    const-string v17, ""
    move-object/from16 v18, v0
    check-cast v18, Ljava/lang/Throwable;
    const/16 v19, 0
    const/16 v20, 8
    const/16 v21, 0
    move-object v15, v1
    invoke-direct/range v15 ... v21, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v3
    sub-long/2addr v3, v13
    invoke-direct v6, v2, v3, v4, v0, Lcom/bytedance/trae/network/TraeHttpConnection;->trackRequestEvent(Ljava/lang/String; J Lcom/bytedance/trae/network/response/HttpDataResult;)V
    return-object v0
    :try_start_0x3a
    :try_start_0x67
    :try_start_0x6f
    :try_start_0x83
.end method
