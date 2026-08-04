# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceFlowConnectionSuccessLifecycle.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $completed:Lkotlinx/coroutines/CompletableDeferred;
.field final synthetic $delayMs:J
.field final synthetic $onCompletion:Lkotlin/jvm/functions/Function0;
.field  label:I


.method constructor <init>(long  kotlinx.coroutines.CompletableDeferred  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$delayMs J
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$completed Lkotlinx/coroutines/CompletableDeferred;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$onCompletion Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;
    iget-wide v1, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$delayMs J
    iget-object v3, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$completed Lkotlinx/coroutines/CompletableDeferred;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$onCompletion Lkotlin/jvm/functions/Function0;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;-><init>(J Lkotlinx/coroutines/CompletableDeferred; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$delayMs J
    move-object v6, v5
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->label I
    invoke-static v3, v4, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$completed Lkotlinx/coroutines/CompletableDeferred;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v6, v0, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +007h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;->$onCompletion Lkotlin/jvm/functions/Function0;
    invoke-interface v6, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
