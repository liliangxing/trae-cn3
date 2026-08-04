# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$2:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementUiState  kotlin.jvm.functions.Function1  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function1;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda1;->f$2 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function1;
    iget v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda1;->f$2 I
    check-cast v4, Landroidx/compose/runtime/Composer;
    check-cast v5, Ljava/lang/Integer;
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-static v0, v1, v2, v4, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->$r8$lambda$OG_OfyJR_RvmmYLqQT7DnROZdhQ(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Lkotlin/jvm/functions/Function1; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
