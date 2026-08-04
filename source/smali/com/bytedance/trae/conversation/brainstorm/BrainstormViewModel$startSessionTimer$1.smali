# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  J$0:J
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 41
    # ins_size=2
    move-object/from16 v0, v39
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->label I
    const/4 v3, 1
    if-eqz v2, +013h
    if-ne v2, v3, +009h
    iget-wide v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->J$0 J
    invoke-static/range v40, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v0
    goto +1fh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v40, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const-wide/16 v4, -1
    move-object v2, v0
    move-object v6, v2
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-wide v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->J$0 J
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->label I
    const-wide/16 v7, 300
    invoke-static v7, v8, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    iget-object v8, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionStartTimeMs()J
    move-result-wide v8
    sub-long/2addr v6, v8
    const-wide/16 v8, 0
    invoke-static v6, v7, v8, v9, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v6
    const/16 v8, 1000
    int-to-long v8, v8
    div-long v37, v6, v8
    cmp-long v10, v37, v4
    if-eqz v10, +18fh
    iget-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getTimeoutState()Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Expired Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-ne v4, v5, +047h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const v35, 4177919
    const/16 v36, 0
    move-wide/from16 v26, v6
    invoke-static/range v10 ... v36, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v2
    invoke-interface v5, v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -03bh
    goto/16 +0a8h
    const-wide/32 v10, 1800000
    cmp-long v5, v6, v10
    if-ltz v5, +04bh
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Normal Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-ne v4, v5, +047h
    iget-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v10, v4
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    sget-object v28, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Warning Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    const/16 v29, 60
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const v35, 4079615
    const/16 v36, 0
    move-wide/from16 v26, v6
    invoke-static/range v10 ... v36, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v8
    invoke-interface v5, v4, v8, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -03bh
    goto/16 +0e2h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Warning Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-ne v4, v5, +09bh
    sub-long v4, v6, v10
    div-long/2addr v4, v8
    long-to-int v4, v4
    rsub-int/lit8 v4, v4, 60
    if-gtz v4, +04fh
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    sget-object v28, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Expired Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const v35, 4079615
    const/16 v36, 0
    move-wide/from16 v26, v6
    invoke-static/range v10 ... v36, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    invoke-interface v5, v1, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -03bh
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const/4 v2, 0
    const/4 v4, 0
    invoke-static v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->endBrainstorm$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z I Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v5, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    move-object v10, v8
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    const/16 v28, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const v35, 4112383
    const/16 v36, 0
    move-wide/from16 v26, v6
    move/from16 v29, v4
    invoke-static/range v10 ... v36, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v9
    invoke-interface v5, v8, v9, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -03bh
    goto +44h
    iget-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v10, v4
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const v35, 4177919
    const/16 v36, 0
    move-wide/from16 v26, v6
    invoke-static/range v10 ... v36, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v5
    invoke-interface v8, v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -03bh
    move-wide/from16 v4, v37
    goto/16 -1bfh
    iget-object v8, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startSessionTimer$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const v35, 4177919
    const/16 v36, 0
    move-wide/from16 v26, v6
    invoke-static/range v10 ... v36, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v10
    invoke-interface v8, v9, v10, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, -03bh
    goto/16 -204h
.end method
