# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$2;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "DeviceFlowContainerBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function1;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 1
    const-class v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    const-string/jumbo v4, returnToDeviceSelectionAfterBinding
    const-string/jumbo v5, returnToDeviceSelectionAfterBinding(Lcom/bytedance/trae/conversation/devices/MobileDevice;)Z
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke(com.bytedance.trae.conversation.devices.MobileDevice)java.lang.Boolean
    .registers 3
    # ins_size=2
    const-string v0, "p0"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$2;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->access$returnToDeviceSelectionAfterBinding(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$2;->invoke(Lcom/bytedance/trae/conversation/devices/MobileDevice;)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method
