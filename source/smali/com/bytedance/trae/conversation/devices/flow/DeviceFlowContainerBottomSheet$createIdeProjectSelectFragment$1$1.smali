# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;
.super Ljava/lang/Object;
.source "DeviceFlowContainerBottomSheet.kt"

.implements Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;

.field final synthetic $route:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
.field final synthetic $this_apply:Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect  com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$this_apply Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onProjectSelected(com.bytedance.trae.conversation.network.ProjectItem)void
    .registers 16
    # ins_size=2
    const-string v0, "node"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v4
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v5
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/ProjectItem;->getFolderPath()Ljava/lang/String;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->INSTANCE Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;
    iget-object v2, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$this_apply Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v8, requireContext(...)
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/ProjectItem;->getFolderPath()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/ProjectItem;->getWorkspaceType()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v1, v2, v8, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->getProjectName(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/ProjectItem;->getProjectId()Ljava/lang/String;
    move-result-object v8
    iget-object v15, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getShowProductType()Z
    move-result v11
    new-instance v15, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v9, 0
    const/16 v12, 64
    const/4 v13, 0
    move-object v2, v15
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v0, v15, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->notifyDeviceSelected(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    return-void 
.end method
