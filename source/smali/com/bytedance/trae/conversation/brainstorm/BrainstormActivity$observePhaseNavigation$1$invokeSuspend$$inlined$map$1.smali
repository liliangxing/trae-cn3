# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1;
.super Ljava/lang/Object;
.source "SafeCollector.common.kt"

.implements Lkotlinx/coroutines/flow/Flow;

.field final synthetic $this_unsafeTransform$inlined:Lkotlinx/coroutines/flow/Flow;


.method public constructor <init>(kotlinx.coroutines.flow.Flow)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1;->$this_unsafeTransform$inlined Lkotlinx/coroutines/flow/Flow;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public collect(kotlinx.coroutines.flow.FlowCollector  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1;->$this_unsafeTransform$inlined Lkotlinx/coroutines/flow/Flow;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2;-><init>(Lkotlinx/coroutines/flow/FlowCollector;)V
    check-cast v1, Lkotlinx/coroutines/flow/FlowCollector;
    invoke-interface v0, v1, v4, Lkotlinx/coroutines/flow/Flow;->collect(Lkotlinx/coroutines/flow/FlowCollector; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    if-ne v3, v4, +003h
    return-object v3
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method
