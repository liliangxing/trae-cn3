# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt;
.super Ljava/lang/Object;
.source "DeviceFlowConnectionSuccessLifecycle.kt"


.method public static final runConnectionSuccessWhenResumed(androidx.lifecycle.Lifecycle  long  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=5
    new-instance v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v7
    move-wide v2, v8
    move-object v4, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt$runConnectionSuccessWhenResumed$2;-><init>(Landroidx/lifecycle/Lifecycle; J Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    invoke-static v6, v11, Lkotlinx/coroutines/CoroutineScopeKt;->coroutineScope(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v8
    if-ne v7, v8, +003h
    return-object v7
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
