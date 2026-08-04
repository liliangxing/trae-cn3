# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceFlowConnectionSuccessLifecycle.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $completed:Lkotlinx/coroutines/CompletableDeferred;
.field final synthetic $delayMs:J
.field final synthetic $lifecycle:Landroidx/lifecycle/Lifecycle;
.field final synthetic $onCompletion:Lkotlin/jvm/functions/Function0;
.field  label:I


.method constructor <init>(androidx.lifecycle.Lifecycle  long  kotlinx.coroutines.CompletableDeferred  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$lifecycle Landroidx/lifecycle/Lifecycle;
    iput-wide v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$delayMs J
    iput-object v4, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$completed Lkotlinx/coroutines/CompletableDeferred;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$onCompletion Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$lifecycle Landroidx/lifecycle/Lifecycle;
    iget-wide v2, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$delayMs J
    iget-object v4, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$completed Lkotlinx/coroutines/CompletableDeferred;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$onCompletion Lkotlin/jvm/functions/Function0;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;-><init>(Landroidx/lifecycle/Lifecycle; J Lkotlinx/coroutines/CompletableDeferred; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2bh
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$lifecycle Landroidx/lifecycle/Lifecycle;
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->RESUMED Landroidx/lifecycle/Lifecycle$State;
    new-instance v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;
    iget-wide v4, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$delayMs J
    iget-object v6, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$completed Lkotlinx/coroutines/CompletableDeferred;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->$onCompletion Lkotlin/jvm/functions/Function0;
    const/4 v8, 0
    move-object v3, v9
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1$1;-><init>(J Lkotlinx/coroutines/CompletableDeferred; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    move-object v3, v10
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;->label I
    invoke-static v11, v1, v9, v3, Landroidx/lifecycle/RepeatOnLifecycleKt;->repeatOnLifecycle(Landroidx/lifecycle/Lifecycle; Landroidx/lifecycle/Lifecycle$State; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
