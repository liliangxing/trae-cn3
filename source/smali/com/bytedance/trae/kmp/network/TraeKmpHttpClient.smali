# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
.super Ljava/lang/Object;
.source "TraeKmpHttpClient.kt"

.implements Lcom/bytedance/trae/kmp/network/KmpHttpClient;

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$Companion;
.field private static final json:Lkotlinx/serialization/json/Json;
.field private final eventReporter:Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;
.field private final headerProvider:Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private final rawClient:Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;


.method public static synthetic $r8$lambda$jgFKOHF-du1H4rUj9a8n0Pq9cyg(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->json$lambda$3(Lkotlinx/serialization/json/JsonBuilder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->Companion Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$Companion;
    new-instance v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$$ExternalSyntheticLambda0;-><init>()V
    const/4 v2, 1
    invoke-static v1, v0, v2, v1, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Lkotlinx/serialization/json/Json;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->json Lkotlinx/serialization/json/Json;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.network.KmpRawHttpClient  com.bytedance.trae.kmp.network.KmpHttpHeaderProvider  com.bytedance.trae.kmp.network.KmpHttpEventReporter  com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, rawClient
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headerProvider"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "eventReporter"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->rawClient Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->headerProvider Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->eventReporter Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpRawHttpClient  com.bytedance.trae.kmp.network.KmpHttpHeaderProvider  com.bytedance.trae.kmp.network.KmpHttpEventReporter  com.bytedance.trae.kmp.host.KmpHostInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +006h
    sget-object v4, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    check-cast v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;-><init>(Lcom/bytedance/trae/kmp/network/KmpRawHttpClient; Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider; Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    return-void 
.end method

.method private final absoluteUrl(com.bytedance.trae.kmp.network.KmpHostType  java.lang.String)java.lang.String
    .registers 8
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->INSTANCE Lcom/bytedance/trae/kmp/network/KmpHostResolver;
    iget-object v1, v5, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->baseUrl(Lcom/bytedance/trae/kmp/network/KmpHostType; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/lang/String;
    move-result-object v6
    const-string v0, "/"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v6, v0, v1, v2, v3, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +01fh
    invoke-static v7, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    const/4 v1, 1
    invoke-static v6, v1, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    goto +36h
    invoke-static v6, v0, v1, v2, v3, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +020h
    invoke-static v7, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01ah
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const/16 v0, 47
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    goto +12h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method private final decode(com.bytedance.trae.kmp.network.KmpRawHttpResult  kotlinx.serialization.DeserializationStrategy)com.bytedance.trae.kmp.network.KmpHttpResult
    .registers 12
    # ins_size=3
    invoke-virtual v10, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->getRawBody()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +01fh
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->json Lkotlinx/serialization/json/Json;
    invoke-virtual v2, v11, v0, Lkotlinx/serialization/json/Json;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    goto +ch
    move-exception v11
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->box-impl(Ljava/lang/Object;)Lkotlin/Result;
    move-result-object v11
    goto +2h
    move-object v11, v1
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    if-eqz v11, +00fh
    invoke-virtual v11, Lkotlin/Result;->unbox-impl()Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move-object v3, v2
    goto +2h
    move-object v3, v1
    invoke-virtual v10, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->getRawBody()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v10, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->getStatusCode()I
    move-result v5
    invoke-virtual v10, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->getStatusMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v10, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->getHeaders()Ljava/util/Map;
    move-result-object v7
    if-eqz v11, +00fh
    invoke-virtual v11, Lkotlin/Result;->unbox-impl()Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v11
    if-nez v11, +003h
    goto +3h
    move-object v8, v11
    goto +6h
    invoke-virtual v10, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->getError()Ljava/lang/Throwable;
    move-result-object v10
    move-object v8, v10
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/kmp/network/KmpHttpResult;-><init>(Ljava/lang/Object; Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/Throwable;)V
    return-object v0
    :try_start_0x7
.end method

.method private static final json$lambda$3(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$Json"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v0, Lkotlinx/serialization/json/JsonBuilder;->setIgnoreUnknownKeys(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final mergedHeaders(com.bytedance.trae.kmp.network.KmpHttpRequestOptions  java.util.Map)java.util.Map
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->headerProvider Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;->headers(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v2
    return-object v2
.end method

.method private final reportIfNeeded(java.lang.String  com.bytedance.trae.kmp.network.KmpHttpRequestOptions  long  com.bytedance.trae.kmp.network.KmpHttpResult)void
    .registers 15
    # ins_size=6
    invoke-virtual v11, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->getTrackRequestEvent()Z
    move-result v11
    if-nez v11, +003h
    return-void 
    invoke-virtual v14, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v11
    instance-of v0, v11, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    if-eqz v0, +005h
    check-cast v11, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    goto +2h
    const/4 v11, 0
    new-instance v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->getCode()J
    move-result-wide v0
    goto +6h
    invoke-virtual v14, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getStatusCode()I
    move-result v0
    int-to-long v0, v0
    move-wide v4, v0
    if-eqz v11, +008h
    invoke-virtual v11, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->getBusinessMessage()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +006h
    invoke-virtual v14, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getStatusMessage()Ljava/lang/String;
    move-result-object v11
    move-object v6, v11
    invoke-virtual v14, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getHeaders()Ljava/util/Map;
    move-result-object v7
    move-object v0, v8
    move-object v1, v10
    move-wide v2, v12
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;-><init>(Ljava/lang/String; J J Ljava/lang/String; Ljava/util/Map;)V
    sget-object v10, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
    iget-object v10, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->eventReporter Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;
    invoke-interface v10, v8, Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;->report(Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v10
    sget-object v11, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v10, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x39
.end method

.method private final withHostType(com.bytedance.trae.kmp.network.KmpHttpRequestOptions  com.bytedance.trae.kmp.network.KmpHostType)com.bytedance.trae.kmp.network.KmpHttpRequestOptions
    .registers 13
    # ins_size=3
    invoke-virtual v11, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->getHostType()Lcom/bytedance/trae/kmp/network/KmpHostType;
    move-result-object v0
    if-ne v0, v12, +003h
    goto +fh
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v8, 31
    const/4 v9, 0
    move-object v1, v11
    move-object v7, v12
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->copy$default(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    move-result-object v11
    return-object v11
.end method

.method public getResult(com.bytedance.trae.kmp.network.KmpHostType  java.lang.String  java.util.Map  java.util.Map  com.bytedance.trae.kmp.network.KmpHttpRequestOptions  kotlinx.serialization.DeserializationStrategy  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=8
    move-object v0, v14
    move-object/from16 v1, v21
    instance-of v2, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;
    invoke-direct v2, v14, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;-><init>(Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient; Lkotlin/coroutines/Continuation;)V
    move-object v8, v2
    iget-object v1, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->label I
    const/4 v4, 1
    if-eqz v3, +029h
    if-ne v3, v4, +01fh
    iget-wide v2, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->J$0 J
    iget-object v4, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$4 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
    iget-object v5, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$3 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    iget-object v6, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/serialization/DeserializationStrategy;
    iget-object v7, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v5
    move-object v13, v6
    move-object v12, v7
    goto +45h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v1, v15
    move-object/from16 v3, v19
    invoke-direct v14, v3, v15, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->withHostType(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lcom/bytedance/trae/kmp/network/KmpHostType;)Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    move-result-object v9
    sget-object v3, Lkotlin/time/TimeSource$Monotonic;->INSTANCE Lkotlin/time/TimeSource$Monotonic;
    invoke-virtual v3, Lkotlin/time/TimeSource$Monotonic;->markNow-z9LOYto()J
    move-result-wide v10
    iget-object v3, v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->rawClient Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;
    invoke-direct/range v14 ... v16, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->absoluteUrl(Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object/from16 v5, v17
    invoke-direct v14, v9, v5, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->mergedHeaders(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v5
    iput-object v0, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$0 Ljava/lang/Object;
    move-object/from16 v12, v16
    iput-object v12, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$1 Ljava/lang/Object;
    move-object/from16 v13, v20
    iput-object v13, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$2 Ljava/lang/Object;
    iput-object v9, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$3 Ljava/lang/Object;
    iput-object v0, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->L$4 Ljava/lang/Object;
    iput-wide v10, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->J$0 J
    iput v4, v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$getResult$1;->label I
    move-object v4, v1
    move-object/from16 v6, v18
    move-object v7, v9
    invoke-interface/range v3 ... v8, Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;->getRaw(Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v4, v0
    move-object v8, v4
    move-wide v2, v10
    check-cast v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    invoke-direct v4, v1, v13, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->decode(Lcom/bytedance/trae/kmp/network/KmpRawHttpResult; Lkotlinx/serialization/DeserializationStrategy;)Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    move-result-object v1
    invoke-static v2, v3, Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;->elapsedNow-UwyO8pc(J)J
    move-result-wide v2
    invoke-static v2, v3, Lkotlin/time/Duration;->getInWholeMilliseconds-impl(J)J
    move-result-wide v2
    move-object v15, v8
    move-object/from16 v16, v12
    move-object/from16 v17, v9
    move-wide/from16 v18, v2
    move-object/from16 v20, v1
    invoke-direct/range v15 ... v20, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->reportIfNeeded(Ljava/lang/String; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; J Lcom/bytedance/trae/kmp/network/KmpHttpResult;)V
    return-object v1
.end method

.method public postResult(com.bytedance.trae.kmp.network.KmpHostType  java.lang.String  java.lang.String  java.lang.String  java.util.Map  com.bytedance.trae.kmp.network.KmpHttpRequestOptions  kotlinx.serialization.DeserializationStrategy  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=9
    move-object v0, v15
    move-object/from16 v1, v23
    instance-of v2, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;
    invoke-direct v2, v15, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;-><init>(Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient; Lkotlin/coroutines/Continuation;)V
    move-object v9, v2
    iget-object v1, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->label I
    const/4 v4, 1
    if-eqz v3, +028h
    if-ne v3, v4, +01eh
    iget-wide v2, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->J$0 J
    iget-object v4, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$4 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
    iget-object v5, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$3 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    iget-object v6, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lkotlinx/serialization/DeserializationStrategy;
    iget-object v7, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v10, v5
    move-object v14, v6
    goto +49h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v1, v16
    move-object/from16 v3, v21
    invoke-direct v15, v3, v1, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->withHostType(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lcom/bytedance/trae/kmp/network/KmpHostType;)Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    move-result-object v10
    sget-object v3, Lkotlin/time/TimeSource$Monotonic;->INSTANCE Lkotlin/time/TimeSource$Monotonic;
    invoke-virtual v3, Lkotlin/time/TimeSource$Monotonic;->markNow-z9LOYto()J
    move-result-wide v11
    iget-object v3, v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->rawClient Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;
    invoke-direct/range v15 ... v17, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->absoluteUrl(Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object/from16 v5, v20
    invoke-direct v15, v10, v5, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->mergedHeaders(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v7
    iput-object v0, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$0 Ljava/lang/Object;
    move-object/from16 v13, v17
    iput-object v13, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$1 Ljava/lang/Object;
    move-object/from16 v14, v22
    iput-object v14, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$2 Ljava/lang/Object;
    iput-object v10, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$3 Ljava/lang/Object;
    iput-object v0, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->L$4 Ljava/lang/Object;
    iput-wide v11, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->J$0 J
    iput v4, v9, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$postResult$1;->label I
    move-object v4, v1
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    move-object v8, v10
    invoke-interface/range v3 ... v9, Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;->postRaw(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v4, v0
    move-object v8, v4
    move-wide v2, v11
    move-object v7, v13
    check-cast v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    invoke-direct v4, v1, v14, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->decode(Lcom/bytedance/trae/kmp/network/KmpRawHttpResult; Lkotlinx/serialization/DeserializationStrategy;)Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    move-result-object v1
    invoke-static v2, v3, Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;->elapsedNow-UwyO8pc(J)J
    move-result-wide v2
    invoke-static v2, v3, Lkotlin/time/Duration;->getInWholeMilliseconds-impl(J)J
    move-result-wide v2
    move-object/from16 v16, v8
    move-object/from16 v17, v7
    move-object/from16 v18, v10
    move-wide/from16 v19, v2
    move-object/from16 v21, v1
    invoke-direct/range v16 ... v21, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;->reportIfNeeded(Ljava/lang/String; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; J Lcom/bytedance/trae/kmp/network/KmpHttpResult;)V
    return-object v1
.end method
