# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MainActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/MainActivity;


.method constructor <init>(java.lang.String  com.bytedance.trae.home.MainActivity  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->$conversationId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->$conversationId Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/MainActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;->Companion Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;
    iget-object v1, v5, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->$conversationId Ljava/lang/String;
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->label I
    invoke-virtual v6, v1, v3, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;->getConversationFullDetailRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +0a5h
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-eqz v0, +099h
    new-instance v0, Landroid/content/Intent;
    iget-object v1, v5, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-eqz v1, +079h
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;->getCliProductType()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    const-string v4, "remote"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +006h
    invoke-virtual v1, v4, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    goto +48h
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;->getCliProductType()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    const-string/jumbo v4, trae_work
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ch
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    goto +23h
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;->getCliProductType()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v6, trae_ide
    invoke-static v2, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +00bh
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    const-string v6, "extra_conversation"
    check-cast v1, Ljava/io/Serializable;
    invoke-virtual v0, v6, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    iget-object v6, v5, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-virtual v6, v0, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    const/4 v0, 0
    invoke-virtual v6, v0, v0, Lcom/bytedance/trae/home/MainActivity;->overridePendingTransition(I I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
