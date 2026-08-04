# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$HolderState  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->invoke(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->label I
    if-nez v0, +031h
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->IDLE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    if-eq v2, v0, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->TERMINATED Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    if-ne v2, v0, +008h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setILaunchedActiveBrainstorm$p(Lcom/bytedance/trae/conversation/ConversationActivity; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v2
    sget-object v0, Landroidx/lifecycle/Lifecycle$State;->RESUMED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v2, v0, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v2
    if-eqz v2, +007h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$applyMinimizedVoiceVisibility(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
