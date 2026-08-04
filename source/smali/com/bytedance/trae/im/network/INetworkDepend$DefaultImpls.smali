# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/network/INetworkDepend$DefaultImpls;
.super Ljava/lang/Object;
.source "INetworkDepend.kt"


.method public static synthetic connect$default(com.bytedance.trae.im.network.INetworkDepend  com.bytedance.trae.network.HubConnectionListener  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    if-nez v3, +00bh
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-interface v0, v1, Lcom/bytedance/trae/im/network/INetworkDepend;->connect(Lcom/bytedance/trae/network/HubConnectionListener;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: connect"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic initConfig$default(com.bytedance.trae.im.network.INetworkDepend  com.bytedance.trae.network.FrontierConfig  java.util.Map  boolean  com.bytedance.trae.network.HubClientMetadata  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    if-nez v6, +01dh
    and-int/lit8 v6, v5, 2
    if-eqz v6, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +008h
    sget-object v4, Lcom/bytedance/trae/network/HubClientMetadata;->Companion Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->fromSystem()Lcom/bytedance/trae/network/HubClientMetadata;
    move-result-object v4
    invoke-interface v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/network/INetworkDepend;->initConfig(Lcom/bytedance/trae/network/FrontierConfig; Ljava/util/Map; Z Lcom/bytedance/trae/network/HubClientMetadata;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: initConfig"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
