# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  com.bytedance.trae.conversation.voice.network.StartVoiceChatData  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    const-string v0, ""
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->label I
    const-string v4, "VoiceChatSession"
    const/4 v5, 1
    if-eqz v3, +013h
    if-ne v3, v5, +009h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +74h
    move-exception v0
    goto/16 +07fh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const-string/jumbo v3, stopVoiceChat
    invoke-static v4, v3, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setBotCompleteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setCurrentRecognizedText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setDefiniteText$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +046h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +03eh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +036h
    sget-object v6, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v7
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v8
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v10
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v11
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v12
    const-string/jumbo v9, transcription
    const/4 v13, 0
    move-object v14, v1
    check-cast v14, Lkotlin/coroutines/Continuation;
    const/16 v15, 64
    const/16 v16, 0
    iput v5, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->label I
    invoke-static/range v6 ... v16, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->stopVoiceChat$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->Stopped Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    goto +8h
    const-string/jumbo v2, stopVoiceChat failed
    invoke-static v4, v2, v0, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto -13h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->Stopped Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    throw v0
    :try_start_0x11
    :try_start_0x23
    :try_start_0x95
.end method
