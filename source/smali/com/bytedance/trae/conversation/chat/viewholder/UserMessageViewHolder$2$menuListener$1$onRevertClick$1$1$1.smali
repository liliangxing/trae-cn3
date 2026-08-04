# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserMessageViewHolder.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field final synthetic $revertChatMode:Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;


.method constructor <init>(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.tracker.SoloChatMode  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +015h
    if-ne v1, v2, +00bh
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v0
    goto +37h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getMessageListener()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v9
    invoke-interface v9, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v9
    if-eqz v9, +0a1h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +004h
    goto/16 +099h
    sget-object v1, Lcom/bytedance/trae/im/service/IDeleteConversationService;->Companion Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;
    new-instance v3, Lcom/bytedance/trae/im/service/DeleteConversationRequest;
    invoke-direct v3, v9, Lcom/bytedance/trae/im/service/DeleteConversationRequest;-><init>(Ljava/lang/String;)V
    move-object v4, v8
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v9, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->L$0 Ljava/lang/Object;
    iput v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->label I
    invoke-virtual v1, v3, v4, Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;->deleteConversationRawCall(Lcom/bytedance/trae/im/service/DeleteConversationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v2, v9
    move-object v9, v1
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v1, 0
    if-eqz v0, +055h
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    const-wide/32 v5, 2900101
    cmp-long v9, v3, v5
    if-nez v9, +026h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v9
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v9, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/Toast;->show()V
    goto +42h
    sget-object v9, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    invoke-virtual v9, v2, Lcom/bytedance/trae/conversation/chat/MessageManager;->notifyConversationDeleted(Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    new-instance v7, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v1, 0
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/16 v5, 9
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v9, v7, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackRevertSuccess(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    goto +24h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v9
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v9, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/Toast;->show()V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
