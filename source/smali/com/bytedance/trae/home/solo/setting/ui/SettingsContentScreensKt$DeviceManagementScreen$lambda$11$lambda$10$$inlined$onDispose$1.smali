# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$lambda$11$lambda$10$$inlined$onDispose$1;
.super Ljava/lang/Object;
.source "Effects.kt"

.implements Landroidx/compose/runtime/DisposableEffectResult;

.field final synthetic $onSwipeInteractionChanged$inlined:Lkotlin/jvm/functions/Function1;
.field final synthetic $viewModel$inlined:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;


.method public constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$lambda$11$lambda$10$$inlined$onDispose$1;->$viewModel$inlined Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$lambda$11$lambda$10$$inlined$onDispose$1;->$onSwipeInteractionChanged$inlined Lkotlin/jvm/functions/Function1;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public dispose()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$lambda$11$lambda$10$$inlined$onDispose$1;->$viewModel$inlined Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->stopPolling$impl_mainlandRelease()V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$lambda$11$lambda$10$$inlined$onDispose$1;->$onSwipeInteractionChanged$inlined Lkotlin/jvm/functions/Function1;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
