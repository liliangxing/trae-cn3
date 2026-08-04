# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/network/INetworkDepend;
.super Ljava/lang/Object;
.source "INetworkDepend.kt"

.field public static final Companion:Lcom/bytedance/trae/im/network/INetworkDepend$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->$$INSTANCE Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    sput-object v0, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    return-void 
.end method

.method public abstract checkAlive()void
    # abstract or native
.end method

.method public abstract connect(com.bytedance.trae.network.HubConnectionListener)void
    # abstract or native
.end method

.method public abstract disconnect()void
    # abstract or native
.end method

.method public abstract getHubNetConnection()com.bytedance.trae.network.HubNetConnection
    # abstract or native
.end method

.method public abstract getPushFrontierConnection()com.bytedance.trae.network.FrontierConnection
    # abstract or native
.end method

.method public abstract initConfig(com.bytedance.trae.network.FrontierConfig  java.util.Map  boolean  com.bytedance.trae.network.HubClientMetadata)void
    # abstract or native
.end method

.method public abstract isNetworkAvailable()boolean
    # abstract or native
.end method
