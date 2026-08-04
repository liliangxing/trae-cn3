# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeHttpConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $allowEmptyBody:Z
.field final synthetic $execute:Lkotlin/jvm/functions/Function1;
.field final synthetic $interceptorPath:Ljava/lang/String;
.field final synthetic $parseBody:Lkotlin/jvm/functions/Function2;
.field final synthetic $requireHttpSuccess:Z
.field final synthetic $successCodes:Ljava/util/Set;
.field  label:I


.method constructor <init>(kotlin.jvm.functions.Function1  boolean  boolean  kotlin.jvm.functions.Function2  java.util.Set  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$execute Lkotlin/jvm/functions/Function1;
    iput-boolean v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$allowEmptyBody Z
    iput-boolean v3, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$requireHttpSuccess Z
    iput-object v4, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$parseBody Lkotlin/jvm/functions/Function2;
    iput-object v5, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$successCodes Ljava/util/Set;
    iput-object v6, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$interceptorPath Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;
    iget-object v1, v8, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$execute Lkotlin/jvm/functions/Function1;
    iget-boolean v2, v8, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$allowEmptyBody Z
    iget-boolean v3, v8, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$requireHttpSuccess Z
    iget-object v4, v8, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$parseBody Lkotlin/jvm/functions/Function2;
    iget-object v5, v8, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$successCodes Ljava/util/Set;
    iget-object v6, v8, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$interceptorPath Ljava/lang/String;
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;-><init>(Lkotlin/jvm/functions/Function1; Z Z Lkotlin/jvm/functions/Function2; Ljava/util/Set; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->label I
    if-nez v0, +153h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v14, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v14, Lcom/bytedance/trae/network/TraeHttpConnection;->access$elapsedRealtime(Lcom/bytedance/trae/network/TraeHttpConnection;)J
    move-result-wide v0
    const/4 v14, 0
    new-instance v2, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v2, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v3, 1
    iput-boolean v3, v2, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    iget-object v3, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$execute Lkotlin/jvm/functions/Function1;
    invoke-interface v3, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/retrofit2/SsResponse;
    if-nez v2, +020h
    new-instance v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v4, -1005
    const-string/jumbo v5, ssResponse is null
    new-instance v3, Ljava/lang/Exception;
    const-string/jumbo v6, ssResponse is null
    invoke-direct v3, v6, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v6, v3
    check-cast v6, Ljava/lang/Throwable;
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +105h
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v5
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v3, v2, Lcom/bytedance/trae/network/TraeHttpConnection;->access$readRawBody(Lcom/bytedance/trae/network/TraeHttpConnection; Lcom/bytedance/retrofit2/SsResponse;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +009h
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v4, v3, Lcom/bytedance/trae/network/TraeHttpConnection;->access$normalizeJsonBody(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v14
    if-eqz v3, +014h
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v4, v3, Lcom/bytedance/trae/network/TraeHttpConnection;->access$takeIfPresentBody(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +dh
    move-exception v14
    move-object v6, v14
    move-object v14, v3
    goto/16 +0b2h
    move-exception v14
    move-object v12, v3
    move-object v3, v14
    move-object v14, v12
    goto/16 +0c9h
    move-object v4, v14
    const-string v6, ""
    if-nez v4, +008h
    iget-boolean v7, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$allowEmptyBody Z
    if-eqz v7, +005h
    move-object v14, v6
    goto +2h
    move-object v14, v4
    iget-boolean v7, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$requireHttpSuccess Z
    const-string v8, "HTTP "
    if-eqz v7, +044h
    const/16 v7, 200
    if-eq v5, v7, +040h
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->message()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +00fh
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    new-instance v9, Ljava/lang/Exception;
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v10, ": "
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    if-nez v4, +003h
    goto +2h
    move-object v6, v4
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v9, v6, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    check-cast v9, Ljava/lang/Throwable;
    invoke-direct v14, v5, v7, v9, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    move-object v10, v14
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +1bh
    if-eqz v14, +01dh
    iget-object v4, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$parseBody Lkotlin/jvm/functions/Function2;
    invoke-interface v4, v14, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v14, v2, Lcom/bytedance/trae/network/response/BizResponse;->setupSSResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    iget-object v4, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$successCodes Ljava/util/Set;
    invoke-virtual v14, v4, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    iget-object v5, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$interceptorPath Ljava/lang/String;
    invoke-static v4, v5, v14, Lcom/bytedance/trae/network/TraeHttpConnection;->access$successResult(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Lcom/bytedance/trae/network/response/BizResponse;)Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v10
    move-object v14, v3
    goto/16 +06ch
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->message()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, "Empty response body"
    move-object v6, v4
    new-instance v4, Ljava/lang/Exception;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ": empty body"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v4, v7, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v7, v4
    check-cast v7, Ljava/lang/Throwable;
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v14
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v10, v14
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto -34h
    move-exception v3
    goto +5h
    move-exception v3
    goto +21h
    move-exception v3
    move-object v2, v14
    move-object v6, v3
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v3, v6, Lcom/bytedance/trae/network/TraeHttpConnection;->access$extractErrorInfo(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/Throwable;)Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;
    move-result-object v3
    new-instance v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getCode()I
    move-result v4
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;->getMessage()Ljava/lang/String;
    move-result-object v5
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +17h
    move-exception v3
    move-object v2, v14
    new-instance v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1001
    const-string v6, ""
    move-object v7, v3
    check-cast v7, Ljava/lang/Throwable;
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v10, v11
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    iget-object v4, v13, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCallWithBody$8;->$interceptorPath Ljava/lang/String;
    sget-object v5, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v5, Lcom/bytedance/trae/network/TraeHttpConnection;->access$elapsedRealtime(Lcom/bytedance/trae/network/TraeHttpConnection;)J
    move-result-wide v5
    sub-long/2addr v5, v0
    invoke-static v3, v4, v5, v6, v10, Lcom/bytedance/trae/network/TraeHttpConnection;->access$trackRequestEventSafely(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; J Lcom/bytedance/trae/network/response/HttpDataResult;)V
    new-instance v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-direct v0, v10, v14, v2, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)V
    return-object v0
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    :try_start_0x11
    :try_start_0x23
    :try_start_0x57
    :try_start_0x6e
    :try_start_0x7f
.end method
