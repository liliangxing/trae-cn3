# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
.super Ljava/lang/Object;
.source "ThirdPartyTokenRepository.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
.field public static final TYPE_BYTECLOUD:Ljava/lang/String;
.field public static final TYPE_GITHUB:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$createService(com.bytedance.trae.conversation.network.ThirdPartyTokenRepository)com.bytedance.trae.conversation.network.IThirdPartyTokenApi
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->createService()Lcom/bytedance/trae/conversation/network/IThirdPartyTokenApi;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$parseEnvelopeOrThrow(com.bytedance.trae.conversation.network.ThirdPartyTokenRepository  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.conversation.network.ThirdPartyTokenEnvelope
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->parseEnvelopeOrThrow(Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;
    move-result-object v0
    return-object v0
.end method

.method private final cloudideHeaders()java.util.Map
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    goto +bh
    const-string v1, "X-Cloudide-Token"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method private final createService()com.bytedance.trae.conversation.network.IThirdPartyTokenApi
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v1, third_party_token
    const-class v2, Lcom/bytedance/trae/conversation/network/IThirdPartyTokenApi;
    const/4 v3, 0
    sget-object v4, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v5, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v9, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->cloudideHeaders()Ljava/util/Map;
    move-result-object v5
    const/4 v6, 0
    const/16 v7, 36
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/IThirdPartyTokenApi;
    return-object v0
.end method

.method private final parseEnvelopeOrThrow(com.bytedance.retrofit2.SsResponse)com.bytedance.trae.conversation.network.ThirdPartyTokenEnvelope
    .registers 7
    # ins_size=2
    if-eqz v6, +0bfh
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v0
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +03dh
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v6
    if-eqz v6, +036h
    invoke-interface v6, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v6
    if-eqz v6, +030h
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v3, Ljava/io/InputStreamReader;
    invoke-direct v3, v6, v1, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v3, Ljava/io/Reader;
    instance-of v6, v3, Ljava/io/BufferedReader;
    if-eqz v6, +005h
    check-cast v3, Ljava/io/BufferedReader;
    goto +9h
    new-instance v6, Ljava/io/BufferedReader;
    const/16 v1, 8192
    invoke-direct v6, v3, v1, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v3, v6
    check-cast v3, Ljava/io/Closeable;
    move-object v6, v3
    check-cast v6, Ljava/io/BufferedReader;
    check-cast v6, Ljava/io/Reader;
    invoke-static v6, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v1
    invoke-static v3, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +9h
    move-exception v6
    throw v6
    move-exception v0
    invoke-static v3, v6, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v0
    move-object v1, v2
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
    sget-object v6, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v6, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v6
    if-nez v1, +006h
    const-string/jumbo v3, {}
    goto +2h
    move-object v3, v1
    const-class v4, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;
    invoke-virtual v6, v3, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v6, v2
    check-cast v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;
    if-eqz v6, +00ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;->getResponseMetadata()Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetadata;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetadata;->getError()Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetaError;
    move-result-object v2
    if-eqz v2, +019h
    new-instance v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetaError;->getCode()Ljava/lang/String;
    move-result-object v3
    const-string v4, ""
    if-nez v3, +003h
    move-object v3, v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetaError;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v4, v2
    invoke-direct v6, v3, v4, v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)V
    throw v6
    const/16 v2, 200
    const/4 v3, 0
    if-gt v2, v0, +007h
    const/16 v2, 300
    if-ge v0, v2, +003h
    const/4 v3, 1
    if-eqz v3, +00dh
    if-eqz v6, +003h
    return-object v6
    new-instance v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$DecodingFailed;
    const-string v0, "failed to parse response"
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$DecodingFailed;-><init>(Ljava/lang/String;)V
    throw v6
    new-instance v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;
    invoke-direct v6, v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;-><init>(I Ljava/lang/String;)V
    throw v6
    new-instance v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$DecodingFailed;
    const-string/jumbo v0, response is null
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$DecodingFailed;-><init>(Ljava/lang/String;)V
    throw v6
    :try_start_0x35
    :try_start_0x43
    :try_start_0x4a
.end method

.method public static synthetic setThirdPartyToken$default(com.bytedance.trae.conversation.network.ThirdPartyTokenRepository  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->setThirdPartyToken(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final disconnectThirdPartyToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$disconnectThirdPartyToken$2;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$disconnectThirdPartyToken$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    if-ne v4, v5, +003h
    return-object v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method public final getThirdPartyToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public final setThirdPartyToken(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$setThirdPartyToken$2;
    const/4 v2, 0
    invoke-direct v1, v4, v5, v6, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$setThirdPartyToken$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v7, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    if-ne v4, v5, +003h
    return-object v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
