# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $shouldPin:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(boolean  java.lang.String  com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;
    iget-boolean v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$conversationId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    packed-switch v1, +0000168h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +150h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3bh
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    if-eqz v6, +01bh
    sget-object v6, Lcom/bytedance/trae/im/service/IPinConversationService;->Companion Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    new-instance v1, Lcom/bytedance/trae/im/service/PinConversationRequest;
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$conversationId Ljava/lang/String;
    invoke-direct v1, v2, Lcom/bytedance/trae/im/service/PinConversationRequest;-><init>(Ljava/lang/String;)V
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 1
    iput v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->pinRawCall(Lcom/bytedance/trae/im/service/PinConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +19h
    sget-object v6, Lcom/bytedance/trae/im/service/IPinConversationService;->Companion Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    new-instance v1, Lcom/bytedance/trae/im/service/PinConversationRequest;
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$conversationId Ljava/lang/String;
    invoke-direct v1, v2, Lcom/bytedance/trae/im/service/PinConversationRequest;-><init>(Ljava/lang/String;)V
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 2
    iput v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->unpinRawCall(Lcom/bytedance/trae/im/service/PinConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +0a3h
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-eqz v1, +030h
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$conversationId Ljava/lang/String;
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/PinConversationResponse;
    invoke-static v1, v2, v3, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$applyPinSuccess(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/lang/String; Z Lcom/bytedance/trae/im/service/PinConversationResponse;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-boolean v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$pinSuccessString(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)I
    move-result v1
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 3
    iput v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    invoke-interface v6, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +0d3h
    return-object v0
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v1
    const-wide/32 v3, 2900104
    cmp-long v1, v1, v3
    if-nez v1, +01bh
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_pin_version_incompatible I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 4
    iput v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    invoke-interface v6, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +0afh
    return-object v0
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v1
    const-wide/32 v3, 2900101
    cmp-long v6, v1, v3
    if-nez v6, +01bh
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 5
    iput v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    invoke-interface v6, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +08bh
    return-object v0
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-boolean v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$pinFailureString(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)I
    move-result v1
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 6
    iput v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    invoke-interface v6, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +06ch
    return-object v0
    instance-of v1, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +06ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "performPinAction error: conversationId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$conversationId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", shouldPin="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", code="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", msg="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v6
    const-string v3, "TaskViewModel"
    invoke-virtual v1, v3, v2, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$get_toastMessage$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-boolean v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->$shouldPin Z
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$pinFailureString(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Z)I
    move-result v1
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v2, v5
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 7
    iput v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;->label I
    invoke-interface v6, v1, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    nop 
    packed-switch-payload 0 1 2 3 4 5 6 7
.end method
