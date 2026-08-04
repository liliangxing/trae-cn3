# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic Z$0:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->Z$0 Z
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
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->invoke(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 40
    # ins_size=2
    move-object/from16 v0, v38
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->label I
    if-nez v1, +0b6h
    invoke-static/range v39, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->Z$0 Z
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v2
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onStreaming(Z)V
    if-nez v1, +0a3h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getHasReportedStreamShow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v1
    if-nez v1, +09bh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v2, 1
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setHasReportedStreamShow$p(Lcom/bytedance/trae/conversation/ConversationActivity; Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v7
    new-instance v5, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v9, 0
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v1
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    const-string v2, ""
    if-nez v1, +004h
    move-object v10, v2
    goto +2h
    move-object v10, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingMessageId$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v11, v2
    goto +2h
    move-object v11, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getStreamingChatModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v12, v2
    goto +2h
    move-object v12, v1
    const/4 v13, 1
    const/4 v14, 0
    move-object v8, v5
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getLastSendContext$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-result-object v1
    if-nez v1, +03ch
    new-instance v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-object v8, v1
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
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
    const v36, 134217727
    const/16 v37, 0
    invoke-direct/range v8 ... v37, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Z Z I I Ljava/lang/String; I I I I I I I I I I I I Ljava/lang/String; I I I I I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v6, v1
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    invoke-static/range v4 ... v10, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackShow$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Ljava/util/Map; I Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
.end method
