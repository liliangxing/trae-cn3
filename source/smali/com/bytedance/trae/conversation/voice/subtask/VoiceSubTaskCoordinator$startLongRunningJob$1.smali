# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VoiceSubTaskCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $sourceTaskId:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->$sourceTaskId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->$sourceTaskId Ljava/lang/String;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->label I
    const-wide/16 v3, 10000
    invoke-static v3, v4, v2, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getStarted$p()Z
    move-result v1
    if-nez v1, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$get_activeTask$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    iget-object v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->$sourceTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getIN_FLIGHT_STATES$p()Ljava/util/Set;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLongRunning()Z
    move-result v1
    if-eqz v1, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$get_activeTask$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const/4 v13, 1
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 3583
    const/16 v17, 0
    invoke-static/range v2 ... v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->copy$default(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, subTask longRunning: sourceTaskId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$startLongRunningJob$1;->$sourceTaskId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "VoiceSubTaskCoord"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
