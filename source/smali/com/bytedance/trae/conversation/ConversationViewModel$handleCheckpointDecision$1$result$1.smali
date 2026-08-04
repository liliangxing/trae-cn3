# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $convId:Ljava/lang/String;
.field final synthetic $decision:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->$convId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->$convId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.im.service.ICancelTaskApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/service/ICancelTaskApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->invoke(Lcom/bytedance/trae/im/service/ICancelTaskApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2bh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/im/service/ICancelTaskApi;
    new-instance v1, Lcom/bytedance/trae/im/service/CancelTaskRequest;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->$convId Ljava/lang/String;
    iget-object v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    check-cast v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Cancel;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Cancel;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/im/service/CancelTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$1;->label I
    invoke-interface v6, v1, v3, Lcom/bytedance/trae/im/service/ICancelTaskApi;->cancelTask(Lcom/bytedance/trae/im/service/CancelTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    return-object v6
.end method
