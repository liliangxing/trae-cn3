# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormMcpClient.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatId:Ljava/lang/String;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $sessionId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;


.method public static synthetic $r8$lambda$g0meyLnSLs-xVVfKV0G-VFXOfCA(kotlinx.coroutines.CoroutineScope  kotlin.jvm.internal.Ref$ObjectRef  java.lang.StringBuilder  com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String  java.lang.String)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->invokeSuspend$lambda$1(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$sessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$messageId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$chatId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$1(kotlinx.coroutines.CoroutineScope  kotlin.jvm.internal.Ref$ObjectRef  java.lang.StringBuilder  com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String  java.lang.String)kotlin.Unit
    .registers 10
    # ins_size=6
    invoke-static v4, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v4
    if-nez v4, +005h
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    const-string v4, "event:"
    const/4 v0, 0
    const/4 v1, 2
    const/4 v2, 0
    invoke-static v9, v4, v0, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +016h
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v9, v4, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    iput-object v4, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    goto/16 +096h
    const-string v4, "data:"
    invoke-static v9, v4, v0, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +027h
    move-object v5, v6
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +003h
    move v0, v2
    if-eqz v0, +007h
    const-string v5, "
"
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v9, v4, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +67h
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +060h
    move-object v4, v6
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    move v0, v2
    if-eqz v0, +054h
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$getGson$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;)Lcom/google/gson/Gson;
    move-result-object v4
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcSseEvent;
    iget-object v0, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v8, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcSseEvent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, v9, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$getSessionManager$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v7
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v7, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->sendServerMessage(Ljava/lang/String;)J
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v7, "forwarded SSE event: type="
    invoke-direct v4, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", length="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Ljava/lang/StringBuilder;->length()I
    move-result v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v7, "BrainstormMcpClient"
    invoke-static v7, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    const-string v4, ""
    iput-object v4, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-static v6, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$sessionId Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$messageId Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$chatId Ljava/lang/String;
    move-object v0, v6
    move-object v5, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlin/coroutines/Continuation;
    return-object v6
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    const-string v0, "BrainstormMcpClient"
    const-string v1, "forwarded final SSE event: type="
    const-string v2, "SSE stream completed for chatId="
    const-string/jumbo v3, subscribeSse failed: 
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v4, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->label I
    if-nez v4, +0feh
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->L$0 Ljava/lang/Object;
    move-object v5, v14
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    sget-object v14, Lcom/bytedance/trae/im/service/ISendMessageService;->Companion Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
    const-string v4, "Accept"
    const-string/jumbo v6, text/event-stream
    invoke-static v4, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    invoke-static v4, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    invoke-virtual v14, v4, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->createService(Ljava/util/Map;)Lcom/bytedance/trae/im/service/ISendMessageService;
    move-result-object v14
    iget-object v4, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$sessionId Ljava/lang/String;
    iget-object v6, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$messageId Ljava/lang/String;
    invoke-interface v14, v4, v6, Lcom/bytedance/trae/im/service/ISendMessageService;->subscribeSseEvents(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;
    move-result-object v14
    invoke-interface v14, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->isSuccessful()Z
    move-result v6
    if-nez v6, +019h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->raw()Lcom/bytedance/retrofit2/client/Response;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/retrofit2/client/Response;->getBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v3
    if-nez v3, +00bh
    const-string/jumbo v1, subscribeSse: response body is null
    invoke-static v0, v1, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    new-instance v4, Ljava/io/BufferedReader;
    new-instance v6, Ljava/io/InputStreamReader;
    invoke-interface v3, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v3
    sget-object v7, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v6, v3, v7, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v6, Ljava/io/Reader;
    invoke-direct v4, v6, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    new-instance v3, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v3, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    const-string v6, ""
    iput-object v6, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, Ljava/lang/StringBuilder;-><init>()V
    move-object v11, v4
    check-cast v11, Ljava/io/Reader;
    iget-object v8, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iget-object v9, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$chatId Ljava/lang/String;
    new-instance v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;
    move-object v4, v12
    move-object v6, v3
    move-object v7, v10
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;-><init>(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String;)V
    invoke-static v11, v12, Lkotlin/io/TextStreamsKt;->forEachLine(Ljava/io/Reader; Lkotlin/jvm/functions/Function1;)V
    move-object v4, v10
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +041h
    iget-object v4, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$getGson$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;)Lcom/google/gson/Gson;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcSseEvent;
    iget-object v6, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$chatId Ljava/lang/String;
    iget-object v7, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v9, toString(...)
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v6, v7, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcSseEvent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    iget-object v5, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$getSessionManager$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v5
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v5, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->sendServerMessage(Ljava/lang/String;)J
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$chatId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    goto +11h
    move-exception v14
    const-string/jumbo v1, subscribeSse error
    invoke-static v0, v1, v14, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto +9h
    const-string v1, "SSE subscription cancelled"
    invoke-static v0, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-interface v14, Lcom/bytedance/retrofit2/Call;->cancel()V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    :try_start_0x33
.end method
