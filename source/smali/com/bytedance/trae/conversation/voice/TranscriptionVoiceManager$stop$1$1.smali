# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $ignoreFinalText:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(boolean  com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->$ignoreFinalText Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->$ignoreFinalText Z
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;-><init>(Z Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    const-string v4, ""
    if-eqz v1, +016h
    if-eq v1, v3, +00dh
    if-ne v1, v2, +003h
    goto +9h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +50h
    move-exception v6
    goto/16 +0f3h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->$ignoreFinalText Z
    if-eqz v6, +023h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v6
    const-string v0, "cancel"
    const-string/jumbo v1, unknown
    iget-object v2, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$buildSessionSnapshot(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    move-result-object v2
    invoke-virtual v6, v0, v4, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->report(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    return-object v6
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getHasReceiveVoice$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Z
    move-result v6
    if-eqz v6, +010h
    move-object v6, v5
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v3, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->label I
    const-wide/16 v1, 2000
    invoke-static v1, v2, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +011h
    return-object v0
    move-object v6, v5
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->label I
    const-wide/16 v1, 1000
    invoke-static v1, v2, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    sget-object v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getRtcListener$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v3
    const/4 v0, 0
    if-eqz v6, +039h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v6
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v1
    const-string v2, "paragraph"
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->markFinalText(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$reportVoiceStartPerf(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$reportVoiceSessionPerf(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitFinalText(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto -7dh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +006h
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v1
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +005h
    const-string v2, "empty"
    goto +3h
    const-string v2, "current_text_fallback"
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->markFinalText(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$reportVoiceStartPerf(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$reportVoiceSessionPerf(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitFinalText(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    goto +9h
    const-string v0, "VoiceChatSession"
    const-string/jumbo v1, wait bot response failed
    invoke-static v0, v1, v6, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    move-exception v6
    iget-object v0, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$stopInternal(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)V
    throw v6
    :try_start_0x19
    :try_start_0x23
    :try_start_0x48
    :try_start_0x111
.end method
