# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;
    check-cast v2, Lcom/bytedance/trae/login/api/LoginDeviceListResult;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->$r8$lambda$tpbsihTLEjfbmYD7xVKKMXgMayI(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment; Lcom/bytedance/trae/login/api/LoginDeviceListResult;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
