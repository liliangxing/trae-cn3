# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    check-cast v2, Ljava/util/List;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->$r8$lambda$NlB2RZBebq63IR4l5V-CT4Ddk2I(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
