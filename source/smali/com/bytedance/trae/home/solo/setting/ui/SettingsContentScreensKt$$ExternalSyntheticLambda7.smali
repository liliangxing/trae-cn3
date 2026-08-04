# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda7;->f$1 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda7;->f$1 Lkotlin/jvm/functions/Function1;
    check-cast v3, Landroidx/compose/runtime/DisposableEffectScope;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->$r8$lambda$IwA9GVzgQsFq-uFaXtTzQDJMmNU(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/DisposableEffectScope;)Landroidx/compose/runtime/DisposableEffectResult;
    move-result-object v3
    return-object v3
.end method
