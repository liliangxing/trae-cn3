# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserMessageViewHolder.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isFirstMessage:Z
.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field final synthetic $revertChatMode:Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;


.method public static synthetic $r8$lambda$KHzakmTtlCzSfYpy0SRWIEmWMws(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.tracker.SoloChatMode)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$_Q3jVqYhTQsoMidVRLvwj0vyKcg(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.conversation.tracker.SoloChatMode)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->invokeSuspend$lambda$1(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  boolean  com.bytedance.trae.conversation.tracker.SoloChatMode  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$isFirstMessage Z
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.tracker.SoloChatMode)kotlin.Unit
    .registers 10
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v9, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final invokeSuspend$lambda$1(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  com.bytedance.trae.conversation.tracker.SoloChatMode)kotlin.Unit
    .registers 14
    # ins_size=4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v10
    move-object v6, v11
    move-object v7, v12
    move-object v8, v13
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-boolean v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$isFirstMessage Z
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->label I
    const/4 v2, 1
    if-eqz v1, +014h
    if-ne v1, v2, +00ah
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getMessageListener()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v15
    invoke-interface v15, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v15
    if-eqz v15, +18bh
    invoke-virtual v15, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v15
    if-nez v15, +004h
    goto/16 +183h
    sget-object v1, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi;->Companion Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;
    new-instance v3, Lcom/bytedance/trae/im/service/RevertCheckTaskRequest;
    iget-object v4, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v15, v4, Lcom/bytedance/trae/im/service/RevertCheckTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v4, v14
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v15, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->L$0 Ljava/lang/Object;
    iput v2, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->label I
    invoke-virtual v1, v3, v4, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;->revertCheckTaskRawCall(Lcom/bytedance/trae/im/service/RevertCheckTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v15
    move-object v15, v1
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v3, 0
    if-eqz v1, +0ceh
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/im/service/RevertCheckTaskResponse;
    const/4 v1, 0
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/im/service/RevertCheckTaskResponse;->getDiffFileInfos()Ljava/util/List;
    move-result-object v15
    goto +2h
    move-object v15, v1
    if-nez v15, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v15
    move-object v7, v15
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v15
    invoke-virtual v15, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v5
    instance-of v15, v5, Landroid/app/Activity;
    if-eqz v15, +006h
    move-object v15, v5
    check-cast v15, Landroid/app/Activity;
    goto +2h
    move-object v15, v1
    if-eqz v15, +00ah
    invoke-virtual v15, Landroid/app/Activity;->isFinishing()Z
    move-result v15
    if-ne v15, v2, +004h
    move v15, v2
    goto +2h
    move v15, v3
    if-nez v15, +08fh
    instance-of v15, v5, Landroid/app/Activity;
    if-eqz v15, +005h
    move-object v1, v5
    check-cast v1, Landroid/app/Activity;
    if-eqz v1, +009h
    invoke-virtual v1, Landroid/app/Activity;->isDestroyed()Z
    move-result v15
    if-ne v15, v2, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +004h
    goto/16 +07ah
    iget-boolean v15, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$isFirstMessage Z
    const-string v1, "getString(...)"
    if-eqz v15, +03ch
    new-instance v15, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_revert_dialog_title I
    invoke-virtual v5, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_cancel I
    invoke-virtual v5, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_confirm I
    invoke-virtual v5, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_revert_first_message I
    invoke-virtual v5, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget-object v1, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v2, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    new-instance v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda0;
    invoke-direct v11, v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    move-object v4, v15
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;-><init>(Landroid/content/Context; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->show()V
    goto/16 +0c5h
    new-instance v15, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_revert_dialog_title I
    invoke-virtual v5, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_cancel I
    invoke-virtual v5, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_confirm I
    invoke-virtual v5, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v10, 0
    iget-object v1, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v2, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget-object v3, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->$revertChatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    new-instance v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;
    invoke-direct v11, v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    const/16 v12, 32
    const/4 v13, 0
    move-object v4, v15
    invoke-direct/range v4 ... v13, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;-><init>(Landroid/content/Context; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->show()V
    goto/16 +08dh
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    instance-of v0, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +089h
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    int-to-long v0, v0
    const-wide/32 v4, 2900101
    cmp-long v0, v0, v4
    if-nez v0, +028h
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v15
    invoke-virtual v15, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v15
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v15, v0, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v15
    invoke-virtual v15, Landroid/widget/Toast;->show()V
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v15
    const v0, 991505
    if-ne v15, v0, +026h
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v15
    invoke-virtual v15, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v15
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_check_rollback_failed I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v15, v0, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v15
    invoke-virtual v15, Landroid/widget/Toast;->show()V
    goto +24h
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v15
    invoke-virtual v15, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v15
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1$onRevertClick$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getTvContent$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v15, v0, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v15
    invoke-virtual v15, Landroid/widget/Toast;->show()V
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    new-instance v15, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v15, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v15
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    :try_start_0x72
    :try_start_0xad
.end method
