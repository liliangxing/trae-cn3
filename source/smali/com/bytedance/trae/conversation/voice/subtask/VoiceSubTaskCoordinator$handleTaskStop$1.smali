# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VoiceSubTaskCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
.field final synthetic $durationMs:J
.field final synthetic $msg:Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  com.bytedance.trae.conversation.voice.subtask.TaskStopMessage  long  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$msg Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$durationMs J
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$msg Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    iget-wide v3, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$durationMs J
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage; J Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +54h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getProxyConversationId()Ljava/lang/String;
    move-result-object v4
    iget-object v14, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLocalTaskId()Ljava/lang/String;
    move-result-object v5
    move-object v14, v4
    check-cast v14, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v14, +00bh
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    goto +3h
    move v14, v1
    goto +2h
    move v14, v2
    if-nez v14, +02fh
    move-object v14, v5
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +008h
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    move v1, v2
    if-nez v1, +021h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    iget-object v14, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v7, task_stop
    const-wide/16 v8, 0
    move-object v10, v13
    check-cast v10, Lkotlin/coroutines/Continuation;
    const/16 v11, 16
    const/4 v12, 0
    iput v2, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->label I
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->cancelClientProxyTaskForReuse$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    goto +5h
    sget-object v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;
    check-cast v14, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleTaskStop[ack]: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$msg Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", outcome="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    const-string v1, "VoiceSubTaskCoord"
    invoke-virtual v0, v1, v14, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    iget-object v14, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$msg Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, success
    const-string v5, ""
    iget-wide v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$handleTaskStop$1;->$durationMs J
    const/4 v8, 0
    const/4 v9, 0
    const-string/jumbo v10, task-stop-client-proxy
    const/16 v11, 48
    const/4 v12, 0
    invoke-static/range v2 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->postSubTaskResultOnceAsync$default(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
