# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;
.super Ljava/lang/Object;
.source "BrainstormViewModel.kt"

.implements Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onConversationStateChanged(com.bytedance.trae.conversation.voice.ConversationStateMessage)void
    .registers 37
    # ins_size=2
    move-object/from16 v0, v35
    const-string/jumbo v1, state
    move-object/from16 v2, v36
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "onConversationStateChanged: stage="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getCode()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v5, 45
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getDescription()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", roundId="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getRoundID()J
    move-result-wide v5
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", errorCode="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v5
    const/4 v6, 0
    if-eqz v5, +00bh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getErrorCode()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    goto +2h
    move-object v5, v6
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", errorReasonHash="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getReason()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v6
    const-string v7, ""
    if-nez v5, +003h
    move-object v5, v7
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "BrainstormViewModel"
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getDescription()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getCode()I
    move-result v3
    const/4 v5, 0
    if-eqz v3, +2aah
    const/4 v4, 1
    if-eq v3, v4, +255h
    const/4 v6, 2
    if-eq v3, v6, +188h
    const/4 v2, 3
    if-eq v3, v2, +106h
    const/4 v2, 4
    if-eq v3, v2, +07ah
    const/4 v2, 5
    if-eq v3, v2, +004h
    goto/16 +37bh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v2
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->setAiListening(Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$stopOutputVolumeMonitoring(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v8, v3
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    sget-object v12, Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const v33, 4063207
    const/16 v34, 0
    move-object/from16 v28, v1
    invoke-static/range v8 ... v34, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -03bh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v1
    if-eqz v1, +322h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFinishMs()Ljava/lang/Long;
    move-result-object v3
    if-nez v3, +00dh
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setBotFinishMs(Ljava/lang/Long;)V
    const-string v3, "answer_finish"
    invoke-static v2, v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$tryReportRoundIfFinal(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord; Ljava/lang/String;)V
    goto/16 +308h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v2
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->setAiListening(Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$stopOutputVolumeMonitoring(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v8, v3
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    sget-object v12, Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const v33, 4063207
    const/16 v34, 0
    move-object/from16 v28, v1
    invoke-static/range v8 ... v34, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v6
    invoke-interface v2, v3, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -03bh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setInterrupted(Z)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotFirstCharMs()Ljava/lang/Long;
    move-result-object v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->DURING_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    goto +ch
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v2
    if-nez v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_ANSWERING Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;->BEFORE_FIRST_CHAR Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setInterruptPhase(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setAwaitingBotFirstChar$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v3, "interrupted_stage"
    invoke-static v2, v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$tryReportRoundIfFinal(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord; Ljava/lang/String;)V
    goto/16 +27fh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v2
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->setAiListening(Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const v33, 4063215
    const/16 v34, 0
    move-object/from16 v28, v1
    invoke-static/range v8 ... v34, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v3, v2, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -03ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v2, "answering"
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$restartOutputVolumeMonitoring(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v1
    if-eqz v1, +020h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotAnsweringMs()Ljava/lang/Long;
    move-result-object v3
    if-nez v3, +018h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setBotAnsweringMs(Ljava/lang/Long;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getSessionBotSpeakStartTimestamps$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/util/List;
    move-result-object v1
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$reportDiscussionStartPerfIfNeeded(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    goto/16 +200h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->THINKING_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v3, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v3
    invoke-virtual v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->setAiListening(Z)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$stopOutputVolumeMonitoring(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    move-object v8, v5
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const v33, 4063215
    const/16 v34, 0
    move-object/from16 v28, v1
    invoke-static/range v8 ... v34, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v6
    invoke-interface v3, v5, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -03ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v3, "new_thinking"
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$closeLastRoundAsInterruptedIfNeeded(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    move-wide v9, v5
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getSessionUserSpeakEndTimestamps$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/util/List;
    move-result-object v1
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getSessionRoundDelays$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/util/List;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-object v5, v3
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getRoundIndexSeq$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)I
    move-result v7
    move v6, v7
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    add-int/lit8 v7, v7, 1
    invoke-static v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setRoundIndexSeq$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getRoundID()J
    move-result-wide v7
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getPendingUserSpeakStartMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/Long;
    move-result-object v18
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getPendingUserSubtitleFirstCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/Long;
    move-result-object v19
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getPendingUserSubtitleLastCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/Long;
    move-result-object v20
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const v30, 4187128
    const/16 v31, 0
    invoke-direct/range v5 ... v31, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;-><init>(I J J Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I I I Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Z Z Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase; Z Z Z Z I Ljava/util/Set; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setAwaitingBotFirstChar$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z)V
    goto/16 +136h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v2
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->setAiListening(Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$stopOutputVolumeMonitoring(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const v33, 4063215
    const/16 v34, 0
    move-object/from16 v28, v1
    invoke-static/range v8 ... v34, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v3, v2, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -03ah
    goto/16 +0e4h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v1
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->setAiListening(Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$stopOutputVolumeMonitoring(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getReason()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v6
    if-nez v1, +003h
    goto +2h
    move-object v7, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "conversation_error_"
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v9
    if-eqz v9, +00bh
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getErrorCode()I
    move-result v9
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    goto +2h
    move-object v9, v6
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v9
    if-eqz v9, +006h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getErrorCode()I
    move-result v5
    invoke-virtual v1, v3, v8, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v8, v3
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    sget-object v12, Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v9, "error: "
    invoke-direct v5, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v28
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const v33, 4063207
    const/16 v34, 0
    invoke-static/range v8 ... v34, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v5
    invoke-interface v1, v3, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -048h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "AI error stage: code="
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v2
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getErrorCode()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", reasonLength="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", reasonHash="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v7, Ljava/lang/String;->hashCode()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onError(java.lang.Throwable)void
    .registers 33
    # ins_size=2
    move-object/from16 v0, v31
    move-object/from16 v1, v32
    const-string v2, "error"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, voiceChat.onError: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v32, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "BrainstormViewModel"
    invoke-virtual v2, v4, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$stopSessionTimer(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v8, 0
    const-string v11, ""
    const-string v12, ""
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 4194059
    const/16 v30, 0
    invoke-static/range v4 ... v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -03ah
    invoke-virtual/range v32, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    instance-of v3, v1, Ljava/lang/IllegalStateException;
    const/4 v4, 0
    const/4 v5, 2
    const/4 v6, 0
    if-eqz v3, +007h
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    goto +1ch
    instance-of v7, v1, Ljava/lang/IllegalArgumentException;
    if-eqz v7, +007h
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    goto +13h
    const-string/jumbo v7, startVoiceChat
    invoke-static v2, v7, v6, v5, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +007h
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    goto +5h
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$RtcError;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$RtcError;
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    if-eqz v3, +007h
    const-string/jumbo v1, voice_session_conflict
    move-object v10, v1
    goto +33h
    instance-of v1, v1, Ljava/lang/IllegalArgumentException;
    if-eqz v1, +006h
    const-string/jumbo v1, voice_chat_invalid_argument
    goto -9h
    const-string/jumbo v1, startVoiceChat failed
    invoke-static v2, v1, v6, v5, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +006h
    const-string/jumbo v1, start_voice_chat_request_failed
    goto -16h
    const-string/jumbo v1, startVoiceChat returns invalid data
    invoke-static v2, v1, v6, v5, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +006h
    const-string/jumbo v1, start_voice_chat_invalid_data
    goto -23h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +006h
    const-string/jumbo v1, voice_discussion_start_failed
    goto -2fh
    const-string/jumbo v1, rtc_runtime_error
    goto -33h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->RTC_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    move-object v9, v1
    const/4 v11, 0
    const/4 v12, 4
    const/4 v13, 0
    invoke-static/range v8 ... v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptSignal$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_voicePromptEvents$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v1
    invoke-interface v1, v7, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    return-void 
.end method

.method public onFinalText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 13
    # ins_size=3
    const-string/jumbo v0, text
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 0
    if-eqz v1, +08ah
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->ordinal()I
    move-result v6
    aget v1, v1, v6
    if-eq v1, v2, +025h
    if-ne v1, v4, +01dh
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getSessionBotMessageCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)I
    move-result v1
    iget-object v6, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    add-int/2addr v1, v2
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setSessionBotMessageCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; I)V
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getSessionBotCharCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)I
    move-result v6
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v7
    add-int/2addr v6, v7
    invoke-static v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setSessionBotCharCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; I)V
    goto +21h
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getSessionUserMessageCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)I
    move-result v1
    iget-object v6, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    add-int/2addr v1, v2
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setSessionUserMessageCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; I)V
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getSessionUserCharCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)I
    move-result v6
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v7
    add-int/2addr v6, v7
    invoke-static v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setSessionUserCharCount$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; I)V
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v1
    if-eqz v1, +03bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v6
    xor-int/2addr v6, v2
    if-eqz v6, +003h
    goto +2h
    move-object v1, v5
    if-eqz v1, +030h
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->ordinal()I
    move-result v7
    aget v6, v6, v7
    if-eq v6, v2, +01ah
    if-ne v6, v4, +012h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getBotCharCount()I
    move-result v6
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v7
    add-int/2addr v6, v7
    invoke-virtual v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setBotCharCount(I)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setBotCurrentParagraphChars(I)V
    goto +13h
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserCharCount()I
    move-result v6
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v7
    add-int/2addr v6, v7
    invoke-virtual v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setUserCharCount(I)V
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    if-ne v12, v1, +05dh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v2
    if-eqz v0, +009h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->USER_FINAL_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v0
    if-eqz v0, +033h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +003h
    goto +2h
    move-object v0, v5
    if-eqz v0, +028h
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setUserFinalReceived(Z)V
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getPendingUserSubtitleLastCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/Long;
    move-result-object v1
    if-eqz v1, +01dh
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v6
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleLastCharMs()Ljava/lang/Long;
    move-result-object v1
    if-eqz v1, +00ah
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v8
    cmp-long v1, v6, v8
    if-lez v1, +009h
    invoke-static v6, v7, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setUserSubtitleLastCharMs(Ljava/lang/Long;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPendingUserSpeakStartMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/Long;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPendingUserSubtitleFirstCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/Long;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPendingUserSubtitleLastCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/Long;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setUserVadActive$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->ordinal()I
    move-result v12
    aget v12, v0, v12
    if-eq v12, v2, +010h
    if-ne v12, v4, +008h
    iget-object v12, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v12, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$handleBotFinalText(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    goto +ch
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    iget-object v12, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v12, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$handleUserFinalText(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    return-void 
.end method

.method public onLocalAudioVolume(float)void
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_localAudioVolume$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    invoke-static v6, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    const v0, 1028443341
    cmpl-float v0, v6, v0
    const/4 v1, 0
    if-ltz v0, +07ah
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceDiscussionAttemptTracker$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    move-result-object v0
    if-eqz v0, +024h
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getTerminalReported()Z
    move-result v4
    if-nez v4, +018h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->FIRST_VOICE_DETECTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +008h
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$refreshVoiceAttemptContext(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->onLocalAudioVolume(F)Z
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getUserVadActive$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Z
    move-result v6
    if-nez v6, +04dh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const/4 v0, 1
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setUserVadActive$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getPendingUserSpeakStartMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/Long;
    move-result-object v6
    if-nez v6, +00bh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-static v6, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPendingUserSpeakStartMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/Long;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v6
    if-eqz v6, +02ah
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v2
    if-nez v2, +00fh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserFinalReceived()Z
    move-result v2
    if-nez v2, +009h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSpeakStartMs()Ljava/lang/Long;
    move-result-object v2
    if-nez v2, +003h
    move v1, v0
    if-eqz v1, +003h
    goto +2h
    const/4 v6, 0
    if-eqz v6, +011h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getPendingUserSpeakStartMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/Long;
    move-result-object v0
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setUserSpeakStartMs(Ljava/lang/Long;)V
    goto +6h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setUserVadActive$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z)V
    return-void 
.end method

.method public onPerfTimestamp(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$PerfEvent  long)void
    .registers 5
    # ins_size=4
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +023h
    const/4 v0, 2
    if-eq v2, v0, +01ah
    const/4 v0, 3
    if-eq v2, v0, +011h
    const/4 v0, 4
    if-ne v2, v0, +008h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPerfBotJoinedMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; J)V
    goto +18h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPerfJoinRoomSuccessMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; J)V
    goto +ch
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPerfJoinRoomStartMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; J)V
    goto +6h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPerfApiRequestStartMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; J)V
    return-void 
.end method

.method public onRecognizedText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 37
    # ins_size=3
    move-object/from16 v0, v34
    move-object/from16 v8, v35
    const-string/jumbo v1, text
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, role
    move-object/from16 v2, v36
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual/range v36, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->ordinal()I
    move-result v2
    aget v1, v1, v2
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 1
    if-eq v1, v4, +094h
    const/4 v5, 2
    if-ne v1, v5, +08bh
    invoke-static/range v35, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->parseAttachedSubTaskId(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getCleanedText()Ljava/lang/String;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v4
    if-eqz v5, +038h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v5
    if-eqz v5, +030h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v6
    xor-int/2addr v4, v6
    if-eqz v4, +003h
    move-object v2, v5
    if-eqz v2, +026h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getAwaitingBotFirstChar$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Z
    move-result v7
    if-eqz v7, +00ch
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    invoke-virtual v2, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setBotFirstCharMs(Ljava/lang/Long;)V
    invoke-static v4, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setAwaitingBotFirstChar$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z)V
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setBotLatestCharMs(Ljava/lang/Long;)V
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setBotCurrentParagraphChars(I)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v5, v3
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 0
    const/4 v12, 0
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
    const v30, 4194159
    const/16 v31, 0
    move-object v13, v1
    invoke-static/range v5 ... v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -037h
    goto/16 +0b1h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v4
    if-eqz v1, +057h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v1
    invoke-virtual v1, v5, v6, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->markUserSubtitle(J)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getPendingUserSubtitleFirstCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/Long;
    move-result-object v1
    if-nez v1, +00bh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    invoke-static v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPendingUserSubtitleFirstCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/Long;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    invoke-static v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$setPendingUserSubtitleLastCharMs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/Long;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$currentRound(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;
    move-result-object v1
    if-eqz v1, +028h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getReported()Z
    move-result v7
    if-nez v7, +009h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserFinalReceived()Z
    move-result v7
    if-nez v7, +003h
    move v3, v4
    if-eqz v3, +003h
    move-object v2, v1
    if-eqz v2, +016h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->getUserSubtitleFirstCharMs()Ljava/lang/Long;
    move-result-object v1
    if-nez v1, +009h
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setUserSubtitleFirstCharMs(Ljava/lang/Long;)V
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;->setUserSubtitleLastCharMs(Ljava/lang/Long;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v15
    invoke-interface v15, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v14
    move-object v1, v14
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v16, 0
    move-object/from16 v32, v14
    move-object/from16 v14, v16
    const-wide/16 v16, 0
    move-object/from16 v33, v15
    move-wide/from16 v15, v16
    const-wide/16 v17, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const v26, 4194207
    const/16 v27, 0
    move-object/from16 v8, v35
    invoke-static/range v1 ... v27, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v1
    move-object/from16 v3, v32
    move-object/from16 v2, v33
    invoke-interface v2, v3, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    move-object/from16 v8, v35
    move-object v15, v2
    goto -48h
.end method

.method public onRtcAudioInputDeviceStateChanged(java.lang.String  int  int)void
    .registers 5
    # ins_size=4
    const-string v0, "deviceId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->onRtcAudioInputDeviceStateChanged(I I Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    move-result-object v2
    if-eqz v2, +00bh
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_voicePromptEvents$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    invoke-interface v3, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    return-void 
.end method

.method public onRtcAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 4
    # ins_size=2
    const-string v0, "properties"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->onRtcAudioProperties(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    move-result-object v3
    if-eqz v3, +00bh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_voicePromptEvents$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    return-void 
.end method

.method public onRtcNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 5
    # ins_size=3
    const-string v0, "local"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remotes"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v4
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->onRtcNetworkQuality(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    iget-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_voicePromptEvents$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v1
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    goto -13h
    return-void 
.end method

.method public onRtcTextMessage(java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->peekSubTaskMessageType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    const-string v3, ""
    const/4 v4, 0
    if-eqz v0, +134h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v5
    sparse-switch v5, +00001feh
    goto/16 +12bh
    const-string/jumbo v5, task_update
    invoke-virtual v0, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +120h
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskUpdate(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-nez v0, +00ah
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v1, "invalid task_update"
    invoke-static v0, v8, v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceChatSession$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    if-nez v8, +003h
    goto +2h
    move-object v3, v8
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v4, v3
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v8, v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskUpdate(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    move-result v8
    if-eqz v8, +007h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundHasSubtask(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    return-void 
    const-string/jumbo v5, task_result
    invoke-virtual v0, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0d9h
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseToolResult(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    move-result-object v0
    if-nez v0, +00ah
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v1, "invalid task_result"
    invoke-static v0, v8, v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleToolResult(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v8
    if-eqz v8, +010h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v9
    invoke-static v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundServerTool(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$reportServerToolEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
    const-string/jumbo v5, task_start
    invoke-virtual v0, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0a9h
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStart(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;
    move-result-object v0
    if-nez v0, +00ah
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v1, "invalid task_start"
    invoke-static v0, v8, v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v9
    invoke-static v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundServerTool(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->recordServerToolStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    return-void 
    const-string/jumbo v5, task_stop
    invoke-virtual v0, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +07ch
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStop(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    move-result-object v0
    if-nez v0, +00ah
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v1, "invalid task_stop"
    invoke-static v0, v8, v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceChatSession$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    if-nez v8, +003h
    goto +2h
    move-object v3, v8
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v4, v3
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v8, v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStop(Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage; Ljava/lang/String;)V
    return-void 
    const-string/jumbo v5, sub_task_request
    invoke-virtual v0, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +3dh
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskRequest(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-nez v0, +00ah
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string v1, "invalid sub_task_request"
    invoke-static v0, v8, v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceChatSession$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    if-nez v8, +003h
    goto +2h
    move-object v3, v8
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v4, v3
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v8, v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskRequest(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    move-result v8
    if-eqz v8, +007h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundHasSubtask(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    return-void 
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskRequest(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-eqz v0, +02eh
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceChatSession$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v4
    if-nez v9, +003h
    goto +2h
    move-object v3, v9
    move-object v9, v3
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-lez v9, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v4, v3
    sget-object v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v9, v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskRequest(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    move-result v9
    if-eqz v9, +005h
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundHasSubtask(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    return-void 
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskUpdate(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-eqz v0, +02eh
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceChatSession$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v4
    if-nez v9, +003h
    goto +2h
    move-object v3, v9
    move-object v9, v3
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-lez v9, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v4, v3
    sget-object v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v9, v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskUpdate(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    move-result v9
    if-eqz v9, +005h
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundHasSubtask(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    return-void 
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStart(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;
    move-result-object v0
    if-eqz v0, +016h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v9
    invoke-static v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundServerTool(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->recordServerToolStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    return-void 
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStop(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    move-result-object v0
    if-eqz v0, +028h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceChatSession$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    if-nez v8, +003h
    goto +2h
    move-object v3, v8
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v4, v3
    sget-object v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v8, v0, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStop(Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage; Ljava/lang/String;)V
    return-void 
    invoke-static v9, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseToolResult(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    move-result-object v0
    if-eqz v0, +017h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleToolResult(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v9
    if-eqz v9, +00ch
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v9
    invoke-static v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$markCurrentRoundServerTool(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    invoke-static v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$reportServerToolEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v2, v8
    move-object v3, v9
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->logUnrecognizedRtcFrame$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    sparse-switch-payload -360db28c ac8367c 4e3e6528 770e4017 7cc0b0c3
.end method

.method public onStatus(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Status)void
    .registers 33
    # ins_size=2
    move-object/from16 v0, v31
    move-object/from16 v1, v32
    const-string/jumbo v2, status
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->ordinal()I
    move-result v3
    aget v2, v2, v3
    const/4 v3, 1
    if-eq v2, v3, +0a1h
    const/4 v3, 2
    if-eq v2, v3, +09eh
    const/4 v3, 3
    if-eq v2, v3, +052h
    const/4 v3, 4
    if-ne v2, v3, +049h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 3932159
    const/16 v30, 0
    invoke-static/range v4 ... v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -035h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getVoiceHealthMonitor$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->resetRuntime()V
    goto +50h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 1
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 3932159
    const/16 v30, 0
    invoke-static/range v4 ... v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -035h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RTC_JOINED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->recordVoiceAttemptStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$startSessionTimer(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, voiceChat.onStatus: status=
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, ", isRtcJoined="
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "BrainstormViewModel"
    invoke-virtual v3, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onSubtitleText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, text
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->BOT Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    if-ne v7, v0, +009h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_botSubtitleBuffer$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/StringBuilder;
    move-result-object v0
    goto +7h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_userSubtitleBuffer$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/StringBuilder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->BOT Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    if-ne v7, v1, +009h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_botWordAggregateBuffer$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/StringBuilder;
    move-result-object v7
    goto +7h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_userWordAggregateBuffer$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v1
    const/4 v2, 0
    if-ge v2, v1, +037h
    invoke-virtual v6, v2, Ljava/lang/String;->charAt(I)C
    move-result v3
    iget-object v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v4, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$isCjkChar(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; C)Z
    move-result v4
    if-eqz v4, +00fh
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-object v3, v7
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    invoke-static v7, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    goto +1ah
    const/16 v4, 32
    if-eq v3, v4, +00bh
    const/16 v4, 10
    if-ne v3, v4, +003h
    goto +5h
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +dh
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-object v3, v7
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    invoke-static v7, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    add-int/lit8 v2, v2, 1
    goto -36h
    return-void 
.end method

.method public onVoiceChatDataReady(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 3
    # ins_size=2
    const-string v0, "data"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getSubTaskConfig()Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->updateSubTaskConfig(Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;)V
    return-void 
.end method
