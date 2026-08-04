# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    check-cast v3, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->$r8$lambda$kcwS1t8UtsN-shdr-2mMufWLLks(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
