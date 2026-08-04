# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;
.super Ljava/lang/Object;
.source "SettingsContentScreens.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic $latestCopySuccessMessage$delegate:Landroidx/compose/runtime/State;
.field final synthetic $onRefreshDeviceCache:Lkotlin/jvm/functions/Function0;


.method constructor <init>(kotlin.jvm.functions.Function0  androidx.compose.runtime.State)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;->$onRefreshDeviceCache Lkotlin/jvm/functions/Function0;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;->$latestCopySuccessMessage$delegate Landroidx/compose/runtime/State;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementEffect  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    instance-of v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$CopyToClipboard;
    if-eqz v2, +00eh
    sget-object v2, Lcom/bytedance/trae/kmp/host/KmpHostActions;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostActions;
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$CopyToClipboard;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$CopyToClipboard;->getText()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/kmp/host/KmpHostActions;->copyToClipboard(Ljava/lang/String;)V
    goto +22h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00eh
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpHostActions;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostActions;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;->$latestCopySuccessMessage$delegate Landroidx/compose/runtime/State;
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->access$DeviceManagementScreen$lambda$7(Landroidx/compose/runtime/State;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/host/KmpHostActions;->showToast(Ljava/lang/String;)V
    goto +eh
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$RefreshDeviceCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$RefreshDeviceCache;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ah
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;->$onRefreshDeviceCache Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;->emit(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
