# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/NetQualityManager;
.super Ljava/lang/Object;
.source "NetQualityManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/NetQualityManager;
.field private static final NETWORK_STATUS_VALUES:[Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field private static final TAG:Ljava/lang/String;
.field private static currentNetworkStatus:Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
.field private static final mConnectionTypeLiveData:Landroidx/lifecycle/MutableLiveData;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/NetQualityManager;
    invoke-direct v0, Lcom/bytedance/trae/network/NetQualityManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager;->INSTANCE Lcom/bytedance/trae/network/NetQualityManager;
    const-string v0, "NetQualityManager"
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager;->TAG Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->NET_DEFAULT Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager;->currentNetworkStatus Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    invoke-static Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->values()[Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager;->NETWORK_STATUS_VALUES [Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager;->mConnectionTypeLiveData Landroidx/lifecycle/MutableLiveData;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final toNetworkStatus(int)com.bytedance.trae.network.NetQualityManager$NetworkStatus
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager;->NETWORK_STATUS_VALUES [Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    array-length v1, v0
    const/4 v2, 0
    move v3, v2
    if-ge v3, v1, +013h
    aget-object v4, v0, v3
    invoke-virtual v4, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->getValue()I
    move-result v5
    if-ne v5, v7, +004h
    const/4 v5, 1
    goto +2h
    move v5, v2
    if-eqz v5, +003h
    goto +5h
    add-int/lit8 v3, v3, 1
    goto -12h
    const/4 v4, 0
    if-nez v4, +004h
    sget-object v4, Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;->UNKNOWN Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    return-object v4
.end method

.method public final getCurrentNetworkStatus()com.bytedance.trae.network.NetQualityManager$NetworkStatus
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager;->currentNetworkStatus Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    return-object v0
.end method

.method public final provide(int)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-eqz v0, +016h
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager;->TAG Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Net work quality is : "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-direct v3, v4, Lcom/bytedance/trae/network/NetQualityManager;->toNetworkStatus(I)Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/NetQualityManager;->currentNetworkStatus Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager;->mConnectionTypeLiveData Landroidx/lifecycle/MutableLiveData;
    invoke-direct v3, v4, Lcom/bytedance/trae/network/NetQualityManager;->toNetworkStatus(I)Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "network_quality"
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public final register(androidx.lifecycle.Observer)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, observer
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager;->mConnectionTypeLiveData Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->observeForever(Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method public final unRegister(androidx.lifecycle.Observer)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, observer
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/NetQualityManager;->mConnectionTypeLiveData Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->removeObserver(Landroidx/lifecycle/Observer;)V
    return-void 
.end method
