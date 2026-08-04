# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VoiceSubTaskCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
.field final synthetic $previousCreateJob:Lkotlinx/coroutines/Job;
.field final synthetic $previousTaskId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  kotlinx.coroutines.Job  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousCreateJob Lkotlinx/coroutines/Job;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousTaskId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousCreateJob Lkotlinx/coroutines/Job;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousTaskId Ljava/lang/String;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lkotlinx/coroutines/Job; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    const-string/jumbo v0, switching[pending-not-active]: pending=
    const-string/jumbo v1, switching[start-latest]: taskId=
    const-string/jumbo v2, switching[failed]: prevId=
    const-string/jumbo v3, switching[stale-cancel]: prevId=
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->label I
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v5, +017h
    if-ne v5, v6, +00dh
    iget-object v4, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    move-exception v12
    goto/16 +226h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lkotlinx/coroutines/CoroutineScope;
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$current Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iget-object v9, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousCreateJob Lkotlinx/coroutines/Job;
    move-object v10, v11
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->L$0 Ljava/lang/Object;
    iput v6, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->label I
    invoke-static v5, v8, v9, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$cancelPreviousTaskForSwitch(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lkotlinx/coroutines/Job; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v4, +003h
    return-object v4
    move-object v4, v12
    move-object v12, v5
    check-cast v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getStarted$p()Z
    move-result v5
    if-nez v5, +01ch
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyStartJob$p()Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-interface v4, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v1, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v1
    if-ne v0, v1, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyStartJob$p(Lkotlinx/coroutines/Job;)V
    return-object v12
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getCancelingClientProxyTaskId$p()Ljava/lang/String;
    move-result-object v5
    iget-object v8, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousTaskId Ljava/lang/String;
    invoke-static v5, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const-string v8, "VoiceSubTaskCoord"
    if-nez v5, +03eh
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousTaskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", currentCanceling="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getCancelingClientProxyTaskId$p()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyStartJob$p()Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-interface v4, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v1, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v1
    if-ne v0, v1, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyStartJob$p(Lkotlinx/coroutines/Job;)V
    return-object v12
    instance-of v3, v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$Failed;
    if-eqz v3, +080h
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyRequest$p()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyExecutor$p()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1;->$previousTaskId Ljava/lang/String;
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", pending="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v7
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", pendingExecutor="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", reason="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    check-cast v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$Failed;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$Failed;->getReason()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v3, v8, v12, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyRequest$p(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyExecutor$p(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setCancelingClientProxyTaskId$p(Ljava/lang/String;)V
    if-eqz v0, +00dh
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    const-string v1, "local_sub_task_cancel_previous_failed"
    invoke-static v12, v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$failPendingClientProxyTask(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyStartJob$p()Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-interface v4, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v1, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v1
    if-ne v0, v1, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyStartJob$p(Lkotlinx/coroutines/Job;)V
    return-object v12
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setCancelingClientProxyTaskId$p(Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyRequest$p()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v2
    if-nez v2, +01ch
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyStartJob$p()Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-interface v4, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v1, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v1
    if-ne v0, v1, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyStartJob$p(Lkotlinx/coroutines/Job;)V
    return-object v12
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyExecutor$p()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    if-nez v3, +00ch
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->Companion Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getExecutor()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;->fromProtocol(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyRequest$p(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyExecutor$p(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;)V
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$get_activeTask$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v7
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v10
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +04ah
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", active="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v7
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", skip start"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyStartJob$p()Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-interface v4, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v1, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v1
    if-ne v0, v1, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyStartJob$p(Lkotlinx/coroutines/Job;)V
    return-object v12
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, ", executor="
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, ", outcome="
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v8, v12, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$queueSubTaskSupersede$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ordinal()I
    move-result v0
    aget v12, v12, v0
    if-eq v12, v6, +011h
    const/4 v0, 2
    if-ne v12, v0, +008h
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v12, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$startServerClosedLoopTask(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    goto +15h
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v0
    invoke-static v12, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$markCreateTaskRetryableBizErrorSuppressed(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v12, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$startClientProxyTask(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;)V
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyStartJob$p()Lkotlinx/coroutines/Job;
    move-result-object v12
    invoke-interface v4, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v1, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v1, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v1, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    if-ne v12, v0, +007h
    sget-object v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyStartJob$p(Lkotlinx/coroutines/Job;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    move-exception v0
    move-object v4, v12
    move-object v12, v0
    invoke-static Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$getPendingClientProxyStartJob$p()Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-interface v4, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    sget-object v2, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v2, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v1, v2, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v1
    if-ne v0, v1, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-static v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$setPendingClientProxyStartJob$p(Lkotlinx/coroutines/Job;)V
    throw v12
    :try_start_0x1c
    :try_start_0x32
    :try_start_0x48
    :try_start_0x6a
    :try_start_0x78
    :try_start_0xb4
    :try_start_0x136
    :try_start_0x15b
    :try_start_0x1d9
.end method
