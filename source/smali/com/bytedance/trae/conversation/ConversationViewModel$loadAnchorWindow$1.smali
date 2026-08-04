# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $anchorCreatedAtMs:Ljava/lang/String;
.field final synthetic $conversationId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$anchorCreatedAtMs Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$conversationId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$anchorCreatedAtMs Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->label I
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +013h
    if-ne v1, v2, +009h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +24h
    move-exception v12
    goto/16 +095h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$conversationId Ljava/lang/String;
    iget-object v6, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$anchorCreatedAtMs Ljava/lang/String;
    const/4 v7, 5
    const/4 v8, 5
    const/4 v9, 1
    move-object v10, v11
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v2, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->label I
    invoke-static/range v4 ... v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$loadAnchorMessagesByCreatedAt(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    check-cast v12, Ljava/util/List;
    if-nez v12, +012h
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_isAnchorWindowLoading$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-object v12
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$toParsedHistoryMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v12
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-static v0, v1, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$mergeMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/util/List;)Ljava/util/List;
    move-result-object v12
    invoke-static v0, v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_hasMoreMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v12
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$anchorCreatedAtMs Ljava/lang/String;
    const/4 v4, 4
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$hasLoadedOlderSide(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/lang/String; I)Z
    move-result v0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v12, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_messages$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$anchorCreatedAtMs Ljava/lang/String;
    invoke-static v12, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$hasLoadedNewerSide(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List; Ljava/lang/String; I)Z
    move-result v0
    invoke-static v12, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setHasMoreNewerAnchorMessages$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_isAnchorWindowLoading$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v12
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v12, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->$conversationId Ljava/lang/String;
    invoke-static v12, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$prefetchLatestMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationViewModel$loadAnchorWindow$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_isAnchorWindowLoading$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    throw v12
    :try_start_0xc
    :try_start_0x1e
    :try_start_0x47
.end method
