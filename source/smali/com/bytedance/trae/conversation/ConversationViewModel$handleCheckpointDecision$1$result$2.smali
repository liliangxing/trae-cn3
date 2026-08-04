# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $convId:Ljava/lang/String;
.field final synthetic $decision:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
.field final synthetic $decisionStr:Ljava/lang/String;
.field final synthetic $params:Lkotlin/jvm/internal/Ref$ObjectRef;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision  java.lang.String  kotlin.jvm.internal.Ref$ObjectRef  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$convId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decisionStr Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$params Lkotlin/jvm/internal/Ref$ObjectRef;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$convId Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decisionStr Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$params Lkotlin/jvm/internal/Ref$ObjectRef;
    move-object v0, v6
    move-object v5, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/coroutines/Continuation;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlin/coroutines/Continuation;
    return-object v6
.end method

.method public final invoke(com.bytedance.trae.im.service.IConfirmTaskApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/service/IConfirmTaskApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->invoke(Lcom/bytedance/trae/im/service/IConfirmTaskApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +42h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->L$0 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/im/service/IConfirmTaskApi;
    new-instance v1, Lcom/bytedance/trae/im/service/ConfirmTaskRequest;
    iget-object v4, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$convId Ljava/lang/String;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getTaskId()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getPlanItemId()Ljava/lang/String;
    move-result-object v7
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decision Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;->getToolName()Ljava/lang/String;
    move-result-object v8
    iget-object v9, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$decisionStr Ljava/lang/String;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->$params Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v3, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    move-object v10, v3
    check-cast v10, Ljava/lang/String;
    const/4 v11, 4
    const/4 v12, 0
    move-object v3, v1
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/im/service/ConfirmTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v3, v13
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v13, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCheckpointDecision$1$result$2;->label I
    invoke-interface v14, v1, v3, Lcom/bytedance/trae/im/service/IConfirmTaskApi;->confirmTask(Lcom/bytedance/trae/im/service/ConfirmTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    return-object v14
.end method
