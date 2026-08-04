# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.conversation.brainstorm.model.BrainstormEndData  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->invoke(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->label I
    if-nez v0, +079h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;->getSummarySkippedBecauseNoContent()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +00fh
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    check-cast v0, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_empty_summary_toast I
    invoke-static v0, v2, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;->isAbort()Z
    move-result v0
    if-eqz v0, +008h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->setResult(I)V
    goto +49h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    new-instance v1, Landroid/content/Intent;
    invoke-direct v1, Landroid/content/Intent;-><init>()V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    const-string v3, "extra_messages_text"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;->getMessages()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v3, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getCliConversationId()Ljava/lang/String;
    move-result-object v2
    const-string v4, "extra_session_id"
    invoke-virtual v1, v4, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;->getParentConversationId()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +015h
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    move-object v3, v6
    if-eqz v3, +007h
    const-string v6, "extra_parent_conversation_id"
    invoke-virtual v1, v6, v3, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v6, -1
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->setResult(I Landroid/content/Intent;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observeBrainstormEnded$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->finish()V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
.end method
