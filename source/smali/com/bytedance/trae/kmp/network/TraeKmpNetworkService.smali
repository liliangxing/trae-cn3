# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;
.super Ljava/lang/Object;
.source "TraeKmpNetworkService.kt"

.implements Lcom/bytedance/kmp/network/IKmpNetworkService;

.field public static final $stable:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final baseUrlOf(java.lang.String)java.lang.String
    .registers 9
    # ins_size=2
    move-object v6, v8
    check-cast v6, Ljava/lang/CharSequence;
    const-string v1, "://"
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v0
    if-gez v0, +003h
    return-object v8
    const/16 v1, 47
    add-int/lit8 v2, v0, 3
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v6
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-gez v0, +003h
    goto +ch
    const/4 v1, 0
    invoke-virtual v8, v1, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v0, substring(...)
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const/16 v0, 47
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    return-object v8
.end method

.method private final errorResponse(com.bytedance.kmp.network.requet.Request  java.lang.String)com.bytedance.kmp.network.response.Response
    .registers 13
    # ins_size=3
    new-instance v7, Lcom/bytedance/kmp/network/NetError;
    invoke-direct v7, Lcom/bytedance/kmp/network/NetError;-><init>()V
    invoke-virtual v7, v12, Lcom/bytedance/kmp/network/NetError;->setErrorMessage(Ljava/lang/String;)V
    new-instance v9, Lcom/bytedance/kmp/network/response/Response;
    sget-object v2, Lcom/bytedance/kmp/network/Protocol;->UNKNOWN Lcom/bytedance/kmp/network/Protocol;
    const/4 v4, -1
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    const/4 v6, 0
    const/4 v8, 0
    move-object v0, v9
    move-object v1, v11
    move-object v3, v12
    invoke-direct/range v0 ... v8, Lcom/bytedance/kmp/network/response/Response;-><init>(Lcom/bytedance/kmp/network/requet/Request; Lcom/bytedance/kmp/network/Protocol; Ljava/lang/String; I Ljava/util/List; Lcom/bytedance/kmp/network/response/ResponseBody; Lcom/bytedance/kmp/network/NetError; Lcom/bytedance/kmp/network/NetRequestMetrics;)V
    return-object v9
.end method

