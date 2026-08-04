# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  com.bytedance.trae.conversation.voice.network.StartVoiceChatData  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$conversationId Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +46h
    move-exception v13
    goto +3ch
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v13, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v13, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Ljava/lang/String;
    move-result-object v3
    iget-object v13, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v5
    iget-object v13, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v6
    iget-object v13, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v7
    iget-object v13, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->$conversationId Ljava/lang/String;
    const-string/jumbo v4, transcription
    const/4 v8, 0
    move-object v9, v12
    check-cast v9, Lkotlin/coroutines/Continuation;
    const/16 v10, 64
    const/4 v11, 0
    iput v2, v12, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stopVoiceChatBestEffort$1;->label I
    move-object v2, v13
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->stopVoiceChat$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +00bh
    return-object v0
    const-string v0, "VoiceChatSession"
    const-string/jumbo v1, stopVoiceChat after join refused failed
    invoke-static v0, v1, v13, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    :try_start_0xb
    :try_start_0x1c
.end method
