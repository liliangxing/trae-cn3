# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserMessageViewHolder.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatMode:Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field final synthetic $userMessageCount:I
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;


.method constructor <init>(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  int  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.tracker.SoloChatMode  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$userMessageCount I
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$userMessageCount I
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; I Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->label I
    const-wide/32 v2, 2900101
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v1, +021h
    if-eq v1, v5, +016h
    if-ne v1, v4, +00ch
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v0
    goto/16 +0c4h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v6, v0
    goto +35h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getMessageListener()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v14
    if-eqz v14, +11fh
    invoke-interface v14, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v14
    if-eqz v14, +119h
    invoke-virtual v14, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v14
    if-nez v14, +004h
    goto/16 +111h
    iget v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$userMessageCount I
    if-ne v1, v5, +079h
    sget-object v1, Lcom/bytedance/trae/im/service/IDeleteConversationService;->Companion Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;
    new-instance v4, Lcom/bytedance/trae/im/service/DeleteConversationRequest;
    invoke-direct v4, v14, Lcom/bytedance/trae/im/service/DeleteConversationRequest;-><init>(Ljava/lang/String;)V
    move-object v6, v13
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->L$0 Ljava/lang/Object;
    iput v5, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->label I
    invoke-virtual v1, v4, v6, Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;->deleteConversationRawCall(Lcom/bytedance/trae/im/service/DeleteConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v6, v14
    move-object v14, v1
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +04bh
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v0
    cmp-long v14, v0, v2
    if-nez v14, +013h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-static v14, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    goto/16 +0ceh
    sget-object v14, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v14, v6, v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->notifyMessageDeleted(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    invoke-virtual v14, v6, Lcom/bytedance/trae/conversation/chat/MessageManager;->notifyConversationDeleted(Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v5, 0
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    const/4 v8, 0
    const/16 v9, 9
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v14, v0, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackDeleteSuccess(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    goto/16 +0a4h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-static v14, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    goto/16 +093h
    sget-object v1, Lcom/bytedance/trae/im/service/IDeleteTaskApi;->Companion Lcom/bytedance/trae/im/service/IDeleteTaskApi$Companion;
    new-instance v6, Lcom/bytedance/trae/im/service/DeleteTaskRequest;
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v14, v7, Lcom/bytedance/trae/im/service/DeleteTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v7, v13
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->L$0 Ljava/lang/Object;
    iput v4, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->label I
    invoke-virtual v1, v6, v7, Lcom/bytedance/trae/im/service/IDeleteTaskApi$Companion;->deleteTaskRawCall(Lcom/bytedance/trae/im/service/DeleteTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v8, v14
    move-object v14, v1
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +026h
    sget-object v14, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v14, v8, v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->notifyMessageDeleted(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v7, 0
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v9
    const/4 v10, 0
    const/16 v11, 9
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->$chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v14, v0, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackDeleteSuccess(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    goto +4bh
    instance-of v0, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +035h
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v14
    int-to-long v0, v14
    cmp-long v14, v0, v2
    if-nez v14, +016h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-static v14, v0, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/Toast;->show()V
    goto +28h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-static v14, v0, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/Toast;->show()V
    goto +14h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-static v14, v0, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/Toast;->show()V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
