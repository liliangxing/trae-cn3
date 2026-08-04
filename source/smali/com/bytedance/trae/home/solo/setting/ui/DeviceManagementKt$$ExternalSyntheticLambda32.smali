# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$3:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState  com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette  kotlin.jvm.functions.Function1  int)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$2 Lkotlin/jvm/functions/Function1;
    iput v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$3 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$2 Lkotlin/jvm/functions/Function1;
    iget v3, v6, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda32;->f$3 I
    move-object v4, v7
    check-cast v4, Landroidx/compose/runtime/Composer;
    check-cast v8, Ljava/lang/Integer;
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$1Hi13il37O7atSPDafaEjgfl-tI(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette; Lkotlin/jvm/functions/Function1; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
