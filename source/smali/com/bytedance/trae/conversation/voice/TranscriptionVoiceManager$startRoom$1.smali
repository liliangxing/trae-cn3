# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 25
    # ins_size=2
    move-object/from16 v1, v23
    const-string/jumbo v0, startRoom startVoiceChat returns invalid data: 
    const-string/jumbo v2, startRoom startVoiceChat failed: 
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->label I
    const/4 v5, 1
    const-string v6, "VoiceChatSession"
    if-eqz v4, +015h
    if-ne v4, v5, +00bh
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v24
    goto +6ah
    move-exception v0
    goto/16 +117h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->getCachedData()Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-result-object v4
    if-eqz v4, +116h
    iget-object v7, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    invoke-static v7, v8, v9, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfStartVoiceChatTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    sget-object v10, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v11
    iget-object v7, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v12
    const-string/jumbo v13, transcription
    const/4 v14, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getUserId()Ljava/lang/String;
    move-result-object v16
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v17
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getToken()Ljava/lang/String;
    move-result-object v18
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotUserId()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v7
    if-nez v7, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotUserId()Ljava/lang/String;
    move-result-object v4
    goto +5h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotName()Ljava/lang/String;
    move-result-object v4
    move-object/from16 v19, v4
    move-object/from16 v20, v1
    check-cast v20, Lkotlin/coroutines/Continuation;
    const/16 v21, 8
    const/16 v22, 0
    iput v5, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->label I
    invoke-static/range v10 ... v22, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->startVoiceChat$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v3, +003h
    return-object v3
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    invoke-static v3, v7, v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfApiRequestEndTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    instance-of v3, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-nez v3, +029h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v6, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string/jumbo v3, startVoiceChat failed
    invoke-direct v2, v3, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-nez v2, +01fh
    const-string/jumbo v0, startRoom startVoiceChat returned null data
    invoke-static v6, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string/jumbo v3, startVoiceChat empty data
    invoke-direct v2, v3, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$isVoiceChatDataValid(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)Z
    move-result v3
    if-nez v3, +028h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v6, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v2, Ljava/lang/IllegalArgumentException;
    const-string v3, "invalid voiceChat data"
    invoke-direct v2, v3, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setVoiceChat$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v3
    const-string v4, ""
    if-nez v3, +003h
    move-object v3, v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v4, v2
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->captureVoiceChatData(Ljava/lang/String; Ljava/lang/String;)V
    goto +13h
    check-cast v0, Ljava/lang/Throwable;
    const-string/jumbo v2, startRoom failed
    invoke-static v6, v2, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$startRoom$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x15
    :try_start_0x29
    :try_start_0x127
.end method
