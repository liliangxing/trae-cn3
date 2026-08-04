# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/NetworkMonitor$init$callback$1;
.super Landroid/net/ConnectivityManager$NetworkCallback;
.source "NetworkMonitor.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroid/net/ConnectivityManager$NetworkCallback;-><init>()V
    return-void 
.end method

.method public onAvailable(android.net.Network)void
    .registers 3
    # ins_size=2
    const-string v0, "network"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->networkAvailableOverrideOrNull()Ljava/lang/Boolean;
    move-result-object v2
    if-eqz v2, +003h
    return-void 
    invoke-static Lcom/bytedance/trae/network/NetworkMonitor;->access$get_isConnected$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v2, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->INSTANCE Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
    invoke-virtual v2, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->onNetworkChanged()V
    return-void 
.end method

.method public onLost(android.net.Network)void
    .registers 3
    # ins_size=2
    const-string v0, "network"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->networkAvailableOverrideOrNull()Ljava/lang/Boolean;
    move-result-object v2
    if-eqz v2, +003h
    return-void 
    invoke-static Lcom/bytedance/trae/network/NetworkMonitor;->access$get_isConnected$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v2, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->INSTANCE Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
    invoke-virtual v2, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->onNetworkChanged()V
    return-void 
.end method

.method public onUnavailable()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->networkAvailableOverrideOrNull()Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +003h
    return-void 
    invoke-static Lcom/bytedance/trae/network/NetworkMonitor;->access$get_isConnected$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method
