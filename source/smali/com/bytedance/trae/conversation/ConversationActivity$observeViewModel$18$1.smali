# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.im.service.Conversation  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/service/Conversation;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->invoke(Lcom/bytedance/trae/im/service/Conversation; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->label I
    if-nez v0, +060h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$hideWelcomeScreen(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setConversationId(Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v0
    const-string v1, "binding"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->btnOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    const/16 v3, 8
    invoke-virtual v0, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->btnOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$updateConversationTitleInfo(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Conversation;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getDetailFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v5
    if-eqz v5, +005h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setTask()V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
