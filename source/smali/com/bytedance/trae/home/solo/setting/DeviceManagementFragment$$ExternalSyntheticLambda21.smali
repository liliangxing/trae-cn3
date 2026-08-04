# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda21;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda21;->f$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda21;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda21;->f$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda21;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    check-cast v3, Ljava/lang/String;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->$r8$lambda$VTLSRD8VeCqhdS_Hr_RsjVbh3hc(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
