# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment$setupClickListeners$19$1;
.super Ljava/lang/Object;
.source "InputFragment.kt"

.implements Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputFragment;


.method constructor <init>(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$setupClickListeners$19$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDirectorySelected(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 15
    # ins_size=2
    const-string v0, "node"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$setupClickListeners$19$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getCurrentDevice$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v1
    if-eqz v1, +036h
    iget-object v0, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$setupClickListeners$19$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    invoke-virtual v14, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getPath()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 503
    const/4 v12, 0
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getOnSelectedDeviceChanged()Lkotlin/jvm/functions/Function1;
    move-result-object v2
    if-eqz v2, +005h
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvFolderName Landroid/widget/TextView;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getPath()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->parseWorkspaceDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-virtual v1, v14, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
