# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $remaining:J
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(long  com.bytedance.trae.conversation.ConversationViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->$remaining J
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;
    iget-wide v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->$remaining J
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;-><init>(J Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->label I
    const/4 v2, 3
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v1, +02dh
    if-eq v1, v4, +027h
    if-eq v1, v3, +018h
    if-ne v1, v2, +00eh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +076h
    move-exception v10
    goto/16 +07fh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v10, v3
    goto +2eh
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-wide v6, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->$remaining J
    move-object v10, v9
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v4, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->label I
    invoke-static v6, v7, v10, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    iget-object v10, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getStreamingThrottleMutex$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v10
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-object v4, v9
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->L$0 Ljava/lang/Object;
    iput-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->L$1 Ljava/lang/Object;
    iput v3, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->label I
    invoke-interface v10, v5, v4, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v0, +003h
    return-object v0
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getPendingStreamingMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v3
    if-eqz v3, +02ah
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    invoke-static v1, v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setLastStreamingEmitTime$p(Lcom/bytedance/trae/conversation/ConversationViewModel; J)V
    invoke-static v1, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setPendingStreamingMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    invoke-static v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$upsertMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$processTraeRefInSummary(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v4
    if-eqz v4, +013h
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_throttledStreamingMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v1
    iput-object v10, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->L$0 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->L$1 Ljava/lang/Object;
    iput v2, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$emitStreamingThrottled$2$1;->label I
    invoke-interface v1, v3, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v10
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    move-exception v0
    move-object v8, v0
    move-object v0, v10
    move-object v10, v8
    invoke-interface v0, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v10
    :try_start_0x16
    :try_start_0x60
    :try_start_0x8f
.end method
