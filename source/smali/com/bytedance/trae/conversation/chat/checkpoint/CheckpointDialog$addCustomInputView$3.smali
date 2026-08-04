# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;
.super Ljava/lang/Object;
.source "CheckpointDialog.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic $creator:Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
.field final synthetic $isAskUserQuestion:Z
.field final synthetic $page:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;


.method constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  boolean)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$page Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$creator Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$isAskUserQuestion Z
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public beforeTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method

.method public onTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$page Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$clearSingleSelectionForCustomInputIfNeeded(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$page Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$updateCustomInputState(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$page Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$creator Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;->$isAskUserQuestion Z
    invoke-static v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$updateActionArea(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)V
    return-void 
.end method
