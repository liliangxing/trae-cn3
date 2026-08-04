# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic Z$0:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->Z$0 Z
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->invoke(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->label I
    if-nez v0, +04ah
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->Z$0 Z
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v0
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->layoutLoadError Landroid/widget/LinearLayout;
    const/16 v3, 8
    if-eqz v6, +004h
    const/4 v4, 0
    goto +2h
    move v4, v3
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    if-eqz v6, +025h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v6
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    iget-object v6, v6, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->detailFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v6, v3, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getBinding$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v6
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v6
    iget-object v6, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v6, v3, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
.end method
