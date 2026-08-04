# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormSessionHolder.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $sessionStartTimeMs:J
.field  label:I


.method constructor <init>(long  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->$sessionStartTimeMs J
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->$sessionStartTimeMs J
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;-><init>(J Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 58
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v1, v56
    iget v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->label I
    const/4 v3, 1
    if-eqz v2, +011h
    if-ne v2, v3, +007h
    invoke-static/range v57, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v1
    goto +1bh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v57, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v1
    move-object v4, v2
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->label I
    const-wide/16 v5, 300
    invoke-static v5, v6, v4, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    iget-wide v6, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startTimer$1;->$sessionStartTimeMs J
    sub-long v24, v4, v6
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$get_elapsedMs$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-static/range v24 ... v25, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v5
    invoke-interface v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$getCurrentSnapshot$p()Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v4
    if-eqz v4, +05eh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v8
    const/4 v9, 0
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
    const/16 v20, 0
    const/16 v21, 0
    const-wide/16 v22, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const v33, 4177919
    const/16 v34, 0
    invoke-static/range v8 ... v34, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v27
    const/16 v29, 0
    const/16 v33, 0
    const-wide/16 v34, 0
    const-wide/16 v36, 0
    const-wide/16 v38, 0
    const-wide/16 v40, 0
    const-wide/16 v42, 0
    const-wide/16 v44, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    const v54, 2097150
    const/16 v55, 0
    move-object/from16 v26, v4
    invoke-static/range v26 ... v55, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$setCurrentSnapshot$p(Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;)V
    goto/16 -089h
.end method
