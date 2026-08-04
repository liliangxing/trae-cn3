# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $$this$launch:Lkotlinx/coroutines/CoroutineScope;
.field synthetic Z$0:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->Z$0 Z
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->invoke(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 23
    # ins_size=2
    move-object/from16 v0, v21
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->label I
    if-nez v1, +0e1h
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->Z$0 Z
    if-eqz v1, +0ceh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getWasUserInitiatedCancel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v1
    if-eqz v1, +0c4h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v1
    const-string/jumbo v2, viewModel
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getLastDoneMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatStartTime()Ljava/lang/Long;
    move-result-object v5
    goto +2h
    move-object v5, v3
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatEndTime()Ljava/lang/Long;
    move-result-object v1
    goto +2h
    move-object v1, v3
    const-wide v6, 4652007308841189376
    if-eqz v5, +019h
    if-eqz v1, +017h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v8
    invoke-virtual v5, Ljava/lang/Long;->longValue()J
    move-result-wide v10
    cmp-long v8, v8, v10
    if-lez v8, +00bh
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v8
    invoke-virtual v5, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    goto +13h
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingStartTimeMs$p(Lcom/bytedance/trae/conversation/ConversationActivity;)J
    move-result-wide v8
    const-wide/16 v10, 0
    cmp-long v1, v8, v10
    if-lez v1, +00eh
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v8
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingStartTimeMs$p(Lcom/bytedance/trae/conversation/ConversationActivity;)J
    move-result-wide v4
    sub-long/2addr v8, v4
    long-to-double v4, v8
    div-double/2addr v4, v6
    goto +3h
    const-wide/16 v4, 0
    move-wide v10, v4
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v4, 1
    invoke-static v1, v3, v4, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v13
    new-instance v7, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v15, 0
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    const-string v2, ""
    if-nez v1, +005h
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingMessageId$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    move-object/from16 v17, v2
    goto +3h
    move-object/from16 v17, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingChatModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    move-object/from16 v18, v2
    goto +3h
    move-object/from16 v18, v1
    const/16 v19, 1
    const/16 v20, 0
    move-object v14, v7
    invoke-direct/range v14 ... v20, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v6, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string/jumbo v8, user_click
    const-string/jumbo v9, streaming
    const/4 v12, 0
    const/16 v14, 16
    const/4 v15, 0
    invoke-static/range v6 ... v15, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackCanceled$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Ljava/lang/String; D Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; I Ljava/lang/Object;)V
    goto +ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputSended()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
.end method
