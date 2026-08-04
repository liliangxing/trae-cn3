# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $startTime:Lkotlin/jvm/internal/Ref$LongRef;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  kotlin.jvm.internal.Ref$LongRef  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->$startTime Lkotlin/jvm/internal/Ref$LongRef;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->$startTime Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/jvm/internal/Ref$LongRef; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 28
    # ins_size=2
    move-object/from16 v1, v26
    const-string/jumbo v0, startVoiceChat returns invalid data: 
    const-string v2, "preload cachedData invalid: "
    const-string/jumbo v3, startVoiceChat failed: 
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->label I
    const-string v6, "Voice discussion is in progress"
    const-string v7, "invalid voiceChat data"
    const/4 v8, 1
    const-string v9, ""
    const-string v10, "VoiceChatSession"
    if-eqz v5, +016h
    if-ne v5, v8, +00ch
    invoke-static/range v27, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v27
    goto/16 +11bh
    move-exception v0
    goto/16 +20dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v27, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->getCachedData()Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-result-object v5
    if-eqz v5, +0abh
    const-string v0, "preload cachedData"
    invoke-static v10, v0, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v0
    const-string v3, "cached_join_first"
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->setStartPath(Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$isVoiceChatDataValid(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)Z
    move-result v0
    if-nez v0, +026h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v10, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v2, Ljava/lang/IllegalArgumentException;
    invoke-direct v2, v7, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$handleJoinRefused(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setVoiceChat$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v9
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v9, v3
    invoke-virtual v0, v2, v9, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->captureVoiceChatData(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfJoinRoomTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getRtcListener$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;->Transcription Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    invoke-virtual v0, v5, v2, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->join$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;)Z
    move-result v0
    if-nez v0, +01bh
    const-string v0, "VolcRtcClient busy, refuse to start transcription voice (preloaded path)"
    invoke-static v10, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v2, Ljava/lang/IllegalStateException;
    invoke-direct v2, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$handleJoinRefused(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iget-object v4, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->$startTime Lkotlin/jvm/internal/Ref$LongRef;
    iget-wide v4, v4, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sub-long/2addr v2, v4
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setVoiceStartCaptureDuration$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->JoiningRoom Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->startRoom()V
    goto/16 +15bh
    const-string v2, "no preload cachedData"
    invoke-static v10, v2, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v2
    const-string v5, "cold_api"
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->setStartPath(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v5
    invoke-virtual v5, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v11, toString(...)
    invoke-static v5, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setConversationId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    invoke-static v2, v11, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfStartVoiceChatTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    sget-object v13, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v14
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v15
    const-string/jumbo v16, transcription
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    move-object/from16 v23, v1
    check-cast v23, Lkotlin/coroutines/Continuation;
    const/16 v24, 504
    const/16 v25, 0
    iput v8, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->label I
    invoke-static/range v13 ... v25, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->startVoiceChat$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    invoke-static v4, v11, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfApiRequestEndTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    instance-of v4, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v5, 0
    if-nez v4, +029h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v10, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string/jumbo v3, startVoiceChat failed
    invoke-direct v2, v3, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$handleJoinRefused(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-nez v2, +01fh
    const-string/jumbo v0, startVoiceChat returned null data
    invoke-static v10, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string/jumbo v3, startVoiceChat empty data
    invoke-direct v2, v3, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$handleJoinRefused(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$isVoiceChatDataValid(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)Z
    move-result v3
    if-nez v3, +026h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v10, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v3, Ljava/lang/IllegalArgumentException;
    invoke-direct v3, v7, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Throwable;
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$handleJoinRefused(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setVoiceChat$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    move-object v3, v9
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +2h
    move-object v9, v4
    invoke-virtual v0, v3, v9, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->captureVoiceChatData(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-static v0, v3, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfJoinRoomTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getRtcListener$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    sget-object v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;->Transcription Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->join$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;)Z
    move-result v0
    if-nez v0, +01bh
    const-string v0, "VolcRtcClient busy, refuse to start transcription voice (api path)"
    invoke-static v10, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v3, Ljava/lang/IllegalStateException;
    invoke-direct v3, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Throwable;
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$handleJoinRefused(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iget-object v4, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->$startTime Lkotlin/jvm/internal/Ref$LongRef;
    iget-wide v4, v4, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sub-long/2addr v2, v4
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setVoiceStartCaptureDuration$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->JoiningRoom Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    goto +bh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$start$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->onError()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x1d
    :try_start_0x32
.end method
