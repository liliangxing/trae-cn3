# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;
.super Ljava/lang/Object;
.source "DeviceActivateBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance()com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;-><init>()V
    return-object v0
.end method

.method public final newInstance(com.bytedance.trae.conversation.devices.OfflineDeviceTarget)com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet
    .registers 6
    # ins_size=2
    const-string/jumbo v0, target
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_device_id"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "arg_device_name"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getDeviceName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v2
    const-string v3, "arg_product_type"
    invoke-virtual v1, v3, v2, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "arg_is_paired"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired()Z
    move-result v3
    invoke-virtual v1, v2, v3, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    const-string v2, "arg_enter_from"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v2, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
