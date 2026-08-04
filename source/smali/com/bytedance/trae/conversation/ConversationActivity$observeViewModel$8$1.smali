# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.im.model.ParsedChatMessage  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->invoke(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->label I
    if-nez v0, +0d6h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00bh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setStreamingMessageId$p(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStreamingChatModel()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +007h
    iget-object v3, v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setStreamingChatModel$p(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    goto +2h
    move v0, v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "[Node4] Activity.streaming: planItemCount="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", status="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", isHistory="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v4, "AgentDataFlow"
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v7, Lcom/bytedance/trae/im/service/IMMessageKt;->getTaskId(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00ah
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +2h
    move v1, v2
    const-string v0, "CheckPointDialog"
    if-nez v1, +045h
    iget-object v1, v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v7, Lcom/bytedance/trae/im/service/IMMessageKt;->getTaskId(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v7, v3, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$checkConfirmRequired(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String;)V
    goto +3bh
    move-exception v7
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, streamingMessage: checkConfirmRequired error: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v0, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationActivity;->access$isCheckpointDialogVisible$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v7
    if-nez v7, +01eh
    iget-object v7, v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v7
    if-nez v7, +008h
    const-string v7, "binding"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v7, 0
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v7, v2, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    goto +9h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v1, streamingMessage: taskId is null
    invoke-virtual v7, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    :try_start_0x8d
    :try_start_0xbc
.end method
