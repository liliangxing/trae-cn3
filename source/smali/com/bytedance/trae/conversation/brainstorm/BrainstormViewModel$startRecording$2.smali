# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $session:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->$session Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->$session Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 34
    # ins_size=2
    move-object/from16 v0, v32
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +019h
    if-eq v2, v4, +011h
    if-ne v2, v3, +007h
    invoke-static/range v33, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a3h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v33, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v33
    goto +12h
    invoke-static/range v33, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->label I
    invoke-static v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$resolveVoiceConversationIdForRecording(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Ljava/lang/String;
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00ah
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    const/4 v4, 0
    const-string v5, "BrainstormViewModel"
    if-eqz v4, +074h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const-string/jumbo v8, voice_conversation_id_empty
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string/jumbo v6, startRecording: voice conversation id empty
    invoke-static v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    const/4 v9, 0
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const v30, 4194267
    const/16 v31, 0
    invoke-static/range v5 ... v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v5
    invoke-interface v4, v2, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -038h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_voicePromptEvents$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->label I
    invoke-interface v2, v4, v5, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->$session Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceChatListener$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    const-string v4, "chat"
    invoke-virtual v1, v3, v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->start(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v6, startRecording: session.start invoked, conversationId=
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", scene=chat, sessionRunning="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->$session Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isRunning()Z
    move-result v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", room="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->$session Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", task="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startRecording$2;->$session Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
