# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceFlowConnectionSuccessLifecycle.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $delayMs:J
.field final synthetic $lifecycle:Landroidx/lifecycle/Lifecycle;
.field final synthetic $onCompletion:Lkotlin/jvm/functions/Function0;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(androidx.lifecycle.Lifecycle  long  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$lifecycle Landroidx/lifecycle/Lifecycle;
    iput-wide v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$delayMs J
    iput-object v4, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$onCompletion Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$lifecycle Landroidx/lifecycle/Lifecycle;
    iget-wide v2, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$delayMs J
    iget-object v4, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$onCompletion Lkotlin/jvm/functions/Function0;
    move-object v0, v6
    move-object v5, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;-><init>(Landroidx/lifecycle/Lifecycle; J Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlin/coroutines/Continuation;
    return-object v6
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v1, v18
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v0, +028h
    if-eq v0, v6, +01bh
    if-eq v0, v4, +015h
    if-eq v0, v3, +00ah
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/Throwable;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06ch
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +54h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->L$0 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Lkotlinx/coroutines/Job;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    move-exception v0
    goto +4eh
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->L$0 Ljava/lang/Object;
    move-object v7, v0
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v5, v6, v5, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v0
    const/4 v15, 0
    const/16 v16, 0
    new-instance v17, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$lifecycle Landroidx/lifecycle/Lifecycle;
    iget-wide v10, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$delayMs J
    iget-object v13, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->$onCompletion Lkotlin/jvm/functions/Function0;
    const/4 v14, 0
    move-object/from16 v8, v17
    move-object v12, v0
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2$lifecycleJob$1;-><init>(Landroidx/lifecycle/Lifecycle; J Lkotlinx/coroutines/CompletableDeferred; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v10, v17
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    move-object v8, v15
    move-object/from16 v9, v16
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v7
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->L$0 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->label I
    invoke-interface v0, v8, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v6, v7
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->L$0 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->label I
    invoke-static v6, v0, Lkotlinx/coroutines/JobKt;->cancelAndJoin(Lkotlinx/coroutines/Job; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    move-object v6, v7
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->L$0 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;->label I
    invoke-static v6, v4, Lkotlinx/coroutines/JobKt;->cancelAndJoin(Lkotlinx/coroutines/Job; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v2, +003h
    return-object v2
    throw v0
    :try_start_0x2e
    :try_start_0x5f
.end method
