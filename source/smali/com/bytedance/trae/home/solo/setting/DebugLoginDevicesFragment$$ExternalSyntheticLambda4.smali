# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/login/api/LoginDeviceListResult;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  com.bytedance.trae.login.api.LoginDeviceListResult)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/login/api/LoginDeviceListResult;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/login/api/LoginDeviceListResult;
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->$r8$lambda$0mTw3oqjyLtJHUXSBAsbcLBlMF0(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment; Lcom/bytedance/trae/login/api/LoginDeviceListResult;)V
    return-void 
.end method
