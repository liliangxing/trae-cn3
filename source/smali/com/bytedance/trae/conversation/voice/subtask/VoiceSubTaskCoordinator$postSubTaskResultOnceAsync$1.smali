# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VoiceSubTaskCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $durationMs:J
.field final synthetic $errorCode:Ljava/lang/String;
.field final synthetic $reportTaskId:Ljava/lang/String;
.field final synthetic $result:Ljava/lang/String;
.field final synthetic $safeError:Ljava/lang/String;
.field final synthetic $scene:Ljava/lang/String;
.field final synthetic $status:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 10
    # ins_size=10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$reportTaskId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$result Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$status Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$errorCode Ljava/lang/String;
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$durationMs J
    iput-object v7, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$safeError Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$scene Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v9, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 13
    # ins_size=3
    new-instance v11, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$reportTaskId Ljava/lang/String;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$result Ljava/lang/String;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$status Ljava/lang/String;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$errorCode Ljava/lang/String;
    iget-wide v5, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$durationMs J
    iget-object v7, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$safeError Ljava/lang/String;
    iget-object v8, v10, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$scene Ljava/lang/String;
    move-object v0, v11
    move-object v9, v12
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/coroutines/Continuation;
    return-object v11
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->label I
    const/4 v2, 1
    const-string v3, "postSubTaskResult["
    const-string v4, "VoiceSubTaskCoord"
    if-eqz v1, +011h
    if-ne v1, v2, +007h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09dh
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v14, Lcom/bytedance/trae/im/service/SubTaskResultRequest;
    iget-object v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$reportTaskId Ljava/lang/String;
    iget-object v7, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$result Ljava/lang/String;
    iget-object v8, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$status Ljava/lang/String;
    iget-object v9, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$errorCode Ljava/lang/String;
    iget-wide v10, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$durationMs J
    iget-object v12, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$safeError Ljava/lang/String;
    move-object v5, v14
    invoke-direct/range v5 ... v12, Lcom/bytedance/trae/im/service/SubTaskResultRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$scene Ljava/lang/String;
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "]: posting taskId="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$reportTaskId Ljava/lang/String;
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, " status="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$status Ljava/lang/String;
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, " durationMs="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-wide v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$durationMs J
    invoke-virtual v5, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, " errorCode="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$errorCode Ljava/lang/String;
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, " resultLen="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$result Ljava/lang/String;
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, " errorLen="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v6, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$safeError Ljava/lang/String;
    if-eqz v6, +007h
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v6
    goto +2h
    const/4 v6, 0
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/service/ISubTaskResultApi;->Companion Lcom/bytedance/trae/im/service/ISubTaskResultApi$Companion;
    new-instance v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1$httpResult$1;
    const/4 v6, 0
    invoke-direct v5, v14, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1$httpResult$1;-><init>(Lcom/bytedance/trae/im/service/SubTaskResultRequest; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v14, v13
    check-cast v14, Lkotlin/coroutines/Continuation;
    iput v2, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->label I
    invoke-virtual v1, v5, v14, Lcom/bytedance/trae/im/service/ISubTaskResultApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +037h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$scene Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "]: ok taskId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$reportTaskId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " bizCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v2
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v4, v14, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +4ah
    instance-of v0, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +04ah
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$reportTaskId Ljava/lang/String;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$clearSubTaskResultReportStarted(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$scene Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "]: failed taskId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v13, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1;->$reportTaskId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " code="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " msg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v4, v14, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    new-instance v14, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v14, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v14
.end method
