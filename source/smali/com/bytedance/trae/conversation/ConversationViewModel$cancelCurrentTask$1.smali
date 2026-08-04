# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $convId:Ljava/lang/String;
.field final synthetic $taskId:Ljava/lang/String;
.field  J$0:J
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.ConversationViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$convId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$convId Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 73
    # ins_size=2
    move-object/from16 v0, v71
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    const-string v3, "getString(...)"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 1
    packed-switch v2, +000040bh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static/range v72, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +3bah
    invoke-static/range v72, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +175h
    invoke-static/range v72, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +3e6h
    invoke-static/range v72, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +12bh
    iget-wide v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->J$0 J
    invoke-static/range v72, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v72
    goto +21h
    invoke-static/range v72, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    sget-object v2, Lcom/bytedance/trae/im/service/ICancelTaskApi;->Companion Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    new-instance v9, Lcom/bytedance/trae/im/service/CancelTaskRequest;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$convId Ljava/lang/String;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/im/service/CancelTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v10, v0
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->J$0 J
    iput v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-virtual v2, v9, v10, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->cancelTaskRawCall(Lcom/bytedance/trae/im/service/CancelTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/im/service/CancelTaskRawResult;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    sub-long v17, v9, v7
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CancelTaskRawResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CancelTaskRawResult;->getBizCode()Ljava/lang/Long;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CancelTaskRawResult;->getBizMsg()Ljava/lang/String;
    instance-of v2, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +317h
    sget-object v2, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-virtual v2, v9, Lcom/bytedance/trae/im/service/IMService;->getStreamingMessage(Ljava/lang/String;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    if-eqz v2, +009h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v4
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    const-string v9, "placeholder_"
    const/4 v10, 2
    if-nez v2, +084h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    instance-of v12, v2, Ljava/util/Collection;
    if-eqz v12, +00bh
    move-object v12, v2
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v12
    if-nez v12, +039h
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +02fh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v13
    if-eqz v13, +020h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v9, v5, v10, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v13
    if-nez v13, +016h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v12
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v4
    invoke-static v12, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +004h
    move v12, v6
    goto +2h
    move v12, v5
    if-eqz v12, -031h
    sget-object v11, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->INSTANCE Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;
    const-string v12, "biz_error"
    const-string/jumbo v13, user_click
    iget-object v14, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    iget-object v15, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$convId Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning()Z
    move-result v20
    move-object/from16 v2, v16
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v5
    goto +2h
    move v2, v6
    if-eqz v2, +005h
    const-string v2, "empty"
    goto +4h
    const-string/jumbo v2, streaming
    move-object/from16 v21, v2
    move-object/from16 v19, v8
    invoke-virtual/range v11 ... v21, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->report(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/Long; Z Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-nez v2, +0a0h
    if-nez v8, +003h
    goto +eh
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v11
    const-wide/32 v13, 991201
    cmp-long v2, v11, v13
    if-nez v2, +004h
    goto/16 +090h
    if-nez v8, +003h
    goto +4ch
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v6
    const-wide/32 v8, 2900101
    cmp-long v2, v6, v8
    if-nez v2, +042h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-static v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$set_currentTaskId$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_cancelTaskResult$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v4
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    const/4 v6, 3
    iput v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v4, v5, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-virtual v4, v5, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v0
    check-cast v3, Lkotlin/coroutines/Continuation;
    const/4 v5, 4
    iput v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v4, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +297h
    return-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-static v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$set_currentTaskId$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_cancelTaskResult$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v4
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    const/4 v6, 5
    iput v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v4, v5, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v4, v5, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v0
    check-cast v3, Lkotlin/coroutines/Continuation;
    const/4 v5, 6
    iput v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v4, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +257h
    return-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/service/IMService;->getStreamingMessage(Ljava/lang/String;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    const-string v3, "canceled"
    if-eqz v2, +01ah
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setStatus(Ljava/lang/String;)V
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setUserCanceled(Ljava/lang/Boolean;)V
    invoke-virtual v2, v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHistory(Z)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getStreamingMessageListener$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    move-result-object v3
    invoke-interface v3, v2, v6, Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;->onStreamingMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    goto/16 +187h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    instance-of v8, v2, Ljava/util/Collection;
    if-eqz v8, +00dh
    move-object v8, v2
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +004h
    move v2, v5
    goto +39h
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, -00ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v11
    if-eqz v11, +020h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v9, v5, v10, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +016h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +004h
    move v8, v6
    goto +2h
    move v8, v5
    if-eqz v8, -031h
    move v2, v6
    if-nez v2, +130h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +014h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -015h
    goto +2h
    move-object v7, v4
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v7, +029h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +01fh
    invoke-virtual v7, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setStatus(Ljava/lang/String;)V
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v7, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setUserCanceled(Ljava/lang/Boolean;)V
    invoke-virtual v7, v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setHistory(Z)V
    sget-object v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAM_DONE Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-virtual v7, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setSourcePhase(Lcom/bytedance/trae/im/model/MessageSourcePhase;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$upsertMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    goto/16 +0cdh
    if-nez v7, +0cbh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +014h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskIdUser()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -015h
    goto +2h
    move-object v7, v4
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v7, +09ch
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v20
    new-instance v14, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-object/from16 v50, v14
    iget-object v15, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    const/16 v16, 0
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v17
    const/16 v18, 2
    const/16 v19, 0
    invoke-direct/range v14 ... v19, Lcom/bytedance/trae/im/model/ParsedTaskContent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v34
    new-instance v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v11, v2
    const/4 v14, 0
    const/4 v15, 0
    const-string v16, "canceled"
    const/16 v17, 0
    const-string v18, "assistant"
    const/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v47
    const/16 v48, 0
    const/16 v49, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 1
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, 0
    const/16 v60, 0
    const/16 v61, 0
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, 0
    const/16 v66, 0
    const/16 v67, 0
    const v68, -4194644
    const v69, 8388315
    const/16 v70, 0
    invoke-direct/range v11 ... v70, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$upsertMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$set_currentTaskId$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_cancelTaskResult$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +08eh
    return-object v1
    instance-of v2, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +08ch
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    const-string v8, "not running"
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v2, v8, v6, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v2
    if-eqz v2, +01eh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_cancelTaskResult$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/4 v5, 7
    iput v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +05bh
    return-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->$taskId Ljava/lang/String;
    invoke-static v2, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$set_currentTaskId$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_cancelTaskResult$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    move-object v9, v0
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->L$0 Ljava/lang/Object;
    const/16 v10, 8
    iput v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    move v5, v6
    if-eqz v5, +027h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v5, v6, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v0
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->L$0 Ljava/lang/Object;
    const/16 v4, 9
    iput v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$cancelCurrentTask$1;->label I
    invoke-interface v2, v5, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    packed-switch-payload 0 1 2 3 4 5 6 7 8 9
    :try_start_0x91
.end method
