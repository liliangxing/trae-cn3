# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $botName:Ljava/lang/String;
.field final synthetic $payload:Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
.field final synthetic $uid:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol$SubtitlePayload  java.lang.String  com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$payload Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$botName Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$uid Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$payload Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$botName Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$uid Ljava/lang/String;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;-><init>(Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->label I
    if-nez v0, +162h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$payload Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;->getData()Ljava/util/List;
    move-result-object v13
    check-cast v13, Ljava/lang/Iterable;
    iget-object v0, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$botName Ljava/lang/String;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iget-object v2, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$handleSubvMessage$2;->$uid Ljava/lang/String;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +144h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getDefinite()Z
    move-result v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getText()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getParagraph()Z
    move-result v6
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getUserId()Ljava/lang/String;
    move-result-object v3
    move-object v7, v0
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    const/4 v8, 0
    const/4 v9, 1
    if-lez v7, +004h
    move v7, v9
    goto +2h
    move v7, v8
    if-eqz v7, +00ah
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +004h
    move v7, v9
    goto +2h
    move v7, v8
    invoke-static v1, v9, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setHasReceiveVoice$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Z)V
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "RTC subtitle: uid="
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", userId="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v10, " botName="
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v10, " isBot="
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v10, " paragraph="
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v10, " definite="
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v10, "VoiceChatSession"
    invoke-static v10, v3, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v3, ""
    if-eqz v7, +034h
    if-eqz v6, -082h
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v4
    if-nez v4, -08eh
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    goto/16 -0b2h
    if-eqz v4, +02eh
    move-object v4, v5
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    move v8, v9
    if-eqz v8, +022h
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    goto +19h
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAsrCallbackCount$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)I
    move-result v4
    add-int/2addr v4, v9
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setAsrCallbackCount$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; I)V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v4
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v9
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->onRecognizedText(Z)V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitRecognizedText(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    if-eqz v6, -11bh
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getAttemptTracker$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->onParagraph()V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-static v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    goto/16 -146h
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
.end method
