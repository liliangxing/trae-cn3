# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;
.super Ljava/lang/Object;
.source "AndroidKmpRawHttpClient.kt"

.implements Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;

.field public static final $stable:I
.field private final executeRequest:Lkotlin/jvm/functions/Function2;
.field private final requestFactory:Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;


.method public static synthetic $r8$lambda$smGD4JpNKxUa58aX_lzGfsuw-d0(com.bytedance.trae.kmp.network.AndroidKmpRequest)com.bytedance.kmp.network.requet.Request
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->_init_$lambda$0(Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;)Lcom/bytedance/kmp/network/requet/Request;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;-><init>(Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory; Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.network.AndroidKmpRequestFactory  kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, requestFactory
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "executeRequest"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->requestFactory Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->executeRequest Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.AndroidKmpRequestFactory  kotlin.jvm.functions.Function2  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +007h
    new-instance v1, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$$ExternalSyntheticLambda0;-><init>()V
    and-int/lit8 v3, v3, 2
    if-eqz v3, +00ah
    new-instance v2, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$2;
    const/4 v3, 0
    invoke-direct v2, v3, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$2;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;-><init>(Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.kmp.network.AndroidKmpRequest)com.bytedance.kmp.network.requet.Request
    .registers 17
    # ins_size=1
    const-string/jumbo v0, request
    move-object/from16 v1, v16
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/kmp/network/KmpNetworkManager;->INSTANCE Lcom/bytedance/kmp/network/KmpNetworkManager;
    invoke-virtual/range v16, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;->getUrl()Ljava/lang/String;
    move-result-object v2
    invoke-virtual/range v16, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;->getMethod()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v16, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;->getQueries()Ljava/util/Map;
    move-result-object v4
    invoke-virtual/range v16, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;->getHeaders()Ljava/util/Map;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    invoke-virtual/range v16, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;->getBody()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v16, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;->getContentType()Ljava/lang/String;
    move-result-object v12
    const/4 v13, 0
    const/16 v14, 2544
    const/4 v15, 0
    move-object v1, v0
    invoke-static/range v1 ... v15, Lcom/bytedance/kmp/network/KmpNetworkManager;->constructRequest$default(Lcom/bytedance/kmp/network/KmpNetworkManager; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Ljava/lang/String; Ljava/util/Map; Ljava/util/List; Ljava/util/List; Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/kmp/network/requet/RequestContext; I Ljava/lang/Object;)Lcom/bytedance/kmp/network/requet/Request;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$execute(com.bytedance.trae.kmp.network.AndroidKmpRawHttpClient  com.bytedance.kmp.network.requet.Request  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->execute(Lcom/bytedance/kmp/network/requet/Request; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final execute(com.bytedance.kmp.network.requet.Request  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;-><init>(Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1bh
    move-exception v7
    move-object v5, v7
    goto/16 +082h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v6, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->executeRequest Lkotlin/jvm/functions/Function2;
    iput v3, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient$execute$1;->label I
    invoke-interface v8, v7, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Lcom/bytedance/kmp/network/response/Response;
    invoke-virtual v8, Lcom/bytedance/kmp/network/response/Response;->getBody()Lcom/bytedance/kmp/network/response/ResponseBody;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/kmp/network/response/ResponseBody;->string()Ljava/lang/String;
    move-result-object v7
    goto +2h
    const/4 v7, 0
    move-object v1, v7
    invoke-virtual v8, Lcom/bytedance/kmp/network/response/Response;->getCode()I
    move-result v2
    invoke-virtual v8, Lcom/bytedance/kmp/network/response/Response;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v8, Lcom/bytedance/kmp/network/response/Response;->getHeaders()Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    const/16 v0, 10
    invoke-static v7, v0, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v0
    const/16 v4, 16
    invoke-static v0, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    new-instance v4, Ljava/util/LinkedHashMap;
    invoke-direct v4, v0, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v4, Ljava/util/Map;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +020h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/kmp/network/Header;
    invoke-virtual v0, Lcom/bytedance/kmp/network/Header;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/kmp/network/Header;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v5, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-virtual v0, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v5
    invoke-virtual v0, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    invoke-interface v4, v5, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -23h
    invoke-virtual v8, Lcom/bytedance/kmp/network/response/Response;->getError()Lcom/bytedance/kmp/network/NetError;
    move-result-object v7
    move-object v5, v7
    check-cast v5, Ljava/lang/Throwable;
    new-instance v7, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    move-object v0, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/Throwable;)V
    goto +34h
    invoke-static v5, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClientKt;->access$httpStatusCodeOrNull(Ljava/lang/Throwable;)Ljava/lang/Integer;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2h
    const/4 v7, -1
    move v2, v7
    new-instance v7, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    const/4 v1, 0
    if-lez v2, +018h
    invoke-virtual v5, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +014h
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v0, "HTTP "
    invoke-direct v8, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    goto +3h
    const-string v8, "Network Failure"
    move-object v3, v8
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v4
    move-object v0, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/Throwable;)V
    return-object v7
    :try_start_0x26
    :try_start_0x39
.end method

.method public getRaw(java.lang.String  java.util.Map  java.util.Map  com.bytedance.trae.kmp.network.KmpHttpRequestOptions  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=6
    iget-object v14, v10, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->requestFactory Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;
    new-instance v9, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;
    const-string v2, "GET"
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 48
    const/4 v8, 0
    move-object v0, v9
    move-object v1, v11
    move-object v3, v12
    move-object v4, v13
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v14, v9, Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;->create(Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;)Lcom/bytedance/kmp/network/requet/Request;
    move-result-object v11
    invoke-direct v10, v11, v15, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->execute(Lcom/bytedance/kmp/network/requet/Request; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    return-object v11
.end method

.method public postRaw(java.lang.String  java.lang.String  java.lang.String  java.util.Map  com.bytedance.trae.kmp.network.KmpHttpRequestOptions  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=7
    move-object v0, v12
    iget-object v1, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->requestFactory Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;
    new-instance v11, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;
    const-string v4, "POST"
    const/4 v6, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v2, v11
    move-object v3, v13
    move-object/from16 v5, v16
    move-object v7, v14
    move-object v8, v15
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v11, Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;->create(Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;)Lcom/bytedance/kmp/network/requet/Request;
    move-result-object v1
    move-object/from16 v2, v18
    invoke-direct v12, v1, v2, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;->execute(Lcom/bytedance/kmp/network/requet/Request; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
