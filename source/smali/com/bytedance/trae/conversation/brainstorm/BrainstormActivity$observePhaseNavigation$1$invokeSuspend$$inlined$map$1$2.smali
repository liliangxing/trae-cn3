# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2;
.super Ljava/lang/Object;
.source "Emitters.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic $this_unsafeFlow:Lkotlinx/coroutines/flow/FlowCollector;


.method public constructor <init>(kotlinx.coroutines.flow.FlowCollector)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2;->$this_unsafeFlow Lkotlinx/coroutines/flow/FlowCollector;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    instance-of v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;
    invoke-direct v0, v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2;->$this_unsafeFlow Lkotlinx/coroutines/flow/FlowCollector;
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getPhase()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    move-result-object v5
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1;->label I
    invoke-interface v6, v5, v0, Lkotlinx/coroutines/flow/FlowCollector;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method
