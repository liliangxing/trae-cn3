# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
.super Ljava/lang/Object;
.source "ICancelTaskApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$guOpX5V-qYw3Ebrr6NG2Fj76wbk(com.bytedance.trae.im.service.CancelTaskRequest  com.bytedance.trae.im.service.ICancelTaskApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->cancelTaskRawCall$lambda$0(Lcom/bytedance/trae/im/service/CancelTaskRequest; Lcom/bytedance/trae/im/service/ICancelTaskApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final cancelTaskRawCall$lambda$0(com.bytedance.trae.im.service.CancelTaskRequest  com.bytedance.trae.im.service.ICancelTaskApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCallWithBody"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/ICancelTaskApi;->cancelTaskRaw(Lcom/bytedance/trae/im/service/CancelTaskRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
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

.method private final parseBizCode(java.lang.String)java.lang.Long
    .registers 6
    # ins_size=2
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    invoke-static v5, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v5
    const-string v0, "code"
    invoke-virtual v5, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +00bh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    move-object v1, v5
    return-object v1
    :try_start_0x13
.end method

.method private final parseBizMsg(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    invoke-static v3, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    const-string v0, "msg"
    invoke-virtual v3, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +3h
    move-object v1, v0
    goto +eh
    const-string v0, "message"
    invoke-virtual v3, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    move-object v1, v3
    return-object v1
    :try_start_0x13
.end method

.method public final cancelTaskRawCall(com.bytedance.trae.im.service.CancelTaskRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v19
    instance-of v2, v1, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;
    iget v3, v2, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;-><init>(Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion; Lkotlin/coroutines/Continuation;)V
    move-object v14, v2
    iget-object v1, v14, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v14, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->label I
    const/4 v4, 1
    if-eqz v3, +014h
    if-ne v3, v4, +00ah
    iget-object v2, v14, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +60h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "POST tasks/cancel rawCall: convId="
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/CancelTaskRequest;->getConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ", taskId="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/CancelTaskRequest;->getTaskId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v5, "ICancelTaskApi"
    invoke-virtual v1, v5, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "cancel_task"
    const-class v5, Lcom/bytedance/trae/im/service/ICancelTaskApi;
    const-class v6, Lcom/bytedance/trae/im/service/CancelTaskResponse;
    check-cast v6, Ljava/lang/reflect/Type;
    const/4 v7, 0
    const/4 v8, 0
    invoke-direct/range v17, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v9
    const/4 v10, 1
    sget-object v11, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v12, 0
    new-instance v13, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$$ExternalSyntheticLambda0;
    move-object/from16 v15, v18
    invoke-direct v13, v15, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/service/CancelTaskRequest;)V
    const/16 v15, 280
    const/16 v16, 0
    iput-object v0, v14, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->L$0 Ljava/lang/Object;
    iput v4, v14, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$cancelTaskRawCall$1;->label I
    move-object v4, v1
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v2, v0
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getBody()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->parseBizCode(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getBody()Ljava/lang/String;
    move-result-object v4
    invoke-direct v2, v4, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->parseBizMsg(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    new-instance v4, Lcom/bytedance/trae/im/service/CancelTaskRawResult;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v1
    invoke-direct v4, v1, v3, v2, Lcom/bytedance/trae/im/service/CancelTaskRawResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Ljava/lang/Long; Ljava/lang/String;)V
    return-object v4
.end method

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=3
    instance-of v0, v15, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;
    if-eqz v0, +012h
    move-object v0, v15
    check-cast v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;
    iget v1, v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v15, v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;->label I
    sub-int/2addr v15, v2
    iput v15, v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;
    invoke-direct v0, v13, v15, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;-><init>(Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;->label I
    const/4 v3, 1
    if-eqz v2, +015h
    if-ne v2, v3, +00bh
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    move-exception v14
    move-object v3, v14
    goto +52h
    move-exception v14
    goto +61h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v15, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v15, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v5, "cancel_task"
    const-class v6, Lcom/bytedance/trae/im/service/ICancelTaskApi;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 60
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/im/service/ICancelTaskApi;
    iput v3, v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion$safeCall$1;->label I
    invoke-interface v14, v15, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v1, +003h
    return-object v1
    check-cast v15, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v15, +01dh
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1005
    const-string v2, "BizResponse is null"
    new-instance v15, Ljava/lang/Exception;
    const-string v0, "BizResponse is null"
    invoke-direct v15, v0, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v3, v15
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +2fh
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v0, 0
    invoke-direct v14, v15, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +26h
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1000
    const-string v2, ""
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +15h
    new-instance v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1001
    const-string v2, ""
    move-object v3, v14
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v15
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v14, v15
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v14
    :try_start_0x26
    :try_start_0x3a
.end method
