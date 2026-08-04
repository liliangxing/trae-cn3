# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/network/NetworkDependImpl;
.super Ljava/lang/Object;
.source "NetworkDependImpl.kt"

.implements Lcom/bytedance/trae/im/network/INetworkDepend;

.field public static final Companion:Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;
.field private static final HUB_REASON_IMSDK:Ljava/lang/String;
.field private static final PUSH_REASON:Ljava/lang/String;
.field private static final PUSH_REASON_USER_CHANGED:Ljava/lang/String;
.field private static bridge instance:Lcom/bytedance/trae/im/network/NetworkDependImpl;
.field private currentPushUserId:Ljava/lang/Long;
.field private currentServiceId:Ljava/lang/Integer;
.field private hubNet:Lcom/bytedance/trae/network/HubNetConnection;
.field private pushFrontier:Lcom/bytedance/trae/network/FrontierConnection;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;->Companion Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;->updateHubNet(Ljava/lang/Integer;)V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getInstance$cp()com.bytedance.trae.im.network.NetworkDependImpl
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;->instance Lcom/bytedance/trae/im/network/NetworkDependImpl;
    return-object v0
.end method

.method public static final synthetic access$setInstance$cp(com.bytedance.trae.im.network.NetworkDependImpl)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;->instance Lcom/bytedance/trae/im/network/NetworkDependImpl;
    return-void 
.end method

.method private final updateHubNet(java.lang.Integer)void
    .registers 3
    # ins_size=2
    if-eqz v2, +018h
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentServiceId Ljava/lang/Integer;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +eh
    iput-object v2, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentServiceId Ljava/lang/Integer;
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection;
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    invoke-direct v0, v2, Lcom/bytedance/trae/network/HubNetConnection;-><init>(I)V
    iput-object v0, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;->hubNet Lcom/bytedance/trae/network/HubNetConnection;
    return-void 
.end method

.method public checkAlive()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;->hubNet Lcom/bytedance/trae/network/HubNetConnection;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/network/HubNetConnection;->checkAliveAndReconnect()V
    return-void 
.end method

.method public connect(com.bytedance.trae.network.HubConnectionListener)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->hubNet Lcom/bytedance/trae/network/HubNetConnection;
    if-eqz v0, +007h
    const-string v1, "imsdk"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->connect(Ljava/lang/String; Lcom/bytedance/trae/network/HubConnectionListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v3, +007h
    const-string v0, "push"
    invoke-virtual v3, v0, Lcom/bytedance/trae/network/FrontierConnection;->connect(Ljava/lang/String;)V
    return-void 
.end method

.method public disconnect()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->hubNet Lcom/bytedance/trae/network/HubNetConnection;
    if-eqz v0, +007h
    const-string v1, "imsdk"
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->disconnect(Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v0, +007h
    const-string v1, "push"
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/FrontierConnection;->disconnect(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->isDisabled()Z
    move-result v0
    if-nez v0, +018h
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    iput-object v0, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentPushUserId Ljava/lang/Long;
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentServiceId Ljava/lang/Integer;
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, 1
    invoke-direct v0, v1, Lcom/bytedance/trae/network/HubNetConnection;-><init>(I)V
    iput-object v0, v2, Lcom/bytedance/trae/im/network/NetworkDependImpl;->hubNet Lcom/bytedance/trae/network/HubNetConnection;
    return-void 
.end method

.method public getHubNetConnection()com.bytedance.trae.network.HubNetConnection
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;->hubNet Lcom/bytedance/trae/network/HubNetConnection;
    return-object v0
.end method

.method public getPushFrontierConnection()com.bytedance.trae.network.FrontierConnection
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    return-object v0
.end method

.method public initConfig(com.bytedance.trae.network.FrontierConfig  java.util.Map  boolean  com.bytedance.trae.network.HubClientMetadata)void
    .registers 9
    # ins_size=5
    const-string v0, "config"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraHeaders"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clientMetadata"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->hubNet Lcom/bytedance/trae/network/HubNetConnection;
    if-eqz v0, +005h
    invoke-virtual v0, v5, v6, v7, v8, Lcom/bytedance/trae/network/HubNetConnection;->setup(Lcom/bytedance/trae/network/FrontierConfig; Ljava/util/Map; Z Lcom/bytedance/trae/network/HubClientMetadata;)V
    const/4 v0, 0
    if-eqz v7, +011h
    iget-object v5, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v5, +008h
    const-string/jumbo v6, tob_no_push
    invoke-virtual v5, v6, Lcom/bytedance/trae/network/FrontierConnection;->disconnect(Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    iput-object v0, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentPushUserId Ljava/lang/Long;
    return-void 
    const-string/jumbo v7, user_id
    invoke-interface v6, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +007h
    invoke-static v7, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v7
    goto +2h
    move-object v7, v0
    sget-object v1, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-virtual v1, Lcom/bytedance/trae/network/FrontierSwitchConfig;->isDisabled()Z
    move-result v1
    if-nez v1, +017h
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentPushUserId Ljava/lang/Long;
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00fh
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v1, +007h
    const-string v2, "push_user_changed"
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/FrontierConnection;->disconnect(Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    iput-object v0, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentPushUserId Ljava/lang/Long;
    if-eqz v7, +049h
    invoke-virtual v7, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +03fh
    iget-object v0, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    const/4 v1, 1
    if-nez v0, +014h
    iget-object v0, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentServiceId Ljava/lang/Integer;
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    move v0, v1
    add-int/2addr v0, v1
    new-instance v2, Lcom/bytedance/trae/network/FrontierConnection;
    invoke-direct v2, v0, v7, Lcom/bytedance/trae/network/FrontierConnection;-><init>(I Ljava/lang/Long;)V
    iput-object v2, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    iput-object v7, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->currentPushUserId Ljava/lang/Long;
    invoke-static v6, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v7, Lcom/bytedance/trae/network/DebugSettings;->getPpeEnv()Ljava/lang/String;
    move-result-object v7
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +008h
    const-string/jumbo v0, x-tt-env
    invoke-interface v6, v0, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v7, v4, Lcom/bytedance/trae/im/network/NetworkDependImpl;->pushFrontier Lcom/bytedance/trae/network/FrontierConnection;
    if-eqz v7, +005h
    invoke-virtual v7, v5, v6, v8, Lcom/bytedance/trae/network/FrontierConnection;->setup(Lcom/bytedance/trae/network/FrontierConfig; Ljava/util/Map; Lcom/bytedance/trae/network/HubClientMetadata;)V
    return-void 
.end method

.method public isNetworkAvailable()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-static v0, Lcom/bytedance/common/utility/NetworkUtils;->isNetworkAvailable(Landroid/content/Context;)Z
    move-result v0
    return v0
.end method
