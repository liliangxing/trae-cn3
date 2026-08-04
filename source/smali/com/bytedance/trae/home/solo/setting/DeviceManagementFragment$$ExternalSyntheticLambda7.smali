# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function4;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=5
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    check-cast v3, Landroid/view/View;
    check-cast v4, Ljava/lang/Float;
    invoke-virtual v4, Ljava/lang/Float;->floatValue()F
    move-result v4
    check-cast v5, Ljava/lang/Float;
    invoke-virtual v5, Ljava/lang/Float;->floatValue()F
    move-result v5
    invoke-static v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->$r8$lambda$pE9lzm8ztXuEOCVJ78c1A32vgeI(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Landroid/view/View; F F)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
