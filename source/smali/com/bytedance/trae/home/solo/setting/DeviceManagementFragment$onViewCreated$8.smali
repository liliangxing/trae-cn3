# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;
.super Landroidx/activity/OnBackPressedCallback;
.source "DeviceManagementFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    const/4 v1, 1
    invoke-direct v0, v1, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V
    return-void 
.end method

.method public handleOnBackPressed()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    move-result-object v0
    if-eqz v0, +028h
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    move-result-object v0
    const/4 v1, 0
    const-string v2, "adapter"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->hasOpenItem()Z
    move-result v0
    if-eqz v0, +013h
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->closeOpenItem()V
    goto +12h
    const/4 v0, 0
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    invoke-virtual v0, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    return-void 
.end method
