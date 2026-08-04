# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $decision:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision  com.bytedance.trae.conversation.ConversationViewModel  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->label I
    const/4 v2, 3
    const-string v3, "Checkpoint"
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v1, +022h
    if-eq v1, v5, +01ch
    if-eq v1, v4, +015h
    if-ne v1, v2, +00bh
    iget-object v0, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1cfh
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1f6h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3fh
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Cancel;
    const/4 v6, 0
    if-eqz v1, +074h
    check-cast v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Cancel;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Cancel;->getConversationId()Ljava/lang/String;
    move-result-object v15
    move-object v1, v15
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +008h
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v6, v5
    if-eqz v6, +00ah
    const-string v15, "CancelTask ABORT: conversationId is null/empty"
    invoke-static v3, v15, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    sget-object v1, Lcom/bytedance/trae/im/service/ICancelTaskApi;->Companion Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;
    iget-object v6, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    const/4 v7, 0
    invoke-direct v2, v15, v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    move-object v15, v14
    check-cast v15, Lkotlin/coroutines/Continuation;
    iput v5, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->label I
    invoke-virtual v1, v2, v15, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-nez v1, +1aeh
    instance-of v1, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +030h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "CancelTask error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v3, v1, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v1
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v15
    move-object v2, v14
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v4, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->label I
    invoke-interface v1, v15, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +17dh
    return-object v0
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;
    if-nez v1, +011h
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;
    if-nez v1, +00dh
    instance-of v15, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    if-eqz v15, +003h
    goto +7h
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
    new-instance v7, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v7, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;
    const-string v8, "confirm"
    if-eqz v1, +00dh
    check-cast v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;->getParams()Ljava/lang/String;
    move-result-object v15
    iput-object v15, v7, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    move-object v15, v8
    goto/16 +0dch
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;
    if-eqz v1, +007h
    const-string/jumbo v15, skip
    goto/16 +0d3h
    instance-of v1, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    if-eqz v1, +141h
    check-cast v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->getAnswers()Ljava/util/List;
    move-result-object v15
    check-cast v15, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v9, 10
    invoke-static v15, v9, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v9
    invoke-direct v1, v9, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    const-string v10, "custom_input"
    if-eqz v9, +04fh
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;
    new-instance v11, Ljava/util/LinkedHashMap;
    invoke-direct v11, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v11, Ljava/util/Map;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;->getSelectedOptions()Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v12
    xor-int/2addr v12, v5
    if-eqz v12, +00ch
    const-string/jumbo v12, selected_options
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;->getSelectedOptions()Ljava/util/List;
    move-result-object v13
    invoke-interface v11, v12, v13, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;->getCustomInput()Ljava/lang/String;
    move-result-object v12
    check-cast v12, Ljava/lang/CharSequence;
    if-eqz v12, +00bh
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    if-eqz v12, +003h
    goto +3h
    move v12, v6
    goto +2h
    move v12, v5
    if-nez v12, +009h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;->getCustomInput()Ljava/lang/String;
    move-result-object v9
    invoke-interface v11, v10, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v11, Ljava/util/Map;->isEmpty()Z
    move-result v9
    if-eqz v9, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v11
    invoke-interface v1, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -54h
    check-cast v1, Ljava/util/List;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->getGson()Lcom/google/gson/Gson;
    move-result-object v15
    iget-object v9, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    check-cast v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->getQuestionsJson()Ljava/lang/String;
    move-result-object v9
    const-class v11, Lcom/google/gson/JsonElement;
    invoke-virtual v15, v9, v11, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/google/gson/JsonElement;
    new-array v4, v4, [Lkotlin/Pair;
    const-string v9, "questions"
    invoke-static v9, v15, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v15
    aput-object v15, v4, v6
    const-string v15, "answers"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v15
    aput-object v15, v4, v5
    invoke-static v4, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v15
    iget-object v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    check-cast v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->getSupplementaryInfo()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v6
    goto +2h
    move v1, v5
    if-nez v1, +00dh
    iget-object v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    check-cast v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->getSupplementaryInfo()Ljava/lang/String;
    move-result-object v1
    invoke-interface v15, v10, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getGson()Lcom/google/gson/Gson;
    move-result-object v1
    invoke-virtual v1, v15, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v15
    iput-object v15, v7, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    goto/16 -0dbh
    iget-object v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getConversationId()Ljava/lang/String;
    move-result-object v4
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v5, v6
    if-eqz v5, +00ah
    const-string v15, "ConfirmTask ABORT: conversationId is null/empty"
    invoke-static v3, v15, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    sget-object v1, Lcom/bytedance/trae/im/service/IConfirmTaskApi;->Companion Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;
    iget-object v5, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    const/4 v8, 0
    move-object v3, v9
    move-object v6, v15
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    move-object v3, v14
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v15, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->L$0 Ljava/lang/Object;
    iput v2, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->label I
    invoke-virtual v1, v9, v3, Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v15
    move-object v15, v1
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-nez v1, +030h
    instance-of v1, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +026h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "ConfirmTask error: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "ConversationViewModel"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v2, v14, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-static v1, v2, v0, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$reportCheckpointConfirmTaskError(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Ljava/lang/String; Lcom/bytedance/trae/network/response/HttpDataResult$Error;)V
    goto +7h
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
.end method
