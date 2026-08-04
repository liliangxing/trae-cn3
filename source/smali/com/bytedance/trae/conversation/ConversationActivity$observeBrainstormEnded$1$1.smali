# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.conversation.brainstorm.HolderEndData  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->invoke(Lcom/bytedance/trae/conversation/brainstorm/HolderEndData; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->label I
    if-nez v0, +112h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "holder.ended received: reason="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->getReason()Lcom/bytedance/trae/conversation/brainstorm/EndReason;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isAbort="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->isAbort()Z
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ConversationActivity"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->getSummarySkippedBecauseNoContent()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +00fh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v0, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_empty_summary_toast I
    invoke-static v0, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->isAbort()Z
    move-result v0
    if-nez v0, +0b9h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$isNewConversation$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v0
    const-string/jumbo v3, viewModel
    const/4 v4, 0
    if-eqz v0, +01eh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getSegmentedSelectedIndex()I
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    goto +4ch
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    goto +49h
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +030h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v8
    if-nez v8, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -031h
    goto +2h
    move-object v6, v4
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/im/service/Mode;
    if-nez v0, +004h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->getCliConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->getMessages()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 1
    if-eqz v6, +00bh
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v1
    goto +2h
    move v6, v7
    if-nez v6, +029h
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +008h
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    move v1, v7
    if-nez v1, +01bh
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->getMessages()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->getParentConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v1, v0, v5, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleBrainstormResult(Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String;)V
    goto +8h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "holder.ended: skip handle due to blank messages/cliCnvId"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;->getReason()Lcom/bytedance/trae/conversation/brainstorm/EndReason;
    move-result-object v10
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/EndReason;->UserBackInConversation Lcom/bytedance/trae/conversation/brainstorm/EndReason;
    if-eq v10, v0, +007h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/ConversationActivity;->finish()V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
.end method
