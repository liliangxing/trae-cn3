# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;
.super Ljava/lang/Object;
.source "CodeDeviceSelectBottomSheet.kt"

.implements Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;

.field final synthetic $location:Lcom/bytedance/trae/conversation/devices/DeviceItem;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceItem)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->this$0 Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->$location Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDirectorySelected(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 16
    # ins_size=2
    const-string v0, "node"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackDeviceSelectPath(I)V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->this$0 Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getOnDeviceSelected()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +03fh
    new-instance v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->$location Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->$location Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v3
    iget-object v1, v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->$location Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getPath()Ljava/lang/String;
    move-result-object v5
    iget-object v15, v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->$location Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    iget-object v15, v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->this$0 Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    invoke-static v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    move-result-object v15
    if-nez v15, +008h
    const-string v15, "adapter"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getShowProductType()Z
    move-result v10
    const/16 v11, 224
    const/4 v12, 0
    move-object v1, v13
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v13, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;->this$0 Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->dismiss()V
    return-void 
    :try_start_0x5
.end method
