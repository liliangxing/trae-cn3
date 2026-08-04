# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
.field public final synthetic f$2:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda4;->f$2 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iget v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda4;->f$2 I
    check-cast v4, Landroidx/compose/runtime/Composer;
    check-cast v5, Ljava/lang/Integer;
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-static v0, v1, v2, v4, v5, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$7UQt-oRMLrKSDwhyAJ5mn7uaCJ0(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
