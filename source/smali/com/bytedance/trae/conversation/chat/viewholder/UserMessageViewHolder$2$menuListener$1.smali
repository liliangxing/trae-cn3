# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;
.super Ljava/lang/Object;
.source "UserMessageViewHolder.kt"

.implements Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;


.method constructor <init>(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onCopyClick()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "clipboard"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.content.ClipboardManager"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/content/ClipboardManager;
    const-string v1, "message"
    check-cast v1, Ljava/lang/CharSequence;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v2
    invoke-static v1, v2, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_copied I
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    return-void 
.end method

.method public onDeleteClick()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$handleDeleteClick(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)V
    return-void 
.end method

.method public onRevertClick()void
    .registers 12
    # ins_size=1
    iget-object v0, v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getCurrentMessage$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    iget-object v0, v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getMessageListener()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +003h
    return-void 
    iget-object v0, v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getMessageListener()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +004h
    const-string v0, ""
    move-object v6, v0
    iget-object v0, v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$resolveChatMode(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v5, 0
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    const/4 v8, 0
    const/16 v9, 9
    const/4 v10, 0
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-virtual v4, v2, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackRevertClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    iget-object v2, v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getMessageListener()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v2
    invoke-interface v2, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v2
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +013h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v6
    if-eqz v6, -011h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-nez v4, +003h
    goto +2ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-nez v4, +003h
    goto +1fh
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v4
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v7
    cmp-long v9, v4, v7
    if-lez v9, +004h
    move-object v1, v6
    move-wide v4, v7
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-nez v6, -015h
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v1, +012h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    move v4, v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    const/4 v6, 0
    move-object v1, v10
    move-object v5, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    move-object v0, v10
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v1, 3
    const/4 v10, 0
    move-object v5, v7
    move-object v6, v8
    move-object v7, v9
    move-object v8, v0
    move v9, v1
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
