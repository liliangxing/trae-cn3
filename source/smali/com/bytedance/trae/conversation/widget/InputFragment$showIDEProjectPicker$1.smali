# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;
.super Ljava/lang/Object;
.source "InputFragment.kt"

.implements Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;

.field final synthetic $device:Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
.field final synthetic $openSkillsAfterSelection:Z
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputFragment;


.method constructor <init>(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.devices.SelectedDeviceItem  boolean)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->$openSkillsAfterSelection Z
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onProjectSelected(com.bytedance.trae.conversation.network.ProjectItem)void
    .registers 15
    # ins_size=2
    const-string v0, "node"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ProjectItem;->getProjectId()Ljava/lang/String;
    move-result-object v7
    sget-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->INSTANCE Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v2, requireContext(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ProjectItem;->getFolderPath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ProjectItem;->getWorkspaceType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->getProjectName(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ProjectItem;->getFolderPath()Ljava/lang/String;
    move-result-object v5
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v6, 0
    const/4 v8, 0
    const/4 v10, 0
    const/16 v11, 343
    const/4 v12, 0
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v0
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getOnSelectedDeviceChanged()Lkotlin/jvm/functions/Function1;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvFolderName Landroid/widget/TextView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectName()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +005h
    check-cast v2, Ljava/lang/CharSequence;
    goto +eh
    iget-object v2, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/ProjectItem;->getFolderPath()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v2, v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->parseWorkspaceDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    move-object v2, v14
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-boolean v14, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->$openSkillsAfterSelection Z
    if-eqz v14, +018h
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 1
    const/4 v6, 0
    const/16 v7, 16
    const/4 v8, 0
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheet$default(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method
