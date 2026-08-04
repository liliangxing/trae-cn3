# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method public static synthetic $r8$lambda$3IdNu1VwS30kJeLoFMcSY676AnQ(com.bytedance.trae.conversation.ConversationActivity  boolean  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->invokeSuspend$lambda$2(Lcom/bytedance/trae/conversation/ConversationActivity; Z Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$2(com.bytedance.trae.conversation.ConversationActivity  boolean  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=3
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->onMessageListCommitComplete()V
    const/4 v0, 0
    if-eqz v3, +006h
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setSnapToBottomAfterLatestPageSubmit$p(Lcom/bytedance/trae/conversation/ConversationActivity; Z)V
    goto +16h
    if-eqz v4, +015h
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getDetailFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v3
    const/4 v1, 1
    if-eqz v3, +009h
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scrollToCreatedAt(Ljava/lang/String;)Z
    move-result v3
    if-ne v3, v1, +003h
    move v0, v1
    if-eqz v0, +005h
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$setHasScrolledToAnchorCreatedAt$p(Lcom/bytedance/trae/conversation/ConversationActivity; Z)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/util/List;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->invoke(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->label I
    if-nez v0, +0c5h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->L$0 Ljava/lang/Object;
    check-cast v8, Ljava/util/List;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getAnchorCreatedAtMs$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00ch
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getHasScrolledToAnchorCreatedAt$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v0, v1
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getSnapToBottomAfterLatestPageSubmit$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v1
    const/4 v3, 0
    if-eqz v1, +00eh
    move-object v1, v8
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    iget-object v4, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getDetailFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v4
    if-eqz v4, +00ch
    iget-object v5, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;
    invoke-direct v6, v5, v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Z Ljava/lang/String;)V
    invoke-virtual v4, v8, v1, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->submitMessages(Ljava/util/List; Z Lkotlin/jvm/functions/Function0;)V
    move-object v0, v8
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v2
    if-eqz v0, +074h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getAnchorCreatedAtMs$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00ah
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move v2, v3
    if-nez v2, +00dh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getDetailFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setAnchorLoading(Z)V
    move-object v0, v8
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +1fh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v1
    if-eqz v1, -010h
    add-int/lit8 v3, v3, 1
    if-gez v3, -014h
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -19h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Node4] Activity.messages: total="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v8, Ljava/util/List;->size()I
    move-result v8
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v1, ", agentCount="
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v1, "AgentDataFlow"
    invoke-virtual v0, v1, v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
.end method
