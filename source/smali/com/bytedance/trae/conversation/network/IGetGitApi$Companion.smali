# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
.super Ljava/lang/Object;
.source "IGetGitApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
.field private static final LIST_REPOSITORIES_SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$d4TqaGXzN4OHc7u-tekHZmzwHqQ(java.util.Map  com.bytedance.trae.conversation.network.IGetGitApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->listRepositoriesRawCall$lambda$0(Ljava/util/Map; Lcom/bytedance/trae/conversation/network/IGetGitApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->LIST_REPOSITORIES_SUCCESS_CODES Ljava/util/Set;
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

.method private static final listRepositoriesRawCall$lambda$0(java.util.Map  com.bytedance.trae.conversation.network.IGetGitApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCallWithBody"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/conversation/network/IGetGitApi;->listRepositoriesRaw(Ljava/util/Map; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private final monitorRepoResponse(com.bytedance.retrofit2.SsResponse)void
    .registers 9
    # ins_size=2
    if-nez v8, +003h
    return-void 
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "http_code"
    invoke-virtual v8, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v2
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v8, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v8
    const-string v2, "headers(...)"
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +017h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v4, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v4
    const-string v5, "X-Tt-Logid"
    const/4 v6, 1
    invoke-static v4, v5, v6, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-eqz v4, -019h
    goto +2h
    move-object v2, v3
    check-cast v2, Lcom/bytedance/retrofit2/client/Header;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v3
    const-string v2, "logid"
    invoke-virtual v1, v2, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v8, repo_response
    invoke-static v8, v0, v3, v1, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x3
.end method

.method public final listRepositoriesRawCall(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v19
    instance-of v2, v1, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;-><init>(Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion; Lkotlin/coroutines/Continuation;)V
    move-object v14, v2
    iget-object v1, v14, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v14, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->label I
    const/4 v4, 1
    if-eqz v3, +014h
    if-ne v3, v4, +00ah
    iget-object v2, v14, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +38h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "git"
    const-class v5, Lcom/bytedance/trae/conversation/network/IGetGitApi;
    const-class v6, Lcom/bytedance/trae/conversation/network/ListRepositoriesData;
    check-cast v6, Ljava/lang/reflect/Type;
    const/4 v7, 0
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->getBASE_URL()Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->LIST_REPOSITORIES_SUCCESS_CODES Ljava/util/Set;
    const/4 v12, 0
    new-instance v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$$ExternalSyntheticLambda0;
    move-object/from16 v15, v18
    invoke-direct v13, v15, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$$ExternalSyntheticLambda0;-><init>(Ljava/util/Map;)V
    const/16 v15, 360
    const/16 v16, 0
    iput-object v0, v14, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->L$0 Ljava/lang/Object;
    iput v4, v14, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$listRepositoriesRawCall$1;->label I
    move-object v4, v1
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v2, v0
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getSsResponse()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->monitorRepoResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v1
    return-object v1
.end method

.method public final safeCall(java.util.Map  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=4
    instance-of v13, v15, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;
    if-eqz v13, +012h
    move-object v13, v15
    check-cast v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;
    iget v0, v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;->label I
    const/high16 v1, -2147483648
    and-int/2addr v0, v1
    if-eqz v0, +008h
    iget v15, v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;->label I
    sub-int/2addr v15, v1
    iput v15, v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;->label I
    goto +6h
    new-instance v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;
    invoke-direct v13, v12, v15, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;-><init>(Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;->label I
    const/4 v2, 1
    if-eqz v1, +016h
    if-ne v1, v2, +00ch
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +31h
    move-exception v13
    move-object v3, v13
    goto +6eh
    move-exception v13
    goto/16 +07dh
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v14, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v14, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "git"
    const-class v5, Lcom/bytedance/trae/conversation/network/IGetGitApi;
    const/4 v6, 0
    invoke-direct v12, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->getBASE_URL()Ljava/lang/String;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 52
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/conversation/network/IGetGitApi;
    iput v2, v13, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion$safeCall$1;->label I
    invoke-interface v14, v15, v13, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    check-cast v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    if-nez v15, +01dh
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1005
    const-string v2, "BizResponse is null"
    new-instance v14, Ljava/lang/Exception;
    const-string v15, "BizResponse is null"
    invoke-direct v14, v15, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v3, v14
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v13
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +47h
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v14, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getCode()J
    move-result-wide v1
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    const/4 v7, 0
    const/16 v8, 44
    const/4 v9, 0
    move-object v0, v14
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v15, 0
    invoke-direct v13, v14, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +26h
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1000
    const-string v2, ""
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v13
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +15h
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1001
    const-string v2, ""
    move-object v3, v13
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v13, v14
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v13
    :try_start_0x26
    :try_start_0x3b
.end method
