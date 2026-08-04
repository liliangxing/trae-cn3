# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormMcpClient.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $query:Ljava/lang/String;
.field final synthetic $sessionId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->$sessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->$query Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->$sessionId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->$query Ljava/lang/String;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.im.service.ISendMessageService  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/service/ISendMessageService;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->invoke(Lcom/bytedance/trae/im/service/ISendMessageService; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/im/service/ISendMessageService;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->$sessionId Ljava/lang/String;
    new-instance v11, Lcom/bytedance/trae/im/service/SendMessageRequest;
    const/4 v4, 0
    iget-object v5, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->$query Ljava/lang/String;
    const/4 v6, 0
    const-string/jumbo v7, solo_work_remote
    const/4 v8, 0
    const/16 v9, 21
    const/4 v10, 0
    move-object v3, v11
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/im/service/SendMessageRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v3, v12
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$postMessage$result$1;->label I
    invoke-interface v13, v1, v11, v3, Lcom/bytedance/trae/im/service/ISendMessageService;->sendMessage(Ljava/lang/String; Lcom/bytedance/trae/im/service/SendMessageRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    return-object v13
.end method
