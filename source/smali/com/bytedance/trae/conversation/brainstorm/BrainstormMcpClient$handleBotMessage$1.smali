# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormMcpClient.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $botMessage:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->$botMessage Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->$botMessage Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    const-string v0, "POST /messages success: messageId="
    const-string v1, "handleBotMessage: chat_id="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->label I
    const/4 v4, 0
    const/4 v5, 2
    const/4 v6, 1
    const-string v7, "BrainstormMcpClient"
    if-eqz v3, +01fh
    if-eq v3, v6, +014h
    if-ne v3, v5, +00ah
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0f7h
    move-exception v12
    goto/16 +0e9h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    iget-object v1, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a0h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->$botMessage Ljava/lang/String;
    invoke-static v12, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$parseRtcLlmRequest(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;
    move-result-object v12
    if-nez v12, +00ah
    const-string v12, "handleBotMessage: failed to parse RTCLLMRequest"
    invoke-static v7, v12, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;->getChatId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", signature="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;->getSignature()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +009h
    const/16 v8, 20
    invoke-static v3, v8, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "..."
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;->getSignature()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    move v3, v6
    if-eqz v3, +00ah
    const-string v12, "handleBotMessage: signature is empty, skip setServerParams"
    invoke-static v7, v12, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    iget-object v3, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$getSessionManager$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v3
    sget-object v8, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->getHOST()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v1, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->setServerParams(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, setServerParams done
    invoke-static v7, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;->getRequest()Lcom/google/gson/JsonObject;
    move-result-object v1
    if-nez v1, +00ah
    const-string v12, "handleBotMessage: request body is null"
    invoke-static v7, v12, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    iget-object v3, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$getSessionId$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;)Ljava/lang/String;
    move-result-object v8
    move-object v9, v11
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->L$0 Ljava/lang/Object;
    iput v6, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->label I
    invoke-static v3, v8, v1, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$postMessage(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Lcom/google/gson/JsonObject; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    move-object v10, v1
    move-object v1, v12
    move-object v12, v10
    check-cast v12, Ljava/lang/String;
    if-nez v12, +00ah
    const-string v12, "handleBotMessage: POST /messages failed"
    invoke-static v7, v12, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v7, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$getSessionId$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;->getChatId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    move-object v6, v11
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v4, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->L$0 Ljava/lang/Object;
    iput v5, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$handleBotMessage$1;->label I
    invoke-static v0, v3, v12, v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;->access$subscribeSseAndForward(Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v2, +00eh
    return-object v2
    const-string v0, "handleBotMessage error"
    invoke-static v7, v0, v12, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto +6h
    const-string v12, "handleBotMessage cancelled"
    invoke-static v7, v12, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    :try_start_0x15
    :try_start_0x29
    :try_start_0x31
.end method
