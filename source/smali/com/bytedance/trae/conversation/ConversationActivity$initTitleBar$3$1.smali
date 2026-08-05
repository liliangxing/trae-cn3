.class public final Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;
.super Ljava/lang/Object;
.source "ConversationActivity.kt"

# interfaces
.implements Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bytedance/trae/conversation/ConversationActivity;->initTitleBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016J\u0008\u0010\u0005\u001a\u00020\u0003H\u0016J\u0008\u0010\u0006\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"
    }
    d2 = {
        "com/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1",
        "Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;",
        "onArtifactClick",
        "",
        "onPinClick",
        "onRenameClick",
        "onDeleteClick",
        "conversation_mainlandRelease"
    }
    k = 0x1
    mv = {
        0x2,
        0x0,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


# direct methods
.method constructor <init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    .registers 2

    iput-object p1, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    .line 1277
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onArtifactClick()V
    .registers 11

    .line 1279
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-virtual {v0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    .line 1281
    :cond_b
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel:Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;

    move-result-object v0

    const-string/jumbo v1, "viewModel"

    const/4 v2, 0x0

    if-nez v0, :cond_1b

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_1b
    invoke-virtual {v0}, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    invoke-interface {v0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;

    .line 1282
    iget-object v3, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # invokes: Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static {v3}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getDetailFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;

    move-result-object v3

    if-eqz v3, :cond_32

    invoke-virtual {v3}, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getLastMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;

    move-result-object v3

    goto :goto_33

    :cond_32
    move-object v3, v2

    :goto_33
    if-eqz v0, :cond_77

    if-nez v3, :cond_38

    goto :goto_77

    .line 1287
    :cond_38
    sget-object v4, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->Companion:Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;

    .line 1288
    iget-object v5, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    check-cast v5, Landroid/content/Context;

    .line 1289
    invoke-virtual {v0}, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    if-nez v6, :cond_47

    move-object v6, v7

    .line 1290
    :cond_47
    invoke-virtual {v3}, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTurnId()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_4e

    move-object v3, v7

    .line 1291
    :cond_4e
    invoke-virtual {v0}, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_56

    move-object v8, v7

    goto :goto_57

    :cond_56
    move-object v8, v0

    .line 1292
    :goto_57
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel:Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;

    move-result-object v0

    if-nez v0, :cond_63

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_64

    :cond_63
    move-object v2, v0

    :goto_64
    invoke-virtual {v2}, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    invoke-interface {v0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-nez v0, :cond_72

    move-object v9, v7

    goto :goto_73

    :cond_72
    move-object v9, v0

    :goto_73
    move-object v7, v3

    .line 1287
    invoke-virtual/range {v4 .. v9}, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;->start(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :cond_77
    :goto_77
    return-void
.end method

.method public onDeleteClick()V
    .registers 2

    .line 1311
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-virtual {v0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    .line 1312
    :cond_b
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # invokes: Lcom/bytedance/trae/conversation/ConversationActivity;->showDeleteDialog()V
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$showDeleteDialog(Lcom/bytedance/trae/conversation/ConversationActivity;)V

    return-void
.end method

.method public onPinClick()V
    .registers 5

    .line 1297
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-virtual {v0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    .line 1298
    :cond_b
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel:Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;

    move-result-object v0

    const/4 v1, 0x0

    const-string/jumbo v2, "viewModel"

    if-nez v0, :cond_1b

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_1b
    invoke-virtual {v0}, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    invoke-interface {v0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;

    if-eqz v0, :cond_35

    invoke-virtual {v0}, Lcom/bytedance/trae/im/service/Conversation;->isPinned()Ljava/lang/Boolean;

    move-result-object v0

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    goto :goto_36

    :cond_35
    const/4 v0, 0x0

    :goto_36
    if-eqz v0, :cond_49

    .line 1299
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel:Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;

    move-result-object v0

    if-nez v0, :cond_44

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_45

    :cond_44
    move-object v1, v0

    :goto_45
    invoke-virtual {v1}, Lcom/bytedance/trae/conversation/ConversationViewModel;->unpinConversation()V

    goto :goto_59

    .line 1301
    :cond_49
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel:Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;

    move-result-object v0

    if-nez v0, :cond_55

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_56

    :cond_55
    move-object v1, v0

    :goto_56
    invoke-virtual {v1}, Lcom/bytedance/trae/conversation/ConversationViewModel;->pinConversation()V

    :goto_59
    return-void
.end method

.method public onRenameClick()V
    .registers 2

    .line 1306
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # getter for: Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getMenuPopupWindow$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-virtual {v0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    .line 1307
    :cond_b
    iget-object v0, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    # invokes: Lcom/bytedance/trae/conversation/ConversationActivity;->showRenameDialog()V
    invoke-static {v0}, Lcom/bytedance/trae/conversation/ConversationActivity;->access$showRenameDialog(Lcom/bytedance/trae/conversation/ConversationActivity;)V

    return-void
.end method

.method public onExtractClick()V
    .registers 5

    .line 1315
    sget-object v0, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->INSTANCE:Lcom/bytedance/trae/conversation/extract/ExtractHelper;

    .line 1316
    iget-object v1, p0, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;->this$0:Lcom/bytedance/trae/conversation/ConversationActivity;

    const-string v2, ""

    const-string v3, ""

    .line 1315
    invoke-virtual/range {v0 .. v3}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->start(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