.method private final readBody(com.bytedance.kmp.network.requet.RequestBody)byte[]
    .registers 4
    # ins_size=2
    new-instance v0, Lokio/Buffer;
    invoke-direct v0, Lokio/Buffer;-><init>()V
    move-object v1, v0
    check-cast v1, Lokio/BufferedSink;
    invoke-virtual v3, v1, Lcom/bytedance/kmp/network/requet/RequestBody;->writeTo(Lokio/BufferedSink;)V
    invoke-virtual v0, Lokio/Buffer;->readByteArray()[B
    move-result-object v3
    return-object v3
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

.method private final successResponse(com.bytedance.kmp.network.requet.Request  com.bytedance.retrofit2.SsResponse)com.bytedance.kmp.network.response.Response
    .registers 12
    # ins_size=3
    sget-object v2, Lcom/bytedance/kmp/network/Protocol;->HTTP_1_1 Lcom/bytedance/kmp/network/Protocol;
    invoke-virtual v11, Lcom/bytedance/retrofit2/SsResponse;->message()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "OK"
    move-object v3, v0
    invoke-virtual v11, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v4
    invoke-virtual v11, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v0
    const-string v1, "headers(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v0, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v1, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +023h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/retrofit2/client/Header;
    new-instance v6, Lcom/bytedance/kmp/network/Header;
    invoke-virtual v5, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v7
    const-string v8, "getName(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v5
    const-string v8, "getValue(...)"
    invoke-static v5, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, v5, Lcom/bytedance/kmp/network/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -26h
    move-object v5, v1
    check-cast v5, Ljava/util/List;
    invoke-direct v9, v11, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;->readRawBody(Lcom/bytedance/retrofit2/SsResponse;)Ljava/lang/String;
    move-result-object v11
    if-eqz v11, +008h
    new-instance v0, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;
    invoke-direct v0, v11, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;-><init>(Ljava/lang/String;)V
    goto +2h
    const/4 v0, 0
    move-object v6, v0
    check-cast v6, Lcom/bytedance/kmp/network/response/ResponseBody;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v11, Lcom/bytedance/kmp/network/response/Response;
    move-object v0, v11
    move-object v1, v10
    invoke-direct/range v0 ... v8, Lcom/bytedance/kmp/network/response/Response;-><init>(Lcom/bytedance/kmp/network/requet/Request; Lcom/bytedance/kmp/network/Protocol; Ljava/lang/String; I Ljava/util/List; Lcom/bytedance/kmp/network/response/ResponseBody; Lcom/bytedance/kmp/network/NetError; Lcom/bytedance/kmp/network/NetRequestMetrics;)V
    return-object v11
.end method

.method public cancel(com.bytedance.kmp.network.requet.Request)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, request
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public execute(com.bytedance.kmp.network.requet.Request  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=3
    invoke-virtual v8, Lcom/bytedance/kmp/network/requet/Request;->getUrl()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, Lcom/bytedance/kmp/network/requet/Request;->getMethod()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toUpperCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/kmp/network/requet/Request;->getHeaders()Ljava/util/Map;
    move-result-object v1
    new-instance v2, Ljava/util/ArrayList;
    invoke-interface v1, Ljava/util/Map;->size()I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
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
    invoke-interface v2, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -20h
    check-cast v2, Ljava/util/List;
    invoke-direct v7, v9, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;->baseUrlOf(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-class v3, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$KmpBridgeApi;
    invoke-static v1, v3, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$KmpBridgeApi;
    if-nez v1, +009h
    const-string v9, "TTNet not initialized"
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;->errorResponse(Lcom/bytedance/kmp/network/requet/Request; Ljava/lang/String;)Lcom/bytedance/kmp/network/response/Response;
    move-result-object v8
    return-object v8
    new-instance v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v3, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v4, 1
    iput-boolean v4, v3, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    const-string v4, "POST"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +027h
    invoke-virtual v8, Lcom/bytedance/kmp/network/requet/Request;->getBody()Lcom/bytedance/kmp/network/requet/RequestBody;
    move-result-object v0
    const/4 v4, 0
    if-eqz v0, +008h
    invoke-direct v7, v0, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;->readBody(Lcom/bytedance/kmp/network/requet/RequestBody;)[B
    move-result-object v5
    if-nez v5, +004h
    new-array v5, v4, [B
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/kmp/network/requet/RequestBody;->contentType()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "application/json; charset=UTF-8"
    new-instance v6, Lcom/bytedance/retrofit2/mime/TypedByteArray;
    new-array v4, v4, [Ljava/lang/String;
    invoke-direct v6, v0, v5, v4, Lcom/bytedance/retrofit2/mime/TypedByteArray;-><init>(Ljava/lang/String; [B [Ljava/lang/String;)V
    invoke-interface v1, v9, v6, v2, v3, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$KmpBridgeApi;->post(Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedByteArray; Ljava/util/List; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v9
    goto +5h
    invoke-interface v1, v9, v2, v3, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$KmpBridgeApi;->get(Ljava/lang/String; Ljava/util/List; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v9
    invoke-interface v9, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v9
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;->successResponse(Lcom/bytedance/kmp/network/requet/Request; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/kmp/network/response/Response;
    move-result-object v8
    goto +10h
    move-exception v9
    invoke-virtual v9, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v9, Ljava/lang/Throwable;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;->errorResponse(Lcom/bytedance/kmp/network/requet/Request; Ljava/lang/String;)Lcom/bytedance/kmp/network/response/Response;
    move-result-object v8
    return-object v8
    :try_start_0x63
.end method

.method public executeStream(com.bytedance.kmp.network.requet.Request  com.bytedance.kmp.network.response.ResponseCallback  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=4
    const-string v0, "executeStream not supported"
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;->errorResponse(Lcom/bytedance/kmp/network/requet/Request; Ljava/lang/String;)Lcom/bytedance/kmp/network/response/Response;
    move-result-object v2
    invoke-interface v3, v2, v4, Lcom/bytedance/kmp/network/response/ResponseCallback;->onError(Lcom/bytedance/kmp/network/response/Response; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    if-ne v2, v3, +003h
    return-object v2
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public getNetworkQualityState(kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=2
    new-instance v8, Lcom/bytedance/kmp/network/nqe/NetworkQualityState;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v8
    invoke-direct/range v0 ... v6, Lcom/bytedance/kmp/network/nqe/NetworkQualityState;-><init>(Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType; Lcom/bytedance/kmp/network/nqe/RttAndThroughput; Lcom/bytedance/kmp/network/nqe/PacketLoss; Lcom/bytedance/kmp/network/nqe/PacketLoss; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v8
.end method

.method public preConnect(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public registerNQEListener(com.bytedance.kmp.network.nqe.NQEListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
