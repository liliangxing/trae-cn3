# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$7;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "DeviceManagementFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$7;->this$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V
    return-void 
.end method

.method public onScrollStateChanged(androidx.recyclerview.widget.RecyclerView  int)void
    .registers 4
    # ins_size=3
    const-string v0, "recyclerView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    if-ne v3, v2, +013h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$7;->this$0 Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    move-result-object v2
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->closeOpenItem()V
    return-void 
.end method
