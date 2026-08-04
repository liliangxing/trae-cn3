# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda11;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnTouchListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda11;->f$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    return-void 
.end method

.method public final onTouch(android.view.View  android.view.MotionEvent)boolean
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda11;->f$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->$r8$lambda$_ksXU-WrOiADwuFxr2BfwFQX_I4(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v2
    return v2
.end method
