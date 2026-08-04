# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->$r8$lambda$oK8U0UTIxcL5F0XWXWso72_hn64(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository; Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    move-result-object v2
    return-object v2
.end method
