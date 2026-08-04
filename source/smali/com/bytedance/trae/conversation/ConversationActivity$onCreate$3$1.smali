# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $id:Ljava/lang/String;
.field  I$0:I
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->$id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->$id Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->label I
    const/4 v2, 4
    const/4 v3, 2
    const/4 v4, 3
    const/4 v5, 1
    if-eqz v1, +029h
    if-eq v1, v5, +023h
    if-eq v1, v3, +01ah
    if-eq v1, v4, +011h
    if-ne v1, v2, +007h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c6h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    iget v1, v9, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->I$0 I
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v6, v9
    goto +58h
    iget v1, v9, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->I$0 I
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v6, v9
    goto +3fh
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +14h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;->Companion Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->$id Ljava/lang/String;
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v5, v9, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->label I
    invoke-virtual v10, v1, v6, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;->getConversationFullDetailRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    const/4 v1, 0
    move-object v6, v9
    instance-of v7, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v7, +00fh
    move-object v8, v10
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v8
    if-nez v8, +02ah
    if-ge v1, v4, +028h
    move-object v10, v6
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v1, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->I$0 I
    iput v3, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->label I
    const-wide/16 v7, 100
    invoke-static v7, v8, v10, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    sget-object v10, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;->Companion Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;
    iget-object v7, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->$id Ljava/lang/String;
    move-object v8, v6
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v1, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->I$0 I
    iput v4, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->label I
    invoke-virtual v10, v7, v8, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;->getConversationFullDetailRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    add-int/2addr v1, v5
    goto -38h
    if-eqz v7, +02dh
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-eqz v1, +021h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;
    invoke-virtual v0, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->onConversationFullDetailLoaded(Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v10, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v10, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    iput-boolean v5, v10, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    sget-object v1, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-virtual v1, Lcom/bytedance/trae/network/NetworkMonitor;->isConnected()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    check-cast v1, Lkotlinx/coroutines/flow/Flow;
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$invokeSuspend$$inlined$filter$1;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$invokeSuspend$$inlined$filter$1;-><init>(Lkotlinx/coroutines/flow/Flow;)V
    check-cast v3, Lkotlinx/coroutines/flow/Flow;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->$id Ljava/lang/String;
    iget-object v5, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v1, v10, v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef; Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    check-cast v1, Lkotlinx/coroutines/flow/FlowCollector;
    move-object v10, v6
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;->label I
    invoke-interface v3, v1, v10, Lkotlinx/coroutines/flow/Flow;->collect(Lkotlinx/coroutines/flow/FlowCollector; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method
