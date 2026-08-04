# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
.super Ljava/lang/Object;
.source "BrainstormMcpClient.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$Companion;
.field private static final TAG:Ljava/lang/String;
.field private currentJob:Lkotlinx/coroutines/Job;
.field private final gson:Lcom/google/gson/Gson;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field private final sessionId:Ljava/lang/String;
.field private final sessionManager:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, sessionManager
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->sessionManager Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->sessionId Ljava/lang/String;
    new-instance v2, Lcom/google/gson/Gson;
    invoke-direct v2, Lcom/google/gson/Gson;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->gson Lcom/google/gson/Gson;
    const/4 v2, 0
    const/4 v3, 1
    invoke-static v2, v3, v2, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v2
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v2, v3, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method public static final synthetic access$getGson$p(com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient)com.google.gson.Gson
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->gson Lcom/google/gson/Gson;
    return-object v0
.end method

.method public static final synthetic access$getSessionId$p(com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getSessionManager$p(com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient)com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->sessionManager Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    return-object v0
.end method

.method public static final synthetic access$parseRtcLlmRequest(com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String)com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient$RtcLlmRequest
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->parseRtcLlmRequest(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$postMessage(com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String  com.google.gson.JsonObject  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->postMessage(Ljava/lang/String; Lcom/google/gson/JsonObject; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$subscribeSseAndForward(com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->subscribeSseAndForward(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final parseRtcLlmRequest(java.lang.String)com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient$RtcLlmRequest
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->gson Lcom/google/gson/Gson;
    const-class v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;
    invoke-virtual v0, v3, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;
    goto +1bh
    move-exception v3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "parseRtcLlmRequest failed: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "BrainstormMcpClient"
    invoke-static v0, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    const/4 v3, 0
    return-object v3
    :try_start_0x0
.end method

.method private final postMessage(java.lang.String  com.google.gson.JsonObject  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=4
    instance-of v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;
    invoke-direct v0, v5, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +48h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const-string v8, "messages"
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->getAsJsonArray(Ljava/lang/String;)Lcom/google/gson/JsonArray;
    move-result-object v7
    if-eqz v7, +01fh
    check-cast v7, Ljava/lang/Iterable;
    invoke-static v7, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/lang/Iterable;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/google/gson/JsonElement;
    if-eqz v7, +015h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-eqz v7, +00fh
    const-string v8, "content"
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v4
    if-nez v7, +004h
    const-string v7, ""
    sget-object v8, Lcom/bytedance/trae/im/service/ISendMessageService;->Companion Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;
    invoke-direct v2, v6, v7, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$1;->label I
    invoke-virtual v8, v2, v0, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v6, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v7, "BrainstormMcpClient"
    if-eqz v6, +03bh
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/SendMessageResponse;
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/SendMessageResponse;->getMessageId()Ljava/lang/String;
    move-result-object v6
    move-object v4, v6
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00ah
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +047h
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v0, "postMessage: messageId is empty, resp="
    invoke-direct v6, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v8
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v7, v6, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    goto +2fh
    instance-of v6, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v6, +02dh
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v0, "postMessage failed: code="
    invoke-direct v6, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v0, ", msg="
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v8
    invoke-static v7, v6, v8, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v4
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
.end method

.method private final subscribeSseAndForward(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v9
    move-object v3, v10
    move-object v4, v8
    move-object v5, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
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

.method public final cancel()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->currentJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->currentJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final handleBotMessage(java.lang.String)void
    .registers 11
    # ins_size=2
    const-string v0, "botMessage"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->currentJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;
    invoke-direct v0, v9, v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->currentJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final release()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->cancel()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->scope Lkotlinx/coroutines/CoroutineScope;
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v1, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v1, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v1, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +007h
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method
