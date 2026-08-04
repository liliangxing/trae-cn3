# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;
.super Ljava/lang/Object;
.source "BytecloudUserInfoFetcher.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;
    invoke-direct v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;->INSTANCE Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final parseResponse(com.bytedance.retrofit2.SsResponse)com.bytedance.trae.login.user.BytecloudUserInfoFetcher$BytecloudUserInfoResponse
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
    const-class v4, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;
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
    new-instance v1, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$BytecloudUserInfoResponse;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v1, v0, v6, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$BytecloudUserInfoResponse;-><init>(Lcom/bytedance/trae/login/traeauth/TraeResponse; Lcom/bytedance/retrofit2/SsResponse;)V
    return-object v1
    const/4 v6, 0
    return-object v6
.end method

.method public final doFetch(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v1, v17
    move-object/from16 v0, v19
    const-string v2, "doFetch: "
    instance-of v3, v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;
    if-eqz v3, +012h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;
    iget v4, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v0, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->label I
    sub-int/2addr v0, v5
    iput v0, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;
    invoke-direct v3, v1, v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;-><init>(Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->label I
    const-string v6, "BytecloudUserInfoFetcher"
    const/4 v7, 1
    if-eqz v5, +014h
    if-ne v5, v7, +00ah
    iget-object v2, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +53h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v5, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v5, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v12
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    move-object v13, v0
    check-cast v13, Ljava/util/Map;
    const-string v0, "X-Cloudide-Token"
    move-object/from16 v2, v18
    invoke-interface v13, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v8, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v9, trae_bytecloud_auth
    const-class v10, Lcom/bytedance/trae/login/user/BytecloudUserInfoApi;
    const/4 v11, 0
    const/4 v14, 1
    const/4 v15, 4
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoApi;
    iput-object v1, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->L$0 Ljava/lang/Object;
    iput v7, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$doFetch$1;->label I
    invoke-interface v0, v3, Lcom/bytedance/trae/login/user/BytecloudUserInfoApi;->getBytecloudUserInfo(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v2, v1
    check-cast v0, Lcom/bytedance/retrofit2/SsResponse;
    invoke-direct v2, v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;->parseResponse(Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$BytecloudUserInfoResponse;
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
    invoke-virtual v2, v6, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 0
    return-object v0
    :try_start_0x32
    :try_start_0x41
.end method
