# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;
.super Landroidx/activity/OnBackPressedCallback;
.source "BrainstormActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    const/4 v1, 1
    invoke-direct v0, v1, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V
    return-void 
.end method

.method public handleOnBackPressed()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getPhase()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    if-ne v0, v3, +035h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode()Z
    move-result v0
    if-eqz v0, +013h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->toggleSubtitleMode()V
    goto +14h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->showExitConfirmDialog()V
    goto +eh
    const/4 v0, 0
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;->setEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    invoke-virtual v0, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    return-void 
.end method
