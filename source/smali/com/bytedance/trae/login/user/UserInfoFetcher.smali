# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/user/UserInfoFetcher;
.super Ljava/lang/Object;
.source "UserInfoFetcher.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/user/UserInfoFetcher;
.field private static final TAG:Ljava/lang/String;
.field private static final exceptionHandler:Lkotlinx/coroutines/CoroutineExceptionHandler;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/user/UserInfoFetcher;
    invoke-direct v0, Lcom/bytedance/trae/login/user/UserInfoFetcher;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/user/UserInfoFetcher;->INSTANCE Lcom/bytedance/trae/login/user/UserInfoFetcher;
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    sput-object v1, Lcom/bytedance/trae/login/user/UserInfoFetcher;->exceptionHandler Lkotlinx/coroutines/CoroutineExceptionHandler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final parseResponse(com.bytedance.retrofit2.SsResponse)com.bytedance.trae.login.user.UserInfoFetcher$UserInfoResponse
    .registers 7
    # ins_size=2
    if-eqz v6, +034h
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    goto +2ah
    const-class v1, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    check-cast v1, Ljava/lang/reflect/Type;
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/reflect/Type;
    const/4 v3, 0
    const-class v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    aput-object v4, v2, v3
    invoke-static v1, v2, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v1
    invoke-virtual v1, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v2, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v2
    invoke-virtual v2, v0, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    new-instance v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v1, v0, v6, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;-><init>(Lcom/bytedance/trae/login/traeauth/TraeResponse; Lcom/bytedance/retrofit2/SsResponse;)V
    return-object v1
    const/4 v6, 0
    return-object v6
.end method

.method public final doFetch(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=3
    move-object/from16 v1, v18
    move-object/from16 v0, v19
    move-object/from16 v2, v20
    const-string v3, "doFetch: "
    instance-of v4, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;
    if-eqz v4, +012h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;
    iget v5, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v2, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->label I
    sub-int/2addr v2, v6
    iput v2, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;
    invoke-direct v4, v1, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;-><init>(Lcom/bytedance/trae/login/user/UserInfoFetcher; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->label I
    const/4 v7, 1
    const-string v8, "UserInfoFetcher"
    if-eqz v6, +014h
    if-ne v6, v7, +00ah
    iget-object v0, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/login/user/UserInfoFetcher;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +62h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v13
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v8, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    move-object v14, v2
    check-cast v14, Ljava/util/Map;
    const-string v2, "X-Cloudide-Token"
    invoke-interface v14, v2, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v10, trae_auth
    const-class v11, Lcom/bytedance/trae/login/user/UserInfoApi;
    const/4 v12, 0
    const/4 v15, 1
    const/16 v16, 4
    const/16 v17, 0
    invoke-static/range v9 ... v17, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/user/UserInfoApi;
    iput-object v1, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->L$0 Ljava/lang/Object;
    iput v7, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$doFetch$1;->label I
    invoke-interface v0, v4, Lcom/bytedance/trae/login/user/UserInfoApi;->getUserInfo(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    move-object v0, v1
    check-cast v2, Lcom/bytedance/retrofit2/SsResponse;
    invoke-direct v0, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher;->parseResponse(Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    move-result-object v0
    goto +1bh
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "doFetch exception: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 0
    return-object v0
    :try_start_0x34
    :try_start_0x43
.end method
