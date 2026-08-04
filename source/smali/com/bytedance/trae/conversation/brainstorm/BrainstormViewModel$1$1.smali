# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1$1;
.super Ljava/lang/Object;
.source "BrainstormViewModel.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  kotlin.coroutines.Continuation)java.lang.Object
    .registers 48
    # ins_size=3
    move-object/from16 v0, v45
    move-object/from16 v15, v46
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[SubTask] activeTask="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BrainstormViewModel"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v15, +05fh
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getTERMINAL_SUB_TASK_STATES$cp()Ljava/util/Set;
    move-result-object v1
    invoke-virtual/range v46, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +051h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const-wide/16 v30, 0
    const-wide/16 v32, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const v41, 3670015
    const/16 v42, 0
    invoke-static/range v16 ... v42, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v3
    invoke-interface v1, v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -041h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, v15, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$applySubTaskTerminal(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    goto +4ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v14
    invoke-interface v14, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v16, 0
    move-object/from16 v43, v13
    move/from16 v13, v16
    const/16 v16, 0
    move-object/from16 v44, v14
    move-object/from16 v14, v16
    const-wide/16 v16, 0
    move-wide/from16 v15, v16
    const-wide/16 v17, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v24, 0
    const/16 v25, 0
    const v26, 3670015
    const/16 v27, 0
    move-object/from16 v23, v46
    invoke-static/range v1 ... v27, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v1
    move-object/from16 v3, v43
    move-object/from16 v2, v44
    invoke-interface v2, v3, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-object/from16 v15, v46
    move-object v14, v2
    goto -4bh
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$1$1;->emit(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
