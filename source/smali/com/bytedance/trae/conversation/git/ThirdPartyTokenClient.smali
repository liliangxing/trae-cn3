# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
.super Ljava/lang/Object;
.source "ThirdPartyTokenClient.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$findTokenInArray(com.bytedance.trae.conversation.git.ThirdPartyTokenClient  java.lang.String  org.json.JSONArray)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;->findTokenInArray(Ljava/lang/String; Lorg/json/JSONArray;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$parseTraeEnvelopeOrThrow(com.bytedance.trae.conversation.git.ThirdPartyTokenClient  com.bytedance.retrofit2.SsResponse)org.json.JSONObject
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;->parseTraeEnvelopeOrThrow(Lcom/bytedance/retrofit2/SsResponse;)Lorg/json/JSONObject;
    move-result-object v0
    return-object v0
.end method

.method private final ensureTrailingSlash(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 2
    const/4 v2, 0
    const/16 v3, 47
    const/4 v4, 0
    invoke-static v0, v3, v4, v1, v2, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +12h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method private final findTokenInArray(java.lang.String  org.json.JSONArray)java.lang.String
    .registers 9
    # ins_size=3
    invoke-virtual v8, Lorg/json/JSONArray;->length()I
    move-result v0
    const/4 v1, 0
    const/4 v2, 0
    if-ge v1, v0, +02eh
    invoke-virtual v8, v1, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;
    move-result-object v3
    if-nez v3, +003h
    goto +23h
    const-string v4, "Type"
    invoke-virtual v3, v4, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const/4 v5, 1
    invoke-static v4, v7, v5, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-eqz v4, +017h
    const-string v7, "AccessToken"
    invoke-virtual v3, v7, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v8, v7
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v5
    if-eqz v8, +003h
    move-object v2, v7
    return-object v2
    add-int/lit8 v1, v1, 1
    goto -2eh
    return-object v2
.end method

.method private final parseTraeEnvelopeOrThrow(com.bytedance.retrofit2.SsResponse)org.json.JSONObject
    .registers 11
    # ins_size=2
    if-eqz v10, +099h
    invoke-virtual v10, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v0
    invoke-virtual v10, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    const/16 v1, 200
    const/4 v2, 1
    const/4 v3, 0
    if-gt v1, v0, +008h
    const/16 v1, 300
    if-ge v0, v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +07ah
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
    new-instance v0, Lorg/json/JSONObject;
    if-nez v10, +005h
    const-string/jumbo v10, {}
    invoke-direct v0, v10, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    goto +ch
    move-exception v10
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v10, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-nez v0, +052h
    check-cast v10, Lorg/json/JSONObject;
    const-string v0, "ResponseMetadata"
    invoke-virtual v10, v0, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v0
    if-eqz v0, +009h
    const-string v1, "Error"
    invoke-virtual v0, v1, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-object v10
    const-string v10, "Code"
    invoke-virtual v0, v10, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    const-string v1, "Message"
    invoke-virtual v0, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 2
    new-array v1, v1, [Ljava/lang/String;
    aput-object v10, v1, v3
    aput-object v0, v1, v2
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, " "
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthFailed;
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthFailed;-><init>(Ljava/lang/String;)V
    throw v0
    sget-object v10, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;
    throw v10
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
    invoke-direct v1, v0, v10, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;-><init>(I Ljava/lang/String;)V
    throw v1
    sget-object v10, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;
    throw v10
    :try_start_0x1b
.end method

.method public final disconnectThirdPartyToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$disconnectThirdPartyToken$2;
    const/4 v2, 0
    invoke-direct v1, v3, v4, v2, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$disconnectThirdPartyToken$2;-><init>(Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
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

.method public final exchangeCodeAndFetchGitHubToken(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=4
    instance-of v0, v9, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;
    invoke-direct v0, v6, v9, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;-><init>(Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->label I
    const-string v3, "github"
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v2, +01ah
    if-eq v2, v5, +010h
    if-ne v2, v4, +006h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ch
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    iget-object v7, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +10h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->label I
    invoke-virtual v6, v3, v7, v8, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;->setThirdPartyToken(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v7, v6
    const/4 v8, 0
    iput-object v8, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;->label I
    invoke-virtual v7, v3, v0, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;->getThirdPartyToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    check-cast v9, Ljava/lang/String;
    move-object v7, v9
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00ah
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    const/4 v5, 0
    if-nez v5, +008h
    new-instance v7, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;
    invoke-direct v7, v9, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;-><init>(Ljava/lang/String;)V
    return-object v7
    sget-object v7, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;
    throw v7
.end method

.method public final getThirdPartyToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$getThirdPartyToken$2;
    const/4 v2, 0
    invoke-direct v1, v3, v4, v2, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$getThirdPartyToken$2;-><init>(Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public final setThirdPartyToken(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$setThirdPartyToken$2;
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient$setThirdPartyToken$2;-><init>(Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v7, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v10
    if-ne v9, v10, +003h
    return-object v9
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
