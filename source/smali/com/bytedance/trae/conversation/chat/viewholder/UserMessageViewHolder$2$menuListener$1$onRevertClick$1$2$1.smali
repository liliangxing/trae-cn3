# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserMessageViewHolder.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field final synthetic $revertChatMode:Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;


.method constructor <init>(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.conversation.tracker.SoloChatMode  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$conversationId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$conversationId Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +26h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v9, Lcom/bytedance/trae/im/service/IRevertTaskApi;->Companion Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1$result$1;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$conversationId Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v5, 0
    invoke-direct v1, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1$result$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v8
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->label I
    invoke-virtual v9, v1, v3, Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v9, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v9, +030h
    sget-object v9, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$conversationId Ljava/lang/String;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getCurrentMessage$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    invoke-virtual v9, v0, v1, v2, Lcom/bytedance/trae/conversation/chat/MessageManager;->notifyMessageReverted(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    new-instance v7, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v1, 0
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$conversationId Ljava/lang/String;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/16 v5, 9
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v9, v7, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackRevertSuccess(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    goto +25h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v9
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v9, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/Toast;->show()V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
