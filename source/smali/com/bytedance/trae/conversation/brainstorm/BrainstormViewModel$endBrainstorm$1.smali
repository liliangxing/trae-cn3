# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $endState:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
.field final synthetic $hasSummaryWorthyInput:Z
.field final synthetic $isAbort:Z
.field final synthetic $parentConversationId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  boolean  boolean  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$endState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$hasSummaryWorthyInput Z
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$isAbort Z
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$parentConversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$endState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-boolean v3, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$hasSummaryWorthyInput Z
    iget-boolean v4, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$isAbort Z
    iget-object v5, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$parentConversationId Ljava/lang/String;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z Z Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 35
    # ins_size=2
    move-object/from16 v0, v33
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->label I
    const/4 v3, 1
    if-eqz v2, +011h
    if-ne v2, v3, +007h
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09bh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v34, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$endState Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionStartTimeMs()J
    move-result-wide v6
    sub-long/2addr v4, v6
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;
    invoke-static v2, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;->access$formatDuration(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion; J)Ljava/lang/String;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;->Idle Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const-wide/16 v20, 0
    const-wide/16 v22, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const v31, 4194299
    const/16 v32, 0
    invoke-static/range v6 ... v32, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v6
    invoke-interface v4, v5, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -038h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$get_brainstormEnded$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;
    iget-boolean v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$hasSummaryWorthyInput Z
    const/4 v7, 0
    if-eqz v6, +013h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getApplication()Landroid/app/Application;
    move-result-object v6
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_summary_query I
    new-array v9, v3, [Ljava/lang/Object;
    aput-object v2, v9, v7
    invoke-virtual v6, v8, v9, Landroid/app/Application;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    goto +3h
    const-string v2, ""
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-boolean v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$isAbort Z
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$parentConversationId Ljava/lang/String;
    if-nez v6, +007h
    iget-boolean v9, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->$hasSummaryWorthyInput Z
    if-nez v9, +003h
    move v7, v3
    invoke-direct v5, v2, v6, v8, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;-><init>(Ljava/lang/String; Z Ljava/lang/String; Z)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$endBrainstorm$1;->label I
    invoke-interface v4, v5, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
