# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $onResult:Lkotlin/jvm/functions/Function1;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->$onResult Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->$onResult Lkotlin/jvm/functions/Function1;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v6
    const-string/jumbo v1, viewModel
    const/4 v3, 0
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    move-object v4, v6
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    const/4 v4, 0
    goto +2h
    move v4, v2
    if-eqz v4, +00ah
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->$onResult Lkotlin/jvm/functions/Function1;
    invoke-interface v6, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    iget-object v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v4
    move-object v1, v5
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->label I
    invoke-virtual v3, v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->checkIdeProjectForSkills(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v6, +015h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getSelectedDeviceByMode$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Ljava/util/Map;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getCurrentMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v1
    invoke-interface v0, v1, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;->$onResult Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v6, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
