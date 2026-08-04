# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;
.super Ljava/lang/Object;
.source "ConversationActivity.kt"

.implements Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onArtifactClick()void
    .registers 11
    # ins_size=1
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    const-string/jumbo v1, viewModel
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getDetailFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getLastMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v3
    goto +2h
    move-object v3, v2
    if-eqz v0, +044h
    if-nez v3, +003h
    goto +40h
    sget-object v4, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v5, Landroid/content/Context;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v6
    const-string v7, ""
    if-nez v6, +003h
    move-object v6, v7
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTurnId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    move-object v3, v7
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v8, v7
    goto +2h
    move-object v8, v0
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +004h
    move-object v9, v7
    goto +2h
    move-object v9, v0
    move-object v7, v3
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onDeleteClick()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$showDeleteDialog(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public onPinClick()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +010h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->isPinned()Ljava/lang/Boolean;
    move-result-object v0
    const/4 v3, 1
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +013h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->unpinConversation()V
    goto +11h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->pinConversation()V
    return-void 
.end method

.method public onExtractClick()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +004h
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationTitle()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +004h
    const-string v0, "conversation"
    sget-object v3, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->INSTANCE Lcom/bytedance/trae/conversation/extract/ExtractHelper;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v4, Landroid/app/Activity;
    invoke-virtual v3, v4, v1, v0, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->start(Landroid/app/Activity; Ljava/lang/String; Ljava/lang/String;)V
    return-void
.end method

.method public onRenameClick()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$showRenameDialog(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method
