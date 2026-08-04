# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/devices/DeviceItem;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.DeviceItem)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;->f$1 Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;->f$2 Lcom/bytedance/trae/conversation/devices/DeviceItem;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;->f$1 Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;->f$2 Lcom/bytedance/trae/conversation/devices/DeviceItem;
    check-cast v4, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->$r8$lambda$Utdc5Rab16c1cxmNftHxjuT5WBI(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
