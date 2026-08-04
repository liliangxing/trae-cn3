# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DiscussingFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->invoke(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->label I
    if-nez v0, +048h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateTimer(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getTimeoutState()Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getTimeoutRemainingSeconds()I
    move-result v2
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateTimeoutState(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isMicMuted()Z
    move-result v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateMicUi(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateParticipantStates(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateAiDisplay(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode()Z
    move-result v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateContentMode(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateSubtitleListIfNeeded(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isRtcJoined()Z
    move-result v4
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateWaveformAnimating(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Z)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
