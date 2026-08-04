# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $$this$launch:Lkotlinx/coroutines/CoroutineScope;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlin/Unit;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->invoke(Lkotlin/Unit; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.Unit  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 53
    # ins_size=2
    move-object/from16 v0, v51
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->label I
    if-nez v1, +223h
    invoke-static/range v52, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "CheckPointDialog"
    const-string/jumbo v3, taskDone: CheckpointDialog dismissIfShowing
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    const-string v3, "getSupportFragmentManager(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;->dismissIfShowing(Landroidx/fragment/app/FragmentManager;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$dismissPluginAuthBottomSheetIfShowing(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v2, 0
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setCheckpointDialogVisible$p(Lcom/bytedance/trae/conversation/ConversationActivity; Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v3, 0
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setShowingCheckpointToolCallId$p(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v1
    const-string v4, "binding"
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    const/4 v5, 0
    invoke-virtual v1, v5, Landroidx/fragment/app/FragmentContainerView;->setTranslationY(F)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    const/16 v5, 8
    invoke-virtual v1, v5, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v1, v2, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getDetailFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scrollToBottom()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v1
    const-string/jumbo v4, viewModel
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 1
    if-eqz v5, +008h
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    move v2, v6
    if-nez v2, +02eh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v2
    sget-object v5, Landroidx/lifecycle/Lifecycle$State;->RESUMED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v2, v5, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v2
    if-eqz v2, +01ch
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1$1;
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v10, v2
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getLastDoneMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    const-string/jumbo v5, success
    if-eqz v2, +038h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v7
    const-string v8, "error"
    const-string v9, "canceled"
    sparse-switch v7, +0000134h
    goto +2bh
    const-string v7, "cancelled"
    invoke-virtual v2, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +011h
    goto +22h
    invoke-virtual v2, v8, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +026h
    goto +1bh
    invoke-virtual v2, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +14h
    move-object v8, v9
    goto +1bh
    const-string v7, "failed"
    invoke-virtual v2, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +014h
    goto +9h
    const-string v7, "completed"
    invoke-virtual v2, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00ah
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v5
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatStartTime()Ljava/lang/Long;
    move-result-object v2
    goto +2h
    move-object v2, v3
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatEndTime()Ljava/lang/Long;
    move-result-object v1
    goto +2h
    move-object v1, v3
    if-eqz v2, +021h
    if-eqz v1, +01fh
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v9
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v11
    cmp-long v7, v9, v11
    if-lez v7, +013h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v9
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    sub-long/2addr v9, v1
    long-to-double v1, v9
    const-wide v9, 4652007308841189376
    div-double/2addr v1, v9
    goto +3h
    const-wide/16 v1, 0
    move-wide v13, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, v3, v6, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v20
    new-instance v10, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/16 v22, 0
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    const-string v2, ""
    if-nez v1, +005h
    move-object/from16 v23, v2
    goto +3h
    move-object/from16 v23, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingMessageId$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    move-object/from16 v24, v2
    goto +3h
    move-object/from16 v24, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingChatModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    move-object/from16 v25, v2
    goto +3h
    move-object/from16 v25, v1
    const/16 v26, 1
    const/16 v27, 0
    move-object/from16 v21, v10
    invoke-direct/range v21 ... v27, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getLastSendContext$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-result-object v1
    if-nez v1, +044h
    new-instance v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-object/from16 v21, v1
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const v49, 134217727
    const/16 v50, 0
    invoke-direct/range v21 ... v50, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Z Z I I Ljava/lang/String; I I I I I I I I I I I I Ljava/lang/String; I I I I I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v11, v1
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v21, 0
    const/16 v22, 1520
    const/16 v23, 0
    move-object v12, v8
    invoke-static/range v9 ... v23, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackCompleteShow$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Ljava/lang/String; D I I I Ljava/lang/String; I Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Ljava/util/Map; I Ljava/lang/Object;)V
    invoke-static v8, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00dh
    sget-object v1, Lcom/bytedance/trae/praise/PraiseDialogHelper;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogHelper;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v2, Landroid/content/Context;
    const-string v3, "conversation"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/praise/PraiseDialogHelper;->onTaskDoneAndTryShow(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    sparse-switch-payload -539f09b5 -4c696bc3 -7577b67 5c4d208 1c682951
.end method
