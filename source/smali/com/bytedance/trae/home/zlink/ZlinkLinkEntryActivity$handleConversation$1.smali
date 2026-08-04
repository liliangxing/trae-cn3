# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ZlinkLinkEntryActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;


.method constructor <init>(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->this$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    iput-object v2, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->this$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    iget-object v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->$conversationId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;-><init>(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    const-wide/16 v4, 0
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    const/4 v7, 1
    const/4 v8, 0
    iput v2, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->label I
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->awaitReady$default(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    iget-object v10, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->this$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    invoke-virtual v10, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->isFinishing()Z
    move-result v10
    if-nez v10, +066h
    iget-object v10, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->this$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    invoke-virtual v10, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->isDestroyed()Z
    move-result v10
    if-eqz v10, +003h
    goto +5ch
    new-instance v10, Landroid/content/Intent;
    iget-object v0, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->this$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    check-cast v0, Landroid/content/Context;
    const-class v1, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v10, v0, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    iget-object v0, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->$conversationId Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00ah
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +035h
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationUtils;->INSTANCE Lcom/bytedance/trae/conversation/ConversationUtils;
    iget-object v1, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->$conversationId Ljava/lang/String;
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationUtils;->resolveInitialConversation(Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-eqz v0, +02ah
    sget-object v1, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01ah
    sget-object v1, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    const-string v1, "extra_conversation"
    check-cast v0, Ljava/io/Serializable;
    invoke-virtual v10, v1, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    iget-object v0, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->this$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    invoke-virtual v0, v10, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->startActivity(Landroid/content/Intent;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;->this$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    invoke-virtual v10, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method
