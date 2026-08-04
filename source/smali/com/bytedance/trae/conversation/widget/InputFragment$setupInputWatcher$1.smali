# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;
.super Ljava/lang/Object;
.source "InputFragment.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputFragment;


.method constructor <init>(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 8
    # ins_size=2
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v7, +011h
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    move v7, v1
    goto +2h
    move v7, v0
    if-ne v7, v1, +004h
    move v7, v1
    goto +2h
    move v7, v0
    iget-object v2, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->hasInputTag()Z
    move-result v2
    if-nez v7, +00fh
    iget-object v3, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$hasUploadedAttachments(Lcom/bytedance/trae/conversation/widget/InputFragment;)Z
    move-result v3
    if-nez v3, +007h
    if-eqz v2, +003h
    goto +3h
    move v3, v0
    goto +2h
    move v3, v1
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v4, v3, Landroid/widget/ImageView;->setEnabled(Z)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v4, v3, Landroid/widget/ImageView;->setClickable(Z)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    invoke-virtual v4, v1, Landroid/widget/ImageView;->setEnabled(Z)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    invoke-virtual v4, v1, Landroid/widget/ImageView;->setClickable(Z)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    const/high16 v5, 1065353216
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setAlpha(F)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getHoldToTalkState$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    if-ne v4, v5, +013h
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    if-nez v7, +004h
    if-eqz v2, +004h
    const/16 v0, 8
    invoke-virtual v4, v0, Landroid/widget/ImageView;->setVisibility(I)V
    if-nez v7, +004h
    if-eqz v2, +018h
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getHoldToTalkState$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    move-result-object v7
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->HOLD Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    if-ne v7, v0, +00eh
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-static v7, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$setHoldToTalkState$p(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$updateHoldToTalkUI(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getCurrentInputState()Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    move-result-object v7
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->ordinal()I
    move-result v7
    aget v7, v0, v7
    if-eq v7, v1, +01fh
    const/4 v0, 2
    if-eq v7, v0, +012h
    const/4 v0, 3
    if-eq v7, v0, +022h
    const/4 v0, 4
    if-eq v7, v0, +01fh
    const/4 v0, 5
    if-ne v7, v0, +003h
    goto +1ah
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    if-nez v3, +013h
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v7, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +ah
    if-eqz v3, +009h
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v7, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
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
    return-void 
.end method
