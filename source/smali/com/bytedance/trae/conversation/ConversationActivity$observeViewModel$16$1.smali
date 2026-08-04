# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlin/Pair;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->invoke(Lkotlin/Pair; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.Pair  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->label I
    if-nez v0, +0a2h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lkotlin/Pair;
    invoke-virtual v5, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$hideWelcomeScreen(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->clearInput()V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v5
    const/4 v1, 0
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setBottomContextualBarVisible(Z)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v5
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setDeviceFolderBarVisible(Z)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v5
    const/4 v2, 0
    const-string v3, "binding"
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showConversationDetailHeader()V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v5
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getTitleText()Ljava/lang/CharSequence;
    move-result-object v5
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    const/4 v1, 1
    if-eqz v1, +01eh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v5
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    iget-object v5, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_new_task I
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v5, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setConversationDetailTitle(Ljava/lang/CharSequence;)V
    sget-object v5, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskIdUser()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v1, v2, Lcom/bytedance/trae/im/track/AgentMonitor;->onUserMessageSuccess(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-static v5, v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$flushPendingTriggerTracker(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
