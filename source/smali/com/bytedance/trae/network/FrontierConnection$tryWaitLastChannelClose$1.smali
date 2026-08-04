# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "FrontierConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $block:Lkotlin/jvm/functions/Function0;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/FrontierConnection;


.method constructor <init>(com.bytedance.trae.network.FrontierConnection  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->this$0 Lcom/bytedance/trae/network/FrontierConnection;
    iput-object v2, v0, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->$block Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;
    iget-object v0, v2, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->this$0 Lcom/bytedance/trae/network/FrontierConnection;
    iget-object v1, v2, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->$block Lkotlin/jvm/functions/Function0;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;-><init>(Lcom/bytedance/trae/network/FrontierConnection; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +010h
    if-ne v1, v3, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +26h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->this$0 Lcom/bytedance/trae/network/FrontierConnection;
    invoke-static v6, Lcom/bytedance/trae/network/FrontierConnection;->access$getPendingCloseDeferred$p(Lcom/bytedance/trae/network/FrontierConnection;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v6
    if-eqz v6, +016h
    new-instance v1, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1$1$1;
    invoke-direct v1, v6, v2, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1$1$1;-><init>(Lkotlinx/coroutines/CompletableDeferred; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    iput v3, v5, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->label I
    const-wide/16 v3, 2000
    invoke-static v3, v4, v1, v5, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lkotlin/Unit;
    iget-object v6, v5, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->this$0 Lcom/bytedance/trae/network/FrontierConnection;
    invoke-static v6, v2, Lcom/bytedance/trae/network/FrontierConnection;->access$setPendingCloseDeferred$p(Lcom/bytedance/trae/network/FrontierConnection; Lkotlinx/coroutines/CompletableDeferred;)V
    iget-object v6, v5, Lcom/bytedance/trae/network/FrontierConnection$tryWaitLastChannelClose$1;->$block Lkotlin/jvm/functions/Function0;
    invoke-interface v6, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
