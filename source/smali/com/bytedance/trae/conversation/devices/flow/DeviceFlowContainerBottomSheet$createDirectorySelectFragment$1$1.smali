# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;
.super Ljava/lang/Object;
.source "DeviceFlowContainerBottomSheet.kt"

.implements Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;

.field final synthetic $route:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDirectorySelected(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 16
    # ins_size=2
    const-string v0, "node"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackDeviceSelectPath(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    new-instance v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v3
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getPath()Ljava/lang/String;
    move-result-object v5
    iget-object v15, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    iget-object v15, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;->$route Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getShowProductType()Z
    move-result v10
    const/16 v11, 224
    const/4 v12, 0
    move-object v1, v13
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->notifyDeviceSelected(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    return-void 
    :try_start_0x5
.end method
