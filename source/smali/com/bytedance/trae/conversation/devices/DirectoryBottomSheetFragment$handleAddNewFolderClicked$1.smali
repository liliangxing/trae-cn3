# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$handleAddNewFolderClicked$1;
.super Ljava/lang/Object;
.source "DirectoryBottomSheetFragment.kt"

.implements Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;


.method constructor <init>(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$handleAddNewFolderClicked$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDirectorySelected(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 3
    # ins_size=2
    const-string v0, "node"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$handleAddNewFolderClicked$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getListener$p(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;->onDirectorySelected(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$handleAddNewFolderClicked$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    check-cast v2, Landroidx/fragment/app/Fragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v2
    if-nez v2, +007h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$handleAddNewFolderClicked$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->dismiss()V
    return-void 
.end method
