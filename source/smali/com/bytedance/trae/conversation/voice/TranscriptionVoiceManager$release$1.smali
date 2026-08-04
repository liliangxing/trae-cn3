# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.network.StartVoiceChatData  com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v1, v16
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +013h
    if-ne v2, v3, +009h
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5ah
    move-exception v0
    goto/16 +090h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +045h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +03dh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +035h
    sget-object v5, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v6
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v7
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v9
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v10
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v8, transcription
    const/4 v12, 0
    move-object v13, v1
    check-cast v13, Lkotlin/coroutines/Continuation;
    const/16 v14, 64
    const/4 v15, 0
    iput v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->label I
    invoke-static/range v5 ... v15, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->stopVoiceChat$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getScope$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getUiScope$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +043h
    invoke-static v0, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    goto +3eh
    const-string v2, "VoiceChatSession"
    const-string/jumbo v5, stopVoiceChat on release failed
    invoke-static v2, v5, v0, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getScope$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getUiScope$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +003h
    goto -40h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getScope$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    sget-object v5, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v5, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v2, v5, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/Job;
    if-eqz v2, +005h
    invoke-static v2, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$release$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getUiScope$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    sget-object v5, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v5, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v2, v5, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/Job;
    if-eqz v2, +005h
    invoke-static v2, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    throw v0
    :try_start_0xe
    :try_start_0x20
    :try_start_0xa3
.end method
