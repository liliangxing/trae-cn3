# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/NetworkMonitor;
.super Ljava/lang/Object;
.source "NetworkMonitor.kt"

.field private static final DEFAULT_CONNECTED:Z
.field public static final INSTANCE:Lcom/bytedance/trae/network/NetworkMonitor;
.field private static final _isConnected:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static connectivityManager:Landroid/net/ConnectivityManager;
.field private static bridge initialized:Z
.field private static final isConnected:Lkotlinx/coroutines/flow/StateFlow;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-direct v0, Lcom/bytedance/trae/network/NetworkMonitor;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->_isConnected Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->isConnected Lkotlinx/coroutines/flow/StateFlow;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$get_isConnected$p()kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->_isConnected Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method private final checkConnectivity(android.net.ConnectivityManager)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Landroid/net/ConnectivityManager;->getActiveNetwork()Landroid/net/Network;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v3, v0, Landroid/net/ConnectivityManager;->getNetworkCapabilities(Landroid/net/Network;)Landroid/net/NetworkCapabilities;
    move-result-object v3
    if-nez v3, +003h
    return v1
    const/16 v0, 12
    invoke-virtual v3, v0, Landroid/net/NetworkCapabilities;->hasCapability(I)Z
    move-result v3
    return v3
.end method

.method public final applyE2EConnectivityOverride(java.lang.Boolean)void
    .registers 3
    # ins_size=2
    if-eqz v2, +008h
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->_isConnected Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +14h
    sget-object v2, Lcom/bytedance/trae/network/NetworkMonitor;->connectivityManager Landroid/net/ConnectivityManager;
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->_isConnected Lkotlinx/coroutines/flow/MutableStateFlow;
    if-eqz v2, +007h
    invoke-direct v1, v2, Lcom/bytedance/trae/network/NetworkMonitor;->checkConnectivity(Landroid/net/ConnectivityManager;)Z
    move-result v2
    goto +2h
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->INSTANCE Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
    invoke-virtual v2, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->onNetworkChanged()V
    return-void 
.end method

.method public final init(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/network/NetworkMonitor;->initialized Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/network/NetworkMonitor;->initialized Z
    invoke-virtual v3, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v3
    const-string v0, "connectivity"
    invoke-virtual v3, v0, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v3
    instance-of v0, v3, Landroid/net/ConnectivityManager;
    if-eqz v0, +005h
    check-cast v3, Landroid/net/ConnectivityManager;
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-void 
    sput-object v3, Lcom/bytedance/trae/network/NetworkMonitor;->connectivityManager Landroid/net/ConnectivityManager;
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->_isConnected Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-direct v2, v3, Lcom/bytedance/trae/network/NetworkMonitor;->checkConnectivity(Landroid/net/ConnectivityManager;)Z
    move-result v1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/network/NetworkMonitor$init$callback$1;
    invoke-direct v0, Lcom/bytedance/trae/network/NetworkMonitor$init$callback$1;-><init>()V
    check-cast v0, Landroid/net/ConnectivityManager$NetworkCallback;
    invoke-virtual v3, v0, Landroid/net/ConnectivityManager;->registerDefaultNetworkCallback(Landroid/net/ConnectivityManager$NetworkCallback;)V
    return-void 
.end method

.method public final isConnected()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->isConnected Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final isNetworkAvailable()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->networkAvailableOverrideOrNull()Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->connectivityManager Landroid/net/ConnectivityManager;
    if-nez v0, +00fh
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->_isConnected Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
    invoke-direct v1, v0, Lcom/bytedance/trae/network/NetworkMonitor;->checkConnectivity(Landroid/net/ConnectivityManager;)Z
    move-result v0
    return v0
.end method
